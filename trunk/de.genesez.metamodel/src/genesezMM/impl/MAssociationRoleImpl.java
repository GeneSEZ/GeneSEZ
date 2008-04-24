/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MAssociation;
import genesezMM.MAssociationRole;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MAssociationRoleImpl#isAggregation <em>Aggregation</em>}</li>
 *   <li>{@link genesezMM.impl.MAssociationRoleImpl#isComposition <em>Composition</em>}</li>
 *   <li>{@link genesezMM.impl.MAssociationRoleImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link genesezMM.impl.MAssociationRoleImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MAssociationRoleImpl extends MPropertyImpl implements MAssociationRole
{
  /**
   * The default value of the '{@link #isAggregation() <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAggregation()
   * @generated
   * @ordered
   */
  protected static final boolean AGGREGATION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAggregation() <em>Aggregation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAggregation()
   * @generated
   * @ordered
   */
  protected boolean aggregation = AGGREGATION_EDEFAULT;

  /**
   * The default value of the '{@link #isComposition() <em>Composition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComposition()
   * @generated
   * @ordered
   */
  protected static final boolean COMPOSITION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isComposition() <em>Composition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isComposition()
   * @generated
   * @ordered
   */
  protected boolean composition = COMPOSITION_EDEFAULT;

  /**
   * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociation()
   * @generated
   * @ordered
   */
  protected MAssociation association;

  /**
   * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpposite()
   * @generated
   * @ordered
   */
  protected MAssociationRole opposite;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MAssociationRoleImpl()
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
    return GenesezMMPackage.Literals.MASSOCIATION_ROLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAggregation()
  {
    return aggregation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAggregation(boolean newAggregation)
  {
    boolean oldAggregation = aggregation;
    aggregation = newAggregation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION_ROLE__AGGREGATION, oldAggregation, aggregation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isComposition()
  {
    return composition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComposition(boolean newComposition)
  {
    boolean oldComposition = composition;
    composition = newComposition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION_ROLE__COMPOSITION, oldComposition, composition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation getAssociation()
  {
    if (association != null && association.eIsProxy())
    {
      InternalEObject oldAssociation = (InternalEObject)association;
      association = (MAssociation)eResolveProxy(oldAssociation);
      if (association != oldAssociation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION, oldAssociation, association));
      }
    }
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociation basicGetAssociation()
  {
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssociation(MAssociation newAssociation, NotificationChain msgs)
  {
    MAssociation oldAssociation = association;
    association = newAssociation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION, oldAssociation, newAssociation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssociation(MAssociation newAssociation)
  {
    if (newAssociation != association)
    {
      NotificationChain msgs = null;
      if (association != null)
        msgs = ((InternalEObject)association).eInverseRemove(this, GenesezMMPackage.MASSOCIATION__END, MAssociation.class, msgs);
      if (newAssociation != null)
        msgs = ((InternalEObject)newAssociation).eInverseAdd(this, GenesezMMPackage.MASSOCIATION__END, MAssociation.class, msgs);
      msgs = basicSetAssociation(newAssociation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION, newAssociation, newAssociation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociationRole getOpposite()
  {
    if (opposite != null && opposite.eIsProxy())
    {
      InternalEObject oldOpposite = (InternalEObject)opposite;
      opposite = (MAssociationRole)eResolveProxy(oldOpposite);
      if (opposite != oldOpposite)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE, oldOpposite, opposite));
      }
    }
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MAssociationRole basicGetOpposite()
  {
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpposite(MAssociationRole newOpposite)
  {
    MAssociationRole oldOpposite = opposite;
    opposite = newOpposite;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE, oldOpposite, opposite));
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
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        if (association != null)
          msgs = ((InternalEObject)association).eInverseRemove(this, GenesezMMPackage.MASSOCIATION__END, MAssociation.class, msgs);
        return basicSetAssociation((MAssociation)otherEnd, msgs);
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
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        return basicSetAssociation(null, msgs);
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
      case GenesezMMPackage.MASSOCIATION_ROLE__AGGREGATION:
        return isAggregation() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MASSOCIATION_ROLE__COMPOSITION:
        return isComposition() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        if (resolve) return getAssociation();
        return basicGetAssociation();
      case GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE:
        if (resolve) return getOpposite();
        return basicGetOpposite();
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
      case GenesezMMPackage.MASSOCIATION_ROLE__AGGREGATION:
        setAggregation(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__COMPOSITION:
        setComposition(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        setAssociation((MAssociation)newValue);
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE:
        setOpposite((MAssociationRole)newValue);
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
      case GenesezMMPackage.MASSOCIATION_ROLE__AGGREGATION:
        setAggregation(AGGREGATION_EDEFAULT);
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__COMPOSITION:
        setComposition(COMPOSITION_EDEFAULT);
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        setAssociation((MAssociation)null);
        return;
      case GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE:
        setOpposite((MAssociationRole)null);
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
      case GenesezMMPackage.MASSOCIATION_ROLE__AGGREGATION:
        return aggregation != AGGREGATION_EDEFAULT;
      case GenesezMMPackage.MASSOCIATION_ROLE__COMPOSITION:
        return composition != COMPOSITION_EDEFAULT;
      case GenesezMMPackage.MASSOCIATION_ROLE__ASSOCIATION:
        return association != null;
      case GenesezMMPackage.MASSOCIATION_ROLE__OPPOSITE:
        return opposite != null;
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
    result.append(" (aggregation: ");
    result.append(aggregation);
    result.append(", composition: ");
    result.append(composition);
    result.append(')');
    return result.toString();
  }

} //MAssociationRoleImpl
