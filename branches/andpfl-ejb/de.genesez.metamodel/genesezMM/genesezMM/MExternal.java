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
 * A representation of the model object '<em><b>MExternal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MExternal#getSpecification <em>Specification</em>}</li>
 *   <li>{@link genesezMM.MExternal#getModel <em>Model</em>}</li>
 *   <li>{@link genesezMM.MExternal#getGenericParameter <em>Generic Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMExternal()
 * @model
 * @generated
 */
public interface MExternal extends MType
{
  /**
   * Returns the value of the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specification</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specification</em>' attribute.
   * @see #setSpecification(String)
   * @see genesezMM.GenesezMMPackage#getMExternal_Specification()
   * @model required="true"
   * @generated
   */
  String getSpecification();

  /**
   * Sets the value of the '{@link genesezMM.MExternal#getSpecification <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specification</em>' attribute.
   * @see #getSpecification()
   * @generated
   */
  void setSpecification(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMExternal_Model()
   * @see genesezMM.MModel#getExternalTypes
   * @model opposite="externalTypes" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MGeneric}.
   * It is bidirectional and its opposite is '{@link genesezMM.MGeneric#getOwningExternal <em>Owning External</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMExternal_GenericParameter()
   * @see genesezMM.MGeneric#getOwningExternal
   * @model type="genesezMM.MGeneric" opposite="owningExternal" containment="true"
   * @generated
   */
  EList getGenericParameter();

} // MExternal
