package de.genesez.platforms.common.workflow.feature;

import java.util.Properties;

/**
 * Provides Subclasses with setProperties and check method.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public interface TransformationFeature {
	
	/**
	 * Sets the properties for the feature
	 * 
	 * @param properties
	 *            the properties
	 */
	public abstract void setProperties(Properties properties);

	/**
	 * Checks the configuration of the feature
	 */
	public abstract void checkConfiguration();
}
