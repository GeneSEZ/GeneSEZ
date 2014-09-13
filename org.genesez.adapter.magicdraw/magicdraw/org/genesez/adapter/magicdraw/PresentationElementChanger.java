package org.genesez.adapter.magicdraw;

import java.awt.Color;
import java.util.List;
import java.util.Properties;

import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.annotation.AnnotationManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.PresentationElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.properties.ColorProperty;
import com.nomagic.magicdraw.properties.PropertyID;
import com.nomagic.magicdraw.properties.PropertyManager;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

/**
 * Class to change the graphical representation of the elements
 * 
 * @author S. Wagner
 */
public class PresentationElementChanger 
{
	PresentationElementReseter presentationElementReseter;
	
	/**
	 * Method to change the fill color of a class.
	 * 
	 * @param classElement: The class which is to be changed
	 * @param errorProperties: The error Which is to be handled
	 */
	public void changeClassPresentation(Element classElement, Properties errorProperties)
	{
		//if the error type is 4
		if (errorProperties.get("severity").equals("4"))
		{
			//fill color = red
			ColorProperty colorProperty = new ColorProperty(PropertyID.FILL_COLOR, Color.RED);
			PropertyManager propertyManager = new PropertyManager();
			propertyManager.addProperty(colorProperty);
			
			List<PresentationElement> listPresentationElement = Application.getInstance().getProject().getActiveDiagram().getPresentationElements();

			//search the element by id and change fill color
			for (PresentationElement presentationElement : listPresentationElement) 
			{
				if(presentationElement.getElement().getID().equals(classElement.getID()))
				{
					//add element to reset list
					presentationElementReseter.addResetList(classElement, presentationElement);
					
					SessionManager.getInstance().createSession("Session"+errorProperties.getProperty("id"));
					
					try {PresentationElementsManager.getInstance().setPresentationElementProperties(presentationElement, propertyManager);} 
						catch (ReadOnlyElementException e) {e.printStackTrace();}
					
					SessionManager.getInstance().closeSession();
					
					addAnnotation(classElement, errorProperties);
					
					break;
				}
			} 
		}
	}

	/**
	 * set PresentationElementReseter
	 */
	public void setPresentationElementReseter(PresentationElementReseter presentationElementReseter) 
	{
		this.presentationElementReseter = presentationElementReseter;
	}
	
	/**
	 * adds a annotation (frame around the class)
	 * 
	 * @param classElement: The class which is to be changed
	 * @param errorProperties: The error which is to be handled
	 */
	public void addAnnotation(Element classElement, Properties errorProperties)
	{
		AnnotationManager instance = AnnotationManager.getInstance();
		
		//get all annotation that has the element already
		List<Annotation> list = instance.getAnnotations(classElement);
		
		//The displayed error message
		String errorMessage = "Errors: \n";
		
		//delete all the old annotation and adds the old error messages to the new error message
		for (Annotation annotation : list)
		{
			if(classElement.getID().equals(annotation.getTarget().getID()))
			{
				errorMessage = annotation.getText() + "\n";
				instance.remove(annotation);	
			}
		}
		
		//Add the error message of the current error to errorMessage
		errorMessage += errorProperties.getProperty("message");
		
        Project project = Project.getProject(classElement);

        //add annotation to Element
        Annotation annotation = new Annotation(Annotation.getSeverityLevel(project, Annotation.FATAL), "Fatal", errorMessage, classElement);
		
        instance.add(annotation);
        instance.update();
	}
}
