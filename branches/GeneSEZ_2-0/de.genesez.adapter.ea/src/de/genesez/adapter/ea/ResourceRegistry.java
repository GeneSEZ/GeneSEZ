package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * A singleton class to handle Resources for the model transformation
 * 
 * @author gerbe
 *
 * The ResourceRegistry create and load resources for transforming the model.
 * It also provides access to the resources via their names.
 */
public class ResourceRegistry {

	private static final Log log = LogFactory.getLog(ResourceRegistry.class);
	private static final ResourceSetImpl RESOURCE_SET = new ResourceSetImpl();

	public static final ResourceRegistry instance = new ResourceRegistry();
	
	private Map<String, Resource> resources = new HashMap<String, Resource>();
	
	/**
	 * Just to make constructor private
	 */
	private ResourceRegistry() {
		// nothing to do here ;-)
	}
	
	/**
	 * Load a resource by its URI and register it
	 * @param _name	The name of the resource
	 * @param _uri	The URI from where to load the resource
	 * @return	The loaded resource
	 */
	public Resource load(String _name, URI _uri) {
		log.debug("Loading resource " + _name + " from "+ _uri.toString());
		Resource resource = RESOURCE_SET.getResource(_uri, true);
		this.resources.put(_name, resource);
		return resource;
	}
	
	/**
	 * Creates a resource under a specified URI and register it
	 * @param _name	The name of the resource
	 * @param _uri	The URI where to create the resource
	 * @return	The created resource
	 */
	public XMIResource create(String _name, URI _uri) {
		log.debug("Create resource " + _name + " on " + _uri.toString());
		XMIResource resource = (XMIResource) RESOURCE_SET.createResource(_uri);
		resource.setEncoding("UTF-8");
		this.resources.put(_name, resource);
		return resource;
	}
	
	/**
	 * Returns a resource identified by its name
	 * @param _name	The name of the resource
	 * @return	The resource if found, null instead
	 */
	public Resource get(String _name) {
		return this.resources.get(_name);
	}
}
