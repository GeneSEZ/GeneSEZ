/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MStereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MStereotype#getProperty <em>Property</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MStereotype#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMStereotype()
 * @model
 * @generated
 */
public interface MStereotype extends MElement
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MTag}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MTag#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMStereotype_Property()
   * @see de.genesez.metamodel.gcore.MTag#getStereotype
   * @model type="de.genesez.metamodel.gcore.MTag" opposite="stereotype" containment="true"
   * @generated
   */
  EList getProperty();

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MModel#getAnyStereotype <em>Any Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMStereotype_Model()
   * @see de.genesez.metamodel.gcore.MModel#getAnyStereotype
   * @model opposite="anyStereotype" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

} // MStereotype
