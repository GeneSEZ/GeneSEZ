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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class ClassTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ClassTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Class transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942522238_266030_2282) ENABLED START */
		LOG.debug("Creating Class " + element.GetName() + ", parent " + parent.getName());
		Class clazz = UMLFactory.eINSTANCE.createClass();
		clazz.setName(element.GetName());
		clazz.setIsLeaf(element.GetIsLeaf());
		clazz.setIsActive(element.GetIsActive());
		if (element.GetAbstract().equals("0")) {
			clazz.setIsAbstract(false);
		} else if (element.GetAbstract().equals("1")) {
			clazz.setIsAbstract(true);
		}
		
		if (element.GetVisibility().equals("Public")) {
			clazz.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		} else if (element.GetVisibility().equals("Private")) {
			clazz.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		} else if (element.GetVisibility().equals("Package")) {
			clazz.setVisibility(VisibilityKind.PACKAGE_LITERAL);
		} else if (element.GetVisibility().equals("Protected")) {
			clazz.setVisibility(VisibilityKind.PROTECTED_LITERAL);
		}
		
		parent.getPackagedElements().add(clazz);
		
		this.umlElement = clazz;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.INSTANCE.addElement(element, clazz);
		return clazz;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	attribute	
	 */
	
	protected void transformAttribute(org.sparx.Attribute attribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942550717_486719_2287) ENABLED START */
		LOG.debug("Transforming attribute " + attribute.GetName() + ", type: " + attribute.GetType());
		Property p = UMLFactory.eINSTANCE.createProperty();
		p.setName(attribute.GetName());
		
		((Class) this.umlElement).getOwnedAttributes().add(p);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	method	
	 */
	
	protected void transformMethod(org.sparx.Method method) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942597915_721139_2291) ENABLED START */
		LOG.debug("Transforming method " + method.GetName() + ", type: " + method.GetReturnType());
		
		Operation operation = UMLFactory.eINSTANCE.createOperation();
		operation.setName(method.GetName());
		
		((Class) this.umlElement).getOwnedOperations().add(operation);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363942476721_653989_2257) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
