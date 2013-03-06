/**
 */
package org.genesez.metamodel.gtrace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gtrace.GtraceFactory
 * @model kind="package"
 * @generated
 */
public interface GtracePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gtrace";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://genesez.org/metamodel/traceability";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gtrace";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GtracePackage eINSTANCE = org.genesez.metamodel.gtrace.impl.GtracePackageImpl.init();

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gtrace.impl.TTraceModelImpl <em>TTrace Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gtrace.impl.TTraceModelImpl
   * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTTraceModel()
   * @generated
   */
  int TTRACE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Requirement Trace</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_MODEL__REQUIREMENT_TRACE = 1;

  /**
   * The feature id for the '<em><b>Scenario Trace</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_MODEL__SCENARIO_TRACE = 2;

  /**
   * The feature id for the '<em><b>Scenario Step Trace</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_MODEL__SCENARIO_STEP_TRACE = 3;

  /**
   * The number of structural features of the '<em>TTrace Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gtrace.impl.TTraceImpl <em>TTrace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gtrace.impl.TTraceImpl
   * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTTrace()
   * @generated
   */
  int TTRACE = 1;

  /**
   * The feature id for the '<em><b>Reviewed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE__REVIEWED = 0;

  /**
   * The number of structural features of the '<em>TTrace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTRACE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl <em>TRequirement Trace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl
   * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTRequirementTrace()
   * @generated
   */
  int TREQUIREMENT_TRACE = 2;

  /**
   * The feature id for the '<em><b>Reviewed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TRACE__REVIEWED = TTRACE__REVIEWED;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TRACE__REQUIREMENT = TTRACE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Structural Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT = TTRACE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TRequirement Trace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TRACE_FEATURE_COUNT = TTRACE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl <em>TScenario Trace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl
   * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTScenarioTrace()
   * @generated
   */
  int TSCENARIO_TRACE = 3;

  /**
   * The feature id for the '<em><b>Reviewed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_TRACE__REVIEWED = TTRACE__REVIEWED;

  /**
   * The feature id for the '<em><b>Scenario</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_TRACE__SCENARIO = TTRACE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_TRACE__CLASSIFIER = TTRACE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_TRACE__STATE_MACHINE = TTRACE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TScenario Trace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_TRACE_FEATURE_COUNT = TTRACE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl <em>TScenario Step Trace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl
   * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTScenarioStepTrace()
   * @generated
   */
  int TSCENARIO_STEP_TRACE = 4;

  /**
   * The feature id for the '<em><b>Reviewed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_STEP_TRACE__REVIEWED = TTRACE__REVIEWED;

  /**
   * The feature id for the '<em><b>Scenario Step</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_STEP_TRACE__SCENARIO_STEP = TTRACE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_STEP_TRACE__OPERATION = TTRACE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_STEP_TRACE__STATE = TTRACE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TScenario Step Trace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSCENARIO_STEP_TRACE_FEATURE_COUNT = TTRACE_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gtrace.TTraceModel <em>TTrace Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTrace Model</em>'.
   * @see org.genesez.metamodel.gtrace.TTraceModel
   * @generated
   */
  EClass getTTraceModel();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gtrace.TTraceModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gtrace.TTraceModel#getName()
   * @see #getTTraceModel()
   * @generated
   */
  EAttribute getTTraceModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gtrace.TTraceModel#getRequirementTrace <em>Requirement Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TTraceModel#getRequirementTrace()
   * @see #getTTraceModel()
   * @generated
   */
  EReference getTTraceModel_RequirementTrace();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gtrace.TTraceModel#getScenarioTrace <em>Scenario Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenario Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TTraceModel#getScenarioTrace()
   * @see #getTTraceModel()
   * @generated
   */
  EReference getTTraceModel_ScenarioTrace();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gtrace.TTraceModel#getScenarioStepTrace <em>Scenario Step Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenario Step Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TTraceModel#getScenarioStepTrace()
   * @see #getTTraceModel()
   * @generated
   */
  EReference getTTraceModel_ScenarioStepTrace();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gtrace.TTrace <em>TTrace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTrace</em>'.
   * @see org.genesez.metamodel.gtrace.TTrace
   * @generated
   */
  EClass getTTrace();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gtrace.TTrace#getReviewed <em>Reviewed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reviewed</em>'.
   * @see org.genesez.metamodel.gtrace.TTrace#getReviewed()
   * @see #getTTrace()
   * @generated
   */
  EAttribute getTTrace_Reviewed();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gtrace.TRequirementTrace <em>TRequirement Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequirement Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TRequirementTrace
   * @generated
   */
  EClass getTRequirementTrace();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TRequirementTrace#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Requirement</em>'.
   * @see org.genesez.metamodel.gtrace.TRequirementTrace#getRequirement()
   * @see #getTRequirementTrace()
   * @generated
   */
  EReference getTRequirementTrace_Requirement();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TRequirementTrace#getStructuralElement <em>Structural Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Structural Element</em>'.
   * @see org.genesez.metamodel.gtrace.TRequirementTrace#getStructuralElement()
   * @see #getTRequirementTrace()
   * @generated
   */
  EReference getTRequirementTrace_StructuralElement();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gtrace.TScenarioTrace <em>TScenario Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TScenario Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioTrace
   * @generated
   */
  EClass getTScenarioTrace();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Scenario</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioTrace#getScenario()
   * @see #getTScenarioTrace()
   * @generated
   */
  EReference getTScenarioTrace_Scenario();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classifier</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioTrace#getClassifier()
   * @see #getTScenarioTrace()
   * @generated
   */
  EReference getTScenarioTrace_Classifier();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioTrace#getStateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State Machine</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioTrace#getStateMachine()
   * @see #getTScenarioTrace()
   * @generated
   */
  EReference getTScenarioTrace_StateMachine();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gtrace.TScenarioStepTrace <em>TScenario Step Trace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TScenario Step Trace</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioStepTrace
   * @generated
   */
  EClass getTScenarioStepTrace();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioStepTrace#getScenarioStep <em>Scenario Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Scenario Step</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioStepTrace#getScenarioStep()
   * @see #getTScenarioStepTrace()
   * @generated
   */
  EReference getTScenarioStepTrace_ScenarioStep();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioStepTrace#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioStepTrace#getOperation()
   * @see #getTScenarioStepTrace()
   * @generated
   */
  EReference getTScenarioStepTrace_Operation();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gtrace.TScenarioStepTrace#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.genesez.metamodel.gtrace.TScenarioStepTrace#getState()
   * @see #getTScenarioStepTrace()
   * @generated
   */
  EReference getTScenarioStepTrace_State();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GtraceFactory getGtraceFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gtrace.impl.TTraceModelImpl <em>TTrace Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gtrace.impl.TTraceModelImpl
     * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTTraceModel()
     * @generated
     */
    EClass TTRACE_MODEL = eINSTANCE.getTTraceModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TTRACE_MODEL__NAME = eINSTANCE.getTTraceModel_Name();

    /**
     * The meta object literal for the '<em><b>Requirement Trace</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTRACE_MODEL__REQUIREMENT_TRACE = eINSTANCE.getTTraceModel_RequirementTrace();

    /**
     * The meta object literal for the '<em><b>Scenario Trace</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTRACE_MODEL__SCENARIO_TRACE = eINSTANCE.getTTraceModel_ScenarioTrace();

    /**
     * The meta object literal for the '<em><b>Scenario Step Trace</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTRACE_MODEL__SCENARIO_STEP_TRACE = eINSTANCE.getTTraceModel_ScenarioStepTrace();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gtrace.impl.TTraceImpl <em>TTrace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gtrace.impl.TTraceImpl
     * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTTrace()
     * @generated
     */
    EClass TTRACE = eINSTANCE.getTTrace();

    /**
     * The meta object literal for the '<em><b>Reviewed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TTRACE__REVIEWED = eINSTANCE.getTTrace_Reviewed();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl <em>TRequirement Trace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl
     * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTRequirementTrace()
     * @generated
     */
    EClass TREQUIREMENT_TRACE = eINSTANCE.getTRequirementTrace();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREQUIREMENT_TRACE__REQUIREMENT = eINSTANCE.getTRequirementTrace_Requirement();

    /**
     * The meta object literal for the '<em><b>Structural Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT = eINSTANCE.getTRequirementTrace_StructuralElement();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl <em>TScenario Trace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gtrace.impl.TScenarioTraceImpl
     * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTScenarioTrace()
     * @generated
     */
    EClass TSCENARIO_TRACE = eINSTANCE.getTScenarioTrace();

    /**
     * The meta object literal for the '<em><b>Scenario</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_TRACE__SCENARIO = eINSTANCE.getTScenarioTrace_Scenario();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_TRACE__CLASSIFIER = eINSTANCE.getTScenarioTrace_Classifier();

    /**
     * The meta object literal for the '<em><b>State Machine</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_TRACE__STATE_MACHINE = eINSTANCE.getTScenarioTrace_StateMachine();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl <em>TScenario Step Trace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gtrace.impl.TScenarioStepTraceImpl
     * @see org.genesez.metamodel.gtrace.impl.GtracePackageImpl#getTScenarioStepTrace()
     * @generated
     */
    EClass TSCENARIO_STEP_TRACE = eINSTANCE.getTScenarioStepTrace();

    /**
     * The meta object literal for the '<em><b>Scenario Step</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_STEP_TRACE__SCENARIO_STEP = eINSTANCE.getTScenarioStepTrace_ScenarioStep();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_STEP_TRACE__OPERATION = eINSTANCE.getTScenarioStepTrace_Operation();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSCENARIO_STEP_TRACE__STATE = eINSTANCE.getTScenarioStepTrace_State();

  }

} //GtracePackage
