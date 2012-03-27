package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231922872125_629926_385) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Represents an enclosed huge task which can be divided into several tasks 
 * and has a clear outcome.
 * @author nicher
 */
public class Project implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		MILESTONE, TASK
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores associated objects of association MILESTONE to Milestone */
	private java.util.Set<Milestone> milestone = new java.util.HashSet<Milestone>();
	
	/** Stores associated objects of association TASK to Task */
	private java.util.Set<Task> task = new java.util.HashSet<Task>();
	
	private String name;
	
	private String description;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>description</b></em>'
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the value of attribute '<em><b>description</b></em>'
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.MILESTONE, new ManyAssociation<Project, Milestone>(this, milestone, Milestone.Associations.PROJECT));
		association.put(Associations.TASK, new ManyAssociation<Project, Task>(this, task, Task.Associations.PROJECT));
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
	 * Provides access to the association '<em><b>milestone</b></em>' to {@link Milestone}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Project, Milestone> milestone() {
		return (Association<Project, Milestone>) association.get(Associations.MILESTONE);
	}
	
	/**
	 * Provides access to the association '<em><b>task</b></em>' to {@link Task}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Project, Task> task() {
		return (Association<Project, Task>) association.get(Associations.TASK);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922872125_629926_385) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
