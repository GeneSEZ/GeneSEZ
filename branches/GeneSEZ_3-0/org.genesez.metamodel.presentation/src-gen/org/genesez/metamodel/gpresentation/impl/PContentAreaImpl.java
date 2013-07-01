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
import org.genesez.metamodel.gpresentation.PAbstractArea;
import org.genesez.metamodel.gpresentation.PContentArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PContent Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PContentAreaImpl#getOwningArea <em>Owning Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PContentAreaImpl extends PMetaDataAwareImpl implements PContentArea
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PContentAreaImpl()
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
    return GpresentationPackage.Literals.PCONTENT_AREA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PAbstractArea getOwningArea()
  {
    if (eContainerFeatureID() != GpresentationPackage.PCONTENT_AREA__OWNING_AREA) return null;
    return (PAbstractArea)eContainer();
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
      case GpresentationPackage.PCONTENT_AREA__OWNING_AREA:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GpresentationPackage.PCONTENT_AREA__OWNING_AREA, msgs);
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
      case GpresentationPackage.PCONTENT_AREA__OWNING_AREA:
        return eBasicSetContainer(null, GpresentationPackage.PCONTENT_AREA__OWNING_AREA, msgs);
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
      case GpresentationPackage.PCONTENT_AREA__OWNING_AREA:
        return eInternalContainer().eInverseRemove(this, GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS, PAbstractArea.class, msgs);
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
      case GpresentationPackage.PCONTENT_AREA__OWNING_AREA:
        return getOwningArea();
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
      case GpresentationPackage.PCONTENT_AREA__OWNING_AREA:
        return getOwningArea() != null;
    }
    return super.eIsSet(featureID);
  }

} //PContentAreaImpl
