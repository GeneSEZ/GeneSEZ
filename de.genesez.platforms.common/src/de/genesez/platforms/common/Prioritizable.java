package de.genesez.platforms.common;

/**
 * Allows priorities. Classes implementing this are able to be sorted in a Collection
 * with a {@link de.genesez.platforms.common.workflow.feature.PriorityComparator}
 * 
 * Note: this class has a natural ordering that is inconsistent with equals.
 * 
 * @author Dominik Wetzel
 * 
 */
public interface Prioritizable {
	/**
	 * Gives the priority for the pre-list if prePriority is 0 or below it will
	 * not be put in the pre-list
	 * 
	 * @return Priority in pre-list
	 */
	public abstract int getPrePriority();

	/**
	 * Gives the priority for the post-list if prePriority is 0 or below it will
	 * not be put in the post-list
	 * 
	 * @return Priority in post-list
	 */
	public abstract int getPostPriority();

	/**
	 * Sets the priority for the pre-list
	 * 
	 * @param priority
	 *            for pre-list
	 */
	public abstract void setPrePriority(int priority);

	/**
	 * Sets the priority for the post-list
	 * 
	 * @param priority
	 *            for post-list
	 */
	public abstract void setPostPriority(int priority);

	// //public abstract boolean[] getFileTreeWalkerFlags();
	//
	// public abstract boolean changesPreFileTree(); // --> FTW in Pre nach
	// Feature (normalerweise auch ein FTW davor)
	//
	// public abstract boolean changesPostFileTree(); // --> FTW in Post nach
	// Feature (normalerweise auch ein FTW davor)
	//
	// public abstract boolean needsPreWalk(); // --> braucht FTW in Pre vor
	// Feature
	//
	// public abstract boolean needsPostWalk(); // --> braucht FTW in Post vor
	// Feature
	//
	// public abstract boolean preWalkInPost(); // --> braucht FTW von Pre in
	// Post
}
