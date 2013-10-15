package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1381497580631_459619_3740) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class DataTypeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(DataTypeTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public DataType transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381497593329_773599_3760) ENABLED START */
		DataType umlDataType = UMLFactory.eINSTANCE.createDataType();
		
		// add to parent
		parent.getPackagedElements().add(umlDataType);
		
		// set attributes
		umlDataType.setName(element.GetName());
		
		// apply stereotypes
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(element, umlDataType);
		
		LOG.info("DataType created: " + umlDataType.getName());
		// add to registry
		ElementRegistry.INSTANCE.addElement(element, umlDataType);
		return umlDataType;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1381497580631_459619_3740) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
