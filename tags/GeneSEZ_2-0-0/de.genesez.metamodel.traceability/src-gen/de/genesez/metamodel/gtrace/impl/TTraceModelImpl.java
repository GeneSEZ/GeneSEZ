/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace.impl;

import de.genesez.metamodel.gtrace.GtracePackage;
import de.genesez.metamodel.gtrace.TRequirementTrace;
import de.genesez.metamodel.gtrace.TScenarioStepTrace;
import de.genesez.metamodel.gtrace.TScenarioTrace;
import de.genesez.metamodel.gtrace.TTraceModel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTrace Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TTraceModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TTraceModelImpl#getRequirementTrace <em>Requirement Trace</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TTraceModelImpl#getScenarioTrace <em>Scenario Trace</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.impl.TTraceModelImpl#getScenarioStepTrace <em>Scenario Step Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTraceModelImpl extends EObjectImpl implements TTraceModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRequirementTrace() <em>Requirement Trace</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementTrace()
   * @generated
   * @ordered
   */
  protected EList<TRequirementTrace> requirementTrace;

  /**
   * The cached value of the '{@link #getScenarioTrace() <em>Scenario Trace</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarioTrace()
   * @generated
   * @ordered
   */
  protected EList<TScenarioTrace> scenarioTrace;

  /**
   * The cached value of the '{@link #getScenarioStepTrace() <em>Scenario Step Trace</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenarioStepTrace()
   * @generated
   * @ordered
   */
  protected EList<TScenarioStepTrace> scenarioStepTrace;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TTraceModelImpl()
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
    return GtracePackage.Literals.TTRACE_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TTRACE_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TRequirementTrace> getRequirementTrace()
  {
    if (requirementTrace == null)
    {
      requirementTrace = new EObjectContainmentEList<TRequirementTrace>(TRequirementTrace.class, this, GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE);
    }
    return requirementTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TScenarioTrace> getScenarioTrace()
  {
    if (scenarioTrace == null)
    {
      scenarioTrace = new EObjectContainmentEList<TScenarioTrace>(TScenarioTrace.class, this, GtracePackage.TTRACE_MODEL__SCENARIO_TRACE);
    }
    return scenarioTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TScenarioStepTrace> getScenarioStepTrace()
  {
    if (scenarioStepTrace == null)
    {
      scenarioStepTrace = new EObjectContainmentEList<TScenarioStepTrace>(TScenarioStepTrace.class, this, GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE);
    }
    return scenarioStepTrace;
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
      case GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE:
        return ((InternalEList<?>)getRequirementTrace()).basicRemove(otherEnd, msgs);
      case GtracePackage.TTRACE_MODEL__SCENARIO_TRACE:
        return ((InternalEList<?>)getScenarioTrace()).basicRemove(otherEnd, msgs);
      case GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE:
        return ((InternalEList<?>)getScenarioStepTrace()).basicRemove(otherEnd, msgs);
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
      case GtracePackage.TTRACE_MODEL__NAME:
        return getName();
      case GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE:
        return getRequirementTrace();
      case GtracePackage.TTRACE_MODEL__SCENARIO_TRACE:
        return getScenarioTrace();
      case GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE:
        return getScenarioStepTrace();
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
      case GtracePackage.TTRACE_MODEL__NAME:
        setName((String)newValue);
        return;
      case GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE:
        getRequirementTrace().clear();
        getRequirementTrace().addAll((Collection<? extends TRequirementTrace>)newValue);
        return;
      case GtracePackage.TTRACE_MODEL__SCENARIO_TRACE:
        getScenarioTrace().clear();
        getScenarioTrace().addAll((Collection<? extends TScenarioTrace>)newValue);
        return;
      case GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE:
        getScenarioStepTrace().clear();
        getScenarioStepTrace().addAll((Collection<? extends TScenarioStepTrace>)newValue);
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
      case GtracePackage.TTRACE_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE:
        getRequirementTrace().clear();
        return;
      case GtracePackage.TTRACE_MODEL__SCENARIO_TRACE:
        getScenarioTrace().clear();
        return;
      case GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE:
        getScenarioStepTrace().clear();
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
      case GtracePackage.TTRACE_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GtracePackage.TTRACE_MODEL__REQUIREMENT_TRACE:
        return requirementTrace != null && !requirementTrace.isEmpty();
      case GtracePackage.TTRACE_MODEL__SCENARIO_TRACE:
        return scenarioTrace != null && !scenarioTrace.isEmpty();
      case GtracePackage.TTRACE_MODEL__SCENARIO_STEP_TRACE:
        return scenarioStepTrace != null && !scenarioStepTrace.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TTraceModelImpl
