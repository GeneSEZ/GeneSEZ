package org.genesez.platform.php.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_PvBWcIpuEeKeCsuOoxdEcQ) 
 */
import org.genesez.m2t.cp.ImportPreserverConfig;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class PhpImportPreserveConfig extends ImportPreserverConfig {
	
	/**
	 * Constructor for class '<em><b>PhpImportPreserveConfig</b></em>'.
	 */
	public PhpImportPreserveConfig() {
		/* PROTECTED REGION ID(java.constructor._Nct8oIpuEeKeCsuOoxdEcQ) ENABLED START */
		super(".*(\\.php)$", "(require|include|require_once|include_once)\\s+.*;$");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._PvBWcIpuEeKeCsuOoxdEcQ) ENABLED START */
	/* PROTECTED REGION END */
}
