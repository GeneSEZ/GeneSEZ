package base.parts;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1178034133828_951385_16) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class Screw {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /** @see {@link getLength} */
    private float length;
    private float diameter;
    private boolean metric;
    private java.util.Set<String> strengthClasses =
        new java.util.HashSet<String>();

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated derived attribute method implementations
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
     * @param  count
     */
    public void screwOn(int count) {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1183038841674_975104_475) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
      * describes the length of a screw
      */
    public float getLength() {
        return length;
    }

    /** @see {@link getLength} */
    public void setLength(float _length) {
        length = _length;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float _diameter) {
        diameter = _diameter;
    }

    public boolean getMetric() {
        return metric;
    }

    public void setMetric(boolean _metric) {
        metric = _metric;
    }

    public java.util.Set getStrengthClasses() {
        return java.util.Collections.unmodifiableSet(strengthClasses);
    }

    public void addToStrengthClasses(String _in) {
        strengthClasses.add(_in);
    }

    public void removeFromStrengthClasses(String _ex) {
        strengthClasses.remove(_ex);
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1178034133828_951385_16) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
