package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754703767_466983_906) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * This abstrct class represents a measure sensor. This sensor can measure manual of in a specificated cycletime automatic.
 * @author nicher
 */
public abstract class MeasureSensor extends Sensor implements IMeasureSensor {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getMin}
     */
    private float min = 0;

    /**
     * variable
     * @see {@link getMax}
     */
    private float max = 0;

    /**
     * variable
     * @see {@link getAutoMeasureStop}
     */
    private boolean autoMeasureStop = false;

    /**
     * variable
     * @see {@link getAutoMeasureCycleTime}
     */
    private int autoMeasureCycleTime = 10000;

    /**
     * variable for association to measureController
     * @see {@link getMeasureController}
     */
    private IMeasureController measureController;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  address
     * @param  min
     * @param  max
     */
    public MeasureSensor(int address, float min, float max) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184786271876_234871_596) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        super(address);
        this.min = min;
        this.max = max;

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated attribute derived method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for association to measureController
     * Reference to the measure controller.
     */
    public IMeasureController getMeasureController() {
        return measureController;
    }

    /**
     * accessor for association to measureController
     * @see {@link getMeasureController}
     */
    public void insertInMeasureController(IMeasureController _in) {
        if (measureController == _in) {
            return;
        }
        measureController = _in;
    }

    /**
     * accessor for association to measureController
     * @see {@link getMeasureController}
     */
    public void removeFromMeasureController(IMeasureController _ex) {
        if (measureController != _ex) {
            return;
        }
        measureController = null;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Starts one measure.
     */
    public abstract void manualMeasure();

    /**
     * Starts the auto measure mode.
     */
    public abstract void autoMeasure();

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  measureValue
     * @return
     */
    public final boolean isMeasureValueToHigh(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184787485715_883554_760) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if (measureValue > max) {
            returnValue = true;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @param  measureValue
     * @return
     */
    public final boolean isMeasureValueNormal(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184787485715_137785_761) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if ((measureValue >= min) && (measureValue <= max)) {
            returnValue = true;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @param  measureValue
     * @return
     */
    public final boolean isMeasureValueToLow(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184787485716_66151_762) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if (measureValue < min) {
            returnValue = true;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute min
     * Minimum value of the green range.
     */
    public float getMin() {
        return min;
    }

    /**
     * accessor for attribute min
     * @see {@link getMin}
     */
    public void setMin(float _min) {
        min = _min;
    }

    /**
     * accessor for attribute max
     * Maximum value of the green range.
     */
    public float getMax() {
        return max;
    }

    /**
     * accessor for attribute max
     * @see {@link getMax}
     */
    public void setMax(float _max) {
        max = _max;
    }

    /**
     * accessor for attribute autoMeasureStop
     * Starts / stops the auto measure.
     */
    public boolean getAutoMeasureStop() {
        return autoMeasureStop;
    }

    /**
     * accessor for attribute autoMeasureStop
     * @see {@link getAutoMeasureStop}
     */
    public void setAutoMeasureStop(boolean _autoMeasureStop) {
        autoMeasureStop = _autoMeasureStop;
    }

    /**
     * accessor for attribute autoMeasureCycleTime
     * Time between two measure events.
     */
    public int getAutoMeasureCycleTime() {
        return autoMeasureCycleTime;
    }

    /**
     * accessor for attribute autoMeasureCycleTime
     * @see {@link getAutoMeasureCycleTime}
     */
    public void setAutoMeasureCycleTime(int _autoMeasureCycleTime) {
        autoMeasureCycleTime = _autoMeasureCycleTime;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754703767_466983_906) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
