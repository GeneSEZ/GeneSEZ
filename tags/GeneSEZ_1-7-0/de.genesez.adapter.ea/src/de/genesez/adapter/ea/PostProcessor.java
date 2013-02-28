package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.StructuredClassifier;

import de.genesez.adapter.ea.transform.PropertyClassifierTransformer;

/**
 * Process action after the main model transformation
 * 
 * @author gerbe
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
	 * Runs the post processing for all elements
	 */
	public void startPostProcessing() {
		log.debug("Starting post processing");
		this.processBehaviors();
		this.processProperties();
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
}
