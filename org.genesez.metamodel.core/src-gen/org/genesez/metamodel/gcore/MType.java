/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MType</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MType#getSpecialization <em>Specialization</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMType()
 * @model abstract="true"
 * @generated
 */
public interface MType extends EObject
{
  /**
   * Returns the value of the '<em><b>Specialization</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MClassifier}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MClassifier#getGeneralization <em>Generalization</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specialization</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specialization</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMType_Specialization()
   * @see org.genesez.metamodel.gcore.MClassifier#getGeneralization
   * @model opposite="generalization"
   * @generated
   */
  EList<MClassifier> getSpecialization();

} // MType
