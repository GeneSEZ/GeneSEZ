package de.genesez.platforms.java.umlsupport.statemachine;

/**
* @author: georg beier 
* @version: $Revision: 1.1 $
*/
public interface EventReceiver<EV> {

    void takeEvent(EventQueue.Event<EV> ev);
}

