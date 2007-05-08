/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAssociation End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link codegenMm.MAssociationEnd#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#isNavigable <em>Navigable</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#isAggregation <em>Aggregation</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#isComposition <em>Composition</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#isDerived <em>Derived</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#getName <em>Name</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#getAssociation <em>Association</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#getClass_ <em>Class</em>}</li>
 *   <li>{@link codegenMm.MAssociationEnd#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see codegenMm.CodegenMmPackage#getMAssociationEnd()
 * @model
 * @generated
 */
public interface MAssociationEnd extends EObject {
	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Multiplicity()
	 * @model
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Navigable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigable</em>' attribute.
	 * @see #setNavigable(boolean)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Navigable()
	 * @model
	 * @generated
	 */
	boolean isNavigable();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#isNavigable <em>Navigable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigable</em>' attribute.
	 * @see #isNavigable()
	 * @generated
	 */
	void setNavigable(boolean value);

	/**
	 * Returns the value of the '<em><b>Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation</em>' attribute.
	 * @see #setAggregation(boolean)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Aggregation()
	 * @model
	 * @generated
	 */
	boolean isAggregation();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#isAggregation <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation</em>' attribute.
	 * @see #isAggregation()
	 * @generated
	 */
	void setAggregation(boolean value);

	/**
	 * Returns the value of the '<em><b>Composition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition</em>' attribute.
	 * @see #setComposition(boolean)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Composition()
	 * @model
	 * @generated
	 */
	boolean isComposition();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#isComposition <em>Composition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition</em>' attribute.
	 * @see #isComposition()
	 * @generated
	 */
	void setComposition(boolean value);

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Derived()
	 * @model
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

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
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link codegenMm.MAssociation#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' container reference.
	 * @see #setAssociation(MAssociation)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Association()
	 * @see codegenMm.MAssociation#getEnd
	 * @model opposite="end" required="true"
	 * @generated
	 */
	MAssociation getAssociation();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#getAssociation <em>Association</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' container reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(MAssociation value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link codegenMm.MClass#getAssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(MClass)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Class()
	 * @see codegenMm.MClass#getAssociationEnd
	 * @model opposite="associationEnd" required="true"
	 * @generated
	 */
	MClass getClass_();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(MClass value);

	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(MAssociationEnd)
	 * @see codegenMm.CodegenMmPackage#getMAssociationEnd_Opposite()
	 * @model required="true"
	 * @generated
	 */
	MAssociationEnd getOpposite();

	/**
	 * Sets the value of the '{@link codegenMm.MAssociationEnd#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(MAssociationEnd value);

} // MAssociationEnd