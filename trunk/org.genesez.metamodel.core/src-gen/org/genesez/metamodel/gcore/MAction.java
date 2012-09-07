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
 * A representation of the model object '<em><b>MAction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MAction#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAction#getOut <em>Out</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAction#getIn <em>In</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAction#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMAction()
 * @model
 * @generated
 */
public interface MAction extends MNode
{
  /**
   * Returns the value of the '<em><b>Behavior</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behavior</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behavior</em>' reference.
   * @see #setBehavior(MBehavior)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAction_Behavior()
   * @model
   * @generated
   */
  MBehavior getBehavior();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAction#getBehavior <em>Behavior</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behavior</em>' reference.
   * @see #getBehavior()
   * @generated
   */
  void setBehavior(MBehavior value);

  /**
   * Returns the value of the '<em><b>Out</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MClassifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAction_Out()
   * @model
   * @generated
   */
  EList<MClassifier> getOut();

  /**
   * Returns the value of the '<em><b>In</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MClassifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAction_In()
   * @model
   * @generated
   */
  EList<MClassifier> getIn();

  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(MOperation)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAction_Operation()
   * @model
   * @generated
   */
  MOperation getOperation();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAction#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(MOperation value);

} // MAction
