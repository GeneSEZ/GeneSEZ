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
 * A representation of the model object '<em><b>PComposite Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PCompositeElement#getNestedElements <em>Nested Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPCompositeElement()
 * @model
 * @generated
 */
public interface PCompositeElement extends PElement {
	/**
	 * Returns the value of the '<em><b>Nested Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.genesez.metamodel.gpresentation.PElement}.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PElement#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Elements</em>' containment reference list.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPCompositeElement_NestedElements()
	 * @see org.genesez.metamodel.gpresentation.PElement#getOwningElement
	 * @model opposite="owningElement" containment="true" required="true"
	 * @generated
	 */
	EList<PElement> getNestedElements();

} // PCompositeElement
