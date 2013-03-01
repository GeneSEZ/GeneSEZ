/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.genesez.metamodel.gpresentation.*;

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
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage
 * @generated
 */
public class GpresentationSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static GpresentationPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GpresentationSwitch()
  {
		if (modelPackage == null) {
			modelPackage = GpresentationPackage.eINSTANCE;
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
		switch (classifierID) {
			case GpresentationPackage.PROOT: {
				PRoot pRoot = (PRoot)theEObject;
				T result = casePRoot(pRoot);
				if (result == null) result = casePAbstractArea(pRoot);
				if (result == null) result = casePMetaDataAware(pRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PCOMPOSITE_AREA: {
				PCompositeArea pCompositeArea = (PCompositeArea)theEObject;
				T result = casePCompositeArea(pCompositeArea);
				if (result == null) result = casePAbstractArea(pCompositeArea);
				if (result == null) result = casePContentArea(pCompositeArea);
				if (result == null) result = casePMetaDataAware(pCompositeArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PELEMENT: {
				PElement pElement = (PElement)theEObject;
				T result = casePElement(pElement);
				if (result == null) result = casePMetaDataAware(pElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PUSER_DEFINED_AREA: {
				PUserDefinedArea pUserDefinedArea = (PUserDefinedArea)theEObject;
				T result = casePUserDefinedArea(pUserDefinedArea);
				if (result == null) result = casePContentArea(pUserDefinedArea);
				if (result == null) result = casePMetaDataAware(pUserDefinedArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PAUTOMATICALLY_GENERATED_AREA: {
				PAutomaticallyGeneratedArea pAutomaticallyGeneratedArea = (PAutomaticallyGeneratedArea)theEObject;
				T result = casePAutomaticallyGeneratedArea(pAutomaticallyGeneratedArea);
				if (result == null) result = casePContentArea(pAutomaticallyGeneratedArea);
				if (result == null) result = casePMetaDataAware(pAutomaticallyGeneratedArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PINPUT: {
				PInput pInput = (PInput)theEObject;
				T result = casePInput(pInput);
				if (result == null) result = casePElement(pInput);
				if (result == null) result = casePMetaDataAware(pInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.POUTPUT: {
				POutput pOutput = (POutput)theEObject;
				T result = casePOutput(pOutput);
				if (result == null) result = casePElement(pOutput);
				if (result == null) result = casePMetaDataAware(pOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PACTION: {
				PAction pAction = (PAction)theEObject;
				T result = casePAction(pAction);
				if (result == null) result = casePElement(pAction);
				if (result == null) result = casePMetaDataAware(pAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PMETA_DATA: {
				PMetaData pMetaData = (PMetaData)theEObject;
				T result = casePMetaData(pMetaData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PREFERENCE_AREA: {
				PReferenceArea pReferenceArea = (PReferenceArea)theEObject;
				T result = casePReferenceArea(pReferenceArea);
				if (result == null) result = casePContentArea(pReferenceArea);
				if (result == null) result = casePMetaDataAware(pReferenceArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PABSTRACT_AREA: {
				PAbstractArea pAbstractArea = (PAbstractArea)theEObject;
				T result = casePAbstractArea(pAbstractArea);
				if (result == null) result = casePMetaDataAware(pAbstractArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PELEMENT_AREA: {
				PElementArea pElementArea = (PElementArea)theEObject;
				T result = casePElementArea(pElementArea);
				if (result == null) result = casePContentArea(pElementArea);
				if (result == null) result = casePMetaDataAware(pElementArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PCONTENT_AREA: {
				PContentArea pContentArea = (PContentArea)theEObject;
				T result = casePContentArea(pContentArea);
				if (result == null) result = casePMetaDataAware(pContentArea);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PPACKAGE: {
				PPackage pPackage = (PPackage)theEObject;
				T result = casePPackage(pPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PKEY: {
				PKey pKey = (PKey)theEObject;
				T result = casePKey(pKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PVALUE: {
				PValue pValue = (PValue)theEObject;
				T result = casePValue(pValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PMETA_DATA_AWARE: {
				PMetaDataAware pMetaDataAware = (PMetaDataAware)theEObject;
				T result = casePMetaDataAware(pMetaDataAware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GpresentationPackage.PCOMPOSITE_ELEMENT: {
				PCompositeElement pCompositeElement = (PCompositeElement)theEObject;
				T result = casePCompositeElement(pCompositeElement);
				if (result == null) result = casePElement(pCompositeElement);
				if (result == null) result = casePMetaDataAware(pCompositeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PRoot</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PRoot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePRoot(PRoot object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PComposite Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PComposite Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePCompositeArea(PCompositeArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PElement</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePElement(PElement object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PUser Defined Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PUser Defined Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePUserDefinedArea(PUserDefinedArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PAutomatically Generated Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAutomatically Generated Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePAutomaticallyGeneratedArea(PAutomaticallyGeneratedArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PInput</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PInput</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePInput(PInput object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>POutput</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>POutput</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePOutput(POutput object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PAction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePAction(PAction object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PMeta Data</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PMeta Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePMetaData(PMetaData object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PReference Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PReference Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePReferenceArea(PReferenceArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PAbstract Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAbstract Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePAbstractArea(PAbstractArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PElement Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PElement Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePElementArea(PElementArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PContent Area</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PContent Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePContentArea(PContentArea object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PPackage</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PPackage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePPackage(PPackage object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PKey</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PKey</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePKey(PKey object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PValue</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PValue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePValue(PValue object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PMeta Data Aware</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PMeta Data Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePMetaDataAware(PMetaDataAware object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>PComposite Element</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PComposite Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePCompositeElement(PCompositeElement object)
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

} //GpresentationSwitch
