/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm.impl;

import codegenMm.CodegenMmPackage;
import codegenMm.MAssociationEnd;
import codegenMm.MAttribute;
import codegenMm.MClass;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegenMm.impl.MClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.impl.MClassImpl#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link codegenMm.impl.MClassImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link codegenMm.impl.MClassImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link codegenMm.impl.MClassImpl#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MClassImpl extends EObjectImpl implements MClass {
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
	 * The cached value of the '{@link #getAssociationEnd() <em>Association End</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected EList associationEnd = null;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList attribute = null;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected EList superClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CodegenMmPackage.Literals.MCLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MCLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociationEnd() {
		if (associationEnd == null) {
			associationEnd = new EObjectWithInverseResolvingEList(MAssociationEnd.class, this, CodegenMmPackage.MCLASS__ASSOCIATION_END, CodegenMmPackage.MASSOCIATION_END__CLASS);
		}
		return associationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage getOwningPackage() {
		if (eContainerFeatureID != CodegenMmPackage.MCLASS__OWNING_PACKAGE) return null;
		return (MPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningPackage(MPackage newOwningPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningPackage, CodegenMmPackage.MCLASS__OWNING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningPackage(MPackage newOwningPackage) {
		if (newOwningPackage != eInternalContainer() || (eContainerFeatureID != CodegenMmPackage.MCLASS__OWNING_PACKAGE && newOwningPackage != null)) {
			if (EcoreUtil.isAncestor(this, newOwningPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningPackage != null)
				msgs = ((InternalEObject)newOwningPackage).eInverseAdd(this, CodegenMmPackage.MPACKAGE__CLASS, MPackage.class, msgs);
			msgs = basicSetOwningPackage(newOwningPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MCLASS__OWNING_PACKAGE, newOwningPackage, newOwningPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentWithInverseEList(MAttribute.class, this, CodegenMmPackage.MCLASS__ATTRIBUTE, CodegenMmPackage.MATTRIBUTE__CLASS);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSuperClass() {
		if (superClass == null) {
			superClass = new EObjectResolvingEList(MClass.class, this, CodegenMmPackage.MCLASS__SUPER_CLASS);
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				return ((InternalEList)getAssociationEnd()).basicAdd(otherEnd, msgs);
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningPackage((MPackage)otherEnd, msgs);
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				return ((InternalEList)getAttribute()).basicAdd(otherEnd, msgs);
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
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				return ((InternalEList)getAssociationEnd()).basicRemove(otherEnd, msgs);
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				return basicSetOwningPackage(null, msgs);
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				return ((InternalEList)getAttribute()).basicRemove(otherEnd, msgs);
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
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, CodegenMmPackage.MPACKAGE__CLASS, MPackage.class, msgs);
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
			case CodegenMmPackage.MCLASS__NAME:
				return getName();
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				return getAssociationEnd();
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				return getOwningPackage();
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				return getAttribute();
			case CodegenMmPackage.MCLASS__SUPER_CLASS:
				return getSuperClass();
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
			case CodegenMmPackage.MCLASS__NAME:
				setName((String)newValue);
				return;
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				getAssociationEnd().clear();
				getAssociationEnd().addAll((Collection)newValue);
				return;
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				setOwningPackage((MPackage)newValue);
				return;
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection)newValue);
				return;
			case CodegenMmPackage.MCLASS__SUPER_CLASS:
				getSuperClass().clear();
				getSuperClass().addAll((Collection)newValue);
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
			case CodegenMmPackage.MCLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				getAssociationEnd().clear();
				return;
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				setOwningPackage((MPackage)null);
				return;
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				getAttribute().clear();
				return;
			case CodegenMmPackage.MCLASS__SUPER_CLASS:
				getSuperClass().clear();
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
			case CodegenMmPackage.MCLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegenMmPackage.MCLASS__ASSOCIATION_END:
				return associationEnd != null && !associationEnd.isEmpty();
			case CodegenMmPackage.MCLASS__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case CodegenMmPackage.MCLASS__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case CodegenMmPackage.MCLASS__SUPER_CLASS:
				return superClass != null && !superClass.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MClassImpl