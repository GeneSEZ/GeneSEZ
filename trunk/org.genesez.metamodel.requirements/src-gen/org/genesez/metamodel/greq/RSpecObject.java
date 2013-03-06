/**
 */
package org.genesez.metamodel.greq;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RSpec Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a specification object.
 * A specification object is general construct to group common properties of specification descriptions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getId <em>Id</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getVersion <em>Version</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getUrl <em>Url</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.genesez.metamodel.greq.RSpecObject#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject()
 * @model abstract="true"
 * @generated
 */
public interface RSpecObject extends EObject
{
  /**
   * Returns the value of the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * A short but meaningful objective of the specification object.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Definition</em>' attribute.
   * @see #setDefinition(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Definition()
   * @model required="true"
   * @generated
   */
  String getDefinition();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RSpecObject#getDefinition <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' attribute.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(String value);

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The unique identifier of the specification object with repect to this model but not globally unique.
   * It means that objects of every specialized class can be uniquely identified, but not objects accross more specializations (globally unique).
   * <!-- end-model-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Id()
   * @model required="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RSpecObject#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The version of the specification object is usually the date of the last modification or a requirement model global change indicating number like the version number in the subversion version control system.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Version()
   * @model required="true"
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RSpecObject#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The URL to the corresponding specification item in the requirements management tool.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Url</em>' attribute.
   * @see #setUrl(String)
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Url()
   * @model
   * @generated
   */
  String getUrl();

  /**
   * Sets the value of the '{@link org.genesez.metamodel.greq.RSpecObject#getUrl <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url</em>' attribute.
   * @see #getUrl()
   * @generated
   */
  void setUrl(String value);

  /**
   * Returns the value of the '<em><b>Annotation</b></em>' reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RAnnotation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of all annotations assigned to this specification object.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Annotation</em>' reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Annotation()
   * @model
   * @generated
   */
  EList<RAnnotation> getAnnotation();

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference list.
   * The list contents are of type {@link org.genesez.metamodel.greq.RValue}.
   * It is bidirectional and its opposite is '{@link org.genesez.metamodel.greq.RValue#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Contains a list of all values this specification object is annotated with.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Value</em>' containment reference list.
   * @see org.genesez.metamodel.greq.GreqPackage#getRSpecObject_Value()
   * @see org.genesez.metamodel.greq.RValue#getObject
   * @model opposite="object" containment="true"
   * @generated
   */
  EList<RValue> getValue();

} // RSpecObject
