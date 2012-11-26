package jsf.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * @author georg beier
 * 
 *         utility class that makes access to JSF environment features a bit
 *         easier
 * 
 */
public class FacesHelper {

	/**
	 * try to access a managed bean by its name
	 * 
	 * @param beanName
	 *            name of bean as defined in faces-config or bean annotations
	 * @return managed bean object, if found
	 */
	public static Object getBean(String beanName) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Object obj = fc.getApplication().getELResolver().getValue(fc.getELContext(), null, beanName);
		return obj;
	}

	/**
	 * put an error message into the current request
	 * 
	 * @param shortMessage
	 *            short display string
	 * @param fullMessage
	 *            full display string
	 * @param severity
	 *            qualifies message: INFO, WARN, ERROR, FATAL
	 */
	public static void notifyMessage(String shortMessage, String fullMessage,
			FacesMessage.Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, shortMessage,
				fullMessage);
		context.addMessage(null, message);
	}

}
