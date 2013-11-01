/**
 */
package org.genesez.metamodel.greq.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;
import org.genesez.metamodel.greq.RScenarioStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RScenario Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioStepImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RScenarioStepImpl#getSupportedRequirement <em>Supported Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RScenarioStepImpl extends RSpecObjectImpl implements RScenarioStep
{
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
  protected RScenarioStepImpl()
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
    return GreqPackage.Literals.RSCENARIO_STEP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RScenario getScenario()
  {
    if (eContainerFeatureID() != GreqPackage.RSCENARIO_STEP__SCENARIO) return null;
    return (RScenario)eContainer();
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
      supportedRequirement = new EObjectWithInverseResolvingEList.ManyInverse<RRequirement>(RRequirement.class, this, GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT, GreqPackage.RREQUIREMENT__SUPPORTED_SCENARIO_STEP);
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
      case GreqPackage.RSCENARIO_STEP__SCENARIO:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GreqPackage.RSCENARIO_STEP__SCENARIO, msgs);
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
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
      case GreqPackage.RSCENARIO_STEP__SCENARIO:
        return eBasicSetContainer(null, GreqPackage.RSCENARIO_STEP__SCENARIO, msgs);
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
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
      case GreqPackage.RSCENARIO_STEP__SCENARIO:
        return eInternalContainer().eInverseRemove(this, GreqPackage.RSCENARIO__STEP, RScenario.class, msgs);
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
      case GreqPackage.RSCENARIO_STEP__SCENARIO:
        return getScenario();
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
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
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
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
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
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
      case GreqPackage.RSCENARIO_STEP__SCENARIO:
        return getScenario() != null;
      case GreqPackage.RSCENARIO_STEP__SUPPORTED_REQUIREMENT:
        return supportedRequirement != null && !supportedRequirement.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RScenarioStepImpl
