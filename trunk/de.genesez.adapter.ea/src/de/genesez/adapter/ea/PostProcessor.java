package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

public class PostProcessor {

	private static final Log log = LogFactory.getLog(PostProcessor.class);

	public static final PostProcessor instance = new PostProcessor();

	private Map<Integer, Element> elementRegistry = new HashMap<Integer, Element>();
	private Map<CallBehaviorAction, Integer> calledBehaviors = new HashMap<CallBehaviorAction, Integer>();
	private Map<Element, Set<String>> stereotypes = new HashMap<Element, Set<String>>();
	
	private PostProcessor() {
		// nothing to do here ;-)
	}
	
	public void registerElement(org.sparx.Element _e, Element _element) {
		this.elementRegistry.put(_e.GetElementID(), _element);
		this.setStereotypes(_element, _e.GetStereotypeList());
	}
	
	public void setCalledBehavior(CallBehaviorAction _caller, int _id) {
		this.calledBehaviors.put(_caller, _id);
	}
	
	private void setStereotypes(Element _element, String _stereotypes) {
		if ( 0 < _stereotypes.length() ) {
			Set<String> stereotypes = new HashSet<String>();
			for (String name : _stereotypes.split(",")) {
				stereotypes.add(name);
			}
			this.stereotypes.put(_element, stereotypes);
		}
	}

	/**
	 * Runs the post processing for all elements
	 */
	public void startPostProcessing() {
		log.info("Starting post processing");
		this.processBehaviors();
		this.processStereotypes();
	}

	/**
	 * Runs the post processing for setting behaviors
	 */
	private void processBehaviors() {
		log.info("Starting post processing for called behaviors");

		// Set the behaviors for CallBehaviorActions
		for (CallBehaviorAction a : this.calledBehaviors.keySet()) {
			int id = this.calledBehaviors.get(a);
			log.debug("Behavior for Action " + a.getName() + " is " + id);
			a.setBehavior((Behavior)this.elementRegistry.get(id));
		}
	}
	
	private void processStereotypes() {
		log.info("Starting post processing for stereotypes");
		
		for (Element e : this.stereotypes.keySet()) {
			for (String s : this.stereotypes.get(e)) {
				log.debug("Search for stereotype " + s);
				Stereotype st = ProfileRegistry.instance.getStereotype(s);
				if (e.isStereotypeApplicable(st)) {
					log.debug("Apply stereotype " + st.getName() );
					EObject o = e.applyStereotype(st);
					if (null != o) {
						ContentRegistry.instance.addContent(o);
					}
				}
			}
		}
	}
}
