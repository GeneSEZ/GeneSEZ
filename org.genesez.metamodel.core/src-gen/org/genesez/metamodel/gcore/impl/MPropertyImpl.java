/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MMultiplicity;
import org.genesez.metamodel.gcore.MProperty;
import org.genesez.metamodel.gcore.MType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MProperty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MPropertyImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MPropertyImpl extends MElementImpl implements MProperty
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final String VISIBILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected String visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final boolean DERIVED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected boolean derived = DERIVED_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenericRealization() <em>Generic Realization</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericRealization()
   * @generated
   * @ordered
   */
  protected EList<MGeneric> genericRealization;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected MType type;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected MMultiplicity multiplicity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MPropertyImpl()
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
    return GcorePackage.Literals.MPROPERTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(String newVisibility)
  {
    String oldVisibility = visibility;
    visibility = newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPROPERTY__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDerived()
  {
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerived(boolean newDerived)
  {
    boolean oldDerived = derived;
    derived = newDerived;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPROPERTY__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier getClassifier()
  {
    if (eContainerFeatureID() != GcorePackage.MPROPERTY__CLASSIFIER) return null;
    return (MClassifier)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MGeneric> getGenericRealization()
  {
    if (genericRealization == null)
    {
      genericRealization = new EObjectContainmentWithInverseEList<MGeneric>(MGeneric.class, this, GcorePackage.MPROPERTY__GENERIC_REALIZATION, GcorePackage.MGENERIC__OWNING_PROPERTY);
    }
    return genericRealization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (MType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MPROPERTY__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(MType newType)
  {
    MType oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPROPERTY__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMultiplicity getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(MMultiplicity newMultiplicity, NotificationChain msgs)
  {
    MMultiplicity oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MPROPERTY__MULTIPLICITY, oldMultiplicity, newMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(MMultiplicity newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MPROPERTY__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MPROPERTY__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPROPERTY__MULTIPLICITY, newMultiplicity, newMultiplicity));
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
      case GcorePackage.MPROPERTY__CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MPROPERTY__CLASSIFIER, msgs);
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenericRealization()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MPROPERTY__CLASSIFIER:
        return eBasicSetContainer(null, GcorePackage.MPROPERTY__CLASSIFIER, msgs);
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        return ((InternalEList<?>)getGenericRealization()).basicRemove(otherEnd, msgs);
      case GcorePackage.MPROPERTY__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
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
      case GcorePackage.MPROPERTY__CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MCLASSIFIER__PROPERTY, MClassifier.class, msgs);
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
      case GcorePackage.MPROPERTY__VISIBILITY:
        return getVisibility();
      case GcorePackage.MPROPERTY__DERIVED:
        return isDerived();
      case GcorePackage.MPROPERTY__CLASSIFIER:
        return getClassifier();
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        return getGenericRealization();
      case GcorePackage.MPROPERTY__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case GcorePackage.MPROPERTY__MULTIPLICITY:
        return getMultiplicity();
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
      case GcorePackage.MPROPERTY__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GcorePackage.MPROPERTY__DERIVED:
        setDerived((Boolean)newValue);
        return;
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        getGenericRealization().clear();
        getGenericRealization().addAll((Collection<? extends MGeneric>)newValue);
        return;
      case GcorePackage.MPROPERTY__TYPE:
        setType((MType)newValue);
        return;
      case GcorePackage.MPROPERTY__MULTIPLICITY:
        setMultiplicity((MMultiplicity)newValue);
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
      case GcorePackage.MPROPERTY__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GcorePackage.MPROPERTY__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        getGenericRealization().clear();
        return;
      case GcorePackage.MPROPERTY__TYPE:
        setType((MType)null);
        return;
      case GcorePackage.MPROPERTY__MULTIPLICITY:
        setMultiplicity((MMultiplicity)null);
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
      case GcorePackage.MPROPERTY__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GcorePackage.MPROPERTY__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case GcorePackage.MPROPERTY__CLASSIFIER:
        return getClassifier() != null;
      case GcorePackage.MPROPERTY__GENERIC_REALIZATION:
        return genericRealization != null && !genericRealization.isEmpty();
      case GcorePackage.MPROPERTY__TYPE:
        return type != null;
      case GcorePackage.MPROPERTY__MULTIPLICITY:
        return multiplicity != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", derived: ");
    result.append(derived);
    result.append(')');
    return result.toString();
  }

} //MPropertyImpl
