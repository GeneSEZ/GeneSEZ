/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.MParameter;
import org.genesez.metamodel.gcore.MType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MParameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getDefaultvalue <em>Defaultvalue</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getLowerBoundMultiplicity <em>Lower Bound Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getUpperBoundMultiplicity <em>Upper Bound Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MParameterImpl extends MElementImpl implements MParameter
{
  /**
   * The default value of the '{@link #getDefaultvalue() <em>Defaultvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultvalue()
   * @generated
   * @ordered
   */
  protected static final String DEFAULTVALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefaultvalue() <em>Defaultvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultvalue()
   * @generated
   * @ordered
   */
  protected String defaultvalue = DEFAULTVALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final String DIRECTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected String direction = DIRECTION_EDEFAULT;

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
   * The default value of the '{@link #getLowerBoundMultiplicity() <em>Lower Bound Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBoundMultiplicity()
   * @generated
   * @ordered
   */
  protected static final int LOWER_BOUND_MULTIPLICITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLowerBoundMultiplicity() <em>Lower Bound Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBoundMultiplicity()
   * @generated
   * @ordered
   */
  protected int lowerBoundMultiplicity = LOWER_BOUND_MULTIPLICITY_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBoundMultiplicity() <em>Upper Bound Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBoundMultiplicity()
   * @generated
   * @ordered
   */
  protected static final int UPPER_BOUND_MULTIPLICITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUpperBoundMultiplicity() <em>Upper Bound Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBoundMultiplicity()
   * @generated
   * @ordered
   */
  protected int upperBoundMultiplicity = UPPER_BOUND_MULTIPLICITY_EDEFAULT;

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
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected MOperation operation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MParameterImpl()
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
    return GcorePackage.Literals.MPARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultvalue()
  {
    return defaultvalue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultvalue(String newDefaultvalue)
  {
    String oldDefaultvalue = defaultvalue;
    defaultvalue = newDefaultvalue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__DEFAULTVALUE, oldDefaultvalue, defaultvalue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(String newDirection)
  {
    String oldDirection = direction;
    direction = newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__DIRECTION, oldDirection, direction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__MULTIPLICITY, oldMultiplicity, multiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLowerBoundMultiplicity()
  {
    return lowerBoundMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLowerBoundMultiplicity(int newLowerBoundMultiplicity)
  {
    int oldLowerBoundMultiplicity = lowerBoundMultiplicity;
    lowerBoundMultiplicity = newLowerBoundMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__LOWER_BOUND_MULTIPLICITY, oldLowerBoundMultiplicity, lowerBoundMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUpperBoundMultiplicity()
  {
    return upperBoundMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpperBoundMultiplicity(int newUpperBoundMultiplicity)
  {
    int oldUpperBoundMultiplicity = upperBoundMultiplicity;
    upperBoundMultiplicity = newUpperBoundMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__UPPER_BOUND_MULTIPLICITY, oldUpperBoundMultiplicity, upperBoundMultiplicity));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__UNIQUE, oldUnique, unique));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__ORDERED, oldOrdered, ordered));
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
      genericRealization = new EObjectContainmentWithInverseEList<MGeneric>(MGeneric.class, this, GcorePackage.MPARAMETER__GENERIC_REALIZATION, GcorePackage.MGENERIC__OWNING_PARAMETER);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MPARAMETER__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MEvent getEvent()
  {
    if (eContainerFeatureID() != GcorePackage.MPARAMETER__EVENT) return null;
    return (MEvent)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation getOperation()
  {
    if (operation != null && operation.eIsProxy())
    {
      InternalEObject oldOperation = (InternalEObject)operation;
      operation = (MOperation)eResolveProxy(oldOperation);
      if (operation != oldOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MPARAMETER__OPERATION, oldOperation, operation));
      }
    }
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation basicGetOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(MOperation newOperation)
  {
    MOperation oldOperation = operation;
    operation = newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MPARAMETER__OPERATION, oldOperation, operation));
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
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenericRealization()).basicAdd(otherEnd, msgs);
      case GcorePackage.MPARAMETER__EVENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MPARAMETER__EVENT, msgs);
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
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        return ((InternalEList<?>)getGenericRealization()).basicRemove(otherEnd, msgs);
      case GcorePackage.MPARAMETER__EVENT:
        return eBasicSetContainer(null, GcorePackage.MPARAMETER__EVENT, msgs);
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
      case GcorePackage.MPARAMETER__EVENT:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MEVENT__PARAMETER, MEvent.class, msgs);
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
      case GcorePackage.MPARAMETER__DEFAULTVALUE:
        return getDefaultvalue();
      case GcorePackage.MPARAMETER__DIRECTION:
        return getDirection();
      case GcorePackage.MPARAMETER__MULTIPLICITY:
        return getMultiplicity();
      case GcorePackage.MPARAMETER__LOWER_BOUND_MULTIPLICITY:
        return getLowerBoundMultiplicity();
      case GcorePackage.MPARAMETER__UPPER_BOUND_MULTIPLICITY:
        return getUpperBoundMultiplicity();
      case GcorePackage.MPARAMETER__UNIQUE:
        return isUnique();
      case GcorePackage.MPARAMETER__ORDERED:
        return isOrdered();
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        return getGenericRealization();
      case GcorePackage.MPARAMETER__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case GcorePackage.MPARAMETER__EVENT:
        return getEvent();
      case GcorePackage.MPARAMETER__OPERATION:
        if (resolve) return getOperation();
        return basicGetOperation();
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
      case GcorePackage.MPARAMETER__DEFAULTVALUE:
        setDefaultvalue((String)newValue);
        return;
      case GcorePackage.MPARAMETER__DIRECTION:
        setDirection((String)newValue);
        return;
      case GcorePackage.MPARAMETER__MULTIPLICITY:
        setMultiplicity((Integer)newValue);
        return;
      case GcorePackage.MPARAMETER__LOWER_BOUND_MULTIPLICITY:
        setLowerBoundMultiplicity((Integer)newValue);
        return;
      case GcorePackage.MPARAMETER__UPPER_BOUND_MULTIPLICITY:
        setUpperBoundMultiplicity((Integer)newValue);
        return;
      case GcorePackage.MPARAMETER__UNIQUE:
        setUnique((Boolean)newValue);
        return;
      case GcorePackage.MPARAMETER__ORDERED:
        setOrdered((Boolean)newValue);
        return;
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        getGenericRealization().clear();
        getGenericRealization().addAll((Collection<? extends MGeneric>)newValue);
        return;
      case GcorePackage.MPARAMETER__TYPE:
        setType((MType)newValue);
        return;
      case GcorePackage.MPARAMETER__OPERATION:
        setOperation((MOperation)newValue);
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
      case GcorePackage.MPARAMETER__DEFAULTVALUE:
        setDefaultvalue(DEFAULTVALUE_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__LOWER_BOUND_MULTIPLICITY:
        setLowerBoundMultiplicity(LOWER_BOUND_MULTIPLICITY_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__UPPER_BOUND_MULTIPLICITY:
        setUpperBoundMultiplicity(UPPER_BOUND_MULTIPLICITY_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        getGenericRealization().clear();
        return;
      case GcorePackage.MPARAMETER__TYPE:
        setType((MType)null);
        return;
      case GcorePackage.MPARAMETER__OPERATION:
        setOperation((MOperation)null);
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
      case GcorePackage.MPARAMETER__DEFAULTVALUE:
        return DEFAULTVALUE_EDEFAULT == null ? defaultvalue != null : !DEFAULTVALUE_EDEFAULT.equals(defaultvalue);
      case GcorePackage.MPARAMETER__DIRECTION:
        return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
      case GcorePackage.MPARAMETER__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case GcorePackage.MPARAMETER__LOWER_BOUND_MULTIPLICITY:
        return lowerBoundMultiplicity != LOWER_BOUND_MULTIPLICITY_EDEFAULT;
      case GcorePackage.MPARAMETER__UPPER_BOUND_MULTIPLICITY:
        return upperBoundMultiplicity != UPPER_BOUND_MULTIPLICITY_EDEFAULT;
      case GcorePackage.MPARAMETER__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case GcorePackage.MPARAMETER__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case GcorePackage.MPARAMETER__GENERIC_REALIZATION:
        return genericRealization != null && !genericRealization.isEmpty();
      case GcorePackage.MPARAMETER__TYPE:
        return type != null;
      case GcorePackage.MPARAMETER__EVENT:
        return getEvent() != null;
      case GcorePackage.MPARAMETER__OPERATION:
        return operation != null;
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
    result.append(" (defaultvalue: ");
    result.append(defaultvalue);
    result.append(", direction: ");
    result.append(direction);
    result.append(", multiplicity: ");
    result.append(multiplicity);
    result.append(", lowerBoundMultiplicity: ");
    result.append(lowerBoundMultiplicity);
    result.append(", upperBoundMultiplicity: ");
    result.append(upperBoundMultiplicity);
    result.append(", unique: ");
    result.append(unique);
    result.append(", ordered: ");
    result.append(ordered);
    result.append(')');
    return result.toString();
  }

} //MParameterImpl
