/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PCompositeElement;
import org.genesez.metamodel.gpresentation.PElement;
import org.genesez.metamodel.gpresentation.PElementArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PElementImpl#getOwningArea <em>Owning Area</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PElementImpl#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PElementImpl extends PMetaDataAwareImpl implements PElement
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PElementImpl()
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
    return GpresentationPackage.Literals.PELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PElementArea getOwningArea()
  {
    if (eContainerFeatureID() != GpresentationPackage.PELEMENT__OWNING_AREA) return null;
    return (PElementArea)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PCompositeElement getOwningElement()
  {
    if (eContainerFeatureID() != GpresentationPackage.PELEMENT__OWNING_ELEMENT) return null;
    return (PCompositeElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GpresentationPackage.PELEMENT__OWNING_AREA:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GpresentationPackage.PELEMENT__OWNING_AREA, msgs);
      case GpresentationPackage.PELEMENT__OWNING_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GpresentationPackage.PELEMENT__OWNING_ELEMENT, msgs);
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
      case GpresentationPackage.PELEMENT__OWNING_AREA:
        return eBasicSetContainer(null, GpresentationPackage.PELEMENT__OWNING_AREA, msgs);
      case GpresentationPackage.PELEMENT__OWNING_ELEMENT:
        return eBasicSetContainer(null, GpresentationPackage.PELEMENT__OWNING_ELEMENT, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case GpresentationPackage.PELEMENT__OWNING_AREA:
        return eInternalContainer().eInverseRemove(this, GpresentationPackage.PELEMENT_AREA__NESTED_ELEMENTS, PElementArea.class, msgs);
      case GpresentationPackage.PELEMENT__OWNING_ELEMENT:
        return eInternalContainer().eInverseRemove(this, GpresentationPackage.PCOMPOSITE_ELEMENT__NESTED_ELEMENTS, PCompositeElement.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case GpresentationPackage.PELEMENT__NAME:
        return getName();
      case GpresentationPackage.PELEMENT__OWNING_AREA:
        return getOwningArea();
      case GpresentationPackage.PELEMENT__OWNING_ELEMENT:
        return getOwningElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GpresentationPackage.PELEMENT__NAME:
        setName((String)newValue);
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
      case GpresentationPackage.PELEMENT__NAME:
        setName(NAME_EDEFAULT);
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
      case GpresentationPackage.PELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GpresentationPackage.PELEMENT__OWNING_AREA:
        return getOwningArea() != null;
      case GpresentationPackage.PELEMENT__OWNING_ELEMENT:
        return getOwningElement() != null;
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

} //PElementImpl
