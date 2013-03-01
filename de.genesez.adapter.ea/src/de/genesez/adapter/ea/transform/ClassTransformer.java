package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

import de.genesez.adapter.ea.ElementRegistry;

public class ClassTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(ClassTransformer.class);
	
	Class transform(org.sparx.Element _e, org.eclipse.uml2.uml.Package _parent) {
		log.debug("Creating Class " + _e.GetName() + ", parent " + _parent.getName());
		Class clazz = UMLFactory.eINSTANCE.createClass();
		clazz.setName(_e.GetName());
		clazz.setIsLeaf(_e.GetIsLeaf());
		clazz.setIsActive(_e.GetIsActive());
		if (_e.GetAbstract().equals("0")){
			clazz.setIsAbstract(false);
		} else if (_e.GetAbstract().equals("1")){
			clazz.setIsAbstract(true);
		}
		
		if (_e.GetVisibility().equals("Public")){
			clazz.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		} else if (_e.GetVisibility().equals("Private")){
			clazz.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		} else if (_e.GetVisibility().equals("Package")){
			clazz.setVisibility(VisibilityKind.PACKAGE_LITERAL);
		} else if (_e.GetVisibility().equals("Protected")){
			clazz.setVisibility(VisibilityKind.PROTECTED_LITERAL);
		}		
		
		_parent.getPackagedElements().add(clazz);
		
		this.umlElement = clazz;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, clazz);
		return clazz;
	}
	
	@Override
	protected void transformAttribute(org.sparx.Attribute _a) {
		log.debug("Transforming attribute " + _a.GetName() + ", type: "+_a.GetType());
		Property p = UMLFactory.eINSTANCE.createProperty();
		p.setName(_a.GetName());
			
		((Class) this.umlElement).getOwnedAttributes().add(p);
	}
	
	@Override
	protected void transformMethod(org.sparx.Method _m) {
		log.debug("Transforming method " + _m.GetName() + ", type: "+_m.GetReturnType());
		
		Operation operation = UMLFactory.eINSTANCE.createOperation();
		operation.setName(_m.GetName());
		
		((Class) this.umlElement).getOwnedOperations().add(operation);
	}
}
