/**
 */
package org.genesez.metamodel.greq.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genesez.metamodel.greq.GreqFactory;
import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RAnnotation;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;
import org.genesez.metamodel.greq.RScenarioStep;
import org.genesez.metamodel.greq.RSpecObject;
import org.genesez.metamodel.greq.RTag;
import org.genesez.metamodel.greq.RValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GreqPackageImpl extends EPackageImpl implements GreqPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rScenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rScenarioStepEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rAnnotationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rTagEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rSpecObjectEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.genesez.metamodel.greq.GreqPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GreqPackageImpl()
  {
    super(eNS_URI, GreqFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link GreqPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GreqPackage init()
  {
    if (isInited) return (GreqPackage)EPackage.Registry.INSTANCE.getEPackage(GreqPackage.eNS_URI);

    // Obtain or create and register package
    GreqPackageImpl theGreqPackage = (GreqPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GreqPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GreqPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theGreqPackage.createPackageContents();

    // Initialize created meta-data
    theGreqPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGreqPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GreqPackage.eNS_URI, theGreqPackage);
    return theGreqPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRModel()
  {
    return rModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRModel_Name()
  {
    return (EAttribute)rModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRModel_Requirement()
  {
    return (EReference)rModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRModel_Scenario()
  {
    return (EReference)rModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRModel_Extension()
  {
    return (EReference)rModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRRequirement()
  {
    return rRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRRequirement_Rationale()
  {
    return (EAttribute)rRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRRequirement_Type()
  {
    return (EAttribute)rRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRRequirement_Precedence()
  {
    return (EAttribute)rRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRRequirement_VerificationMethod()
  {
    return (EAttribute)rRequirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Model()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_SupportedScenario()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Parent()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Child()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Deriving()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Derived()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Refining()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_Refined()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRRequirement_SupportedScenarioStep()
  {
    return (EReference)rRequirementEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRScenario()
  {
    return rScenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRScenario_Precedence()
  {
    return (EAttribute)rScenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRScenario_VerificationMethod()
  {
    return (EAttribute)rScenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRScenario_Model()
  {
    return (EReference)rScenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRScenario_Step()
  {
    return (EReference)rScenarioEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRScenario_SupportedRequirement()
  {
    return (EReference)rScenarioEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRScenarioStep()
  {
    return rScenarioStepEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRScenarioStep_Scenario()
  {
    return (EReference)rScenarioStepEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRScenarioStep_SupportedRequirement()
  {
    return (EReference)rScenarioStepEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRAnnotation()
  {
    return rAnnotationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRAnnotation_Uri()
  {
    return (EAttribute)rAnnotationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRAnnotation_Tag()
  {
    return (EReference)rAnnotationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRAnnotation_Model()
  {
    return (EReference)rAnnotationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRTag()
  {
    return rTagEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRTag_Name()
  {
    return (EAttribute)rTagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRTag_Type()
  {
    return (EAttribute)rTagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRTag_Annotation()
  {
    return (EReference)rTagEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRValue()
  {
    return rValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRValue_Value()
  {
    return (EAttribute)rValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRValue_Tag()
  {
    return (EReference)rValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRValue_Object()
  {
    return (EReference)rValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRSpecObject()
  {
    return rSpecObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSpecObject_Definition()
  {
    return (EAttribute)rSpecObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSpecObject_Id()
  {
    return (EAttribute)rSpecObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSpecObject_Version()
  {
    return (EAttribute)rSpecObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSpecObject_Url()
  {
    return (EAttribute)rSpecObjectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRSpecObject_Annotation()
  {
    return (EReference)rSpecObjectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRSpecObject_Value()
  {
    return (EReference)rSpecObjectEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreqFactory getGreqFactory()
  {
    return (GreqFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    rModelEClass = createEClass(RMODEL);
    createEAttribute(rModelEClass, RMODEL__NAME);
    createEReference(rModelEClass, RMODEL__REQUIREMENT);
    createEReference(rModelEClass, RMODEL__SCENARIO);
    createEReference(rModelEClass, RMODEL__EXTENSION);

    rRequirementEClass = createEClass(RREQUIREMENT);
    createEAttribute(rRequirementEClass, RREQUIREMENT__RATIONALE);
    createEAttribute(rRequirementEClass, RREQUIREMENT__TYPE);
    createEAttribute(rRequirementEClass, RREQUIREMENT__PRECEDENCE);
    createEAttribute(rRequirementEClass, RREQUIREMENT__VERIFICATION_METHOD);
    createEReference(rRequirementEClass, RREQUIREMENT__MODEL);
    createEReference(rRequirementEClass, RREQUIREMENT__SUPPORTED_SCENARIO);
    createEReference(rRequirementEClass, RREQUIREMENT__PARENT);
    createEReference(rRequirementEClass, RREQUIREMENT__CHILD);
    createEReference(rRequirementEClass, RREQUIREMENT__DERIVING);
    createEReference(rRequirementEClass, RREQUIREMENT__DERIVED);
    createEReference(rRequirementEClass, RREQUIREMENT__REFINING);
    createEReference(rRequirementEClass, RREQUIREMENT__REFINED);
    createEReference(rRequirementEClass, RREQUIREMENT__SUPPORTED_SCENARIO_STEP);

    rScenarioEClass = createEClass(RSCENARIO);
    createEAttribute(rScenarioEClass, RSCENARIO__PRECEDENCE);
    createEAttribute(rScenarioEClass, RSCENARIO__VERIFICATION_METHOD);
    createEReference(rScenarioEClass, RSCENARIO__MODEL);
    createEReference(rScenarioEClass, RSCENARIO__STEP);
    createEReference(rScenarioEClass, RSCENARIO__SUPPORTED_REQUIREMENT);

    rScenarioStepEClass = createEClass(RSCENARIO_STEP);
    createEReference(rScenarioStepEClass, RSCENARIO_STEP__SCENARIO);
    createEReference(rScenarioStepEClass, RSCENARIO_STEP__SUPPORTED_REQUIREMENT);

    rAnnotationEClass = createEClass(RANNOTATION);
    createEAttribute(rAnnotationEClass, RANNOTATION__URI);
    createEReference(rAnnotationEClass, RANNOTATION__TAG);
    createEReference(rAnnotationEClass, RANNOTATION__MODEL);

    rTagEClass = createEClass(RTAG);
    createEAttribute(rTagEClass, RTAG__NAME);
    createEAttribute(rTagEClass, RTAG__TYPE);
    createEReference(rTagEClass, RTAG__ANNOTATION);

    rValueEClass = createEClass(RVALUE);
    createEAttribute(rValueEClass, RVALUE__VALUE);
    createEReference(rValueEClass, RVALUE__TAG);
    createEReference(rValueEClass, RVALUE__OBJECT);

    rSpecObjectEClass = createEClass(RSPEC_OBJECT);
    createEAttribute(rSpecObjectEClass, RSPEC_OBJECT__DEFINITION);
    createEAttribute(rSpecObjectEClass, RSPEC_OBJECT__ID);
    createEAttribute(rSpecObjectEClass, RSPEC_OBJECT__VERSION);
    createEAttribute(rSpecObjectEClass, RSPEC_OBJECT__URL);
    createEReference(rSpecObjectEClass, RSPEC_OBJECT__ANNOTATION);
    createEReference(rSpecObjectEClass, RSPEC_OBJECT__VALUE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    rRequirementEClass.getESuperTypes().add(this.getRSpecObject());
    rScenarioEClass.getESuperTypes().add(this.getRSpecObject());
    rScenarioStepEClass.getESuperTypes().add(this.getRSpecObject());

    // Initialize classes and features; add operations and parameters
    initEClass(rModelEClass, RModel.class, "RModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, RModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRModel_Requirement(), this.getRRequirement(), this.getRRequirement_Model(), "requirement", null, 0, -1, RModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRModel_Scenario(), this.getRScenario(), this.getRScenario_Model(), "scenario", null, 0, -1, RModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRModel_Extension(), this.getRAnnotation(), this.getRAnnotation_Model(), "extension", null, 0, -1, RModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rRequirementEClass, RRequirement.class, "RRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRRequirement_Rationale(), ecorePackage.getEString(), "rationale", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRRequirement_Type(), ecorePackage.getEString(), "type", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRRequirement_Precedence(), ecorePackage.getEString(), "precedence", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRRequirement_VerificationMethod(), ecorePackage.getEString(), "verificationMethod", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Model(), this.getRModel(), this.getRModel_Requirement(), "model", null, 1, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_SupportedScenario(), this.getRScenario(), this.getRScenario_SupportedRequirement(), "supportedScenario", null, 0, -1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Parent(), this.getRRequirement(), this.getRRequirement_Child(), "parent", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Child(), this.getRRequirement(), this.getRRequirement_Parent(), "child", null, 0, -1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Deriving(), this.getRRequirement(), this.getRRequirement_Derived(), "deriving", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Derived(), this.getRRequirement(), this.getRRequirement_Deriving(), "derived", null, 0, -1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Refining(), this.getRRequirement(), this.getRRequirement_Refined(), "refining", null, 0, 1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_Refined(), this.getRRequirement(), this.getRRequirement_Refining(), "refined", null, 0, -1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRRequirement_SupportedScenarioStep(), this.getRScenarioStep(), this.getRScenarioStep_SupportedRequirement(), "supportedScenarioStep", null, 0, -1, RRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rScenarioEClass, RScenario.class, "RScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRScenario_Precedence(), ecorePackage.getEString(), "precedence", null, 0, 1, RScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRScenario_VerificationMethod(), ecorePackage.getEString(), "verificationMethod", null, 0, 1, RScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRScenario_Model(), this.getRModel(), this.getRModel_Scenario(), "model", null, 1, 1, RScenario.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRScenario_Step(), this.getRScenarioStep(), this.getRScenarioStep_Scenario(), "step", null, 1, -1, RScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRScenario_SupportedRequirement(), this.getRRequirement(), this.getRRequirement_SupportedScenario(), "supportedRequirement", null, 0, -1, RScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rScenarioStepEClass, RScenarioStep.class, "RScenarioStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRScenarioStep_Scenario(), this.getRScenario(), this.getRScenario_Step(), "scenario", null, 1, 1, RScenarioStep.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRScenarioStep_SupportedRequirement(), this.getRRequirement(), this.getRRequirement_SupportedScenarioStep(), "supportedRequirement", null, 0, -1, RScenarioStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rAnnotationEClass, RAnnotation.class, "RAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRAnnotation_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, RAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRAnnotation_Tag(), this.getRTag(), this.getRTag_Annotation(), "tag", null, 0, -1, RAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRAnnotation_Model(), this.getRModel(), this.getRModel_Extension(), "model", null, 1, 1, RAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rTagEClass, RTag.class, "RTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRTag_Name(), ecorePackage.getEString(), "name", null, 1, 1, RTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRTag_Type(), ecorePackage.getEString(), "type", null, 0, 1, RTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRTag_Annotation(), this.getRAnnotation(), this.getRAnnotation_Tag(), "annotation", null, 1, 1, RTag.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rValueEClass, RValue.class, "RValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, RValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRValue_Tag(), this.getRTag(), null, "tag", null, 1, 1, RValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRValue_Object(), this.getRSpecObject(), this.getRSpecObject_Value(), "object", null, 1, 1, RValue.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rSpecObjectEClass, RSpecObject.class, "RSpecObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRSpecObject_Definition(), ecorePackage.getEString(), "definition", null, 1, 1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRSpecObject_Id(), ecorePackage.getEString(), "id", null, 1, 1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRSpecObject_Version(), ecorePackage.getEString(), "version", null, 1, 1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRSpecObject_Url(), ecorePackage.getEString(), "url", null, 0, 1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRSpecObject_Annotation(), this.getRAnnotation(), null, "annotation", null, 0, -1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRSpecObject_Value(), this.getRValue(), this.getRValue_Object(), "value", null, 0, -1, RSpecObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //GreqPackageImpl
