/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.impl;

import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MPrimitiveType;
import de.genesez.metamodel.gcore.MStereotype;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MModelImpl#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MModelImpl#getAnyStereotype <em>Any Stereotype</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MModelImpl#getExternalTypes <em>External Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MModelImpl extends MPackageImpl implements MModel
{
  /**
   * The cached value of the '{@link #getPrimitiveTypes() <em>Primitive Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimitiveTypes()
   * @generated
   * @ordered
   */
  protected EList primitiveTypes;

  /**
   * The cached value of the '{@link #getAnyStereotype() <em>Any Stereotype</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyStereotype()
   * @generated
   * @ordered
   */
  protected EList anyStereotype;

  /**
   * The cached value of the '{@link #getExternalTypes() <em>External Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExternalTypes()
   * @generated
   * @ordered
   */
  protected EList externalTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MModelImpl()
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
    return GcorePackage.Literals.MMODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getPrimitiveTypes()
  {
    if (primitiveTypes == null)
    {
      primitiveTypes = new EObjectContainmentWithInverseEList(MPrimitiveType.class, this, GcorePackage.MMODEL__PRIMITIVE_TYPES, GcorePackage.MPRIMITIVE_TYPE__MODEL);
    }
    return primitiveTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getAnyStereotype()
  {
    if (anyStereotype == null)
    {
      anyStereotype = new EObjectContainmentWithInverseEList(MStereotype.class, this, GcorePackage.MMODEL__ANY_STEREOTYPE, GcorePackage.MSTEREOTYPE__MODEL);
    }
    return anyStereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getExternalTypes()
  {
    if (externalTypes == null)
    {
      externalTypes = new EObjectContainmentWithInverseEList(MExternal.class, this, GcorePackage.MMODEL__EXTERNAL_TYPES, GcorePackage.MEXTERNAL__MODEL);
    }
    return externalTypes;
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        return ((InternalEList)getPrimitiveTypes()).basicAdd(otherEnd, msgs);
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        return ((InternalEList)getAnyStereotype()).basicAdd(otherEnd, msgs);
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        return ((InternalEList)getExternalTypes()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        return ((InternalEList)getPrimitiveTypes()).basicRemove(otherEnd, msgs);
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        return ((InternalEList)getAnyStereotype()).basicRemove(otherEnd, msgs);
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        return ((InternalEList)getExternalTypes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        return getPrimitiveTypes();
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        return getAnyStereotype();
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        return getExternalTypes();
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
        getPrimitiveTypes().addAll((Collection)newValue);
        return;
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        getAnyStereotype().clear();
        getAnyStereotype().addAll((Collection)newValue);
        return;
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        getExternalTypes().clear();
        getExternalTypes().addAll((Collection)newValue);
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
        return;
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        getAnyStereotype().clear();
        return;
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        getExternalTypes().clear();
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
      case GcorePackage.MMODEL__PRIMITIVE_TYPES:
        return primitiveTypes != null && !primitiveTypes.isEmpty();
      case GcorePackage.MMODEL__ANY_STEREOTYPE:
        return anyStereotype != null && !anyStereotype.isEmpty();
      case GcorePackage.MMODEL__EXTERNAL_TYPES:
        return externalTypes != null && !externalTypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MModelImpl
