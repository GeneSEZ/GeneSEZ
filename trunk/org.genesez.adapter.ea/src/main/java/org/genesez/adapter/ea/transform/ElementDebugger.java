package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363681483226_501411_2064) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sparx.Collection;
import org.sparx.Connector;
import org.sparx.ConnectorConstraint;
import org.sparx.ConnectorTag;
import org.sparx.CustomProperty;
import org.sparx.Issue;
import org.sparx.Method;
import org.sparx.Parameter;
import org.sparx.Property;
import org.sparx.TaggedValue;

/**
 * debugging class for a set of org.sparx.Elements and org.sparx.connectors.
 * @author Christian
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
	 * print debugging information about the org.sparx.Element
	 */
	public void printElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363936442656_377777_1884) ENABLED START */
		
		StringBuilder sb = new StringBuilder("\n");
		
		sb.append("Name = " + element.GetName());
		sb.append("\n");
		sb.append("Genfile = " + element.GetGenfile());
		sb.append("\n");
		
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
		
		// issues to string
		sb.append(issuesToString(element.GetIssues()));
		
		sb.append("\n");
		
		sb.append(propertiesToString(element.GetProperties()));
		
		sb.append("Stereotypes:\n");
		sb.append("\t");
		sb.append(element.GetStereotypeList());
		sb.append("\n");
		sb.append("Extension = " + element.GetStereotypeEx());
		sb.append("\n");
		
		// tagged values to string
		sb.append(taggedValuesToString(element.GetTaggedValues()));
		
		// interfaces
		sb.append("\n");
		sb.append("" + connectorsToString(element.GetConnectors()));
		
		LOG.debug(sb.toString());
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * print debugging information about org.sparx.Connector
	 */
	public void printConnector(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363936416379_5142_1880) ENABLED START */
		StringBuilder sb = new StringBuilder("\n");
		sb.append("Type = " + connector.GetType());
		sb.append("\n");
		sb.append("GUID -> " + connector.GetConnectorGUID());
		sb.append("\n");
		
		// connector properties to string
		sb.append(propertiesToString(connector.GetProperties()));
		
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
		sb.append("Subtype: " + connector.GetSubtype());
		sb.append("\n");
		sb.append("Stateflags: " + connector.GetStateFlags());
		sb.append("\n");
		sb.append("Alias: " + connector.GetAlias());
		sb.append("\n");
		sb.append("Type: " + connector.GetType());
		sb.append("\n");
		sb.append("MetaType: " + connector.GetMetaType());
		sb.append("\n");
		sb.append("Eventflags: " + connector.GetEventFlags());
		sb.append("\n");
		sb.append("propertieCount: " + connector.GetProperties().GetCount());
		sb.append("\n");
		// custom properties
		sb.append(customPropertiesToString(connector.GetCustomProperties()));
		
		sb.append("StereoType = " + connector.GetStereotype());
		sb.append("\n");
		sb.append("StereoTypeEx = " + connector.GetStereotypeEx());
		sb.append("\n");
		
		// connector constraints to string
		sb.append(connectorConstraintsToString(connector.GetConstraints()));
		
		// connectorTagged values
		sb.append(connectorTagsToString(connector.GetTaggedValues()));
		
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private String propertiesToString(org.sparx.Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1367308475143_100237_1529) ENABLED START */
		StringBuilder sb = new StringBuilder("Properties:\n");
		int count = 0;
		for (Property p : properties) {
			sb.append("\tPropertie " + ++count);
			sb.append("\n\t\t");
			sb.append("Name = " + p.GetName());
			sb.append("\n\t\t");
			sb.append("Value = " + p.GetValue());
			sb.append("\n\t\t");
			sb.append("Type = " + p.GetType());
			sb.append("\n\t\t");
			sb.append("Validation = " + p.GetValidation());
			sb.append("\n\t\t");
			sb.append("ObjectType = " + p.GetObjectType());
			sb.append("\n");
		}
		return sb.toString();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363681483226_501411_2064) ENABLED START */
	
	private String customPropertiesToString(Collection<CustomProperty> properties) {
		StringBuilder sb = new StringBuilder();
		sb.append("CustomProperties:\n\t");
		for (CustomProperty prop : properties) {
			sb.append(prop.GetName() + " - " + prop.GetValue());
			sb.append("\n\t");
		}
		return sb.toString();
	}
	
	private String taggedValuesToString(Collection<TaggedValue> collection) {
		StringBuilder sb = new StringBuilder("Tagged Values:\n");
		for (TaggedValue val : collection) {
			sb.append("id(" + val.GetElementID() + ")\tName=" + val.GetName() + " -> Val = " + val.GetValue());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private String connectorTagsToString(Collection<ConnectorTag> collection) {
		StringBuilder sb = new StringBuilder("Tagged Values:\n");
		for (ConnectorTag val : collection) {
			sb.append("\t");
			sb.append("Name=" + val.GetName());
			sb.append("\t->\t");
			sb.append("Value=" + val.GetValue());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private String connectorConstraintsToString(Collection<ConnectorConstraint> constraints) {
		StringBuilder sb = new StringBuilder("Constraints:\n");
		for (ConnectorConstraint con : constraints) {
			sb.append("\tName=" + con.GetName());
			sb.append("\n");
			sb.append("\tNotes=" + con.GetNotes());
			sb.append("\n");
			sb.append("\tType=" + con.GetType());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private String issuesToString(Collection<Issue> issues) {
		StringBuilder sb = new StringBuilder("Issues:\n");
		for (Issue issue : issues) {
			sb.append("\t");
			sb.append("name=" + issue.GetName() + " type=" + issue.GetType());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void printAttribute(org.sparx.Attribute attribute) {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("GUID = " + attribute.GetAttributeGUID());
		sb.append("\n");
		sb.append("ID = " + attribute.GetAttributeID());
		sb.append("\n");
		sb.append("ClassifierID = " + attribute.GetClassifierID());
		sb.append("\n");
		sb.append("Container = " + attribute.GetContainer());
		sb.append("\n");
		sb.append("Default = " + attribute.GetDefault());
		sb.append("\n");
		sb.append("LowerBound = " + attribute.GetLowerBound());
		sb.append("\n");
		sb.append("UpperBound = " + attribute.GetUpperBound());
		sb.append("\n");
		sb.append("Name = " + attribute.GetName());
		sb.append("\n");
		sb.append("ParentID = " + attribute.GetParentID());
		sb.append("\n");
		sb.append("Stereotype = " + attribute.GetStereotype());
		sb.append("\n");
		sb.append("Type = " + attribute.GetType());
		sb.append("\n");
		sb.append("Visibility = " + attribute.GetVisibility());
		sb.append("\n");
		sb.append("AllowDuplicates = " + attribute.GetAllowDuplicates());
		sb.append("\n");
		
		sb.append("isConst = " + attribute.GetIsConst());
		sb.append("\n");
		sb.append("isStatic = " + attribute.GetIsStatic());
		sb.append("\n");
		sb.append("isDerived = " + attribute.GetIsDerived());
		sb.append("\n");
		sb.append("isOrdered = " + attribute.GetIsOrdered());
		sb.append("\n");
		sb.append("isCollection = " + attribute.GetIsCollection());
		sb.append("\n");
		LOG.debug(sb.toString());
	}
	
	public void printMethod(Method method) {
		StringBuilder sb = new StringBuilder("\n");
		sb.append("GUID = " + method.GetMethodGUID());
		sb.append("\n");
		sb.append("ID = " + method.GetMethodID());
		sb.append("\n");
		sb.append("ClassifierID = " + method.GetClassifierID());
		sb.append("\n");
		sb.append("Name = " + method.GetName());
		sb.append("\n");
		sb.append("ParentID = " + method.GetParentID());
		sb.append("\n");
		sb.append("Stereotype = " + method.GetStereotype());
		sb.append("\n");
		sb.append("Behavior = " + method.GetBehavior());
		sb.append("\n");
		sb.append("Visibility = " + method.GetVisibility());
		sb.append("\n");
		sb.append("Code = " + method.GetCode());
		sb.append("\n");
		sb.append("ReturnType = " + method.GetReturnType());
		sb.append("\n");
		sb.append("ReturnIsArray " + method.GetReturnIsArray());
		sb.append("\n");
		
		sb.append(parametersToString(method.GetParameters()));
		sb.append("\n");
		
		sb.append("isConst = " + method.GetIsConst());
		sb.append("\n");
		sb.append("isStatic = " + method.GetIsStatic());
		sb.append("\n");
		sb.append("isLeaf = " + method.GetIsLeaf());
		sb.append("\n");
		sb.append("isPure = " + method.GetIsPure());
		sb.append("\n");
		sb.append("isQuery = " + method.GetIsQuery());
		sb.append("\n");
		sb.append("isRoot = " + method.GetIsRoot());
		sb.append("\n");
		sb.append("IsSynchronized = " + method.GetIsSynchronized());
		sb.append("\n");
		LOG.debug(sb.toString());
	}
	
	private String parametersToString(Collection<Parameter> parameters) {
		StringBuilder sb = new StringBuilder("Parameters:\n");
		for (Parameter para : parameters) {
			sb.append("\t");
			sb.append("name=" + para.GetName() + " type=" + para.GetType());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private String connectorsToString(Collection<Connector> connectorSet) {
		StringBuilder sb = new StringBuilder("Connectors:\n");
		for (Connector con : connectorSet) {
			sb.append("\t");
			sb.append("name=" + con.GetName() + " type=" + con.GetType());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	// private String parameterToString(Parameter parameter){
	// StringBuilder sb = new StringBuilder();
	// return "";
	// }
	
	/* PROTECTED REGION END */
}
