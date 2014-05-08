package org.genesez.util;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324548489333_963273_2494) 
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class to store model elements and objects in a storage backend (map of key-value pairs).
 * 
 * @author Tobias Haubold <tobias.haubold@fh-zwickau.de> (maintainer)
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Georg Beier<georg.beier@fh-zwickau.de>
 */
public class GlobalObjectStorage {
	
	/**
	 * The storage backend.
	 */
	private static Map<String, Object> storageBackend = new LinkedHashMap<String, Object>();
	
	/**
	 * Returns the value to which the specified key is mapped, or null if the storage backend contains no mapping for the specified key.
	 * 
	 * @param	key	The key to access a value.
	 * @return	The value of the specified key.
	 */
	public static Object get(String key) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548648026_997055_2534) ENABLED START */
		return storageBackend.get(key);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Associates the specified key with the specified value in the backend storage.
	 * 
	 * @param	key		The key to access the specified value.
	 * @param	value	The specified value.
	 * @return	The previous value of the specified key, or null if there was no mapping for key in the storage backend.
	 */
	public static Object set(String key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548779609_480591_2541) ENABLED START */
		return storageBackend.put(key, value);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Removes the specified key and value from the backend storage.
	 * 
	 * @param	key	The key to remove.
	 * @return	The previous value of the specified key, or null if there was no mapping for key in the storage backend.
	 */
	public static Object remove(String key) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548856906_604746_2546) ENABLED START */
		return storageBackend.remove(key);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Count all saved model elements and objects from the backend storage.
	 */
	public static int count() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549067124_959868_2557) ENABLED START */
		return storageBackend.size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Remove all saved model elements and objects from the backend storage.
	 */
	public static void clear() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324549067124_959868_2557) ENABLED START */
		storageBackend.clear();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324548489333_963273_2494) ENABLED START */
	/* PROTECTED REGION END */
	
}
