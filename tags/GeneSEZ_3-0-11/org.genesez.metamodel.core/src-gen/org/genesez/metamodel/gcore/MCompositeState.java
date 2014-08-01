/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MComposite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MCompositeState#getSubstate <em>Substate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMCompositeState()
 * @model
 * @generated
 */
public interface MCompositeState extends MState
{
  /**
   * Returns the value of the '<em><b>Substate</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MState}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MState#getSuperstate <em>Superstate</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Substate</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Substate</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMCompositeState_Substate()
   * @see org.genesez.metamodel.gcore.MState#getSuperstate
   * @model opposite="superstate"
   * @generated
   */
  EList<MState> getSubstate();

} // MCompositeState
