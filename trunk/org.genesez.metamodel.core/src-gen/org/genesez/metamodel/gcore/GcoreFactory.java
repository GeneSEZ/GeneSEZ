/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gcore.GcorePackage
 * @generated
 */
public interface GcoreFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GcoreFactory eINSTANCE = org.genesez.metamodel.gcore.impl.GcoreFactoryImpl.init();

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
   * Returns a new object of class '<em>MActivity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MActivity</em>'.
   * @generated
   */
  MActivity createMActivity();

  /**
   * Returns a new object of class '<em>MAction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAction</em>'.
   * @generated
   */
  MAction createMAction();

  /**
   * Returns a new object of class '<em>MState Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MState Machine</em>'.
   * @generated
   */
  MStateMachine createMStateMachine();

  /**
   * Returns a new object of class '<em>MFlow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MFlow</em>'.
   * @generated
   */
  MFlow createMFlow();

  /**
   * Returns a new object of class '<em>MNode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MNode</em>'.
   * @generated
   */
  MNode createMNode();

  /**
   * Returns a new object of class '<em>MGuard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MGuard</em>'.
   * @generated
   */
  MGuard createMGuard();

  /**
   * Returns a new object of class '<em>MUse Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MUse Case</em>'.
   * @generated
   */
  MUseCase createMUseCase();

  /**
   * Returns a new object of class '<em>MInitial</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MInitial</em>'.
   * @generated
   */
  MInitial createMInitial();

  /**
   * Returns a new object of class '<em>MFinal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MFinal</em>'.
   * @generated
   */
  MFinal createMFinal();

  /**
   * Returns a new object of class '<em>MState</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MState</em>'.
   * @generated
   */
  MState createMState();

  /**
   * Returns a new object of class '<em>MTransition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MTransition</em>'.
   * @generated
   */
  MTransition createMTransition();

  /**
   * Returns a new object of class '<em>MEvent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MEvent</em>'.
   * @generated
   */
  MEvent createMEvent();

  /**
   * Returns a new object of class '<em>MAtomic Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MAtomic Transition</em>'.
   * @generated
   */
  MAtomicTransition createMAtomicTransition();

  /**
   * Returns a new object of class '<em>MLeaf State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MLeaf State</em>'.
   * @generated
   */
  MLeafState createMLeafState();

  /**
   * Returns a new object of class '<em>MComposite State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MComposite State</em>'.
   * @generated
   */
  MCompositeState createMCompositeState();

  /**
   * Returns a new object of class '<em>MInitial State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MInitial State</em>'.
   * @generated
   */
  MInitialState createMInitialState();

  /**
   * Returns a new object of class '<em>MFinal State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MFinal State</em>'.
   * @generated
   */
  MFinalState createMFinalState();

  /**
   * Returns a new object of class '<em>MHistory State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MHistory State</em>'.
   * @generated
   */
  MHistoryState createMHistoryState();

  /**
   * Returns a new object of class '<em>MTime Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>MTime Event</em>'.
   * @generated
   */
  MTimeEvent createMTimeEvent();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GcorePackage getGcorePackage();

} //GcoreFactory
