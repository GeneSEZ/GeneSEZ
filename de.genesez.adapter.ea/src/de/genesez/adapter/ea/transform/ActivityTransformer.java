package de.genesez.adapter.ea.transform;

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

import de.genesez.adapter.ea.ElementRegistry;

public class ActivityTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(ActivityTransformer.class);

	private Map<String, ActivityEdge> edges = new HashMap<String, ActivityEdge>();
	private Map<Integer, Set<String>> edgeSources = new HashMap<Integer, Set<String>>();
	private Map<Integer, Set<String>> edgeTargets = new HashMap<Integer, Set<String>>();

	Activity transform(org.sparx.Element _e, BehavioredClassifier _parent) {
		log.debug("Creating Activity " + _e.GetName() + ", parent " + _parent.getName());
		Activity activity = (Activity) _parent.createOwnedBehavior(_e.GetName(),
				UMLFactory.eINSTANCE.createActivity().eClass());

		this.umlElement = activity;
		this.transform(_e);

		return activity;
	}

	Activity transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating Activity " + _e.GetName() + ", parent " + _parent.getName());
		Activity activity = UMLFactory.eINSTANCE.createActivity();
		activity.setName(_e.GetName());
		activity.setPackage(_parent);
		
		this.umlElement = activity;
		this.transform(_e);

		return activity;
	}
	
	private void transform(org.sparx.Element _e) {
		this.eaElement = _e;
		this.transformConnectors();
		this.transformElements();
		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, this.umlElement);
	}
	
	@Override
	protected void transformConnectors() {
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
	}

	@Override
	protected void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName());
		
		if (_c.GetType().equals("ControlFlow")) {
			log.debug("Connector is a ControlFlow");
			ControlFlowTransformer t = new ControlFlowTransformer();
			this.addActivityEdge(_c, t.transform(_c, (Activity)this.umlElement ));
		}
	}
	
	@Override
	protected void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName());

		ActivityNode node = null;

		// Owned activities
		if ( _e.GetType().equals("Activity") ) {
				log.debug("Element is an Activity");
				ActivityTransformer t = new ActivityTransformer();
				t.transform(_e, (Activity)this.umlElement);
		}
		// Call behavior actions
		else if ( _e.GetType().equals("Action") && _e.GetClassfierID() > 0 ) {
			log.debug("Element is a CallBehaviorAction");
			CallBehaviorActionTransformer t = new CallBehaviorActionTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		// All other actions
		else if ( _e.GetType().equals("Action") ) {
			log.debug("Element is an Action");
			CallOperationActionTransformer t = new CallOperationActionTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 100 ) {
			log.debug("Element is an InitialNode");
			InitialNodeTransformer t = new InitialNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 101 ) {
			log.debug("Element is an ActivityFinialNode");
			ActivityFinalNodeTransformer t = new ActivityFinalNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 102 ) {
			log.debug("Element is a FlowFinalNode");
			FlowFinalNodeTransformer t = new FlowFinalNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		else if ( _e.GetType().equals("Decision") ) {
			log.debug("Element is a DecisionNode");
			DecisionNodeTransformer t = new DecisionNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		else if ( _e.GetType().equals("MergeNode") ) {
			log.debug("Element is a MergeNode");
			MergeNodeTransformer t = new MergeNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		// Fork nodes
		else if ( _e.GetType().equals("Synchronization") && isForkNode(_e) ) {
			log.debug("Element is a ForkNode");
			ForkNodeTransformer t = new ForkNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		// Join nodes
		else if ( _e.GetType().equals("Synchronization") && isJoinNode(_e) ) {
			log.debug("Element is a JoinNode");
			JoinNodeTransformer t = new JoinNodeTransformer();
			node = t.transform(_e, (Activity)this.umlElement);
		}
		
		if ( null != node ) {
			this.applyActivityEdges(_e, node);
		}
	}
	
	private void addActivityEdge(org.sparx.Connector _c, ActivityEdge _edge) {
		this.edges.put(_c.GetConnectorGUID(), _edge);

		// create a dummy HashSet for the connectors guid 
		HashSet<String> connectorGuid = new HashSet<String>();
		connectorGuid.add(_c.GetConnectorGUID());

		// add the connector to its sources connector list
		if (this.edgeSources.containsKey(_c.GetClientID())) {
			this.edgeSources.get(_c.GetClientID()).addAll(connectorGuid);
		} else {
			this.edgeSources.put(_c.GetClientID(), connectorGuid);
		}

		// add the connector to its targets connector list
		if (this.edgeTargets.containsKey(_c.GetSupplierID())) {
			this.edgeTargets.get(_c.GetSupplierID()).addAll(connectorGuid);
		} else {
			this.edgeTargets.put(_c.GetSupplierID(), connectorGuid);
		}
	}
	
	private void applyActivityEdges(org.sparx.Element _e, ActivityNode _node) {

		// Apply node as source
		if (this.edgeSources.containsKey(_e.GetElementID())) {
			log.debug("Outgoing Flows: " + this.edgeSources.get(_e.GetElementID()).size());
			for (String connectorGuid: this.edgeSources.get(_e.GetElementID()) ) {
				this.edges.get(connectorGuid).setSource(_node);
			}
		}
		
		// Apply node as target
		if (this.edgeTargets.containsKey(_e.GetElementID())) {
			log.debug("Incoming Flows: " + this.edgeTargets.get(_e.GetElementID()).size());
			for (String connectorGuid: this.edgeTargets.get(_e.GetElementID()) ) {
				this.edges.get(connectorGuid).setTarget(_node);
			}
		}
	}
	
	private static boolean isForkNode(org.sparx.Element _e) {
		int i = 0;
		for (org.sparx.Connector c: _e.GetConnectors()) {
			if (c.GetClientID() == _e.GetElementID()) {
				i++;
			}
		}			
		return i>1;
	}

	private static boolean isJoinNode(org.sparx.Element _e) {
		int i = 0;
		for (org.sparx.Connector c: _e.GetConnectors()) {
			if (c.GetSupplierID() == _e.GetElementID()) {
				i++;
			}
		}
		return i>1;
	}
}
