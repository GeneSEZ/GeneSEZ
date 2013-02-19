package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231922899375_849662_447) 
 */
import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Represents an enclosed unit of work to work on.
 */
public class SubTask extends Task implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		PERSON
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores associated objects of association PERSON to Person as keys and the association class objects as values */
	private LinkedHashMap<Person, TimeBudget> person = new LinkedHashMap<Person, TimeBudget>();
	
	// initialization block for association management objects
	{
		association.put(Associations.PERSON, new ManyAssociationAC<SubTask, Person, TimeBudget>(this, person, Person.Associations.SUBTASK));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * Provides access to the association '<em><b>person</b></em>' to {@link Person}.
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<SubTask, Person, TimeBudget> person() {
		return (AssociationAC<SubTask, Person, TimeBudget>) association.get(Associations.PERSON);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922899375_849662_447) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
