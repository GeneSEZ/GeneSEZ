/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see genesezMM.GenesezMMFactory
 * @model kind="package"
 * @generated
 */
public interface GenesezMMPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "genesezMM";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "platform:/plugin/de.genesez.metamodel/model-gen/genesezMM.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "genesezMM";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GenesezMMPackage eINSTANCE = genesezMM.impl.GenesezMMPackageImpl.init();

  /**
   * The meta object id for the '{@link genesezMM.impl.MElementImpl <em>MElement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MElementImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMElement()
   * @generated
   */
  int MELEMENT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__XMI_GUID = 1;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__OWNED_COMMENT = 2;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__TAGGED_VALUE = 3;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__STEREOTYPE = 4;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT__ASPECT = 5;

  /**
   * The number of structural features of the '<em>MElement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MELEMENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link genesezMM.impl.MPackageImpl <em>MPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MPackageImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMPackage()
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
  int MPACKAGE__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__NESTED_PACKAGE = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__NESTING_PACKAGE = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__ASSOCIATION = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__CLASSIFIER = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link genesezMM.impl.MClassifierImpl <em>MClassifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MClassifierImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMClassifier()
   * @generated
   */
  int MCLASSIFIER = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__VISIBILITY = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__ABSTRACT = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__FINAL = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OWNING_PACKAGE = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OPERATION = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__PROPERTY = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__GENERIC_PARAMETER = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__SUPERTYPE = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__REALIZATION = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__GENERALIZATION = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__SUPPLIER = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>MClassifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link genesezMM.impl.MClassImpl <em>MClass</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MClassImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMClass()
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
  int MCLASS__NAME = MCLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__XMI_GUID = MCLASSIFIER__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OWNED_COMMENT = MCLASSIFIER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__TAGGED_VALUE = MCLASSIFIER__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__STEREOTYPE = MCLASSIFIER__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__ASPECT = MCLASSIFIER__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__VISIBILITY = MCLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__ABSTRACT = MCLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__FINAL = MCLASSIFIER__FINAL;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OWNING_PACKAGE = MCLASSIFIER__OWNING_PACKAGE;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OPERATION = MCLASSIFIER__OPERATION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__PROPERTY = MCLASSIFIER__PROPERTY;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__GENERIC_PARAMETER = MCLASSIFIER__GENERIC_PARAMETER;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__SUPERTYPE = MCLASSIFIER__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__REALIZATION = MCLASSIFIER__REALIZATION;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__GENERALIZATION = MCLASSIFIER__GENERALIZATION;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__SUPPLIER = MCLASSIFIER__SUPPLIER;

  /**
   * The feature id for the '<em><b>Owned Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OWNED_ASSOCIATION = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>MClass</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link genesezMM.impl.MPropertyImpl <em>MProperty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MPropertyImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMProperty()
   * @generated
   */
  int MPROPERTY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__VISIBILITY = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__DERIVED = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__MULTIPLICITY = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__UNIQUE = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__ORDERED = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__CLASSIFIER = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__GENERIC_REALIZATION = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__TYPE = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>MProperty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link genesezMM.impl.MAssociationRoleImpl <em>MAssociation Role</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MAssociationRoleImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMAssociationRole()
   * @generated
   */
  int MASSOCIATION_ROLE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__NAME = MPROPERTY__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__XMI_GUID = MPROPERTY__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OWNED_COMMENT = MPROPERTY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__TAGGED_VALUE = MPROPERTY__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__STEREOTYPE = MPROPERTY__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__ASPECT = MPROPERTY__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__VISIBILITY = MPROPERTY__VISIBILITY;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__DERIVED = MPROPERTY__DERIVED;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__MULTIPLICITY = MPROPERTY__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__UNIQUE = MPROPERTY__UNIQUE;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__ORDERED = MPROPERTY__ORDERED;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__CLASSIFIER = MPROPERTY__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__GENERIC_REALIZATION = MPROPERTY__GENERIC_REALIZATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__TYPE = MPROPERTY__TYPE;

  /**
   * The feature id for the '<em><b>Aggregation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__AGGREGATION = MPROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Composition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__COMPOSITION = MPROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__ASSOCIATION = MPROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OPPOSITE = MPROPERTY_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MAssociation Role</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE_FEATURE_COUNT = MPROPERTY_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link genesezMM.impl.MAssociationImpl <em>MAssociation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MAssociationImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMAssociation()
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
  int MASSOCIATION__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__DERIVED = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__END = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__OWNING_PACKAGE = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Association Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION__ASSOCIATION_CLASS = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MAssociation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link genesezMM.impl.MAttributeImpl <em>MAttribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MAttributeImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMAttribute()
   * @generated
   */
  int MATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__NAME = MPROPERTY__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__XMI_GUID = MPROPERTY__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__OWNED_COMMENT = MPROPERTY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__TAGGED_VALUE = MPROPERTY__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__STEREOTYPE = MPROPERTY__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__ASPECT = MPROPERTY__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__VISIBILITY = MPROPERTY__VISIBILITY;

  /**
   * The feature id for the '<em><b>Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__DERIVED = MPROPERTY__DERIVED;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__MULTIPLICITY = MPROPERTY__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__UNIQUE = MPROPERTY__UNIQUE;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__ORDERED = MPROPERTY__ORDERED;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__CLASSIFIER = MPROPERTY__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__GENERIC_REALIZATION = MPROPERTY__GENERIC_REALIZATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__TYPE = MPROPERTY__TYPE;

  /**
   * The feature id for the '<em><b>Defaultvalue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__DEFAULTVALUE = MPROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__STATIC = MPROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__FINAL = MPROPERTY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MAttribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE_FEATURE_COUNT = MPROPERTY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link genesezMM.impl.MModelImpl <em>MModel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MModelImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMModel()
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
  int MMODEL__NAME = MPACKAGE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__XMI_GUID = MPACKAGE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__OWNED_COMMENT = MPACKAGE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__TAGGED_VALUE = MPACKAGE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__STEREOTYPE = MPACKAGE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__ASPECT = MPACKAGE__ASPECT;

  /**
   * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__NESTED_PACKAGE = MPACKAGE__NESTED_PACKAGE;

  /**
   * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__NESTING_PACKAGE = MPACKAGE__NESTING_PACKAGE;

  /**
   * The feature id for the '<em><b>Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__ASSOCIATION = MPACKAGE__ASSOCIATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__CLASSIFIER = MPACKAGE__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Primitive Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__PRIMITIVE_TYPES = MPACKAGE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Any Stereotype</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__ANY_STEREOTYPE = MPACKAGE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>External Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__EXTERNAL_TYPES = MPACKAGE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MModel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL_FEATURE_COUNT = MPACKAGE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link genesezMM.impl.MInterfaceImpl <em>MInterface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MInterfaceImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMInterface()
   * @generated
   */
  int MINTERFACE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__NAME = MCLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__XMI_GUID = MCLASSIFIER__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__OWNED_COMMENT = MCLASSIFIER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__TAGGED_VALUE = MCLASSIFIER__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__STEREOTYPE = MCLASSIFIER__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__ASPECT = MCLASSIFIER__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__VISIBILITY = MCLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__ABSTRACT = MCLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__FINAL = MCLASSIFIER__FINAL;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__OWNING_PACKAGE = MCLASSIFIER__OWNING_PACKAGE;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__OPERATION = MCLASSIFIER__OPERATION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__PROPERTY = MCLASSIFIER__PROPERTY;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__GENERIC_PARAMETER = MCLASSIFIER__GENERIC_PARAMETER;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__SUPERTYPE = MCLASSIFIER__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__REALIZATION = MCLASSIFIER__REALIZATION;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__GENERALIZATION = MCLASSIFIER__GENERALIZATION;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__SUPPLIER = MCLASSIFIER__SUPPLIER;

  /**
   * The number of structural features of the '<em>MInterface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link genesezMM.impl.MOperationImpl <em>MOperation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MOperationImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMOperation()
   * @generated
   */
  int MOPERATION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__VISIBILITY = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__STATIC = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__ABSTRACT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__FINAL = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__MULTIPLICITY = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__UNIQUE = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__ORDERED = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__PARAMETER = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__CLASSIFIER = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__GENERIC_PARAMETER = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Raised Exception</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__RAISED_EXCEPTION = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__RETURN_TYPE = MELEMENT_FEATURE_COUNT + 11;

  /**
   * The number of structural features of the '<em>MOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 12;

  /**
   * The meta object id for the '{@link genesezMM.impl.MParameterImpl <em>MParameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MParameterImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMParameter()
   * @generated
   */
  int MPARAMETER = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Defaultvalue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__DEFAULTVALUE = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__DIRECTION = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__MULTIPLICITY = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__UNIQUE = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__ORDERED = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Operation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__OPERATION = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__GENERIC_REALIZATION = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__TYPE = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>MParameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link genesezMM.impl.MDataTypeImpl <em>MData Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MDataTypeImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMDataType()
   * @generated
   */
  int MDATA_TYPE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__NAME = MCLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__XMI_GUID = MCLASSIFIER__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__OWNED_COMMENT = MCLASSIFIER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__TAGGED_VALUE = MCLASSIFIER__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__STEREOTYPE = MCLASSIFIER__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__ASPECT = MCLASSIFIER__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__VISIBILITY = MCLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__ABSTRACT = MCLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__FINAL = MCLASSIFIER__FINAL;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__OWNING_PACKAGE = MCLASSIFIER__OWNING_PACKAGE;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__OPERATION = MCLASSIFIER__OPERATION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__PROPERTY = MCLASSIFIER__PROPERTY;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__GENERIC_PARAMETER = MCLASSIFIER__GENERIC_PARAMETER;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__SUPERTYPE = MCLASSIFIER__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__REALIZATION = MCLASSIFIER__REALIZATION;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__GENERALIZATION = MCLASSIFIER__GENERALIZATION;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__SUPPLIER = MCLASSIFIER__SUPPLIER;

  /**
   * The number of structural features of the '<em>MData Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link genesezMM.impl.MTypeImpl <em>MType</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MTypeImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMType()
   * @generated
   */
  int MTYPE = 24;

  /**
   * The number of structural features of the '<em>MType</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link genesezMM.impl.MPrimitiveTypeImpl <em>MPrimitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MPrimitiveTypeImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMPrimitiveType()
   * @generated
   */
  int MPRIMITIVE_TYPE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__NAME = MTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__XMI_GUID = MTYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__OWNED_COMMENT = MTYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__TAGGED_VALUE = MTYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__STEREOTYPE = MTYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__ASPECT = MTYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__MODEL = MTYPE_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>MPrimitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE_FEATURE_COUNT = MTYPE_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link genesezMM.impl.MEnumerationImpl <em>MEnumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MEnumerationImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMEnumeration()
   * @generated
   */
  int MENUMERATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__NAME = MDATA_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__XMI_GUID = MDATA_TYPE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__OWNED_COMMENT = MDATA_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__TAGGED_VALUE = MDATA_TYPE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__STEREOTYPE = MDATA_TYPE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__ASPECT = MDATA_TYPE__ASPECT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__VISIBILITY = MDATA_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__ABSTRACT = MDATA_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__FINAL = MDATA_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__OWNING_PACKAGE = MDATA_TYPE__OWNING_PACKAGE;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__OPERATION = MDATA_TYPE__OPERATION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__PROPERTY = MDATA_TYPE__PROPERTY;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__GENERIC_PARAMETER = MDATA_TYPE__GENERIC_PARAMETER;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__SUPERTYPE = MDATA_TYPE__SUPERTYPE;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__REALIZATION = MDATA_TYPE__REALIZATION;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__GENERALIZATION = MDATA_TYPE__GENERALIZATION;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__SUPPLIER = MDATA_TYPE__SUPPLIER;

  /**
   * The feature id for the '<em><b>Literal</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__LITERAL = MDATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>MEnumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION_FEATURE_COUNT = MDATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link genesezMM.impl.MStereotypeImpl <em>MStereotype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MStereotypeImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMStereotype()
   * @generated
   */
  int MSTEREOTYPE = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__PROPERTY = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__MODEL = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MStereotype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link genesezMM.impl.MTagImpl <em>MTag</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MTagImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMTag()
   * @generated
   */
  int MTAG = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAG__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAG__TYPE = 1;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAG__STEREOTYPE = 2;

  /**
   * The number of structural features of the '<em>MTag</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAG_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link genesezMM.impl.MCommentImpl <em>MComment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MCommentImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMComment()
   * @generated
   */
  int MCOMMENT = 17;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT__XMI_GUID = 0;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT__ANNOTATION = 1;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT__OWNING_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Nested Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT__NESTED_COMMENT = 3;

  /**
   * The feature id for the '<em><b>Nesting Comment</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT__NESTING_COMMENT = 4;

  /**
   * The number of structural features of the '<em>MComment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMMENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link genesezMM.impl.MTaggedValueImpl <em>MTagged Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MTaggedValueImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMTaggedValue()
   * @generated
   */
  int MTAGGED_VALUE = 18;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE__OWNING_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Tag</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE__TAG = 2;

  /**
   * The number of structural features of the '<em>MTagged Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link genesezMM.impl.MAspectImpl <em>MAspect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MAspectImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMAspect()
   * @generated
   */
  int MASPECT = 19;

  /**
   * The feature id for the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT__DOMAIN = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT__NAME = 1;

  /**
   * The feature id for the '<em><b>Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT__ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Introduction</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT__INTRODUCTION = 3;

  /**
   * The feature id for the '<em><b>Pointcut</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT__POINTCUT = 4;

  /**
   * The number of structural features of the '<em>MAspect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASPECT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link genesezMM.impl.MIntroductionImpl <em>MIntroduction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MIntroductionImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMIntroduction()
   * @generated
   */
  int MINTRODUCTION = 20;

  /**
   * The feature id for the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTRODUCTION__DOMAIN = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTRODUCTION__NAME = 1;

  /**
   * The feature id for the '<em><b>Origin</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTRODUCTION__ORIGIN = 2;

  /**
   * The number of structural features of the '<em>MIntroduction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTRODUCTION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link genesezMM.impl.MPointcutImpl <em>MPointcut</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MPointcutImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMPointcut()
   * @generated
   */
  int MPOINTCUT = 21;

  /**
   * The feature id for the '<em><b>Domain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPOINTCUT__DOMAIN = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPOINTCUT__NAME = 1;

  /**
   * The feature id for the '<em><b>Destination</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPOINTCUT__DESTINATION = 2;

  /**
   * The feature id for the '<em><b>Origin</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPOINTCUT__ORIGIN = 3;

  /**
   * The number of structural features of the '<em>MPointcut</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPOINTCUT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link genesezMM.impl.MLiteralImpl <em>MLiteral</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MLiteralImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMLiteral()
   * @generated
   */
  int MLITERAL = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Owning Enumeration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL__OWNING_ENUMERATION = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>MLiteral</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLITERAL_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link genesezMM.impl.MGenericImpl <em>MGeneric</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MGenericImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMGeneric()
   * @generated
   */
  int MGENERIC = 23;

  /**
   * The feature id for the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__SPECIFICATION = MTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__OWNING_CLASSIFIER = MTYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__OWNING_OPERATION = MTYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owning Property</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__OWNING_PROPERTY = MTYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owning Parameter</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__OWNING_PARAMETER = MTYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Owning External</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__OWNING_EXTERNAL = MTYPE_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>MGeneric</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC_FEATURE_COUNT = MTYPE_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link genesezMM.impl.MExternalImpl <em>MExternal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.impl.MExternalImpl
   * @see genesezMM.impl.GenesezMMPackageImpl#getMExternal()
   * @generated
   */
  int MEXTERNAL = 25;

  /**
   * The feature id for the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__SPECIFICATION = MTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__MODEL = MTYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__GENERIC_PARAMETER = MTYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MExternal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL_FEATURE_COUNT = MTYPE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link genesezMM.MDestinationKind <em>MDestination Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see genesezMM.MDestinationKind
   * @see genesezMM.impl.GenesezMMPackageImpl#getMDestinationKind()
   * @generated
   */
  int MDESTINATION_KIND = 26;


  /**
   * Returns the meta object for class '{@link genesezMM.MPackage <em>MPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPackage</em>'.
   * @see genesezMM.MPackage
   * @generated
   */
  EClass getMPackage();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MPackage#getNestedPackage <em>Nested Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Package</em>'.
   * @see genesezMM.MPackage#getNestedPackage()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_NestedPackage();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MPackage#getNestingPackage <em>Nesting Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Nesting Package</em>'.
   * @see genesezMM.MPackage#getNestingPackage()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_NestingPackage();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MPackage#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association</em>'.
   * @see genesezMM.MPackage#getAssociation()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_Association();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MPackage#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classifier</em>'.
   * @see genesezMM.MPackage#getClassifier()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_Classifier();

  /**
   * Returns the meta object for class '{@link genesezMM.MClass <em>MClass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MClass</em>'.
   * @see genesezMM.MClass
   * @generated
   */
  EClass getMClass();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MClass#getOwnedAssociation <em>Owned Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owned Association</em>'.
   * @see genesezMM.MClass#getOwnedAssociation()
   * @see #getMClass()
   * @generated
   */
  EReference getMClass_OwnedAssociation();

  /**
   * Returns the meta object for class '{@link genesezMM.MAssociationRole <em>MAssociation Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAssociation Role</em>'.
   * @see genesezMM.MAssociationRole
   * @generated
   */
  EClass getMAssociationRole();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAssociationRole#isAggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Aggregation</em>'.
   * @see genesezMM.MAssociationRole#isAggregation()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_Aggregation();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAssociationRole#isComposition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Composition</em>'.
   * @see genesezMM.MAssociationRole#isComposition()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_Composition();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MAssociationRole#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association</em>'.
   * @see genesezMM.MAssociationRole#getAssociation()
   * @see #getMAssociationRole()
   * @generated
   */
  EReference getMAssociationRole_Association();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MAssociationRole#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see genesezMM.MAssociationRole#getOpposite()
   * @see #getMAssociationRole()
   * @generated
   */
  EReference getMAssociationRole_Opposite();

  /**
   * Returns the meta object for class '{@link genesezMM.MAssociation <em>MAssociation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAssociation</em>'.
   * @see genesezMM.MAssociation
   * @generated
   */
  EClass getMAssociation();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAssociation#isDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Derived</em>'.
   * @see genesezMM.MAssociation#isDerived()
   * @see #getMAssociation()
   * @generated
   */
  EAttribute getMAssociation_Derived();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MAssociation#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>End</em>'.
   * @see genesezMM.MAssociation#getEnd()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_End();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MAssociation#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Package</em>'.
   * @see genesezMM.MAssociation#getOwningPackage()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_OwningPackage();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MAssociation#getAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association Class</em>'.
   * @see genesezMM.MAssociation#getAssociationClass()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_AssociationClass();

  /**
   * Returns the meta object for class '{@link genesezMM.MAttribute <em>MAttribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAttribute</em>'.
   * @see genesezMM.MAttribute
   * @generated
   */
  EClass getMAttribute();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAttribute#getDefaultvalue <em>Defaultvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defaultvalue</em>'.
   * @see genesezMM.MAttribute#getDefaultvalue()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Defaultvalue();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAttribute#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see genesezMM.MAttribute#isStatic()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Static();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAttribute#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see genesezMM.MAttribute#isFinal()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Final();

  /**
   * Returns the meta object for class '{@link genesezMM.MModel <em>MModel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MModel</em>'.
   * @see genesezMM.MModel
   * @generated
   */
  EClass getMModel();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MModel#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
   * @see genesezMM.MModel#getPrimitiveTypes()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_PrimitiveTypes();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MModel#getAnyStereotype <em>Any Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Any Stereotype</em>'.
   * @see genesezMM.MModel#getAnyStereotype()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_AnyStereotype();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Types</em>'.
   * @see genesezMM.MModel#getExternalTypes()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_ExternalTypes();

  /**
   * Returns the meta object for class '{@link genesezMM.MElement <em>MElement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MElement</em>'.
   * @see genesezMM.MElement
   * @generated
   */
  EClass getMElement();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see genesezMM.MElement#getName()
   * @see #getMElement()
   * @generated
   */
  EAttribute getMElement_Name();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MElement#getXmiGuid <em>Xmi Guid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xmi Guid</em>'.
   * @see genesezMM.MElement#getXmiGuid()
   * @see #getMElement()
   * @generated
   */
  EAttribute getMElement_XmiGuid();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MElement#getOwnedComment <em>Owned Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Comment</em>'.
   * @see genesezMM.MElement#getOwnedComment()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_OwnedComment();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MElement#getTaggedValue <em>Tagged Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tagged Value</em>'.
   * @see genesezMM.MElement#getTaggedValue()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_TaggedValue();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MElement#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stereotype</em>'.
   * @see genesezMM.MElement#getStereotype()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_Stereotype();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MElement#getAspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Aspect</em>'.
   * @see genesezMM.MElement#getAspect()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_Aspect();

  /**
   * Returns the meta object for class '{@link genesezMM.MProperty <em>MProperty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MProperty</em>'.
   * @see genesezMM.MProperty
   * @generated
   */
  EClass getMProperty();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MProperty#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see genesezMM.MProperty#getVisibility()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Visibility();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MProperty#isDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Derived</em>'.
   * @see genesezMM.MProperty#isDerived()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Derived();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MProperty#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see genesezMM.MProperty#getMultiplicity()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MProperty#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see genesezMM.MProperty#isUnique()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Unique();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MProperty#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see genesezMM.MProperty#isOrdered()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Ordered();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MProperty#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Classifier</em>'.
   * @see genesezMM.MProperty#getClassifier()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MProperty#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Realization</em>'.
   * @see genesezMM.MProperty#getGenericRealization()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_GenericRealization();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MProperty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see genesezMM.MProperty#getType()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_Type();

  /**
   * Returns the meta object for class '{@link genesezMM.MInterface <em>MInterface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MInterface</em>'.
   * @see genesezMM.MInterface
   * @generated
   */
  EClass getMInterface();

  /**
   * Returns the meta object for class '{@link genesezMM.MClassifier <em>MClassifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MClassifier</em>'.
   * @see genesezMM.MClassifier
   * @generated
   */
  EClass getMClassifier();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MClassifier#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see genesezMM.MClassifier#getVisibility()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Visibility();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MClassifier#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see genesezMM.MClassifier#isAbstract()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Abstract();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MClassifier#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see genesezMM.MClassifier#isFinal()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Final();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MClassifier#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Package</em>'.
   * @see genesezMM.MClassifier#getOwningPackage()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_OwningPackage();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MClassifier#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operation</em>'.
   * @see genesezMM.MClassifier#getOperation()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MClassifier#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property</em>'.
   * @see genesezMM.MClassifier#getProperty()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Property();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MClassifier#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see genesezMM.MClassifier#getGenericParameter()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_GenericParameter();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MClassifier#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supertype</em>'.
   * @see genesezMM.MClassifier#getSupertype()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Supertype();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MClassifier#getRealization <em>Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Realization</em>'.
   * @see genesezMM.MClassifier#getRealization()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Realization();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MClassifier#getGeneralization <em>Generalization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Generalization</em>'.
   * @see genesezMM.MClassifier#getGeneralization()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Generalization();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MClassifier#getSupplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supplier</em>'.
   * @see genesezMM.MClassifier#getSupplier()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Supplier();

  /**
   * Returns the meta object for class '{@link genesezMM.MOperation <em>MOperation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MOperation</em>'.
   * @see genesezMM.MOperation
   * @generated
   */
  EClass getMOperation();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see genesezMM.MOperation#getVisibility()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Visibility();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see genesezMM.MOperation#isStatic()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Static();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see genesezMM.MOperation#isAbstract()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Abstract();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see genesezMM.MOperation#isFinal()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Final();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see genesezMM.MOperation#getMultiplicity()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see genesezMM.MOperation#isUnique()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Unique();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MOperation#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see genesezMM.MOperation#isOrdered()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Ordered();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MOperation#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see genesezMM.MOperation#getParameter()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_Parameter();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MOperation#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Classifier</em>'.
   * @see genesezMM.MOperation#getClassifier()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MOperation#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see genesezMM.MOperation#getGenericParameter()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_GenericParameter();

  /**
   * Returns the meta object for the reference list '{@link genesezMM.MOperation#getRaisedException <em>Raised Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Raised Exception</em>'.
   * @see genesezMM.MOperation#getRaisedException()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_RaisedException();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MOperation#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Return Type</em>'.
   * @see genesezMM.MOperation#getReturnType()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_ReturnType();

  /**
   * Returns the meta object for class '{@link genesezMM.MParameter <em>MParameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MParameter</em>'.
   * @see genesezMM.MParameter
   * @generated
   */
  EClass getMParameter();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MParameter#getDefaultvalue <em>Defaultvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defaultvalue</em>'.
   * @see genesezMM.MParameter#getDefaultvalue()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Defaultvalue();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MParameter#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see genesezMM.MParameter#getDirection()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Direction();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MParameter#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see genesezMM.MParameter#getMultiplicity()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MParameter#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see genesezMM.MParameter#isUnique()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Unique();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MParameter#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see genesezMM.MParameter#isOrdered()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Ordered();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MParameter#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Operation</em>'.
   * @see genesezMM.MParameter#getOperation()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MParameter#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Realization</em>'.
   * @see genesezMM.MParameter#getGenericRealization()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_GenericRealization();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see genesezMM.MParameter#getType()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_Type();

  /**
   * Returns the meta object for class '{@link genesezMM.MDataType <em>MData Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MData Type</em>'.
   * @see genesezMM.MDataType
   * @generated
   */
  EClass getMDataType();

  /**
   * Returns the meta object for class '{@link genesezMM.MPrimitiveType <em>MPrimitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPrimitive Type</em>'.
   * @see genesezMM.MPrimitiveType
   * @generated
   */
  EClass getMPrimitiveType();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MPrimitiveType#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see genesezMM.MPrimitiveType#getModel()
   * @see #getMPrimitiveType()
   * @generated
   */
  EReference getMPrimitiveType_Model();

  /**
   * Returns the meta object for class '{@link genesezMM.MEnumeration <em>MEnumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MEnumeration</em>'.
   * @see genesezMM.MEnumeration
   * @generated
   */
  EClass getMEnumeration();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MEnumeration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literal</em>'.
   * @see genesezMM.MEnumeration#getLiteral()
   * @see #getMEnumeration()
   * @generated
   */
  EReference getMEnumeration_Literal();

  /**
   * Returns the meta object for class '{@link genesezMM.MStereotype <em>MStereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MStereotype</em>'.
   * @see genesezMM.MStereotype
   * @generated
   */
  EClass getMStereotype();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MStereotype#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property</em>'.
   * @see genesezMM.MStereotype#getProperty()
   * @see #getMStereotype()
   * @generated
   */
  EReference getMStereotype_Property();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see genesezMM.MStereotype#getModel()
   * @see #getMStereotype()
   * @generated
   */
  EReference getMStereotype_Model();

  /**
   * Returns the meta object for class '{@link genesezMM.MTag <em>MTag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTag</em>'.
   * @see genesezMM.MTag
   * @generated
   */
  EClass getMTag();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MTag#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see genesezMM.MTag#getName()
   * @see #getMTag()
   * @generated
   */
  EAttribute getMTag_Name();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MTag#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see genesezMM.MTag#getType()
   * @see #getMTag()
   * @generated
   */
  EAttribute getMTag_Type();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MTag#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Stereotype</em>'.
   * @see genesezMM.MTag#getStereotype()
   * @see #getMTag()
   * @generated
   */
  EReference getMTag_Stereotype();

  /**
   * Returns the meta object for class '{@link genesezMM.MComment <em>MComment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MComment</em>'.
   * @see genesezMM.MComment
   * @generated
   */
  EClass getMComment();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MComment#getXmiGuid <em>Xmi Guid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xmi Guid</em>'.
   * @see genesezMM.MComment#getXmiGuid()
   * @see #getMComment()
   * @generated
   */
  EAttribute getMComment_XmiGuid();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MComment#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Annotation</em>'.
   * @see genesezMM.MComment#getAnnotation()
   * @see #getMComment()
   * @generated
   */
  EAttribute getMComment_Annotation();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MComment#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Element</em>'.
   * @see genesezMM.MComment#getOwningElement()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_OwningElement();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MComment#getNestedComment <em>Nested Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Comment</em>'.
   * @see genesezMM.MComment#getNestedComment()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_NestedComment();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MComment#getNestingComment <em>Nesting Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Nesting Comment</em>'.
   * @see genesezMM.MComment#getNestingComment()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_NestingComment();

  /**
   * Returns the meta object for class '{@link genesezMM.MTaggedValue <em>MTagged Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTagged Value</em>'.
   * @see genesezMM.MTaggedValue
   * @generated
   */
  EClass getMTaggedValue();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MTaggedValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see genesezMM.MTaggedValue#getValue()
   * @see #getMTaggedValue()
   * @generated
   */
  EAttribute getMTaggedValue_Value();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MTaggedValue#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Element</em>'.
   * @see genesezMM.MTaggedValue#getOwningElement()
   * @see #getMTaggedValue()
   * @generated
   */
  EReference getMTaggedValue_OwningElement();

  /**
   * Returns the meta object for the reference '{@link genesezMM.MTaggedValue#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tag</em>'.
   * @see genesezMM.MTaggedValue#getTag()
   * @see #getMTaggedValue()
   * @generated
   */
  EReference getMTaggedValue_Tag();

  /**
   * Returns the meta object for class '{@link genesezMM.MAspect <em>MAspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAspect</em>'.
   * @see genesezMM.MAspect
   * @generated
   */
  EClass getMAspect();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAspect#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see genesezMM.MAspect#getDomain()
   * @see #getMAspect()
   * @generated
   */
  EAttribute getMAspect_Domain();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MAspect#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see genesezMM.MAspect#getName()
   * @see #getMAspect()
   * @generated
   */
  EAttribute getMAspect_Name();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MAspect#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Element</em>'.
   * @see genesezMM.MAspect#getElement()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Element();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MAspect#getIntroduction <em>Introduction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Introduction</em>'.
   * @see genesezMM.MAspect#getIntroduction()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Introduction();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MAspect#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pointcut</em>'.
   * @see genesezMM.MAspect#getPointcut()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Pointcut();

  /**
   * Returns the meta object for class '{@link genesezMM.MIntroduction <em>MIntroduction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MIntroduction</em>'.
   * @see genesezMM.MIntroduction
   * @generated
   */
  EClass getMIntroduction();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MIntroduction#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see genesezMM.MIntroduction#getDomain()
   * @see #getMIntroduction()
   * @generated
   */
  EAttribute getMIntroduction_Domain();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MIntroduction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see genesezMM.MIntroduction#getName()
   * @see #getMIntroduction()
   * @generated
   */
  EAttribute getMIntroduction_Name();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MIntroduction#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Origin</em>'.
   * @see genesezMM.MIntroduction#getOrigin()
   * @see #getMIntroduction()
   * @generated
   */
  EReference getMIntroduction_Origin();

  /**
   * Returns the meta object for class '{@link genesezMM.MPointcut <em>MPointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPointcut</em>'.
   * @see genesezMM.MPointcut
   * @generated
   */
  EClass getMPointcut();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MPointcut#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see genesezMM.MPointcut#getDomain()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Domain();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MPointcut#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see genesezMM.MPointcut#getName()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Name();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MPointcut#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Destination</em>'.
   * @see genesezMM.MPointcut#getDestination()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Destination();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MPointcut#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Origin</em>'.
   * @see genesezMM.MPointcut#getOrigin()
   * @see #getMPointcut()
   * @generated
   */
  EReference getMPointcut_Origin();

  /**
   * Returns the meta object for class '{@link genesezMM.MLiteral <em>MLiteral</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MLiteral</em>'.
   * @see genesezMM.MLiteral
   * @generated
   */
  EClass getMLiteral();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Enumeration</em>'.
   * @see genesezMM.MLiteral#getOwningEnumeration()
   * @see #getMLiteral()
   * @generated
   */
  EReference getMLiteral_OwningEnumeration();

  /**
   * Returns the meta object for class '{@link genesezMM.MGeneric <em>MGeneric</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MGeneric</em>'.
   * @see genesezMM.MGeneric
   * @generated
   */
  EClass getMGeneric();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MGeneric#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Specification</em>'.
   * @see genesezMM.MGeneric#getSpecification()
   * @see #getMGeneric()
   * @generated
   */
  EAttribute getMGeneric_Specification();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MGeneric#getOwningClassifier <em>Owning Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Classifier</em>'.
   * @see genesezMM.MGeneric#getOwningClassifier()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningClassifier();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MGeneric#getOwningOperation <em>Owning Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Operation</em>'.
   * @see genesezMM.MGeneric#getOwningOperation()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningOperation();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MGeneric#getOwningProperty <em>Owning Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Property</em>'.
   * @see genesezMM.MGeneric#getOwningProperty()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningProperty();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MGeneric#getOwningParameter <em>Owning Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Parameter</em>'.
   * @see genesezMM.MGeneric#getOwningParameter()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningParameter();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MGeneric#getOwningExternal <em>Owning External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning External</em>'.
   * @see genesezMM.MGeneric#getOwningExternal()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningExternal();

  /**
   * Returns the meta object for class '{@link genesezMM.MType <em>MType</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MType</em>'.
   * @see genesezMM.MType
   * @generated
   */
  EClass getMType();

  /**
   * Returns the meta object for class '{@link genesezMM.MExternal <em>MExternal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MExternal</em>'.
   * @see genesezMM.MExternal
   * @generated
   */
  EClass getMExternal();

  /**
   * Returns the meta object for the attribute '{@link genesezMM.MExternal#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Specification</em>'.
   * @see genesezMM.MExternal#getSpecification()
   * @see #getMExternal()
   * @generated
   */
  EAttribute getMExternal_Specification();

  /**
   * Returns the meta object for the container reference '{@link genesezMM.MExternal#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see genesezMM.MExternal#getModel()
   * @see #getMExternal()
   * @generated
   */
  EReference getMExternal_Model();

  /**
   * Returns the meta object for the containment reference list '{@link genesezMM.MExternal#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see genesezMM.MExternal#getGenericParameter()
   * @see #getMExternal()
   * @generated
   */
  EReference getMExternal_GenericParameter();

  /**
   * Returns the meta object for enum '{@link genesezMM.MDestinationKind <em>MDestination Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>MDestination Kind</em>'.
   * @see genesezMM.MDestinationKind
   * @generated
   */
  EEnum getMDestinationKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GenesezMMFactory getGenesezMMFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link genesezMM.impl.MPackageImpl <em>MPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MPackageImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMPackage()
     * @generated
     */
    EClass MPACKAGE = eINSTANCE.getMPackage();

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
     * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPACKAGE__ASSOCIATION = eINSTANCE.getMPackage_Association();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPACKAGE__CLASSIFIER = eINSTANCE.getMPackage_Classifier();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MClassImpl <em>MClass</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MClassImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMClass()
     * @generated
     */
    EClass MCLASS = eINSTANCE.getMClass();

    /**
     * The meta object literal for the '<em><b>Owned Association</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASS__OWNED_ASSOCIATION = eINSTANCE.getMClass_OwnedAssociation();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MAssociationRoleImpl <em>MAssociation Role</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MAssociationRoleImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMAssociationRole()
     * @generated
     */
    EClass MASSOCIATION_ROLE = eINSTANCE.getMAssociationRole();

    /**
     * The meta object literal for the '<em><b>Aggregation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__AGGREGATION = eINSTANCE.getMAssociationRole_Aggregation();

    /**
     * The meta object literal for the '<em><b>Composition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__COMPOSITION = eINSTANCE.getMAssociationRole_Composition();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASSOCIATION_ROLE__ASSOCIATION = eINSTANCE.getMAssociationRole_Association();

    /**
     * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASSOCIATION_ROLE__OPPOSITE = eINSTANCE.getMAssociationRole_Opposite();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MAssociationImpl <em>MAssociation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MAssociationImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMAssociation()
     * @generated
     */
    EClass MASSOCIATION = eINSTANCE.getMAssociation();

    /**
     * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION__DERIVED = eINSTANCE.getMAssociation_Derived();

    /**
     * The meta object literal for the '<em><b>End</b></em>' reference list feature.
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
     * The meta object literal for the '<em><b>Association Class</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASSOCIATION__ASSOCIATION_CLASS = eINSTANCE.getMAssociation_AssociationClass();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MAttributeImpl <em>MAttribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MAttributeImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMAttribute()
     * @generated
     */
    EClass MATTRIBUTE = eINSTANCE.getMAttribute();

    /**
     * The meta object literal for the '<em><b>Defaultvalue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATTRIBUTE__DEFAULTVALUE = eINSTANCE.getMAttribute_Defaultvalue();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATTRIBUTE__STATIC = eINSTANCE.getMAttribute_Static();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MATTRIBUTE__FINAL = eINSTANCE.getMAttribute_Final();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MModelImpl <em>MModel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MModelImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMModel()
     * @generated
     */
    EClass MMODEL = eINSTANCE.getMModel();

    /**
     * The meta object literal for the '<em><b>Primitive Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MMODEL__PRIMITIVE_TYPES = eINSTANCE.getMModel_PrimitiveTypes();

    /**
     * The meta object literal for the '<em><b>Any Stereotype</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MMODEL__ANY_STEREOTYPE = eINSTANCE.getMModel_AnyStereotype();

    /**
     * The meta object literal for the '<em><b>External Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MMODEL__EXTERNAL_TYPES = eINSTANCE.getMModel_ExternalTypes();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MElementImpl <em>MElement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MElementImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMElement()
     * @generated
     */
    EClass MELEMENT = eINSTANCE.getMElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MELEMENT__NAME = eINSTANCE.getMElement_Name();

    /**
     * The meta object literal for the '<em><b>Xmi Guid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MELEMENT__XMI_GUID = eINSTANCE.getMElement_XmiGuid();

    /**
     * The meta object literal for the '<em><b>Owned Comment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MELEMENT__OWNED_COMMENT = eINSTANCE.getMElement_OwnedComment();

    /**
     * The meta object literal for the '<em><b>Tagged Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MELEMENT__TAGGED_VALUE = eINSTANCE.getMElement_TaggedValue();

    /**
     * The meta object literal for the '<em><b>Stereotype</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MELEMENT__STEREOTYPE = eINSTANCE.getMElement_Stereotype();

    /**
     * The meta object literal for the '<em><b>Aspect</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MELEMENT__ASPECT = eINSTANCE.getMElement_Aspect();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MPropertyImpl <em>MProperty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MPropertyImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMProperty()
     * @generated
     */
    EClass MPROPERTY = eINSTANCE.getMProperty();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__VISIBILITY = eINSTANCE.getMProperty_Visibility();

    /**
     * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__DERIVED = eINSTANCE.getMProperty_Derived();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__MULTIPLICITY = eINSTANCE.getMProperty_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__UNIQUE = eINSTANCE.getMProperty_Unique();

    /**
     * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__ORDERED = eINSTANCE.getMProperty_Ordered();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPROPERTY__CLASSIFIER = eINSTANCE.getMProperty_Classifier();

    /**
     * The meta object literal for the '<em><b>Generic Realization</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPROPERTY__GENERIC_REALIZATION = eINSTANCE.getMProperty_GenericRealization();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPROPERTY__TYPE = eINSTANCE.getMProperty_Type();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MInterfaceImpl <em>MInterface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MInterfaceImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMInterface()
     * @generated
     */
    EClass MINTERFACE = eINSTANCE.getMInterface();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MClassifierImpl <em>MClassifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MClassifierImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMClassifier()
     * @generated
     */
    EClass MCLASSIFIER = eINSTANCE.getMClassifier();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MCLASSIFIER__VISIBILITY = eINSTANCE.getMClassifier_Visibility();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MCLASSIFIER__ABSTRACT = eINSTANCE.getMClassifier_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MCLASSIFIER__FINAL = eINSTANCE.getMClassifier_Final();

    /**
     * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__OWNING_PACKAGE = eINSTANCE.getMClassifier_OwningPackage();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__OPERATION = eINSTANCE.getMClassifier_Operation();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__PROPERTY = eINSTANCE.getMClassifier_Property();

    /**
     * The meta object literal for the '<em><b>Generic Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__GENERIC_PARAMETER = eINSTANCE.getMClassifier_GenericParameter();

    /**
     * The meta object literal for the '<em><b>Supertype</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__SUPERTYPE = eINSTANCE.getMClassifier_Supertype();

    /**
     * The meta object literal for the '<em><b>Realization</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__REALIZATION = eINSTANCE.getMClassifier_Realization();

    /**
     * The meta object literal for the '<em><b>Generalization</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__GENERALIZATION = eINSTANCE.getMClassifier_Generalization();

    /**
     * The meta object literal for the '<em><b>Supplier</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__SUPPLIER = eINSTANCE.getMClassifier_Supplier();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MOperationImpl <em>MOperation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MOperationImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMOperation()
     * @generated
     */
    EClass MOPERATION = eINSTANCE.getMOperation();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__VISIBILITY = eINSTANCE.getMOperation_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__STATIC = eINSTANCE.getMOperation_Static();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__ABSTRACT = eINSTANCE.getMOperation_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__FINAL = eINSTANCE.getMOperation_Final();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__MULTIPLICITY = eINSTANCE.getMOperation_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__UNIQUE = eINSTANCE.getMOperation_Unique();

    /**
     * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOPERATION__ORDERED = eINSTANCE.getMOperation_Ordered();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__PARAMETER = eINSTANCE.getMOperation_Parameter();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__CLASSIFIER = eINSTANCE.getMOperation_Classifier();

    /**
     * The meta object literal for the '<em><b>Generic Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__GENERIC_PARAMETER = eINSTANCE.getMOperation_GenericParameter();

    /**
     * The meta object literal for the '<em><b>Raised Exception</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__RAISED_EXCEPTION = eINSTANCE.getMOperation_RaisedException();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__RETURN_TYPE = eINSTANCE.getMOperation_ReturnType();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MParameterImpl <em>MParameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MParameterImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMParameter()
     * @generated
     */
    EClass MPARAMETER = eINSTANCE.getMParameter();

    /**
     * The meta object literal for the '<em><b>Defaultvalue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__DEFAULTVALUE = eINSTANCE.getMParameter_Defaultvalue();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__DIRECTION = eINSTANCE.getMParameter_Direction();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__MULTIPLICITY = eINSTANCE.getMParameter_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__UNIQUE = eINSTANCE.getMParameter_Unique();

    /**
     * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__ORDERED = eINSTANCE.getMParameter_Ordered();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPARAMETER__OPERATION = eINSTANCE.getMParameter_Operation();

    /**
     * The meta object literal for the '<em><b>Generic Realization</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPARAMETER__GENERIC_REALIZATION = eINSTANCE.getMParameter_GenericRealization();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPARAMETER__TYPE = eINSTANCE.getMParameter_Type();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MDataTypeImpl <em>MData Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MDataTypeImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMDataType()
     * @generated
     */
    EClass MDATA_TYPE = eINSTANCE.getMDataType();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MPrimitiveTypeImpl <em>MPrimitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MPrimitiveTypeImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMPrimitiveType()
     * @generated
     */
    EClass MPRIMITIVE_TYPE = eINSTANCE.getMPrimitiveType();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPRIMITIVE_TYPE__MODEL = eINSTANCE.getMPrimitiveType_Model();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MEnumerationImpl <em>MEnumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MEnumerationImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMEnumeration()
     * @generated
     */
    EClass MENUMERATION = eINSTANCE.getMEnumeration();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MENUMERATION__LITERAL = eINSTANCE.getMEnumeration_Literal();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MStereotypeImpl <em>MStereotype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MStereotypeImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMStereotype()
     * @generated
     */
    EClass MSTEREOTYPE = eINSTANCE.getMStereotype();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTEREOTYPE__PROPERTY = eINSTANCE.getMStereotype_Property();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTEREOTYPE__MODEL = eINSTANCE.getMStereotype_Model();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MTagImpl <em>MTag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MTagImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMTag()
     * @generated
     */
    EClass MTAG = eINSTANCE.getMTag();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTAG__NAME = eINSTANCE.getMTag_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTAG__TYPE = eINSTANCE.getMTag_Type();

    /**
     * The meta object literal for the '<em><b>Stereotype</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTAG__STEREOTYPE = eINSTANCE.getMTag_Stereotype();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MCommentImpl <em>MComment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MCommentImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMComment()
     * @generated
     */
    EClass MCOMMENT = eINSTANCE.getMComment();

    /**
     * The meta object literal for the '<em><b>Xmi Guid</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MCOMMENT__XMI_GUID = eINSTANCE.getMComment_XmiGuid();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MCOMMENT__ANNOTATION = eINSTANCE.getMComment_Annotation();

    /**
     * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCOMMENT__OWNING_ELEMENT = eINSTANCE.getMComment_OwningElement();

    /**
     * The meta object literal for the '<em><b>Nested Comment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCOMMENT__NESTED_COMMENT = eINSTANCE.getMComment_NestedComment();

    /**
     * The meta object literal for the '<em><b>Nesting Comment</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCOMMENT__NESTING_COMMENT = eINSTANCE.getMComment_NestingComment();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MTaggedValueImpl <em>MTagged Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MTaggedValueImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMTaggedValue()
     * @generated
     */
    EClass MTAGGED_VALUE = eINSTANCE.getMTaggedValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTAGGED_VALUE__VALUE = eINSTANCE.getMTaggedValue_Value();

    /**
     * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTAGGED_VALUE__OWNING_ELEMENT = eINSTANCE.getMTaggedValue_OwningElement();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTAGGED_VALUE__TAG = eINSTANCE.getMTaggedValue_Tag();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MAspectImpl <em>MAspect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MAspectImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMAspect()
     * @generated
     */
    EClass MASPECT = eINSTANCE.getMAspect();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASPECT__DOMAIN = eINSTANCE.getMAspect_Domain();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASPECT__NAME = eINSTANCE.getMAspect_Name();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASPECT__ELEMENT = eINSTANCE.getMAspect_Element();

    /**
     * The meta object literal for the '<em><b>Introduction</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASPECT__INTRODUCTION = eINSTANCE.getMAspect_Introduction();

    /**
     * The meta object literal for the '<em><b>Pointcut</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASPECT__POINTCUT = eINSTANCE.getMAspect_Pointcut();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MIntroductionImpl <em>MIntroduction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MIntroductionImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMIntroduction()
     * @generated
     */
    EClass MINTRODUCTION = eINSTANCE.getMIntroduction();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MINTRODUCTION__DOMAIN = eINSTANCE.getMIntroduction_Domain();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MINTRODUCTION__NAME = eINSTANCE.getMIntroduction_Name();

    /**
     * The meta object literal for the '<em><b>Origin</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINTRODUCTION__ORIGIN = eINSTANCE.getMIntroduction_Origin();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MPointcutImpl <em>MPointcut</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MPointcutImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMPointcut()
     * @generated
     */
    EClass MPOINTCUT = eINSTANCE.getMPointcut();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPOINTCUT__DOMAIN = eINSTANCE.getMPointcut_Domain();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPOINTCUT__NAME = eINSTANCE.getMPointcut_Name();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPOINTCUT__DESTINATION = eINSTANCE.getMPointcut_Destination();

    /**
     * The meta object literal for the '<em><b>Origin</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPOINTCUT__ORIGIN = eINSTANCE.getMPointcut_Origin();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MLiteralImpl <em>MLiteral</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MLiteralImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMLiteral()
     * @generated
     */
    EClass MLITERAL = eINSTANCE.getMLiteral();

    /**
     * The meta object literal for the '<em><b>Owning Enumeration</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MLITERAL__OWNING_ENUMERATION = eINSTANCE.getMLiteral_OwningEnumeration();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MGenericImpl <em>MGeneric</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MGenericImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMGeneric()
     * @generated
     */
    EClass MGENERIC = eINSTANCE.getMGeneric();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MGENERIC__SPECIFICATION = eINSTANCE.getMGeneric_Specification();

    /**
     * The meta object literal for the '<em><b>Owning Classifier</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGENERIC__OWNING_CLASSIFIER = eINSTANCE.getMGeneric_OwningClassifier();

    /**
     * The meta object literal for the '<em><b>Owning Operation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGENERIC__OWNING_OPERATION = eINSTANCE.getMGeneric_OwningOperation();

    /**
     * The meta object literal for the '<em><b>Owning Property</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGENERIC__OWNING_PROPERTY = eINSTANCE.getMGeneric_OwningProperty();

    /**
     * The meta object literal for the '<em><b>Owning Parameter</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGENERIC__OWNING_PARAMETER = eINSTANCE.getMGeneric_OwningParameter();

    /**
     * The meta object literal for the '<em><b>Owning External</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGENERIC__OWNING_EXTERNAL = eINSTANCE.getMGeneric_OwningExternal();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MTypeImpl <em>MType</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MTypeImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMType()
     * @generated
     */
    EClass MTYPE = eINSTANCE.getMType();

    /**
     * The meta object literal for the '{@link genesezMM.impl.MExternalImpl <em>MExternal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.impl.MExternalImpl
     * @see genesezMM.impl.GenesezMMPackageImpl#getMExternal()
     * @generated
     */
    EClass MEXTERNAL = eINSTANCE.getMExternal();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEXTERNAL__SPECIFICATION = eINSTANCE.getMExternal_Specification();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEXTERNAL__MODEL = eINSTANCE.getMExternal_Model();

    /**
     * The meta object literal for the '<em><b>Generic Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEXTERNAL__GENERIC_PARAMETER = eINSTANCE.getMExternal_GenericParameter();

    /**
     * The meta object literal for the '{@link genesezMM.MDestinationKind <em>MDestination Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see genesezMM.MDestinationKind
     * @see genesezMM.impl.GenesezMMPackageImpl#getMDestinationKind()
     * @generated
     */
    EEnum MDESTINATION_KIND = eINSTANCE.getMDestinationKind();

  }

} //GenesezMMPackage
