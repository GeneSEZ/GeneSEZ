package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1379947539745_511262_3540) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Association;
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
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Association transform(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1379947613518_181203_3567) ENABLED START */
		
		// debug
		ElementDebugger.INSTANCE.printConnector(connector);
		
		org.sparx.ConnectorEnd supplierEnd = connector.GetSupplierEnd();
		org.sparx.ConnectorEnd clientEnd = connector.GetClientEnd();
		
		// create new association
		Association association = UMLFactory.eINSTANCE.createAssociation();
		// set name
		association.setName(connector.GetName());
		
		Element sup = ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		Element cli = ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		
		if (!(sup instanceof Port) || !(cli instanceof Port)) {
			// TODO add class associations again
			LOG.error("Association for this is not implemented yet: " + sup.getClass());
			return null;
		}
		
		Port supplier = (Port) ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		Port client = (Port) ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		
		LOG.debug("Creating association between: " + supplier.getName() + " - " + client.getName());
		
		Property property = null;
		
		// Component component = (Component) supplier.getOwner();
		
		org.eclipse.uml2.uml.Package nearestPackage = supplier.getNearestPackage();
		
		// create the navigation
		if (supplierEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
			// association.getNavigableOwnedEnds().add(supplierProperty);
			LOG.debug("Supplier is Navigable!");
			property = supplier.createQualifier(supplier.getName(), supplier.getType());
			association.getMemberEnds().add(property);
		} else {
			// association.getMemberEnds().add(supplierProperty);
			property = association.createOwnedEnd(supplier.getName(), supplier.getType());
			// createLowerUpperCardinality(supplierProperty, clientEnd);
		}
		
		MultiplicityTransformer mt = new MultiplicityTransformer();
		
		// multiplicity
		mt.transform(property, supplierEnd);
		//		createLowerUpperCardinality(property, supplierEnd);
		
		if (clientEnd.GetNavigable().equals(NAVIGABLE_STRING)) {
			LOG.debug("Client is Navigable!");
			property = client.createQualifier(client.getName(), client.getType());
			association.getMemberEnds().add(property);
		} else {
			// association.getMemberEnds().add(clientProperty);
			property = association.createOwnedEnd(client.getName(), client.getType());
			// createLowerUpperCardinality(clientProperty, clientEnd);
		}
		// multiplicity
		//		createLowerUpperCardinality(property, clientEnd);
		mt.transform(property, clientEnd);
		
		LOG.debug("Package = " + nearestPackage.getName() + "\tComponent= " + nearestPackage.getName());
		nearestPackage.getPackagedElements().add(association);
		
		association = (Association) ApplyStereotypeTransformer.INSTANCE.applyStereotypes(connector, association);
		ElementRegistry.INSTANCE.addElement(connector, association);
		
		return association;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1379947539745_511262_3540) ENABLED START */
	
	/* PROTECTED REGION END */
}
