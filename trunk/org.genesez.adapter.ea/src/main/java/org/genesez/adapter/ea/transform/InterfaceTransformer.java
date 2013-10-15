package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363944629075_389873_2450) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class InterfaceTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(InterfaceTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Interface transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363944745586_266742_2480) ENABLED START */
		LOG.debug("Creating Interface " + element.GetName() + ", parent: " + parent.getName());
		Interface iface = parent.createOwnedInterface(element.GetName());
		
		iface.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(element));
		
		this.umlElement = iface;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		InterfaceFactory.INSTANCE.setInterfacePackage(parent);
		ElementRegistry.INSTANCE.addInterface(element, iface);
		return iface;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363944629075_389873_2450) ENABLED START */
	// TODO duplicate to class transformer
	protected void transformAttribute(org.sparx.Attribute attribute) {
		LOG.debug("Transforming attribute in interface " + attribute.GetName() + ", type: " + attribute.GetType());
		
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
		
		((Interface) this.umlElement).getOwnedAttributes().add(property);
	}
	
	// TODO also duplicate
	protected void transformMethod(org.sparx.Method method) {
		LOG.debug("Transforming method '" + method.GetName() + "' in interface: " + eaElement.GetName());
		
		// create method
		Operation operation = UMLFactory.eINSTANCE.createOperation();
		
		LOG.fatal("note yet implemented");
		//		((Interface)this.umlElement).createOwnedOperation(method.GetName(), ownedParameterNames, ownedParameterTypes)
		
	}
	/* PROTECTED REGION END */
}
