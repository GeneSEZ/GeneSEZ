/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.gtrace;

import de.genesez.metamodel.gcore.MElement;

import de.genesez.metamodel.greq.RRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRequirement Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.genesez.metamodel.gtrace.TRequirementTrace#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link de.genesez.metamodel.gtrace.TRequirementTrace#getStructuralElement <em>Structural Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.genesez.metamodel.gtrace.GtracePackage#getTRequirementTrace()
 * @model
 * @generated
 */
public interface TRequirementTrace extends TTrace
{
  /**
   * Returns the value of the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement</em>' reference.
   * @see #setRequirement(RRequirement)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTRequirementTrace_Requirement()
   * @model required="true"
   * @generated
   */
  RRequirement getRequirement();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TRequirementTrace#getRequirement <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement</em>' reference.
   * @see #getRequirement()
   * @generated
   */
  void setRequirement(RRequirement value);

  /**
   * Returns the value of the '<em><b>Structural Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Structural Element</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Structural Element</em>' reference.
   * @see #setStructuralElement(MElement)
   * @see de.genesez.metamodel.gtrace.GtracePackage#getTRequirementTrace_StructuralElement()
   * @model required="true"
   * @generated
   */
  MElement getStructuralElement();

  /**
   * Sets the value of the '{@link de.genesez.metamodel.gtrace.TRequirementTrace#getStructuralElement <em>Structural Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Structural Element</em>' reference.
   * @see #getStructuralElement()
   * @generated
   */
  void setStructuralElement(MElement value);

} // TRequirementTrace
