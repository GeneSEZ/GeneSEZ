/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;

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
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getName <em>Name</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MElement#getAspect <em>Aspect</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement()
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MElement#getName <em>Name</em>}' attribute.
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_XmiGuid()
   * @model required="true"
   * @generated
   */
  String getXmiGuid();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MElement#getXmiGuid <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xmi Guid</em>' attribute.
   * @see #getXmiGuid()
   * @generated
   */
  void setXmiGuid(String value);

  /**
   * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MComment}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MComment#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Comment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Comment</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_OwnedComment()
   * @see de.genesez.metamodel.genesezMM.MComment#getOwningElement
   * @model type="de.genesez.metamodel.genesezMM.MComment" opposite="owningElement" containment="true"
   * @generated
   */
  EList getOwnedComment();

  /**
   * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MTaggedValue}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MTaggedValue#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Value</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_TaggedValue()
   * @see de.genesez.metamodel.genesezMM.MTaggedValue#getOwningElement
   * @model type="de.genesez.metamodel.genesezMM.MTaggedValue" opposite="owningElement" containment="true"
   * @generated
   */
  EList getTaggedValue();

  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MStereotype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_Stereotype()
   * @model type="de.genesez.metamodel.genesezMM.MStereotype"
   * @generated
   */
  EList getStereotype();

  /**
   * Returns the value of the '<em><b>Aspect</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MAspect}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MAspect#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aspect</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aspect</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMElement_Aspect()
   * @see de.genesez.metamodel.genesezMM.MAspect#getElement
   * @model type="de.genesez.metamodel.genesezMM.MAspect" opposite="element" containment="true"
   * @generated
   */
  EList getAspect();

} // MElement
