/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPrimitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MPrimitiveType#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMPrimitiveType()
 * @model
 * @generated
 */
public interface MPrimitiveType extends MType, MElement
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MModel#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPrimitiveType_Model()
   * @see org.genesez.metamodel.gcore.MModel#getPrimitiveTypes
   * @model opposite="primitiveTypes" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

} // MPrimitiveType
