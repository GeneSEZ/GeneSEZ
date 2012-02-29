package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231922905218_820951_467) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A task represents an enclosed task with a defined outcome, which has to be 
 * completed within a planned amount of time.
 * @author	dreamer
 */
public abstract class Task implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		PROJECT, MILESTONE, MAINTASK
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.PROJECT, new OneAssociation<Task, Project>(this, Project.Associations.TASK));
		association.put(Associations.MILESTONE, new OneAssociation<Task, Milestone>(this, Milestone.Associations.TASK));
		association.put(Associations.MAINTASK, new OneAssociation<Task, MainTask>(this, MainTask.Associations.TASK));
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
	private State state;
	/**
	 * @generated	attribute definition
	 */
	private Duration timeBudgetPlanned;
	
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
	 * @generated	getter for the attribute '<em><b>timeBudgetPlanned</b></em>'
	 */
	public Duration getTimeBudgetPlanned() {
		return timeBudgetPlanned;
	}
	
	/**
	 * documented here {@link getTimeBudgetPlanned()}
	 * @generated	setter method for the attribute '<em><b>timeBudgetPlanned</b></em>'
	 */
	public void setTimeBudgetPlanned(Duration timeBudgetPlanned) {
		this.timeBudgetPlanned = timeBudgetPlanned;
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
	public Association<Task, Project> project() {
		return (Association<Task, Project>) association.get(Associations.PROJECT);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>milestone</b></em>' to {@link Milestone}
	 */
	@SuppressWarnings("unchecked")
	public Association<Task, Milestone> milestone() {
		return (Association<Task, Milestone>) association.get(Associations.MILESTONE);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>mainTask</b></em>' to {@link MainTask}
	 */
	@SuppressWarnings("unchecked")
	public Association<Task, MainTask> mainTask() {
		return (Association<Task, MainTask>) association.get(Associations.MAINTASK);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922905218_820951_467) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
