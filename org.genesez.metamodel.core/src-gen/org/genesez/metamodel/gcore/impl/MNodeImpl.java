/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MFlow;
import org.genesez.metamodel.gcore.MNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MNodeImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MNodeImpl#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MNodeImpl extends MElementImpl implements MNode
{
  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected EList<MFlow> to;

  /**
   * The cached value of the '{@link #getFrom() <em>From</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFrom()
   * @generated
   * @ordered
   */
  protected EList<MFlow> from;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MNodeImpl()
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
    return GcorePackage.Literals.MNODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MFlow> getTo()
  {
    if (to == null)
    {
      to = new EObjectWithInverseResolvingEList<MFlow>(MFlow.class, this, GcorePackage.MNODE__TO, GcorePackage.MFLOW__SOURCE);
    }
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MFlow> getFrom()
  {
    if (from == null)
    {
      from = new EObjectWithInverseResolvingEList<MFlow>(MFlow.class, this, GcorePackage.MNODE__FROM, GcorePackage.MFLOW__TARGET);
    }
    return from;
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
      case GcorePackage.MNODE__TO:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTo()).basicAdd(otherEnd, msgs);
      case GcorePackage.MNODE__FROM:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getFrom()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MNODE__TO:
        return ((InternalEList<?>)getTo()).basicRemove(otherEnd, msgs);
      case GcorePackage.MNODE__FROM:
        return ((InternalEList<?>)getFrom()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MNODE__TO:
        return getTo();
      case GcorePackage.MNODE__FROM:
        return getFrom();
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
      case GcorePackage.MNODE__TO:
        getTo().clear();
        getTo().addAll((Collection<? extends MFlow>)newValue);
        return;
      case GcorePackage.MNODE__FROM:
        getFrom().clear();
        getFrom().addAll((Collection<? extends MFlow>)newValue);
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
      case GcorePackage.MNODE__TO:
        getTo().clear();
        return;
      case GcorePackage.MNODE__FROM:
        getFrom().clear();
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
      case GcorePackage.MNODE__TO:
        return to != null && !to.isEmpty();
      case GcorePackage.MNODE__FROM:
        return from != null && !from.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MNodeImpl
