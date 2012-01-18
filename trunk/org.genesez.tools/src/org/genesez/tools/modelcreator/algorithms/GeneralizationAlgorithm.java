package org.genesez.tools.modelcreator.algorithms;

import java.util.List;
import org.eclipse.uml2.uml.Classifier;

public interface GeneralizationAlgorithm<E extends Classifier> {

	/**
	 * Creates the generalizations
	 * 
	 * @param classes
	 *            All classifier from which the generalization structure will be
	 *            created.
	 * @param subclassesPerClass
	 *            subclasses per class in the hierarchy
	 * @param amountOfClasses
	 *            the amount of classes. Meaning of this can differ in different
	 *            implementations.
	 * @param depth
	 *            hierarchy depth
	 */
	public abstract void createHierarchy(List<? extends E> classes,
			int subclassesPerClass, int amountOfClasses, int depth);
}
