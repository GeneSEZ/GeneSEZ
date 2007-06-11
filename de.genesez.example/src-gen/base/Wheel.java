package base;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1177945943625_542159_161) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;


/* <!-- PROTECTED REGION END --> */

/**
 * <!-- PROTECTED REGION ID(java.mclass.declaration.class.comment._11_5_6340215_1177945943625_542159_161) ENABLED START -->
 * Wheel.java
 *
 * <!-- TODO put your comment here -->
 *
 * @author nicher (generated at 2007-06-11 16:53:13.359 CEST)
 * @version %I%
 * <!-- PROTECTED REGION END -->
 */
public class Wheel implements Changeable {
    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._11_5_6340215_1177945958000_326546_182) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private float diameter;

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.declaration.attribute.comment._11_5_6340215_1178785354859_924284_117) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private String specification;

    /**
     * <!-- PROTECTED REGION ID(java.massociationrole.declaration.association.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private Car mycar;

    /**
     * <!-- PROTECTED REGION ID(java.massociationrole.declaration.association.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    private java.util.Set<Screw> screw = new java.util.HashSet<Screw>();

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.getter.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  A car is a vehicle with four wheels and drives on the road.
     * <!-- PROTECTED REGION END -->
     */
    public Car getMycar() {
        return mycar;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.setter.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param mycar  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setMycar(Car mycar) {
        this.mycar = mycar;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.insertin.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
     * insert in for:
     * <!-- TODO put your comment here -->
     *
     * @param _in  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
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

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.removefrom.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
     * remove from for:
     * <!-- TODO put your comment here -->
     *
     * @param _ex  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void removeFromMycar(Car _ex) {
        if (mycar != _ex) {
            return;
        }

        mycar = null;

        _ex.removeFromWheels(this);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.getter.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public java.util.Set<Screw> getScrew() {
        return java.util.Collections.unmodifiableSet(screw);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.setter.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param screw  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setScrew(java.util.HashSet<Screw> screw) {
        this.screw = screw;
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.iterator.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * iterator for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public java.util.Iterator<Screw> getScrewIterator() {
        return screw.iterator();
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.insertin.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * insert in for:
     * <!-- TODO put your comment here -->
     *
     * @param _in  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void insertInScrew(Screw _in) {
        if (screw.contains(_in)) {
            return;
        }

        screw.add(_in);
    }

    /**
     * <!-- PROTECTED REGION ID(java.massociation.implementation.removefrom.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
     * remove from for:
     * <!-- TODO put your comment here -->
     *
     * @param _ex  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void removeFromScrew(Screw _ex) {
        if (!screw.contains(_ex)) {
            return;
        }

        screw.remove(_ex);
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.moperation.implementation.operation.comment._11_5_6340215_1179139054625_520706_1) ENABLED START -->
     * <!-- TODO put your comment here -->
     *
     * @param newWheel  <!-- TODO put your comment here -->
     * @return  <!-- TODO put your comment here -->
    
     * <!-- PROTECTED REGION END -->
     */
    public Boolean change(Changeable newWheel) {
        Boolean returnValue = false;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179139054625_520706_1) ENABLED START --> */
        /* <!-- TODO put your code here --> */

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * <!-- PROTECTED REGION ID(java.moperation.implementation.operation.comment._11_5_6340215_1179238960437_25222_122) ENABLED START -->
     * <!-- TODO put your comment here -->
     *
    
     *
    
     * <!-- PROTECTED REGION END -->
     */
    public void roll() {
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179238960437_25222_122) ENABLED START --> */
        /* <!-- TODO put your code here --> */

        /* <!-- PROTECTED REGION END --> */
    }

    public String toString() {
        /* <!-- PROTECTED REGION ID(java.mclass.implementation.tostring.code._11_5_6340215_1177945943625_542159_161) ENABLED START --> */
        /* <!-- TODO put your own toString code here --> */
        return super.toString();

        /* <!-- PROTECTED REGION END --> */
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._11_5_6340215_1177945958000_326546_182) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public float getDiameter() {
        return diameter;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._11_5_6340215_1177945958000_326546_182) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param diameter  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.getter.comment._11_5_6340215_1178785354859_924284_117) ENABLED START -->
     * getter for:
     * <!-- TODO put your comment here -->
     *
     * @return  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * <!-- PROTECTED REGION ID(java.mattribute.implementation.setter.comment._11_5_6340215_1178785354859_924284_117) ENABLED START -->
     * setter for:
     * <!-- TODO put your comment here -->
     *
     * @param specification  <!-- TODO put your comment here -->
     * <!-- PROTECTED REGION END -->
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1177945943625_542159_161) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
