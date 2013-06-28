/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PKey</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PKey#getKey <em>Key</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PKey#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPKey()
 * @model
 * @generated
 */
public interface PKey extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPKey_Key()
   * @model required="true"
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PKey#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Owner</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PMetaData#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' container reference.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPKey_Owner()
   * @see org.genesez.metamodel.gpresentation.PMetaData#getKey
   * @model opposite="key" required="true" transient="false" changeable="false"
   * @generated
   */
  PMetaData getOwner();

} // PKey
