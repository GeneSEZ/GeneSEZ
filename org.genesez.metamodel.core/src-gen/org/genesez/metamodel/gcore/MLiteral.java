/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MLiteral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMLiteral()
 * @model
 * @generated
 */
public interface MLiteral extends MElement
{
  /**
   * Returns the value of the '<em><b>Owning Enumeration</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MEnumeration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Enumeration</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Enumeration</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMLiteral_OwningEnumeration()
   * @see org.genesez.metamodel.gcore.MEnumeration#getLiteral
   * @model opposite="literal" required="true" transient="false" changeable="false"
   * @generated
   */
  MEnumeration getOwningEnumeration();

} // MLiteral
