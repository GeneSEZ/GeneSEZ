package MyPlugin;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdmodels.Model;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;


public class ActionKlassenUndAttributeAusgeben extends MDAction
{
	public ActionKlassenUndAttributeAusgeben(String id, String name)
	{
		super(id, name, null, null);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Model root = Application.getInstance().getProject().getModel();

		Element el = root;
		
		if (el.hasOwnedElement())
		{
			for (Iterator it = el.getOwnedElement().iterator(); it.hasNext();)
			{
				Element ownedElement = (Element) it.next();
				
				
				if(ownedElement instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class)
				{
		
					com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class test = (Class) ownedElement;
		
					Collection<Property> coll = test.getAttribute();
					
					
					Iterator iterator = coll.iterator();
					
					String aa = "";
					
		            while (iterator.hasNext())
		            {
		            	Property a = (Property) iterator.next();
		            	
		            	if(aa.equals(""))
		            	{
		            		aa +=ownedElement.getHumanName() +"\n" + "\n" + "Attribute:"+ "\n";
		    
		            	}
		            	
		            	aa += a.getName()+"\n";
		            }
		            
		            if(!aa.equals(""))
	            	{
		            javax.swing.JOptionPane.showMessageDialog(null, aa);
	            	}
		            

				}
			}
		}
	}
}
