/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package genesezMM.validation;

import genesezMM.MAssociation;
import genesezMM.MAssociationRole;

/**
 * A sample validator interface for {@link genesezMM.MAssociationRole}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MAssociationRoleValidator
{
  boolean validate();

  boolean validateAggregation(boolean value);
  boolean validateComposition(boolean value);
  boolean validateAssociation(MAssociation value);
  boolean validateOpposite(MAssociationRole value);
}
