package MyPlugin;

import java.awt.event.ActionEvent;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;

public class ActionTest extends MDAction
{
	
	public ActionTest(String id, String name) 
	{
		super(id, name, null, null);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		//Application.getInstance().getEnvironmentOptions().getGeneralOptions()
	}
}
