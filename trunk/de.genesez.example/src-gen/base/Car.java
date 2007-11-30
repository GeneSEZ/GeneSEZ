package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1177945913718_872802_139) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* <!-- PROTECTED REGION END --> */
/**
 * A car is a vehicle with four wheels and drives on the road.
 * @author nicher
 */
public class Car extends Vehicle {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /** @see {@link getMaxSpeed} */
    private int maxSpeed;

    /**
     * variable for association to wheels
     * @see {@link getWheels}
     */
    private java.util.Set<Wheel> wheels = new java.util.HashSet<Wheel>();

    /**
     * variable for association to spare
     * @see {@link getSpare}
     */
    private Wheel spare;

    /**
     * variable for association to license
     */
    private java.util.Set<Owner> license = new java.util.HashSet<Owner>();

    /**
     * variable for association to licensePlate
     */
    private LicensePlate licensePlate;

    /**
     * variable for association to engine
     */
    private Engine engine;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * constructor of the class car
     * @param  mxs  maximum of speed
     * @param  make  i don't know what make do
     * @throws  NotReallySeriousException  this is a comment; this is the second comment
     */
    public Car(int mxs, String make) throws NotReallySeriousException {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179229080562_965427_117) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated derived attribute method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
      * count the number of wheels
      */
    private Integer getNoOfWheels() {
        Integer returnValue = null;

        /* <!-- PROTECTED REGION ID(java.mattribute.implementation.attribute.code._11_5_6340215_1178786244296_257674_121) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for association to wheels
     * reference to normal wheels on a car
     */
    public java.util.Set<Wheel> getWheels() {
        return java.util.Collections.unmodifiableSet(wheels);
    }

    /**
     * accessor for association to wheels
     * @see {@link getWheels}
     */
    public void insertInWheels(Wheel _in) {
        if (wheels.contains(_in)) {
            return;
        }
        wheels.add(_in);
        _in.insertInMycar(this);
    }

    /**
     * accessor for association to wheels
     * @see {@link getWheels}
     */
    public void removeFromWheels(Wheel _ex) {
        if (!wheels.contains(_ex)) {
            return;
        }
        wheels.remove(_ex);
        _ex.removeFromMycar(this);
    }

    /**
     * accessor for association to spare
     * reference to the spared wheel
     */
    public Wheel getSpare() {
        return spare;
    }

    /**
     * accessor for association to spare
     * @see {@link getSpare}
     */
    public void insertInSpare(Wheel _in) {
        if (spare == _in) {
            return;
        }
        spare = _in;
    }

    /**
     * accessor for association to spare
     * @see {@link getSpare}
     */
    public void removeFromSpare(Wheel _ex) {
        if (spare != _ex) {
            return;
        }
        spare = null;
    }

    /**
     * accessor for association to license
     */
    public java.util.Set<License> getLicense() {
        java.util.HashSet<License> _result = new java.util.HashSet<License>();
        for (Owner _assoc : license) {
            _result.add(_assoc.getLicense());
        }
        return _result;
    }

    /**
      * accessor to the association class objects
      */
    public java.util.Set<Owner> getLicenseOwner() {
        return java.util.Collections.unmodifiableSet(license);
    }

    /**
     * accessor for association to license
     */

    /**
      * insert into association, generate linked association class object
      * @param _other partner object
      * @return newly generated linked association class object
      */
    public Owner insertInLicense(License _other) {
        Owner _assoc = new Owner(_other, this);
        license.add(_assoc);
        _other.insertInCar(_assoc);
        return _assoc;
    }

    /**
      * insert linked association class object into association
      * @param _other partner object
      * @return newly generated linked association class object
      */
    public void insertInLicense(Owner _assoc) {
        if (license.contains(_assoc)) {
            return;
        }
        if (_assoc.getCar() != this) {
            throw new RuntimeException("inconsistent association object");
        }
        license.add(_assoc);
    }

    /**
     * accessor for association to license
     */

    /**
      * remove entry from association indexed by its association class object
      */
    public void removeFromLicense(Owner _assoc) {
        if (!license.contains(_assoc)) {
            return;
        }
        license.remove(_assoc);
        _assoc.getLicense().removeFromCar(_assoc);
    }

    /**
     * accessor for association to licensePlate
     */
    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    /**
     * accessor for association to licensePlate
     */
    public void insertInLicensePlate(LicensePlate _in) {
        if (licensePlate == _in) {
            return;
        }
        if (licensePlate != null) {
            licensePlate.removeFromCar(this);
        }
        licensePlate = _in;
        _in.insertInCar(this);
    }

    /**
     * accessor for association to licensePlate
     */
    public void removeFromLicensePlate(LicensePlate _ex) {
        if (licensePlate != _ex) {
            return;
        }
        licensePlate = null;
        _ex.removeFromCar(this);
    }

    /**
     * accessor for association to engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * accessor for association to engine
     */
    public void insertInEngine(Engine _in) {
        if (engine == _in) {
            return;
        }
        if (engine != null) {
            engine.removeFromCar(this);
        }
        engine = _in;
        _in.insertInCar(this);
    }

    /**
     * accessor for association to engine
     */
    public void removeFromEngine(Engine _ex) {
        if (engine != _ex) {
            return;
        }
        engine = null;
        _ex.removeFromCar(this);
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * define if the car is driving
     * @param  speed
     * @return
     * @throws  WhatAMessException
     * @throws  NotReallySeriousException  this is a comment; this is the second comment
     */
    public final boolean drive(int speed)
        throws WhatAMessException, NotReallySeriousException {
        Boolean returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179222914421_654419_131) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
      * describs the maximum speed of a car
      */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /** @see {@link getMaxSpeed} */
    public void setMaxSpeed(int _maxSpeed) {
        maxSpeed = _maxSpeed;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1177945913718_872802_139) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
