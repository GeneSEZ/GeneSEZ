/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTrace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gtrace.TTrace#getReviewed <em>Reviewed</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gtrace.GtracePackage#getTTrace()
 * @model abstract="true"
 * @generated
 */
public interface TTrace extends EObject
{
  /**
   * Returns the value of the '<em><b>Reviewed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reviewed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reviewed</em>' attribute.
   * @see #setReviewed(String)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTTrace_Reviewed()
   * @model
   * @generated
   */
  String getReviewed();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TTrace#getReviewed <em>Reviewed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reviewed</em>' attribute.
   * @see #getReviewed()
   * @generated
   */
  void setReviewed(String value);

} // TTrace
