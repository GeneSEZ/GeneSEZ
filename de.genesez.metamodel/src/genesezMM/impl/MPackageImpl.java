/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MAssociation;
import genesezMM.MClassifier;
import genesezMM.MPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MPackageImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link genesezMM.impl.MPackageImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link genesezMM.impl.MPackageImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link genesezMM.impl.MPackageImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPackageImpl extends MElementImpl implements MPackage
{
  /**
   * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedPackage()
   * @generated
   * @ordered
   */
  protected EList nestedPackage;

  /**
   * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation()
   * @generated
   * @ordered
   */
  protected EList association;

  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected EList classifier;

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
  protected EClass eStaticClass()
  {
    return GenesezMMPackage.Literals.MPACKAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getNestedPackage()
  {
    if (nestedPackage == null)
    {
      nestedPackage = new EObjectContainmentWithInverseEList(MPackage.class, this, GenesezMMPackage.MPACKAGE__NESTED_PACKAGE, GenesezMMPackage.MPACKAGE__NESTING_PACKAGE);
    }
    return nestedPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage getNestingPackage()
  {
    if (eContainerFeatureID != GenesezMMPackage.MPACKAGE__NESTING_PACKAGE) return null;
    return (MPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getAssociation()
  {
    if (association == null)
    {
      association = new EObjectContainmentWithInverseEList(MAssociation.class, this, GenesezMMPackage.MPACKAGE__ASSOCIATION, GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE);
    }
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getClassifier()
  {
    if (classifier == null)
    {
      classifier = new EObjectContainmentWithInverseEList(MClassifier.class, this, GenesezMMPackage.MPACKAGE__CLASSIFIER, GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE);
    }
    return classifier;
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        return ((InternalEList)getNestedPackage()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MPACKAGE__NESTING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MPACKAGE__NESTING_PACKAGE, msgs);
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        return ((InternalEList)getAssociation()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        return ((InternalEList)getClassifier()).basicAdd(otherEnd, msgs);
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        return ((InternalEList)getNestedPackage()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MPACKAGE__NESTING_PACKAGE:
        return eBasicSetContainer(null, GenesezMMPackage.MPACKAGE__NESTING_PACKAGE, msgs);
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        return ((InternalEList)getAssociation()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        return ((InternalEList)getClassifier()).basicRemove(otherEnd, msgs);
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
      case GenesezMMPackage.MPACKAGE__NESTING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MPACKAGE__NESTED_PACKAGE, MPackage.class, msgs);
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        return getNestedPackage();
      case GenesezMMPackage.MPACKAGE__NESTING_PACKAGE:
        return getNestingPackage();
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        return getAssociation();
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        return getClassifier();
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        getNestedPackage().clear();
        getNestedPackage().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        getAssociation().clear();
        getAssociation().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        getClassifier().clear();
        getClassifier().addAll((Collection)newValue);
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        getNestedPackage().clear();
        return;
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        getAssociation().clear();
        return;
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        getClassifier().clear();
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
      case GenesezMMPackage.MPACKAGE__NESTED_PACKAGE:
        return nestedPackage != null && !nestedPackage.isEmpty();
      case GenesezMMPackage.MPACKAGE__NESTING_PACKAGE:
        return getNestingPackage() != null;
      case GenesezMMPackage.MPACKAGE__ASSOCIATION:
        return association != null && !association.isEmpty();
      case GenesezMMPackage.MPACKAGE__CLASSIFIER:
        return classifier != null && !classifier.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MPackageImpl
