package de.genesez.platforms.common.workflow.feature;

/**
 * Implementations of this interface can be added to the Generator. It does
 * something before the generation.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public interface PreFeature extends TransformationFeature {

	/**
	 * invokes before Generation to prepare this or other features.
	 */
	public abstract void invokePre();
}
