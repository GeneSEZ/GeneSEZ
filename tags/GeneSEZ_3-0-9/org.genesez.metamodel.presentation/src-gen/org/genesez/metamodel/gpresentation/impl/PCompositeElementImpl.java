/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PCompositeElement;
import org.genesez.metamodel.gpresentation.PElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PComposite Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PCompositeElementImpl#getNestedElements <em>Nested Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCompositeElementImpl extends PElementImpl implements PCompositeElement
{
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
  protected PCompositeElementImpl()
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
    return GpresentationPackage.Literals.PCOMPOSITE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PElement> getNestedElements()
  {
    if (nestedElements == null)
    {
      nestedElements = new EObjectContainmentWithInverseEList<PElement>(PElement.class, this, GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS, GpresentationPackage.PELEMENT__OWNING_ELEMENT);
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
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
    switch (featureID)
    {
      case GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS:
        return nestedElements != null && !nestedElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PCompositeElementImpl
