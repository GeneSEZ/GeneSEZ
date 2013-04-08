package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363938404290_258809_1894) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class EnumerationTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(EnumerationTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Enumeration transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363938451628_646364_1920) ENABLED START */
		LOG.debug("Creating Enumeration " + element.GetName() + ", parent " + parent.getName());
		
		Enumeration enumeration = parent.createOwnedEnumeration(element.GetName());
		this.umlElement = enumeration;
		this.eaElement = element;
		
		this.transformAttributes();
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(element, enumeration);
		return enumeration;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	attribute	
	 */
	
	protected void transformAttribute(org.sparx.Attribute attribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363938510857_320879_1930) ENABLED START */
		LOG.debug("Transforming attribute " + attribute.GetName());
		
		if (0 < attribute.GetClassifierID()) {
			LOG.debug("Attribute is structured type");
			EnumerationLiteral l = ((Enumeration) this.umlElement).createOwnedLiteral(attribute.GetName());
			ElementRegistry.INSTANCE.addElement(attribute, l);
		} else {
			LOG.debug("Attribute is primitive type");
			EnumerationLiteral l = ((Enumeration) this.umlElement).createOwnedLiteral(attribute.GetName());
			ElementRegistry.INSTANCE.addElement(attribute, l);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363938404290_258809_1894) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
