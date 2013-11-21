package MyPlugin;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdmodels.Model;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.impl.PropertyNames;

import java.awt.*;




public class ActionNamensaenderungListener extends MDAction
{
	public ActionNamensaenderungListener(String id, String name)
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
					ownedElement.addPropertyChangeListener(new PropertyChangeListener()
					{
						public void propertyChange(PropertyChangeEvent event) 
						{
							if (PropertyNames.NAME.equals(event.getPropertyName()))
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Name geändert");
							}
						}
						
					});
				


			}
		}
		
	}}}
		
		
