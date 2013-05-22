/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PContent Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an area that can contain content.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PContentArea#getOwningArea <em>Owning Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPContentArea()
 * @model abstract="true"
 * @generated
 */
public interface PContentArea extends PMetaDataAware {
	/**
	 * Returns the value of the '<em><b>Owning Area</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PAbstractArea#getNestedContents <em>Nested Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Area</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Area</em>' container reference.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPContentArea_OwningArea()
	 * @see org.genesez.metamodel.gpresentation.PAbstractArea#getNestedContents
	 * @model opposite="nestedContents" required="true" transient="false" changeable="false"
	 * @generated
	 */
	PAbstractArea getOwningArea();

} // PContentArea
