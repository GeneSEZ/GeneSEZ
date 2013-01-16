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
 * A representation of the model object '<em><b>RScenario Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A scenario step is a particular, elementary doing of an actor involving a system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RScenarioStep#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RScenarioStep#getSupportedRequirement <em>Supported Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRScenarioStep()
 * @model
 * @generated
 */
public interface RScenarioStep extends RSpecObject
{
  /**
   * Returns the value of the '<em><b>Scenario</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RScenario#getStep <em>Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the context this step is performed.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Scenario</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenarioStep_Scenario()
   * @see org.genesez.metamodel.greq.RScenario#getStep
   * @model opposite="step" required="true" transient="false" changeable="false"
   * @generated
   */
  RScenario getScenario();

  /**
   * Returns the value of the '<em><b>Supported Requirement</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenarioStep <em>Supported Scenario Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to a list of requirements, involved in performing this step.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supported Requirement</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRScenarioStep_SupportedRequirement()
   * @see org.genesez.metamodel.greq.RRequirement#getSupportedScenarioStep
   * @model opposite="supportedScenarioStep"
   * @generated
   */
  EList<RRequirement> getSupportedRequirement();

} // RScenarioStep
