package base.parts;


/*
        Screw.java
        generated @ 2007-05-24 19:39:01.093 CEST by georg
        here only for demo of java extension call.
        should not be used because it would cause
        new svn revisions even when nothing else changed!
 */

/* PROTECTED REGION ID(java.imports._OCniqwodEdy9NY2aWONLeQ) ENABLED START */
// put your imports here - following import is placeholder so that your IDE puts further imports here
import java.lang.String;


/* PROTECTED REGION END */

/**
        <!-- PROTECTED REGION ID(java.type.comment._OCniqwodEdy9NY2aWONLeQ) ENABLED START -->
        <!-- TODO put your type comment here [description + responsibility] -->
        <!-- PROTECTED REGION END -->

        @author                georg
        @version        2007-05-24 19:39:01.109 CEST
 */
public class Screw {
    // -- constructors ----------------------------------------------
    // -- abstract methods ------------------------------------------
    // -- methods ---------------------------------------------------

    // -- attribute definitions with default initialization ---------
    private float length;
    private float diameter;
    private Boolean metric;

    // -- attribute getter + setter ---------------------------------
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public Boolean getMetric() {
        return metric;
    }

    public void setMetric(Boolean metric) {
        this.metric = metric;
    }

    /* PROTECTED REGION ID(java.impl._OCniqwodEdy9NY2aWONLeQ) ENABLED START */
    // -- put your implementation code here -------------------------

    /* PROTECTED REGION END */
}
