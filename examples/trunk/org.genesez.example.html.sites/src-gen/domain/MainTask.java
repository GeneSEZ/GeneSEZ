package domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8a7027a_1346831146062_677258_1657) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * A main task is a container to further divide the work into smaller pieces.
 * @author nicher
 */
public class MainTask extends Task implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		TASK
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores associated objects of association TASK to Task */
	private java.util.Set<Task> task = new java.util.HashSet<Task>();
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetActual</b></em>'
	 */
	private Duration getTimeBudgetActual() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_1_8a7027a_1346831146092_130431_1763) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetActual'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetActual' is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	// initialization block for association management objects
	{
		association.put(Associations.TASK, new ManyAssociation<MainTask, Task>(this, task, Task.Associations.MAINTASK));
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
	 * Provides access to the association '<em><b>task</b></em>' to {@link Task}.
	 */
	@SuppressWarnings("unchecked")
	public Association<MainTask, Task> task() {
		return (Association<MainTask, Task>) association.get(Associations.TASK);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8a7027a_1346831146062_677258_1657) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
