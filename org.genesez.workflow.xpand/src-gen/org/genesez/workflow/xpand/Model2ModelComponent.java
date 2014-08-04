package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_IInokPLKEeGYwYEQM4LYvw) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.Model2Model;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Model2ModelComponent extends AbstractXpandWorkflowComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String outputSlot;
	
	private CompositeComponent compositeXtend;
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private Model2Model model2model;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._QITJ0Pn6EeG2esQ-bp2d2A) ENABLED START */
		super.invokeInternal(context, monitor, issues);
		// init naming mapper
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		for (GlobalVarDef globalVarDef : getGlobalVarDef()) {
			globalVars.put(globalVarDef.getName(), new Variable(globalVarDef.getName(), globalVarDef.getValue()));
		}
		ExecutionContext namingCtx = new ExecutionContextImpl(new TypeSystemImpl(), globalVars);
		// NameMapper.initNameMapper(xtendNamingFile, namingCtx, getMetaModel());
		
		// invoke
		compositeXtend.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._M-BmMPn6EeG2esQ-bp2d2A) ENABLED START */
		if (model2model == null) {
			issues.addError(this, "Workflow parameter 'model2model' is missing!", model2model);
		}
		if (outputSlot == null || outputSlot.isEmpty()) {
			outputSlot = WorkflowContext.DEFAULT_SLOT;
			issues.addInfo(this, "Using default model slot for workflow parameter 'outputSlot'.", outputSlot);
		}
		if (!model2model.validate()) {
			issues.addError(this, "Model2Model is not valid!", model2model);
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		compositeXtend.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public String getLogMessage() {
		/* PROTECTED REGION ID(java.implementation._-er9sP6tEeGciM7nbRm1bw) ENABLED START */
		// TODO: implementation of method 'Model2ModelComponent.getLogMessage(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>outputSlot</b></em>'.
	 */
	public String getOutputSlot() {
		return outputSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputSlot</b></em>'.
	 * @param	outputSlot	the value to set.
	 */
	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>model2model</b></em>'.
	 */
	public Model2Model getModel2model() {
		return model2model;
	}
	
	/**
	 * Sets the value of attribute '<em><b>model2model</b></em>'.
	 * @param	model2model	the value to set.
	 */
	public void setModel2model(Model2Model model2model) {
		this.model2model = model2model;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._IInokPLKEeGYwYEQM4LYvw) ENABLED START */
	private void prepareDelegate() {
		compositeXtend = new CompositeComponent(getClass().getName());
		XtendComponent xc = new XtendComponent();
		// parameters
		addGlobalVarDefs(model2model.getParameter());
		// component properties
		xc.setSkipOnErrors(getAbortOnError());
		for (MetaModel mm : getMetaModel()) {
			xc.addMetaModel(mm);
		}
		for (String a : getAopScript()) {
			xc.addExtensionAdvice(a);
		}
		for (GlobalVarDef def : getGlobalVarDef()) {
			xc.addGlobalVarDef(def);
		}
		xc.setOutputSlot(outputSlot);
		xc.setInvoke(model2model.getScript() + "(" + getSlot() + ")");
		compositeXtend.addComponent(xc);
	}
	/* PROTECTED REGION END */
}
