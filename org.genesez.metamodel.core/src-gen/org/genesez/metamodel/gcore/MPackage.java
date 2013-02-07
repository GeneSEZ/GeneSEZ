/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MPackage#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MPackage#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MPackage#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMPackage()
 * @model
 * @generated
 */
public interface MPackage extends MDefinitionContext
{
  /**
   * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MPackage}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPackage#getNestingPackage <em>Nesting Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Package</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPackage_NestedPackage()
   * @see org.genesez.metamodel.gcore.MPackage#getNestingPackage
   * @model opposite="nestingPackage" containment="true"
   * @generated
   */
  EList<MPackage> getNestedPackage();

  /**
   * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPackage#getNestedPackage <em>Nested Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nesting Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nesting Package</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPackage_NestingPackage()
   * @see org.genesez.metamodel.gcore.MPackage#getNestedPackage
   * @model opposite="nestedPackage" transient="false" changeable="false"
   * @generated
   */
  MPackage getNestingPackage();

  /**
   * Returns the value of the '<em><b>Association</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MAssociation}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAssociation#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMPackage_Association()
   * @see org.genesez.metamodel.gcore.MAssociation#getOwningPackage
   * @model opposite="owningPackage" containment="true"
   * @generated
   */
  EList<MAssociation> getAssociation();

} // MPackage
