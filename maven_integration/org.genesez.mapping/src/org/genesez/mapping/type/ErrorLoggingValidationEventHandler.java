package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324558036531_571419_4561) 
 */

import javax.xml.bind.ValidationEventHandler;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import javax.xml.bind.ValidationEvent;

/**
 * Custom ValidationEventHandler to log warnings and errors during the validation of the XML type mapping file. 
 * The unmarshalling will be cancelled if an error occurs.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public class ErrorLoggingValidationEventHandler implements ValidationEventHandler {
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private Log log = LogFactory.getLog(getClass());
	
	/**
	 * To handle all events occured during the validation
	 * @param	validationError	
	 * @return	any false result will abort the validation immediately
	 */
	public boolean handleEvent(ValidationEvent validationError) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324558180426_535497_4708) ENABLED START */
		switch (validationError.getSeverity()) {
			case ValidationEvent.WARNING:
				if (validationError.getMessage() != null) {
					logValidation(validationError.getSeverity(), validationError);
				}
				return true;
			case ValidationEvent.ERROR:
			case ValidationEvent.FATAL_ERROR:
				logValidation(ValidationEvent.ERROR, validationError);
				return false;
			default:
				return false;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method to log the event depending on the specific LogLevel
	 * @param	lvl	 LogLevel of the event
	 * @param	event	ValidationEvent which occured during the Validation
	 */
	private void logValidation(int lvl, ValidationEvent event) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324558273491_273987_4722) ENABLED START */
		StringBuilder message = new StringBuilder("Validation Problem: ");
		message.append(event.getMessage() + "\n");
		message.append("line: " + event.getLocator().getLineNumber() + " column: " + event.getLocator().getColumnNumber());
		switch (lvl) {
			case ValidationEvent.WARNING:
				log.warn(message);
				break;
			case ValidationEvent.ERROR:
				message.append("\nUnmarshalling cancelled");
				log.error(message);
				break;
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324558036531_571419_4561) ENABLED START */
	/* PROTECTED REGION END */
	
}
