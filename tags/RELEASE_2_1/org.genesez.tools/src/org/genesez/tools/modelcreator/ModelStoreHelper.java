package org.genesez.tools.modelcreator;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Type;
import org.genesez.tools.modelcreator.algorithms.AssociationAlgorithm;
import org.genesez.tools.modelcreator.algorithms.GeneralizationAlgorithm;

public class ModelStoreHelper {

	private static List<Class> classes = new ArrayList<Class>(10000);

	private static List<Classifier> types = new ArrayList<Classifier>(15000);

	private static List<Interface> interfaces = new ArrayList<Interface>(5000);

	//private static AssociationAlgorithm<Classifier> assoAlgo = new AssociationAlgorithmImpl<Classifier>();
	private static AssociationAlgorithm<StructuredClassifier> assoAlgo;

	private static GeneralizationAlgorithm<Classifier> classGeneralAlgo;
	private static GeneralizationAlgorithm<Classifier> interfaceGeneralAlgo;

	// private static Log logger = LogFactory.getLog(ModelStoreHelper.class);

	public static void setAssociationAlgorithm(AssociationAlgorithm<StructuredClassifier> assoAlgo){
		ModelStoreHelper.assoAlgo = assoAlgo;
	}
	
	public static void setClassGeneralizationAlgorithm(GeneralizationAlgorithm<Classifier> generalAlgo){
		classGeneralAlgo = generalAlgo;
	}
	
	public static void setInterfaceGeneralizationAlgorithm(GeneralizationAlgorithm<Classifier> generalAlgo){
		interfaceGeneralAlgo = generalAlgo;
	}
	
	public static void addInterface(Interface theInterface) {
		interfaces.add(theInterface);
		types.add(theInterface);
	}

	/**
	 * Adds a class to the classes list
	 * 
	 * @param theClass
	 *            a class to add
	 */
	public static void addClass(Class theClass) {
		classes.add(theClass);
		types.add(theClass);
	}

	/**
	 * Gets a list of the interfaces
	 * 
	 * @return the list of interfaces
	 */
	public static List<Interface> getInterfaces() {
		return interfaces;
	}

	/**
	 * Creates references
	 * 
	 * @param amount
	 *            the amount of associations to create
	 * @param perClass
	 *            the amount of associations per class
	 */
	public static void createReferences(Integer amount, Integer perClass) {
		assoAlgo.createReferences(classes, interfaces, amount, perClass);
	}
	
	/**
	 * Describes an association
	 * @param a association to set up
	 * @param type the start classifier
	 */
	public static void setupAssociation(Association a, StructuredClassifier type){
		assoAlgo.setupAssociation(a, type, new HashSet<StructuredClassifier>());
	}

	/**
	 * gets some associations
	 * 
	 * @param amount
	 *            the amount of associations
	 * @return the list with the association
	 */
	public static List<StructuredClassifier> getClassesForAssociationClasses(Integer amount) {
		return assoAlgo.getClassesForAssociationClasses(classes, amount);
	}

	/**
	 * Creates the generalizations
	 * 
	 * @param ciH
	 *            the amount of classes in the hierarchy, depending on used
	 *            algorithm different meanings.
	 * @param sPc
	 *            subclasses per class in the hierarchy
	 * @param depth
	 *            hierarchy depth
	 * @param forInterfaces
	 *            true if interface hierarchy, else class hierarchy will be
	 *            created.
	 */
	public static void createHierarchy(Integer ciH, Integer sPc, Integer depth,
			Boolean forInterfaces) {
		if (forInterfaces) {
			interfaceGeneralAlgo.createHierarchy(interfaces, sPc, ciH, depth);
		} else {
			classGeneralAlgo.createHierarchy(classes, sPc, ciH, depth);
		}
	}

	/**
	 * Gets a Classifier depending on the Hash-Code of the given String
	 * 
	 * @param name
	 *            the name that should be hashed
	 * @return a classifier or null if not enough types available
	 */
	public static Class getRealizationClass(String name, Interface in) {
		int get = Math.abs((name.hashCode() + in.getName().hashCode())
				% (classes.size()));
		return classes.get(get);
	}

	/**
	 * Gets a random class type
	 * 
	 * @param voidPossible
	 *            true if void is possible
	 * @return a random class type or maybe null if void possible
	 */
	public static Type getRandomType(Boolean voidPossible) {
		if (voidPossible && Math.random() > 0.7) {
			return null;
		}
		return types
				.get(Math.round(((Double) ((Math.random()) * (types.size() - 1)))
						.floatValue()));
	}
}
