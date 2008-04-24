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
 * A representation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MPackage#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MPackage#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MPackage#getAssociation <em>Association</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MPackage#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMPackage()
 * @model
 * @generated
 */
public interface MPackage extends MElement
{
  /**
   * Returns the value of the '<em><b>Nested Package</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MPackage}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MPackage#getNestingPackage <em>Nesting Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Package</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Package</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMPackage_NestedPackage()
   * @see de.genesez.metamodel.genesezMM.MPackage#getNestingPackage
   * @model type="de.genesez.metamodel.genesezMM.MPackage" opposite="nestingPackage" containment="true"
   * @generated
   */
  EList getNestedPackage();

  /**
   * Returns the value of the '<em><b>Nesting Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MPackage#getNestedPackage <em>Nested Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nesting Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nesting Package</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMPackage_NestingPackage()
   * @see de.genesez.metamodel.genesezMM.MPackage#getNestedPackage
   * @model opposite="nestedPackage" transient="false" changeable="false"
   * @generated
   */
  MPackage getNestingPackage();

  /**
   * Returns the value of the '<em><b>Association</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MAssociation}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MAssociation#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMPackage_Association()
   * @see de.genesez.metamodel.genesezMM.MAssociation#getOwningPackage
   * @model type="de.genesez.metamodel.genesezMM.MAssociation" opposite="owningPackage" containment="true"
   * @generated
   */
  EList getAssociation();

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.genesezMM.MClassifier}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MClassifier#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' containment reference list.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMPackage_Classifier()
   * @see de.genesez.metamodel.genesezMM.MClassifier#getOwningPackage
   * @model type="de.genesez.metamodel.genesezMM.MClassifier" opposite="owningPackage" containment="true"
   * @generated
   */
  EList getClassifier();

} // MPackage
