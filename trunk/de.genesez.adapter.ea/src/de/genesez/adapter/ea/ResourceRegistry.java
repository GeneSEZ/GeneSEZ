package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

public class ResourceRegistry {

	private static final Log log = LogFactory.getLog(ResourceRegistry.class);
	private static final ResourceSetImpl RESOURCE_SET = new ResourceSetImpl();

	public static final ResourceRegistry instance = new ResourceRegistry();
	
	private Map<String, Resource> resources = new HashMap<String, Resource>();
	
	private ResourceRegistry() {
		// nothing to do here ;-)
	}
	
	public Resource load(String _name, URI _uri) {
		log.debug("Loading resource " + _name + " from "+ _uri.toString());
		Resource resource = RESOURCE_SET.getResource(_uri, true);
		this.resources.put(_name, resource);
		return resource;
	}
	
	public XMIResource create(String _name, URI _uri) {
		log.debug("Create resource " + _name + " on " + _uri.toString());
		XMIResource resource = (XMIResource) RESOURCE_SET.createResource(_uri);
		resource.setEncoding("UTF-8");
		this.resources.put(_name, resource);
		return resource;
	}
	
	public Resource get(String _name) {
		return this.resources.get(_name);
	}
}
