/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents an area that is defined within a file.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PRoot#getOwningPackage <em>Owning Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPRoot()
 * @model
 * @generated
 */
public interface PRoot extends PAbstractArea {
	/**
	 * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PPackage#getRoots <em>Roots</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Package</em>' container reference.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPRoot_OwningPackage()
	 * @see org.genesez.metamodel.gpresentation.PPackage#getRoots
	 * @model opposite="roots" required="true" transient="false" changeable="false"
	 * @generated
	 */
	PPackage getOwningPackage();

} // PRoot
