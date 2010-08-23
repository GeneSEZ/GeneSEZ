package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;

public class DependencyTransformer extends AbstractElementTransformer{

private static final Log log = LogFactory.getLog(DependencyTransformer.class);
	
	Dependency transform(org.sparx.Connector _c, Component _parent) {
		log.debug("Creating Dependency " + _c.GetName() + ", parent " + _parent.getName());
		Dependency dependency = UMLFactory.eINSTANCE.createDependency();
//		dependency.setName(_c.GetName());
		dependency.setName(_c.GetStereotype());
		dependency.getClients().add(_parent);
//		Stereotype s = UMLFactory.eINSTANCE.createStereotype();
//		_parent.getModel().getOwnedElements().add(s);
//		s.setName(_c.GetStereotype());
//		dependency.applyStereotype(s);
		_parent.getPackagedElements().add(dependency);
		
		this.umlElement = dependency;
//		this.eaElement = _c;

//		this.transformAttributes();
//		this.transformOperations();
		
		ElementRegistry.instance.addElement(_c, dependency);
		PostProcessor.instance.setDependency(dependency, _c);
		return dependency;
	}
	
}
