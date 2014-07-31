/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MDependency#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MDependency#getSupplier <em>Supplier</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MDependency#getClient <em>Client</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMDependency()
 * @model
 * @generated
 */
public interface MDependency extends MElement
{
  /**
   * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MPackage#getOwnedDependency <em>Owned Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Package</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDependency_OwningPackage()
   * @see org.genesez.metamodel.gcore.MPackage#getOwnedDependency
   * @model opposite="ownedDependency" required="true" transient="false" changeable="false"
   * @generated
   */
  MPackage getOwningPackage();

  /**
   * Returns the value of the '<em><b>Supplier</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supplier</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supplier</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDependency_Supplier()
   * @model
   * @generated
   */
  EList<MElement> getSupplier();

  /**
   * Returns the value of the '<em><b>Client</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MElement}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MElement#getDependency <em>Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Client</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Client</em>' reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMDependency_Client()
   * @see org.genesez.metamodel.gcore.MElement#getDependency
   * @model opposite="dependency"
   * @generated
   */
  EList<MElement> getClient();

} // MDependency
