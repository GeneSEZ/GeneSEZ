package org.genesez.adapter.ea.transform;

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
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
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
 * 
 * 
 * @author christian 
 * @version 3
 * 
 */

public class ConnectorFactory {

	private static final Log log = LogFactory.getLog(ConnectorFactory.class);

	public static ConnectorFactory instance = new ConnectorFactory();

	private Map<String, List<Integer>> informationFlowMap = new HashMap<String, List<Integer>>();
	private Map<String, org.sparx.Connector> informationFlowGUIDMap = new HashMap<String, org.sparx.Connector>();
	
	private Map<String, List<Integer>> dependencyMap = new HashMap<String, List<Integer>>();
	private Map<String, List<Integer>> delegateMap = new HashMap<String, List<Integer>>();
	
//	private Map<String, org.sparx.Connector> informationFlowMap = new HashMap<String, org.sparx.Connector>();	
	
	private Map<String, org.sparx.Connector> associationMap = new HashMap<String, org.sparx.Connector>();
	private Map<String, org.sparx.Connector> associationComponentMap = new HashMap<String, org.sparx.Connector>();

	/**
	 * Constructor
	 */
	private ConnectorFactory() {

	}
	
	/**
	 * Starts the post processing for all connectors
	 * -> dependencies
	 * -> information flows
	 * -> connectors (delegate)
	 * -> associations
	 */
	public void startPostprocssingConnectors(){
		log.debug("Starting post processing remaining dependencies");
		this.processAllDependencies();
		log.debug("Starting post processing information flows");
		this.processAllInformationFlows();		
		log.debug("Starting post processing delegate connectors");
		this.processAllDelegate();
		log.debug("Starting post processing associations");
		this.processAllAssociations();
	}

	/**
	 * add an association between components
	 * @param _c
	 */
	public void addComponentAssociation(org.sparx.Connector _c) {
		this.associationComponentMap.put(_c.GetConnectorGUID(), _c);
	}
	
	/**
	 * add an association for the post processor
	 * @param _c org.sparx.Connector
	 */
	public void addAssociation(org.sparx.Connector _c){
		associationMap.put(_c.GetConnectorGUID(), _c);
	}

