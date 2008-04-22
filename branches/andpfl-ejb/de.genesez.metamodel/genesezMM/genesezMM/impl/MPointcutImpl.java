/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MAspect;
import genesezMM.MDestinationKind;
import genesezMM.MPointcut;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MPointcutImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link genesezMM.impl.MPointcutImpl#getName <em>Name</em>}</li>
 *   <li>{@link genesezMM.impl.MPointcutImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link genesezMM.impl.MPointcutImpl#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MPointcutImpl extends EObjectImpl implements MPointcut
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
   * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected static final MDestinationKind DESTINATION_EDEFAULT = MDestinationKind.ON_ENTRY_LITERAL;

  /**
   * The cached value of the '{@link #getDestination() <em>Destination</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDestination()
   * @generated
   * @ordered
   */
  protected MDestinationKind destination = DESTINATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MPointcutImpl()
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
    return GenesezMMPackage.Literals.MPOINTCUT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPOINTCUT__DOMAIN, oldDomain, domain));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPOINTCUT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDestinationKind getDestination()
  {
    return destination;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDestination(MDestinationKind newDestination)
  {
    MDestinationKind oldDestination = destination;
    destination = newDestination == null ? DESTINATION_EDEFAULT : newDestination;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MPOINTCUT__DESTINATION, oldDestination, destination));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAspect getOrigin()
  {
    if (eContainerFeatureID != GenesezMMPackage.MPOINTCUT__ORIGIN) return null;
    return (MAspect)eContainer();
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
      case GenesezMMPackage.MPOINTCUT__ORIGIN:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MPOINTCUT__ORIGIN, msgs);
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
      case GenesezMMPackage.MPOINTCUT__ORIGIN:
        return eBasicSetContainer(null, GenesezMMPackage.MPOINTCUT__ORIGIN, msgs);
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
      case GenesezMMPackage.MPOINTCUT__ORIGIN:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MASPECT__POINTCUT, MAspect.class, msgs);
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
      case GenesezMMPackage.MPOINTCUT__DOMAIN:
        return getDomain();
      case GenesezMMPackage.MPOINTCUT__NAME:
        return getName();
      case GenesezMMPackage.MPOINTCUT__DESTINATION:
        return getDestination();
      case GenesezMMPackage.MPOINTCUT__ORIGIN:
        return getOrigin();
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
      case GenesezMMPackage.MPOINTCUT__DOMAIN:
        setDomain((String)newValue);
        return;
      case GenesezMMPackage.MPOINTCUT__NAME:
        setName((String)newValue);
        return;
      case GenesezMMPackage.MPOINTCUT__DESTINATION:
        setDestination((MDestinationKind)newValue);
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
      case GenesezMMPackage.MPOINTCUT__DOMAIN:
        setDomain(DOMAIN_EDEFAULT);
        return;
      case GenesezMMPackage.MPOINTCUT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GenesezMMPackage.MPOINTCUT__DESTINATION:
        setDestination(DESTINATION_EDEFAULT);
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
      case GenesezMMPackage.MPOINTCUT__DOMAIN:
        return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
      case GenesezMMPackage.MPOINTCUT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GenesezMMPackage.MPOINTCUT__DESTINATION:
        return destination != DESTINATION_EDEFAULT;
      case GenesezMMPackage.MPOINTCUT__ORIGIN:
        return getOrigin() != null;
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
    result.append(", destination: ");
    result.append(destination);
    result.append(')');
    return result.toString();
  }

} //MPointcutImpl
