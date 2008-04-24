/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MAspect;
import genesezMM.MComment;
import genesezMM.MElement;
import genesezMM.MModel;
import genesezMM.MPrimitiveType;
import genesezMM.MStereotype;
import genesezMM.MTaggedValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPrimitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getAspect <em>Aspect</em>}</li>
 *   <li>{@link genesezMM.impl.MPrimitiveTypeImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPrimitiveTypeImpl extends MTypeImpl implements MPrimitiveType
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getXmiGuid() <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXmiGuid()
   * @generated
   * @ordered
   */
  protected static final String XMI_GUID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getXmiGuid() <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXmiGuid()
   * @generated
   * @ordered
   */
  protected String xmiGuid = XMI_GUID_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedComment() <em>Owned Comment</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedComment()
   * @generated
   * @ordered
   */
  protected EList ownedComment;

  /**
   * The cached value of the '{@link #getTaggedValue() <em>Tagged Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaggedValue()
   * @generated
   * @ordered
   */
  protected EList taggedValue;

  /**
   * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotype()
   * @generated
   * @ordered
   */
  protected EList stereotype;

  /**
   * The cached value of the '{@link #getAspect() <em>Aspect</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAspect()
   * @generated
   * @ordered
   */
  protected EList aspect;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MPrimitiveTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return GenesezMMPackage.Literals.MPRIMITIVE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPRIMITIVE_TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getXmiGuid()
  {
    return xmiGuid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXmiGuid(String newXmiGuid)
  {
    String oldXmiGuid = xmiGuid;
    xmiGuid = newXmiGuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID, oldXmiGuid, xmiGuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getOwnedComment()
  {
    if (ownedComment == null)
    {
      ownedComment = new EObjectContainmentWithInverseEList(MComment.class, this, GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT, GenesezMMPackage.MCOMMENT__OWNING_ELEMENT);
    }
    return ownedComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getTaggedValue()
  {
    if (taggedValue == null)
    {
      taggedValue = new EObjectContainmentWithInverseEList(MTaggedValue.class, this, GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE, GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT);
    }
    return taggedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getStereotype()
  {
    if (stereotype == null)
    {
      stereotype = new EObjectResolvingEList(MStereotype.class, this, GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE);
    }
    return stereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getAspect()
  {
    if (aspect == null)
    {
      aspect = new EObjectContainmentWithInverseEList(MAspect.class, this, GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT, GenesezMMPackage.MASPECT__ELEMENT);
    }
    return aspect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel getModel()
  {
    if (eContainerFeatureID != GenesezMMPackage.MPRIMITIVE_TYPE__MODEL) return null;
    return (MModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        return ((InternalEList)getOwnedComment()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        return ((InternalEList)getTaggedValue()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        return ((InternalEList)getAspect()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MPRIMITIVE_TYPE__MODEL, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        return ((InternalEList)getOwnedComment()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        return ((InternalEList)getAspect()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MPRIMITIVE_TYPE__MODEL:
        return eBasicSetContainer(null, GenesezMMPackage.MPRIMITIVE_TYPE__MODEL, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__MODEL:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MMODEL__PRIMITIVE_TYPES, MModel.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__NAME:
        return getName();
      case GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID:
        return getXmiGuid();
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        return getOwnedComment();
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        return getTaggedValue();
      case GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE:
        return getStereotype();
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        return getAspect();
      case GenesezMMPackage.MPRIMITIVE_TYPE__MODEL:
        return getModel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__NAME:
        setName((String)newValue);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID:
        setXmiGuid((String)newValue);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        getOwnedComment().clear();
        getOwnedComment().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        getTaggedValue().clear();
        getTaggedValue().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE:
        getStereotype().clear();
        getStereotype().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        getAspect().clear();
        getAspect().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID:
        setXmiGuid(XMI_GUID_EDEFAULT);
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        getOwnedComment().clear();
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        getTaggedValue().clear();
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE:
        getStereotype().clear();
        return;
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        getAspect().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MPRIMITIVE_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID:
        return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
      case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT:
        return ownedComment != null && !ownedComment.isEmpty();
      case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE:
        return taggedValue != null && !taggedValue.isEmpty();
      case GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE:
        return stereotype != null && !stereotype.isEmpty();
      case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT:
        return aspect != null && !aspect.isEmpty();
      case GenesezMMPackage.MPRIMITIVE_TYPE__MODEL:
        return getModel() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)
  {
    if (baseClass == MElement.class)
    {
      switch (derivedFeatureID)
      {
        case GenesezMMPackage.MPRIMITIVE_TYPE__NAME: return GenesezMMPackage.MELEMENT__NAME;
        case GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID: return GenesezMMPackage.MELEMENT__XMI_GUID;
        case GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT: return GenesezMMPackage.MELEMENT__OWNED_COMMENT;
        case GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE: return GenesezMMPackage.MELEMENT__TAGGED_VALUE;
        case GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE: return GenesezMMPackage.MELEMENT__STEREOTYPE;
        case GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT: return GenesezMMPackage.MELEMENT__ASPECT;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)
  {
    if (baseClass == MElement.class)
    {
      switch (baseFeatureID)
      {
        case GenesezMMPackage.MELEMENT__NAME: return GenesezMMPackage.MPRIMITIVE_TYPE__NAME;
        case GenesezMMPackage.MELEMENT__XMI_GUID: return GenesezMMPackage.MPRIMITIVE_TYPE__XMI_GUID;
        case GenesezMMPackage.MELEMENT__OWNED_COMMENT: return GenesezMMPackage.MPRIMITIVE_TYPE__OWNED_COMMENT;
        case GenesezMMPackage.MELEMENT__TAGGED_VALUE: return GenesezMMPackage.MPRIMITIVE_TYPE__TAGGED_VALUE;
        case GenesezMMPackage.MELEMENT__STEREOTYPE: return GenesezMMPackage.MPRIMITIVE_TYPE__STEREOTYPE;
        case GenesezMMPackage.MELEMENT__ASPECT: return GenesezMMPackage.MPRIMITIVE_TYPE__ASPECT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", xmiGuid: ");
    result.append(xmiGuid);
    result.append(')');
    return result.toString();
  }

} //MPrimitiveTypeImpl
