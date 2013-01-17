package org.genesez.platform.java.umlsupport.associations;

/**
 * abstract base class for all association implementations.
 * 
 * @author georg beier
 * 
 * @param <From>
 *            one side of association
 * @param <To>
 *            other side of association
 */
public abstract class AssociationBase<From, To> implements
		Association<From, To> {
	private boolean symmetric;
	private From owner;
//	private Method associationGetter;
	private RelatedAssociationRole opposite;

	/**
	 * build unidirectional association
	 * 
	 * @param owner
	 *            object on the FROM side
	 */
	public AssociationBase(From owner) {
		this.owner = owner;
		symmetric = false;
	}

	/**
	 * build bidirectional association
	 * 
	 * @param owner
	 *            object on the From side
	 * @param refClass
	 *            type of the To side
	 * @param assocGetter
	 *            name of getter function on the other side
	 */
	public AssociationBase(From owner, RelatedAssociationRole opposite) {
		this.owner = owner;
		symmetric = true;
		this.opposite = opposite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.Association#getOwner()
	 */
	protected From getOwner() {
		return owner;
	}

	/**
	 * read access to the other side of the association in the referenced class.
	 * Method should be implemented in an anonymous inner class inside the
	 * <From> object.
	 * 
	 * @param associated
	 *            the associated object
	 * @return linked association object on the other side of the association
	 */
	@SuppressWarnings("unchecked")
	protected Association<To, From> getRelatedAssociation(To associated) {
		if (!(associated instanceof AssociationRole)) {
			throw new RuntimeException("association is not symmetric");
		}
		AssociationRole obj = (AssociationRole)associated;
		Association<? extends Object, ? extends Object> assoc = obj.getAssociation(opposite);
		// we can do this cast because we know it's the inverse association
		return (Association<To, From>) assoc;
	}

	/**
	 * link the reverse direction of the association without symmetry check
	 * 
	 * @param associated
	 *            object on the other side
	 * @param assoc
	 *            association class object, ignored for normal binary
	 *            associations
	 */
	protected abstract void link(To associated, Object assoc);

	/**
	 * unlink the reverse direction of the association without symmetry check
	 * 
	 * @param associated
	 *            object on the other side
	 */
	protected abstract void unlink(To associated);

	/**
	 * test if association is symmetrically navigable
	 * 
	 * @return true if yes
	 */
	protected boolean isSymmetric() {
		return symmetric;
	}

	protected RelatedAssociationRole getOpposite() {
		return opposite;
	}
}
