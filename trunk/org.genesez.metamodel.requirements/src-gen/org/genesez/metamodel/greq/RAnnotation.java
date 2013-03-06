/**
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines a particular model extension, similar to an UML stereotype.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RAnnotation#getUri <em>Uri</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RAnnotation#getTag <em>Tag</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RAnnotation#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRAnnotation()
 * @model
 * @generated
 */
public interface RAnnotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Provides a unique identifier for this model extension.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Uri</em>' attribute.
   * @see #setUri(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRAnnotation_Uri()
   * @model required="true"
   * @generated
   */
  String getUri();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RAnnotation#getUri <em>Uri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uri</em>' attribute.
   * @see #getUri()
   * @generated
   */
  void setUri(String value);

  /**
   * Returns the value of the '<em><b>Tag</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RTag}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RTag#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of <b><i>tags</i></b>.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Tag</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRAnnotation_Tag()
   * @see org.genesez.metamodel.greq.RTag#getAnnotation
   * @model opposite="annotation" containment="true"
   * @generated
   */
  EList<RTag> getTag();

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RModel#getExtension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Reference to the requirement model element.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRAnnotation_Model()
   * @see org.genesez.metamodel.greq.RModel#getExtension
   * @model opposite="extension" required="true" transient="false" changeable="false"
   * @generated
   */
  RModel getModel();

} // RAnnotation
