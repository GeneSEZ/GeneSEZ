package de.genesez.platforms.common.typemapping.mappingtypes;

/**
 * This class based on the implementation of the MappingType class and supports
 * the mapping of collection types.
 * 
 * @author nihe
 * @date 2008-02-18
 */
public class CollectionMappingType extends MappingType {
	
	/**
	 * Stores if the collection shall be unique or not.
	 */
	private Boolean unique = null;
	
	/**
	 * Stores if the collection shall be ordered or not.
	 */
	private Boolean ordered = null;
	
	/**
	 * Constructor which set the default mapping settings of a collection type.
	 * 
	 * @param defaultType the default type which is returned when no context is
	 *            given
	 */
	public CollectionMappingType(String defaultType) {
		this(true, false, defaultType);
	}
	
	/**
	 * Constructor which set the default mapping settings of a collection type.
	 * 
	 * @param unique true if the collection shall be unique otherwise false
	 * @param ordered true if the collection shall be ordered otherwise false
	 * @param defaultType the default type which is returned when no context is
	 *            given
	 */
	public CollectionMappingType(Boolean unique, Boolean ordered, String defaultType) {
		super("", defaultType);
		setUnique(unique);
		setOrdered(ordered);
	}
	
	/**
	 * Getter method which returns the unique identifier of the mapping.
	 * 
	 * @see de.genesez.platforms.common.typemapping.mappingtypes.MappingType#getKey()
	 */
	public String getKey() {
		return unique.toString() + ordered.toString();
	}
	
	/**
	 * Getter of the unique attribute.
	 * 
	 * @return true if the collection is unique otherwise false
	 */
	public Boolean getUnique() {
		return unique;
	}
	
	/**
	 * Setter of the unique attribute.
	 * 
	 * @param unique the new unique value
	 */
	private void setUnique(Boolean unique) {
		if (unique == null)
			this.unique = true;
		else
			this.unique = unique;
	}
	
	/**
	 * Getter of the ordered attribute.
	 * 
	 * @return true if the collection is ordered otherwise false
	 */
	public Boolean getOrdered() {
		return ordered;
	}
	
	/**
	 * Setter of the ordered attribute.
	 * @param ordered the new ordered value
	 */
	private void setOrdered(Boolean ordered) {
		if (ordered == null)
			this.ordered = false;
		else
			this.ordered = ordered;
	}
	
}
