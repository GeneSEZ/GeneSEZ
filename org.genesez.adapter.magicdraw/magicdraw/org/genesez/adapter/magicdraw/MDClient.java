package org.genesez.adapter.magicdraw;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;
import javax.security.auth.login.LoginException;
import net.ser1.stomp.Client;
import net.ser1.stomp.Listener;


/**
 *  Represents a client, which receives messages and executes commands
 * 
 */
public class MDClient extends Client
{
	PresentationElementReseter presentationElementReseter = new PresentationElementReseter();
	IssueHandler issueHandler = new IssueHandler();
	
	public MDClient() throws IOException, LoginException 
	{
		super("localhost", 12345, null, null);
		
		
		//instructions to respond to an issue
		this.subscribe("/validation", new Listener() 
		{
			public void message(Map headers, String issuePropertyAsString) 
			{
				//Stores information about issue (message, severity, ID)
				Properties issueProperty = new Properties();

				//"unpacks" the Property
				try {issueProperty.load(new StringReader(issuePropertyAsString));} 
					catch (IOException e) {e.printStackTrace();}
				
				issueHandler.handleIssue(issueProperty, presentationElementReseter);
			}
		});
	}
	
	
	public PresentationElementReseter getPresentationElementReseter() 
	{
		return presentationElementReseter;
	}
}