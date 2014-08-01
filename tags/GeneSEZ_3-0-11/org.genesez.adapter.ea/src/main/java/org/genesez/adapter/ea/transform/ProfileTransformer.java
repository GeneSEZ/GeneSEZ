package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363353485096_359383_2408) 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * transforms the profile
 * TODO doesn't work yet
 * @author christian
 */

public class ProfileTransformer extends AbstractPackageTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ProfileTransformer.class);
	
	private java.util.Set<Integer> connectors = new HashSet<Integer>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	p	
	 * @return	
	 */
	
	public Profile transform(org.sparx.Package p) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363948546213_20212_2673) ENABLED START */
		LOG.debug("Creating Profile " + p.GetName());
		
		Profile profile = UMLFactory.eINSTANCE.createProfile();
		profile.setName(p.GetName());
		
		this.umlPackage = profile;
		this.eaPackage = p;
		
		this.transformElements();
		this.transformConnectors();
		
		ElementRegistry.INSTANCE.addElement(p, profile);
		return profile;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 */
	
	protected void transformElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363948570387_252184_2677) ENABLED START */
		LOG.debug("Transforming element " + element.GetName());
		
		if (element.GetType().equals("Class") && element.GetStereotypeList().equals("stereotype")) {
			LOG.debug("Element is a Stereotype");
			StereotypeTransformer t = new StereotypeTransformer();
			this.stereotypes.put(element.GetElementID(), t.transform(element, (Profile) this.umlPackage));
		} else if (element.GetType().equals("Class") && element.GetStereotypeList().equals("metaclass")) {
			LOG.debug("Element is a Metaclass");
			MetaclassTransformer t = new MetaclassTransformer();
			this.metaclasses.put(element.GetElementID(), t.transform(element, (Profile) this.umlPackage));
		} else if (element.GetType().equals("Interface")) {
			LOG.debug("Element is an Interface");
			InterfaceTransformer t = new InterfaceTransformer();
			t.transform(element, (Profile) this.umlPackage);
			//			this.metaclasses.put(_e.GetElementID(), t.transform(_e, (Profile)this.umlPackage));
		} else if (element.GetType().equals("Class") && element.GetStereotypeList().equals("enumeration")) {
			LOG.debug("Element is an Enumeration");
			EnumerationTransformer t = new EnumerationTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("Class") && element.GetStereotypeList().equals("primitive")) {
			LOG.debug("Element is a Primitive Type");
			PrimitiveTransformer t = new PrimitiveTransformer();
			t.transform(element, this.umlPackage);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	private void transformConnectors() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363948505700_467158_2668) ENABLED START */
		for (org.sparx.Element e : this.eaPackage.GetElements()) {
			for (org.sparx.Connector c : e.GetConnectors()) {
				if (!this.connectors.contains(c.GetConnectorID())) {
					this.transformConnector(c);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	connector	
	 */
	
	private void transformConnector(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363948619756_505498_2681) ENABLED START */
		LOG.debug("Transforming connector " + connector.GetName());
		
		if (connector.GetType().equals("Association") && connector.GetStereotype().equals("extends")) {
			LOG.debug("Conntector is an extension");
			ExtensionTransformer t = new ExtensionTransformer();
			t.transform(connector, this.stereotypes.get(connector.GetClientID()), this.metaclasses.get(connector.GetSupplierID()));
			this.connectors.add(connector.GetConnectorID());
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363353485096_359383_2408) ENABLED START */
	private Map<Integer, Stereotype> stereotypes = new HashMap<Integer, Stereotype>();
	private Map<Integer, Class> metaclasses = new HashMap<Integer, Class>();
	/* PROTECTED REGION END */
	
}
