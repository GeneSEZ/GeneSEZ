package org.genesez.adapter.magicdraw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.nomagic.magicdraw.annotation.Annotation;
import com.nomagic.magicdraw.annotation.AnnotationManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.PresentationElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.properties.ColorProperty;
import com.nomagic.magicdraw.properties.PropertyManager;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

/**
 * class to Resets the graphical representation of all elements.
 */
public class PresentationElementReseter 
{
	//saves all modified elements to reset them later
	private HashMap<Element, ColorProperty> resetList = new HashMap<Element, ColorProperty>();
	

	/**
	* adds a element to resetList
	* 
 	* @param element: the element that was changed
 	* @param presentationElement: the presentationElement that was changed
 	*/
	public void addResetList(Element element, PresentationElement presentationElement) 
	{
		//If the item does not already exist
		if(!resetList.containsKey(element))
		{
			//add element and the ColorProperty of the presentationElement to list (presentationElement can be found on element)
			resetList.put(element, (ColorProperty) presentationElement.getProperty("FILL_COLOR"));
		}
	}


	public void resetDiagram() 
	{
		resetElement();
	}
	
	/**
	 * reset all Elements
	 */
	public void resetElement()
	{
		for(Map.Entry<Element, ColorProperty> list : resetList .entrySet())
		{
			AnnotationManager instance = AnnotationManager.getInstance();
			List<Annotation> annotationList = instance.getAnnotations(list.getKey());
	            
			for (Annotation annotation : annotationList)
			{
				if(list.getKey().getID().equals(annotation.getTarget().getID()))
				{
					instance.remove(annotation);
					break;
				}
			}
		}
		resetPresentationElements();
	}
	
	/**
	 * reset all PresentationElements
	 */
	public void resetPresentationElements()
	{
		//get all presentationElements on diagram
		List<PresentationElement> listPresentationElement = Application.getInstance().getProject().getActiveDiagram().getPresentationElements();

		//go through the resetList and reset the presentation elements
		for(Map.Entry<Element, ColorProperty> list : resetList.entrySet())
		{
			//If both match elements, reset
			for(PresentationElement presentationElement : listPresentationElement)
			{
				if(list.getKey().getID().equals(presentationElement.getElement().getID()))
				{
					PropertyManager propertyManager = new PropertyManager();
				
					SessionManager.getInstance().createSession(presentationElement.getElement().getID() + "Session");
					
					//add old color to propertyManager
					propertyManager.addProperty(list.getValue());
				
					//reset color
					try {PresentationElementsManager.getInstance().setPresentationElementProperties(presentationElement, propertyManager);} 
					catch (ReadOnlyElementException e) {e.printStackTrace();}
					
					SessionManager.getInstance().closeSession();
			
					break;
				}
			}
		}
		//clear list
		resetList.clear();
	}
	
	public boolean isListEmpty()
	{	
		return resetList.isEmpty();
	}
}
