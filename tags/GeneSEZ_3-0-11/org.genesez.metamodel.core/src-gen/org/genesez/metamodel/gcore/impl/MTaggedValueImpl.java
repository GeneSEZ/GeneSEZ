/**
 */
package org.genesez.metamodel.gcore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MTag;
import org.genesez.metamodel.gcore.MTaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MTagged Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MTaggedValueImpl#getValueReference <em>Value Reference</em>}</li>
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
   * The cached value of the '{@link #getValueReference() <em>Value Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueReference()
   * @generated
   * @ordered
   */
  protected MElement valueReference;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MTAGGED_VALUE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTAGGED_VALUE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getOwningElement()
  {
    if (eContainerFeatureID() != GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT) return null;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTAGGED_VALUE__TAG, oldTag, tag));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTAGGED_VALUE__TAG, oldTag, tag));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getValueReference()
  {
    if (valueReference != null && valueReference.eIsProxy())
    {
      InternalEObject oldValueReference = (InternalEObject)valueReference;
      valueReference = (MElement)eResolveProxy(oldValueReference);
      if (valueReference != oldValueReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE, oldValueReference, valueReference));
      }
    }
    return valueReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement basicGetValueReference()
  {
    return valueReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueReference(MElement newValueReference)
  {
    MElement oldValueReference = valueReference;
    valueReference = newValueReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE, oldValueReference, valueReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT, msgs);
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
      case GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return eBasicSetContainer(null, GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT, msgs);
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
      case GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MELEMENT__TAGGED_VALUE, MElement.class, msgs);
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
      case GcorePackage.MTAGGED_VALUE__VALUE:
        return getValue();
      case GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return getOwningElement();
      case GcorePackage.MTAGGED_VALUE__TAG:
        if (resolve) return getTag();
        return basicGetTag();
      case GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE:
        if (resolve) return getValueReference();
        return basicGetValueReference();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GcorePackage.MTAGGED_VALUE__VALUE:
        setValue((String)newValue);
        return;
      case GcorePackage.MTAGGED_VALUE__TAG:
        setTag((MTag)newValue);
        return;
      case GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE:
        setValueReference((MElement)newValue);
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
      case GcorePackage.MTAGGED_VALUE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case GcorePackage.MTAGGED_VALUE__TAG:
        setTag((MTag)null);
        return;
      case GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE:
        setValueReference((MElement)null);
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
      case GcorePackage.MTAGGED_VALUE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case GcorePackage.MTAGGED_VALUE__OWNING_ELEMENT:
        return getOwningElement() != null;
      case GcorePackage.MTAGGED_VALUE__TAG:
        return tag != null;
      case GcorePackage.MTAGGED_VALUE__VALUE_REFERENCE:
        return valueReference != null;
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
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //MTaggedValueImpl
