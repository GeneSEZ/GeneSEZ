/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows to structure the model logically.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getXmiGuid <em>Xmi Guid</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getRoots <em>Roots</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getOwningPackage <em>Owning Package</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getNestedPackages <em>Nested Packages</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PPackage#getMetaData <em>Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage()
 * @model
 * @generated
 */
public interface PPackage extends EObject
{
  /**
   * Returns the value of the '<em><b>Xmi Guid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xmi Guid</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xmi Guid</em>' attribute.
   * @see #setXmiGuid(String)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_XmiGuid()
   * @model required="true"
   * @generated
   */
  String getXmiGuid();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PPackage#getXmiGuid <em>Xmi Guid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xmi Guid</em>' attribute.
   * @see #getXmiGuid()
   * @generated
   */
  void setXmiGuid(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PPackage#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Roots</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gpresentation.PRoot}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PRoot#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Roots</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Roots</em>' containment reference list.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_Roots()
   * @see org.genesez.metamodel.gpresentation.PRoot#getOwningPackage
   * @model opposite="owningPackage" containment="true"
   * @generated
   */
  EList<PRoot> getRoots();

  /**
   * Returns the value of the '<em><b>Owning Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PPackage#getNestedPackages <em>Nested Packages</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owning Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owning Package</em>' container reference.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_OwningPackage()
   * @see org.genesez.metamodel.gpresentation.PPackage#getNestedPackages
   * @model opposite="nestedPackages" required="true" transient="false" changeable="false"
   * @generated
   */
  PPackage getOwningPackage();

  /**
   * Returns the value of the '<em><b>Nested Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gpresentation.PPackage}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PPackage#getOwningPackage <em>Owning Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Packages</em>' containment reference list.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_NestedPackages()
   * @see org.genesez.metamodel.gpresentation.PPackage#getOwningPackage
   * @model opposite="owningPackage" containment="true"
   * @generated
   */
  EList<PPackage> getNestedPackages();

  /**
   * Returns the value of the '<em><b>Meta Data</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gpresentation.PMetaData}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PMetaData#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Meta Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Meta Data</em>' containment reference list.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPPackage_MetaData()
   * @see org.genesez.metamodel.gpresentation.PMetaData#getContainer
   * @model opposite="container" containment="true"
   * @generated
   */
  EList<PMetaData> getMetaData();

} // PPackage
