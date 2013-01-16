/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RScenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A scenario is a description of how a system can be used to achieve a particular business need.
 * It consists of steps which need to be performed in the defined order.
 * 
 * A scenario is something like a <b><i>use case</i></b> or a <b><i>user story</i></b>.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RScenario#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RScenario#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RScenario#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RScenario#getStep <em>Step</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RScenario#getSupportedRequirement <em>Supported Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRScenario()
 * @model
 * @generated
 */
public interface RScenario extends RSpecObject
{
  /**
   * Returns the value of the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Specifies an ordinal value to determine crucial scenarios by relating the values of different scenarios.
   * Possible values include the priority or a target relese.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Precedence</em>' attribute.
   * @see #setPrecedence(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenario_Precedence()
   * @model
   * @generated
   */
  String getPrecedence();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RScenario#getPrecedence <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precedence</em>' attribute.
   * @see #getPrecedence()
   * @generated
   */
  void setPrecedence(String value);

  /**
   * Returns the value of the '<em><b>Verification Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Specifies how this scenario can be verified.
   * It should just consits of a single word for an easy possible evaluation.
   * Possibilities are: 'test', 'demo' and 'review'. You can check the SysML specification for more non normative possibilities.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Verification Method</em>' attribute.
   * @see #setVerificationMethod(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenario_VerificationMethod()
   * @model
   * @generated
   */
  String getVerificationMethod();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RScenario#getVerificationMethod <em>Verification Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Method</em>' attribute.
   * @see #getVerificationMethod()
   * @generated
   */
  void setVerificationMethod(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RModel#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the requirements model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenario_Model()
   * @see org.genesez.metamodel.greq.RModel#getScenario
   * @model opposite="scenario" required="true" transient="false" changeable="false"
   * @generated
   */
  RModel getModel();

  /**
   * Returns the value of the '<em><b>Step</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RScenarioStep}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RScenarioStep#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of steps which must be performed in the defined order.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Step</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenario_Step()
   * @see org.genesez.metamodel.greq.RScenarioStep#getScenario
   * @model opposite="scenario" containment="true" required="true"
   * @generated
   */
  EList<RScenarioStep> getStep();

  /**
   * Returns the value of the '<em><b>Supported Requirement</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenario <em>Supported Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to requirements, involved in performing this scenario. The opposite is supportedScenario.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supported Requirement</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenario_SupportedRequirement()
   * @see org.genesez.metamodel.greq.RRequirement#getSupportedScenario
   * @model opposite="supportedScenario"
   * @generated
   */
  EList<RRequirement> getSupportedRequirement();

} // RScenario
