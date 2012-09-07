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
 * A representation of the model object '<em><b>MGuard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MGuard#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGuard#getOwningContext <em>Owning Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMGuard()
 * @model
 * @generated
 */
public interface MGuard extends MElement
{
  /**
   * Returns the value of the '<em><b>Transition</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTransition}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTransition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGuard_Transition()
   * @see org.genesez.metamodel.gcore.MTransition#getGuard
   * @model opposite="guard" required="true"
   * @generated
   */
  EList<MTransition> getTransition();

  /**
   * Returns the value of the '<em><b>Owning Context</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MDefinitionContext#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Context</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Context</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGuard_OwningContext()
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getGuard
   * @model opposite="guard" required="true" transient="false" changeable="false"
   * @generated
   */
  MDefinitionContext getOwningContext();

} // MGuard
