/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MTag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MTag#getName <em>Name</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MTag#getType <em>Type</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MTag#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMTag()
 * @model
 * @generated
 */
public interface MTag extends EObject
{
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMTag_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MTag#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMTag_Type()
   * @model required="true"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MTag#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MStereotype#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMTag_Stereotype()
   * @see de.genesez.metamodel.genesezMM.MStereotype#getProperty
   * @model opposite="property" required="true" transient="false" changeable="false"
   * @generated
   */
  MStereotype getStereotype();

} // MTag
