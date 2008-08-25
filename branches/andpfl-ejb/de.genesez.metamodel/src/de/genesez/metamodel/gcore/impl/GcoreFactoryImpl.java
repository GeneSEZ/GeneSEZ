/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore.impl;

import de.genesez.metamodel.gcore.*;

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
public class GcoreFactoryImpl extends EFactoryImpl implements GcoreFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GcoreFactory init()
  {
    try
    {
      GcoreFactory theGcoreFactory = (GcoreFactory)EPackage.Registry.INSTANCE.getEFactory("platform:/plugin/de.genesez.metamodel/model-gen/gcore.ecore"); 
      if (theGcoreFactory != null)
      {
        return theGcoreFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GcoreFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GcoreFactoryImpl()
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
      case GcorePackage.MPACKAGE: return createMPackage();
      case GcorePackage.MCLASS: return createMClass();
      case GcorePackage.MASSOCIATION_ROLE: return createMAssociationRole();
      case GcorePackage.MASSOCIATION: return createMAssociation();
      case GcorePackage.MATTRIBUTE: return createMAttribute();
      case GcorePackage.MMODEL: return createMModel();
      case GcorePackage.MPROPERTY: return createMProperty();
      case GcorePackage.MINTERFACE: return createMInterface();
      case GcorePackage.MOPERATION: return createMOperation();
      case GcorePackage.MPARAMETER: return createMParameter();
      case GcorePackage.MDATA_TYPE: return createMDataType();
      case GcorePackage.MPRIMITIVE_TYPE: return createMPrimitiveType();
      case GcorePackage.MENUMERATION: return createMEnumeration();
      case GcorePackage.MSTEREOTYPE: return createMStereotype();
      case GcorePackage.MTAG: return createMTag();
      case GcorePackage.MCOMMENT: return createMComment();
      case GcorePackage.MTAGGED_VALUE: return createMTaggedValue();
      case GcorePackage.MASPECT: return createMAspect();
      case GcorePackage.MINTRODUCTION: return createMIntroduction();
      case GcorePackage.MPOINTCUT: return createMPointcut();
      case GcorePackage.MLITERAL: return createMLiteral();
      case GcorePackage.MGENERIC: return createMGeneric();
      case GcorePackage.MEXTERNAL: return createMExternal();
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
      case GcorePackage.MDESTINATION_KIND:
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
      case GcorePackage.MDESTINATION_KIND:
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
  public GcorePackage getGcorePackage()
  {
    return (GcorePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  public static GcorePackage getPackage()
  {
    return GcorePackage.eINSTANCE;
  }

} //GcoreFactoryImpl
