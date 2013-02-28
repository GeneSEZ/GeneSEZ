/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gpresentation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAbstract Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Allows to build a structure of areas.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gpresentation.PAbstractArea#getName <em>Name</em>}</li>
 *   <li>{@link org.genesez.metamodel.gpresentation.PAbstractArea#getNestedContents <em>Nested Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPAbstractArea()
 * @model abstract="true"
 * @generated
 */
public interface PAbstractArea extends PMetaDataAware
{
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
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPAbstractArea_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.gpresentation.PAbstractArea#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Nested Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gpresentation.PContentArea}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gpresentation.PContentArea#getOwningArea <em>Owning Area</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Contents</em>' containment reference list.
   * @see org.genesez.metamodel.gpresentation.GpresentationPackage#getPAbstractArea_NestedContents()
   * @see org.genesez.metamodel.gpresentation.PContentArea#getOwningArea
   * @model opposite="owningArea" containment="true"
   * @generated
   */
  EList<PContentArea> getNestedContents();

} // PAbstractArea
