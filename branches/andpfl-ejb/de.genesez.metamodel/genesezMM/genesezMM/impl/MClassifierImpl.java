/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.impl;

import genesezMM.GenesezMMPackage;
import genesezMM.MClassifier;
import genesezMM.MGeneric;
import genesezMM.MOperation;
import genesezMM.MPackage;
import genesezMM.MProperty;
import genesezMM.MType;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MClassifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getRealization <em>Realization</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link genesezMM.impl.MClassifierImpl#getSupplier <em>Supplier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MClassifierImpl extends MElementImpl implements MClassifier
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final String VISIBILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected String visibility = VISIBILITY_EDEFAULT;

  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected static final boolean FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFinal()
   * @generated
   * @ordered
   */
  protected boolean final_ = FINAL_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperation()
   * @generated
   * @ordered
   */
  protected EList operation;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected EList property;

  /**
   * The cached value of the '{@link #getGenericParameter() <em>Generic Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericParameter()
   * @generated
   * @ordered
   */
  protected EList genericParameter;

  /**
   * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupertype()
   * @generated
   * @ordered
   */
  protected EList supertype;

  /**
   * The cached value of the '{@link #getRealization() <em>Realization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealization()
   * @generated
   * @ordered
   */
  protected EList realization;

  /**
   * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralization()
   * @generated
   * @ordered
   */
  protected EList generalization;

  /**
   * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupplier()
   * @generated
   * @ordered
   */
  protected EList supplier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MClassifierImpl()
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
    return GenesezMMPackage.Literals.MCLASSIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(String newVisibility)
  {
    String oldVisibility = visibility;
    visibility = newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCLASSIFIER__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCLASSIFIER__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFinal()
  {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFinal(boolean newFinal)
  {
    boolean oldFinal = final_;
    final_ = newFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MCLASSIFIER__FINAL, oldFinal, final_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MPackage getOwningPackage()
  {
    if (eContainerFeatureID != GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE) return null;
    return (MPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getOperation()
  {
    if (operation == null)
    {
      operation = new EObjectContainmentWithInverseEList(MOperation.class, this, GenesezMMPackage.MCLASSIFIER__OPERATION, GenesezMMPackage.MOPERATION__CLASSIFIER);
    }
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getProperty()
  {
    if (property == null)
    {
      property = new EObjectContainmentWithInverseEList(MProperty.class, this, GenesezMMPackage.MCLASSIFIER__PROPERTY, GenesezMMPackage.MPROPERTY__CLASSIFIER);
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getGenericParameter()
  {
    if (genericParameter == null)
    {
      genericParameter = new EObjectContainmentWithInverseEList(MGeneric.class, this, GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER, GenesezMMPackage.MGENERIC__OWNING_CLASSIFIER);
    }
    return genericParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getSupertype()
  {
    if (supertype == null)
    {
      supertype = new EObjectResolvingEList(MType.class, this, GenesezMMPackage.MCLASSIFIER__SUPERTYPE);
    }
    return supertype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getRealization()
  {
    if (realization == null)
    {
      realization = new EObjectResolvingEList(MType.class, this, GenesezMMPackage.MCLASSIFIER__REALIZATION);
    }
    return realization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getGeneralization()
  {
    if (generalization == null)
    {
      generalization = new EObjectResolvingEList(MType.class, this, GenesezMMPackage.MCLASSIFIER__GENERALIZATION);
    }
    return generalization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getSupplier()
  {
    if (supplier == null)
    {
      supplier = new EObjectResolvingEList(MType.class, this, GenesezMMPackage.MCLASSIFIER__SUPPLIER);
    }
    return supplier;
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
      case GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE, msgs);
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        return ((InternalEList)getOperation()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        return ((InternalEList)getProperty()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        return ((InternalEList)getGenericParameter()).basicAdd(otherEnd, msgs);
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
      case GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE:
        return eBasicSetContainer(null, GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE, msgs);
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        return ((InternalEList)getOperation()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        return ((InternalEList)getProperty()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        return ((InternalEList)getGenericParameter()).basicRemove(otherEnd, msgs);
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
      case GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MPACKAGE__CLASSIFIER, MPackage.class, msgs);
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
      case GenesezMMPackage.MCLASSIFIER__VISIBILITY:
        return getVisibility();
      case GenesezMMPackage.MCLASSIFIER__ABSTRACT:
        return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MCLASSIFIER__FINAL:
        return isFinal() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE:
        return getOwningPackage();
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        return getOperation();
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        return getProperty();
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        return getGenericParameter();
      case GenesezMMPackage.MCLASSIFIER__SUPERTYPE:
        return getSupertype();
      case GenesezMMPackage.MCLASSIFIER__REALIZATION:
        return getRealization();
      case GenesezMMPackage.MCLASSIFIER__GENERALIZATION:
        return getGeneralization();
      case GenesezMMPackage.MCLASSIFIER__SUPPLIER:
        return getSupplier();
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
      case GenesezMMPackage.MCLASSIFIER__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__ABSTRACT:
        setAbstract(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MCLASSIFIER__FINAL:
        setFinal(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        getOperation().clear();
        getOperation().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__SUPERTYPE:
        getSupertype().clear();
        getSupertype().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__REALIZATION:
        getRealization().clear();
        getRealization().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__GENERALIZATION:
        getGeneralization().clear();
        getGeneralization().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MCLASSIFIER__SUPPLIER:
        getSupplier().clear();
        getSupplier().addAll((Collection)newValue);
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
      case GenesezMMPackage.MCLASSIFIER__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GenesezMMPackage.MCLASSIFIER__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case GenesezMMPackage.MCLASSIFIER__FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        getOperation().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        getProperty().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        getGenericParameter().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__SUPERTYPE:
        getSupertype().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__REALIZATION:
        getRealization().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__GENERALIZATION:
        getGeneralization().clear();
        return;
      case GenesezMMPackage.MCLASSIFIER__SUPPLIER:
        getSupplier().clear();
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
      case GenesezMMPackage.MCLASSIFIER__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GenesezMMPackage.MCLASSIFIER__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case GenesezMMPackage.MCLASSIFIER__FINAL:
        return final_ != FINAL_EDEFAULT;
      case GenesezMMPackage.MCLASSIFIER__OWNING_PACKAGE:
        return getOwningPackage() != null;
      case GenesezMMPackage.MCLASSIFIER__OPERATION:
        return operation != null && !operation.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__PROPERTY:
        return property != null && !property.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__SUPERTYPE:
        return supertype != null && !supertype.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__REALIZATION:
        return realization != null && !realization.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__GENERALIZATION:
        return generalization != null && !generalization.isEmpty();
      case GenesezMMPackage.MCLASSIFIER__SUPPLIER:
        return supplier != null && !supplier.isEmpty();
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", final: ");
    result.append(final_);
    result.append(')');
    return result.toString();
  }

} //MClassifierImpl
