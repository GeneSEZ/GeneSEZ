package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.sparx.Collection;

public class TransformHelper {

	private final static Log log = LogFactory.getLog(TransformHelper.class);
	private static XMIResource resource = null;

	// these are just helpers... maybe we'll beautify it some day
	private Map<String, ActivityEdge> edges = new HashMap<String, ActivityEdge>();
	private Map<Integer, Set<String>> edgeSources = new HashMap<Integer, Set<String>>();
	private Map<Integer, Set<String>> edgeTargets = new HashMap<Integer, Set<String>>();

	public void setResource(XMIResource r) {
		TransformHelper.resource = r;
	}
	
	/**
	 * Built the corresponding UML model of an EA model
	 * @param in	the EA package reference of the model
	 * @return		the UML model reference
	 */
	public Model transform(org.sparx.Package in) {
		Model m = UMLFactory.eINSTANCE.createModel();
		this.transform(in, m);
		return m;
	}
	/**
	 * Transforms an Enterprise Architect model into an UML model
	 * @param in	the EA package reference of the model
	 * @param out	the UML model reference
	 */
	public void transform(org.sparx.Package in, Model out) {
		log.info("Transforming Model: " + in.GetName());
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetPackageGUID());
		
		// Transform packages within model
		Collection<org.sparx.Package> pkgs = in.GetPackages();
		for (org.sparx.Package p : pkgs) {
			Package _p = out.createNestedPackage(p.GetName());
			this.transform(p, _p);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect package into an UML2 package
	 * @param in	the EA package reference
	 * @param out	the UML2 package reference
	 */
	public void transform(org.sparx.Package in, Package out) {
		log.info("Transforming Package: " + in.GetName());
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetPackageGUID());
		
		// Transform subpackages recursive
		Collection<org.sparx.Package> pkgs = in.GetPackages();
		for (org.sparx.Package p : pkgs) {
			Package _p = out.createNestedPackage(p.GetName());
			this.transform(p, _p);
		}

		// Transform elements in package (parentId == 0)
		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			if ( 0 == e.GetParentID() ) {
				ElementFactory.create(e, out, this);
			}
		}
	}
	
	/**
	 * Transforms an Enterprise Architect actor into an UML actor
	 * @param in	the EA actor reference
	 * @param out	the UML2 package reference
	 */
	public void transform(org.sparx.Element in, Actor out) {
		log.info("Transforming Actor: " + in.GetName());
		this.basicTransform(in, out);
		log.info("Actor transformed");
	}

	/**
	 * Transforms an Enterprise Architect usecase into an UML usecase
	 * @param in	the EA usecase reference
	 * @param out	the UML2 usecase reference
	 */
	public void transform(org.sparx.Element in, UseCase out) {
		log.info("Transforming UseCase: " + in.GetName());
		this.basicTransform(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out, this);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect activity into an UML activity
	 * @param in	the EA activity reference
	 * @param out	the UML2 activity reference
	 */
	public void transform(org.sparx.Element in, Activity out) {
		log.info("Transforming Activity: " + in.GetName());
		this.basicTransform(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			for (org.sparx.Connector c : e.GetConnectors()) {
				// Connectors are always found two times:
				// At the source node and at the target node
				if (this.edges.containsKey(c.GetConnectorGUID())) {
					continue;
				}
				
				ElementFactory.create(c, out, this);
			}
		}

		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out, this);
		}
	}

	/**
	 * 
	 */
	public void transform(org.sparx.Connector in, ControlFlow out) {
		log.info("Transforming ControlFlow: " + in.GetName());
		this.basicTransform(in, out);

		// remember the connector guid and the corresponding ActivityEdge
		this.edges.put(in.GetConnectorGUID(), out);

		// create a dummy HashSet for the connectors guid 
		HashSet<String> connectorGuid = new HashSet<String>();
		connectorGuid.add(in.GetConnectorGUID());
		// add the connector to its sources connector list
		if (this.edgeSources.containsKey(in.GetClientID())) {
			this.edgeSources.get(in.GetClientID()).addAll(connectorGuid);
		} else {
			this.edgeSources.put(in.GetClientID(), connectorGuid);
		}
		// add the connector to its targets connector list
		if (this.edgeTargets.containsKey(in.GetSupplierID())) {
			this.edgeTargets.get(in.GetSupplierID()).addAll(connectorGuid);
		} else {
			this.edgeTargets.put(in.GetSupplierID(), connectorGuid);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect action into an UML action
	 * @param in	the EA action reference
	 * @param out	the UML2 action reference
	 */
	public void transform(org.sparx.Element in, Action out) {
		log.info("Transforming Action: " + in.GetName());
		this.basicTransform(in, out);
		this.applyEdges(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out, this);
		}
	}

	/**
	 * Transforms an Enterprise Architect initialnode into an UML initialnode
	 * @param in	the EA initialnode reference
	 * @param out	the UML2 initialnode reference
	 */
	public void transform(org.sparx.Element in, InitialNode out) {
		log.info("Transforming IntitialNode: " + in.GetName());
		this.basicTransform(in, out);
		this.applyEdges(in, out);
	}

	/**
	 * Transforms an Enterprise Architect finalnode into an UML finalnode
	 * @param in	the EA finalnode reference
	 * @param out	the UML2 finalnode reference
	 */
	public void transform(org.sparx.Element in, FinalNode out) {
		log.info("Transforming FinalNode: " + in.GetName());
		this.basicTransform(in, out);
		this.applyEdges(in, out);
	}
	
	/**
	 * Basic transformations for all elements
	 * @param in	the EA element reference
	 * @param out	the UML named element reference 
	 */
	private void basicTransform(org.sparx.Element in, NamedElement out) {
		log.debug("Starting basic transformation for Element");
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetElementGUID());
		this.applyStereotypes(in, out);
	}

	/**
	 * Basic transformations for all connectors
	 * @param in	the EA connector reference
	 * @param out	the UML named element reference 
	 */
	private void basicTransform(org.sparx.Connector in, NamedElement out) {
		log.debug("Starting basic transformation for Connector");
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetConnectorGUID());
	}

	/**
	 * Applies the source and target activity nodes to the activity edges 
	 * @param in
	 * @param out
	 */
	private void applyEdges(org.sparx.Element in, ActivityNode out) {
		
		if (this.edgeSources.containsKey(in.GetElementID())) {
			log.debug("Outgoing Flows:" + this.edgeSources.get(in.GetElementID()).size());
			for (String connectorGuid: this.edgeSources.get(in.GetElementID()) ) {
				this.edges.get(connectorGuid).setSource(out);
			}
		}
		
		if (this.edgeTargets.containsKey(in.GetElementID())) {
			log.debug("Incoming Flows:" + this.edgeTargets.get(in.GetElementID()).size());
			for (String connectorGuid: this.edgeTargets.get(in.GetElementID()) ) {
				this.edges.get(connectorGuid).setTarget(out);
			}
		}
	}
	
	/**
	 * Apply stereotypes to elements
	 * @param in	the EA element reference
	 * @param out	the UML named element reference
	 */
	private void applyStereotypes(org.sparx.Element in, NamedElement out) {
		log.info("Applying Stereotypes: " + in.GetName());
		
//		// Read and apply stereotypes
//		for (String s : in.GetStereotypeList().split(",")) {
//			log.info("Apply stereotype " + s);
//		}
//		
//		// Set tagged values
//		Collection<org.sparx.TaggedValue> tgvs = in.GetTaggedValues();
//		for (org.sparx.TaggedValue t : tgvs) {
//			log.info("Set tagged value" + t.GetName() + " to " + t.GetValue());
//		}
	}
}
