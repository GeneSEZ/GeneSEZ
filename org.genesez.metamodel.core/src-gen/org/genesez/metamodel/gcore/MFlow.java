/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MFlow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MFlow#getSource <em>Source</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MFlow#getTarget <em>Target</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MFlow#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MFlow#getTransport <em>Transport</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMFlow()
 * @model
 * @generated
 */
public interface MFlow extends MElement
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MNode#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(MNode)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMFlow_Source()
   * @see org.genesez.metamodel.gcore.MNode#getTo
   * @model opposite="to" required="true"
   * @generated
   */
  MNode getSource();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MFlow#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(MNode value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MNode#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(MNode)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMFlow_Target()
   * @see org.genesez.metamodel.gcore.MNode#getFrom
   * @model opposite="from" required="true"
   * @generated
   */
  MNode getTarget();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MFlow#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(MNode value);

  /**
   * Returns the value of the '<em><b>Guard</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' reference.
   * @see #setGuard(MGuard)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMFlow_Guard()
   * @model
   * @generated
   */
  MGuard getGuard();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MFlow#getGuard <em>Guard</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(MGuard value);

  /**
   * Returns the value of the '<em><b>Transport</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transport</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transport</em>' reference.
   * @see #setTransport(MClassifier)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMFlow_Transport()
   * @model
   * @generated
   */
  MClassifier getTransport();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MFlow#getTransport <em>Transport</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transport</em>' reference.
   * @see #getTransport()
   * @generated
   */
  void setTransport(MClassifier value);

} // MFlow
