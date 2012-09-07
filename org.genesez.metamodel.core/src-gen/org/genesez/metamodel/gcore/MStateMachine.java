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
 * A representation of the model object '<em><b>MState Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MStateMachine#getSmstate <em>Smstate</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MStateMachine#getSmtransition <em>Smtransition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MStateMachine#getAtomicTransition <em>Atomic Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMStateMachine()
 * @model
 * @generated
 */
public interface MStateMachine extends MBehavior
{
  /**
   * Returns the value of the '<em><b>Smstate</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MState}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Smstate</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Smstate</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStateMachine_Smstate()
   * @see org.genesez.metamodel.gcore.MState#getOwner
   * @model opposite="owner" containment="true"
   * @generated
   */
  EList<MState> getSmstate();

  /**
   * Returns the value of the '<em><b>Smtransition</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTransition#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Smtransition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Smtransition</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStateMachine_Smtransition()
   * @see org.genesez.metamodel.gcore.MTransition#getStatemachine
   * @model opposite="statemachine" containment="true"
   * @generated
   */
  EList<MTransition> getSmtransition();

  /**
   * Returns the value of the '<em><b>Atomic Transition</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MAtomicTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAtomicTransition#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atomic Transition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atomic Transition</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStateMachine_AtomicTransition()
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getStatemachine
   * @model opposite="statemachine" containment="true"
   * @generated
   */
  EList<MAtomicTransition> getAtomicTransition();

} // MStateMachine
