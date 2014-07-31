/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MBehavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MBehavior#getOwningContext <em>Owning Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MBehavior#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MBehavior#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MBehavior#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MBehavior#getDo <em>Do</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior()
 * @model abstract="true"
 * @generated
 */
public interface MBehavior extends MElement, MDefinitionContext
{
  /**
   * Returns the value of the '<em><b>Owning Context</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MDefinitionContext#getOwnedBehavior <em>Owned Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Context</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Context</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior_OwningContext()
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getOwnedBehavior
   * @model opposite="ownedBehavior" required="true" transient="false" changeable="false"
   * @generated
   */
  MDefinitionContext getOwningContext();

  /**
   * Returns the value of the '<em><b>Transition</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTransition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior_Transition()
   * @see org.genesez.metamodel.gcore.MTransition#getAction
   * @model opposite="action"
   * @generated
   */
  EList<MTransition> getTransition();

  /**
   * Returns the value of the '<em><b>Entry</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MState}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior_Entry()
   * @see org.genesez.metamodel.gcore.MState#getEntry
   * @model opposite="entry"
   * @generated
   */
  EList<MState> getEntry();

  /**
   * Returns the value of the '<em><b>Exit</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MState}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior_Exit()
   * @see org.genesez.metamodel.gcore.MState#getExit
   * @model opposite="exit"
   * @generated
   */
  EList<MState> getExit();

  /**
   * Returns the value of the '<em><b>Do</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MState}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Do</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Do</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMBehavior_Do()
   * @see org.genesez.metamodel.gcore.MState#getDo
   * @model opposite="do"
   * @generated
   */
  EList<MState> getDo();

} // MBehavior
