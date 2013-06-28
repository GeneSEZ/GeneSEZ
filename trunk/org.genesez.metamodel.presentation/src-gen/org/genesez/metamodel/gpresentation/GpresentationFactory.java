/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage
 * @generated
 */
public interface GpresentationFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GpresentationFactory eINSTANCE = org.genesez.metamodel.gpresentation.impl.GpresentationFactoryImpl.init();

  /**
   * Returns a new object of class '<em>PRoot</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PRoot</em>'.
   * @generated
   */
  PRoot createPRoot();

  /**
   * Returns a new object of class '<em>PComposite Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PComposite Area</em>'.
   * @generated
   */
  PCompositeArea createPCompositeArea();

  /**
   * Returns a new object of class '<em>PUser Defined Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PUser Defined Area</em>'.
   * @generated
   */
  PUserDefinedArea createPUserDefinedArea();

  /**
   * Returns a new object of class '<em>PAutomatically Generated Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAutomatically Generated Area</em>'.
   * @generated
   */
  PAutomaticallyGeneratedArea createPAutomaticallyGeneratedArea();

  /**
   * Returns a new object of class '<em>PInput</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PInput</em>'.
   * @generated
   */
  PInput createPInput();

  /**
   * Returns a new object of class '<em>POutput</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>POutput</em>'.
   * @generated
   */
  POutput createPOutput();

  /**
   * Returns a new object of class '<em>PAction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PAction</em>'.
   * @generated
   */
  PAction createPAction();

  /**
   * Returns a new object of class '<em>PMeta Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PMeta Data</em>'.
   * @generated
   */
  PMetaData createPMetaData();

  /**
   * Returns a new object of class '<em>PReference Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PReference Area</em>'.
   * @generated
   */
  PReferenceArea createPReferenceArea();

  /**
   * Returns a new object of class '<em>PElement Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PElement Area</em>'.
   * @generated
   */
  PElementArea createPElementArea();

  /**
   * Returns a new object of class '<em>PPackage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PPackage</em>'.
   * @generated
   */
  PPackage createPPackage();

  /**
   * Returns a new object of class '<em>PKey</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PKey</em>'.
   * @generated
   */
  PKey createPKey();

  /**
   * Returns a new object of class '<em>PValue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PValue</em>'.
   * @generated
   */
  PValue createPValue();

  /**
   * Returns a new object of class '<em>PComposite Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PComposite Element</em>'.
   * @generated
   */
  PCompositeElement createPCompositeElement();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GpresentationPackage getGpresentationPackage();

} //GpresentationFactory
