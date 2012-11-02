/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genesez.metamodel.gpresentation.GpresentationFactory;
import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PAbstractArea;
import org.genesez.metamodel.gpresentation.PAction;
import org.genesez.metamodel.gpresentation.PAutomaticallyGeneratedArea;
import org.genesez.metamodel.gpresentation.PCompositeArea;
import org.genesez.metamodel.gpresentation.PCompositeElement;
import org.genesez.metamodel.gpresentation.PContentArea;
import org.genesez.metamodel.gpresentation.PElement;
import org.genesez.metamodel.gpresentation.PElementArea;
import org.genesez.metamodel.gpresentation.PInput;
import org.genesez.metamodel.gpresentation.PKey;
import org.genesez.metamodel.gpresentation.PMetaData;
import org.genesez.metamodel.gpresentation.PMetaDataAware;
import org.genesez.metamodel.gpresentation.POutput;
import org.genesez.metamodel.gpresentation.PPackage;
import org.genesez.metamodel.gpresentation.PReferenceArea;
import org.genesez.metamodel.gpresentation.PRoot;
import org.genesez.metamodel.gpresentation.PUserDefinedArea;
import org.genesez.metamodel.gpresentation.PValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GpresentationPackageImpl extends EPackageImpl implements GpresentationPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pCompositeAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pUserDefinedAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pAutomaticallyGeneratedAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pInputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pOutputEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pMetaDataEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pReferenceAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pAbstractAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pElementAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pContentAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pKeyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pMetaDataAwareEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pCompositeElementEClass = null;

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
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GpresentationPackageImpl()
  {
    super(eNS_URI, GpresentationFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GpresentationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GpresentationPackage init()
  {
    if (isInited) return (GpresentationPackage)EPackage.Registry.INSTANCE.getEPackage(GpresentationPackage.eNS_URI);

    // Obtain or create and register package
    GpresentationPackageImpl theGpresentationPackage = (GpresentationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GpresentationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GpresentationPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theGpresentationPackage.createPackageContents();

    // Initialize created meta-data
    theGpresentationPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGpresentationPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GpresentationPackage.eNS_URI, theGpresentationPackage);
    return theGpresentationPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPRoot()
  {
    return pRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPRoot_OwningPackage()
  {
    return (EReference)pRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPCompositeArea()
  {
    return pCompositeAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPElement()
  {
    return pElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPElement_Name()
  {
    return (EAttribute)pElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPElement_OwningArea()
  {
    return (EReference)pElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPElement_OwningElement()
  {
    return (EReference)pElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPUserDefinedArea()
  {
    return pUserDefinedAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPAutomaticallyGeneratedArea()
  {
    return pAutomaticallyGeneratedAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPInput()
  {
    return pInputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPOutput()
  {
    return pOutputEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPOutput_Output()
  {
    return (EAttribute)pOutputEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPAction()
  {
    return pActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPMetaData()
  {
    return pMetaDataEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPMetaData_Uri()
  {
    return (EAttribute)pMetaDataEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPMetaData_Key()
  {
    return (EReference)pMetaDataEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPMetaData_Container()
  {
    return (EReference)pMetaDataEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPReferenceArea()
  {
    return pReferenceAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPReferenceArea_Target()
  {
    return (EReference)pReferenceAreaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPAbstractArea()
  {
    return pAbstractAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPAbstractArea_Name()
  {
    return (EAttribute)pAbstractAreaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPAbstractArea_NestedContents()
  {
    return (EReference)pAbstractAreaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPElementArea()
  {
    return pElementAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPElementArea_Name()
  {
    return (EAttribute)pElementAreaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPElementArea_NestedElements()
  {
    return (EReference)pElementAreaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPContentArea()
  {
    return pContentAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPContentArea_OwningArea()
  {
    return (EReference)pContentAreaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPPackage()
  {
    return pPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPPackage_Name()
  {
    return (EAttribute)pPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPPackage_Roots()
  {
    return (EReference)pPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPPackage_OwningPackage()
  {
    return (EReference)pPackageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPPackage_NestedPackages()
  {
    return (EReference)pPackageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPPackage_MetaData()
  {
    return (EReference)pPackageEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPKey()
  {
    return pKeyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPKey_Key()
  {
    return (EAttribute)pKeyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPKey_Owner()
  {
    return (EReference)pKeyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPValue()
  {
    return pValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPValue_Value()
  {
    return (EAttribute)pValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPValue_Key()
  {
    return (EReference)pValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPValue_Owner()
  {
    return (EReference)pValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPMetaDataAware()
  {
    return pMetaDataAwareEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPMetaDataAware_MetaData()
  {
    return (EReference)pMetaDataAwareEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPMetaDataAware_Value()
  {
    return (EReference)pMetaDataAwareEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPCompositeElement()
  {
    return pCompositeElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPCompositeElement_NestedElements()
  {
    return (EReference)pCompositeElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GpresentationFactory getGpresentationFactory()
  {
    return (GpresentationFactory)getEFactoryInstance();
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
    pRootEClass = createEClass(PROOT);
    createEReference(pRootEClass, PROOT__OWNING_PACKAGE);

    pCompositeAreaEClass = createEClass(PCOMPOSITE_AREA);

    pElementEClass = createEClass(PELEMENT);
    createEAttribute(pElementEClass, PELEMENT__NAME);
    createEReference(pElementEClass, PELEMENT__OWNING_AREA);
    createEReference(pElementEClass, PELEMENT__OWNING_ELEMENT);

    pUserDefinedAreaEClass = createEClass(PUSER_DEFINED_AREA);

    pAutomaticallyGeneratedAreaEClass = createEClass(PAUTOMATICALLY_GENERATED_AREA);

    pInputEClass = createEClass(PINPUT);

    pOutputEClass = createEClass(POUTPUT);
    createEAttribute(pOutputEClass, POUTPUT__OUTPUT);

    pActionEClass = createEClass(PACTION);

    pMetaDataEClass = createEClass(PMETA_DATA);
    createEAttribute(pMetaDataEClass, PMETA_DATA__URI);
    createEReference(pMetaDataEClass, PMETA_DATA__KEY);
    createEReference(pMetaDataEClass, PMETA_DATA__CONTAINER);

    pReferenceAreaEClass = createEClass(PREFERENCE_AREA);
    createEReference(pReferenceAreaEClass, PREFERENCE_AREA__TARGET);

    pAbstractAreaEClass = createEClass(PABSTRACT_AREA);
    createEAttribute(pAbstractAreaEClass, PABSTRACT_AREA__NAME);
    createEReference(pAbstractAreaEClass, PABSTRACT_AREA__NESTED_CONTENTS);

    pElementAreaEClass = createEClass(PELEMENT_AREA);
    createEAttribute(pElementAreaEClass, PELEMENT_AREA__NAME);
    createEReference(pElementAreaEClass, PELEMENT_AREA__NESTED_ELEMENTS);

    pContentAreaEClass = createEClass(PCONTENT_AREA);
    createEReference(pContentAreaEClass, PCONTENT_AREA__OWNING_AREA);

    pPackageEClass = createEClass(PPACKAGE);
    createEAttribute(pPackageEClass, PPACKAGE__NAME);
    createEReference(pPackageEClass, PPACKAGE__ROOTS);
    createEReference(pPackageEClass, PPACKAGE__OWNING_PACKAGE);
    createEReference(pPackageEClass, PPACKAGE__NESTED_PACKAGES);
    createEReference(pPackageEClass, PPACKAGE__META_DATA);

    pKeyEClass = createEClass(PKEY);
    createEAttribute(pKeyEClass, PKEY__KEY);
    createEReference(pKeyEClass, PKEY__OWNER);

    pValueEClass = createEClass(PVALUE);
    createEAttribute(pValueEClass, PVALUE__VALUE);
    createEReference(pValueEClass, PVALUE__KEY);
    createEReference(pValueEClass, PVALUE__OWNER);

    pMetaDataAwareEClass = createEClass(PMETA_DATA_AWARE);
    createEReference(pMetaDataAwareEClass, PMETA_DATA_AWARE__META_DATA);
    createEReference(pMetaDataAwareEClass, PMETA_DATA_AWARE__VALUE);

    pCompositeElementEClass = createEClass(PCOMPOSITE_ELEMENT);
    createEReference(pCompositeElementEClass, PCOMPOSITE_ELEMENT__NESTED_ELEMENTS);
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
    pRootEClass.getESuperTypes().add(this.getPAbstractArea());
    pCompositeAreaEClass.getESuperTypes().add(this.getPAbstractArea());
    pCompositeAreaEClass.getESuperTypes().add(this.getPContentArea());
    pElementEClass.getESuperTypes().add(this.getPMetaDataAware());
    pUserDefinedAreaEClass.getESuperTypes().add(this.getPContentArea());
    pAutomaticallyGeneratedAreaEClass.getESuperTypes().add(this.getPContentArea());
    pInputEClass.getESuperTypes().add(this.getPElement());
    pOutputEClass.getESuperTypes().add(this.getPElement());
    pActionEClass.getESuperTypes().add(this.getPElement());
    pReferenceAreaEClass.getESuperTypes().add(this.getPContentArea());
    pAbstractAreaEClass.getESuperTypes().add(this.getPMetaDataAware());
    pElementAreaEClass.getESuperTypes().add(this.getPContentArea());
    pContentAreaEClass.getESuperTypes().add(this.getPMetaDataAware());
    pCompositeElementEClass.getESuperTypes().add(this.getPElement());

    // Initialize classes and features; add operations and parameters
    initEClass(pRootEClass, PRoot.class, "PRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPRoot_OwningPackage(), this.getPPackage(), this.getPPackage_Roots(), "owningPackage", null, 1, 1, PRoot.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pCompositeAreaEClass, PCompositeArea.class, "PCompositeArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pElementEClass, PElement.class, "PElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, PElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPElement_OwningArea(), this.getPElementArea(), this.getPElementArea_NestedElements(), "owningArea", null, 0, 1, PElement.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPElement_OwningElement(), this.getPCompositeElement(), this.getPCompositeElement_NestedElements(), "owningElement", null, 0, 1, PElement.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pUserDefinedAreaEClass, PUserDefinedArea.class, "PUserDefinedArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pAutomaticallyGeneratedAreaEClass, PAutomaticallyGeneratedArea.class, "PAutomaticallyGeneratedArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pInputEClass, PInput.class, "PInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pOutputEClass, POutput.class, "POutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPOutput_Output(), ecorePackage.getEString(), "output", null, 1, 1, POutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pActionEClass, PAction.class, "PAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pMetaDataEClass, PMetaData.class, "PMetaData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPMetaData_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, PMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPMetaData_Key(), this.getPKey(), this.getPKey_Owner(), "key", null, 0, -1, PMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPMetaData_Container(), this.getPPackage(), this.getPPackage_MetaData(), "container", null, 1, 1, PMetaData.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pReferenceAreaEClass, PReferenceArea.class, "PReferenceArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPReferenceArea_Target(), this.getPRoot(), null, "target", null, 1, 1, PReferenceArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pAbstractAreaEClass, PAbstractArea.class, "PAbstractArea", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPAbstractArea_Name(), ecorePackage.getEString(), "name", null, 1, 1, PAbstractArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPAbstractArea_NestedContents(), this.getPContentArea(), this.getPContentArea_OwningArea(), "nestedContents", null, 0, -1, PAbstractArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pElementAreaEClass, PElementArea.class, "PElementArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPElementArea_Name(), ecorePackage.getEString(), "name", null, 1, 1, PElementArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPElementArea_NestedElements(), this.getPElement(), this.getPElement_OwningArea(), "nestedElements", null, 0, -1, PElementArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pContentAreaEClass, PContentArea.class, "PContentArea", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPContentArea_OwningArea(), this.getPAbstractArea(), this.getPAbstractArea_NestedContents(), "owningArea", null, 1, 1, PContentArea.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pPackageEClass, PPackage.class, "PPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPPackage_Name(), ecorePackage.getEString(), "name", null, 1, 1, PPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPPackage_Roots(), this.getPRoot(), this.getPRoot_OwningPackage(), "roots", null, 0, -1, PPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPPackage_OwningPackage(), this.getPPackage(), this.getPPackage_NestedPackages(), "owningPackage", null, 1, 1, PPackage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPPackage_NestedPackages(), this.getPPackage(), this.getPPackage_OwningPackage(), "nestedPackages", null, 0, -1, PPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPPackage_MetaData(), this.getPMetaData(), this.getPMetaData_Container(), "metaData", null, 0, -1, PPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pKeyEClass, PKey.class, "PKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPKey_Key(), ecorePackage.getEString(), "key", null, 1, 1, PKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPKey_Owner(), this.getPMetaData(), this.getPMetaData_Key(), "owner", null, 1, 1, PKey.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pValueEClass, PValue.class, "PValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, PValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPValue_Key(), this.getPKey(), null, "key", null, 1, 1, PValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPValue_Owner(), this.getPMetaDataAware(), this.getPMetaDataAware_Value(), "owner", null, 1, 1, PValue.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pMetaDataAwareEClass, PMetaDataAware.class, "PMetaDataAware", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPMetaDataAware_MetaData(), this.getPMetaData(), null, "metaData", null, 0, -1, PMetaDataAware.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPMetaDataAware_Value(), this.getPValue(), this.getPValue_Owner(), "value", null, 0, -1, PMetaDataAware.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pCompositeElementEClass, PCompositeElement.class, "PCompositeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPCompositeElement_NestedElements(), this.getPElement(), this.getPElement_OwningElement(), "nestedElements", null, 1, -1, PCompositeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //GpresentationPackageImpl
