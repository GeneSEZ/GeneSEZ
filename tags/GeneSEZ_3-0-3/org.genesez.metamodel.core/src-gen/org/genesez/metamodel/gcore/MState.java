/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MState</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getDo <em>Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MState#getSuperstate <em>Superstate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMState()
 * @model
 * @generated
 */
public interface MState extends MElement
{
  /**
   * Returns the value of the '<em><b>Owner</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MStateMachine#getSmstate <em>Smstate</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owner</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owner</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Owner()
   * @see org.genesez.metamodel.gcore.MStateMachine#getSmstate
   * @model opposite="smstate" required="true" transient="false" changeable="false"
   * @generated
   */
  MStateMachine getOwner();

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTransition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Outgoing()
   * @see org.genesez.metamodel.gcore.MTransition#getSource
   * @model opposite="source"
   * @generated
   */
  EList<MTransition> getOutgoing();

  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTransition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Incoming()
   * @see org.genesez.metamodel.gcore.MTransition#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<MTransition> getIncoming();

  /**
   * Returns the value of the '<em><b>Entry</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MBehavior#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry</em>' reference.
   * @see #setEntry(MBehavior)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Entry()
   * @see org.genesez.metamodel.gcore.MBehavior#getEntry
   * @model opposite="entry"
   * @generated
   */
  MBehavior getEntry();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MState#getEntry <em>Entry</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entry</em>' reference.
   * @see #getEntry()
   * @generated
   */
  void setEntry(MBehavior value);

  /**
   * Returns the value of the '<em><b>Exit</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MBehavior#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit</em>' reference.
   * @see #setExit(MBehavior)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Exit()
   * @see org.genesez.metamodel.gcore.MBehavior#getExit
   * @model opposite="exit"
   * @generated
   */
  MBehavior getExit();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MState#getExit <em>Exit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exit</em>' reference.
   * @see #getExit()
   * @generated
   */
  void setExit(MBehavior value);

  /**
   * Returns the value of the '<em><b>Do</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MBehavior#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do</em>' reference.
   * @see #setDo(MBehavior)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Do()
   * @see org.genesez.metamodel.gcore.MBehavior#getDo
   * @model opposite="do"
   * @generated
   */
  MBehavior getDo();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MState#getDo <em>Do</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do</em>' reference.
   * @see #getDo()
   * @generated
   */
  void setDo(MBehavior value);

  /**
   * Returns the value of the '<em><b>Superstate</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MCompositeState#getSubstate <em>Substate</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Superstate</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Superstate</em>' reference.
   * @see #setSuperstate(MCompositeState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMState_Superstate()
   * @see org.genesez.metamodel.gcore.MCompositeState#getSubstate
   * @model opposite="substate"
   * @generated
   */
  MCompositeState getSuperstate();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MState#getSuperstate <em>Superstate</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Superstate</em>' reference.
   * @see #getSuperstate()
   * @generated
   */
  void setSuperstate(MCompositeState value);

} // MState
