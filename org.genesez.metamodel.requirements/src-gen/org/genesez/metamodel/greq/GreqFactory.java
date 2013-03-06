/**
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.greq.GreqPackage
 * @generated
 */
public interface GreqFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GreqFactory eINSTANCE = org.genesez.metamodel.greq.impl.GreqFactoryImpl.init();

  /**
   * Returns a new object of class '<em>RModel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RModel</em>'.
   * @generated
   */
  RModel createRModel();

  /**
   * Returns a new object of class '<em>RRequirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RRequirement</em>'.
   * @generated
   */
  RRequirement createRRequirement();

  /**
   * Returns a new object of class '<em>RScenario</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RScenario</em>'.
   * @generated
   */
  RScenario createRScenario();

  /**
   * Returns a new object of class '<em>RScenario Step</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RScenario Step</em>'.
   * @generated
   */
  RScenarioStep createRScenarioStep();

  /**
   * Returns a new object of class '<em>RAnnotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RAnnotation</em>'.
   * @generated
   */
  RAnnotation createRAnnotation();

  /**
   * Returns a new object of class '<em>RTag</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RTag</em>'.
   * @generated
   */
  RTag createRTag();

  /**
   * Returns a new object of class '<em>RValue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>RValue</em>'.
   * @generated
   */
  RValue createRValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GreqPackage getGreqPackage();

} //GreqFactory
