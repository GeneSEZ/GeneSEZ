/**
 */
package org.genesez.metamodel.gcore.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.genesez.metamodel.gcore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gcore.GcorePackage
 * @generated
 */
public class GcoreSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GcorePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = GcorePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GcorePackage.MPACKAGE:
      {
        MPackage mPackage = (MPackage)theEObject;
        T result = caseMPackage(mPackage);
        if (result == null) result = caseMDefinitionContext(mPackage);
        if (result == null) result = caseMElement(mPackage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCLASS:
      {
        MClass mClass = (MClass)theEObject;
        T result = caseMClass(mClass);
        if (result == null) result = caseMClassifier(mClass);
        if (result == null) result = caseMType(mClass);
        if (result == null) result = caseMDefinitionContext(mClass);
        if (result == null) result = caseMElement(mClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASSOCIATION_ROLE:
      {
        MAssociationRole mAssociationRole = (MAssociationRole)theEObject;
        T result = caseMAssociationRole(mAssociationRole);
        if (result == null) result = caseMProperty(mAssociationRole);
        if (result == null) result = caseMElement(mAssociationRole);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASSOCIATION:
      {
        MAssociation mAssociation = (MAssociation)theEObject;
        T result = caseMAssociation(mAssociation);
        if (result == null) result = caseMElement(mAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MATTRIBUTE:
      {
        MAttribute mAttribute = (MAttribute)theEObject;
        T result = caseMAttribute(mAttribute);
        if (result == null) result = caseMProperty(mAttribute);
        if (result == null) result = caseMElement(mAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MMODEL:
      {
        MModel mModel = (MModel)theEObject;
        T result = caseMModel(mModel);
        if (result == null) result = caseMPackage(mModel);
        if (result == null) result = caseMDefinitionContext(mModel);
        if (result == null) result = caseMElement(mModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MELEMENT:
      {
        MElement mElement = (MElement)theEObject;
        T result = caseMElement(mElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPROPERTY:
      {
        MProperty mProperty = (MProperty)theEObject;
        T result = caseMProperty(mProperty);
        if (result == null) result = caseMElement(mProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINTERFACE:
      {
        MInterface mInterface = (MInterface)theEObject;
        T result = caseMInterface(mInterface);
        if (result == null) result = caseMClassifier(mInterface);
        if (result == null) result = caseMType(mInterface);
        if (result == null) result = caseMDefinitionContext(mInterface);
        if (result == null) result = caseMElement(mInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCLASSIFIER:
      {
        MClassifier mClassifier = (MClassifier)theEObject;
        T result = caseMClassifier(mClassifier);
        if (result == null) result = caseMType(mClassifier);
        if (result == null) result = caseMDefinitionContext(mClassifier);
        if (result == null) result = caseMElement(mClassifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MOPERATION:
      {
        MOperation mOperation = (MOperation)theEObject;
        T result = caseMOperation(mOperation);
        if (result == null) result = caseMElement(mOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPARAMETER:
      {
        MParameter mParameter = (MParameter)theEObject;
        T result = caseMParameter(mParameter);
        if (result == null) result = caseMElement(mParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MDATA_TYPE:
      {
        MDataType mDataType = (MDataType)theEObject;
        T result = caseMDataType(mDataType);
        if (result == null) result = caseMClassifier(mDataType);
        if (result == null) result = caseMType(mDataType);
        if (result == null) result = caseMDefinitionContext(mDataType);
        if (result == null) result = caseMElement(mDataType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MENUMERATION:
      {
        MEnumeration mEnumeration = (MEnumeration)theEObject;
        T result = caseMEnumeration(mEnumeration);
        if (result == null) result = caseMDataType(mEnumeration);
        if (result == null) result = caseMClassifier(mEnumeration);
        if (result == null) result = caseMType(mEnumeration);
        if (result == null) result = caseMDefinitionContext(mEnumeration);
        if (result == null) result = caseMElement(mEnumeration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MSTEREOTYPE:
      {
        MStereotype mStereotype = (MStereotype)theEObject;
        T result = caseMStereotype(mStereotype);
        if (result == null) result = caseMElement(mStereotype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTAG:
      {
        MTag mTag = (MTag)theEObject;
        T result = caseMTag(mTag);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCOMMENT:
      {
        MComment mComment = (MComment)theEObject;
        T result = caseMComment(mComment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTAGGED_VALUE:
      {
        MTaggedValue mTaggedValue = (MTaggedValue)theEObject;
        T result = caseMTaggedValue(mTaggedValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASPECT:
      {
        MAspect mAspect = (MAspect)theEObject;
        T result = caseMAspect(mAspect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINTRODUCTION:
      {
        MIntroduction mIntroduction = (MIntroduction)theEObject;
        T result = caseMIntroduction(mIntroduction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPOINTCUT:
      {
        MPointcut mPointcut = (MPointcut)theEObject;
        T result = caseMPointcut(mPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MLITERAL:
      {
        MLiteral mLiteral = (MLiteral)theEObject;
        T result = caseMLiteral(mLiteral);
        if (result == null) result = caseMElement(mLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MGENERIC:
      {
        MGeneric mGeneric = (MGeneric)theEObject;
        T result = caseMGeneric(mGeneric);
        if (result == null) result = caseMType(mGeneric);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTYPE:
      {
        MType mType = (MType)theEObject;
        T result = caseMType(mType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MEXTERNAL:
      {
        MExternal mExternal = (MExternal)theEObject;
        T result = caseMExternal(mExternal);
        if (result == null) result = caseMType(mExternal);
        if (result == null) result = caseMElement(mExternal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MACTIVITY:
      {
        MActivity mActivity = (MActivity)theEObject;
        T result = caseMActivity(mActivity);
        if (result == null) result = caseMBehavior(mActivity);
        if (result == null) result = caseMDefinitionContext(mActivity);
        if (result == null) result = caseMElement(mActivity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MACTION:
      {
        MAction mAction = (MAction)theEObject;
        T result = caseMAction(mAction);
        if (result == null) result = caseMNode(mAction);
        if (result == null) result = caseMElement(mAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MBEHAVIOR:
      {
        MBehavior mBehavior = (MBehavior)theEObject;
        T result = caseMBehavior(mBehavior);
        if (result == null) result = caseMDefinitionContext(mBehavior);
        if (result == null) result = caseMElement(mBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MSTATE_MACHINE:
      {
        MStateMachine mStateMachine = (MStateMachine)theEObject;
        T result = caseMStateMachine(mStateMachine);
        if (result == null) result = caseMBehavior(mStateMachine);
        if (result == null) result = caseMDefinitionContext(mStateMachine);
        if (result == null) result = caseMElement(mStateMachine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MFLOW:
      {
        MFlow mFlow = (MFlow)theEObject;
        T result = caseMFlow(mFlow);
        if (result == null) result = caseMElement(mFlow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MNODE:
      {
        MNode mNode = (MNode)theEObject;
        T result = caseMNode(mNode);
        if (result == null) result = caseMElement(mNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MGUARD:
      {
        MGuard mGuard = (MGuard)theEObject;
        T result = caseMGuard(mGuard);
        if (result == null) result = caseMElement(mGuard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MUSE_CASE:
      {
        MUseCase mUseCase = (MUseCase)theEObject;
        T result = caseMUseCase(mUseCase);
        if (result == null) result = caseMClassifier(mUseCase);
        if (result == null) result = caseMType(mUseCase);
        if (result == null) result = caseMDefinitionContext(mUseCase);
        if (result == null) result = caseMElement(mUseCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINITIAL:
      {
        MInitial mInitial = (MInitial)theEObject;
        T result = caseMInitial(mInitial);
        if (result == null) result = caseMNode(mInitial);
        if (result == null) result = caseMElement(mInitial);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MFINAL:
      {
        MFinal mFinal = (MFinal)theEObject;
        T result = caseMFinal(mFinal);
        if (result == null) result = caseMNode(mFinal);
        if (result == null) result = caseMElement(mFinal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MSTATE:
      {
        MState mState = (MState)theEObject;
        T result = caseMState(mState);
        if (result == null) result = caseMElement(mState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTRANSITION:
      {
        MTransition mTransition = (MTransition)theEObject;
        T result = caseMTransition(mTransition);
        if (result == null) result = caseMElement(mTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MDEFINITION_CONTEXT:
      {
        MDefinitionContext mDefinitionContext = (MDefinitionContext)theEObject;
        T result = caseMDefinitionContext(mDefinitionContext);
        if (result == null) result = caseMElement(mDefinitionContext);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MEVENT:
      {
        MEvent mEvent = (MEvent)theEObject;
        T result = caseMEvent(mEvent);
        if (result == null) result = caseMElement(mEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MATOMIC_TRANSITION:
      {
        MAtomicTransition mAtomicTransition = (MAtomicTransition)theEObject;
        T result = caseMAtomicTransition(mAtomicTransition);
        if (result == null) result = caseMElement(mAtomicTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MLEAF_STATE:
      {
        MLeafState mLeafState = (MLeafState)theEObject;
        T result = caseMLeafState(mLeafState);
        if (result == null) result = caseMState(mLeafState);
        if (result == null) result = caseMElement(mLeafState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCOMPOSITE_STATE:
      {
        MCompositeState mCompositeState = (MCompositeState)theEObject;
        T result = caseMCompositeState(mCompositeState);
        if (result == null) result = caseMState(mCompositeState);
        if (result == null) result = caseMElement(mCompositeState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINITIAL_STATE:
      {
        MInitialState mInitialState = (MInitialState)theEObject;
        T result = caseMInitialState(mInitialState);
        if (result == null) result = caseMLeafState(mInitialState);
        if (result == null) result = caseMState(mInitialState);
        if (result == null) result = caseMElement(mInitialState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MFINAL_STATE:
      {
        MFinalState mFinalState = (MFinalState)theEObject;
        T result = caseMFinalState(mFinalState);
        if (result == null) result = caseMLeafState(mFinalState);
        if (result == null) result = caseMState(mFinalState);
        if (result == null) result = caseMElement(mFinalState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MHISTORY_STATE:
      {
        MHistoryState mHistoryState = (MHistoryState)theEObject;
        T result = caseMHistoryState(mHistoryState);
        if (result == null) result = caseMLeafState(mHistoryState);
        if (result == null) result = caseMState(mHistoryState);
        if (result == null) result = caseMElement(mHistoryState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTIME_EVENT:
      {
        MTimeEvent mTimeEvent = (MTimeEvent)theEObject;
        T result = caseMTimeEvent(mTimeEvent);
        if (result == null) result = caseMEvent(mTimeEvent);
        if (result == null) result = caseMElement(mTimeEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MMULTIPLICITY:
      {
        MMultiplicity mMultiplicity = (MMultiplicity)theEObject;
        T result = caseMMultiplicity(mMultiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MDEPENDENCY:
      {
        MDependency mDependency = (MDependency)theEObject;
        T result = caseMDependency(mDependency);
        if (result == null) result = caseMElement(mDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MPackage</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MPackage</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMPackage(MPackage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMClass(MClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAssociation Role</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAssociation Role</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAssociationRole(MAssociationRole object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAssociation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAssociation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAssociation(MAssociation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAttribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAttribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAttribute(MAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MModel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MModel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMModel(MModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MElement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MElement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMElement(MElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MProperty</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MProperty</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMProperty(MProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MInterface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MInterface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMInterface(MInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MClassifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MClassifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMClassifier(MClassifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MOperation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MOperation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMOperation(MOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MParameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MParameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMParameter(MParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MData Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MData Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMDataType(MDataType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MEnumeration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MEnumeration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMEnumeration(MEnumeration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MStereotype</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MStereotype</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMStereotype(MStereotype object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MTag</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MTag</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMTag(MTag object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MComment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MComment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMComment(MComment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MTagged Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MTagged Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMTaggedValue(MTaggedValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAspect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAspect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAspect(MAspect object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MIntroduction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MIntroduction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMIntroduction(MIntroduction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MPointcut</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MPointcut</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMPointcut(MPointcut object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MLiteral</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MLiteral</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMLiteral(MLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MGeneric</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MGeneric</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMGeneric(MGeneric object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMType(MType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MExternal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MExternal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMExternal(MExternal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MActivity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MActivity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMActivity(MActivity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAction(MAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MBehavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MBehavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMBehavior(MBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MState Machine</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MState Machine</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMStateMachine(MStateMachine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MFlow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MFlow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMFlow(MFlow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MNode</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MNode</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMNode(MNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MGuard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MGuard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMGuard(MGuard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MUse Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MUse Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMUseCase(MUseCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MInitial</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MInitial</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMInitial(MInitial object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MFinal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MFinal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMFinal(MFinal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MState</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MState</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMState(MState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MTransition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MTransition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMTransition(MTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MDefinition Context</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MDefinition Context</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMDefinitionContext(MDefinitionContext object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MEvent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MEvent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMEvent(MEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MAtomic Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MAtomic Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMAtomicTransition(MAtomicTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MLeaf State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MLeaf State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMLeafState(MLeafState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MComposite State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MComposite State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMCompositeState(MCompositeState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MInitial State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MInitial State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMInitialState(MInitialState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MFinal State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MFinal State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMFinalState(MFinalState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MHistory State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MHistory State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMHistoryState(MHistoryState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MTime Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MTime Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMTimeEvent(MTimeEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MMultiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MMultiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMultiplicity(MMultiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MDependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MDependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMDependency(MDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //GcoreSwitch
