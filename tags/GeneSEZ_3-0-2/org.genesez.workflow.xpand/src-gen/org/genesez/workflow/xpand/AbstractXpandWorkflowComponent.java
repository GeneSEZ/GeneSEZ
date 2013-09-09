package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Aes3IPqcEeGS1KtqERYUjQ) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.genesez.workflow.AbstractSlotWorkflowComponent;
import org.genesez.workflow.Parameter;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractXpandWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS, isTransformationParameter = true)
	private java.util.Set<String> aopScript = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<MetaModel> metaModel = new java.util.LinkedHashSet<MetaModel>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<GlobalVarDef> globalVarDef = new java.util.LinkedHashSet<GlobalVarDef>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> emfMetaModelPackage = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String xtendNamingFile;
	
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
	 */
	public void addGlobalVarDef(String name, Object value) {
		/* PROTECTED REGION ID(java.implementation._v14C0P4AEeGA35ujkRyC6w) ENABLED START */
		GlobalVarDef gvd = new GlobalVarDef();
		gvd.setName(name);
		gvd.setValue(String.valueOf(value));
		globalVarDef.add(gvd);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addGlobalVarDefs(java.util.Set<Parameter> parameter) {
		/* PROTECTED REGION ID(java.implementation._WPosAIl3EeKRAcdOy_Za0Q) ENABLED START */
		// aggregate multi value parameters
		Map<String, List<? super Object>> aggr = new LinkedHashMap<String, List<? super Object>>();
		for (Parameter p : parameter) {
			String key = p.getName();
			List<? super Object> value;
			if (aggr.containsKey(key)) {
				value = aggr.get(key);
			} else {
				value = new ArrayList<>();
			}
			value.add(p.getValue());
			aggr.put(key, value);
		}
		// add parameters as global variables
		for (Map.Entry<String, List<? super Object>> me : aggr.entrySet()) {
			List<? super Object> values = me.getValue();
			if (values.size() == 1) {
				Object o = values.get(0);
				if (o instanceof String) {
					addGlobalVarDef(me.getKey(), (String) o);
				} else {
					addGlobalVarDef(me.getKey(), o);
				}
			} else {
				addGlobalVarDef(me.getKey(), listToString(values));
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>aopScript</b></em>'.
	 */
	public java.util.Set<String> getAopScript() {
		return aopScript;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>aopScript</b></em>'.
	 * @param	aopScript	the value to add.
	 */
	public void addAopScript(String aopScript) {
		this.aopScript.add(aopScript);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>aopScript</b></em>'.
	 * @param	aopScript	the value to remove.
	 */
	public void removeAopScript(String aopScript) {
		this.aopScript.remove(aopScript);
	}
	
	/**
	 * Returns the value of attribute '<em><b>metaModel</b></em>'.
	 */
	public java.util.Set<MetaModel> getMetaModel() {
		return metaModel;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to add.
	 */
	public void addMetaModel(MetaModel metaModel) {
		this.metaModel.add(metaModel);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to remove.
	 */
	public void removeMetaModel(MetaModel metaModel) {
		this.metaModel.remove(metaModel);
	}
	
	/**
	 * Returns the value of attribute '<em><b>globalVarDef</b></em>'.
	 */
	public java.util.Set<GlobalVarDef> getGlobalVarDef() {
		return globalVarDef;
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>globalVarDef</b></em>'.
	 * @param	globalVarDef	the value to remove.
	 */
	public void removeGlobalVarDef(GlobalVarDef globalVarDef) {
		this.globalVarDef.remove(globalVarDef);
	}
	
	/**
	 * Returns the value of attribute '<em><b>emfMetaModelPackage</b></em>'.
	 */
	public java.util.Set<String> getEmfMetaModelPackage() {
		return emfMetaModelPackage;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>emfMetaModelPackage</b></em>'.
	 * @param	emfMetaModelPackage	the value to add.
	 */
	public void addEmfMetaModelPackage(String emfMetaModelPackage) {
		this.emfMetaModelPackage.add(emfMetaModelPackage);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>emfMetaModelPackage</b></em>'.
	 * @param	emfMetaModelPackage	the value to remove.
	 */
	public void removeEmfMetaModelPackage(String emfMetaModelPackage) {
		this.emfMetaModelPackage.remove(emfMetaModelPackage);
	}
	
	/**
	 * Returns the value of attribute '<em><b>xtendNamingFile</b></em>'.
	 */
	public String getXtendNamingFile() {
		return xtendNamingFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>xtendNamingFile</b></em>'.
	 * @param	xtendNamingFile	the value to set.
	 */
	public void setXtendNamingFile(String xtendNamingFile) {
		this.xtendNamingFile = xtendNamingFile;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._Aes3IPqcEeGS1KtqERYUjQ) ENABLED START */
	/* PROTECTED REGION END */
}
