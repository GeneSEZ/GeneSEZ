/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;

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
 *   <li>{@link de.genesez.metamodel.genesezMM.MAspect#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAspect#getName <em>Name</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAspect#getElement <em>Element</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAspect#getIntroduction <em>Introduction</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAspect#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect()
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect_Domain()
   * @model required="true"
   * @generated
   */
  String getDomain();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MAspect#getDomain <em>Domain</em>}' attribute.
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MAspect#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MElement#getAspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect_Element()
   * @see de.genesez.metamodel.genesezMM.MElement#getAspect
   * @model opposite="aspect" required="true" transient="false" changeable="false"
   * @generated
   */
  MElement getElement();

  /**
   * Returns the value of the '<em><b>Introduction</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MIntroduction}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MIntroduction#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Introduction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Introduction</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect_Introduction()
   * @see de.genesez.metamodel.genesezMM.MIntroduction#getOrigin
   * @model type="de.genesez.metamodel.genesezMM.MIntroduction" opposite="origin" containment="true"
   * @generated
   */
  EList getIntroduction();

  /**
   * Returns the value of the '<em><b>Pointcut</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MPointcut}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MPointcut#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pointcut</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pointcut</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAspect_Pointcut()
   * @see de.genesez.metamodel.genesezMM.MPointcut#getOrigin
   * @model type="de.genesez.metamodel.genesezMM.MPointcut" opposite="origin" containment="true"
   * @generated
   */
  EList getPointcut();

} // MAspect
