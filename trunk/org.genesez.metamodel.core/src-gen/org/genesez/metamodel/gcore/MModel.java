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
 * A representation of the model object '<em><b>MModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MModel#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MModel#getAnyStereotype <em>Any Stereotype</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MModel#getExternalTypes <em>External Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMModel()
 * @model
 * @generated
 */
public interface MModel extends MPackage
{
  /**
   * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MPrimitiveType}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPrimitiveType#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive Types</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMModel_PrimitiveTypes()
   * @see org.genesez.metamodel.gcore.MPrimitiveType#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<MPrimitiveType> getPrimitiveTypes();

  /**
   * Returns the value of the '<em><b>Any Stereotype</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MStereotype}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Stereotype</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Stereotype</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMModel_AnyStereotype()
   * @see org.genesez.metamodel.gcore.MStereotype#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<MStereotype> getAnyStereotype();

  /**
   * Returns the value of the '<em><b>External Types</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MExternal}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MExternal#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Types</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMModel_ExternalTypes()
   * @see org.genesez.metamodel.gcore.MExternal#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<MExternal> getExternalTypes();

} // MModel
