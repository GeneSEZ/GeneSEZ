/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.validation;

import de.genesez.metamodel.genesezMM.MEnumeration;

/**
 * A sample validator interface for {@link de.genesez.metamodel.genesezMM.MLiteral}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MLiteralValidator
{
  boolean validate();

  boolean validateOwningEnumeration(MEnumeration value);
}
