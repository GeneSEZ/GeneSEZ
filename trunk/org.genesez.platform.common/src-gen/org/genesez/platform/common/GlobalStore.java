package org.genesez.platform.common;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324548489333_963273_2494) 
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class for storing model elements and objects.
 * 
 * @author nihe
 * @author geobe
 * @author tobias haubold (last)
 * @date 2008-04-18
 * @deprecated
 */
public class GlobalStore {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * storage backend
	 */
	private static Map<String, Object> safe = new LinkedHashMap<String, Object>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * returns a value
	 * @param	key	the key to access a value
	 * @return	the value of the specified key.
	 */
	public static Object get(String key) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548648026_997055_2534) ENABLED START */
		return safe.get(key);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Saves a key-value pair.
	 * @param	key	the key to access the value
	 * @param	value	the value to store
	 * @return	
	 */
	public static Object save(String key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548779609_480591_2541) ENABLED START */
		return safe.put(key, value);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Removes the key and it's value.
	 * @param	key	the key to access a value
	 * @return	the previous value associated with key, or null if there was no mapping for key
	 */
	public static Object remove(String key) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548856906_604746_2546) ENABLED START */
		return safe.remove(key);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Clears all saved objects.
	 */
	
	public static void clear() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549067124_959868_2557) ENABLED START */
		safe.clear();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324548489333_963273_2494) ENABLED START */
	/* PROTECTED REGION END */
	
}
