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
 * A representation of the model object '<em><b>MAssociation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MAssociation#isDerived <em>Derived</em>}</li>
 *   <li>{@link genesezMM.MAssociation#getEnd <em>End</em>}</li>
 *   <li>{@link genesezMM.MAssociation#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link genesezMM.MAssociation#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMAssociation()
 * @model
 * @generated
 */
public interface MAssociation extends MElement
{
  /**
   * Returns the value of the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Derived</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derived</em>' attribute.
   * @see #setDerived(boolean)
   * @see genesezMM.GenesezMMPackage#getMAssociation_Derived()
   * @model required="true"
   * @generated
   */
  boolean isDerived();

  /**
   * Sets the value of the '{@link genesezMM.MAssociation#isDerived <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived</em>' attribute.
   * @see #isDerived()
   * @generated
   */
  void setDerived(boolean value);

  /**
   * Returns the value of the '<em><b>End</b></em>' reference list.
   * The list contents are of type {@link genesezMM.MAssociationRole}.
   * It is bidirectional and its opposite is '{@link genesezMM.MAssociationRole#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' reference list.
   * @see genesezMM.GenesezMMPackage#getMAssociation_End()
   * @see genesezMM.MAssociationRole#getAssociation
   * @model type="genesezMM.MAssociationRole" opposite="association" required="true"
   * @generated
   */
  EList getEnd();

  /**
   * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MPackage#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Package</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMAssociation_OwningPackage()
   * @see genesezMM.MPackage#getAssociation
   * @model opposite="association" required="true" transient="false" changeable="false"
   * @generated
   */
  MPackage getOwningPackage();

  /**
   * Returns the value of the '<em><b>Association Class</b></em>' reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MClass#getOwnedAssociation <em>Owned Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class</em>' reference.
   * @see #setAssociationClass(MClass)
   * @see genesezMM.GenesezMMPackage#getMAssociation_AssociationClass()
   * @see genesezMM.MClass#getOwnedAssociation
   * @model opposite="ownedAssociation"
   * @generated
   */
  MClass getAssociationClass();

  /**
   * Sets the value of the '{@link genesezMM.MAssociation#getAssociationClass <em>Association Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association Class</em>' reference.
   * @see #getAssociationClass()
   * @generated
   */
  void setAssociationClass(MClass value);

} // MAssociation
