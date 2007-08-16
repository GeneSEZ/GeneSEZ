package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754602110_680994_835) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * The listener interface receives interesting measure events on a measure sensor.
 * @author nicher
 */
public interface IMeasureListener {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable and constant declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Receives the measure event all the time.
     * @param  e
     */
    public abstract void measureValue(MeasureEvent e);

    /**
     * Receives the measure event if the measure value is in the green range.
     * @param  e
     */
    public abstract void measureValueNormal(MeasureEvent e);

    /**
     * Receives the measure value if the measure value is to high.
     * @param  e
     */
    public abstract void measureValueToHigh(MeasureEvent e);

    /**
     * Receives the measure value if the measure value is to low.
     * @param  e
     */
    public abstract void measureValueToLow(MeasureEvent e);

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754602110_680994_835) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
