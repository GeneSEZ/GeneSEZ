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
 * A representation of the model object '<em><b>MAssociation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociation#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociation#getEnd <em>End</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociation#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociation#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociation()
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociation_Derived()
   * @model required="true"
   * @generated
   */
  boolean isDerived();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociation#isDerived <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived</em>' attribute.
   * @see #isDerived()
   * @generated
   */
  void setDerived(boolean value);

  /**
   * Returns the value of the '<em><b>End</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MAssociationRole}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAssociationRole#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociation_End()
   * @see org.genesez.metamodel.gcore.MAssociationRole#getAssociation
   * @model opposite="association" required="true"
   * @generated
   */
  EList<MAssociationRole> getEnd();

  /**
   * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPackage#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Package</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociation_OwningPackage()
   * @see org.genesez.metamodel.gcore.MPackage#getAssociation
   * @model opposite="association" required="true" transient="false" changeable="false"
   * @generated
   */
  MPackage getOwningPackage();

  /**
   * Returns the value of the '<em><b>Association Class</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClass#getOwnedAssociation <em>Owned Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Class</em>' reference.
   * @see #setAssociationClass(MClass)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociation_AssociationClass()
   * @see org.genesez.metamodel.gcore.MClass#getOwnedAssociation
   * @model opposite="ownedAssociation"
   * @generated
   */
  MClass getAssociationClass();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociation#getAssociationClass <em>Association Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association Class</em>' reference.
   * @see #getAssociationClass()
   * @generated
   */
  void setAssociationClass(MClass value);

} // MAssociation
