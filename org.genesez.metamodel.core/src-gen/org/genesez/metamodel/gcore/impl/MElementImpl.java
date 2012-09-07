/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAspect;
import org.genesez.metamodel.gcore.MComment;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MStereotype;
import org.genesez.metamodel.gcore.MTaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getOwnedComment <em>Owned Comment</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getTaggedValue <em>Tagged Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MElementImpl#getAspect <em>Aspect</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MElementImpl extends EObjectImpl implements MElement
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MElementImpl()
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
    return GcorePackage.Literals.MELEMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MELEMENT__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MELEMENT__XMI_GUID, oldXmiGuid, xmiGuid));
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
      ownedComment = new EObjectContainmentWithInverseEList<MComment>(MComment.class, this, GcorePackage.MELEMENT__OWNED_COMMENT, GcorePackage.MCOMMENT__OWNING_ELEMENT);
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
      taggedValue = new EObjectContainmentWithInverseEList<MTaggedValue>(MTaggedValue.class, this, GcorePackage.MELEMENT__TAGGED_VALUE, GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT);
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
      stereotype = new EObjectResolvingEList<MStereotype>(MStereotype.class, this, GcorePackage.MELEMENT__STEREOTYPE);
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
      aspect = new EObjectContainmentWithInverseEList<MAspect>(MAspect.class, this, GcorePackage.MELEMENT__ASPECT, GcorePackage.MASPECT__ELEMENT);
    }
    return aspect;
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
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedComment()).basicAdd(otherEnd, msgs);
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTaggedValue()).basicAdd(otherEnd, msgs);
      case GcorePackage.MELEMENT__ASPECT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspect()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        return ((InternalEList<?>)getOwnedComment()).basicRemove(otherEnd, msgs);
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        return ((InternalEList<?>)getTaggedValue()).basicRemove(otherEnd, msgs);
      case GcorePackage.MELEMENT__ASPECT:
        return ((InternalEList<?>)getAspect()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GcorePackage.MELEMENT__NAME:
        return getName();
      case GcorePackage.MELEMENT__XMI_GUID:
        return getXmiGuid();
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        return getOwnedComment();
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        return getTaggedValue();
      case GcorePackage.MELEMENT__STEREOTYPE:
        return getStereotype();
      case GcorePackage.MELEMENT__ASPECT:
        return getAspect();
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
      case GcorePackage.MELEMENT__NAME:
        setName((String)newValue);
        return;
      case GcorePackage.MELEMENT__XMI_GUID:
        setXmiGuid((String)newValue);
        return;
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        getOwnedComment().clear();
        getOwnedComment().addAll((Collection<? extends MComment>)newValue);
        return;
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        getTaggedValue().clear();
        getTaggedValue().addAll((Collection<? extends MTaggedValue>)newValue);
        return;
      case GcorePackage.MELEMENT__STEREOTYPE:
        getStereotype().clear();
        getStereotype().addAll((Collection<? extends MStereotype>)newValue);
        return;
      case GcorePackage.MELEMENT__ASPECT:
        getAspect().clear();
        getAspect().addAll((Collection<? extends MAspect>)newValue);
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
      case GcorePackage.MELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GcorePackage.MELEMENT__XMI_GUID:
        setXmiGuid(XMI_GUID_EDEFAULT);
        return;
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        getOwnedComment().clear();
        return;
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        getTaggedValue().clear();
        return;
      case GcorePackage.MELEMENT__STEREOTYPE:
        getStereotype().clear();
        return;
      case GcorePackage.MELEMENT__ASPECT:
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
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GcorePackage.MELEMENT__XMI_GUID:
        return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
      case GcorePackage.MELEMENT__OWNED_COMMENT:
        return ownedComment != null && !ownedComment.isEmpty();
      case GcorePackage.MELEMENT__TAGGED_VALUE:
        return taggedValue != null && !taggedValue.isEmpty();
      case GcorePackage.MELEMENT__STEREOTYPE:
        return stereotype != null && !stereotype.isEmpty();
      case GcorePackage.MELEMENT__ASPECT:
        return aspect != null && !aspect.isEmpty();
    }
    return super.eIsSet(featureID);
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

} //MElementImpl
