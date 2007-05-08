/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm.impl;

import codegenMm.CodegenMmPackage;
import codegenMm.MAssociation;
import codegenMm.MAssociationEnd;

import codegenMm.MPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegenMm.impl.MAssociationImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationImpl#getEnd <em>End</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationImpl#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAssociationImpl extends EObjectImpl implements MAssociation {
	/**
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected EList end = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CodegenMmPackage.Literals.MASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION__DERIVED, oldDerived, derived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEnd() {
		if (end == null) {
			end = new EObjectContainmentWithInverseEList(MAssociationEnd.class, this, CodegenMmPackage.MASSOCIATION__END, CodegenMmPackage.MASSOCIATION_END__ASSOCIATION);
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage getOwningPackage() {
		if (eContainerFeatureID != CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE) return null;
		return (MPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPackage(MPackage newOwningPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningPackage, CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningPackage(MPackage newOwningPackage) {
		if (newOwningPackage != eInternalContainer() || (eContainerFeatureID != CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE && newOwningPackage != null)) {
			if (EcoreUtil.isAncestor(this, newOwningPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPackage != null)
				msgs = ((InternalEObject)newOwningPackage).eInverseAdd(this, CodegenMmPackage.MPACKAGE__ASSOCIATION, MPackage.class, msgs);
			msgs = basicSetOwningPackage(newOwningPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE, newOwningPackage, newOwningPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__END:
				return ((InternalEList)getEnd()).basicAdd(otherEnd, msgs);
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((MPackage)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__END:
				return ((InternalEList)getEnd()).basicRemove(otherEnd, msgs);
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, CodegenMmPackage.MPACKAGE__ASSOCIATION, MPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__DERIVED:
				return isDerived() ? Boolean.TRUE : Boolean.FALSE;
			case CodegenMmPackage.MASSOCIATION__NAME:
				return getName();
			case CodegenMmPackage.MASSOCIATION__END:
				return getEnd();
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				return getOwningPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__DERIVED:
				setDerived(((Boolean)newValue).booleanValue());
				return;
			case CodegenMmPackage.MASSOCIATION__NAME:
				setName((String)newValue);
				return;
			case CodegenMmPackage.MASSOCIATION__END:
				getEnd().clear();
				getEnd().addAll((Collection)newValue);
				return;
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				setOwningPackage((MPackage)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__DERIVED:
				setDerived(DERIVED_EDEFAULT);
				return;
			case CodegenMmPackage.MASSOCIATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegenMmPackage.MASSOCIATION__END:
				getEnd().clear();
				return;
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				setOwningPackage((MPackage)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION__DERIVED:
				return derived != DERIVED_EDEFAULT;
			case CodegenMmPackage.MASSOCIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegenMmPackage.MASSOCIATION__END:
				return end != null && !end.isEmpty();
			case CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE:
				return getOwningPackage() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (derived: ");
		result.append(derived);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MAssociationImpl