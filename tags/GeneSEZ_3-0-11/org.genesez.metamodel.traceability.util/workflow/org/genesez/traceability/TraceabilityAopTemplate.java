package org.genesez.traceability;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_qDTPMI_XEeK_rM5VK2SGEA) 
 */
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.genesez.workflow.Model2Text;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class TraceabilityAopTemplate extends AbstractTraceabilityTransformable implements Model2Text {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		result = result && super.validate();
		return result;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._qDTPMI_XEeK_rM5VK2SGEA) ENABLED START */
	/* PROTECTED REGION END */
}
