package de.genesez.common.typemapping.mappingtypes;

public class CollectionMappingType extends MappingType {

	private Boolean unique = null;
	private Boolean ordered = null;
		
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public CollectionMappingType(String defaultType) {
		this(true, false, defaultType);
	}
	
	public CollectionMappingType(Boolean unique, Boolean ordered, String defaultType) {
		super("", defaultType);
		setUnique(unique);
		setOrdered(ordered);
	}
		
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * implemented abstract methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	@Override
	public String getKey() {
		return unique.toString() + ordered.toString();
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * accessor methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public Boolean getUnique() {
		return unique;
	}

	public void setUnique(Boolean unique) {
		if (unique == null)
			this.unique = true;
		else
			this.unique = unique;
	}

	public Boolean getOrdered() {
		return ordered;
	}

	public void setOrdered(Boolean ordered) {
		if (ordered == null)
			this.ordered = false;
		else
			this.ordered = ordered;
	}

}
