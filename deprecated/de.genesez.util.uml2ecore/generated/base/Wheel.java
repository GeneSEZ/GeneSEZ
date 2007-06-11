package base;


/*
        Wheel.java
        generated @ 2007-05-24 19:39:01.656 CEST by georg
        here only for demo of java extension call.
        should not be used because it would cause
        new svn revisions even when nothing else changed!
 */

/* PROTECTED REGION ID(java.imports._OCnimQodEdy9NY2aWONLeQ) ENABLED START */
// put your imports here - following import is placeholder so that your IDE puts further imports here
import base.parts.Screw;


/* PROTECTED REGION END */

/**
        <!-- PROTECTED REGION ID(java.type.comment._OCnimQodEdy9NY2aWONLeQ) ENABLED START -->
        <!-- TODO put your type comment here [description + responsibility] -->
        <!-- PROTECTED REGION END -->

        @author                georg
        @version        2007-05-24 19:39:01.656 CEST
 */
public class Wheel implements Changeable {
    // -- attribute definitions with default initialization ---------
    private float diameter;
    private String specification;

    // -- declare association attributes ----------------------------
    private Car mycar;
    private java.util.Set<Screw> screw = new java.util.HashSet<Screw>();

    // -- constructors ----------------------------------------------
    // -- abstract methods ------------------------------------------
    // -- methods ---------------------------------------------------
    public Boolean change(Wheel newWheel) {
        Boolean retval = false;

        /* PROTECTED REGION ID(methods.methodimpl_OCnipQodEdy9NY2aWONLeQ) ENABLED START */
        // TODO: implement method change
        /* PROTECTED REGION END */
        return retval;
    }

    public void roll() {
        /* PROTECTED REGION ID(methods.methodimpl_OCniqAodEdy9NY2aWONLeQ) ENABLED START */
        // TODO: implement method roll
        /* PROTECTED REGION END */
    }

    // -- attribute getter + setter ---------------------------------
    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    // -- methods for adding to and removing from association -------
    public void insertInMycar(Car _in) {
        if (mycar == _in) {
            return;
        }

        if (mycar != null) {
            mycar.removeFromWheels(this);
        }

        mycar = _in;
        _in.insertInWheels(this);
    }

    public void removeFromMycar(Car _ex) {
        if (mycar != _ex) {
            return;
        }

        mycar = null;
        _ex.removeFromWheels(this);
    }

    public void insertInScrew(Screw _in) {
        if (screw.contains(_in)) {
            return;
        }

        screw.add(_in);
    }

    public void removeFromScrew(Screw _ex) {
        if (!screw.contains(_ex)) {
            return;
        }

        screw.remove(_ex);
    }

    // -- methods for accessing the association ----------------------
    public Car getMycar() {
        return mycar;
    }

    public java.util.Set<Screw> getScrew() {
        return java.util.Collections.unmodifiableSet(screw);
    }

    public java.util.Iterator<Screw> getScrewIterator() {
        return screw.iterator();
    }

    /* PROTECTED REGION ID(java.impl._OCnimQodEdy9NY2aWONLeQ) ENABLED START */
    // -- put your implementation code here -------------------------

    /* PROTECTED REGION END */
}
