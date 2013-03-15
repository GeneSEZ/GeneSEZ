package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_vaiVYPRiEeGG-J2DIYyoXg) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Reader;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * .WHEN_NEEDED
 */
public class EmfReader extends AbstractEmfResourceWorkflowComponent {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean makeEPackagesGlobal = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean firstElementOnly = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean ignoreMissingModel = false;
	
	private Reader reader;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._qcViMPjlEeGhK_C0J8Xzwg) ENABLED START */
		logger.trace("EMF uri map:");
		for (Entry<URI, URI> entry : URIConverter.URI_MAP.entrySet()) {
			logger.trace(entry.toString());
		}
		reader.invokeInternal(context, monitor, issues);
		Object object = context.get(getSlot());
		if (object instanceof AnyType) {
			logger.warn("The root element of the instantiated model is of type 'AnyType'! It seams your model uses a namespace URI which is not registered with the corresponding EPackage of your meta model in the EMF EPackage Registry.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._wxfmEPjoEeGhK_C0J8Xzwg) ENABLED START */
		super.checkConfiguration(issues);
		prepareDelegate();
		reader.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public String getLogMessage() {
		/* PROTECTED REGION ID(java.implementation._gvX1IP6tEeGciM7nbRm1bw) ENABLED START */
		// TODO: implementation of method 'EmfReader.getLogMessage(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>makeEPackagesGlobal</b></em>'.
	 */
	public boolean getMakeEPackagesGlobal() {
		return makeEPackagesGlobal;
	}
	
	/**
	 * Sets the value of attribute '<em><b>makeEPackagesGlobal</b></em>'.
	 * @param	makeEPackagesGlobal	the value to set.
	 */
	public void setMakeEPackagesGlobal(boolean makeEPackagesGlobal) {
		this.makeEPackagesGlobal = makeEPackagesGlobal;
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstElementOnly</b></em>'.
	 */
	public boolean getFirstElementOnly() {
		return firstElementOnly;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstElementOnly</b></em>'.
	 * @param	firstElementOnly	the value to set.
	 */
	public void setFirstElementOnly(boolean firstElementOnly) {
		this.firstElementOnly = firstElementOnly;
	}
	
	/**
	 * Returns the value of attribute '<em><b>ignoreMissingModel</b></em>'.
	 */
	public boolean getIgnoreMissingModel() {
		return ignoreMissingModel;
	}
	
	/**
	 * Sets the value of attribute '<em><b>ignoreMissingModel</b></em>'.
	 * @param	ignoreMissingModel	the value to set.
	 */
	public void setIgnoreMissingModel(boolean ignoreMissingModel) {
		this.ignoreMissingModel = ignoreMissingModel;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "makeEPackagesGlobal")
	public boolean getDefaultMakeEPackagesGlobal() {
		return true;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "firstElementOnly")
	public boolean getDefaultFirstElementOnly() {
		return true;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "ignoreMissingModel")
	public boolean getDefaultIgnoreMissingModel() {
		return false;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._vaiVYPRiEeGG-J2DIYyoXg) ENABLED START */
	private void prepareDelegate() {
		reader = new Reader();
		reader.setUri(getUri());
		reader.setModelSlot(getSlot());
		reader.setFirstElementOnly(firstElementOnly);
		reader.setIgnoreMissingModel(ignoreMissingModel);
		reader.setMakeEPackagesGlobal(makeEPackagesGlobal);
		//reader.setResourceSet( getResourceSet() );
		reader.setSkipOnErrors(getAbortOnError());
		reader.setUseSingleGlobalResourceSet(getUseSingleGlobalResourceSet());
	}
	
	/* PROTECTED REGION END */
}
