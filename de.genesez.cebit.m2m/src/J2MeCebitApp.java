

//get the AVIDirector specific classes
import com.avidwireless.avidirector.AVIDirectorMain;
import com.avidwireless.avidirector.M2Mlet;
import com.avidwireless.avidirector.M2M_IO;
import com.avidwireless.avidirector.iodevice.*;
import com.avidwireless.avidirector.IllegalHardwareAddressException;
import com.avidwireless.avidirector.InvalidHardwareOperationException;
import com.avidwireless.avidirector.AvidUtil;
import com.avidwireless.avidirector.Logger;
import com.avidwireless.avidirector.WatchDogTimer;
import com.avidwireless.avidirector.WatchDogMonitoredClass;
import com.avidwireless.avidirector.ThreadStatus; // the M2M-XML command types
import com.sensorlogic.messages.M2MXML_Messages;
import com.sensorlogic.messages.TelemetryMessage;
import com.sensorlogic.messages.PerceptRequest;
import com.sensorlogic.messages.Response; // standard Java classes
import javax.comm.SerialPort;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.UnsupportedCommOperationException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;

public class J2MeCebitApp extends M2Mlet implements Runnable, WatchDogMonitoredClass {

	/* Our source safe revision numbers */
	final static String REVISION = "$Revision: 6 $"; // for tracking
														// revisions
	/*
	 * $NoKeywords: $
	 */

	// ############ STATIC DATA AND CONSTANTS ##################
	/** Configuration file value to enable or disable the demo mode */
	final static String CONFIG_FILE_DEMO_MODE = "DEMO_ENABLED";

	/** Configuration file value for how often to update the portal */
	final static String CONFIG_FILE_PORTAL_UPDATE = "DEMO_UPDATE_INTERVAL";

	/** The Watchdog timer timeout in milliseconds */
	final static int WATCH_DOG_TIMEOUT = 120000;

	// ################# INSTANCE DATA #########################

	/** Array of our M2M sensors we are using to poll */
	M2M_IODevice[] sensors;

	/** The output devices */
	M2M_IODevice lamp, greenLed, redLed;

	/** Set true if this is enabled */
	volatile boolean demoM2mletEnabled;

	/** Set true of the old demo board */
	private boolean oldDemoBoard;

	/** The polling interval which we update the portal with a new reading */
	long portalUpdateInterval;

	/** Variables to manage a background thread to perform the readings */
	private Thread thread;
	private volatile boolean threadRunning;

	/** Last time this Thread ran */
	private volatile long lastTimeRan;

	/** Watchdog Timer used to monitor this thread running */
	private WatchDogTimer watchDogTimer;

	// ################# CONSTRUCTORS #########################

	/**
	 * M2Mlets require a null constructor
	 */
	public J2MeCebitApp() {
		// null constructor
	}

	// ################ INSTANCE METHODS ########################

