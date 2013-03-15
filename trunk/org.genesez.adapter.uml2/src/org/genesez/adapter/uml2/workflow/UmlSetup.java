package org.genesez.adapter.uml2.workflow;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.profile.l2.L2Package;
import org.eclipse.uml2.uml.profile.l3.L3Package;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.uml2.Setup;

/**
 * Utility class which allows to set different namespace URIs for the currently registered UML EPackage.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class UmlSetup extends Setup {
	
	static final Map<String, String> NS_URI_FQN_MAP = new LinkedHashMap<String, String>();
	static final Map<String, String> NS_URI_URI_MAP = new LinkedHashMap<String, String>();
	
	private Log logger = LogFactory.getLog(getClass());
	
	public UmlSetup() {
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", UMLResource.Factory.INSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml2", UMLResource.Factory.INSTANCE);
	}
	
	@Override
	public void setStandardUML2Setup(boolean b) {
		super.setStandardUML2Setup(b);
		if (b) {
			// fill maps if not already manuall done
			if (NS_URI_FQN_MAP.isEmpty()) {
				setRegisterNsUri(true);
			}
			if (NS_URI_URI_MAP.isEmpty()) {
				setRegisterProfileLocation(true);
			}
			
			// register map contents
			for (Map.Entry<String, String> me : NS_URI_FQN_MAP.entrySet()) {
				registerEPackage(me.getKey(), me.getValue());
			}
			for (Map.Entry<String, String> me : NS_URI_URI_MAP.entrySet()) {
				UMLPlugin.getEPackageNsURIToProfileLocationMap().put(me.getKey(), URI.createURI(me.getValue()));
			}
		}
		
		// log uml plugin profile locations
		logger.trace("UML Profile Location Map:");
		for (Map.Entry<String, URI> me : UMLPlugin.getEPackageNsURIToProfileLocationMap().entrySet()) {
			logger.trace(me.getKey() + " -> " + me.getValue());
		}
	}
	
	public void setRegisterNsUri(boolean shallRegister) {
		if (shallRegister) {
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/Types", "org.eclipse.uml2.types.TypesPackage");
			
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/schemas/Standard/1", "org.eclipse.uml2.uml.profile.l2.L2Package");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "org.eclipse.uml2.uml.profile.l2.L2Package");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "org.eclipse.uml2.uml.profile.l3.L3Package");
		}
	}
	
	/**
	 * Adds the specified mapping from a namespace URI (nsURI) to an EPackage to the EMF Package Registery.
	 * @param map	an mapping from an nsUri to a full qualified name of an EPackage
	 */
	public void addNsUriFqn(Mapping map) {
		NS_URI_FQN_MAP.put(map.getFrom(), map.getTo());
	}
	
	public void setRegisterProfileLocation(boolean shallRegister) {
		if (shallRegister) {
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "pathmap://UML_PROFILES/StandardL2.profile.uml#_0");
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "pathmap://UML_PROFILES/StandardL3.profile.uml#_0");
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/schemas/Ecore/5", "pathmap://UML_PROFILES/Ecore.profile.uml#_0");
		}
	}
	
	/**
	 * Adds the specified mapping from a namespace URI (nsURI) to an UML profile location to the UML Plugin Profile Location Map.
	 * @param map	an mapping from an nsUri to an UML profile location URI
	 */
	public void addNsUriProfileLocation(Mapping map) {
		NS_URI_URI_MAP.put(map.getFrom(), map.getTo());
	}
	
	
	protected void registerEPackage(String nsUri, String fqn) {
		try {
			EPackage ePackage = EcoreUtil2.getEPackageByClassName(fqn);
			// in case the epackage has a different nsUri, register it under this nsUri too
			if (EPackage.Registry.INSTANCE.get(nsUri) == null) {
				EPackage.Registry.INSTANCE.put(nsUri, ePackage);
			}
		} catch (ConfigurationException ce) {
			logger.warn("Unable to register EPackage with namespace URI: " + nsUri);
		}
	}
}
