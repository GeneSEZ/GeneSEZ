package association.simple;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_QFz0IJh3EeKA2py9a1_A4A) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Related implements Relatable {
	
	/** Stores the linked object of association '<em><b>bidiIfManyToOne</b></em>' */
	public Hubable bidiIfManyToOne;
	
	/** Stores the linked object of association '<em><b>bidiOneToOne</b></em>' */
	public Hub bidiOneToOne;
	
	/** Stores all linked objects of association '<em><b>bidiManyToMany</b></em>' */
	public java.util.Set<Hub> bidiManyToMany = new java.util.HashSet<Hub>();
	
	/** Stores all linked objects of association '<em><b>bidiSelfrefOneToMany</b></em>' */
	public java.util.Set<Related> bidiSelfrefOneToMany = new java.util.HashSet<Related>();
	
	/** Stores the linked object of association '<em><b>bidiSelfrefManyToOne</b></em>' */
	public Related bidiSelfrefManyToOne;
	
	/**
	 * Returns the linked object of association '<em><b>bidiIfManyToOne</b></em>'.
	 */
	public Hubable getBidiIfManyToOne() {
		return bidiIfManyToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiIfManyToOne</b></em>'.
	 * @param	bidiIfManyToOne	the object to associate.
	 */
	public void setBidiIfManyToOne(Hubable bidiIfManyToOne) {
		if (this.bidiIfManyToOne == bidiIfManyToOne) {
			return;
		}
		Hubable former = this.bidiIfManyToOne;
		this.bidiIfManyToOne = bidiIfManyToOne;
		if (former != null) {
			former.removeBidiIfOneToMany(this);
		}
		if (bidiIfManyToOne != null) {
			bidiIfManyToOne.addBidiIfOneToMany(this);
		}
	}
	
	/**
	 * Returns the linked object of association '<em><b>bidiOneToOne</b></em>'.
	 */
	public Hub getBidiOneToOne() {
		return bidiOneToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiOneToOne</b></em>'.
	 * @param	bidiOneToOne	the object to associate.
	 */
	public void setBidiOneToOne(Hub bidiOneToOne) {
		if (this.bidiOneToOne == bidiOneToOne) {
			return;
		}
		Hub former = this.bidiOneToOne;
		this.bidiOneToOne = bidiOneToOne;
		if (former != null) {
			former.setBidiOneToOne(null);
		}
		if (bidiOneToOne != null) {
			bidiOneToOne.setBidiOneToOne(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>bidiManyToMany</b></em>'.
	 */
	public java.util.Set<Hub> getBidiManyToMany() {
		return bidiManyToMany;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiManyToMany</b></em>'.
	 * @param	bidiManyToMany	the object to associate.
	 */
	public void addBidiManyToMany(Hub bidiManyToMany) {
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
	public void removeBidiManyToMany(Hub bidiManyToMany) {
		if (bidiManyToMany == null || !this.bidiManyToMany.contains(bidiManyToMany)) {
			return;
		}
		this.bidiManyToMany.remove(bidiManyToMany);
		bidiManyToMany.removeBidiManyToMany(this);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>bidiSelfrefOneToMany</b></em>'.
	 */
	public java.util.Set<Related> getBidiSelfrefOneToMany() {
		return bidiSelfrefOneToMany;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiSelfrefOneToMany</b></em>'.
	 * @param	bidiSelfrefOneToMany	the object to associate.
	 */
	public void addBidiSelfrefOneToMany(Related bidiSelfrefOneToMany) {
		if (bidiSelfrefOneToMany == null || this.bidiSelfrefOneToMany.contains(bidiSelfrefOneToMany)) {
			return;
		}
		this.bidiSelfrefOneToMany.add(bidiSelfrefOneToMany);
		bidiSelfrefOneToMany.setBidiSelfrefManyToOne(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>bidiSelfrefOneToMany</b></em>'.
	 * @param	bidiSelfrefOneToMany	the object to remove.
	 */
	public void removeBidiSelfrefOneToMany(Related bidiSelfrefOneToMany) {
		if (bidiSelfrefOneToMany == null || !this.bidiSelfrefOneToMany.contains(bidiSelfrefOneToMany)) {
			return;
		}
		this.bidiSelfrefOneToMany.remove(bidiSelfrefOneToMany);
		bidiSelfrefOneToMany.setBidiSelfrefManyToOne(null);
	}
	
	/**
	 * Returns the linked object of association '<em><b>bidiSelfrefManyToOne</b></em>'.
	 */
	public Related getBidiSelfrefManyToOne() {
		return bidiSelfrefManyToOne;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiSelfrefManyToOne</b></em>'.
	 * @param	bidiSelfrefManyToOne	the object to associate.
	 */
	public void setBidiSelfrefManyToOne(Related bidiSelfrefManyToOne) {
		if (this.bidiSelfrefManyToOne == bidiSelfrefManyToOne) {
			return;
		}
		Related former = this.bidiSelfrefManyToOne;
		this.bidiSelfrefManyToOne = bidiSelfrefManyToOne;
		if (former != null) {
			former.removeBidiSelfrefOneToMany(this);
		}
		if (bidiSelfrefManyToOne != null) {
			bidiSelfrefManyToOne.addBidiSelfrefOneToMany(this);
		}
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._QFz0IJh3EeKA2py9a1_A4A) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
