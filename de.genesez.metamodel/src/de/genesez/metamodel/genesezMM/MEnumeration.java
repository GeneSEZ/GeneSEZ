/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MEnumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MEnumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMEnumeration()
 * @model
 * @generated
 */
public interface MEnumeration extends MDataType
{
  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MLiteral}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMEnumeration_Literal()
   * @see de.genesez.metamodel.genesezMM.MLiteral#getOwningEnumeration
   * @model type="de.genesez.metamodel.genesezMM.MLiteral" opposite="owningEnumeration" containment="true"
   * @generated
   */
  EList getLiteral();

} // MEnumeration
