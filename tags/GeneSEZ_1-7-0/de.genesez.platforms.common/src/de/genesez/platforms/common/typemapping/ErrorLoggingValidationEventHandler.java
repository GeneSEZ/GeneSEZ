package de.genesez.platforms.common.typemapping;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Custom ValidationEventHandler to log warnings and errors during the
 * validation of the xml file. The unmarshalling will be cancelled if an error
 * occurs
 * 
 * @author pethu
 * @date 2009-01-24
 */
public class ErrorLoggingValidationEventHandler implements ValidationEventHandler {
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private final Log log = LogFactory.getLog(getClass());

	/**
	 * To handle all events occured during the validation
	 * 
	 * @return any false result will abort the validation immediately
	 */
	public boolean handleEvent(ValidationEvent validationError) {
		switch (validationError.getSeverity()) {
			case ValidationEvent.WARNING:
				if (validationError.getMessage() != null) {
					logValidation(validationError.getSeverity(),
							validationError);
				}
				return true;
			case ValidationEvent.ERROR:
			case ValidationEvent.FATAL_ERROR:
				logValidation(ValidationEvent.ERROR, validationError);
				return false;
			default:
				return false;
		}
	}

	/**
	 * Method to log the event depending on the specific LogLevel
	 * 
	 * @param lvl
	 *            LogLevel of the event
	 * @param event
	 *            ValidationEvent which occured during the Validation
	 */
	private void logValidation(int lvl, ValidationEvent event) {
		StringBuilder message = new StringBuilder("Validation Problem: ");
		message.append(event.getMessage() + "\n");
		message.append("line: " + event.getLocator().getLineNumber()
				+ " column: " + event.getLocator().getColumnNumber());
		switch (lvl) {
			case ValidationEvent.WARNING:
				log.warn(message);
				break;
			case ValidationEvent.ERROR:
				message.append("\nUnmarshalling cancelled");
				log.error(message);
				break;
		}
	}
}
