/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.util;

import de.genesez.metamodel.gcore.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see de.genesez.metamodel.gcore.GcorePackage
 * @generated
 */
public class GcoreSwitch
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
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public Object doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected Object doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch((EClass)eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected Object doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case GcorePackage.MPACKAGE:
      {
        MPackage mPackage = (MPackage)theEObject;
        Object result = caseMPackage(mPackage);
        if (result == null) result = caseMElement(mPackage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCLASS:
      {
        MClass mClass = (MClass)theEObject;
        Object result = caseMClass(mClass);
        if (result == null) result = caseMClassifier(mClass);
        if (result == null) result = caseMElement(mClass);
        if (result == null) result = caseMType(mClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASSOCIATION_ROLE:
      {
        MAssociationRole mAssociationRole = (MAssociationRole)theEObject;
        Object result = caseMAssociationRole(mAssociationRole);
        if (result == null) result = caseMProperty(mAssociationRole);
        if (result == null) result = caseMElement(mAssociationRole);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASSOCIATION:
      {
        MAssociation mAssociation = (MAssociation)theEObject;
        Object result = caseMAssociation(mAssociation);
        if (result == null) result = caseMElement(mAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MATTRIBUTE:
      {
        MAttribute mAttribute = (MAttribute)theEObject;
        Object result = caseMAttribute(mAttribute);
        if (result == null) result = caseMProperty(mAttribute);
        if (result == null) result = caseMElement(mAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MMODEL:
      {
        MModel mModel = (MModel)theEObject;
        Object result = caseMModel(mModel);
        if (result == null) result = caseMPackage(mModel);
        if (result == null) result = caseMElement(mModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MELEMENT:
      {
        MElement mElement = (MElement)theEObject;
        Object result = caseMElement(mElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPROPERTY:
      {
        MProperty mProperty = (MProperty)theEObject;
        Object result = caseMProperty(mProperty);
        if (result == null) result = caseMElement(mProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINTERFACE:
      {
        MInterface mInterface = (MInterface)theEObject;
        Object result = caseMInterface(mInterface);
        if (result == null) result = caseMClassifier(mInterface);
        if (result == null) result = caseMElement(mInterface);
        if (result == null) result = caseMType(mInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCLASSIFIER:
      {
        MClassifier mClassifier = (MClassifier)theEObject;
        Object result = caseMClassifier(mClassifier);
        if (result == null) result = caseMElement(mClassifier);
        if (result == null) result = caseMType(mClassifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MOPERATION:
      {
        MOperation mOperation = (MOperation)theEObject;
        Object result = caseMOperation(mOperation);
        if (result == null) result = caseMElement(mOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPARAMETER:
      {
        MParameter mParameter = (MParameter)theEObject;
        Object result = caseMParameter(mParameter);
        if (result == null) result = caseMElement(mParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MDATA_TYPE:
      {
        MDataType mDataType = (MDataType)theEObject;
        Object result = caseMDataType(mDataType);
        if (result == null) result = caseMClassifier(mDataType);
        if (result == null) result = caseMElement(mDataType);
        if (result == null) result = caseMType(mDataType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPRIMITIVE_TYPE:
      {
        MPrimitiveType mPrimitiveType = (MPrimitiveType)theEObject;
        Object result = caseMPrimitiveType(mPrimitiveType);
        if (result == null) result = caseMType(mPrimitiveType);
        if (result == null) result = caseMElement(mPrimitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MENUMERATION:
      {
        MEnumeration mEnumeration = (MEnumeration)theEObject;
        Object result = caseMEnumeration(mEnumeration);
        if (result == null) result = caseMDataType(mEnumeration);
        if (result == null) result = caseMClassifier(mEnumeration);
        if (result == null) result = caseMElement(mEnumeration);
        if (result == null) result = caseMType(mEnumeration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MSTEREOTYPE:
      {
        MStereotype mStereotype = (MStereotype)theEObject;
        Object result = caseMStereotype(mStereotype);
        if (result == null) result = caseMElement(mStereotype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTAG:
      {
        MTag mTag = (MTag)theEObject;
        Object result = caseMTag(mTag);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MCOMMENT:
      {
        MComment mComment = (MComment)theEObject;
        Object result = caseMComment(mComment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTAGGED_VALUE:
      {
        MTaggedValue mTaggedValue = (MTaggedValue)theEObject;
        Object result = caseMTaggedValue(mTaggedValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MASPECT:
      {
        MAspect mAspect = (MAspect)theEObject;
        Object result = caseMAspect(mAspect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MINTRODUCTION:
      {
        MIntroduction mIntroduction = (MIntroduction)theEObject;
        Object result = caseMIntroduction(mIntroduction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MPOINTCUT:
      {
        MPointcut mPointcut = (MPointcut)theEObject;
        Object result = caseMPointcut(mPointcut);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MLITERAL:
      {
        MLiteral mLiteral = (MLiteral)theEObject;
        Object result = caseMLiteral(mLiteral);
        if (result == null) result = caseMElement(mLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MGENERIC:
      {
        MGeneric mGeneric = (MGeneric)theEObject;
        Object result = caseMGeneric(mGeneric);
        if (result == null) result = caseMType(mGeneric);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MTYPE:
      {
        MType mType = (MType)theEObject;
        Object result = caseMType(mType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case GcorePackage.MEXTERNAL:
      {
        MExternal mExternal = (MExternal)theEObject;
        Object result = caseMExternal(mExternal);
        if (result == null) result = caseMType(mExternal);
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
  public Object caseMPackage(MPackage object)
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
  public Object caseMClass(MClass object)
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
  public Object caseMAssociationRole(MAssociationRole object)
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
  public Object caseMAssociation(MAssociation object)
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
  public Object caseMAttribute(MAttribute object)
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
  public Object caseMModel(MModel object)
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
  public Object caseMElement(MElement object)
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
  public Object caseMProperty(MProperty object)
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
  public Object caseMInterface(MInterface object)
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
  public Object caseMClassifier(MClassifier object)
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
  public Object caseMOperation(MOperation object)
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
  public Object caseMParameter(MParameter object)
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
  public Object caseMDataType(MDataType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MPrimitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MPrimitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseMPrimitiveType(MPrimitiveType object)
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
  public Object caseMEnumeration(MEnumeration object)
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
  public Object caseMStereotype(MStereotype object)
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
  public Object caseMTag(MTag object)
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
  public Object caseMComment(MComment object)
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
  public Object caseMTaggedValue(MTaggedValue object)
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
  public Object caseMAspect(MAspect object)
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
  public Object caseMIntroduction(MIntroduction object)
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
  public Object caseMPointcut(MPointcut object)
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
  public Object caseMLiteral(MLiteral object)
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
  public Object caseMGeneric(MGeneric object)
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
  public Object caseMType(MType object)
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
  public Object caseMExternal(MExternal object)
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
  public Object defaultCase(EObject object)
  {
    return null;
  }

} //GcoreSwitch
