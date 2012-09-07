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
 * A representation of the model object '<em><b>MAtomic Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getDefiningTransition <em>Defining Transition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getEndDo <em>End Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getAction <em>Action</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getStartDo <em>Start Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getHistoryContext <em>History Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getStartTimer <em>Start Timer</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getStopTimer <em>Stop Timer</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getSource <em>Source</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAtomicTransition#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition()
 * @model
 * @generated
 */
public interface MAtomicTransition extends MElement
{
  /**
   * Returns the value of the '<em><b>Defining Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defining Transition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defining Transition</em>' reference.
   * @see #setDefiningTransition(MTransition)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_DefiningTransition()
   * @model required="true"
   * @generated
   */
  MTransition getDefiningTransition();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAtomicTransition#getDefiningTransition <em>Defining Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defining Transition</em>' reference.
   * @see #getDefiningTransition()
   * @generated
   */
  void setDefiningTransition(MTransition value);

  /**
   * Returns the value of the '<em><b>End Do</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Do</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Do</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_EndDo()
   * @model
   * @generated
   */
  EList<MBehavior> getEndDo();

  /**
   * Returns the value of the '<em><b>Exit</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Exit()
   * @model
   * @generated
   */
  EList<MBehavior> getExit();

  /**
   * Returns the value of the '<em><b>Action</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Action()
   * @model
   * @generated
   */
  EList<MBehavior> getAction();

  /**
   * Returns the value of the '<em><b>Entry</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Entry()
   * @model
   * @generated
   */
  EList<MBehavior> getEntry();

  /**
   * Returns the value of the '<em><b>Start Do</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Do</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Do</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_StartDo()
   * @model
   * @generated
   */
  EList<MBehavior> getStartDo();

  /**
   * Returns the value of the '<em><b>History Context</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MHistoryState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>History Context</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>History Context</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_HistoryContext()
   * @model
   * @generated
   */
  EList<MHistoryState> getHistoryContext();

  /**
   * Returns the value of the '<em><b>Statemachine</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MStateMachine#getAtomicTransition <em>Atomic Transition</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statemachine</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statemachine</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Statemachine()
   * @see org.genesez.metamodel.gcore.MStateMachine#getAtomicTransition
   * @model opposite="atomicTransition" required="true" transient="false" changeable="false"
   * @generated
   */
  MStateMachine getStatemachine();

  /**
   * Returns the value of the '<em><b>Start Timer</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTimeEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Timer</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Timer</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_StartTimer()
   * @model
   * @generated
   */
  EList<MTimeEvent> getStartTimer();

  /**
   * Returns the value of the '<em><b>Stop Timer</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTimeEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stop Timer</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stop Timer</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_StopTimer()
   * @model
   * @generated
   */
  EList<MTimeEvent> getStopTimer();

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(MLeafState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Source()
   * @model required="true"
   * @generated
   */
  MLeafState getSource();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAtomicTransition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(MLeafState value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(MLeafState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAtomicTransition_Target()
   * @model required="true"
   * @generated
   */
  MLeafState getTarget();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAtomicTransition#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(MLeafState value);

} // MAtomicTransition
