package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_paljEPU8EeGsV8fV-DCYeA) 
 */

import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.Mwe2Bridge;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public abstract class AbstractWorkflowComponent extends org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent implements WorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Specifies the execution in case of errors.
	 */
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean abortOnError = true;
	
	// -- generated method declarations -------------------------------------
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected abstract void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Provides the mwe2 execution wrapper.
	 * @return	
	 */
	protected Mwe2Bridge getBridge() {
		/* PROTECTED REGION ID(java.implementation._135mEPVBEeGsV8fV-DCYeA) ENABLED START */
		return super.getBridge();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Specifies the execution in case of errors.
	 */
	public boolean getAbortOnError() {
		return abortOnError;
	}
	
	/**
	 * Specifies the execution in case of errors.
	 */
	public void setAbortOnError(boolean abortOnError) {
		this.abortOnError = abortOnError;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._paljEPU8EeGsV8fV-DCYeA) ENABLED START */
	protected String listToString(Collection<? extends Object> list) {
		StringBuilder sb = new StringBuilder();
		Iterator<? extends Object> it = list.iterator();
		while (it.hasNext()) {
			String item = it.next().toString();
			if (item.startsWith("'")) {
				item = item.substring(1, item.length() - 1);
			}
			sb.append(item);
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/* PROTECTED REGION END */
	
}
