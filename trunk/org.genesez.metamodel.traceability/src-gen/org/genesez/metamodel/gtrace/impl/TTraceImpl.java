/**
 */
package org.genesez.metamodel.gtrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.TTrace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTrace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TTraceImpl#getReviewed <em>Reviewed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TTraceImpl extends EObjectImpl implements TTrace
{
  /**
   * The default value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReviewed()
   * @generated
   * @ordered
   */
  protected static final String REVIEWED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReviewed() <em>Reviewed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReviewed()
   * @generated
   * @ordered
   */
  protected String reviewed = REVIEWED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TTraceImpl()
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
    return GtracePackage.Literals.TTRACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReviewed()
  {
    return reviewed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReviewed(String newReviewed)
  {
    String oldReviewed = reviewed;
    reviewed = newReviewed;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TTRACE__REVIEWED, oldReviewed, reviewed));
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
      case GtracePackage.TTRACE__REVIEWED:
        return getReviewed();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GtracePackage.TTRACE__REVIEWED:
        setReviewed((String)newValue);
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
      case GtracePackage.TTRACE__REVIEWED:
        setReviewed(REVIEWED_EDEFAULT);
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
      case GtracePackage.TTRACE__REVIEWED:
        return REVIEWED_EDEFAULT == null ? reviewed != null : !REVIEWED_EDEFAULT.equals(reviewed);
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
    result.append(" (reviewed: ");
    result.append(reviewed);
    result.append(')');
    return result.toString();
  }

} //TTraceImpl
