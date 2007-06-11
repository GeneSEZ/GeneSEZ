package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1179139182234_646597_164) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;


/* <!-- PROTECTED REGION END --> */

/**
 * <!-- PROTECTED REGION ID(java.mclass.declaration.class.comment._11_5_6340215_1179139182234_646597_164) ENABLED START -->
 * Vehicle.java
 *
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * <p>
 * null
 *
 * @author nicher (generated at 2007-06-11 16:53:13.437 CEST)
 * @version %I%
 * <!-- PROTECTED REGION END -->
 */
public abstract class Vehicle {
    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._11_5_6340215_1177946075218_295795_245) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private String make;

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._12_5EAPbeta2_8a7027a_1181573402463_629866_342) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private VehicleStatus status;

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.moperation.declaration.operation.comment._11_5_6340215_1179222625687_525666_120) ENABLED START -->
     * nothing
     *
     * @param speed  define the actual of speed of the vehicle
     * @return  <!-- TODO put your comment here -->
     * @throws WhatAMessException  <!-- TODO put your comment here -->
     * @throws NotReallySeriousException  this is a comment;  this is the second comment
     * <!-- PROTECTED REGION END -->
     */
    public abstract Boolean drive(int speed)
        throws WhatAMessException, NotReallySeriousException;

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////
    public String toString() {
        /* <!-- PROTECTED REGION ID(java.mclass.implementation.tostring.code._11_5_6340215_1179139182234_646597_164) ENABLED START --> */
        /* <!-- TODO put your own toString code here --> */
        return super.toString();

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._11_5_6340215_1177946075218_295795_245) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public String getMake() {
        return make;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._11_5_6340215_1177946075218_295795_245) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param make  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._12_5EAPbeta2_8a7027a_1181573402463_629866_342) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public VehicleStatus getStatus() {
        return status;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._12_5EAPbeta2_8a7027a_1181573402463_629866_342) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param status  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1179139182234_646597_164) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
