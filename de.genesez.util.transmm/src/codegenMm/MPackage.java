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
 * A representation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegenMm.MPackage#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.MPackage#getClass_ <em>Class</em>}</li>
 *   <li>{@link codegenMm.MPackage#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link codegenMm.MPackage#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link codegenMm.MPackage#getModel <em>Model</em>}</li>
 *   <li>{@link codegenMm.MPackage#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegenMm.CodegenMmPackage#getMPackage()
 * @model
 * @generated
 */
public interface MPackage extends EObject {
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
	 * @see codegenMm.CodegenMmPackage#getMPackage_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegenMm.MPackage#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' containment reference list.
	 * The list contents are of type {@link codegenMm.MClass}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MClass#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' containment reference list.
	 * @see codegenMm.CodegenMmPackage#getMPackage_Class()
	 * @see codegenMm.MClass#getOwningPackage
	 * @model type="codegenMm.MClass" opposite="owningPackage" containment="true"
	 * @generated
	 */
	EList getClass_();

	/**
	 * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
	 * The list contents are of type {@link codegenMm.MPackage}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MPackage#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Package</em>' containment reference list.
	 * @see codegenMm.CodegenMmPackage#getMPackage_NestedPackage()
	 * @see codegenMm.MPackage#getNestingPackage
	 * @model type="codegenMm.MPackage" opposite="nestingPackage" containment="true"
	 * @generated
	 */
	EList getNestedPackage();

	/**
	 * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegenMm.MPackage#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nesting Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nesting Package</em>' container reference.
	 * @see #setNestingPackage(MPackage)
	 * @see codegenMm.CodegenMmPackage#getMPackage_NestingPackage()
	 * @see codegenMm.MPackage#getNestedPackage
	 * @model opposite="nestedPackage"
	 * @generated
	 */
	MPackage getNestingPackage();

	/**
	 * Sets the value of the '{@link codegenMm.MPackage#getNestingPackage <em>Nesting Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nesting Package</em>' container reference.
	 * @see #getNestingPackage()
	 * @generated
	 */
	void setNestingPackage(MPackage value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegenMm.MModel#getOwnedPackage <em>Owned Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(MModel)
	 * @see codegenMm.CodegenMmPackage#getMPackage_Model()
	 * @see codegenMm.MModel#getOwnedPackage
	 * @model opposite="ownedPackage" required="true"
	 * @generated
	 */
	MModel getModel();

	/**
	 * Sets the value of the '{@link codegenMm.MPackage#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(MModel value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' containment reference list.
	 * The list contents are of type {@link codegenMm.MAssociation}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MAssociation#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' containment reference list.
	 * @see codegenMm.CodegenMmPackage#getMPackage_Association()
	 * @see codegenMm.MAssociation#getOwningPackage
	 * @model type="codegenMm.MAssociation" opposite="owningPackage" containment="true"
	 * @generated
	 */
	EList getAssociation();

} // MPackage