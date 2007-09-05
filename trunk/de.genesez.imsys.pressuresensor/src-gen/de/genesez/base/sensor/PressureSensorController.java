package de.genesez.base.sensor;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184788751596_880775_1180) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import de.genesez.imsys.sensor.IMeasureListener;
import de.genesez.imsys.sensor.IMeasureSensor;
import de.genesez.imsys.sensor.MeasureController;
import de.genesez.imsys.sensor.MeasureEvent;

/* <!-- PROTECTED REGION END --> */
/**
 * This class controls the pressure sensor.
 * @author nicher
 */
public class PressureSensorController extends MeasureController {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  pressureSensor
     * @param  min
     * @param  max
     */
    public PressureSensorController(PressureSensor pressureSensor, float min,
        float max) {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184788838512_821977_1247) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        super(pressureSensor, min, max);
        pressureSensor.insertInMeasureController(this);

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
     * Method which receives an measure event and send this event to all measure listeners.
     * @param  e
     */
    public void sendMeasureValue(MeasureEvent e) {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185458858941_864914_1523) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        IMeasureListener listener;

        // notify all listeners witch listens to the pressure sensor
        for (int i = 0; i < getMeasureListenerCount(); i++) {
            listener = getMeasureListener(i);

            listener.measureValue(e);
            if (isMeasureValueTooHigh(e.getMeasureValue())) {
                listener.measureValueTooHigh(e);
            } else if (isMeasureValueNormal(e.getMeasureValue())) {
                listener.measureValueNormal(e);
            } else if (isMeasureValueTooLow(e.getMeasureValue())) {
                listener.measureValueTooLow(e);
            }
        }

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184788751596_880775_1180) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
