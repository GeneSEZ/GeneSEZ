/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PPackage;
import org.genesez.metamodel.gpresentation.PRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PRoot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PRootImpl#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PRootImpl extends PAbstractAreaImpl implements PRoot
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PRootImpl()
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
    return GpresentationPackage.Literals.PROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PPackage getOwningPackage()
  {
    if (eContainerFeatureID() != GpresentationPackage.PROOT__OWNING_PACKAGE) return null;
    return (PPackage)eContainer();
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
      case GpresentationPackage.PROOT__OWNING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GpresentationPackage.PROOT__OWNING_PACKAGE, msgs);
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
      case GpresentationPackage.PROOT__OWNING_PACKAGE:
        return eBasicSetContainer(null, GpresentationPackage.PROOT__OWNING_PACKAGE, msgs);
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
      case GpresentationPackage.PROOT__OWNING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GpresentationPackage.PPACKAGE__ROOTS, PPackage.class, msgs);
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
      case GpresentationPackage.PROOT__OWNING_PACKAGE:
        return getOwningPackage();
    }
    return super.eGet(featureID, resolve, coreType);
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
      case GpresentationPackage.PROOT__OWNING_PACKAGE:
        return getOwningPackage() != null;
    }
    return super.eIsSet(featureID);
  }

} //PRootImpl
