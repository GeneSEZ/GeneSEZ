/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.genesez.metamodel.gcore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>MDestination Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.genesez.metamodel.gcore.GcorePackage#getMDestinationKind()
 * @model
 * @generated
 */
public enum MDestinationKind implements Enumerator
{
  /**
   * The '<em><b>On Entry</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_ENTRY_VALUE
   * @generated
   * @ordered
   */
  ON_ENTRY(1, "onEntry", "onEntry"),

  /**
   * The '<em><b>On Exit</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_EXIT_VALUE
   * @generated
   * @ordered
   */
  ON_EXIT(2, "onExit", "onExit"),

  /**
   * The '<em><b>On Exception</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_EXCEPTION_VALUE
   * @generated
   * @ordered
   */
  ON_EXCEPTION(3, "onException", "onException"),

  /**
   * The '<em><b>Around</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AROUND_VALUE
   * @generated
   * @ordered
   */
  AROUND(4, "around", "around"),

  /**
   * The '<em><b>External</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTERNAL_VALUE
   * @generated
   * @ordered
   */
  EXTERNAL(5, "external", "external");

  /**
   * The '<em><b>On Entry</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Entry</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_ENTRY
   * @model name="onEntry"
   * @generated
   * @ordered
   */
  public static final int ON_ENTRY_VALUE = 1;

  /**
   * The '<em><b>On Exit</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Exit</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_EXIT
   * @model name="onExit"
   * @generated
   * @ordered
   */
  public static final int ON_EXIT_VALUE = 2;

  /**
   * The '<em><b>On Exception</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Exception</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_EXCEPTION
   * @model name="onException"
   * @generated
   * @ordered
   */
  public static final int ON_EXCEPTION_VALUE = 3;

  /**
   * The '<em><b>Around</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Around</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AROUND
   * @model name="around"
   * @generated
   * @ordered
   */
  public static final int AROUND_VALUE = 4;

  /**
   * The '<em><b>External</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>External</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXTERNAL
   * @model name="external"
   * @generated
   * @ordered
   */
  public static final int EXTERNAL_VALUE = 5;

  /**
   * An array of all the '<em><b>MDestination Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MDestinationKind[] VALUES_ARRAY =
    new MDestinationKind[]
    {
      ON_ENTRY,
      ON_EXIT,
      ON_EXCEPTION,
      AROUND,
      EXTERNAL,
    };

  /**
   * A public read-only list of all the '<em><b>MDestination Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<MDestinationKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>MDestination Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MDestinationKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MDestinationKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>MDestination Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MDestinationKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      MDestinationKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>MDestination Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MDestinationKind get(int value)
  {
    switch (value)
    {
      case ON_ENTRY_VALUE: return ON_ENTRY;
      case ON_EXIT_VALUE: return ON_EXIT;
      case ON_EXCEPTION_VALUE: return ON_EXCEPTION;
      case AROUND_VALUE: return AROUND;
      case EXTERNAL_VALUE: return EXTERNAL;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private MDestinationKind(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //MDestinationKind
