/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.greq.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;
import org.genesez.metamodel.greq.RScenarioStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RRequirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getRationale <em>Rationale</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getSupportedScenario <em>Supported Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getChild <em>Child</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getDeriving <em>Deriving</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getDerived <em>Derived</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getRefining <em>Refining</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RRequirementImpl#getSupportedScenarioStep <em>Supported Scenario Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RRequirementImpl extends RSpecObjectImpl implements RRequirement
{
  /**
   * The default value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected static final String RATIONALE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRationale() <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRationale()
   * @generated
   * @ordered
   */
  protected String rationale = RATIONALE_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getPrecedence() <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecedence()
   * @generated
   * @ordered
   */
  protected static final String PRECEDENCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrecedence() <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrecedence()
   * @generated
   * @ordered
   */
  protected String precedence = PRECEDENCE_EDEFAULT;

  /**
   * The default value of the '{@link #getVerificationMethod() <em>Verification Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationMethod()
   * @generated
   * @ordered
   */
  protected static final String VERIFICATION_METHOD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVerificationMethod() <em>Verification Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerificationMethod()
   * @generated
   * @ordered
   */
  protected String verificationMethod = VERIFICATION_METHOD_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupportedScenario() <em>Supported Scenario</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedScenario()
   * @generated
   * @ordered
   */
  protected EList<RScenario> supportedScenario;

  /**
   * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParent()
   * @generated
   * @ordered
   */
  protected RRequirement parent;

  /**
   * The cached value of the '{@link #getChild() <em>Child</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected EList<RRequirement> child;

  /**
   * The cached value of the '{@link #getDeriving() <em>Deriving</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeriving()
   * @generated
   * @ordered
   */
  protected RRequirement deriving;

  /**
   * The cached value of the '{@link #getDerived() <em>Derived</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDerived()
   * @generated
   * @ordered
   */
  protected EList<RRequirement> derived;

  /**
   * The cached value of the '{@link #getRefining() <em>Refining</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefining()
   * @generated
   * @ordered
   */
  protected RRequirement refining;

  /**
   * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefined()
   * @generated
   * @ordered
   */
  protected EList<RRequirement> refined;

  /**
   * The cached value of the '{@link #getSupportedScenarioStep() <em>Supported Scenario Step</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedScenarioStep()
   * @generated
   * @ordered
   */
  protected EList<RScenarioStep> supportedScenarioStep;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RRequirementImpl()
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
    return GreqPackage.Literals.RREQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRationale()
  {
    return rationale;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRationale(String newRationale)
  {
    String oldRationale = rationale;
    rationale = newRationale;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__RATIONALE, oldRationale, rationale));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPrecedence()
  {
    return precedence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrecedence(String newPrecedence)
  {
    String oldPrecedence = precedence;
    precedence = newPrecedence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__PRECEDENCE, oldPrecedence, precedence));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVerificationMethod()
  {
    return verificationMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerificationMethod(String newVerificationMethod)
  {
    String oldVerificationMethod = verificationMethod;
    verificationMethod = newVerificationMethod;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__VERIFICATION_METHOD, oldVerificationMethod, verificationMethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RModel getModel()
  {
    if (eContainerFeatureID() != GreqPackage.RREQUIREMENT__MODEL) return null;
    return (RModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RScenario> getSupportedScenario()
  {
    if (supportedScenario == null)
    {
      supportedScenario = new EObjectWithInverseResolvingEList.ManyInverse<RScenario>(RScenario.class, this, GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO, GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT);
    }
    return supportedScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement getParent()
  {
    if (parent != null && parent.eIsProxy())
    {
      InternalEObject oldParent = (InternalEObject)parent;
      parent = (RRequirement)eResolveProxy(oldParent);
      if (parent != oldParent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GreqPackage.RREQUIREMENT__PARENT, oldParent, parent));
      }
    }
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement basicGetParent()
  {
    return parent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(RRequirement newParent, NotificationChain msgs)
  {
    RRequirement oldParent = parent;
    parent = newParent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__PARENT, oldParent, newParent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(RRequirement newParent)
  {
    if (newParent != parent)
    {
      NotificationChain msgs = null;
      if (parent != null)
        msgs = ((InternalEObject)parent).eInverseRemove(this, GreqPackage.RREQUIREMENT__CHILD, RRequirement.class, msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, GreqPackage.RREQUIREMENT__CHILD, RRequirement.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RRequirement> getChild()
  {
    if (child == null)
    {
      child = new EObjectWithInverseResolvingEList<RRequirement>(RRequirement.class, this, GreqPackage.RREQUIREMENT__CHILD, GreqPackage.RREQUIREMENT__PARENT);
    }
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement getDeriving()
  {
    if (deriving != null && deriving.eIsProxy())
    {
      InternalEObject oldDeriving = (InternalEObject)deriving;
      deriving = (RRequirement)eResolveProxy(oldDeriving);
      if (deriving != oldDeriving)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GreqPackage.RREQUIREMENT__DERIVING, oldDeriving, deriving));
      }
    }
    return deriving;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement basicGetDeriving()
  {
    return deriving;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeriving(RRequirement newDeriving, NotificationChain msgs)
  {
    RRequirement oldDeriving = deriving;
    deriving = newDeriving;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__DERIVING, oldDeriving, newDeriving);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeriving(RRequirement newDeriving)
  {
    if (newDeriving != deriving)
    {
      NotificationChain msgs = null;
      if (deriving != null)
        msgs = ((InternalEObject)deriving).eInverseRemove(this, GreqPackage.RREQUIREMENT__DERIVED, RRequirement.class, msgs);
      if (newDeriving != null)
        msgs = ((InternalEObject)newDeriving).eInverseAdd(this, GreqPackage.RREQUIREMENT__DERIVED, RRequirement.class, msgs);
      msgs = basicSetDeriving(newDeriving, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__DERIVING, newDeriving, newDeriving));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RRequirement> getDerived()
  {
    if (derived == null)
    {
      derived = new EObjectWithInverseResolvingEList<RRequirement>(RRequirement.class, this, GreqPackage.RREQUIREMENT__DERIVED, GreqPackage.RREQUIREMENT__DERIVING);
    }
    return derived;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement getRefining()
  {
    if (refining != null && refining.eIsProxy())
    {
      InternalEObject oldRefining = (InternalEObject)refining;
      refining = (RRequirement)eResolveProxy(oldRefining);
      if (refining != oldRefining)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GreqPackage.RREQUIREMENT__REFINING, oldRefining, refining));
      }
    }
    return refining;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement basicGetRefining()
  {
    return refining;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRefining(RRequirement newRefining, NotificationChain msgs)
  {
    RRequirement oldRefining = refining;
    refining = newRefining;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__REFINING, oldRefining, newRefining);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefining(RRequirement newRefining)
  {
    if (newRefining != refining)
    {
      NotificationChain msgs = null;
      if (refining != null)
        msgs = ((InternalEObject)refining).eInverseRemove(this, GreqPackage.RREQUIREMENT__REFINED, RRequirement.class, msgs);
      if (newRefining != null)
        msgs = ((InternalEObject)newRefining).eInverseAdd(this, GreqPackage.RREQUIREMENT__REFINED, RRequirement.class, msgs);
      msgs = basicSetRefining(newRefining, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RREQUIREMENT__REFINING, newRefining, newRefining));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RRequirement> getRefined()
  {
    if (refined == null)
    {
      refined = new EObjectWithInverseResolvingEList<RRequirement>(RRequirement.class, this, GreqPackage.RREQUIREMENT__REFINED, GreqPackage.RREQUIREMENT__REFINING);
    }
    return refined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RScenarioStep> getSupportedScenarioStep()
  {
    if (supportedScenarioStep == null)
    {
      supportedScenarioStep = new EObjectWithInverseResolvingEList.ManyInverse<RScenarioStep>(RScenarioStep.class, this, GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP, GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT);
    }
    return supportedScenarioStep;
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
      case GreqPackage.RREQUIREMENT__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GreqPackage.RREQUIREMENT__MODEL, msgs);
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedScenario()).basicAdd(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__PARENT:
        if (parent != null)
          msgs = ((InternalEObject)parent).eInverseRemove(this, GreqPackage.RREQUIREMENT__CHILD, RRequirement.class, msgs);
        return basicSetParent((RRequirement)otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__CHILD:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getChild()).basicAdd(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__DERIVING:
        if (deriving != null)
          msgs = ((InternalEObject)deriving).eInverseRemove(this, GreqPackage.RREQUIREMENT__DERIVED, RRequirement.class, msgs);
        return basicSetDeriving((RRequirement)otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__DERIVED:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDerived()).basicAdd(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__REFINING:
        if (refining != null)
          msgs = ((InternalEObject)refining).eInverseRemove(this, GreqPackage.RREQUIREMENT__REFINED, RRequirement.class, msgs);
        return basicSetRefining((RRequirement)otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__REFINED:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefined()).basicAdd(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedScenarioStep()).basicAdd(otherEnd, msgs);
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
      case GreqPackage.RREQUIREMENT__MODEL:
        return eBasicSetContainer(null, GreqPackage.RREQUIREMENT__MODEL, msgs);
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        return ((InternalEList<?>)getSupportedScenario()).basicRemove(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__PARENT:
        return basicSetParent(null, msgs);
      case GreqPackage.RREQUIREMENT__CHILD:
        return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__DERIVING:
        return basicSetDeriving(null, msgs);
      case GreqPackage.RREQUIREMENT__DERIVED:
        return ((InternalEList<?>)getDerived()).basicRemove(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__REFINING:
        return basicSetRefining(null, msgs);
      case GreqPackage.RREQUIREMENT__REFINED:
        return ((InternalEList<?>)getRefined()).basicRemove(otherEnd, msgs);
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        return ((InternalEList<?>)getSupportedScenarioStep()).basicRemove(otherEnd, msgs);
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
      case GreqPackage.RREQUIREMENT__MODEL:
        return eInternalContainer().eInverseRemove(this, GreqPackage.RMODEL__REQUIREMENT, RModel.class, msgs);
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
      case GreqPackage.RREQUIREMENT__RATIONALE:
        return getRationale();
      case GreqPackage.RREQUIREMENT__TYPE:
        return getType();
      case GreqPackage.RREQUIREMENT__PRECEDENCE:
        return getPrecedence();
      case GreqPackage.RREQUIREMENT__VERIFICATION_METHOD:
        return getVerificationMethod();
      case GreqPackage.RREQUIREMENT__MODEL:
        return getModel();
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        return getSupportedScenario();
      case GreqPackage.RREQUIREMENT__PARENT:
        if (resolve) return getParent();
        return basicGetParent();
      case GreqPackage.RREQUIREMENT__CHILD:
        return getChild();
      case GreqPackage.RREQUIREMENT__DERIVING:
        if (resolve) return getDeriving();
        return basicGetDeriving();
      case GreqPackage.RREQUIREMENT__DERIVED:
        return getDerived();
      case GreqPackage.RREQUIREMENT__REFINING:
        if (resolve) return getRefining();
        return basicGetRefining();
      case GreqPackage.RREQUIREMENT__REFINED:
        return getRefined();
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        return getSupportedScenarioStep();
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
      case GreqPackage.RREQUIREMENT__RATIONALE:
        setRationale((String)newValue);
        return;
      case GreqPackage.RREQUIREMENT__TYPE:
        setType((String)newValue);
        return;
      case GreqPackage.RREQUIREMENT__PRECEDENCE:
        setPrecedence((String)newValue);
        return;
      case GreqPackage.RREQUIREMENT__VERIFICATION_METHOD:
        setVerificationMethod((String)newValue);
        return;
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        getSupportedScenario().clear();
        getSupportedScenario().addAll((Collection<? extends RScenario>)newValue);
        return;
      case GreqPackage.RREQUIREMENT__PARENT:
        setParent((RRequirement)newValue);
        return;
      case GreqPackage.RREQUIREMENT__CHILD:
        getChild().clear();
        getChild().addAll((Collection<? extends RRequirement>)newValue);
        return;
      case GreqPackage.RREQUIREMENT__DERIVING:
        setDeriving((RRequirement)newValue);
        return;
      case GreqPackage.RREQUIREMENT__DERIVED:
        getDerived().clear();
        getDerived().addAll((Collection<? extends RRequirement>)newValue);
        return;
      case GreqPackage.RREQUIREMENT__REFINING:
        setRefining((RRequirement)newValue);
        return;
      case GreqPackage.RREQUIREMENT__REFINED:
        getRefined().clear();
        getRefined().addAll((Collection<? extends RRequirement>)newValue);
        return;
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        getSupportedScenarioStep().clear();
        getSupportedScenarioStep().addAll((Collection<? extends RScenarioStep>)newValue);
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
      case GreqPackage.RREQUIREMENT__RATIONALE:
        setRationale(RATIONALE_EDEFAULT);
        return;
      case GreqPackage.RREQUIREMENT__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case GreqPackage.RREQUIREMENT__PRECEDENCE:
        setPrecedence(PRECEDENCE_EDEFAULT);
        return;
      case GreqPackage.RREQUIREMENT__VERIFICATION_METHOD:
        setVerificationMethod(VERIFICATION_METHOD_EDEFAULT);
        return;
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        getSupportedScenario().clear();
        return;
      case GreqPackage.RREQUIREMENT__PARENT:
        setParent((RRequirement)null);
        return;
      case GreqPackage.RREQUIREMENT__CHILD:
        getChild().clear();
        return;
      case GreqPackage.RREQUIREMENT__DERIVING:
        setDeriving((RRequirement)null);
        return;
      case GreqPackage.RREQUIREMENT__DERIVED:
        getDerived().clear();
        return;
      case GreqPackage.RREQUIREMENT__REFINING:
        setRefining((RRequirement)null);
        return;
      case GreqPackage.RREQUIREMENT__REFINED:
        getRefined().clear();
        return;
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        getSupportedScenarioStep().clear();
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
      case GreqPackage.RREQUIREMENT__RATIONALE:
        return RATIONALE_EDEFAULT == null ? rationale != null : !RATIONALE_EDEFAULT.equals(rationale);
      case GreqPackage.RREQUIREMENT__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case GreqPackage.RREQUIREMENT__PRECEDENCE:
        return PRECEDENCE_EDEFAULT == null ? precedence != null : !PRECEDENCE_EDEFAULT.equals(precedence);
      case GreqPackage.RREQUIREMENT__VERIFICATION_METHOD:
        return VERIFICATION_METHOD_EDEFAULT == null ? verificationMethod != null : !VERIFICATION_METHOD_EDEFAULT.equals(verificationMethod);
      case GreqPackage.RREQUIREMENT__MODEL:
        return getModel() != null;
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO:
        return supportedScenario != null && !supportedScenario.isEmpty();
      case GreqPackage.RREQUIREMENT__PARENT:
        return parent != null;
      case GreqPackage.RREQUIREMENT__CHILD:
        return child != null && !child.isEmpty();
      case GreqPackage.RREQUIREMENT__DERIVING:
        return deriving != null;
      case GreqPackage.RREQUIREMENT__DERIVED:
        return derived != null && !derived.isEmpty();
      case GreqPackage.RREQUIREMENT__REFINING:
        return refining != null;
      case GreqPackage.RREQUIREMENT__REFINED:
        return refined != null && !refined.isEmpty();
      case GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP:
        return supportedScenarioStep != null && !supportedScenarioStep.isEmpty();
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
    result.append(" (rationale: ");
    result.append(rationale);
    result.append(", type: ");
    result.append(type);
    result.append(", precedence: ");
    result.append(precedence);
    result.append(", verificationMethod: ");
    result.append(verificationMethod);
    result.append(')');
    return result.toString();
  }

} //RRequirementImpl
