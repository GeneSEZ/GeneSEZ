/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MDependency;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDependencyImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDependencyImpl#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDependencyImpl#getClient <em>Client</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MDependencyImpl extends MElementImpl implements MDependency
{
  /**
   * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupplier()
   * @generated
   * @ordered
   */
  protected EList<MElement> supplier;

  /**
   * The cached value of the '{@link #getClient() <em>Client</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClient()
   * @generated
   * @ordered
   */
  protected EList<MElement> client;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MDependencyImpl()
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
    return GcorePackage.Literals.MDEPENDENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage getOwningPackage()
  {
    if (eContainerFeatureID() != GcorePackage.MDEPENDENCY__OWNING_PACKAGE) return null;
    return (MPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MElement> getSupplier()
  {
    if (supplier == null)
    {
      supplier = new EObjectResolvingEList<MElement>(MElement.class, this, GcorePackage.MDEPENDENCY__SUPPLIER);
    }
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MElement> getClient()
  {
    if (client == null)
    {
      client = new EObjectWithInverseResolvingEList.ManyInverse<MElement>(MElement.class, this, GcorePackage.MDEPENDENCY__CLIENT, GcorePackage.MELEMENT__DEPENDENCY);
    }
    return client;
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
      case GcorePackage.MDEPENDENCY__OWNING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MDEPENDENCY__OWNING_PACKAGE, msgs);
      case GcorePackage.MDEPENDENCY__CLIENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getClient()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MDEPENDENCY__OWNING_PACKAGE:
        return eBasicSetContainer(null, GcorePackage.MDEPENDENCY__OWNING_PACKAGE, msgs);
      case GcorePackage.MDEPENDENCY__CLIENT:
        return ((InternalEList<?>)getClient()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MDEPENDENCY__OWNING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MPACKAGE__OWNED_DEPENDENCY, MPackage.class, msgs);
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
      case GcorePackage.MDEPENDENCY__OWNING_PACKAGE:
        return getOwningPackage();
      case GcorePackage.MDEPENDENCY__SUPPLIER:
        return getSupplier();
      case GcorePackage.MDEPENDENCY__CLIENT:
        return getClient();
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
      case GcorePackage.MDEPENDENCY__SUPPLIER:
        getSupplier().clear();
        getSupplier().addAll((Collection<? extends MElement>)newValue);
        return;
      case GcorePackage.MDEPENDENCY__CLIENT:
        getClient().clear();
        getClient().addAll((Collection<? extends MElement>)newValue);
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
      case GcorePackage.MDEPENDENCY__SUPPLIER:
        getSupplier().clear();
        return;
      case GcorePackage.MDEPENDENCY__CLIENT:
        getClient().clear();
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
      case GcorePackage.MDEPENDENCY__OWNING_PACKAGE:
        return getOwningPackage() != null;
      case GcorePackage.MDEPENDENCY__SUPPLIER:
        return supplier != null && !supplier.isEmpty();
      case GcorePackage.MDEPENDENCY__CLIENT:
        return client != null && !client.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MDependencyImpl
