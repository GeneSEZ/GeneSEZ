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
 * A representation of the model object '<em><b>MProperty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MProperty#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link genesezMM.MProperty#isDerived <em>Derived</em>}</li>
 *   <li>{@link genesezMM.MProperty#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link genesezMM.MProperty#isUnique <em>Unique</em>}</li>
 *   <li>{@link genesezMM.MProperty#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link genesezMM.MProperty#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link genesezMM.MProperty#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link genesezMM.MProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMProperty()
 * @model
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
   * @see genesezMM.GenesezMMPackage#getMProperty_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#getVisibility <em>Visibility</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMProperty_Derived()
   * @model required="true"
   * @generated
   */
  boolean isDerived();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#isDerived <em>Derived</em>}' attribute.
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
   * @see #setMultiplicity(int)
   * @see genesezMM.GenesezMMPackage#getMProperty_Multiplicity()
   * @model required="true"
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(int value);

  /**
   * Returns the value of the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique</em>' attribute.
   * @see #setUnique(boolean)
   * @see genesezMM.GenesezMMPackage#getMProperty_Unique()
   * @model required="true"
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#isUnique <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique</em>' attribute.
   * @see #isUnique()
   * @generated
   */
  void setUnique(boolean value);

  /**
   * Returns the value of the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ordered</em>' attribute.
   * @see #setOrdered(boolean)
   * @see genesezMM.GenesezMMPackage#getMProperty_Ordered()
   * @model required="true"
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MClassifier#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMProperty_Classifier()
   * @see genesezMM.MClassifier#getProperty
   * @model opposite="property" required="true" transient="false" changeable="false"
   * @generated
   */
  MClassifier getClassifier();

  /**
   * Returns the value of the '<em><b>Generic Realization</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MGeneric}.
   * It is bidirectional and its opposite is '{@link genesezMM.MGeneric#getOwningProperty <em>Owning Property</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Realization</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Realization</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMProperty_GenericRealization()
   * @see genesezMM.MGeneric#getOwningProperty
   * @model type="genesezMM.MGeneric" opposite="owningProperty" containment="true"
   * @generated
   */
  EList getGenericRealization();

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
   * @see genesezMM.GenesezMMPackage#getMProperty_Type()
   * @model required="true"
   * @generated
   */
  MType getType();

  /**
   * Sets the value of the '{@link genesezMM.MProperty#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(MType value);

} // MProperty
