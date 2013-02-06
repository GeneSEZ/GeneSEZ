/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAssociation;
import org.genesez.metamodel.gcore.MPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPackageImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPackageImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPackageImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPackageImpl extends MDefinitionContextImpl implements MPackage
{
  /**
   * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedPackage()
   * @generated
   * @ordered
   */
  protected EList<MPackage> nestedPackage;

  /**
   * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation()
   * @generated
   * @ordered
   */
  protected EList<MAssociation> association;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MPackageImpl()
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
    return GcorePackage.Literals.MPACKAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage getNestingPackage()
  {
    if (eContainerFeatureID() != GcorePackage.MPACKAGE__NESTING_PACKAGE) return null;
    return (MPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MPackage> getNestedPackage()
  {
    if (nestedPackage == null)
    {
      nestedPackage = new EObjectContainmentWithInverseEList<MPackage>(MPackage.class, this, GcorePackage.MPACKAGE__NESTED_PACKAGE, GcorePackage.MPACKAGE__NESTING_PACKAGE);
    }
    return nestedPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MAssociation> getAssociation()
  {
    if (association == null)
    {
      association = new EObjectContainmentWithInverseEList<MAssociation>(MAssociation.class, this, GcorePackage.MPACKAGE__ASSOCIATION, GcorePackage.MASSOCIATION__OWNING_PACKAGE);
    }
    return association;
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
      case GcorePackage.MPACKAGE__NESTING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MPACKAGE__NESTING_PACKAGE, msgs);
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackage()).basicAdd(otherEnd, msgs);
      case GcorePackage.MPACKAGE__ASSOCIATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociation()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MPACKAGE__NESTING_PACKAGE:
        return eBasicSetContainer(null, GcorePackage.MPACKAGE__NESTING_PACKAGE, msgs);
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
      case GcorePackage.MPACKAGE__ASSOCIATION:
        return ((InternalEList<?>)getAssociation()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MPACKAGE__NESTING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MPACKAGE__NESTED_PACKAGE, MPackage.class, msgs);
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
      case GcorePackage.MPACKAGE__NESTING_PACKAGE:
        return getNestingPackage();
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        return getNestedPackage();
      case GcorePackage.MPACKAGE__ASSOCIATION:
        return getAssociation();
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
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        getNestedPackage().clear();
        getNestedPackage().addAll((Collection<? extends MPackage>)newValue);
        return;
      case GcorePackage.MPACKAGE__ASSOCIATION:
        getAssociation().clear();
        getAssociation().addAll((Collection<? extends MAssociation>)newValue);
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
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        getNestedPackage().clear();
        return;
      case GcorePackage.MPACKAGE__ASSOCIATION:
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
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MPACKAGE__NESTING_PACKAGE:
        return getNestingPackage() != null;
      case GcorePackage.MPACKAGE__NESTED_PACKAGE:
        return nestedPackage != null && !nestedPackage.isEmpty();
      case GcorePackage.MPACKAGE__ASSOCIATION:
        return association != null && !association.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MPackageImpl
