/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MHistory State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MHistoryState#isDeep <em>Deep</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MHistoryState#getReachableHistory <em>Reachable History</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MHistoryState#getDefaultHistory <em>Default History</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMHistoryState()
 * @model
 * @generated
 */
public interface MHistoryState extends MLeafState
{
  /**
   * Returns the value of the '<em><b>Deep</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deep</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deep</em>' attribute.
   * @see #setDeep(boolean)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMHistoryState_Deep()
   * @model required="true"
   * @generated
   */
  boolean isDeep();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MHistoryState#isDeep <em>Deep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deep</em>' attribute.
   * @see #isDeep()
   * @generated
   */
  void setDeep(boolean value);

  /**
   * Returns the value of the '<em><b>Reachable History</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MLeafState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reachable History</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reachable History</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMHistoryState_ReachableHistory()
   * @model
   * @generated
   */
  EList<MLeafState> getReachableHistory();

  /**
   * Returns the value of the '<em><b>Default History</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default History</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default History</em>' reference.
   * @see #setDefaultHistory(MLeafState)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMHistoryState_DefaultHistory()
   * @model
   * @generated
   */
  MLeafState getDefaultHistory();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MHistoryState#getDefaultHistory <em>Default History</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default History</em>' reference.
   * @see #getDefaultHistory()
   * @generated
   */
  void setDefaultHistory(MLeafState value);

} // MHistoryState
