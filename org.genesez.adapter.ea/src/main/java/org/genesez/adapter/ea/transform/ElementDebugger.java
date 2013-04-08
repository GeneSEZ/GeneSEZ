package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363681483226_501411_2064) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sparx.ConnectorConstraint;
import org.sparx.ConnectorTag;
import org.sparx.Issue;
import org.sparx.Property;
import org.sparx.TaggedValue;

/**
 * debugging class for a set of org.sparx.Elements
 * 
 * TODO maybe to delete this class in future, this is quick 'n dirty
 * @author christian
 */

public class ElementDebugger {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ElementDebugger.class);
	
	public static final ElementDebugger INSTANCE = new ElementDebugger();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ElementDebugger</b></em>'.
	 */
	
	private ElementDebugger() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363681638138_829588_2092) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * print debugging information about org.sparx.Connector
	 * @param	connector	
	 */
	
	public void printConnector(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363936416379_5142_1880) ENABLED START */
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Type = " + connector.GetType());
		sb.append("\n");
		sb.append("GUID -> " + connector.GetConnectorGUID());
		sb.append("\n");
		sb.append("Properties:\n");
		for (Property p : connector.GetProperties()) {
			sb.append("\tName = " + p.GetName() + " ->\tValue = " + p.GetValue());
			sb.append("\n");
		}
		sb.append("direction: " + connector.GetDirection());
		sb.append("\n");
		sb.append("client: " + connector.GetClientID());
		sb.append("\n");
		sb.append("supplier: " + connector.GetSupplierID());
		sb.append("\n");
		sb.append("SupplierEnd Navigable: " + connector.GetSupplierEnd().GetNavigable());
		sb.append("\n");
		sb.append("Supplier Cardinality: " + connector.GetSupplierEnd().GetCardinality());
		sb.append("\n");
		sb.append("ClientEnd Navigable: " + connector.GetClientEnd().GetNavigable());
		sb.append("\n");
		sb.append("Client Cardinality: " + connector.GetClientEnd().GetCardinality());
		sb.append("\n");
		
		sb.append("StereoType = " + connector.GetStereotype());
		sb.append("\n");
		sb.append("StereoTypeEx = " + connector.GetStereotypeEx());
		sb.append("\n");
		
		sb.append("Constraints:\n");
		for (ConnectorConstraint con : connector.GetConstraints()) {
			sb.append("\tName=" + con.GetName());
			sb.append("\n");
			sb.append("\tNotes=" + con.GetNotes());
			sb.append("\n");
			sb.append("\tType=" + con.GetType());
			sb.append("\n");
		}
		
		sb.append("TaggedValues:\n");
		for (ConnectorTag val : connector.GetTaggedValues()) {
			sb.append("\t");
			sb.append("Name=" + val.GetName());
			sb.append("\t->\t");
			sb.append("Value=" + val.GetValue());
			sb.append("\n");
		}
		
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * print debugging information about the org.sparx.Element
	 * @param	element	
	 */
	
	public void printElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363936442656_377777_1884) ENABLED START */
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Name = " + element.GetName());
		sb.append("\n");
		sb.append("Genfile = " + element.GetGenfile());
		sb.append("\n");
		//		sb.append(" " + _e. );
		//		sb.append("\n");
		sb.append("Alias = " + element.GetAlias());
		sb.append("\n");
		sb.append("Classfier = " + element.GetClassfierID());
		sb.append("\n");
		sb.append("Classifier = " + element.GetClassifierID());
		sb.append("\n");
		sb.append("Abstract = " + element.GetAbstract());
		sb.append("\n");
		sb.append("Complexity = " + element.GetComplexity());
		sb.append("\n");
		sb.append("Gentype = " + element.GetGentype());
		sb.append("\n");
		sb.append("Multiplicity = " + element.GetMultiplicity());
		sb.append("\n");
		sb.append("Persistance = " + element.GetPersistence());
		sb.append("\n");
		sb.append("ClassifierType = " + element.GetClassifierType());
		sb.append("\n");
		sb.append("IsNew = " + element.GetIsNew());
		sb.append("\n");
		sb.append("IsSpec = " + element.GetIsSpec());
		sb.append("\n");
		sb.append("IsLeaf = " + element.GetIsLeaf());
		sb.append("\n");
		sb.append("IsActive = " + element.GetIsActive());
		sb.append("\n");
		sb.append("Issues:\n");
		for (Issue issue : element.GetIssues()) {
			sb.append("\t");
			sb.append("name=" + issue.GetName() + " type=" + issue.GetType());
			sb.append("\n");
		}
		
		sb.append("\n");
		sb.append("Properties...\n ");
		for (Property p : element.GetProperties()) {
			sb.append("\t");
			sb.append("name=" + p.GetName() + " val=" + p.GetValue());
			sb.append("\n");
		}
		
		sb.append("Stereotypes:\n");
		sb.append(element.GetStereotypeList());
		sb.append("\n");
		sb.append("Extension=" + element.GetStereotypeEx());
		sb.append("\n");
		
		sb.append("Tagged Values:\n");
		for (TaggedValue val : element.GetTaggedValues()) {
			sb.append("id(" + val.GetElementID() + ")\tName=" + val.GetName() + " -> Val = " + val.GetValue());
			sb.append("\n");
		}
		
		LOG.debug(sb.toString());
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363681483226_501411_2064) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
