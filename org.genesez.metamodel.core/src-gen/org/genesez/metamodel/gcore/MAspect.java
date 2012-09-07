/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MAspect#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAspect#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAspect#getElement <em>Element</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAspect#getIntroduction <em>Introduction</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAspect#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect()
 * @model
 * @generated
 */
public interface MAspect extends EObject
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect_Domain()
   * @model required="true"
   * @generated
   */
  String getDomain();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAspect#getDomain <em>Domain</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAspect#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MElement#getAspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect_Element()
   * @see org.genesez.metamodel.gcore.MElement#getAspect
   * @model opposite="aspect" required="true" transient="false" changeable="false"
   * @generated
   */
  MElement getElement();

  /**
   * Returns the value of the '<em><b>Introduction</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MIntroduction}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MIntroduction#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Introduction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Introduction</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect_Introduction()
   * @see org.genesez.metamodel.gcore.MIntroduction#getOrigin
   * @model opposite="origin" containment="true"
   * @generated
   */
  EList<MIntroduction> getIntroduction();

  /**
   * Returns the value of the '<em><b>Pointcut</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MPointcut}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPointcut#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pointcut</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pointcut</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAspect_Pointcut()
   * @see org.genesez.metamodel.gcore.MPointcut#getOrigin
   * @model opposite="origin" containment="true"
   * @generated
   */
  EList<MPointcut> getPointcut();

} // MAspect
