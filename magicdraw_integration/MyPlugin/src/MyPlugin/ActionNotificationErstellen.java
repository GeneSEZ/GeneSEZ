package MyPlugin;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.annotation.AnnotationAction;
import com.nomagic.magicdraw.annotation.AnnotationManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdmodels.Model;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;


public class ActionNotificationErstellen extends MDAction
{

        public ActionNotificationErstellen(String id, String name)
        {
           super(id, name, null, null);
        }

        @Override
		public void actionPerformed(ActionEvent evt)
        {
        	
        	BaseElement element = null;


        	Model root = Application.getInstance().getProject().getModel();

    		Element el = root;
    		
    		
    		if (el.hasOwnedElement())
    		{
    			for (Iterator it = el.getOwnedElement().iterator(); it.hasNext();)
    			{
    				Element ownedElement = (Element) it.next();
    				
    				
    				if(ownedElement instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class)
    				{
    					javax.swing.JOptionPane.showMessageDialog(null, ownedElement.getHumanName());
    		
//    					if(ownedElement.getHumanName().equals(Application.getInstance().getProject()))
//    					{
    						// element = (BaseElement) ownedElement;
    					
    					
    						NotificationServiceClass rahmen= new NotificationServiceClass();
    						int i = (int) ((Math.random()*4) + 1);
    						
    						
    						if(i == 1)
    						{
    							rahmen.setKind("Fatal");
    						}
    						else if(i == 2)
    						{
    							rahmen.setKind("Warning");
    						}
    						else if(i == 3)
    						{
    							rahmen.setKind("Info");
    						}
    						else if(i == 4)
    						{
    							rahmen.setKind("Debug");
    						}
    				
    						rahmen.addRahmenToElement(ownedElement);
//    					}
    		            

    				}
    				
    			}
    		}
    		
            
            
//            Project project = Project.getProject(element);
//            AnnotationManager instance = AnnotationManager.getInstance();
//            Annotation annotation1 = new Annotation(Annotation.getSeverityLevel(project, Annotation.ERROR), "sample", "Annotation Sample 1", element);
//            instance.add(annotation1);
//            instance.update();
        }



    }



    
