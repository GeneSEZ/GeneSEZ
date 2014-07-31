package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_khAd0IpREeK8mZXbW9KccQ) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.Model2Model;
import org.genesez.workflow.Transformable;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ModelModificationComponent extends AbstractXpandWorkflowComponent {
	
	private CompositeComponent compositeXtend;
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<Model2Model> model2model = new java.util.LinkedHashSet<Model2Model>();
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._VgM7oIpSEeK8mZXbW9KccQ) ENABLED START */
		if (model2model.isEmpty()) {
			issues.addError(this, "Workflow parameter 'model2model' is missing!", model2model);
		}
		for (Transformable t : model2model) {
			if (!t.validate()) {
				issues.addError(this, "Model2Model is not valid!", t);
			}
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		compositeXtend.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._VgM7pIpSEeK8mZXbW9KccQ) ENABLED START */
		super.invokeInternal(context, monitor, issues);
		compositeXtend.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>model2model</b></em>'.
	 */
	public java.util.Set<Model2Model> getModel2model() {
		return model2model;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>model2model</b></em>'.
	 * @param	model2model	the value to add.
	 */
	public void addModel2model(Model2Model model2model) {
		this.model2model.add(model2model);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>model2model</b></em>'.
	 * @param	model2model	the value to remove.
	 */
	public void removeModel2model(Model2Model model2model) {
		this.model2model.remove(model2model);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._khAd0IpREeK8mZXbW9KccQ) ENABLED START */
	protected void prepareDelegate() {
		compositeXtend = new CompositeComponent(getClass().getName());
		for (Model2Model m2m : model2model) {
			XtendComponent xc = new XtendComponent();
			// transformable parameter
			addGlobalVarDefs(m2m.getParameter());
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
			xc.setOutputSlot(WorkflowContext.DEFAULT_SLOT);
			xc.setInvoke(m2m.getScript() + "(" + getSlot() + ")");
			compositeXtend.addComponent(xc);
		}
	}
	/* PROTECTED REGION END */
}
