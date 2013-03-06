/**
 */
package org.genesez.metamodel.gtrace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genesez.metamodel.gtrace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GtraceFactoryImpl extends EFactoryImpl implements GtraceFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GtraceFactory init()
  {
    try
    {
      GtraceFactory theGtraceFactory = (GtraceFactory)EPackage.Registry.INSTANCE.getEFactory("http://genesez.org/metamodel/traceability"); 
      if (theGtraceFactory != null)
      {
        return theGtraceFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GtraceFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GtraceFactoryImpl()
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
      case GtracePackage.TTRACE_MODEL: return createTTraceModel();
      case GtracePackage.TREQUIREMENT_TRACE: return createTRequirementTrace();
      case GtracePackage.TSCENARIO_TRACE: return createTScenarioTrace();
      case GtracePackage.TSCENARIO_STEP_TRACE: return createTScenarioStepTrace();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TTraceModel createTTraceModel()
  {
    TTraceModelImpl tTraceModel = new TTraceModelImpl();
    return tTraceModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRequirementTrace createTRequirementTrace()
  {
    TRequirementTraceImpl tRequirementTrace = new TRequirementTraceImpl();
    return tRequirementTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TScenarioTrace createTScenarioTrace()
  {
    TScenarioTraceImpl tScenarioTrace = new TScenarioTraceImpl();
    return tScenarioTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TScenarioStepTrace createTScenarioStepTrace()
  {
    TScenarioStepTraceImpl tScenarioStepTrace = new TScenarioStepTraceImpl();
    return tScenarioStepTrace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GtracePackage getGtracePackage()
  {
    return (GtracePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GtracePackage getPackage()
  {
    return GtracePackage.eINSTANCE;
  }

} //GtraceFactoryImpl
