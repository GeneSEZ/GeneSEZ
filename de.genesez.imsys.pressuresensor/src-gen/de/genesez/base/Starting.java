package de.genesez.base;


/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184755478944_579173_1194) ENABLED START */
/* TODO put your imports here */
import java.lang.String;

import de.genesez.base.net.ConfigFTPFileLoader;
import de.genesez.base.sensor.PressureSensor;
import de.genesez.base.sensor.PressureSensorController;
import de.genesez.base.sensor.PressureWatcher;
import de.genesez.imsys.net.ISMTPMailer;
import de.genesez.imsys.net.SMTPMailer;
import de.genesez.imsys.net.TcpIpSocket;
import de.genesez.imsys.sensor.MeasureAdapter;
import de.genesez.imsys.sensor.MeasureEvent;
import de.genesez.imsys.system.Led;
import de.genesez.imsys.system.Mailbox;
import de.genesez.imsys.util.DateFormatter;

import se.imsys.system.PortIO;

/* PROTECTED REGION END */
/**
 * Starts the application.
 * @author nicher
 */
public class Starting {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated attribute derived method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     */
    public static void main(String[] args) {

        /* PROTECTED REGION ID(java.moperation.implementation.staticmain.code._12_5_8a7027a_1184755478944_579173_1194) ENABLED START */
        /* TODO put your own implementation code here */
        if (args.length < 1) {
            System.out.println("No mode specificed (LIVE or DEMO)");
            return;
        }

        // initial the ftp reloader, witch download the config file
        final ConfigFTPFileLoader confFileLoader =
            new ConfigFTPFileLoader(ConfigParameter.getFTP_SERVER(),
                ConfigParameter.getFTP_PORT(),
                ConfigParameter.getFTP_USERNAME(),
                ConfigParameter.getFTP_PASSWORT());

        // create a i2c pressure sensor
        final PressureSensor ps = new PressureSensor(0x78, 1, 0);
        ps.setAutoMeasureCycleTime(ConfigParameter.getPS_CYCLETIME());

        // create a presure sensor controller and add the i2c pressure sensor
        final PressureSensorController psc =
            new PressureSensorController(ps, ConfigParameter.getPS_MIN(),
                ConfigParameter.getPS_MAX());

        // create socket and smtp mailer for the pressure watcher
        final Mailbox mb = new Mailbox();
        final TcpIpSocket socket =
            new TcpIpSocket(ConfigParameter.getSO_SERVER(),
                ConfigParameter.getSO_PORT());
        final ISMTPMailer mailer =
            new SMTPMailer(ConfigParameter.getSMTP_DOMAIN(),
                ConfigParameter.getSMTP_SERVER(),
                ConfigParameter.getSMTP_PORT(),
                ConfigParameter.getSMTP_USERNAME(),
                ConfigParameter.getSMTP_PASSWORD());

        final PressureWatcher pw = new PressureWatcher(mb, socket, mailer);

        // crate a LED (IMSYS D100 LED)
        final Led led = new Led(PortIO.PORT_B, 4, 100, 5);

        // decition if live or demo mode is selected
        if (args[0].equals("LIVE")) {
            // This mode is a LIVE MODE and shows the 
            // socket communication between the microsystem and
            // a pc. If the microsystem can't connect to the pc
            // the measure values will be send by mail.
            System.out.println("LIVE MODE ENABLED");

            psc.insertInMeasureListener(new MeasureAdapter() {
                    public void measureValue(MeasureEvent e) {
                        pw.addPressureValue(e);
                    }
                });

            //confFileLoader.autoDownload();
        } else {
            // This mode is a DEMO MODE and shows if the 
            // pressure sensor work right. It is not the
            // best way to switch the LED off when the
            // pressure is to low, because the LED is also
            // off when the pressure is normal. SORRY
            System.out.println("DEMO MODE ENABLED");

            // if the pressure is to high then the D100 LED is on
            psc.insertInMeasureListener(new MeasureAdapter() {
                    public void measureValueToHigh(MeasureEvent e) {
                        System.out.println("Notify ToHigh(" +
                            DateFormatter.getUTCFormat(e.getTimeStamp()) +
                            "): " + e.getMeasureValue());

                        led.on();
                    }
                });

            // if the pressure is normal then the D100 LED flash
            psc.insertInMeasureListener(new MeasureAdapter() {
                    public void measureValueNormal(MeasureEvent e) {
                        System.out.println("Notify Normal(" +
                            DateFormatter.getUTCFormat(e.getTimeStamp()) +
                            "): " + e.getMeasureValue());

                        led.flash();
                    }
                });

            // if the pressure is to low then the D100 LED is off
            psc.insertInMeasureListener(new MeasureAdapter() {
                    public void measureValueToLow(MeasureEvent e) {
                        System.out.println("Notify ToLow(" +
                            DateFormatter.getUTCFormat(e.getTimeStamp()) +
                            "): " + e.getMeasureValue());

                        led.off();
                    }
                });
        }

        // starts the pressure sensor to measure
        ps.autoMeasure();

        // starts the pressure watcher to watch the pressure
        pw.autoSending();

        // the main application sleeps 180 seconds
        // and after the sleep the automeasure will
        // be stopped.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        } finally {
            ps.setAutoMeasureStop(true);
            pw.setAutoSendingStop(true);
            confFileLoader.setAutoDownLoadStop(true);
        }

        System.out.println("System terminated normal.");

        /* PROTECTED REGION END */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184755478944_579173_1194) ENABLED START */
    /* TODO put your own implementation code here */

    /* PROTECTED REGION END */
}
