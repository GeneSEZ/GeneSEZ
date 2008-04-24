/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.impl;

import de.genesez.metamodel.genesezMM.GenesezMMPackage;
import de.genesez.metamodel.genesezMM.MAssociation;
import de.genesez.metamodel.genesezMM.MAssociationRole;
import de.genesez.metamodel.genesezMM.MClass;
import de.genesez.metamodel.genesezMM.MPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MAssociationImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MAssociationImpl#getEnd <em>End</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MAssociationImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link de.genesez.metamodel.genesezMM.impl.MAssociationImpl#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAssociationImpl extends MElementImpl implements MAssociation
{
  /**
   * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected static final boolean DERIVED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDerived()
   * @generated
   * @ordered
   */
  protected boolean derived = DERIVED_EDEFAULT;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected EList end;

  /**
   * The cached value of the '{@link #getAssociationClass() <em>Association Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationClass()
   * @generated
   * @ordered
   */
  protected MClass associationClass;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MAssociationImpl()
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
    return GenesezMMPackage.Literals.MASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDerived()
  {
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerived(boolean newDerived)
  {
    boolean oldDerived = derived;
    derived = newDerived;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getEnd()
  {
    if (end == null)
    {
      end = new EObjectWithInverseResolvingEList(MAssociationRole.class, this, GenesezMMPackage.MASSOCIATION__END, GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION);
    }
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage getOwningPackage()
  {
    if (eContainerFeatureID != GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE) return null;
    return (MPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClass getAssociationClass()
  {
    if (associationClass != null && associationClass.eIsProxy())
    {
      InternalEObject oldAssociationClass = (InternalEObject)associationClass;
      associationClass = (MClass)eResolveProxy(oldAssociationClass);
      if (associationClass != oldAssociationClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
      }
    }
    return associationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClass basicGetAssociationClass()
  {
    return associationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssociationClass(MClass newAssociationClass, NotificationChain msgs)
  {
    MClass oldAssociationClass = associationClass;
    associationClass = newAssociationClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, newAssociationClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssociationClass(MClass newAssociationClass)
  {
    if (newAssociationClass != associationClass)
    {
      NotificationChain msgs = null;
      if (associationClass != null)
        msgs = ((InternalEObject)associationClass).eInverseRemove(this, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
      if (newAssociationClass != null)
        msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
      msgs = basicSetAssociationClass(newAssociationClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS, newAssociationClass, newAssociationClass));
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
      case GenesezMMPackage.MASSOCIATION__END:
        return ((InternalEList)getEnd()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE, msgs);
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        if (associationClass != null)
          msgs = ((InternalEObject)associationClass).eInverseRemove(this, GenesezMMPackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
        return basicSetAssociationClass((MClass)otherEnd, msgs);
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
      case GenesezMMPackage.MASSOCIATION__END:
        return ((InternalEList)getEnd()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE:
        return eBasicSetContainer(null, GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE, msgs);
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        return basicSetAssociationClass(null, msgs);
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
      case GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MPACKAGE__ASSOCIATION, MPackage.class, msgs);
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
      case GenesezMMPackage.MASSOCIATION__DERIVED:
        return isDerived() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MASSOCIATION__END:
        return getEnd();
      case GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE:
        return getOwningPackage();
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        if (resolve) return getAssociationClass();
        return basicGetAssociationClass();
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
      case GenesezMMPackage.MASSOCIATION__DERIVED:
        setDerived(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MASSOCIATION__END:
        getEnd().clear();
        getEnd().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        setAssociationClass((MClass)newValue);
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
      case GenesezMMPackage.MASSOCIATION__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case GenesezMMPackage.MASSOCIATION__END:
        getEnd().clear();
        return;
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        setAssociationClass((MClass)null);
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
      case GenesezMMPackage.MASSOCIATION__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case GenesezMMPackage.MASSOCIATION__END:
        return end != null && !end.isEmpty();
      case GenesezMMPackage.MASSOCIATION__OWNING_PACKAGE:
        return getOwningPackage() != null;
      case GenesezMMPackage.MASSOCIATION__ASSOCIATION_CLASS:
        return associationClass != null;
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
    result.append(" (derived: ");
    result.append(derived);
    result.append(')');
    return result.toString();
  }

} //MAssociationImpl
