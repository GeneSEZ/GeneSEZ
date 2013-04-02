package org.genesez.traceability;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_syfZYI8TEeKpNoiOVa6Abg) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.metamodel.gtrace.AdaptedFactoryActivator;
import org.genesez.workflow.AbstractSlotWorkflowComponent;
import org.genesez.workflow.EmfReader;
import org.genesez.workflow.EmfWriter;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class TraceabilityComponent extends AbstractSlotWorkflowComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gcoreModelSlot = "coremodel";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String greqModelSlot = "reqmodel";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gtraceModelSlot = "tracemodel";
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gcoreModelFile;
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String greqModelFile;
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gtraceModelFile;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean useModelExtensionsForCrossModelNavigation = false;
	
	private CompositeComponent delegate;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean useDefaultUriMapping = true;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._aEjouI8VEeKpNoiOVa6Abg) ENABLED START */
		if (gcoreModelFile == null) {
			issues.addError(this, "Workflow parameter 'gcoreModelFile' is missing!", gcoreModelFile);
		}
		if (greqModelFile == null) {
			issues.addError(this, "Workflow parameter 'greqModelFile' is missing!", greqModelFile);
		}
		if (gtraceModelFile == null) {
			issues.addError(this, "Workflow parameter 'gtraceModelFile' is missing!", gtraceModelFile);
		}
		
		// setup
		delegate = new CompositeComponent(getClass().getName());
		EmfWriter writer = new EmfWriter();
		writer.setSlot(gcoreModelSlot);
		writer.setFile(gcoreModelFile);
		delegate.addComponent(writer);
		EmfReader reqR = new EmfReader();
		reqR.setFile(greqModelFile);
		reqR.setSlot(greqModelSlot);
		delegate.addComponent(reqR);
		EmfReader traceR = new EmfReader();
		traceR.setFile(gtraceModelFile);
		traceR.setSlot(gtraceModelSlot);
		delegate.addComponent(traceR);
		
		// delegate
		delegate.checkConfiguration(issues);
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._aEjosI8VEeKpNoiOVa6Abg) ENABLED START */
		super.invokeInternal(context, monitor, issues);
		if (useDefaultUriMapping) {
			// register uri mappings for gcore + greq models with the following pattern:
			// model file name -> path to model file
			Path path = Paths.get(gcoreModelFile);
			URI from = URI.createURI(path.getFileName().toString());
			URI to = URI.createURI(gcoreModelFile);
			URIConverter.URI_MAP.put(from, to);
			path = Paths.get(greqModelFile);
			from = URI.createURI(path.getFileName().toString());
			to = URI.createURI(greqModelFile);
			URIConverter.URI_MAP.put(from, to);
		}
		if (useModelExtensionsForCrossModelNavigation) {
			AdaptedFactoryActivator.enable();
		}
		delegate.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "gcoreModelSlot")
	public String getDefaultGcoreModelSlot() {
		return "coremodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "greqModelSlot")
	public String getDefaultGreqModelSlot() {
		return "reqmodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "gtraceModelSlot")
	public String getDefaultGtraceModelSlot() {
		return "tracemodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "useModelExtensionsForCrossModelNavigation")
	public boolean getDefaultUseModelExtensionsForCrossModelNavigation() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "useDefaultUriMapping")
	public boolean getDefaultUseDefaultUriMapping() {
		return true;
	}
	
	/**
	 * Returns the value of attribute '<em><b>gcoreModelSlot</b></em>'.
	 */
	public String getGcoreModelSlot() {
		return gcoreModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gcoreModelSlot</b></em>'.
	 * @param	gcoreModelSlot	the value to set.
	 */
	public void setGcoreModelSlot(String gcoreModelSlot) {
		this.gcoreModelSlot = gcoreModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>greqModelSlot</b></em>'.
	 */
	public String getGreqModelSlot() {
		return greqModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>greqModelSlot</b></em>'.
	 * @param	greqModelSlot	the value to set.
	 */
	public void setGreqModelSlot(String greqModelSlot) {
		this.greqModelSlot = greqModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>gtraceModelSlot</b></em>'.
	 */
	public String getGtraceModelSlot() {
		return gtraceModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gtraceModelSlot</b></em>'.
	 * @param	gtraceModelSlot	the value to set.
	 */
	public void setGtraceModelSlot(String gtraceModelSlot) {
		this.gtraceModelSlot = gtraceModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>gcoreModelFile</b></em>'.
	 */
	public String getGcoreModelFile() {
		return gcoreModelFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gcoreModelFile</b></em>'.
	 * @param	gcoreModelFile	the value to set.
	 */
	public void setGcoreModelFile(String gcoreModelFile) {
		this.gcoreModelFile = gcoreModelFile;
	}
	
	/**
	 * Returns the value of attribute '<em><b>greqModelFile</b></em>'.
	 */
	public String getGreqModelFile() {
		return greqModelFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>greqModelFile</b></em>'.
	 * @param	greqModelFile	the value to set.
	 */
	public void setGreqModelFile(String greqModelFile) {
		this.greqModelFile = greqModelFile;
	}
	
	/**
	 * Returns the value of attribute '<em><b>gtraceModelFile</b></em>'.
	 */
	public String getGtraceModelFile() {
		return gtraceModelFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gtraceModelFile</b></em>'.
	 * @param	gtraceModelFile	the value to set.
	 */
	public void setGtraceModelFile(String gtraceModelFile) {
		this.gtraceModelFile = gtraceModelFile;
	}
	
	/**
	 * Returns the value of attribute '<em><b>useModelExtensionsForCrossModelNavigation</b></em>'.
	 */
	public boolean getUseModelExtensionsForCrossModelNavigation() {
		return useModelExtensionsForCrossModelNavigation;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useModelExtensionsForCrossModelNavigation</b></em>'.
	 * @param	useModelExtensionsForCrossModelNavigation	the value to set.
	 */
	public void setUseModelExtensionsForCrossModelNavigation(boolean useModelExtensionsForCrossModelNavigation) {
		this.useModelExtensionsForCrossModelNavigation = useModelExtensionsForCrossModelNavigation;
	}
	
	/**
	 * Returns the value of attribute '<em><b>useDefaultUriMapping</b></em>'.
	 */
	public boolean getUseDefaultUriMapping() {
		return useDefaultUriMapping;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useDefaultUriMapping</b></em>'.
	 * @param	useDefaultUriMapping	the value to set.
	 */
	public void setUseDefaultUriMapping(boolean useDefaultUriMapping) {
		this.useDefaultUriMapping = useDefaultUriMapping;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._syfZYI8TEeKpNoiOVa6Abg) ENABLED START */
	/* PROTECTED REGION END */
}