	/**
	 * Starts the M2Mlet for the Simulator board. This creates any initial
	 * devices and sets them to defined states.
	 * 
	 * @param adApp
	 *            Inistance of the AVIDirectorMain application
	 */
	public final boolean start(AVIDirectorMain adApp) {
		final String NAME = "Demo_M2Mlet.start";
		started = false;
		this.app = adApp;
		lastTimeRan = 0;

		try {
			// boolean find out if we are in debug mode
			boolean debugMode = Logger.isDebug();

			// test if this is enabled or not, and if disable don't bother
			// initializing
			String configDemoM2mletEnabled = app.getConfigurationItem(propertyKeyName + '.' + CONFIG_FILE_DEMO_MODE);
			if (configDemoM2mletEnabled != null) {
				demoM2mletEnabled = AvidUtil.parseBoolean(configDemoM2mletEnabled);
			} else {
				// if no entry then assume it is enabled
				demoM2mletEnabled = true;
			}

			// get the polling interval, default to 0 minutes
			portalUpdateInterval = app.getConfigurationItem(propertyKeyName + '.' + CONFIG_FILE_PORTAL_UPDATE, 0l);

			// if enabled then continue the starting
			if (demoM2mletEnabled) {
				/** Populate our M2M_IODevice array with the sensors we have */
				sensors = new M2M_IODevice[3];

				// sensors[0] is TTL1 is analog input with a potentometer
				sensors[0] = app.getM2M_IODevice(M2M_IODevice.TTL1);
				if (sensors[0] != null) {
					if (debugMode)
						Logger.debugln(NAME, "Setting up " + sensors[0].getDeviceAddress() + " as analog input with +/- 30 trigger");
					sensors[0].setAnalogInput();
					sensors[0].setTriggerValueChange(30, 30); // trigger when
																// changes +/-
																// 30, no more
																// than once
																// every 10
																// seconds
					sensors[0].setMinTriggerInterval(10000);
				} else {
					Logger.log(NAME, "No TTL1 Device specified");
				}

				// TTL5 is round pushbutton
				sensors[1] = app.getM2M_IODevice(M2M_IODevice.TTL5);
				if (sensors[1] != null) {
					sensors[1].setDigitalInput();
					// if this is low, then new simulation board. If high, then
					// original board (the LED value was inverted on this one)
					int value = sensors[1].readPinDig();
					if (value == 1) {
						oldDemoBoard = true;
						if (debugMode)
							Logger.debugln(NAME, "Setting up " + sensors[1].getDeviceAddress()
									+ " for the round pushbutton trigger when 0 (pressed in) - old board");
						sensors[1].setTriggerValueGoesLow(true); // trigger
																	// when low
						sensors[1].setTriggerValueGoesHigh(false);
					} else { // new demo board
						if (debugMode)
							Logger.debugln(NAME, "Setting up " + sensors[1].getDeviceAddress() + " for the round pushbutton trigger when 1 (pressed in)");
						sensors[1].setTriggerValueGoesLow(false); // trigger
																	// when high
						sensors[1].setTriggerValueGoesHigh(true);
					}
				} else {
					Logger.log(NAME, "No TTL5 Device specified");
				}

				// TTL6 is the toggle switch, notify on both high and low
				sensors[2] = app.getM2M_IODevice(M2M_IODevice.TTL6);
				if (sensors[2] != null) {
					if (debugMode)
						Logger.debugln(NAME, "Setting up " + sensors[2].getDeviceAddress() + " for the toggle switch and trigger on either");
					sensors[2].setDigitalInput();
					sensors[2].setTriggerValueGoesLow(true); // trigger
																// either way
					sensors[2].setTriggerValueGoesHigh(true);
				} else {
					Logger.log(NAME, "No TTL6 Device specified");
				}

				// TTL2 is the light bulb
				lamp = app.getM2M_IODevice(M2M_IODevice.TTL2);
				if (lamp != null) {
					if (debugMode)
						Logger.debugln(NAME, "Setting up " + lamp.getDeviceAddress() + " as analog output for the lamp");
					lamp.setAnalogOutput();
				} else {
					Logger.log(NAME, "No TTL2 Device specified");
				}

				// TTL3 is the Green LED
				greenLed = app.getM2M_IODevice(M2M_IODevice.TTL3);
				if (greenLed != null) {
					if (debugMode)
						Logger.debugln(NAME, "Setting up " + greenLed.getDeviceAddress() + " for the Green LED");
					greenLed.setDigitalOutput();
				} else {
					Logger.log(NAME, "No TTL3 Device specified");
				}

				// TTL4 is the Red LED
				redLed = app.getM2M_IODevice(M2M_IODevice.TTL4);
				if (redLed != null) {
					if (debugMode)
						Logger.debugln(NAME, "Setting up " + redLed.getDeviceAddress() + " for the Red LED");
					redLed.setDigitalOutput();
				} else {
					Logger.log(NAME, "No TTL4 Device specified");
				}

				// start this thread running
				started = true;
				thread = new ThreadStatus(this) {
					/**
					 * Each thread can return a String with information about
					 * how the thread is running, such as the last time it ran
					 * or if it is running or completed running
					 * 
					 * @return Sting with the Thread status
					 * @see se.imsys.system.ThreadStatus
					 */
					public String getThreadStatus() {
						StringBuffer sb = new StringBuffer(80);
						sb.append("threadRunning=").append(threadRunning);
						if (sensors != null)
							sb.append(" Controlling ").append(sensors.length).append(" sensors.");
						if (lastTimeRan > 0)
							sb.append(" Last ran ").append((System.currentTimeMillis() - lastTimeRan)).append("ms ago ");
						return sb.toString();
					}

					/**
					 * Returns a long containing the system time the thread last
					 * ran. This is mainly for Threads that are waiting for the
					 * an event before they run or periodic threads
					 * 
					 * @return long with the System.currentTimeMillis the thread
					 *         last ran
					 * @see se.imsys.system.ThreadStatus
					 */
					public long getLastTimeThreadRan() {
						return lastTimeRan;
					}
				};

				// Now wait for a signal that it has started
				synchronized (this) {
					try {
						thread.start();
						this.wait(30000); // 30 seconds to get going
					} catch (InterruptedException e) {
						Logger.log(NAME, "InterruptedException starting Thread");
					}
				}
			} else {
				Logger.log(NAME, "Demo M2MLet is not enabled");
			}
		} // try
		catch (Exception e) {
			Logger.log(NAME, e);
		}
		return started;
	} // initialize

