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
import org.eclipse.uml2.uml.Type;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ProfileRegistry;
import org.sparx.ConnectorTag;

/**
 * Class for applying stereotypes
 * @author Christian
 */
public class ApplyStereotypeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ApplyStereotypeTransformer.class);
	
	public static final ApplyStereotypeTransformer INSTANCE = new ApplyStereotypeTransformer();
	
	// -- generated constructors --------------------------------------------
	/**
	 * private constructor for singleton
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
	 */
	public Element applyStereotypes(org.sparx.Connector eaConnector, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363362966451_255649_3119) ENABLED START */
		LOG.debug("Applying stereotypes for connectors");
		final String stereotypeName = eaConnector.GetStereotype();
		Stereotype st = ProfileRegistry.INSTANCE.getStereotype(stereotypeName);
		
		if (stereotypeName.length() == 0) {
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
	 * Applies one tagged value of a stereotype to the element
	 * @param	eaConnector	EA connector
	 * @param	umlElement	the UML element
	 * @param	st	The stereotype
	 */
	private Element applyTaggedValuesConnector(org.sparx.Connector eaConnector, Element umlElement, Stereotype st) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363036802_861473_3124) ENABLED START */
		LOG.debug("Applying tagged values");
		for (Property p : st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (ConnectorTag t : eaConnector.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName() + " to " + t.GetValue());
					umlElement = applyTaggedValue(umlElement, st, p, t.GetValue());
				}
			}
		}
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public Element applyStereotypes(org.sparx.Element eaElement, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363500708_64081_3152) ENABLED START */
		LOG.debug("Applying stereotypes for elements");
		for (String s : eaElement.GetStereotypeList().split(",")) {
			LOG.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.INSTANCE.getStereotype(s);
			// does the UML element fit the stereotype
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
	 */
	private void applyTaggedValuesElement(org.sparx.Element eaElement, Element umlElement, Stereotype st) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363363532753_365707_3157) ENABLED START */
		LOG.debug("Applying tagged values");
		for (Property p : st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (org.sparx.TaggedValue t : eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName() + " to " + t.GetValue());
					applyTaggedValue(umlElement, st, p, t.GetValue());
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the right Object from the propertyType. i.e. Boolean, Integer, etc.
	 * @param	property	The UML property
	 * @param	typeName	The name of the Tag.
	 * @return	The identified object. If not recognized, NULL is returned.
	 */
	private Object getObjectFromTypeName(Property property, String typeName) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1365775148844_86200_1966) ENABLED START */
		Type type = property.getType();
		if (type.getName().equals("String")) {
			return typeName;
		} else if (type.equals("Integer")) {
			return Integer.valueOf(typeName);
		} else if (type.getName().equals("Boolean")) {
			return Boolean.valueOf(typeName);
		} else if (type instanceof Enumeration) {
			LOG.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) type;
			EnumerationLiteral l = e.getOwnedLiteral(typeName);
			return l;
		} else {
			LOG.fatal("Setting tagged values of type " + property.getType() + " is not implemented");
		}
		
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private Element applyTaggedValue(Element umlElement, Stereotype stereotype, Property property, String eaTaggedValue) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1382082170566_514929_3797) ENABLED START */
		// get the right object from property type
		Object obj = getObjectFromTypeName(property, eaTaggedValue);
		umlElement.setValue(stereotype, property.getName(), obj);
		
		LOG.debug("The tagged value is " + obj != null ? obj.getClass() : "NULL");
		
		return umlElement;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363362878863_904654_3091) ENABLED START */
	// TODO here is some space to do optimization
	public Element applyStereotypes(org.sparx.Attribute eaAttribute, Element umlElement) {
		LOG.debug("Applying stereotypes for attribute ");
		final String stereotype = eaAttribute.GetStereotype();
		
		if (stereotype.length() == 0) {
			LOG.debug("No stereotype to apply.");
			return umlElement;
		}
		
		Stereotype st = ProfileRegistry.INSTANCE.getStereotype(stereotype);
		for (Stereotype s : st.getApplicableStereotypes()) {
			LOG.error("\t\t" + s.getName());
		}
		
		// does the UML element fit the stereotype
		if (umlElement.isStereotypeApplicable(st)) {
			LOG.debug("Apply stereotype " + st.getName());
			EObject o = umlElement.applyStereotype(st);
			if (null != o) {
				ContentRegistry.INSTANCE.addContent(o);
				applyTaggedValuesProperty(eaAttribute, umlElement, st);
			}
		} else {
			LOG.error("Stereotype eaAttribute(" + eaAttribute.GetName() + "), umlElement(" + umlElement.toString() + "), stereotype(" + st.getName() + ") is not applicable!");
		}
		return umlElement;
	}
	
	private void applyTaggedValuesProperty(org.sparx.Attribute eaAttribute, Element umlElement, Stereotype st) {
		LOG.debug("Applying tagged values");
		for (Property p : st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (org.sparx.AttributeTag t : eaAttribute.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName());
					applyTaggedValue(umlElement, st, p, t.GetValue());
				}
			}
		}
	}
	
	/* PROTECTED REGION END */
}
