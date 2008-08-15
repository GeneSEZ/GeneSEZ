package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class UseCaseTransformer {

	private static final Log log = LogFactory.getLog(UseCaseTransformer.class);
	private UseCase useCase;
	
	UseCase transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating UseCase " + _e.GetName() + ", parent " + _parent.getName());
		this.useCase = UMLFactory.eINSTANCE.createUseCase();
		this.useCase.setPackage(_parent);
		this.useCase.setName(_e.GetName());
		this.transformElements(_e);
		XmiFile.instance.addElement(this.useCase, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.useCase);
		return this.useCase;
	}
	
	private void transformElements(org.sparx.Element _e) {
		for (org.sparx.Element e : _e.GetElements()) {
			if ( e.GetType().equals("Activity") ) {
				log.debug("Element is a Activity");
				ActivityTransformer t = new ActivityTransformer();
				t.transform(e, this.useCase);
			}
		}
	}
}
