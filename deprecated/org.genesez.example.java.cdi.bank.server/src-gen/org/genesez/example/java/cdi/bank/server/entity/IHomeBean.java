package org.genesez.example.java.cdi.bank.server.entity;

/* PROTECTED REGION ID(org.genesez.example.java.cdi.bank.server.entity._16_0_1_41601a3_1267462981134_570566_486.IHomeBean_Imports) ENABLED START */
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

import org.genesez.example.java.cdi.bank.server.IEntityBase;

/* PROTECTED REGION END */

public interface IHomeBean<T extends IEntityBase, E extends EntityManager> extends Serializable {
	
	/**
	 * Returns the instance of the bean. If no instance exists, but an id is set,
	 * the instance will be read from the database. If no id is set, a new instance will be created.
	 * 
	 * @return An instance of the bean.
	 */
	public T getInstance();
	
	/**
	 * Returns the primary key of the enity. 
	 * 
	 * @return The id of the entity.
	 */
	public long getId();
	
	/**
	 * Sets the id (primaray key of the entity)
	 *  
	 * @param id
	 */
	public void setId(long id);
	
	/**
	 * Loads an instance of the bean from the database with its id.
	 * 
	 * @return The bean instance.
	 */
	public T loadInstance();
	
	/**
	 * Creates a new instance.
	 * 
	 * @return The new bean instance.
	 */
	public T createInstance();
	
	/**
	 * Returnd true if the bean has been persisted (if it is managed by the entity manager).
	 * 
	 * @return true if managed by the entity manager, else false.
	 */
	public boolean isManaged();
	
	/**
	 * Saves a bean in the database.
	 * 
	 * @return String "saved"
	 */
	public String save();
	
	/**
	 * Deletes an object from the database.
	 * 
	 * @return String "deleted"
	 */
	public String delete();
	
	/**
	 * Stopps the conversation.
	 * 
	 * @return String "cancelled"
	 */
	public String cancel();
	
	/**
	 * Starts the conversation
	 */
	public void initConversation();
	
	/**
	 * Ends the conversation
	 */
	public void endConversation();
	
	/**
	 * @return the conversation id
	 */
	public String getConversationId();
	
	/**
	 * Returns all objects of the type T.
	 * @return list of all objects
	 */
	public List<T> getList();
	
	/* PROTECTED REGION ID(org.genesez.example.java.cdi.bank.server.entity._16_0_1_41601a3_1267462981134_570566_486.IHomeBean_OwnCodeImpl) ENABLED START */
	/* TODO: put your own source code here */
	/* PROTECTED REGION END */
	
}
