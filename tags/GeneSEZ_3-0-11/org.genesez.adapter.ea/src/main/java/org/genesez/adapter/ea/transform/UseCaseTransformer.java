package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363954611865_954816_2833) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class UseCaseTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(UseCaseTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public UseCase transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363954828050_334396_2873) ENABLED START */
		LOG.debug("Creating UseCase " + element.GetName() + ", parent " + parent.getName());
		
		UseCase useCase = UMLFactory.eINSTANCE.createUseCase();
		useCase.setPackage(parent);
		useCase.setName(element.GetName());
		
		this.umlElement = useCase;
		this.eaElement = element;
		
		this.transformElements();
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(element, useCase);
		return useCase;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 */
	
	protected void transformElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363954911281_311088_2886) ENABLED START */
		if (element.GetType().equals("Activity")) {
			LOG.debug("Element is a Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(element, (UseCase) this.umlElement);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363954611865_954816_2833) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
