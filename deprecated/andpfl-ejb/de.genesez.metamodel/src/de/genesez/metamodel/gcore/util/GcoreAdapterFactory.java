/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.util;

import de.genesez.metamodel.gcore.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.genesez.metamodel.gcore.GcorePackage
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
   * The switch the delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GcoreSwitch modelSwitch =
    new GcoreSwitch()
    {
      public Object caseMPackage(MPackage object)
      {
        return createMPackageAdapter();
      }
      public Object caseMClass(MClass object)
      {
        return createMClassAdapter();
      }
      public Object caseMAssociationRole(MAssociationRole object)
      {
        return createMAssociationRoleAdapter();
      }
      public Object caseMAssociation(MAssociation object)
      {
        return createMAssociationAdapter();
      }
      public Object caseMAttribute(MAttribute object)
      {
        return createMAttributeAdapter();
      }
      public Object caseMModel(MModel object)
      {
        return createMModelAdapter();
      }
      public Object caseMElement(MElement object)
      {
        return createMElementAdapter();
      }
      public Object caseMProperty(MProperty object)
      {
        return createMPropertyAdapter();
      }
      public Object caseMInterface(MInterface object)
      {
        return createMInterfaceAdapter();
      }
      public Object caseMClassifier(MClassifier object)
      {
        return createMClassifierAdapter();
      }
      public Object caseMOperation(MOperation object)
      {
        return createMOperationAdapter();
      }
      public Object caseMParameter(MParameter object)
      {
        return createMParameterAdapter();
      }
      public Object caseMDataType(MDataType object)
      {
        return createMDataTypeAdapter();
      }
      public Object caseMPrimitiveType(MPrimitiveType object)
      {
        return createMPrimitiveTypeAdapter();
      }
      public Object caseMEnumeration(MEnumeration object)
      {
        return createMEnumerationAdapter();
      }
      public Object caseMStereotype(MStereotype object)
      {
        return createMStereotypeAdapter();
      }
      public Object caseMTag(MTag object)
      {
        return createMTagAdapter();
      }
      public Object caseMComment(MComment object)
      {
        return createMCommentAdapter();
      }
      public Object caseMTaggedValue(MTaggedValue object)
      {
        return createMTaggedValueAdapter();
      }
      public Object caseMAspect(MAspect object)
      {
        return createMAspectAdapter();
      }
      public Object caseMIntroduction(MIntroduction object)
      {
        return createMIntroductionAdapter();
      }
      public Object caseMPointcut(MPointcut object)
      {
        return createMPointcutAdapter();
      }
      public Object caseMLiteral(MLiteral object)
      {
        return createMLiteralAdapter();
      }
      public Object caseMGeneric(MGeneric object)
      {
        return createMGenericAdapter();
      }
      public Object caseMType(MType object)
      {
        return createMTypeAdapter();
      }
      public Object caseMExternal(MExternal object)
      {
        return createMExternalAdapter();
      }
      public Object defaultCase(EObject object)
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
  public Adapter createAdapter(Notifier target)
  {
    return (Adapter)modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MPackage <em>MPackage</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MPackage
   * @generated
   */
  public Adapter createMPackageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MClass <em>MClass</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MClass
   * @generated
   */
  public Adapter createMClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MAssociationRole <em>MAssociation Role</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MAssociationRole
   * @generated
   */
  public Adapter createMAssociationRoleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MAssociation <em>MAssociation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MAssociation
   * @generated
   */
  public Adapter createMAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MAttribute <em>MAttribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MAttribute
   * @generated
   */
  public Adapter createMAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MModel <em>MModel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MModel
   * @generated
   */
  public Adapter createMModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MElement <em>MElement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MElement
   * @generated
   */
  public Adapter createMElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MProperty <em>MProperty</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MProperty
   * @generated
   */
  public Adapter createMPropertyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MInterface <em>MInterface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MInterface
   * @generated
   */
  public Adapter createMInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MClassifier <em>MClassifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MClassifier
   * @generated
   */
  public Adapter createMClassifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MOperation <em>MOperation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MOperation
   * @generated
   */
  public Adapter createMOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MParameter <em>MParameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MParameter
   * @generated
   */
  public Adapter createMParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MDataType <em>MData Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MDataType
   * @generated
   */
  public Adapter createMDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MPrimitiveType <em>MPrimitive Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MPrimitiveType
   * @generated
   */
  public Adapter createMPrimitiveTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MEnumeration <em>MEnumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MEnumeration
   * @generated
   */
  public Adapter createMEnumerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MStereotype <em>MStereotype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MStereotype
   * @generated
   */
  public Adapter createMStereotypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MTag <em>MTag</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MTag
   * @generated
   */
  public Adapter createMTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MComment <em>MComment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MComment
   * @generated
   */
  public Adapter createMCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MTaggedValue <em>MTagged Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MTaggedValue
   * @generated
   */
  public Adapter createMTaggedValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MAspect <em>MAspect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MAspect
   * @generated
   */
  public Adapter createMAspectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MIntroduction <em>MIntroduction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MIntroduction
   * @generated
   */
  public Adapter createMIntroductionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MPointcut <em>MPointcut</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MPointcut
   * @generated
   */
  public Adapter createMPointcutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MLiteral <em>MLiteral</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MLiteral
   * @generated
   */
  public Adapter createMLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MGeneric <em>MGeneric</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MGeneric
   * @generated
   */
  public Adapter createMGenericAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MType <em>MType</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MType
   * @generated
   */
  public Adapter createMTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.genesez.metamodel.gcore.MExternal <em>MExternal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.genesez.metamodel.gcore.MExternal
   * @generated
   */
  public Adapter createMExternalAdapter()
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
