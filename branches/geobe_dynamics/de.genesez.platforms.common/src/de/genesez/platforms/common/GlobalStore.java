package de.genesez.platforms.common;

import de.genesez.metamodel.gcore.MModel;

/**
 * Utility class for storing a model
 * 
 * @author	nihe
 * @author	geobe
 * @date	2008-04-18
 */
public class GlobalStore {
	
	/**
	 * holds a model reference
	 */
	private static MModel model;
	
	/**
	 * getter for the model reference
	 * @return	the stored model reference
	 */
	public static MModel getModel() {
		return model;
	}
	
	/**
	 * setter for the model reference
	 * @param mod	model reference to save
	 */
	public static void setModel(MModel mod) {
		model = mod;
	}
}
