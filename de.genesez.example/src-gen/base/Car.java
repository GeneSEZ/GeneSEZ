package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1177945913718_872802_139) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;


/* <!-- PROTECTED REGION END --> */

/**
 * <!-- PROTECTED REGION ID(java.mclass.declaration.class.comment._11_5_6340215_1177945913718_872802_139) ENABLED START -->
 * Car.java
 *
 * A car is a vehicle with four wheels and drives on the road.
 *
 * @author nicher (generated at 2007-06-11 16:53:13.187 CEST)
 * @version %I%
 * <!-- PROTECTED REGION END -->
 */
public class Car extends Vehicle {
    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._11_5_6340215_1177946061546_878977_243) ENABLED START -->
     * describs the maximum speed of a car
     * <p>
     * internal bla bla bla
     * <!-- PROTECTED REGION END -->
     */
    private int maxSpeed;

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._11_5_6340215_1178786244296_257674_121) ENABLED START -->
     * count the number of wheels
     * <!-- PROTECTED REGION END -->
     */
    private Integer noOfWheels;

    /**
     * <!-- PROTECTED REGION ID(java.massociationrole.declaration.association.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * reference to normal wheels on a car
     * <!-- PROTECTED REGION END -->
     */
    private java.util.Set<Wheel> wheels = new java.util.HashSet<Wheel>();

    /**
     * <!-- PROTECTED REGION ID(java.massociationrole.declaration.association.comment._11_5_6340215_1178610607125_74363_5) ENABLED START -->
     * reference to the spared wheel
     * <!-- PROTECTED REGION END -->
     */
    private Wheel spare;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.moperation.implementation.constructor.comment._11_5_6340215_1179229080562_965427_117) ENABLED START -->
     * constructor of the class car
     *
     * @param mxs  maximum of speed
     * @param make  i don't know what make do
     *
     * @throws NotReallySeriousException  this is a comment;  this is the second comment
     * <!-- PROTECTED REGION END -->
     */
    public Car(int mxs, String make) throws NotReallySeriousException {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.constructor.code._11_5_6340215_1179229080562_965427_117) ENABLED START --> */
        /* <!-- TODO put your code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.getter.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * getter for:
     * reference to normal wheels on a car
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public java.util.Set<Wheel> getWheels() {
        return java.util.Collections.unmodifiableSet(wheels);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.setter.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * setter for:
     * reference to normal wheels on a car
     *
     * @param wheels  reference to normal wheels on a car
     * <!-- PROTECTED REGION END -->
     */
    public void setWheels(java.util.HashSet<Wheel> wheels) {
        this.wheels = wheels;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.iterator.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * iterator for:
     * reference to normal wheels on a car
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public java.util.Iterator<Wheel> getWheelsIterator() {
        return wheels.iterator();
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.insertin.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * insert in for:
     * reference to normal wheels on a car
     *
     * @param _in  reference to normal wheels on a car
     * <!-- PROTECTED REGION END -->
     */
    public void insertInWheels(Wheel _in) {
        if (wheels.contains(_in)) {
            return;
        }

        wheels.add(_in);

        _in.insertInMycar(this);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.removefrom.comment._11_5_6340215_1177945988421_623431_192) ENABLED START -->
     * remove from for:
     * reference to normal wheels on a car
     *
     * @param _ex  reference to normal wheels on a car
     * <!-- PROTECTED REGION END -->
     */
    public void removeFromWheels(Wheel _ex) {
        if (!wheels.contains(_ex)) {
            return;
        }

        wheels.remove(_ex);

        _ex.removeFromMycar(this);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.getter.comment._11_5_6340215_1178610607125_74363_5) ENABLED START -->
     * getter for:
     * reference to the spared wheel
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public Wheel getSpare() {
        return spare;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.setter.comment._11_5_6340215_1178610607125_74363_5) ENABLED START -->
     * setter for:
     * reference to the spared wheel
     *
     * @param spare  reference to the spared wheel
     * <!-- PROTECTED REGION END -->
     */
    public void setSpare(Wheel spare) {
        this.spare = spare;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.insertin.comment._11_5_6340215_1178610607125_74363_5) ENABLED START -->
     * insert in for:
     * reference to the spared wheel
     *
     * @param _in  reference to the spared wheel
     * <!-- PROTECTED REGION END -->
     */
    public void insertInSpare(Wheel _in) {
        if (spare == _in) {
            return;
        }

        spare = _in;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.removefrom.comment._11_5_6340215_1178610607125_74363_5) ENABLED START -->
     * remove from for:
     * reference to the spared wheel
     *
     * @param _ex  reference to the spared wheel
     * <!-- PROTECTED REGION END -->
     */
    public void removeFromSpare(Wheel _ex) {
        if (spare != _ex) {
            return;
        }

        spare = null;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.moperation.implementation.operation.comment._11_5_6340215_1179222914421_654419_131) ENABLED START -->
     * define if the car is driving
     *
     * @param speed  acutal speed of the car
     * @return  <!-- TODO put your comment here -->
     * @throws WhatAMessException  <!-- TODO put your comment here -->
     * @throws NotReallySeriousException  this is a comment;  this is the second comment
     * <!-- PROTECTED REGION END -->
     */
    public final Boolean drive(int speed)
        throws WhatAMessException, NotReallySeriousException {
        Boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179222914421_654419_131) ENABLED START --> */
        /* <!-- TODO put your code here --> */

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    public String toString() {
        /* <!-- PROTECTED REGION ID(java.mclass.implementation.tostring.code._11_5_6340215_1177945913718_872802_139) ENABLED START --> */
        /* <!-- TODO put your own toString code here --> */
        return super.toString();

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._11_5_6340215_1177946061546_878977_243) ENABLED START -->
     * getter for:
     * describs the maximum speed of a car
     * <p>
     * internal bla bla bla
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._11_5_6340215_1177946061546_878977_243) ENABLED START -->
     * setter for:
     * describs the maximum speed of a car
     * <p>
     * internal bla bla bla
     *
     * @param MaxSpeed  describs the maximum speed of a car;  <p> ;  internal bla bla bla
     * <!-- PROTECTED REGION END -->
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._11_5_6340215_1178786244296_257674_121) ENABLED START -->
     * getter for:
     * count the number of wheels
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public Integer getNoOfWheels() {
        return noOfWheels;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._11_5_6340215_1178786244296_257674_121) ENABLED START -->
     * setter for:
     * count the number of wheels
     *
     * @param noOfWheels  count the number of wheels
     * <!-- PROTECTED REGION END -->
     */
    public void setNoOfWheels(Integer noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1177945913718_872802_139) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
