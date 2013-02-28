package org.genesez.adapter.uml2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.emf.XmiReader;
import org.eclipse.xtend.typesystem.uml2.Setup;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import org.eclipse.xtend.typesystem.uml2.profile.ProfileMetaModel;

/**
 * Performs the UML to GeneSEZ transformation
 * TODO: currently uses the deprecated XmiReader, should use instead Reader (see commented parts)
 * TODO: find why Reader does not resolve model elements from referenced uml files!
 */
public class Uml2GeneSEZ extends CompositeComponent {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
		defaults.put("umlSlot", "uml2model");
		defaults.put("ignoreValidationErrors", "false");
		defaults.put("umlCheckScript", "org::genesez::adapter::uml2::uml2constraints, org::genesez::adapter::uml2::UmlStateMachineValidation, org::genesez::adapter::uml2::Uml2GeneSezStateMachineValidation");
		defaults.put("uml2GenesezScriptCall", "org::genesez::adapter::uml2::uml2genesez::transform");
		defaults.put("excludePackages", "UML Standard Profile");
		defaults.put("mapClassesInModelToExternal", "false");
		defaults.put("externalPackages", "");
		defaults.put("externalStereotypes", "external");
		defaults.put("excludeStereotypes", "exclude");
		defaults.put("includeProfiles", "");
		defaults.put("allowGeneratedXmiGuID", "false");
	}
	
	private Properties properties = new Properties(defaults);
	private Log logger = LogFactory.getLog(getClass());
	
	private XmiReader xmiReader = new XmiReader();
