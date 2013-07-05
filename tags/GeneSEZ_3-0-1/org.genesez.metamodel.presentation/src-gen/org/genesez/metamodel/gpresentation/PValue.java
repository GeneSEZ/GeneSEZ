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
 * A representation of the model object '<em><b>PValue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PValue#getValue <em>Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PValue#getKey <em>Key</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PValue#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPValue()
 * @model
 * @generated
 */
public interface PValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPValue_Value()
   * @model required="true"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Key</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' reference.
   * @see #setKey(PKey)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPValue_Key()
   * @model required="true"
   * @generated
   */
  PKey getKey();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PValue#getKey <em>Key</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' reference.
   * @see #getKey()
   * @generated
   */
  void setKey(PKey value);

  /**
   * Returns the value of the '<em><b>Owner</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' container reference.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPValue_Owner()
   * @see org.genesez.metamodel.gpresentation.PMetaDataAware#getValue
   * @model opposite="value" required="true" transient="false" changeable="false"
   * @generated
   */
  PMetaDataAware getOwner();

} // PValue
