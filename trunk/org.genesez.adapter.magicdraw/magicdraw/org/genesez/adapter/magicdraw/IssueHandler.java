package org.genesez.adapter.magicdraw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;

/**
 * Class receives the issues, finds the element in the diagram by xmlGUIID and starts the error handling
 * 
 * @author S. Wagner
 *
 */
public class IssueHandler 
{
	//class to change the elements on the diagram
	PresentationElementChanger presentationElementChanger = new PresentationElementChanger();
	//For searching needed. items will not be searched several times or infinite loops are created
	List<String> listOfVisitedElements = new ArrayList<String>();
	Properties issueProperties;
	String xmiGUID;
	
	/**
	 * Entry point to handle issues
	 * 
	 * @param presentationElementReseter: class to reset (the color) the elements on the diagram 
	 * @param issueProperties: the issue as property representation
	 */
	public void handleIssue(Properties issueProperties, PresentationElementReseter presentationElementReseter)
	{
		this.issueProperties = issueProperties;
		//adds presentationElementReseter to presentationElementChanger
		presentationElementChanger.setPresentationElementReseter(presentationElementReseter);

		Element model = Application.getInstance().getProject().getModel();
		
		if (model.hasOwnedElement())
		{
			search(model);
		}

		//Resets the list after execution
		listOfVisitedElements.clear();
	}	

	/**
	 * Search the element by xmlGUIID what caused the issue
	 * 
	 * @param element: the element which is checked
	 */
	public void search(Element element)
	{
		//If the element was not visited
		if(!listOfVisitedElements.contains(element.getID()))
		{
			listOfVisitedElements.add(element.getID());

			for (Iterator<Element> ownedElementIterator = element.getOwnedElement().iterator(); ownedElementIterator.hasNext();)
			{
				Element ownedElement = ownedElementIterator.next();

				identifyElement(ownedElement);

				//Search all child elements (In the case of a class it would be, for example: attributes)
				if(element.hasOwnedElement())
				{
					search(ownedElement);
				}
			}	
		}
	}
		
	/**
	 * Method controls: Is the error caused by this element?
	 *
	 * @param element element the element which is checked
	 */
	private void identifyElement(Element element) 
	{
		//if the element is from the type "class" > run the test case for class
		if(element instanceof com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class)
		{	
			//controls: Is the error caused by this attribute?
			if(((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) element).hasAttribute())
			{
				for (Iterator<Property> propertyIterator = ((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) element).getAttribute().iterator(); propertyIterator.hasNext();)
				{
					Element attribute = propertyIterator.next();

					if((attribute.getID().equals(issueProperties.get("id").toString())))
					{
						presentationElementChanger.changeClassPresentation(attribute.getOwner(), issueProperties);
					}
				}
			}
		}
	}
}