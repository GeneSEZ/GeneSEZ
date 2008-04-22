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
 * A representation of the model object '<em><b>MOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MOperation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link genesezMM.MOperation#isStatic <em>Static</em>}</li>
 *   <li>{@link genesezMM.MOperation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link genesezMM.MOperation#isFinal <em>Final</em>}</li>
 *   <li>{@link genesezMM.MOperation#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link genesezMM.MOperation#isUnique <em>Unique</em>}</li>
 *   <li>{@link genesezMM.MOperation#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link genesezMM.MOperation#getParameter <em>Parameter</em>}</li>
 *   <li>{@link genesezMM.MOperation#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link genesezMM.MOperation#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link genesezMM.MOperation#getRaisedException <em>Raised Exception</em>}</li>
 *   <li>{@link genesezMM.MOperation#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMOperation()
 * @model
 * @generated
 */
public interface MOperation extends MElement
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
   * @see genesezMM.GenesezMMPackage#getMOperation_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(String value);

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
   * @see genesezMM.GenesezMMPackage#getMOperation_Static()
   * @model required="true"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

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
   * @see genesezMM.GenesezMMPackage#getMOperation_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#isAbstract <em>Abstract</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMOperation_Final()
   * @model required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

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
   * @see genesezMM.GenesezMMPackage#getMOperation_Multiplicity()
   * @model required="true"
   * @generated
   */
  int getMultiplicity();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#getMultiplicity <em>Multiplicity</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMOperation_Unique()
   * @model required="true"
   * @generated
   */
  boolean isUnique();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#isUnique <em>Unique</em>}' attribute.
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
   * @see genesezMM.GenesezMMPackage#getMOperation_Ordered()
   * @model required="true"
   * @generated
   */
  boolean isOrdered();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#isOrdered <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ordered</em>' attribute.
   * @see #isOrdered()
   * @generated
   */
  void setOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MParameter}.
   * It is bidirectional and its opposite is '{@link genesezMM.MParameter#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMOperation_Parameter()
   * @see genesezMM.MParameter#getOperation
   * @model type="genesezMM.MParameter" opposite="operation" containment="true"
   * @generated
   */
  EList getParameter();

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MClassifier#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMOperation_Classifier()
   * @see genesezMM.MClassifier#getOperation
   * @model opposite="operation" required="true" transient="false" changeable="false"
   * @generated
   */
  MClassifier getClassifier();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link genesezMM.MGeneric}.
   * It is bidirectional and its opposite is '{@link genesezMM.MGeneric#getOwningOperation <em>Owning Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see genesezMM.GenesezMMPackage#getMOperation_GenericParameter()
   * @see genesezMM.MGeneric#getOwningOperation
   * @model type="genesezMM.MGeneric" opposite="owningOperation" containment="true"
   * @generated
   */
  EList getGenericParameter();

  /**
   * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
   * The list contents are of type {@link genesezMM.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raised Exception</em>' reference list.
   * @see genesezMM.GenesezMMPackage#getMOperation_RaisedException()
   * @model type="genesezMM.MType"
   * @generated
   */
  EList getRaisedException();

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' reference.
   * @see #setReturnType(MType)
   * @see genesezMM.GenesezMMPackage#getMOperation_ReturnType()
   * @model required="true"
   * @generated
   */
  MType getReturnType();

  /**
   * Sets the value of the '{@link genesezMM.MOperation#getReturnType <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(MType value);

} // MOperation