	/**
	 * This thread monitors the test box's switches and dials and if something
	 * has changed it displays a message on the display and sends a message to
	 * the M2MXML portal.
	 */
	public final void run() {
		final String NAME = "Demo_M2Mlet.run";
		boolean isDebug = Logger.isDebug(); // cache the debug value

		Thread.currentThread().setName("M2MApp.Demo_M2Mlet");
		// notify out start method that we are running
		threadRunning = true;
		synchronized (this) {
			this.notifyAll();
		}
		if (started) {
			if (isDebug)
				Logger.debugln(NAME, "Thread started");
			// lcd.displayMessage("Monitoring...");
			double value; // currently read value from a sensor
			double lightIntensity; // value of the light (0-62)
			StringBuffer perceptMessage; // Percept reading to Portal
			boolean retFlag; // return status of a command
			boolean triggerResponse; // set true if there is a change of
										// value
			double ttl1Value = -1, ttl3Value = -1, ttl4Value = -1;
			long portalUpdateCounter = 0; // timers looking for when to update
											// the portal
			boolean updatePortal;

			perceptMessage = new StringBuffer(256);

			// Monitor this running with a watchdog timer, and check in every 60
			// seconds (at least)
			watchDogTimer = app.getWatchDogTimer();
			watchDogTimer.registerWatchDogMonitoredItem(this, "Demo_M2Mlet", WATCH_DOG_TIMEOUT);
			int watchDogTimerCounter = 0; // used to track when to update

			while (threadRunning && demoM2mletEnabled) {
				isDebug = Logger.isDebug(); // update the debug value in case it
											// changed
				lastTimeRan = System.currentTimeMillis();

				// go through the sensors and send a new reading if it changed

				// see if we need to poll now
				if ((portalUpdateInterval > 0) && ((System.currentTimeMillis() - portalUpdateCounter) >= portalUpdateInterval)) {
					updatePortal = true;
					portalUpdateCounter = System.currentTimeMillis();
					if (isDebug)
						Logger.debugln(NAME, "Updating Portal");
					// get the RSSI
					watchDogTimer.resetWatchDogTimer(this); // pet the watch dog
															// - don't make her
															// byte!
					watchDogTimerCounter = 0;
				} else {
					updatePortal = false;
					// update the watchdog timer every 300 clicks or so
					if (watchDogTimerCounter++ > 300) {
						watchDogTimerCounter = 0;
						// if (ttl4Value != 1)
						watchDogTimer.resetWatchDogTimer(this); // pet the watch
																// dog - don't
																// make her
																// byte!
					}
				}

				for (int device = 0; device < sensors.length; device++) {
					if (sensors[device] != null) {
						// sensors are fast to poll, so do them all the time
						try {
							// read the value and set it
							if (sensors[device].isAnalogInput()) { // analog
																	// input
																	// sensor
								value = sensors[device].readPinAnalog();
							} else { // digital sensor
								value = sensors[device].readPinDig();
							}
							// update the value on the sensor and see if we
							// triggered anything
							triggerResponse = sensors[device].updateValue(value);

							// handle any special things for these devices
							switch (device) {
							case 0: { // Pot
								// change the Light intensity to 0 to 62 from 0
								// to 4096
								if ((value <= (ttl1Value - 10)) || (value >= (ttl1Value + 10))) {
									lightIntensity = (value / 66); // 0 to 62
									lamp.writePinAnalog(lightIntensity);
									ttl1Value = value;
								}
								break;
							}
							case 1: { // Round pushbotton, only signal when
										// pushed down
								if (value != ttl3Value) {
									// set the Green LED but invert the value
									if (oldDemoBoard) {
										greenLed.writePinDig((value == 0) ? 1 : 0); // old
																					// demo
																					// board
																					// needs
																					// inverting
									} else {
										greenLed.writePinDig(value);
									}
									ttl3Value = value;
								}
								break;
							}
							case 2: { // Switch pushbotton, signal either way
								if (value != ttl4Value) {
									redLed.writePinDig(value);
									ttl4Value = value;
								}
								break;
							}
							} // switch

							if (triggerResponse || updatePortal) {
								if (isDebug)
									Logger.debugln(NAME, sensors[device].getDeviceAddress() + " value = " + value + " triggered a percept message to portal");
								// send the correct percept for the device
								if (sensors[device].isAnalogInput())
									perceptMessage.append(M2MXML_Messages.createPerceptString(sensors[device].getDeviceAddress(), value,
											PerceptRequest.PERCEPT_TYPE_SIMPLE, null));
								else
									perceptMessage.append(M2MXML_Messages.createPerceptString(sensors[device].getDeviceAddress(), value,
											PerceptRequest.PERCEPT_TYPE_BIT, null));
							}
						} catch (InvalidHardwareOperationException ihoe) {
							Logger.log(NAME, sensors[device].getDeviceName() + " InvalidHardwareOperationException:" + ihoe.getMessage());
						} catch (IllegalHardwareAddressException ihae) {
							Logger.log(NAME, sensors[device].getDeviceName() + " IllegalHardwareAddressException:" + ihae.getMessage());
						} catch (NullPointerException npe) {
							Logger.log(NAME, sensors[device].getDeviceName() + " NullPointerException:" + npe.getMessage());
						} catch (Exception ex) {
							Logger.log(NAME, sensors[device].getDeviceName() + " Exception:" + ex.toString());
						}
					} else {
						// null sensor
						if (Logger.isDebugLevel2())
							Logger.debugln(NAME, "Device#" + device + " is null. Probably an invalid name");
					}
				} // sensor loop

				// send our sensor readings
				if (perceptMessage.length() > 0) {
					app.sendMessageToPortal(perceptMessage.toString());
					perceptMessage.setLength(0);
				}
				// update every 100 ms
				if (threadRunning)
					AvidUtil.waitHereMs(100); // update every 1/10 of a second
			} // while thread running
			thread = null; // release ourselves
			if (isDebug)
				Logger.debugln(NAME, "Exiting thread");
		} else {
			Logger.log(NAME, "Not started so cannot run thread. Exiting");
		}
	} // run

