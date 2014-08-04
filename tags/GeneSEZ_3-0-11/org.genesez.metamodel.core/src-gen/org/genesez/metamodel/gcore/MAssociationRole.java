/**
 */
package org.genesez.metamodel.gcore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAssociation Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#isAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#isComposition <em>Composition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#getOppositeMultiplicity <em>Opposite Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifierMultiplicity <em>Qualifier Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole()
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_Aggregation()
   * @model required="true"
   * @generated
   */
  boolean isAggregation();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#isAggregation <em>Aggregation</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_Composition()
   * @model required="true"
   * @generated
   */
  boolean isComposition();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#isComposition <em>Composition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Composition</em>' attribute.
   * @see #isComposition()
   * @generated
   */
  void setComposition(boolean value);

  /**
   * Returns the value of the '<em><b>Association</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MAssociation#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' reference.
   * @see #setAssociation(MAssociation)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_Association()
   * @see org.genesez.metamodel.gcore.MAssociation#getEnd
   * @model opposite="end" required="true"
   * @generated
   */
  MAssociation getAssociation();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#getAssociation <em>Association</em>}' reference.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_Opposite()
   * @model required="true"
   * @generated
   */
  MAssociationRole getOpposite();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#getOpposite <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(MAssociationRole value);

  /**
   * Returns the value of the '<em><b>Qualifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualifier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifier</em>' reference.
   * @see #setQualifier(MType)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_Qualifier()
   * @model required="true"
   * @generated
   */
  MType getQualifier();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifier <em>Qualifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualifier</em>' reference.
   * @see #getQualifier()
   * @generated
   */
  void setQualifier(MType value);

  /**
   * Returns the value of the '<em><b>Opposite Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opposite Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite Multiplicity</em>' containment reference.
   * @see #setOppositeMultiplicity(MMultiplicity)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_OppositeMultiplicity()
   * @model containment="true" required="true"
   * @generated
   */
  MMultiplicity getOppositeMultiplicity();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#getOppositeMultiplicity <em>Opposite Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite Multiplicity</em>' containment reference.
   * @see #getOppositeMultiplicity()
   * @generated
   */
  void setOppositeMultiplicity(MMultiplicity value);

  /**
   * Returns the value of the '<em><b>Qualifier Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualifier Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualifier Multiplicity</em>' containment reference.
   * @see #setQualifierMultiplicity(MMultiplicity)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMAssociationRole_QualifierMultiplicity()
   * @model containment="true" required="true"
   * @generated
   */
  MMultiplicity getQualifierMultiplicity();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifierMultiplicity <em>Qualifier Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualifier Multiplicity</em>' containment reference.
   * @see #getQualifierMultiplicity()
   * @generated
   */
  void setQualifierMultiplicity(MMultiplicity value);

} // MAssociationRole
