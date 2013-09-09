/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MNode#getTo <em>To</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MNode#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMNode()
 * @model
 * @generated
 */
public interface MNode extends MElement
{
  /**
   * Returns the value of the '<em><b>To</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MFlow}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MFlow#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMNode_To()
   * @see org.genesez.metamodel.gcore.MFlow#getSource
   * @model opposite="source"
   * @generated
   */
  EList<MFlow> getTo();

  /**
   * Returns the value of the '<em><b>From</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MFlow}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MFlow#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMNode_From()
   * @see org.genesez.metamodel.gcore.MFlow#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<MFlow> getFrom();

} // MNode
