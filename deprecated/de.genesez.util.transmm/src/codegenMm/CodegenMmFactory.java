/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see codegenMm.CodegenMmPackage
 * @generated
 */
public interface CodegenMmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenMmFactory eINSTANCE = codegenMm.impl.CodegenMmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>MPackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MPackage</em>'.
	 * @generated
	 */
	MPackage createMPackage();

	/**
	 * Returns a new object of class '<em>MClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MClass</em>'.
	 * @generated
	 */
	MClass createMClass();

	/**
	 * Returns a new object of class '<em>MAssociation End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAssociation End</em>'.
	 * @generated
	 */
	MAssociationEnd createMAssociationEnd();

	/**
	 * Returns a new object of class '<em>MAssociation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAssociation</em>'.
	 * @generated
	 */
	MAssociation createMAssociation();

	/**
	 * Returns a new object of class '<em>MAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MAttribute</em>'.
	 * @generated
	 */
	MAttribute createMAttribute();

	/**
	 * Returns a new object of class '<em>MModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MModel</em>'.
	 * @generated
	 */
	MModel createMModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CodegenMmPackage getCodegenMmPackage();

} //CodegenMmFactory
