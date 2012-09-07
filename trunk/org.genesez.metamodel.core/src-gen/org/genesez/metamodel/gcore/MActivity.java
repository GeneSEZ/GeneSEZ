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
 * A representation of the model object '<em><b>MActivity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MActivity#getEdge <em>Edge</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MActivity#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMActivity()
 * @model
 * @generated
 */
public interface MActivity extends MBehavior
{
  /**
   * Returns the value of the '<em><b>Edge</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MFlow}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Edge</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Edge</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMActivity_Edge()
   * @model containment="true"
   * @generated
   */
  EList<MFlow> getEdge();

  /**
   * Returns the value of the '<em><b>Node</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMActivity_Node()
   * @model containment="true"
   * @generated
   */
  EList<MNode> getNode();

} // MActivity
