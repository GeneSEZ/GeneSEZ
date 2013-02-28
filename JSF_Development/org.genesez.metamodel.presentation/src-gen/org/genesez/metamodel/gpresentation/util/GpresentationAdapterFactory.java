/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.genesez.metamodel.gpresentation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage
 * @generated
 */
public class GpresentationAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static GpresentationPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GpresentationAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = GpresentationPackage.eINSTANCE;
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
  protected GpresentationSwitch<Adapter> modelSwitch =
    new GpresentationSwitch<Adapter>()
    {
      @Override
      public Adapter casePRoot(PRoot object)
      {
        return createPRootAdapter();
      }
      @Override
      public Adapter casePCompositeArea(PCompositeArea object)
      {
        return createPCompositeAreaAdapter();
      }
      @Override
      public Adapter casePElement(PElement object)
      {
        return createPElementAdapter();
      }
      @Override
      public Adapter casePUserDefinedArea(PUserDefinedArea object)
      {
        return createPUserDefinedAreaAdapter();
      }
      @Override
      public Adapter casePAutomaticallyGeneratedArea(PAutomaticallyGeneratedArea object)
      {
        return createPAutomaticallyGeneratedAreaAdapter();
      }
      @Override
      public Adapter casePInput(PInput object)
      {
        return createPInputAdapter();
      }
      @Override
      public Adapter casePOutput(POutput object)
      {
        return createPOutputAdapter();
      }
      @Override
      public Adapter casePAction(PAction object)
      {
        return createPActionAdapter();
      }
      @Override
      public Adapter casePMetaData(PMetaData object)
      {
        return createPMetaDataAdapter();
      }
      @Override
      public Adapter casePReferenceArea(PReferenceArea object)
      {
        return createPReferenceAreaAdapter();
      }
      @Override
      public Adapter casePAbstractArea(PAbstractArea object)
      {
        return createPAbstractAreaAdapter();
      }
      @Override
      public Adapter casePElementArea(PElementArea object)
      {
        return createPElementAreaAdapter();
      }
      @Override
      public Adapter casePContentArea(PContentArea object)
      {
        return createPContentAreaAdapter();
      }
      @Override
      public Adapter casePPackage(PPackage object)
      {
        return createPPackageAdapter();
      }
      @Override
      public Adapter casePKey(PKey object)
      {
        return createPKeyAdapter();
      }
      @Override
      public Adapter casePValue(PValue object)
      {
        return createPValueAdapter();
      }
      @Override
      public Adapter casePMetaDataAware(PMetaDataAware object)
      {
        return createPMetaDataAwareAdapter();
      }
      @Override
      public Adapter casePCompositeElement(PCompositeElement object)
      {
        return createPCompositeElementAdapter();
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
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PRoot <em>PRoot</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PRoot
   * @generated
   */
  public Adapter createPRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PCompositeArea <em>PComposite Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PCompositeArea
   * @generated
   */
  public Adapter createPCompositeAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PElement <em>PElement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PElement
   * @generated
   */
  public Adapter createPElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PUserDefinedArea <em>PUser Defined Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PUserDefinedArea
   * @generated
   */
  public Adapter createPUserDefinedAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PAutomaticallyGeneratedArea <em>PAutomatically Generated Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PAutomaticallyGeneratedArea
   * @generated
   */
  public Adapter createPAutomaticallyGeneratedAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PInput <em>PInput</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PInput
   * @generated
   */
  public Adapter createPInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.POutput <em>POutput</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.POutput
   * @generated
   */
  public Adapter createPOutputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PAction <em>PAction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PAction
   * @generated
   */
  public Adapter createPActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PMetaData <em>PMeta Data</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PMetaData
   * @generated
   */
  public Adapter createPMetaDataAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PReferenceArea <em>PReference Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PReferenceArea
   * @generated
   */
  public Adapter createPReferenceAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PAbstractArea <em>PAbstract Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PAbstractArea
   * @generated
   */
  public Adapter createPAbstractAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PElementArea <em>PElement Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PElementArea
   * @generated
   */
  public Adapter createPElementAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PContentArea <em>PContent Area</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PContentArea
   * @generated
   */
  public Adapter createPContentAreaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PPackage <em>PPackage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PPackage
   * @generated
   */
  public Adapter createPPackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PKey <em>PKey</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PKey
   * @generated
   */
  public Adapter createPKeyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PValue <em>PValue</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PValue
   * @generated
   */
  public Adapter createPValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PMetaDataAware <em>PMeta Data Aware</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PMetaDataAware
   * @generated
   */
  public Adapter createPMetaDataAwareAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.genesez.metamodel.gpresentation.PCompositeElement <em>PComposite Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.genesez.metamodel.gpresentation.PCompositeElement
   * @generated
   */
  public Adapter createPCompositeElementAdapter()
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

} //GpresentationAdapterFactory
