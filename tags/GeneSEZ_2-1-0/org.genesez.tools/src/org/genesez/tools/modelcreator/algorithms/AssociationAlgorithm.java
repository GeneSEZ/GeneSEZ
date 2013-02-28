package org.genesez.tools.modelcreator.algorithms;

import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.StructuredClassifier;

public interface AssociationAlgorithm<E extends StructuredClassifier> {

	/**
	 * Creates References
	 * 
	 * @param types
	 *            all available types, that can be associated
	 * @param interfaces
	 *            the available interfaces
	 * @param amount
	 *            the amount of types that should have an association
	 * @param perClass
	 *            the amount of associations per class
	 */
	public abstract void createReferences(List<? extends E> types,
			List<Interface> interfaces, int amount, int perClass);

	/**
	 * gets classifiers with AssociationClasses
	 * 
	 * @amount the amount of associationClasses
	 * @return a list with classifiers
	 */
	public abstract List<E> getClassesForAssociationClasses(
			List<? extends E> types, int amount);

	/**
	 * Describes an Association
	 * 
	 * @param a
	 *            the association
	 * @param type
	 *            the type from which the association is started
	 * @param used
	 *            already associated types
	 */
	public abstract void setupAssociation(Association a, E type, Set<E> used);
}
