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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGuard;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MDefinition Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MDefinitionContextImpl#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MDefinitionContextImpl extends MElementImpl implements MDefinitionContext
{
  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected EList<MClassifier> classifier;

  /**
   * The cached value of the '{@link #getOwnedBehavior() <em>Owned Behavior</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedBehavior()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> ownedBehavior;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected EList<MGuard> guard;

  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected EList<MEvent> event;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MDefinitionContextImpl()
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
    return GcorePackage.Literals.MDEFINITION_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MClassifier> getClassifier()
  {
    if (classifier == null)
    {
      classifier = new EObjectContainmentWithInverseEList<MClassifier>(MClassifier.class, this, GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER, GcorePackage.MCLASSIFIER__OWNING_CONTEXT);
    }
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getOwnedBehavior()
  {
    if (ownedBehavior == null)
    {
      ownedBehavior = new EObjectContainmentWithInverseEList<MBehavior>(MBehavior.class, this, GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR, GcorePackage.MBEHAVIOR__OWNING_CONTEXT);
    }
    return ownedBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MGuard> getGuard()
  {
    if (guard == null)
    {
      guard = new EObjectContainmentWithInverseEList<MGuard>(MGuard.class, this, GcorePackage.MDEFINITION_CONTEXT__GUARD, GcorePackage.MGUARD__OWNING_CONTEXT);
    }
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MEvent> getEvent()
  {
    if (event == null)
    {
      event = new EObjectContainmentWithInverseEList<MEvent>(MEvent.class, this, GcorePackage.MDEFINITION_CONTEXT__EVENT, GcorePackage.MEVENT__OWNING_CONTEXT);
    }
    return event;
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassifier()).basicAdd(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBehavior()).basicAdd(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGuard()).basicAdd(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvent()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        return ((InternalEList<?>)getClassifier()).basicRemove(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        return ((InternalEList<?>)getGuard()).basicRemove(otherEnd, msgs);
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        return getClassifier();
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        return getOwnedBehavior();
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        return getGuard();
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        return getEvent();
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        getClassifier().clear();
        getClassifier().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        getOwnedBehavior().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        getGuard().clear();
        getGuard().addAll((Collection<? extends MGuard>)newValue);
        return;
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        getEvent().clear();
        getEvent().addAll((Collection<? extends MEvent>)newValue);
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        getClassifier().clear();
        return;
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        return;
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        getGuard().clear();
        return;
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        getEvent().clear();
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
      case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER:
        return classifier != null && !classifier.isEmpty();
      case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR:
        return ownedBehavior != null && !ownedBehavior.isEmpty();
      case GcorePackage.MDEFINITION_CONTEXT__GUARD:
        return guard != null && !guard.isEmpty();
      case GcorePackage.MDEFINITION_CONTEXT__EVENT:
        return event != null && !event.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MDefinitionContextImpl
