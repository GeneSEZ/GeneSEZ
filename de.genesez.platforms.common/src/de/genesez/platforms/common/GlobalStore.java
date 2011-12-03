package de.genesez.platforms.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class for storing model elements and objects.
 * 
 * @author nihe
 * @author geobe
 * @author tobias haubold (last)
 * @date 2008-04-18
 */
public class GlobalStore {
	
	/**
	 * storage backend
	 */
	private static Map<String, Object> safe = new LinkedHashMap<String, Object>();
	
	/**
	 * @return the value of the specified key.
	 */
	public static Object get(String key) {
		return safe.get(key);
	}
	
	/**
	 * Saves a key-value pair.
	 * @param key	the key to access the value
	 * @param value	the value to store
	 */
	public static Object save(String key, Object value) {
		return safe.put(key, value);
	}
	
	/**
	 * Removes the key and it's value.
	 * @param key	the key to access a value
	 */
	public static Object remove(String key) {
		return safe.remove(key);
	}
	
	/**
	 * Clears all saved objects.
	 */
	public static void clear() {
		safe.clear();
	}
}
