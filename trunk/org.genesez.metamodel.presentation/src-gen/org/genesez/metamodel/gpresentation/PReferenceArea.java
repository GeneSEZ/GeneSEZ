/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PReference Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows to reference another area to use it multiple times.JSF: includesSwing: attributes
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PReferenceArea#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPReferenceArea()
 * @model
 * @generated
 */
public interface PReferenceArea extends PContentArea
{
  /**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(PRoot)
	 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPReferenceArea_Target()
	 * @model required="true"
	 * @generated
	 */
  PRoot getTarget();

  /**
	 * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PReferenceArea#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(PRoot value);

} // PReferenceArea
