/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegenMm.MModel#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.MModel#getOwnedPackage <em>Owned Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegenMm.CodegenMmPackage#getMModel()
 * @model
 * @generated
 */
public interface MModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see codegenMm.CodegenMmPackage#getMModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegenMm.MModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Package</b></em>' containment reference list.
	 * The list contents are of type {@link codegenMm.MPackage}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MPackage#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Package</em>' containment reference list.
	 * @see codegenMm.CodegenMmPackage#getMModel_OwnedPackage()
	 * @see codegenMm.MPackage#getModel
	 * @model type="codegenMm.MPackage" opposite="model" containment="true"
	 * @generated
	 */
	EList getOwnedPackage();

} // MModel