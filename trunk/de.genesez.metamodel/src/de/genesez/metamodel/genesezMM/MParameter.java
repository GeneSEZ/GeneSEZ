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
 * A representation of the model object '<em><b>MParameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MParameter#getDefaultvalue <em>Defaultvalue</em>}</li>
 *   <li>{@link genesezMM.MParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link genesezMM.MParameter#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link genesezMM.MParameter#isUnique <em>Unique</em>}</li>
 *   <li>{@link genesezMM.MParameter#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link genesezMM.MParameter#getOperation <em>Operation</em>}</li>
 *   <li>{@link genesezMM.MParameter#getGenericRealization <em>Generic Realization</em>}</li>
 *   <li>{@link genesezMM.MParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMParameter()
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
   * @see genesezMM.GenesezMMPackage#getMParameter_Defaultvalue()
   * @model required="true"
   * @generated
   */
  String getDefaultvalue();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#getDefaultvalue <em>Defaultvalue</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMParameter_Direction()
   * @model required="true"
   * @generated
   */
  String getDirection();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see #getDirection()
   * @generated
   */
  void setDirection(String value);

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
   * @see genesezMM.GenesezMMPackage#getMParameter_Multiplicity()
   * @model required="true"
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#getMultiplicity <em>Multiplicity</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMParameter_Unique()
   * @model required="true"
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#isUnique <em>Unique</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMParameter_Ordered()
   * @model required="true"
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MOperation#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMParameter_Operation()
   * @see genesezMM.MOperation#getParameter
   * @model opposite="parameter" required="true" transient="false" changeable="false"
   * @generated
   */
  MOperation getOperation();

  /**
   * Returns the value of the '<em><b>Generic Realization</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MGeneric}.
   * It is bidirectional and its opposite is '{@link genesezMM.MGeneric#getOwningParameter <em>Owning Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Realization</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Realization</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMParameter_GenericRealization()
   * @see genesezMM.MGeneric#getOwningParameter
   * @model type="genesezMM.MGeneric" opposite="owningParameter" containment="true"
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
   * @see genesezMM.GenesezMMPackage#getMParameter_Type()
   * @model required="true"
   * @generated
   */
  MType getType();

  /**
   * Sets the value of the '{@link genesezMM.MParameter#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(MType value);

} // MParameter
