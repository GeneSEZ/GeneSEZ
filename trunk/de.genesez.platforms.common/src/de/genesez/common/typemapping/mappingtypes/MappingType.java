package de.genesez.common.typemapping.mappingtypes;

import java.util.HashMap;
import java.util.Map;

public abstract class MappingType {

	private String map = null;
	private String defaultType = null;
	private Map<String, String> contextTypes = null;

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public MappingType(String map, String defaultType) {
		setMap(map);
		setDefaultType(defaultType);
		contextTypes = new HashMap<String, String>();
	}

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * abstract methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public abstract String getKey();

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * accessor methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getDefaultType() {
		return defaultType;
	}

	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}
	
	public Boolean hasContextType(String context) {
		return contextTypes.containsKey(context);
	}
	
	public String getContextType(String context) {
		return contextTypes.get(context);
	}

	public void addContextType(String context, String contextType) {
		contextTypes.put(context, contextType);
	}

	public void removeContextType(String context) {
		contextTypes.remove(context);
	}

}
