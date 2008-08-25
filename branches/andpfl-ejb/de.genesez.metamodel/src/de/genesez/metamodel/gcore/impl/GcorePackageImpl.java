/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.impl;

import de.genesez.metamodel.gcore.GcoreFactory;
import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.gcore.MAspect;
import de.genesez.metamodel.gcore.MAssociation;
import de.genesez.metamodel.gcore.MAssociationRole;
import de.genesez.metamodel.gcore.MAttribute;
import de.genesez.metamodel.gcore.MClass;
import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MComment;
import de.genesez.metamodel.gcore.MDataType;
import de.genesez.metamodel.gcore.MDestinationKind;
import de.genesez.metamodel.gcore.MElement;
import de.genesez.metamodel.gcore.MEnumeration;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MInterface;
import de.genesez.metamodel.gcore.MIntroduction;
import de.genesez.metamodel.gcore.MLiteral;
import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MPackage;
import de.genesez.metamodel.gcore.MParameter;
import de.genesez.metamodel.gcore.MPointcut;
import de.genesez.metamodel.gcore.MPrimitiveType;
import de.genesez.metamodel.gcore.MProperty;
import de.genesez.metamodel.gcore.MStereotype;
import de.genesez.metamodel.gcore.MTag;
import de.genesez.metamodel.gcore.MTaggedValue;
import de.genesez.metamodel.gcore.MType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GcorePackageImpl extends EPackageImpl implements GcorePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAssociationRoleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mClassifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mDataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPrimitiveTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mEnumerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mStereotypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTagEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTaggedValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mAspectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mIntroductionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mPointcutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mGenericEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mExternalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum mDestinationKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.genesez.metamodel.gcore.GcorePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GcorePackageImpl()
  {
    super(eNS_URI, GcoreFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GcorePackage init()
  {
    if (isInited) return (GcorePackage)EPackage.Registry.INSTANCE.getEPackage(GcorePackage.eNS_URI);

    // Obtain or create and register package
    GcorePackageImpl theGcorePackage = (GcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof GcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new GcorePackageImpl());

    isInited = true;

    // Create package meta-data objects
    theGcorePackage.createPackageContents();

    // Initialize created meta-data
    theGcorePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGcorePackage.freeze();

    return theGcorePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMPackage()
  {
    return mPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_NestedPackage()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_NestingPackage()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_Association()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPackage_Classifier()
  {
    return (EReference)mPackageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMClass()
  {
    return mClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClass_OwnedAssociation()
  {
    return (EReference)mClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAssociationRole()
  {
    return mAssociationRoleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociationRole_Aggregation()
  {
    return (EAttribute)mAssociationRoleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociationRole_Composition()
  {
    return (EAttribute)mAssociationRoleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_Association()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociationRole_Opposite()
  {
    return (EReference)mAssociationRoleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAssociation()
  {
    return mAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAssociation_Derived()
  {
    return (EAttribute)mAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_End()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_OwningPackage()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAssociation_AssociationClass()
  {
    return (EReference)mAssociationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAttribute()
  {
    return mAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Defaultvalue()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Static()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAttribute_Final()
  {
    return (EAttribute)mAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMModel()
  {
    return mModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMModel_PrimitiveTypes()
  {
    return (EReference)mModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMModel_AnyStereotype()
  {
    return (EReference)mModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMModel_ExternalTypes()
  {
    return (EReference)mModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMElement()
  {
    return mElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMElement_Name()
  {
    return (EAttribute)mElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMElement_XmiGuid()
  {
    return (EAttribute)mElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_OwnedComment()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_TaggedValue()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_Stereotype()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMElement_Aspect()
  {
    return (EReference)mElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMProperty()
  {
    return mPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Visibility()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Derived()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Multiplicity()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Unique()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMProperty_Ordered()
  {
    return (EAttribute)mPropertyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_Classifier()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_GenericRealization()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMProperty_Type()
  {
    return (EReference)mPropertyEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMInterface()
  {
    return mInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMClassifier()
  {
    return mClassifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Visibility()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Abstract()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMClassifier_Final()
  {
    return (EAttribute)mClassifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_OwningPackage()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Operation()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Property()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_GenericParameter()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Supertype()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Realization()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Generalization()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMClassifier_Supplier()
  {
    return (EReference)mClassifierEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMOperation()
  {
    return mOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Visibility()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Static()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Abstract()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Final()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Multiplicity()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Unique()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMOperation_Ordered()
  {
    return (EAttribute)mOperationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_Parameter()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_Classifier()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_GenericParameter()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_RaisedException()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMOperation_ReturnType()
  {
    return (EReference)mOperationEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMParameter()
  {
    return mParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Defaultvalue()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Direction()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Multiplicity()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Unique()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMParameter_Ordered()
  {
    return (EAttribute)mParameterEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Operation()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_GenericRealization()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMParameter_Type()
  {
    return (EReference)mParameterEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMDataType()
  {
    return mDataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMPrimitiveType()
  {
    return mPrimitiveTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPrimitiveType_Model()
  {
    return (EReference)mPrimitiveTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMEnumeration()
  {
    return mEnumerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMEnumeration_Literal()
  {
    return (EReference)mEnumerationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMStereotype()
  {
    return mStereotypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStereotype_Property()
  {
    return (EReference)mStereotypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMStereotype_Model()
  {
    return (EReference)mStereotypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTag()
  {
    return mTagEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTag_Name()
  {
    return (EAttribute)mTagEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTag_Type()
  {
    return (EAttribute)mTagEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTag_Stereotype()
  {
    return (EReference)mTagEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMComment()
  {
    return mCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMComment_XmiGuid()
  {
    return (EAttribute)mCommentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMComment_Annotation()
  {
    return (EAttribute)mCommentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_OwningElement()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_NestedComment()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMComment_NestingComment()
  {
    return (EReference)mCommentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMTaggedValue()
  {
    return mTaggedValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMTaggedValue_Value()
  {
    return (EAttribute)mTaggedValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTaggedValue_OwningElement()
  {
    return (EReference)mTaggedValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMTaggedValue_Tag()
  {
    return (EReference)mTaggedValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMAspect()
  {
    return mAspectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAspect_Domain()
  {
    return (EAttribute)mAspectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMAspect_Name()
  {
    return (EAttribute)mAspectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Element()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Introduction()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMAspect_Pointcut()
  {
    return (EReference)mAspectEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMIntroduction()
  {
    return mIntroductionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMIntroduction_Domain()
  {
    return (EAttribute)mIntroductionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMIntroduction_Name()
  {
    return (EAttribute)mIntroductionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMIntroduction_Origin()
  {
    return (EReference)mIntroductionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMPointcut()
  {
    return mPointcutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Domain()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Name()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMPointcut_Destination()
  {
    return (EAttribute)mPointcutEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMPointcut_Origin()
  {
    return (EReference)mPointcutEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMLiteral()
  {
    return mLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMLiteral_OwningEnumeration()
  {
    return (EReference)mLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMGeneric()
  {
    return mGenericEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMGeneric_Specification()
  {
    return (EAttribute)mGenericEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningClassifier()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningOperation()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningProperty()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningParameter()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMGeneric_OwningExternal()
  {
    return (EReference)mGenericEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMType()
  {
    return mTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMExternal()
  {
    return mExternalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMExternal_Specification()
  {
    return (EAttribute)mExternalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMExternal_Model()
  {
    return (EReference)mExternalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMExternal_GenericParameter()
  {
    return (EReference)mExternalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMDestinationKind()
  {
    return mDestinationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreFactory getGcoreFactory()
  {
    return (GcoreFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    mPackageEClass = createEClass(MPACKAGE);
    createEReference(mPackageEClass, MPACKAGE__NESTED_PACKAGE);
    createEReference(mPackageEClass, MPACKAGE__NESTING_PACKAGE);
    createEReference(mPackageEClass, MPACKAGE__ASSOCIATION);
    createEReference(mPackageEClass, MPACKAGE__CLASSIFIER);

    mClassEClass = createEClass(MCLASS);
    createEReference(mClassEClass, MCLASS__OWNED_ASSOCIATION);

    mAssociationRoleEClass = createEClass(MASSOCIATION_ROLE);
    createEAttribute(mAssociationRoleEClass, MASSOCIATION_ROLE__AGGREGATION);
    createEAttribute(mAssociationRoleEClass, MASSOCIATION_ROLE__COMPOSITION);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__ASSOCIATION);
    createEReference(mAssociationRoleEClass, MASSOCIATION_ROLE__OPPOSITE);

    mAssociationEClass = createEClass(MASSOCIATION);
    createEAttribute(mAssociationEClass, MASSOCIATION__DERIVED);
    createEReference(mAssociationEClass, MASSOCIATION__END);
    createEReference(mAssociationEClass, MASSOCIATION__OWNING_PACKAGE);
    createEReference(mAssociationEClass, MASSOCIATION__ASSOCIATION_CLASS);

    mAttributeEClass = createEClass(MATTRIBUTE);
    createEAttribute(mAttributeEClass, MATTRIBUTE__DEFAULTVALUE);
    createEAttribute(mAttributeEClass, MATTRIBUTE__STATIC);
    createEAttribute(mAttributeEClass, MATTRIBUTE__FINAL);

    mModelEClass = createEClass(MMODEL);
    createEReference(mModelEClass, MMODEL__PRIMITIVE_TYPES);
    createEReference(mModelEClass, MMODEL__ANY_STEREOTYPE);
    createEReference(mModelEClass, MMODEL__EXTERNAL_TYPES);

    mElementEClass = createEClass(MELEMENT);
    createEAttribute(mElementEClass, MELEMENT__NAME);
    createEAttribute(mElementEClass, MELEMENT__XMI_GUID);
    createEReference(mElementEClass, MELEMENT__OWNED_COMMENT);
    createEReference(mElementEClass, MELEMENT__TAGGED_VALUE);
    createEReference(mElementEClass, MELEMENT__STEREOTYPE);
    createEReference(mElementEClass, MELEMENT__ASPECT);

    mPropertyEClass = createEClass(MPROPERTY);
    createEAttribute(mPropertyEClass, MPROPERTY__VISIBILITY);
    createEAttribute(mPropertyEClass, MPROPERTY__DERIVED);
    createEAttribute(mPropertyEClass, MPROPERTY__MULTIPLICITY);
    createEAttribute(mPropertyEClass, MPROPERTY__UNIQUE);
    createEAttribute(mPropertyEClass, MPROPERTY__ORDERED);
    createEReference(mPropertyEClass, MPROPERTY__CLASSIFIER);
    createEReference(mPropertyEClass, MPROPERTY__GENERIC_REALIZATION);
    createEReference(mPropertyEClass, MPROPERTY__TYPE);

    mInterfaceEClass = createEClass(MINTERFACE);

    mClassifierEClass = createEClass(MCLASSIFIER);
    createEAttribute(mClassifierEClass, MCLASSIFIER__VISIBILITY);
    createEAttribute(mClassifierEClass, MCLASSIFIER__ABSTRACT);
    createEAttribute(mClassifierEClass, MCLASSIFIER__FINAL);
    createEReference(mClassifierEClass, MCLASSIFIER__OWNING_PACKAGE);
    createEReference(mClassifierEClass, MCLASSIFIER__OPERATION);
    createEReference(mClassifierEClass, MCLASSIFIER__PROPERTY);
    createEReference(mClassifierEClass, MCLASSIFIER__GENERIC_PARAMETER);
    createEReference(mClassifierEClass, MCLASSIFIER__SUPERTYPE);
    createEReference(mClassifierEClass, MCLASSIFIER__REALIZATION);
    createEReference(mClassifierEClass, MCLASSIFIER__GENERALIZATION);
    createEReference(mClassifierEClass, MCLASSIFIER__SUPPLIER);

    mOperationEClass = createEClass(MOPERATION);
    createEAttribute(mOperationEClass, MOPERATION__VISIBILITY);
    createEAttribute(mOperationEClass, MOPERATION__STATIC);
    createEAttribute(mOperationEClass, MOPERATION__ABSTRACT);
    createEAttribute(mOperationEClass, MOPERATION__FINAL);
    createEAttribute(mOperationEClass, MOPERATION__MULTIPLICITY);
    createEAttribute(mOperationEClass, MOPERATION__UNIQUE);
    createEAttribute(mOperationEClass, MOPERATION__ORDERED);
    createEReference(mOperationEClass, MOPERATION__PARAMETER);
    createEReference(mOperationEClass, MOPERATION__CLASSIFIER);
    createEReference(mOperationEClass, MOPERATION__GENERIC_PARAMETER);
    createEReference(mOperationEClass, MOPERATION__RAISED_EXCEPTION);
    createEReference(mOperationEClass, MOPERATION__RETURN_TYPE);

    mParameterEClass = createEClass(MPARAMETER);
    createEAttribute(mParameterEClass, MPARAMETER__DEFAULTVALUE);
    createEAttribute(mParameterEClass, MPARAMETER__DIRECTION);
    createEAttribute(mParameterEClass, MPARAMETER__MULTIPLICITY);
    createEAttribute(mParameterEClass, MPARAMETER__UNIQUE);
    createEAttribute(mParameterEClass, MPARAMETER__ORDERED);
    createEReference(mParameterEClass, MPARAMETER__OPERATION);
    createEReference(mParameterEClass, MPARAMETER__GENERIC_REALIZATION);
    createEReference(mParameterEClass, MPARAMETER__TYPE);

    mDataTypeEClass = createEClass(MDATA_TYPE);

    mPrimitiveTypeEClass = createEClass(MPRIMITIVE_TYPE);
    createEReference(mPrimitiveTypeEClass, MPRIMITIVE_TYPE__MODEL);

    mEnumerationEClass = createEClass(MENUMERATION);
    createEReference(mEnumerationEClass, MENUMERATION__LITERAL);

    mStereotypeEClass = createEClass(MSTEREOTYPE);
    createEReference(mStereotypeEClass, MSTEREOTYPE__PROPERTY);
    createEReference(mStereotypeEClass, MSTEREOTYPE__MODEL);

    mTagEClass = createEClass(MTAG);
    createEAttribute(mTagEClass, MTAG__NAME);
    createEAttribute(mTagEClass, MTAG__TYPE);
    createEReference(mTagEClass, MTAG__STEREOTYPE);

    mCommentEClass = createEClass(MCOMMENT);
    createEAttribute(mCommentEClass, MCOMMENT__XMI_GUID);
    createEAttribute(mCommentEClass, MCOMMENT__ANNOTATION);
    createEReference(mCommentEClass, MCOMMENT__OWNING_ELEMENT);
    createEReference(mCommentEClass, MCOMMENT__NESTED_COMMENT);
    createEReference(mCommentEClass, MCOMMENT__NESTING_COMMENT);

    mTaggedValueEClass = createEClass(MTAGGED_VALUE);
    createEAttribute(mTaggedValueEClass, MTAGGED_VALUE__VALUE);
    createEReference(mTaggedValueEClass, MTAGGED_VALUE__OWNING_ELEMENT);
    createEReference(mTaggedValueEClass, MTAGGED_VALUE__TAG);

    mAspectEClass = createEClass(MASPECT);
    createEAttribute(mAspectEClass, MASPECT__DOMAIN);
    createEAttribute(mAspectEClass, MASPECT__NAME);
    createEReference(mAspectEClass, MASPECT__ELEMENT);
    createEReference(mAspectEClass, MASPECT__INTRODUCTION);
    createEReference(mAspectEClass, MASPECT__POINTCUT);

    mIntroductionEClass = createEClass(MINTRODUCTION);
    createEAttribute(mIntroductionEClass, MINTRODUCTION__DOMAIN);
    createEAttribute(mIntroductionEClass, MINTRODUCTION__NAME);
    createEReference(mIntroductionEClass, MINTRODUCTION__ORIGIN);

    mPointcutEClass = createEClass(MPOINTCUT);
    createEAttribute(mPointcutEClass, MPOINTCUT__DOMAIN);
    createEAttribute(mPointcutEClass, MPOINTCUT__NAME);
    createEAttribute(mPointcutEClass, MPOINTCUT__DESTINATION);
    createEReference(mPointcutEClass, MPOINTCUT__ORIGIN);

    mLiteralEClass = createEClass(MLITERAL);
    createEReference(mLiteralEClass, MLITERAL__OWNING_ENUMERATION);

    mGenericEClass = createEClass(MGENERIC);
    createEAttribute(mGenericEClass, MGENERIC__SPECIFICATION);
    createEReference(mGenericEClass, MGENERIC__OWNING_CLASSIFIER);
    createEReference(mGenericEClass, MGENERIC__OWNING_OPERATION);
    createEReference(mGenericEClass, MGENERIC__OWNING_PROPERTY);
    createEReference(mGenericEClass, MGENERIC__OWNING_PARAMETER);
    createEReference(mGenericEClass, MGENERIC__OWNING_EXTERNAL);

    mTypeEClass = createEClass(MTYPE);

    mExternalEClass = createEClass(MEXTERNAL);
    createEAttribute(mExternalEClass, MEXTERNAL__SPECIFICATION);
    createEReference(mExternalEClass, MEXTERNAL__MODEL);
    createEReference(mExternalEClass, MEXTERNAL__GENERIC_PARAMETER);

    // Create enums
    mDestinationKindEEnum = createEEnum(MDESTINATION_KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Add supertypes to classes
    mPackageEClass.getESuperTypes().add(this.getMElement());
    mClassEClass.getESuperTypes().add(this.getMClassifier());
    mAssociationRoleEClass.getESuperTypes().add(this.getMProperty());
    mAssociationEClass.getESuperTypes().add(this.getMElement());
    mAttributeEClass.getESuperTypes().add(this.getMProperty());
    mModelEClass.getESuperTypes().add(this.getMPackage());
    mPropertyEClass.getESuperTypes().add(this.getMElement());
    mInterfaceEClass.getESuperTypes().add(this.getMClassifier());
    mClassifierEClass.getESuperTypes().add(this.getMElement());
    mClassifierEClass.getESuperTypes().add(this.getMType());
    mOperationEClass.getESuperTypes().add(this.getMElement());
    mParameterEClass.getESuperTypes().add(this.getMElement());
    mDataTypeEClass.getESuperTypes().add(this.getMClassifier());
    mPrimitiveTypeEClass.getESuperTypes().add(this.getMType());
    mPrimitiveTypeEClass.getESuperTypes().add(this.getMElement());
    mEnumerationEClass.getESuperTypes().add(this.getMDataType());
    mStereotypeEClass.getESuperTypes().add(this.getMElement());
    mLiteralEClass.getESuperTypes().add(this.getMElement());
    mGenericEClass.getESuperTypes().add(this.getMType());
    mExternalEClass.getESuperTypes().add(this.getMType());

    // Initialize classes and features; add operations and parameters
    initEClass(mPackageEClass, MPackage.class, "MPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMPackage_NestedPackage(), this.getMPackage(), this.getMPackage_NestingPackage(), "nestedPackage", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_NestingPackage(), this.getMPackage(), this.getMPackage_NestedPackage(), "nestingPackage", null, 0, 1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_Association(), this.getMAssociation(), this.getMAssociation_OwningPackage(), "association", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPackage_Classifier(), this.getMClassifier(), this.getMClassifier_OwningPackage(), "classifier", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mClassEClass, MClass.class, "MClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMClass_OwnedAssociation(), this.getMAssociation(), this.getMAssociation_AssociationClass(), "ownedAssociation", null, 0, 1, MClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAssociationRoleEClass, MAssociationRole.class, "MAssociationRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAssociationRole_Aggregation(), ecorePackage.getEBoolean(), "aggregation", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAssociationRole_Composition(), ecorePackage.getEBoolean(), "composition", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_Association(), this.getMAssociation(), this.getMAssociation_End(), "association", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociationRole_Opposite(), this.getMAssociationRole(), null, "opposite", null, 1, 1, MAssociationRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAssociationEClass, MAssociation.class, "MAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAssociation_Derived(), ecorePackage.getEBoolean(), "derived", null, 1, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_End(), this.getMAssociationRole(), this.getMAssociationRole_Association(), "end", null, 1, -1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_OwningPackage(), this.getMPackage(), this.getMPackage_Association(), "owningPackage", null, 1, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAssociation_AssociationClass(), this.getMClass(), this.getMClass_OwnedAssociation(), "associationClass", null, 0, 1, MAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAttributeEClass, MAttribute.class, "MAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAttribute_Defaultvalue(), ecorePackage.getEString(), "defaultvalue", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAttribute_Static(), ecorePackage.getEBoolean(), "static", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAttribute_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mModelEClass, MModel.class, "MModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMModel_PrimitiveTypes(), this.getMPrimitiveType(), this.getMPrimitiveType_Model(), "primitiveTypes", null, 0, -1, MModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMModel_AnyStereotype(), this.getMStereotype(), this.getMStereotype_Model(), "anyStereotype", null, 0, -1, MModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMModel_ExternalTypes(), this.getMExternal(), this.getMExternal_Model(), "externalTypes", null, 0, -1, MModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mElementEClass, MElement.class, "MElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMElement_XmiGuid(), ecorePackage.getEString(), "xmiGuid", null, 1, 1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_OwnedComment(), this.getMComment(), this.getMComment_OwningElement(), "ownedComment", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_TaggedValue(), this.getMTaggedValue(), this.getMTaggedValue_OwningElement(), "taggedValue", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_Stereotype(), this.getMStereotype(), null, "stereotype", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMElement_Aspect(), this.getMAspect(), this.getMAspect_Element(), "aspect", null, 0, -1, MElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mPropertyEClass, MProperty.class, "MProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMProperty_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMProperty_Derived(), ecorePackage.getEBoolean(), "derived", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMProperty_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMProperty_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMProperty_Ordered(), ecorePackage.getEBoolean(), "ordered", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_Classifier(), this.getMClassifier(), this.getMClassifier_Property(), "classifier", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_GenericRealization(), this.getMGeneric(), this.getMGeneric_OwningProperty(), "genericRealization", null, 0, -1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMProperty_Type(), this.getMType(), null, "type", null, 1, 1, MProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mInterfaceEClass, MInterface.class, "MInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mClassifierEClass, MClassifier.class, "MClassifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMClassifier_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMClassifier_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMClassifier_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_OwningPackage(), this.getMPackage(), this.getMPackage_Classifier(), "owningPackage", null, 1, 1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Operation(), this.getMOperation(), this.getMOperation_Classifier(), "operation", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Property(), this.getMProperty(), this.getMProperty_Classifier(), "property", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningClassifier(), "genericParameter", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Supertype(), this.getMType(), null, "supertype", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Realization(), this.getMType(), null, "realization", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Generalization(), this.getMType(), null, "generalization", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMClassifier_Supplier(), this.getMType(), null, "supplier", null, 0, -1, MClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mOperationEClass, MOperation.class, "MOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMOperation_Visibility(), ecorePackage.getEString(), "visibility", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Static(), ecorePackage.getEBoolean(), "static", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMOperation_Ordered(), ecorePackage.getEBoolean(), "ordered", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_Parameter(), this.getMParameter(), this.getMParameter_Operation(), "parameter", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_Classifier(), this.getMClassifier(), this.getMClassifier_Operation(), "classifier", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningOperation(), "genericParameter", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_RaisedException(), this.getMType(), null, "raisedException", null, 0, -1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMOperation_ReturnType(), this.getMType(), null, "returnType", null, 1, 1, MOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mParameterEClass, MParameter.class, "MParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMParameter_Defaultvalue(), ecorePackage.getEString(), "defaultvalue", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMParameter_Direction(), ecorePackage.getEString(), "direction", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMParameter_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMParameter_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMParameter_Ordered(), ecorePackage.getEBoolean(), "ordered", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Operation(), this.getMOperation(), this.getMOperation_Parameter(), "operation", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_GenericRealization(), this.getMGeneric(), this.getMGeneric_OwningParameter(), "genericRealization", null, 0, -1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMParameter_Type(), this.getMType(), null, "type", null, 1, 1, MParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mDataTypeEClass, MDataType.class, "MDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mPrimitiveTypeEClass, MPrimitiveType.class, "MPrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMPrimitiveType_Model(), this.getMModel(), this.getMModel_PrimitiveTypes(), "model", null, 1, 1, MPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mEnumerationEClass, MEnumeration.class, "MEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMEnumeration_Literal(), this.getMLiteral(), this.getMLiteral_OwningEnumeration(), "literal", null, 0, -1, MEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mStereotypeEClass, MStereotype.class, "MStereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMStereotype_Property(), this.getMTag(), this.getMTag_Stereotype(), "property", null, 0, -1, MStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMStereotype_Model(), this.getMModel(), this.getMModel_AnyStereotype(), "model", null, 1, 1, MStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTagEClass, MTag.class, "MTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTag_Name(), ecorePackage.getEString(), "name", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMTag_Type(), ecorePackage.getEString(), "type", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTag_Stereotype(), this.getMStereotype(), this.getMStereotype_Property(), "stereotype", null, 1, 1, MTag.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mCommentEClass, MComment.class, "MComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMComment_XmiGuid(), ecorePackage.getEString(), "xmiGuid", null, 1, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMComment_Annotation(), ecorePackage.getEString(), "annotation", null, 1, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_OwningElement(), this.getMElement(), this.getMElement_OwnedComment(), "owningElement", null, 1, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_NestedComment(), this.getMComment(), this.getMComment_NestingComment(), "nestedComment", null, 0, -1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMComment_NestingComment(), this.getMComment(), this.getMComment_NestedComment(), "nestingComment", null, 0, 1, MComment.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTaggedValueEClass, MTaggedValue.class, "MTaggedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMTaggedValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTaggedValue_OwningElement(), this.getMElement(), this.getMElement_TaggedValue(), "owningElement", null, 1, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMTaggedValue_Tag(), this.getMTag(), null, "tag", null, 1, 1, MTaggedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mAspectEClass, MAspect.class, "MAspect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMAspect_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMAspect_Name(), ecorePackage.getEString(), "name", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Element(), this.getMElement(), this.getMElement_Aspect(), "element", null, 1, 1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Introduction(), this.getMIntroduction(), this.getMIntroduction_Origin(), "introduction", null, 0, -1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMAspect_Pointcut(), this.getMPointcut(), this.getMPointcut_Origin(), "pointcut", null, 0, -1, MAspect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mIntroductionEClass, MIntroduction.class, "MIntroduction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMIntroduction_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMIntroduction_Name(), ecorePackage.getEString(), "name", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMIntroduction_Origin(), this.getMAspect(), this.getMAspect_Introduction(), "origin", null, 1, 1, MIntroduction.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mPointcutEClass, MPointcut.class, "MPointcut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMPointcut_Domain(), ecorePackage.getEString(), "domain", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMPointcut_Name(), ecorePackage.getEString(), "name", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMPointcut_Destination(), this.getMDestinationKind(), "destination", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMPointcut_Origin(), this.getMAspect(), this.getMAspect_Pointcut(), "origin", null, 1, 1, MPointcut.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mLiteralEClass, MLiteral.class, "MLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMLiteral_OwningEnumeration(), this.getMEnumeration(), this.getMEnumeration_Literal(), "owningEnumeration", null, 1, 1, MLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mGenericEClass, MGeneric.class, "MGeneric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMGeneric_Specification(), ecorePackage.getEString(), "specification", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningClassifier(), this.getMClassifier(), this.getMClassifier_GenericParameter(), "owningClassifier", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningOperation(), this.getMOperation(), this.getMOperation_GenericParameter(), "owningOperation", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningProperty(), this.getMProperty(), this.getMProperty_GenericRealization(), "owningProperty", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningParameter(), this.getMParameter(), this.getMParameter_GenericRealization(), "owningParameter", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMGeneric_OwningExternal(), this.getMExternal(), this.getMExternal_GenericParameter(), "owningExternal", null, 1, 1, MGeneric.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mTypeEClass, MType.class, "MType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mExternalEClass, MExternal.class, "MExternal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMExternal_Specification(), ecorePackage.getEString(), "specification", null, 1, 1, MExternal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMExternal_Model(), this.getMModel(), this.getMModel_ExternalTypes(), "model", null, 1, 1, MExternal.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMExternal_GenericParameter(), this.getMGeneric(), this.getMGeneric_OwningExternal(), "genericParameter", null, 0, -1, MExternal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(mDestinationKindEEnum, MDestinationKind.class, "MDestinationKind");
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_ENTRY_LITERAL);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_EXIT_LITERAL);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.ON_EXCEPTION_LITERAL);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.AROUND_LITERAL);
    addEEnumLiteral(mDestinationKindEEnum, MDestinationKind.EXTERNAL_LITERAL);

    // Create resource
    createResource(eNS_URI);
  }

} //GcorePackageImpl
