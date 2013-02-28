package org.genesez.tools.modelcreator;

import java.util.List;
import java.util.Properties;

import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVar;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import org.genesez.platform.common.workflow.Serializer;
import org.genesez.platform.common.workflow.WorkflowUtils;
import org.genesez.tools.modelcreator.ModelStoreHelper;
import org.genesez.tools.modelcreator.algorithms.AssociationAlgorithm;
import org.genesez.tools.modelcreator.algorithms.AssociationAlgorithmInPackage;
import org.genesez.tools.modelcreator.algorithms.GeneralizationAlgorithm;
import org.genesez.tools.modelcreator.algorithms.GeneralizationAlgorithmImpl;


public class ModelCreator extends CompositeComponent {

	private XtendComponent xtendComponent = new XtendComponent();
	private Serializer serializer = new Serializer();
	private Properties globalVars = new Properties();
	private Properties properties = new Properties();
	private static Properties globalVarDefaults = new Properties();

	private static Properties defaults = new Properties();
	static {
		globalVarDefaults.put("headPackages", "3");
		globalVarDefaults.put("packagesPerPackage", "3");
		globalVarDefaults.put("packageHierarchyDepth", "3");

		globalVarDefaults.put("classesPerPackage", "5");
		globalVarDefaults.put("interfacesPerPackage", "1");
		globalVarDefaults.put("operationsPerClass", "4");
		globalVarDefaults.put("attributesPerClass", "3");
		globalVarDefaults.put("parametersPerOperation", "2");

		globalVarDefaults.put("associationClasses", "10");
		globalVarDefaults.put("associations", "200");
		globalVarDefaults.put("associationsPerClass", "2");

		globalVarDefaults.put("classHierarchyTrees", "5");
		globalVarDefaults.put("classHierarchyDepth", "3");
		globalVarDefaults.put("specializationsPerClass", "3");

		globalVarDefaults.put("realizationsPerInterface", "1");
		globalVarDefaults.put("interfaceHierarchyTrees", "2");
		globalVarDefaults.put("interfaceHierarchyDepth", "2");
		globalVarDefaults.put("specializationsPerInterface", "2");

		globalVarDefaults.put("random", "0");
		globalVarDefaults.put("offset", "0");
		globalVarDefaults.put("offsetInPercent", "false");
		
		defaults.put("name", "createdModel");

		defaults.put("invokeScript", "CreateModel::start()");
		defaults.put("slot", "model");
		defaults.put("outputFile", "model/uml2model.xmi");
		
	}
	
	private AssociationAlgorithm<StructuredClassifier> associationAlgo = new AssociationAlgorithmInPackage<StructuredClassifier>();
	private GeneralizationAlgorithm<Classifier> classGeneralizationAlgo = new GeneralizationAlgorithmImpl<Classifier>();
	private GeneralizationAlgorithm<Classifier> interfaceGeneralizationAlgo = classGeneralizationAlgo;

	/**
	 * Constructor for the Model creator, sets default properties and adds
	 * components
	 */
	public ModelCreator() {
		super(ModelCreator.class.getSimpleName());
		globalVars.putAll(globalVarDefaults);
		properties.putAll(defaults);

		xtendComponent.addMetaModel(new UML2MetaModel());

		super.addComponent(xtendComponent);
		super.addComponent(serializer);
	}

	/**
	 * checks the configuration of the component and sets the properties.
	 */
	@Override
	public void checkConfiguration(Issues issues) {
		String slot = properties.getProperty("slot");
		setGlobalVars();
		GlobalVar name = new GlobalVar();
		name.setName("name");
		name.setValue(properties.getProperty("name"));
		xtendComponent.addGlobalVar(name);
		xtendComponent.setInvoke(properties.getProperty("invokeScript"));
		xtendComponent.setOutputSlot(slot);
		serializer.setSlot(slot);
		serializer.setFile(properties.getProperty("outputFile"));
		ModelStoreHelper.setAssociationAlgorithm(associationAlgo);
		ModelStoreHelper.setClassGeneralizationAlgorithm(classGeneralizationAlgo);
		ModelStoreHelper.setInterfaceGeneralizationAlgorithm(interfaceGeneralizationAlgo);
		super.checkConfiguration(issues);
	}

	/**
	 * sets GlobalVarDefs
	 */
	private void setGlobalVars() {
		for (String key : globalVars.stringPropertyNames()) {
			xtendComponent.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					key, globalVars.getProperty(key)));
		}
	}

	// FOR COMPONENT PROPERTIES

	public void setSlot(String slot) {
		properties.setProperty("slot", slot);
	}

	public void setInvokeScript(String script) {
		properties.setProperty("invokeScript", script);
	}

	public void setOutputFile(String file) {
		properties.setProperty("outputFile", file);
	}
	
	public void setAssociationAlgorithm(AssociationAlgorithm<StructuredClassifier> associationAlgorithm){
		this.associationAlgo = associationAlgorithm; 
	}
	
	public void setClassGeneralizationAlgorithm(GeneralizationAlgorithm<Classifier> generalizationAlgorithm) {
		this.classGeneralizationAlgo = generalizationAlgorithm;
	}
	
	public void setInterfaceGeneralizationAlgorithm(GeneralizationAlgorithm<Classifier> generalizationAlgorithm) {
		this.interfaceGeneralizationAlgo = generalizationAlgorithm;
	}
		
	public void setName(String name) {
		properties.setProperty("name", name);
	}

	// FOR MORE COMFORTABLE CONFIGURATION OF GLOBALVARS

