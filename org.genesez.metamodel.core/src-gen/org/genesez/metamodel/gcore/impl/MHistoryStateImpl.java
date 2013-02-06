/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MHistoryState;
import org.genesez.metamodel.gcore.MLeafState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MHistory State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MHistoryStateImpl#isDeep <em>Deep</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MHistoryStateImpl#getReachableHistory <em>Reachable History</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MHistoryStateImpl#getDefaultHistory <em>Default History</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MHistoryStateImpl extends MLeafStateImpl implements MHistoryState
{
  /**
   * The default value of the '{@link #isDeep() <em>Deep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDeep()
   * @generated
   * @ordered
   */
  protected static final boolean DEEP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDeep() <em>Deep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDeep()
   * @generated
   * @ordered
   */
  protected boolean deep = DEEP_EDEFAULT;

  /**
   * The cached value of the '{@link #getReachableHistory() <em>Reachable History</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReachableHistory()
   * @generated
   * @ordered
   */
  protected EList<MLeafState> reachableHistory;

  /**
   * The cached value of the '{@link #getDefaultHistory() <em>Default History</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultHistory()
   * @generated
   * @ordered
   */
  protected MLeafState defaultHistory;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MHistoryStateImpl()
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
    return GcorePackage.Literals.MHISTORY_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDeep()
  {
    return deep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeep(boolean newDeep)
  {
    boolean oldDeep = deep;
    deep = newDeep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MHISTORY_STATE__DEEP, oldDeep, deep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MLeafState> getReachableHistory()
  {
    if (reachableHistory == null)
    {
      reachableHistory = new EObjectResolvingEList<MLeafState>(MLeafState.class, this, GcorePackage.MHISTORY_STATE__REACHABLE_HISTORY);
    }
    return reachableHistory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState getDefaultHistory()
  {
    if (defaultHistory != null && defaultHistory.eIsProxy())
    {
      InternalEObject oldDefaultHistory = (InternalEObject)defaultHistory;
      defaultHistory = (MLeafState)eResolveProxy(oldDefaultHistory);
      if (defaultHistory != oldDefaultHistory)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY, oldDefaultHistory, defaultHistory));
      }
    }
    return defaultHistory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState basicGetDefaultHistory()
  {
    return defaultHistory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultHistory(MLeafState newDefaultHistory)
  {
    MLeafState oldDefaultHistory = defaultHistory;
    defaultHistory = newDefaultHistory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY, oldDefaultHistory, defaultHistory));
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
      case GcorePackage.MHISTORY_STATE__DEEP:
        return isDeep();
      case GcorePackage.MHISTORY_STATE__REACHABLE_HISTORY:
        return getReachableHistory();
      case GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY:
        if (resolve) return getDefaultHistory();
        return basicGetDefaultHistory();
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
      case GcorePackage.MHISTORY_STATE__DEEP:
        setDeep((Boolean)newValue);
        return;
      case GcorePackage.MHISTORY_STATE__REACHABLE_HISTORY:
        getReachableHistory().clear();
        getReachableHistory().addAll((Collection<? extends MLeafState>)newValue);
        return;
      case GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY:
        setDefaultHistory((MLeafState)newValue);
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
      case GcorePackage.MHISTORY_STATE__DEEP:
        setDeep(DEEP_EDEFAULT);
        return;
      case GcorePackage.MHISTORY_STATE__REACHABLE_HISTORY:
        getReachableHistory().clear();
        return;
      case GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY:
        setDefaultHistory((MLeafState)null);
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
      case GcorePackage.MHISTORY_STATE__DEEP:
        return deep != DEEP_EDEFAULT;
      case GcorePackage.MHISTORY_STATE__REACHABLE_HISTORY:
        return reachableHistory != null && !reachableHistory.isEmpty();
      case GcorePackage.MHISTORY_STATE__DEFAULT_HISTORY:
        return defaultHistory != null;
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
    result.append(" (deep: ");
    result.append(deep);
    result.append(')');
    return result.toString();
  }

} //MHistoryStateImpl
