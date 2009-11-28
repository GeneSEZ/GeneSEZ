/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.impl;

import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MExternal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MExternalImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MExternalImpl#getModel <em>Model</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MExternalImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MExternalImpl extends MTypeImpl implements MExternal
{
  /**
   * The default value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected static final String SPECIFICATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected String specification = SPECIFICATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenericParameter() <em>Generic Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericParameter()
   * @generated
   * @ordered
   */
  protected EList genericParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MExternalImpl()
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
    return GcorePackage.Literals.MEXTERNAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSpecification()
  {
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecification(String newSpecification)
  {
    String oldSpecification = specification;
    specification = newSpecification;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MEXTERNAL__SPECIFICATION, oldSpecification, specification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel getModel()
  {
    if (eContainerFeatureID != GcorePackage.MEXTERNAL__MODEL) return null;
    return (MModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getGenericParameter()
  {
    if (genericParameter == null)
    {
      genericParameter = new EObjectContainmentWithInverseEList(MGeneric.class, this, GcorePackage.MEXTERNAL__GENERIC_PARAMETER, GcorePackage.MGENERIC__OWNING_EXTERNAL);
    }
    return genericParameter;
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
      case GcorePackage.MEXTERNAL__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MEXTERNAL__MODEL, msgs);
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return ((InternalEList)getGenericParameter()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MEXTERNAL__MODEL:
        return eBasicSetContainer(null, GcorePackage.MEXTERNAL__MODEL, msgs);
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return ((InternalEList)getGenericParameter()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MEXTERNAL__MODEL:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MMODEL__EXTERNAL_TYPES, MModel.class, msgs);
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
      case GcorePackage.MEXTERNAL__SPECIFICATION:
        return getSpecification();
      case GcorePackage.MEXTERNAL__MODEL:
        return getModel();
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return getGenericParameter();
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
      case GcorePackage.MEXTERNAL__SPECIFICATION:
        setSpecification((String)newValue);
        return;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection)newValue);
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
      case GcorePackage.MEXTERNAL__SPECIFICATION:
        setSpecification(SPECIFICATION_EDEFAULT);
        return;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        getGenericParameter().clear();
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
      case GcorePackage.MEXTERNAL__SPECIFICATION:
        return SPECIFICATION_EDEFAULT == null ? specification != null : !SPECIFICATION_EDEFAULT.equals(specification);
      case GcorePackage.MEXTERNAL__MODEL:
        return getModel() != null;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (specification: ");
    result.append(specification);
    result.append(')');
    return result.toString();
  }

} //MExternalImpl
