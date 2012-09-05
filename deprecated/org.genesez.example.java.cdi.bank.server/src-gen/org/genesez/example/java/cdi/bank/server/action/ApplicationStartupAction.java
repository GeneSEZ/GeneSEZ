package org.genesez.example.java.cdi.bank.server.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1293549670821_189430_387) 
 */

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.genesez.example.java.cdi.bank.qualifier.Logging;
import org.genesez.example.java.cdi.bank.server.event.ApplicationStartedEvent;

/**
 */

@ApplicationScoped
@Startup
@Logging
public class ApplicationStartupAction implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Date startTime;
	
	@Inject
	@Any
	private Event<ApplicationStartedEvent> applicationStartedEvent;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ApplicationStartupAction</b></em>'.
	 */
	
	public ApplicationStartupAction() {
		/* PROTECTED REGION ID(java.constructor._16_0_1_41601a3_1293644799162_29491_931) ENABLED START */
		
		startTime = new Date();
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	
	@PostConstruct
	public void perform() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1293549758707_909539_412) ENABLED START */
		
		applicationStartedEvent.fire(new ApplicationStartedEvent());
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1293549670821_189430_387) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
