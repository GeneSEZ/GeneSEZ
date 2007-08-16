package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184785728932_224001_502) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Date;

/* <!-- PROTECTED REGION END --> */
/**
 * An event which indicates that a measure action occurred in a measure sensor. The event contains a timestamp and the measure value.
 * @author nicher
 */
public class MeasureEvent {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * variable
     * @see {@link getMeasureValue}
     */
    private float measureValue;

    /**
     * variable
     * @see {@link getTimeStamp}
     */
    private Date timeStamp;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  measureValue
     */
    public MeasureEvent(float measureValue) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184785764716_332171_526) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        this.measureValue = measureValue;
        this.timeStamp = new Date();

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

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute measureValue
     * The measure value.
     */
    public float getMeasureValue() {
        return measureValue;
    }

    /**
     * accessor for attribute measureValue
     * @see {@link getMeasureValue}
     */
    public void setMeasureValue(float _measureValue) {
        measureValue = _measureValue;
    }

    /**
     * accessor for attribute timeStamp
     * The time stamp shows when the value was measured.
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * accessor for attribute timeStamp
     * @see {@link getTimeStamp}
     */
    public void setTimeStamp(Date _timeStamp) {
        timeStamp = _timeStamp;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184785728932_224001_502) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
