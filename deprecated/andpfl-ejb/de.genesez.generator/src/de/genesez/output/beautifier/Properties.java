package de.genesez.output.beautifier;

import java.util.HashMap;

/**
 * @author nicher
 * 
 */
public class Properties {

	/**
	 * 
	 */
	private java.util.Map<String, String> options = null;

	/**
	 * 
	 */
	public Properties() {
		this.options = new HashMap<String, String>();
	}

	/**
	 * @param key
	 * @param value
	 */
	public void put(String key, String value) {
		options.put(key, value);
	}

	/**
	 * @param key
	 */
	public void remove(String key) {
		options.remove(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return options.get(key);
	}

	/**
	 * Returns true if the options contains a mapping for the specified key.
	 * 
	 * @param key
	 * @return true if the option was fund.
	 */
	public boolean containsKey(String key) {
		return options.containsKey(key);
	}

}
