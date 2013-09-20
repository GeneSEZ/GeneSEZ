package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1357563324577_635875_1695) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ProfileRegistry;
import org.sparx.TaggedValue;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public abstract class AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(AbstractElementTransformer.class);
	
	protected Element umlElement;
	
	protected org.sparx.Element eaElement;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	
	protected void transformAttributes() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1357565403570_546712_1773) ENABLED START */
		for (org.sparx.Attribute a : this.eaElement.GetAttributes()) {
			this.transformAttribute(a);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	protected void transformConnectors() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1357565410361_791740_1776) ENABLED START */
		for (org.sparx.Connector c : this.eaElement.GetConnectors()) {
			this.transformConnector(c);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	protected void transformOperations() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1357565416366_597788_1779) ENABLED START */
		for (org.sparx.Method m : this.eaElement.GetMethods()) {
			this.transformMethod(m);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	protected void transformElements() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363080056207_931839_1949) ENABLED START */
		for (org.sparx.Element e : this.eaElement.GetElements()) {
			this.transformElement(e);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	a	
	 */
	
	protected void transformAttribute(org.sparx.Attribute a) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363080688547_362826_1967) ENABLED START */
		LOG.fatal("Transforming attributes is not implemented!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 */
	
	protected void transformElement(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363080696863_169046_1970) ENABLED START */
		LOG.fatal("Transforming elements is not implemented!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Depending on the type of the connector the methods to transform are called
	 * @param	c	
	 */
	
	protected void transformConnector(org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363081551636_874988_1977) ENABLED START */
		final String connecterType = c.GetType();
		
		if (connecterType.equals("Dependency")) {
			LOG.debug("Connector is Dependency");
			ConnectorFactory.INSTANCE.addDependency(c.GetConnectorGUID(), eaElement.GetParentID());
		} else if (connecterType.equals("Delegate")) {
			LOG.debug("Connector is Delegate");
			
			// if port, parent is other
			if (umlElement instanceof Port) {
				ConnectorFactory.INSTANCE.addDelegate(c.GetConnectorGUID(), eaElement.GetElementID());
			} else {
				ConnectorFactory.INSTANCE.addDelegate(c.GetConnectorGUID(), eaElement.GetParentID());
			}
		} else if (connecterType.equals("InformationFlow")) {
			LOG.debug("Connector is InformationFlow");
			ConnectorFactory.INSTANCE.addInformationFlow(c, eaElement.GetParentID());
		} else if (connecterType.equals("Association")) {
			LOG.debug("Connector is Association");
			// ConnectorFactory.instance.addAssociation(_c.GetConnectorGUID(),
			// eaElement.GetElementID());
			ConnectorFactory.INSTANCE.addAssociation(c);
		} else if (connecterType.equals("Realisation")) {
			LOG.debug("Connector is Realisation");
			LOG.fatal("Connectors is Realisation and not implemented yet!");
		} else if (connecterType.equals("Generalization")) {
			LOG.debug("Connector is Generalization");
			ConnectorFactory.INSTANCE.addGeneralisation(c);		
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	m	
	 */
	
	protected void transformMethod(org.sparx.Method m) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363082244430_575349_1987) ENABLED START */
		LOG.fatal("Transforming methods is not implemented!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	protected void applyStereotypes() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363082262737_224445_1990) ENABLED START */
		LOG.debug("Applying stereotypes");
		for (String s : this.eaElement.GetStereotypeList().split(",")) {
			LOG.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.INSTANCE.getStereotype(s);
			if (this.umlElement.isStereotypeApplicable(st)) {
				LOG.debug("Apply stereotype " + st.getName());
				EObject o = this.umlElement.applyStereotype(st);
				if (null != o) {
					ContentRegistry.INSTANCE.addContent(o);
					this.applyTaggedValues(st);
				}
			} else {
				LOG.error("Stereotype is not applicable!");
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	st	
	 */
	
	private void applyTaggedValues(Stereotype st) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363082297954_439260_1993) ENABLED START */
		LOG.debug("Applying tagged values");
		for (Property p : st.getAttributes()) {
			LOG.debug("Tagged value " + p.getName());
			for (org.sparx.TaggedValue t : this.eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					LOG.debug("Found use of tagged value " + p.getName());
					this.applyTaggedValue(st, p, t);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Applies one tagged value of a stereotype to the element
	 * @param	st	The stereotype
	 * @param	p	The property of the tagged value
	 * @param	t	The tagged value from the model
	 */
	
	private void applyTaggedValue(Stereotype st, Property p, TaggedValue t) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363082373669_76011_2000) ENABLED START */
		LOG.debug("Set tagged value " + p.getName() + " to " + t.GetValue());
		if (p.getType().getName().equals("String")) {
			this.umlElement.setValue(st, p.getName(), t.GetValue());
		} else if (p.getType().getName().equals("Integer")) {
			this.umlElement.setValue(st, p.getName(), Integer.valueOf(t.GetValue()));
		} else if (p.getType().getName().equals("Boolean")) {
			this.umlElement.setValue(st, p.getName(), Boolean.valueOf(t.GetValue()));
		} else if (p.getType() instanceof Enumeration) {
			LOG.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(t.GetValue());
			this.umlElement.setValue(st, p.getName(), l);
		} else {
			LOG.fatal("Setting tagged values of type " + p.getType() + " is not implemented");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1357563324577_635875_1695) ENABLED START */
	
	// :)
	
	/* PROTECTED REGION END */
	
}
