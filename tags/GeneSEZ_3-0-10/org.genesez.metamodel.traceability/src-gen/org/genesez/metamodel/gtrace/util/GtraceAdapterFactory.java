/**
 */
package org.genesez.metamodel.gtrace.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genesez.metamodel.gtrace.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gtrace.GtracePackage
 * @generated
 */
public class GtraceAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GtracePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GtraceAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GtracePackage.eINSTANCE;
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
  protected GtraceSwitch<Adapter> modelSwitch =
    new GtraceSwitch<Adapter>()
    {
      @Override
      public Adapter caseTTraceModel(TTraceModel object)
      {
        return createTTraceModelAdapter();
      }
      @Override
      public Adapter caseTTrace(TTrace object)
      {
        return createTTraceAdapter();
      }
      @Override
      public Adapter caseTRequirementTrace(TRequirementTrace object)
      {
        return createTRequirementTraceAdapter();
      }
      @Override
      public Adapter caseTScenarioTrace(TScenarioTrace object)
      {
        return createTScenarioTraceAdapter();
      }
      @Override
      public Adapter caseTScenarioStepTrace(TScenarioStepTrace object)
      {
        return createTScenarioStepTraceAdapter();
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
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gtrace.TTraceModel <em>TTrace Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gtrace.TTraceModel
   * @generated
   */
  public Adapter createTTraceModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gtrace.TTrace <em>TTrace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gtrace.TTrace
   * @generated
   */
  public Adapter createTTraceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gtrace.TRequirementTrace <em>TRequirement Trace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gtrace.TRequirementTrace
   * @generated
   */
  public Adapter createTRequirementTraceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gtrace.TScenarioTrace <em>TScenario Trace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gtrace.TScenarioTrace
   * @generated
   */
  public Adapter createTScenarioTraceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gtrace.TScenarioStepTrace <em>TScenario Step Trace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gtrace.TScenarioStepTrace
   * @generated
   */
  public Adapter createTScenarioStepTraceAdapter()
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

} //GtraceAdapterFactory