	/**
	 * When a SetConfiguration command is received, for each configuration item
	 * this method is called. Each M2MLet can override this method to handle
	 * processing the configiruation command changes.
	 * <p>
	 * We are looking for the M2MLET.DEMO_ENABLED item changing, and setting the
	 * demonstration parameter to this value
	 * 
	 * @param propertyName
	 *            The Configuration file property name
	 * @param oldValue
	 *            The old value of this item. This is null if there is no old
	 *            value
	 * @param newValue
	 *            The new value of this item.
	 * @param seqNum
	 *            The sequence number of this command
	 * @return boolean true if this was processed successfully, false if an
	 *         error occureed
	 */
	public boolean processSetConfigurationItem(String propertyName, String oldValue, String newValue, String seqNum) {
		final String NAME = "Demo_M2Mlet.processSetConfigurationItem";
		boolean returnStatus = false;
		// The M2MLet must override this to mean anything. The default is to
		// return true
		if (propertyName.equals(CONFIG_FILE_DEMO_MODE)) {
			demoM2mletEnabled = AvidUtil.parseBoolean(newValue);
			Logger.log(NAME, "DemoM2MletEnable = " + demoM2mletEnabled + " starting Demo mode");
			// start the Demo if we didn't when initialized
			if (demoM2mletEnabled && !started)
				start(app);
			returnStatus = true;
		} else {
			if (Logger.isDebug())
				Logger.debugln(NAME, "Unknown Property " + propertyName);
			// other parameter, return true for now
			returnStatus = true;
		}
		return returnStatus;
	} // processSetConfigurationItem

	/**
	 * Stops the currently executing Demo_M2Mlet. This will try to do any
	 * cleanup possible
	 * 
	 */
	public final void stop() {
		final String NAME = "Demo_M2Mlet.stop";
		if (app != null)
			Logger.log(NAME, "Stopping");
		threadRunning = false;
		sensors = null;
		lamp = null;
		greenLed = null;
		redLed = null;
		sensors = null;

		// stop the watchdog from staring at us
		if (watchDogTimer != null) {
			watchDogTimer.removeMonitoredItem(this);
			watchDogTimer = null;
		}

		thread = null; // release ourselves
		Logger.log(NAME, "Stopped");
	} // stop

	/**
	 * Returns the M2Mlet application name
	 * 
	 * @return String with the M2Mlet application name
	 */
	public String getAppName() {
		return "Demo board M2Mlet";
	}

	/**
	 * Returns a description of the M2Mlet for our user
	 * 
	 * @return String up to 64 characters with a description of the application
	 */
	public String getDescription() {
		return "M2Mlet for the Simulation board operation.";
	}

}
