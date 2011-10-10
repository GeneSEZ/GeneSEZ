package de.genesez.platforms.common.workflow.feature;

import java.util.Comparator;

import de.genesez.platforms.common.Prioritizable;

/**
 * A Comparator for {@link de.genesez.platforms.common.Prioritizable}. Needed to
 * sort priorities in a collection. It's used to order pre-list and post-list.
 * 
 * Note: compare and equals will not give the same result.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-07
 */
public class PriorityComparator implements Comparator<Prioritizable> {

	private boolean orderPre = true;

	/**
	 * constructs a new Comparator
	 * 
	 * @param prePrioritySort
	 *            if true, list will be sort with prePriority if false with
	 *            postPriority
	 */
	public PriorityComparator(boolean prePrioritySort) {
		this.orderPre = prePrioritySort;
	}

	/**
	 * Compares two prioritizables.
	 * 
	 * @see java.util.Comparator#compare(Object, Object) for more Information
	 */
	@Override
	public int compare(Prioritizable feature1, Prioritizable feature2) {
		if (this.orderPre) {
			return (int) Math.signum(feature1.getPrePriority()
					- feature2.getPrePriority());
		} else {
			return (int) Math.signum(feature1.getPostPriority()
					- feature2.getPostPriority());
		}
	}
}
