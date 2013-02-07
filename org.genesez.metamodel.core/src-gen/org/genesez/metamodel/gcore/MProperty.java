/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MProperty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty()
 * @model abstract="true"
 * @generated
 */
public interface MProperty extends MElement
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MProperty#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(String value);

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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_Derived()
   * @model required="true"
   * @generated
   */
  boolean isDerived();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MProperty#isDerived <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived</em>' attribute.
   * @see #isDerived()
   * @generated
   */
  void setDerived(boolean value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(MMultiplicity)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_Multiplicity()
   * @model required="true"
   * @generated
   */
  MMultiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MProperty#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(MMultiplicity value);

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClassifier#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_Classifier()
   * @see org.genesez.metamodel.gcore.MClassifier#getProperty
   * @model opposite="property" required="true" transient="false" changeable="false"
   * @generated
   */
  MClassifier getClassifier();

  /**
   * Returns the value of the '<em><b>Generic Realization</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGeneric#getOwningProperty <em>Owning Property</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Realization</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Realization</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_GenericRealization()
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningProperty
   * @model opposite="owningProperty" containment="true"
   * @generated
   */
  EList<MGeneric> getGenericRealization();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(MType)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMProperty_Type()
   * @model required="true"
   * @generated
   */
  MType getType();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MProperty#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(MType value);

} // MProperty
