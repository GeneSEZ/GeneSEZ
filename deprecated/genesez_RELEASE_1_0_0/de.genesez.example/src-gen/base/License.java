package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_6340215_1182161482703_876307_352) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class License {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////
    private String registration;

    /**
     * variable for association to car
     */
    private java.util.Set<Owner> car = new java.util.HashSet<Owner>();

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated derived attribute method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * accessor for association to car
     */
    public java.util.Set<Car> getCar() {
        java.util.HashSet<Car> _result = new java.util.HashSet<Car>();
        for (Owner _assoc : car) {
            _result.add(_assoc.getCar());
        }
        return _result;
    }

    /**
      * accessor to the association class objects
      */
    public java.util.Set<Owner> getCarOwner() {
        return java.util.Collections.unmodifiableSet(car);
    }

    /**
     * accessor for association to car
     */

    /**
      * insert into association, generate linked association class object
      * @param _other partner object
      * @return newly generated linked association class object
      */
    public Owner insertInCar(Car _other) {
        Owner _assoc = new Owner(this, _other);
        car.add(_assoc);
        _other.insertInLicense(_assoc);
        return _assoc;
    }

    /**
      * insert linked association class object into association
      * @param _other partner object
      * @return newly generated linked association class object
      */
    public void insertInCar(Owner _assoc) {
        if (car.contains(_assoc)) {
            return;
        }
        if (_assoc.getLicense() != this) {
            throw new RuntimeException("inconsistent association object");
        }
        car.add(_assoc);
    }

    /**
     * accessor for association to car
     */

    /**
      * remove entry from association indexed by its association class object
      */
    public void removeFromCar(Owner _assoc) {
        if (!car.contains(_assoc)) {
            return;
        }
        car.remove(_assoc);
        _assoc.getCar().removeFromLicense(_assoc);
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String _registration) {
        registration = _registration;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_6340215_1182161482703_876307_352) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
