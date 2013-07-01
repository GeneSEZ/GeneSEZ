package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(Bank_Tutorial_Weld_Server.bankgroupServer.entity._16_0_1_41601a3_1267462905086_648269_462.ConversationAdmin_Imports) ENABLED START */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/* PROTECTED REGION END */

@Named
@SessionScoped
public class ConversationAdmin implements Serializable {
	
	private java.util.List<String> conversationList = new java.util.ArrayList<String>();
	
	/**
	 * returns if a conversation is currently running
	 * @return  
	 */
	@Named("isConversationRunning")
	@Produces
	public boolean isConversationRunning() {
		return (getConversationList().size() > 0);
	}
	
	/**
	 * removes a conversation from the list
	 * @param   id  
	 */
	public void removeConversation(String id) {
		if (conversationList != null) {
			conversationList.remove(id);
		}
		
	}
	
	/**
	 * returns the last conversation id
	 * @return  
	 */
	@Named("currentConversationId")
	@Produces
	public String getLastConversationId() {
		String id = "";
		if (conversationList != null && conversationList.size() > 0)
			id = conversationList.get(conversationList.size() - 1);
		return id;
	}
	
	/**
	 * getter for the attribute '<em><b>conversationList</b></em>'
	 */
	public java.util.List<String> getConversationList() {
		return conversationList;
	}
	
	/* PROTECTED REGION ID(Bank_Tutorial_Weld_Server.bankgroupServer.entity._16_0_1_41601a3_1267462905086_648269_462.ConversationAdmin_OwnCodeImpl) ENABLED START */
	/* TODO: put your own source code here */
	/* PROTECTED REGION END */
}
