package de.genesez.base.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184788436265_449095_937) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.Thread;

import java.util.Date;
import java.util.Random;

import com.dalsemi.onewire.utils.Address;
import com.dalsemi.system.I2CPort;
import com.dalsemi.system.IllegalAddressException;

import de.genesez.imsys.sensor.MeasureEvent;
import de.genesez.imsys.sensor.MeasureSensor;

/* <!-- PROTECTED REGION END --> */
/**
 * This class represents the pressure sensor form the whz in zwickau germany.
 * @author nicher
 */
public class PressureSensor extends MeasureSensor implements Runnable {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getIsAutoMeasureMode}
     */
    private boolean isAutoMeasureMode = false;

    /**
     * variable
     */
    private boolean autoMeasureStop = false;

    /**
     * variable
     */
    private int autoMeasureCycleTime = 10000;

    /**
     */
    private Thread runner;

    /**
     * variable for association to i2c
     * @see {@link getI2c}
     */
    private I2CPort i2c;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  address
     * @param  gradient
     * @param  offset
     */
    public PressureSensor(int address, float gradient, float offset) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188991660230_164612_1324) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        super(address, gradient, offset);

        // initial the i2c port
        i2c = new I2CPort();

        // The PCF8574 is capable of I2C clock frequency of 100kHz, so
        // set the I2C bus speed to 8 (will result in a 10.8µs clock
        // period on the I2C bus).
        i2c.setClockDelay(8);

        // Set the device address to use for subsequent read and write
        // operations. The low three bits should match the setting on
        // the hardware address pins of the device. 
        i2c.setAddress((byte) (0x20 | (address & 0x07)));

        /* <!-- PROTECTED REGION END --> */
    }

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
     * This method reads from the whz pressure sensor which is connected by the i2c bus system.
     */
    public void measure() {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184788568835_800356_1085) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        float measure;
        MeasureEvent me;
        
        /*
        // actual way to get a pressurevalue
        // by random
        measure = Math.abs(new Random(new Date().getTime()).nextInt()) % 100;
        // correct measurevalue
        measure = getGradient() * measure + getOffset();
        // create measureevent
        me = new MeasureEvent(getAddress(), measure);
        // send measurevalue to pressurecontroller
        getMeasureController().sendMeasureValue(me);
         */
        
        // right way to get a pressurevaule
        // by i2c-bus
        byte[] buf = new byte[1];
        try {
            // posible write command to get
            // the pressuevalue
            //buf[0] = 0x55;
            buf = new String("IR_200004").getBytes();
            // write command for pressurevalue
            i2c.write(buf, 0, buf.length);
            // read pressurevalue
            i2c.read(buf, 0, 1);
            System.out.println(buf);
            
            System.out.println("--" + buf[4]+ buf[5]+ buf[6]+ buf[7]);
            
            // get preadure value from substring 4-7
            // for example buf = 25253520,
            // pressurevalue = 3520
            //System.out.println("--" + new String(buf));
            measure = Float.parseFloat(new String(buf).substring(4, 7));
            // correct measurevalue
            measure = getGradient() * measure + getOffset();
            // create measureevent
            me = new MeasureEvent(getAddress(), measure);
            // send measurevalue to pressurecontroller
            getMeasureController().sendMeasureValue(me);
        } catch (IllegalAddressException e) {
        	System.out.println(e.toString());
        }
        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Starts the manual measure measure mode in a Thread.
     */
    public void manualMeasure() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184939798112_183751_634) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        isAutoMeasureMode = false;
        runner = new Thread(this);
        runner.start();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Starts the auto measure mode in a thread.
     */
    public void autoMeasure() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184939024358_452624_613) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        isAutoMeasureMode = true;
        runner = new Thread(this);
        runner.start();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     */
    public void run() {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.threadrun.code._12_5_8a7027a_1184788436265_449095_937) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        synchronized (this) {
            if (isAutoMeasureMode) {
                while (!autoMeasureStop) {
                    measure();

                    try {
                        Thread.sleep(autoMeasureCycleTime);
                    } catch (InterruptedException e) {
                    }
                }
            } else {
                measure();
            }
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute isAutoMeasureMode
     * Starts / stops the auto measure mode.
     */
    public boolean getIsAutoMeasureMode() {
        return isAutoMeasureMode;
    }

    /**
     * accessor for attribute isAutoMeasureMode
     * @see {@link getIsAutoMeasureMode}
     */
    public void setIsAutoMeasureMode(boolean _isAutoMeasureMode) {
        isAutoMeasureMode = _isAutoMeasureMode;
    }

    /**
     * accessor for attribute autoMeasureStop
     */
    public boolean getAutoMeasureStop() {
        return autoMeasureStop;
    }

    /**
     * accessor for attribute autoMeasureStop
     */
    public void setAutoMeasureStop(boolean _autoMeasureStop) {
        autoMeasureStop = _autoMeasureStop;
    }

    /**
     * accessor for attribute autoMeasureCycleTime
     */
    public int getAutoMeasureCycleTime() {
        return autoMeasureCycleTime;
    }

    /**
     * accessor for attribute autoMeasureCycleTime
     */
    public void setAutoMeasureCycleTime(int _autoMeasureCycleTime) {
        autoMeasureCycleTime = _autoMeasureCycleTime;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184788436265_449095_937) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
