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
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MCompositeState;
import org.genesez.metamodel.gcore.MState;
import org.genesez.metamodel.gcore.MStateMachine;
import org.genesez.metamodel.gcore.MTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MState</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getDo <em>Do</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MStateImpl#getSuperstate <em>Superstate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MStateImpl extends MElementImpl implements MState
{
  /**
   * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoing()
   * @generated
   * @ordered
   */
  protected EList<MTransition> outgoing;

  /**
   * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncoming()
   * @generated
   * @ordered
   */
  protected EList<MTransition> incoming;

  /**
   * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntry()
   * @generated
   * @ordered
   */
  protected MBehavior entry;

  /**
   * The cached value of the '{@link #getExit() <em>Exit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExit()
   * @generated
   * @ordered
   */
  protected MBehavior exit;

  /**
   * The cached value of the '{@link #getDo() <em>Do</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDo()
   * @generated
   * @ordered
   */
  protected MBehavior do_;

  /**
   * The cached value of the '{@link #getSuperstate() <em>Superstate</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperstate()
   * @generated
   * @ordered
   */
  protected MCompositeState superstate;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MStateImpl()
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
    return GcorePackage.Literals.MSTATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MStateMachine getOwner()
  {
    if (eContainerFeatureID() != GcorePackage.MSTATE__OWNER) return null;
    return (MStateMachine)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTransition> getOutgoing()
  {
    if (outgoing == null)
    {
      outgoing = new EObjectWithInverseResolvingEList<MTransition>(MTransition.class, this, GcorePackage.MSTATE__OUTGOING, GcorePackage.MTRANSITION__SOURCE);
    }
    return outgoing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MTransition> getIncoming()
  {
    if (incoming == null)
    {
      incoming = new EObjectWithInverseResolvingEList<MTransition>(MTransition.class, this, GcorePackage.MSTATE__INCOMING, GcorePackage.MTRANSITION__TARGET);
    }
    return incoming;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior getEntry()
  {
    if (entry != null && entry.eIsProxy())
    {
      InternalEObject oldEntry = (InternalEObject)entry;
      entry = (MBehavior)eResolveProxy(oldEntry);
      if (entry != oldEntry)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MSTATE__ENTRY, oldEntry, entry));
      }
    }
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior basicGetEntry()
  {
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEntry(MBehavior newEntry, NotificationChain msgs)
  {
    MBehavior oldEntry = entry;
    entry = newEntry;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__ENTRY, oldEntry, newEntry);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEntry(MBehavior newEntry)
  {
    if (newEntry != entry)
    {
      NotificationChain msgs = null;
      if (entry != null)
        msgs = ((InternalEObject)entry).eInverseRemove(this, GcorePackage.MBEHAVIOR__ENTRY, MBehavior.class, msgs);
      if (newEntry != null)
        msgs = ((InternalEObject)newEntry).eInverseAdd(this, GcorePackage.MBEHAVIOR__ENTRY, MBehavior.class, msgs);
      msgs = basicSetEntry(newEntry, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__ENTRY, newEntry, newEntry));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior getExit()
  {
    if (exit != null && exit.eIsProxy())
    {
      InternalEObject oldExit = (InternalEObject)exit;
      exit = (MBehavior)eResolveProxy(oldExit);
      if (exit != oldExit)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MSTATE__EXIT, oldExit, exit));
      }
    }
    return exit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior basicGetExit()
  {
    return exit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExit(MBehavior newExit, NotificationChain msgs)
  {
    MBehavior oldExit = exit;
    exit = newExit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__EXIT, oldExit, newExit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExit(MBehavior newExit)
  {
    if (newExit != exit)
    {
      NotificationChain msgs = null;
      if (exit != null)
        msgs = ((InternalEObject)exit).eInverseRemove(this, GcorePackage.MBEHAVIOR__EXIT, MBehavior.class, msgs);
      if (newExit != null)
        msgs = ((InternalEObject)newExit).eInverseAdd(this, GcorePackage.MBEHAVIOR__EXIT, MBehavior.class, msgs);
      msgs = basicSetExit(newExit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__EXIT, newExit, newExit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior getDo()
  {
    if (do_ != null && do_.eIsProxy())
    {
      InternalEObject oldDo = (InternalEObject)do_;
      do_ = (MBehavior)eResolveProxy(oldDo);
      if (do_ != oldDo)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MSTATE__DO, oldDo, do_));
      }
    }
    return do_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MBehavior basicGetDo()
  {
    return do_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDo(MBehavior newDo, NotificationChain msgs)
  {
    MBehavior oldDo = do_;
    do_ = newDo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__DO, oldDo, newDo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDo(MBehavior newDo)
  {
    if (newDo != do_)
    {
      NotificationChain msgs = null;
      if (do_ != null)
        msgs = ((InternalEObject)do_).eInverseRemove(this, GcorePackage.MBEHAVIOR__DO, MBehavior.class, msgs);
      if (newDo != null)
        msgs = ((InternalEObject)newDo).eInverseAdd(this, GcorePackage.MBEHAVIOR__DO, MBehavior.class, msgs);
      msgs = basicSetDo(newDo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__DO, newDo, newDo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MCompositeState getSuperstate()
  {
    if (superstate != null && superstate.eIsProxy())
    {
      InternalEObject oldSuperstate = (InternalEObject)superstate;
      superstate = (MCompositeState)eResolveProxy(oldSuperstate);
      if (superstate != oldSuperstate)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MSTATE__SUPERSTATE, oldSuperstate, superstate));
      }
    }
    return superstate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MCompositeState basicGetSuperstate()
  {
    return superstate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperstate(MCompositeState newSuperstate, NotificationChain msgs)
  {
    MCompositeState oldSuperstate = superstate;
    superstate = newSuperstate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__SUPERSTATE, oldSuperstate, newSuperstate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperstate(MCompositeState newSuperstate)
  {
    if (newSuperstate != superstate)
    {
      NotificationChain msgs = null;
      if (superstate != null)
        msgs = ((InternalEObject)superstate).eInverseRemove(this, GcorePackage.MCOMPOSITE_STATE__SUBSTATE, MCompositeState.class, msgs);
      if (newSuperstate != null)
        msgs = ((InternalEObject)newSuperstate).eInverseAdd(this, GcorePackage.MCOMPOSITE_STATE__SUBSTATE, MCompositeState.class, msgs);
      msgs = basicSetSuperstate(newSuperstate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MSTATE__SUPERSTATE, newSuperstate, newSuperstate));
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
      case GcorePackage.MSTATE__OWNER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MSTATE__OWNER, msgs);
      case GcorePackage.MSTATE__OUTGOING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
      case GcorePackage.MSTATE__INCOMING:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
      case GcorePackage.MSTATE__ENTRY:
        if (entry != null)
          msgs = ((InternalEObject)entry).eInverseRemove(this, GcorePackage.MBEHAVIOR__ENTRY, MBehavior.class, msgs);
        return basicSetEntry((MBehavior)otherEnd, msgs);
      case GcorePackage.MSTATE__EXIT:
        if (exit != null)
          msgs = ((InternalEObject)exit).eInverseRemove(this, GcorePackage.MBEHAVIOR__EXIT, MBehavior.class, msgs);
        return basicSetExit((MBehavior)otherEnd, msgs);
      case GcorePackage.MSTATE__DO:
        if (do_ != null)
          msgs = ((InternalEObject)do_).eInverseRemove(this, GcorePackage.MBEHAVIOR__DO, MBehavior.class, msgs);
        return basicSetDo((MBehavior)otherEnd, msgs);
      case GcorePackage.MSTATE__SUPERSTATE:
        if (superstate != null)
          msgs = ((InternalEObject)superstate).eInverseRemove(this, GcorePackage.MCOMPOSITE_STATE__SUBSTATE, MCompositeState.class, msgs);
        return basicSetSuperstate((MCompositeState)otherEnd, msgs);
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
      case GcorePackage.MSTATE__OWNER:
        return eBasicSetContainer(null, GcorePackage.MSTATE__OWNER, msgs);
      case GcorePackage.MSTATE__OUTGOING:
        return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
      case GcorePackage.MSTATE__INCOMING:
        return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
      case GcorePackage.MSTATE__ENTRY:
        return basicSetEntry(null, msgs);
      case GcorePackage.MSTATE__EXIT:
        return basicSetExit(null, msgs);
      case GcorePackage.MSTATE__DO:
        return basicSetDo(null, msgs);
      case GcorePackage.MSTATE__SUPERSTATE:
        return basicSetSuperstate(null, msgs);
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
      case GcorePackage.MSTATE__OWNER:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MSTATE_MACHINE__SMSTATE, MStateMachine.class, msgs);
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
      case GcorePackage.MSTATE__OWNER:
        return getOwner();
      case GcorePackage.MSTATE__OUTGOING:
        return getOutgoing();
      case GcorePackage.MSTATE__INCOMING:
        return getIncoming();
      case GcorePackage.MSTATE__ENTRY:
        if (resolve) return getEntry();
        return basicGetEntry();
      case GcorePackage.MSTATE__EXIT:
        if (resolve) return getExit();
        return basicGetExit();
      case GcorePackage.MSTATE__DO:
        if (resolve) return getDo();
        return basicGetDo();
      case GcorePackage.MSTATE__SUPERSTATE:
        if (resolve) return getSuperstate();
        return basicGetSuperstate();
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
      case GcorePackage.MSTATE__OUTGOING:
        getOutgoing().clear();
        getOutgoing().addAll((Collection<? extends MTransition>)newValue);
        return;
      case GcorePackage.MSTATE__INCOMING:
        getIncoming().clear();
        getIncoming().addAll((Collection<? extends MTransition>)newValue);
        return;
      case GcorePackage.MSTATE__ENTRY:
        setEntry((MBehavior)newValue);
        return;
      case GcorePackage.MSTATE__EXIT:
        setExit((MBehavior)newValue);
        return;
      case GcorePackage.MSTATE__DO:
        setDo((MBehavior)newValue);
        return;
      case GcorePackage.MSTATE__SUPERSTATE:
        setSuperstate((MCompositeState)newValue);
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
      case GcorePackage.MSTATE__OUTGOING:
        getOutgoing().clear();
        return;
      case GcorePackage.MSTATE__INCOMING:
        getIncoming().clear();
        return;
      case GcorePackage.MSTATE__ENTRY:
        setEntry((MBehavior)null);
        return;
      case GcorePackage.MSTATE__EXIT:
        setExit((MBehavior)null);
        return;
      case GcorePackage.MSTATE__DO:
        setDo((MBehavior)null);
        return;
      case GcorePackage.MSTATE__SUPERSTATE:
        setSuperstate((MCompositeState)null);
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
      case GcorePackage.MSTATE__OWNER:
        return getOwner() != null;
      case GcorePackage.MSTATE__OUTGOING:
        return outgoing != null && !outgoing.isEmpty();
      case GcorePackage.MSTATE__INCOMING:
        return incoming != null && !incoming.isEmpty();
      case GcorePackage.MSTATE__ENTRY:
        return entry != null;
      case GcorePackage.MSTATE__EXIT:
        return exit != null;
      case GcorePackage.MSTATE__DO:
        return do_ != null;
      case GcorePackage.MSTATE__SUPERSTATE:
        return superstate != null;
    }
    return super.eIsSet(featureID);
  }

} //MStateImpl
