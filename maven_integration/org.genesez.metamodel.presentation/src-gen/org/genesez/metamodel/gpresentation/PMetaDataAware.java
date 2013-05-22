/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PMeta Data Aware</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaDataAware()
 * @model abstract="true"
 * @generated
 */
public interface PMetaDataAware extends EObject {
	/**
	 * Returns the value of the '<em><b>Xmi Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmi Guid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmi Guid</em>' attribute.
	 * @see #setXmiGuid(String)
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaDataAware_XmiGuid()
	 * @model required="true"
	 * @generated
	 */
	String getXmiGuid();

	/**
	 * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getXmiGuid <em>Xmi Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmi Guid</em>' attribute.
	 * @see #getXmiGuid()
	 * @generated
	 */
	void setXmiGuid(String value);

	/**
	 * Returns the value of the '<em><b>Meta Data</b></em>' reference list.
	 * The list contents are of type {@link org.genesez.metamodel.gpresentation.PMetaData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data</em>' reference list.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaDataAware_MetaData()
	 * @model
	 * @generated
	 */
	EList<PMetaData> getMetaData();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.genesez.metamodel.gpresentation.PValue}.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PValue#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference list.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaDataAware_Value()
	 * @see org.genesez.metamodel.gpresentation.PValue#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<PValue> getValue();

} // PMetaDataAware
