/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PAbstractArea;
import org.genesez.metamodel.gpresentation.PContentArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAbstract Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PAbstractAreaImpl#getNestedContents <em>Nested Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PAbstractAreaImpl extends PMetaDataAwareImpl implements PAbstractArea
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
   * The cached value of the '{@link #getNestedContents() <em>Nested Contents</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedContents()
   * @generated
   * @ordered
   */
  protected EList<PContentArea> nestedContents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PAbstractAreaImpl()
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
    return GpresentationPackage.Literals.PABSTRACT_AREA;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PABSTRACT_AREA__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PContentArea> getNestedContents()
  {
    if (nestedContents == null)
    {
      nestedContents = new EObjectContainmentWithInverseEList<PContentArea>(PContentArea.class, this, GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS, GpresentationPackage.PCONTENT_AREA__OWNING_AREA);
    }
    return nestedContents;
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
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedContents()).basicAdd(otherEnd, msgs);
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
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        return ((InternalEList<?>)getNestedContents()).basicRemove(otherEnd, msgs);
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
      case GpresentationPackage.PABSTRACT_AREA__NAME:
        return getName();
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        return getNestedContents();
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
      case GpresentationPackage.PABSTRACT_AREA__NAME:
        setName((String)newValue);
        return;
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        getNestedContents().clear();
        getNestedContents().addAll((Collection<? extends PContentArea>)newValue);
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
      case GpresentationPackage.PABSTRACT_AREA__NAME:
        setName(NAME_EDEFAULT);
        return;
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        getNestedContents().clear();
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
      case GpresentationPackage.PABSTRACT_AREA__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS:
        return nestedContents != null && !nestedContents.isEmpty();
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

} //PAbstractAreaImpl
