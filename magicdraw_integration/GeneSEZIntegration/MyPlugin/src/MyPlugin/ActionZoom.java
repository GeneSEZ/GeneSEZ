package MyPlugin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;

public class ActionZoom extends MDAction
{

	private String value;
	DiagramPresentationElement test;

	public ActionZoom(String value) 
	{
		super(value, "Zoom", null, null);
		this.value = value;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		test = Application.getInstance().getProject().getActiveDiagram();
		
		if(value.equals("+"))
		{
			test.setZoom((float) (0.2+test.getZoom()));
		}
		else
		{
			test.setZoom((float) (test.getZoom()-0.2));
		}
		

	}

}
