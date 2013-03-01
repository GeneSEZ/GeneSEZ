/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

import java.util.Map;

/**
 * @author georg beier
 * 
 */
/**
 * implementation of a to-many association with association class
 * 
 * @author georg beier
 * 
 * @param <From>
 *            one side of association
 * @param <To>
 *            other side of association
 * @param <Assoc>
 *            association class type
 */
public class ManyAssociationAC<From, To, Assoc extends AssociationClass>
		extends ManyAssociation<From, To> implements
		AssociationAC<From, To, Assoc> {

	private Map<To, Assoc> refMap;

	/**
	 * @param owner
	 * @param reference
	 */
	public ManyAssociationAC(From owner, Map<To, Assoc> reference) {
		super(owner, reference.keySet());
		refMap = reference;
	}

	/**
	 * @param owner
	 * @param reference
	 * @param refClass
	 * @param assocGetter
	 */
	public ManyAssociationAC(From owner, Map<To, Assoc> reference,
			RelatedAssociationRole opposite) {
		super(owner, reference.keySet(), opposite);
		refMap = reference;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationAC#getAssoc(java.lang.Object)
	 */
//	@Override
	public Assoc getAssoc(To associated) {
		return refMap.get(associated);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.ManyAssociation#insert(java.lang.Object)
	 */
//	@Override
	public To insert(To associated) {
		return insert(associated, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationAC#insert(java.lang.Object,
	 *      java.lang.Object)
	 */
//	@Override
	public To insert(To associated, Assoc aco) {
		if (!refMap.containsKey(associated)) {
			refMap.put(associated, aco);
			linkAssoc(aco);
		} else if (refMap.get(associated) != aco) {
			unlinkAssoc(refMap.get(associated));
			refMap.put(associated, aco);
			linkAssoc(aco);
		}
		if (isSymmetric()) {
			((AssociationBase<To, From>) getRelatedAssociation(associated))
					.link(getOwner(), aco);
		}
		return associated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationAC#setAssoc(java.lang.Object,
	 *      java.lang.Object)
	 */
//	@Override
	public Assoc setAssoc(To associated, Assoc assoc) {
		if (refMap.containsKey(associated) && refMap.get(associated) != assoc) {
			unlinkAssoc(refMap.get(associated));
			refMap.put(associated, assoc);
			linkAssoc(assoc);
			if (isSymmetric()) {
				((AssociationBase<To, From>) getRelatedAssociation(associated))
						.link(getOwner(), assoc);
			}
			return assoc;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.genesez.umlsupport.AssociationBase#link(java.lang.Object,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void link(To associated, Object assoc) {
		if (refMap.containsKey(associated) && refMap.get(associated) != assoc) {
			unlinkAssoc(refMap.get(associated));
		}
		refMap.put(associated, (Assoc) assoc);
		linkAssoc((Assoc) assoc);
	}

	/**
	 * make a link in the association class to this association end
	 * 
	 * @param assoc
	 *            the association class object
	 */
	private void linkAssoc(Assoc assoc) {
		if (assoc != null) {
			assoc.getAssociationClassLink().link(getOwner(), getOpposite());
		}
	}

	/**
	 * remove link in the association class to this association end
	 * 
	 * @param assoc
	 *            the association class object
	 */
	private void unlinkAssoc(Assoc assoc) {
		if (assoc != null)
			assoc.getAssociationClassLink().clear(getOpposite());
	}
}
