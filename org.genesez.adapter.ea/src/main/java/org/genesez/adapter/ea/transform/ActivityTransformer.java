package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363340874505_454681_2106) 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * transforms activity components
 * @author christian
 */

public class ActivityTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ActivityTransformer.class);
	
	public static final int INITIAL_NODE = 100;
	
	public static final int ACTIVITY_FINAL_NODE = 101;
	
	public static final int FLOW_FINAL_NODE = 102;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @param	parent	
	 * @return	
	 */
	
	public Activity transform(org.sparx.Element e, BehavioredClassifier parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363361825736_383301_3017) ENABLED START */
		LOG.debug("Creating Activity " + e.GetName() + ", parent " + parent.getName());
		Activity activity = (Activity) parent.createOwnedBehavior(e.GetName(), UMLFactory.eINSTANCE.createActivity().eClass());
		
		this.umlElement = activity;
		this.transform(e);
		
		return activity;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @param	parent	
	 * @return	
	 */
	
	public Activity transform(org.sparx.Element e, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362090688_873925_3031) ENABLED START */
		LOG.debug("Creating Activity " + e.GetName() + ", parent " + parent.getName());
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		activity.setName(e.GetName());
		activity.setPackage(parent);
		
		this.umlElement = activity;
		this.transform(e);
		
		return activity;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 */
	
	private void transform(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362122387_219403_3036) ENABLED START */
		this.eaElement = e;
		this.transformConnectors();
		this.transformElements();
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(e, this.umlElement);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	protected void transformConnectors() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362146580_726370_3039) ENABLED START */
		for (org.sparx.Element e : this.eaElement.GetElements()) {
			for (org.sparx.Connector c : e.GetConnectors()) {
				// Connectors are always found two times:
				// At the source node and at the target node
				if (this.edges.containsKey(c.GetConnectorGUID())) {
					continue;
				}
				this.transformConnector(c);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	c	
	 */
	
	protected void transformConnector(org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362168230_485022_3042) ENABLED START */
		LOG.debug("Transforming connector " + c.GetName());
		
		if (c.GetType().equals("ControlFlow")) {
			LOG.debug("Connector is a ControlFlow");
			ControlFlowTransformer t = new ControlFlowTransformer();
			this.addActivityEdge(c, t.transform(c, (Activity) this.umlElement));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 */
	
	protected void transformElement(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362203391_514284_3045) ENABLED START */
		LOG.debug("Transforming element " + e.GetName());
		
		ActivityNode node = null;
		
		// Owned activities
		if (e.GetType().equals("Activity")) {
			LOG.debug("Element is an Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(e, (Activity) this.umlElement);
		}
		// Call behavior actions
		else if (e.GetType().equals("Action") && e.GetClassfierID() > 0) {
			LOG.debug("Element is a CallBehaviorAction");
			CallBehaviorActionTransformer t = new CallBehaviorActionTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		}
		// All other actions
		else if (e.GetType().equals("Action")) {
			LOG.debug("Element is an Action");
			CallOperationActionTransformer t = new CallOperationActionTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		} else if (e.GetType().equals("StateNode") && e.GetSubtype() == INITIAL_NODE) {
			LOG.debug("Element is an InitialNode");
			InitialNodeTransformer t = new InitialNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		} else if (e.GetType().equals("StateNode") && e.GetSubtype() == ACTIVITY_FINAL_NODE) {
			LOG.debug("Element is an ActivityFinialNode");
			ActivityFinalNodeTransformer t = new ActivityFinalNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		} else if (e.GetType().equals("StateNode") && e.GetSubtype() == FLOW_FINAL_NODE) {
			LOG.debug("Element is a FlowFinalNode");
			FlowFinalNodeTransformer t = new FlowFinalNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		} else if (e.GetType().equals("Decision")) {
			LOG.debug("Element is a DecisionNode");
			DecisionNodeTransformer t = new DecisionNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		} else if (e.GetType().equals("MergeNode")) {
			LOG.debug("Element is a MergeNode");
			MergeNodeTransformer t = new MergeNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		}
		// Fork nodes
		else if (e.GetType().equals("Synchronization") && isForkNode(e)) {
			LOG.debug("Element is a ForkNode");
			ForkNodeTransformer t = new ForkNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		}
		// Join nodes
		else if (e.GetType().equals("Synchronization") && isJoinNode(e)) {
			LOG.debug("Element is a JoinNode");
			JoinNodeTransformer t = new JoinNodeTransformer();
			node = t.transform(e, (Activity) this.umlElement);
		}
		
		if (null != node) {
			this.applyActivityEdges(e, node);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	c	
	 * @param	edge	
	 */
	
	private void addActivityEdge(org.sparx.Connector c, ActivityEdge edge) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362233555_701061_3048) ENABLED START */
		this.edges.put(c.GetConnectorGUID(), edge);
		
		// create a dummy HashSet for the connectors guid 
		HashSet<String> connectorGuid = new HashSet<String>();
		connectorGuid.add(c.GetConnectorGUID());
		
		// add the connector to its sources connector list
		if (this.edgeSources.containsKey(c.GetClientID())) {
			this.edgeSources.get(c.GetClientID()).addAll(connectorGuid);
		} else {
			this.edgeSources.put(c.GetClientID(), connectorGuid);
		}
		
		// add the connector to its targets connector list
		if (this.edgeTargets.containsKey(c.GetSupplierID())) {
			this.edgeTargets.get(c.GetSupplierID()).addAll(connectorGuid);
		} else {
			this.edgeTargets.put(c.GetSupplierID(), connectorGuid);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @param	node	
	 */
	
	private void applyActivityEdges(org.sparx.Element e, ActivityNode node) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362273681_9146_3053) ENABLED START */
		// Apply node as source
		if (this.edgeSources.containsKey(e.GetElementID())) {
			LOG.debug("Outgoing Flows: " + this.edgeSources.get(e.GetElementID()).size());
			for (String connectorGuid : this.edgeSources.get(e.GetElementID())) {
				this.edges.get(connectorGuid).setSource(node);
			}
		}
		
		// Apply node as target
		if (this.edgeTargets.containsKey(e.GetElementID())) {
			LOG.debug("Incoming Flows: " + this.edgeTargets.get(e.GetElementID()).size());
			for (String connectorGuid : this.edgeTargets.get(e.GetElementID())) {
				this.edges.get(connectorGuid).setTarget(node);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @return	
	 */
	
	private boolean isForkNode(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362375949_303244_3062) ENABLED START */
		int i = 0;
		for (org.sparx.Connector c : e.GetConnectors()) {
			if (c.GetClientID() == e.GetElementID()) {
				i++;
			}
		}
		return i > 1;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @return	
	 */
	
	private boolean isJoinNode(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363340960011_961298_2134) ENABLED START */
		int i = 0;
		for (org.sparx.Connector c : e.GetConnectors()) {
			if (c.GetSupplierID() == e.GetElementID()) {
				i++;
			}
		}
		return i > 1;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363340874505_454681_2106) ENABLED START */
	private Map<String, ActivityEdge> edges = new HashMap<String, ActivityEdge>();
	private Map<Integer, Set<String>> edgeSources = new HashMap<Integer, Set<String>>();
	private Map<Integer, Set<String>> edgeTargets = new HashMap<Integer, Set<String>>();
	/* PROTECTED REGION END */
	
}
