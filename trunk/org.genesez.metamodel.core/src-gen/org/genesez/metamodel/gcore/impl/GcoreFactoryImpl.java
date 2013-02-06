/**
 */
package org.genesez.metamodel.gcore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genesez.metamodel.gcore.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GcoreFactoryImpl extends EFactoryImpl implements GcoreFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GcoreFactory init()
  {
    try
    {
      GcoreFactory theGcoreFactory = (GcoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://genesez.org/metamodel/core"); 
      if (theGcoreFactory != null)
      {
        return theGcoreFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GcoreFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case GcorePackage.MPACKAGE: return createMPackage();
      case GcorePackage.MCLASS: return createMClass();
      case GcorePackage.MASSOCIATION_ROLE: return createMAssociationRole();
      case GcorePackage.MASSOCIATION: return createMAssociation();
      case GcorePackage.MATTRIBUTE: return createMAttribute();
      case GcorePackage.MMODEL: return createMModel();
      case GcorePackage.MINTERFACE: return createMInterface();
      case GcorePackage.MOPERATION: return createMOperation();
      case GcorePackage.MPARAMETER: return createMParameter();
      case GcorePackage.MDATA_TYPE: return createMDataType();
      case GcorePackage.MENUMERATION: return createMEnumeration();
      case GcorePackage.MSTEREOTYPE: return createMStereotype();
      case GcorePackage.MTAG: return createMTag();
      case GcorePackage.MCOMMENT: return createMComment();
      case GcorePackage.MTAGGED_VALUE: return createMTaggedValue();
      case GcorePackage.MASPECT: return createMAspect();
      case GcorePackage.MINTRODUCTION: return createMIntroduction();
      case GcorePackage.MPOINTCUT: return createMPointcut();
      case GcorePackage.MLITERAL: return createMLiteral();
      case GcorePackage.MGENERIC: return createMGeneric();
      case GcorePackage.MEXTERNAL: return createMExternal();
      case GcorePackage.MACTIVITY: return createMActivity();
      case GcorePackage.MACTION: return createMAction();
      case GcorePackage.MSTATE_MACHINE: return createMStateMachine();
      case GcorePackage.MFLOW: return createMFlow();
      case GcorePackage.MNODE: return createMNode();
      case GcorePackage.MGUARD: return createMGuard();
      case GcorePackage.MUSE_CASE: return createMUseCase();
      case GcorePackage.MINITIAL: return createMInitial();
      case GcorePackage.MFINAL: return createMFinal();
      case GcorePackage.MSTATE: return createMState();
      case GcorePackage.MTRANSITION: return createMTransition();
      case GcorePackage.MEVENT: return createMEvent();
      case GcorePackage.MATOMIC_TRANSITION: return createMAtomicTransition();
      case GcorePackage.MLEAF_STATE: return createMLeafState();
      case GcorePackage.MCOMPOSITE_STATE: return createMCompositeState();
      case GcorePackage.MINITIAL_STATE: return createMInitialState();
      case GcorePackage.MFINAL_STATE: return createMFinalState();
      case GcorePackage.MHISTORY_STATE: return createMHistoryState();
      case GcorePackage.MTIME_EVENT: return createMTimeEvent();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case GcorePackage.MDESTINATION_KIND:
        return createMDestinationKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case GcorePackage.MDESTINATION_KIND:
        return convertMDestinationKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage createMPackage()
  {
    MPackageImpl mPackage = new MPackageImpl();
    return mPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClass createMClass()
  {
    MClassImpl mClass = new MClassImpl();
    return mClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociationRole createMAssociationRole()
  {
    MAssociationRoleImpl mAssociationRole = new MAssociationRoleImpl();
    return mAssociationRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation createMAssociation()
  {
    MAssociationImpl mAssociation = new MAssociationImpl();
    return mAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAttribute createMAttribute()
  {
    MAttributeImpl mAttribute = new MAttributeImpl();
    return mAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel createMModel()
  {
    MModelImpl mModel = new MModelImpl();
    return mModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MInterface createMInterface()
  {
    MInterfaceImpl mInterface = new MInterfaceImpl();
    return mInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation createMOperation()
  {
    MOperationImpl mOperation = new MOperationImpl();
    return mOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MParameter createMParameter()
  {
    MParameterImpl mParameter = new MParameterImpl();
    return mParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDataType createMDataType()
  {
    MDataTypeImpl mDataType = new MDataTypeImpl();
    return mDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MEnumeration createMEnumeration()
  {
    MEnumerationImpl mEnumeration = new MEnumerationImpl();
    return mEnumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStereotype createMStereotype()
  {
    MStereotypeImpl mStereotype = new MStereotypeImpl();
    return mStereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTag createMTag()
  {
    MTagImpl mTag = new MTagImpl();
    return mTag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MComment createMComment()
  {
    MCommentImpl mComment = new MCommentImpl();
    return mComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTaggedValue createMTaggedValue()
  {
    MTaggedValueImpl mTaggedValue = new MTaggedValueImpl();
    return mTaggedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAspect createMAspect()
  {
    MAspectImpl mAspect = new MAspectImpl();
    return mAspect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MIntroduction createMIntroduction()
  {
    MIntroductionImpl mIntroduction = new MIntroductionImpl();
    return mIntroduction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPointcut createMPointcut()
  {
    MPointcutImpl mPointcut = new MPointcutImpl();
    return mPointcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLiteral createMLiteral()
  {
    MLiteralImpl mLiteral = new MLiteralImpl();
    return mLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MGeneric createMGeneric()
  {
    MGenericImpl mGeneric = new MGenericImpl();
    return mGeneric;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MExternal createMExternal()
  {
    MExternalImpl mExternal = new MExternalImpl();
    return mExternal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MActivity createMActivity()
  {
    MActivityImpl mActivity = new MActivityImpl();
    return mActivity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAction createMAction()
  {
    MActionImpl mAction = new MActionImpl();
    return mAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine createMStateMachine()
  {
    MStateMachineImpl mStateMachine = new MStateMachineImpl();
    return mStateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MFlow createMFlow()
  {
    MFlowImpl mFlow = new MFlowImpl();
    return mFlow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MNode createMNode()
  {
    MNodeImpl mNode = new MNodeImpl();
    return mNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MGuard createMGuard()
  {
    MGuardImpl mGuard = new MGuardImpl();
    return mGuard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MUseCase createMUseCase()
  {
    MUseCaseImpl mUseCase = new MUseCaseImpl();
    return mUseCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MInitial createMInitial()
  {
    MInitialImpl mInitial = new MInitialImpl();
    return mInitial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MFinal createMFinal()
  {
    MFinalImpl mFinal = new MFinalImpl();
    return mFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MState createMState()
  {
    MStateImpl mState = new MStateImpl();
    return mState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTransition createMTransition()
  {
    MTransitionImpl mTransition = new MTransitionImpl();
    return mTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MEvent createMEvent()
  {
    MEventImpl mEvent = new MEventImpl();
    return mEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAtomicTransition createMAtomicTransition()
  {
    MAtomicTransitionImpl mAtomicTransition = new MAtomicTransitionImpl();
    return mAtomicTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLeafState createMLeafState()
  {
    MLeafStateImpl mLeafState = new MLeafStateImpl();
    return mLeafState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MCompositeState createMCompositeState()
  {
    MCompositeStateImpl mCompositeState = new MCompositeStateImpl();
    return mCompositeState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MInitialState createMInitialState()
  {
    MInitialStateImpl mInitialState = new MInitialStateImpl();
    return mInitialState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MFinalState createMFinalState()
  {
    MFinalStateImpl mFinalState = new MFinalStateImpl();
    return mFinalState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MHistoryState createMHistoryState()
  {
    MHistoryStateImpl mHistoryState = new MHistoryStateImpl();
    return mHistoryState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTimeEvent createMTimeEvent()
  {
    MTimeEventImpl mTimeEvent = new MTimeEventImpl();
    return mTimeEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDestinationKind createMDestinationKindFromString(EDataType eDataType, String initialValue)
  {
    MDestinationKind result = MDestinationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMDestinationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcorePackage getGcorePackage()
  {
    return (GcorePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GcorePackage getPackage()
  {
    return GcorePackage.eINSTANCE;
  }

} //GcoreFactoryImpl
