/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

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
 * <!-- begin-model-doc -->
 * Author:GeneSEZ Research Group.Created:7/12/12 1:38 PM.Title:.Comment:.
 * <!-- end-model-doc -->
 * @see org.genesez.metamodel.gpresentation.GpresentationFactory
 * @model kind="package"
 * @generated
 */
public interface GpresentationPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "gpresentation";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://genesez.org/metamodel/presentation";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "gpresentation";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GpresentationPackage eINSTANCE = org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl.init();

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl <em>PMeta Data Aware</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPMetaDataAware()
   * @generated
   */
  int PMETA_DATA_AWARE = 16;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA_AWARE__META_DATA = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA_AWARE__VALUE = 1;

  /**
   * The number of structural features of the '<em>PMeta Data Aware</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA_AWARE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl <em>PAbstract Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAbstractArea()
   * @generated
   */
  int PABSTRACT_AREA = 10;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PABSTRACT_AREA__META_DATA = PMETA_DATA_AWARE__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PABSTRACT_AREA__VALUE = PMETA_DATA_AWARE__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PABSTRACT_AREA__NAME = PMETA_DATA_AWARE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Nested Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PABSTRACT_AREA__NESTED_CONTENTS = PMETA_DATA_AWARE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>PAbstract Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PABSTRACT_AREA_FEATURE_COUNT = PMETA_DATA_AWARE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PRootImpl <em>PRoot</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PRootImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPRoot()
   * @generated
   */
  int PROOT = 0;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT__META_DATA = PABSTRACT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT__VALUE = PABSTRACT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT__NAME = PABSTRACT_AREA__NAME;

  /**
   * The feature id for the '<em><b>Nested Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT__NESTED_CONTENTS = PABSTRACT_AREA__NESTED_CONTENTS;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT__OWNING_PACKAGE = PABSTRACT_AREA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PRoot</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROOT_FEATURE_COUNT = PABSTRACT_AREA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PCompositeAreaImpl <em>PComposite Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PCompositeAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPCompositeArea()
   * @generated
   */
  int PCOMPOSITE_AREA = 1;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA__META_DATA = PABSTRACT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA__VALUE = PABSTRACT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA__NAME = PABSTRACT_AREA__NAME;

  /**
   * The feature id for the '<em><b>Nested Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA__NESTED_CONTENTS = PABSTRACT_AREA__NESTED_CONTENTS;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA__OWNING_AREA = PABSTRACT_AREA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PComposite Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_AREA_FEATURE_COUNT = PABSTRACT_AREA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PElementImpl <em>PElement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PElementImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPElement()
   * @generated
   */
  int PELEMENT = 2;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT__META_DATA = PMETA_DATA_AWARE__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT__VALUE = PMETA_DATA_AWARE__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT__NAME = PMETA_DATA_AWARE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT__OWNING_AREA = PMETA_DATA_AWARE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT__OWNING_ELEMENT = PMETA_DATA_AWARE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>PElement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_FEATURE_COUNT = PMETA_DATA_AWARE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PContentAreaImpl <em>PContent Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PContentAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPContentArea()
   * @generated
   */
  int PCONTENT_AREA = 12;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCONTENT_AREA__META_DATA = PMETA_DATA_AWARE__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCONTENT_AREA__VALUE = PMETA_DATA_AWARE__VALUE;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCONTENT_AREA__OWNING_AREA = PMETA_DATA_AWARE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PContent Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCONTENT_AREA_FEATURE_COUNT = PMETA_DATA_AWARE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PUserDefinedAreaImpl <em>PUser Defined Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PUserDefinedAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPUserDefinedArea()
   * @generated
   */
  int PUSER_DEFINED_AREA = 3;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUSER_DEFINED_AREA__META_DATA = PCONTENT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUSER_DEFINED_AREA__VALUE = PCONTENT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUSER_DEFINED_AREA__OWNING_AREA = PCONTENT_AREA__OWNING_AREA;

  /**
   * The number of structural features of the '<em>PUser Defined Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PUSER_DEFINED_AREA_FEATURE_COUNT = PCONTENT_AREA_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PAutomaticallyGeneratedAreaImpl <em>PAutomatically Generated Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PAutomaticallyGeneratedAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAutomaticallyGeneratedArea()
   * @generated
   */
  int PAUTOMATICALLY_GENERATED_AREA = 4;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAUTOMATICALLY_GENERATED_AREA__META_DATA = PCONTENT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAUTOMATICALLY_GENERATED_AREA__VALUE = PCONTENT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAUTOMATICALLY_GENERATED_AREA__OWNING_AREA = PCONTENT_AREA__OWNING_AREA;

  /**
   * The number of structural features of the '<em>PAutomatically Generated Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAUTOMATICALLY_GENERATED_AREA_FEATURE_COUNT = PCONTENT_AREA_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PInputImpl <em>PInput</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PInputImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPInput()
   * @generated
   */
  int PINPUT = 5;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT__META_DATA = PELEMENT__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT__VALUE = PELEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT__NAME = PELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT__OWNING_AREA = PELEMENT__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT__OWNING_ELEMENT = PELEMENT__OWNING_ELEMENT;

  /**
   * The number of structural features of the '<em>PInput</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PINPUT_FEATURE_COUNT = PELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.POutputImpl <em>POutput</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.POutputImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPOutput()
   * @generated
   */
  int POUTPUT = 6;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__META_DATA = PELEMENT__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__VALUE = PELEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__NAME = PELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__OWNING_AREA = PELEMENT__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__OWNING_ELEMENT = PELEMENT__OWNING_ELEMENT;

  /**
   * The feature id for the '<em><b>Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT__OUTPUT = PELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>POutput</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POUTPUT_FEATURE_COUNT = PELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PActionImpl <em>PAction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PActionImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAction()
   * @generated
   */
  int PACTION = 7;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION__META_DATA = PELEMENT__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION__VALUE = PELEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION__NAME = PELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION__OWNING_AREA = PELEMENT__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION__OWNING_ELEMENT = PELEMENT__OWNING_ELEMENT;

  /**
   * The number of structural features of the '<em>PAction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACTION_FEATURE_COUNT = PELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PMetaDataImpl <em>PMeta Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PMetaDataImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPMetaData()
   * @generated
   */
  int PMETA_DATA = 8;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA__URI = 0;

  /**
   * The feature id for the '<em><b>Key</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA__KEY = 1;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA__CONTAINER = 2;

  /**
   * The number of structural features of the '<em>PMeta Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PMETA_DATA_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PReferenceAreaImpl <em>PReference Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PReferenceAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPReferenceArea()
   * @generated
   */
  int PREFERENCE_AREA = 9;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFERENCE_AREA__META_DATA = PCONTENT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFERENCE_AREA__VALUE = PCONTENT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFERENCE_AREA__OWNING_AREA = PCONTENT_AREA__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFERENCE_AREA__TARGET = PCONTENT_AREA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PReference Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFERENCE_AREA_FEATURE_COUNT = PCONTENT_AREA_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PElementAreaImpl <em>PElement Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PElementAreaImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPElementArea()
   * @generated
   */
  int PELEMENT_AREA = 11;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA__META_DATA = PCONTENT_AREA__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA__VALUE = PCONTENT_AREA__VALUE;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA__OWNING_AREA = PCONTENT_AREA__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA__NAME = PCONTENT_AREA_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Nested Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA__NESTED_ELEMENTS = PCONTENT_AREA_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>PElement Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PELEMENT_AREA_FEATURE_COUNT = PCONTENT_AREA_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl <em>PPackage</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PPackageImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPPackage()
   * @generated
   */
  int PPACKAGE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Roots</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE__ROOTS = 1;

  /**
   * The feature id for the '<em><b>Owning Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE__OWNING_PACKAGE = 2;

  /**
   * The feature id for the '<em><b>Nested Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE__NESTED_PACKAGES = 3;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE__META_DATA = 4;

  /**
   * The number of structural features of the '<em>PPackage</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PPACKAGE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PKeyImpl <em>PKey</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PKeyImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPKey()
   * @generated
   */
  int PKEY = 14;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PKEY__KEY = 0;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PKEY__OWNER = 1;

  /**
   * The number of structural features of the '<em>PKey</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PKEY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PValueImpl <em>PValue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PValueImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPValue()
   * @generated
   */
  int PVALUE = 15;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PVALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Key</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PVALUE__KEY = 1;

  /**
   * The feature id for the '<em><b>Owner</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PVALUE__OWNER = 2;

  /**
   * The number of structural features of the '<em>PValue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PVALUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.genesez.metamodel.gpresentation.impl.PCompositeElementImpl <em>PComposite Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.genesez.metamodel.gpresentation.impl.PCompositeElementImpl
   * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPCompositeElement()
   * @generated
   */
  int PCOMPOSITE_ELEMENT = 17;

  /**
   * The feature id for the '<em><b>Meta Data</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__META_DATA = PELEMENT__META_DATA;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__VALUE = PELEMENT__VALUE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__NAME = PELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Owning Area</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__OWNING_AREA = PELEMENT__OWNING_AREA;

  /**
   * The feature id for the '<em><b>Owning Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__OWNING_ELEMENT = PELEMENT__OWNING_ELEMENT;

  /**
   * The feature id for the '<em><b>Nested Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT__NESTED_ELEMENTS = PELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>PComposite Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PCOMPOSITE_ELEMENT_FEATURE_COUNT = PELEMENT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PRoot <em>PRoot</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PRoot</em>'.
   * @see org.genesez.metamodel.gpresentation.PRoot
   * @generated
   */
  EClass getPRoot();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PRoot#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Package</em>'.
   * @see org.genesez.metamodel.gpresentation.PRoot#getOwningPackage()
   * @see #getPRoot()
   * @generated
   */
  EReference getPRoot_OwningPackage();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PCompositeArea <em>PComposite Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PComposite Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PCompositeArea
   * @generated
   */
  EClass getPCompositeArea();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PElement <em>PElement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PElement</em>'.
   * @see org.genesez.metamodel.gpresentation.PElement
   * @generated
   */
  EClass getPElement();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gpresentation.PElement#getName()
   * @see #getPElement()
   * @generated
   */
  EAttribute getPElement_Name();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PElement#getOwningArea <em>Owning Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PElement#getOwningArea()
   * @see #getPElement()
   * @generated
   */
  EReference getPElement_OwningArea();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PElement#getOwningElement <em>Owning Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Element</em>'.
   * @see org.genesez.metamodel.gpresentation.PElement#getOwningElement()
   * @see #getPElement()
   * @generated
   */
  EReference getPElement_OwningElement();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PUserDefinedArea <em>PUser Defined Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PUser Defined Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PUserDefinedArea
   * @generated
   */
  EClass getPUserDefinedArea();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PAutomaticallyGeneratedArea <em>PAutomatically Generated Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PAutomatically Generated Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PAutomaticallyGeneratedArea
   * @generated
   */
  EClass getPAutomaticallyGeneratedArea();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PInput <em>PInput</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PInput</em>'.
   * @see org.genesez.metamodel.gpresentation.PInput
   * @generated
   */
  EClass getPInput();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.POutput <em>POutput</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>POutput</em>'.
   * @see org.genesez.metamodel.gpresentation.POutput
   * @generated
   */
  EClass getPOutput();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.POutput#getOutput <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Output</em>'.
   * @see org.genesez.metamodel.gpresentation.POutput#getOutput()
   * @see #getPOutput()
   * @generated
   */
  EAttribute getPOutput_Output();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PAction <em>PAction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PAction</em>'.
   * @see org.genesez.metamodel.gpresentation.PAction
   * @generated
   */
  EClass getPAction();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PMetaData <em>PMeta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PMeta Data</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaData
   * @generated
   */
  EClass getPMetaData();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PMetaData#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaData#getUri()
   * @see #getPMetaData()
   * @generated
   */
  EAttribute getPMetaData_Uri();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PMetaData#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Key</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaData#getKey()
   * @see #getPMetaData()
   * @generated
   */
  EReference getPMetaData_Key();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PMetaData#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Container</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaData#getContainer()
   * @see #getPMetaData()
   * @generated
   */
  EReference getPMetaData_Container();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PReferenceArea <em>PReference Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PReference Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PReferenceArea
   * @generated
   */
  EClass getPReferenceArea();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gpresentation.PReferenceArea#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.genesez.metamodel.gpresentation.PReferenceArea#getTarget()
   * @see #getPReferenceArea()
   * @generated
   */
  EReference getPReferenceArea_Target();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PAbstractArea <em>PAbstract Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PAbstract Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PAbstractArea
   * @generated
   */
  EClass getPAbstractArea();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PAbstractArea#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gpresentation.PAbstractArea#getName()
   * @see #getPAbstractArea()
   * @generated
   */
  EAttribute getPAbstractArea_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PAbstractArea#getNestedContents <em>Nested Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Contents</em>'.
   * @see org.genesez.metamodel.gpresentation.PAbstractArea#getNestedContents()
   * @see #getPAbstractArea()
   * @generated
   */
  EReference getPAbstractArea_NestedContents();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PElementArea <em>PElement Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PElement Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PElementArea
   * @generated
   */
  EClass getPElementArea();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PElementArea#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gpresentation.PElementArea#getName()
   * @see #getPElementArea()
   * @generated
   */
  EAttribute getPElementArea_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PElementArea#getNestedElements <em>Nested Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Elements</em>'.
   * @see org.genesez.metamodel.gpresentation.PElementArea#getNestedElements()
   * @see #getPElementArea()
   * @generated
   */
  EReference getPElementArea_NestedElements();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PContentArea <em>PContent Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PContent Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PContentArea
   * @generated
   */
  EClass getPContentArea();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PContentArea#getOwningArea <em>Owning Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Area</em>'.
   * @see org.genesez.metamodel.gpresentation.PContentArea#getOwningArea()
   * @see #getPContentArea()
   * @generated
   */
  EReference getPContentArea_OwningArea();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PPackage <em>PPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PPackage</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage
   * @generated
   */
  EClass getPPackage();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PPackage#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage#getName()
   * @see #getPPackage()
   * @generated
   */
  EAttribute getPPackage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PPackage#getRoots <em>Roots</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Roots</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage#getRoots()
   * @see #getPPackage()
   * @generated
   */
  EReference getPPackage_Roots();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PPackage#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owning Package</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage#getOwningPackage()
   * @see #getPPackage()
   * @generated
   */
  EReference getPPackage_OwningPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PPackage#getNestedPackages <em>Nested Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Packages</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage#getNestedPackages()
   * @see #getPPackage()
   * @generated
   */
  EReference getPPackage_NestedPackages();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PPackage#getMetaData <em>Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Meta Data</em>'.
   * @see org.genesez.metamodel.gpresentation.PPackage#getMetaData()
   * @see #getPPackage()
   * @generated
   */
  EReference getPPackage_MetaData();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PKey <em>PKey</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PKey</em>'.
   * @see org.genesez.metamodel.gpresentation.PKey
   * @generated
   */
  EClass getPKey();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PKey#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.genesez.metamodel.gpresentation.PKey#getKey()
   * @see #getPKey()
   * @generated
   */
  EAttribute getPKey_Key();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PKey#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owner</em>'.
   * @see org.genesez.metamodel.gpresentation.PKey#getOwner()
   * @see #getPKey()
   * @generated
   */
  EReference getPKey_Owner();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PValue <em>PValue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PValue</em>'.
   * @see org.genesez.metamodel.gpresentation.PValue
   * @generated
   */
  EClass getPValue();

  /**
   * Returns the meta object for the attribute '{@link org.genesez.metamodel.gpresentation.PValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.genesez.metamodel.gpresentation.PValue#getValue()
   * @see #getPValue()
   * @generated
   */
  EAttribute getPValue_Value();

  /**
   * Returns the meta object for the reference '{@link org.genesez.metamodel.gpresentation.PValue#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Key</em>'.
   * @see org.genesez.metamodel.gpresentation.PValue#getKey()
   * @see #getPValue()
   * @generated
   */
  EReference getPValue_Key();

  /**
   * Returns the meta object for the container reference '{@link org.genesez.metamodel.gpresentation.PValue#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Owner</em>'.
   * @see org.genesez.metamodel.gpresentation.PValue#getOwner()
   * @see #getPValue()
   * @generated
   */
  EReference getPValue_Owner();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PMetaDataAware <em>PMeta Data Aware</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PMeta Data Aware</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaDataAware
   * @generated
   */
  EClass getPMetaDataAware();

  /**
   * Returns the meta object for the reference list '{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getMetaData <em>Meta Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Meta Data</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaDataAware#getMetaData()
   * @see #getPMetaDataAware()
   * @generated
   */
  EReference getPMetaDataAware_MetaData();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PMetaDataAware#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Value</em>'.
   * @see org.genesez.metamodel.gpresentation.PMetaDataAware#getValue()
   * @see #getPMetaDataAware()
   * @generated
   */
  EReference getPMetaDataAware_Value();

  /**
   * Returns the meta object for class '{@link org.genesez.metamodel.gpresentation.PCompositeElement <em>PComposite Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PComposite Element</em>'.
   * @see org.genesez.metamodel.gpresentation.PCompositeElement
   * @generated
   */
  EClass getPCompositeElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.genesez.metamodel.gpresentation.PCompositeElement#getNestedElements <em>Nested Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Elements</em>'.
   * @see org.genesez.metamodel.gpresentation.PCompositeElement#getNestedElements()
   * @see #getPCompositeElement()
   * @generated
   */
  EReference getPCompositeElement_NestedElements();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GpresentationFactory getGpresentationFactory();

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
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PRootImpl <em>PRoot</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PRootImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPRoot()
     * @generated
     */
    EClass PROOT = eINSTANCE.getPRoot();

    /**
     * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROOT__OWNING_PACKAGE = eINSTANCE.getPRoot_OwningPackage();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PCompositeAreaImpl <em>PComposite Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PCompositeAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPCompositeArea()
     * @generated
     */
    EClass PCOMPOSITE_AREA = eINSTANCE.getPCompositeArea();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PElementImpl <em>PElement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PElementImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPElement()
     * @generated
     */
    EClass PELEMENT = eINSTANCE.getPElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PELEMENT__NAME = eINSTANCE.getPElement_Name();

    /**
     * The meta object literal for the '<em><b>Owning Area</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PELEMENT__OWNING_AREA = eINSTANCE.getPElement_OwningArea();

    /**
     * The meta object literal for the '<em><b>Owning Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PELEMENT__OWNING_ELEMENT = eINSTANCE.getPElement_OwningElement();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PUserDefinedAreaImpl <em>PUser Defined Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PUserDefinedAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPUserDefinedArea()
     * @generated
     */
    EClass PUSER_DEFINED_AREA = eINSTANCE.getPUserDefinedArea();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PAutomaticallyGeneratedAreaImpl <em>PAutomatically Generated Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PAutomaticallyGeneratedAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAutomaticallyGeneratedArea()
     * @generated
     */
    EClass PAUTOMATICALLY_GENERATED_AREA = eINSTANCE.getPAutomaticallyGeneratedArea();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PInputImpl <em>PInput</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PInputImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPInput()
     * @generated
     */
    EClass PINPUT = eINSTANCE.getPInput();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.POutputImpl <em>POutput</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.POutputImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPOutput()
     * @generated
     */
    EClass POUTPUT = eINSTANCE.getPOutput();

    /**
     * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute POUTPUT__OUTPUT = eINSTANCE.getPOutput_Output();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PActionImpl <em>PAction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PActionImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAction()
     * @generated
     */
    EClass PACTION = eINSTANCE.getPAction();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PMetaDataImpl <em>PMeta Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PMetaDataImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPMetaData()
     * @generated
     */
    EClass PMETA_DATA = eINSTANCE.getPMetaData();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PMETA_DATA__URI = eINSTANCE.getPMetaData_Uri();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PMETA_DATA__KEY = eINSTANCE.getPMetaData_Key();

    /**
     * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PMETA_DATA__CONTAINER = eINSTANCE.getPMetaData_Container();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PReferenceAreaImpl <em>PReference Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PReferenceAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPReferenceArea()
     * @generated
     */
    EClass PREFERENCE_AREA = eINSTANCE.getPReferenceArea();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFERENCE_AREA__TARGET = eINSTANCE.getPReferenceArea_Target();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl <em>PAbstract Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPAbstractArea()
     * @generated
     */
    EClass PABSTRACT_AREA = eINSTANCE.getPAbstractArea();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PABSTRACT_AREA__NAME = eINSTANCE.getPAbstractArea_Name();

    /**
     * The meta object literal for the '<em><b>Nested Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PABSTRACT_AREA__NESTED_CONTENTS = eINSTANCE.getPAbstractArea_NestedContents();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PElementAreaImpl <em>PElement Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PElementAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPElementArea()
     * @generated
     */
    EClass PELEMENT_AREA = eINSTANCE.getPElementArea();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PELEMENT_AREA__NAME = eINSTANCE.getPElementArea_Name();

    /**
     * The meta object literal for the '<em><b>Nested Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PELEMENT_AREA__NESTED_ELEMENTS = eINSTANCE.getPElementArea_NestedElements();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PContentAreaImpl <em>PContent Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PContentAreaImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPContentArea()
     * @generated
     */
    EClass PCONTENT_AREA = eINSTANCE.getPContentArea();

    /**
     * The meta object literal for the '<em><b>Owning Area</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PCONTENT_AREA__OWNING_AREA = eINSTANCE.getPContentArea_OwningArea();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl <em>PPackage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PPackageImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPPackage()
     * @generated
     */
    EClass PPACKAGE = eINSTANCE.getPPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PPACKAGE__NAME = eINSTANCE.getPPackage_Name();

    /**
     * The meta object literal for the '<em><b>Roots</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PPACKAGE__ROOTS = eINSTANCE.getPPackage_Roots();

    /**
     * The meta object literal for the '<em><b>Owning Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PPACKAGE__OWNING_PACKAGE = eINSTANCE.getPPackage_OwningPackage();

    /**
     * The meta object literal for the '<em><b>Nested Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PPACKAGE__NESTED_PACKAGES = eINSTANCE.getPPackage_NestedPackages();

    /**
     * The meta object literal for the '<em><b>Meta Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PPACKAGE__META_DATA = eINSTANCE.getPPackage_MetaData();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PKeyImpl <em>PKey</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PKeyImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPKey()
     * @generated
     */
    EClass PKEY = eINSTANCE.getPKey();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PKEY__KEY = eINSTANCE.getPKey_Key();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PKEY__OWNER = eINSTANCE.getPKey_Owner();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PValueImpl <em>PValue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PValueImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPValue()
     * @generated
     */
    EClass PVALUE = eINSTANCE.getPValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PVALUE__VALUE = eINSTANCE.getPValue_Value();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PVALUE__KEY = eINSTANCE.getPValue_Key();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PVALUE__OWNER = eINSTANCE.getPValue_Owner();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl <em>PMeta Data Aware</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPMetaDataAware()
     * @generated
     */
    EClass PMETA_DATA_AWARE = eINSTANCE.getPMetaDataAware();

    /**
     * The meta object literal for the '<em><b>Meta Data</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PMETA_DATA_AWARE__META_DATA = eINSTANCE.getPMetaDataAware_MetaData();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PMETA_DATA_AWARE__VALUE = eINSTANCE.getPMetaDataAware_Value();

    /**
     * The meta object literal for the '{@link org.genesez.metamodel.gpresentation.impl.PCompositeElementImpl <em>PComposite Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.genesez.metamodel.gpresentation.impl.PCompositeElementImpl
     * @see org.genesez.metamodel.gpresentation.impl.GpresentationPackageImpl#getPCompositeElement()
     * @generated
     */
    EClass PCOMPOSITE_ELEMENT = eINSTANCE.getPCompositeElement();

    /**
     * The meta object literal for the '<em><b>Nested Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PCOMPOSITE_ELEMENT__NESTED_ELEMENTS = eINSTANCE.getPCompositeElement_NestedElements();

  }

} //GpresentationPackage
