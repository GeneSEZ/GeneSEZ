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
 * A representation of the model object '<em><b>MClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegenMm.MClass#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.MClass#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link codegenMm.MClass#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link codegenMm.MClass#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link codegenMm.MClass#getSuperClass <em>Super Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegenMm.CodegenMmPackage#getMClass()
 * @model
 * @generated
 */
public interface MClass extends EObject {
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
	 * @see codegenMm.CodegenMmPackage#getMClass_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegenMm.MClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Association End</b></em>' reference list.
	 * The list contents are of type {@link codegenMm.MAssociationEnd}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MAssociationEnd#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End</em>' reference list.
	 * @see codegenMm.CodegenMmPackage#getMClass_AssociationEnd()
	 * @see codegenMm.MAssociationEnd#getClass_
	 * @model type="codegenMm.MAssociationEnd" opposite="class"
	 * @generated
	 */
	EList getAssociationEnd();

	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegenMm.MPackage#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see #setOwningPackage(MPackage)
	 * @see codegenMm.CodegenMmPackage#getMClass_OwningPackage()
	 * @see codegenMm.MPackage#getClass_
	 * @model opposite="class" required="true"
	 * @generated
	 */
	MPackage getOwningPackage();

	/**
	 * Sets the value of the '{@link codegenMm.MClass#getOwningPackage <em>Owning Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Package</em>' container reference.
	 * @see #getOwningPackage()
	 * @generated
	 */
	void setOwningPackage(MPackage value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link codegenMm.MAttribute}.
	 * It is bidirectional and its opposite is '{@link codegenMm.MAttribute#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see codegenMm.CodegenMmPackage#getMClass_Attribute()
	 * @see codegenMm.MAttribute#getClass_
	 * @model type="codegenMm.MAttribute" opposite="class" containment="true"
	 * @generated
	 */
	EList getAttribute();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference list.
	 * The list contents are of type {@link codegenMm.MClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference list.
	 * @see codegenMm.CodegenMmPackage#getMClass_SuperClass()
	 * @model type="codegenMm.MClass"
	 * @generated
	 */
	EList getSuperClass();

} // MClass