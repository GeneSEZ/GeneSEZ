/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.MParameter;
import org.genesez.metamodel.gcore.MType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MOperation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getRaisedException <em>Raised Exception</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MOperationImpl#getReturn <em>Return</em>}</li>
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
  protected EList<MParameter> parameter;

  /**
   * The cached value of the '{@link #getGenericParameter() <em>Generic Parameter</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenericParameter()
   * @generated
   * @ordered
   */
  protected EList<MGeneric> genericParameter;

  /**
   * The cached value of the '{@link #getRaisedException() <em>Raised Exception</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRaisedException()
   * @generated
   * @ordered
   */
  protected EList<MType> raisedException;

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
   * The cached value of the '{@link #getReturn() <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected MParameter return_;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MOPERATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__VISIBILITY, oldVisibility, visibility));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__STATIC, oldStatic, static_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__ABSTRACT, oldAbstract, abstract_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__FINAL, oldFinal, final_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__MULTIPLICITY, oldMultiplicity, multiplicity));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__UNIQUE, oldUnique, unique));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__ORDERED, oldOrdered, ordered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MParameter> getParameter()
  {
    if (parameter == null)
    {
      parameter = new EObjectContainmentEList<MParameter>(MParameter.class, this, GcorePackage.MOPERATION__PARAMETER);
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
    if (eContainerFeatureID() != GcorePackage.MOPERATION__CLASSIFIER) return null;
    return (MClassifier)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MGeneric> getGenericParameter()
  {
    if (genericParameter == null)
    {
      genericParameter = new EObjectContainmentWithInverseEList<MGeneric>(MGeneric.class, this, GcorePackage.MOPERATION__GENERIC_PARAMETER, GcorePackage.MGENERIC__OWNING_OPERATION);
    }
    return genericParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MType> getRaisedException()
  {
    if (raisedException == null)
    {
      raisedException = new EObjectResolvingEList<MType>(MType.class, this, GcorePackage.MOPERATION__RAISED_EXCEPTION);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GcorePackage.MOPERATION__RETURN_TYPE, oldReturnType, returnType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__RETURN_TYPE, oldReturnType, returnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MParameter getReturn()
  {
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturn(MParameter newReturn, NotificationChain msgs)
  {
    MParameter oldReturn = return_;
    return_ = newReturn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__RETURN, oldReturn, newReturn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturn(MParameter newReturn)
  {
    if (newReturn != return_)
    {
      NotificationChain msgs = null;
      if (return_ != null)
        msgs = ((InternalEObject)return_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MOPERATION__RETURN, null, msgs);
      if (newReturn != null)
        msgs = ((InternalEObject)newReturn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GcorePackage.MOPERATION__RETURN, null, msgs);
      msgs = basicSetReturn(newReturn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MOPERATION__RETURN, newReturn, newReturn));
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
      case GcorePackage.MOPERATION__CLASSIFIER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MOPERATION__CLASSIFIER, msgs);
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenericParameter()).basicAdd(otherEnd, msgs);
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
      case GcorePackage.MOPERATION__PARAMETER:
        return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
      case GcorePackage.MOPERATION__CLASSIFIER:
        return eBasicSetContainer(null, GcorePackage.MOPERATION__CLASSIFIER, msgs);
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        return ((InternalEList<?>)getGenericParameter()).basicRemove(otherEnd, msgs);
      case GcorePackage.MOPERATION__RETURN:
        return basicSetReturn(null, msgs);
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
      case GcorePackage.MOPERATION__CLASSIFIER:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MCLASSIFIER__OPERATION, MClassifier.class, msgs);
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
      case GcorePackage.MOPERATION__VISIBILITY:
        return getVisibility();
      case GcorePackage.MOPERATION__STATIC:
        return isStatic();
      case GcorePackage.MOPERATION__ABSTRACT:
        return isAbstract();
      case GcorePackage.MOPERATION__FINAL:
        return isFinal();
      case GcorePackage.MOPERATION__MULTIPLICITY:
        return getMultiplicity();
      case GcorePackage.MOPERATION__UNIQUE:
        return isUnique();
      case GcorePackage.MOPERATION__ORDERED:
        return isOrdered();
      case GcorePackage.MOPERATION__PARAMETER:
        return getParameter();
      case GcorePackage.MOPERATION__CLASSIFIER:
        return getClassifier();
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        return getGenericParameter();
      case GcorePackage.MOPERATION__RAISED_EXCEPTION:
        return getRaisedException();
      case GcorePackage.MOPERATION__RETURN_TYPE:
        if (resolve) return getReturnType();
        return basicGetReturnType();
      case GcorePackage.MOPERATION__RETURN:
        return getReturn();
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
      case GcorePackage.MOPERATION__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GcorePackage.MOPERATION__STATIC:
        setStatic((Boolean)newValue);
        return;
      case GcorePackage.MOPERATION__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case GcorePackage.MOPERATION__FINAL:
        setFinal((Boolean)newValue);
        return;
      case GcorePackage.MOPERATION__MULTIPLICITY:
        setMultiplicity((Integer)newValue);
        return;
      case GcorePackage.MOPERATION__UNIQUE:
        setUnique((Boolean)newValue);
        return;
      case GcorePackage.MOPERATION__ORDERED:
        setOrdered((Boolean)newValue);
        return;
      case GcorePackage.MOPERATION__PARAMETER:
        getParameter().clear();
        getParameter().addAll((Collection<? extends MParameter>)newValue);
        return;
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection<? extends MGeneric>)newValue);
        return;
      case GcorePackage.MOPERATION__RAISED_EXCEPTION:
        getRaisedException().clear();
        getRaisedException().addAll((Collection<? extends MType>)newValue);
        return;
      case GcorePackage.MOPERATION__RETURN_TYPE:
        setReturnType((MType)newValue);
        return;
      case GcorePackage.MOPERATION__RETURN:
        setReturn((MParameter)newValue);
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
      case GcorePackage.MOPERATION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__ORDERED:
        setOrdered(ORDERED_EDEFAULT);
        return;
      case GcorePackage.MOPERATION__PARAMETER:
        getParameter().clear();
        return;
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        getGenericParameter().clear();
        return;
      case GcorePackage.MOPERATION__RAISED_EXCEPTION:
        getRaisedException().clear();
        return;
      case GcorePackage.MOPERATION__RETURN_TYPE:
        setReturnType((MType)null);
        return;
      case GcorePackage.MOPERATION__RETURN:
        setReturn((MParameter)null);
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
      case GcorePackage.MOPERATION__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GcorePackage.MOPERATION__STATIC:
        return static_ != STATIC_EDEFAULT;
      case GcorePackage.MOPERATION__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case GcorePackage.MOPERATION__FINAL:
        return final_ != FINAL_EDEFAULT;
      case GcorePackage.MOPERATION__MULTIPLICITY:
        return multiplicity != MULTIPLICITY_EDEFAULT;
      case GcorePackage.MOPERATION__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case GcorePackage.MOPERATION__ORDERED:
        return ordered != ORDERED_EDEFAULT;
      case GcorePackage.MOPERATION__PARAMETER:
        return parameter != null && !parameter.isEmpty();
      case GcorePackage.MOPERATION__CLASSIFIER:
        return getClassifier() != null;
      case GcorePackage.MOPERATION__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
      case GcorePackage.MOPERATION__RAISED_EXCEPTION:
        return raisedException != null && !raisedException.isEmpty();
      case GcorePackage.MOPERATION__RETURN_TYPE:
        return returnType != null;
      case GcorePackage.MOPERATION__RETURN:
        return return_ != null;
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
