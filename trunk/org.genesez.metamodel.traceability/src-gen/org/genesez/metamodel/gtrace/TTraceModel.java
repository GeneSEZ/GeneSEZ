/**
 */
package org.genesez.metamodel.gtrace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTrace Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gtrace.TTraceModel#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.TTraceModel#getRequirementTrace <em>Requirement Trace</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.TTraceModel#getScenarioTrace <em>Scenario Trace</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.TTraceModel#getScenarioStepTrace <em>Scenario Step Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gtrace.GtracePackage#getTTraceModel()
 * @model
 * @generated
 */
public interface TTraceModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTTraceModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gtrace.TTraceModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Requirement Trace</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gtrace.TRequirementTrace}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Trace</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Trace</em>' containment reference list.
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTTraceModel_RequirementTrace()
   * @model containment="true"
   * @generated
   */
  EList<TRequirementTrace> getRequirementTrace();

  /**
   * Returns the value of the '<em><b>Scenario Trace</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gtrace.TScenarioTrace}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario Trace</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario Trace</em>' containment reference list.
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTTraceModel_ScenarioTrace()
   * @model containment="true"
   * @generated
   */
  EList<TScenarioTrace> getScenarioTrace();

  /**
   * Returns the value of the '<em><b>Scenario Step Trace</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gtrace.TScenarioStepTrace}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scenario Step Trace</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scenario Step Trace</em>' containment reference list.
   * @see org.genesez.metamodel.gtrace.GtracePackage#getTTraceModel_ScenarioStepTrace()
   * @model containment="true"
   * @generated
   */
  EList<TScenarioStepTrace> getScenarioStepTrace();

} // TTraceModel
