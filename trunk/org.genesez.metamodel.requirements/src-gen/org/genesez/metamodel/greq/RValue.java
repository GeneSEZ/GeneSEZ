/**
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RValue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents the meta data stored within a model extension, similar to values in a map or UML tagged values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RValue#getValue <em>Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RValue#getTag <em>Tag</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RValue#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRValue()
 * @model
 * @generated
 */
public interface RValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Stores the meta data information.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRValue_Value()
   * @model required="true"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * References the meta data definition.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Tag</em>' reference.
   * @see #setTag(RTag)
   * @see org.genesez.metamodel.greq.GreqPackage#getRValue_Tag()
   * @model required="true"
   * @generated
   */
  RTag getTag();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RValue#getTag <em>Tag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' reference.
   * @see #getTag()
   * @generated
   */
  void setTag(RTag value);

  /**
   * Returns the value of the '<em><b>Object</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RSpecObject#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * References the <b><i>specification object</i></b> this meta data is assigned to.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Object</em>' container reference.
   * @see org.genesez.metamodel.greq.GreqPackage#getRValue_Object()
   * @see org.genesez.metamodel.greq.RSpecObject#getValue
   * @model opposite="value" required="true" transient="false" changeable="false"
   * @generated
   */
  RSpecObject getObject();

} // RValue
