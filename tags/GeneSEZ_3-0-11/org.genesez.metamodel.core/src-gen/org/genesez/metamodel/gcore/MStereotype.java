/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MStereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MStereotype#getProperty <em>Property</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MStereotype#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MStereotype#getGeneralization <em>Generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMStereotype()
 * @model
 * @generated
 */
public interface MStereotype extends MElement
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MTag}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MTag#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStereotype_Property()
   * @see org.genesez.metamodel.gcore.MTag#getStereotype
   * @model opposite="stereotype" containment="true"
   * @generated
   */
  EList<MTag> getProperty();

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MModel#getAnyStereotype <em>Any Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStereotype_Model()
   * @see org.genesez.metamodel.gcore.MModel#getAnyStereotype
   * @model opposite="anyStereotype" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

  /**
   * Returns the value of the '<em><b>Generalization</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MStereotype}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generalization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generalization</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMStereotype_Generalization()
   * @model
   * @generated
   */
  EList<MStereotype> getGeneralization();

} // MStereotype
