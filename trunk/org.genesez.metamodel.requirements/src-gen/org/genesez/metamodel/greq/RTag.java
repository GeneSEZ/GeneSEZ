/**
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RTag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A <pre>tag</pre> represents a named definition of some meta data, like a key in a map or a tag of an UML stereotype.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RTag#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RTag#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RTag#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRTag()
 * @model
 * @generated
 */
public interface RTag extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A description for the meta data the <pre>tag</pre> identifies.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRTag_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RTag#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Optionally identifies the type of the meta data the <pre>tag</pre> identifies.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRTag_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RTag#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Annotation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RAnnotation#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * References the model extension defining the <pre>tag</pre>.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Annotation</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRTag_Annotation()
   * @see org.genesez.metamodel.greq.RAnnotation#getTag
   * @model opposite="tag" required="true" transient="false" changeable="false"
   * @generated
   */
  RAnnotation getAnnotation();

} // RTag
