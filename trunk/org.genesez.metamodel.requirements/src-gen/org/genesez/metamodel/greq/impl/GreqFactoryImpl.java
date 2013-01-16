/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genesez.metamodel.greq.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GreqFactoryImpl extends EFactoryImpl implements GreqFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GreqFactory init()
  {
    try
    {
      GreqFactory theGreqFactory = (GreqFactory)EPackage.Registry.INSTANCE.getEFactory("http://genesez.org/metamodel/requirements"); 
      if (theGreqFactory != null)
      {
        return theGreqFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GreqFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreqFactoryImpl()
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
      case GreqPackage.RMODEL: return createRModel();
      case GreqPackage.RREQUIREMENT: return createRRequirement();
      case GreqPackage.RSCENARIO: return createRScenario();
      case GreqPackage.RSCENARIO_STEP: return createRScenarioStep();
      case GreqPackage.RANNOTATION: return createRAnnotation();
      case GreqPackage.RTAG: return createRTag();
      case GreqPackage.RVALUE: return createRValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RModel createRModel()
  {
    RModelImpl rModel = new RModelImpl();
    return rModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement createRRequirement()
  {
    RRequirementImpl rRequirement = new RRequirementImpl();
    return rRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenario createRScenario()
  {
    RScenarioImpl rScenario = new RScenarioImpl();
    return rScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenarioStep createRScenarioStep()
  {
    RScenarioStepImpl rScenarioStep = new RScenarioStepImpl();
    return rScenarioStep;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RAnnotation createRAnnotation()
  {
    RAnnotationImpl rAnnotation = new RAnnotationImpl();
    return rAnnotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RTag createRTag()
  {
    RTagImpl rTag = new RTagImpl();
    return rTag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RValue createRValue()
  {
    RValueImpl rValue = new RValueImpl();
    return rValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreqPackage getGreqPackage()
  {
    return (GreqPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GreqPackage getPackage()
  {
    return GreqPackage.eINSTANCE;
  }

} //GreqFactoryImpl
