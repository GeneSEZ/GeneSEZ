/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.genesez.metamodel.genesezMM.GenesezMMPackage
 * @generated
 */
public interface GenesezMMFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GenesezMMFactory eINSTANCE = de.genesez.metamodel.genesezMM.impl.GenesezMMFactoryImpl.init();

  /**
   * Returns a new object of class '<em>MPackage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MPackage</em>'.
   * @generated
   */
  MPackage createMPackage();

  /**
   * Returns a new object of class '<em>MClass</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MClass</em>'.
   * @generated
   */
  MClass createMClass();

  /**
   * Returns a new object of class '<em>MAssociation Role</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAssociation Role</em>'.
   * @generated
   */
  MAssociationRole createMAssociationRole();

  /**
   * Returns a new object of class '<em>MAssociation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAssociation</em>'.
   * @generated
   */
  MAssociation createMAssociation();

  /**
   * Returns a new object of class '<em>MAttribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAttribute</em>'.
   * @generated
   */
  MAttribute createMAttribute();

  /**
   * Returns a new object of class '<em>MModel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MModel</em>'.
   * @generated
   */
  MModel createMModel();

  /**
   * Returns a new object of class '<em>MProperty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MProperty</em>'.
   * @generated
   */
  MProperty createMProperty();

  /**
   * Returns a new object of class '<em>MInterface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MInterface</em>'.
   * @generated
   */
  MInterface createMInterface();

  /**
   * Returns a new object of class '<em>MOperation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MOperation</em>'.
   * @generated
   */
  MOperation createMOperation();

  /**
   * Returns a new object of class '<em>MParameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MParameter</em>'.
   * @generated
   */
  MParameter createMParameter();

  /**
   * Returns a new object of class '<em>MData Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MData Type</em>'.
   * @generated
   */
  MDataType createMDataType();

  /**
   * Returns a new object of class '<em>MPrimitive Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MPrimitive Type</em>'.
   * @generated
   */
  MPrimitiveType createMPrimitiveType();

  /**
   * Returns a new object of class '<em>MEnumeration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MEnumeration</em>'.
   * @generated
   */
  MEnumeration createMEnumeration();

  /**
   * Returns a new object of class '<em>MStereotype</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MStereotype</em>'.
   * @generated
   */
  MStereotype createMStereotype();

  /**
   * Returns a new object of class '<em>MTag</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MTag</em>'.
   * @generated
   */
  MTag createMTag();

  /**
   * Returns a new object of class '<em>MComment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MComment</em>'.
   * @generated
   */
  MComment createMComment();

  /**
   * Returns a new object of class '<em>MTagged Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MTagged Value</em>'.
   * @generated
   */
  MTaggedValue createMTaggedValue();

  /**
   * Returns a new object of class '<em>MAspect</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAspect</em>'.
   * @generated
   */
  MAspect createMAspect();

  /**
   * Returns a new object of class '<em>MIntroduction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MIntroduction</em>'.
   * @generated
   */
  MIntroduction createMIntroduction();

  /**
   * Returns a new object of class '<em>MPointcut</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MPointcut</em>'.
   * @generated
   */
  MPointcut createMPointcut();

  /**
   * Returns a new object of class '<em>MLiteral</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MLiteral</em>'.
   * @generated
   */
  MLiteral createMLiteral();

  /**
   * Returns a new object of class '<em>MGeneric</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MGeneric</em>'.
   * @generated
   */
  MGeneric createMGeneric();

  /**
   * Returns a new object of class '<em>MExternal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MExternal</em>'.
   * @generated
   */
  MExternal createMExternal();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GenesezMMPackage getGenesezMMPackage();

} //GenesezMMFactory
