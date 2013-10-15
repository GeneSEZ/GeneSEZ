package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363949216084_802602_2716) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public abstract class PropertyTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PropertyTransformer.class);
	
	protected org.sparx.Attribute eaAttribute;
	
	protected Property property;
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 */
	protected abstract Type findType();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Property transform(org.sparx.Attribute attribute, StructuredClassifier parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363949388411_331913_2751) ENABLED START */
		LOG.debug("Creating Attribute " + attribute.GetName() + ", parent " + parent.getName());
		
		this.eaAttribute = attribute;
		
		Type type = this.findType();
		
		this.property = parent.createOwnedAttribute(attribute.GetName(), type);
		this.property.setIsDerived(this.eaAttribute.GetIsDerived());
		this.property.setIsReadOnly(this.eaAttribute.GetIsOrdered());
		this.property.setIsReadOnly(this.eaAttribute.GetIsConst());
		this.property.setIsStatic(this.eaAttribute.GetIsStatic());
		
		ElementRegistry.INSTANCE.addAttribute(this.eaAttribute, this.property);
		
		return this.property;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363949216084_802602_2716) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
