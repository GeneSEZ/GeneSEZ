/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAssociation Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MAssociationRole#isAggregation <em>Aggregation</em>}</li>
 *   <li>{@link genesezMM.MAssociationRole#isComposition <em>Composition</em>}</li>
 *   <li>{@link genesezMM.MAssociationRole#getAssociation <em>Association</em>}</li>
 *   <li>{@link genesezMM.MAssociationRole#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMAssociationRole()
 * @model
 * @generated
 */
public interface MAssociationRole extends MProperty
{
  /**
   * Returns the value of the '<em><b>Aggregation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregation</em>' attribute.
   * @see #setAggregation(boolean)
   * @see genesezMM.GenesezMMPackage#getMAssociationRole_Aggregation()
   * @model required="true"
   * @generated
   */
  boolean isAggregation();

  /**
   * Sets the value of the '{@link genesezMM.MAssociationRole#isAggregation <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregation</em>' attribute.
   * @see #isAggregation()
   * @generated
   */
  void setAggregation(boolean value);

  /**
   * Returns the value of the '<em><b>Composition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Composition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Composition</em>' attribute.
   * @see #setComposition(boolean)
   * @see genesezMM.GenesezMMPackage#getMAssociationRole_Composition()
   * @model required="true"
   * @generated
   */
  boolean isComposition();

  /**
   * Sets the value of the '{@link genesezMM.MAssociationRole#isComposition <em>Composition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Composition</em>' attribute.
   * @see #isComposition()
   * @generated
   */
  void setComposition(boolean value);

  /**
   * Returns the value of the '<em><b>Association</b></em>' reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MAssociation#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' reference.
   * @see #setAssociation(MAssociation)
   * @see genesezMM.GenesezMMPackage#getMAssociationRole_Association()
   * @see genesezMM.MAssociation#getEnd
   * @model opposite="end" required="true"
   * @generated
   */
  MAssociation getAssociation();

  /**
   * Sets the value of the '{@link genesezMM.MAssociationRole#getAssociation <em>Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association</em>' reference.
   * @see #getAssociation()
   * @generated
   */
  void setAssociation(MAssociation value);

  /**
   * Returns the value of the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' reference.
   * @see #setOpposite(MAssociationRole)
   * @see genesezMM.GenesezMMPackage#getMAssociationRole_Opposite()
   * @model required="true"
   * @generated
   */
  MAssociationRole getOpposite();

  /**
   * Sets the value of the '{@link genesezMM.MAssociationRole#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(MAssociationRole value);

} // MAssociationRole
