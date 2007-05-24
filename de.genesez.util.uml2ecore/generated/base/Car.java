package base;


/*
        Car.java
        generated @ 2007-05-24 19:39:01.593 CEST by georg
        here only for demo of java extension call.
        should not be used because it would cause
        new svn revisions even when nothing else changed!
 */

/* PROTECTED REGION ID(java.imports._OCniiQodEdy9NY2aWONLeQ) ENABLED START */
// put your imports here - following import is placeholder so that your IDE puts further imports here
import java.lang.String;


/* PROTECTED REGION END */

/**
        <!-- PROTECTED REGION ID(java.type.comment._OCniiQodEdy9NY2aWONLeQ) ENABLED START -->
        <!-- TODO put your type comment here [description + responsibility] -->
        <!-- PROTECTED REGION END -->

        @author                georg
        @version        2007-05-24 19:39:01.593 CEST
 */
public class Car extends Vehicle {
    // -- attribute definitions with default initialization ---------
    private int maxSpeed;
    private Integer noOfWheels;

    // -- declare association attributes ----------------------------
    private java.util.Set<Wheel> wheels = new java.util.HashSet<Wheel>();
    private Wheel spare;

    // -- constructors ----------------------------------------------
    public Car(int mxs, String make) throws NotReallySeriousException {
        /* PROTECTED REGION ID(methods.methodimpl_OCnilgodEdy9NY2aWONLeQ) ENABLED START */
        // TODO: implement constructor
        /* PROTECTED REGION END */
    }

    // -- abstract methods ------------------------------------------
    // -- methods ---------------------------------------------------
    public final Boolean drive(int speed)
        throws WhatAMessException, NotReallySeriousException {
        Boolean retval = false;

        /* PROTECTED REGION ID(methods.methodimpl_OCnikwodEdy9NY2aWONLeQ) ENABLED START */
        // TODO: implement method drive
        /* PROTECTED REGION END */
        return retval;
    }

    // -- attribute getter + setter ---------------------------------
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(Integer noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    // -- methods for adding to and removing from association -------
    public void insertInWheels(Wheel _in) {
        if (wheels.contains(_in)) {
            return;
        }

        wheels.add(_in);
        _in.insertInMycar(this);
    }

    public void removeFromWheels(Wheel _ex) {
        if (!wheels.contains(_ex)) {
            return;
        }

        wheels.remove(_ex);
        _ex.removeFromMycar(this);
    }

    public void insertInSpare(Wheel _in) {
        if (spare == _in) {
            return;
        }

        spare = _in;
    }

    public void removeFromSpare(Wheel _ex) {
        if (spare != _ex) {
            return;
        }

        spare = null;
    }

    // -- methods for accessing the association ----------------------
    public java.util.Set<Wheel> getWheels() {
        return java.util.Collections.unmodifiableSet(wheels);
    }

    public java.util.Iterator<Wheel> getWheelsIterator() {
        return wheels.iterator();
    }

    public Wheel getSpare() {
        return spare;
    }

    /* PROTECTED REGION ID(java.impl._OCniiQodEdy9NY2aWONLeQ) ENABLED START */
    // -- put your implementation code here -------------------------

    /* PROTECTED REGION END */
}
