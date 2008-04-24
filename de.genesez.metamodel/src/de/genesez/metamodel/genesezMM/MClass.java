/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MClass#getOwnedAssociation <em>Owned Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMClass()
 * @model
 * @generated
 */
public interface MClass extends MClassifier
{
  /**
   * Returns the value of the '<em><b>Owned Association</b></em>' reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MAssociation#getAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Association</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Association</em>' reference.
   * @see #setOwnedAssociation(MAssociation)
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMClass_OwnedAssociation()
   * @see de.genesez.metamodel.genesezMM.MAssociation#getAssociationClass
   * @model opposite="associationClass"
   * @generated
   */
  MAssociation getOwnedAssociation();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MClass#getOwnedAssociation <em>Owned Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Association</em>' reference.
   * @see #getOwnedAssociation()
   * @generated
   */
  void setOwnedAssociation(MAssociation value);

} // MClass
