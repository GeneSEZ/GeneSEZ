package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231922894109_139661_427) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A main task is a container to further divide the work into smaller pieces.
 * @author	dreamer
 */
public class MainTask extends Task implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		TASK
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.TASK, new ManyAssociation<MainTask, Task>(this, new LinkedHashSet<Task>(), Task.Associations.MAINTASK));
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>timeBudgetActual</b></em>'
	 */
	private Duration getTimeBudgetActual() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_b6f02e1_1231923287265_436300_572) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetActual'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetActual' is missing!");
		/* PROTECTED REGION END */
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
	 * @generated	accessor of the association '<em><b>task</b></em>' to {@link Task}
	 */
	@SuppressWarnings("unchecked")
	public Association<MainTask, Task> task() {
		return (Association<MainTask, Task>) association.get(Associations.TASK);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922894109_139661_427) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
