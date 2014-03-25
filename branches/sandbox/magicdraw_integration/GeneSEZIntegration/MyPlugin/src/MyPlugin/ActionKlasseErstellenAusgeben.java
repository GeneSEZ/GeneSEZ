package MyPlugin;


import java.awt.event.ActionEvent;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.impl.ElementsFactory;



class ActionKlasseErstellenAusgeben extends MDAction
{
	
	public ActionKlasseErstellenAusgeben(String id, String name)
	{
		super(id, name, null, null);
	}


	public void actionPerformed(ActionEvent e)
	{
		SessionManager.getInstance().createSession("ErstelleKlasse");
		
		ElementsFactory f = Application.getInstance().getProject().getElementsFactory();
		com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class classA = f.createClassInstance();
		
	
			classA.setName("Testklasse");
			Property p = f.createPropertyInstance();
			p.setClassifier(classA);
			p.setName("Attribut");
			
			javax.swing.JOptionPane.showMessageDialog(null, "Die ID der Klasse: " + classA.getID());

		try
		{
			ModelElementsManager.getInstance().addElement(classA, Application.getInstance().getProject().getModel());
		}
		catch (ReadOnlyElementException e1){}
		
		SessionManager.getInstance().closeSession();
		
		javax.swing.JOptionPane.showMessageDialog(null,"Die zur ID zugehörigen Klasse: "+Application.getInstance().getProject().getElementByID(classA.getID()).getHumanName());
	}
}