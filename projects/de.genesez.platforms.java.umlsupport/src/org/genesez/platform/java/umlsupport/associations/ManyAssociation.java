package org.genesez.platform.java.umlsupport.associations;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * implementation of a binary to-many association
 * 
 * @author georg beier
 * 
 * @param <From>
 *            one side of association
 * @param <To>
 *            other side of association
 */
public class ManyAssociation<From, To> extends AssociationBase<From, To> {

	Collection<To> ref;

	/**
	 * build unidirectional association
	 * 
	 * @param owner
	 *            object that owns this association end
	 * @param reference
	 *            collection field in the owner class that holds association
	 *            references
	 * 
	 */
	public ManyAssociation(From owner, Collection<To> reference) {
		super(owner);
		ref = reference;
	}

	/**
	 * build bidirectional association
	 * 
	 * @param owner
	 *            object that owns this association end
	 * @param reference
	 *            collection field in the owner class that holds association
	 *            references
	 * @param refClass
	 *            type of the referenced objects
	 * @param assocGetter
	 *            name of the getter method in the referenced type that gives
	 *            access to the other association end
	 * 
	 */
	public ManyAssociation(From owner, Collection<To> reference,
			RelatedAssociationRole opposite) {
		super(owner, opposite);
		ref = reference;
	}

//	@Override
	public To insert(To associated) {
		if (!getReference().contains(associated)) {
			getReference().add(associated);
			if (isSymmetric()) {
				((AssociationBase<To, From>) getRelatedAssociation(associated))
						.link(getOwner(), null);
			}
		}
		return associated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.Association#remove(java.lang.Object)
	 */
//	@Override
	public To remove(To associated) {
		if (getReference().contains(associated)) {
			getReference().remove(associated);
			if (isSymmetric()) {
				((AssociationBase<To, From>) getRelatedAssociation(associated))
						.unlink(getOwner());
			}
			return associated;
		}
		return null;
	}

//	@Override
	public To get() {
		if (ref.isEmpty())
			return null;
		else
			return ref.iterator().next();
	}
	
	public Collection<To> getAll() {
		return Collections.unmodifiableCollection(ref);
	}

//	@Override
	public Iterator<To> iterator() {
		return ref.iterator();
	}

	/**
	 * read access to the actual reference collection in the from object. Method
	 * should be implemented in an anonymous inner class inside the <From>
	 * object.
	 * 
	 * @return the referenced collection
	 */
	protected Collection<To> getReference() {
		return ref;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationBase#link(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected void link(To associated, Object assoc) {
		getReference().add(associated);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationBase#unlink(java.lang.Object)
	 */
	@Override
	protected void unlink(To associated) {
		getReference().remove(associated);
	}

}
