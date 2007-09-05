package de.genesez.imsys.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754622251_213885_857) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * The measure controller interface contains all interesting methods of a measure controller.
 * @author nicher
 */
public interface IMeasureController {

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
     * Method which receives an measure event and send this event to all measure listeners.
     * @param  e
     */
    public abstract void sendMeasureValue(MeasureEvent e);

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueTooHigh(float measureValue);

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueNormal(float measureValue);

    /**
     * @param  measureValue
     * @return
     */
    public abstract boolean isMeasureValueTooLow(float measureValue);

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754622251_213885_857) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
