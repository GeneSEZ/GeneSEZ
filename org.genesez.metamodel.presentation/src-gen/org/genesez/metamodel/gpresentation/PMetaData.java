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
 * A representation of the model object '<em><b>PMeta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaData#getUri <em>Uri</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaData#getKey <em>Key</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PMetaData#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaData()
 * @model
 * @generated
 */
public interface PMetaData extends EObject
{
  /**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uri</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaData_Uri()
	 * @model required="true"
	 * @generated
	 */
  String getUri();

  /**
	 * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PMetaData#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
  void setUri(String value);

  /**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference list.
	 * The list contents are of type {@link org.genesez.metamodel.gpresentation.PKey}.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PKey#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference list.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaData_Key()
	 * @see org.genesez.metamodel.gpresentation.PKey#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
  EList<PKey> getKey();

  /**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PPackage#getMetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Container</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPMetaData_Container()
	 * @see org.genesez.metamodel.gpresentation.PPackage#getMetaData
	 * @model opposite="metaData" required="true" transient="false" changeable="false"
	 * @generated
	 */
  PPackage getContainer();

} // PMetaData
