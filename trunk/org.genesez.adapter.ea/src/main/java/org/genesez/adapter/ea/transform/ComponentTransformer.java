package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363942855327_489308_2295) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * transforms all components
 * @author christian
 */

public class ComponentTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ComponentTransformer.class);
	
	private Package umlPackage = null;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * the actual component transformer the returns the emf uml component
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Component transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942926653_742441_2323) ENABLED START */
		Component component = UMLFactory.eINSTANCE.createComponent();
		component.setName(element.GetName());
		
		// DEBUGGING
		//		ElementDebugger.INSTANCE.printElement(_e);
		
		// set package for methods
		this.umlPackage = parent;
		// set default variables
		this.umlElement = component;
		this.eaElement = element;
		
		// if component is an instance of a component
		final int classfierId = element.GetClassfierID();
		//		boolean addElement = true;
		if (classfierId != 0) {
			
			Component comp = (Component) ElementRegistry.INSTANCE.getElementById(classfierId);
			LOG.debug("Creating instance of Component " + element.GetName() + ":" + comp.getName());
			// createInstanceSpecification(_e, comp);
			component.setName(element.GetName() + ":" + comp.getName());
			this.umlPackage.getPackagedElements().add(component);
			// addElement = false;
		} else {
			this.umlPackage.getPackagedElements().add(component);
			LOG.debug("Creating Component " + element.GetName() + ", parent " + parent.getName() + ", id: " + element.GetElementID());
		}
		
		// apply the stereotype of the component
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(eaElement, umlElement);
		
		// transform others
		this.transformElements();
		
		//		for(org.sparx.Element e : _e.GetElements())
		//			this.transformRecursive(e, component);
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// if it's no instance add to registry
		// if(addElement)
		ElementRegistry.INSTANCE.addElement(element, component);
		return component;
		/* PROTECTED REGION END */
	}
	
	/**
	 * transforms all components recursive that exist in the component
	 * @param	element	
	 * @param	nextComponent	
	 */
	
	private void transformRecursive(org.sparx.Element element, Component nextComponent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942990449_85663_2329) ENABLED START */
		LOG.debug("Transforming element " + element.GetName() + ", type: " + element.GetType() + ", id: " + element.GetElementID());
		LOG.debug("Basic UML element =" + ((Component) this.umlElement).getName());
		
		if (element.GetType().equals("Port")) {
			LOG.debug("Element is a Port");
			PortTransformer t = new PortTransformer();
			t.transform(element, nextComponent);
		} else if (element.GetType().equals("Component")) {
			final int classifierId = element.GetClassifierID();
			Component comp = (Component) ElementRegistry.INSTANCE.getElementById(classifierId);
			Component component = null;
			
			if (classifierId != 0) {
				LOG.debug("Creating instance of Component " + element.GetName() + ":" + comp.getName());
				component = UMLFactory.eINSTANCE.createComponent();
				component.setName(element.GetName() + ":" + comp.getName());
				// add the component the parent component
				nextComponent.getPackagedElements().add(component);
			} else {
				LOG.debug("Creating Component " + element.GetName() + ", parent " + comp.getName() + ", id: " + element.GetElementID());
				component = UMLFactory.eINSTANCE.createComponent();
				component.setName(element.GetName());
				comp.getPackagedElements().add(component);
			}
			// apply stereotypes
			component = (Component) ApplyStereotypeTransformer.INSTANCE.applyStereotypes(element, component);
			
			ElementRegistry.INSTANCE.addElement(element, component);
			
			for (org.sparx.Element e : element.GetElements())
				this.transformRecursive(e, component);
			
		} else {
			LOG.error("Element type not known!");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 */
	
	protected void transformElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363943088050_105798_2336) ENABLED START */
		this.transformRecursive(element, (Component) this.umlElement);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	connector	
	 */
	
	protected void transformConnector(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363943111360_75028_2339) ENABLED START */
		LOG.debug("Transforming connector " + connector.GetName() + ", type: " + connector.GetType());
		
		if (connector.GetType().equals("Dependency")) {
			LOG.debug("Connector is a dependency");
			DependencyTransformer t = new DependencyTransformer();
			t.transform(connector, (Component) this.umlElement);
		} else if (connector.GetType().equals("Association")) {
			LOG.debug("Connector is a association");
			
			ConnectorFactory.INSTANCE.addComponentAssociation(connector);
			
			//			ElementDebugger.INSTANCE.printConnector(_c);
		} else {
			LOG.debug("Connector " + connector.GetType() + " is not implemented.");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363942855327_489308_2295) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
