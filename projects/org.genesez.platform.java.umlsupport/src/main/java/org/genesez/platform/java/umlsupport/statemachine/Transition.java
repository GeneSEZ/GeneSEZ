package org.genesez.platform.java.umlsupport.statemachine;

/**
 * @author: georg beier 
 * @version: $Revision: 1.1 $
 */
public class Transition<RCV, EV, ST> implements AbstractTransition<RCV, EV, ST> {

    // Attribute Definitions

    private ST target;

    // Constructors

    public Transition(ST tgt) {
        target = tgt;
    }

    /**
     * does nothing. should be overwritten by subclass, 
     * if any actions are bound to this transition
     * @param ev	incoming event
     * @param onObj	object receiving event
     * @return target state
    */
    public ST exec(EventQueue.Event<EV> ev, RCV onObj) {
        return target;
    }


    public ST getTarget() {
        return target;
    }

    public String toString() {
        return
            "(target: " + getTarget() + ")" ;
    }

}


