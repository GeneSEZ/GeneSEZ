package association.simple;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Oo0RsJh3EeKA2py9a1_A4A) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Hub implements Hubable {
	
	/** Stores all linked objects of association '<em><b>bidiIfOneToMany</b></em>' */
	public java.util.Set<Relatable> bidiIfOneToMany = new java.util.HashSet<Relatable>();
	
	/** Stores the linked object of association '<em><b>unidirectionalToOne</b></em>' */
	public Related unidirectionalToOne;
	
	/** Stores the linked object of association '<em><b>bidiOneToOne</b></em>' */
	public Related bidiOneToOne;
	
	/** Stores all linked objects of association '<em><b>unidirectionalToMany</b></em>' */
	public java.util.Set<Related> unidirectionalToMany = new java.util.HashSet<Related>();
	
	/** Stores all linked objects of association '<em><b>bidiManyToMany</b></em>' */
	public java.util.Set<Related> bidiManyToMany = new java.util.HashSet<Related>();
	
	/** Stores the linked object of association '<em><b>unidirectionalSelfrefToOne</b></em>' */
	public Hub unidirectionalSelfrefToOne;
	
	/**
	 * Returns all linked objects of association '<em><b>bidiIfOneToMany</b></em>'.
	 */
	public java.util.Set<Relatable> getBidiIfOneToMany() {
		return bidiIfOneToMany;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiIfOneToMany</b></em>'.
	 * @param	bidiIfOneToMany	the object to associate.
	 */
	public void addBidiIfOneToMany(Relatable bidiIfOneToMany) {
		if (bidiIfOneToMany == null || this.bidiIfOneToMany.contains(bidiIfOneToMany)) {
			return;
		}
		this.bidiIfOneToMany.add(bidiIfOneToMany);
		bidiIfOneToMany.setBidiIfManyToOne(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>bidiIfOneToMany</b></em>'.
	 * @param	bidiIfOneToMany	the object to remove.
	 */
	public void removeBidiIfOneToMany(Relatable bidiIfOneToMany) {
		if (bidiIfOneToMany == null || !this.bidiIfOneToMany.contains(bidiIfOneToMany)) {
			return;
		}
		this.bidiIfOneToMany.remove(bidiIfOneToMany);
		bidiIfOneToMany.setBidiIfManyToOne(null);
	}
	
	/**
	 * Returns the linked object of association '<em><b>unidirectionalToOne</b></em>'.
	 */
	public Related getUnidirectionalToOne() {
		return unidirectionalToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>unidirectionalToOne</b></em>'.
	 * @param	unidirectionalToOne	the object to associate.
	 */
	public void setUnidirectionalToOne(Related unidirectionalToOne) {
		if (this.unidirectionalToOne == unidirectionalToOne) {
			return;
		}
		this.unidirectionalToOne = unidirectionalToOne;
	}
	
	/**
	 * Returns the linked object of association '<em><b>bidiOneToOne</b></em>'.
	 */
	public Related getBidiOneToOne() {
		return bidiOneToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiOneToOne</b></em>'.
	 * @param	bidiOneToOne	the object to associate.
	 */
	public void setBidiOneToOne(Related bidiOneToOne) {
		if (this.bidiOneToOne == bidiOneToOne) {
			return;
		}
		Related former = this.bidiOneToOne;
		this.bidiOneToOne = bidiOneToOne;
		if (former != null) {
			former.setBidiOneToOne(null);
		}
		if (bidiOneToOne != null) {
			bidiOneToOne.setBidiOneToOne(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>unidirectionalToMany</b></em>'.
	 */
	public java.util.Set<Related> getUnidirectionalToMany() {
		return unidirectionalToMany;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>unidirectionalToMany</b></em>'.
	 * @param	unidirectionalToMany	the object to associate.
	 */
	public void addUnidirectionalToMany(Related unidirectionalToMany) {
		if (unidirectionalToMany == null || this.unidirectionalToMany.contains(unidirectionalToMany)) {
			return;
		}
		this.unidirectionalToMany.add(unidirectionalToMany);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>unidirectionalToMany</b></em>'.
	 * @param	unidirectionalToMany	the object to remove.
	 */
	public void removeUnidirectionalToMany(Related unidirectionalToMany) {
		if (unidirectionalToMany == null || !this.unidirectionalToMany.contains(unidirectionalToMany)) {
			return;
		}
		this.unidirectionalToMany.remove(unidirectionalToMany);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>bidiManyToMany</b></em>'.
	 */
	public java.util.Set<Related> getBidiManyToMany() {
		return bidiManyToMany;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiManyToMany</b></em>'.
	 * @param	bidiManyToMany	the object to associate.
	 */
	public void addBidiManyToMany(Related bidiManyToMany) {
		if (bidiManyToMany == null || this.bidiManyToMany.contains(bidiManyToMany)) {
			return;
		}
		this.bidiManyToMany.add(bidiManyToMany);
		bidiManyToMany.addBidiManyToMany(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>bidiManyToMany</b></em>'.
	 * @param	bidiManyToMany	the object to remove.
	 */
	public void removeBidiManyToMany(Related bidiManyToMany) {
		if (bidiManyToMany == null || !this.bidiManyToMany.contains(bidiManyToMany)) {
			return;
		}
		this.bidiManyToMany.remove(bidiManyToMany);
		bidiManyToMany.removeBidiManyToMany(this);
	}
	
	/**
	 * Returns the linked object of association '<em><b>unidirectionalSelfrefToOne</b></em>'.
	 */
	public Hub getUnidirectionalSelfrefToOne() {
		return unidirectionalSelfrefToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>unidirectionalSelfrefToOne</b></em>'.
	 * @param	unidirectionalSelfrefToOne	the object to associate.
	 */
	public void setUnidirectionalSelfrefToOne(Hub unidirectionalSelfrefToOne) {
		if (this.unidirectionalSelfrefToOne == unidirectionalSelfrefToOne) {
			return;
		}
		this.unidirectionalSelfrefToOne = unidirectionalSelfrefToOne;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._Oo0RsJh3EeKA2py9a1_A4A) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
