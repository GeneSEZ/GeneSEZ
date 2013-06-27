package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231922905218_820951_467) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * A task represents an enclosed task with a defined outcome, which has to be 
 * completed within a planned amount of time.
 * @author nicher
 */
public abstract class Task implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		PROJECT, MILESTONE, MAINTASK
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association PROJECT to Project */
	private Project project;
	
	/** Stores the associated object of association MILESTONE to Milestone */
	private Milestone milestone;
	
	/** Stores the associated object of association MAINTASK to MainTask */
	private MainTask mainTask;
	
	private String name;
	
	private String description;
	
	private State state;
	
	private Duration timeBudgetPlanned;
	
	// -- generated association + attribute accessors -----------------------
	// initialization block for association management objects
	{
		association.put(Associations.PROJECT, new OneAssociation<Task, Project>(this, new Accessor<Project>() {
			public Project get() {
				return project;
			}
			
			public void set(Project referenced) {
				project = referenced;
			}
		}, Project.Associations.TASK));
		association.put(Associations.MILESTONE, new OneAssociation<Task, Milestone>(this, new Accessor<Milestone>() {
			public Milestone get() {
				return milestone;
			}
			
			public void set(Milestone referenced) {
				milestone = referenced;
			}
		}, Milestone.Associations.TASK));
		association.put(Associations.MAINTASK, new OneAssociation<Task, MainTask>(this, new Accessor<MainTask>() {
			public MainTask get() {
				return mainTask;
			}
			
			public void set(MainTask referenced) {
				mainTask = referenced;
			}
		}, MainTask.Associations.TASK));
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
	 * Provides access to the association '<em><b>project</b></em>' to {@link Project}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Task, Project> project() {
		return (Association<Task, Project>) association.get(Associations.PROJECT);
	}
	
	/**
	 * Provides access to the association '<em><b>milestone</b></em>' to {@link Milestone}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Task, Milestone> milestone() {
		return (Association<Task, Milestone>) association.get(Associations.MILESTONE);
	}
	
	/**
	 * Provides access to the association '<em><b>mainTask</b></em>' to {@link MainTask}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Task, MainTask> mainTask() {
		return (Association<Task, MainTask>) association.get(Associations.MAINTASK);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231922905218_820951_467) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
