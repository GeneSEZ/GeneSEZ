package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Aes3IPqcEeGS1KtqERYUjQ) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.genesez.workflow.AbstractSlotWorkflowComponent;
import org.genesez.workflow.profile.Parameter;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public abstract class AbstractXpandWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS)
	private java.util.Set<String> aopScript = new java.util.LinkedHashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<MetaModel> metaModel = new java.util.LinkedHashSet<MetaModel>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<GlobalVarDef> globalVarDef = new java.util.LinkedHashSet<GlobalVarDef>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> emfMetaModelPackage = new java.util.HashSet<String>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._jVgogPqdEeGS1KtqERYUjQ) ENABLED START */
		if (!emfMetaModelPackage.isEmpty()) {
			for (String p : emfMetaModelPackage) {
				EmfMetaModel emm = new EmfMetaModel();
				emm.setMetaModelPackage(p);
				metaModel.add(emm);
			}
		}
		if (metaModel.isEmpty()) {
			issues.addError(this, "Workflow parameter 'metaModel' or 'emfMetaModelPackage' is missing!", metaModel);
		}
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	name	
	 * @param	value	
	 */
	public void addGlobalVarDef(String name, String value) {
		/* PROTECTED REGION ID(java.implementation._uiyqUP4AEeGA35ujkRyC6w) ENABLED START */
		GlobalVarDef gvd = new GlobalVarDef();
		gvd.setName(name);
		gvd.setValue("'" + value + "'");
		globalVarDef.add(gvd);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	name	
	 * @param	value	
	 */
	public void addGlobalVarDef(String name, Object value) {
		/* PROTECTED REGION ID(java.implementation._v14C0P4AEeGA35ujkRyC6w) ENABLED START */
		GlobalVarDef gvd = new GlobalVarDef();
		gvd.setName(name);
		gvd.setValue(String.valueOf(value));
		globalVarDef.add(gvd);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>aopScript</b></em>'
	 */
	public java.util.Set<String> getAopScript() {
		return aopScript;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>aopScript</b></em>'.
	 * @param	aopScript	the value to add
	 */
	public void addAopScript(String aopScript) {
		this.aopScript.add(aopScript);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>aopScript</b></em>'.
	 * @param	aopScript	the value to remove
	 */
	public void removeAopScript(String aopScript) {
		this.aopScript.remove(aopScript);
	}
	
	/**
	 * Returns the value of attribute '<em><b>metaModel</b></em>'
	 */
	public java.util.Set<MetaModel> getMetaModel() {
		return metaModel;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to add
	 */
	public void addMetaModel(MetaModel metaModel) {
		this.metaModel.add(metaModel);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to remove
	 */
	public void removeMetaModel(MetaModel metaModel) {
		this.metaModel.remove(metaModel);
	}
	
	/**
	 * Returns the value of attribute '<em><b>globalVarDef</b></em>'
	 */
	public java.util.Set<GlobalVarDef> getGlobalVarDef() {
		return globalVarDef;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>globalVarDef</b></em>'.
	 * @param	globalVarDef	the value to add
	 */
	public void addGlobalVarDef(GlobalVarDef globalVarDef) {
		this.globalVarDef.add(globalVarDef);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>globalVarDef</b></em>'.
	 * @param	globalVarDef	the value to remove
	 */
	public void removeGlobalVarDef(GlobalVarDef globalVarDef) {
		this.globalVarDef.remove(globalVarDef);
	}
	
	/**
	 * Returns the value of attribute '<em><b>emfMetaModelPackage</b></em>'
	 */
	public java.util.Set<String> getEmfMetaModelPackage() {
		return emfMetaModelPackage;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>emfMetaModelPackage</b></em>'.
	 * @param	emfMetaModelPackage	the value to add
	 */
	public void addEmfMetaModelPackage(String emfMetaModelPackage) {
		this.emfMetaModelPackage.add(emfMetaModelPackage);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>emfMetaModelPackage</b></em>'.
	 * @param	emfMetaModelPackage	the value to remove
	 */
	public void removeEmfMetaModelPackage(String emfMetaModelPackage) {
		this.emfMetaModelPackage.remove(emfMetaModelPackage);
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._Aes3IPqcEeGS1KtqERYUjQ) ENABLED START */
	/* PROTECTED REGION END */
	
	// -- nested classifier -------------------------------------------------
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdAopScript {
		
		// -- generated elements ------------------------------------------------
		String[] value();
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._69m7gPk6EeG9kdm-OL78lQ_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdMetaModel {
		
		// -- generated elements ------------------------------------------------
		String[] value();
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._rcLqIPqcEeGS1KtqERYUjQ_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdGlobalVarDef {
		
		// -- generated elements ------------------------------------------------
		String[] name();
		
		String[] value();
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._t_Z00PqcEeGS1KtqERYUjQ_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdEmfMetaModelPackage {
		
		// -- generated elements ------------------------------------------------
		String[] value();
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._8F2lgP3mEeGA35ujkRyC6w_annotation) ENABLED START */
		// TODO: put your own implementation code here
		/* PROTECTED REGION END */
	}
	
}
