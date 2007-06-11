/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm.impl;

import codegenMm.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodegenMmFactoryImpl extends EFactoryImpl implements CodegenMmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CodegenMmFactory init() {
		try {
			CodegenMmFactory theCodegenMmFactory = (CodegenMmFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.genesez.de/codegenMm"); 
			if (theCodegenMmFactory != null) {
				return theCodegenMmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CodegenMmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenMmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CodegenMmPackage.MPACKAGE: return createMPackage();
			case CodegenMmPackage.MCLASS: return createMClass();
			case CodegenMmPackage.MASSOCIATION_END: return createMAssociationEnd();
			case CodegenMmPackage.MASSOCIATION: return createMAssociation();
			case CodegenMmPackage.MATTRIBUTE: return createMAttribute();
			case CodegenMmPackage.MMODEL: return createMModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage createMPackage() {
		MPackageImpl mPackage = new MPackageImpl();
		return mPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MClass createMClass() {
		MClassImpl mClass = new MClassImpl();
		return mClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAssociationEnd createMAssociationEnd() {
		MAssociationEndImpl mAssociationEnd = new MAssociationEndImpl();
		return mAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAssociation createMAssociation() {
		MAssociationImpl mAssociation = new MAssociationImpl();
		return mAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAttribute createMAttribute() {
		MAttributeImpl mAttribute = new MAttributeImpl();
		return mAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MModel createMModel() {
		MModelImpl mModel = new MModelImpl();
		return mModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodegenMmPackage getCodegenMmPackage() {
		return (CodegenMmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static CodegenMmPackage getPackage() {
		return CodegenMmPackage.eINSTANCE;
	}

} //CodegenMmFactoryImpl
