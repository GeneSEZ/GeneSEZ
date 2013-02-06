/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAction;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActionImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActionImpl#getOut <em>Out</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActionImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MActionImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MActionImpl extends MNodeImpl implements MAction
{
  /**
   * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehavior()
   * @generated
   * @ordered
   */
  protected MBehavior behavior;

  /**
   * The cached value of the '{@link #getOut() <em>Out</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOut()
   * @generated
   * @ordered
   */
  protected EList<MClassifier> out;

  /**
   * The cached value of the '{@link #getIn() <em>In</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIn()
   * @generated
   * @ordered
   */
  protected EList<MClassifier> in;

  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected MOperation operation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MActionImpl()
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
    return GcorePackage.Literals.MACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior getBehavior()
  {
    if (behavior != null && behavior.eIsProxy())
    {
      InternalEObject oldBehavior = (InternalEObject)behavior;
      behavior = (MBehavior)eResolveProxy(oldBehavior);
      if (behavior != oldBehavior)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MACTION__BEHAVIOR, oldBehavior, behavior));
      }
    }
    return behavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior basicGetBehavior()
  {
    return behavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehavior(MBehavior newBehavior)
  {
    MBehavior oldBehavior = behavior;
    behavior = newBehavior;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MACTION__BEHAVIOR, oldBehavior, behavior));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MClassifier> getOut()
  {
    if (out == null)
    {
      out = new EObjectResolvingEList<MClassifier>(MClassifier.class, this, GcorePackage.MACTION__OUT);
    }
    return out;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MClassifier> getIn()
  {
    if (in == null)
    {
      in = new EObjectResolvingEList<MClassifier>(MClassifier.class, this, GcorePackage.MACTION__IN);
    }
    return in;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation getOperation()
  {
    if (operation != null && operation.eIsProxy())
    {
      InternalEObject oldOperation = (InternalEObject)operation;
      operation = (MOperation)eResolveProxy(oldOperation);
      if (operation != oldOperation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MACTION__OPERATION, oldOperation, operation));
      }
    }
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MOperation basicGetOperation()
  {
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(MOperation newOperation)
  {
    MOperation oldOperation = operation;
    operation = newOperation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MACTION__OPERATION, oldOperation, operation));
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
      case GcorePackage.MACTION__BEHAVIOR:
        if (resolve) return getBehavior();
        return basicGetBehavior();
      case GcorePackage.MACTION__OUT:
        return getOut();
      case GcorePackage.MACTION__IN:
        return getIn();
      case GcorePackage.MACTION__OPERATION:
        if (resolve) return getOperation();
        return basicGetOperation();
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
      case GcorePackage.MACTION__BEHAVIOR:
        setBehavior((MBehavior)newValue);
        return;
      case GcorePackage.MACTION__OUT:
        getOut().clear();
        getOut().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MACTION__IN:
        getIn().clear();
        getIn().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MACTION__OPERATION:
        setOperation((MOperation)newValue);
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
      case GcorePackage.MACTION__BEHAVIOR:
        setBehavior((MBehavior)null);
        return;
      case GcorePackage.MACTION__OUT:
        getOut().clear();
        return;
      case GcorePackage.MACTION__IN:
        getIn().clear();
        return;
      case GcorePackage.MACTION__OPERATION:
        setOperation((MOperation)null);
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
      case GcorePackage.MACTION__BEHAVIOR:
        return behavior != null;
      case GcorePackage.MACTION__OUT:
        return out != null && !out.isEmpty();
      case GcorePackage.MACTION__IN:
        return in != null && !in.isEmpty();
      case GcorePackage.MACTION__OPERATION:
        return operation != null;
    }
    return super.eIsSet(featureID);
  }

} //MActionImpl
