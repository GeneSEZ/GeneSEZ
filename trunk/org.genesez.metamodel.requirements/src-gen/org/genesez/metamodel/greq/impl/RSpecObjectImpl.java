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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.greq.RAnnotation;
import org.genesez.metamodel.greq.RSpecObject;
import org.genesez.metamodel.greq.RValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RSpec Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.impl.RSpecObjectImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RSpecObjectImpl extends RObjectImpl implements RSpecObject
{
  /**
   * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected static final String DEFINITION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected String definition = DEFINITION_EDEFAULT;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected static final String VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected String version = VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected static final String URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected String url = URL_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected EList<RAnnotation> annotation;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EList<RValue> value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RSpecObjectImpl()
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
    return GreqPackage.Literals.RSPEC_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(String newDefinition)
  {
    String oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSPEC_OBJECT__DEFINITION, oldDefinition, definition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSPEC_OBJECT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(String newVersion)
  {
    String oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSPEC_OBJECT__VERSION, oldVersion, version));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUrl()
  {
    return url;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUrl(String newUrl)
  {
    String oldUrl = url;
    url = newUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GreqPackage.RSPEC_OBJECT__URL, oldUrl, url));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RAnnotation> getAnnotation()
  {
    if (annotation == null)
    {
      annotation = new EObjectResolvingEList<RAnnotation>(RAnnotation.class, this, GreqPackage.RSPEC_OBJECT__ANNOTATION);
    }
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RValue> getValue()
  {
    if (value == null)
    {
      value = new EObjectContainmentWithInverseEList<RValue>(RValue.class, this, GreqPackage.RSPEC_OBJECT__VALUE, GreqPackage.RVALUE__OBJECT);
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
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GreqPackage.RSPEC_OBJECT__VALUE:
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
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GreqPackage.RSPEC_OBJECT__VALUE:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GreqPackage.RSPEC_OBJECT__DEFINITION:
        return getDefinition();
      case GreqPackage.RSPEC_OBJECT__ID:
        return getId();
      case GreqPackage.RSPEC_OBJECT__VERSION:
        return getVersion();
      case GreqPackage.RSPEC_OBJECT__URL:
        return getUrl();
      case GreqPackage.RSPEC_OBJECT__ANNOTATION:
        return getAnnotation();
      case GreqPackage.RSPEC_OBJECT__VALUE:
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GreqPackage.RSPEC_OBJECT__DEFINITION:
        setDefinition((String)newValue);
        return;
      case GreqPackage.RSPEC_OBJECT__ID:
        setId((String)newValue);
        return;
      case GreqPackage.RSPEC_OBJECT__VERSION:
        setVersion((String)newValue);
        return;
      case GreqPackage.RSPEC_OBJECT__URL:
        setUrl((String)newValue);
        return;
      case GreqPackage.RSPEC_OBJECT__ANNOTATION:
        getAnnotation().clear();
        getAnnotation().addAll((Collection<? extends RAnnotation>)newValue);
        return;
      case GreqPackage.RSPEC_OBJECT__VALUE:
        getValue().clear();
        getValue().addAll((Collection<? extends RValue>)newValue);
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
      case GreqPackage.RSPEC_OBJECT__DEFINITION:
        setDefinition(DEFINITION_EDEFAULT);
        return;
      case GreqPackage.RSPEC_OBJECT__ID:
        setId(ID_EDEFAULT);
        return;
      case GreqPackage.RSPEC_OBJECT__VERSION:
        setVersion(VERSION_EDEFAULT);
        return;
      case GreqPackage.RSPEC_OBJECT__URL:
        setUrl(URL_EDEFAULT);
        return;
      case GreqPackage.RSPEC_OBJECT__ANNOTATION:
        getAnnotation().clear();
        return;
      case GreqPackage.RSPEC_OBJECT__VALUE:
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GreqPackage.RSPEC_OBJECT__DEFINITION:
        return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
      case GreqPackage.RSPEC_OBJECT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case GreqPackage.RSPEC_OBJECT__VERSION:
        return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
      case GreqPackage.RSPEC_OBJECT__URL:
        return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
      case GreqPackage.RSPEC_OBJECT__ANNOTATION:
        return annotation != null && !annotation.isEmpty();
      case GreqPackage.RSPEC_OBJECT__VALUE:
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
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (definition: ");
    result.append(definition);
    result.append(", id: ");
    result.append(id);
    result.append(", version: ");
    result.append(version);
    result.append(", url: ");
    result.append(url);
    result.append(')');
    return result.toString();
  }

} //RSpecObjectImpl
