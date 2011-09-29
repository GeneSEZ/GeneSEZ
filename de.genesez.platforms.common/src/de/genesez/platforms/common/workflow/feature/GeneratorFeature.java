package de.genesez.platforms.common.workflow.feature;

import java.util.Properties;

/**
 * Implementations of this interface can be added to the Generator.
 * It does something after the generation and the files are all written.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 */
public interface GeneratorFeature {
	
	/**
	 * Sets the properties for the feature
	 * @param properties the properties
	 */
	public abstract void setProperties(Properties properties);
	
	/**
	 * Checks the Configuration of the feature
	 */
	public abstract void checkConfiguration();
	
	/**
	 * Is called after generation and after preProcessing()
	 * @throws NotPreparedException if preProcessing() was not called before.
	 */
	public abstract void afterGeneration() throws NotPreparedException;
}
