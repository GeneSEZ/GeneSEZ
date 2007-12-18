/**
 * 
 */
package de.genesez.common;

import genesezMM.MModel;

/**
 * @author nihe
 * @author geobe
 * @author toh
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
