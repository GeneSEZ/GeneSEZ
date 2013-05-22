/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PElement Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an area consisting of elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PElementArea#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PElementArea#getNestedElements <em>Nested Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElementArea()
 * @model
 * @generated
 */
public interface PElementArea extends PContentArea {
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
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElementArea_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PElementArea#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Nested Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.genesez.metamodel.gpresentation.PElement}.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PElement#getOwningArea <em>Owning Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Elements</em>' containment reference list.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElementArea_NestedElements()
	 * @see org.genesez.metamodel.gpresentation.PElement#getOwningArea
	 * @model opposite="owningArea" containment="true"
	 * @generated
	 */
	EList<PElement> getNestedElements();

} // PElementArea
