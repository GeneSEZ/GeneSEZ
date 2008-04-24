/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;

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
 *   <li>{@link genesezMM.MElement#getName <em>Name</em>}</li>
 *   <li>{@link genesezMM.MElement#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link genesezMM.MElement#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link genesezMM.MElement#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link genesezMM.MElement#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link genesezMM.MElement#getAspect <em>Aspect</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMElement()
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
   * @see genesezMM.GenesezMMPackage#getMElement_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link genesezMM.MElement#getName <em>Name</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMElement_XmiGuid()
   * @model required="true"
   * @generated
   */
  String getXmiGuid();

  /**
   * Sets the value of the '{@link genesezMM.MElement#getXmiGuid <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xmi Guid</em>' attribute.
   * @see #getXmiGuid()
   * @generated
   */
  void setXmiGuid(String value);

  /**
   * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MComment}.
   * It is bidirectional and its opposite is '{@link genesezMM.MComment#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Comment</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Comment</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMElement_OwnedComment()
   * @see genesezMM.MComment#getOwningElement
   * @model type="genesezMM.MComment" opposite="owningElement" containment="true"
   * @generated
   */
  EList getOwnedComment();

  /**
   * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MTaggedValue}.
   * It is bidirectional and its opposite is '{@link genesezMM.MTaggedValue#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Value</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMElement_TaggedValue()
   * @see genesezMM.MTaggedValue#getOwningElement
   * @model type="genesezMM.MTaggedValue" opposite="owningElement" containment="true"
   * @generated
   */
  EList getTaggedValue();

  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' reference list.
   * The list contents are of type {@link genesezMM.MStereotype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' reference list.
   * @see genesezMM.GenesezMMPackage#getMElement_Stereotype()
   * @model type="genesezMM.MStereotype"
   * @generated
   */
  EList getStereotype();

  /**
   * Returns the value of the '<em><b>Aspect</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MAspect}.
   * It is bidirectional and its opposite is '{@link genesezMM.MAspect#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aspect</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aspect</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMElement_Aspect()
   * @see genesezMM.MAspect#getElement
   * @model type="genesezMM.MAspect" opposite="element" containment="true"
   * @generated
   */
  EList getAspect();

} // MElement
