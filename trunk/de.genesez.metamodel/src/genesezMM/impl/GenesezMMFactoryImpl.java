/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenesezMMFactoryImpl extends EFactoryImpl implements GenesezMMFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GenesezMMFactory init()
  {
    try
    {
      GenesezMMFactory theGenesezMMFactory = (GenesezMMFactory)EPackage.Registry.INSTANCE.getEFactory("platform:/plugin/de.genesez.metamodel/model-gen/genesezMM.ecore"); 
      if (theGenesezMMFactory != null)
      {
        return theGenesezMMFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GenesezMMFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GenesezMMFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case GenesezMMPackage.MPACKAGE: return createMPackage();
      case GenesezMMPackage.MCLASS: return createMClass();
      case GenesezMMPackage.MASSOCIATION_ROLE: return createMAssociationRole();
      case GenesezMMPackage.MASSOCIATION: return createMAssociation();
      case GenesezMMPackage.MATTRIBUTE: return createMAttribute();
      case GenesezMMPackage.MMODEL: return createMModel();
      case GenesezMMPackage.MPROPERTY: return createMProperty();
      case GenesezMMPackage.MINTERFACE: return createMInterface();
      case GenesezMMPackage.MOPERATION: return createMOperation();
      case GenesezMMPackage.MPARAMETER: return createMParameter();
      case GenesezMMPackage.MDATA_TYPE: return createMDataType();
      case GenesezMMPackage.MPRIMITIVE_TYPE: return createMPrimitiveType();
      case GenesezMMPackage.MENUMERATION: return createMEnumeration();
      case GenesezMMPackage.MSTEREOTYPE: return createMStereotype();
      case GenesezMMPackage.MTAG: return createMTag();
      case GenesezMMPackage.MCOMMENT: return createMComment();
      case GenesezMMPackage.MTAGGED_VALUE: return createMTaggedValue();
      case GenesezMMPackage.MASPECT: return createMAspect();
      case GenesezMMPackage.MINTRODUCTION: return createMIntroduction();
      case GenesezMMPackage.MPOINTCUT: return createMPointcut();
      case GenesezMMPackage.MLITERAL: return createMLiteral();
      case GenesezMMPackage.MGENERIC: return createMGeneric();
      case GenesezMMPackage.MEXTERNAL: return createMExternal();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case GenesezMMPackage.MDESTINATION_KIND:
        return createMDestinationKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case GenesezMMPackage.MDESTINATION_KIND:
        return convertMDestinationKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage createMPackage()
  {
    MPackageImpl mPackage = new MPackageImpl();
    return mPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClass createMClass()
  {
    MClassImpl mClass = new MClassImpl();
    return mClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociationRole createMAssociationRole()
  {
    MAssociationRoleImpl mAssociationRole = new MAssociationRoleImpl();
    return mAssociationRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation createMAssociation()
  {
    MAssociationImpl mAssociation = new MAssociationImpl();
    return mAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAttribute createMAttribute()
  {
    MAttributeImpl mAttribute = new MAttributeImpl();
    return mAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel createMModel()
  {
    MModelImpl mModel = new MModelImpl();
    return mModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MProperty createMProperty()
  {
    MPropertyImpl mProperty = new MPropertyImpl();
    return mProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MInterface createMInterface()
  {
    MInterfaceImpl mInterface = new MInterfaceImpl();
    return mInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation createMOperation()
  {
    MOperationImpl mOperation = new MOperationImpl();
    return mOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MParameter createMParameter()
  {
    MParameterImpl mParameter = new MParameterImpl();
    return mParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDataType createMDataType()
  {
    MDataTypeImpl mDataType = new MDataTypeImpl();
    return mDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPrimitiveType createMPrimitiveType()
  {
    MPrimitiveTypeImpl mPrimitiveType = new MPrimitiveTypeImpl();
    return mPrimitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MEnumeration createMEnumeration()
  {
    MEnumerationImpl mEnumeration = new MEnumerationImpl();
    return mEnumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStereotype createMStereotype()
  {
    MStereotypeImpl mStereotype = new MStereotypeImpl();
    return mStereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTag createMTag()
  {
    MTagImpl mTag = new MTagImpl();
    return mTag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MComment createMComment()
  {
    MCommentImpl mComment = new MCommentImpl();
    return mComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTaggedValue createMTaggedValue()
  {
    MTaggedValueImpl mTaggedValue = new MTaggedValueImpl();
    return mTaggedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAspect createMAspect()
  {
    MAspectImpl mAspect = new MAspectImpl();
    return mAspect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MIntroduction createMIntroduction()
  {
    MIntroductionImpl mIntroduction = new MIntroductionImpl();
    return mIntroduction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPointcut createMPointcut()
  {
    MPointcutImpl mPointcut = new MPointcutImpl();
    return mPointcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MLiteral createMLiteral()
  {
    MLiteralImpl mLiteral = new MLiteralImpl();
    return mLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MGeneric createMGeneric()
  {
    MGenericImpl mGeneric = new MGenericImpl();
    return mGeneric;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MExternal createMExternal()
  {
    MExternalImpl mExternal = new MExternalImpl();
    return mExternal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDestinationKind createMDestinationKindFromString(EDataType eDataType, String initialValue)
  {
    MDestinationKind result = MDestinationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMDestinationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GenesezMMPackage getGenesezMMPackage()
  {
    return (GenesezMMPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static GenesezMMPackage getPackage()
  {
    return GenesezMMPackage.eINSTANCE;
  }

} //GenesezMMFactoryImpl
