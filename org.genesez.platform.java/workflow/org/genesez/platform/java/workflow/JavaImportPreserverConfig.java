package org.genesez.platform.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_xsgQ0IvoEeKyp9GO00JvUQ) 
 */
import org.genesez.m2t.cp.ImportPreserverConfig;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class JavaImportPreserverConfig extends ImportPreserverConfig {
	
	/**
	 * Constructor for class '<em><b>JavaImportPreserverConfig</b></em>'.
	 */
	public JavaImportPreserverConfig() {
		/* PROTECTED REGION ID(java.constructor._Gogx4IchEeKkPZ9HV4VaKQ) ENABLED START */
		super(".*(\\.java)$", "(import)\\s+.*;$");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._xsgQ0IvoEeKyp9GO00JvUQ) ENABLED START */
	/* PROTECTED REGION END */
}
