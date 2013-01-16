/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RModel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents the entire requirements model, i.e. the root element of the model tree.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RModel#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RModel#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RModel#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RModel#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRModel()
 * @model
 * @generated
 */
public interface RModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name of the requirements model, usually the same name as the project the requirements contained by the model are used for.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRModel_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Requirement</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RRequirement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RRequirement#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of all requirements within the model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Requirement</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRModel_Requirement()
   * @see org.genesez.metamodel.greq.RRequirement#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<RRequirement> getRequirement();

  /**
   * Returns the value of the '<em><b>Scenario</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RScenario}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RScenario#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of all scenarios within the model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Scenario</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRModel_Scenario()
   * @see org.genesez.metamodel.greq.RScenario#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<RScenario> getScenario();

  /**
   * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RAnnotation}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RAnnotation#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of all annotations defined for this model.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Extension</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRModel_Extension()
   * @see org.genesez.metamodel.greq.RAnnotation#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  EList<RAnnotation> getExtension();

} // RModel
