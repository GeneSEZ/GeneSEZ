/**
 */
package org.genesez.metamodel.greq.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.genesez.metamodel.greq.*;

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
 * @see org.genesez.metamodel.greq.GreqPackage
 * @generated
 */
public class GreqSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GreqPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreqSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GreqPackage.eINSTANCE;
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
      case GreqPackage.RMODEL:
      {
        RModel rModel = (RModel)theEObject;
        T result = caseRModel(rModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RREQUIREMENT:
      {
        RRequirement rRequirement = (RRequirement)theEObject;
        T result = caseRRequirement(rRequirement);
        if (result == null) result = caseRSpecObject(rRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RSCENARIO:
      {
        RScenario rScenario = (RScenario)theEObject;
        T result = caseRScenario(rScenario);
        if (result == null) result = caseRSpecObject(rScenario);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RSCENARIO_STEP:
      {
        RScenarioStep rScenarioStep = (RScenarioStep)theEObject;
        T result = caseRScenarioStep(rScenarioStep);
        if (result == null) result = caseRSpecObject(rScenarioStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RANNOTATION:
      {
        RAnnotation rAnnotation = (RAnnotation)theEObject;
        T result = caseRAnnotation(rAnnotation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RTAG:
      {
        RTag rTag = (RTag)theEObject;
        T result = caseRTag(rTag);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RVALUE:
      {
        RValue rValue = (RValue)theEObject;
        T result = caseRValue(rValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GreqPackage.RSPEC_OBJECT:
      {
        RSpecObject rSpecObject = (RSpecObject)theEObject;
        T result = caseRSpecObject(rSpecObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RModel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RModel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRModel(RModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RRequirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RRequirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRRequirement(RRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RScenario</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RScenario</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRScenario(RScenario object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RScenario Step</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RScenario Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRScenarioStep(RScenarioStep object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RAnnotation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RAnnotation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRAnnotation(RAnnotation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RTag</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RTag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRTag(RTag object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RValue</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RValue</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRValue(RValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>RSpec Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RSpec Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRSpecObject(RSpecObject object)
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

} //GreqSwitch
