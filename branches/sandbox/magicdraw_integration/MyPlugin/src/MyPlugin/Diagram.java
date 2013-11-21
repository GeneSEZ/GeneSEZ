package MyPlugin;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.DiagramContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.ui.actions.DefaultDiagramAction;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;


public class Diagram implements DiagramContextAMConfigurator, AMConfigurator
{
	private ActionKlasseErstellenAusgeben action;
	

	public Diagram(ActionKlasseErstellenAusgeben action3)
	{
		this.action = action3;
	}
	

	public void configure(ActionsManager manager,DiagramPresentationElement diagram,PresentationElement[] selected,	PresentationElement requestor)
	{
		ActionsCategory category = new MDActionsCategory(null, null);
		category.addAction(action);
		manager.addCategory(category);
	}
	
	
	public int getPriority()
	{
		return AMConfigurator.MEDIUM_PRIORITY;
	}

	
	public void configure(ActionsManager manager)
	{
		if( manager.getActionFor(action.getID())==null)
		{
			ActionsCategory category = (ActionsCategory) manager.getActionFor( ActionsID.CLASS_DIAGRAM_ELEMENTS);
			if(category != null )
			{
				category.addAction(action);
			}
		}
	}
	


}
