/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package codegenMm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see codegenMm.CodegenMmFactory
 * @model kind="package"
 * @generated
 */
public interface CodegenMmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "codegenMm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.genesez.de/codegenMm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "codegenMm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CodegenMmPackage eINSTANCE = codegenMm.impl.CodegenMmPackageImpl.init();

	/**
	 * The meta object id for the '{@link codegenMm.impl.MPackageImpl <em>MPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MPackageImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMPackage()
	 * @generated
	 */
	int MPACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__CLASS = 1;

	/**
	 * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__NESTED_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__NESTING_PACKAGE = 3;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__MODEL = 4;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__ASSOCIATION = 5;

	/**
	 * The number of structural features of the '<em>MPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link codegenMm.impl.MClassImpl <em>MClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MClassImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMClass()
	 * @generated
	 */
	int MCLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Association End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCLASS__ASSOCIATION_END = 1;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCLASS__OWNING_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCLASS__ATTRIBUTE = 3;

	/**
	 * The number of structural features of the '<em>MClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCLASS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link codegenMm.impl.MAssociationEndImpl <em>MAssociation End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MAssociationEndImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMAssociationEnd()
	 * @generated
	 */
	int MASSOCIATION_END = 2;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END__MULTIPLICITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END__NAME = 1;

	/**
	 * The feature id for the '<em><b>Association</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END__ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END__CLASS = 3;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END__OPPOSITE = 4;

	/**
	 * The number of structural features of the '<em>MAssociation End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_END_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link codegenMm.impl.MAssociationImpl <em>MAssociation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MAssociationImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMAssociation()
	 * @generated
	 */
	int MASSOCIATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION__END = 1;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION__OWNING_PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>MAssociation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASSOCIATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link codegenMm.impl.MAttributeImpl <em>MAttribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MAttributeImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMAttribute()
	 * @generated
	 */
	int MATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATTRIBUTE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATTRIBUTE__VISIBILITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATTRIBUTE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATTRIBUTE__CLASS = 3;

	/**
	 * The number of structural features of the '<em>MAttribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATTRIBUTE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link codegenMm.impl.MModelImpl <em>MModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see codegenMm.impl.MModelImpl
	 * @see codegenMm.impl.CodegenMmPackageImpl#getMModel()
	 * @generated
	 */
	int MMODEL = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Owned Package</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMODEL__OWNED_PACKAGE = 1;

	/**
	 * The number of structural features of the '<em>MModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMODEL_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link codegenMm.MPackage <em>MPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPackage</em>'.
	 * @see codegenMm.MPackage
	 * @generated
	 */
	EClass getMPackage();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MPackage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MPackage#getName()
	 * @see #getMPackage()
	 * @generated
	 */
	EAttribute getMPackage_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MPackage#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class</em>'.
	 * @see codegenMm.MPackage#getClass_()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_Class();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MPackage#getNestedPackage <em>Nested Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Package</em>'.
	 * @see codegenMm.MPackage#getNestedPackage()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_NestedPackage();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MPackage#getNestingPackage <em>Nesting Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Nesting Package</em>'.
	 * @see codegenMm.MPackage#getNestingPackage()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_NestingPackage();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MPackage#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see codegenMm.MPackage#getModel()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MPackage#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Association</em>'.
	 * @see codegenMm.MPackage#getAssociation()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_Association();

	/**
	 * Returns the meta object for class '{@link codegenMm.MClass <em>MClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MClass</em>'.
	 * @see codegenMm.MClass
	 * @generated
	 */
	EClass getMClass();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MClass#getName()
	 * @see #getMClass()
	 * @generated
	 */
	EAttribute getMClass_Name();

	/**
	 * Returns the meta object for the reference list '{@link codegenMm.MClass#getAssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Association End</em>'.
	 * @see codegenMm.MClass#getAssociationEnd()
	 * @see #getMClass()
	 * @generated
	 */
	EReference getMClass_AssociationEnd();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MClass#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see codegenMm.MClass#getOwningPackage()
	 * @see #getMClass()
	 * @generated
	 */
	EReference getMClass_OwningPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MClass#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see codegenMm.MClass#getAttribute()
	 * @see #getMClass()
	 * @generated
	 */
	EReference getMClass_Attribute();

	/**
	 * Returns the meta object for class '{@link codegenMm.MAssociationEnd <em>MAssociation End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAssociation End</em>'.
	 * @see codegenMm.MAssociationEnd
	 * @generated
	 */
	EClass getMAssociationEnd();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAssociationEnd#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see codegenMm.MAssociationEnd#getMultiplicity()
	 * @see #getMAssociationEnd()
	 * @generated
	 */
	EAttribute getMAssociationEnd_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAssociationEnd#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MAssociationEnd#getName()
	 * @see #getMAssociationEnd()
	 * @generated
	 */
	EAttribute getMAssociationEnd_Name();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MAssociationEnd#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Association</em>'.
	 * @see codegenMm.MAssociationEnd#getAssociation()
	 * @see #getMAssociationEnd()
	 * @generated
	 */
	EReference getMAssociationEnd_Association();

	/**
	 * Returns the meta object for the reference '{@link codegenMm.MAssociationEnd#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see codegenMm.MAssociationEnd#getClass_()
	 * @see #getMAssociationEnd()
	 * @generated
	 */
	EReference getMAssociationEnd_Class();

	/**
	 * Returns the meta object for the reference '{@link codegenMm.MAssociationEnd#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see codegenMm.MAssociationEnd#getOpposite()
	 * @see #getMAssociationEnd()
	 * @generated
	 */
	EReference getMAssociationEnd_Opposite();

	/**
	 * Returns the meta object for class '{@link codegenMm.MAssociation <em>MAssociation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAssociation</em>'.
	 * @see codegenMm.MAssociation
	 * @generated
	 */
	EClass getMAssociation();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAssociation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MAssociation#getName()
	 * @see #getMAssociation()
	 * @generated
	 */
	EAttribute getMAssociation_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MAssociation#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End</em>'.
	 * @see codegenMm.MAssociation#getEnd()
	 * @see #getMAssociation()
	 * @generated
	 */
	EReference getMAssociation_End();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MAssociation#getOwningPackage <em>Owning Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Package</em>'.
	 * @see codegenMm.MAssociation#getOwningPackage()
	 * @see #getMAssociation()
	 * @generated
	 */
	EReference getMAssociation_OwningPackage();

	/**
	 * Returns the meta object for class '{@link codegenMm.MAttribute <em>MAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAttribute</em>'.
	 * @see codegenMm.MAttribute
	 * @generated
	 */
	EClass getMAttribute();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAttribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see codegenMm.MAttribute#getType()
	 * @see #getMAttribute()
	 * @generated
	 */
	EAttribute getMAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAttribute#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see codegenMm.MAttribute#getVisibility()
	 * @see #getMAttribute()
	 * @generated
	 */
	EAttribute getMAttribute_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MAttribute#getName()
	 * @see #getMAttribute()
	 * @generated
	 */
	EAttribute getMAttribute_Name();

	/**
	 * Returns the meta object for the container reference '{@link codegenMm.MAttribute#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see codegenMm.MAttribute#getClass_()
	 * @see #getMAttribute()
	 * @generated
	 */
	EReference getMAttribute_Class();

	/**
	 * Returns the meta object for class '{@link codegenMm.MModel <em>MModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MModel</em>'.
	 * @see codegenMm.MModel
	 * @generated
	 */
	EClass getMModel();

	/**
	 * Returns the meta object for the attribute '{@link codegenMm.MModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see codegenMm.MModel#getName()
	 * @see #getMModel()
	 * @generated
	 */
	EAttribute getMModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link codegenMm.MModel#getOwnedPackage <em>Owned Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Package</em>'.
	 * @see codegenMm.MModel#getOwnedPackage()
	 * @see #getMModel()
	 * @generated
	 */
	EReference getMModel_OwnedPackage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CodegenMmFactory getCodegenMmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link codegenMm.impl.MPackageImpl <em>MPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MPackageImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMPackage()
		 * @generated
		 */
		EClass MPACKAGE = eINSTANCE.getMPackage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MPACKAGE__NAME = eINSTANCE.getMPackage_Name();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__CLASS = eINSTANCE.getMPackage_Class();

		/**
		 * The meta object literal for the '<em><b>Nested Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__NESTED_PACKAGE = eINSTANCE.getMPackage_NestedPackage();

		/**
		 * The meta object literal for the '<em><b>Nesting Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__NESTING_PACKAGE = eINSTANCE.getMPackage_NestingPackage();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__MODEL = eINSTANCE.getMPackage_Model();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__ASSOCIATION = eINSTANCE.getMPackage_Association();

		/**
		 * The meta object literal for the '{@link codegenMm.impl.MClassImpl <em>MClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MClassImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMClass()
		 * @generated
		 */
		EClass MCLASS = eINSTANCE.getMClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MCLASS__NAME = eINSTANCE.getMClass_Name();

		/**
		 * The meta object literal for the '<em><b>Association End</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCLASS__ASSOCIATION_END = eINSTANCE.getMClass_AssociationEnd();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCLASS__OWNING_PACKAGE = eINSTANCE.getMClass_OwningPackage();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCLASS__ATTRIBUTE = eINSTANCE.getMClass_Attribute();

		/**
		 * The meta object literal for the '{@link codegenMm.impl.MAssociationEndImpl <em>MAssociation End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MAssociationEndImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMAssociationEnd()
		 * @generated
		 */
		EClass MASSOCIATION_END = eINSTANCE.getMAssociationEnd();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASSOCIATION_END__MULTIPLICITY = eINSTANCE.getMAssociationEnd_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASSOCIATION_END__NAME = eINSTANCE.getMAssociationEnd_Name();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASSOCIATION_END__ASSOCIATION = eINSTANCE.getMAssociationEnd_Association();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASSOCIATION_END__CLASS = eINSTANCE.getMAssociationEnd_Class();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASSOCIATION_END__OPPOSITE = eINSTANCE.getMAssociationEnd_Opposite();

		/**
		 * The meta object literal for the '{@link codegenMm.impl.MAssociationImpl <em>MAssociation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MAssociationImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMAssociation()
		 * @generated
		 */
		EClass MASSOCIATION = eINSTANCE.getMAssociation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASSOCIATION__NAME = eINSTANCE.getMAssociation_Name();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASSOCIATION__END = eINSTANCE.getMAssociation_End();

		/**
		 * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASSOCIATION__OWNING_PACKAGE = eINSTANCE.getMAssociation_OwningPackage();

		/**
		 * The meta object literal for the '{@link codegenMm.impl.MAttributeImpl <em>MAttribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MAttributeImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMAttribute()
		 * @generated
		 */
		EClass MATTRIBUTE = eINSTANCE.getMAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATTRIBUTE__TYPE = eINSTANCE.getMAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATTRIBUTE__VISIBILITY = eINSTANCE.getMAttribute_Visibility();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATTRIBUTE__NAME = eINSTANCE.getMAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATTRIBUTE__CLASS = eINSTANCE.getMAttribute_Class();

		/**
		 * The meta object literal for the '{@link codegenMm.impl.MModelImpl <em>MModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see codegenMm.impl.MModelImpl
		 * @see codegenMm.impl.CodegenMmPackageImpl#getMModel()
		 * @generated
		 */
		EClass MMODEL = eINSTANCE.getMModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMODEL__NAME = eINSTANCE.getMModel_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Package</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MMODEL__OWNED_PACKAGE = eINSTANCE.getMModel_OwnedPackage();

	}

} //CodegenMmPackage
