/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MGeneric;
import genesezMM.MOperation;
import genesezMM.MParameter;
import genesezMM.MType;

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
 * An implementation of the model object '<em><b>MParameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MParameterImpl#getDefaultvalue <em>Defaultvalue</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link genesezMM.impl.MParameterImpl#getType <em>Type</em>}</li>
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
  protected MParameterImpl()
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
    return GenesezMMPackage.Literals.MPARAMETER;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__DEFAULTVALUE, oldDefaultvalue, defaultvalue));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__DIRECTION, oldDirection, direction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__MULTIPLICITY, oldMultiplicity, multiplicity));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__UNIQUE, oldUnique, unique));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation getOperation()
  {
    if (eContainerFeatureID != GenesezMMPackage.MPARAMETER__OPERATION) return null;
    return (MOperation)eContainer();
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
      genericRealization = new EObjectContainmentWithInverseEList(MGeneric.class, this, GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION, GenesezMMPackage.MGENERIC__OWNING_PARAMETER);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MPARAMETER__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPARAMETER__TYPE, oldType, type));
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
      case GenesezMMPackage.MPARAMETER__OPERATION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MPARAMETER__OPERATION, msgs);
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
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
      case GenesezMMPackage.MPARAMETER__OPERATION:
        return eBasicSetContainer(null, GenesezMMPackage.MPARAMETER__OPERATION, msgs);
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
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
      case GenesezMMPackage.MPARAMETER__OPERATION:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MOPERATION__PARAMETER, MOperation.class, msgs);
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
      case GenesezMMPackage.MPARAMETER__DEFAULTVALUE:
        return getDefaultvalue();
      case GenesezMMPackage.MPARAMETER__DIRECTION:
        return getDirection();
      case GenesezMMPackage.MPARAMETER__MULTIPLICITY:
        return new Integer(getMultiplicity());
      case GenesezMMPackage.MPARAMETER__UNIQUE:
        return isUnique() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MPARAMETER__ORDERED:
        return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MPARAMETER__OPERATION:
        return getOperation();
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
        return getGenericRealization();
      case GenesezMMPackage.MPARAMETER__TYPE:
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
      case GenesezMMPackage.MPARAMETER__DEFAULTVALUE:
        setDefaultvalue((String)newValue);
        return;
      case GenesezMMPackage.MPARAMETER__DIRECTION:
        setDirection((String)newValue);
        return;
      case GenesezMMPackage.MPARAMETER__MULTIPLICITY:
        setMultiplicity(((Integer)newValue).intValue());
        return;
      case GenesezMMPackage.MPARAMETER__UNIQUE:
        setUnique(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MPARAMETER__ORDERED:
        setOrdered(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
        getGenericRealization().clear();
        getGenericRealization().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPARAMETER__TYPE:
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
      case GenesezMMPackage.MPARAMETER__DEFAULTVALUE:
        setDefaultvalue(DEFAULTVALUE_EDEFAULT);
        return;
      case GenesezMMPackage.MPARAMETER__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case GenesezMMPackage.MPARAMETER__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case GenesezMMPackage.MPARAMETER__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case GenesezMMPackage.MPARAMETER__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
        getGenericRealization().clear();
        return;
      case GenesezMMPackage.MPARAMETER__TYPE:
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
      case GenesezMMPackage.MPARAMETER__DEFAULTVALUE:
        return DEFAULTVALUE_EDEFAULT == null ? defaultvalue != null : !DEFAULTVALUE_EDEFAULT.equals(defaultvalue);
      case GenesezMMPackage.MPARAMETER__DIRECTION:
        return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
      case GenesezMMPackage.MPARAMETER__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case GenesezMMPackage.MPARAMETER__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case GenesezMMPackage.MPARAMETER__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case GenesezMMPackage.MPARAMETER__OPERATION:
        return getOperation() != null;
      case GenesezMMPackage.MPARAMETER__GENERIC_REALIZATION:
        return genericRealization != null && !genericRealization.isEmpty();
      case GenesezMMPackage.MPARAMETER__TYPE:
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
    result.append(" (defaultvalue: ");
    result.append(defaultvalue);
    result.append(", direction: ");
    result.append(direction);
    result.append(", multiplicity: ");
    result.append(multiplicity);
    result.append(", unique: ");
    result.append(unique);
    result.append(", ordered: ");
    result.append(ordered);
    result.append(')');
    return result.toString();
  }

} //MParameterImpl
