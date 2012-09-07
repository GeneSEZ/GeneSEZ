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

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAssociation;
import org.genesez.metamodel.gcore.MAssociationRole;
import org.genesez.metamodel.gcore.MClass;
import org.genesez.metamodel.gcore.MPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationImpl#getAssociationClass <em>Association Class</em>}</li>
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
  protected EList<MAssociationRole> end;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MASSOCIATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION__DERIVED, oldDerived, derived));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MAssociationRole> getEnd()
  {
    if (end == null)
    {
      end = new EObjectWithInverseResolvingEList<MAssociationRole>(MAssociationRole.class, this, GcorePackage.MASSOCIATION__END, GcorePackage.MASSOCIATION_ROLE__ASSOCIATION);
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
    if (eContainerFeatureID() != GcorePackage.MASSOCIATION__OWNING_PACKAGE) return null;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, newAssociationClass);
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
        msgs = ((InternalEObject)associationClass).eInverseRemove(this, GcorePackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
      if (newAssociationClass != null)
        msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, GcorePackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
      msgs = basicSetAssociationClass(newAssociationClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION__ASSOCIATION_CLASS, newAssociationClass, newAssociationClass));
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
      case GcorePackage.MASSOCIATION__END:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnd()).basicAdd(otherEnd, msgs);
      case GcorePackage.MASSOCIATION__OWNING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MASSOCIATION__OWNING_PACKAGE, msgs);
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
        if (associationClass != null)
          msgs = ((InternalEObject)associationClass).eInverseRemove(this, GcorePackage.MCLASS__OWNED_ASSOCIATION, MClass.class, msgs);
        return basicSetAssociationClass((MClass)otherEnd, msgs);
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
      case GcorePackage.MASSOCIATION__END:
        return ((InternalEList<?>)getEnd()).basicRemove(otherEnd, msgs);
      case GcorePackage.MASSOCIATION__OWNING_PACKAGE:
        return eBasicSetContainer(null, GcorePackage.MASSOCIATION__OWNING_PACKAGE, msgs);
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
        return basicSetAssociationClass(null, msgs);
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
      case GcorePackage.MASSOCIATION__OWNING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MPACKAGE__ASSOCIATION, MPackage.class, msgs);
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
      case GcorePackage.MASSOCIATION__DERIVED:
        return isDerived();
      case GcorePackage.MASSOCIATION__END:
        return getEnd();
      case GcorePackage.MASSOCIATION__OWNING_PACKAGE:
        return getOwningPackage();
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
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
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GcorePackage.MASSOCIATION__DERIVED:
        setDerived((Boolean)newValue);
        return;
      case GcorePackage.MASSOCIATION__END:
        getEnd().clear();
        getEnd().addAll((Collection<? extends MAssociationRole>)newValue);
        return;
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
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
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MASSOCIATION__DERIVED:
        setDerived(DERIVED_EDEFAULT);
        return;
      case GcorePackage.MASSOCIATION__END:
        getEnd().clear();
        return;
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
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
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MASSOCIATION__DERIVED:
        return derived != DERIVED_EDEFAULT;
      case GcorePackage.MASSOCIATION__END:
        return end != null && !end.isEmpty();
      case GcorePackage.MASSOCIATION__OWNING_PACKAGE:
        return getOwningPackage() != null;
      case GcorePackage.MASSOCIATION__ASSOCIATION_CLASS:
        return associationClass != null;
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
    result.append(" (derived: ");
    result.append(derived);
    result.append(')');
    return result.toString();
  }

} //MAssociationImpl
