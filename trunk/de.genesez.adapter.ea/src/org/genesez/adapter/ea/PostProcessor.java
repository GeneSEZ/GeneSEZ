package org.genesez.adapter.ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.genesez.adapter.ea.transform.ConnectorFactory;
import org.genesez.adapter.ea.transform.InterfaceFactory;
import org.genesez.adapter.ea.transform.PropertyClassifierTransformer;


/**
 * Process action after the main model transformation
 * 
 * @author gerbe
 * @author christian
 * 
 * Some model transformation actions cannot be done during the main transformation.
 * Such actions are e.g. setting the called behavior of CallBehaviorActions or
 * adding Properties to classifiers because there's no guarantee that these
 * elements are already processed.
 * So, these actions are performed after the main transformation.
 * The PostProcessor collect these actions for a later execution.
 */
public class PostProcessor {

	private static final Log log = LogFactory.getLog(PostProcessor.class);

	public static final PostProcessor instance = new PostProcessor();

	private Map<CallBehaviorAction, Integer> calledBehaviors = new HashMap<CallBehaviorAction, Integer>();
	private Map<StructuredClassifier, Set<org.sparx.Attribute>> properties = new HashMap<StructuredClassifier, Set<org.sparx.Attribute>>();
	private Map<Dependency, org.sparx.Connector> dependencies = new HashMap<Dependency, org.sparx.Connector>();
	
	/**
	 * Just to make constructor private
	 */
	private PostProcessor() {
		// nothing to do here ;-)
	}
	
	/**
	 * Initializes (or reset) the ProstProcessor
	 */
	public void initialize() {
		this.calledBehaviors = new HashMap<CallBehaviorAction, Integer>();
		this.properties = new HashMap<StructuredClassifier, Set<org.sparx.Attribute>>();
		this.dependencies = new HashMap<Dependency, org.sparx.Connector>();
	}
	
	/**
	 * Add a set call behavior action
	 * @param _caller	The UML CallBehaviorAction
	 * @param _id		The Enterprise Architect ID of the called behavior
	 */
	public void setCalledBehavior(CallBehaviorAction _caller, int _id) {
		this.calledBehaviors.put(_caller, _id);
	}
	
	/**
	 * Add a property adding action
	 * @param _c	The classifier to add the property
	 * @param _a	The Enterprise Architect attribute to create the Property from
	 */
	public void setProperty(StructuredClassifier _c, org.sparx.Attribute _a) {
		if ( ! this.properties.containsKey(_c)) {
			this.properties.put(_c, new HashSet<org.sparx.Attribute>());
		}
		this.properties.get(_c).add(_a);
	}
	
	/**
	 * Add a property adding action
	 * @param _d	The dependency to add the dependencies
	 * @param _c	The Enterprise Architect Connector to create the Dependency from
	 */
	public void setDependency(Dependency _d, org.sparx.Connector _c) {
		if ( ! this.dependencies.containsKey(_d)) {
			this.dependencies.put(_d, _c);
		}
	}
	
	
	
	/**
	 * Runs the post processing for all elements
	 */
	public void startPostProcessing() {
		log.debug("Starting post processing");
		this.processBehaviors();
		this.processProperties();
		this.processDependencies();
		// Interfaces
		this.processInterfaces();
		// Connections
		this.processConnections();
		
		// TODO DEBUG
		ElementRegistry.instance.print();
	}

	/**
	 * Runs the post processing for setting behaviors
	 */
	private void processBehaviors() {
		log.debug("Starting post processing for called behaviors");

		// Set the behaviors for CallBehaviorActions
		for (CallBehaviorAction a : this.calledBehaviors.keySet()) {
			int id = this.calledBehaviors.get(a);
			log.debug("Behavior for Action " + a.getName() + " is " + id);
			a.setBehavior((Behavior)ElementRegistry.instance.getById(id));
		}
	}
	
	/**
	 * Process properties of classifiers 
	 */
	private void processProperties() {
		log.debug("Starting post processing for properties");

		for (StructuredClassifier c : this.properties.keySet()) {
			for (org.sparx.Attribute a: this.properties.get(c)) {
				PropertyClassifierTransformer p = new PropertyClassifierTransformer();
				p.transform(a, c);
			}
		}
	}
	
	/**
	 * Process dependencies which could not be resolved
	 */
	private void processDependencies() {
		log.debug("Starting post processing for dependencies");
		log.debug("\n\tDependencies found: " + this.dependencies.size() +"\n");
		
		for (Dependency d : this.dependencies.keySet()) {
			org.sparx.Connector c = this.dependencies.get(d);
			
			NamedElement elem = (NamedElement) ElementRegistry.instance.getById(c.GetSupplierID());
			if(elem != null){
				d.getSuppliers().add(elem);	
			}else{
				String guid = c.GetConnectorGUID();
				ConnectorFactory.instance.addDependency(guid, c.GetClientID());
				ConnectorFactory.instance.addDependency(guid, c.GetSupplierID());
				log.fatal("FUCK element does not exist yet.");
				log.fatal("Name="+d.getName() );
			}
		}
	}
	
	/**
	 * Process interfaces 
	 */
	private void processInterfaces(){
		log.debug("Starting post processing interface realization");
		InterfaceFactory.instance.processInterfaces();	
	}

	/**
	 * Process all connections
	 */
	private void processConnections(){
//		ConnectorFactory.instance.printDependencies();
		log.debug("Starting post processing all Connections");
		ConnectorFactory.instance.startPostprocssingConnectors();
	}
	
}
