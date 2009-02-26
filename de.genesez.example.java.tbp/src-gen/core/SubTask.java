package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231922899375_849662_447) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Represents an enclosed unit of work to work on.
 * @author	dreamer
 */
public class SubTask extends Task implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		PERSON
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.PERSON, new ManyAssociationAC<SubTask, Person, TimeBudget>(this, new LinkedHashMap<Person, TimeBudget>(), Person.Associations.SUBTASK));
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * generic accessor for association objects used by the association handling framework
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>person</b></em>' to {@link Person}
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<SubTask, Person, TimeBudget> person() {
		return (AssociationAC<SubTask, Person, TimeBudget>) association.get(Associations.PERSON);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922899375_849662_447) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
