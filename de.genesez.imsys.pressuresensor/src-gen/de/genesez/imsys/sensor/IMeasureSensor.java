package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754662579_970824_880) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * The measure sensor interface contains all interesting methods of an measure sensor.
 * @author nicher
 */
public interface IMeasureSensor {

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
     * Starts the manual measure mode which measure only one time.
     */
    public abstract void manualMeasure();

    /**
     * Starts the auto measure mode.
     */
    public abstract void autoMeasure();

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueToHigh(float measureValue);

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueNormal(float measureValue);

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueToLow(float measureValue);

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754662579_970824_880) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
