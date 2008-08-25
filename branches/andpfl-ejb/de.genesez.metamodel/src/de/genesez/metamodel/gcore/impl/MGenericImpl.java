/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.impl;

import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MParameter;
import de.genesez.metamodel.gcore.MProperty;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MGeneric</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getOwningClassifier <em>Owning Classifier</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getOwningOperation <em>Owning Operation</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getOwningProperty <em>Owning Property</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getOwningParameter <em>Owning Parameter</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.impl.MGenericImpl#getOwningExternal <em>Owning External</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MGenericImpl extends MTypeImpl implements MGeneric
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MGenericImpl()
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
    return GcorePackage.Literals.MGENERIC;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MGENERIC__SPECIFICATION, oldSpecification, specification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier getOwningClassifier()
  {
    if (eContainerFeatureID != GcorePackage.MGENERIC__OWNING_CLASSIFIER) return null;
    return (MClassifier)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation getOwningOperation()
  {
    if (eContainerFeatureID != GcorePackage.MGENERIC__OWNING_OPERATION) return null;
    return (MOperation)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MProperty getOwningProperty()
  {
    if (eContainerFeatureID != GcorePackage.MGENERIC__OWNING_PROPERTY) return null;
    return (MProperty)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MParameter getOwningParameter()
  {
    if (eContainerFeatureID != GcorePackage.MGENERIC__OWNING_PARAMETER) return null;
    return (MParameter)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MExternal getOwningExternal()
  {
    if (eContainerFeatureID != GcorePackage.MGENERIC__OWNING_EXTERNAL) return null;
    return (MExternal)eContainer();
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
      case GcorePackage.MGENERIC__OWNING_CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MGENERIC__OWNING_CLASSIFIER, msgs);
      case GcorePackage.MGENERIC__OWNING_OPERATION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MGENERIC__OWNING_OPERATION, msgs);
      case GcorePackage.MGENERIC__OWNING_PROPERTY:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MGENERIC__OWNING_PROPERTY, msgs);
      case GcorePackage.MGENERIC__OWNING_PARAMETER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MGENERIC__OWNING_PARAMETER, msgs);
      case GcorePackage.MGENERIC__OWNING_EXTERNAL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MGENERIC__OWNING_EXTERNAL, msgs);
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
      case GcorePackage.MGENERIC__OWNING_CLASSIFIER:
        return eBasicSetContainer(null, GcorePackage.MGENERIC__OWNING_CLASSIFIER, msgs);
      case GcorePackage.MGENERIC__OWNING_OPERATION:
        return eBasicSetContainer(null, GcorePackage.MGENERIC__OWNING_OPERATION, msgs);
      case GcorePackage.MGENERIC__OWNING_PROPERTY:
        return eBasicSetContainer(null, GcorePackage.MGENERIC__OWNING_PROPERTY, msgs);
      case GcorePackage.MGENERIC__OWNING_PARAMETER:
        return eBasicSetContainer(null, GcorePackage.MGENERIC__OWNING_PARAMETER, msgs);
      case GcorePackage.MGENERIC__OWNING_EXTERNAL:
        return eBasicSetContainer(null, GcorePackage.MGENERIC__OWNING_EXTERNAL, msgs);
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
      case GcorePackage.MGENERIC__OWNING_CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MCLASSIFIER__GENERIC_PARAMETER, MClassifier.class, msgs);
      case GcorePackage.MGENERIC__OWNING_OPERATION:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MOPERATION__GENERIC_PARAMETER, MOperation.class, msgs);
      case GcorePackage.MGENERIC__OWNING_PROPERTY:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MPROPERTY__GENERIC_REALIZATION, MProperty.class, msgs);
      case GcorePackage.MGENERIC__OWNING_PARAMETER:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MPARAMETER__GENERIC_REALIZATION, MParameter.class, msgs);
      case GcorePackage.MGENERIC__OWNING_EXTERNAL:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MEXTERNAL__GENERIC_PARAMETER, MExternal.class, msgs);
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
      case GcorePackage.MGENERIC__SPECIFICATION:
        return getSpecification();
      case GcorePackage.MGENERIC__OWNING_CLASSIFIER:
        return getOwningClassifier();
      case GcorePackage.MGENERIC__OWNING_OPERATION:
        return getOwningOperation();
      case GcorePackage.MGENERIC__OWNING_PROPERTY:
        return getOwningProperty();
      case GcorePackage.MGENERIC__OWNING_PARAMETER:
        return getOwningParameter();
      case GcorePackage.MGENERIC__OWNING_EXTERNAL:
        return getOwningExternal();
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
      case GcorePackage.MGENERIC__SPECIFICATION:
        setSpecification((String)newValue);
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
      case GcorePackage.MGENERIC__SPECIFICATION:
        setSpecification(SPECIFICATION_EDEFAULT);
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
      case GcorePackage.MGENERIC__SPECIFICATION:
        return SPECIFICATION_EDEFAULT == null ? specification != null : !SPECIFICATION_EDEFAULT.equals(specification);
      case GcorePackage.MGENERIC__OWNING_CLASSIFIER:
        return getOwningClassifier() != null;
      case GcorePackage.MGENERIC__OWNING_OPERATION:
        return getOwningOperation() != null;
      case GcorePackage.MGENERIC__OWNING_PROPERTY:
        return getOwningProperty() != null;
      case GcorePackage.MGENERIC__OWNING_PARAMETER:
        return getOwningParameter() != null;
      case GcorePackage.MGENERIC__OWNING_EXTERNAL:
        return getOwningExternal() != null;
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

} //MGenericImpl
