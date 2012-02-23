package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.genesez.adapter.ea.ElementRegistry;


public class UseCaseTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(UseCaseTransformer.class);
	
	UseCase transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating UseCase " + _e.GetName() + ", parent " + _parent.getName());

		UseCase useCase = UMLFactory.eINSTANCE.createUseCase();
		useCase.setPackage(_parent);
		useCase.setName(_e.GetName());

		this.umlElement = useCase;
		this.eaElement = _e;

		this.transformElements();
		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, useCase);
		return useCase;
	}
	
	@Override
	protected void transformElement(org.sparx.Element _e) {
		if ( _e.GetType().equals("Activity") ) {
			log.debug("Element is a Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(_e, (UseCase)this.umlElement);
		}
	}
}
