/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MParameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getDefaultvalue <em>Defaultvalue</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MParameter#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter()
 * @model
 * @generated
 */
public interface MParameter extends MElement
{
  /**
   * Returns the value of the '<em><b>Defaultvalue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Defaultvalue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Defaultvalue</em>' attribute.
   * @see #setDefaultvalue(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Defaultvalue()
   * @model required="true"
   * @generated
   */
  String getDefaultvalue();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MParameter#getDefaultvalue <em>Defaultvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defaultvalue</em>' attribute.
   * @see #getDefaultvalue()
   * @generated
   */
  void setDefaultvalue(String value);

  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see #setDirection(String)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Direction()
   * @model required="true"
   * @generated
   */
  String getDirection();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MParameter#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see #getDirection()
   * @generated
   */
  void setDirection(String value);

  /**
   * Returns the value of the '<em><b>Generic Realization</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGeneric#getOwningParameter <em>Owning Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Realization</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Realization</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_GenericRealization()
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningParameter
   * @model opposite="owningParameter" containment="true"
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Type()
   * @model required="true"
   * @generated
   */
  MType getType();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MParameter#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(MType value);

  /**
   * Returns the value of the '<em><b>Event</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MEvent#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Event()
   * @see org.genesez.metamodel.gcore.MEvent#getParameter
   * @model opposite="parameter" transient="false" changeable="false"
   * @generated
   */
  MEvent getEvent();

  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(MOperation)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Operation()
   * @model required="true"
   * @generated
   */
  MOperation getOperation();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MParameter#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(MOperation value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(MMultiplicity)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMParameter_Multiplicity()
   * @model containment="true" required="true"
   * @generated
   */
  MMultiplicity getMultiplicity();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MParameter#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(MMultiplicity value);

} // MParameter
