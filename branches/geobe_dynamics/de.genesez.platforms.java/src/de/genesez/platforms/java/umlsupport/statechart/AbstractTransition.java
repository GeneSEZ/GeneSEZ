package de.genesez.platforms.java.umlsupport.statechart;

/**
* @author: georg beier
* @version: $Revision: 1.1 $
*/
public interface AbstractTransition<RCV, EV, ST> {
    ST exec(EventQueue.Event<EV> ev, RCV onObj);
}

