/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MClassifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#isFinal <em>Final</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getProperty <em>Property</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getRealization <em>Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MClassifier#getOwningContext <em>Owning Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier()
 * @model abstract="true"
 * @generated
 */
public interface MClassifier extends MElement, MType, MDefinitionContext
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MClassifier#getVisibility <em>Visibility</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MClassifier#isAbstract <em>Abstract</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Final()
   * @model required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MClassifier#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MOperation}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MOperation#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Operation()
   * @see org.genesez.metamodel.gcore.MOperation#getClassifier
   * @model opposite="classifier" containment="true"
   * @generated
   */
  EList<MOperation> getOperation();

  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MProperty}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MProperty#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Property()
   * @see org.genesez.metamodel.gcore.MProperty#getClassifier
   * @model opposite="classifier" containment="true"
   * @generated
   */
  EList<MProperty> getProperty();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGeneric#getOwningClassifier <em>Owning Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_GenericParameter()
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningClassifier
   * @model opposite="owningClassifier" containment="true"
   * @generated
   */
  EList<MGeneric> getGenericParameter();

  /**
   * Returns the value of the '<em><b>Realization</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Realization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Realization</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Realization()
   * @model
   * @generated
   */
  EList<MType> getRealization();

  /**
   * Returns the value of the '<em><b>Generalization</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MType}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MType#getSpecialization <em>Specialization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generalization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generalization</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Generalization()
   * @see org.genesez.metamodel.gcore.MType#getSpecialization
   * @model opposite="specialization"
   * @generated
   */
  EList<MType> getGeneralization();

  /**
   * Returns the value of the '<em><b>Supplier</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supplier</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supplier</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_Supplier()
   * @model
   * @generated
   */
  EList<MType> getSupplier();

  /**
   * Returns the value of the '<em><b>Owning Context</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MDefinitionContext#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Context</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Context</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMClassifier_OwningContext()
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getClassifier
   * @model opposite="classifier" required="true" transient="false" changeable="false"
   * @generated
   */
  MDefinitionContext getOwningContext();

} // MClassifier
