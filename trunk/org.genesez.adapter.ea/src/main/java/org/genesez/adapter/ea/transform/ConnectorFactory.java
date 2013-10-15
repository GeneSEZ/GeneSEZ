package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363352652227_896894_2327) 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * This class transforms connectors which could not be resolved at runtime.
 * It's run by the post processor.
 * @author Christian
 */
public class ConnectorFactory {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ConnectorFactory.class);
	
	public static final ConnectorFactory INSTANCE = new ConnectorFactory();
	
	public static final String NAVIGABLE_STRING = "Navigable";
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ConnectorFactory</b></em>'.
	 */
	private ConnectorFactory() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363352684960_913005_2352) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Starts the post processing for all connectors
	 * -> dependencies
	 * -> information flows
	 * -> connectors (delegate)
	 * -> associations
	 */
	public void startProcessingConnectors() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363676933605_87329_1881) ENABLED START */
		LOG.debug("Starting post processing ");
		
		LOG.debug("Starting post processing remaining dependencies");
		this.processDependencies();
		LOG.debug("Starting post processing information flows");
		this.processInformationFlows();
		LOG.debug("Starting post processing delegate connectors");
		this.processDelegate();
		LOG.debug("Starting post processing associations");
		this.processAssociations();
		LOG.debug("Starting post processing generalizations");
		this.processAllGeneralizations();
		
		LOG.debug("Starting post processing interface realizations");
		this.processAllRealizations();
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addComponentAssociation(org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363676956282_180393_1884) ENABLED START */
		this.associationComponentMap.put(c.GetConnectorGUID(), c);
		/* PROTECTED REGION END */
	}
	
	/**
	 * add an association for the post processor
	 */
	public void addAssociation(org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363360332414_941716_2899) ENABLED START */
		this.associationMap.put(c.GetConnectorGUID(), c);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addInformationFlow(org.sparx.Connector c, int parentId) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363360351820_573154_2902) ENABLED START */
		final String guid = c.GetConnectorGUID();
		informationFlowGUIDMap.put(guid, c);
		if (informationFlowMap.containsKey(guid)) {
			informationFlowMap.get(guid).add(parentId);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parentId);
			informationFlowMap.put(guid, list);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addDependency(String guid, int parentId) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363352721058_550116_2355) ENABLED START */
		if (dependencyMap.containsKey(guid)) {
			dependencyMap.get(guid).add(parentId);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parentId);
			dependencyMap.put(guid, list);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addDelegate(String guid, int parentId) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363360379922_689124_2909) ENABLED START */
		if (delegateMap.containsKey(guid)) {
			delegateMap.get(guid).add(parentId);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parentId);
			delegateMap.put(guid, list);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * processes all delegation connectors
	 */
	public void processDelegate() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677071885_381746_1887) ENABLED START */
		for (String guid : delegateMap.keySet()) {
			List<Integer> list = delegateMap.get(guid);
			
			Element element = ElementRegistry.INSTANCE.getElementById(list.get(0));
			
			Element owner = element.getOwner();
			Component component = null;
			
			if (owner instanceof Component) {
				component = (Component) element.getOwner();
			} else {
				continue;
			}
			
			Connector connector = UMLFactory.eINSTANCE.createConnector();
			component.getOwnedConnectors().add(connector);
			
			for (Integer i : list) {
				Element elem = ElementRegistry.INSTANCE.getElementById(i);
				Port p = null;
				if (elem instanceof Port) {
					p = (Port) elem;
				} else {
					break;
				}
				ConnectorEnd end = connector.createEnd();
				end.setRole(p);
			}
			
//			ElementRegistry.INSTANCE.addElement(, connector);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * processes all dependencies
	 */
	public void processDependencies() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677109192_957490_1890) ENABLED START */
		for (String guid : dependencyMap.keySet()) {
			
			List<Integer> list = dependencyMap.get(guid);
			if (list.size() > 2) {
				LOG.error("Dependency to more than 2 ports not implemented yet! Continue with next.");
				continue;
			}
			
			Element elementOne = ElementRegistry.INSTANCE.getElementById(list.get(0));
			Element elementTwo = ElementRegistry.INSTANCE.getElementById(list.get(1));
			
			Port first = null, second = null;
			
			if (elementOne instanceof Port && elementTwo instanceof Port) {
				first = (Port) elementOne;
				second = (Port) elementTwo;
			} else {
				// go on if those are not two ports
				continue;
			}
			
			Port source = null;
			Port target = null;
			for (Interface iface : first.getProvideds()) {
				for (Interface requiredIface : second.getRequireds()) {
					if (iface.getName().equals(requiredIface)) {
						source = first;
						target = second;
					}
				}
			}
			if (source == null || target == null) {
				for (Interface iface : second.getProvideds()) {
					for (Interface requiredIface : first.getRequireds()) {
						if (iface.getName().equals(requiredIface.getName())) {
							source = second;
							target = first;
						}
					}
				}
			}
			// in case dependency has wrong connection
			if (source == null || target == null) {
				LOG.error("Error, Dependency from required to required or provided to provided!!!");
				source = first;
				target = second;
			}
			
			Class sourceClazz = ElementRegistry.INSTANCE.getClassByPort(source);
			Class targetClazz = ElementRegistry.INSTANCE.getClassByPort(target);
			
			// provided interface port gets the connection
			
			org.eclipse.uml2.uml.Package nearestPackage = source.getNearestPackage();
			
			Dependency dependency = UMLFactory.eINSTANCE.createDependency();
			
			dependency.setVisibility(VisibilityKind.PUBLIC_LITERAL);
			
			// temp name
			// dependency.setName("dependency");
			// add source and client
			dependency.getSuppliers().add(sourceClazz);
			dependency.getClients().add(targetClazz);
			
			// set package
			nearestPackage.getPackagedElements().add(dependency);
			
			// add informationFlow to registry
//			ElementRegistry.INSTANCE.addConnector(eaConnector, umlElement);(guid, dependency);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * processes all associations
	 */
	public void processAssociations() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677142924_423112_1894) ENABLED START */
		AssociationTransformer at = new AssociationTransformer();
		for (String guid : associationMap.keySet()) {
			
			at.transform(associationMap.get(guid));
			
		}
		// now run all component associations, because they are handled
		// different
		this.processComponentAssociations();
		/* PROTECTED REGION END */
	}
	
	/**
	 * create all associations between components
	 */
	public void processComponentAssociations() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677164033_725038_1897) ENABLED START */
		LOG.debug("Start processing associations of components...");
		for (String guid : associationComponentMap.keySet()) {
			
			// get connector from map
			org.sparx.Connector eaElement = associationComponentMap.get(guid);
			
			Element castSupplier = ElementRegistry.INSTANCE.getElementById(eaElement.GetSupplierID());
			Element castClient = ElementRegistry.INSTANCE.getElementById(eaElement.GetClientID());
			
			// if not instance of component
			// TODO implement association between control flows and others
			// maybe think of a new design
			if (!(castSupplier instanceof Component) && !(castClient instanceof Component)) {
				LOG.error("Association between those elements not implemented yet, " + "element names are " + castSupplier.getClass() + " and " + castClient.getClass());
				continue;
			}
			
			// cast components from registry
			Component supplier = (Component) castSupplier;
			Component client = (Component) castClient;
			
			org.sparx.ConnectorEnd supplierEnd = eaElement.GetSupplierEnd();
			org.sparx.ConnectorEnd clientEnd = eaElement.GetClientEnd();
			
			// create association
			Association association = UMLFactory.eINSTANCE.createAssociation();
			
			// set name
			association.setName(eaElement.GetName());
			LOG.debug("Associationname = [" + eaElement.GetName() + "]");
			
			// set package
			supplier.getPackagedElements().add(association);
			
			Property property = null;
			
			// first association memberEnd
			if (supplierEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
				property = client.createOwnedAttribute(null, supplier);
				association.getMemberEnds().add(property);
			} else {
				property = association.createOwnedEnd(null, supplier);
			}
			
			LOG.debug("Creating cardinality of supplier.");
			MultiplicityTransformer mt = new MultiplicityTransformer();
			
			mt.transform(property, supplierEnd);
			// createLowerUpperCardinality(property, supplierEnd);
			
			// second association memberEnd
			if (clientEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
				property = supplier.createOwnedAttribute(null, client);
				association.getMemberEnds().add(property);
			} else {
				property = association.createOwnedEnd(null, client);
			}
			
			LOG.debug("Creating cardinality of client.");
			// createLowerUpperCardinality(property, clientEnd);
			mt.transform(property, clientEnd);
			
			// apply stereotypes
			association = (Association) ApplyStereotypeTransformer.INSTANCE.applyStereotypes(eaElement, association);
			
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void processInformationFlows() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677713915_399928_1940) ENABLED START */
		// TODO information flow needs to have at least one classifier
		// Specifies the information items that may circulate on this
		// information flow.
		for (String guid : informationFlowMap.keySet()) {
			
			List<Integer> list = informationFlowMap.get(guid);
			
			// logging for special case
			if (list.size() > 2) {
				LOG.fatal("InformationFlow to more than 2 ports not implemented!");
			}
			
			Port first = (Port) ElementRegistry.INSTANCE.getElementById(list.get(0));
			Port second = (Port) ElementRegistry.INSTANCE.getElementById(list.get(1));
			
			Port source = null;
			Port target = null;
			for (Interface iface : first.getProvideds()) {
				for (Interface requiredIface : second.getRequireds()) {
					if (iface.getName().equals(requiredIface)) {
						source = first;
						target = second;
					}
				}
			}
			if (source == null || target == null) {
				for (Interface iface : second.getProvideds()) {
					for (Interface requiredIface : first.getRequireds()) {
						if (iface.getName().equals(requiredIface.getName())) {
							source = second;
							target = first;
						}
					}
				}
			}
			// in case informationflow has wrong connection
			if (source == null || target == null) {
				LOG.warn("Error, InformationFlow from required to required or provided to provided!!!");
				source = first;
				target = second;
			}
			
			Class sourceClazz = ElementRegistry.INSTANCE.getClassByPort(source);
			Class targetClazz = ElementRegistry.INSTANCE.getClassByPort(target);
			// provided interface port gets the connection
			
			org.eclipse.uml2.uml.Package nearestPackage = source.getNearestPackage();
			
			// get the original connector
			org.sparx.Connector con = informationFlowGUIDMap.get(guid);
			
			// create information flow and set name
			InformationFlow flow = (InformationFlow) nearestPackage.createPackagedElement(con.GetName(), UMLFactory.eINSTANCE.createInformationFlow().eClass());
			
			flow.getInformationSources().add(sourceClazz);
			flow.getInformationTargets().add(targetClazz);
			// add informationFlow to registry
//			ElementRegistry.INSTANCE.addElementGuid(guid, flow);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * some helpful method for debugging dependency problems 
	 */
	public void printDependencies() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677743340_69490_1943) ENABLED START */
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Dependencies:");
		sb.append("\n");
		for (String guid : dependencyMap.keySet()) {
			sb.append(guid + ":\n");
			int i = 1;
			for (Integer parent : dependencyMap.get(guid)) {
				Element element = ElementRegistry.INSTANCE.getElementById(parent);
				if (element != null) {
					sb.append(i++);
					if (element instanceof Port) {
						Port port = (Port) element;
						sb.append(". Port-Parent=" + port.getName());
					} else if (element instanceof Dependency) {
						Dependency dep = (Dependency) element;
						sb.append(". Dependency=" + dep.getName());
						
						sb.append("\nSuppliers:\n");
						for (NamedElement ne : dep.getSuppliers()) {
							sb.append("\n" + ne.getName());
						}
						sb.append("\nClients:\n");
						for (NamedElement ne : dep.getClients()) {
							sb.append("\t" + ne.getName());
						}
					} else if (element instanceof Package) {
						Package pack = (Package) element;
						sb.append(". Package=" + pack.getName());
					} else {
						sb.append("\nClass: " + element.getClass());
					}
					
					sb.append("\n");
				} else {
					LOG.fatal("parentID(" + parent + " not found in registry");
				}
				
			}
			sb.append("-------------------------------------------------------------------------\n");
		}
		sb.append("\n=======================================================================");
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * some helpful method for debugging information flow problems
	 */
	public void printInformationFlows() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677760459_596928_1946) ENABLED START */
		StringBuilder sb = new StringBuilder();
		sb.append("List InformationFlows:");
		sb.append("\n");
		for (String guid : informationFlowMap.keySet()) {
			sb.append(guid + ":\n");
			for (Integer parent : informationFlowMap.get(guid)) {
				Port port = (Port) ElementRegistry.INSTANCE.getElementById(parent);
				sb.append("\tName=" + port.getName());
				sb.append("\n");
				sb.append("\tProvided:\n");
				for (Interface iface : port.getProvideds()) {
					sb.append("\t\t" + iface.getName());
					sb.append("\n");
				}
				sb.append("\tRequired:\n");
				for (Interface iface : port.getRequireds()) {
					sb.append("\t\t" + iface.getName());
					sb.append("\n");
				}
			}
		}
		
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addRealisation(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381844144383_465714_3679) ENABLED START */
		realizationMap.put(connector.GetConnectorGUID(), connector);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void processAllRealizations() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381844172463_385230_3682) ENABLED START */
		RealizationTransformer t = new RealizationTransformer();
		for (org.sparx.Connector connector : realizationMap.values()) {
			t.transform(connector);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addGeneralization(org.sparx.Connector c) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381844190419_692437_3685) ENABLED START */
		this.generalisationMap.put(c.GetConnectorGUID(), c);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void processAllGeneralizations() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381844233069_724877_3689) ENABLED START */
		GeneralizationTransformer gf = new GeneralizationTransformer();
		
		// go over all generalizations
		for (org.sparx.Connector connector : generalisationMap.values()) {
			gf.transform(connector);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363352652227_896894_2327) ENABLED START */
	
	private Map<String, List<Integer>> informationFlowMap = new HashMap<String, List<Integer>>();
	private Map<String, org.sparx.Connector> informationFlowGUIDMap = new HashMap<String, org.sparx.Connector>();
	
	private Map<String, List<Integer>> dependencyMap = new HashMap<String, List<Integer>>();
	private Map<String, List<Integer>> delegateMap = new HashMap<String, List<Integer>>();
	
	// private Map<String, org.sparx.Connector> informationFlowMap = new HashMap<String, org.sparx.Connector>();
	
	private Map<String, org.sparx.Connector> associationMap = new HashMap<String, org.sparx.Connector>();
	private Map<String, org.sparx.Connector> associationComponentMap = new HashMap<String, org.sparx.Connector>();
	
	// interface realizations
	private Map<String, org.sparx.Connector> realizationMap = new HashMap<String, org.sparx.Connector>();
	
	// Generalizations
	private Map<String, org.sparx.Connector> generalisationMap = new HashMap<String, org.sparx.Connector>();
	
	/* PROTECTED REGION END */
}
