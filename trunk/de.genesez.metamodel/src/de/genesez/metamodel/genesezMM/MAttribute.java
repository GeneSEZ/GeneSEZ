/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAttribute#getDefaultvalue <em>Defaultvalue</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAttribute#isStatic <em>Static</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.MAttribute#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAttribute()
 * @model
 * @generated
 */
public interface MAttribute extends MProperty
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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAttribute_Defaultvalue()
   * @model required="true"
   * @generated
   */
  String getDefaultvalue();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MAttribute#getDefaultvalue <em>Defaultvalue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Defaultvalue</em>' attribute.
   * @see #getDefaultvalue()
   * @generated
   */
  void setDefaultvalue(String value);

  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(boolean)
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAttribute_Static()
   * @model required="true"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MAttribute#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

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
   * @see de.genesez.metamodel.genesezMM.GenesezMMPackage#getMAttribute_Final()
   * @model required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.genesezMM.MAttribute#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

} // MAttribute
