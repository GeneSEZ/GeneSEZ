/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MElement#getAspect <em>Aspect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMElement()
 * @model abstract="true"
 * @generated
 */
public interface MElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_XmiGuid()
   * @model id="true" required="true"
   * @generated
   */
  String getXmiGuid();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MElement#getXmiGuid <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xmi Guid</em>' attribute.
   * @see #getXmiGuid()
   * @generated
   */
  void setXmiGuid(String value);

  /**
   * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MComment}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MComment#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Comment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Comment</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_OwnedComment()
   * @see org.genesez.metamodel.gcore.MComment#getOwningElement
   * @model opposite="owningElement" containment="true"
   * @generated
   */
  EList<MComment> getOwnedComment();

  /**
   * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTaggedValue}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTaggedValue#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Value</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_TaggedValue()
   * @see org.genesez.metamodel.gcore.MTaggedValue#getOwningElement
   * @model opposite="owningElement" containment="true"
   * @generated
   */
  EList<MTaggedValue> getTaggedValue();

  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MStereotype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_Stereotype()
   * @model
   * @generated
   */
  EList<MStereotype> getStereotype();

  /**
   * Returns the value of the '<em><b>Aspect</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MAspect}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAspect#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aspect</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aspect</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMElement_Aspect()
   * @see org.genesez.metamodel.gcore.MAspect#getElement
   * @model opposite="element" containment="true"
   * @generated
   */
  EList<MAspect> getAspect();

} // MElement
