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
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RAnnotation;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RTag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RAnnotationImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RAnnotationImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RAnnotationImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RAnnotationImpl extends RObjectImpl implements RAnnotation
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
   * The cached value of the '{@link #getTag() <em>Tag</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTag()
   * @generated
   * @ordered
   */
  protected EList<RTag> tag;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RAnnotationImpl()
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
    return GreqPackage.Literals.RANNOTATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RANNOTATION__URI, oldUri, uri));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RTag> getTag()
  {
    if (tag == null)
    {
      tag = new EObjectContainmentWithInverseEList<RTag>(RTag.class, this, GreqPackage.RANNOTATION__TAG, GreqPackage.RTAG__ANNOTATION);
    }
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RModel getModel()
  {
    if (eContainerFeatureID() != GreqPackage.RANNOTATION__MODEL) return null;
    return (RModel)eContainer();
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
      case GreqPackage.RANNOTATION__TAG:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTag()).basicAdd(otherEnd, msgs);
      case GreqPackage.RANNOTATION__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GreqPackage.RANNOTATION__MODEL, msgs);
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
      case GreqPackage.RANNOTATION__TAG:
        return ((InternalEList<?>)getTag()).basicRemove(otherEnd, msgs);
      case GreqPackage.RANNOTATION__MODEL:
        return eBasicSetContainer(null, GreqPackage.RANNOTATION__MODEL, msgs);
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
      case GreqPackage.RANNOTATION__MODEL:
        return eInternalContainer().eInverseRemove(this, GreqPackage.RMODEL__EXTENSION, RModel.class, msgs);
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
      case GreqPackage.RANNOTATION__URI:
        return getUri();
      case GreqPackage.RANNOTATION__TAG:
        return getTag();
      case GreqPackage.RANNOTATION__MODEL:
        return getModel();
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
      case GreqPackage.RANNOTATION__URI:
        setUri((String)newValue);
        return;
      case GreqPackage.RANNOTATION__TAG:
        getTag().clear();
        getTag().addAll((Collection<? extends RTag>)newValue);
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
      case GreqPackage.RANNOTATION__URI:
        setUri(URI_EDEFAULT);
        return;
      case GreqPackage.RANNOTATION__TAG:
        getTag().clear();
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
      case GreqPackage.RANNOTATION__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
      case GreqPackage.RANNOTATION__TAG:
        return tag != null && !tag.isEmpty();
      case GreqPackage.RANNOTATION__MODEL:
        return getModel() != null;
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

} //RAnnotationImpl
