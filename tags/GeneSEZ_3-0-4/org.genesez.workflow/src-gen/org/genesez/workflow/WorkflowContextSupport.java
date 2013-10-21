package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_AGHvgI-_EeK_rM5VK2SGEA) 
 */
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class WorkflowContextSupport {
	
	private static WorkflowContext mweWfContext;
	
	private static IWorkflowContext mwe2WfContext;
	
	/**
	 * Method stub for further implementation.
	 */
	public static void update(WorkflowContext wfcontext) {
		/* PROTECTED REGION ID(java.implementation._LFmU0I-_EeK_rM5VK2SGEA) ENABLED START */
		mweWfContext = wfcontext;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public static void update(IWorkflowContext wfcontext) {
		/* PROTECTED REGION ID(java.implementation._6wEl8I_AEeK_rM5VK2SGEA) ENABLED START */
		mwe2WfContext = wfcontext;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public static Object getSlot(String name) {
		/* PROTECTED REGION ID(java.implementation._OKvg0I-_EeK_rM5VK2SGEA) ENABLED START */
		Object result = null;
		if (mweWfContext != null) {
			result = mweWfContext.get(name);
		}
		if (mwe2WfContext != null) {
			result = mwe2WfContext.get(name);
		}
		return result;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._AGHvgI-_EeK_rM5VK2SGEA) ENABLED START */
	/* PROTECTED REGION END */
}
