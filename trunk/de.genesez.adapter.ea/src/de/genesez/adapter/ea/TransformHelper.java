package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.FinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.sparx.Collection;

public class TransformHelper {

	private final static Log log = LogFactory.getLog(XmiWriter.class);
	private static XMIResource resource = null;
	
	public static void setResource(XMIResource r) {
		TransformHelper.resource = r;
	}
	
	/**
	 * Built the corresponding UML model of an EA model
	 * @param in	the EA package reference of the model
	 * @return		the UML model reference
	 */
	public static Model transform(org.sparx.Package in) {
		Model m = UMLFactory.eINSTANCE.createModel();
		TransformHelper.transform(in, m);
		return m;
	}
	/**
	 * Transforms an Enterprise Architect model into an UML model
	 * @param in	the EA package reference of the model
	 * @param out	the UML model reference
	 */
	public static void transform(org.sparx.Package in, Model out) {
		log.info("Transforming Model: " + in.GetName());
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetPackageGUID());
		
		// Transform packages within model
		Collection<org.sparx.Package> pkgs = in.GetPackages();
		for (org.sparx.Package p : pkgs) {
			Package _p = out.createNestedPackage(p.GetName());
			TransformHelper.transform(p, _p);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect package into an UML2 package
	 * @param in	the EA package reference
	 * @param out	the UML2 package reference
	 */
	public static void transform(org.sparx.Package in, Package out) {
		log.info("Transforming Package: " + in.GetName());
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetPackageGUID());
		
		// Transform subpackages recursive
		Collection<org.sparx.Package> pkgs = in.GetPackages();
		for (org.sparx.Package p : pkgs) {
			Package _p = out.createNestedPackage(p.GetName());
			TransformHelper.transform(p, _p);
		}

		// Transform elements in package (parentId == 0)
		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			if ( 0 == e.GetParentID() ) {
				ElementFactory.create(e, out);
			}
		}
	}
	
	/**
	 * Transforms an Enterprise Architect actor into an UML actor
	 * @param in	the EA actor reference
	 * @param out	the UML2 package reference
	 */
	public static void transform(org.sparx.Element in, Actor out) {
		log.info("Transforming Actor: " + in.GetName());
		basicTransform(in, out);
	}

	/**
	 * Transforms an Enterprise Architect usecase into an UML usecase
	 * @param in	the EA usecase reference
	 * @param out	the UML2 usecase reference
	 */
	public static void transform(org.sparx.Element in, UseCase out) {
		log.info("Transforming UseCase: " + in.GetName());
		basicTransform(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect activity into an UML activity
	 * @param in	the EA activity reference
	 * @param out	the UML2 activity reference
	 */
	public static void transform(org.sparx.Element in, Activity out) {
		log.info("Transforming Activity: " + in.GetName());
		basicTransform(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out);
		}
	}
	
	/**
	 * Transforms an Enterprise Architect action into an UML action
	 * @param in	the EA action reference
	 * @param out	the UML2 action reference
	 */
	public static void transform(org.sparx.Element in, Action out) {
		log.info("Transforming Action: " + in.GetName());
		basicTransform(in, out);

		Collection<org.sparx.Element> elms = in.GetElements();
		for (org.sparx.Element e : elms) {
			ElementFactory.create(e, out);
		}
	}

	/**
	 * Transforms an Enterprise Architect initialnode into an UML initialnode
	 * @param in	the EA initialnode reference
	 * @param out	the UML2 initialnode reference
	 */
	public static void transform(org.sparx.Element in, InitialNode out) {
		log.info("Transforming IntitialNode: " + in.GetName());
		basicTransform(in, out);
	}

	/**
	 * Transforms an Enterprise Architect finalnode into an UML finalnode
	 * @param in	the EA finalnode reference
	 * @param out	the UML2 finalnode reference
	 */
	public static void transform(org.sparx.Element in, FinalNode out) {
		log.info("Transforming FinalNode: " + in.GetName());
		basicTransform(in, out);
	}
	
	/**
	 * Basic transformations for all elements
	 * @param in	the EA element reference
	 * @param out	the UML named element reference 
	 */
	private static void basicTransform(org.sparx.Element in, NamedElement out) {
		out.setName(in.GetName());
		TransformHelper.resource.setID(out, in.GetElementGUID());
		TransformHelper.applyStereotypes(in, out);
	}
	
	/**
	 * Apply stereotypes to elements
	 * @param in	the EA element reference
	 * @param out	the UML named element reference
	 */
	private static void applyStereotypes(org.sparx.Element in, NamedElement out) {
		log.info("Transforming FinalNode: " + in.GetName());
		
		// Read and apply stereotypes
		for (String s : in.GetStereotypeList().split(",")) {
			log.info("Apply stereotype " + s);
		}
		
		// Set tagged values
		Collection<org.sparx.TaggedValue> tgvs = in.GetTaggedValues();
		for (org.sparx.TaggedValue t : tgvs) {
			log.info("Set tagged value" + t.GetName() + " to " + t.GetValue());
		}
	}
}
