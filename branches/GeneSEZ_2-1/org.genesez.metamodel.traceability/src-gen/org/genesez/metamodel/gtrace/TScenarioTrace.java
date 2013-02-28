/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gtrace;

import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MStateMachine;

import org.genesez.metamodel.greq.RScenario;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TScenario Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gtrace.TScenarioTrace#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.TScenarioTrace#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.TScenarioTrace#getStateMachine <em>State Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gtrace.GtracePackage#getTScenarioTrace()
 * @model
 * @generated
 */
public interface TScenarioTrace extends TTrace
{
  /**
   * Returns the value of the '<em><b>Scenario</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario</em>' reference.
   * @see #setScenario(RScenario)
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTScenarioTrace_Scenario()
   * @model required="true"
   * @generated
   */
  RScenario getScenario();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getScenario <em>Scenario</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scenario</em>' reference.
   * @see #getScenario()
   * @generated
   */
  void setScenario(RScenario value);

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' reference.
   * @see #setClassifier(MClassifier)
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTScenarioTrace_Classifier()
   * @model
   * @generated
   */
  MClassifier getClassifier();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getClassifier <em>Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classifier</em>' reference.
   * @see #getClassifier()
   * @generated
   */
  void setClassifier(MClassifier value);

  /**
   * Returns the value of the '<em><b>State Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Machine</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Machine</em>' reference.
   * @see #setStateMachine(MStateMachine)
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTScenarioTrace_StateMachine()
   * @model
   * @generated
   */
  MStateMachine getStateMachine();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getStateMachine <em>State Machine</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State Machine</em>' reference.
   * @see #getStateMachine()
   * @generated
   */
  void setStateMachine(MStateMachine value);

} // TScenarioTrace
