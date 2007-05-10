package base;


/*
        Car.java
        generated @ 2007-05-10 22:19:01.671 CEST by georg
        here only for demo of java extension call.
        should not be used because it would cause
        new svn revisions even when nothing else changed!
 */

/* PROTECTED REGION ID(java.imports._wPhQOf8mEdu_PKOyBey_uw) ENABLED START */
// put your imports here - following import is placeholder so that your IDE puts further imports here


/* PROTECTED REGION END */

/**
        <!-- PROTECTED REGION ID(java.type.comment._wPhQOf8mEdu_PKOyBey_uw) ENABLED START -->
        <!-- TODO put your type comment here [description + responsibility] -->
        <!-- PROTECTED REGION END -->

        @author                georg
        @version        2007-05-10 22:19:01.671 CEST
 */
public class Car {
    // -- attribute definitions with default initialization ---------
    private int maxSpeed;
    private String make;
    private Integer noOfWheels;

    // -- declare association attributes ----------------------------
    private java.util.Set<Wheel> wheels = new java.util.HashSet<Wheel>();
    private Wheel spare;

    // -- attribute getter + setter ---------------------------------
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(Integer noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    // -- adding to and removing from association -------------------
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

    // -- various ways to access the association --------------------
    public java.util.Set<Wheel> getWheels() {
        return java.util.Collections.unmodifiableSet(wheels);
    }

    public Wheel[] getWheelsArray() {
        return wheels.toArray(new Wheel[0]);
    }

    public java.util.Iterator<Wheel> getWheelsIterator() {
        return wheels.iterator();
    }

    public int getWheelsCount() {
        return wheels.size();
    }

    public Wheel getSpare() {
        return spare;
    }

    /* PROTECTED REGION ID(java.impl._wPhQOf8mEdu_PKOyBey_uw) ENABLED START */
    // -- put your implementation code here -------------------------

    /* PROTECTED REGION END */

    // -- now it's your turn ----------------------------------------
}
