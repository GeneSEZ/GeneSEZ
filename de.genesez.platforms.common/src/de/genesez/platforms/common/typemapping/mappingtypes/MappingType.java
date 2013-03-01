package de.genesez.platforms.common.typemapping.mappingtypes;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a skeletal implementation of a mapping type, to minimize
 * the program code. The task of this class is, to store the model type and the
 * language specific mapping type. Furthermore, the context map stores all model
 * to language specific types based on a specific context.
 * 
 * @author nihe
 * @date 2008-02-18
 */
public abstract class MappingType {
	
	/**
	 * The type which shall be transformed (model type).
	 */
	private String map = null;
	
	/**
	 * The default mapping type which is returned when no context is given.
	 */
	private String defaultType = null;
	
	/**
	 * Context map which stores the mappings when specific contexts are given.
	 */
	private Map<String, String> contextTypes = null;
	
	/**
	 * Sole constructor which set the default mapping settings.
	 * 
	 * @param map the type which shall be transformed (model type)
	 * @param defaultType the default type which is returned when no context is
	 *            given
	 */
	public MappingType(String map, String defaultType) {
		setMap(map);
		setDefaultType(defaultType);
		contextTypes = new HashMap<String, String>();
	}
	
	/**
	 * Abstract getter method which returns the unique identifier of the
	 * mapping. Normally, it is set to the map type (model value).
	 * 
	 * @return the unique identifier of the mapping as String representation
	 */
	public abstract String getKey();
	
	/**
	 * Getter of the map attribute.
	 * 
	 * @return the map attribute as String representation
	 */
	public String getMap() {
		return map;
	}
	
	/**
	 * Setter of the map attribute.
	 * 
	 * @param map the new map value
	 */
	private void setMap(String map) {
		this.map = map;
	}
	
	/**
	 * Getter of the default mapping type.
	 * 
	 * @return the default mapping type as String representation
	 */
	public String getDefaultType() {
		return defaultType;
	}
	
	/**
	 * Setter of the default mapping type.
	 * 
	 * @param defaultType the new default mapping type
	 */
	private void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}
	
	/**
	 * Returns true if this context map contains a mapping for the specified
	 * context.
	 * 
	 * @param context the context to be tested
	 * @return true if this context map contains a mapping for the specific
	 *         context otherwise false
	 */
	public Boolean hasContextType(String context) {
		return contextTypes.containsKey(context);
	}
	
	/**
	 * Returns the mapping type to which the specified context is mapped in this
	 * context map, or null if the context map contains no mapping for this
	 * context.
	 * 
	 * @param context the context
	 * @return the mapping type as String representation
	 */
	public String getContextType(String context) {
		return contextTypes.get(context);
	}
	
	/**
	 * Associates the specified mapping type with the specified context in this
	 * context map. If the context map previously contained a mapping for this
	 * context, the old mapping type is replaced.
	 * 
	 * @param context the context
	 * @param contextType the mapping type
	 */
	public void addContextType(String context, String contextType) {
		contextTypes.put(context, contextType);
	}
	
	/**
	 * Removes the mapping for this context from this context map if present.
	 * 
	 * @param context the context
	 */
	public void removeContextType(String context) {
		contextTypes.remove(context);
	}
	
}
