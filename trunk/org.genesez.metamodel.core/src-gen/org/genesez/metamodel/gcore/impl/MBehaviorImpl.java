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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGuard;
import org.genesez.metamodel.gcore.MState;
import org.genesez.metamodel.gcore.MTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MBehavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getOwningContext <em>Owning Context</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MBehaviorImpl#getDo <em>Do</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MBehaviorImpl extends MElementImpl implements MBehavior
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
   * The cached value of the '{@link #getTransition() <em>Transition</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransition()
   * @generated
   * @ordered
   */
  protected EList<MTransition> transition;

  /**
   * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntry()
   * @generated
   * @ordered
   */
  protected EList<MState> entry;

  /**
   * The cached value of the '{@link #getExit() <em>Exit</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExit()
   * @generated
   * @ordered
   */
  protected EList<MState> exit;

  /**
   * The cached value of the '{@link #getDo() <em>Do</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDo()
   * @generated
   * @ordered
   */
  protected EList<MState> do_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MBehaviorImpl()
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
    return GcorePackage.Literals.MBEHAVIOR;
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
      classifier = new EObjectContainmentWithInverseEList<MClassifier>(MClassifier.class, this, GcorePackage.MBEHAVIOR__CLASSIFIER, GcorePackage.MCLASSIFIER__OWNING_CONTEXT);
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
      ownedBehavior = new EObjectContainmentWithInverseEList<MBehavior>(MBehavior.class, this, GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR, GcorePackage.MBEHAVIOR__OWNING_CONTEXT);
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
      guard = new EObjectContainmentWithInverseEList<MGuard>(MGuard.class, this, GcorePackage.MBEHAVIOR__GUARD, GcorePackage.MGUARD__OWNING_CONTEXT);
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
      event = new EObjectContainmentWithInverseEList<MEvent>(MEvent.class, this, GcorePackage.MBEHAVIOR__EVENT, GcorePackage.MEVENT__OWNING_CONTEXT);
    }
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDefinitionContext getOwningContext()
  {
    if (eContainerFeatureID() != GcorePackage.MBEHAVIOR__OWNING_CONTEXT) return null;
    return (MDefinitionContext)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTransition> getTransition()
  {
    if (transition == null)
    {
      transition = new EObjectWithInverseResolvingEList<MTransition>(MTransition.class, this, GcorePackage.MBEHAVIOR__TRANSITION, GcorePackage.MTRANSITION__ACTION);
    }
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MState> getEntry()
  {
    if (entry == null)
    {
      entry = new EObjectWithInverseResolvingEList<MState>(MState.class, this, GcorePackage.MBEHAVIOR__ENTRY, GcorePackage.MSTATE__ENTRY);
    }
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MState> getExit()
  {
    if (exit == null)
    {
      exit = new EObjectWithInverseResolvingEList<MState>(MState.class, this, GcorePackage.MBEHAVIOR__EXIT, GcorePackage.MSTATE__EXIT);
    }
    return exit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MState> getDo()
  {
    if (do_ == null)
    {
      do_ = new EObjectWithInverseResolvingEList<MState>(MState.class, this, GcorePackage.MBEHAVIOR__DO, GcorePackage.MSTATE__DO);
    }
    return do_;
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassifier()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBehavior()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__GUARD:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGuard()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__EVENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvent()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__OWNING_CONTEXT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MBEHAVIOR__OWNING_CONTEXT, msgs);
      case GcorePackage.MBEHAVIOR__TRANSITION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransition()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__ENTRY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntry()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__EXIT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getExit()).basicAdd(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__DO:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDo()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        return ((InternalEList<?>)getClassifier()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__GUARD:
        return ((InternalEList<?>)getGuard()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__EVENT:
        return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__OWNING_CONTEXT:
        return eBasicSetContainer(null, GcorePackage.MBEHAVIOR__OWNING_CONTEXT, msgs);
      case GcorePackage.MBEHAVIOR__TRANSITION:
        return ((InternalEList<?>)getTransition()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__ENTRY:
        return ((InternalEList<?>)getEntry()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__EXIT:
        return ((InternalEList<?>)getExit()).basicRemove(otherEnd, msgs);
      case GcorePackage.MBEHAVIOR__DO:
        return ((InternalEList<?>)getDo()).basicRemove(otherEnd, msgs);
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
      case GcorePackage.MBEHAVIOR__OWNING_CONTEXT:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR, MDefinitionContext.class, msgs);
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        return getClassifier();
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        return getOwnedBehavior();
      case GcorePackage.MBEHAVIOR__GUARD:
        return getGuard();
      case GcorePackage.MBEHAVIOR__EVENT:
        return getEvent();
      case GcorePackage.MBEHAVIOR__OWNING_CONTEXT:
        return getOwningContext();
      case GcorePackage.MBEHAVIOR__TRANSITION:
        return getTransition();
      case GcorePackage.MBEHAVIOR__ENTRY:
        return getEntry();
      case GcorePackage.MBEHAVIOR__EXIT:
        return getExit();
      case GcorePackage.MBEHAVIOR__DO:
        return getDo();
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        getClassifier().clear();
        getClassifier().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        getOwnedBehavior().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__GUARD:
        getGuard().clear();
        getGuard().addAll((Collection<? extends MGuard>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__EVENT:
        getEvent().clear();
        getEvent().addAll((Collection<? extends MEvent>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__TRANSITION:
        getTransition().clear();
        getTransition().addAll((Collection<? extends MTransition>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__ENTRY:
        getEntry().clear();
        getEntry().addAll((Collection<? extends MState>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__EXIT:
        getExit().clear();
        getExit().addAll((Collection<? extends MState>)newValue);
        return;
      case GcorePackage.MBEHAVIOR__DO:
        getDo().clear();
        getDo().addAll((Collection<? extends MState>)newValue);
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        getClassifier().clear();
        return;
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        return;
      case GcorePackage.MBEHAVIOR__GUARD:
        getGuard().clear();
        return;
      case GcorePackage.MBEHAVIOR__EVENT:
        getEvent().clear();
        return;
      case GcorePackage.MBEHAVIOR__TRANSITION:
        getTransition().clear();
        return;
      case GcorePackage.MBEHAVIOR__ENTRY:
        getEntry().clear();
        return;
      case GcorePackage.MBEHAVIOR__EXIT:
        getExit().clear();
        return;
      case GcorePackage.MBEHAVIOR__DO:
        getDo().clear();
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
      case GcorePackage.MBEHAVIOR__CLASSIFIER:
        return classifier != null && !classifier.isEmpty();
      case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR:
        return ownedBehavior != null && !ownedBehavior.isEmpty();
      case GcorePackage.MBEHAVIOR__GUARD:
        return guard != null && !guard.isEmpty();
      case GcorePackage.MBEHAVIOR__EVENT:
        return event != null && !event.isEmpty();
      case GcorePackage.MBEHAVIOR__OWNING_CONTEXT:
        return getOwningContext() != null;
      case GcorePackage.MBEHAVIOR__TRANSITION:
        return transition != null && !transition.isEmpty();
      case GcorePackage.MBEHAVIOR__ENTRY:
        return entry != null && !entry.isEmpty();
      case GcorePackage.MBEHAVIOR__EXIT:
        return exit != null && !exit.isEmpty();
      case GcorePackage.MBEHAVIOR__DO:
        return do_ != null && !do_.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == MDefinitionContext.class)
    {
      switch (derivedFeatureID)
      {
        case GcorePackage.MBEHAVIOR__CLASSIFIER: return GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER;
        case GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR: return GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR;
        case GcorePackage.MBEHAVIOR__GUARD: return GcorePackage.MDEFINITION_CONTEXT__GUARD;
        case GcorePackage.MBEHAVIOR__EVENT: return GcorePackage.MDEFINITION_CONTEXT__EVENT;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == MDefinitionContext.class)
    {
      switch (baseFeatureID)
      {
        case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER: return GcorePackage.MBEHAVIOR__CLASSIFIER;
        case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR: return GcorePackage.MBEHAVIOR__OWNED_BEHAVIOR;
        case GcorePackage.MDEFINITION_CONTEXT__GUARD: return GcorePackage.MBEHAVIOR__GUARD;
        case GcorePackage.MDEFINITION_CONTEXT__EVENT: return GcorePackage.MBEHAVIOR__EVENT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //MBehaviorImpl
