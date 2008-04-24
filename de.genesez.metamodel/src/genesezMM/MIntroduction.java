/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MIntroduction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link genesezMM.MIntroduction#getDomain <em>Domain</em>}</li>
 *   <li>{@link genesezMM.MIntroduction#getName <em>Name</em>}</li>
 *   <li>{@link genesezMM.MIntroduction#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @see genesezMM.GenesezMMPackage#getMIntroduction()
 * @model
 * @generated
 */
public interface MIntroduction extends EObject
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' attribute.
   * @see #setDomain(String)
   * @see genesezMM.GenesezMMPackage#getMIntroduction_Domain()
   * @model required="true"
   * @generated
   */
  String getDomain();

  /**
   * Sets the value of the '{@link genesezMM.MIntroduction#getDomain <em>Domain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' attribute.
   * @see #getDomain()
   * @generated
   */
  void setDomain(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see genesezMM.GenesezMMPackage#getMIntroduction_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link genesezMM.MIntroduction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Origin</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link genesezMM.MAspect#getIntroduction <em>Introduction</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Origin</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Origin</em>' container reference.
   * @see genesezMM.GenesezMMPackage#getMIntroduction_Origin()
   * @see genesezMM.MAspect#getIntroduction
   * @model opposite="introduction" required="true" transient="false" changeable="false"
   * @generated
   */
  MAspect getOrigin();

} // MIntroduction
