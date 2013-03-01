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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PMetaData;
import org.genesez.metamodel.gpresentation.PPackage;
import org.genesez.metamodel.gpresentation.PRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PPackage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getRoots <em>Roots</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getNestedPackages <em>Nested Packages</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PPackageImpl#getMetaData <em>Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PPackageImpl extends EObjectImpl implements PPackage
{
  /**
	 * The default value of the '{@link #getXmiGuid() <em>Xmi Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String XMI_GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmiGuid() <em>Xmi Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiGuid()
	 * @generated
	 * @ordered
	 */
	protected String xmiGuid = XMI_GUID_EDEFAULT;

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
	 * The cached value of the '{@link #getRoots() <em>Roots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRoots()
	 * @generated
	 * @ordered
	 */
  protected EList<PRoot> roots;

  /**
	 * The cached value of the '{@link #getNestedPackages() <em>Nested Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNestedPackages()
	 * @generated
	 * @ordered
	 */
  protected EList<PPackage> nestedPackages;

  /**
	 * The cached value of the '{@link #getMetaData() <em>Meta Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMetaData()
	 * @generated
	 * @ordered
	 */
  protected EList<PMetaData> metaData;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PPackageImpl()
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
		return GpresentationPackage.Literals.PPACKAGE;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmiGuid() {
		return xmiGuid;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmiGuid(String newXmiGuid) {
		String oldXmiGuid = xmiGuid;
		xmiGuid = newXmiGuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PPACKAGE__XMI_GUID, oldXmiGuid, xmiGuid));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PPACKAGE__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PRoot> getRoots()
  {
		if (roots == null) {
			roots = new EObjectContainmentWithInverseEList<PRoot>(PRoot.class, this, GpresentationPackage.PPACKAGE__ROOTS, GpresentationPackage.PROOT__OWNING_PACKAGE);
		}
		return roots;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PPackage getOwningPackage()
  {
		if (eContainerFeatureID() != GpresentationPackage.PPACKAGE__OWNING_PACKAGE) return null;
		return (PPackage)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PPackage> getNestedPackages()
  {
		if (nestedPackages == null) {
			nestedPackages = new EObjectContainmentWithInverseEList<PPackage>(PPackage.class, this, GpresentationPackage.PPACKAGE__NESTED_PACKAGES, GpresentationPackage.PPACKAGE__OWNING_PACKAGE);
		}
		return nestedPackages;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PMetaData> getMetaData()
  {
		if (metaData == null) {
			metaData = new EObjectContainmentWithInverseEList<PMetaData>(PMetaData.class, this, GpresentationPackage.PPACKAGE__META_DATA, GpresentationPackage.PMETA_DATA__CONTAINER);
		}
		return metaData;
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__ROOTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRoots()).basicAdd(otherEnd, msgs);
			case GpresentationPackage.PPACKAGE__OWNING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GpresentationPackage.PPACKAGE__OWNING_PACKAGE, msgs);
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackages()).basicAdd(otherEnd, msgs);
			case GpresentationPackage.PPACKAGE__META_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMetaData()).basicAdd(otherEnd, msgs);
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__ROOTS:
				return ((InternalEList<?>)getRoots()).basicRemove(otherEnd, msgs);
			case GpresentationPackage.PPACKAGE__OWNING_PACKAGE:
				return eBasicSetContainer(null, GpresentationPackage.PPACKAGE__OWNING_PACKAGE, msgs);
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				return ((InternalEList<?>)getNestedPackages()).basicRemove(otherEnd, msgs);
			case GpresentationPackage.PPACKAGE__META_DATA:
				return ((InternalEList<?>)getMetaData()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
			case GpresentationPackage.PPACKAGE__OWNING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, GpresentationPackage.PPACKAGE__NESTED_PACKAGES, PPackage.class, msgs);
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__XMI_GUID:
				return getXmiGuid();
			case GpresentationPackage.PPACKAGE__NAME:
				return getName();
			case GpresentationPackage.PPACKAGE__ROOTS:
				return getRoots();
			case GpresentationPackage.PPACKAGE__OWNING_PACKAGE:
				return getOwningPackage();
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				return getNestedPackages();
			case GpresentationPackage.PPACKAGE__META_DATA:
				return getMetaData();
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__XMI_GUID:
				setXmiGuid((String)newValue);
				return;
			case GpresentationPackage.PPACKAGE__NAME:
				setName((String)newValue);
				return;
			case GpresentationPackage.PPACKAGE__ROOTS:
				getRoots().clear();
				getRoots().addAll((Collection<? extends PRoot>)newValue);
				return;
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				getNestedPackages().clear();
				getNestedPackages().addAll((Collection<? extends PPackage>)newValue);
				return;
			case GpresentationPackage.PPACKAGE__META_DATA:
				getMetaData().clear();
				getMetaData().addAll((Collection<? extends PMetaData>)newValue);
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__XMI_GUID:
				setXmiGuid(XMI_GUID_EDEFAULT);
				return;
			case GpresentationPackage.PPACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GpresentationPackage.PPACKAGE__ROOTS:
				getRoots().clear();
				return;
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				getNestedPackages().clear();
				return;
			case GpresentationPackage.PPACKAGE__META_DATA:
				getMetaData().clear();
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
		switch (featureID) {
			case GpresentationPackage.PPACKAGE__XMI_GUID:
				return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
			case GpresentationPackage.PPACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GpresentationPackage.PPACKAGE__ROOTS:
				return roots != null && !roots.isEmpty();
			case GpresentationPackage.PPACKAGE__OWNING_PACKAGE:
				return getOwningPackage() != null;
			case GpresentationPackage.PPACKAGE__NESTED_PACKAGES:
				return nestedPackages != null && !nestedPackages.isEmpty();
			case GpresentationPackage.PPACKAGE__META_DATA:
				return metaData != null && !metaData.isEmpty();
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
		result.append(" (xmiGuid: ");
		result.append(xmiGuid);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PPackageImpl
