package MyPlugin;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.MDAction;

import java.util.Iterator;


public class Toolbar implements AMConfigurator
{
	private MDAction action;


	public Toolbar(MDAction action)
	{
		this.action = action;
	}


	public void configure(ActionsManager manager)
	{
		for (Iterator<ActionsCategory> iterator = manager.getCategories().iterator(); iterator.hasNext();)
		{
			ActionsCategory category = iterator.next();
			
			if (category.getID().equals(ActionsID.FILE))
			{
				category.addAction(action);
			}
		}
	}

	
	public int getPriority()
	{
		return AMConfigurator.MEDIUM_PRIORITY;
	}

}