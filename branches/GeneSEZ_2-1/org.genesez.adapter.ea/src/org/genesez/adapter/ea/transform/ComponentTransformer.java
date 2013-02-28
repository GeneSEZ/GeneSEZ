package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;


/**
 * transforms all components
 * 
 * @author gerbe
 * @author christian
 * @version 4
 * 
 */

public class ComponentTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory
			.getLog(ComponentTransformer.class);

	private org.eclipse.uml2.uml.Package umlPackage = null;

	/**
	 * the actual component transformer the returns the emf uml component
	 * 
	 * @param _e org.sparx.Element to transform
	 * @param _parent package
	 * @return component
	 */
	Component transform(org.sparx.Element _e,
			org.eclipse.uml2.uml.Package _parent) {

		Component component = UMLFactory.eINSTANCE.createComponent();
		component.setName(_e.GetName());

		// DEBUGGING
//		ElementDebugger.INSTANCE.printElement(_e);

		// set package for methods
		this.umlPackage = _parent;
		// set default variables
		this.umlElement = component;
		this.eaElement = _e;

		// if component is an instance of a component
		final int classfierId = _e.GetClassfierID();
//		boolean addElement = true;
		if (classfierId != 0) {
			
			Component comp = (Component) ElementRegistry.instance
					.getById(classfierId);
			log.debug("Creating instance of Component " + _e.GetName() + ":" + comp.getName());
			// createInstanceSpecification(_e, comp);
			component.setName(_e.GetName() + ":" + comp.getName());
			this.umlPackage.getPackagedElements().add(component);
			// addElement = false;
		} else {
			this.umlPackage.getPackagedElements().add(component);
			log.debug("Creating Component " + _e.GetName() + ", parent "
					+ _parent.getName() + ", id: " + _e.GetElementID());
		}

		// apply the stereotype of the component
		ApplyStereotypeTransformer.applyStereotypes(eaElement, umlElement);

		// transform others
		this.transformElements();
		
//		for(org.sparx.Element e : _e.GetElements())
//			this.transformRecursive(e, component);
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();

		// if it's no instance add to registry
		// if(addElement)
		ElementRegistry.instance.addElement(_e, component);
		return component;
	}

	/**
	 * creates an interface specification when a component is an instance
	 * 
	 * @param _e
	 * @param comp
	 * 
	 * @deprecated
	 */
	private void createInstanceSpecification(org.sparx.Element _e,
			Component comp) {
		log.debug("Element is an instance of a component -> creating an instance specification (Classifier: "
				+ comp.getName() + ")");
		InstanceSpecification instance = UMLFactory.eINSTANCE
				.createInstanceSpecification();
		instance.getClassifiers().add(comp);
		instance.setName(_e.GetName());
		umlPackage.getPackagedElements().add(instance);
		ElementRegistry.instance.addElement(_e, instance);
	}

	/**
	 * transforms all components rekursive that exist in the component
	 * @param _e
	 * @param nextComponent
	 * 
	 */
	private void transformRecursive(org.sparx.Element _e, Component nextComponent){
		log.debug("Transforming element " + _e.GetName() + ", type: "
				+ _e.GetType() + ", id: " + _e.GetElementID());
		log.debug("Basic UML element =" + ((Component)this.umlElement).getName()	);

		if (_e.GetType().equals("Port")) {
			log.debug("Element is a Port");
			PortTransformer t = new PortTransformer();
			t.transform(_e, nextComponent);
		} else if (_e.GetType().equals("Component")) {
			final int classifierId = _e.GetClassifierID();
			Component comp = (Component) ElementRegistry.instance.getById(classifierId);
			Component component = null;

			if (classifierId != 0) {
				log.debug("Creating instance of Component " + _e.GetName() + ":" + comp.getName());
				component = UMLFactory.eINSTANCE.createComponent();
				component.setName(_e.GetName() + ":" + comp.getName());
				// add the component the parent component
				nextComponent.getPackagedElements().add(component);
			} else {
				log.debug("Creating Component " + _e.GetName() + ", parent "
						+ comp.getName() + ", id: " + _e.GetElementID());
				component = UMLFactory.eINSTANCE.createComponent();
				component.setName(_e.GetName());
				comp.getPackagedElements().add(component);
			}
			// apply stereotypes
			component = (Component) ApplyStereotypeTransformer.applyStereotypes(_e, component);

			ElementRegistry.instance.addElement(_e, component);
			
			for(org.sparx.Element e: _e.GetElements())
				this.transformRecursive(e, component);

		} else {
			log.error("Element type not known!");
		}
		
	}
	
	@Override
	protected void transformElement(org.sparx.Element _e) {
		this.transformRecursive(_e, (Component) this.umlElement);
	}

	/**
	 * transforms an connector from the component and adds it to the ConnectorFactory 
	 */
	@Override
	protected void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName() + ", type: "
				+ _c.GetType());

		if (_c.GetType().equals("Dependency")) {
			log.debug("Connector is a dependency");
			DependencyTransformer t = new DependencyTransformer();
			t.transform(_c, (Component) this.umlElement);
		} else if (_c.GetType().equals("Association")) {
			log.debug("Connector is a association");

			ConnectorFactory.instance.addComponentAssociation(_c);

//			ElementDebugger.INSTANCE.printConnector(_c);
		} else {
			log.debug("Connector " + _c.GetType() + " is not implemented.");
		}
	}

}
