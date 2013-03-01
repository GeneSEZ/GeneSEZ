/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.genesez.metamodel.gpresentation.GpresentationPackage;
import org.genesez.metamodel.gpresentation.PAbstractArea;
import org.genesez.metamodel.gpresentation.PCompositeArea;
import org.genesez.metamodel.gpresentation.PContentArea;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PComposite Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.impl.PCompositeAreaImpl#getOwningArea <em>Owning Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCompositeAreaImpl extends PAbstractAreaImpl implements PCompositeArea
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PCompositeAreaImpl()
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
		return GpresentationPackage.Literals.PCOMPOSITE_AREA;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PAbstractArea getOwningArea()
  {
		if (eContainerFeatureID() != GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA) return null;
		return (PAbstractArea)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA, msgs);
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
			case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA:
				return eBasicSetContainer(null, GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA, msgs);
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
			case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA:
				return eInternalContainer().eInverseRemove(this, GpresentationPackage.PABSTRACT_AREA__NESTED_CONTENTS, PAbstractArea.class, msgs);
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
			case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA:
				return getOwningArea();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA:
				return getOwningArea() != null;
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
		if (baseClass == PContentArea.class) {
			switch (derivedFeatureID) {
				case GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA: return GpresentationPackage.PCONTENT_AREA__OWNING_AREA;
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
		if (baseClass == PContentArea.class) {
			switch (baseFeatureID) {
				case GpresentationPackage.PCONTENT_AREA__OWNING_AREA: return GpresentationPackage.PCOMPOSITE_AREA__OWNING_AREA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //PCompositeAreaImpl
