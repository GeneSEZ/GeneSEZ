/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MTagged Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MTaggedValue#getValue <em>Value</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MTaggedValue#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MTaggedValue#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMTaggedValue()
 * @model
 * @generated
 */
public interface MTaggedValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMTaggedValue_Value()
   * @model required="true"
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MTaggedValue#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Owning Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MElement#getTaggedValue <em>Tagged Value</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Element</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMTaggedValue_OwningElement()
   * @see de.genesez.metamodel.gcore.MElement#getTaggedValue
   * @model opposite="taggedValue" required="true" transient="false" changeable="false"
   * @generated
   */
  MElement getOwningElement();

  /**
   * Returns the value of the '<em><b>Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' reference.
   * @see #setTag(MTag)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMTaggedValue_Tag()
   * @model required="true"
   * @generated
   */
  MTag getTag();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MTaggedValue#getTag <em>Tag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' reference.
   * @see #getTag()
   * @generated
   */
  void setTag(MTag value);

} // MTaggedValue
