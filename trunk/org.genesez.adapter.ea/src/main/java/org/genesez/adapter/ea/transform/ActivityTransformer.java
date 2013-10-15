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
 * @author Christian
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
	 */
	protected void transformElement(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362203391_514284_3045) ENABLED START */
		LOG.debug("Transforming element " + e.GetName());
		
		// define node
		ActivityNode node = null;
		
		IActivityTransformable activityTransformer = null;
		
		// Owned activities
		if (e.GetType().equals("Activity")) {
			LOG.debug("Element is an Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(e, (Activity) this.umlElement);
		}
		// Call behavior actions
		else {
			// get the right transformer for the activity
			activityTransformer = selectTransformer(e);
			// transform node now
			node = activityTransformer.transform(e, (Activity) this.umlElement);
		}
		
		// apply edges if node not null
		if (node != null) {
			this.applyActivityEdges(e, node);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
	
	/**
	 * transforms some StateNode, depending on its subtype
	 */
	private IActivityTransformable selectStateNodeTransformer(int subType) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1367313330094_43476_1703) ENABLED START */
		IActivityTransformable activityTransformer = null;
		if (subType == INITIAL_NODE) {
			LOG.debug("Element is an InitialNode");
			activityTransformer = new InitialNodeTransformer();
		} else if (subType == ACTIVITY_FINAL_NODE) {
			LOG.debug("Element is an ActivityFinalNode");
			activityTransformer = new ActivityFinalNodeTransformer();
		} else if (subType == FLOW_FINAL_NODE) {
			LOG.debug("Element is a FlowFinalNode");
			activityTransformer = new FlowFinalNodeTransformer();
		}
		return activityTransformer;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private IActivityTransformable selectTransformer(org.sparx.Element eaElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1367329350065_457718_1906) ENABLED START */
		IActivityTransformable activityTransformer = null;
		// Call behavior actions
		if (eaElement.GetType().equals("Action") && eaElement.GetClassfierID() > 0) {
			LOG.debug("Element is a CallBehaviorAction");
			activityTransformer = new CallBehaviorActionTransformer();
		}
		// All other actions
		else if (eaElement.GetType().equals("Action")) {
			LOG.debug("Element is an Action");
			activityTransformer = new CallOperationActionTransformer();
		} else if (eaElement.GetType().equals("StateNode")) {
			activityTransformer = selectStateNodeTransformer(eaElement.GetSubtype());
		} else if (eaElement.GetType().equals("Decision")) {
			LOG.debug("Element is a DecisionNode");
			activityTransformer = new DecisionNodeTransformer();
		} else if (eaElement.GetType().equals("MergeNode")) {
			LOG.debug("Element is a MergeNode");
			activityTransformer = new MergeNodeTransformer();
		}
		// Fork nodes
		else if (eaElement.GetType().equals("Synchronization") && isForkNode(eaElement)) {
			LOG.debug("Element is a ForkNode");
			activityTransformer = new ForkNodeTransformer();
		}
		// Join nodes
		else if (eaElement.GetType().equals("Synchronization") && isJoinNode(eaElement)) {
			LOG.debug("Element is a JoinNode");
			activityTransformer = new JoinNodeTransformer();
		}
		// if null
		if (activityTransformer == null) {
			LOG.error("not yet implemented activity feature: " + eaElement.GetType());
		}
		
		return activityTransformer;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363340874505_454681_2106) ENABLED START */
	private Map<String, ActivityEdge> edges = new HashMap<String, ActivityEdge>();
	private Map<Integer, Set<String>> edgeSources = new HashMap<Integer, Set<String>>();
	private Map<Integer, Set<String>> edgeTargets = new HashMap<Integer, Set<String>>();
	/* PROTECTED REGION END */
}
