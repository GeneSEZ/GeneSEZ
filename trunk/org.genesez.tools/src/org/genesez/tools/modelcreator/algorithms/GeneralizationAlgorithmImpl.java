package org.genesez.tools.modelcreator.algorithms;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Classifier;
import org.genesez.tools.modelcreator.CountHelper;

public class GeneralizationAlgorithmImpl<E extends Classifier> implements
		GeneralizationAlgorithm<E> {

	/**
	 * creates Generalizations. Creates always complete trees if enough classes
	 * are available.
	 * 
	 * amount of generalizations is calculated by:
	 * amountOfClasses * ((sum[from i = 0 till depth] subclassesPerClass^i) -1)
	 * 
	 * @see GeneralizationAlgorithm#createHierarchy(List, int, int, int)
	 * @param amountOfClasses
	 *            is used as the amount of head classes, that means the amount
	 *            of hierarchical trees.<br>
	 *            Amount of all used classes is calculated by: amountOfClasses *
	 *            (Sum[from i = 0 till depth] subclassesPerClass^i)
	 */
	public void createHierarchy(List<? extends E> classes, int subclassesPerClass,
			int amountOfClasses, int depth) {
		if (amountOfClasses > 0 && subclassesPerClass > 0 && depth > 0) {
			
			int neededClasses = 0;
			for (int i = 0; i <= depth; i++) {
				neededClasses = neededClasses
						+ (int) Math.pow(subclassesPerClass, i);
			}

			int size = classes.size();
			float offset = size / (float) (neededClasses * amountOfClasses + 1);
			if (offset < 1) {
				offset = 1;
				size++;
			}
			
			List<E> extendedTypes = new ArrayList<E>(1000);
			for (float c = offset; c < size - 1; c = c + offset) {
				int i = Math.round(c);
				extendedTypes.add(classes.get(i));
			}

			while (!extendedTypes.isEmpty()) {
				createLevel(extendedTypes, new Integer(depth),
						subclassesPerClass, new ArrayList<E>());
			}
		}
	}

	/**
	 * Creates and connects an entire hierarchical tree until depth is zero.
	 * 
	 * @param types
	 *            list of chosen classifiers
	 * @param depth
	 *            the
	 * @param sPc
	 * @param subclasses
	 */
	private void createLevel(List<E> types, int depth, int sPc,
			List<E> subclasses) {
		if (depth >= 0) {
			List<E> newSubclasses = new ArrayList<E>();
			for (int i = 0; i < Math.pow(sPc, depth); i++) {
				if (types.isEmpty()) {
					return;
				}
				E type = types.remove(0);
				for (int j = (i * sPc); j < (i * sPc) + sPc
						&& j < (i * sPc) + subclasses.size(); j++) {
					CountHelper.getName("generalizations");
					subclasses.get(j).createGeneralization(type);
				}
				newSubclasses.add(type);
			}
			createLevel(types, depth - 1, sPc, newSubclasses);
		}
	}
}
