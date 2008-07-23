/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

/**
 * implementation of a to-one association with association class
 * 
 * @author georg beier
 * 
 * @param <From>
 *            one side of association
 * @param <To>
 *            other side of association
 * @param <Assoc>
 *            association class type
 * 
 */
public class OneAssociationAC<From, To, Assoc extends AssociationClass> extends
		OneAssociation<From, To> implements AssociationAC<From, To, Assoc> {

	/** reference to the association class object */
	private Assoc assocObject;

	/**
	 * @param owner
	 *            object that owns this association end
	 */
	public OneAssociationAC(From owner) {
		super(owner);
	}

	/**
	 * @param owner
	 *            the owning object of the association
	 * @param refClass
	 *            the referenced class on the other side of the association
	 * @param assocGetter
	 *            name of the accessor method that returns the opposite
	 *            association end
	 */
	public OneAssociationAC(From owner, RelatedAssociationRole opposite) {
		super(owner, opposite);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.TernaryAssociation#insert(java.lang.Object,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
//	@Override
	public To insert(To associated, Assoc aco) {
		linkAssoc(aco);
		insert(associated);
		return associated;
	}

//	@Override
	public To remove(To associated) {
		unlinkAssoc();
		return super.remove(associated);
	}

//	@Override
	public Assoc getAssoc(To associated) {
		if (associated == getReference())
			return assocObject;
		else
			return null;
	}

//	@Override
	public Assoc setAssoc(To associated, Assoc assoc) {
		if (associated == getReference()) {
			// unlinkAssoc();
			linkAssoc(assoc);
			((AssociationBase<To, From>) getRelatedAssociation(associated))
					.link(getOwner(), getAssociationClassObject());
			return assocObject;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.OneAssociation#link(java.lang.Object,
	 *      java.lang.Object)
	 */
	protected void link(To associated, Object assoc) {
		if (isSymmetric()) {
			To to = getReference();
			if (to != null && to != associated)
				((AssociationBase<To, From>) getRelatedAssociation(to))
						.unlink(getOwner());
		}
		setReference(associated);
		linkAssoc((Assoc) assoc);
		// super.link(associated, assoc);
	}

	/**
	 * access current association class object.
	 * 
	 * @return the currently linked association class object
	 */
	protected AssociationClass getAssociationClassObject() {
		return assocObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationBase#unlink(java.lang.Object)
	 */
	@Override
	protected void unlink(To associated) {
		unlinkAssoc();
		super.unlink(associated);
	}

	/**
	 * make a link in the association class to this association end
	 * 
	 * @param assoc
	 *            the association class object
	 */
	private void linkAssoc(Assoc assoc) {
		if (assoc != null) {
			unlinkAssoc();
			assocObject = assoc;
			assoc.getAssociationClassLink().link(getOwner(), getOpposite());
		}
	}

	/**
	 * remove link in the association class to this association end
	 * 
	 */
	private void unlinkAssoc() {
		if (assocObject != null)
			assocObject.getAssociationClassLink().clear(getOpposite());
	}
}
