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
 * A representation of the model object '<em><b>MModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MModel#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MModel#getAnyStereotype <em>Any Stereotype</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MModel#getExternalTypes <em>External Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMModel()
 * @model
 * @generated
 */
public interface MModel extends MPackage
{
  /**
   * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MPrimitiveType}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MPrimitiveType#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive Types</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMModel_PrimitiveTypes()
   * @see de.genesez.metamodel.gcore.MPrimitiveType#getModel
   * @model type="de.genesez.metamodel.gcore.MPrimitiveType" opposite="model" containment="true"
   * @generated
   */
  EList getPrimitiveTypes();

  /**
   * Returns the value of the '<em><b>Any Stereotype</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MStereotype}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Stereotype</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Stereotype</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMModel_AnyStereotype()
   * @see de.genesez.metamodel.gcore.MStereotype#getModel
   * @model type="de.genesez.metamodel.gcore.MStereotype" opposite="model" containment="true"
   * @generated
   */
  EList getAnyStereotype();

  /**
   * Returns the value of the '<em><b>External Types</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MExternal}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MExternal#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External Types</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMModel_ExternalTypes()
   * @see de.genesez.metamodel.gcore.MExternal#getModel
   * @model type="de.genesez.metamodel.gcore.MExternal" opposite="model" containment="true"
   * @generated
   */
  EList getExternalTypes();

} // MModel
