package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_6340215_1182161516984_21570_380) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * @author nicher
 */
public class Owner {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////
    private String name;

    /** reference attribute to the managed association end */
    private Car car;

    /** reference attribute to the managed association end */
    private License license;

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
      * An AssociationClass should only have a public initializing constructor
      * that sets the references to its association ends
      */
    public Owner(Car _car, License _license) {
        car = _car;
        license = _license;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_6340215_1182161516984_21570_380) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated derived attribute method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /** getter of reference attribute to the managed association end  car*/
    public Car getCar() {
        return car;
    }

    /** getter of reference attribute to the managed association end  license*/
    public License getLicense() {
        return license;
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
    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_6340215_1182161516984_21570_380) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
