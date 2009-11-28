/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MComment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MComment#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MComment#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MComment#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MComment#getNestedComment <em>Nested Comment</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MComment#getNestingComment <em>Nesting Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMComment()
 * @model
 * @generated
 */
public interface MComment extends EObject
{
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
   * @see de.genesez.metamodel.gcore.GcorePackage#getMComment_XmiGuid()
   * @model required="true"
   * @generated
   */
  String getXmiGuid();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MComment#getXmiGuid <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xmi Guid</em>' attribute.
   * @see #getXmiGuid()
   * @generated
   */
  void setXmiGuid(String value);

  /**
   * Returns the value of the '<em><b>Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation</em>' attribute.
   * @see #setAnnotation(String)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMComment_Annotation()
   * @model required="true"
   * @generated
   */
  String getAnnotation();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MComment#getAnnotation <em>Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation</em>' attribute.
   * @see #getAnnotation()
   * @generated
   */
  void setAnnotation(String value);

  /**
   * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MElement#getOwnedComment <em>Owned Comment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Element</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMComment_OwningElement()
   * @see de.genesez.metamodel.gcore.MElement#getOwnedComment
   * @model opposite="ownedComment" required="true" transient="false" changeable="false"
   * @generated
   */
  MElement getOwningElement();

  /**
   * Returns the value of the '<em><b>Nested Comment</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MComment}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MComment#getNestingComment <em>Nesting Comment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Comment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Comment</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMComment_NestedComment()
   * @see de.genesez.metamodel.gcore.MComment#getNestingComment
   * @model type="de.genesez.metamodel.gcore.MComment" opposite="nestingComment" containment="true"
   * @generated
   */
  EList getNestedComment();

  /**
   * Returns the value of the '<em><b>Nesting Comment</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MComment#getNestedComment <em>Nested Comment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nesting Comment</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nesting Comment</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMComment_NestingComment()
   * @see de.genesez.metamodel.gcore.MComment#getNestedComment
   * @model opposite="nestedComment" transient="false" changeable="false"
   * @generated
   */
  MComment getNestingComment();

} // MComment
