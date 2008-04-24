/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MAspect;
import genesezMM.MElement;
import genesezMM.MIntroduction;
import genesezMM.MPointcut;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MAspectImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link genesezMM.impl.MAspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link genesezMM.impl.MAspectImpl#getElement <em>Element</em>}</li>
 *   <li>{@link genesezMM.impl.MAspectImpl#getIntroduction <em>Introduction</em>}</li>
 *   <li>{@link genesezMM.impl.MAspectImpl#getPointcut <em>Pointcut</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAspectImpl extends EObjectImpl implements MAspect
{
  /**
   * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected static final String DOMAIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected String domain = DOMAIN_EDEFAULT;

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
   * The cached value of the '{@link #getIntroduction() <em>Introduction</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntroduction()
   * @generated
   * @ordered
   */
  protected EList introduction;

  /**
   * The cached value of the '{@link #getPointcut() <em>Pointcut</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPointcut()
   * @generated
   * @ordered
   */
  protected EList pointcut;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MAspectImpl()
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
    return GenesezMMPackage.Literals.MASPECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDomain()
  {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDomain(String newDomain)
  {
    String oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASPECT__DOMAIN, oldDomain, domain));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASPECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getElement()
  {
    if (eContainerFeatureID != GenesezMMPackage.MASPECT__ELEMENT) return null;
    return (MElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getIntroduction()
  {
    if (introduction == null)
    {
      introduction = new EObjectContainmentWithInverseEList(MIntroduction.class, this, GenesezMMPackage.MASPECT__INTRODUCTION, GenesezMMPackage.MINTRODUCTION__ORIGIN);
    }
    return introduction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getPointcut()
  {
    if (pointcut == null)
    {
      pointcut = new EObjectContainmentWithInverseEList(MPointcut.class, this, GenesezMMPackage.MASPECT__POINTCUT, GenesezMMPackage.MPOINTCUT__ORIGIN);
    }
    return pointcut;
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
      case GenesezMMPackage.MASPECT__ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MASPECT__ELEMENT, msgs);
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        return ((InternalEList)getIntroduction()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MASPECT__POINTCUT:
        return ((InternalEList)getPointcut()).basicAdd(otherEnd, msgs);
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
      case GenesezMMPackage.MASPECT__ELEMENT:
        return eBasicSetContainer(null, GenesezMMPackage.MASPECT__ELEMENT, msgs);
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        return ((InternalEList)getIntroduction()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MASPECT__POINTCUT:
        return ((InternalEList)getPointcut()).basicRemove(otherEnd, msgs);
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
      case GenesezMMPackage.MASPECT__ELEMENT:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MELEMENT__ASPECT, MElement.class, msgs);
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
      case GenesezMMPackage.MASPECT__DOMAIN:
        return getDomain();
      case GenesezMMPackage.MASPECT__NAME:
        return getName();
      case GenesezMMPackage.MASPECT__ELEMENT:
        return getElement();
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        return getIntroduction();
      case GenesezMMPackage.MASPECT__POINTCUT:
        return getPointcut();
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
      case GenesezMMPackage.MASPECT__DOMAIN:
        setDomain((String)newValue);
        return;
      case GenesezMMPackage.MASPECT__NAME:
        setName((String)newValue);
        return;
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        getIntroduction().clear();
        getIntroduction().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MASPECT__POINTCUT:
        getPointcut().clear();
        getPointcut().addAll((Collection)newValue);
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
      case GenesezMMPackage.MASPECT__DOMAIN:
        setDomain(DOMAIN_EDEFAULT);
        return;
      case GenesezMMPackage.MASPECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        getIntroduction().clear();
        return;
      case GenesezMMPackage.MASPECT__POINTCUT:
        getPointcut().clear();
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
      case GenesezMMPackage.MASPECT__DOMAIN:
        return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
      case GenesezMMPackage.MASPECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GenesezMMPackage.MASPECT__ELEMENT:
        return getElement() != null;
      case GenesezMMPackage.MASPECT__INTRODUCTION:
        return introduction != null && !introduction.isEmpty();
      case GenesezMMPackage.MASPECT__POINTCUT:
        return pointcut != null && !pointcut.isEmpty();
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
    result.append(" (domain: ");
    result.append(domain);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //MAspectImpl
