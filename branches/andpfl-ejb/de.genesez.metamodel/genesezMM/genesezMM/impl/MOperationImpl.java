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
import genesezMM.MParameter;
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
 * An implementation of the model object '<em><b>MOperation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link genesezMM.impl.MOperationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getRaisedException <em>Raised Exception</em>}</li>
 *   <li>{@link genesezMM.impl.MOperationImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MOperationImpl extends MElementImpl implements MOperation
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
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

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
   * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected static final int MULTIPLICITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected int multiplicity = MULTIPLICITY_EDEFAULT;

  /**
   * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected boolean unique = UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOrdered()
   * @generated
   * @ordered
   */
  protected boolean ordered = ORDERED_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected EList parameter;

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
   * The cached value of the '{@link #getRaisedException() <em>Raised Exception</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRaisedException()
   * @generated
   * @ordered
   */
  protected EList raisedException;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected MType returnType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MOperationImpl()
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
    return GenesezMMPackage.Literals.MOPERATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__STATIC, oldStatic, static_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__ABSTRACT, oldAbstract, abstract_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__FINAL, oldFinal, final_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(int newMultiplicity)
  {
    int oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__MULTIPLICITY, oldMultiplicity, multiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnique()
  {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique(boolean newUnique)
  {
    boolean oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__UNIQUE, oldUnique, unique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOrdered()
  {
    return ordered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrdered(boolean newOrdered)
  {
    boolean oldOrdered = ordered;
    ordered = newOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentWithInverseEList(MParameter.class, this, GenesezMMPackage.MOPERATION__PARAMETER, GenesezMMPackage.MPARAMETER__OPERATION);
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MClassifier getClassifier()
  {
    if (eContainerFeatureID != GenesezMMPackage.MOPERATION__CLASSIFIER) return null;
    return (MClassifier)eContainer();
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
      genericParameter = new EObjectContainmentWithInverseEList(MGeneric.class, this, GenesezMMPackage.MOPERATION__GENERIC_PARAMETER, GenesezMMPackage.MGENERIC__OWNING_OPERATION);
    }
    return genericParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getRaisedException()
  {
    if (raisedException == null)
    {
      raisedException = new EObjectResolvingEList(MType.class, this, GenesezMMPackage.MOPERATION__RAISED_EXCEPTION);
    }
    return raisedException;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType getReturnType()
  {
    if (returnType != null && returnType.eIsProxy())
    {
      InternalEObject oldReturnType = (InternalEObject)returnType;
      returnType = (MType)eResolveProxy(oldReturnType);
      if (returnType != oldReturnType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenesezMMPackage.MOPERATION__RETURN_TYPE, oldReturnType, returnType));
      }
    }
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MType basicGetReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(MType newReturnType)
  {
    MType oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GenesezMMPackage.MOPERATION__RETURN_TYPE, oldReturnType, returnType));
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
      case GenesezMMPackage.MOPERATION__PARAMETER:
        return ((InternalEList)getParameter()).basicAdd(otherEnd, msgs);
      case GenesezMMPackage.MOPERATION__CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GenesezMMPackage.MOPERATION__CLASSIFIER, msgs);
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
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
      case GenesezMMPackage.MOPERATION__PARAMETER:
        return ((InternalEList)getParameter()).basicRemove(otherEnd, msgs);
      case GenesezMMPackage.MOPERATION__CLASSIFIER:
        return eBasicSetContainer(null, GenesezMMPackage.MOPERATION__CLASSIFIER, msgs);
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
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
      case GenesezMMPackage.MOPERATION__CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, GenesezMMPackage.MCLASSIFIER__OPERATION, MClassifier.class, msgs);
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
      case GenesezMMPackage.MOPERATION__VISIBILITY:
        return getVisibility();
      case GenesezMMPackage.MOPERATION__STATIC:
        return isStatic() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MOPERATION__ABSTRACT:
        return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MOPERATION__FINAL:
        return isFinal() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MOPERATION__MULTIPLICITY:
        return new Integer(getMultiplicity());
      case GenesezMMPackage.MOPERATION__UNIQUE:
        return isUnique() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MOPERATION__ORDERED:
        return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
      case GenesezMMPackage.MOPERATION__PARAMETER:
        return getParameter();
      case GenesezMMPackage.MOPERATION__CLASSIFIER:
        return getClassifier();
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
        return getGenericParameter();
      case GenesezMMPackage.MOPERATION__RAISED_EXCEPTION:
        return getRaisedException();
      case GenesezMMPackage.MOPERATION__RETURN_TYPE:
        if (resolve) return getReturnType();
        return basicGetReturnType();
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
      case GenesezMMPackage.MOPERATION__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GenesezMMPackage.MOPERATION__STATIC:
        setStatic(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MOPERATION__ABSTRACT:
        setAbstract(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MOPERATION__FINAL:
        setFinal(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MOPERATION__MULTIPLICITY:
        setMultiplicity(((Integer)newValue).intValue());
        return;
      case GenesezMMPackage.MOPERATION__UNIQUE:
        setUnique(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MOPERATION__ORDERED:
        setOrdered(((Boolean)newValue).booleanValue());
        return;
      case GenesezMMPackage.MOPERATION__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MOPERATION__RAISED_EXCEPTION:
        getRaisedException().clear();
        getRaisedException().addAll((Collection)newValue);
        return;
      case GenesezMMPackage.MOPERATION__RETURN_TYPE:
        setReturnType((MType)newValue);
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
      case GenesezMMPackage.MOPERATION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case GenesezMMPackage.MOPERATION__PARAMETER:
        getParameter().clear();
        return;
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
        getGenericParameter().clear();
        return;
      case GenesezMMPackage.MOPERATION__RAISED_EXCEPTION:
        getRaisedException().clear();
        return;
      case GenesezMMPackage.MOPERATION__RETURN_TYPE:
        setReturnType((MType)null);
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
      case GenesezMMPackage.MOPERATION__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GenesezMMPackage.MOPERATION__STATIC:
        return static_ != STATIC_EDEFAULT;
      case GenesezMMPackage.MOPERATION__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case GenesezMMPackage.MOPERATION__FINAL:
        return final_ != FINAL_EDEFAULT;
      case GenesezMMPackage.MOPERATION__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case GenesezMMPackage.MOPERATION__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case GenesezMMPackage.MOPERATION__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case GenesezMMPackage.MOPERATION__PARAMETER:
        return parameter != null && !parameter.isEmpty();
      case GenesezMMPackage.MOPERATION__CLASSIFIER:
        return getClassifier() != null;
      case GenesezMMPackage.MOPERATION__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
      case GenesezMMPackage.MOPERATION__RAISED_EXCEPTION:
        return raisedException != null && !raisedException.isEmpty();
      case GenesezMMPackage.MOPERATION__RETURN_TYPE:
        return returnType != null;
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
    result.append(", static: ");
    result.append(static_);
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", final: ");
    result.append(final_);
    result.append(", multiplicity: ");
    result.append(multiplicity);
    result.append(", unique: ");
    result.append(unique);
    result.append(", ordered: ");
    result.append(ordered);
    result.append(')');
    return result.toString();
  }

} //MOperationImpl
