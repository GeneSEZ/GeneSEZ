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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGuard;
import org.genesez.metamodel.gcore.MState;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.gcore.MTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MTransition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTransitionImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MTransitionImpl extends MElementImpl implements MTransition
{
  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final String KIND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected String kind = KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected MState source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected MState target;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected MGuard guard;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected EList<MEvent> trigger;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected MBehavior action;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MTransitionImpl()
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
    return GcorePackage.Literals.MTRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(String newKind)
  {
    String oldKind = kind;
    kind = newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (MState)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTRANSITION__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(MState newSource, NotificationChain msgs)
  {
    MState oldSource = source;
    source = newSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(MState newSource)
  {
    if (newSource != source)
    {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, GcorePackage.MSTATE__OUTGOING, MState.class, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, GcorePackage.MSTATE__OUTGOING, MState.class, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (MState)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTRANSITION__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(MState newTarget, NotificationChain msgs)
  {
    MState oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(MState newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, GcorePackage.MSTATE__INCOMING, MState.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, GcorePackage.MSTATE__INCOMING, MState.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MGuard getGuard()
  {
    if (guard != null && guard.eIsProxy())
    {
      InternalEObject oldGuard = (InternalEObject)guard;
      guard = (MGuard)eResolveProxy(oldGuard);
      if (guard != oldGuard)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTRANSITION__GUARD, oldGuard, guard));
      }
    }
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MGuard basicGetGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(MGuard newGuard, NotificationChain msgs)
  {
    MGuard oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(MGuard newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, GcorePackage.MGUARD__TRANSITION, MGuard.class, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, GcorePackage.MGUARD__TRANSITION, MGuard.class, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine getStatemachine()
  {
    if (eContainerFeatureID() != GcorePackage.MTRANSITION__STATEMACHINE) return null;
    return (MStateMachine)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MEvent> getTrigger()
  {
    if (trigger == null)
    {
      trigger = new EObjectResolvingEList<MEvent>(MEvent.class, this, GcorePackage.MTRANSITION__TRIGGER);
    }
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior getAction()
  {
    if (action != null && action.eIsProxy())
    {
      InternalEObject oldAction = (InternalEObject)action;
      action = (MBehavior)eResolveProxy(oldAction);
      if (action != oldAction)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTRANSITION__ACTION, oldAction, action));
      }
    }
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior basicGetAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(MBehavior newAction, NotificationChain msgs)
  {
    MBehavior oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(MBehavior newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, GcorePackage.MBEHAVIOR__TRANSITION, MBehavior.class, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, GcorePackage.MBEHAVIOR__TRANSITION, MBehavior.class, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTRANSITION__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GcorePackage.MTRANSITION__SOURCE:
        if (source != null)
          msgs = ((InternalEObject)source).eInverseRemove(this, GcorePackage.MSTATE__OUTGOING, MState.class, msgs);
        return basicSetSource((MState)otherEnd, msgs);
      case GcorePackage.MTRANSITION__TARGET:
        if (target != null)
          msgs = ((InternalEObject)target).eInverseRemove(this, GcorePackage.MSTATE__INCOMING, MState.class, msgs);
        return basicSetTarget((MState)otherEnd, msgs);
      case GcorePackage.MTRANSITION__GUARD:
        if (guard != null)
          msgs = ((InternalEObject)guard).eInverseRemove(this, GcorePackage.MGUARD__TRANSITION, MGuard.class, msgs);
        return basicSetGuard((MGuard)otherEnd, msgs);
      case GcorePackage.MTRANSITION__STATEMACHINE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MTRANSITION__STATEMACHINE, msgs);
      case GcorePackage.MTRANSITION__ACTION:
        if (action != null)
          msgs = ((InternalEObject)action).eInverseRemove(this, GcorePackage.MBEHAVIOR__TRANSITION, MBehavior.class, msgs);
        return basicSetAction((MBehavior)otherEnd, msgs);
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
      case GcorePackage.MTRANSITION__SOURCE:
        return basicSetSource(null, msgs);
      case GcorePackage.MTRANSITION__TARGET:
        return basicSetTarget(null, msgs);
      case GcorePackage.MTRANSITION__GUARD:
        return basicSetGuard(null, msgs);
      case GcorePackage.MTRANSITION__STATEMACHINE:
        return eBasicSetContainer(null, GcorePackage.MTRANSITION__STATEMACHINE, msgs);
      case GcorePackage.MTRANSITION__ACTION:
        return basicSetAction(null, msgs);
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
      case GcorePackage.MTRANSITION__STATEMACHINE:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MSTATE_MACHINE__SMTRANSITION, MStateMachine.class, msgs);
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
      case GcorePackage.MTRANSITION__KIND:
        return getKind();
      case GcorePackage.MTRANSITION__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case GcorePackage.MTRANSITION__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
      case GcorePackage.MTRANSITION__GUARD:
        if (resolve) return getGuard();
        return basicGetGuard();
      case GcorePackage.MTRANSITION__STATEMACHINE:
        return getStatemachine();
      case GcorePackage.MTRANSITION__TRIGGER:
        return getTrigger();
      case GcorePackage.MTRANSITION__ACTION:
        if (resolve) return getAction();
        return basicGetAction();
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
      case GcorePackage.MTRANSITION__KIND:
        setKind((String)newValue);
        return;
      case GcorePackage.MTRANSITION__SOURCE:
        setSource((MState)newValue);
        return;
      case GcorePackage.MTRANSITION__TARGET:
        setTarget((MState)newValue);
        return;
      case GcorePackage.MTRANSITION__GUARD:
        setGuard((MGuard)newValue);
        return;
      case GcorePackage.MTRANSITION__TRIGGER:
        getTrigger().clear();
        getTrigger().addAll((Collection<? extends MEvent>)newValue);
        return;
      case GcorePackage.MTRANSITION__ACTION:
        setAction((MBehavior)newValue);
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
      case GcorePackage.MTRANSITION__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case GcorePackage.MTRANSITION__SOURCE:
        setSource((MState)null);
        return;
      case GcorePackage.MTRANSITION__TARGET:
        setTarget((MState)null);
        return;
      case GcorePackage.MTRANSITION__GUARD:
        setGuard((MGuard)null);
        return;
      case GcorePackage.MTRANSITION__TRIGGER:
        getTrigger().clear();
        return;
      case GcorePackage.MTRANSITION__ACTION:
        setAction((MBehavior)null);
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
      case GcorePackage.MTRANSITION__KIND:
        return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
      case GcorePackage.MTRANSITION__SOURCE:
        return source != null;
      case GcorePackage.MTRANSITION__TARGET:
        return target != null;
      case GcorePackage.MTRANSITION__GUARD:
        return guard != null;
      case GcorePackage.MTRANSITION__STATEMACHINE:
        return getStatemachine() != null;
      case GcorePackage.MTRANSITION__TRIGGER:
        return trigger != null && !trigger.isEmpty();
      case GcorePackage.MTRANSITION__ACTION:
        return action != null;
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //MTransitionImpl
