/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MEvent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MEvent#isIsCall <em>Is Call</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MEvent#isIsChange <em>Is Change</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MEvent#getOwningContext <em>Owning Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MEvent#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMEvent()
 * @model
 * @generated
 */
public interface MEvent extends MElement
{
  /**
   * Returns the value of the '<em><b>Is Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Call</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Call</em>' attribute.
   * @see #setIsCall(boolean)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMEvent_IsCall()
   * @model required="true"
   * @generated
   */
  boolean isIsCall();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MEvent#isIsCall <em>Is Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Call</em>' attribute.
   * @see #isIsCall()
   * @generated
   */
  void setIsCall(boolean value);

  /**
   * Returns the value of the '<em><b>Is Change</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Change</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Change</em>' attribute.
   * @see #setIsChange(boolean)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMEvent_IsChange()
   * @model required="true"
   * @generated
   */
  boolean isIsChange();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MEvent#isIsChange <em>Is Change</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Change</em>' attribute.
   * @see #isIsChange()
   * @generated
   */
  void setIsChange(boolean value);

  /**
   * Returns the value of the '<em><b>Owning Context</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MDefinitionContext#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Context</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Context</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMEvent_OwningContext()
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getEvent
   * @model opposite="event" required="true" transient="false" changeable="false"
   * @generated
   */
  MDefinitionContext getOwningContext();

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MParameter}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MParameter#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMEvent_Parameter()
   * @see org.genesez.metamodel.gcore.MParameter#getEvent
   * @model opposite="event" containment="true"
   * @generated
   */
  EList<MParameter> getParameter();

} // MEvent
