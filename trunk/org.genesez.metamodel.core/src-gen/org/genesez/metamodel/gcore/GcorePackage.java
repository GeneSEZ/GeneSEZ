/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;

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
 * <!-- begin-model-doc -->
 * Author:gerbe.Created:8/30/12 6:57 PM.Title:.Comment:.
 * <!-- end-model-doc -->
 * @see org.genesez.metamodel.gcore.GcoreFactory
 * @model kind="package"
 * @generated
 */
public interface GcorePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gcore";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://genesez.org/metamodel/core";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gcore";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GcorePackage eINSTANCE = org.genesez.metamodel.gcore.impl.GcorePackageImpl.init();

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MElementImpl <em>MElement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MElementImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMElement()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl <em>MDefinition Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MDefinitionContextImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDefinitionContext()
   * @generated
   */
  int MDEFINITION_CONTEXT = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__CLASSIFIER = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__OWNED_BEHAVIOR = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__GUARD = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT__EVENT = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MDefinition Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDEFINITION_CONTEXT_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MPackageImpl <em>MPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MPackageImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPackage()
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
  int MPACKAGE__NAME = MDEFINITION_CONTEXT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__XMI_GUID = MDEFINITION_CONTEXT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__OWNED_COMMENT = MDEFINITION_CONTEXT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__TAGGED_VALUE = MDEFINITION_CONTEXT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__STEREOTYPE = MDEFINITION_CONTEXT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__ASPECT = MDEFINITION_CONTEXT__ASPECT;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__CLASSIFIER = MDEFINITION_CONTEXT__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__OWNED_BEHAVIOR = MDEFINITION_CONTEXT__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__GUARD = MDEFINITION_CONTEXT__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__EVENT = MDEFINITION_CONTEXT__EVENT;

  /**
   * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__NESTING_PACKAGE = MDEFINITION_CONTEXT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__NESTED_PACKAGE = MDEFINITION_CONTEXT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE__ASSOCIATION = MDEFINITION_CONTEXT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPACKAGE_FEATURE_COUNT = MDEFINITION_CONTEXT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MClassifierImpl <em>MClassifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MClassifierImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMClassifier()
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
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__SPECIALIZATION = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__CLASSIFIER = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OWNED_BEHAVIOR = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__GUARD = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__EVENT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__VISIBILITY = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__ABSTRACT = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__FINAL = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OPERATION = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__PROPERTY = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__GENERIC_PARAMETER = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__REALIZATION = MELEMENT_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__GENERALIZATION = MELEMENT_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__SUPPLIER = MELEMENT_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER__OWNING_CONTEXT = MELEMENT_FEATURE_COUNT + 14;

  /**
   * The number of structural features of the '<em>MClassifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASSIFIER_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 15;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MClassImpl <em>MClass</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MClassImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMClass()
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
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__SPECIALIZATION = MCLASSIFIER__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__CLASSIFIER = MCLASSIFIER__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OWNED_BEHAVIOR = MCLASSIFIER__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__GUARD = MCLASSIFIER__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__EVENT = MCLASSIFIER__EVENT;

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
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCLASS__OWNING_CONTEXT = MCLASSIFIER__OWNING_CONTEXT;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MPropertyImpl <em>MProperty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MPropertyImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMProperty()
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
   * The feature id for the '<em><b>Lower Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__LOWER_BOUND_MULTIPLICITY = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Upper Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__UPPER_BOUND_MULTIPLICITY = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__UNIQUE = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__ORDERED = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__CLASSIFIER = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__GENERIC_REALIZATION = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY__TYPE = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>MProperty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPROPERTY_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl <em>MAssociation Role</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MAssociationRoleImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAssociationRole()
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
   * The feature id for the '<em><b>Lower Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__LOWER_BOUND_MULTIPLICITY = MPROPERTY__LOWER_BOUND_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Upper Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__UPPER_BOUND_MULTIPLICITY = MPROPERTY__UPPER_BOUND_MULTIPLICITY;

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
   * The feature id for the '<em><b>Opposite Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY = MPROPERTY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Opposite Lower Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OPPOSITE_LOWER_BOUND_MULTIPLICITY = MPROPERTY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Opposite Upper Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OPPOSITE_UPPER_BOUND_MULTIPLICITY = MPROPERTY_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Qualifier Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY = MPROPERTY_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Association</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__ASSOCIATION = MPROPERTY_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Opposite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__OPPOSITE = MPROPERTY_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Qualifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE__QUALIFIER = MPROPERTY_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>MAssociation Role</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASSOCIATION_ROLE_FEATURE_COUNT = MPROPERTY_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MAssociationImpl <em>MAssociation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MAssociationImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAssociation()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MAttributeImpl <em>MAttribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MAttributeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAttribute()
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
   * The feature id for the '<em><b>Lower Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__LOWER_BOUND_MULTIPLICITY = MPROPERTY__LOWER_BOUND_MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Upper Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATTRIBUTE__UPPER_BOUND_MULTIPLICITY = MPROPERTY__UPPER_BOUND_MULTIPLICITY;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MModelImpl <em>MModel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MModelImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMModel()
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
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__CLASSIFIER = MPACKAGE__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__OWNED_BEHAVIOR = MPACKAGE__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__GUARD = MPACKAGE__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__EVENT = MPACKAGE__EVENT;

  /**
   * The feature id for the '<em><b>Nesting Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__NESTING_PACKAGE = MPACKAGE__NESTING_PACKAGE;

  /**
   * The feature id for the '<em><b>Nested Package</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__NESTED_PACKAGE = MPACKAGE__NESTED_PACKAGE;

  /**
   * The feature id for the '<em><b>Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MMODEL__ASSOCIATION = MPACKAGE__ASSOCIATION;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MInterfaceImpl <em>MInterface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MInterfaceImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInterface()
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
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__SPECIALIZATION = MCLASSIFIER__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__CLASSIFIER = MCLASSIFIER__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__OWNED_BEHAVIOR = MCLASSIFIER__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__GUARD = MCLASSIFIER__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__EVENT = MCLASSIFIER__EVENT;

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
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE__OWNING_CONTEXT = MCLASSIFIER__OWNING_CONTEXT;

  /**
   * The number of structural features of the '<em>MInterface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINTERFACE_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MOperationImpl <em>MOperation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MOperationImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMOperation()
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
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION__RETURN = MELEMENT_FEATURE_COUNT + 12;

  /**
   * The number of structural features of the '<em>MOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOPERATION_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 13;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MParameterImpl <em>MParameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MParameterImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMParameter()
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
   * The feature id for the '<em><b>Lower Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__LOWER_BOUND_MULTIPLICITY = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Upper Bound Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__UPPER_BOUND_MULTIPLICITY = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__UNIQUE = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__ORDERED = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Generic Realization</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__GENERIC_REALIZATION = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__TYPE = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Event</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__EVENT = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER__OPERATION = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>MParameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPARAMETER_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MDataTypeImpl <em>MData Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MDataTypeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDataType()
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
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__SPECIALIZATION = MCLASSIFIER__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__CLASSIFIER = MCLASSIFIER__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__OWNED_BEHAVIOR = MCLASSIFIER__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__GUARD = MCLASSIFIER__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__EVENT = MCLASSIFIER__EVENT;

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
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE__OWNING_CONTEXT = MCLASSIFIER__OWNING_CONTEXT;

  /**
   * The number of structural features of the '<em>MData Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MDATA_TYPE_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MTypeImpl <em>MType</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MTypeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMType()
   * @generated
   */
  int MTYPE = 24;

  /**
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTYPE__SPECIALIZATION = 0;

  /**
   * The number of structural features of the '<em>MType</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MPrimitiveTypeImpl <em>MPrimitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MPrimitiveTypeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPrimitiveType()
   * @generated
   */
  int MPRIMITIVE_TYPE = 13;

  /**
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MPRIMITIVE_TYPE__SPECIALIZATION = MTYPE__SPECIALIZATION;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MEnumerationImpl <em>MEnumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MEnumerationImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMEnumeration()
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
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__SPECIALIZATION = MDATA_TYPE__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__CLASSIFIER = MDATA_TYPE__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__OWNED_BEHAVIOR = MDATA_TYPE__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__GUARD = MDATA_TYPE__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__EVENT = MDATA_TYPE__EVENT;

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
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MENUMERATION__OWNING_CONTEXT = MDATA_TYPE__OWNING_CONTEXT;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MStereotypeImpl <em>MStereotype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MStereotypeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMStereotype()
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
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE__GENERALIZATION = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MStereotype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTEREOTYPE_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MTagImpl <em>MTag</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MTagImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTag()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MCommentImpl <em>MComment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MCommentImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMComment()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl <em>MTagged Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MTaggedValueImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTaggedValue()
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
   * The feature id for the '<em><b>Value Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE__VALUE_REFERENCE = 3;

  /**
   * The number of structural features of the '<em>MTagged Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTAGGED_VALUE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MAspectImpl <em>MAspect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MAspectImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAspect()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MIntroductionImpl <em>MIntroduction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MIntroductionImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMIntroduction()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MPointcutImpl <em>MPointcut</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MPointcutImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPointcut()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MLiteralImpl <em>MLiteral</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MLiteralImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMLiteral()
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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MGenericImpl <em>MGeneric</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MGenericImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMGeneric()
   * @generated
   */
  int MGENERIC = 23;

  /**
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGENERIC__SPECIALIZATION = MTYPE__SPECIALIZATION;

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
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MExternalImpl <em>MExternal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MExternalImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMExternal()
   * @generated
   */
  int MEXTERNAL = 25;

  /**
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__SPECIALIZATION = MTYPE__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__NAME = MTYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__XMI_GUID = MTYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__OWNED_COMMENT = MTYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__TAGGED_VALUE = MTYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__STEREOTYPE = MTYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__ASPECT = MTYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__SPECIFICATION = MTYPE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__MODEL = MTYPE_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL__GENERIC_PARAMETER = MTYPE_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>MExternal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEXTERNAL_FEATURE_COUNT = MTYPE_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl <em>MBehavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MBehaviorImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMBehavior()
   * @generated
   */
  int MBEHAVIOR = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__CLASSIFIER = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__OWNED_BEHAVIOR = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__GUARD = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__EVENT = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__OWNING_CONTEXT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Transition</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__TRANSITION = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__ENTRY = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__EXIT = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR__DO = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>MBehavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MBEHAVIOR_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MActivityImpl <em>MActivity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MActivityImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMActivity()
   * @generated
   */
  int MACTIVITY = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__NAME = MBEHAVIOR__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__XMI_GUID = MBEHAVIOR__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__OWNED_COMMENT = MBEHAVIOR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__TAGGED_VALUE = MBEHAVIOR__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__STEREOTYPE = MBEHAVIOR__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__ASPECT = MBEHAVIOR__ASPECT;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__CLASSIFIER = MBEHAVIOR__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__OWNED_BEHAVIOR = MBEHAVIOR__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__GUARD = MBEHAVIOR__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__EVENT = MBEHAVIOR__EVENT;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__OWNING_CONTEXT = MBEHAVIOR__OWNING_CONTEXT;

  /**
   * The feature id for the '<em><b>Transition</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__TRANSITION = MBEHAVIOR__TRANSITION;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__ENTRY = MBEHAVIOR__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__EXIT = MBEHAVIOR__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__DO = MBEHAVIOR__DO;

  /**
   * The feature id for the '<em><b>Edge</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__EDGE = MBEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Node</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY__NODE = MBEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MActivity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTIVITY_FEATURE_COUNT = MBEHAVIOR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MNodeImpl <em>MNode</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MNodeImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMNode()
   * @generated
   */
  int MNODE = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>To</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__TO = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>From</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE__FROM = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MNode</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MNODE_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MActionImpl <em>MAction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MActionImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAction()
   * @generated
   */
  int MACTION = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__NAME = MNODE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__XMI_GUID = MNODE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__OWNED_COMMENT = MNODE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__TAGGED_VALUE = MNODE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__STEREOTYPE = MNODE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__ASPECT = MNODE__ASPECT;

  /**
   * The feature id for the '<em><b>To</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__TO = MNODE__TO;

  /**
   * The feature id for the '<em><b>From</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__FROM = MNODE__FROM;

  /**
   * The feature id for the '<em><b>Behavior</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__BEHAVIOR = MNODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Out</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__OUT = MNODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>In</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__IN = MNODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION__OPERATION = MNODE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MAction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACTION_FEATURE_COUNT = MNODE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MStateMachineImpl <em>MState Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MStateMachineImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMStateMachine()
   * @generated
   */
  int MSTATE_MACHINE = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__NAME = MBEHAVIOR__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__XMI_GUID = MBEHAVIOR__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__OWNED_COMMENT = MBEHAVIOR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__TAGGED_VALUE = MBEHAVIOR__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__STEREOTYPE = MBEHAVIOR__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__ASPECT = MBEHAVIOR__ASPECT;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__CLASSIFIER = MBEHAVIOR__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__OWNED_BEHAVIOR = MBEHAVIOR__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__GUARD = MBEHAVIOR__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__EVENT = MBEHAVIOR__EVENT;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__OWNING_CONTEXT = MBEHAVIOR__OWNING_CONTEXT;

  /**
   * The feature id for the '<em><b>Transition</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__TRANSITION = MBEHAVIOR__TRANSITION;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__ENTRY = MBEHAVIOR__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__EXIT = MBEHAVIOR__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__DO = MBEHAVIOR__DO;

  /**
   * The feature id for the '<em><b>Smstate</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__SMSTATE = MBEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Smtransition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__SMTRANSITION = MBEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Atomic Transition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE__ATOMIC_TRANSITION = MBEHAVIOR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MState Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_MACHINE_FEATURE_COUNT = MBEHAVIOR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MFlowImpl <em>MFlow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MFlowImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFlow()
   * @generated
   */
  int MFLOW = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__SOURCE = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__TARGET = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Guard</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__GUARD = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Transport</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW__TRANSPORT = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MFlow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFLOW_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MGuardImpl <em>MGuard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MGuardImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMGuard()
   * @generated
   */
  int MGUARD = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Transition</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__TRANSITION = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD__OWNING_CONTEXT = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MGuard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MGUARD_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MUseCaseImpl <em>MUse Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MUseCaseImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMUseCase()
   * @generated
   */
  int MUSE_CASE = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__NAME = MCLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__XMI_GUID = MCLASSIFIER__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__OWNED_COMMENT = MCLASSIFIER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__TAGGED_VALUE = MCLASSIFIER__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__STEREOTYPE = MCLASSIFIER__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__ASPECT = MCLASSIFIER__ASPECT;

  /**
   * The feature id for the '<em><b>Specialization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__SPECIALIZATION = MCLASSIFIER__SPECIALIZATION;

  /**
   * The feature id for the '<em><b>Classifier</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__CLASSIFIER = MCLASSIFIER__CLASSIFIER;

  /**
   * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__OWNED_BEHAVIOR = MCLASSIFIER__OWNED_BEHAVIOR;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__GUARD = MCLASSIFIER__GUARD;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__EVENT = MCLASSIFIER__EVENT;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__VISIBILITY = MCLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__ABSTRACT = MCLASSIFIER__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__FINAL = MCLASSIFIER__FINAL;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__OPERATION = MCLASSIFIER__OPERATION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__PROPERTY = MCLASSIFIER__PROPERTY;

  /**
   * The feature id for the '<em><b>Generic Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__GENERIC_PARAMETER = MCLASSIFIER__GENERIC_PARAMETER;

  /**
   * The feature id for the '<em><b>Realization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__REALIZATION = MCLASSIFIER__REALIZATION;

  /**
   * The feature id for the '<em><b>Generalization</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__GENERALIZATION = MCLASSIFIER__GENERALIZATION;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__SUPPLIER = MCLASSIFIER__SUPPLIER;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE__OWNING_CONTEXT = MCLASSIFIER__OWNING_CONTEXT;

  /**
   * The number of structural features of the '<em>MUse Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MUSE_CASE_FEATURE_COUNT = MCLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MInitialImpl <em>MInitial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MInitialImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInitial()
   * @generated
   */
  int MINITIAL = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__NAME = MNODE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__XMI_GUID = MNODE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__OWNED_COMMENT = MNODE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__TAGGED_VALUE = MNODE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__STEREOTYPE = MNODE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__ASPECT = MNODE__ASPECT;

  /**
   * The feature id for the '<em><b>To</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__TO = MNODE__TO;

  /**
   * The feature id for the '<em><b>From</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL__FROM = MNODE__FROM;

  /**
   * The number of structural features of the '<em>MInitial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_FEATURE_COUNT = MNODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MFinalImpl <em>MFinal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MFinalImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFinal()
   * @generated
   */
  int MFINAL = 35;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__NAME = MNODE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__XMI_GUID = MNODE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__OWNED_COMMENT = MNODE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__TAGGED_VALUE = MNODE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__STEREOTYPE = MNODE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__ASPECT = MNODE__ASPECT;

  /**
   * The feature id for the '<em><b>To</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__TO = MNODE__TO;

  /**
   * The feature id for the '<em><b>From</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL__FROM = MNODE__FROM;

  /**
   * The number of structural features of the '<em>MFinal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_FEATURE_COUNT = MNODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MStateImpl <em>MState</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMState()
   * @generated
   */
  int MSTATE = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__OWNER = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__OUTGOING = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__INCOMING = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__ENTRY = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__EXIT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__DO = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE__SUPERSTATE = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>MState</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSTATE_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MTransitionImpl <em>MTransition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MTransitionImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTransition()
   * @generated
   */
  int MTRANSITION = 37;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__KIND = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__SOURCE = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__TARGET = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Guard</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__GUARD = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Statemachine</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__STATEMACHINE = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__TRIGGER = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Action</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION__ACTION = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>MTransition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTRANSITION_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MEventImpl <em>MEvent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MEventImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMEvent()
   * @generated
   */
  int MEVENT = 39;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Is Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__IS_CALL = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is Change</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__IS_CHANGE = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__OWNING_CONTEXT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT__PARAMETER = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>MEvent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEVENT_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl <em>MAtomic Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAtomicTransition()
   * @generated
   */
  int MATOMIC_TRANSITION = 40;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__NAME = MELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__XMI_GUID = MELEMENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__OWNED_COMMENT = MELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__TAGGED_VALUE = MELEMENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__STEREOTYPE = MELEMENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__ASPECT = MELEMENT__ASPECT;

  /**
   * The feature id for the '<em><b>Defining Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__DEFINING_TRANSITION = MELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End Do</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__END_DO = MELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__EXIT = MELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Action</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__ACTION = MELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__ENTRY = MELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Start Do</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__START_DO = MELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>History Context</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__HISTORY_CONTEXT = MELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Statemachine</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__STATEMACHINE = MELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Start Timer</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__START_TIMER = MELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Stop Timer</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__STOP_TIMER = MELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__SOURCE = MELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION__TARGET = MELEMENT_FEATURE_COUNT + 11;

  /**
   * The number of structural features of the '<em>MAtomic Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATOMIC_TRANSITION_FEATURE_COUNT = MELEMENT_FEATURE_COUNT + 12;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MLeafStateImpl <em>MLeaf State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MLeafStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMLeafState()
   * @generated
   */
  int MLEAF_STATE = 41;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__NAME = MSTATE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__XMI_GUID = MSTATE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__OWNED_COMMENT = MSTATE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__TAGGED_VALUE = MSTATE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__STEREOTYPE = MSTATE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__ASPECT = MSTATE__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__OWNER = MSTATE__OWNER;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__OUTGOING = MSTATE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__INCOMING = MSTATE__INCOMING;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__ENTRY = MSTATE__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__EXIT = MSTATE__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__DO = MSTATE__DO;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE__SUPERSTATE = MSTATE__SUPERSTATE;

  /**
   * The number of structural features of the '<em>MLeaf State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MLEAF_STATE_FEATURE_COUNT = MSTATE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MCompositeStateImpl <em>MComposite State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MCompositeStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMCompositeState()
   * @generated
   */
  int MCOMPOSITE_STATE = 42;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__NAME = MSTATE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__XMI_GUID = MSTATE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__OWNED_COMMENT = MSTATE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__TAGGED_VALUE = MSTATE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__STEREOTYPE = MSTATE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__ASPECT = MSTATE__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__OWNER = MSTATE__OWNER;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__OUTGOING = MSTATE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__INCOMING = MSTATE__INCOMING;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__ENTRY = MSTATE__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__EXIT = MSTATE__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__DO = MSTATE__DO;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__SUPERSTATE = MSTATE__SUPERSTATE;

  /**
   * The feature id for the '<em><b>Substate</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE__SUBSTATE = MSTATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>MComposite State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MCOMPOSITE_STATE_FEATURE_COUNT = MSTATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MInitialStateImpl <em>MInitial State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MInitialStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInitialState()
   * @generated
   */
  int MINITIAL_STATE = 43;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__NAME = MLEAF_STATE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__XMI_GUID = MLEAF_STATE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__OWNED_COMMENT = MLEAF_STATE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__TAGGED_VALUE = MLEAF_STATE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__STEREOTYPE = MLEAF_STATE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__ASPECT = MLEAF_STATE__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__OWNER = MLEAF_STATE__OWNER;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__OUTGOING = MLEAF_STATE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__INCOMING = MLEAF_STATE__INCOMING;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__ENTRY = MLEAF_STATE__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__EXIT = MLEAF_STATE__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__DO = MLEAF_STATE__DO;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE__SUPERSTATE = MLEAF_STATE__SUPERSTATE;

  /**
   * The number of structural features of the '<em>MInitial State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINITIAL_STATE_FEATURE_COUNT = MLEAF_STATE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MFinalStateImpl <em>MFinal State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MFinalStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFinalState()
   * @generated
   */
  int MFINAL_STATE = 44;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__NAME = MLEAF_STATE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__XMI_GUID = MLEAF_STATE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__OWNED_COMMENT = MLEAF_STATE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__TAGGED_VALUE = MLEAF_STATE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__STEREOTYPE = MLEAF_STATE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__ASPECT = MLEAF_STATE__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__OWNER = MLEAF_STATE__OWNER;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__OUTGOING = MLEAF_STATE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__INCOMING = MLEAF_STATE__INCOMING;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__ENTRY = MLEAF_STATE__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__EXIT = MLEAF_STATE__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__DO = MLEAF_STATE__DO;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE__SUPERSTATE = MLEAF_STATE__SUPERSTATE;

  /**
   * The number of structural features of the '<em>MFinal State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MFINAL_STATE_FEATURE_COUNT = MLEAF_STATE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MHistoryStateImpl <em>MHistory State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MHistoryStateImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMHistoryState()
   * @generated
   */
  int MHISTORY_STATE = 45;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__NAME = MLEAF_STATE__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__XMI_GUID = MLEAF_STATE__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__OWNED_COMMENT = MLEAF_STATE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__TAGGED_VALUE = MLEAF_STATE__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__STEREOTYPE = MLEAF_STATE__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__ASPECT = MLEAF_STATE__ASPECT;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__OWNER = MLEAF_STATE__OWNER;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__OUTGOING = MLEAF_STATE__OUTGOING;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__INCOMING = MLEAF_STATE__INCOMING;

  /**
   * The feature id for the '<em><b>Entry</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__ENTRY = MLEAF_STATE__ENTRY;

  /**
   * The feature id for the '<em><b>Exit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__EXIT = MLEAF_STATE__EXIT;

  /**
   * The feature id for the '<em><b>Do</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__DO = MLEAF_STATE__DO;

  /**
   * The feature id for the '<em><b>Superstate</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__SUPERSTATE = MLEAF_STATE__SUPERSTATE;

  /**
   * The feature id for the '<em><b>Deep</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__DEEP = MLEAF_STATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Reachable History</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__REACHABLE_HISTORY = MLEAF_STATE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Default History</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE__DEFAULT_HISTORY = MLEAF_STATE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>MHistory State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MHISTORY_STATE_FEATURE_COUNT = MLEAF_STATE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.impl.MTimeEventImpl <em>MTime Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.impl.MTimeEventImpl
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTimeEvent()
   * @generated
   */
  int MTIME_EVENT = 46;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__NAME = MEVENT__NAME;

  /**
   * The feature id for the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__XMI_GUID = MEVENT__XMI_GUID;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__OWNED_COMMENT = MEVENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__TAGGED_VALUE = MEVENT__TAGGED_VALUE;

  /**
   * The feature id for the '<em><b>Stereotype</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__STEREOTYPE = MEVENT__STEREOTYPE;

  /**
   * The feature id for the '<em><b>Aspect</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__ASPECT = MEVENT__ASPECT;

  /**
   * The feature id for the '<em><b>Is Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__IS_CALL = MEVENT__IS_CALL;

  /**
   * The feature id for the '<em><b>Is Change</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__IS_CHANGE = MEVENT__IS_CHANGE;

  /**
   * The feature id for the '<em><b>Owning Context</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__OWNING_CONTEXT = MEVENT__OWNING_CONTEXT;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__PARAMETER = MEVENT__PARAMETER;

  /**
   * The feature id for the '<em><b>Is Relative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__IS_RELATIVE = MEVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>When</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT__WHEN = MEVENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>MTime Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MTIME_EVENT_FEATURE_COUNT = MEVENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gcore.MDestinationKind <em>MDestination Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gcore.MDestinationKind
   * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDestinationKind()
   * @generated
   */
  int MDESTINATION_KIND = 47;


  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MPackage <em>MPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPackage</em>'.
   * @see org.genesez.metamodel.gcore.MPackage
   * @generated
   */
  EClass getMPackage();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MPackage#getNestingPackage <em>Nesting Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Nesting Package</em>'.
   * @see org.genesez.metamodel.gcore.MPackage#getNestingPackage()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_NestingPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MPackage#getNestedPackage <em>Nested Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Package</em>'.
   * @see org.genesez.metamodel.gcore.MPackage#getNestedPackage()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_NestedPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MPackage#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association</em>'.
   * @see org.genesez.metamodel.gcore.MPackage#getAssociation()
   * @see #getMPackage()
   * @generated
   */
  EReference getMPackage_Association();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MClass <em>MClass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MClass</em>'.
   * @see org.genesez.metamodel.gcore.MClass
   * @generated
   */
  EClass getMClass();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MClass#getOwnedAssociation <em>Owned Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owned Association</em>'.
   * @see org.genesez.metamodel.gcore.MClass#getOwnedAssociation()
   * @see #getMClass()
   * @generated
   */
  EReference getMClass_OwnedAssociation();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAssociationRole <em>MAssociation Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAssociation Role</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole
   * @generated
   */
  EClass getMAssociationRole();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#isAggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Aggregation</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#isAggregation()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_Aggregation();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#isComposition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Composition</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#isComposition()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_Composition();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#getOppositeMultiplicity <em>Opposite Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opposite Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getOppositeMultiplicity()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_OppositeMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#getOppositeLowerBoundMultiplicity <em>Opposite Lower Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opposite Lower Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getOppositeLowerBoundMultiplicity()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_OppositeLowerBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#getOppositeUpperBoundMultiplicity <em>Opposite Upper Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opposite Upper Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getOppositeUpperBoundMultiplicity()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_OppositeUpperBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifierMultiplicity <em>Qualifier Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Qualifier Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getQualifierMultiplicity()
   * @see #getMAssociationRole()
   * @generated
   */
  EAttribute getMAssociationRole_QualifierMultiplicity();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAssociationRole#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getAssociation()
   * @see #getMAssociationRole()
   * @generated
   */
  EReference getMAssociationRole_Association();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAssociationRole#getOpposite <em>Opposite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Opposite</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getOpposite()
   * @see #getMAssociationRole()
   * @generated
   */
  EReference getMAssociationRole_Opposite();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAssociationRole#getQualifier <em>Qualifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Qualifier</em>'.
   * @see org.genesez.metamodel.gcore.MAssociationRole#getQualifier()
   * @see #getMAssociationRole()
   * @generated
   */
  EReference getMAssociationRole_Qualifier();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAssociation <em>MAssociation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAssociation</em>'.
   * @see org.genesez.metamodel.gcore.MAssociation
   * @generated
   */
  EClass getMAssociation();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAssociation#isDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Derived</em>'.
   * @see org.genesez.metamodel.gcore.MAssociation#isDerived()
   * @see #getMAssociation()
   * @generated
   */
  EAttribute getMAssociation_Derived();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAssociation#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>End</em>'.
   * @see org.genesez.metamodel.gcore.MAssociation#getEnd()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_End();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MAssociation#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Package</em>'.
   * @see org.genesez.metamodel.gcore.MAssociation#getOwningPackage()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_OwningPackage();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAssociation#getAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Association Class</em>'.
   * @see org.genesez.metamodel.gcore.MAssociation#getAssociationClass()
   * @see #getMAssociation()
   * @generated
   */
  EReference getMAssociation_AssociationClass();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAttribute <em>MAttribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAttribute</em>'.
   * @see org.genesez.metamodel.gcore.MAttribute
   * @generated
   */
  EClass getMAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAttribute#getDefaultvalue <em>Defaultvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defaultvalue</em>'.
   * @see org.genesez.metamodel.gcore.MAttribute#getDefaultvalue()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Defaultvalue();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAttribute#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.genesez.metamodel.gcore.MAttribute#isStatic()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Static();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAttribute#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.genesez.metamodel.gcore.MAttribute#isFinal()
   * @see #getMAttribute()
   * @generated
   */
  EAttribute getMAttribute_Final();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MModel <em>MModel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MModel</em>'.
   * @see org.genesez.metamodel.gcore.MModel
   * @generated
   */
  EClass getMModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MModel#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
   * @see org.genesez.metamodel.gcore.MModel#getPrimitiveTypes()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_PrimitiveTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MModel#getAnyStereotype <em>Any Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Any Stereotype</em>'.
   * @see org.genesez.metamodel.gcore.MModel#getAnyStereotype()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_AnyStereotype();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Types</em>'.
   * @see org.genesez.metamodel.gcore.MModel#getExternalTypes()
   * @see #getMModel()
   * @generated
   */
  EReference getMModel_ExternalTypes();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MElement <em>MElement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MElement</em>'.
   * @see org.genesez.metamodel.gcore.MElement
   * @generated
   */
  EClass getMElement();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getName()
   * @see #getMElement()
   * @generated
   */
  EAttribute getMElement_Name();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MElement#getXmiGuid <em>Xmi Guid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xmi Guid</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getXmiGuid()
   * @see #getMElement()
   * @generated
   */
  EAttribute getMElement_XmiGuid();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MElement#getOwnedComment <em>Owned Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Comment</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getOwnedComment()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_OwnedComment();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MElement#getTaggedValue <em>Tagged Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tagged Value</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getTaggedValue()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_TaggedValue();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MElement#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stereotype</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getStereotype()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_Stereotype();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MElement#getAspect <em>Aspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Aspect</em>'.
   * @see org.genesez.metamodel.gcore.MElement#getAspect()
   * @see #getMElement()
   * @generated
   */
  EReference getMElement_Aspect();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MProperty <em>MProperty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MProperty</em>'.
   * @see org.genesez.metamodel.gcore.MProperty
   * @generated
   */
  EClass getMProperty();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getVisibility()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#isDerived <em>Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Derived</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#isDerived()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Derived();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getMultiplicity()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#getLowerBoundMultiplicity <em>Lower Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getLowerBoundMultiplicity()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_LowerBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#getUpperBoundMultiplicity <em>Upper Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getUpperBoundMultiplicity()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_UpperBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#isUnique()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Unique();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MProperty#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#isOrdered()
   * @see #getMProperty()
   * @generated
   */
  EAttribute getMProperty_Ordered();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MProperty#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Classifier</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getClassifier()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MProperty#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Realization</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getGenericRealization()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_GenericRealization();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MProperty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.genesez.metamodel.gcore.MProperty#getType()
   * @see #getMProperty()
   * @generated
   */
  EReference getMProperty_Type();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MInterface <em>MInterface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MInterface</em>'.
   * @see org.genesez.metamodel.gcore.MInterface
   * @generated
   */
  EClass getMInterface();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MClassifier <em>MClassifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MClassifier</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier
   * @generated
   */
  EClass getMClassifier();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MClassifier#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getVisibility()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MClassifier#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#isAbstract()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MClassifier#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#isFinal()
   * @see #getMClassifier()
   * @generated
   */
  EAttribute getMClassifier_Final();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MClassifier#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operation</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getOperation()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MClassifier#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getProperty()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Property();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MClassifier#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getGenericParameter()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_GenericParameter();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MClassifier#getRealization <em>Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Realization</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getRealization()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Realization();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MClassifier#getGeneralization <em>Generalization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Generalization</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getGeneralization()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Generalization();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MClassifier#getSupplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Supplier</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getSupplier()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_Supplier();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MClassifier#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Context</em>'.
   * @see org.genesez.metamodel.gcore.MClassifier#getOwningContext()
   * @see #getMClassifier()
   * @generated
   */
  EReference getMClassifier_OwningContext();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MOperation <em>MOperation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MOperation</em>'.
   * @see org.genesez.metamodel.gcore.MOperation
   * @generated
   */
  EClass getMOperation();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getVisibility()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#isStatic()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Static();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#isAbstract()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#isFinal()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Final();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getMultiplicity()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#isUnique()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Unique();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MOperation#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#isOrdered()
   * @see #getMOperation()
   * @generated
   */
  EAttribute getMOperation_Ordered();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MOperation#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getParameter()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_Parameter();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MOperation#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Classifier</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getClassifier()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MOperation#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getGenericParameter()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_GenericParameter();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MOperation#getRaisedException <em>Raised Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Raised Exception</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getRaisedException()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_RaisedException();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MOperation#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Return Type</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getReturnType()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_ReturnType();

  /**
   * Returns the meta object for the containment reference '{@link org.genesez.metamodel.gcore.MOperation#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see org.genesez.metamodel.gcore.MOperation#getReturn()
   * @see #getMOperation()
   * @generated
   */
  EReference getMOperation_Return();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MParameter <em>MParameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MParameter</em>'.
   * @see org.genesez.metamodel.gcore.MParameter
   * @generated
   */
  EClass getMParameter();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#getDefaultvalue <em>Defaultvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Defaultvalue</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getDefaultvalue()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Defaultvalue();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getDirection()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Direction();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getMultiplicity()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#getLowerBoundMultiplicity <em>Lower Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getLowerBoundMultiplicity()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_LowerBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#getUpperBoundMultiplicity <em>Upper Bound Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound Multiplicity</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getUpperBoundMultiplicity()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_UpperBoundMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#isUnique()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Unique();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MParameter#isOrdered <em>Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ordered</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#isOrdered()
   * @see #getMParameter()
   * @generated
   */
  EAttribute getMParameter_Ordered();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MParameter#getGenericRealization <em>Generic Realization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Realization</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getGenericRealization()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_GenericRealization();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getType()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_Type();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MParameter#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Event</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getEvent()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_Event();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MParameter#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.genesez.metamodel.gcore.MParameter#getOperation()
   * @see #getMParameter()
   * @generated
   */
  EReference getMParameter_Operation();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MDataType <em>MData Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MData Type</em>'.
   * @see org.genesez.metamodel.gcore.MDataType
   * @generated
   */
  EClass getMDataType();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MPrimitiveType <em>MPrimitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPrimitive Type</em>'.
   * @see org.genesez.metamodel.gcore.MPrimitiveType
   * @generated
   */
  EClass getMPrimitiveType();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MPrimitiveType#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.gcore.MPrimitiveType#getModel()
   * @see #getMPrimitiveType()
   * @generated
   */
  EReference getMPrimitiveType_Model();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MEnumeration <em>MEnumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MEnumeration</em>'.
   * @see org.genesez.metamodel.gcore.MEnumeration
   * @generated
   */
  EClass getMEnumeration();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MEnumeration#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literal</em>'.
   * @see org.genesez.metamodel.gcore.MEnumeration#getLiteral()
   * @see #getMEnumeration()
   * @generated
   */
  EReference getMEnumeration_Literal();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MStereotype <em>MStereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MStereotype</em>'.
   * @see org.genesez.metamodel.gcore.MStereotype
   * @generated
   */
  EClass getMStereotype();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MStereotype#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property</em>'.
   * @see org.genesez.metamodel.gcore.MStereotype#getProperty()
   * @see #getMStereotype()
   * @generated
   */
  EReference getMStereotype_Property();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.gcore.MStereotype#getModel()
   * @see #getMStereotype()
   * @generated
   */
  EReference getMStereotype_Model();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MStereotype#getGeneralization <em>Generalization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Generalization</em>'.
   * @see org.genesez.metamodel.gcore.MStereotype#getGeneralization()
   * @see #getMStereotype()
   * @generated
   */
  EReference getMStereotype_Generalization();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MTag <em>MTag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTag</em>'.
   * @see org.genesez.metamodel.gcore.MTag
   * @generated
   */
  EClass getMTag();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTag#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gcore.MTag#getName()
   * @see #getMTag()
   * @generated
   */
  EAttribute getMTag_Name();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTag#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.genesez.metamodel.gcore.MTag#getType()
   * @see #getMTag()
   * @generated
   */
  EAttribute getMTag_Type();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MTag#getStereotype <em>Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Stereotype</em>'.
   * @see org.genesez.metamodel.gcore.MTag#getStereotype()
   * @see #getMTag()
   * @generated
   */
  EReference getMTag_Stereotype();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MComment <em>MComment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MComment</em>'.
   * @see org.genesez.metamodel.gcore.MComment
   * @generated
   */
  EClass getMComment();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MComment#getXmiGuid <em>Xmi Guid</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xmi Guid</em>'.
   * @see org.genesez.metamodel.gcore.MComment#getXmiGuid()
   * @see #getMComment()
   * @generated
   */
  EAttribute getMComment_XmiGuid();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MComment#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Annotation</em>'.
   * @see org.genesez.metamodel.gcore.MComment#getAnnotation()
   * @see #getMComment()
   * @generated
   */
  EAttribute getMComment_Annotation();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MComment#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Element</em>'.
   * @see org.genesez.metamodel.gcore.MComment#getOwningElement()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_OwningElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MComment#getNestedComment <em>Nested Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Comment</em>'.
   * @see org.genesez.metamodel.gcore.MComment#getNestedComment()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_NestedComment();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MComment#getNestingComment <em>Nesting Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Nesting Comment</em>'.
   * @see org.genesez.metamodel.gcore.MComment#getNestingComment()
   * @see #getMComment()
   * @generated
   */
  EReference getMComment_NestingComment();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MTaggedValue <em>MTagged Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTagged Value</em>'.
   * @see org.genesez.metamodel.gcore.MTaggedValue
   * @generated
   */
  EClass getMTaggedValue();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTaggedValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.genesez.metamodel.gcore.MTaggedValue#getValue()
   * @see #getMTaggedValue()
   * @generated
   */
  EAttribute getMTaggedValue_Value();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MTaggedValue#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Element</em>'.
   * @see org.genesez.metamodel.gcore.MTaggedValue#getOwningElement()
   * @see #getMTaggedValue()
   * @generated
   */
  EReference getMTaggedValue_OwningElement();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTaggedValue#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Tag</em>'.
   * @see org.genesez.metamodel.gcore.MTaggedValue#getTag()
   * @see #getMTaggedValue()
   * @generated
   */
  EReference getMTaggedValue_Tag();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTaggedValue#getValueReference <em>Value Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value Reference</em>'.
   * @see org.genesez.metamodel.gcore.MTaggedValue#getValueReference()
   * @see #getMTaggedValue()
   * @generated
   */
  EReference getMTaggedValue_ValueReference();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAspect <em>MAspect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAspect</em>'.
   * @see org.genesez.metamodel.gcore.MAspect
   * @generated
   */
  EClass getMAspect();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAspect#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see org.genesez.metamodel.gcore.MAspect#getDomain()
   * @see #getMAspect()
   * @generated
   */
  EAttribute getMAspect_Domain();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MAspect#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gcore.MAspect#getName()
   * @see #getMAspect()
   * @generated
   */
  EAttribute getMAspect_Name();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MAspect#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Element</em>'.
   * @see org.genesez.metamodel.gcore.MAspect#getElement()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Element();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MAspect#getIntroduction <em>Introduction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Introduction</em>'.
   * @see org.genesez.metamodel.gcore.MAspect#getIntroduction()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Introduction();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MAspect#getPointcut <em>Pointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pointcut</em>'.
   * @see org.genesez.metamodel.gcore.MAspect#getPointcut()
   * @see #getMAspect()
   * @generated
   */
  EReference getMAspect_Pointcut();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MIntroduction <em>MIntroduction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MIntroduction</em>'.
   * @see org.genesez.metamodel.gcore.MIntroduction
   * @generated
   */
  EClass getMIntroduction();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MIntroduction#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see org.genesez.metamodel.gcore.MIntroduction#getDomain()
   * @see #getMIntroduction()
   * @generated
   */
  EAttribute getMIntroduction_Domain();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MIntroduction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gcore.MIntroduction#getName()
   * @see #getMIntroduction()
   * @generated
   */
  EAttribute getMIntroduction_Name();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MIntroduction#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Origin</em>'.
   * @see org.genesez.metamodel.gcore.MIntroduction#getOrigin()
   * @see #getMIntroduction()
   * @generated
   */
  EReference getMIntroduction_Origin();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MPointcut <em>MPointcut</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MPointcut</em>'.
   * @see org.genesez.metamodel.gcore.MPointcut
   * @generated
   */
  EClass getMPointcut();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MPointcut#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Domain</em>'.
   * @see org.genesez.metamodel.gcore.MPointcut#getDomain()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Domain();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MPointcut#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gcore.MPointcut#getName()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Name();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MPointcut#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Destination</em>'.
   * @see org.genesez.metamodel.gcore.MPointcut#getDestination()
   * @see #getMPointcut()
   * @generated
   */
  EAttribute getMPointcut_Destination();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MPointcut#getOrigin <em>Origin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Origin</em>'.
   * @see org.genesez.metamodel.gcore.MPointcut#getOrigin()
   * @see #getMPointcut()
   * @generated
   */
  EReference getMPointcut_Origin();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MLiteral <em>MLiteral</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MLiteral</em>'.
   * @see org.genesez.metamodel.gcore.MLiteral
   * @generated
   */
  EClass getMLiteral();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MLiteral#getOwningEnumeration <em>Owning Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Enumeration</em>'.
   * @see org.genesez.metamodel.gcore.MLiteral#getOwningEnumeration()
   * @see #getMLiteral()
   * @generated
   */
  EReference getMLiteral_OwningEnumeration();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MGeneric <em>MGeneric</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MGeneric</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric
   * @generated
   */
  EClass getMGeneric();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MGeneric#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Specification</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getSpecification()
   * @see #getMGeneric()
   * @generated
   */
  EAttribute getMGeneric_Specification();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGeneric#getOwningClassifier <em>Owning Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Classifier</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningClassifier()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningClassifier();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGeneric#getOwningOperation <em>Owning Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Operation</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningOperation()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningOperation();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGeneric#getOwningProperty <em>Owning Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Property</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningProperty()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningProperty();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGeneric#getOwningParameter <em>Owning Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningParameter()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningParameter();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGeneric#getOwningExternal <em>Owning External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning External</em>'.
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningExternal()
   * @see #getMGeneric()
   * @generated
   */
  EReference getMGeneric_OwningExternal();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MType <em>MType</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MType</em>'.
   * @see org.genesez.metamodel.gcore.MType
   * @generated
   */
  EClass getMType();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MType#getSpecialization <em>Specialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Specialization</em>'.
   * @see org.genesez.metamodel.gcore.MType#getSpecialization()
   * @see #getMType()
   * @generated
   */
  EReference getMType_Specialization();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MExternal <em>MExternal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MExternal</em>'.
   * @see org.genesez.metamodel.gcore.MExternal
   * @generated
   */
  EClass getMExternal();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MExternal#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Specification</em>'.
   * @see org.genesez.metamodel.gcore.MExternal#getSpecification()
   * @see #getMExternal()
   * @generated
   */
  EAttribute getMExternal_Specification();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MExternal#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.genesez.metamodel.gcore.MExternal#getModel()
   * @see #getMExternal()
   * @generated
   */
  EReference getMExternal_Model();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MExternal#getGenericParameter <em>Generic Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generic Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MExternal#getGenericParameter()
   * @see #getMExternal()
   * @generated
   */
  EReference getMExternal_GenericParameter();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MActivity <em>MActivity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MActivity</em>'.
   * @see org.genesez.metamodel.gcore.MActivity
   * @generated
   */
  EClass getMActivity();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MActivity#getEdge <em>Edge</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Edge</em>'.
   * @see org.genesez.metamodel.gcore.MActivity#getEdge()
   * @see #getMActivity()
   * @generated
   */
  EReference getMActivity_Edge();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MActivity#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node</em>'.
   * @see org.genesez.metamodel.gcore.MActivity#getNode()
   * @see #getMActivity()
   * @generated
   */
  EReference getMActivity_Node();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAction <em>MAction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAction</em>'.
   * @see org.genesez.metamodel.gcore.MAction
   * @generated
   */
  EClass getMAction();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAction#getBehavior <em>Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Behavior</em>'.
   * @see org.genesez.metamodel.gcore.MAction#getBehavior()
   * @see #getMAction()
   * @generated
   */
  EReference getMAction_Behavior();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAction#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Out</em>'.
   * @see org.genesez.metamodel.gcore.MAction#getOut()
   * @see #getMAction()
   * @generated
   */
  EReference getMAction_Out();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAction#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>In</em>'.
   * @see org.genesez.metamodel.gcore.MAction#getIn()
   * @see #getMAction()
   * @generated
   */
  EReference getMAction_In();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAction#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.genesez.metamodel.gcore.MAction#getOperation()
   * @see #getMAction()
   * @generated
   */
  EReference getMAction_Operation();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MBehavior <em>MBehavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MBehavior</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior
   * @generated
   */
  EClass getMBehavior();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MBehavior#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Context</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior#getOwningContext()
   * @see #getMBehavior()
   * @generated
   */
  EReference getMBehavior_OwningContext();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MBehavior#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Transition</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior#getTransition()
   * @see #getMBehavior()
   * @generated
   */
  EReference getMBehavior_Transition();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MBehavior#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Entry</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior#getEntry()
   * @see #getMBehavior()
   * @generated
   */
  EReference getMBehavior_Entry();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MBehavior#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Exit</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior#getExit()
   * @see #getMBehavior()
   * @generated
   */
  EReference getMBehavior_Exit();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MBehavior#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Do</em>'.
   * @see org.genesez.metamodel.gcore.MBehavior#getDo()
   * @see #getMBehavior()
   * @generated
   */
  EReference getMBehavior_Do();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MStateMachine <em>MState Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MState Machine</em>'.
   * @see org.genesez.metamodel.gcore.MStateMachine
   * @generated
   */
  EClass getMStateMachine();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MStateMachine#getSmstate <em>Smstate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Smstate</em>'.
   * @see org.genesez.metamodel.gcore.MStateMachine#getSmstate()
   * @see #getMStateMachine()
   * @generated
   */
  EReference getMStateMachine_Smstate();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MStateMachine#getSmtransition <em>Smtransition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Smtransition</em>'.
   * @see org.genesez.metamodel.gcore.MStateMachine#getSmtransition()
   * @see #getMStateMachine()
   * @generated
   */
  EReference getMStateMachine_Smtransition();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MStateMachine#getAtomicTransition <em>Atomic Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Atomic Transition</em>'.
   * @see org.genesez.metamodel.gcore.MStateMachine#getAtomicTransition()
   * @see #getMStateMachine()
   * @generated
   */
  EReference getMStateMachine_AtomicTransition();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MFlow <em>MFlow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MFlow</em>'.
   * @see org.genesez.metamodel.gcore.MFlow
   * @generated
   */
  EClass getMFlow();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MFlow#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.genesez.metamodel.gcore.MFlow#getSource()
   * @see #getMFlow()
   * @generated
   */
  EReference getMFlow_Source();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MFlow#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.genesez.metamodel.gcore.MFlow#getTarget()
   * @see #getMFlow()
   * @generated
   */
  EReference getMFlow_Target();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MFlow#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Guard</em>'.
   * @see org.genesez.metamodel.gcore.MFlow#getGuard()
   * @see #getMFlow()
   * @generated
   */
  EReference getMFlow_Guard();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MFlow#getTransport <em>Transport</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Transport</em>'.
   * @see org.genesez.metamodel.gcore.MFlow#getTransport()
   * @see #getMFlow()
   * @generated
   */
  EReference getMFlow_Transport();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MNode <em>MNode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MNode</em>'.
   * @see org.genesez.metamodel.gcore.MNode
   * @generated
   */
  EClass getMNode();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MNode#getTo <em>To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>To</em>'.
   * @see org.genesez.metamodel.gcore.MNode#getTo()
   * @see #getMNode()
   * @generated
   */
  EReference getMNode_To();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MNode#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>From</em>'.
   * @see org.genesez.metamodel.gcore.MNode#getFrom()
   * @see #getMNode()
   * @generated
   */
  EReference getMNode_From();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MGuard <em>MGuard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MGuard</em>'.
   * @see org.genesez.metamodel.gcore.MGuard
   * @generated
   */
  EClass getMGuard();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MGuard#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Transition</em>'.
   * @see org.genesez.metamodel.gcore.MGuard#getTransition()
   * @see #getMGuard()
   * @generated
   */
  EReference getMGuard_Transition();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MGuard#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Context</em>'.
   * @see org.genesez.metamodel.gcore.MGuard#getOwningContext()
   * @see #getMGuard()
   * @generated
   */
  EReference getMGuard_OwningContext();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MUseCase <em>MUse Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MUse Case</em>'.
   * @see org.genesez.metamodel.gcore.MUseCase
   * @generated
   */
  EClass getMUseCase();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MInitial <em>MInitial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MInitial</em>'.
   * @see org.genesez.metamodel.gcore.MInitial
   * @generated
   */
  EClass getMInitial();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MFinal <em>MFinal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MFinal</em>'.
   * @see org.genesez.metamodel.gcore.MFinal
   * @generated
   */
  EClass getMFinal();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MState <em>MState</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MState</em>'.
   * @see org.genesez.metamodel.gcore.MState
   * @generated
   */
  EClass getMState();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MState#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owner</em>'.
   * @see org.genesez.metamodel.gcore.MState#getOwner()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Owner();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MState#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outgoing</em>'.
   * @see org.genesez.metamodel.gcore.MState#getOutgoing()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Outgoing();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MState#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Incoming</em>'.
   * @see org.genesez.metamodel.gcore.MState#getIncoming()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Incoming();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MState#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Entry</em>'.
   * @see org.genesez.metamodel.gcore.MState#getEntry()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Entry();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MState#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Exit</em>'.
   * @see org.genesez.metamodel.gcore.MState#getExit()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Exit();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MState#getDo <em>Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Do</em>'.
   * @see org.genesez.metamodel.gcore.MState#getDo()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Do();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MState#getSuperstate <em>Superstate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Superstate</em>'.
   * @see org.genesez.metamodel.gcore.MState#getSuperstate()
   * @see #getMState()
   * @generated
   */
  EReference getMState_Superstate();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MTransition <em>MTransition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTransition</em>'.
   * @see org.genesez.metamodel.gcore.MTransition
   * @generated
   */
  EClass getMTransition();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTransition#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getKind()
   * @see #getMTransition()
   * @generated
   */
  EAttribute getMTransition_Kind();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTransition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getSource()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Source();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTransition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getTarget()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Target();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTransition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Guard</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getGuard()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Guard();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MTransition#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Statemachine</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getStatemachine()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Statemachine();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MTransition#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Trigger</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getTrigger()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Trigger();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MTransition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Action</em>'.
   * @see org.genesez.metamodel.gcore.MTransition#getAction()
   * @see #getMTransition()
   * @generated
   */
  EReference getMTransition_Action();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MDefinitionContext <em>MDefinition Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MDefinition Context</em>'.
   * @see org.genesez.metamodel.gcore.MDefinitionContext
   * @generated
   */
  EClass getMDefinitionContext();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MDefinitionContext#getClassifier <em>Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classifier</em>'.
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getClassifier()
   * @see #getMDefinitionContext()
   * @generated
   */
  EReference getMDefinitionContext_Classifier();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MDefinitionContext#getOwnedBehavior <em>Owned Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Behavior</em>'.
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getOwnedBehavior()
   * @see #getMDefinitionContext()
   * @generated
   */
  EReference getMDefinitionContext_OwnedBehavior();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MDefinitionContext#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Guard</em>'.
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getGuard()
   * @see #getMDefinitionContext()
   * @generated
   */
  EReference getMDefinitionContext_Guard();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MDefinitionContext#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Event</em>'.
   * @see org.genesez.metamodel.gcore.MDefinitionContext#getEvent()
   * @see #getMDefinitionContext()
   * @generated
   */
  EReference getMDefinitionContext_Event();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MEvent <em>MEvent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MEvent</em>'.
   * @see org.genesez.metamodel.gcore.MEvent
   * @generated
   */
  EClass getMEvent();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MEvent#isIsCall <em>Is Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Call</em>'.
   * @see org.genesez.metamodel.gcore.MEvent#isIsCall()
   * @see #getMEvent()
   * @generated
   */
  EAttribute getMEvent_IsCall();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MEvent#isIsChange <em>Is Change</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Change</em>'.
   * @see org.genesez.metamodel.gcore.MEvent#isIsChange()
   * @see #getMEvent()
   * @generated
   */
  EAttribute getMEvent_IsChange();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MEvent#getOwningContext <em>Owning Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Context</em>'.
   * @see org.genesez.metamodel.gcore.MEvent#getOwningContext()
   * @see #getMEvent()
   * @generated
   */
  EReference getMEvent_OwningContext();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gcore.MEvent#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see org.genesez.metamodel.gcore.MEvent#getParameter()
   * @see #getMEvent()
   * @generated
   */
  EReference getMEvent_Parameter();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MAtomicTransition <em>MAtomic Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MAtomic Transition</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition
   * @generated
   */
  EClass getMAtomicTransition();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAtomicTransition#getDefiningTransition <em>Defining Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Defining Transition</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getDefiningTransition()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_DefiningTransition();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getEndDo <em>End Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>End Do</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getEndDo()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_EndDo();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getExit <em>Exit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Exit</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getExit()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Exit();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Action</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getAction()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Action();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Entry</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getEntry()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Entry();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getStartDo <em>Start Do</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Start Do</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getStartDo()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_StartDo();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getHistoryContext <em>History Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>History Context</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getHistoryContext()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_HistoryContext();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gcore.MAtomicTransition#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Statemachine</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getStatemachine()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Statemachine();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getStartTimer <em>Start Timer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Start Timer</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getStartTimer()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_StartTimer();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MAtomicTransition#getStopTimer <em>Stop Timer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stop Timer</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getStopTimer()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_StopTimer();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAtomicTransition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getSource()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Source();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MAtomicTransition#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.genesez.metamodel.gcore.MAtomicTransition#getTarget()
   * @see #getMAtomicTransition()
   * @generated
   */
  EReference getMAtomicTransition_Target();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MLeafState <em>MLeaf State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MLeaf State</em>'.
   * @see org.genesez.metamodel.gcore.MLeafState
   * @generated
   */
  EClass getMLeafState();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MCompositeState <em>MComposite State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MComposite State</em>'.
   * @see org.genesez.metamodel.gcore.MCompositeState
   * @generated
   */
  EClass getMCompositeState();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MCompositeState#getSubstate <em>Substate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Substate</em>'.
   * @see org.genesez.metamodel.gcore.MCompositeState#getSubstate()
   * @see #getMCompositeState()
   * @generated
   */
  EReference getMCompositeState_Substate();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MInitialState <em>MInitial State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MInitial State</em>'.
   * @see org.genesez.metamodel.gcore.MInitialState
   * @generated
   */
  EClass getMInitialState();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MFinalState <em>MFinal State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MFinal State</em>'.
   * @see org.genesez.metamodel.gcore.MFinalState
   * @generated
   */
  EClass getMFinalState();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MHistoryState <em>MHistory State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MHistory State</em>'.
   * @see org.genesez.metamodel.gcore.MHistoryState
   * @generated
   */
  EClass getMHistoryState();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MHistoryState#isDeep <em>Deep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Deep</em>'.
   * @see org.genesez.metamodel.gcore.MHistoryState#isDeep()
   * @see #getMHistoryState()
   * @generated
   */
  EAttribute getMHistoryState_Deep();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gcore.MHistoryState#getReachableHistory <em>Reachable History</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Reachable History</em>'.
   * @see org.genesez.metamodel.gcore.MHistoryState#getReachableHistory()
   * @see #getMHistoryState()
   * @generated
   */
  EReference getMHistoryState_ReachableHistory();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gcore.MHistoryState#getDefaultHistory <em>Default History</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Default History</em>'.
   * @see org.genesez.metamodel.gcore.MHistoryState#getDefaultHistory()
   * @see #getMHistoryState()
   * @generated
   */
  EReference getMHistoryState_DefaultHistory();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gcore.MTimeEvent <em>MTime Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MTime Event</em>'.
   * @see org.genesez.metamodel.gcore.MTimeEvent
   * @generated
   */
  EClass getMTimeEvent();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTimeEvent#isIsRelative <em>Is Relative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Relative</em>'.
   * @see org.genesez.metamodel.gcore.MTimeEvent#isIsRelative()
   * @see #getMTimeEvent()
   * @generated
   */
  EAttribute getMTimeEvent_IsRelative();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gcore.MTimeEvent#getWhen <em>When</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>When</em>'.
   * @see org.genesez.metamodel.gcore.MTimeEvent#getWhen()
   * @see #getMTimeEvent()
   * @generated
   */
  EAttribute getMTimeEvent_When();

  /**
   * Returns the meta object for enum '{@link org.genesez.metamodel.gcore.MDestinationKind <em>MDestination Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>MDestination Kind</em>'.
   * @see org.genesez.metamodel.gcore.MDestinationKind
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
  GcoreFactory getGcoreFactory();

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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MPackageImpl <em>MPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MPackageImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPackage()
     * @generated
     */
    EClass MPACKAGE = eINSTANCE.getMPackage();

    /**
     * The meta object literal for the '<em><b>Nesting Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPACKAGE__NESTING_PACKAGE = eINSTANCE.getMPackage_NestingPackage();

    /**
     * The meta object literal for the '<em><b>Nested Package</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPACKAGE__NESTED_PACKAGE = eINSTANCE.getMPackage_NestedPackage();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPACKAGE__ASSOCIATION = eINSTANCE.getMPackage_Association();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MClassImpl <em>MClass</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MClassImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMClass()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl <em>MAssociation Role</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MAssociationRoleImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAssociationRole()
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
     * The meta object literal for the '<em><b>Opposite Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY = eINSTANCE.getMAssociationRole_OppositeMultiplicity();

    /**
     * The meta object literal for the '<em><b>Opposite Lower Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__OPPOSITE_LOWER_BOUND_MULTIPLICITY = eINSTANCE.getMAssociationRole_OppositeLowerBoundMultiplicity();

    /**
     * The meta object literal for the '<em><b>Opposite Upper Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__OPPOSITE_UPPER_BOUND_MULTIPLICITY = eINSTANCE.getMAssociationRole_OppositeUpperBoundMultiplicity();

    /**
     * The meta object literal for the '<em><b>Qualifier Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY = eINSTANCE.getMAssociationRole_QualifierMultiplicity();

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
     * The meta object literal for the '<em><b>Qualifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MASSOCIATION_ROLE__QUALIFIER = eINSTANCE.getMAssociationRole_Qualifier();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MAssociationImpl <em>MAssociation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MAssociationImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAssociation()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MAttributeImpl <em>MAttribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MAttributeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAttribute()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MModelImpl <em>MModel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MModelImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMModel()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MElementImpl <em>MElement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MElementImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMElement()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MPropertyImpl <em>MProperty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MPropertyImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMProperty()
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
     * The meta object literal for the '<em><b>Lower Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__LOWER_BOUND_MULTIPLICITY = eINSTANCE.getMProperty_LowerBoundMultiplicity();

    /**
     * The meta object literal for the '<em><b>Upper Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPROPERTY__UPPER_BOUND_MULTIPLICITY = eINSTANCE.getMProperty_UpperBoundMultiplicity();

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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MInterfaceImpl <em>MInterface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MInterfaceImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInterface()
     * @generated
     */
    EClass MINTERFACE = eINSTANCE.getMInterface();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MClassifierImpl <em>MClassifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MClassifierImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMClassifier()
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
     * The meta object literal for the '<em><b>Owning Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCLASSIFIER__OWNING_CONTEXT = eINSTANCE.getMClassifier_OwningContext();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MOperationImpl <em>MOperation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MOperationImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMOperation()
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
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOPERATION__RETURN = eINSTANCE.getMOperation_Return();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MParameterImpl <em>MParameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MParameterImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMParameter()
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
     * The meta object literal for the '<em><b>Lower Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__LOWER_BOUND_MULTIPLICITY = eINSTANCE.getMParameter_LowerBoundMultiplicity();

    /**
     * The meta object literal for the '<em><b>Upper Bound Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MPARAMETER__UPPER_BOUND_MULTIPLICITY = eINSTANCE.getMParameter_UpperBoundMultiplicity();

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
     * The meta object literal for the '<em><b>Event</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPARAMETER__EVENT = eINSTANCE.getMParameter_Event();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MPARAMETER__OPERATION = eINSTANCE.getMParameter_Operation();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MDataTypeImpl <em>MData Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MDataTypeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDataType()
     * @generated
     */
    EClass MDATA_TYPE = eINSTANCE.getMDataType();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MPrimitiveTypeImpl <em>MPrimitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MPrimitiveTypeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPrimitiveType()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MEnumerationImpl <em>MEnumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MEnumerationImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMEnumeration()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MStereotypeImpl <em>MStereotype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MStereotypeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMStereotype()
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
     * The meta object literal for the '<em><b>Generalization</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTEREOTYPE__GENERALIZATION = eINSTANCE.getMStereotype_Generalization();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MTagImpl <em>MTag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MTagImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTag()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MCommentImpl <em>MComment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MCommentImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMComment()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl <em>MTagged Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MTaggedValueImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTaggedValue()
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
     * The meta object literal for the '<em><b>Value Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTAGGED_VALUE__VALUE_REFERENCE = eINSTANCE.getMTaggedValue_ValueReference();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MAspectImpl <em>MAspect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MAspectImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAspect()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MIntroductionImpl <em>MIntroduction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MIntroductionImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMIntroduction()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MPointcutImpl <em>MPointcut</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MPointcutImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMPointcut()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MLiteralImpl <em>MLiteral</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MLiteralImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMLiteral()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MGenericImpl <em>MGeneric</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MGenericImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMGeneric()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MTypeImpl <em>MType</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MTypeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMType()
     * @generated
     */
    EClass MTYPE = eINSTANCE.getMType();

    /**
     * The meta object literal for the '<em><b>Specialization</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTYPE__SPECIALIZATION = eINSTANCE.getMType_Specialization();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MExternalImpl <em>MExternal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MExternalImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMExternal()
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
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MActivityImpl <em>MActivity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MActivityImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMActivity()
     * @generated
     */
    EClass MACTIVITY = eINSTANCE.getMActivity();

    /**
     * The meta object literal for the '<em><b>Edge</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTIVITY__EDGE = eINSTANCE.getMActivity_Edge();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTIVITY__NODE = eINSTANCE.getMActivity_Node();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MActionImpl <em>MAction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MActionImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAction()
     * @generated
     */
    EClass MACTION = eINSTANCE.getMAction();

    /**
     * The meta object literal for the '<em><b>Behavior</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTION__BEHAVIOR = eINSTANCE.getMAction_Behavior();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTION__OUT = eINSTANCE.getMAction_Out();

    /**
     * The meta object literal for the '<em><b>In</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTION__IN = eINSTANCE.getMAction_In();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACTION__OPERATION = eINSTANCE.getMAction_Operation();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl <em>MBehavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MBehaviorImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMBehavior()
     * @generated
     */
    EClass MBEHAVIOR = eINSTANCE.getMBehavior();

    /**
     * The meta object literal for the '<em><b>Owning Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MBEHAVIOR__OWNING_CONTEXT = eINSTANCE.getMBehavior_OwningContext();

    /**
     * The meta object literal for the '<em><b>Transition</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MBEHAVIOR__TRANSITION = eINSTANCE.getMBehavior_Transition();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MBEHAVIOR__ENTRY = eINSTANCE.getMBehavior_Entry();

    /**
     * The meta object literal for the '<em><b>Exit</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MBEHAVIOR__EXIT = eINSTANCE.getMBehavior_Exit();

    /**
     * The meta object literal for the '<em><b>Do</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MBEHAVIOR__DO = eINSTANCE.getMBehavior_Do();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MStateMachineImpl <em>MState Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MStateMachineImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMStateMachine()
     * @generated
     */
    EClass MSTATE_MACHINE = eINSTANCE.getMStateMachine();

    /**
     * The meta object literal for the '<em><b>Smstate</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE_MACHINE__SMSTATE = eINSTANCE.getMStateMachine_Smstate();

    /**
     * The meta object literal for the '<em><b>Smtransition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE_MACHINE__SMTRANSITION = eINSTANCE.getMStateMachine_Smtransition();

    /**
     * The meta object literal for the '<em><b>Atomic Transition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE_MACHINE__ATOMIC_TRANSITION = eINSTANCE.getMStateMachine_AtomicTransition();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MFlowImpl <em>MFlow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MFlowImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFlow()
     * @generated
     */
    EClass MFLOW = eINSTANCE.getMFlow();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MFLOW__SOURCE = eINSTANCE.getMFlow_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MFLOW__TARGET = eINSTANCE.getMFlow_Target();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MFLOW__GUARD = eINSTANCE.getMFlow_Guard();

    /**
     * The meta object literal for the '<em><b>Transport</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MFLOW__TRANSPORT = eINSTANCE.getMFlow_Transport();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MNodeImpl <em>MNode</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MNodeImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMNode()
     * @generated
     */
    EClass MNODE = eINSTANCE.getMNode();

    /**
     * The meta object literal for the '<em><b>To</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MNODE__TO = eINSTANCE.getMNode_To();

    /**
     * The meta object literal for the '<em><b>From</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MNODE__FROM = eINSTANCE.getMNode_From();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MGuardImpl <em>MGuard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MGuardImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMGuard()
     * @generated
     */
    EClass MGUARD = eINSTANCE.getMGuard();

    /**
     * The meta object literal for the '<em><b>Transition</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGUARD__TRANSITION = eINSTANCE.getMGuard_Transition();

    /**
     * The meta object literal for the '<em><b>Owning Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MGUARD__OWNING_CONTEXT = eINSTANCE.getMGuard_OwningContext();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MUseCaseImpl <em>MUse Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MUseCaseImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMUseCase()
     * @generated
     */
    EClass MUSE_CASE = eINSTANCE.getMUseCase();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MInitialImpl <em>MInitial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MInitialImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInitial()
     * @generated
     */
    EClass MINITIAL = eINSTANCE.getMInitial();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MFinalImpl <em>MFinal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MFinalImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFinal()
     * @generated
     */
    EClass MFINAL = eINSTANCE.getMFinal();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MStateImpl <em>MState</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMState()
     * @generated
     */
    EClass MSTATE = eINSTANCE.getMState();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__OWNER = eINSTANCE.getMState_Owner();

    /**
     * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__OUTGOING = eINSTANCE.getMState_Outgoing();

    /**
     * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__INCOMING = eINSTANCE.getMState_Incoming();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__ENTRY = eINSTANCE.getMState_Entry();

    /**
     * The meta object literal for the '<em><b>Exit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__EXIT = eINSTANCE.getMState_Exit();

    /**
     * The meta object literal for the '<em><b>Do</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__DO = eINSTANCE.getMState_Do();

    /**
     * The meta object literal for the '<em><b>Superstate</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSTATE__SUPERSTATE = eINSTANCE.getMState_Superstate();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MTransitionImpl <em>MTransition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MTransitionImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTransition()
     * @generated
     */
    EClass MTRANSITION = eINSTANCE.getMTransition();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTRANSITION__KIND = eINSTANCE.getMTransition_Kind();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__SOURCE = eINSTANCE.getMTransition_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__TARGET = eINSTANCE.getMTransition_Target();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__GUARD = eINSTANCE.getMTransition_Guard();

    /**
     * The meta object literal for the '<em><b>Statemachine</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__STATEMACHINE = eINSTANCE.getMTransition_Statemachine();

    /**
     * The meta object literal for the '<em><b>Trigger</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__TRIGGER = eINSTANCE.getMTransition_Trigger();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MTRANSITION__ACTION = eINSTANCE.getMTransition_Action();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl <em>MDefinition Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MDefinitionContextImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDefinitionContext()
     * @generated
     */
    EClass MDEFINITION_CONTEXT = eINSTANCE.getMDefinitionContext();

    /**
     * The meta object literal for the '<em><b>Classifier</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MDEFINITION_CONTEXT__CLASSIFIER = eINSTANCE.getMDefinitionContext_Classifier();

    /**
     * The meta object literal for the '<em><b>Owned Behavior</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MDEFINITION_CONTEXT__OWNED_BEHAVIOR = eINSTANCE.getMDefinitionContext_OwnedBehavior();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MDEFINITION_CONTEXT__GUARD = eINSTANCE.getMDefinitionContext_Guard();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MDEFINITION_CONTEXT__EVENT = eINSTANCE.getMDefinitionContext_Event();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MEventImpl <em>MEvent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MEventImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMEvent()
     * @generated
     */
    EClass MEVENT = eINSTANCE.getMEvent();

    /**
     * The meta object literal for the '<em><b>Is Call</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEVENT__IS_CALL = eINSTANCE.getMEvent_IsCall();

    /**
     * The meta object literal for the '<em><b>Is Change</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MEVENT__IS_CHANGE = eINSTANCE.getMEvent_IsChange();

    /**
     * The meta object literal for the '<em><b>Owning Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEVENT__OWNING_CONTEXT = eINSTANCE.getMEvent_OwningContext();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEVENT__PARAMETER = eINSTANCE.getMEvent_Parameter();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl <em>MAtomic Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MAtomicTransitionImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMAtomicTransition()
     * @generated
     */
    EClass MATOMIC_TRANSITION = eINSTANCE.getMAtomicTransition();

    /**
     * The meta object literal for the '<em><b>Defining Transition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__DEFINING_TRANSITION = eINSTANCE.getMAtomicTransition_DefiningTransition();

    /**
     * The meta object literal for the '<em><b>End Do</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__END_DO = eINSTANCE.getMAtomicTransition_EndDo();

    /**
     * The meta object literal for the '<em><b>Exit</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__EXIT = eINSTANCE.getMAtomicTransition_Exit();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__ACTION = eINSTANCE.getMAtomicTransition_Action();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__ENTRY = eINSTANCE.getMAtomicTransition_Entry();

    /**
     * The meta object literal for the '<em><b>Start Do</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__START_DO = eINSTANCE.getMAtomicTransition_StartDo();

    /**
     * The meta object literal for the '<em><b>History Context</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__HISTORY_CONTEXT = eINSTANCE.getMAtomicTransition_HistoryContext();

    /**
     * The meta object literal for the '<em><b>Statemachine</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__STATEMACHINE = eINSTANCE.getMAtomicTransition_Statemachine();

    /**
     * The meta object literal for the '<em><b>Start Timer</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__START_TIMER = eINSTANCE.getMAtomicTransition_StartTimer();

    /**
     * The meta object literal for the '<em><b>Stop Timer</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__STOP_TIMER = eINSTANCE.getMAtomicTransition_StopTimer();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__SOURCE = eINSTANCE.getMAtomicTransition_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATOMIC_TRANSITION__TARGET = eINSTANCE.getMAtomicTransition_Target();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MLeafStateImpl <em>MLeaf State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MLeafStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMLeafState()
     * @generated
     */
    EClass MLEAF_STATE = eINSTANCE.getMLeafState();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MCompositeStateImpl <em>MComposite State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MCompositeStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMCompositeState()
     * @generated
     */
    EClass MCOMPOSITE_STATE = eINSTANCE.getMCompositeState();

    /**
     * The meta object literal for the '<em><b>Substate</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MCOMPOSITE_STATE__SUBSTATE = eINSTANCE.getMCompositeState_Substate();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MInitialStateImpl <em>MInitial State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MInitialStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMInitialState()
     * @generated
     */
    EClass MINITIAL_STATE = eINSTANCE.getMInitialState();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MFinalStateImpl <em>MFinal State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MFinalStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMFinalState()
     * @generated
     */
    EClass MFINAL_STATE = eINSTANCE.getMFinalState();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MHistoryStateImpl <em>MHistory State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MHistoryStateImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMHistoryState()
     * @generated
     */
    EClass MHISTORY_STATE = eINSTANCE.getMHistoryState();

    /**
     * The meta object literal for the '<em><b>Deep</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MHISTORY_STATE__DEEP = eINSTANCE.getMHistoryState_Deep();

    /**
     * The meta object literal for the '<em><b>Reachable History</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MHISTORY_STATE__REACHABLE_HISTORY = eINSTANCE.getMHistoryState_ReachableHistory();

    /**
     * The meta object literal for the '<em><b>Default History</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MHISTORY_STATE__DEFAULT_HISTORY = eINSTANCE.getMHistoryState_DefaultHistory();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.impl.MTimeEventImpl <em>MTime Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.impl.MTimeEventImpl
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMTimeEvent()
     * @generated
     */
    EClass MTIME_EVENT = eINSTANCE.getMTimeEvent();

    /**
     * The meta object literal for the '<em><b>Is Relative</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTIME_EVENT__IS_RELATIVE = eINSTANCE.getMTimeEvent_IsRelative();

    /**
     * The meta object literal for the '<em><b>When</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MTIME_EVENT__WHEN = eINSTANCE.getMTimeEvent_When();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gcore.MDestinationKind <em>MDestination Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gcore.MDestinationKind
     * @see org.genesez.metamodel.gcore.impl.GcorePackageImpl#getMDestinationKind()
     * @generated
     */
    EEnum MDESTINATION_KIND = eINSTANCE.getMDestinationKind();

  }

} //GcorePackage
