package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754863065_958703_1059) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Vector;

/* <!-- PROTECTED REGION END --> */
/**
 * The measure controller contains all methods from the measure interface.
 * @author nicher
 */
public abstract class MeasureController implements IMeasureController {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     */
    private float min = 30;

    /**
     * variable
     */
    private float max = 70;

    /**
     * variable for association to measureSensor
     */
    private IMeasureSensor measureSensor;

    /**
     * variable for association to measureListener
     */
    private java.util.Vector measureListener = new java.util.Vector();

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  measureSensor
     * @param  min
     * @param  max
     */
    public MeasureController(IMeasureSensor measureSensor, float min, float max) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184786332336_927305_604) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        this.measureSensor = measureSensor;
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
     * accessor for association to measureSensor
     */
    public IMeasureSensor getMeasureSensor() {
        return measureSensor;
    }

    /**
     * accessor for association to measureSensor
     */
    public void insertInMeasureSensor(IMeasureSensor _in) {
        if (measureSensor == _in) {
            return;
        }
        measureSensor = _in;
    }

    /**
     * accessor for association to measureSensor
     */
    public void removeFromMeasureSensor(IMeasureSensor _ex) {
        if (measureSensor != _ex) {
            return;
        }
        measureSensor = null;
    }

    /**
     * accessor for association to measureListener
     */
    public IMeasureListener getMeasureListener(int _index) {
        return (IMeasureListener) measureListener.elementAt(_index);
    }

    public int getMeasureListenerCount() {
        return measureListener.size();
    }

    /**
     * accessor for association to measureListener
     */
    public void insertInMeasureListener(IMeasureListener _in) {
        if (measureListener.contains(_in)) {
            return;
        }
        measureListener.addElement(_in);
    }

    /**
     * accessor for association to measureListener
     */
    public void removeFromMeasureListener(IMeasureListener _ex) {
        if (!measureListener.contains(_ex)) {
            return;
        }
        measureListener.removeElement(_ex);
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Method which receives an measure event and send this event to all measure listeners.
     * @param  e
     */
    public abstract void sendMeasureValue(MeasureEvent e);

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  measureValue
     * @return
     */
    public boolean isMeasureValueTooHigh(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188925038620_221622_1046) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if (measureValue > max) {
            returnValue = true;
        } else {
            returnValue = false;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @param  measureValue
     * @return
     */
    public boolean isMeasureValueNormal(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188925045347_172705_1051) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if ((measureValue >= min) && (measureValue <= max)) {
            returnValue = true;
        } else {
            returnValue = false;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * @param  measureValue
     * @return
     */
    public boolean isMeasureValueTooLow(float measureValue) {
        boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188925050723_332702_1056) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        if (measureValue < min) {
            returnValue = true;
        } else {
            returnValue = false;
        }

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute min
     */
    public float getMin() {
        return min;
    }

    /**
     * accessor for attribute min
     */
    public void setMin(float _min) {
        min = _min;
    }

    /**
     * accessor for attribute max
     */
    public float getMax() {
        return max;
    }

    /**
     * accessor for attribute max
     */
    public void setMax(float _max) {
        max = _max;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754863065_958703_1059) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
