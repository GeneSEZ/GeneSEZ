/**
 */
package org.genesez.metamodel.gcore.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genesez.metamodel.gcore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gcore.GcorePackage
 * @generated
 */
public class GcoreAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GcorePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GcorePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GcoreSwitch<Adapter> modelSwitch =
    new GcoreSwitch<Adapter>()
    {
      @Override
      public Adapter caseMPackage(MPackage object)
      {
        return createMPackageAdapter();
      }
      @Override
      public Adapter caseMClass(MClass object)
      {
        return createMClassAdapter();
      }
      @Override
      public Adapter caseMAssociationRole(MAssociationRole object)
      {
        return createMAssociationRoleAdapter();
      }
      @Override
      public Adapter caseMAssociation(MAssociation object)
      {
        return createMAssociationAdapter();
      }
      @Override
      public Adapter caseMAttribute(MAttribute object)
      {
        return createMAttributeAdapter();
      }
      @Override
      public Adapter caseMModel(MModel object)
      {
        return createMModelAdapter();
      }
      @Override
      public Adapter caseMElement(MElement object)
      {
        return createMElementAdapter();
      }
      @Override
      public Adapter caseMProperty(MProperty object)
      {
        return createMPropertyAdapter();
      }
      @Override
      public Adapter caseMInterface(MInterface object)
      {
        return createMInterfaceAdapter();
      }
      @Override
      public Adapter caseMClassifier(MClassifier object)
      {
        return createMClassifierAdapter();
      }
      @Override
      public Adapter caseMOperation(MOperation object)
      {
        return createMOperationAdapter();
      }
      @Override
      public Adapter caseMParameter(MParameter object)
      {
        return createMParameterAdapter();
      }
      @Override
      public Adapter caseMDataType(MDataType object)
      {
        return createMDataTypeAdapter();
      }
      @Override
      public Adapter caseMEnumeration(MEnumeration object)
      {
        return createMEnumerationAdapter();
      }
      @Override
      public Adapter caseMStereotype(MStereotype object)
      {
        return createMStereotypeAdapter();
      }
      @Override
      public Adapter caseMTag(MTag object)
      {
        return createMTagAdapter();
      }
      @Override
      public Adapter caseMComment(MComment object)
      {
        return createMCommentAdapter();
      }
      @Override
      public Adapter caseMTaggedValue(MTaggedValue object)
      {
        return createMTaggedValueAdapter();
      }
      @Override
      public Adapter caseMAspect(MAspect object)
      {
        return createMAspectAdapter();
      }
      @Override
      public Adapter caseMIntroduction(MIntroduction object)
      {
        return createMIntroductionAdapter();
      }
      @Override
      public Adapter caseMPointcut(MPointcut object)
      {
        return createMPointcutAdapter();
      }
      @Override
      public Adapter caseMLiteral(MLiteral object)
      {
        return createMLiteralAdapter();
      }
      @Override
      public Adapter caseMGeneric(MGeneric object)
      {
        return createMGenericAdapter();
      }
      @Override
      public Adapter caseMType(MType object)
      {
        return createMTypeAdapter();
      }
      @Override
      public Adapter caseMExternal(MExternal object)
      {
        return createMExternalAdapter();
      }
      @Override
      public Adapter caseMActivity(MActivity object)
      {
        return createMActivityAdapter();
      }
      @Override
      public Adapter caseMAction(MAction object)
      {
        return createMActionAdapter();
      }
      @Override
      public Adapter caseMBehavior(MBehavior object)
      {
        return createMBehaviorAdapter();
      }
      @Override
      public Adapter caseMStateMachine(MStateMachine object)
      {
        return createMStateMachineAdapter();
      }
      @Override
      public Adapter caseMFlow(MFlow object)
      {
        return createMFlowAdapter();
      }
      @Override
      public Adapter caseMNode(MNode object)
      {
        return createMNodeAdapter();
      }
      @Override
      public Adapter caseMGuard(MGuard object)
      {
        return createMGuardAdapter();
      }
      @Override
      public Adapter caseMUseCase(MUseCase object)
      {
        return createMUseCaseAdapter();
      }
      @Override
      public Adapter caseMInitial(MInitial object)
      {
        return createMInitialAdapter();
      }
      @Override
      public Adapter caseMFinal(MFinal object)
      {
        return createMFinalAdapter();
      }
      @Override
      public Adapter caseMState(MState object)
      {
        return createMStateAdapter();
      }
      @Override
      public Adapter caseMTransition(MTransition object)
      {
        return createMTransitionAdapter();
      }
      @Override
      public Adapter caseMDefinitionContext(MDefinitionContext object)
      {
        return createMDefinitionContextAdapter();
      }
      @Override
      public Adapter caseMEvent(MEvent object)
      {
        return createMEventAdapter();
      }
      @Override
      public Adapter caseMAtomicTransition(MAtomicTransition object)
      {
        return createMAtomicTransitionAdapter();
      }
      @Override
      public Adapter caseMLeafState(MLeafState object)
      {
        return createMLeafStateAdapter();
      }
      @Override
      public Adapter caseMCompositeState(MCompositeState object)
      {
        return createMCompositeStateAdapter();
      }
      @Override
      public Adapter caseMInitialState(MInitialState object)
      {
        return createMInitialStateAdapter();
      }
      @Override
      public Adapter caseMFinalState(MFinalState object)
      {
        return createMFinalStateAdapter();
      }
      @Override
      public Adapter caseMHistoryState(MHistoryState object)
      {
        return createMHistoryStateAdapter();
      }
      @Override
      public Adapter caseMTimeEvent(MTimeEvent object)
      {
        return createMTimeEventAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MPackage <em>MPackage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MPackage
   * @generated
   */
  public Adapter createMPackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MClass <em>MClass</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MClass
   * @generated
   */
  public Adapter createMClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAssociationRole <em>MAssociation Role</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAssociationRole
   * @generated
   */
  public Adapter createMAssociationRoleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAssociation <em>MAssociation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAssociation
   * @generated
   */
  public Adapter createMAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAttribute <em>MAttribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAttribute
   * @generated
   */
  public Adapter createMAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MModel <em>MModel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MModel
   * @generated
   */
  public Adapter createMModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MElement <em>MElement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MElement
   * @generated
   */
  public Adapter createMElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MProperty <em>MProperty</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MProperty
   * @generated
   */
  public Adapter createMPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MInterface <em>MInterface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MInterface
   * @generated
   */
  public Adapter createMInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MClassifier <em>MClassifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MClassifier
   * @generated
   */
  public Adapter createMClassifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MOperation <em>MOperation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MOperation
   * @generated
   */
  public Adapter createMOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MParameter <em>MParameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MParameter
   * @generated
   */
  public Adapter createMParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MDataType <em>MData Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MDataType
   * @generated
   */
  public Adapter createMDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MEnumeration <em>MEnumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MEnumeration
   * @generated
   */
  public Adapter createMEnumerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MStereotype <em>MStereotype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MStereotype
   * @generated
   */
  public Adapter createMStereotypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MTag <em>MTag</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MTag
   * @generated
   */
  public Adapter createMTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MComment <em>MComment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MComment
   * @generated
   */
  public Adapter createMCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MTaggedValue <em>MTagged Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MTaggedValue
   * @generated
   */
  public Adapter createMTaggedValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAspect <em>MAspect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAspect
   * @generated
   */
  public Adapter createMAspectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MIntroduction <em>MIntroduction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MIntroduction
   * @generated
   */
  public Adapter createMIntroductionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MPointcut <em>MPointcut</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MPointcut
   * @generated
   */
  public Adapter createMPointcutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MLiteral <em>MLiteral</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MLiteral
   * @generated
   */
  public Adapter createMLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MGeneric <em>MGeneric</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MGeneric
   * @generated
   */
  public Adapter createMGenericAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MType <em>MType</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MType
   * @generated
   */
  public Adapter createMTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MExternal <em>MExternal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MExternal
   * @generated
   */
  public Adapter createMExternalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MActivity <em>MActivity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MActivity
   * @generated
   */
  public Adapter createMActivityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAction <em>MAction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAction
   * @generated
   */
  public Adapter createMActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MBehavior <em>MBehavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MBehavior
   * @generated
   */
  public Adapter createMBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MStateMachine <em>MState Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MStateMachine
   * @generated
   */
  public Adapter createMStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MFlow <em>MFlow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MFlow
   * @generated
   */
  public Adapter createMFlowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MNode <em>MNode</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MNode
   * @generated
   */
  public Adapter createMNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MGuard <em>MGuard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MGuard
   * @generated
   */
  public Adapter createMGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MUseCase <em>MUse Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MUseCase
   * @generated
   */
  public Adapter createMUseCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MInitial <em>MInitial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MInitial
   * @generated
   */
  public Adapter createMInitialAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MFinal <em>MFinal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MFinal
   * @generated
   */
  public Adapter createMFinalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MState <em>MState</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MState
   * @generated
   */
  public Adapter createMStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MTransition <em>MTransition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MTransition
   * @generated
   */
  public Adapter createMTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MDefinitionContext <em>MDefinition Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MDefinitionContext
   * @generated
   */
  public Adapter createMDefinitionContextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MEvent <em>MEvent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MEvent
   * @generated
   */
  public Adapter createMEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MAtomicTransition <em>MAtomic Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MAtomicTransition
   * @generated
   */
  public Adapter createMAtomicTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MLeafState <em>MLeaf State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MLeafState
   * @generated
   */
  public Adapter createMLeafStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MCompositeState <em>MComposite State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MCompositeState
   * @generated
   */
  public Adapter createMCompositeStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MInitialState <em>MInitial State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MInitialState
   * @generated
   */
  public Adapter createMInitialStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MFinalState <em>MFinal State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MFinalState
   * @generated
   */
  public Adapter createMFinalStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MHistoryState <em>MHistory State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MHistoryState
   * @generated
   */
  public Adapter createMHistoryStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gcore.MTimeEvent <em>MTime Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gcore.MTimeEvent
   * @generated
   */
  public Adapter createMTimeEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //GcoreAdapterFactory
