package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1182165491328_680838_471) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class Engine {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////
    private byte ps;
    private String name;

    /**
     * variable for association to car
     */
    private Car car;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * @param  ps
     * @param  name
     */
    public Engine(byte ps, String name) {

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1182275619895_618915_478) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

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
            car.removeFromEngine(this);
        }
        car = _in;
        _in.insertInEngine(this);
    }

    /**
     * accessor for association to car
     */
    public void removeFromCar(Car _ex) {
        if (car != _ex) {
            return;
        }
        car = null;
        _ex.removeFromEngine(this);
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
    public byte getPs() {
        return ps;
    }

    public void setPs(byte _ps) {
        ps = _ps;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1182165491328_680838_471) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
