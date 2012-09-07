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
 * A representation of the model object '<em><b>MDefinition Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MDefinitionContext#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MDefinitionContext#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MDefinitionContext#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MDefinitionContext#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMDefinitionContext()
 * @model abstract="true"
 * @generated
 */
public interface MDefinitionContext extends MElement
{
  /**
   * Returns the value of the '<em><b>Classifier</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MClassifier}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClassifier#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDefinitionContext_Classifier()
   * @see org.genesez.metamodel.gcore.MClassifier#getOwningContext
   * @model opposite="owningContext" containment="true"
   * @generated
   */
  EList<MClassifier> getClassifier();

  /**
   * Returns the value of the '<em><b>Owned Behavior</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MBehavior}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MBehavior#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Behavior</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Behavior</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDefinitionContext_OwnedBehavior()
   * @see org.genesez.metamodel.gcore.MBehavior#getOwningContext
   * @model opposite="owningContext" containment="true"
   * @generated
   */
  EList<MBehavior> getOwnedBehavior();

  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGuard}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGuard#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDefinitionContext_Guard()
   * @see org.genesez.metamodel.gcore.MGuard#getOwningContext
   * @model opposite="owningContext" containment="true"
   * @generated
   */
  EList<MGuard> getGuard();

  /**
   * Returns the value of the '<em><b>Event</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MEvent}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MEvent#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDefinitionContext_Event()
   * @see org.genesez.metamodel.gcore.MEvent#getOwningContext
   * @model opposite="owningContext" containment="true"
   * @generated
   */
  EList<MEvent> getEvent();

} // MDefinitionContext
