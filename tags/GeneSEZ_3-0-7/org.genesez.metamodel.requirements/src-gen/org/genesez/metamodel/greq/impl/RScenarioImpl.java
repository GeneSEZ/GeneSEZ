/**
 */
package org.genesez.metamodel.greq.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;
import org.genesez.metamodel.greq.RScenarioStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RScenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioImpl#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioImpl#getVerificationMethod <em>Verification Method</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioImpl#getStep <em>Step</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioImpl#getSupportedRequirement <em>Supported Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RScenarioImpl extends RSpecObjectImpl implements RScenario
{
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
   * The cached value of the '{@link #getStep() <em>Step</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStep()
   * @generated
   * @ordered
   */
  protected EList<RScenarioStep> step;

  /**
   * The cached value of the '{@link #getSupportedRequirement() <em>Supported Requirement</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedRequirement()
   * @generated
   * @ordered
   */
  protected EList<RRequirement> supportedRequirement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RScenarioImpl()
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
    return GreqPackage.Literals.RSCENARIO;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSCENARIO__PRECEDENCE, oldPrecedence, precedence));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSCENARIO__VERIFICATION_METHOD, oldVerificationMethod, verificationMethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RModel getModel()
  {
    if (eContainerFeatureID() != GreqPackage.RSCENARIO__MODEL) return null;
    return (RModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RScenarioStep> getStep()
  {
    if (step == null)
    {
      step = new EObjectContainmentWithInverseEList<RScenarioStep>(RScenarioStep.class, this, GreqPackage.RSCENARIO__STEP, GreqPackage.RSCENARIO_STEP__SCENARIO);
    }
    return step;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RRequirement> getSupportedRequirement()
  {
    if (supportedRequirement == null)
    {
      supportedRequirement = new EObjectWithInverseResolvingEList.ManyInverse<RRequirement>(RRequirement.class, this, GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT, GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO);
    }
    return supportedRequirement;
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
      case GreqPackage.RSCENARIO__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GreqPackage.RSCENARIO__MODEL, msgs);
      case GreqPackage.RSCENARIO__STEP:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStep()).basicAdd(otherEnd, msgs);
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedRequirement()).basicAdd(otherEnd, msgs);
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
      case GreqPackage.RSCENARIO__MODEL:
        return eBasicSetContainer(null, GreqPackage.RSCENARIO__MODEL, msgs);
      case GreqPackage.RSCENARIO__STEP:
        return ((InternalEList<?>)getStep()).basicRemove(otherEnd, msgs);
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        return ((InternalEList<?>)getSupportedRequirement()).basicRemove(otherEnd, msgs);
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
      case GreqPackage.RSCENARIO__MODEL:
        return eInternalContainer().eInverseRemove(this, GreqPackage.RMODEL__SCENARIO, RModel.class, msgs);
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
      case GreqPackage.RSCENARIO__PRECEDENCE:
        return getPrecedence();
      case GreqPackage.RSCENARIO__VERIFICATION_METHOD:
        return getVerificationMethod();
      case GreqPackage.RSCENARIO__MODEL:
        return getModel();
      case GreqPackage.RSCENARIO__STEP:
        return getStep();
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        return getSupportedRequirement();
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
      case GreqPackage.RSCENARIO__PRECEDENCE:
        setPrecedence((String)newValue);
        return;
      case GreqPackage.RSCENARIO__VERIFICATION_METHOD:
        setVerificationMethod((String)newValue);
        return;
      case GreqPackage.RSCENARIO__STEP:
        getStep().clear();
        getStep().addAll((Collection<? extends RScenarioStep>)newValue);
        return;
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        getSupportedRequirement().clear();
        getSupportedRequirement().addAll((Collection<? extends RRequirement>)newValue);
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
      case GreqPackage.RSCENARIO__PRECEDENCE:
        setPrecedence(PRECEDENCE_EDEFAULT);
        return;
      case GreqPackage.RSCENARIO__VERIFICATION_METHOD:
        setVerificationMethod(VERIFICATION_METHOD_EDEFAULT);
        return;
      case GreqPackage.RSCENARIO__STEP:
        getStep().clear();
        return;
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        getSupportedRequirement().clear();
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
      case GreqPackage.RSCENARIO__PRECEDENCE:
        return PRECEDENCE_EDEFAULT == null ? precedence != null : !PRECEDENCE_EDEFAULT.equals(precedence);
      case GreqPackage.RSCENARIO__VERIFICATION_METHOD:
        return VERIFICATION_METHOD_EDEFAULT == null ? verificationMethod != null : !VERIFICATION_METHOD_EDEFAULT.equals(verificationMethod);
      case GreqPackage.RSCENARIO__MODEL:
        return getModel() != null;
      case GreqPackage.RSCENARIO__STEP:
        return step != null && !step.isEmpty();
      case GreqPackage.RSCENARIO__SUPPORTED_REQUIREMENT:
        return supportedRequirement != null && !supportedRequirement.isEmpty();
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
    result.append(" (precedence: ");
    result.append(precedence);
    result.append(", verificationMethod: ");
    result.append(verificationMethod);
    result.append(')');
    return result.toString();
  }

} //RScenarioImpl
