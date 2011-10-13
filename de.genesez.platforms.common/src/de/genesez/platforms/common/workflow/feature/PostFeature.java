package de.genesez.platforms.common.workflow.feature;


/**
 * Implementations of this interface can be added to the Generator. It does
 * something after the generation.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public interface PostFeature extends TransformationFeature{

	/**
	 * Is called after generation and after preProcessing()
	 * 
	 * @throws NotPreparedException
	 *             if preProcessing() was not called before.
	 */
	public abstract void invokePost() throws NotPreparedException;
}
