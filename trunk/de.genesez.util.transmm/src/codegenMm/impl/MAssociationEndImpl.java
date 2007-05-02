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
import codegenMm.MClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link codegenMm.impl.MAssociationEndImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationEndImpl#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationEndImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationEndImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link codegenMm.impl.MAssociationEndImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAssociationEndImpl extends EObjectImpl implements MAssociationEnd {
	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MULTIPLICITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int multiplicity = MULTIPLICITY_EDEFAULT;

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
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected MClass class_ = null;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected MAssociationEnd opposite = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAssociationEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CodegenMmPackage.Literals.MASSOCIATION_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(int newMultiplicity) {
		int oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__MULTIPLICITY, oldMultiplicity, multiplicity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAssociation getAssociation() {
		if (eContainerFeatureID != CodegenMmPackage.MASSOCIATION_END__ASSOCIATION) return null;
		return (MAssociation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(MAssociation newAssociation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAssociation, CodegenMmPackage.MASSOCIATION_END__ASSOCIATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(MAssociation newAssociation) {
		if (newAssociation != eInternalContainer() || (eContainerFeatureID != CodegenMmPackage.MASSOCIATION_END__ASSOCIATION && newAssociation != null)) {
			if (EcoreUtil.isAncestor(this, newAssociation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, CodegenMmPackage.MASSOCIATION__END, MAssociation.class, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MClass getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (MClass)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegenMmPackage.MASSOCIATION_END__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MClass basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(MClass newClass, NotificationChain msgs) {
		MClass oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__CLASS, oldClass, newClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(MClass newClass) {
		if (newClass != class_) {
			NotificationChain msgs = null;
			if (class_ != null)
				msgs = ((InternalEObject)class_).eInverseRemove(this, CodegenMmPackage.MCLASS__ASSOCIATION_END, MClass.class, msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, CodegenMmPackage.MCLASS__ASSOCIATION_END, MClass.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAssociationEnd getOpposite() {
		if (opposite != null && opposite.eIsProxy()) {
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (MAssociationEnd)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CodegenMmPackage.MASSOCIATION_END__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAssociationEnd basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(MAssociationEnd newOpposite) {
		MAssociationEnd oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CodegenMmPackage.MASSOCIATION_END__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssociation((MAssociation)otherEnd, msgs);
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				if (class_ != null)
					msgs = ((InternalEObject)class_).eInverseRemove(this, CodegenMmPackage.MCLASS__ASSOCIATION_END, MClass.class, msgs);
				return basicSetClass((MClass)otherEnd, msgs);
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
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				return basicSetAssociation(null, msgs);
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				return basicSetClass(null, msgs);
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
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				return eInternalContainer().eInverseRemove(this, CodegenMmPackage.MASSOCIATION__END, MAssociation.class, msgs);
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
			case CodegenMmPackage.MASSOCIATION_END__MULTIPLICITY:
				return new Integer(getMultiplicity());
			case CodegenMmPackage.MASSOCIATION_END__NAME:
				return getName();
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				return getAssociation();
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case CodegenMmPackage.MASSOCIATION_END__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
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
			case CodegenMmPackage.MASSOCIATION_END__MULTIPLICITY:
				setMultiplicity(((Integer)newValue).intValue());
				return;
			case CodegenMmPackage.MASSOCIATION_END__NAME:
				setName((String)newValue);
				return;
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				setAssociation((MAssociation)newValue);
				return;
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				setClass((MClass)newValue);
				return;
			case CodegenMmPackage.MASSOCIATION_END__OPPOSITE:
				setOpposite((MAssociationEnd)newValue);
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
			case CodegenMmPackage.MASSOCIATION_END__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case CodegenMmPackage.MASSOCIATION_END__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				setAssociation((MAssociation)null);
				return;
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				setClass((MClass)null);
				return;
			case CodegenMmPackage.MASSOCIATION_END__OPPOSITE:
				setOpposite((MAssociationEnd)null);
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
			case CodegenMmPackage.MASSOCIATION_END__MULTIPLICITY:
				return multiplicity != MULTIPLICITY_EDEFAULT;
			case CodegenMmPackage.MASSOCIATION_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CodegenMmPackage.MASSOCIATION_END__ASSOCIATION:
				return getAssociation() != null;
			case CodegenMmPackage.MASSOCIATION_END__CLASS:
				return class_ != null;
			case CodegenMmPackage.MASSOCIATION_END__OPPOSITE:
				return opposite != null;
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
		result.append(" (multiplicity: ");
		result.append(multiplicity);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //MAssociationEndImpl