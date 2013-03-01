/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PElement;
import org.genesez.metamodel.gpresentation.PElementArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PElement Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PElementAreaImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PElementAreaImpl#getNestedElements <em>Nested Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PElementAreaImpl extends PContentAreaImpl implements PElementArea
{
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
	 * The cached value of the '{@link #getNestedElements() <em>Nested Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNestedElements()
	 * @generated
	 * @ordered
	 */
  protected EList<PElement> nestedElements;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PElementAreaImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return GpresentationPackage.Literals.PELEMENT_AREA;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PELEMENT_AREA__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PElement> getNestedElements()
  {
		if (nestedElements == null) {
			nestedElements = new EObjectContainmentWithInverseEList<PElement>(PElement.class, this, GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS, GpresentationPackage.PELEMENT__OWNING_AREA);
		}
		return nestedElements;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				return ((InternalEList<?>)getNestedElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NAME:
				return getName();
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				return getNestedElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NAME:
				setName((String)newValue);
				return;
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				getNestedElements().clear();
				getNestedElements().addAll((Collection<? extends PElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				getNestedElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case GpresentationPackage.PELEMENT_AREA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS:
				return nestedElements != null && !nestedElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PElementAreaImpl
