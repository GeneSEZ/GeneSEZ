package MyPlugin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;







import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.PresentationElementsManager;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.DiagramSurface;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram;

class ActionZeichenflaecheAendern extends MDAction
{
	int value;
	int size = 2;
	int id;
	DiagramPresentationElement test;

	public ActionZeichenflaecheAendern(String id, String name, int value)
	{
		super(id, name, null, null);
		this.value = value;

		
	}


	public void actionPerformed(ActionEvent e)
	{
		Project project = Application.getInstance().getProject();
		test = project.getActiveDiagram();
			
		Random random = new Random();
		
		if(value == 1)
		{
			test.setZoom(size);
			if(size ==2)
			{
			size = 1;
			}
			else
			{
			size = 2;
			}
		}
		
		if(value == 2)
		{
			test.setLineColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
		}
		if(value == 3)
		{
			test.close();
		}

		}
		
	}
