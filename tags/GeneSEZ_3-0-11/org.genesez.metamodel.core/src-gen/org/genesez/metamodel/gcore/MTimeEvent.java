/**
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MTime Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MTimeEvent#isIsRelative <em>Is Relative</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTimeEvent#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMTimeEvent()
 * @model
 * @generated
 */
public interface MTimeEvent extends MEvent
{
  /**
   * Returns the value of the '<em><b>Is Relative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Relative</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Relative</em>' attribute.
   * @see #setIsRelative(boolean)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTimeEvent_IsRelative()
   * @model required="true"
   * @generated
   */
  boolean isIsRelative();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTimeEvent#isIsRelative <em>Is Relative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Relative</em>' attribute.
   * @see #isIsRelative()
   * @generated
   */
  void setIsRelative(boolean value);

  /**
   * Returns the value of the '<em><b>When</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>When</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>When</em>' attribute.
   * @see #setWhen(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTimeEvent_When()
   * @model required="true"
   * @generated
   */
  String getWhen();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTimeEvent#getWhen <em>When</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When</em>' attribute.
   * @see #getWhen()
   * @generated
   */
  void setWhen(String value);

} // MTimeEvent
