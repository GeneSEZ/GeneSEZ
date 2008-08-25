/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MExternal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gcore.MExternal#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MExternal#getModel <em>Model</em>}</li>
 *   <li>{@link de.genesez.metamodel.gcore.MExternal#getGenericParameter <em>Generic Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gcore.GcorePackage#getMExternal()
 * @model
 * @generated
 */
public interface MExternal extends MType
{
  /**
   * Returns the value of the '<em><b>Specification</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specification</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specification</em>' attribute.
   * @see #setSpecification(String)
   * @see de.genesez.metamodel.gcore.GcorePackage#getMExternal_Specification()
   * @model required="true"
   * @generated
   */
  String getSpecification();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gcore.MExternal#getSpecification <em>Specification</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Specification</em>' attribute.
   * @see #getSpecification()
   * @generated
   */
  void setSpecification(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMExternal_Model()
   * @see de.genesez.metamodel.gcore.MModel#getExternalTypes
   * @model opposite="externalTypes" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link de.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link de.genesez.metamodel.gcore.MGeneric#getOwningExternal <em>Owning External</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see de.genesez.metamodel.gcore.GcorePackage#getMExternal_GenericParameter()
   * @see de.genesez.metamodel.gcore.MGeneric#getOwningExternal
   * @model type="de.genesez.metamodel.gcore.MGeneric" opposite="owningExternal" containment="true"
   * @generated
   */
  EList getGenericParameter();

} // MExternal
