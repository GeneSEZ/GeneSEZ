/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.impl;

import de.genesez.metamodel.genesezMM.GenesezMMPackage;
import de.genesez.metamodel.genesezMM.MClassifier;
import de.genesez.metamodel.genesezMM.MGeneric;
import de.genesez.metamodel.genesezMM.MProperty;
import de.genesez.metamodel.genesezMM.MType;

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
 * An implementation of the model object '<em><b>MProperty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MPropertyImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPropertyImpl extends MElementImpl implements MProperty
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
   * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected static final int MULTIPLICITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected int multiplicity = MULTIPLICITY_EDEFAULT;

  /**
   * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected boolean unique = UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected boolean ordered = ORDERED_EDEFAULT;

  /**
   * The cached value of the '{@link #getGenericRealization() <em>Generic Realization</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericRealization()
   * @generated
   * @ordered
   */
  protected EList genericRealization;

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
  protected EClass eStaticClass()
  {
    return GenesezMMPackage.Literals.MPROPERTY;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__VISIBILITY, oldVisibility, visibility));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(int newMultiplicity)
  {
    int oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__MULTIPLICITY, oldMultiplicity, multiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnique()
  {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique(boolean newUnique)
  {
    boolean oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__UNIQUE, oldUnique, unique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOrdered()
  {
    return ordered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrdered(boolean newOrdered)
  {
    boolean oldOrdered = ordered;
    ordered = newOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier getClassifier()
  {
    if (eContainerFeatureID != GenesezMMPackage.MPROPERTY__CLASSIFIER) return null;
    return (MClassifier)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getGenericRealization()
  {
    if (genericRealization == null)
    {
      genericRealization = new EObjectContainmentWithInverseEList(MGeneric.class, this, GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION, GenesezMMPackage.MGENERIC__OWNING_PROPERTY);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MPROPERTY__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPROPERTY__TYPE, oldType, type));
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
      case GenesezMMPackage.MPROPERTY__CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MPROPERTY__CLASSIFIER, msgs);
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        return ((InternalEList)getGenericRealization()).basicAdd(otherEnd, msgs);
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
      case GenesezMMPackage.MPROPERTY__CLASSIFIER:
        return eBasicSetContainer(null, GenesezMMPackage.MPROPERTY__CLASSIFIER, msgs);
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        return ((InternalEList)getGenericRealization()).basicRemove(otherEnd, msgs);
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
      case GenesezMMPackage.MPROPERTY__CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MCLASSIFIER__PROPERTY, MClassifier.class, msgs);
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
      case GenesezMMPackage.MPROPERTY__VISIBILITY:
        return getVisibility();
      case GenesezMMPackage.MPROPERTY__DERIVED:
        return isDerived() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MPROPERTY__MULTIPLICITY:
        return new Integer(getMultiplicity());
      case GenesezMMPackage.MPROPERTY__UNIQUE:
        return isUnique() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MPROPERTY__ORDERED:
        return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MPROPERTY__CLASSIFIER:
        return getClassifier();
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        return getGenericRealization();
      case GenesezMMPackage.MPROPERTY__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case GenesezMMPackage.MPROPERTY__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GenesezMMPackage.MPROPERTY__DERIVED:
        setDerived(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MPROPERTY__MULTIPLICITY:
        setMultiplicity(((Integer)newValue).intValue());
        return;
      case GenesezMMPackage.MPROPERTY__UNIQUE:
        setUnique(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MPROPERTY__ORDERED:
        setOrdered(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        getGenericRealization().clear();
        getGenericRealization().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPROPERTY__TYPE:
        setType((MType)newValue);
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
      case GenesezMMPackage.MPROPERTY__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GenesezMMPackage.MPROPERTY__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case GenesezMMPackage.MPROPERTY__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case GenesezMMPackage.MPROPERTY__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case GenesezMMPackage.MPROPERTY__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        getGenericRealization().clear();
        return;
      case GenesezMMPackage.MPROPERTY__TYPE:
        setType((MType)null);
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
      case GenesezMMPackage.MPROPERTY__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GenesezMMPackage.MPROPERTY__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case GenesezMMPackage.MPROPERTY__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case GenesezMMPackage.MPROPERTY__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case GenesezMMPackage.MPROPERTY__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case GenesezMMPackage.MPROPERTY__CLASSIFIER:
        return getClassifier() != null;
      case GenesezMMPackage.MPROPERTY__GENERIC_REALIZATION:
        return genericRealization != null && !genericRealization.isEmpty();
      case GenesezMMPackage.MPROPERTY__TYPE:
        return type != null;
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", derived: ");
    result.append(derived);
    result.append(", multiplicity: ");
    result.append(multiplicity);
    result.append(", unique: ");
    result.append(unique);
    result.append(", ordered: ");
    result.append(ordered);
    result.append(')');
    return result.toString();
  }

} //MPropertyImpl