	/**
	 * add an information flow
	 * @param guid
	 * @param parent_id
	 */
	public void addInformationFlow(org.sparx.Connector _c, int parent_id) {
		final String guid = _c.GetConnectorGUID();
		informationFlowGUIDMap.put(guid, _c);
		if (informationFlowMap.containsKey(guid)) {
			informationFlowMap.get(guid).add(parent_id);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parent_id);
			informationFlowMap.put(guid, list);
		}
	}
	
	public void addDependency(String guid, int parent_id) {
		if (dependencyMap.containsKey(guid)) {
			dependencyMap.get(guid).add(parent_id);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parent_id);
			dependencyMap.put(guid, list);
		}
	}

	public void addDelegate(String guid, int parent_id) {
		if (delegateMap.containsKey(guid)) {
			delegateMap.get(guid).add(parent_id);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(parent_id);
			delegateMap.put(guid, list);
		}
	}

	/**
	 * processes all delegation connectors
	 */
	public void processAllDelegate() {
		for (String guid : delegateMap.keySet()) {
			List<Integer> list = delegateMap.get(guid);

			Element element = ElementRegistry.instance.getById(list.get(0));

			Element owner = element.getOwner();
			Component component = null;

			if (owner instanceof Component)
				component = (Component) element.getOwner();
			else
				continue;

			Connector connector = UMLFactory.eINSTANCE.createConnector();

			component.getOwnedConnectors().add(connector);

			for (Integer i : list) {
				Element elem = ElementRegistry.instance.getById(i);
				Port p = null;
				if (elem instanceof Port) {
					p = (Port) elem;
				} else
					break;
				ConnectorEnd end = connector.createEnd();
				end.setRole(p);
			}

			ElementRegistry.instance.addElementGuid(guid, connector);
		}
	}

	/**
	 * processes all dependencies
	 */
	public void processAllDependencies() {
		for (String guid : dependencyMap.keySet()) {

			List<Integer> list = dependencyMap.get(guid);
			if (list.size() > 2)
				log.error("Dependency to more than 2 ports not implemented!");

			Element elementOne = ElementRegistry.instance.getById(list.get(0));
			Element elementTwo = ElementRegistry.instance.getById(list.get(1));

			Port first = null, second = null;

			if (elementOne instanceof Port && elementTwo instanceof Port) {
				first = (Port) elementOne;
				second = (Port) elementTwo;
			} else {
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
				log.error("Error, Dependency from required to required or provided to provided!!!");
				source = first;
				target = second;
			}

			Class sourceClazz = (Class) ElementRegistry.instance
					.getClassByPort(source);
			Class targetClazz = (Class) ElementRegistry.instance
					.getClassByPort(target);

			// provided interface port gets the connection

			org.eclipse.uml2.uml.Package nearestPackage = source
					.getNearestPackage();

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
			ElementRegistry.instance.addElementGuid(guid, dependency);
		}
	}
	
	/**
	 * processes all associations
	 */
	public void processAllAssociations() {
		for (String guid : associationMap.keySet()) {
			
			// get the connector element
			org.sparx.Connector eaElement = associationMap.get(guid);
			
			// debug
//			ElementDebugger.INSTANCE.printConnector(eaElement);
			
			org.sparx.ConnectorEnd supplierEnd = eaElement.GetSupplierEnd();
			org.sparx.ConnectorEnd clientEnd = eaElement.GetClientEnd();
			
			// create new association
			Association association = UMLFactory.eINSTANCE.createAssociation();
			// set name
			association.setName(eaElement.GetName());
			
			Element sup = ElementRegistry.instance.getById(eaElement.GetSupplierID());
			Element cli = ElementRegistry.instance.getById(eaElement.GetClientID());
			
			if( !(sup instanceof Port) || !(cli instanceof Port) ){
				// TODO add class associations again
				log.error("Association for this is not implemented yet: " + sup.getClass());
				continue;
			}
			
			Port supplier = (Port) ElementRegistry.instance.getById(eaElement.GetSupplierID());
			Port client = (Port) ElementRegistry.instance.getById(eaElement.GetClientID());
			
			log.debug("Creating association between: " + supplier.getName() + " - " + client.getName() );
			
			Property property = null;
			
//			Component component = (Component) supplier.getOwner();
			
			org.eclipse.uml2.uml.Package _p = supplier.getNearestPackage();
			 
			// create the navigation			
			if(supplierEnd.GetNavigable().equals("Navigable")){
//				association.getNavigableOwnedEnds().add(supplierProperty);	
				log.debug("Supplier is Navigable!");
				property = supplier.createQualifier(supplier.getName(), supplier.getType());		
				association.getMemberEnds().add(property);	
			}else{
//				association.getMemberEnds().add(supplierProperty);
				property = association.createOwnedEnd(supplier.getName(), supplier.getType());
//				createLowerUpperCardinality(supplierProperty, clientEnd);
			}
			
			// multiplicity
			createLowerUpperCardinality(property, supplierEnd);
			
			if(clientEnd.GetNavigable().equals("Navigable")){
				log.debug("Client is Navigable!");
				property = client.createQualifier(client.getName(), client.getType());
				association.getMemberEnds().add(property);
			}else{
//				association.getMemberEnds().add(clientProperty);
				property = association.createOwnedEnd(client.getName(), client.getType());
//				createLowerUpperCardinality(clientProperty, clientEnd);
			}
			// multiplicity
			createLowerUpperCardinality(property, clientEnd);
			
			
			log.debug("Package = " + _p.getName() + "\tComponent= " + _p.getName());
			_p.getPackagedElements().add(association);
			
			association = (Association) ApplyStereotypeTransformer.applyStereotypes(eaElement, association);
			ElementRegistry.instance.addElement(eaElement, association);
			
		}
		// now run all component associations, because they are handled different 
		this.processAllComponentAssociations();
	}
	
	/**
	 * create all associations between components
	 * 
	 */
	public void processAllComponentAssociations() {
		log.debug("Start processing associations of components...");
		for (String guid : associationComponentMap.keySet()) {

			// get connector from map
			org.sparx.Connector eaElement = associationComponentMap.get(guid);
			
			Element castSupplier = ElementRegistry.instance.getById(eaElement.GetSupplierID());
			Element castClient = ElementRegistry.instance.getById(eaElement.GetClientID());
			
			// if not instance of component
			// TODO implement association between control flows and others
			// maybe think of a new design
			if( !(castSupplier instanceof Component)  && !(castClient instanceof Component)){
					log.error("Association between those elements not implemented yet, " +
							"element names are " + castSupplier.getClass() + " and " + castClient.getClass() );		
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
			log.debug("Associationname = [" + eaElement.GetName() + "]");

			// set package
//			Package nearestPackage = supplier.getNearestPackage();
//			association.setPackage(nearestPackage);
			supplier.getPackagedElements().add(association);

			Property property = null;

			// first association memberEnd
			if (supplierEnd.GetNavigable().equals("Navigable")) {
				property = client.createOwnedAttribute(null, supplier);
				association.getMemberEnds().add(property);
			} else {
				property = association.createOwnedEnd(null, supplier);
			}

			log.debug("Creating cardinality of supplier.");
			createLowerUpperCardinality(property, supplierEnd);

			// second association memberEnd
			if (clientEnd.GetNavigable().equals("Navigable")) {
				property = supplier.createOwnedAttribute(null, client);
				association.getMemberEnds().add(property);
			} else {
				property = association.createOwnedEnd(null, client);
			}

			log.debug("Creating cardinality of client.");
			createLowerUpperCardinality(property, clientEnd);

			// apply stereotypes
			association = (Association) ApplyStereotypeTransformer
					.applyStereotypes(eaElement, association);

		}
	}
	
	/**
	 * private method to create the multiplicity
	 * 
	 * @param property
	 * @param end
	 */
	private void createLowerUpperCardinality(Property property, org.sparx.ConnectorEnd end){
		int lower, upper;
		List<Integer> values = getCardinality(end);
		lower = values.get(0);
		upper = values.get(1);

		// lower value
		property.setLowerValue(getLiteralInteger(lower));
		// upper value
		property.setUpperValue(getLiteralUnlimitedNatural(upper));
	}

	/**
	 * create lower value for multiplicity
	 * 
	 * @param lower
	 * @return
	 */
	private LiteralInteger getLiteralInteger(int lower) {
		LiteralInteger literalInteger = UMLFactory.eINSTANCE
				.createLiteralInteger();
		literalInteger.setValue(lower);
		return literalInteger;
	}

	/**
	 * create upper value for multiplicity
	 * 
	 * @param upper
	 * @return
	 */
	private LiteralUnlimitedNatural getLiteralUnlimitedNatural(int upper) {
		LiteralUnlimitedNatural unlimitedInteger = UMLFactory.eINSTANCE
				.createLiteralUnlimitedNatural();
		unlimitedInteger.setValue(upper);
		return unlimitedInteger;
	}

	/**
	 * read the multiplicity from connectorEnd
	 * 
	 * @param connectorEnd
	 * @return
	 */
	private List<Integer> getCardinality(org.sparx.ConnectorEnd connectorEnd) {
		List<Integer> values = new ArrayList<Integer>(2);
		int lower = 0, upper = 0;
		String cardinality = connectorEnd.GetCardinality();
		log.debug("Origin: " + cardinality);
		// if string is empty
		if (cardinality.equals("")) {
			log.debug("Cardinality is empty");
			lower = 1;
			upper = 1;
		} else if (cardinality.length() == 1) {
			log.debug("Cardinality has length of one");
			// single value might be any value >= 0 or *
			upper = evaluateCardinalty(cardinality);
			// in case it is *
			if (upper == -1) {
				lower = 0;
			} else {
				lower = upper;
			}
		} else {
			// values that might be 0..*, 1..8, 8..*, etc.
			int counter = 0;
			log.debug("Cardinality > 1");
			// split string with ".."
			for (String split : cardinality.split("\\.\\.")) {
				log.debug("Split: " + split);
				if (counter++ == 0) {
					log.debug("Lower Value = " + split);
					lower = evaluateCardinalty(split);
				} else {
					log.debug("Upper Value = " + split);
					upper = evaluateCardinalty(split);
				}
			}
		}
		values.add(lower);
		values.add(upper);

		log.debug("Cardinalty: [" + lower + ".." + upper + "]");
		return values;
	}

	/**
	 * evaluate the multiplicity
	 * 
	 * @param cardinality
	 * @return
	 */
	private int evaluateCardinalty(String cardinality) {
		// if empty set default to "1"
		if (cardinality.equals("*")) {
			// return unlimited
			return -1;
		} else {
			// return value of string as integer
			return Integer.valueOf(cardinality);
		}
	}

	/**
	 * post process all information flows
	 */
	public void processAllInformationFlows() {

		// TODO information flow needs to have at least one classifier
		// Specifies the information items that may circulate on this
		// information flow.
		for (String guid : informationFlowMap.keySet()) {

			List<Integer> list = informationFlowMap.get(guid);
			if (list.size() > 2)
				log.fatal("InformationFlow to more than 2 ports not implemented!");
			Port first = (Port) ElementRegistry.instance.getById(list.get(0));
			Port second = (Port) ElementRegistry.instance.getById(list.get(1));

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
				log.warn("Error, InformationFlow from required to required or provided to provided!!!");
				source = first;
				target = second;
			}

			Class sourceClazz = (Class) ElementRegistry.instance
					.getClassByPort(source);
			Class targetClazz = (Class) ElementRegistry.instance
					.getClassByPort(target);
			// provided interface port gets the connection

			org.eclipse.uml2.uml.Package nearestPackage = source
					.getNearestPackage();
			
			// get the original connector
			org.sparx.Connector con = informationFlowGUIDMap.get(guid);
			
			// create information flow and set name
			InformationFlow flow = (InformationFlow) nearestPackage
					.createPackagedElement(con.GetName(), UMLFactory.eINSTANCE
							.createInformationFlow().eClass());

			flow.getInformationSources().add(sourceClazz);
			flow.getInformationTargets().add(targetClazz);
			// add informationFlow to registry
			ElementRegistry.instance.addElementGuid(guid, flow);
		}
	}

	/**
	 * some helpful method for debugging dependency problems 
	 */
	public void printDependencies() {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Dependencies:");
		sb.append("\n");
		for (String guid : dependencyMap.keySet()) {
			sb.append(guid + ":\n");
			int i = 1;
			for (Integer parent : dependencyMap.get(guid)) {
				Element element = ElementRegistry.instance.getById(parent);
				if (element != null) {
					sb.append(i++);
					if (element instanceof Port) {
						Port port = (Port) element;
						sb.append(". Port-Parent=" + port.getName());
					} else if (element instanceof Dependency) {
						Dependency dep = (Dependency) element;
						sb.append(". Dependency=" + dep.getName());

						sb.append("\nSuppliers:\n");
						for (NamedElement ne : dep.getSuppliers())
							sb.append("\n" + ne.getName());
						sb.append("\nClients:\n");
						for (NamedElement ne : dep.getClients())
							sb.append("\t" + ne.getName());
					} else if (element instanceof Package) {
						Package pack = (Package) element;
						sb.append(". Package=" + pack.getName());
					} else {
						sb.append("\nClass: " + element.getClass());
					}

					sb.append("\n");
				} else {
					log.fatal("parentID(" + parent + " not found in registry");
				}

			}
			sb.append("-------------------------------------------------------------------------\n");
		}
		sb.append("\n=======================================================================");
		log.debug(sb.toString());

	}

	/**
	 * some helpful method for debugging information flow problems 
	 */
	public void printInformationFlows() {
		StringBuilder sb = new StringBuilder();
		sb.append("List InformationFlows:");
		sb.append("\n");
		for (String guid : informationFlowMap.keySet()) {
			sb.append(guid + ":\n");
			for (Integer parent : informationFlowMap.get(guid)) {
				Port port = (Port) ElementRegistry.instance.getById(parent);
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

		log.debug(sb.toString());
	}

}
