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
 * A representation of the model object '<em><b>MClassifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#isFinal <em>Final</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getProperty <em>Property</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getRealization <em>Realization</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MClassifier#getSupplier <em>Supplier</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier()
 * @model abstract="true"
 * @generated
 */
public interface MClassifier extends MElement, MType
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see #setVisibility(String)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MClassifier#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(String value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MClassifier#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Final()
   * @model required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MClassifier#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MPackage#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Package</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_OwningPackage()
   * @see de.genesez.metamodel.gcore.MPackage#getClassifier
   * @model opposite="classifier" required="true" transient="false" changeable="false"
   * @generated
   */
  MPackage getOwningPackage();

  /**
   * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MOperation}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MOperation#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Operation()
   * @see de.genesez.metamodel.gcore.MOperation#getClassifier
   * @model type="de.genesez.metamodel.gcore.MOperation" opposite="classifier" containment="true"
   * @generated
   */
  EList getOperation();

  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MProperty}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MProperty#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Property()
   * @see de.genesez.metamodel.gcore.MProperty#getClassifier
   * @model type="de.genesez.metamodel.gcore.MProperty" opposite="classifier" containment="true"
   * @generated
   */
  EList getProperty();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MGeneric#getOwningClassifier <em>Owning Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_GenericParameter()
   * @see de.genesez.metamodel.gcore.MGeneric#getOwningClassifier
   * @model type="de.genesez.metamodel.gcore.MGeneric" opposite="owningClassifier" containment="true"
   * @generated
   */
  EList getGenericParameter();

  /**
   * Returns the value of the '<em><b>Supertype</b></em>' reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supertype</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supertype</em>' reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Supertype()
   * @model type="de.genesez.metamodel.gcore.MType"
   * @generated
   */
  EList getSupertype();

  /**
   * Returns the value of the '<em><b>Realization</b></em>' reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Realization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realization</em>' reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Realization()
   * @model type="de.genesez.metamodel.gcore.MType"
   * @generated
   */
  EList getRealization();

  /**
   * Returns the value of the '<em><b>Generalization</b></em>' reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generalization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generalization</em>' reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Generalization()
   * @model type="de.genesez.metamodel.gcore.MType"
   * @generated
   */
  EList getGeneralization();

  /**
   * Returns the value of the '<em><b>Supplier</b></em>' reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supplier</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supplier</em>' reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMClassifier_Supplier()
   * @model type="de.genesez.metamodel.gcore.MType"
   * @generated
   */
  EList getSupplier();

} // MClassifier
