package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_NEnv4PLHEeGYwYEQM4LYvw) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.Transformable;
import org.genesez.workflow.Validator;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ValidatorComponent extends AbstractXpandWorkflowComponent {
	
	private CompositeComponent compositeCheck;
	
	@WfParameter(isRequired = true, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<Validator> validator = new java.util.LinkedHashSet<Validator>();
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._U869MPk7EeG9kdm-OL78lQ) ENABLED START */
		// init naming mapper
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		for (GlobalVarDef globalVarDef : getGlobalVarDef()) {
			globalVars.put(globalVarDef.getName(), new Variable(globalVarDef.getName(), globalVarDef.getValue()));
		}
		ExecutionContext namingCtx = new ExecutionContextImpl(new TypeSystemImpl(), globalVars);
		//		NameMapper.initNameMapper(xtendNamingFile, namingCtx, getMetaModel());
		
		// invoke
		compositeCheck.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Q-Z5MPk7EeG9kdm-OL78lQ) ENABLED START */
		if (validator.isEmpty()) {
			issues.addError(this, "Workflow parameter 'validator' is missing!", validator);
		}
		// ensure valid transformables
		for (Transformable t : validator) {
			if (!t.validate()) {
				issues.addError(this, "Validator is not valid!", t);
			}
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		compositeCheck.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>validator</b></em>'.
	 */
	public java.util.Set<Validator> getValidator() {
		return validator;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>validator</b></em>'.
	 * @param	validator	the value to add.
	 */
	public void addValidator(Validator validator) {
		this.validator.add(validator);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>validator</b></em>'.
	 * @param	validator	the value to remove.
	 */
	public void removeValidator(Validator validator) {
		this.validator.remove(validator);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._NEnv4PLHEeGYwYEQM4LYvw) ENABLED START */
	private void prepareDelegate() {
		compositeCheck = new CompositeComponent(getClass().getName());
		for (Validator v : validator) {
			CheckComponent cc = new CheckComponent();
			// transformable properties
			addGlobalVarDefs(v.getParameter());
			cc.addCheckFile(v.getScript());
			// component properties
			cc.setAbortOnError(getAbortOnError());
			cc.setEmfAllChildrenSlot(getSlot());
			for (MetaModel mm : getMetaModel()) {
				cc.addMetaModel(mm);
			}
			for (String s : getAopScript()) {
				cc.addExtensionAdvice(s);
			}
			for (GlobalVarDef def : getGlobalVarDef()) {
				cc.addGlobalVarDef(def);
			}
			compositeCheck.addComponent(cc);
		}
	}
	/* PROTECTED REGION END */
}
