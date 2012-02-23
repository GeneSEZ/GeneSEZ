package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ProfileRegistry;
import org.sparx.ConnectorTag;


public class ApplyStereotypeTransformer {
	
	private static final Log log = LogFactory.getLog(ApplyStereotypeTransformer.class);
		
	// Connector
	//------------------------------------------------------------------------
	
	/**
	 * overwrites the default method to apply the stereotypes, beecause SPARX
	 * allows only one stereotype for connectors
	 *  
	 */
	public static Element applyStereotypes(org.sparx.Connector eaElement,
			Element umlElement) {
		log.debug("Applying stereotypes");
		String s = eaElement.GetStereotype();
		Stereotype st = ProfileRegistry.instance.getStereotype(s);

		if (umlElement.isStereotypeApplicable(st)) {
			log.debug("Apply stereotype " + st.getName());
			EObject o = umlElement.applyStereotype(st);
			if (null != o) {
				ContentRegistry.instance.addContent(o);
				umlElement = applyTaggedValuesConnetor(eaElement, umlElement,
						st);
			}
		} else {
			log.error("Stereotype is not applicable!");
		}
		return umlElement;
	}
	
	private static Element applyTaggedValuesConnetor(org.sparx.Connector eaElement, Element umlElement, Stereotype _st) {
		log.debug("Applying tagged values");
		for (Property p : _st.getAttributes()) {
			log.debug("Tagged value " + p.getName());
			for (ConnectorTag t : eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					log.debug("Found use of tagged value " + p.getName());
					umlElement = applyTaggedValueConnector(umlElement, _st, p, t);
				}
			}
		}
		return umlElement;
	}
	
	/**
	 * Applies one tagged value of a stereotype to the element
	 * 
	 * @param _st
	 *            The stereotype
	 * @param _p
	 *            The property of the tagged value
	 * @param t
	 *            The tagged value from the model
	 */
	private static Element applyTaggedValueConnector(Element umlElement, Stereotype _st, Property _p,
			ConnectorTag t) {
		log.debug("Set tagged value " + _p.getName() + " to " + t.GetValue());
		if (_p.getType().getName().equals("String")) {
			umlElement.setValue(_st, _p.getName(), t.GetValue());
		} else if (_p.getType().getName().equals("Integer")) {
			umlElement.setValue(_st, _p.getName(),
					Integer.valueOf(t.GetValue()));
		} else if (_p.getType().getName().equals("Boolean")) {
			umlElement.setValue(_st, _p.getName(),
					Boolean.valueOf(t.GetValue()));
		} else if (_p.getType() instanceof Enumeration) {
			log.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) _p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(t.GetValue());
			umlElement.setValue(_st, _p.getName(), l);
		} else {
			log.fatal("Setting tagged values of type " + _p.getType()
					+ " is not implemented");
		}
		return umlElement;
	}
	
		
	// Element
	//------------------------------------------------------------------------
	
	public static Element applyStereotypes(org.sparx.Element eaElement, Element umlElement) {
		log.debug("Applying stereotypes");
		for (String s : eaElement.GetStereotypeList().split(",")) {
			log.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.instance.getStereotype(s);
			if (umlElement.isStereotypeApplicable(st)) {
				log.debug("Apply stereotype " + st.getName());
				EObject o = umlElement.applyStereotype(st);
				if (null != o) {
					ContentRegistry.instance.addContent(o);
					applyTaggedValuesElement(eaElement,umlElement, st);
				}
			}else{
				log.error("Stereotype is not applicable!");
			}
		}
		return umlElement;
	}
	
	private static void applyTaggedValuesElement(org.sparx.Element eaElement, Element umlElement, Stereotype _st) {
		log.debug("Applying tagged values");
		for (Property p : _st.getAttributes()) {
			log.debug("Tagged value " + p.getName());
			for (org.sparx.TaggedValue t : eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					log.debug("Found use of tagged value " + p.getName());
					applyTaggedValueElement(umlElement, _st, p, t);
				}
			}
		}
	}

	/**
	 * Applies one tagged value of a stereotype to the element
	 * 
	 * @param _st
	 *            The stereotype
	 * @param _p
	 *            The property of the tagged value
	 * @param _t
	 *            The tagged value from the model
	 */
	private static void applyTaggedValueElement(Element umlElement, Stereotype _st, Property _p,
			org.sparx.TaggedValue _t) {
		log.debug("Set tagged value " + _p.getName() + " to " + _t.GetValue());
		if (_p.getType().getName().equals("String")) {
			umlElement.setValue(_st, _p.getName(), _t.GetValue());
		} else if (_p.getType().getName().equals("Integer")) {
			umlElement.setValue(_st, _p.getName(),
					Integer.valueOf(_t.GetValue()));
		} else if (_p.getType().getName().equals("Boolean")) {
			umlElement.setValue(_st, _p.getName(),
					Boolean.valueOf(_t.GetValue()));
		} else if (_p.getType() instanceof Enumeration) {
			log.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) _p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(_t.GetValue());
			umlElement.setValue(_st, _p.getName(), l);
		} else {
			log.fatal("Setting tagged values of type " + _p.getType()
					+ " is not implemented");
		}
	}
}
