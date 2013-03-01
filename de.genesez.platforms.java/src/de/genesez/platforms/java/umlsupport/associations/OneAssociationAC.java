/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

/**
 * implementation of a to-one association with association class
 * 
 * @param <From>	one side of association
 * @param <To>		other side of association
 * @param <Assoc>	association class type
 * 
 * @author georg beier
 * @author toh (last modified)
 */
public class OneAssociationAC<From, To, Assoc extends AssociationClass> extends
		OneAssociation<From, To> implements AssociationAC<From, To, Assoc> {

	/** provides access to the associated class object */
	private Accessor<Assoc> accessorAC;

	/**
	 * @param owner	object that owns this association end
	 * @param accessor	object providing access to the associated object
	 */
	public OneAssociationAC(From owner, Accessor<To> accessor, Accessor<Assoc> accessorAC) {
		super(owner, accessor);
		this.accessorAC = accessorAC;
	}

	/**
	 * @param owner		the owning object of the association
	 * @param opposite	enumeration literal identifying the opposite of this association
	 * @param accessor	object providing access to the associated object
	 */
	public OneAssociationAC(From owner, Accessor<To> accessor, Accessor<Assoc> accessorAC, RelatedAssociationRole opposite) {
		super(owner, accessor, opposite);
		this.accessorAC = accessorAC;
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationAC#insert(java.lang.Object, java.lang.Object)
	 */
	public To insert(To associated, Assoc aco) {
		linkAssoc(aco);
		insert(associated);
		return associated;
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.OneAssociation#remove(java.lang.Object)
	 */
	public To remove(To associated) {
		unlinkAssoc();
		return super.remove(associated);
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationAC#getAssoc(java.lang.Object)
	 */
	public Assoc getAssoc(To associated) {
		if (associated == getReference())
			return accessorAC.get();
		else
			return null;
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationAC#setAssoc(java.lang.Object, java.lang.Object)
	 */
	public Assoc setAssoc(To associated, Assoc assoc) {
		if (associated == getReference()) {
			linkAssoc(assoc);
			((AssociationBase<To, From>) getRelatedAssociation(associated))
					.link(getOwner(), getAssociationClassObject());
			return accessorAC.get();
		} else
			return null;
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.OneAssociation#link(java.lang.Object, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
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
		return accessorAC.get();
	}

	/**
	 * @see de.genesez.platforms.java.umlsupport.associations.OneAssociation#unlink(java.lang.Object)
	 */
	@Override
	protected void unlink(To associated) {
		unlinkAssoc();
		super.unlink(associated);
	}

	/**
	 * make a link in the association class to this association end
	 * 
	 * @param assoc	the association class object
	 */
	private void linkAssoc(Assoc assoc) {
		if (assoc != null) {
			unlinkAssoc();
			accessorAC.set(assoc);
			assoc.getAssociationClassLink().link(getOwner(), getOpposite());
		}
	}

	/**
	 * remove link in the association class to this association end
	 */
	private void unlinkAssoc() {
		if (accessorAC.get() != null)
			accessorAC.get().getAssociationClassLink().clear(getOpposite());
	}
}
