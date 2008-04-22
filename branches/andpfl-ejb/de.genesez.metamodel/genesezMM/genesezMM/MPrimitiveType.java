/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPrimitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MPrimitiveType#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMPrimitiveType()
 * @model
 * @generated
 */
public interface MPrimitiveType extends MType, MElement
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MModel#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMPrimitiveType_Model()
   * @see genesezMM.MModel#getPrimitiveTypes
   * @model opposite="primitiveTypes" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

} // MPrimitiveType
