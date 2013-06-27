/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace;

import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MState;

import de.genesez.metamodel.greq.RScenarioStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TScenario Step Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getScenarioStep <em>Scenario Step</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gtrace.GtracePackage#getTScenarioStepTrace()
 * @model
 * @generated
 */
public interface TScenarioStepTrace extends TTrace
{
  /**
   * Returns the value of the '<em><b>Scenario Step</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario Step</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario Step</em>' reference.
   * @see #setScenarioStep(RScenarioStep)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTScenarioStepTrace_ScenarioStep()
   * @model required="true"
   * @generated
   */
  RScenarioStep getScenarioStep();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getScenarioStep <em>Scenario Step</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scenario Step</em>' reference.
   * @see #getScenarioStep()
   * @generated
   */
  void setScenarioStep(RScenarioStep value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(MOperation)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTScenarioStepTrace_Operation()
   * @model
   * @generated
   */
  MOperation getOperation();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(MOperation value);

  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(MState)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTScenarioStepTrace_State()
   * @model
   * @generated
   */
  MState getState();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TScenarioStepTrace#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(MState value);

} // TScenarioStepTrace
