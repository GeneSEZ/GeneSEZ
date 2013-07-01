package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1293549670821_189430_387) 
 */
import java.util.Date;

import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;

import javax.enterprise.inject.Any;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@ApplicationScoped
@Startup
@Logging
public class ApplicationStartupAction implements Serializable {
	
	private Date startTime;
	
	@Inject
	@Any
	private Event<ApplicationStartedEvent> applicationStartedEvent;
	
	/**
	 * Constructor for class '<em><b>ApplicationStartupAction</b></em>'.
	 */
	
	public ApplicationStartupAction() {
		/* PROTECTED REGION ID(java.constructor._16_0_1_41601a3_1293644799162_29491_931) ENABLED START */
		
		startTime = new Date();
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@PostConstruct
	public void perform() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1293549758707_909539_412) ENABLED START */
		
		applicationStartedEvent.fire(new ApplicationStartedEvent());
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1293549670821_189430_387) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
