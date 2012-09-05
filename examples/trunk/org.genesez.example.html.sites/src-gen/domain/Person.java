package domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8a7027a_1346831146061_327596_1655) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author nicher
 */
public class Person implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		SUBTASK
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores associated objects of association SUBTASK to SubTask as keys and the association class objects as values */
	private LinkedHashMap<SubTask, TimeBudget> subTask = new LinkedHashMap<SubTask, TimeBudget>();
	
	private String name;
	
	private String password;
	
	// -- generated association + attribute accessors -----------------------
	// initialization block for association management objects
	{
		association.put(Associations.SUBTASK, new ManyAssociationAC<Person, SubTask, TimeBudget>(this, subTask, SubTask.Associations.PERSON));
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
	 * Provides access to the association '<em><b>subTask</b></em>' to {@link SubTask}.
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<Person, SubTask, TimeBudget> subTask() {
		return (AssociationAC<Person, SubTask, TimeBudget>) association.get(Associations.SUBTASK);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8a7027a_1346831146061_327596_1655) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
