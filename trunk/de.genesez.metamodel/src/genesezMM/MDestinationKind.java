/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>MDestination Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see genesezMM.GenesezMMPackage#getMDestinationKind()
 * @model
 * @generated
 */
public final class MDestinationKind extends AbstractEnumerator
{
  /**
   * The '<em><b>On Entry</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Entry</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_ENTRY_LITERAL
   * @model name="onEntry"
   * @generated
   * @ordered
   */
  public static final int ON_ENTRY = 1;

  /**
   * The '<em><b>On Exit</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Exit</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_EXIT_LITERAL
   * @model name="onExit"
   * @generated
   * @ordered
   */
  public static final int ON_EXIT = 2;

  /**
   * The '<em><b>On Exception</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>On Exception</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ON_EXCEPTION_LITERAL
   * @model name="onException"
   * @generated
   * @ordered
   */
  public static final int ON_EXCEPTION = 3;

  /**
   * The '<em><b>Around</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Around</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AROUND_LITERAL
   * @model name="around"
   * @generated
   * @ordered
   */
  public static final int AROUND = 4;

  /**
   * The '<em><b>External</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>External</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXTERNAL_LITERAL
   * @model name="external"
   * @generated
   * @ordered
   */
  public static final int EXTERNAL = 5;

  /**
   * The '<em><b>On Entry</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_ENTRY
   * @generated
   * @ordered
   */
  public static final MDestinationKind ON_ENTRY_LITERAL = new MDestinationKind(ON_ENTRY, "onEntry", "onEntry");

  /**
   * The '<em><b>On Exit</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_EXIT
   * @generated
   * @ordered
   */
  public static final MDestinationKind ON_EXIT_LITERAL = new MDestinationKind(ON_EXIT, "onExit", "onExit");

  /**
   * The '<em><b>On Exception</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ON_EXCEPTION
   * @generated
   * @ordered
   */
  public static final MDestinationKind ON_EXCEPTION_LITERAL = new MDestinationKind(ON_EXCEPTION, "onException", "onException");

  /**
   * The '<em><b>Around</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AROUND
   * @generated
   * @ordered
   */
  public static final MDestinationKind AROUND_LITERAL = new MDestinationKind(AROUND, "around", "around");

  /**
   * The '<em><b>External</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTERNAL
   * @generated
   * @ordered
   */
  public static final MDestinationKind EXTERNAL_LITERAL = new MDestinationKind(EXTERNAL, "external", "external");

  /**
   * An array of all the '<em><b>MDestination Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final MDestinationKind[] VALUES_ARRAY =
    new MDestinationKind[]
    {
      ON_ENTRY_LITERAL,
      ON_EXIT_LITERAL,
      ON_EXCEPTION_LITERAL,
      AROUND_LITERAL,
      EXTERNAL_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>MDestination Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

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
      case ON_ENTRY: return ON_ENTRY_LITERAL;
      case ON_EXIT: return ON_EXIT_LITERAL;
      case ON_EXCEPTION: return ON_EXCEPTION_LITERAL;
      case AROUND: return AROUND_LITERAL;
      case EXTERNAL: return EXTERNAL_LITERAL;
    }
    return null;
  }

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private MDestinationKind(int value, String name, String literal)
  {
    super(value, name, literal);
  }

} //MDestinationKind
