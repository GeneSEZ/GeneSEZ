package org.genesez.adapter.uml2.workflow;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.emf.mwe.utils.SingleGlobalResourceSet;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.Setup;

/**
 * Provides standalone use of UML based on the xtend uml setup.
 * It allows to customize registered packages in the emf package registry and uml profile locations.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class UmlSetup extends Setup {
	
	static final Map<String, String> NS_URI_FQN_MAP = new LinkedHashMap<String, String>();
	static final Map<String, String> NS_URI_URI_MAP = new LinkedHashMap<String, String>();
	static final Map<String, String> PLUGIN_URI_MAP = new LinkedHashMap<String, String>();
	
	private Log logger = LogFactory.getLog(getClass());
	private org.eclipse.xtend.typesystem.uml2.Setup xpandUmlSetup;
	
	public UmlSetup() {
		initUmlPlugin();
	}
	
	@SuppressWarnings("deprecation")
	public void setStandardUML2Setup(boolean b) {
		setDoSetup(b);
		if (b) {
			xpandUmlSetup = new org.eclipse.xtend.typesystem.uml2.Setup();
			try {
				// xpand 1.x compatibility
				Method m = org.eclipse.xtend.typesystem.uml2.Setup.class.getMethod("setStandardUML2Setup", boolean.class);
				Annotation depcreated = m.getAnnotation(Deprecated.class);
				if (depcreated == null) {
					xpandUmlSetup.setStandardUML2Setup(b);
				}
			} catch (Exception e) {
				logger.debug("XPand 1.x compatibility couldn't be guaranted!", e);
			}
		}
	}
	
	public void setDoSetup(boolean perform) {
		if (perform) {
			// fill maps if not already manually done
			if (NS_URI_FQN_MAP.isEmpty()) {
				setRegisterNsUri(true);
			}
			if (NS_URI_URI_MAP.isEmpty()) {
				setRegisterProfileLocation(true);
			}
//			setStandardProfileMapping(true);
			if (PLUGIN_URI_MAP.isEmpty()) {
				setRegisterPluginUriMapping(true);
			}
			
			// register map contents
			for (Map.Entry<String, String> me : NS_URI_FQN_MAP.entrySet()) {
				registerEPackage(me.getKey(), me.getValue());
			}
			for (Map.Entry<String, String> me : NS_URI_URI_MAP.entrySet()) {
				UMLPlugin.getEPackageNsURIToProfileLocationMap().put(me.getKey(), URI.createURI(me.getValue()));
			}
			for (Map.Entry<String, String> me : PLUGIN_URI_MAP.entrySet()) {
				registerPlatformUriMapping(me.getKey(), me.getValue());
			}
		}
		
		// log uml plugin profile locations
		if (logger.isTraceEnabled()) {
			logger.trace("UML Profile Location Map:");
			for (Map.Entry<String, URI> me : UMLPlugin.getEPackageNsURIToProfileLocationMap().entrySet()) {
				logger.trace(me.getKey() + " -> " + me.getValue());
			}
		}
	}
	
	/**
	 * Registers standard UML packages and profile packages depending on specified value.
	 * @param shallRegister	true if registration should be performed
	 */
	public void setRegisterNsUri(boolean shallRegister) {
		if (shallRegister) {
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/Types", "org.eclipse.uml2.types.TypesPackage");
			
			// uml 4.x.x packages
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/schemas/Standard/1", "org.eclipse.uml2.uml.profile.l2.L2Package");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "org.eclipse.uml2.uml.profile.l2.L2Package");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "org.eclipse.uml2.uml.profile.l3.L3Package");
			
			// uml 5.x.x packages
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/schemas/Standard/1", "org.eclipse.uml2.uml.profile.standard.StandardPackage");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "org.eclipse.uml2.uml.profile.standard.StandardPackage");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "org.eclipse.uml2.uml.profile.standard.StandardPackage");
			NS_URI_FQN_MAP.put("http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard", "org.eclipse.uml2.uml.profile.standard.StandardPackage");
		}
	}
	
	/**
	 * Adds the specified mapping from a namespace URI (nsURI) to an EPackage to the EMF Package Registery.
	 * @param map	an mapping from an nsUri to a full qualified name of an EPackage
	 */
	public void addNsUriFqn(Mapping map) {
		NS_URI_FQN_MAP.put(map.getFrom(), map.getTo());
	}
	
	/**
	 * Registers standard UML profiles depending on specified value.
	 * @param shallRegister	true if registration should be performed
	 */
	public void setRegisterProfileLocation(boolean shallRegister) {
		if (shallRegister) {
			// uml 4.x.x locations
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L2", "pathmap://UML_PROFILES/StandardL2.profile.uml#_0");
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/4.0.0/UML/Profile/L3", "pathmap://UML_PROFILES/StandardL3.profile.uml#_0");
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/schemas/Ecore/5", "pathmap://UML_PROFILES/Ecore.profile.uml#_0");
			
			// uml 5.x.x locations
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard", "pathmap://UML_PROFILES/Standard.profile.uml#_0");
			NS_URI_URI_MAP.put("http://www.eclipse.org/uml2/schemas/UML2/2", "pathmap://UML_PROFILES/UML2.profile.uml#_0");
		}
	}
	
	/**
	 * Adds the specified mapping from a namespace URI (nsURI) to an UML profile location to the UML Plugin Profile Location Map.
	 * @param map	an mapping from an nsUri to an UML profile location URI
	 */
	public void addNsUriProfileLocation(Mapping map) {
		NS_URI_URI_MAP.put(map.getFrom(), map.getTo());
	}
	
	/**
	 * Registers a mapping of the standard UML profile depending on specified value.
	 * Change introduced from UML version 3.x.x to 4.x.x.
	 * @param map	true if registration should be performed
	 */
	public void setStandardProfileMapping(boolean map) {
		if (map) {
			try {
				EPackage ePackage = EcoreUtil2.getEPackageByClassName("org.eclipse.uml2.uml.profile.l2.L2Package");
				if (ePackage != null) {
					addUriMap( new org.eclipse.xtend.typesystem.emf.Mapping("pathmap://UML_PROFILES/Standard.profile.uml", "pathmap://UML_PROFILES/StandardL2.profile.uml"));
				}
			} catch (ConfigurationException ce) {
				logger.info("Not running with UML 4 -> not registering mapping for uml standard profile");
			}
		}
	}
	
	/**
	 * Registers mappings for platform plugin uris of UML specific files depending on the specified value.
	 * @param shallRegister		true if registration should be done
	 */
	public void setRegisterPluginUriMapping(boolean shallRegister) {
		if (shallRegister) {
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/CMOF20_2_UML.ecore2xml", "model/CMOF20_2_UML.ecore2xml");
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/CMOF24_2_UML.ecore2xml", "model/CMOF24_2_UML.ecore2xml");
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/CMOF_2_UML.ecore2xml", "model/CMOF_2_UML.ecore2xml");
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/UML21_2_UML.ecore2xml", "model/UML21_2_UML.ecore2xml");
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/UML2_2_UML.ecore2xml", "model/UML2_2_UML.ecore2xml");
			PLUGIN_URI_MAP.put("platform:/plugin/org.eclipse.uml2.uml/model/UML30_2_UML.ecore2xml", "model/UML30_2_UML.ecore2xml");
		}
	}
	
	/**
	 * Adds the specified uri mapping from a platform plugin uri to a file name relative to a plug-in directory.
	 * @param map	an mapping from a platform plugin uri to a relative file name
	 */
	public void addPluginUriMapping(Mapping map) {
		PLUGIN_URI_MAP.put(map.getTo(), map.getTo());
	}
	
	/**
	 * Performs registration of an URI mapping for platform plugin URIs.
	 * @param from	the platform plugin URI that should be mapped
	 * @param to	the relative file name to which the URI should be mapped to
	 */
	protected void registerPlatformUriMapping(String from, String to) {
		URI uri = EcoreUtil2.getURI(to);
		if (uri != null) {
			String path = uri.toString();
			if (path.indexOf(".jar!") != -1) {
				if (!path.startsWith("jar:"))
					path = "jar:" + path;
			}
			addUriMap(new org.eclipse.xtend.typesystem.emf.Mapping(from, path));
		}
	}
	
	
	/**
	 * Resolves the EPackage by the specified full qualified name and registers it
	 * using its own namespace URI as well as the specified.
	 * A warning message is logged if the specified EPackage cannot be resolved.
	 * 
	 * @param nsUri	the namespace URI for the EPackage
	 * @param fqn	the full qualified name of the EPackage
	 */
	protected void registerEPackage(String nsUri, String fqn) {
		try {
			EPackage ePackage = EcoreUtil2.getEPackageByClassName(fqn);
			// in case the epackage has a different nsUri, register it under this nsUri too
			if (EPackage.Registry.INSTANCE.get(nsUri) == null) {
				EPackage.Registry.INSTANCE.put(nsUri, ePackage);
			}
		} catch (ConfigurationException ce) {
			logger.debug("Unable to register EPackage with namespace URI: " + nsUri);
		}
	}
	
	/**
	 * Checks if the class {@link UMLResourceUtil} is available (since UML 4.x) and if it calls its method
	 * {@link UMLResourcesUtil.init()} with the {@link SingleGlobalResourceSet} as parameter.
	 */
	protected void initUmlPlugin() {
		ResourceSet rs = SingleGlobalResourceSet.get();
		try {
			Class<?> clazz = ResourceLoaderFactory.createResourceLoader().loadClass("org.eclipse.uml2.uml.resources.util.UMLResourcesUtil");
			if (clazz == null) {
				if (logger.isInfoEnabled()) {
					logger.info("Not able to initialize UML support using class 'UMLResourceUtil', it was not found.");
				}
				return;
			}
			Method m = clazz.getMethod("init", ResourceSet.class);
			if (m == null || !Modifier.isStatic(m.getModifiers())) {
				if (logger.isWarnEnabled()) {
					logger.warn("The class 'UMLResourceUtil' does not have an 'init' method or is not static!");
				}
			}
			m.invoke(null, rs);
			if (logger.isInfoEnabled()) {
				logger.debug("UML support was initialized.");
			}
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("UML support could not be initialized by with 'UMLResourceUtil'!", e);
			}
		}
	}
}
