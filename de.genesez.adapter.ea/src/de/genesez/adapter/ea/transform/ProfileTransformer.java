package de.genesez.adapter.ea.transform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class ProfileTransformer extends AbstractPackageTransformer {

	private static final Log log = LogFactory.getLog(ProfileTransformer.class);

	private Map<Integer, Stereotype> stereotypes = new HashMap<Integer, Stereotype>();
	private Map<Integer, Class> metaclasses = new HashMap<Integer, Class>();
	private Set<Integer> connectors = new HashSet<Integer>();
	
	public Profile transform(org.sparx.Package _p) {
		log.debug("Creating Profile " + _p.GetName());
		
		Profile profile = UMLFactory.eINSTANCE.createProfile();
		profile.setName(_p.GetName());

		this.umlPackage = profile;
		this.eaPackage = _p;
		
		this.transformElements();
		this.transformConnectors();

		ElementRegistry.instance.addElement(_p, profile);
		return profile;
	}

	@Override
	protected void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName());
		
		if ( _e.GetType().equals("Class") && _e.GetStereotypeList().equals("stereotype") ) {
			log.debug("Element is a Stereotype");
			StereotypeTransformer t = new StereotypeTransformer();
			this.stereotypes.put(_e.GetElementID(), t.transform(_e, (Profile)this.umlPackage));
		}
		else if ( _e.GetType().equals("Class") && _e.GetStereotypeList().equals("metaclass") ) {
			log.debug("Element is a Metaclass");
			MetaclassTransformer t = new MetaclassTransformer();
			this.metaclasses.put(_e.GetElementID(), t.transform(_e, (Profile)this.umlPackage));
		}
		else if ( _e.GetType().equals("Interface") ) {
			log.debug("Element is an Interface");
			InterfaceTransformer t = new InterfaceTransformer();
			t.transform(_e, (Profile)this.umlPackage);
//			this.metaclasses.put(_e.GetElementID(), t.transform(_e, (Profile)this.umlPackage));
		}
		else if (_e.GetType().equals("Class") && _e.GetStereotypeList().equals("enumeration") ) {
			log.debug("Element is an Enumeration");
			EnumerationTransformer t = new EnumerationTransformer();
			t.transform(_e, this.umlPackage);
		}
		else if (_e.GetType().equals("Class") && _e.GetStereotypeList().equals("primitive") ) {
			log.debug("Element is a Primitive Type");
			PrimitiveTransformer t = new PrimitiveTransformer();
			t.transform(_e, this.umlPackage);
		}
	}

	private void transformConnectors() {
		for (org.sparx.Element e: this.eaPackage.GetElements()) {
			for (org.sparx.Connector c: e.GetConnectors()) {
				if ( !this.connectors.contains(c.GetConnectorID()) ) {
					this.transformConnector(c);
				}
			}
		}
	}

	private void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName());
		
		if (_c.GetType().equals("Association") && _c.GetStereotype().equals("extends")) {
			log.debug("Conntector is an extension");
			ExtensionTransformer t = new ExtensionTransformer();
			t.transform(_c, this.stereotypes.get(_c.GetClientID()), this.metaclasses.get(_c.GetSupplierID()));
			this.connectors.add(_c.GetConnectorID());
		}
	}
}
