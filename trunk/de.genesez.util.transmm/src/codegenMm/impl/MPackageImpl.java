/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm.impl;

import codegenMm.CodegenMmPackage;
import codegenMm.MAssociation;
import codegenMm.MClass;
import codegenMm.MModel;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegenMm.impl.MPackageImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.impl.MPackageImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link codegenMm.impl.MPackageImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link codegenMm.impl.MPackageImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link codegenMm.impl.MPackageImpl#getModel <em>Model</em>}</li>
 *   <li>{@link codegenMm.impl.MPackageImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPackageImpl extends EObjectImpl implements MPackage {
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
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EList class_ = null;

	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList nestedPackage = null;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList association = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CodegenMmPackage.Literals.MPACKAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MPACKAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getClass_() {
		if (class_ == null) {
			class_ = new EObjectContainmentWithInverseEList(MClass.class, this, CodegenMmPackage.MPACKAGE__CLASS, CodegenMmPackage.MCLASS__OWNING_PACKAGE);
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectContainmentWithInverseEList(MPackage.class, this, CodegenMmPackage.MPACKAGE__NESTED_PACKAGE, CodegenMmPackage.MPACKAGE__NESTING_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage getNestingPackage() {
		if (eContainerFeatureID != CodegenMmPackage.MPACKAGE__NESTING_PACKAGE) return null;
		return (MPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestingPackage(MPackage newNestingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestingPackage, CodegenMmPackage.MPACKAGE__NESTING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingPackage(MPackage newNestingPackage) {
		if (newNestingPackage != eInternalContainer() || (eContainerFeatureID != CodegenMmPackage.MPACKAGE__NESTING_PACKAGE && newNestingPackage != null)) {
			if (EcoreUtil.isAncestor(this, newNestingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNestingPackage != null)
				msgs = ((InternalEObject)newNestingPackage).eInverseAdd(this, CodegenMmPackage.MPACKAGE__NESTED_PACKAGE, MPackage.class, msgs);
			msgs = basicSetNestingPackage(newNestingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MPACKAGE__NESTING_PACKAGE, newNestingPackage, newNestingPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MModel getModel() {
		if (eContainerFeatureID != CodegenMmPackage.MPACKAGE__MODEL) return null;
		return (MModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(MModel newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, CodegenMmPackage.MPACKAGE__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(MModel newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID != CodegenMmPackage.MPACKAGE__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, CodegenMmPackage.MMODEL__OWNED_PACKAGE, MModel.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MPACKAGE__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociation() {
		if (association == null) {
			association = new EObjectContainmentWithInverseEList(MAssociation.class, this, CodegenMmPackage.MPACKAGE__ASSOCIATION, CodegenMmPackage.MASSOCIATION__OWNING_PACKAGE);
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegenMmPackage.MPACKAGE__CLASS:
				return ((InternalEList)getClass_()).basicAdd(otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				return ((InternalEList)getNestedPackage()).basicAdd(otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNestingPackage((MPackage)otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModel((MModel)otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				return ((InternalEList)getAssociation()).basicAdd(otherEnd, msgs);
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
			case CodegenMmPackage.MPACKAGE__CLASS:
				return ((InternalEList)getClass_()).basicRemove(otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				return ((InternalEList)getNestedPackage()).basicRemove(otherEnd, msgs);
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case CodegenMmPackage.MPACKAGE__MODEL:
				return basicSetModel(null, msgs);
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				return ((InternalEList)getAssociation()).basicRemove(otherEnd, msgs);
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
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, CodegenMmPackage.MPACKAGE__NESTED_PACKAGE, MPackage.class, msgs);
			case CodegenMmPackage.MPACKAGE__MODEL:
				return eInternalContainer().eInverseRemove(this, CodegenMmPackage.MMODEL__OWNED_PACKAGE, MModel.class, msgs);
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
			case CodegenMmPackage.MPACKAGE__NAME:
				return getName();
			case CodegenMmPackage.MPACKAGE__CLASS:
				return getClass_();
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				return getNestedPackage();
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				return getNestingPackage();
			case CodegenMmPackage.MPACKAGE__MODEL:
				return getModel();
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				return getAssociation();
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
			case CodegenMmPackage.MPACKAGE__NAME:
				setName((String)newValue);
				return;
			case CodegenMmPackage.MPACKAGE__CLASS:
				getClass_().clear();
				getClass_().addAll((Collection)newValue);
				return;
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection)newValue);
				return;
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				setNestingPackage((MPackage)newValue);
				return;
			case CodegenMmPackage.MPACKAGE__MODEL:
				setModel((MModel)newValue);
				return;
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				getAssociation().clear();
				getAssociation().addAll((Collection)newValue);
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
			case CodegenMmPackage.MPACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegenMmPackage.MPACKAGE__CLASS:
				getClass_().clear();
				return;
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				setNestingPackage((MPackage)null);
				return;
			case CodegenMmPackage.MPACKAGE__MODEL:
				setModel((MModel)null);
				return;
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				getAssociation().clear();
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
			case CodegenMmPackage.MPACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegenMmPackage.MPACKAGE__CLASS:
				return class_ != null && !class_.isEmpty();
			case CodegenMmPackage.MPACKAGE__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case CodegenMmPackage.MPACKAGE__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case CodegenMmPackage.MPACKAGE__MODEL:
				return getModel() != null;
			case CodegenMmPackage.MPACKAGE__ASSOCIATION:
				return association != null && !association.isEmpty();
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

} //MPackageImpl