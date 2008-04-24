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
 * A representation of the model object '<em><b>MEnumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MEnumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMEnumeration()
 * @model
 * @generated
 */
public interface MEnumeration extends MDataType
{
  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MLiteral}.
   * It is bidirectional and its opposite is '{@link genesezMM.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMEnumeration_Literal()
   * @see genesezMM.MLiteral#getOwningEnumeration
   * @model type="genesezMM.MLiteral" opposite="owningEnumeration" containment="true"
   * @generated
   */
  EList getLiteral();

} // MEnumeration
