package de.genesez.imsys.sensor;


/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184754703767_466983_906) ENABLED START */
/* TODO put your imports here */
import java.lang.String;

/* PROTECTED REGION END */
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
     */
    private float gradient = 1;

    /**
     * variable
     */
    private float offset = 0;

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
     * @param  gradient
     * @param  offset
     */
    public MeasureSensor(int address, float gradient, float offset) {
        /* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188991545820_140894_1317) ENABLED START */
        /* TODO put your own implementation code here */
        super(address);
        this.gradient = gradient;
        this.offset = offset;

        /* PROTECTED REGION END */
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
     */
    public abstract void measure();

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for attribute gradient
     */
    public float getGradient() {
        return gradient;
    }

    /**
     * accessor for attribute gradient
     */
    public void setGradient(float _gradient) {
        gradient = _gradient;
    }

    /**
     * accessor for attribute offset
     */
    public float getOffset() {
        return offset;
    }

    /**
     * accessor for attribute offset
     */
    public void setOffset(float _offset) {
        offset = _offset;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184754703767_466983_906) ENABLED START */
    /* TODO put your own implementation code here */

    /* PROTECTED REGION END */
}
