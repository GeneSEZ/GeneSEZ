package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class ComponentTransformer extends AbstractElementTransformer{

	private static final Log log = LogFactory.getLog(ComponentTransformer.class);
	
	Component transform(org.sparx.Element _e, org.eclipse.uml2.uml.Package _parent) {
		log.debug("Creating Component " + _e.GetName() + ", parent " + _parent.getName());
		Component component = UMLFactory.eINSTANCE.createComponent();
		component.setName(_e.GetName());
		_parent.getPackagedElements().add(component);
		
		this.umlElement = component;
		this.eaElement = _e;

		this.transformElements();
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, component);
		return component;
	}
	
	@Override
	protected void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName() + ", type: "+_e.GetType());
		
		if ( _e.GetType().equals("Port") ) {
			log.debug("Element is a Port");
			PortTransformer t = new PortTransformer();
			t.transform(_e, (Component) this.umlElement);
		}
	}
	
	@Override
	protected void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName() + ", type: "+_c.GetType());
		
		if ( _c.GetType().equals("Dependency") ) {
			log.debug("Connector is a dependency");
			DependencyTransformer t = new DependencyTransformer();
			t.transform(_c, (Component) this.umlElement);
		}		
	}
	
}