//	private Reader xmiReader = new Reader();
	private CheckComponent checkComponent = new CheckComponent();
	private XtendComponent xtendComponent = new XtendComponent();
	
	private List<String> excludePackages = new ArrayList<String>();
	private List<String> externalPackages = new ArrayList<String>();
	private List<String> externalStereotypes = new ArrayList<String>();
	private List<String> excludeStereotypes = new ArrayList<String>();
	private List<String> includeProfiles = new ArrayList<String>();
	private boolean addDefaultCheckFiles = true;
	private boolean isNotSetUmlSlot = true;
	private boolean isNotSetIgnoreValidationErrors = true;
	private boolean isNotSetUml2genesezScriptCall = true;
	private boolean isNotSetOutputSlot = true;
	private boolean isNotSetExcludePackages = true;
	private boolean isNotSetMapClassesInModelToExternal = true;
	private boolean isNotSetExternalPackages = true;
	private boolean isNotSetExternalStereotypes = true;
	private boolean isNotSetExcludeStereotypes = true;
	private boolean isNotSetIncludeProfiles = true;
	private boolean isNotSetAllowGeneratedXmiGuID = true;
	
	
	/**
	 * Constructs which three component add(xmiReader, checkComponent,
	 * xtendComponent) in CompositeComponent's object. Also UML2MetaMedol and
	 * EmfMetaModel.
	 */
	public Uml2GeneSEZ() {
		super(Uml2GeneSEZ.class.getSimpleName());
		
		// uml standard setup
		Setup uml2Setup = new Setup();
		uml2Setup.setStandardUML2Setup(true);
		super.addBean(uml2Setup);
		
		// uml2 meta model
		UML2MetaModel uml2MetaModel = new UML2MetaModel();
		
		// GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		
		// GeneSEZ presentation meta model
		EmfMetaModel gpresentation = new EmfMetaModel();
		gpresentation.setMetaModelPackage(properties.getProperty("gpresentationPackage"));
		
		checkComponent.addMetaModel(uml2MetaModel);
		xtendComponent.addMetaModel(uml2MetaModel);
		xtendComponent.addMetaModel(gcore);
		xtendComponent.addMetaModel(gpresentation);
		
		super.addComponent(xmiReader);
		super.addComponent(checkComponent);
		super.addComponent(xtendComponent);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see org.openarchitectureware.workflow.WorkflowComponent#checkConfiguration(org.openarchitectureware.workflow.issues.Issues)
	 */
	public void checkConfiguration(Issues issues) {
		if (isNotSetUmlSlot) {
			setUmlSlot(properties.getProperty("umlSlot"));
		}
		if (isNotSetUml2genesezScriptCall) {
			xtendComponent.setInvoke(
					properties.getProperty("uml2GenesezScriptCall") + "(" + properties.getProperty("umlSlot") + ")");
		}
		if (isNotSetIgnoreValidationErrors) {
			setIgnoreValidationErrors(new Boolean(properties.getProperty("ignoreValidationErrors")));
		}
		if (addDefaultCheckFiles) {
			String files = properties.getProperty("umlCheckScript");
			List<String> filtered = WorkflowUtils.split(files);
			for (String s : filtered) {
				addUmlCheckScript(s);
			}
		}
		if (isNotSetOutputSlot) {
			setSlot(properties.getProperty("slot"));
		}
		if (isNotSetExcludePackages) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"excludePackages", "'" + properties.getProperty("excludePackages") + "'"));
		} else {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"excludePackages", "'" + WorkflowUtils.arrayToString(excludePackages) + "'"));
		}
		if (isNotSetMapClassesInModelToExternal) {
			setMapClassesInModelToExternal(new Boolean(properties.getProperty("mapClassesInModelToExternal")));
		}
		if (isNotSetExternalPackages) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"externalPackages", "'" + properties.getProperty("externalPackages") + "'"));
		} else {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"externalPackages", "'" + WorkflowUtils.arrayToString(externalPackages) + "'"));
		}
		if (isNotSetExternalStereotypes) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"externalStereotypes", "'" + properties.getProperty("externalStereotypes") + "'"));
		} else {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"externalStereotypes", "'" + WorkflowUtils.arrayToString(externalStereotypes) + "'"));
		}
		if (isNotSetExcludeStereotypes) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"excludeStereotypes", "'" + properties.getProperty("excludeStereotypes") + "'"));
		} else {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"excludeStereotypes", "'" + WorkflowUtils.arrayToString(excludeStereotypes) + "'"));
		}
		if (isNotSetIncludeProfiles) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"includeProfiles", "'" + properties.getProperty("includeProfiles") + "'"));
		} else {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"includeProfiles", "'" + WorkflowUtils.arrayToString(includeProfiles) + "'"));
		}
		if (isNotSetAllowGeneratedXmiGuID) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"allowGeneratedXmiGuID", Boolean.parseBoolean(properties.getProperty("allowGeneratedXmiGuID"))));
		}
		super.checkConfiguration(issues);
	}
	
	/**
	 * setter for <b>mandatory</b> model parameter to specify the model file
	 */
	public void setModel(String model) {
//		xmiReader.setUri(model);
		xmiReader.setModelFile(model);
	}
	
	/**
	 * setter for UmlSlot parameter in xmiReader and checkComponent.
	 */
	public void setUmlSlot(String umlSlot) {
		properties.put("umlSlot", umlSlot);
//		xmiReader.setModelSlot(umlSlot);
		xmiReader.setOutputSlot(umlSlot);
		checkComponent.setEmfAllChildrenSlot(umlSlot);
		xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("uml2model", umlSlot));
		
		isNotSetUmlSlot = false;
	}
	
	/**
	 * setter for UmlGenesezScript parameter in xtendComponent.
	 */
	public void setUml2GenesezScriptCall(String scriptCall) {
		xtendComponent.setInvoke(scriptCall + "(" + properties.getProperty("umlSlot") + ")");
		isNotSetUml2genesezScriptCall = false;
	}
	
	/**
	 * setter for ignoreValidationErrors parameter in checkComponent.
	 */
	public void setIgnoreValidationErrors(boolean ignoreValidationErrors) {
		checkComponent.setAbortOnError(!ignoreValidationErrors);
		isNotSetIgnoreValidationErrors = false;
	}
	
	/**
	 * adder forumlCheckScript in checkComponent.
	 */
	public void addUmlCheckScript(String umlCheckScript) {
		checkComponent.addCheckFile(umlCheckScript);
		addDefaultCheckFiles = false;
	}
	
	/**
	 * setter for Slot parameter in xtendComponent.
	 */
	public void setSlot(String slot) {
		xtendComponent.setOutputSlot(slot);
		isNotSetOutputSlot = false;
	}
	
	public void addProfile(String profile) {
		ProfileMetaModel metaModel = new ProfileMetaModel();
		metaModel.addProfile(profile);
		xtendComponent.addMetaModel(metaModel);
	}
	
	/**
	 * adder for MetaModel parameter in xtendComponent. Setter for profile to
	 * MetaModel.
	 */
	public void addProfiles(String profiles) {
		if (profiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(profiles);
			for (String s : filtered) {
				addProfile(s);
			}
		}
	}
	
	public void addExcludePackage(String excludePackage) {
		this.excludePackages.add(excludePackage);
		isNotSetExcludePackages = false;
	}
	
	/**
	 * adder for excludePackages parameter, which in GlobalVarDef add.
	 */
	public void addExcludePackages(String excludePackages) {
		if (excludePackages.length() > 0) {
			List<String> filtered = WorkflowUtils.split(excludePackages);
			for (String s : filtered) {
				addExcludePackage(s);
			}
		}
	}
	
	/**
	 * setter for mapClassesInModelToExternal parameter, which in GlobalVarDef
	 * add.
	 */
	public void setMapClassesInModelToExternal(boolean mapClassesInModelToExternal) {
		xtendComponent.addGlobalVarDef(
				WorkflowUtils.createGlobalVarDef(
					"mapClassesInModelToExternal", mapClassesInModelToExternal));
		isNotSetMapClassesInModelToExternal = false;
	}
	
	public void addExternalPackage(String externalPackage) {
		this.externalPackages.add(externalPackage);
		isNotSetExternalPackages = false;
	}
	
	/**
	 * adder for ExternalPackages parameter, which in GlobalVarDef add.
	 */
	public void addExternalPackages(String externalPackages) {
		if (externalPackages.length() > 0) {
			List<String> filtered = WorkflowUtils.split(externalPackages);
			for (String s : filtered) {
				addExternalPackage(s);
			}
		}
	}
	
	public void addExternalStereotype(String externalStereotype) {
		this.externalStereotypes.add(externalStereotype);
		isNotSetExternalStereotypes = false;
	}
	
	/**
	 * adder for ExternalStereotypes parameter, which in GlobalVarDef add.
	 */
	public void addExternalStereotypes(String externalStereotypes) {
		if (externalStereotypes.length() > 0) {
			List<String> filtered = WorkflowUtils.split(externalStereotypes);
			for (String s : filtered) {
				addExternalStereotype(s);
			}
		}
	}
	
	public void addExcludeStereotype(String excludeStereotype) {
		this.excludeStereotypes.add(excludeStereotype);
		isNotSetExcludePackages = false;
	}
	
	/**
	 * adder for ExternalStereotypes parameter, which in GlobalVarDef add.
	 */
	public void addExcludeStereotypes(String excludeStereotypes) {
		if (excludeStereotypes.length() > 0) {
			List<String> filtered = WorkflowUtils.split(excludeStereotypes);
			for (String s : filtered) {
				addExternalStereotype(s);
			}
		}
	}
	
	public void addIncludeProfile(String includeProfile) {
		this.includeProfiles.add(includeProfile);
		isNotSetIncludeProfiles = false;
	}
	
	/**
	 * adder for IncludeProfiles parameter, which in GlobalVarDef add.
	 */
	public void addIncludeProfiles(String includeProfiles) {
		if (includeProfiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(includeProfiles);
			for (String p : filtered) {
				addIncludeProfile(p);
			}
		}
	}
	
	public void setAllowGeneratedXmiGuID(boolean allowed){
		xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("allowGeneratedXmiGuID", allowed));
		isNotSetAllowGeneratedXmiGuID = false;
	}
}