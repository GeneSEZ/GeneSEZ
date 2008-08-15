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
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class ActivityTransformer {

	private static final Log log = LogFactory.getLog(ActivityTransformer.class);
	private Activity activity;

	private Map<String, ActivityEdge> edges = new HashMap<String, ActivityEdge>();
	private Map<Integer, Set<String>> edgeSources = new HashMap<Integer, Set<String>>();
	private Map<Integer, Set<String>> edgeTargets = new HashMap<Integer, Set<String>>();

	Activity transform(org.sparx.Element _e, BehavioredClassifier _parent) {
		log.debug("Creating Activity " + _e.GetName() + ", parent " + _parent.getName());
		this.activity = (Activity) _parent.createOwnedBehavior(_e.GetName(),
				UMLFactory.eINSTANCE.createActivity().eClass());
		this.transform(_e);
		XmiFile.instance.addElement(this.activity, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.activity);
		return this.activity;
	}

	Activity transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating Activity " + _e.GetName() + ", parent " + _parent.getName());
		this.activity = UMLFactory.eINSTANCE.createActivity();
		this.activity.setName(_e.GetName());
		this.activity.setPackage(_parent);
		this.transform(_e);
		XmiFile.instance.addElement(this.activity, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.activity);
		return this.activity;
	}
	
	private void transform(org.sparx.Element _e) {

		// Transform the Connectors of all children of the Activity,
		// because the Edges should be contained by the Activity
		// before adding the children Nodes
		for (org.sparx.Element e : _e.GetElements()) {
			for (org.sparx.Connector c : e.GetConnectors()) {
				// Connectors are always found two times:
				// At the source node and at the target node
				if (this.edges.containsKey(c.GetConnectorGUID())) {
					continue;
				}
				this.transformConnector(c);
			}
		}

		for (org.sparx.Element e : _e.GetElements()) {
			this.transformElement(e);
		}
	}

	private void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName());
		
		if (_c.GetType().equals("ControlFlow")) {
			log.debug("Connector is a ControlFlow");
			ControlFlowTransformer t = new ControlFlowTransformer();
			this.addActivityEdge(_c, t.transform(_c, this.activity));
		}
	}
	
	private void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName());

		if ( _e.GetType().equals("Action") && _e.GetClassfierID() > 0 ) {
			log.debug("Element is a CallBehaviorAction");
			CallBehaviorActionTransformer t = new CallBehaviorActionTransformer();
			ActivityNode node = t.transform(_e, this.activity);
			this.applyActivityEdges(_e, node);
		}
		else if ( _e.GetType().equals("Action") ) {
			log.debug("Element is an Action");
			CallOperationActionTransformer t = new CallOperationActionTransformer();
			ActivityNode node = t.transform(_e, this.activity);
			this.applyActivityEdges(_e, node);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 100 ) {
			log.debug("Element is an InitialNode");
			InitialNodeTransformer t = new InitialNodeTransformer();
			ActivityNode node = t.transform(_e, this.activity);
			this.applyActivityEdges(_e, node);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 101 ) {
			log.debug("Element is an ActivityFinialNode");
			ActivityFinalNodeTransformer t = new ActivityFinalNodeTransformer();
			ActivityNode node = t.transform(_e, this.activity);
			this.applyActivityEdges(_e, node);
		}
		else if ( _e.GetType().equals("StateNode") && _e.GetSubtype() == 102 ) {
			log.debug("Element is an FlowFinalNode");
			FlowFinalNodeTransformer t = new FlowFinalNodeTransformer();
			ActivityNode node = t.transform(_e, this.activity);
			this.applyActivityEdges(_e, node);
		}
		else if ( _e.GetType().equals("Activity") ) {
			log.debug("Element is an Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(_e, this.activity);
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
}