/**
	 * Sets the structural parameters in following order:
	 * <p>
	 * {@link #setHeadPackages(String)}<br>
	 * {@link #setPackagesPerPackage(String)}<br>
	 * {@link #setPackageHierarchyDepth(String)}<br>
	 * {@link #setClassesPerPackage(String)}<br>
	 * {@link #setInterfacesPerPackage(String)}<br>
	 * {@link #setAttributesPerClass(String)}<br>
	 * {@link #setOperationsPerClass(String)}<br>
	 * {@link #setParametersPerOperation(String)
	 * </p>
	 * @param structure a comma or semicolon separated list with 8 numbers.
	 */
	public void setStructure(String structure) {
		List<String> numbers = WorkflowUtils.split(structure);
		setHeadPackages(numbers.get(0));
		setPackagesPerPackage(numbers.get(1));
		setPackageHierarchyDepth(numbers.get(2));
		setClassesPerPackage(numbers.get(3));
		setInterfacesPerPackage(numbers.get(4));
		setAttributesPerClass(numbers.get(5));
		setOperationsPerClass(numbers.get(6));
		setParametersPerOperation(numbers.get(7));
	}

	/**
	 * Sets the association parameters in the following order:
	 * <p>
	 * {@link #setAmountOfAssociations(String)}<br>
	 * {@link #setAssociationsPerClass(String)}<br>
	 * {@link #setAssociationClasses(String)}
	 * </p>
	 * 
	 * @param associations
	 *            a comma or semicolon separated list with 3 numbers.
	 */
	public void setAssociations(String associations) {
		List<String> numbers = WorkflowUtils.split(associations);
		setAmountOfAssociations(numbers.get(0));
		setAssociationsPerClass(numbers.get(1));
		setAssociationClasses(numbers.get(2));
	}

	/**
	 * Sets the generalization parameters in the following order:
	 * <p>
	 * {@link #setClassHierarchyTrees(String)}<br>
	 * {@link #setSpecializationsPerClass(String)}<br>
	 * {@link #setClassHierarchyDepth(String)}<br>
	 * {@link #setRealizationsPerInterface(String)}<br>
	 * {@link #setInterfaceHierarchyTrees(String)}<br>
	 * {@link #setSpecialzationsPerInterface(String)}<br>
	 * {@link #setInterfaceHierarchyDepth(String)}
	 * </p>
	 * 
	 * @param generalizations
	 *            a comma or semicolon separated list with 7 numbers.
	 */
	public void setGeneralizations(String generalizations) {
		List<String> numbers = WorkflowUtils.split(generalizations);
		setClassHierarchyTrees(numbers.get(0));
		setSpecializationsPerClass(numbers.get(1));
		setClassHierarchyDepth(numbers.get(2));

		setRealizationsPerInterface(numbers.get(3));
		setInterfaceHierarchyTrees(numbers.get(4));
		setSpecialzationsPerInterface(numbers.get(5));
		setInterfaceHierarchyDepth(numbers.get(6));
	}

	// DEFINING GLOBALVARS

	// structural parameters

	public void setHeadPackages(String number) {
		globalVars.setProperty("headPackages", number);
	}

	public void setPackagesPerPackage(String number) {
		globalVars.setProperty("packagesPerPackage", number);
	}

	public void setPackageHierarchyDepth(String number) {
		globalVars.setProperty("packageHierarchyDepth", number);
	}

	public void setClassesPerPackage(String number) {
		globalVars.setProperty("classesPerPackage", number);
	}

	public void setInterfacesPerPackage(String number) {
		globalVars.setProperty("interfacesPerPackage", number);
	}

	public void setOperationsPerClass(String number) {
		globalVars.setProperty("operationsPerClass", number);
	}

	public void setAttributesPerClass(String number) {
		globalVars.setProperty("attributesPerClass", number);
	}

	public void setParametersPerOperation(String number) {
		globalVars.setProperty("parametersPerOperation", number);
	}

	// association parameters

	public void setAssociationClasses(String number) {
		globalVars.setProperty("associationClasses", number);
	}

	public void setAssociationsPerClass(String number) {
		globalVars.setProperty("associationsPerClass", number);
	}

	public void setAmountOfAssociations(String number) {
		globalVars.setProperty("associations", number);
	}

	// generalization parameters

	public void setClassHierarchyTrees(String number) {
		globalVars.setProperty("classHierarchyTrees", number);
	}

	public void setClassHierarchyDepth(String number) {
		globalVars.setProperty("classHierarchyDepth", number);
	}

	public void setSpecializationsPerClass(String number) {
		globalVars.setProperty("specializationsPerClass", number);
	}

	public void setRealizationsPerInterface(String number) {
		globalVars.setProperty("realizationsPerInterface", number);
	}

	public void setSpecialzationsPerInterface(String number) {
		globalVars.setProperty("specializationsPerInterface", number);
	}

	public void setInterfaceHierarchyDepth(String number) {
		globalVars.setProperty("interfaceHierarchyDepth", number);
	}

	public void setInterfaceHierarchyTrees(String number) {
		globalVars.setProperty("interfaceHierarchyTrees", number);
	}

	// ADJUSTMENTS FOR MODELCREATION

	public void setOffset(String number) {
		globalVars.setProperty("offset", number);
	}

	public void setOffsetInPercent(boolean offsetInPercent) {
		globalVars.setProperty("offsetInPercent",
				Boolean.toString(offsetInPercent));
	}

	public void setRandom(String number) {
		globalVars.setProperty("random", number);
	}
}
