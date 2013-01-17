package org.genesez.platform.java.umlsupport.statemachine;
import java.util.*; // always good to have, discard if you like ;-)
/**
 * @author:	 georg beier 
 * @version: $Revision: 1.1 $
 */
public class TransitionSelector<EV, ST> {

    /**
    * Initializing constructor
    **/
    public TransitionSelector( EV pEvent, ST pOrigin ) {

        event = pEvent;
        origin = pOrigin;
    }

    private EV event;
    private ST origin;

    // Attribute Getters

    public EV getEvent() {
        return event;
    }

    public ST getOrigin() {
        return origin;
    }

    public String toString() {
        return
            "(event: " + getEvent() + ")" +
            "(origin: " + getOrigin() + ")" ;
    }

    @SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
        if(obj instanceof TransitionSelector) {
            TransitionSelector _obj = (TransitionSelector) obj;
            return
                event.equals(_obj.event) &&
                origin.equals(_obj.origin) ;
        } else
            return false;
    }

    public int hashCode() {
        long hash = 0;
        hash += event.hashCode();
        hash += origin.hashCode();
        return (int) (hash % Integer.MAX_VALUE);
    }
}


