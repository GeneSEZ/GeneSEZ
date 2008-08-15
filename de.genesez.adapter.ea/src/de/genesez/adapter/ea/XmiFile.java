package de.genesez.adapter.ea;

import java.io.IOException;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.openarchitectureware.workflow.ConfigurationException;

public class XmiFile {

	private static final Log log = LogFactory.getLog(XmiFile.class);
	private static final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	public static final XmiFile instance = new XmiFile();
	
	public XMIResource resource;
	
	private XmiFile() {
		// nothing to do here ;-)
	}
	
	public void setFilename(String value) {
		URI fileURI = URI.createFileURI(value);
		this.resource = (XMIResource) RESOURCE_SET.createResource(fileURI);
		this.resource.setEncoding("UTF-8");
		
	}
	
	public void addElement(Element _e, String _guid) {
		this.resource.setID(_e, _guid);
	}
	
	public void addContent(EObject o) {
		this.resource.getContents().add(o);
	}
	
	public void save() {
		try 
		{
			this.resource.save(Collections.EMPTY_MAP);
		} 
		catch (final IOException e) 
		{
			throw new ConfigurationException(e);
		}
	}
}
