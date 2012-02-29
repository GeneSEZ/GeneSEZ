package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231922872125_629926_385) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Represents an enclosed huge task which can be divided into several tasks 
 * and has a clear outcome.
 * @author	dreamer
 */
public class Project implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		MILESTONE, TASK
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.MILESTONE, new ManyAssociation<Project, Milestone>(this, new LinkedHashSet<Milestone>(), Milestone.Associations.PROJECT));
		association.put(Associations.TASK, new ManyAssociation<Project, Task>(this, new LinkedHashSet<Task>(), Task.Associations.PROJECT));
	}
	/**
	 * @generated	attribute definition
	 */
	private String name;
	/**
	 * @generated	attribute definition
	 */
	private String description;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * documented here {@link getName()}
	 * @generated	setter method for the attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>description</b></em>'
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * documented here {@link getDescription()}
	 * @generated	setter method for the attribute '<em><b>description</b></em>'
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
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
	 * @generated	accessor of the association '<em><b>milestone</b></em>' to {@link Milestone}
	 */
	@SuppressWarnings("unchecked")
	public Association<Project, Milestone> milestone() {
		return (Association<Project, Milestone>) association.get(Associations.MILESTONE);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>task</b></em>' to {@link Task}
	 */
	@SuppressWarnings("unchecked")
	public Association<Project, Task> task() {
		return (Association<Project, Task>) association.get(Associations.TASK);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922872125_629926_385) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
