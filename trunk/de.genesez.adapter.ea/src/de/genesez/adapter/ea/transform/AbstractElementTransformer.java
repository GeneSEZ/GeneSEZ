package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

import de.genesez.adapter.ea.ContentRegistry;
import de.genesez.adapter.ea.ProfileRegistry;

public abstract class AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(AbstractElementTransformer.class);
	protected Element umlElement = null;
	protected org.sparx.Element eaElement = null;

	protected void transformAttributes() {
		for (org.sparx.Attribute a : this.eaElement.GetAttributes()) {
			this.transformAttribute(a);
		}
	}

	protected void transformConnectors() {
		for (org.sparx.Connector c : this.eaElement.GetConnectors()) {
			this.transformConnector(c);
		}
	}

	protected void transformElements() {
		for (org.sparx.Element e : this.eaElement.GetElements()) {
			this.transformElement(e);
		}
	}

	protected void transformAttribute(org.sparx.Attribute _a) {
		log.fatal("Transforming attributes is not implemented!");
	}
	
	protected void transformConnector(org.sparx.Connector _c) {
		log.fatal("Transforming connectors is not implemented!");
	}
	
	protected void transformElement(org.sparx.Element _e) {
		log.fatal("Transforming elements is not implemented!");
	}

	protected void applyStereotypes() {
		log.debug("Applying stereotypes");
		for (String s : this.eaElement.GetStereotypeList().split(",")) {
			log.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.instance.getStereotype(s);
			if (this.umlElement.isStereotypeApplicable(st)) {
				log.debug("Apply stereotype " + st.getName() );
				EObject o = this.umlElement.applyStereotype(st);
				if (null != o) {
					ContentRegistry.instance.addContent(o);
				}
			}
		}
	}
}
