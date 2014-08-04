/**
 */
package org.genesez.metamodel.gcore.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.genesez.metamodel.gcore.GcoreFactory;
import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAction;
import org.genesez.metamodel.gcore.MActivity;
import org.genesez.metamodel.gcore.MAspect;
import org.genesez.metamodel.gcore.MAssociation;
import org.genesez.metamodel.gcore.MAssociationRole;
import org.genesez.metamodel.gcore.MAtomicTransition;
import org.genesez.metamodel.gcore.MAttribute;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MClass;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MComment;
import org.genesez.metamodel.gcore.MCompositeState;
import org.genesez.metamodel.gcore.MDataType;
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MDependency;
import org.genesez.metamodel.gcore.MDestinationKind;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MEnumeration;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MExternal;
import org.genesez.metamodel.gcore.MFinal;
import org.genesez.metamodel.gcore.MFinalState;
import org.genesez.metamodel.gcore.MFlow;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MGuard;
import org.genesez.metamodel.gcore.MHistoryState;
import org.genesez.metamodel.gcore.MInitial;
import org.genesez.metamodel.gcore.MInitialState;
import org.genesez.metamodel.gcore.MInterface;
import org.genesez.metamodel.gcore.MIntroduction;
import org.genesez.metamodel.gcore.MLeafState;
import org.genesez.metamodel.gcore.MLiteral;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.metamodel.gcore.MMultiplicity;
import org.genesez.metamodel.gcore.MNode;
import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.MPackage;
import org.genesez.metamodel.gcore.MParameter;
import org.genesez.metamodel.gcore.MPointcut;
import org.genesez.metamodel.gcore.MProperty;
import org.genesez.metamodel.gcore.MState;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.gcore.MStereotype;
import org.genesez.metamodel.gcore.MTag;
import org.genesez.metamodel.gcore.MTaggedValue;
import org.genesez.metamodel.gcore.MTimeEvent;
import org.genesez.metamodel.gcore.MTransition;
import org.genesez.metamodel.gcore.MType;
import org.genesez.metamodel.gcore.MUseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GcorePackageImpl extends EPackageImpl implements GcorePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAssociationRoleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mClassifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mDataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mEnumerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mStereotypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTagEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTaggedValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAspectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mIntroductionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mGenericEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mExternalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mActivityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mStateMachineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mFlowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mGuardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mUseCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mInitialEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mFinalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mDefinitionContextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAtomicTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mLeafStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mCompositeStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mInitialStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mFinalStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mHistoryStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTimeEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mMultiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum mDestinationKindEEnum = null;

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
   * @see org.genesez.metamodel.gcore.GcorePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GcorePackageImpl()
  {
    super(eNS_URI, GcoreFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link GcorePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GcorePackage init()
  {
    if (isInited) return (GcorePackage)EPackage.Registry.INSTANCE.getEPackage(GcorePackage.eNS_URI);

    // Obtain or create and register package
    GcorePackageImpl theGcorePackage = (GcorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GcorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GcorePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theGcorePackage.createPackageContents();

    // Initialize created meta-data
    theGcorePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGcorePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GcorePackage.eNS_URI, theGcorePackage);
    return theGcorePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMPackage()
  {
    return mPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_NestedPackage()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_NestingPackage()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_Association()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_OwnedDependency()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMClass()
  {
    return mClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClass_OwnedAssociation()
  {
    return (EReference)mClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAssociationRole()
  {
    return mAssociationRoleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociationRole_Aggregation()
  {
    return (EAttribute)mAssociationRoleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociationRole_Composition()
  {
    return (EAttribute)mAssociationRoleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_Association()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_Opposite()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_Qualifier()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_OppositeMultiplicity()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_QualifierMultiplicity()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAssociation()
  {
    return mAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociation_Derived()
  {
    return (EAttribute)mAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_End()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_OwningPackage()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_AssociationClass()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAttribute()
  {
    return mAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Defaultvalue()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Static()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Final()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMModel()
  {
    return mModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMModel_AnyStereotype()
  {
    return (EReference)mModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMModel_ExternalTypes()
  {
    return (EReference)mModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMElement()
  {
    return mElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMElement_Name()
  {
    return (EAttribute)mElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMElement_XmiGuid()
  {
    return (EAttribute)mElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_OwnedComment()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_TaggedValue()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_Stereotype()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_Aspect()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_Dependency()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMProperty()
  {
    return mPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Visibility()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Derived()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_Classifier()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_GenericRealization()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_Type()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_Multiplicity()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMInterface()
  {
    return mInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMClassifier()
  {
    return mClassifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Visibility()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Abstract()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Final()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Operation()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Property()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_GenericParameter()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Realization()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Generalization()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Supplier()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_OwningContext()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMOperation()
  {
    return mOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Visibility()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Static()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Abstract()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Final()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_Parameter()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_Classifier()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_GenericParameter()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_RaisedException()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_Return()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMParameter()
  {
    return mParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Defaultvalue()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Direction()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_GenericRealization()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Type()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Event()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Operation()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Multiplicity()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMDataType()
  {
    return mDataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMEnumeration()
  {
    return mEnumerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMEnumeration_Literal()
  {
    return (EReference)mEnumerationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMStereotype()
  {
    return mStereotypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStereotype_Property()
  {
    return (EReference)mStereotypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStereotype_Model()
  {
    return (EReference)mStereotypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStereotype_Generalization()
  {
    return (EReference)mStereotypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTag()
  {
    return mTagEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTag_Name()
  {
    return (EAttribute)mTagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTag_Type()
  {
    return (EAttribute)mTagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTag_Stereotype()
  {
    return (EReference)mTagEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMComment()
  {
    return mCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMComment_XmiGuid()
  {
    return (EAttribute)mCommentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMComment_Annotation()
  {
    return (EAttribute)mCommentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_OwningElement()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_NestingComment()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_NestedComment()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTaggedValue()
  {
    return mTaggedValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTaggedValue_Value()
  {
    return (EAttribute)mTaggedValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTaggedValue_OwningElement()
  {
    return (EReference)mTaggedValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTaggedValue_Tag()
  {
    return (EReference)mTaggedValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTaggedValue_ValueReference()
  {
    return (EReference)mTaggedValueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAspect()
  {
    return mAspectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAspect_Domain()
  {
    return (EAttribute)mAspectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAspect_Name()
  {
    return (EAttribute)mAspectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Element()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Introduction()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Pointcut()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMIntroduction()
  {
    return mIntroductionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMIntroduction_Domain()
  {
    return (EAttribute)mIntroductionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMIntroduction_Name()
  {
    return (EAttribute)mIntroductionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMIntroduction_Origin()
  {
    return (EReference)mIntroductionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMPointcut()
  {
    return mPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Domain()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Name()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Destination()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPointcut_Origin()
  {
    return (EReference)mPointcutEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMLiteral()
  {
    return mLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMLiteral_OwningEnumeration()
  {
    return (EReference)mLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMGeneric()
  {
    return mGenericEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMGeneric_Specification()
  {
    return (EAttribute)mGenericEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningClassifier()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningOperation()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningProperty()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningParameter()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningExternal()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_Default()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_Constraint()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMType()
  {
    return mTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMType_Specialization()
  {
    return (EReference)mTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMExternal()
  {
    return mExternalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMExternal_Model()
  {
    return (EReference)mExternalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMExternal_GenericParameter()
  {
    return (EReference)mExternalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMActivity()
  {
    return mActivityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMActivity_Edge()
  {
    return (EReference)mActivityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMActivity_Node()
  {
    return (EReference)mActivityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAction()
  {
    return mActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAction_Behavior()
  {
    return (EReference)mActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAction_Out()
  {
    return (EReference)mActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAction_In()
  {
    return (EReference)mActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAction_Operation()
  {
    return (EReference)mActionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMBehavior()
  {
    return mBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMBehavior_OwningContext()
  {
    return (EReference)mBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMBehavior_Transition()
  {
    return (EReference)mBehaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMBehavior_Entry()
  {
    return (EReference)mBehaviorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMBehavior_Exit()
  {
    return (EReference)mBehaviorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMBehavior_Do()
  {
    return (EReference)mBehaviorEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMStateMachine()
  {
    return mStateMachineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStateMachine_Smstate()
  {
    return (EReference)mStateMachineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStateMachine_Smtransition()
  {
    return (EReference)mStateMachineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStateMachine_AtomicTransition()
  {
    return (EReference)mStateMachineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMFlow()
  {
    return mFlowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMFlow_Source()
  {
    return (EReference)mFlowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMFlow_Target()
  {
    return (EReference)mFlowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMFlow_Guard()
  {
    return (EReference)mFlowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMFlow_Transport()
  {
    return (EReference)mFlowEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMNode()
  {
    return mNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMNode_To()
  {
    return (EReference)mNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMNode_From()
  {
    return (EReference)mNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMGuard()
  {
    return mGuardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGuard_Transition()
  {
    return (EReference)mGuardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGuard_OwningContext()
  {
    return (EReference)mGuardEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMUseCase()
  {
    return mUseCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMInitial()
  {
    return mInitialEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMFinal()
  {
    return mFinalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMState()
  {
    return mStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Owner()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Outgoing()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Incoming()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Entry()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Exit()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Do()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMState_Superstate()
  {
    return (EReference)mStateEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTransition()
  {
    return mTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTransition_Kind()
  {
    return (EAttribute)mTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Source()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Target()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Guard()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Statemachine()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Trigger()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTransition_Action()
  {
    return (EReference)mTransitionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMDefinitionContext()
  {
    return mDefinitionContextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDefinitionContext_Classifier()
  {
    return (EReference)mDefinitionContextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDefinitionContext_OwnedBehavior()
  {
    return (EReference)mDefinitionContextEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDefinitionContext_Guard()
  {
    return (EReference)mDefinitionContextEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDefinitionContext_Event()
  {
    return (EReference)mDefinitionContextEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMEvent()
  {
    return mEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMEvent_IsCall()
  {
    return (EAttribute)mEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMEvent_IsChange()
  {
    return (EAttribute)mEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMEvent_OwningContext()
  {
    return (EReference)mEventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMEvent_Parameter()
  {
    return (EReference)mEventEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAtomicTransition()
  {
    return mAtomicTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_DefiningTransition()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_EndDo()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Exit()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Action()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Entry()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_StartDo()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_HistoryContext()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Statemachine()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_StartTimer()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_StopTimer()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Source()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAtomicTransition_Target()
  {
    return (EReference)mAtomicTransitionEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMLeafState()
  {
    return mLeafStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMCompositeState()
  {
    return mCompositeStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMCompositeState_Substate()
  {
    return (EReference)mCompositeStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMInitialState()
  {
    return mInitialStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMFinalState()
  {
    return mFinalStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMHistoryState()
  {
    return mHistoryStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMHistoryState_Deep()
  {
    return (EAttribute)mHistoryStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMHistoryState_ReachableHistory()
  {
    return (EReference)mHistoryStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMHistoryState_DefaultHistory()
  {
    return (EReference)mHistoryStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTimeEvent()
  {
    return mTimeEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTimeEvent_IsRelative()
  {
    return (EAttribute)mTimeEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTimeEvent_When()
  {
    return (EAttribute)mTimeEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMMultiplicity()
  {
    return mMultiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMultiplicity_Unique()
  {
    return (EAttribute)mMultiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMultiplicity_Ordered()
  {
    return (EAttribute)mMultiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMultiplicity_LowerBound()
  {
    return (EAttribute)mMultiplicityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMMultiplicity_UpperBound()
  {
    return (EAttribute)mMultiplicityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMDependency()
  {
    return mDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDependency_OwningPackage()
  {
    return (EReference)mDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDependency_Supplier()
  {
    return (EReference)mDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMDependency_Client()
  {
    return (EReference)mDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMDestinationKind()
  {
    return mDestinationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreFactory getGcoreFactory()
  {
    return (GcoreFactory)getEFactoryInstance();
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
    mPackageEClass = createEClass(MPACKAGE);
    createEReference(mPackageEClass, MPACKAGE__NESTED_PACKAGE);
    createEReference(mPackageEClass, MPACKAGE__NESTING_PACKAGE);
    createEReference(mPackageEClass, MPACKAGE__ASSOCIATION);
    createEReference(mPackageEClass, MPACKAGE__OWNED_DEPENDENCY);

    mClassEClass = createEClass(MCLASS);
    createEReference(mClassEClass, MCLASS__OWNED_ASSOCIATION);

    mAssociationRoleEClass = createEClass(MASSOCIATION_ROLE);
    createEAttribute(mAssociationRoleEClass, MASSOCIATION_ROLE__AGGREGATION);
    createEAttribute(mAssociationRoleEClass, MASSOCIATION_ROLE__COMPOSITION);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__ASSOCIATION);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__OPPOSITE);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__QUALIFIER);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY);

    mAssociationEClass = createEClass(MASSOCIATION);
    createEAttribute(mAssociationEClass, MASSOCIATION__DERIVED);
    createEReference(mAssociationEClass, MASSOCIATION__END);
    createEReference(mAssociationEClass, MASSOCIATION__OWNING_PACKAGE);
    createEReference(mAssociationEClass, MASSOCIATION__ASSOCIATION_CLASS);

    mAttributeEClass = createEClass(MATTRIBUTE);
    createEAttribute(mAttributeEClass, MATTRIBUTE__DEFAULTVALUE);
    createEAttribute(mAttributeEClass, MATTRIBUTE__STATIC);
    createEAttribute(mAttributeEClass, MATTRIBUTE__FINAL);

    mModelEClass = createEClass(MMODEL);
    createEReference(mModelEClass, MMODEL__ANY_STEREOTYPE);
    createEReference(mModelEClass, MMODEL__EXTERNAL_TYPES);

    mElementEClass = createEClass(MELEMENT);
    createEAttribute(mElementEClass, MELEMENT__NAME);
    createEAttribute(mElementEClass, MELEMENT__XMI_GUID);
    createEReference(mElementEClass, MELEMENT__OWNED_COMMENT);
    createEReference(mElementEClass, MELEMENT__TAGGED_VALUE);
    createEReference(mElementEClass, MELEMENT__STEREOTYPE);
    createEReference(mElementEClass, MELEMENT__ASPECT);
    createEReference(mElementEClass, MELEMENT__DEPENDENCY);

    mPropertyEClass = createEClass(MPROPERTY);
    createEAttribute(mPropertyEClass, MPROPERTY__VISIBILITY);
    createEAttribute(mPropertyEClass, MPROPERTY__DERIVED);
    createEReference(mPropertyEClass, MPROPERTY__CLASSIFIER);
    createEReference(mPropertyEClass, MPROPERTY__GENERIC_REALIZATION);
    createEReference(mPropertyEClass, MPROPERTY__TYPE);
    createEReference(mPropertyEClass, MPROPERTY__MULTIPLICITY);

    mInterfaceEClass = createEClass(MINTERFACE);

    mClassifierEClass = createEClass(MCLASSIFIER);
    createEAttribute(mClassifierEClass, MCLASSIFIER__VISIBILITY);
    createEAttribute(mClassifierEClass, MCLASSIFIER__ABSTRACT);
    createEAttribute(mClassifierEClass, MCLASSIFIER__FINAL);
    createEReference(mClassifierEClass, MCLASSIFIER__OPERATION);
    createEReference(mClassifierEClass, MCLASSIFIER__PROPERTY);
    createEReference(mClassifierEClass, MCLASSIFIER__GENERIC_PARAMETER);
    createEReference(mClassifierEClass, MCLASSIFIER__REALIZATION);
    createEReference(mClassifierEClass, MCLASSIFIER__GENERALIZATION);
    createEReference(mClassifierEClass, MCLASSIFIER__SUPPLIER);
    createEReference(mClassifierEClass, MCLASSIFIER__OWNING_CONTEXT);

    mOperationEClass = createEClass(MOPERATION);
    createEAttribute(mOperationEClass, MOPERATION__VISIBILITY);
    createEAttribute(mOperationEClass, MOPERATION__STATIC);
    createEAttribute(mOperationEClass, MOPERATION__ABSTRACT);
    createEAttribute(mOperationEClass, MOPERATION__FINAL);
    createEReference(mOperationEClass, MOPERATION__PARAMETER);
    createEReference(mOperationEClass, MOPERATION__CLASSIFIER);
    createEReference(mOperationEClass, MOPERATION__GENERIC_PARAMETER);
    createEReference(mOperationEClass, MOPERATION__RAISED_EXCEPTION);
    createEReference(mOperationEClass, MOPERATION__RETURN);

    mParameterEClass = createEClass(MPARAMETER);
    createEAttribute(mParameterEClass, MPARAMETER__DEFAULTVALUE);
    createEAttribute(mParameterEClass, MPARAMETER__DIRECTION);
    createEReference(mParameterEClass, MPARAMETER__GENERIC_REALIZATION);
    createEReference(mParameterEClass, MPARAMETER__TYPE);
    createEReference(mParameterEClass, MPARAMETER__EVENT);
    createEReference(mParameterEClass, MPARAMETER__OPERATION);
    createEReference(mParameterEClass, MPARAMETER__MULTIPLICITY);

    mDataTypeEClass = createEClass(MDATA_TYPE);

    mEnumerationEClass = createEClass(MENUMERATION);
    createEReference(mEnumerationEClass, MENUMERATION__LITERAL);

    mStereotypeEClass = createEClass(MSTEREOTYPE);
    createEReference(mStereotypeEClass, MSTEREOTYPE__PROPERTY);
    createEReference(mStereotypeEClass, MSTEREOTYPE__MODEL);
    createEReference(mStereotypeEClass, MSTEREOTYPE__GENERALIZATION);

    mTagEClass = createEClass(MTAG);
    createEAttribute(mTagEClass, MTAG__NAME);
    createEAttribute(mTagEClass, MTAG__TYPE);
    createEReference(mTagEClass, MTAG__STEREOTYPE);

    mCommentEClass = createEClass(MCOMMENT);
    createEAttribute(mCommentEClass, MCOMMENT__XMI_GUID);
    createEAttribute(mCommentEClass, MCOMMENT__ANNOTATION);
    createEReference(mCommentEClass, MCOMMENT__OWNING_ELEMENT);
    createEReference(mCommentEClass, MCOMMENT__NESTING_COMMENT);
    createEReference(mCommentEClass, MCOMMENT__NESTED_COMMENT);

    mTaggedValueEClass = createEClass(MTAGGED_VALUE);
    createEAttribute(mTaggedValueEClass, MTAGGED_VALUE__VALUE);
    createEReference(mTaggedValueEClass, MTAGGED_VALUE__OWNING_ELEMENT);
    createEReference(mTaggedValueEClass, MTAGGED_VALUE__TAG);
    createEReference(mTaggedValueEClass, MTAGGED_VALUE__VALUE_REFERENCE);

    mAspectEClass = createEClass(MASPECT);
    createEAttribute(mAspectEClass, MASPECT__DOMAIN);
    createEAttribute(mAspectEClass, MASPECT__NAME);
    createEReference(mAspectEClass, MASPECT__ELEMENT);
    createEReference(mAspectEClass, MASPECT__INTRODUCTION);
    createEReference(mAspectEClass, MASPECT__POINTCUT);

    mIntroductionEClass = createEClass(MINTRODUCTION);
    createEAttribute(mIntroductionEClass, MINTRODUCTION__DOMAIN);
    createEAttribute(mIntroductionEClass, MINTRODUCTION__NAME);
    createEReference(mIntroductionEClass, MINTRODUCTION__ORIGIN);

    mPointcutEClass = createEClass(MPOINTCUT);
    createEAttribute(mPointcutEClass, MPOINTCUT__DOMAIN);
    createEAttribute(mPointcutEClass, MPOINTCUT__NAME);
    createEAttribute(mPointcutEClass, MPOINTCUT__DESTINATION);
    createEReference(mPointcutEClass, MPOINTCUT__ORIGIN);

    mLiteralEClass = createEClass(MLITERAL);
    createEReference(mLiteralEClass, MLITERAL__OWNING_ENUMERATION);

    mGenericEClass = createEClass(MGENERIC);
    createEAttribute(mGenericEClass, MGENERIC__SPECIFICATION);
    createEReference(mGenericEClass, MGENERIC__OWNING_CLASSIFIER);
    createEReference(mGenericEClass, MGENERIC__OWNING_OPERATION);
    createEReference(mGenericEClass, MGENERIC__OWNING_PROPERTY);
    createEReference(mGenericEClass, MGENERIC__OWNING_PARAMETER);
    createEReference(mGenericEClass, MGENERIC__OWNING_EXTERNAL);
    createEReference(mGenericEClass, MGENERIC__DEFAULT);
    createEReference(mGenericEClass, MGENERIC__CONSTRAINT);

    mTypeEClass = createEClass(MTYPE);
    createEReference(mTypeEClass, MTYPE__SPECIALIZATION);

    mExternalEClass = createEClass(MEXTERNAL);
    createEReference(mExternalEClass, MEXTERNAL__MODEL);
    createEReference(mExternalEClass, MEXTERNAL__GENERIC_PARAMETER);

    mActivityEClass = createEClass(MACTIVITY);
    createEReference(mActivityEClass, MACTIVITY__EDGE);
    createEReference(mActivityEClass, MACTIVITY__NODE);

    mActionEClass = createEClass(MACTION);
    createEReference(mActionEClass, MACTION__BEHAVIOR);
    createEReference(mActionEClass, MACTION__OUT);
    createEReference(mActionEClass, MACTION__IN);
    createEReference(mActionEClass, MACTION__OPERATION);

    mBehaviorEClass = createEClass(MBEHAVIOR);
    createEReference(mBehaviorEClass, MBEHAVIOR__OWNING_CONTEXT);
    createEReference(mBehaviorEClass, MBEHAVIOR__TRANSITION);
    createEReference(mBehaviorEClass, MBEHAVIOR__ENTRY);
    createEReference(mBehaviorEClass, MBEHAVIOR__EXIT);
    createEReference(mBehaviorEClass, MBEHAVIOR__DO);

    mStateMachineEClass = createEClass(MSTATE_MACHINE);
    createEReference(mStateMachineEClass, MSTATE_MACHINE__SMSTATE);
    createEReference(mStateMachineEClass, MSTATE_MACHINE__SMTRANSITION);
    createEReference(mStateMachineEClass, MSTATE_MACHINE__ATOMIC_TRANSITION);

    mFlowEClass = createEClass(MFLOW);
    createEReference(mFlowEClass, MFLOW__SOURCE);
    createEReference(mFlowEClass, MFLOW__TARGET);
    createEReference(mFlowEClass, MFLOW__GUARD);
    createEReference(mFlowEClass, MFLOW__TRANSPORT);

    mNodeEClass = createEClass(MNODE);
    createEReference(mNodeEClass, MNODE__TO);
    createEReference(mNodeEClass, MNODE__FROM);

    mGuardEClass = createEClass(MGUARD);
    createEReference(mGuardEClass, MGUARD__TRANSITION);
    createEReference(mGuardEClass, MGUARD__OWNING_CONTEXT);

    mUseCaseEClass = createEClass(MUSE_CASE);

    mInitialEClass = createEClass(MINITIAL);

    mFinalEClass = createEClass(MFINAL);

    mStateEClass = createEClass(MSTATE);
    createEReference(mStateEClass, MSTATE__OWNER);
    createEReference(mStateEClass, MSTATE__OUTGOING);
    createEReference(mStateEClass, MSTATE__INCOMING);
    createEReference(mStateEClass, MSTATE__ENTRY);
    createEReference(mStateEClass, MSTATE__EXIT);
    createEReference(mStateEClass, MSTATE__DO);
    createEReference(mStateEClass, MSTATE__SUPERSTATE);

    mTransitionEClass = createEClass(MTRANSITION);
    createEAttribute(mTransitionEClass, MTRANSITION__KIND);
    createEReference(mTransitionEClass, MTRANSITION__SOURCE);
    createEReference(mTransitionEClass, MTRANSITION__TARGET);
    createEReference(mTransitionEClass, MTRANSITION__GUARD);
    createEReference(mTransitionEClass, MTRANSITION__STATEMACHINE);
    createEReference(mTransitionEClass, MTRANSITION__TRIGGER);
    createEReference(mTransitionEClass, MTRANSITION__ACTION);

    mDefinitionContextEClass = createEClass(MDEFINITION_CONTEXT);
    createEReference(mDefinitionContextEClass, MDEFINITION_CONTEXT__CLASSIFIER);
    createEReference(mDefinitionContextEClass, MDEFINITION_CONTEXT__OWNED_BEHAVIOR);
    createEReference(mDefinitionContextEClass, MDEFINITION_CONTEXT__GUARD);
    createEReference(mDefinitionContextEClass, MDEFINITION_CONTEXT__EVENT);

    mEventEClass = createEClass(MEVENT);
    createEAttribute(mEventEClass, MEVENT__IS_CALL);
    createEAttribute(mEventEClass, MEVENT__IS_CHANGE);
    createEReference(mEventEClass, MEVENT__OWNING_CONTEXT);
    createEReference(mEventEClass, MEVENT__PARAMETER);

    mAtomicTransitionEClass = createEClass(MATOMIC_TRANSITION);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__DEFINING_TRANSITION);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__END_DO);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__EXIT);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__ACTION);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__ENTRY);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__START_DO);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__HISTORY_CONTEXT);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__STATEMACHINE);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__START_TIMER);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__STOP_TIMER);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__SOURCE);
    createEReference(mAtomicTransitionEClass, MATOMIC_TRANSITION__TARGET);

    mLeafStateEClass = createEClass(MLEAF_STATE);

    mCompositeStateEClass = createEClass(MCOMPOSITE_STATE);
    createEReference(mCompositeStateEClass, MCOMPOSITE_STATE__SUBSTATE);

    mInitialStateEClass = createEClass(MINITIAL_STATE);

    mFinalStateEClass = createEClass(MFINAL_STATE);

    mHistoryStateEClass = createEClass(MHISTORY_STATE);
    createEAttribute(mHistoryStateEClass, MHISTORY_STATE__DEEP);
    createEReference(mHistoryStateEClass, MHISTORY_STATE__REACHABLE_HISTORY);
    createEReference(mHistoryStateEClass, MHISTORY_STATE__DEFAULT_HISTORY);

    mTimeEventEClass = createEClass(MTIME_EVENT);
    createEAttribute(mTimeEventEClass, MTIME_EVENT__IS_RELATIVE);
    createEAttribute(mTimeEventEClass, MTIME_EVENT__WHEN);

    mMultiplicityEClass = createEClass(MMULTIPLICITY);
    createEAttribute(mMultiplicityEClass, MMULTIPLICITY__UNIQUE);
    createEAttribute(mMultiplicityEClass, MMULTIPLICITY__ORDERED);
    createEAttribute(mMultiplicityEClass, MMULTIPLICITY__LOWER_BOUND);
    createEAttribute(mMultiplicityEClass, MMULTIPLICITY__UPPER_BOUND);

    mDependencyEClass = createEClass(MDEPENDENCY);
    createEReference(mDependencyEClass, MDEPENDENCY__OWNING_PACKAGE);
    createEReference(mDependencyEClass, MDEPENDENCY__SUPPLIER);
    createEReference(mDependencyEClass, MDEPENDENCY__CLIENT);

    // Create enums
    mDestinationKindEEnum = createEEnum(MDESTINATION_KIND);
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
    mPackageEClass.getESuperTypes().add(this.getMDefinitionContext());
    mClassEClass.getESuperTypes().add(this.getMClassifier());
    mAssociationRoleEClass.getESuperTypes().add(this.getMProperty());
    mAssociationEClass.getESuperTypes().add(this.getMElement());
    mAttributeEClass.getESuperTypes().add(this.getMProperty());
    mModelEClass.getESuperTypes().add(this.getMPackage());
    mPropertyEClass.getESuperTypes().add(this.getMElement());
    mInterfaceEClass.getESuperTypes().add(this.getMClassifier());
    mClassifierEClass.getESuperTypes().add(this.getMElement());
    mClassifierEClass.getESuperTypes().add(this.getMType());
    mClassifierEClass.getESuperTypes().add(this.getMDefinitionContext());
    mOperationEClass.getESuperTypes().add(this.getMElement());
    mParameterEClass.getESuperTypes().add(this.getMElement());
    mDataTypeEClass.getESuperTypes().add(this.getMClassifier());
    mEnumerationEClass.getESuperTypes().add(this.getMDataType());
    mStereotypeEClass.getESuperTypes().add(this.getMElement());
    mLiteralEClass.getESuperTypes().add(this.getMElement());
    mGenericEClass.getESuperTypes().add(this.getMType());
    mExternalEClass.getESuperTypes().add(this.getMType());
    mExternalEClass.getESuperTypes().add(this.getMElement());
    mActivityEClass.getESuperTypes().add(this.getMBehavior());
    mActionEClass.getESuperTypes().add(this.getMNode());
    mBehaviorEClass.getESuperTypes().add(this.getMElement());
    mBehaviorEClass.getESuperTypes().add(this.getMDefinitionContext());
    mStateMachineEClass.getESuperTypes().add(this.getMBehavior());
    mFlowEClass.getESuperTypes().add(this.getMElement());
    mNodeEClass.getESuperTypes().add(this.getMElement());
    mGuardEClass.getESuperTypes().add(this.getMElement());
    mUseCaseEClass.getESuperTypes().add(this.getMClassifier());
    mInitialEClass.getESuperTypes().add(this.getMNode());
    mFinalEClass.getESuperTypes().add(this.getMNode());
    mStateEClass.getESuperTypes().add(this.getMElement());
    mTransitionEClass.getESuperTypes().add(this.getMElement());
    mDefinitionContextEClass.getESuperTypes().add(this.getMElement());
    mEventEClass.getESuperTypes().add(this.getMElement());
    mAtomicTransitionEClass.getESuperTypes().add(this.getMElement());
    mLeafStateEClass.getESuperTypes().add(this.getMState());
    mCompositeStateEClass.getESuperTypes().add(this.getMState());
    mInitialStateEClass.getESuperTypes().add(this.getMLeafState());
    mFinalStateEClass.getESuperTypes().add(this.getMLeafState());
    mHistoryStateEClass.getESuperTypes().add(this.getMLeafState());
    mTimeEventEClass.getESuperTypes().add(this.getMEvent());
    mDependencyEClass.getESuperTypes().add(this.getMElement());

    // Initialize classes and features; add operations and parameters
    initEClass(mPackageEClass, MPackage.class, "MPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMPackage_NestedPackage(), this.getMPackage(), this.getMPackage_NestingPackage(), "nestedPackage", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_NestingPackage(), this.getMPackage(), this.getMPackage_NestedPackage(), "nestingPackage", null, 0, 1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_Association(), this.getMAssociation(), this.getMAssociation_OwningPackage(), "association", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_OwnedDependency(), this.getMDependency(), this.getMDependency_OwningPackage(), "ownedDependency", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mClassEClass, MClass.class, "MClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMClass_OwnedAssociation(), this.getMAssociation(), this.getMAssociation_AssociationClass(), "ownedAssociation", null, 0, 1, MClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAssociationRoleEClass, MAssociationRole.class, "MAssociationRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAssociationRole_Aggregation(), ecorePackage.getEBoolean(), "aggregation", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAssociationRole_Composition(), ecorePackage.getEBoolean(), "composition", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_Association(), this.getMAssociation(), this.getMAssociation_End(), "association", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_Opposite(), this.getMAssociationRole(), null, "opposite", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_Qualifier(), this.getMType(), null, "qualifier", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_OppositeMultiplicity(), this.getMMultiplicity(), null, "oppositeMultiplicity", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_QualifierMultiplicity(), this.getMMultiplicity(), null, "qualifierMultiplicity", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAssociationEClass, MAssociation.class, "MAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAssociation_Derived(), ecorePackage.getEBoolean(), "derived", null, 1, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_End(), this.getMAssociationRole(), this.getMAssociationRole_Association(), "end", null, 1, -1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_OwningPackage(), this.getMPackage(), this.getMPackage_Association(), "owningPackage", null, 1, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_AssociationClass(), this.getMClass(), this.getMClass_OwnedAssociation(), "associationClass", null, 0, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAttributeEClass, MAttribute.class, "MAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAttribute_Defaultvalue(), ecorePackage.getEString(), "defaultvalue", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAttribute_Static(), ecorePackage.getEBoolean(), "static", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAttribute_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mModelEClass, MModel.class, "MModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMModel_AnyStereotype(), this.getMStereotype(), this.getMStereotype_Model(), "anyStereotype", null, 0, -1, MModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMModel_ExternalTypes(), this.getMExternal(), this.getMExternal_Model(), "externalTypes", null, 0, -1, MModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mElementEClass, MElement.class, "MElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMElement_XmiGuid(), ecorePackage.getEString(), "xmiGuid", null, 1, 1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_OwnedComment(), this.getMComment(), this.getMComment_OwningElement(), "ownedComment", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_TaggedValue(), this.getMTaggedValue(), this.getMTaggedValue_OwningElement(), "taggedValue", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_Stereotype(), this.getMStereotype(), null, "stereotype", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_Aspect(), this.getMAspect(), this.getMAspect_Element(), "aspect", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_Dependency(), this.getMDependency(), this.getMDependency_Client(), "dependency", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mPropertyEClass, MProperty.class, "MProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMProperty_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMProperty_Derived(), ecorePackage.getEBoolean(), "derived", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_Classifier(), this.getMClassifier(), this.getMClassifier_Property(), "classifier", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_GenericRealization(), this.getMGeneric(), this.getMGeneric_OwningProperty(), "genericRealization", null, 0, -1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_Type(), this.getMType(), null, "type", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_Multiplicity(), this.getMMultiplicity(), null, "multiplicity", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mInterfaceEClass, MInterface.class, "MInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mClassifierEClass, MClassifier.class, "MClassifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMClassifier_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMClassifier_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMClassifier_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Operation(), this.getMOperation(), this.getMOperation_Classifier(), "operation", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Property(), this.getMProperty(), this.getMProperty_Classifier(), "property", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningClassifier(), "genericParameter", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Realization(), this.getMType(), null, "realization", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Generalization(), this.getMType(), this.getMType_Specialization(), "generalization", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Supplier(), this.getMType(), null, "supplier", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_OwningContext(), this.getMDefinitionContext(), this.getMDefinitionContext_Classifier(), "owningContext", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mOperationEClass, MOperation.class, "MOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMOperation_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Static(), ecorePackage.getEBoolean(), "static", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_Parameter(), this.getMParameter(), null, "parameter", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_Classifier(), this.getMClassifier(), this.getMClassifier_Operation(), "classifier", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningOperation(), "genericParameter", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_RaisedException(), this.getMType(), null, "raisedException", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_Return(), this.getMParameter(), null, "return", null, 0, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mParameterEClass, MParameter.class, "MParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMParameter_Defaultvalue(), ecorePackage.getEString(), "defaultvalue", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMParameter_Direction(), ecorePackage.getEString(), "direction", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_GenericRealization(), this.getMGeneric(), this.getMGeneric_OwningParameter(), "genericRealization", null, 0, -1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Type(), this.getMType(), null, "type", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Event(), this.getMEvent(), this.getMEvent_Parameter(), "event", null, 0, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Operation(), this.getMOperation(), null, "operation", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Multiplicity(), this.getMMultiplicity(), null, "multiplicity", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mDataTypeEClass, MDataType.class, "MDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mEnumerationEClass, MEnumeration.class, "MEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMEnumeration_Literal(), this.getMLiteral(), this.getMLiteral_OwningEnumeration(), "literal", null, 0, -1, MEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mStereotypeEClass, MStereotype.class, "MStereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMStereotype_Property(), this.getMTag(), this.getMTag_Stereotype(), "property", null, 0, -1, MStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMStereotype_Model(), this.getMModel(), this.getMModel_AnyStereotype(), "model", null, 1, 1, MStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMStereotype_Generalization(), this.getMStereotype(), null, "generalization", null, 0, -1, MStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTagEClass, MTag.class, "MTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTag_Name(), ecorePackage.getEString(), "name", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMTag_Type(), ecorePackage.getEString(), "type", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTag_Stereotype(), this.getMStereotype(), this.getMStereotype_Property(), "stereotype", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mCommentEClass, MComment.class, "MComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMComment_XmiGuid(), ecorePackage.getEString(), "xmiGuid", null, 1, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMComment_Annotation(), ecorePackage.getEString(), "annotation", null, 1, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_OwningElement(), this.getMElement(), this.getMElement_OwnedComment(), "owningElement", null, 0, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_NestingComment(), this.getMComment(), this.getMComment_NestedComment(), "nestingComment", null, 0, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_NestedComment(), this.getMComment(), this.getMComment_NestingComment(), "nestedComment", null, 0, -1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTaggedValueEClass, MTaggedValue.class, "MTaggedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTaggedValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTaggedValue_OwningElement(), this.getMElement(), this.getMElement_TaggedValue(), "owningElement", null, 1, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTaggedValue_Tag(), this.getMTag(), null, "tag", null, 1, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTaggedValue_ValueReference(), this.getMElement(), null, "valueReference", null, 0, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAspectEClass, MAspect.class, "MAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAspect_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAspect_Name(), ecorePackage.getEString(), "name", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Element(), this.getMElement(), this.getMElement_Aspect(), "element", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Introduction(), this.getMIntroduction(), this.getMIntroduction_Origin(), "introduction", null, 0, -1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Pointcut(), this.getMPointcut(), this.getMPointcut_Origin(), "pointcut", null, 0, -1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mIntroductionEClass, MIntroduction.class, "MIntroduction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMIntroduction_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMIntroduction_Name(), ecorePackage.getEString(), "name", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMIntroduction_Origin(), this.getMAspect(), this.getMAspect_Introduction(), "origin", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mPointcutEClass, MPointcut.class, "MPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMPointcut_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMPointcut_Name(), ecorePackage.getEString(), "name", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMPointcut_Destination(), this.getMDestinationKind(), "destination", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPointcut_Origin(), this.getMAspect(), this.getMAspect_Pointcut(), "origin", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mLiteralEClass, MLiteral.class, "MLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMLiteral_OwningEnumeration(), this.getMEnumeration(), this.getMEnumeration_Literal(), "owningEnumeration", null, 1, 1, MLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mGenericEClass, MGeneric.class, "MGeneric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMGeneric_Specification(), ecorePackage.getEString(), "specification", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningClassifier(), this.getMClassifier(), this.getMClassifier_GenericParameter(), "owningClassifier", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningOperation(), this.getMOperation(), this.getMOperation_GenericParameter(), "owningOperation", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningProperty(), this.getMProperty(), this.getMProperty_GenericRealization(), "owningProperty", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningParameter(), this.getMParameter(), this.getMParameter_GenericRealization(), "owningParameter", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningExternal(), this.getMExternal(), this.getMExternal_GenericParameter(), "owningExternal", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_Default(), this.getMType(), null, "default", null, 0, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_Constraint(), this.getMType(), null, "constraint", null, 0, -1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTypeEClass, MType.class, "MType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMType_Specialization(), this.getMClassifier(), this.getMClassifier_Generalization(), "specialization", null, 0, -1, MType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mExternalEClass, MExternal.class, "MExternal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMExternal_Model(), this.getMModel(), this.getMModel_ExternalTypes(), "model", null, 1, 1, MExternal.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMExternal_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningExternal(), "genericParameter", null, 0, -1, MExternal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mActivityEClass, MActivity.class, "MActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMActivity_Edge(), this.getMFlow(), null, "edge", null, 0, -1, MActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMActivity_Node(), this.getMNode(), null, "node", null, 0, -1, MActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mActionEClass, MAction.class, "MAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMAction_Behavior(), this.getMBehavior(), null, "behavior", null, 0, 1, MAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAction_Out(), this.getMClassifier(), null, "out", null, 0, -1, MAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAction_In(), this.getMClassifier(), null, "in", null, 0, -1, MAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAction_Operation(), this.getMOperation(), null, "operation", null, 0, 1, MAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mBehaviorEClass, MBehavior.class, "MBehavior", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMBehavior_OwningContext(), this.getMDefinitionContext(), this.getMDefinitionContext_OwnedBehavior(), "owningContext", null, 1, 1, MBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMBehavior_Transition(), this.getMTransition(), this.getMTransition_Action(), "transition", null, 0, -1, MBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMBehavior_Entry(), this.getMState(), this.getMState_Entry(), "entry", null, 0, -1, MBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMBehavior_Exit(), this.getMState(), this.getMState_Exit(), "exit", null, 0, -1, MBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMBehavior_Do(), this.getMState(), this.getMState_Do(), "do", null, 0, -1, MBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mStateMachineEClass, MStateMachine.class, "MStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMStateMachine_Smstate(), this.getMState(), this.getMState_Owner(), "smstate", null, 0, -1, MStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMStateMachine_Smtransition(), this.getMTransition(), this.getMTransition_Statemachine(), "smtransition", null, 0, -1, MStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMStateMachine_AtomicTransition(), this.getMAtomicTransition(), this.getMAtomicTransition_Statemachine(), "atomicTransition", null, 0, -1, MStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mFlowEClass, MFlow.class, "MFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMFlow_Source(), this.getMNode(), this.getMNode_To(), "source", null, 1, 1, MFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMFlow_Target(), this.getMNode(), this.getMNode_From(), "target", null, 1, 1, MFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMFlow_Guard(), this.getMGuard(), null, "guard", null, 0, 1, MFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMFlow_Transport(), this.getMClassifier(), null, "transport", null, 0, 1, MFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mNodeEClass, MNode.class, "MNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMNode_To(), this.getMFlow(), this.getMFlow_Source(), "to", null, 0, -1, MNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMNode_From(), this.getMFlow(), this.getMFlow_Target(), "from", null, 0, -1, MNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mGuardEClass, MGuard.class, "MGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMGuard_Transition(), this.getMTransition(), this.getMTransition_Guard(), "transition", null, 1, -1, MGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGuard_OwningContext(), this.getMDefinitionContext(), this.getMDefinitionContext_Guard(), "owningContext", null, 1, 1, MGuard.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mUseCaseEClass, MUseCase.class, "MUseCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mInitialEClass, MInitial.class, "MInitial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mFinalEClass, MFinal.class, "MFinal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mStateEClass, MState.class, "MState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMState_Owner(), this.getMStateMachine(), this.getMStateMachine_Smstate(), "owner", null, 1, 1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Outgoing(), this.getMTransition(), this.getMTransition_Source(), "outgoing", null, 0, -1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Incoming(), this.getMTransition(), this.getMTransition_Target(), "incoming", null, 0, -1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Entry(), this.getMBehavior(), this.getMBehavior_Entry(), "entry", null, 0, 1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Exit(), this.getMBehavior(), this.getMBehavior_Exit(), "exit", null, 0, 1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Do(), this.getMBehavior(), this.getMBehavior_Do(), "do", null, 0, 1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMState_Superstate(), this.getMCompositeState(), this.getMCompositeState_Substate(), "superstate", null, 0, 1, MState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTransitionEClass, MTransition.class, "MTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTransition_Kind(), ecorePackage.getEString(), "kind", null, 1, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Source(), this.getMState(), this.getMState_Outgoing(), "source", null, 1, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Target(), this.getMState(), this.getMState_Incoming(), "target", null, 1, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Guard(), this.getMGuard(), this.getMGuard_Transition(), "guard", null, 0, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Statemachine(), this.getMStateMachine(), this.getMStateMachine_Smtransition(), "statemachine", null, 1, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Trigger(), this.getMEvent(), null, "trigger", null, 0, -1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTransition_Action(), this.getMBehavior(), this.getMBehavior_Transition(), "action", null, 0, 1, MTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mDefinitionContextEClass, MDefinitionContext.class, "MDefinitionContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMDefinitionContext_Classifier(), this.getMClassifier(), this.getMClassifier_OwningContext(), "classifier", null, 0, -1, MDefinitionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMDefinitionContext_OwnedBehavior(), this.getMBehavior(), this.getMBehavior_OwningContext(), "ownedBehavior", null, 0, -1, MDefinitionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMDefinitionContext_Guard(), this.getMGuard(), this.getMGuard_OwningContext(), "guard", null, 0, -1, MDefinitionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMDefinitionContext_Event(), this.getMEvent(), this.getMEvent_OwningContext(), "event", null, 0, -1, MDefinitionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mEventEClass, MEvent.class, "MEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMEvent_IsCall(), ecorePackage.getEBoolean(), "isCall", null, 1, 1, MEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMEvent_IsChange(), ecorePackage.getEBoolean(), "isChange", null, 1, 1, MEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMEvent_OwningContext(), this.getMDefinitionContext(), this.getMDefinitionContext_Event(), "owningContext", null, 1, 1, MEvent.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMEvent_Parameter(), this.getMParameter(), this.getMParameter_Event(), "parameter", null, 0, -1, MEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAtomicTransitionEClass, MAtomicTransition.class, "MAtomicTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMAtomicTransition_DefiningTransition(), this.getMTransition(), null, "definingTransition", null, 1, 1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_EndDo(), this.getMBehavior(), null, "endDo", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Exit(), this.getMBehavior(), null, "exit", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Action(), this.getMBehavior(), null, "action", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Entry(), this.getMBehavior(), null, "entry", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_StartDo(), this.getMBehavior(), null, "startDo", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_HistoryContext(), this.getMHistoryState(), null, "historyContext", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Statemachine(), this.getMStateMachine(), this.getMStateMachine_AtomicTransition(), "statemachine", null, 1, 1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_StartTimer(), this.getMTimeEvent(), null, "startTimer", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_StopTimer(), this.getMTimeEvent(), null, "stopTimer", null, 0, -1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Source(), this.getMLeafState(), null, "source", null, 1, 1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAtomicTransition_Target(), this.getMLeafState(), null, "target", null, 1, 1, MAtomicTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mLeafStateEClass, MLeafState.class, "MLeafState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mCompositeStateEClass, MCompositeState.class, "MCompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMCompositeState_Substate(), this.getMState(), this.getMState_Superstate(), "substate", null, 0, -1, MCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mInitialStateEClass, MInitialState.class, "MInitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mFinalStateEClass, MFinalState.class, "MFinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mHistoryStateEClass, MHistoryState.class, "MHistoryState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMHistoryState_Deep(), ecorePackage.getEBoolean(), "deep", null, 1, 1, MHistoryState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMHistoryState_ReachableHistory(), this.getMLeafState(), null, "reachableHistory", null, 0, -1, MHistoryState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMHistoryState_DefaultHistory(), this.getMLeafState(), null, "defaultHistory", null, 0, 1, MHistoryState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTimeEventEClass, MTimeEvent.class, "MTimeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTimeEvent_IsRelative(), ecorePackage.getEBoolean(), "isRelative", null, 1, 1, MTimeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMTimeEvent_When(), ecorePackage.getEString(), "when", null, 1, 1, MTimeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mMultiplicityEClass, MMultiplicity.class, "MMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMultiplicity_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, MMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMultiplicity_Ordered(), ecorePackage.getEBoolean(), "ordered", null, 1, 1, MMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMultiplicity_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, MMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMultiplicity_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, MMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mDependencyEClass, MDependency.class, "MDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMDependency_OwningPackage(), this.getMPackage(), this.getMPackage_OwnedDependency(), "owningPackage", null, 1, 1, MDependency.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMDependency_Supplier(), this.getMElement(), null, "supplier", null, 0, -1, MDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMDependency_Client(), this.getMElement(), this.getMElement_Dependency(), "client", null, 0, -1, MDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(mDestinationKindEEnum, MDestinationKind.class, "MDestinationKind");
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_ENTRY);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_EXIT);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_EXCEPTION);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.AROUND);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.EXTERNAL);

    // Create resource
    createResource(eNS_URI);
  }

} //GcorePackageImpl
