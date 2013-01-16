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
 * A representation of the model object '<em><b>RRequirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A requirement is a very focused statement about a paricular business need concerning a paricular unit of a system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenario <em>Supported Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getParent <em>Parent</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getChild <em>Child</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getDeriving <em>Deriving</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getRefining <em>Refining</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenarioStep <em>Supported Scenario Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement()
 * @model
 * @generated
 */
public interface RRequirement extends RSpecObject
{
  /**
   * Returns the value of the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Describes the sense of the requirement and can be useful to find a test context for the requirement.
   * Usually the <pre>rationale</pre> describes the requirement from another point of view as the <pre>description</pre>.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Rationale</em>' attribute.
   * @see #setRationale(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Rationale()
   * @model
   * @generated
   */
  String getRationale();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getRationale <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' attribute.
   * @see #getRationale()
   * @generated
   */
  void setRationale(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The type is used to classifiy requirements.
   * Commonly used are 'functional', 'non-functional' and 'constraint'.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Specifies an ordinal value to determine crucial requirements by relating the values of different requirements.
   * Possible values include the priority or a target relese.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Precedence</em>' attribute.
   * @see #setPrecedence(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Precedence()
   * @model
   * @generated
   */
  String getPrecedence();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getPrecedence <em>Precedence</em>}' attribute.
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
   * Specifies how this requirement can be verified.
   * It should just consits of a single word for an easy possible evaluation.
   * Possibilities are: 'test', 'demo' and 'review'. You can check the SysML specification for more (non normative) possibilities.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Verification Method</em>' attribute.
   * @see #setVerificationMethod(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_VerificationMethod()
   * @model
   * @generated
   */
  String getVerificationMethod();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getVerificationMethod <em>Verification Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Method</em>' attribute.
   * @see #getVerificationMethod()
   * @generated
   */
  void setVerificationMethod(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RModel#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the requirements model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Model()
   * @see org.genesez.metamodel.greq.RModel#getRequirement
   * @model opposite="requirement" required="true" transient="false" changeable="false"
   * @generated
   */
  RModel getModel();

  /**
   * Returns the value of the '<em><b>Supported Scenario</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RScenario}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RScenario#getSupportedRequirement <em>Supported Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * References to scenarios involving this requirement in their business objective.
   * The opposite is supportedRequirement.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supported Scenario</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_SupportedScenario()
   * @see org.genesez.metamodel.greq.RScenario#getSupportedRequirement
   * @model opposite="supportedRequirement"
   * @generated
   */
  EList<RScenario> getSupportedScenario();

  /**
   * Returns the value of the '<em><b>Parent</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the parent requirement. The opposite is child.
   * It is used to nest requirements, with the exception of namespace embedding.
   * 
   * This dependency is taken from SysML with change that no requirement is embedded into the namespace of one another.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Parent</em>' reference.
   * @see #setParent(RRequirement)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Parent()
   * @see org.genesez.metamodel.greq.RRequirement#getChild
   * @model opposite="child"
   * @generated
   */
  RRequirement getParent();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getParent <em>Parent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' reference.
   * @see #getParent()
   * @generated
   */
  void setParent(RRequirement value);

  /**
   * Returns the value of the '<em><b>Child</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of child requirements. The opposite is parent.
   * It is used to nest requirements, with the exception of namespace embedding.
   * 
   * This dependency is taken from SysML with change that no requirement is embedded into the namespace of one another.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Child</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Child()
   * @see org.genesez.metamodel.greq.RRequirement#getParent
   * @model opposite="parent"
   * @generated
   */
  EList<RRequirement> getChild();

  /**
   * Returns the value of the '<em><b>Deriving</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the requirement this requirement is derived from. The opposite is derived.
   * It can be used to express a dependency between requirements in the means that the existence of one requirements it logical by one another.
   * 
   * This dependency is taken from SysML.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Deriving</em>' reference.
   * @see #setDeriving(RRequirement)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Deriving()
   * @see org.genesez.metamodel.greq.RRequirement#getDerived
   * @model opposite="derived"
   * @generated
   */
  RRequirement getDeriving();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getDeriving <em>Deriving</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deriving</em>' reference.
   * @see #getDeriving()
   * @generated
   */
  void setDeriving(RRequirement value);

  /**
   * Returns the value of the '<em><b>Derived</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getDeriving <em>Deriving</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of derived requirements. The opposite is deriving.
   * It can be used to express a dependency between requirements in the means that the existence of one requirement is logical by one another.
   * 
   * This dependency is taken from SysML.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Derived</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Derived()
   * @see org.genesez.metamodel.greq.RRequirement#getDeriving
   * @model opposite="deriving"
   * @generated
   */
  EList<RRequirement> getDerived();

  /**
   * Returns the value of the '<em><b>Refining</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getRefined <em>Refined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the requirement this requirement is refined from. The opposite is refined.
   * It can be used to express a dependency between requirements in the means that one requirements is more precise than one another.
   * 
   * This dependency is taken from SysML.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Refining</em>' reference.
   * @see #setRefining(RRequirement)
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Refining()
   * @see org.genesez.metamodel.greq.RRequirement#getRefined
   * @model opposite="refined"
   * @generated
   */
  RRequirement getRefining();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RRequirement#getRefining <em>Refining</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Refining</em>' reference.
   * @see #getRefining()
   * @generated
   */
  void setRefining(RRequirement value);

  /**
   * Returns the value of the '<em><b>Refined</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getRefining <em>Refining</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of refined requirements. The opposite is refining.
   * It can be used to express a dependency between requirements in the means that one requirements is more precise than one another.
   * 
   * This dependency is taken from SysML.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Refined</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_Refined()
   * @see org.genesez.metamodel.greq.RRequirement#getRefining
   * @model opposite="refining"
   * @generated
   */
  EList<RRequirement> getRefined();

  /**
   * Returns the value of the '<em><b>Supported Scenario Step</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RScenarioStep}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RScenarioStep#getSupportedRequirement <em>Supported Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * References to scenario steps involving this requirement in their business objective.
   * The opposite is supportedRequirement.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Supported Scenario Step</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRRequirement_SupportedScenarioStep()
   * @see org.genesez.metamodel.greq.RScenarioStep#getSupportedRequirement
   * @model opposite="supportedRequirement"
   * @generated
   */
  EList<RScenarioStep> getSupportedScenarioStep();

} // RRequirement
