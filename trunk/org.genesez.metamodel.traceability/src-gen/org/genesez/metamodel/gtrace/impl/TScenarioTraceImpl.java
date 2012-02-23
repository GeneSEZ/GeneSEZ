/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gtrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.greq.RScenario;

import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.TScenarioTrace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TScenario Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TScenarioTraceImpl extends TTraceImpl implements TScenarioTrace
{
  /**
   * The cached value of the '{@link #getScenario() <em>Scenario</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenario()
   * @generated
   * @ordered
   */
  protected RScenario scenario;

  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected MClassifier classifier;

  /**
   * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStateMachine()
   * @generated
   * @ordered
   */
  protected MStateMachine stateMachine;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TScenarioTraceImpl()
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
    return GtracePackage.Literals.TSCENARIO_TRACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenario getScenario()
  {
    if (scenario != null && scenario.eIsProxy())
    {
      InternalEObject oldScenario = (InternalEObject)scenario;
      scenario = (RScenario)eResolveProxy(oldScenario);
      if (scenario != oldScenario)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_TRACE__SCENARIO, oldScenario, scenario));
      }
    }
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenario basicGetScenario()
  {
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScenario(RScenario newScenario)
  {
    RScenario oldScenario = scenario;
    scenario = newScenario;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_TRACE__SCENARIO, oldScenario, scenario));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier getClassifier()
  {
    if (classifier != null && classifier.eIsProxy())
    {
      InternalEObject oldClassifier = (InternalEObject)classifier;
      classifier = (MClassifier)eResolveProxy(oldClassifier);
      if (classifier != oldClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_TRACE__CLASSIFIER, oldClassifier, classifier));
      }
    }
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier basicGetClassifier()
  {
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassifier(MClassifier newClassifier)
  {
    MClassifier oldClassifier = classifier;
    classifier = newClassifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_TRACE__CLASSIFIER, oldClassifier, classifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine getStateMachine()
  {
    if (stateMachine != null && stateMachine.eIsProxy())
    {
      InternalEObject oldStateMachine = (InternalEObject)stateMachine;
      stateMachine = (MStateMachine)eResolveProxy(oldStateMachine);
      if (stateMachine != oldStateMachine)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TSCENARIO_TRACE__STATE_MACHINE, oldStateMachine, stateMachine));
      }
    }
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine basicGetStateMachine()
  {
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStateMachine(MStateMachine newStateMachine)
  {
    MStateMachine oldStateMachine = stateMachine;
    stateMachine = newStateMachine;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TSCENARIO_TRACE__STATE_MACHINE, oldStateMachine, stateMachine));
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
      case GtracePackage.TSCENARIO_TRACE__SCENARIO:
        if (resolve) return getScenario();
        return basicGetScenario();
      case GtracePackage.TSCENARIO_TRACE__CLASSIFIER:
        if (resolve) return getClassifier();
        return basicGetClassifier();
      case GtracePackage.TSCENARIO_TRACE__STATE_MACHINE:
        if (resolve) return getStateMachine();
        return basicGetStateMachine();
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
      case GtracePackage.TSCENARIO_TRACE__SCENARIO:
        setScenario((RScenario)newValue);
        return;
      case GtracePackage.TSCENARIO_TRACE__CLASSIFIER:
        setClassifier((MClassifier)newValue);
        return;
      case GtracePackage.TSCENARIO_TRACE__STATE_MACHINE:
        setStateMachine((MStateMachine)newValue);
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
      case GtracePackage.TSCENARIO_TRACE__SCENARIO:
        setScenario((RScenario)null);
        return;
      case GtracePackage.TSCENARIO_TRACE__CLASSIFIER:
        setClassifier((MClassifier)null);
        return;
      case GtracePackage.TSCENARIO_TRACE__STATE_MACHINE:
        setStateMachine((MStateMachine)null);
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
      case GtracePackage.TSCENARIO_TRACE__SCENARIO:
        return scenario != null;
      case GtracePackage.TSCENARIO_TRACE__CLASSIFIER:
        return classifier != null;
      case GtracePackage.TSCENARIO_TRACE__STATE_MACHINE:
        return stateMachine != null;
    }
    return super.eIsSet(featureID);
  }

} //TScenarioTraceImpl
