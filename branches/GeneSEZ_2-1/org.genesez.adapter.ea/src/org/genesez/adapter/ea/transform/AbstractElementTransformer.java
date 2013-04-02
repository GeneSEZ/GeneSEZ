package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ProfileRegistry;


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

	protected void transformOperations() {
		for (org.sparx.Method m : this.eaElement.GetMethods()) {
			this.transformMethod(m);
		}
	}

	protected void transformAttribute(org.sparx.Attribute _a) {
		log.fatal("Transforming attributes is not implemented!");
	}

	
	/**
	 * Depending on the type of the connector the methods to transform are called
	 * 
	 * @param _c org.sparx.Connector
	 */
	protected void transformConnector(org.sparx.Connector _c) {
		
		// 
		final String connecterType = _c.GetType();
		
		if( connecterType.equals("Dependency")){
			log.debug("Connector is Dependency");
			ConnectorFactory.instance.addDependency(_c.GetConnectorGUID(), eaElement.GetParentID());
		}else if(connecterType.equals("Delegate")){			
			log.debug("Connector is Delegate");
			
			// if port, parent is other
			if(umlElement instanceof Port){
				ConnectorFactory.instance.addDelegate(_c.GetConnectorGUID(), eaElement.GetElementID());
			}else{
				ConnectorFactory.instance.addDelegate(_c.GetConnectorGUID(), eaElement.GetParentID());
			}
		}else if(connecterType.equals("InformationFlow")){
			log.debug("Connector is InformationFlow");
			ConnectorFactory.instance.addInformationFlow(_c, eaElement.GetParentID());
		}else if(connecterType.equals("Association")){
			log.debug("Connector is Association");
//			ConnectorFactory.instance.addAssociation(_c.GetConnectorGUID(), eaElement.GetElementID());
			ConnectorFactory.instance.addAssociation(_c);
		}else if(connecterType.equals("Realisation")){
			log.debug("Connector is Realisation");
			log.fatal("Connectors is not implemented!");
		}else if(connecterType.equals("Generalization")){
			log.debug("Connector is Generalization");
			log.fatal("Connectors is not implemented!");
		}
	}
	
	
	
	// ---------------------------------------------------------------------

	protected void transformElement(org.sparx.Element _e) {
		log.fatal("Transforming elements is not implemented!");
	}

	protected void transformMethod(org.sparx.Method _m) {
		log.fatal("Transforming methods is not implemented!");
	}

	protected void applyStereotypes() {
		log.debug("Applying stereotypes");
		for (String s : this.eaElement.GetStereotypeList().split(",")) {
			log.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.instance.getStereotype(s);
			if (this.umlElement.isStereotypeApplicable(st)) {
				log.debug("Apply stereotype " + st.getName());
				EObject o = this.umlElement.applyStereotype(st);
				if (null != o) {
					ContentRegistry.instance.addContent(o);
					this.applyTaggedValues(st);
				}
			}else{
				log.error("Stereotype is not applicable!");
			}
		}
	}
	
	private void applyTaggedValues(Stereotype _st) {
		log.debug("Applying tagged values");
		for (Property p : _st.getAttributes()) {
			log.debug("Tagged value " + p.getName());
			for (org.sparx.TaggedValue t : this.eaElement.GetTaggedValues()) {
				if (p.getName().equals(t.GetName())) {
					log.debug("Found use of tagged value " + p.getName());
					this.applyTaggedValue(_st, p, t);
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
	private void applyTaggedValue(Stereotype _st, Property _p,
			org.sparx.TaggedValue _t) {
		log.debug("Set tagged value " + _p.getName() + " to " + _t.GetValue());
		if (_p.getType().getName().equals("String")) {
			this.umlElement.setValue(_st, _p.getName(), _t.GetValue());
		} else if (_p.getType().getName().equals("Integer")) {
			this.umlElement.setValue(_st, _p.getName(),
					Integer.valueOf(_t.GetValue()));
		} else if (_p.getType().getName().equals("Boolean")) {
			this.umlElement.setValue(_st, _p.getName(),
					Boolean.valueOf(_t.GetValue()));
		} else if (_p.getType() instanceof Enumeration) {
			log.debug("Tagged value is an enumeration");
			Enumeration e = (Enumeration) _p.getType();
			EnumerationLiteral l = e.getOwnedLiteral(_t.GetValue());
			this.umlElement.setValue(_st, _p.getName(), l);
		} else {
			log.fatal("Setting tagged values of type " + _p.getType()
					+ " is not implemented");
		}
	}
}