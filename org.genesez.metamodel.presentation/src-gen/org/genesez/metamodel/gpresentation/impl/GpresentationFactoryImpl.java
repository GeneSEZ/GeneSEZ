/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.genesez.metamodel.gpresentation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GpresentationFactoryImpl extends EFactoryImpl implements GpresentationFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static GpresentationFactory init()
  {
		try {
			GpresentationFactory theGpresentationFactory = (GpresentationFactory)EPackage.Registry.INSTANCE.getEFactory("http://genesez.org/metamodel/presentation"); 
			if (theGpresentationFactory != null) {
				return theGpresentationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GpresentationFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GpresentationFactoryImpl()
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
		switch (eClass.getClassifierID()) {
			case GpresentationPackage.PROOT: return createPRoot();
			case GpresentationPackage.PCOMPOSITE_AREA: return createPCompositeArea();
			case GpresentationPackage.PUSER_DEFINED_AREA: return createPUserDefinedArea();
			case GpresentationPackage.PAUTOMATICALLY_GENERATED_AREA: return createPAutomaticallyGeneratedArea();
			case GpresentationPackage.PINPUT: return createPInput();
			case GpresentationPackage.POUTPUT: return createPOutput();
			case GpresentationPackage.PACTION: return createPAction();
			case GpresentationPackage.PMETA_DATA: return createPMetaData();
			case GpresentationPackage.PREFERENCE_AREA: return createPReferenceArea();
			case GpresentationPackage.PELEMENT_AREA: return createPElementArea();
			case GpresentationPackage.PPACKAGE: return createPPackage();
			case GpresentationPackage.PKEY: return createPKey();
			case GpresentationPackage.PVALUE: return createPValue();
			case GpresentationPackage.PCOMPOSITE_ELEMENT: return createPCompositeElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PRoot createPRoot()
  {
		PRootImpl pRoot = new PRootImpl();
		return pRoot;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PCompositeArea createPCompositeArea()
  {
		PCompositeAreaImpl pCompositeArea = new PCompositeAreaImpl();
		return pCompositeArea;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PUserDefinedArea createPUserDefinedArea()
  {
		PUserDefinedAreaImpl pUserDefinedArea = new PUserDefinedAreaImpl();
		return pUserDefinedArea;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PAutomaticallyGeneratedArea createPAutomaticallyGeneratedArea()
  {
		PAutomaticallyGeneratedAreaImpl pAutomaticallyGeneratedArea = new PAutomaticallyGeneratedAreaImpl();
		return pAutomaticallyGeneratedArea;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PInput createPInput()
  {
		PInputImpl pInput = new PInputImpl();
		return pInput;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public POutput createPOutput()
  {
		POutputImpl pOutput = new POutputImpl();
		return pOutput;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PAction createPAction()
  {
		PActionImpl pAction = new PActionImpl();
		return pAction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PMetaData createPMetaData()
  {
		PMetaDataImpl pMetaData = new PMetaDataImpl();
		return pMetaData;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PReferenceArea createPReferenceArea()
  {
		PReferenceAreaImpl pReferenceArea = new PReferenceAreaImpl();
		return pReferenceArea;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PElementArea createPElementArea()
  {
		PElementAreaImpl pElementArea = new PElementAreaImpl();
		return pElementArea;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PPackage createPPackage()
  {
		PPackageImpl pPackage = new PPackageImpl();
		return pPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PKey createPKey()
  {
		PKeyImpl pKey = new PKeyImpl();
		return pKey;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PValue createPValue()
  {
		PValueImpl pValue = new PValueImpl();
		return pValue;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PCompositeElement createPCompositeElement()
  {
		PCompositeElementImpl pCompositeElement = new PCompositeElementImpl();
		return pCompositeElement;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GpresentationPackage getGpresentationPackage()
  {
		return (GpresentationPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static GpresentationPackage getPackage()
  {
		return GpresentationPackage.eINSTANCE;
	}

} //GpresentationFactoryImpl
