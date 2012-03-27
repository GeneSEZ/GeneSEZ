package org.genesez.tools.modelcreator.algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Interface;
import org.genesez.tools.modelcreator.CountHelper;

public class AssociationAlgorithmInPackage<E extends StructuredClassifier>
		implements AssociationAlgorithm<E> {

	private Map<E, List<Element>> classPackage = new HashMap<E, List<Element>>(
			1000);
	private Map<Interface, List<Element>> interfacePackage = new HashMap<Interface, List<Element>>();

	/**
	 * Creates associations
	 * @see AssociationAlgorithm#createReferences(List, List, int, int)
	 */
	public void createReferences(List<? extends E> types,
			List<Interface> interfaces, int amount, int perClass) {
		for (E type : types) {
			classPackage.put(type, getPackageList(type));
		}
		for (Interface type : interfaces) {
			interfacePackage.put(type, getPackageList(type));
		}

		if (amount > 0 && perClass > 0) {
			int typeSize = types.size();
			int size = typeSize + interfaces.size();
			float offset = (size * perClass) / (float) (amount + 1);

			for (float i = offset; i < size - 1; i = i + offset) {
				int y = Math.round(i);
				if (y >= typeSize) {
					createInterfaceAssociation(interfaces.get(y - typeSize),
							perClass, offset);
				} else {
					E aType = types.get(y);
					Set<E> classSet = new HashSet<E>();
					for (int j = 0; j < perClass; j++) {
						setupAssociation(
								UMLFactory.eINSTANCE.createAssociation(),
								aType, classSet);
					}
				}
			}
		}
	}

	/**
	 * Compares whether the classifier is in a package
	 * 
	 * @param toCompare
	 *            the package list to check
	 * @param classifier
	 *            a classifier that should be compared
	 * @return false if the classifier is in another package (e. g. a = x.y, b =
	 *         x.y.z , c = x.z.y -> (a and b) and (b and a) return true other
	 *         return false
	 */
	private boolean compareElements(List<Element> toCompare,
			Classifier classifier) {
		List<Element> toCheck = classPackage.get(classifier);
		for (int i = 0; i < toCompare.size(); i++) {
			if (i >= toCheck.size()) {
				return true;
			}
			if (!toCompare.get(i).equals(toCheck.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * gets a List with packages that own the given type
	 * 
	 * @param type
	 *            the examined type
	 * @return the list with packages
	 */
	private List<Element> getPackageList(Classifier type) {
		List<Element> packageList = new LinkedList<Element>();
		Element p = type.getOwner();
		packageList.add(p);
		while ((p = p.getOwner()) != null) {
			packageList.add(p);
		}
		return packageList;
	}

	/**
	 * Describes an Association
	 * 
	 * @param a
	 *            the association
	 * @param type
	 *            the type from which the association is started
	 * @param types
	 *            a list with available types
	 * @param used
	 *            already associated types
	 */
	public void setupAssociation(Association a, E type, Set<E> used) {
		a.setPackage(type.getPackage());
		int j = Math.abs(type.hashCode() * a.hashCode());
		StructuredClassifier associatedType = getAssociatedType(
				classPackage.get(type), used,
				Math.abs(a.toString().hashCode()), j);

		List<Property> props = new ArrayList<Property>(4);
		Property prop1, prop2;
		int i = j % 3;

		if (i == 0) {
			prop1 = type.createOwnedAttribute(
					CountHelper.getName("references"), associatedType);
			prop2 = a.createOwnedEnd(CountHelper.getName("references"), type);
		} else if (i == 1) {
			prop1 = a.createOwnedEnd(CountHelper.getName("references"),
					associatedType);
			prop2 = associatedType.createOwnedAttribute(
					CountHelper.getName("references"), type);
		} else {
			prop1 = type.createOwnedAttribute(
					CountHelper.getName("references"), associatedType);
			prop2 = associatedType.createOwnedAttribute(
					CountHelper.getName("references"), type);
		}
		prop1.setAssociation(a);
		prop2.setAssociation(a);

		props.add(prop1);
		props.add(prop2);

		for (Property prop : props) {
			int z = Math.abs(prop.toString().hashCode());
			prop.setLower(1);
			if ((z % 2) == 0) {
				prop.setUpper(1);
			} else {
				prop.setUpper(10);
			}
			prop.setAggregation(getAggregationKind(z));
		}
	}

	/**
	 * Creates an Association for an Interface
	 * 
	 * @param in
	 *            the interface
	 * @param perClass
	 *            associations per interface
	 * @param offset
	 *            the offset value, just for calculation
	 */
	private void createInterfaceAssociation(Interface in, int perClass,
			float offset) {
		Set<E> classSet = new HashSet<E>();
		for (int i = 0; i < perClass; i++) {
			int j = Math
					.abs((Math.round((Float) (in.hashCode() / (offset + i)))));
			int max1, max2;
			if (j % 2 == 0) {
				max1 = 1;
			} else {
				max1 = 10;
			}
			if (j % 3 == 0) {
				max2 = 10;
			} else {
				max2 = 1;
			}
			in.createAssociation(
					false,
					getAggregationKind(j),
					CountHelper.getName("references"),
					1,
					max1,
					getAssociatedType(interfacePackage.get(in), classSet,
							offset, j), true, getAggregationKind(j),
					CountHelper.getName("references"), 1, max2);
		}
	}

	/**
	 * Gets an AggregationKind depending on the given value
	 * 
	 * @param j
	 *            variable for checking
	 * @return NONE_LITERAL, COMPOSITE_LITERAL or SHARED_LITERAL depending on j.
	 */
	private static AggregationKind getAggregationKind(int j) {
		int i = j % 7;
		if (i == 0 || i == 1 || i == 2) {
			return AggregationKind.NONE_LITERAL;
		} else if (i == 3 || i == 4) {
			return AggregationKind.COMPOSITE_LITERAL;
		} else {
			return AggregationKind.SHARED_LITERAL;
		}
	}

	/**
	 * Gets a calculated classifier from the list
	 * 
	 * @param toCompare
	 *            a List with a packages, that can be used
	 * @param classSet
	 *            a Set with classifier that already associated with the class
	 * @param offset
	 *            an offset just for calculation
	 * @param j
	 *            another variable for calculation
	 * @return a Classifier from types list
	 */
	private E getAssociatedType(List<Element> toCompare, Set<E> classSet,
			float offset, int j) {
		List<E> availableTypes = new ArrayList<E>();
		for (E classifier : classPackage.keySet()) {
			if (compareElements(toCompare, classifier)) {
				availableTypes.add(classifier);
			}
		}
		List<E> copy = new ArrayList<E>(availableTypes.size());
		copy.addAll(availableTypes);
		copy.removeAll(classSet);
		E result = copy.get(Math.round(((offset * copy.size() * j)))
				% copy.size());
		classSet.add(result);
		return result;
	}

	/**
	 * gets classes for Associations
	 * 
	 * @see AssociationAlgorithm#getClassesForAssociationClasses(List, int)
	 */
	public List<E> getClassesForAssociationClasses(List<? extends E> types,
			int amount) {
		int size = types.size();
		float offset = size / (float) (amount + 1);
		if (offset < 1) {
			offset = 1;
			size++;
		}
		List<E> classifiers = new LinkedList<E>();
		for (float c = offset; c < size - 1; c = c + offset) {
			int i = Math.round(c);
			classifiers.add(types.get(i));
		}
		return classifiers;
	}

}
