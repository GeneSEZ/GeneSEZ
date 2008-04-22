/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MModel;
import genesezMM.MStereotype;
import genesezMM.MTag;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MStereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MStereotypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link genesezMM.impl.MStereotypeImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MStereotypeImpl extends MElementImpl implements MStereotype
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected EList property;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MStereotypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return GenesezMMPackage.Literals.MSTEREOTYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getProperty()
  {
    if (property == null)
    {
      property = new EObjectContainmentWithInverseEList(MTag.class, this, GenesezMMPackage.MSTEREOTYPE__PROPERTY, GenesezMMPackage.MTAG__STEREOTYPE);
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel getModel()
  {
    if (eContainerFeatureID != GenesezMMPackage.MSTEREOTYPE__MODEL) return null;
    return (MModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        return ((InternalEList)getProperty()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MSTEREOTYPE__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MSTEREOTYPE__MODEL, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        return ((InternalEList)getProperty()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MSTEREOTYPE__MODEL:
        return eBasicSetContainer(null, GenesezMMPackage.MSTEREOTYPE__MODEL, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__MODEL:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MMODEL__ANY_STEREOTYPE, MModel.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        return getProperty();
      case GenesezMMPackage.MSTEREOTYPE__MODEL:
        return getModel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        getProperty().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MSTEREOTYPE__PROPERTY:
        return property != null && !property.isEmpty();
      case GenesezMMPackage.MSTEREOTYPE__MODEL:
        return getModel() != null;
    }
    return super.eIsSet(featureID);
  }

} //MStereotypeImpl
