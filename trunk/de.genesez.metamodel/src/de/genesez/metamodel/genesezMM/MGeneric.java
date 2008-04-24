/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MGeneric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getOwningClassifier <em>Owning Classifier</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getOwningOperation <em>Owning Operation</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getOwningProperty <em>Owning Property</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getOwningParameter <em>Owning Parameter</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MGeneric#getOwningExternal <em>Owning External</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric()
 * @model
 * @generated
 */
public interface MGeneric extends MType
{
  /**
   * Returns the value of the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specification</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specification</em>' attribute.
   * @see #setSpecification(String)
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_Specification()
   * @model required="true"
   * @generated
   */
  String getSpecification();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MGeneric#getSpecification <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specification</em>' attribute.
   * @see #getSpecification()
   * @generated
   */
  void setSpecification(String value);

  /**
   * Returns the value of the '<em><b>Owning Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MClassifier#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Classifier</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_OwningClassifier()
   * @see de.genesez.metamodel.genesezMM.MClassifier#getGenericParameter
   * @model opposite="genericParameter" required="true" transient="false" changeable="false"
   * @generated
   */
  MClassifier getOwningClassifier();

  /**
   * Returns the value of the '<em><b>Owning Operation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MOperation#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Operation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Operation</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_OwningOperation()
   * @see de.genesez.metamodel.genesezMM.MOperation#getGenericParameter
   * @model opposite="genericParameter" required="true" transient="false" changeable="false"
   * @generated
   */
  MOperation getOwningOperation();

  /**
   * Returns the value of the '<em><b>Owning Property</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MProperty#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Property</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Property</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_OwningProperty()
   * @see de.genesez.metamodel.genesezMM.MProperty#getGenericRealization
   * @model opposite="genericRealization" required="true" transient="false" changeable="false"
   * @generated
   */
  MProperty getOwningProperty();

  /**
   * Returns the value of the '<em><b>Owning Parameter</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MParameter#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Parameter</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Parameter</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_OwningParameter()
   * @see de.genesez.metamodel.genesezMM.MParameter#getGenericRealization
   * @model opposite="genericRealization" required="true" transient="false" changeable="false"
   * @generated
   */
  MParameter getOwningParameter();

  /**
   * Returns the value of the '<em><b>Owning External</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.genesezMM.MExternal#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning External</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning External</em>' container reference.
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMGeneric_OwningExternal()
   * @see de.genesez.metamodel.genesezMM.MExternal#getGenericParameter
   * @model opposite="genericParameter" required="true" transient="false" changeable="false"
   * @generated
   */
  MExternal getOwningExternal();

} // MGeneric
