package MyPlugin;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.annotation.AnnotationAction;
import com.nomagic.magicdraw.annotation.AnnotationManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.BaseElement;
import com.nomagic.uml2.ext.magicdraw.auxiliaryconstructs.mdmodels.Model;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class NotificationServiceClass
{
	private String text, kind;

	public NotificationServiceClass()
    {
        text ="Beschreibung";
        kind = "Error";
    }
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	
	public void addRahmenToElement(Element element)
	{
		text = "";
        Project project = Project.getProject(element);
        AnnotationManager instance = AnnotationManager.getInstance();
        
        Annotation annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.ERROR), kind, text, element);
        
//        if(kind == "Error")
//        {
//        	annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.ERROR), kind, text, element);
//        }
        if(kind == "Fatal")
        {
        	annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.FATAL), kind, text, element);
        }
        else if(kind == "Debug")
        {
        	annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.DEBUG), kind, text, element);
        }
	    else if(kind == "Info")
	    {
	        annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.INFO), kind, text, element);
        }
	    else if(kind == "Warning")
	    {
	        annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.WARNING), kind, text, element);
        }
        
        instance.add(annotation);
        instance.update();
        
        removeRahmenFromElement(element, "Fatal");
	}
	
	
	
	public void removeRahmenFromElement(Element element)
	{
		removeRahmenFromElement(element, null);
	}
	
	public void removeRahmenFromElement(Element element, String kind)
	{
		AnnotationManager instance = AnnotationManager.getInstance();
		List<Annotation> list = instance.getAnnotations(element);
            
		for (Annotation annotation : list)
		{
			javax.swing.JOptionPane.showMessageDialog(null, element.getHumanName() + annotation.getKind());
			
			if(element.getID().equals(annotation.getTarget().getID()) && kind == null)
			{
				instance.remove(annotation);
			}
			else if(element.getID().equals(annotation.getTarget().getID()) && kind.equals(annotation.getKind()))
			{
				instance.remove(annotation);
			}
		}
        instance.update();
	}	
}
