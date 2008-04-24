/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.impl;

import de.genesez.metamodel.genesezMM.GenesezMMPackage;
import de.genesez.metamodel.genesezMM.MAssociation;
import de.genesez.metamodel.genesezMM.MClass;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MClassImpl#getOwnedAssociation <em>Owned Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MClassImpl extends MClassifierImpl implements MClass
{
  /**
   * The cached value of the '{@link #getOwnedAssociation() <em>Owned Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedAssociation()
   * @generated
   * @ordered
   */
  protected MAssociation ownedAssociation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MClassImpl()
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
    return GenesezMMPackage.Literals.MCLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation getOwnedAssociation()
  {
    if (ownedAssociation != null && ownedAssociation.eIsProxy())
    {
      InternalEObject oldOwnedAssociation = (InternalEObject)ownedAssociation;
      ownedAssociation = (MAssociation)eResolveProxy(oldOwnedAssociation);
      if (ownedAssociation != oldOwnedAssociation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, oldOwnedAssociation, ownedAssociation));
      }
    }
    return ownedAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation basicGetOwnedAssociation()
  {
    return ownedAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedAssociation(MAssociation newOwnedAssociation, NotificationChain msgs)
  {
    MAssociation oldOwnedAssociation = ownedAssociation;
    ownedAssociation = newOwnedAssociation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, oldOwnedAssociation, newOwnedAssociation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedAssociation(MAssociation newOwnedAssociation)
  {
    if (newOwnedAssociation != ownedAssociation)
    {
      NotificationChain msgs = null;
      if (ownedAssociation != null)
        msgs = ((InternalEObject)ownedAssociation).eInverseRemove(this, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, MAssociation.class, msgs);
      if (newOwnedAssociation != null)
        msgs = ((InternalEObject)newOwnedAssociation).eInverseAdd(this, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, MAssociation.class, msgs);
      msgs = basicSetOwnedAssociation(newOwnedAssociation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, newOwnedAssociation, newOwnedAssociation));
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        if (ownedAssociation != null)
          msgs = ((InternalEObject)ownedAssociation).eInverseRemove(this, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, MAssociation.class, msgs);
        return basicSetOwnedAssociation((MAssociation)otherEnd, msgs);
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        return basicSetOwnedAssociation(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        if (resolve) return getOwnedAssociation();
        return basicGetOwnedAssociation();
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        setOwnedAssociation((MAssociation)newValue);
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        setOwnedAssociation((MAssociation)null);
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
      case GenesezMMPackage.MCLASS__OWNED_ASSOCIATION:
        return ownedAssociation != null;
    }
    return super.eIsSet(featureID);
  }

} //MClassImpl
