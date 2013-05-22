package org.genesez.platform.java.umlsupport.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: georg beier 
 * @version: $Revision: 1.1 $
 */
public class StateMachine<RCV, EV, ST> {

    private Map<TransitionSelector<EV, ST>, AbstractTransition<RCV, EV, ST>> transitionTable;

    public StateMachine() {
        transitionTable = new HashMap<TransitionSelector<EV, ST>, AbstractTransition<RCV, EV, ST>>();
    }

    /**
     * execute a state machine event
    */
    public ST takeEvent(EventQueue.Event<EV> ev, ST state, RCV rcv) {
        ST stateId;
        EV eventId = (EV) ev.getEventId();
        TransitionSelector<EV, ST> key = new TransitionSelector<EV, ST>(eventId, state);
        AbstractTransition<RCV, EV, ST> trans = transitionTable.get(key);
        if(trans != null) {
        	stateId = trans.exec(ev, rcv);
            if(stateId != null)
                return stateId;
            else
                return state;
        } else {
            throw new RuntimeException(
                "unexpected event " + ev +
                " in state " + state + " of object " + rcv);
        }
    }

    /**
     */  
    public void addTransition(EV evid, ST stid, AbstractTransition<RCV, EV, ST> tran) {
        transitionTable.put(new TransitionSelector<EV, ST>(evid, stid), tran);
    }

    public String toString() {
        return
            "(transitionTable: " + transitionTable + ")" ;
    }

}


