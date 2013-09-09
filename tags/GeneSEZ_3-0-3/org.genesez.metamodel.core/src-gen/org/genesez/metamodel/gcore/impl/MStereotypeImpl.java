/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.metamodel.gcore.MStereotype;
import org.genesez.metamodel.gcore.MTag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MStereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStereotypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStereotypeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStereotypeImpl#getGeneralization <em>Generalization</em>}</li>
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
  protected EList<MTag> property;

  /**
   * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralization()
   * @generated
   * @ordered
   */
  protected EList<MStereotype> generalization;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MSTEREOTYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTag> getProperty()
  {
    if (property == null)
    {
      property = new EObjectContainmentWithInverseEList<MTag>(MTag.class, this, GcorePackage.MSTEREOTYPE__PROPERTY, GcorePackage.MTAG__STEREOTYPE);
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
    if (eContainerFeatureID() != GcorePackage.MSTEREOTYPE__MODEL) return null;
    return (MModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MStereotype> getGeneralization()
  {
    if (generalization == null)
    {
      generalization = new EObjectResolvingEList<MStereotype>(MStereotype.class, this, GcorePackage.MSTEREOTYPE__GENERALIZATION);
    }
    return generalization;
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperty()).basicAdd(otherEnd, msgs);
      case GcorePackage.MSTEREOTYPE__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MSTEREOTYPE__MODEL, msgs);
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
      case GcorePackage.MSTEREOTYPE__MODEL:
        return eBasicSetContainer(null, GcorePackage.MSTEREOTYPE__MODEL, msgs);
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
      case GcorePackage.MSTEREOTYPE__MODEL:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MMODEL__ANY_STEREOTYPE, MModel.class, msgs);
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        return getProperty();
      case GcorePackage.MSTEREOTYPE__MODEL:
        return getModel();
      case GcorePackage.MSTEREOTYPE__GENERALIZATION:
        return getGeneralization();
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection<? extends MTag>)newValue);
        return;
      case GcorePackage.MSTEREOTYPE__GENERALIZATION:
        getGeneralization().clear();
        getGeneralization().addAll((Collection<? extends MStereotype>)newValue);
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        getProperty().clear();
        return;
      case GcorePackage.MSTEREOTYPE__GENERALIZATION:
        getGeneralization().clear();
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
      case GcorePackage.MSTEREOTYPE__PROPERTY:
        return property != null && !property.isEmpty();
      case GcorePackage.MSTEREOTYPE__MODEL:
        return getModel() != null;
      case GcorePackage.MSTEREOTYPE__GENERALIZATION:
        return generalization != null && !generalization.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MStereotypeImpl
