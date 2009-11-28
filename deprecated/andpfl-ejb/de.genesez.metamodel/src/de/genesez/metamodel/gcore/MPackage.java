/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MPackage#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MPackage#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MPackage#getAssociation <em>Association</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MPackage#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMPackage()
 * @model
 * @generated
 */
public interface MPackage extends MElement
{
  /**
   * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MPackage}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MPackage#getNestingPackage <em>Nesting Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Package</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMPackage_NestedPackage()
   * @see de.genesez.metamodel.gcore.MPackage#getNestingPackage
   * @model type="de.genesez.metamodel.gcore.MPackage" opposite="nestingPackage" containment="true"
   * @generated
   */
  EList getNestedPackage();

  /**
   * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MPackage#getNestedPackage <em>Nested Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nesting Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nesting Package</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMPackage_NestingPackage()
   * @see de.genesez.metamodel.gcore.MPackage#getNestedPackage
   * @model opposite="nestedPackage" transient="false" changeable="false"
   * @generated
   */
  MPackage getNestingPackage();

  /**
   * Returns the value of the '<em><b>Association</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MAssociation}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MAssociation#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMPackage_Association()
   * @see de.genesez.metamodel.gcore.MAssociation#getOwningPackage
   * @model type="de.genesez.metamodel.gcore.MAssociation" opposite="owningPackage" containment="true"
   * @generated
   */
  EList getAssociation();

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MClassifier}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MClassifier#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMPackage_Classifier()
   * @see de.genesez.metamodel.gcore.MClassifier#getOwningPackage
   * @model type="de.genesez.metamodel.gcore.MClassifier" opposite="owningPackage" containment="true"
   * @generated
   */
  EList getClassifier();

} // MPackage
