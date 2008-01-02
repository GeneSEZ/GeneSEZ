package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1182165360608_205087_392) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class LicensePlate {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////
    private String key;

    /**
     * variable for association to car
     */
    private Car car;

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
    public Car getCar() {
        return car;
    }

    /**
     * accessor for association to car
     */
    public void insertInCar(Car _in) {
        if (car == _in) {
            return;
        }
        if (car != null) {
            car.removeFromLicensePlate(this);
        }
        car = _in;
        _in.insertInLicensePlate(this);
    }

    /**
     * accessor for association to car
     */
    public void removeFromCar(Car _ex) {
        if (car != _ex) {
            return;
        }
        car = null;
        _ex.removeFromLicensePlate(this);
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
    public String getKey() {
        return key;
    }

    public void setKey(String _key) {
        key = _key;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1182165360608_205087_392) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
