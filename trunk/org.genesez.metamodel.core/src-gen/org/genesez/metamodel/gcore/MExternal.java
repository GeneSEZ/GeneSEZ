/**
 */
package org.genesez.metamodel.gcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MExternal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.gcore.MExternal#getModel <em>Model</em>}</li>
 *   <li>{@link org.genesez.metamodel.gcore.MExternal#getGenericParameter <em>Generic Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.gcore.GcorePackage#getMExternal()
 * @model
 * @generated
 */
public interface MExternal extends MType, MElement
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MModel#getExternalTypes <em>External Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMExternal_Model()
   * @see org.genesez.metamodel.gcore.MModel#getExternalTypes
   * @model opposite="externalTypes" required="true" transient="false" changeable="false"
   * @generated
   */
  MModel getModel();

  /**
   * Returns the value of the '<em><b>Generic Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.gcore.MGeneric}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.gcore.MGeneric#getOwningExternal <em>Owning External</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generic Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generic Parameter</em>' containment reference list.
   * @see org.genesez.metamodel.gcore.GcorePackage#getMExternal_GenericParameter()
   * @see org.genesez.metamodel.gcore.MGeneric#getOwningExternal
   * @model opposite="owningExternal" containment="true"
   * @generated
   */
  EList<MGeneric> getGenericParameter();

} // MExternal
