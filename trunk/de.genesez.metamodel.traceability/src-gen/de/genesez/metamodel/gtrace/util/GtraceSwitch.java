/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace.util;

import de.genesez.metamodel.gtrace.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.genesez.metamodel.gtrace.GtracePackage
 * @generated
 */
public class GtraceSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GtracePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GtraceSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GtracePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GtracePackage.TTRACE_MODEL:
      {
        TTraceModel tTraceModel = (TTraceModel)theEObject;
        T result = caseTTraceModel(tTraceModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GtracePackage.TTRACE:
      {
        TTrace tTrace = (TTrace)theEObject;
        T result = caseTTrace(tTrace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GtracePackage.TREQUIREMENT_TRACE:
      {
        TRequirementTrace tRequirementTrace = (TRequirementTrace)theEObject;
        T result = caseTRequirementTrace(tRequirementTrace);
        if (result == null) result = caseTTrace(tRequirementTrace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GtracePackage.TSCENARIO_TRACE:
      {
        TScenarioTrace tScenarioTrace = (TScenarioTrace)theEObject;
        T result = caseTScenarioTrace(tScenarioTrace);
        if (result == null) result = caseTTrace(tScenarioTrace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GtracePackage.TSCENARIO_STEP_TRACE:
      {
        TScenarioStepTrace tScenarioStepTrace = (TScenarioStepTrace)theEObject;
        T result = caseTScenarioStepTrace(tScenarioStepTrace);
        if (result == null) result = caseTTrace(tScenarioStepTrace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TTrace Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TTrace Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTTraceModel(TTraceModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TTrace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TTrace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTTrace(TTrace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TRequirement Trace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TRequirement Trace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTRequirementTrace(TRequirementTrace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TScenario Trace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TScenario Trace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTScenarioTrace(TScenarioTrace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>TScenario Step Trace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TScenario Step Trace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTScenarioStepTrace(TScenarioStepTrace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //GtraceSwitch
