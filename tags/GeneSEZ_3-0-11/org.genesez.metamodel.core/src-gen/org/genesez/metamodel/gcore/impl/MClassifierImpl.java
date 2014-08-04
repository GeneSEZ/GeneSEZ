/**
 */
package org.genesez.metamodel.gcore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.gcore.MBehavior;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MGuard;
import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.MProperty;
import org.genesez.metamodel.gcore.MType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MClassifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getSpecialization <em>Specialization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getGenericParameter <em>Generic Parameter</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getRealization <em>Realization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getGeneralization <em>Generalization</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.impl.MClassifierImpl#getOwningContext <em>Owning Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MClassifierImpl extends MElementImpl implements MClassifier
{
  /**
   * The cached value of the '{@link #getSpecialization() <em>Specialization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecialization()
   * @generated
   * @ordered
   */
  protected EList<MClassifier> specialization;

  /**
   * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifier()
   * @generated
   * @ordered
   */
  protected EList<MClassifier> classifier;

  /**
   * The cached value of the '{@link #getOwnedBehavior() <em>Owned Behavior</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedBehavior()
   * @generated
   * @ordered
   */
  protected EList<MBehavior> ownedBehavior;

  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected EList<MGuard> guard;

  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected EList<MEvent> event;

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
  protected EList<MOperation> operation;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected EList<MProperty> property;

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
   * The cached value of the '{@link #getRealization() <em>Realization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealization()
   * @generated
   * @ordered
   */
  protected EList<MType> realization;

  /**
   * The cached value of the '{@link #getGeneralization() <em>Generalization</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralization()
   * @generated
   * @ordered
   */
  protected EList<MType> generalization;

  /**
   * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupplier()
   * @generated
   * @ordered
   */
  protected EList<MType> supplier;

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
  @Override
  protected EClass eStaticClass()
  {
    return GcorePackage.Literals.MCLASSIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MClassifier> getSpecialization()
  {
    if (specialization == null)
    {
      specialization = new EObjectWithInverseResolvingEList.ManyInverse<MClassifier>(MClassifier.class, this, GcorePackage.MCLASSIFIER__SPECIALIZATION, GcorePackage.MCLASSIFIER__GENERALIZATION);
    }
    return specialization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MClassifier> getClassifier()
  {
    if (classifier == null)
    {
      classifier = new EObjectContainmentWithInverseEList<MClassifier>(MClassifier.class, this, GcorePackage.MCLASSIFIER__CLASSIFIER, GcorePackage.MCLASSIFIER__OWNING_CONTEXT);
    }
    return classifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MBehavior> getOwnedBehavior()
  {
    if (ownedBehavior == null)
    {
      ownedBehavior = new EObjectContainmentWithInverseEList<MBehavior>(MBehavior.class, this, GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR, GcorePackage.MBEHAVIOR__OWNING_CONTEXT);
    }
    return ownedBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MGuard> getGuard()
  {
    if (guard == null)
    {
      guard = new EObjectContainmentWithInverseEList<MGuard>(MGuard.class, this, GcorePackage.MCLASSIFIER__GUARD, GcorePackage.MGUARD__OWNING_CONTEXT);
    }
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MEvent> getEvent()
  {
    if (event == null)
    {
      event = new EObjectContainmentWithInverseEList<MEvent>(MEvent.class, this, GcorePackage.MCLASSIFIER__EVENT, GcorePackage.MEVENT__OWNING_CONTEXT);
    }
    return event;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MCLASSIFIER__VISIBILITY, oldVisibility, visibility));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MCLASSIFIER__ABSTRACT, oldAbstract, abstract_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, GcorePackage.MCLASSIFIER__FINAL, oldFinal, final_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MOperation> getOperation()
  {
    if (operation == null)
    {
      operation = new EObjectContainmentWithInverseEList<MOperation>(MOperation.class, this, GcorePackage.MCLASSIFIER__OPERATION, GcorePackage.MOPERATION__CLASSIFIER);
    }
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MProperty> getProperty()
  {
    if (property == null)
    {
      property = new EObjectContainmentWithInverseEList<MProperty>(MProperty.class, this, GcorePackage.MCLASSIFIER__PROPERTY, GcorePackage.MPROPERTY__CLASSIFIER);
    }
    return property;
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
      genericParameter = new EObjectContainmentWithInverseEList<MGeneric>(MGeneric.class, this, GcorePackage.MCLASSIFIER__GENERIC_PARAMETER, GcorePackage.MGENERIC__OWNING_CLASSIFIER);
    }
    return genericParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MType> getRealization()
  {
    if (realization == null)
    {
      realization = new EObjectResolvingEList<MType>(MType.class, this, GcorePackage.MCLASSIFIER__REALIZATION);
    }
    return realization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MType> getGeneralization()
  {
    if (generalization == null)
    {
      generalization = new EObjectWithInverseResolvingEList.ManyInverse<MType>(MType.class, this, GcorePackage.MCLASSIFIER__GENERALIZATION, GcorePackage.MTYPE__SPECIALIZATION);
    }
    return generalization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MType> getSupplier()
  {
    if (supplier == null)
    {
      supplier = new EObjectResolvingEList<MType>(MType.class, this, GcorePackage.MCLASSIFIER__SUPPLIER);
    }
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MDefinitionContext getOwningContext()
  {
    if (eContainerFeatureID() != GcorePackage.MCLASSIFIER__OWNING_CONTEXT) return null;
    return (MDefinitionContext)eContainer();
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
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecialization()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassifier()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBehavior()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GUARD:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGuard()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__EVENT:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEvent()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OPERATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperation()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__PROPERTY:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperty()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGenericParameter()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralization()).basicAdd(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OWNING_CONTEXT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, GcorePackage.MCLASSIFIER__OWNING_CONTEXT, msgs);
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
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        return ((InternalEList<?>)getSpecialization()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        return ((InternalEList<?>)getClassifier()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        return ((InternalEList<?>)getOwnedBehavior()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GUARD:
        return ((InternalEList<?>)getGuard()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__EVENT:
        return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OPERATION:
        return ((InternalEList<?>)getOperation()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__PROPERTY:
        return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        return ((InternalEList<?>)getGenericParameter()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        return ((InternalEList<?>)getGeneralization()).basicRemove(otherEnd, msgs);
      case GcorePackage.MCLASSIFIER__OWNING_CONTEXT:
        return eBasicSetContainer(null, GcorePackage.MCLASSIFIER__OWNING_CONTEXT, msgs);
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
      case GcorePackage.MCLASSIFIER__OWNING_CONTEXT:
        return eInternalContainer().eInverseRemove(this, GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER, MDefinitionContext.class, msgs);
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
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        return getSpecialization();
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        return getClassifier();
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        return getOwnedBehavior();
      case GcorePackage.MCLASSIFIER__GUARD:
        return getGuard();
      case GcorePackage.MCLASSIFIER__EVENT:
        return getEvent();
      case GcorePackage.MCLASSIFIER__VISIBILITY:
        return getVisibility();
      case GcorePackage.MCLASSIFIER__ABSTRACT:
        return isAbstract();
      case GcorePackage.MCLASSIFIER__FINAL:
        return isFinal();
      case GcorePackage.MCLASSIFIER__OPERATION:
        return getOperation();
      case GcorePackage.MCLASSIFIER__PROPERTY:
        return getProperty();
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        return getGenericParameter();
      case GcorePackage.MCLASSIFIER__REALIZATION:
        return getRealization();
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        return getGeneralization();
      case GcorePackage.MCLASSIFIER__SUPPLIER:
        return getSupplier();
      case GcorePackage.MCLASSIFIER__OWNING_CONTEXT:
        return getOwningContext();
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
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        getSpecialization().clear();
        getSpecialization().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        getClassifier().clear();
        getClassifier().addAll((Collection<? extends MClassifier>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        getOwnedBehavior().addAll((Collection<? extends MBehavior>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__GUARD:
        getGuard().clear();
        getGuard().addAll((Collection<? extends MGuard>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__EVENT:
        getEvent().clear();
        getEvent().addAll((Collection<? extends MEvent>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__VISIBILITY:
        setVisibility((String)newValue);
        return;
      case GcorePackage.MCLASSIFIER__ABSTRACT:
        setAbstract((Boolean)newValue);
        return;
      case GcorePackage.MCLASSIFIER__FINAL:
        setFinal((Boolean)newValue);
        return;
      case GcorePackage.MCLASSIFIER__OPERATION:
        getOperation().clear();
        getOperation().addAll((Collection<? extends MOperation>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection<? extends MProperty>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        getGenericParameter().clear();
        getGenericParameter().addAll((Collection<? extends MGeneric>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__REALIZATION:
        getRealization().clear();
        getRealization().addAll((Collection<? extends MType>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        getGeneralization().clear();
        getGeneralization().addAll((Collection<? extends MType>)newValue);
        return;
      case GcorePackage.MCLASSIFIER__SUPPLIER:
        getSupplier().clear();
        getSupplier().addAll((Collection<? extends MType>)newValue);
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
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        getSpecialization().clear();
        return;
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        getClassifier().clear();
        return;
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        getOwnedBehavior().clear();
        return;
      case GcorePackage.MCLASSIFIER__GUARD:
        getGuard().clear();
        return;
      case GcorePackage.MCLASSIFIER__EVENT:
        getEvent().clear();
        return;
      case GcorePackage.MCLASSIFIER__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case GcorePackage.MCLASSIFIER__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case GcorePackage.MCLASSIFIER__FINAL:
        setFinal(FINAL_EDEFAULT);
        return;
      case GcorePackage.MCLASSIFIER__OPERATION:
        getOperation().clear();
        return;
      case GcorePackage.MCLASSIFIER__PROPERTY:
        getProperty().clear();
        return;
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        getGenericParameter().clear();
        return;
      case GcorePackage.MCLASSIFIER__REALIZATION:
        getRealization().clear();
        return;
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        getGeneralization().clear();
        return;
      case GcorePackage.MCLASSIFIER__SUPPLIER:
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
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GcorePackage.MCLASSIFIER__SPECIALIZATION:
        return specialization != null && !specialization.isEmpty();
      case GcorePackage.MCLASSIFIER__CLASSIFIER:
        return classifier != null && !classifier.isEmpty();
      case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR:
        return ownedBehavior != null && !ownedBehavior.isEmpty();
      case GcorePackage.MCLASSIFIER__GUARD:
        return guard != null && !guard.isEmpty();
      case GcorePackage.MCLASSIFIER__EVENT:
        return event != null && !event.isEmpty();
      case GcorePackage.MCLASSIFIER__VISIBILITY:
        return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
      case GcorePackage.MCLASSIFIER__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case GcorePackage.MCLASSIFIER__FINAL:
        return final_ != FINAL_EDEFAULT;
      case GcorePackage.MCLASSIFIER__OPERATION:
        return operation != null && !operation.isEmpty();
      case GcorePackage.MCLASSIFIER__PROPERTY:
        return property != null && !property.isEmpty();
      case GcorePackage.MCLASSIFIER__GENERIC_PARAMETER:
        return genericParameter != null && !genericParameter.isEmpty();
      case GcorePackage.MCLASSIFIER__REALIZATION:
        return realization != null && !realization.isEmpty();
      case GcorePackage.MCLASSIFIER__GENERALIZATION:
        return generalization != null && !generalization.isEmpty();
      case GcorePackage.MCLASSIFIER__SUPPLIER:
        return supplier != null && !supplier.isEmpty();
      case GcorePackage.MCLASSIFIER__OWNING_CONTEXT:
        return getOwningContext() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == MType.class)
    {
      switch (derivedFeatureID)
      {
        case GcorePackage.MCLASSIFIER__SPECIALIZATION: return GcorePackage.MTYPE__SPECIALIZATION;
        default: return -1;
      }
    }
    if (baseClass == MDefinitionContext.class)
    {
      switch (derivedFeatureID)
      {
        case GcorePackage.MCLASSIFIER__CLASSIFIER: return GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER;
        case GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR: return GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR;
        case GcorePackage.MCLASSIFIER__GUARD: return GcorePackage.MDEFINITION_CONTEXT__GUARD;
        case GcorePackage.MCLASSIFIER__EVENT: return GcorePackage.MDEFINITION_CONTEXT__EVENT;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == MType.class)
    {
      switch (baseFeatureID)
      {
        case GcorePackage.MTYPE__SPECIALIZATION: return GcorePackage.MCLASSIFIER__SPECIALIZATION;
        default: return -1;
      }
    }
    if (baseClass == MDefinitionContext.class)
    {
      switch (baseFeatureID)
      {
        case GcorePackage.MDEFINITION_CONTEXT__CLASSIFIER: return GcorePackage.MCLASSIFIER__CLASSIFIER;
        case GcorePackage.MDEFINITION_CONTEXT__OWNED_BEHAVIOR: return GcorePackage.MCLASSIFIER__OWNED_BEHAVIOR;
        case GcorePackage.MDEFINITION_CONTEXT__GUARD: return GcorePackage.MCLASSIFIER__GUARD;
        case GcorePackage.MDEFINITION_CONTEXT__EVENT: return GcorePackage.MCLASSIFIER__EVENT;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(", abstract: ");
    result.append(abstract_);
    result.append(", final: ");
    result.append(final_);
    result.append(')');
    return result.toString();
  }

} //MClassifierImpl
