/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAtomicTransition;
import org.genesez.metamodel.gcore.MState;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.gcore.MTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MState Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateMachineImpl#getSmstate <em>Smstate</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateMachineImpl#getSmtransition <em>Smtransition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateMachineImpl#getAtomicTransition <em>Atomic Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MStateMachineImpl extends MBehaviorImpl implements MStateMachine
{
  /**
   * The cached value of the '{@link #getSmstate() <em>Smstate</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSmstate()
   * @generated
   * @ordered
   */
  protected EList<MState> smstate;

  /**
   * The cached value of the '{@link #getSmtransition() <em>Smtransition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSmtransition()
   * @generated
   * @ordered
   */
  protected EList<MTransition> smtransition;

  /**
   * The cached value of the '{@link #getAtomicTransition() <em>Atomic Transition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtomicTransition()
   * @generated
   * @ordered
   */
  protected EList<MAtomicTransition> atomicTransition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MStateMachineImpl()
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
    return GcorePackage.Literals.MSTATE_MACHINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MState> getSmstate()
  {
    if (smstate == null)
    {
      smstate = new EObjectContainmentWithInverseEList<MState>(MState.class, this, GcorePackage.MSTATE_MACHINE__SMSTATE, GcorePackage.MSTATE__OWNER);
    }
    return smstate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTransition> getSmtransition()
  {
    if (smtransition == null)
    {
      smtransition = new EObjectContainmentWithInverseEList<MTransition>(MTransition.class, this, GcorePackage.MSTATE_MACHINE__SMTRANSITION, GcorePackage.MTRANSITION__STATEMACHINE);
    }
    return smtransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MAtomicTransition> getAtomicTransition()
  {
    if (atomicTransition == null)
    {
      atomicTransition = new EObjectContainmentWithInverseEList<MAtomicTransition>(MAtomicTransition.class, this, GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION, GcorePackage.MATOMIC_TRANSITION__STATEMACHINE);
    }
    return atomicTransition;
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSmstate()).basicAdd(otherEnd, msgs);
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSmtransition()).basicAdd(otherEnd, msgs);
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAtomicTransition()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        return ((InternalEList<?>)getSmstate()).basicRemove(otherEnd, msgs);
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        return ((InternalEList<?>)getSmtransition()).basicRemove(otherEnd, msgs);
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        return ((InternalEList<?>)getAtomicTransition()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        return getSmstate();
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        return getSmtransition();
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        return getAtomicTransition();
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        getSmstate().clear();
        getSmstate().addAll((Collection<? extends MState>)newValue);
        return;
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        getSmtransition().clear();
        getSmtransition().addAll((Collection<? extends MTransition>)newValue);
        return;
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        getAtomicTransition().clear();
        getAtomicTransition().addAll((Collection<? extends MAtomicTransition>)newValue);
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        getSmstate().clear();
        return;
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        getSmtransition().clear();
        return;
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        getAtomicTransition().clear();
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
      case GcorePackage.MSTATE_MACHINE__SMSTATE:
        return smstate != null && !smstate.isEmpty();
      case GcorePackage.MSTATE_MACHINE__SMTRANSITION:
        return smtransition != null && !smtransition.isEmpty();
      case GcorePackage.MSTATE_MACHINE__ATOMIC_TRANSITION:
        return atomicTransition != null && !atomicTransition.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MStateMachineImpl
