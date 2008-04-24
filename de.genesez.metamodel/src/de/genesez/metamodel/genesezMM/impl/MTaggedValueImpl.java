/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.impl;

import de.genesez.metamodel.genesezMM.GenesezMMPackage;
import de.genesez.metamodel.genesezMM.MElement;
import de.genesez.metamodel.genesezMM.MTag;
import de.genesez.metamodel.genesezMM.MTaggedValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MTagged Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MTaggedValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MTaggedValueImpl#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MTaggedValueImpl#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MTaggedValueImpl extends EObjectImpl implements MTaggedValue
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTag() <em>Tag</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected MTag tag;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MTaggedValueImpl()
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
    return GenesezMMPackage.Literals.MTAGGED_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MTAGGED_VALUE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getOwningElement()
  {
    if (eContainerFeatureID != GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT) return null;
    return (MElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTag getTag()
  {
    if (tag != null && tag.eIsProxy())
    {
      InternalEObject oldTag = (InternalEObject)tag;
      tag = (MTag)eResolveProxy(oldTag);
      if (tag != oldTag)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MTAGGED_VALUE__TAG, oldTag, tag));
      }
    }
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MTag basicGetTag()
  {
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTag(MTag newTag)
  {
    MTag oldTag = tag;
    tag = newTag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MTAGGED_VALUE__TAG, oldTag, tag));
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
      case GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT, msgs);
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
      case GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return eBasicSetContainer(null, GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT, msgs);
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
      case GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MELEMENT__TAGGED_VALUE, MElement.class, msgs);
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
      case GenesezMMPackage.MTAGGED_VALUE__VALUE:
        return getValue();
      case GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return getOwningElement();
      case GenesezMMPackage.MTAGGED_VALUE__TAG:
        if (resolve) return getTag();
        return basicGetTag();
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
      case GenesezMMPackage.MTAGGED_VALUE__VALUE:
        setValue((String)newValue);
        return;
      case GenesezMMPackage.MTAGGED_VALUE__TAG:
        setTag((MTag)newValue);
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
      case GenesezMMPackage.MTAGGED_VALUE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case GenesezMMPackage.MTAGGED_VALUE__TAG:
        setTag((MTag)null);
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
      case GenesezMMPackage.MTAGGED_VALUE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case GenesezMMPackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return getOwningElement() != null;
      case GenesezMMPackage.MTAGGED_VALUE__TAG:
        return tag != null;
    }
    return super.eIsSet(featureID);
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
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //MTaggedValueImpl
