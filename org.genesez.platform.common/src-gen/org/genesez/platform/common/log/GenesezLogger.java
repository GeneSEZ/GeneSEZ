package org.genesez.platform.common.log;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324549222709_524114_2594) 
 */

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * Logging Wrapper around apache commons logging to provide support for logging to all GeneSEZ openArchitectureWare scripts
 * 
 * @author	toh
 * @date	2008-05-08
 */
public class GenesezLogger {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * holds the current used logger
	 */
	private static Log logger = LogFactory.getLog("GeneSEZ");
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * selects a logger to use
	 * @param	logger	the name of the logger to use
	 */
	
	public static void selectLogger(String logger) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549589812_654105_2663) ENABLED START */
		GenesezLogger.logger = LogFactory.getLog(logger);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'fatal' log level
	 * @param	message	the message to log
	 */
	
	public static void fatal(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549610379_117349_2671) ENABLED START */
		logger.fatal(message);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'error' log level
	 * @param	message	the message to log
	 */
	
	public static void error(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549622212_780114_2678) ENABLED START */
		logger.error(message);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'warn' log level
	 * @param	message	the message to log
	 */
	
	public static void warn(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549636049_172544_2685) ENABLED START */
		logger.warn(message);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'info' log level
	 * @param	message	the message to log
	 */
	
	public static void info(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549645835_354113_2692) ENABLED START */
		logger.info(message);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'debug' log level
	 * @param	message	the message to log
	 */
	
	public static void debug(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549660546_925650_2700) ENABLED START */
		logger.debug(message);
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs a message with 'trace' log level
	 * @param	message	the message to log
	 */
	
	public static void trace(String message) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549669350_559477_2707) ENABLED START */
		logger.trace(message);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324549222709_524114_2594) ENABLED START */
	/* PROTECTED REGION END */
	
}
