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
import org.genesez.metamodel.gcore.MAtomicTransition;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MHistoryState;
import org.genesez.metamodel.gcore.MLeafState;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.gcore.MTimeEvent;
import org.genesez.metamodel.gcore.MTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAtomic Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getDefiningTransition <em>Defining Transition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getEndDo <em>End Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getStartDo <em>Start Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getHistoryContext <em>History Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getStartTimer <em>Start Timer</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getStopTimer <em>Stop Timer</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAtomicTransitionImpl extends MElementImpl implements MAtomicTransition
{
  /**
   * The cached value of the '{@link #getDefiningTransition() <em>Defining Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefiningTransition()
   * @generated
   * @ordered
   */
  protected MTransition definingTransition;

  /**
   * The cached value of the '{@link #getEndDo() <em>End Do</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndDo()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> endDo;

  /**
   * The cached value of the '{@link #getExit() <em>Exit</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExit()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> exit;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> action;

  /**
   * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntry()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> entry;

  /**
   * The cached value of the '{@link #getStartDo() <em>Start Do</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartDo()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> startDo;

  /**
   * The cached value of the '{@link #getHistoryContext() <em>History Context</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHistoryContext()
   * @generated
   * @ordered
   */
  protected EList<MHistoryState> historyContext;

  /**
   * The cached value of the '{@link #getStartTimer() <em>Start Timer</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartTimer()
   * @generated
   * @ordered
   */
  protected EList<MTimeEvent> startTimer;

  /**
   * The cached value of the '{@link #getStopTimer() <em>Stop Timer</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStopTimer()
   * @generated
   * @ordered
   */
  protected EList<MTimeEvent> stopTimer;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected MLeafState source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected MLeafState target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MAtomicTransitionImpl()
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
    return GcorePackage.Literals.MATOMIC_TRANSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTransition getDefiningTransition()
  {
    if (definingTransition != null && definingTransition.eIsProxy())
    {
      InternalEObject oldDefiningTransition = (InternalEObject)definingTransition;
      definingTransition = (MTransition)eResolveProxy(oldDefiningTransition);
      if (definingTransition != oldDefiningTransition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
      }
    }
    return definingTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTransition basicGetDefiningTransition()
  {
    return definingTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefiningTransition(MTransition newDefiningTransition)
  {
    MTransition oldDefiningTransition = definingTransition;
    definingTransition = newDefiningTransition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION, oldDefiningTransition, definingTransition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getEndDo()
  {
    if (endDo == null)
    {
      endDo = new EObjectResolvingEList<MBehavior>(MBehavior.class, this, GcorePackage.MATOMIC_TRANSITION__END_DO);
    }
    return endDo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getExit()
  {
    if (exit == null)
    {
      exit = new EObjectResolvingEList<MBehavior>(MBehavior.class, this, GcorePackage.MATOMIC_TRANSITION__EXIT);
    }
    return exit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getAction()
  {
    if (action == null)
    {
      action = new EObjectResolvingEList<MBehavior>(MBehavior.class, this, GcorePackage.MATOMIC_TRANSITION__ACTION);
    }
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getEntry()
  {
    if (entry == null)
    {
      entry = new EObjectResolvingEList<MBehavior>(MBehavior.class, this, GcorePackage.MATOMIC_TRANSITION__ENTRY);
    }
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getStartDo()
  {
    if (startDo == null)
    {
      startDo = new EObjectResolvingEList<MBehavior>(MBehavior.class, this, GcorePackage.MATOMIC_TRANSITION__START_DO);
    }
    return startDo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MHistoryState> getHistoryContext()
  {
    if (historyContext == null)
    {
      historyContext = new EObjectResolvingEList<MHistoryState>(MHistoryState.class, this, GcorePackage.MATOMIC_TRANSITION__HISTORY_CONTEXT);
    }
    return historyContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine getStatemachine()
  {
    if (eContainerFeatureID() != GcorePackage.MATOMIC_TRANSITION__STATEMACHINE) return null;
    return (MStateMachine)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTimeEvent> getStartTimer()
  {
    if (startTimer == null)
    {
      startTimer = new EObjectResolvingEList<MTimeEvent>(MTimeEvent.class, this, GcorePackage.MATOMIC_TRANSITION__START_TIMER);
    }
    return startTimer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTimeEvent> getStopTimer()
  {
    if (stopTimer == null)
    {
      stopTimer = new EObjectResolvingEList<MTimeEvent>(MTimeEvent.class, this, GcorePackage.MATOMIC_TRANSITION__STOP_TIMER);
    }
    return stopTimer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState getSource()
  {
    if (source != null && source.eIsProxy())
    {
      InternalEObject oldSource = (InternalEObject)source;
      source = (MLeafState)eResolveProxy(oldSource);
      if (source != oldSource)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MATOMIC_TRANSITION__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState basicGetSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(MLeafState newSource)
  {
    MLeafState oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MATOMIC_TRANSITION__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (MLeafState)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MATOMIC_TRANSITION__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(MLeafState newTarget)
  {
    MLeafState oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MATOMIC_TRANSITION__TARGET, oldTarget, target));
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
      case GcorePackage.MATOMIC_TRANSITION__STATEMACHINE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MATOMIC_TRANSITION__STATEMACHINE, msgs);
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
      case GcorePackage.MATOMIC_TRANSITION__STATEMACHINE:
        return eBasicSetContainer(null, GcorePackage.MATOMIC_TRANSITION__STATEMACHINE, msgs);
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
      case GcorePackage.MATOMIC_TRANSITION__STATEMACHINE:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION, MStateMachine.class, msgs);
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
      case GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION:
        if (resolve) return getDefiningTransition();
        return basicGetDefiningTransition();
      case GcorePackage.MATOMIC_TRANSITION__END_DO:
        return getEndDo();
      case GcorePackage.MATOMIC_TRANSITION__EXIT:
        return getExit();
      case GcorePackage.MATOMIC_TRANSITION__ACTION:
        return getAction();
      case GcorePackage.MATOMIC_TRANSITION__ENTRY:
        return getEntry();
      case GcorePackage.MATOMIC_TRANSITION__START_DO:
        return getStartDo();
      case GcorePackage.MATOMIC_TRANSITION__HISTORY_CONTEXT:
        return getHistoryContext();
      case GcorePackage.MATOMIC_TRANSITION__STATEMACHINE:
        return getStatemachine();
      case GcorePackage.MATOMIC_TRANSITION__START_TIMER:
        return getStartTimer();
      case GcorePackage.MATOMIC_TRANSITION__STOP_TIMER:
        return getStopTimer();
      case GcorePackage.MATOMIC_TRANSITION__SOURCE:
        if (resolve) return getSource();
        return basicGetSource();
      case GcorePackage.MATOMIC_TRANSITION__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
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
      case GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION:
        setDefiningTransition((MTransition)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__END_DO:
        getEndDo().clear();
        getEndDo().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__EXIT:
        getExit().clear();
        getExit().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__ACTION:
        getAction().clear();
        getAction().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__ENTRY:
        getEntry().clear();
        getEntry().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__START_DO:
        getStartDo().clear();
        getStartDo().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__HISTORY_CONTEXT:
        getHistoryContext().clear();
        getHistoryContext().addAll((Collection<? extends MHistoryState>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__START_TIMER:
        getStartTimer().clear();
        getStartTimer().addAll((Collection<? extends MTimeEvent>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__STOP_TIMER:
        getStopTimer().clear();
        getStopTimer().addAll((Collection<? extends MTimeEvent>)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__SOURCE:
        setSource((MLeafState)newValue);
        return;
      case GcorePackage.MATOMIC_TRANSITION__TARGET:
        setTarget((MLeafState)newValue);
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
      case GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION:
        setDefiningTransition((MTransition)null);
        return;
      case GcorePackage.MATOMIC_TRANSITION__END_DO:
        getEndDo().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__EXIT:
        getExit().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__ACTION:
        getAction().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__ENTRY:
        getEntry().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__START_DO:
        getStartDo().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__HISTORY_CONTEXT:
        getHistoryContext().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__START_TIMER:
        getStartTimer().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__STOP_TIMER:
        getStopTimer().clear();
        return;
      case GcorePackage.MATOMIC_TRANSITION__SOURCE:
        setSource((MLeafState)null);
        return;
      case GcorePackage.MATOMIC_TRANSITION__TARGET:
        setTarget((MLeafState)null);
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
      case GcorePackage.MATOMIC_TRANSITION__DEFINING_TRANSITION:
        return definingTransition != null;
      case GcorePackage.MATOMIC_TRANSITION__END_DO:
        return endDo != null && !endDo.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__EXIT:
        return exit != null && !exit.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__ACTION:
        return action != null && !action.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__ENTRY:
        return entry != null && !entry.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__START_DO:
        return startDo != null && !startDo.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__HISTORY_CONTEXT:
        return historyContext != null && !historyContext.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__STATEMACHINE:
        return getStatemachine() != null;
      case GcorePackage.MATOMIC_TRANSITION__START_TIMER:
        return startTimer != null && !startTimer.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__STOP_TIMER:
        return stopTimer != null && !stopTimer.isEmpty();
      case GcorePackage.MATOMIC_TRANSITION__SOURCE:
        return source != null;
      case GcorePackage.MATOMIC_TRANSITION__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //MAtomicTransitionImpl
