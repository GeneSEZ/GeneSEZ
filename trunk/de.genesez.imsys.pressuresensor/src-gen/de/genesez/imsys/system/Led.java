package de.genesez.imsys.system;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184931277350_172600_683) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.Thread;

import se.imsys.system.PortIO;

/* <!-- PROTECTED REGION END --> */
/**
 * This class gives access to a led which is sored on the Cjip.
 * @author nicher
 */
public class Led implements Runnable {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getAddress}
     */
    private int address = 0;

    /**
     * variable
     * @see {@link getFlashTime}
     */
    private int flashTime = 200;

    /**
     * variable
     * @see {@link getFlashCycle}
     */
    private int flashCycle = 10;

    /**
     */
    private Thread runner;

    /**
     * variable for association to portIO
     * @see {@link getPortIO}
     */
    private PortIO portIO;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  port
     * @param  address
     */
    public Led(int port, int address) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184933993632_341296_1119) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        portIO = new PortIO(port);
        this.address = address;

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * @param  port
     * @param  address
     * @param  flashTime
     * @param  flashCycle
     */
    public Led(int port, int address, int flashTime, int flashCycle) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184934020007_670827_1123) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        this(port, address);
        this.flashTime = flashTime;
        this.flashCycle = flashCycle;

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
     * Turn the led on.
     */
    public void on() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184931388497_129978_723) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        portIO.setControlBit(address);
        portIO.setDataBit(address);

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Turn the led off.
     */
    public void off() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184931393653_435832_727) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        portIO.clearDataBit(address);
        portIO.clearControlBit(address);

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     * Turn the led on and off in the specificated flashtime and flashcycles.
     */
    public void flash() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184933624553_150896_1111) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        runner = new Thread(this);
        runner.start();

        /* <!-- PROTECTED REGION END --> */
    }

    /**
     */
    public void run() {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.threadrun.code._12_5_8a7027a_1184931277350_172600_683) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        synchronized (this) {
            for (int i = 0; i < flashCycle; i++) {
                on();

                try {
                    Thread.sleep(flashTime);
                } catch (InterruptedException e) {
                }

                off();

                try {
                    Thread.sleep(flashTime);
                } catch (InterruptedException e) {
                }
            }
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute address
     * The address of the led.
     */
    public int getAddress() {
        return address;
    }

    /**
     * accessor for attribute address
     * @see {@link getAddress}
     */
    public void setAddress(int _address) {
        address = _address;
    }

    /**
     * accessor for attribute flashTime
     * Time between on and off turning.
     */
    public int getFlashTime() {
        return flashTime;
    }

    /**
     * accessor for attribute flashTime
     * @see {@link getFlashTime}
     */
    public void setFlashTime(int _flashTime) {
        flashTime = _flashTime;
    }

    /**
     * accessor for attribute flashCycle
     * Number of cycles where the led is turned on and off.
     */
    public int getFlashCycle() {
        return flashCycle;
    }

    /**
     * accessor for attribute flashCycle
     * @see {@link getFlashCycle}
     */
    public void setFlashCycle(int _flashCycle) {
        flashCycle = _flashCycle;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184931277350_172600_683) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
