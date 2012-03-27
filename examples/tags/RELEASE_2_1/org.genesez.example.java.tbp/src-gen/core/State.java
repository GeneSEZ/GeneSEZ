package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231923141062_436418_512) 
 */

import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Represents the <b><i>progress</i></b> of a unit of work and indicates if 
 * it needs further attention. The usual life cycle of a unit of work is 
 * usually: todo -&gt; in progress -&gt; done.
 * @author nicher
 */
public enum State {
	
	// -- enumeration literals ----------------------------------------------
	
	/**
	 * Indicates that the work has <b><i>not</i></b> started yet and the unit of 
	 * work has to be completed in the future.
	 */
	TODO,
	/**
	 * Indicates that the work of a unit has already <b><i>started</i></b> and 
	 * needs <b><i>further</i></b> attention too.
	 */
	IN_PROGRESS,
	/**
	 * Indicates that the unit of work is <b><i>finished</i></b> and do <b><i>not</i></b> 
	 * need further attention.
	 */
	DONE;
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.enumeration.own.code.implementation._16_0_b6f02e1_1231923141062_436418_512) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
