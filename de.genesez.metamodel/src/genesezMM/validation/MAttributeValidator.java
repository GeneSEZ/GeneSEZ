/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.validation;


/**
 * A sample validator interface for {@link genesezMM.MAttribute}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MAttributeValidator
{
  boolean validate();

  boolean validateDefaultvalue(String value);
  boolean validateStatic(boolean value);
  boolean validateFinal(boolean value);
}
