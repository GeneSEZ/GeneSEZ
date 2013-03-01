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
import org.genesez.metamodel.gpresentation.PKey;
import org.genesez.metamodel.gpresentation.PMetaData;
import org.genesez.metamodel.gpresentation.PPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PMeta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PMetaDataImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PMetaDataImpl extends EObjectImpl implements PMetaData
{
  /**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
  protected static final String URI_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
  protected String uri = URI_EDEFAULT;

  /**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
  protected EList<PKey> key;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PMetaDataImpl()
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
		return GpresentationPackage.Literals.PMETA_DATA;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getUri()
  {
		return uri;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUri(String newUri)
  {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GpresentationPackage.PMETA_DATA__URI, oldUri, uri));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PKey> getKey()
  {
		if (key == null) {
			key = new EObjectContainmentWithInverseEList<PKey>(PKey.class, this, GpresentationPackage.PMETA_DATA__KEY, GpresentationPackage.PKEY__OWNER);
		}
		return key;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PPackage getContainer()
  {
		if (eContainerFeatureID() != GpresentationPackage.PMETA_DATA__CONTAINER) return null;
		return (PPackage)eContainer();
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
			case GpresentationPackage.PMETA_DATA__KEY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getKey()).basicAdd(otherEnd, msgs);
			case GpresentationPackage.PMETA_DATA__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GpresentationPackage.PMETA_DATA__CONTAINER, msgs);
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
			case GpresentationPackage.PMETA_DATA__KEY:
				return ((InternalEList<?>)getKey()).basicRemove(otherEnd, msgs);
			case GpresentationPackage.PMETA_DATA__CONTAINER:
				return eBasicSetContainer(null, GpresentationPackage.PMETA_DATA__CONTAINER, msgs);
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
			case GpresentationPackage.PMETA_DATA__CONTAINER:
				return eInternalContainer().eInverseRemove(this, GpresentationPackage.PPACKAGE__META_DATA, PPackage.class, msgs);
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
			case GpresentationPackage.PMETA_DATA__URI:
				return getUri();
			case GpresentationPackage.PMETA_DATA__KEY:
				return getKey();
			case GpresentationPackage.PMETA_DATA__CONTAINER:
				return getContainer();
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
			case GpresentationPackage.PMETA_DATA__URI:
				setUri((String)newValue);
				return;
			case GpresentationPackage.PMETA_DATA__KEY:
				getKey().clear();
				getKey().addAll((Collection<? extends PKey>)newValue);
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
			case GpresentationPackage.PMETA_DATA__URI:
				setUri(URI_EDEFAULT);
				return;
			case GpresentationPackage.PMETA_DATA__KEY:
				getKey().clear();
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
			case GpresentationPackage.PMETA_DATA__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case GpresentationPackage.PMETA_DATA__KEY:
				return key != null && !key.isEmpty();
			case GpresentationPackage.PMETA_DATA__CONTAINER:
				return getContainer() != null;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //PMetaDataImpl
