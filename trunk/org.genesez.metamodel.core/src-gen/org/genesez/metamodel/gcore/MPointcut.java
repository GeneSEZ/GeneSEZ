/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPointcut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MPointcut#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MPointcut#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MPointcut#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MPointcut#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMPointcut()
 * @model
 * @generated
 */
public interface MPointcut extends EObject
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' attribute.
   * @see #setDomain(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPointcut_Domain()
   * @model required="true"
   * @generated
   */
  String getDomain();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MPointcut#getDomain <em>Domain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' attribute.
   * @see #getDomain()
   * @generated
   */
  void setDomain(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPointcut_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MPointcut#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' attribute.
   * The literals are from the enumeration {@link org.genesez.metamodel.gcore.MDestinationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' attribute.
   * @see org.genesez.metamodel.gcore.MDestinationKind
   * @see #setDestination(MDestinationKind)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPointcut_Destination()
   * @model required="true"
   * @generated
   */
  MDestinationKind getDestination();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MPointcut#getDestination <em>Destination</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' attribute.
   * @see org.genesez.metamodel.gcore.MDestinationKind
   * @see #getDestination()
   * @generated
   */
  void setDestination(MDestinationKind value);

  /**
   * Returns the value of the '<em><b>Origin</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAspect#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Origin</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Origin</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPointcut_Origin()
   * @see org.genesez.metamodel.gcore.MAspect#getPointcut
   * @model opposite="pointcut" required="true" transient="false" changeable="false"
   * @generated
   */
  MAspect getOrigin();

} // MPointcut
