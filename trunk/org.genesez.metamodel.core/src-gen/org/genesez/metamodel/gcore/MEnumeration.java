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
 * A representation of the model object '<em><b>MEnumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MEnumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMEnumeration()
 * @model
 * @generated
 */
public interface MEnumeration extends MDataType
{
  /**
   * Returns the value of the '<em><b>Literal</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MLiteral}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMEnumeration_Literal()
   * @see org.genesez.metamodel.gcore.MLiteral#getOwningEnumeration
   * @model opposite="owningEnumeration" containment="true"
   * @generated
   */
  EList<MLiteral> getLiteral();

} // MEnumeration
