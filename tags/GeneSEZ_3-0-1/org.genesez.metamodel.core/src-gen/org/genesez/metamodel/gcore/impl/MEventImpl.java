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
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MEvent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MEventImpl#isIsCall <em>Is Call</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MEventImpl#isIsChange <em>Is Change</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MEventImpl#getOwningContext <em>Owning Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MEventImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MEventImpl extends MElementImpl implements MEvent
{
  /**
   * The default value of the '{@link #isIsCall() <em>Is Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCall()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsCall() <em>Is Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsCall()
   * @generated
   * @ordered
   */
  protected boolean isCall = IS_CALL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsChange() <em>Is Change</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsChange()
   * @generated
   * @ordered
   */
  protected static final boolean IS_CHANGE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsChange() <em>Is Change</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsChange()
   * @generated
   * @ordered
   */
  protected boolean isChange = IS_CHANGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected EList<MParameter> parameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MEventImpl()
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
    return GcorePackage.Literals.MEVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsCall()
  {
    return isCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsCall(boolean newIsCall)
  {
    boolean oldIsCall = isCall;
    isCall = newIsCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MEVENT__IS_CALL, oldIsCall, isCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsChange()
  {
    return isChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsChange(boolean newIsChange)
  {
    boolean oldIsChange = isChange;
    isChange = newIsChange;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MEVENT__IS_CHANGE, oldIsChange, isChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDefinitionContext getOwningContext()
  {
    if (eContainerFeatureID() != GcorePackage.MEVENT__OWNING_CONTEXT) return null;
    return (MDefinitionContext)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MParameter> getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentWithInverseEList<MParameter>(MParameter.class, this, GcorePackage.MEVENT__PARAMETER, GcorePackage.MPARAMETER__EVENT);
    }
    return parameter;
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
      case GcorePackage.MEVENT__OWNING_CONTEXT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MEVENT__OWNING_CONTEXT, msgs);
      case GcorePackage.MEVENT__PARAMETER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameter()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MEVENT__OWNING_CONTEXT:
        return eBasicSetContainer(null, GcorePackage.MEVENT__OWNING_CONTEXT, msgs);
      case GcorePackage.MEVENT__PARAMETER:
        return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MEVENT__OWNING_CONTEXT:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MDEFINITION_CONTEXT__EVENT, MDefinitionContext.class, msgs);
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
      case GcorePackage.MEVENT__IS_CALL:
        return isIsCall();
      case GcorePackage.MEVENT__IS_CHANGE:
        return isIsChange();
      case GcorePackage.MEVENT__OWNING_CONTEXT:
        return getOwningContext();
      case GcorePackage.MEVENT__PARAMETER:
        return getParameter();
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
      case GcorePackage.MEVENT__IS_CALL:
        setIsCall((Boolean)newValue);
        return;
      case GcorePackage.MEVENT__IS_CHANGE:
        setIsChange((Boolean)newValue);
        return;
      case GcorePackage.MEVENT__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection<? extends MParameter>)newValue);
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
      case GcorePackage.MEVENT__IS_CALL:
        setIsCall(IS_CALL_EDEFAULT);
        return;
      case GcorePackage.MEVENT__IS_CHANGE:
        setIsChange(IS_CHANGE_EDEFAULT);
        return;
      case GcorePackage.MEVENT__PARAMETER:
        getParameter().clear();
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
      case GcorePackage.MEVENT__IS_CALL:
        return isCall != IS_CALL_EDEFAULT;
      case GcorePackage.MEVENT__IS_CHANGE:
        return isChange != IS_CHANGE_EDEFAULT;
      case GcorePackage.MEVENT__OWNING_CONTEXT:
        return getOwningContext() != null;
      case GcorePackage.MEVENT__PARAMETER:
        return parameter != null && !parameter.isEmpty();
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
    result.append(" (isCall: ");
    result.append(isCall);
    result.append(", isChange: ");
    result.append(isChange);
    result.append(')');
    return result.toString();
  }

} //MEventImpl
