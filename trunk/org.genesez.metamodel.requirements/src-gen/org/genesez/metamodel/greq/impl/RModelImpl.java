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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RAnnotation;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RModel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RModelImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RModelImpl#getScenario <em>Scenario</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RModelImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RModelImpl extends RObjectImpl implements RModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirement()
   * @generated
   * @ordered
   */
  protected EList<RRequirement> requirement;

  /**
   * The cached value of the '{@link #getScenario() <em>Scenario</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenario()
   * @generated
   * @ordered
   */
  protected EList<RScenario> scenario;

  /**
   * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtension()
   * @generated
   * @ordered
   */
  protected EList<RAnnotation> extension;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RModelImpl()
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
    return GreqPackage.Literals.RMODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RMODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RRequirement> getRequirement()
  {
    if (requirement == null)
    {
      requirement = new EObjectContainmentWithInverseEList<RRequirement>(RRequirement.class, this, GreqPackage.RMODEL__REQUIREMENT, GreqPackage.RREQUIREMENT__MODEL);
    }
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RScenario> getScenario()
  {
    if (scenario == null)
    {
      scenario = new EObjectContainmentWithInverseEList<RScenario>(RScenario.class, this, GreqPackage.RMODEL__SCENARIO, GreqPackage.RSCENARIO__MODEL);
    }
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RAnnotation> getExtension()
  {
    if (extension == null)
    {
      extension = new EObjectContainmentWithInverseEList<RAnnotation>(RAnnotation.class, this, GreqPackage.RMODEL__EXTENSION, GreqPackage.RANNOTATION__MODEL);
    }
    return extension;
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
      case GreqPackage.RMODEL__REQUIREMENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequirement()).basicAdd(otherEnd, msgs);
      case GreqPackage.RMODEL__SCENARIO:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getScenario()).basicAdd(otherEnd, msgs);
      case GreqPackage.RMODEL__EXTENSION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtension()).basicAdd(otherEnd, msgs);
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
      case GreqPackage.RMODEL__REQUIREMENT:
        return ((InternalEList<?>)getRequirement()).basicRemove(otherEnd, msgs);
      case GreqPackage.RMODEL__SCENARIO:
        return ((InternalEList<?>)getScenario()).basicRemove(otherEnd, msgs);
      case GreqPackage.RMODEL__EXTENSION:
        return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
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
      case GreqPackage.RMODEL__NAME:
        return getName();
      case GreqPackage.RMODEL__REQUIREMENT:
        return getRequirement();
      case GreqPackage.RMODEL__SCENARIO:
        return getScenario();
      case GreqPackage.RMODEL__EXTENSION:
        return getExtension();
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
      case GreqPackage.RMODEL__NAME:
        setName((String)newValue);
        return;
      case GreqPackage.RMODEL__REQUIREMENT:
        getRequirement().clear();
        getRequirement().addAll((Collection<? extends RRequirement>)newValue);
        return;
      case GreqPackage.RMODEL__SCENARIO:
        getScenario().clear();
        getScenario().addAll((Collection<? extends RScenario>)newValue);
        return;
      case GreqPackage.RMODEL__EXTENSION:
        getExtension().clear();
        getExtension().addAll((Collection<? extends RAnnotation>)newValue);
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
      case GreqPackage.RMODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GreqPackage.RMODEL__REQUIREMENT:
        getRequirement().clear();
        return;
      case GreqPackage.RMODEL__SCENARIO:
        getScenario().clear();
        return;
      case GreqPackage.RMODEL__EXTENSION:
        getExtension().clear();
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
      case GreqPackage.RMODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GreqPackage.RMODEL__REQUIREMENT:
        return requirement != null && !requirement.isEmpty();
      case GreqPackage.RMODEL__SCENARIO:
        return scenario != null && !scenario.isEmpty();
      case GreqPackage.RMODEL__EXTENSION:
        return extension != null && !extension.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RModelImpl
