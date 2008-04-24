/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MStereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MStereotype#getProperty <em>Property</em>}</li>
 *   <li>{@link genesezMM.MStereotype#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMStereotype()
 * @model
 * @generated
 */
public interface MStereotype extends MElement
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MTag}.
   * It is bidirectional and its opposite is '{@link genesezMM.MTag#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMStereotype_Property()
   * @see genesezMM.MTag#getStereotype
   * @model type="genesezMM.MTag" opposite="stereotype" containment="true"
   * @generated
   */
  EList getProperty();

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MModel#getAnyStereotype <em>Any Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMStereotype_Model()
   * @see genesezMM.MModel#getAnyStereotype
   * @model opposite="anyStereotype" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

} // MStereotype
