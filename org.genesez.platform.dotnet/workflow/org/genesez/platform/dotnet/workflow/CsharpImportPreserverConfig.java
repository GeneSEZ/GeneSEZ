package org.genesez.platform.dotnet.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_fpT60IpsEeKeCsuOoxdEcQ) 
 */
import org.genesez.m2t.cp.ImportPreserverConfig;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class CsharpImportPreserverConfig extends ImportPreserverConfig {
	
	/**
	 * Constructor for class '<em><b>CsharpImportPreserverConfig</b></em>'.
	 */
	public CsharpImportPreserverConfig() {
		/* PROTECTED REGION ID(java.constructor._i3K98IpsEeKeCsuOoxdEcQ) ENABLED START */
		super(".*(\\.cs)$", "(using)\\s+.*;$");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._fpT60IpsEeKeCsuOoxdEcQ) ENABLED START */
	/* PROTECTED REGION END */
}
