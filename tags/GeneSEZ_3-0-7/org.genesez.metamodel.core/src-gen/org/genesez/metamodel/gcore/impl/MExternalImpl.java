/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAspect;
import org.genesez.metamodel.gcore.MComment;
import org.genesez.metamodel.gcore.MDependency;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MExternal;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.metamodel.gcore.MStereotype;
import org.genesez.metamodel.gcore.MTaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MExternal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getAspect <em>Aspect</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MExternalImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MExternalImpl extends MTypeImpl implements MExternal
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
  protected EList<MComment> ownedComment;

  /**
   * The cached value of the '{@link #getTaggedValue() <em>Tagged Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTaggedValue()
   * @generated
   * @ordered
   */
  protected EList<MTaggedValue> taggedValue;

  /**
   * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotype()
   * @generated
   * @ordered
   */
  protected EList<MStereotype> stereotype;

  /**
   * The cached value of the '{@link #getAspect() <em>Aspect</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAspect()
   * @generated
   * @ordered
   */
  protected EList<MAspect> aspect;

  /**
   * The cached value of the '{@link #getDependency() <em>Dependency</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDependency()
   * @generated
   * @ordered
   */
  protected EList<MDependency> dependency;

  /**
   * The cached value of the '{@link #getGenericParameter() <em>Generic Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericParameter()
   * @generated
   * @ordered
   */
  protected EList<MGeneric> genericParameter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MExternalImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MEXTERNAL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MEXTERNAL__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MEXTERNAL__XMI_GUID, oldXmiGuid, xmiGuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MComment> getOwnedComment()
  {
    if (ownedComment == null)
    {
      ownedComment = new EObjectContainmentWithInverseEList<MComment>(MComment.class, this, GcorePackage.MEXTERNAL__OWNED_COMMENT, GcorePackage.MCOMMENT__OWNING_ELEMENT);
    }
    return ownedComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTaggedValue> getTaggedValue()
  {
    if (taggedValue == null)
    {
      taggedValue = new EObjectContainmentWithInverseEList<MTaggedValue>(MTaggedValue.class, this, GcorePackage.MEXTERNAL__TAGGED_VALUE, GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT);
    }
    return taggedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MStereotype> getStereotype()
  {
    if (stereotype == null)
    {
      stereotype = new EObjectResolvingEList<MStereotype>(MStereotype.class, this, GcorePackage.MEXTERNAL__STEREOTYPE);
    }
    return stereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MAspect> getAspect()
  {
    if (aspect == null)
    {
      aspect = new EObjectContainmentWithInverseEList<MAspect>(MAspect.class, this, GcorePackage.MEXTERNAL__ASPECT, GcorePackage.MASPECT__ELEMENT);
    }
    return aspect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MDependency> getDependency()
  {
    if (dependency == null)
    {
      dependency = new EObjectWithInverseResolvingEList.ManyInverse<MDependency>(MDependency.class, this, GcorePackage.MEXTERNAL__DEPENDENCY, GcorePackage.MDEPENDENCY__CLIENT);
    }
    return dependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MModel getModel()
  {
    if (eContainerFeatureID() != GcorePackage.MEXTERNAL__MODEL) return null;
    return (MModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MGeneric> getGenericParameter()
  {
    if (genericParameter == null)
    {
      genericParameter = new EObjectContainmentWithInverseEList<MGeneric>(MGeneric.class, this, GcorePackage.MEXTERNAL__GENERIC_PARAMETER, GcorePackage.MGENERIC__OWNING_EXTERNAL);
    }
    return genericParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTaggedValue()).basicAdd(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__ASPECT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspect()).basicAdd(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependency()).basicAdd(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MEXTERNAL__MODEL, msgs);
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenericParameter()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        return ((InternalEList<?>)getTaggedValue()).basicRemove(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__ASPECT:
        return ((InternalEList<?>)getAspect()).basicRemove(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        return ((InternalEList<?>)getDependency()).basicRemove(otherEnd, msgs);
      case GcorePackage.MEXTERNAL__MODEL:
        return eBasicSetContainer(null, GcorePackage.MEXTERNAL__MODEL, msgs);
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return ((InternalEList<?>)getGenericParameter()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case GcorePackage.MEXTERNAL__MODEL:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MMODEL__EXTERNAL_TYPES, MModel.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__NAME:
        return getName();
      case GcorePackage.MEXTERNAL__XMI_GUID:
        return getXmiGuid();
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        return getOwnedComment();
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        return getTaggedValue();
      case GcorePackage.MEXTERNAL__STEREOTYPE:
        return getStereotype();
      case GcorePackage.MEXTERNAL__ASPECT:
        return getAspect();
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        return getDependency();
      case GcorePackage.MEXTERNAL__MODEL:
        return getModel();
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return getGenericParameter();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__NAME:
        setName((String)newValue);
        return;
      case GcorePackage.MEXTERNAL__XMI_GUID:
        setXmiGuid((String)newValue);
        return;
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        getOwnedComment().clear();
        getOwnedComment().addAll((Collection<? extends MComment>)newValue);
        return;
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        getTaggedValue().clear();
        getTaggedValue().addAll((Collection<? extends MTaggedValue>)newValue);
        return;
      case GcorePackage.MEXTERNAL__STEREOTYPE:
        getStereotype().clear();
        getStereotype().addAll((Collection<? extends MStereotype>)newValue);
        return;
      case GcorePackage.MEXTERNAL__ASPECT:
        getAspect().clear();
        getAspect().addAll((Collection<? extends MAspect>)newValue);
        return;
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        getDependency().clear();
        getDependency().addAll((Collection<? extends MDependency>)newValue);
        return;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection<? extends MGeneric>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GcorePackage.MEXTERNAL__XMI_GUID:
        setXmiGuid(XMI_GUID_EDEFAULT);
        return;
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        getOwnedComment().clear();
        return;
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        getTaggedValue().clear();
        return;
      case GcorePackage.MEXTERNAL__STEREOTYPE:
        getStereotype().clear();
        return;
      case GcorePackage.MEXTERNAL__ASPECT:
        getAspect().clear();
        return;
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        getDependency().clear();
        return;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        getGenericParameter().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MEXTERNAL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GcorePackage.MEXTERNAL__XMI_GUID:
        return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
      case GcorePackage.MEXTERNAL__OWNED_COMMENT:
        return ownedComment != null && !ownedComment.isEmpty();
      case GcorePackage.MEXTERNAL__TAGGED_VALUE:
        return taggedValue != null && !taggedValue.isEmpty();
      case GcorePackage.MEXTERNAL__STEREOTYPE:
        return stereotype != null && !stereotype.isEmpty();
      case GcorePackage.MEXTERNAL__ASPECT:
        return aspect != null && !aspect.isEmpty();
      case GcorePackage.MEXTERNAL__DEPENDENCY:
        return dependency != null && !dependency.isEmpty();
      case GcorePackage.MEXTERNAL__MODEL:
        return getModel() != null;
      case GcorePackage.MEXTERNAL__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == MElement.class)
    {
      switch (derivedFeatureID)
      {
        case GcorePackage.MEXTERNAL__NAME: return GcorePackage.MELEMENT__NAME;
        case GcorePackage.MEXTERNAL__XMI_GUID: return GcorePackage.MELEMENT__XMI_GUID;
        case GcorePackage.MEXTERNAL__OWNED_COMMENT: return GcorePackage.MELEMENT__OWNED_COMMENT;
        case GcorePackage.MEXTERNAL__TAGGED_VALUE: return GcorePackage.MELEMENT__TAGGED_VALUE;
        case GcorePackage.MEXTERNAL__STEREOTYPE: return GcorePackage.MELEMENT__STEREOTYPE;
        case GcorePackage.MEXTERNAL__ASPECT: return GcorePackage.MELEMENT__ASPECT;
        case GcorePackage.MEXTERNAL__DEPENDENCY: return GcorePackage.MELEMENT__DEPENDENCY;
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
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == MElement.class)
    {
      switch (baseFeatureID)
      {
        case GcorePackage.MELEMENT__NAME: return GcorePackage.MEXTERNAL__NAME;
        case GcorePackage.MELEMENT__XMI_GUID: return GcorePackage.MEXTERNAL__XMI_GUID;
        case GcorePackage.MELEMENT__OWNED_COMMENT: return GcorePackage.MEXTERNAL__OWNED_COMMENT;
        case GcorePackage.MELEMENT__TAGGED_VALUE: return GcorePackage.MEXTERNAL__TAGGED_VALUE;
        case GcorePackage.MELEMENT__STEREOTYPE: return GcorePackage.MEXTERNAL__STEREOTYPE;
        case GcorePackage.MELEMENT__ASPECT: return GcorePackage.MEXTERNAL__ASPECT;
        case GcorePackage.MELEMENT__DEPENDENCY: return GcorePackage.MEXTERNAL__DEPENDENCY;
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
  @Override
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

} //MExternalImpl
