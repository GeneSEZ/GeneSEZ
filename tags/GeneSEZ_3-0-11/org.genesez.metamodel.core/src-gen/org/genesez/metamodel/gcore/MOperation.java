/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#isStatic <em>Static</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#isFinal <em>Final</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getRaisedException <em>Raised Exception</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MOperation#getReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation()
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Visibility()
   * @model required="true"
   * @generated
   */
  String getVisibility();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MOperation#getVisibility <em>Visibility</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Static()
   * @model required="true"
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MOperation#isStatic <em>Static</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MOperation#isAbstract <em>Abstract</em>}' attribute.
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
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Final()
   * @model required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MOperation#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Parameter()
   * @model containment="true"
   * @generated
   */
  EList<MParameter> getParameter();

  /**
   * Returns the value of the '<em><b>Classifier</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClassifier#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Classifier()
   * @see org.genesez.metamodel.gcore.MClassifier#getOperation
   * @model opposite="operation" required="true" transient="false" changeable="false"
   * @generated
   */
  MClassifier getClassifier();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGeneric#getOwningOperation <em>Owning Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_GenericParameter()
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningOperation
   * @model opposite="owningOperation" containment="true"
   * @generated
   */
  EList<MGeneric> getGenericParameter();

  /**
   * Returns the value of the '<em><b>Raised Exception</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raised Exception</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_RaisedException()
   * @model
   * @generated
   */
  EList<MType> getRaisedException();

  /**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(MParameter)
   * @see org.genesez.metamodel.gcore.GcorePackage#getMOperation_Return()
   * @model containment="true"
   * @generated
   */
  MParameter getReturn();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gcore.MOperation#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
  void setReturn(MParameter value);

} // MOperation
