package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;
import java.util.Date;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231922886578_724134_407) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Represents a step within a project that has to be completet.
 * @author	dreamer
 */
public class Milestone implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		PROJECT, TASK
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.PROJECT, new OneAssociation<Milestone, Project>(this, Project.Associations.MILESTONE));
		association.put(Associations.TASK, new ManyAssociation<Milestone, Task>(this, new LinkedHashSet<Task>(), Task.Associations.MILESTONE));
	}
	/**
	 * @generated	attribute definition
	 */
	private String name;
	/**
	 * @generated	attribute definition
	 */
	private String description;
	/**
	 * @generated	attribute definition
	 */
	private State state = State.TODO;
	/**
	 * @generated	attribute definition
	 */
	private Date deadline;
	
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
	 * @generated	getter for the attribute '<em><b>state</b></em>'
	 */
	public State getState() {
		return state;
	}
	
	/**
	 * documented here {@link getState()}
	 * @generated	setter method for the attribute '<em><b>state</b></em>'
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>deadline</b></em>'
	 */
	public Date getDeadline() {
		return deadline;
	}
	
	/**
	 * documented here {@link getDeadline()}
	 * @generated	setter method for the attribute '<em><b>deadline</b></em>'
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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
	 * @generated	accessor of the association '<em><b>project</b></em>' to {@link Project}
	 */
	@SuppressWarnings("unchecked")
	public Association<Milestone, Project> project() {
		return (Association<Milestone, Project>) association.get(Associations.PROJECT);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>task</b></em>' to {@link Task}
	 */
	@SuppressWarnings("unchecked")
	public Association<Milestone, Task> task() {
		return (Association<Milestone, Task>) association.get(Associations.TASK);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922886578_724134_407) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
