package org.genesez.platform.java.umlsupport.associations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * implementation of a binary to-one association 
 * 
 * @param <From>	one side of association
 * @param <To>		other side of association
 * 
 * @author georg beier
 * @author toh (last modified)
 */
public class OneAssociation<From, To> extends AssociationBase<From, To> {

	/** accessor object to the associated object */
	private Accessor<To> accessor;

	/**
	 * @param owner		object that owns this association end
	 * @param accessor	object providing access to the associated object
	 */
	public OneAssociation(From owner, Accessor<To> accessor) {
		super(owner);
		this.accessor = accessor;
	}

	/**
	 * @param owner		object that owns this association end
	 * @param accessor	object providing access to the associated object
	 * @param opposite	enumeration literal identifying the opposite of this association
	 */
	public OneAssociation(From owner, Accessor<To> accessor, RelatedAssociationRole opposite) {
		super(owner, opposite);
		this.accessor = accessor;
	}

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.Association#insert(java.lang.Object)
	 */
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

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.Association#remove(java.lang.Object)
	 */
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

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.Association#get()
	 */
	public To get() {
		return getReference();
	}
	
	/**
	 * @see org.genesez.platform.java.umlsupport.associations.Association#getAll()
	 */
	public Collection<To> getAll() {
		List<To> l = new ArrayList<To>();
		l.add(getReference());
		return Collections.unmodifiableCollection(l);
	}

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.Association#iterator()
	 */
	public Iterator<To> iterator() {
		return new OneIterator();
	}

	/**
	 * read access to the actual reference field in the from object.
	 * 
	 * @return the referenced object
	 */
	protected To getReference() {
		return accessor.get();
	}

	/**
	 * write access to the actual reference field in the from object.
	 * 
	 * @return the new referenced object
	 */
	protected To setReference(To newAssociated) {
		accessor.set(newAssociated);
		return accessor.get();
	}

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationBase#link(java.lang.Object, java.lang.Object)
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

	/**
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationBase#unlink(java.lang.Object)
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
	 */
	protected class OneIterator implements Iterator<To> {

		private boolean unused = true;

		/**
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return unused && getReference() != null;
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		public To next() {
			if (!unused)
				throw new NoSuchElementException();
			unused = false;
			return getReference();
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException(
					"remove not supported on OneIterator");
		}
	}
}
