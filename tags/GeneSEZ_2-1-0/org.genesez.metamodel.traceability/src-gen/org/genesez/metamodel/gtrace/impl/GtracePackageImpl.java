/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gtrace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.greq.GreqPackage;

import org.genesez.metamodel.gtrace.GtraceFactory;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.TRequirementTrace;
import org.genesez.metamodel.gtrace.TScenarioStepTrace;
import org.genesez.metamodel.gtrace.TScenarioTrace;
import org.genesez.metamodel.gtrace.TTrace;
import org.genesez.metamodel.gtrace.TTraceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GtracePackageImpl extends EPackageImpl implements GtracePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tTraceModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tTraceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tRequirementTraceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tScenarioTraceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tScenarioStepTraceEClass = null;

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
   * @see org.genesez.metamodel.gtrace.GtracePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GtracePackageImpl()
  {
    super(eNS_URI, GtraceFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GtracePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GtracePackage init()
  {
    if (isInited) return (GtracePackage)EPackage.Registry.INSTANCE.getEPackage(GtracePackage.eNS_URI);

    // Obtain or create and register package
    GtracePackageImpl theGtracePackage = (GtracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GtracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GtracePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    GcorePackage.eINSTANCE.eClass();
    GreqPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theGtracePackage.createPackageContents();

    // Initialize created meta-data
    theGtracePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGtracePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GtracePackage.eNS_URI, theGtracePackage);
    return theGtracePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTTraceModel()
  {
    return tTraceModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTTraceModel_Name()
  {
    return (EAttribute)tTraceModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTTraceModel_RequirementTrace()
  {
    return (EReference)tTraceModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTTraceModel_ScenarioTrace()
  {
    return (EReference)tTraceModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTTraceModel_ScenarioStepTrace()
  {
    return (EReference)tTraceModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTTrace()
  {
    return tTraceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTTrace_Reviewed()
  {
    return (EAttribute)tTraceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTRequirementTrace()
  {
    return tRequirementTraceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTRequirementTrace_Requirement()
  {
    return (EReference)tRequirementTraceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTRequirementTrace_StructuralElement()
  {
    return (EReference)tRequirementTraceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTScenarioTrace()
  {
    return tScenarioTraceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioTrace_Scenario()
  {
    return (EReference)tScenarioTraceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioTrace_Classifier()
  {
    return (EReference)tScenarioTraceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioTrace_StateMachine()
  {
    return (EReference)tScenarioTraceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTScenarioStepTrace()
  {
    return tScenarioStepTraceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioStepTrace_ScenarioStep()
  {
    return (EReference)tScenarioStepTraceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioStepTrace_Operation()
  {
    return (EReference)tScenarioStepTraceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTScenarioStepTrace_State()
  {
    return (EReference)tScenarioStepTraceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GtraceFactory getGtraceFactory()
  {
    return (GtraceFactory)getEFactoryInstance();
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
    tTraceModelEClass = createEClass(TTRACE_MODEL);
    createEAttribute(tTraceModelEClass, TTRACE_MODEL__NAME);
    createEReference(tTraceModelEClass, TTRACE_MODEL__REQUIREMENT_TRACE);
    createEReference(tTraceModelEClass, TTRACE_MODEL__SCENARIO_TRACE);
    createEReference(tTraceModelEClass, TTRACE_MODEL__SCENARIO_STEP_TRACE);

    tTraceEClass = createEClass(TTRACE);
    createEAttribute(tTraceEClass, TTRACE__REVIEWED);

    tRequirementTraceEClass = createEClass(TREQUIREMENT_TRACE);
    createEReference(tRequirementTraceEClass, TREQUIREMENT_TRACE__REQUIREMENT);
    createEReference(tRequirementTraceEClass, TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT);

    tScenarioTraceEClass = createEClass(TSCENARIO_TRACE);
    createEReference(tScenarioTraceEClass, TSCENARIO_TRACE__SCENARIO);
    createEReference(tScenarioTraceEClass, TSCENARIO_TRACE__CLASSIFIER);
    createEReference(tScenarioTraceEClass, TSCENARIO_TRACE__STATE_MACHINE);

    tScenarioStepTraceEClass = createEClass(TSCENARIO_STEP_TRACE);
    createEReference(tScenarioStepTraceEClass, TSCENARIO_STEP_TRACE__SCENARIO_STEP);
    createEReference(tScenarioStepTraceEClass, TSCENARIO_STEP_TRACE__OPERATION);
    createEReference(tScenarioStepTraceEClass, TSCENARIO_STEP_TRACE__STATE);
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

    // Obtain other dependent packages
    GreqPackage theGreqPackage = (GreqPackage)EPackage.Registry.INSTANCE.getEPackage(GreqPackage.eNS_URI);
    GcorePackage theGcorePackage = (GcorePackage)EPackage.Registry.INSTANCE.getEPackage(GcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    tRequirementTraceEClass.getESuperTypes().add(this.getTTrace());
    tScenarioTraceEClass.getESuperTypes().add(this.getTTrace());
    tScenarioStepTraceEClass.getESuperTypes().add(this.getTTrace());

    // Initialize classes and features; add operations and parameters
    initEClass(tTraceModelEClass, TTraceModel.class, "TTraceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTTraceModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, TTraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTTraceModel_RequirementTrace(), this.getTRequirementTrace(), null, "requirementTrace", null, 0, -1, TTraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTTraceModel_ScenarioTrace(), this.getTScenarioTrace(), null, "scenarioTrace", null, 0, -1, TTraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTTraceModel_ScenarioStepTrace(), this.getTScenarioStepTrace(), null, "scenarioStepTrace", null, 0, -1, TTraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tTraceEClass, TTrace.class, "TTrace", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTTrace_Reviewed(), ecorePackage.getEString(), "reviewed", null, 0, 1, TTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tRequirementTraceEClass, TRequirementTrace.class, "TRequirementTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTRequirementTrace_Requirement(), theGreqPackage.getRRequirement(), null, "requirement", null, 1, 1, TRequirementTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTRequirementTrace_StructuralElement(), theGcorePackage.getMElement(), null, "structuralElement", null, 1, 1, TRequirementTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tScenarioTraceEClass, TScenarioTrace.class, "TScenarioTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTScenarioTrace_Scenario(), theGreqPackage.getRScenario(), null, "scenario", null, 1, 1, TScenarioTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTScenarioTrace_Classifier(), theGcorePackage.getMClassifier(), null, "classifier", null, 0, 1, TScenarioTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTScenarioTrace_StateMachine(), theGcorePackage.getMStateMachine(), null, "stateMachine", null, 0, 1, TScenarioTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tScenarioStepTraceEClass, TScenarioStepTrace.class, "TScenarioStepTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTScenarioStepTrace_ScenarioStep(), theGreqPackage.getRScenarioStep(), null, "scenarioStep", null, 1, 1, TScenarioStepTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTScenarioStepTrace_Operation(), theGcorePackage.getMOperation(), null, "operation", null, 0, 1, TScenarioStepTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTScenarioStepTrace_State(), theGcorePackage.getMState(), null, "state", null, 0, 1, TScenarioStepTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //GtracePackageImpl
