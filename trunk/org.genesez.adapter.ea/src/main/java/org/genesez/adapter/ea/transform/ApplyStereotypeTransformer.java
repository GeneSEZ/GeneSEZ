package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363362878863_904654_3091) 
 */

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
import org.sparx.TaggedValue;

/**
 * Class for transforming stereotypes
 * @author christian
 */

public class ApplyStereotypeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ApplyStereotypeTransformer.class);
	
	public static final ApplyStereotypeTransformer INSTANCE = new ApplyStereotypeTransformer();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ApplyStereotypeTransformer</b></em>'.
	 */
	
	private ApplyStereotypeTransformer() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363363248225_847078_3134) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * overwrites the default method to apply the stereotypes, because SPARX
	 * allows only one stereotype for connectors
	 * @param	eaConnector	
	 * @param	umlElement	
	 * @return	
	 */
	
	public Element applyStereotypes(org.sparx.Connector eaConnector, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362966451_255649_3119) ENABLED START */
		LOG.debug("Applying stereotypes for connectors");
		String s = eaConnector.GetStereotype();
		Stereotype st = ProfileRegistry.INSTANCE.getStereotype(s);
		
		if (s.length() == 0) {
			LOG.debug("No stereotype to apply, going on...");
			return umlElement;
		}
		
		if (umlElement.isStereotypeApplicable(st)) {
			LOG.debug("Apply stereotype " + st.getName());
			EObject o = umlElement.applyStereotype(st);
			if (null != o) {
				ContentRegistry.INSTANCE.addContent(o);
				umlElement = applyTaggedValuesConnector(eaConnector, umlElement, st);
			}
		} else {
			LOG.error("Stereotype connector is not applicable!");
		}
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	eaConnector	
	 * @param	umlElement	
	 * @param	st	
	 * @return	
	 */
	
	private Element applyTaggedValuesConnector(org.sparx.Connector eaConnector, Element umlElement, Stereotype st) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363036802_861473_3124) ENABLED START */
		LOG.debug("Applying tagged values");
		for (Property p : st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (ConnectorTag t : eaConnector.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName());
					umlElement = applyTaggedValueConnector(umlElement, st, p, t);
				}
			}
		}
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Applies one tagged value of a stereotype to the element
	 * @param	umlElement	
	 * @param	_st	The stereotype
	 * @param	_p	The property of the tagged value
	 * @param	t	The tagged value from the model
	 * @return	
	 */
	
	private Element applyTaggedValueConnector(Element umlElement, Stereotype _st, Property _p, org.sparx.ConnectorTag t) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363073292_705579_3129) ENABLED START */
		LOG.debug("Set tagged value " + _p.getName() + " to " + t.GetValue());
		if (_p.getType().getName().equals("String")) {
			umlElement.setValue(_st, _p.getName(), t.GetValue());
		} else if (_p.getType().getName().equals("Integer")) {
			umlElement.setValue(_st, _p.getName(), Integer.valueOf(t.GetValue()));
		} else if (_p.getType().getName().equals("Boolean")) {
			umlElement.setValue(_st, _p.getName(), Boolean.valueOf(t.GetValue()));
		} else if (_p.getType() instanceof Enumeration) {
			LOG.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) _p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(t.GetValue());
			umlElement.setValue(_st, _p.getName(), l);
		} else {
			LOG.fatal("Setting tagged values of type " + _p.getType() + " is not implemented");
		}
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	eaElement	
	 * @param	umlElement	
	 * @return	
	 */
	
	public Element applyStereotypes(org.sparx.Element eaElement, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363500708_64081_3152) ENABLED START */
		LOG.debug("Applying stereotypes for elements");
		for (String s : eaElement.GetStereotypeList().split(",")) {
			LOG.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.INSTANCE.getStereotype(s);
			if (umlElement.isStereotypeApplicable(st)) {
				LOG.debug("Apply stereotype " + st.getName());
				EObject o = umlElement.applyStereotype(st);
				if (null != o) {
					ContentRegistry.INSTANCE.addContent(o);
					applyTaggedValuesElement(eaElement, umlElement, st);
				}
			} else {
				LOG.error("Stereotype eaElement(" + eaElement.GetName() + "), umlElement(" + umlElement.toString() + "), stereotype(" + s + ") is not applicable!");
			}
		}
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	eaElement	
	 * @param	umlElement	
	 * @param	_st	
	 */
	
	private void applyTaggedValuesElement(org.sparx.Element eaElement, Element umlElement, Stereotype _st) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363532753_365707_3157) ENABLED START */
		LOG.debug("Applying tagged values");
		for (Property p : _st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (org.sparx.TaggedValue t : eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName());
					applyTaggedValueElement(umlElement, _st, p, t);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	umlElement	
	 * @param	_st	
	 * @param	_p	
	 * @param	_t	
	 */
	
	private void applyTaggedValueElement(Element umlElement, Stereotype _st, Property _p, TaggedValue _t) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363756025_154382_3164) ENABLED START */
		LOG.debug("Set tagged value " + _p.getName() + " to " + _t.GetValue());
		if (_p.getType().getName().equals("String")) {
			umlElement.setValue(_st, _p.getName(), _t.GetValue());
		} else if (_p.getType().getName().equals("Integer")) {
			umlElement.setValue(_st, _p.getName(), Integer.valueOf(_t.GetValue()));
		} else if (_p.getType().getName().equals("Boolean")) {
			umlElement.setValue(_st, _p.getName(), Boolean.valueOf(_t.GetValue()));
		} else if (_p.getType() instanceof Enumeration) {
			LOG.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) _p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(_t.GetValue());
			umlElement.setValue(_st, _p.getName(), l);
		} else {
			LOG.fatal("Setting tagged values of type " + _p.getType() + " is not implemented");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363362878863_904654_3091) ENABLED START */
	
	/* PROTECTED REGION END */
	
}
