/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.genesez.metamodel.gtrace.GtracePackage
 * @generated
 */
public interface GtraceFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GtraceFactory eINSTANCE = de.genesez.metamodel.gtrace.impl.GtraceFactoryImpl.init();

  /**
   * Returns a new object of class '<em>TTrace Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TTrace Model</em>'.
   * @generated
   */
  TTraceModel createTTraceModel();

  /**
   * Returns a new object of class '<em>TRequirement Trace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TRequirement Trace</em>'.
   * @generated
   */
  TRequirementTrace createTRequirementTrace();

  /**
   * Returns a new object of class '<em>TScenario Trace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TScenario Trace</em>'.
   * @generated
   */
  TScenarioTrace createTScenarioTrace();

  /**
   * Returns a new object of class '<em>TScenario Step Trace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TScenario Step Trace</em>'.
   * @generated
   */
  TScenarioStepTrace createTScenarioStepTrace();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GtracePackage getGtracePackage();

} //GtraceFactory
