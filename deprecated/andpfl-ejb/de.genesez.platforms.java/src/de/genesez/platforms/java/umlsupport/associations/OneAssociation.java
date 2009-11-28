package de.genesez.platforms.java.umlsupport.associations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * implementation of a binary to-one association 
 * 
 * @author georg beier
 * 
 * @param <From>
 *            one side of association
 * @param <To>
 *            other side of association
 */
public class OneAssociation<From, To> extends AssociationBase<From, To> {

	/** reference to the associated object */
	private To ref;

	/**
	 * @param owner
	 *            object that owns this association end
	 */
	public OneAssociation(From owner) {
		super(owner);
	}

	/**
	 * @param owner
	 *            object that owns this association end
	 * @param refClass
	 *            type of the referenced objects
	 * @param assocGetter
	 *            name of the getter method in the referenced type that gives
	 *            access to the other association end
	 */
	public OneAssociation(From owner, RelatedAssociationRole opposite) {
		super(owner, opposite);
	}

//	@Override
	public To insert(To associated) {
		if (getReference() != associated) {
			if (isSymmetric()) {
				To to = getReference();
				setReference(associated);
				if (to != null)
					((AssociationBase<To, From>) getRelatedAssociation(to))
							.unlink(getOwner());
				((AssociationBase<To, From>) getRelatedAssociation(associated))
						.link(getOwner(), getAssociationClassObject());
			} else {
				setReference(associated);
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
		if (getReference() == associated) {
			if (isSymmetric()) {
				To to = getReference();
				setReference(null);
				((AssociationBase<To, From>) getRelatedAssociation(to))
						.unlink(getOwner());
			} else {
				setReference(null);
			}
			return associated;
		}
		return null;
	}

//	@Override
	public To get() {
		return getReference();
	}
	
	public Collection<To> getAll() {
		List<To> l = new ArrayList<To>();
		l.add(ref);
		return Collections.unmodifiableCollection(l);
	}

//	@Override
	public Iterator<To> iterator() {
		return new OneIterator();
	}

	/**
	 * read access to the actual reference field in the from object.
	 * 
	 * @return the referenced object
	 */
	protected To getReference() {
		return ref;
	}

	/**
	 * write access to the actual reference field in the from object.
	 * 
	 * @return the new referenced object
	 */
	protected To setReference(To newAssociated) {
		ref = newAssociated;
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
		if (isSymmetric()) {
			To to = getReference();
			if (to != null)
				((AssociationBase<To, From>) getRelatedAssociation(to))
						.unlink(getOwner());
		}
		setReference(associated);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationBase#unlink(java.lang.Object)
	 */
	@Override
	protected void unlink(To associated) {
		setReference(null);
	}

	/**
	 * access current association class object. Is supposed to be overridden in
	 * a derived class that has association class objects.
	 * 
	 * @return null
	 */
	protected Object getAssociationClassObject() {
		return null;
	}

	/**
	 * implement iterator interface for access to at most one single associated
	 * object
	 * 
	 * @author georg beier
	 * 
	 */
	protected class OneIterator implements Iterator<To> {

		private boolean unused = true;

//		@Override
		public boolean hasNext() {
			return unused && getReference() != null;
		}

//		@Override
		public To next() {
			if (!unused)
				throw new NoSuchElementException();
			unused = false;
			return getReference();
		}

//		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"remove not supported on OneIterator");
		}

	}

}
