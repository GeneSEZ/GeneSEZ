package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1379947539745_511262_3540) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class AssociationTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(AssociationTransformer.class);
	
	public static final String NAVIGABLE_STRING = "Navigable";
	
	private Association association;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Association transform(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1379947613518_181203_3567) ENABLED START */
		LOG.debug("Start transforming Association Name: " + connector.GetName());
		
		// TODO debug
		ElementDebugger.INSTANCE.printConnector(connector);
		
		// TODO search for already connected associations
		this.association = (Association) ElementRegistry.INSTANCE.getConnectorById(connector.GetConnectorID());
		if (this.association != null) {
			LOG.debug("Association has been transformed before");
			return this.association;
		}
		
		// get supplier and client
		org.sparx.ConnectorEnd supplierEnd = connector.GetSupplierEnd();
		org.sparx.ConnectorEnd clientEnd = connector.GetClientEnd();
		
		// create new association
		association = UMLFactory.eINSTANCE.createAssociation();
		// set name
		association.setName(connector.GetName());
		
		// TODO only needed if checking instance type
		Element sup = ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		Element cli = ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		
		if (!(sup instanceof Port) || !(cli instanceof Port)) {
			// just give it a try for class
			if (sup instanceof Class) {
				
				Class supplier = (Class) ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
				Class client = (Class) ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
				
				LOG.debug("Creating association between: " + supplier.getName() + " - " + client.getName());
				
				// property for supplier
				Property supplierProperty = createProperty(supplier, supplierEnd);
				Property clientProperty = createProperty(client, clientEnd);
				
				// set package
				org.eclipse.uml2.uml.Package nearestPackage = supplier.getNearestPackage();
				
				// create the navigation
				if (supplierEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
					LOG.debug("Supplier is Navigable!");
					client.getOwnedAttributes().add(supplierProperty);
					association.getMemberEnds().add(supplierProperty);
				} else {
					LOG.debug("Supplier is NOT Navigable!");
					association.getOwnedEnds().add(supplierProperty);
				}
				
				/**
				 * now set the client
				 */
				
				if (clientEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
					LOG.debug("Client is Navigable!");
					supplier.getOwnedAttributes().add(clientProperty);
					association.getMemberEnds().add(clientProperty);
				} else {
					LOG.debug("Client is NOT Navigable!");
					association.getOwnedEnds().add(clientProperty);
				}
				
				LOG.debug("Package = " + nearestPackage.getName() + "\tComponent= " + nearestPackage.getName());
				nearestPackage.getPackagedElements().add(association);
				
				association = (Association) ApplyStereotypeTransformer.INSTANCE.applyStereotypes(connector, association);
				
				ElementRegistry.INSTANCE.addConnector(connector, association);
				return association;
				
			}
			
			// TODO add class associations again
			LOG.error("Association for this is not implemented yet: " + sup.getClass());
			return null;
		}
		
		Port supplier = (Port) ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		Port client = (Port) ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		
		LOG.debug("Creating association between: " + supplier.getName() + " - " + client.getName());
		
		// property for supplier and client
		Property property = null;
		
		org.eclipse.uml2.uml.Package nearestPackage = supplier.getNearestPackage();
		
		// create the navigation
		if (supplierEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
			//			 association.getNavigableOwnedEnds().add(supplierProperty);
			LOG.debug("Supplier is Navigable!");
			property = supplier.createQualifier(supplier.getName(), supplier.getType());
			association.getMemberEnds().add(property);
		} else {
			LOG.debug("Supplier is NOT Navigable!");
			// association.getMemberEnds().add(supplierProperty);
			property = association.createOwnedEnd(supplier.getName(), supplier.getType());
		}
		// multiplicity
		MultiplicityTransformer.INSTANCE.transform(property, supplierEnd);
		
		if (clientEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
			LOG.debug("Client is Navigable!");
			property = client.createQualifier(client.getName(), client.getType());
			association.getMemberEnds().add(property);
		} else {
			LOG.debug("Client is NOT Navigable!");
			// association.getMemberEnds().add(clientProperty);
			property = association.createOwnedEnd(client.getName(), client.getType());
		}
		// multiplicity
		MultiplicityTransformer.INSTANCE.transform(property, clientEnd);
		
		LOG.debug("Package = " + nearestPackage.getName() + "\tComponent= " + nearestPackage.getName());
		nearestPackage.getPackagedElements().add(association);
		
		association = (Association) ApplyStereotypeTransformer.INSTANCE.applyStereotypes(connector, association);
		
		ElementRegistry.INSTANCE.addConnector(connector, association);
		return association;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1379947539745_511262_3540) ENABLED START */
	
	private static final int SHARED_AGGREGATION = 1;
	private static final int COMPOSITE_AGGREGATION = 2;
	
	private AggregationKind getAggregationKind(int aggregation) {
		switch (aggregation) {
			case SHARED_AGGREGATION:
				return AggregationKind.SHARED_LITERAL;
			case COMPOSITE_AGGREGATION:
				return AggregationKind.COMPOSITE_LITERAL;
			default:
				return AggregationKind.NONE_LITERAL;
		}
	}
	
	
	private Property createProperty(Class type, org.sparx.ConnectorEnd connectorEnd){
		Property property = UMLFactory.eINSTANCE.createProperty();
		
		// set aggregation
		property.setAggregation(getAggregationKind(connectorEnd.GetAggregation()));
		
		// set type
		property.setType(type);
		
		// set name
		property.setName(connectorEnd.GetRole());
		
		// set visibility of property
		property.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(connectorEnd));
		
		// multiplicity
		MultiplicityTransformer.INSTANCE.transform(property, connectorEnd);
		
		return property;
	}
	
	/* PROTECTED REGION END */
}
