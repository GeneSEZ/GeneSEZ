package org.genesez.example.java.cdi.bank.server.entity;

/* PROTECTED REGION ID(org.genesez.example.java.cdi.bank.server.entity._16_0_1_41601a3_1267462981134_570566_486.HomeBean_Imports) ENABLED START */
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.genesez.example.java.cdi.bank.server.IEntityBase;

/* PROTECTED REGION END */

public abstract class HomeBean<T extends IEntityBase, E extends EntityManager> implements IHomeBean<T, E> {
	/**
	 * The default serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Conversation Object.
	 */
	@Inject
	private Conversation conversation;
	
	/**
	 * The conversation administration object of the session.
	 */
	@Inject
	private ConversationAdmin conversationAdmin;
	
	/**
	 * The primary key of the beans.
	 */
	private long id;
	
	/**
	 * The instance of the entity bean.
	 */
	private T instance;
	
	/**
	 * Returns the entity manager.
	 */
	abstract E getEntityManager();
	
	/**
	 * Returns the instance of the bean. If no instance exists, but an id is set,
	 * the instance will be read from the database. If no id is set, a new instance will be created.
	 * 
	 * @return An instance of the bean.
	 */
	public T getInstance() {
		if (instance == null) {
			if (id > 0) {
				instance = loadInstance();
			} else {
				instance = createInstance();
			}
		}
		return instance;
	}
	
	/**
	 * Returns the primary key of the enity. 
	 * 
	 * @return The id of the entity.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id (primaray key of the entity)
	 *  
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Loads an instance of the bean from the database with its id.
	 * 
	 * @return The bean instance.
	 */
	public T loadInstance() {
		return getEntityManager().find(getClassType(), new Long(getId()));
	}
	
	/**
	 * Creates a new instance.
	 * 
	 * @return The new bean instance.
	 */
	public T createInstance() {
		try {
			return getClassType().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Returns the class type of the bean.
	 * 
	 * @return The class type.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getClassType() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	/**
	 * Returnd true if the bean has been persisted (if it is managed by the entity manager).
	 * 
	 * @return true if managed by the entity manager, else false.
	 */
	public boolean isManaged() {
		return (this.id > 0 && this.id > 0);
	}
	
	/**
	 * Saves a bean in the database.
	 * 
	 * @return String "saved"
	 */
	public String save() {
		if (isManaged()) {
			getEntityManager().merge(getInstance());
		} else {
			getEntityManager().persist(getInstance());
		}
		endConversation();
		return "saved";
	}
	
	/**
	 * Deletes an object from the database.
	 * 
	 * @return String "deleted"
	 */
	public String delete() {
		getEntityManager().merge(getInstance());
		getEntityManager().remove(getInstance());
		endConversation();
		return "deleted";
	}
	
	/**
	 * Stopps the conversation.
	 * 
	 * @return String "cancelled"
	 */
	public String cancel() {
		endConversation();
		return "cancelled";
	}
	
	/**
	 * Starts the conversation
	 */
	public void initConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
			conversationAdmin.getConversationList().add(getConversationId());
		}
	}
	
	/**
	 * Ends the conversation
	 */
	public void endConversation() {
		if (!conversation.isTransient()) {
			conversationAdmin.removeConversation(getConversationId());
			conversation.end();
		}
	}
	
	/**
	 * @return the conversation id
	 */
	public String getConversationId() {
		return conversation.getId();
	}
	
	/**
	 * Returns all objects of the type T.
	 * @return list of all objects
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		getEntityManager().flush();
		return getEntityManager().createQuery("select OBJECT(o) from " + getClassType().getSimpleName() + " o").getResultList();
	}
	
	/* PROTECTED REGION ID(org.genesez.example.java.cdi.bank.server.entity._16_0_1_41601a3_1267462981134_570566_486.HomeBean_OwnCodeImpl) ENABLED START */
	/* TODO: put your own source code here */
	/* PROTECTED REGION END */
	
}
