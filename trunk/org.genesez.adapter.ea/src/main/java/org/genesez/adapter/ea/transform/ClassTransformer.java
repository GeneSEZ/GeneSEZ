package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363942476721_653989_2257) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;
import org.genesez.adapter.ea.ResourceRegistry;
import org.sparx.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class ClassTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ClassTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Class transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942522238_266030_2282) ENABLED START */
		LOG.debug("Creating Class " + element.GetName() + ", parent " + parent.getName());
		
		// TODO for development
		ElementDebugger.INSTANCE.printElement(element);
		
		// create class
		Class clazz = UMLFactory.eINSTANCE.createClass();
		clazz.setName(element.GetName());
		clazz.setIsLeaf(element.GetIsLeaf());
		clazz.setIsActive(element.GetIsActive());
		
		// is abstract
		if (element.GetAbstract().equals("0")) {
			clazz.setIsAbstract(false);
		} else if (element.GetAbstract().equals("1")) {
			clazz.setIsAbstract(true);
		}
		
		// get description (in EA called notes) from class
		if (element.GetNotes().length() != 0) {
			clazz.createOwnedComment().setBody(element.GetNotes());
		}
		
		// set visibility
		clazz.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(element));
		
		parent.getPackagedElements().add(clazz);
		
		this.umlElement = clazz;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// apply stereotypes
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(element, clazz);
		
		ElementRegistry.INSTANCE.addElement(element, clazz);
		return clazz;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformAttribute(org.sparx.Attribute attribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942550717_486719_2287) ENABLED START */
		LOG.debug("Transforming attribute " + attribute.GetName() + ", type: " + attribute.GetType());
		
		// TODO for development
		ElementDebugger.INSTANCE.printAttribute(attribute);
		
		// create property
		Property property = UMLFactory.eINSTANCE.createProperty();
		property.setName(attribute.GetName());
		
		// set visibility
		property.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(attribute));
		
		// set booleans
		property.setIsReadOnly(attribute.GetIsConst());
		property.setIsStatic(attribute.GetIsStatic());
		property.setIsOrdered(attribute.GetIsOrdered());
		property.setIsDerived(attribute.GetIsDerived());
		
		// find classifier id
		final int classiefierId = Integer.valueOf(attribute.GetClassifierID());
		
		if (classiefierId != 0) {
			LOG.debug("type is an class or element of the model with classiefierID -> " + classiefierId);
			PostProcessor.INSTANCE.addAttributeProperty(property, classiefierId);
			LOG.debug("added to post processor attribute properties");
		} else {
			
			final String attributeType = attribute.GetType();
			// set type
			// TODO search for existing classes, then external classes and then primitves
			// maybe create a map with imported primitive types
			PrimitiveType type = ResourceRegistry.INSTANCE.importPrimitiveType(attributeType);
			if (type != null) {
				LOG.debug("PrimitiveType is = " + type.getName());
				property.setType(type);
				
				// check if default value is set
				if (attribute.GetDefault().length() != 0) {
					// select the right type
					// now the type is clear -> set default value
					if (attributeType.equals("Integer")) {
						property.setIntegerDefaultValue(Integer.valueOf(attribute.GetDefault()));
					} else if (attributeType.equals("String")) {
						property.setDefault(attribute.GetDefault());
					} else if (attributeType.equals("Boolean")) {
						property.setBooleanDefaultValue(Boolean.valueOf(attribute.GetDefault()));
					}
				}
			}
		}
		
		// transform multiplicity
		MultiplicityTransformer mt = new MultiplicityTransformer();
		mt.transform(property, attribute);
		
		((Class) this.umlElement).getOwnedAttributes().add(property);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformMethod(org.sparx.Method method) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942597915_721139_2291) ENABLED START */
		LOG.debug("Transforming method " + method.GetName() + ", type: " + method.GetReturnType());
		
		Operation operation = UMLFactory.eINSTANCE.createOperation();
		operation.setName(method.GetName());
		
		// do notes on method
		if (method.GetNotes().length() != 0) {
			operation.createOwnedComment().setBody(method.GetNotes());
		}
		
		ElementDebugger.INSTANCE.printMethod(method);
		
		// set operation global
		this.operation = operation;
		
		// iterate over all parameters
		for (Parameter parameter : method.GetParameters()) {
			this.transform(parameter);
		}
		
		// set the return type
		final String returnType = method.GetReturnType();
		if (returnType.length() != 0) {
			if (returnType.equals("Integer") || returnType.equals("Boolean") || returnType.equals("String")) {
				operation.createReturnResult(null, ResourceRegistry.INSTANCE.importPrimitiveType(returnType));
			} else {
				LOG.error("return type not known yet -> " + returnType);
			}
			
		}
		
		// set the visibility
		this.operation.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(method));
		
		((Class) this.umlElement).getOwnedOperations().add(operation);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363942476721_653989_2257) ENABLED START */
	
	private Operation operation = null;
	
	private void transform(org.sparx.Parameter parameter) {
		
		// find classifier id
		final int classiefierId = Integer.valueOf(parameter.GetClassifierID());
		
		if (classiefierId != 0) {
			LOG.debug("type is an class or element of the model with classiefierID -> " + classiefierId);
			//			PostProcessor.INSTANCE
			//					.addAttributeProperty(operation, classiefierId);
			LOG.fatal("will not be  pressed yet...");
			LOG.debug("added to post processor attribute properties");
		}
		
		PrimitiveType type = ResourceRegistry.INSTANCE.importPrimitiveType(parameter.GetType());
		
		// if type is primitive type
		if (type != null) {
			this.operation.createOwnedParameter(parameter.GetName(), type);
		}
	}
	// :)
	
	/* PROTECTED REGION END */
}
