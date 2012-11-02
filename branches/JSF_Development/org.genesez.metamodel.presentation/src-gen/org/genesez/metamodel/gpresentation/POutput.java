/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>POutput</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.POutput#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPOutput()
 * @model
 * @generated
 */
public interface POutput extends PElement
{

  /**
   * Returns the value of the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' attribute.
   * @see #setOutput(String)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPOutput_Output()
   * @model required="true"
   * @generated
   */
  String getOutput();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.POutput#getOutput <em>Output</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' attribute.
   * @see #getOutput()
   * @generated
   */
  void setOutput(String value);
} // POutput
