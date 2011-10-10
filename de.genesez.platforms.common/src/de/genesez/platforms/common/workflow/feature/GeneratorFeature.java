package de.genesez.platforms.common.workflow.feature;

import java.util.Properties;

import de.genesez.platforms.common.Prioritizable;

/**
 * Implementations of this interface can be added to the Generator. It does
 * something before and after the generation.
 * 
 * Implementations should be compareable to each other, so that it's possible to
 * sort them in a list.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 */
public interface GeneratorFeature extends Prioritizable {

	/**
	 * Sets the properties for the feature
	 * 
	 * @param properties
	 *            the properties
	 */
	public abstract void setProperties(Properties properties);

	/**
	 * Checks the Configuration of the feature
	 */
	public abstract void checkConfiguration();

	/**
	 * Prepares the Feature. Does something before generation process
	 */
	public abstract void pre();

	/**
	 * Is called after generation and after preProcessing()
	 * 
	 * @throws NotPreparedException
	 *             if preProcessing() was not called before.
	 */
	public abstract void post() throws NotPreparedException;

//	/**
//	 * Used to indicate if this feature changes the file tree. If so, and if
//	 * other features are behind this that also observing the file tree the
//	 * FileTreeWalker is called again.
//	 * 
//	 * @return false if file tree will not be changed
//	 */
//	public abstract boolean changeFileTree();
}
