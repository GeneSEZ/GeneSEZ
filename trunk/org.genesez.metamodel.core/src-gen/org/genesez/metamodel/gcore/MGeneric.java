/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MGeneric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getOwningClassifier <em>Owning Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getOwningOperation <em>Owning Operation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getOwningProperty <em>Owning Property</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getOwningParameter <em>Owning Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MGeneric#getOwningExternal <em>Owning External</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric()
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_Specification()
   * @model required="true"
   * @generated
   */
  String getSpecification();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MGeneric#getSpecification <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specification</em>' attribute.
   * @see #getSpecification()
   * @generated
   */
  void setSpecification(String value);

  /**
   * Returns the value of the '<em><b>Owning Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClassifier#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Classifier</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_OwningClassifier()
   * @see org.genesez.metamodel.gcore.MClassifier#getGenericParameter
   * @model opposite="genericParameter" transient="false" changeable="false"
   * @generated
   */
  MClassifier getOwningClassifier();

  /**
   * Returns the value of the '<em><b>Owning Operation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MOperation#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Operation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Operation</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_OwningOperation()
   * @see org.genesez.metamodel.gcore.MOperation#getGenericParameter
   * @model opposite="genericParameter" transient="false" changeable="false"
   * @generated
   */
  MOperation getOwningOperation();

  /**
   * Returns the value of the '<em><b>Owning Property</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MProperty#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Property</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Property</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_OwningProperty()
   * @see org.genesez.metamodel.gcore.MProperty#getGenericRealization
   * @model opposite="genericRealization" transient="false" changeable="false"
   * @generated
   */
  MProperty getOwningProperty();

  /**
   * Returns the value of the '<em><b>Owning Parameter</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MParameter#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Parameter</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Parameter</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_OwningParameter()
   * @see org.genesez.metamodel.gcore.MParameter#getGenericRealization
   * @model opposite="genericRealization" transient="false" changeable="false"
   * @generated
   */
  MParameter getOwningParameter();

  /**
   * Returns the value of the '<em><b>Owning External</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MExternal#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning External</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning External</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMGeneric_OwningExternal()
   * @see org.genesez.metamodel.gcore.MExternal#getGenericParameter
   * @model opposite="genericParameter" transient="false" changeable="false"
   * @generated
   */
  MExternal getOwningExternal();

} // MGeneric
