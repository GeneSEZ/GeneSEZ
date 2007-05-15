package base;


/*
        Vehicle.java
        generated @ 2007-05-15 18:38:01.218 CEST by georg
        here only for demo of java extension call.
        should not be used because it would cause
        new svn revisions even when nothing else changed!
 */

/* PROTECTED REGION ID(java.imports._mxnRkwMCEdyxB6OTzxcZMQ) ENABLED START */
// put your imports here - following import is placeholder so that your IDE puts further imports here
import java.lang.String;


/* PROTECTED REGION END */

/**
        <!-- PROTECTED REGION ID(java.type.comment._mxnRkwMCEdyxB6OTzxcZMQ) ENABLED START -->
        <!-- TODO put your type comment here [description + responsibility] -->
        <!-- PROTECTED REGION END -->

        @author                georg
        @version        2007-05-15 18:38:01.218 CEST
 */
public abstract class Vehicle {
    // -- methods ---------------------------------------------------

    // -- attribute definitions with default initialization ---------
    private String make;

    // -- constructors ----------------------------------------------
    // -- abstract methods ------------------------------------------
    public abstract Boolean drive(int speed)
        throws WhatAMessException, NotReallySeriousException;

    // -- attribute getter + setter ---------------------------------
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    /* PROTECTED REGION ID(java.impl._mxnRkwMCEdyxB6OTzxcZMQ) ENABLED START */
    // -- put your implementation code here -------------------------

    /* PROTECTED REGION END */
}
