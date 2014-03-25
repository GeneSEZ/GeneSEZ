package MyPlugin;

import java.awt.event.ActionEvent;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.uml.symbols.PresentationElementRendererManager;


public class ActionAussehenaendern extends MDAction
{
	private int value;

	
	public ActionAussehenaendern(String id, String name, int value)
	{
		super(id, name, null, null);
		this.value = value;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		PresentationElementRendererManager.getInstance().addProvider(new Darstellen(value));
	}
	
}

	



	