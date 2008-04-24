/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MComment;
import genesezMM.MElement;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MComment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MCommentImpl#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link genesezMM.impl.MCommentImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link genesezMM.impl.MCommentImpl#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link genesezMM.impl.MCommentImpl#getNestedComment <em>Nested Comment</em>}</li>
 *   <li>{@link genesezMM.impl.MCommentImpl#getNestingComment <em>Nesting Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MCommentImpl extends EObjectImpl implements MComment
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
   * The default value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected static final String ANNOTATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotation()
   * @generated
   * @ordered
   */
  protected String annotation = ANNOTATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getNestedComment() <em>Nested Comment</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedComment()
   * @generated
   * @ordered
   */
  protected EList nestedComment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MCommentImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return GenesezMMPackage.Literals.MCOMMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getXmiGuid()
  {
    return xmiGuid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXmiGuid(String newXmiGuid)
  {
    String oldXmiGuid = xmiGuid;
    xmiGuid = newXmiGuid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCOMMENT__XMI_GUID, oldXmiGuid, xmiGuid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAnnotation()
  {
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnotation(String newAnnotation)
  {
    String oldAnnotation = annotation;
    annotation = newAnnotation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCOMMENT__ANNOTATION, oldAnnotation, annotation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MElement getOwningElement()
  {
    if (eContainerFeatureID != GenesezMMPackage.MCOMMENT__OWNING_ELEMENT) return null;
    return (MElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getNestedComment()
  {
    if (nestedComment == null)
    {
      nestedComment = new EObjectContainmentWithInverseEList(MComment.class, this, GenesezMMPackage.MCOMMENT__NESTED_COMMENT, GenesezMMPackage.MCOMMENT__NESTING_COMMENT);
    }
    return nestedComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MComment getNestingComment()
  {
    if (eContainerFeatureID != GenesezMMPackage.MCOMMENT__NESTING_COMMENT) return null;
    return (MComment)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__OWNING_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MCOMMENT__OWNING_ELEMENT, msgs);
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        return ((InternalEList)getNestedComment()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MCOMMENT__NESTING_COMMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MCOMMENT__NESTING_COMMENT, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__OWNING_ELEMENT:
        return eBasicSetContainer(null, GenesezMMPackage.MCOMMENT__OWNING_ELEMENT, msgs);
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        return ((InternalEList)getNestedComment()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MCOMMENT__NESTING_COMMENT:
        return eBasicSetContainer(null, GenesezMMPackage.MCOMMENT__NESTING_COMMENT, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case GenesezMMPackage.MCOMMENT__OWNING_ELEMENT:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MELEMENT__OWNED_COMMENT, MElement.class, msgs);
      case GenesezMMPackage.MCOMMENT__NESTING_COMMENT:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MCOMMENT__NESTED_COMMENT, MComment.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__XMI_GUID:
        return getXmiGuid();
      case GenesezMMPackage.MCOMMENT__ANNOTATION:
        return getAnnotation();
      case GenesezMMPackage.MCOMMENT__OWNING_ELEMENT:
        return getOwningElement();
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        return getNestedComment();
      case GenesezMMPackage.MCOMMENT__NESTING_COMMENT:
        return getNestingComment();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__XMI_GUID:
        setXmiGuid((String)newValue);
        return;
      case GenesezMMPackage.MCOMMENT__ANNOTATION:
        setAnnotation((String)newValue);
        return;
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        getNestedComment().clear();
        getNestedComment().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__XMI_GUID:
        setXmiGuid(XMI_GUID_EDEFAULT);
        return;
      case GenesezMMPackage.MCOMMENT__ANNOTATION:
        setAnnotation(ANNOTATION_EDEFAULT);
        return;
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        getNestedComment().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GenesezMMPackage.MCOMMENT__XMI_GUID:
        return XMI_GUID_EDEFAULT == null ? xmiGuid != null : !XMI_GUID_EDEFAULT.equals(xmiGuid);
      case GenesezMMPackage.MCOMMENT__ANNOTATION:
        return ANNOTATION_EDEFAULT == null ? annotation != null : !ANNOTATION_EDEFAULT.equals(annotation);
      case GenesezMMPackage.MCOMMENT__OWNING_ELEMENT:
        return getOwningElement() != null;
      case GenesezMMPackage.MCOMMENT__NESTED_COMMENT:
        return nestedComment != null && !nestedComment.isEmpty();
      case GenesezMMPackage.MCOMMENT__NESTING_COMMENT:
        return getNestingComment() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (xmiGuid: ");
    result.append(xmiGuid);
    result.append(", annotation: ");
    result.append(annotation);
    result.append(')');
    return result.toString();
  }

} //MCommentImpl
