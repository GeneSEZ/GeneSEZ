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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PMetaData;
import org.genesez.metamodel.gpresentation.PMetaDataAware;
import org.genesez.metamodel.gpresentation.PValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PMeta Data Aware</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataAwareImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PMetaDataAwareImpl extends EObjectImpl implements PMetaDataAware {
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
	 * The cached value of the '{@link #getMetaData() <em>Meta Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaData()
	 * @generated
	 * @ordered
	 */
	protected EList<PMetaData> metaData;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<PValue> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PMetaDataAwareImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GpresentationPackage.Literals.PMETA_DATA_AWARE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PMETA_DATA_AWARE__XMI_GUID, oldXmiGuid, xmiGuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PMetaData> getMetaData() {
		if (metaData == null) {
			metaData = new EObjectResolvingEList<PMetaData>(PMetaData.class, this, GpresentationPackage.PMETA_DATA_AWARE__META_DATA);
		}
		return metaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PValue> getValue() {
		if (value == null) {
			value = new EObjectContainmentWithInverseEList<PValue>(PValue.class, this, GpresentationPackage.PMETA_DATA_AWARE__VALUE, GpresentationPackage.PVALUE__OWNER);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValue()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__XMI_GUID:
				return getXmiGuid();
			case GpresentationPackage.PMETA_DATA_AWARE__META_DATA:
				return getMetaData();
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				return getValue();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__XMI_GUID:
				setXmiGuid((String)newValue);
				return;
			case GpresentationPackage.PMETA_DATA_AWARE__META_DATA:
				getMetaData().clear();
				getMetaData().addAll((Collection<? extends PMetaData>)newValue);
				return;
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends PValue>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__XMI_GUID:
				setXmiGuid(XMI_GUID_EDEFAULT);
				return;
			case GpresentationPackage.PMETA_DATA_AWARE__META_DATA:
				getMetaData().clear();
				return;
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				getValue().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GpresentationPackage.PMETA_DATA_AWARE__XMI_GUID:
				return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
			case GpresentationPackage.PMETA_DATA_AWARE__META_DATA:
				return metaData != null && !metaData.isEmpty();
			case GpresentationPackage.PMETA_DATA_AWARE__VALUE:
				return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (xmiGuid: ");
		result.append(xmiGuid);
		result.append(')');
		return result.toString();
	}

} //PMetaDataAwareImpl
