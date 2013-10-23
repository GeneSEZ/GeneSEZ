package MyPlugin;


import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDActionsCategory;


public class MainMenue implements AMConfigurator
{
  private NMAction action;
  
  public MainMenue(NMAction action)
  {
    this.action = action;
  }


  public void configure(ActionsManager manager)
  {
    ActionsCategory category = (ActionsCategory)manager.getActionFor("Plugin");

    if (category == null)
    {
      category = new MDActionsCategory("Plugin", "Plugin");
      category.setNested(true);
      manager.addCategory(category);
    }
    
    category.addAction(this.action);
  }

  public int getPriority() 
  { 
	  return 10; 
}

}