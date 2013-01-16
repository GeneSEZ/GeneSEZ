/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genesez.metamodel.greq.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.greq.GreqPackage
 * @generated
 */
public class GreqAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GreqPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreqAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GreqPackage.eINSTANCE;
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
  protected GreqSwitch<Adapter> modelSwitch =
    new GreqSwitch<Adapter>()
    {
      @Override
      public Adapter caseRModel(RModel object)
      {
        return createRModelAdapter();
      }
      @Override
      public Adapter caseRRequirement(RRequirement object)
      {
        return createRRequirementAdapter();
      }
      @Override
      public Adapter caseRScenario(RScenario object)
      {
        return createRScenarioAdapter();
      }
      @Override
      public Adapter caseRScenarioStep(RScenarioStep object)
      {
        return createRScenarioStepAdapter();
      }
      @Override
      public Adapter caseRAnnotation(RAnnotation object)
      {
        return createRAnnotationAdapter();
      }
      @Override
      public Adapter caseRTag(RTag object)
      {
        return createRTagAdapter();
      }
      @Override
      public Adapter caseRValue(RValue object)
      {
        return createRValueAdapter();
      }
      @Override
      public Adapter caseRSpecObject(RSpecObject object)
      {
        return createRSpecObjectAdapter();
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
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RModel <em>RModel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RModel
   * @generated
   */
  public Adapter createRModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RRequirement <em>RRequirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RRequirement
   * @generated
   */
  public Adapter createRRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RScenario <em>RScenario</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RScenario
   * @generated
   */
  public Adapter createRScenarioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RScenarioStep <em>RScenario Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RScenarioStep
   * @generated
   */
  public Adapter createRScenarioStepAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RAnnotation <em>RAnnotation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RAnnotation
   * @generated
   */
  public Adapter createRAnnotationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RTag <em>RTag</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RTag
   * @generated
   */
  public Adapter createRTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RValue <em>RValue</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RValue
   * @generated
   */
  public Adapter createRValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.greq.RSpecObject <em>RSpec Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.greq.RSpecObject
   * @generated
   */
  public Adapter createRSpecObjectAdapter()
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

} //GreqAdapterFactory
