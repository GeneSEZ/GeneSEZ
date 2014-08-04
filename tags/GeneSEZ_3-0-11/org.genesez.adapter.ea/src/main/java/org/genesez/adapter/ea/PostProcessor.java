package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866918745_268442_1992) 
 */

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
 * Some model transformation actions cannot be done during the main transformation.
 * Such actions are e.g. setting the called behavior of CallBehaviorActions or
 * adding Properties to classifiers because there's no guarantee that these
 * elements are already processed.
 * So, these actions are performed after the main transformation.
 * The PostProcessor collect these actions for a later execution.
 * @author christian
 */

public class PostProcessor {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PostProcessor.class);
	
	public static final PostProcessor INSTANCE = new PostProcessor();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Just to make constructor private
	 */
	
	private PostProcessor() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363342594283_164328_2184) ENABLED START */
		// nothing to do here
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Initializes (or reset) the PostProcessor
	 */
	
	public void initialize() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342582819_76343_2181) ENABLED START */
		this.calledBehaviors = new HashMap<CallBehaviorAction, Integer>();
		this.properties = new HashMap<StructuredClassifier, Set<org.sparx.Attribute>>();
		this.dependencies = new HashMap<Dependency, org.sparx.Connector>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Runs the post processing for all elements
	 */
	
	public void startPostProcessing() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342826962_47138_2205) ENABLED START */
		LOG.debug("Starting post processing");
		this.processBehaviors();
		this.processProperties();
		this.processDependencies();
		// Interfaces
		this.processInterfaces();
		// Connections
		this.processConnections();
		
		// DEBUG
		ElementRegistry.INSTANCE.printElementRegistry();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Process dependencies which could not be resolved
	 */
	
	private void processDependencies() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342783520_562684_2196) ENABLED START */
		LOG.debug("Starting post processing for dependencies");
		LOG.debug("\n\tDependencies found: " + this.dependencies.size() + "\n");
		
		for (Dependency d : this.dependencies.keySet()) {
			org.sparx.Connector c = this.dependencies.get(d);
			
			NamedElement elem = (NamedElement) ElementRegistry.INSTANCE.getElementById(c.GetSupplierID());
			if (elem != null) {
				d.getSuppliers().add(elem);
			} else {
				String guid = c.GetConnectorGUID();
				ConnectorFactory.INSTANCE.addDependency(guid, c.GetClientID());
				ConnectorFactory.INSTANCE.addDependency(guid, c.GetSupplierID());
				LOG.fatal("FUCK element does not exist yet.");
				LOG.fatal("Name=" + d.getName());
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Process interfaces
	 */
	
	private void processInterfaces() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342746814_626934_2190) ENABLED START */
		LOG.debug("Starting post processing interface realization");
		InterfaceFactory.INSTANCE.processInterfaces();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Process all connections
	 */
	
	private void processConnections() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342771093_486808_2193) ENABLED START */
		//		ConnectorFactory.instance.printDependencies();
		LOG.debug("Starting post processing all Connections");
		ConnectorFactory.INSTANCE.startProcessingConnectors();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Process properties of classifiers
	 */
	
	private void processProperties() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342802536_987354_2199) ENABLED START */
		LOG.debug("Starting post processing for properties");
		
		for (StructuredClassifier c : this.properties.keySet()) {
			for (org.sparx.Attribute a : this.properties.get(c)) {
				PropertyClassifierTransformer p = new PropertyClassifierTransformer();
				p.transform(a, c);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Runs the post processing for setting behaviors
	 */
	
	private void processBehaviors() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342810147_943022_2202) ENABLED START */
		LOG.debug("Starting post processing for called behaviors");
		
		// Set the behaviors for CallBehaviorActions
		for (CallBehaviorAction a : this.calledBehaviors.keySet()) {
			int id = this.calledBehaviors.get(a);
			LOG.debug("Behavior for Action " + a.getName() + " is " + id);
			a.setBehavior((Behavior) ElementRegistry.INSTANCE.getElementById(id));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	caller	
	 * @param	id	
	 */
	
	public void addCalledBehaviorAction(CallBehaviorAction caller, int id) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342920411_716130_2208) ENABLED START */
		this.calledBehaviors.put(caller, id);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	c	
	 * @param	a	
	 */
	
	public void addProperty2Classifier(StructuredClassifier c, org.sparx.Attribute a) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342948960_607032_2216) ENABLED START */
		if (!this.properties.containsKey(c)) {
			this.properties.put(c, new HashSet<org.sparx.Attribute>());
		}
		this.properties.get(c).add(a);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	d	The Enterprise Architect Connector to create the Dependency from
	 * @param	c	The dependency to add the dependencies
	 */
	
	public void addDependency(Dependency d, org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342986388_650310_2224) ENABLED START */
		if (!this.dependencies.containsKey(d)) {
			this.dependencies.put(d, c);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866918745_268442_1992) ENABLED START */
	private Map<CallBehaviorAction, Integer> calledBehaviors = new HashMap<CallBehaviorAction, Integer>();
	private Map<StructuredClassifier, Set<org.sparx.Attribute>> properties = new HashMap<StructuredClassifier, Set<org.sparx.Attribute>>();
	private Map<Dependency, org.sparx.Connector> dependencies = new HashMap<Dependency, org.sparx.Connector>();
	/* PROTECTED REGION END */
	
}
