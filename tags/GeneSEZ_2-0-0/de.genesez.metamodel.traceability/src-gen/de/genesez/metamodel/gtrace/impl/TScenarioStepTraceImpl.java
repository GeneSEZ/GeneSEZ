/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace.impl;

import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MState;

import de.genesez.metamodel.greq.RScenarioStep;

import de.genesez.metamodel.gtrace.GtracePackage;
import de.genesez.metamodel.gtrace.TScenarioStepTrace;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TScenario Step Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl#getScenarioStep <em>Scenario Step</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TScenarioStepTraceImpl extends TTraceImpl implements TScenarioStepTrace
{
  /**
   * The cached value of the '{@link #getScenarioStep() <em>Scenario Step</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarioStep()
   * @generated
   * @ordered
   */
  protected RScenarioStep scenarioStep;

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
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected MState state;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TScenarioStepTraceImpl()
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
    return GtracePackage.Literals.TSCENARIO_STEP_TRACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenarioStep getScenarioStep()
  {
    if (scenarioStep != null && scenarioStep.eIsProxy())
    {
      InternalEObject oldScenarioStep = (InternalEObject)scenarioStep;
      scenarioStep = (RScenarioStep)eResolveProxy(oldScenarioStep);
      if (scenarioStep != oldScenarioStep)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP, oldScenarioStep, scenarioStep));
      }
    }
    return scenarioStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenarioStep basicGetScenarioStep()
  {
    return scenarioStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScenarioStep(RScenarioStep newScenarioStep)
  {
    RScenarioStep oldScenarioStep = scenarioStep;
    scenarioStep = newScenarioStep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP, oldScenarioStep, scenarioStep));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_STEP_TRACE__OPERATION, oldOperation, operation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_STEP_TRACE__OPERATION, oldOperation, operation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (MState)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_STEP_TRACE__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(MState newState)
  {
    MState oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_STEP_TRACE__STATE, oldState, state));
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
      case GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP:
        if (resolve) return getScenarioStep();
        return basicGetScenarioStep();
      case GtracePackage.TSCENARIO_STEP_TRACE__OPERATION:
        if (resolve) return getOperation();
        return basicGetOperation();
      case GtracePackage.TSCENARIO_STEP_TRACE__STATE:
        if (resolve) return getState();
        return basicGetState();
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
      case GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP:
        setScenarioStep((RScenarioStep)newValue);
        return;
      case GtracePackage.TSCENARIO_STEP_TRACE__OPERATION:
        setOperation((MOperation)newValue);
        return;
      case GtracePackage.TSCENARIO_STEP_TRACE__STATE:
        setState((MState)newValue);
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
      case GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP:
        setScenarioStep((RScenarioStep)null);
        return;
      case GtracePackage.TSCENARIO_STEP_TRACE__OPERATION:
        setOperation((MOperation)null);
        return;
      case GtracePackage.TSCENARIO_STEP_TRACE__STATE:
        setState((MState)null);
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
      case GtracePackage.TSCENARIO_STEP_TRACE__SCENARIO_STEP:
        return scenarioStep != null;
      case GtracePackage.TSCENARIO_STEP_TRACE__OPERATION:
        return operation != null;
      case GtracePackage.TSCENARIO_STEP_TRACE__STATE:
        return state != null;
    }
    return super.eIsSet(featureID);
  }

} //TScenarioStepTraceImpl
