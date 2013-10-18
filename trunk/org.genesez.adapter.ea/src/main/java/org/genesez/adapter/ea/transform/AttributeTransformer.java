package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1381923609784_130038_3706) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;
import org.genesez.adapter.ea.ResourceRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class AttributeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(AttributeTransformer.class);
	
	public static final AttributeTransformer INSTANCE = new AttributeTransformer();
	
	private Property property;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>AttributeTransformer</b></em>'.
	 */
	private AttributeTransformer() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_1_df50335_1381924068364_834917_3755) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Property transform(org.sparx.Attribute eaAttribute, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381923684867_489159_3735) ENABLED START */
		LOG.debug("Transforming attribute " + eaAttribute.GetName() + ", type: " + eaAttribute.GetType());
		
		// create property
		property = UMLFactory.eINSTANCE.createProperty();
		property.setName(eaAttribute.GetName());
		
		// add property to belonging element 
		if (umlElement instanceof Class) {
			((Class)umlElement).getOwnedAttributes().add(property);
		}else if (umlElement instanceof org.eclipse.uml2.uml.Interface ){
			((Interface) umlElement).getOwnedAttributes().add(property);
		} else {
			LOG.error("attribute can not be added to " + umlElement.toString() + " because it's not implemented yet");
		}
		
		// set visibility
		property.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(eaAttribute));
		
		// set booleans
		property.setIsReadOnly(eaAttribute.GetIsConst());
		property.setIsStatic(eaAttribute.GetIsStatic());
		property.setIsOrdered(eaAttribute.GetIsOrdered());
		property.setIsDerived(eaAttribute.GetIsDerived());
		
		// find classifier id
		final int classiefierId = Integer.valueOf(eaAttribute.GetClassifierID());
		
		// check if element is an internal element
		if (classiefierId != 0) {
			LOG.debug("type is an class or element of the model with classiefierID -> " + classiefierId);
			PostProcessor.INSTANCE.addAttributeProperty(property, classiefierId);
			LOG.debug("added to post processor attribute properties");
		} else {
			
			final String attributeType = eaAttribute.GetType();
			// set type
			PrimitiveType type = ResourceRegistry.INSTANCE.importPrimitiveType(attributeType);
			if (type != null) {
				LOG.debug("PrimitiveType is = " + type.getName());
				property.setType(type);
				
				// check if default value is set
				if (eaAttribute.GetDefault().length() != 0) {
					// select the right type
					// now the type is clear -> set default value
					if (attributeType.equals("Integer")) {
						property.setIntegerDefaultValue(Integer.valueOf(eaAttribute.GetDefault()));
					} else if (attributeType.equals("String")) {
						property.setDefault(eaAttribute.GetDefault());
					} else if (attributeType.equals("Boolean")) {
						property.setBooleanDefaultValue(Boolean.valueOf(eaAttribute.GetDefault()));
					}
				}
			}
		}
		
		// transform comment
		final String notes = eaAttribute.GetNotes();
		if (notes.length() != 0) {
			property.createOwnedComment().setBody(notes);
		}
		
		// transform multiplicity
		MultiplicityTransformer.INSTANCE.transform(property, eaAttribute);
		
		// apply stereotypes
		// object has to be element of classifier, otherwise stereotype cannot be applied
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(eaAttribute, property);
		
		ElementRegistry.INSTANCE.addAttribute(eaAttribute, property);
		return property;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1381923609784_130038_3706) ENABLED START */
	// :)
	/* PROTECTED REGION END */
}
