package MyPlugin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;










import com.nomagic.magicdraw.actions.ActionsGroups;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.PresentationElementsManager;
import com.nomagic.magicdraw.uml.symbols.DiagramPresentationElement;
import com.nomagic.magicdraw.uml.symbols.DiagramSurface;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Diagram;

class ActionProjektNameModelNameAnzeigen extends MDAction
{

	public ActionProjektNameModelNameAnzeigen(String id, String name)
	{
		super(id, name, null, null);
	
	}


	public void actionPerformed(ActionEvent e)
	{
		Project project = Application.getInstance().getProject();
	
		
		if(project != null)
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Das Projekt heiﬂt:" + project.getName() );
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Kein Projekt vorhanden");
		}
		
		
		if(project != null)
		{
			if(project.getActiveDiagram() != null)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Das ausgew‰hlte Diagramm heiﬂt:" + project.getActiveDiagram().getName());
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Kein Diagramm vorhanden");
			{
		}
		}
		}
	}
}