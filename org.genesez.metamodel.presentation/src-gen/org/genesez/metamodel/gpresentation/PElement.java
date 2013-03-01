/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an abstract element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PElement#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PElement#getOwningArea <em>Owning Area</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PElement#getOwningElement <em>Owning Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElement()
 * @model abstract="true"
 * @generated
 */
public interface PElement extends PMetaDataAware {
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
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owning Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PElementArea#getNestedElements <em>Nested Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Area</em>' container reference.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElement_OwningArea()
	 * @see org.genesez.metamodel.gpresentation.PElementArea#getNestedElements
	 * @model opposite="nestedElements" transient="false" changeable="false"
	 * @generated
	 */
	PElementArea getOwningArea();

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PCompositeElement#getNestedElements <em>Nested Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' container reference.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPElement_OwningElement()
	 * @see org.genesez.metamodel.gpresentation.PCompositeElement#getNestedElements
	 * @model opposite="nestedElements" transient="false" changeable="false"
	 * @generated
	 */
	PCompositeElement getOwningElement();

} // PElement
