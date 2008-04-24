/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.genesez.metamodel.genesezMM.validation;

import de.genesez.metamodel.genesezMM.MAspect;
import de.genesez.metamodel.genesezMM.MDestinationKind;

/**
 * A sample validator interface for {@link de.genesez.metamodel.genesezMM.MPointcut}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MPointcutValidator
{
  boolean validate();

  boolean validateDomain(String value);
  boolean validateName(String value);
  boolean validateDestination(MDestinationKind value);
  boolean validateOrigin(MAspect value);
}
