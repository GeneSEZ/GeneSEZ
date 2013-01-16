/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq;

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
 * @see org.genesez.metamodel.greq.GreqFactory
 * @model kind="package"
 * @generated
 */
public interface GreqPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "greq";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://genesez.org/metamodel/requirements";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "greq";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GreqPackage eINSTANCE = org.genesez.metamodel.greq.impl.GreqPackageImpl.init();

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RModelImpl <em>RModel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RModelImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRModel()
   * @generated
   */
  int RMODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RMODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RMODEL__REQUIREMENT = 1;

  /**
   * The feature id for the '<em><b>Scenario</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RMODEL__SCENARIO = 2;

  /**
   * The feature id for the '<em><b>Extension</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RMODEL__EXTENSION = 3;

  /**
   * The number of structural features of the '<em>RModel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RMODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl <em>RSpec Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RSpecObjectImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRSpecObject()
   * @generated
   */
  int RSPEC_OBJECT = 7;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__DEFINITION = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__ID = 1;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__VERSION = 2;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__URL = 3;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__ANNOTATION = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT__VALUE = 5;

  /**
   * The number of structural features of the '<em>RSpec Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSPEC_OBJECT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RRequirementImpl <em>RRequirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RRequirementImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRRequirement()
   * @generated
   */
  int RREQUIREMENT = 1;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__DEFINITION = RSPEC_OBJECT__DEFINITION;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__ID = RSPEC_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__VERSION = RSPEC_OBJECT__VERSION;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__URL = RSPEC_OBJECT__URL;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__ANNOTATION = RSPEC_OBJECT__ANNOTATION;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__VALUE = RSPEC_OBJECT__VALUE;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__RATIONALE = RSPEC_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__TYPE = RSPEC_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__PRECEDENCE = RSPEC_OBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Verification Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__VERIFICATION_METHOD = RSPEC_OBJECT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__MODEL = RSPEC_OBJECT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Supported Scenario</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__SUPPORTED_SCENARIO = RSPEC_OBJECT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__PARENT = RSPEC_OBJECT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Child</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__CHILD = RSPEC_OBJECT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Deriving</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__DERIVING = RSPEC_OBJECT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Derived</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__DERIVED = RSPEC_OBJECT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Refining</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__REFINING = RSPEC_OBJECT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Refined</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__REFINED = RSPEC_OBJECT_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Supported Scenario Step</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT__SUPPORTED_SCENARIO_STEP = RSPEC_OBJECT_FEATURE_COUNT + 12;

  /**
   * The number of structural features of the '<em>RRequirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RREQUIREMENT_FEATURE_COUNT = RSPEC_OBJECT_FEATURE_COUNT + 13;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RScenarioImpl <em>RScenario</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RScenarioImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRScenario()
   * @generated
   */
  int RSCENARIO = 2;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__DEFINITION = RSPEC_OBJECT__DEFINITION;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__ID = RSPEC_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__VERSION = RSPEC_OBJECT__VERSION;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__URL = RSPEC_OBJECT__URL;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__ANNOTATION = RSPEC_OBJECT__ANNOTATION;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__VALUE = RSPEC_OBJECT__VALUE;

  /**
   * The feature id for the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__PRECEDENCE = RSPEC_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Verification Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__VERIFICATION_METHOD = RSPEC_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__MODEL = RSPEC_OBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Step</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__STEP = RSPEC_OBJECT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Supported Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO__SUPPORTED_REQUIREMENT = RSPEC_OBJECT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>RScenario</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_FEATURE_COUNT = RSPEC_OBJECT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RScenarioStepImpl <em>RScenario Step</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RScenarioStepImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRScenarioStep()
   * @generated
   */
  int RSCENARIO_STEP = 3;

  /**
   * The feature id for the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__DEFINITION = RSPEC_OBJECT__DEFINITION;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__ID = RSPEC_OBJECT__ID;

  /**
   * The feature id for the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__VERSION = RSPEC_OBJECT__VERSION;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__URL = RSPEC_OBJECT__URL;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__ANNOTATION = RSPEC_OBJECT__ANNOTATION;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__VALUE = RSPEC_OBJECT__VALUE;

  /**
   * The feature id for the '<em><b>Scenario</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__SCENARIO = RSPEC_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supported Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP__SUPPORTED_REQUIREMENT = RSPEC_OBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>RScenario Step</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSCENARIO_STEP_FEATURE_COUNT = RSPEC_OBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RAnnotationImpl <em>RAnnotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RAnnotationImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRAnnotation()
   * @generated
   */
  int RANNOTATION = 4;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANNOTATION__URI = 0;

  /**
   * The feature id for the '<em><b>Tag</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANNOTATION__TAG = 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANNOTATION__MODEL = 2;

  /**
   * The number of structural features of the '<em>RAnnotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANNOTATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RTagImpl <em>RTag</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RTagImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRTag()
   * @generated
   */
  int RTAG = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RTAG__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RTAG__TYPE = 1;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RTAG__ANNOTATION = 2;

  /**
   * The number of structural features of the '<em>RTag</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RTAG_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.greq.impl.RValueImpl <em>RValue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.greq.impl.RValueImpl
   * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRValue()
   * @generated
   */
  int RVALUE = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RVALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RVALUE__TAG = 1;

  /**
   * The feature id for the '<em><b>Object</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RVALUE__OBJECT = 2;

  /**
   * The number of structural features of the '<em>RValue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RVALUE_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RModel <em>RModel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RModel</em>'.
   * @see org.genesez.metamodel.greq.RModel
   * @generated
   */
  EClass getRModel();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.greq.RModel#getName()
   * @see #getRModel()
   * @generated
   */
  EAttribute getRModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RModel#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement</em>'.
   * @see org.genesez.metamodel.greq.RModel#getRequirement()
   * @see #getRModel()
   * @generated
   */
  EReference getRModel_Requirement();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RModel#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Scenario</em>'.
   * @see org.genesez.metamodel.greq.RModel#getScenario()
   * @see #getRModel()
   * @generated
   */
  EReference getRModel_Scenario();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RModel#getExtension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extension</em>'.
   * @see org.genesez.metamodel.greq.RModel#getExtension()
   * @see #getRModel()
   * @generated
   */
  EReference getRModel_Extension();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RRequirement <em>RRequirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RRequirement</em>'.
   * @see org.genesez.metamodel.greq.RRequirement
   * @generated
   */
  EClass getRRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RRequirement#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rationale</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getRationale()
   * @see #getRRequirement()
   * @generated
   */
  EAttribute getRRequirement_Rationale();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RRequirement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getType()
   * @see #getRRequirement()
   * @generated
   */
  EAttribute getRRequirement_Type();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RRequirement#getPrecedence <em>Precedence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Precedence</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getPrecedence()
   * @see #getRRequirement()
   * @generated
   */
  EAttribute getRRequirement_Precedence();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RRequirement#getVerificationMethod <em>Verification Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Verification Method</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getVerificationMethod()
   * @see #getRRequirement()
   * @generated
   */
  EAttribute getRRequirement_VerificationMethod();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RRequirement#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getModel()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Model();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenario <em>Supported Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supported Scenario</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getSupportedScenario()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_SupportedScenario();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.greq.RRequirement#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parent</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getParent()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Parent();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RRequirement#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Child</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getChild()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Child();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.greq.RRequirement#getDeriving <em>Deriving</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Deriving</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getDeriving()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Deriving();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RRequirement#getDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Derived</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getDerived()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Derived();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.greq.RRequirement#getRefining <em>Refining</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Refining</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getRefining()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Refining();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RRequirement#getRefined <em>Refined</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refined</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getRefined()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_Refined();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RRequirement#getSupportedScenarioStep <em>Supported Scenario Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supported Scenario Step</em>'.
   * @see org.genesez.metamodel.greq.RRequirement#getSupportedScenarioStep()
   * @see #getRRequirement()
   * @generated
   */
  EReference getRRequirement_SupportedScenarioStep();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RScenario <em>RScenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RScenario</em>'.
   * @see org.genesez.metamodel.greq.RScenario
   * @generated
   */
  EClass getRScenario();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RScenario#getPrecedence <em>Precedence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Precedence</em>'.
   * @see org.genesez.metamodel.greq.RScenario#getPrecedence()
   * @see #getRScenario()
   * @generated
   */
  EAttribute getRScenario_Precedence();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RScenario#getVerificationMethod <em>Verification Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Verification Method</em>'.
   * @see org.genesez.metamodel.greq.RScenario#getVerificationMethod()
   * @see #getRScenario()
   * @generated
   */
  EAttribute getRScenario_VerificationMethod();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RScenario#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.greq.RScenario#getModel()
   * @see #getRScenario()
   * @generated
   */
  EReference getRScenario_Model();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RScenario#getStep <em>Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Step</em>'.
   * @see org.genesez.metamodel.greq.RScenario#getStep()
   * @see #getRScenario()
   * @generated
   */
  EReference getRScenario_Step();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RScenario#getSupportedRequirement <em>Supported Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supported Requirement</em>'.
   * @see org.genesez.metamodel.greq.RScenario#getSupportedRequirement()
   * @see #getRScenario()
   * @generated
   */
  EReference getRScenario_SupportedRequirement();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RScenarioStep <em>RScenario Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RScenario Step</em>'.
   * @see org.genesez.metamodel.greq.RScenarioStep
   * @generated
   */
  EClass getRScenarioStep();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RScenarioStep#getScenario <em>Scenario</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Scenario</em>'.
   * @see org.genesez.metamodel.greq.RScenarioStep#getScenario()
   * @see #getRScenarioStep()
   * @generated
   */
  EReference getRScenarioStep_Scenario();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RScenarioStep#getSupportedRequirement <em>Supported Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supported Requirement</em>'.
   * @see org.genesez.metamodel.greq.RScenarioStep#getSupportedRequirement()
   * @see #getRScenarioStep()
   * @generated
   */
  EReference getRScenarioStep_SupportedRequirement();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RAnnotation <em>RAnnotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RAnnotation</em>'.
   * @see org.genesez.metamodel.greq.RAnnotation
   * @generated
   */
  EClass getRAnnotation();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RAnnotation#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.genesez.metamodel.greq.RAnnotation#getUri()
   * @see #getRAnnotation()
   * @generated
   */
  EAttribute getRAnnotation_Uri();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RAnnotation#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tag</em>'.
   * @see org.genesez.metamodel.greq.RAnnotation#getTag()
   * @see #getRAnnotation()
   * @generated
   */
  EReference getRAnnotation_Tag();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RAnnotation#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.greq.RAnnotation#getModel()
   * @see #getRAnnotation()
   * @generated
   */
  EReference getRAnnotation_Model();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RTag <em>RTag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RTag</em>'.
   * @see org.genesez.metamodel.greq.RTag
   * @generated
   */
  EClass getRTag();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RTag#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.greq.RTag#getName()
   * @see #getRTag()
   * @generated
   */
  EAttribute getRTag_Name();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RTag#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.genesez.metamodel.greq.RTag#getType()
   * @see #getRTag()
   * @generated
   */
  EAttribute getRTag_Type();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RTag#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Annotation</em>'.
   * @see org.genesez.metamodel.greq.RTag#getAnnotation()
   * @see #getRTag()
   * @generated
   */
  EReference getRTag_Annotation();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RValue <em>RValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RValue</em>'.
   * @see org.genesez.metamodel.greq.RValue
   * @generated
   */
  EClass getRValue();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.genesez.metamodel.greq.RValue#getValue()
   * @see #getRValue()
   * @generated
   */
  EAttribute getRValue_Value();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.greq.RValue#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tag</em>'.
   * @see org.genesez.metamodel.greq.RValue#getTag()
   * @see #getRValue()
   * @generated
   */
  EReference getRValue_Tag();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.greq.RValue#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Object</em>'.
   * @see org.genesez.metamodel.greq.RValue#getObject()
   * @see #getRValue()
   * @generated
   */
  EReference getRValue_Object();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.greq.RSpecObject <em>RSpec Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RSpec Object</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject
   * @generated
   */
  EClass getRSpecObject();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RSpecObject#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Definition</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getDefinition()
   * @see #getRSpecObject()
   * @generated
   */
  EAttribute getRSpecObject_Definition();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RSpecObject#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getId()
   * @see #getRSpecObject()
   * @generated
   */
  EAttribute getRSpecObject_Id();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RSpecObject#getVersion <em>Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Version</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getVersion()
   * @see #getRSpecObject()
   * @generated
   */
  EAttribute getRSpecObject_Version();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.greq.RSpecObject#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getUrl()
   * @see #getRSpecObject()
   * @generated
   */
  EAttribute getRSpecObject_Url();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.greq.RSpecObject#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Annotation</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getAnnotation()
   * @see #getRSpecObject()
   * @generated
   */
  EReference getRSpecObject_Annotation();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.greq.RSpecObject#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see org.genesez.metamodel.greq.RSpecObject#getValue()
   * @see #getRSpecObject()
   * @generated
   */
  EReference getRSpecObject_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GreqFactory getGreqFactory();

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
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RModelImpl <em>RModel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RModelImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRModel()
     * @generated
     */
    EClass RMODEL = eINSTANCE.getRModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RMODEL__NAME = eINSTANCE.getRModel_Name();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RMODEL__REQUIREMENT = eINSTANCE.getRModel_Requirement();

    /**
     * The meta object literal for the '<em><b>Scenario</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RMODEL__SCENARIO = eINSTANCE.getRModel_Scenario();

    /**
     * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RMODEL__EXTENSION = eINSTANCE.getRModel_Extension();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RRequirementImpl <em>RRequirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RRequirementImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRRequirement()
     * @generated
     */
    EClass RREQUIREMENT = eINSTANCE.getRRequirement();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RREQUIREMENT__RATIONALE = eINSTANCE.getRRequirement_Rationale();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RREQUIREMENT__TYPE = eINSTANCE.getRRequirement_Type();

    /**
     * The meta object literal for the '<em><b>Precedence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RREQUIREMENT__PRECEDENCE = eINSTANCE.getRRequirement_Precedence();

    /**
     * The meta object literal for the '<em><b>Verification Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RREQUIREMENT__VERIFICATION_METHOD = eINSTANCE.getRRequirement_VerificationMethod();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__MODEL = eINSTANCE.getRRequirement_Model();

    /**
     * The meta object literal for the '<em><b>Supported Scenario</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__SUPPORTED_SCENARIO = eINSTANCE.getRRequirement_SupportedScenario();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__PARENT = eINSTANCE.getRRequirement_Parent();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__CHILD = eINSTANCE.getRRequirement_Child();

    /**
     * The meta object literal for the '<em><b>Deriving</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__DERIVING = eINSTANCE.getRRequirement_Deriving();

    /**
     * The meta object literal for the '<em><b>Derived</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__DERIVED = eINSTANCE.getRRequirement_Derived();

    /**
     * The meta object literal for the '<em><b>Refining</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__REFINING = eINSTANCE.getRRequirement_Refining();

    /**
     * The meta object literal for the '<em><b>Refined</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__REFINED = eINSTANCE.getRRequirement_Refined();

    /**
     * The meta object literal for the '<em><b>Supported Scenario Step</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RREQUIREMENT__SUPPORTED_SCENARIO_STEP = eINSTANCE.getRRequirement_SupportedScenarioStep();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RScenarioImpl <em>RScenario</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RScenarioImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRScenario()
     * @generated
     */
    EClass RSCENARIO = eINSTANCE.getRScenario();

    /**
     * The meta object literal for the '<em><b>Precedence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSCENARIO__PRECEDENCE = eINSTANCE.getRScenario_Precedence();

    /**
     * The meta object literal for the '<em><b>Verification Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSCENARIO__VERIFICATION_METHOD = eINSTANCE.getRScenario_VerificationMethod();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSCENARIO__MODEL = eINSTANCE.getRScenario_Model();

    /**
     * The meta object literal for the '<em><b>Step</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSCENARIO__STEP = eINSTANCE.getRScenario_Step();

    /**
     * The meta object literal for the '<em><b>Supported Requirement</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSCENARIO__SUPPORTED_REQUIREMENT = eINSTANCE.getRScenario_SupportedRequirement();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RScenarioStepImpl <em>RScenario Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RScenarioStepImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRScenarioStep()
     * @generated
     */
    EClass RSCENARIO_STEP = eINSTANCE.getRScenarioStep();

    /**
     * The meta object literal for the '<em><b>Scenario</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSCENARIO_STEP__SCENARIO = eINSTANCE.getRScenarioStep_Scenario();

    /**
     * The meta object literal for the '<em><b>Supported Requirement</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSCENARIO_STEP__SUPPORTED_REQUIREMENT = eINSTANCE.getRScenarioStep_SupportedRequirement();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RAnnotationImpl <em>RAnnotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RAnnotationImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRAnnotation()
     * @generated
     */
    EClass RANNOTATION = eINSTANCE.getRAnnotation();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANNOTATION__URI = eINSTANCE.getRAnnotation_Uri();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANNOTATION__TAG = eINSTANCE.getRAnnotation_Tag();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANNOTATION__MODEL = eINSTANCE.getRAnnotation_Model();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RTagImpl <em>RTag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RTagImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRTag()
     * @generated
     */
    EClass RTAG = eINSTANCE.getRTag();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RTAG__NAME = eINSTANCE.getRTag_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RTAG__TYPE = eINSTANCE.getRTag_Type();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RTAG__ANNOTATION = eINSTANCE.getRTag_Annotation();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RValueImpl <em>RValue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RValueImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRValue()
     * @generated
     */
    EClass RVALUE = eINSTANCE.getRValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RVALUE__VALUE = eINSTANCE.getRValue_Value();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RVALUE__TAG = eINSTANCE.getRValue_Tag();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RVALUE__OBJECT = eINSTANCE.getRValue_Object();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl <em>RSpec Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.greq.impl.RSpecObjectImpl
     * @see org.genesez.metamodel.greq.impl.GreqPackageImpl#getRSpecObject()
     * @generated
     */
    EClass RSPEC_OBJECT = eINSTANCE.getRSpecObject();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSPEC_OBJECT__DEFINITION = eINSTANCE.getRSpecObject_Definition();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSPEC_OBJECT__ID = eINSTANCE.getRSpecObject_Id();

    /**
     * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSPEC_OBJECT__VERSION = eINSTANCE.getRSpecObject_Version();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSPEC_OBJECT__URL = eINSTANCE.getRSpecObject_Url();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSPEC_OBJECT__ANNOTATION = eINSTANCE.getRSpecObject_Annotation();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RSPEC_OBJECT__VALUE = eINSTANCE.getRSpecObject_Value();

  }

} //GreqPackage
