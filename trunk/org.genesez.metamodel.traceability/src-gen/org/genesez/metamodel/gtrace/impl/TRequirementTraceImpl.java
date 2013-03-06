/**
 */
package org.genesez.metamodel.gtrace.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.genesez.metamodel.gcore.MElement;

import org.genesez.metamodel.greq.RRequirement;

import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.TRequirementTrace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TRequirement Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.genesez.metamodel.gtrace.impl.TRequirementTraceImpl#getStructuralElement <em>Structural Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TRequirementTraceImpl extends TTraceImpl implements TRequirementTrace
{
  /**
   * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirement()
   * @generated
   * @ordered
   */
  protected RRequirement requirement;

  /**
   * The cached value of the '{@link #getStructuralElement() <em>Structural Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStructuralElement()
   * @generated
   * @ordered
   */
  protected MElement structuralElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TRequirementTraceImpl()
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
    return GtracePackage.Literals.TREQUIREMENT_TRACE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement getRequirement()
  {
    if (requirement != null && requirement.eIsProxy())
    {
      InternalEObject oldRequirement = (InternalEObject)requirement;
      requirement = (RRequirement)eResolveProxy(oldRequirement);
      if (requirement != oldRequirement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT, oldRequirement, requirement));
      }
    }
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RRequirement basicGetRequirement()
  {
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirement(RRequirement newRequirement)
  {
    RRequirement oldRequirement = requirement;
    requirement = newRequirement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT, oldRequirement, requirement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getStructuralElement()
  {
    if (structuralElement != null && structuralElement.eIsProxy())
    {
      InternalEObject oldStructuralElement = (InternalEObject)structuralElement;
      structuralElement = (MElement)eResolveProxy(oldStructuralElement);
      if (structuralElement != oldStructuralElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT, oldStructuralElement, structuralElement));
      }
    }
    return structuralElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement basicGetStructuralElement()
  {
    return structuralElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStructuralElement(MElement newStructuralElement)
  {
    MElement oldStructuralElement = structuralElement;
    structuralElement = newStructuralElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT, oldStructuralElement, structuralElement));
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
      case GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT:
        if (resolve) return getRequirement();
        return basicGetRequirement();
      case GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT:
        if (resolve) return getStructuralElement();
        return basicGetStructuralElement();
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
      case GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT:
        setRequirement((RRequirement)newValue);
        return;
      case GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT:
        setStructuralElement((MElement)newValue);
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
      case GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT:
        setRequirement((RRequirement)null);
        return;
      case GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT:
        setStructuralElement((MElement)null);
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
      case GtracePackage.TREQUIREMENT_TRACE__REQUIREMENT:
        return requirement != null;
      case GtracePackage.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT:
        return structuralElement != null;
    }
    return super.eIsSet(featureID);
  }

} //TRequirementTraceImpl
