/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MActivity;
import org.genesez.metamodel.gcore.MFlow;
import org.genesez.metamodel.gcore.MNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MActivity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActivityImpl#getEdge <em>Edge</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActivityImpl#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MActivityImpl extends MBehaviorImpl implements MActivity
{
  /**
   * The cached value of the '{@link #getEdge() <em>Edge</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEdge()
   * @generated
   * @ordered
   */
  protected EList<MFlow> edge;

  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected EList<MNode> node;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MActivityImpl()
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
    return GcorePackage.Literals.MACTIVITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MFlow> getEdge()
  {
    if (edge == null)
    {
      edge = new EObjectContainmentEList<MFlow>(MFlow.class, this, GcorePackage.MACTIVITY__EDGE);
    }
    return edge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MNode> getNode()
  {
    if (node == null)
    {
      node = new EObjectContainmentEList<MNode>(MNode.class, this, GcorePackage.MACTIVITY__NODE);
    }
    return node;
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
      case GcorePackage.MACTIVITY__EDGE:
        return ((InternalEList<?>)getEdge()).basicRemove(otherEnd, msgs);
      case GcorePackage.MACTIVITY__NODE:
        return ((InternalEList<?>)getNode()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MACTIVITY__EDGE:
        return getEdge();
      case GcorePackage.MACTIVITY__NODE:
        return getNode();
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
      case GcorePackage.MACTIVITY__EDGE:
        getEdge().clear();
        getEdge().addAll((Collection<? extends MFlow>)newValue);
        return;
      case GcorePackage.MACTIVITY__NODE:
        getNode().clear();
        getNode().addAll((Collection<? extends MNode>)newValue);
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
      case GcorePackage.MACTIVITY__EDGE:
        getEdge().clear();
        return;
      case GcorePackage.MACTIVITY__NODE:
        getNode().clear();
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
      case GcorePackage.MACTIVITY__EDGE:
        return edge != null && !edge.isEmpty();
      case GcorePackage.MACTIVITY__NODE:
        return node != null && !node.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MActivityImpl
