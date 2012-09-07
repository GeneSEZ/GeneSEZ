/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MTransition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getKind <em>Kind</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getSource <em>Source</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MTransition#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition()
 * @model
 * @generated
 */
public interface MTransition extends MElement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see #setKind(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Kind()
   * @model required="true"
   * @generated
   */
  String getKind();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTransition#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see #getKind()
   * @generated
   */
  void setKind(String value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(MState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Source()
   * @see org.genesez.metamodel.gcore.MState#getOutgoing
   * @model opposite="outgoing" required="true"
   * @generated
   */
  MState getSource();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTransition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(MState value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(MState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Target()
   * @see org.genesez.metamodel.gcore.MState#getIncoming
   * @model opposite="incoming" required="true"
   * @generated
   */
  MState getTarget();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTransition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(MState value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGuard#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' reference.
   * @see #setGuard(MGuard)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Guard()
   * @see org.genesez.metamodel.gcore.MGuard#getTransition
   * @model opposite="transition"
   * @generated
   */
  MGuard getGuard();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTransition#getGuard <em>Guard</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(MGuard value);

  /**
   * Returns the value of the '<em><b>Statemachine</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MStateMachine#getSmtransition <em>Smtransition</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statemachine</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachine</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Statemachine()
   * @see org.genesez.metamodel.gcore.MStateMachine#getSmtransition
   * @model opposite="smtransition" required="true" transient="false" changeable="false"
   * @generated
   */
  MStateMachine getStatemachine();

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Trigger()
   * @model
   * @generated
   */
  EList<MEvent> getTrigger();

  /**
   * Returns the value of the '<em><b>Action</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MBehavior#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference.
   * @see #setAction(MBehavior)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMTransition_Action()
   * @see org.genesez.metamodel.gcore.MBehavior#getTransition
   * @model opposite="transition"
   * @generated
   */
  MBehavior getAction();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MTransition#getAction <em>Action</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' reference.
   * @see #getAction()
   * @generated
   */
  void setAction(MBehavior value);

} // MTransition
