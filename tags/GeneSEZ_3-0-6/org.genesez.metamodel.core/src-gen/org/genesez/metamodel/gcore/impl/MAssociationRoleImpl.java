/**
 */
package org.genesez.metamodel.gcore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MAssociation;
import org.genesez.metamodel.gcore.MAssociationRole;
import org.genesez.metamodel.gcore.MMultiplicity;
import org.genesez.metamodel.gcore.MType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAssociation Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#isAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#isComposition <em>Composition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#getOppositeMultiplicity <em>Opposite Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MAssociationRoleImpl#getQualifierMultiplicity <em>Qualifier Multiplicity</em>}</li>
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
   * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifier()
   * @generated
   * @ordered
   */
  protected MType qualifier;

  /**
   * The cached value of the '{@link #getOppositeMultiplicity() <em>Opposite Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOppositeMultiplicity()
   * @generated
   * @ordered
   */
  protected MMultiplicity oppositeMultiplicity;

  /**
   * The cached value of the '{@link #getQualifierMultiplicity() <em>Qualifier Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifierMultiplicity()
   * @generated
   * @ordered
   */
  protected MMultiplicity qualifierMultiplicity;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MASSOCIATION_ROLE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__AGGREGATION, oldAggregation, aggregation));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__COMPOSITION, oldComposition, composition));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MASSOCIATION_ROLE__ASSOCIATION, oldAssociation, association));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__ASSOCIATION, oldAssociation, newAssociation);
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
        msgs = ((InternalEObject)association).eInverseRemove(this, GcorePackage.MASSOCIATION__END, MAssociation.class, msgs);
      if (newAssociation != null)
        msgs = ((InternalEObject)newAssociation).eInverseAdd(this, GcorePackage.MASSOCIATION__END, MAssociation.class, msgs);
      msgs = basicSetAssociation(newAssociation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__ASSOCIATION, newAssociation, newAssociation));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MASSOCIATION_ROLE__OPPOSITE, oldOpposite, opposite));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__OPPOSITE, oldOpposite, opposite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType getQualifier()
  {
    if (qualifier != null && qualifier.eIsProxy())
    {
      InternalEObject oldQualifier = (InternalEObject)qualifier;
      qualifier = (MType)eResolveProxy(oldQualifier);
      if (qualifier != oldQualifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MASSOCIATION_ROLE__QUALIFIER, oldQualifier, qualifier));
      }
    }
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType basicGetQualifier()
  {
    return qualifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifier(MType newQualifier)
  {
    MType oldQualifier = qualifier;
    qualifier = newQualifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__QUALIFIER, oldQualifier, qualifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMultiplicity getOppositeMultiplicity()
  {
    return oppositeMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOppositeMultiplicity(MMultiplicity newOppositeMultiplicity, NotificationChain msgs)
  {
    MMultiplicity oldOppositeMultiplicity = oppositeMultiplicity;
    oppositeMultiplicity = newOppositeMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY, oldOppositeMultiplicity, newOppositeMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOppositeMultiplicity(MMultiplicity newOppositeMultiplicity)
  {
    if (newOppositeMultiplicity != oppositeMultiplicity)
    {
      NotificationChain msgs = null;
      if (oppositeMultiplicity != null)
        msgs = ((InternalEObject)oppositeMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY, null, msgs);
      if (newOppositeMultiplicity != null)
        msgs = ((InternalEObject)newOppositeMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY, null, msgs);
      msgs = basicSetOppositeMultiplicity(newOppositeMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY, newOppositeMultiplicity, newOppositeMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMultiplicity getQualifierMultiplicity()
  {
    return qualifierMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifierMultiplicity(MMultiplicity newQualifierMultiplicity, NotificationChain msgs)
  {
    MMultiplicity oldQualifierMultiplicity = qualifierMultiplicity;
    qualifierMultiplicity = newQualifierMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY, oldQualifierMultiplicity, newQualifierMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualifierMultiplicity(MMultiplicity newQualifierMultiplicity)
  {
    if (newQualifierMultiplicity != qualifierMultiplicity)
    {
      NotificationChain msgs = null;
      if (qualifierMultiplicity != null)
        msgs = ((InternalEObject)qualifierMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY, null, msgs);
      if (newQualifierMultiplicity != null)
        msgs = ((InternalEObject)newQualifierMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY, null, msgs);
      msgs = basicSetQualifierMultiplicity(newQualifierMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY, newQualifierMultiplicity, newQualifierMultiplicity));
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
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        if (association != null)
          msgs = ((InternalEObject)association).eInverseRemove(this, GcorePackage.MASSOCIATION__END, MAssociation.class, msgs);
        return basicSetAssociation((MAssociation)otherEnd, msgs);
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
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        return basicSetAssociation(null, msgs);
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY:
        return basicSetOppositeMultiplicity(null, msgs);
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY:
        return basicSetQualifierMultiplicity(null, msgs);
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
      case GcorePackage.MASSOCIATION_ROLE__AGGREGATION:
        return isAggregation();
      case GcorePackage.MASSOCIATION_ROLE__COMPOSITION:
        return isComposition();
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        if (resolve) return getAssociation();
        return basicGetAssociation();
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE:
        if (resolve) return getOpposite();
        return basicGetOpposite();
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER:
        if (resolve) return getQualifier();
        return basicGetQualifier();
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY:
        return getOppositeMultiplicity();
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY:
        return getQualifierMultiplicity();
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
      case GcorePackage.MASSOCIATION_ROLE__AGGREGATION:
        setAggregation((Boolean)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__COMPOSITION:
        setComposition((Boolean)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        setAssociation((MAssociation)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE:
        setOpposite((MAssociationRole)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER:
        setQualifier((MType)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY:
        setOppositeMultiplicity((MMultiplicity)newValue);
        return;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY:
        setQualifierMultiplicity((MMultiplicity)newValue);
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
      case GcorePackage.MASSOCIATION_ROLE__AGGREGATION:
        setAggregation(AGGREGATION_EDEFAULT);
        return;
      case GcorePackage.MASSOCIATION_ROLE__COMPOSITION:
        setComposition(COMPOSITION_EDEFAULT);
        return;
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        setAssociation((MAssociation)null);
        return;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE:
        setOpposite((MAssociationRole)null);
        return;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER:
        setQualifier((MType)null);
        return;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY:
        setOppositeMultiplicity((MMultiplicity)null);
        return;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY:
        setQualifierMultiplicity((MMultiplicity)null);
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
      case GcorePackage.MASSOCIATION_ROLE__AGGREGATION:
        return aggregation != AGGREGATION_EDEFAULT;
      case GcorePackage.MASSOCIATION_ROLE__COMPOSITION:
        return composition != COMPOSITION_EDEFAULT;
      case GcorePackage.MASSOCIATION_ROLE__ASSOCIATION:
        return association != null;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE:
        return opposite != null;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER:
        return qualifier != null;
      case GcorePackage.MASSOCIATION_ROLE__OPPOSITE_MULTIPLICITY:
        return oppositeMultiplicity != null;
      case GcorePackage.MASSOCIATION_ROLE__QUALIFIER_MULTIPLICITY:
        return qualifierMultiplicity != null;
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
    result.append(" (aggregation: ");
    result.append(aggregation);
    result.append(", composition: ");
    result.append(composition);
    result.append(')');
    return result.toString();
  }

} //MAssociationRoleImpl
