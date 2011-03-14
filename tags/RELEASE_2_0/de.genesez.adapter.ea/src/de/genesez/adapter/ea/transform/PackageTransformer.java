package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class PackageTransformer extends AbstractPackageTransformer {

	private static final Log log = LogFactory.getLog(PackageTransformer.class);
	
	Package transform(org.sparx.Package _p, Package _parent) {
		log.debug("Creating Package " + _p.GetName());

		this.umlPackage = _parent.createNestedPackage(_p.GetName(),
				UMLFactory.eINSTANCE.createPackage().eClass());
		this.eaPackage = _p;

		this.transformPackages();
		this.transformElements();

		ElementRegistry.instance.addElement(_p, this.umlPackage);
		return this.umlPackage;
	}

	@Override
	protected void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName() + ", type: "+_e.GetType());
		
		if ( _e.GetType().equals("Actor") ) {
			log.debug("Element is an Actor");
		}
		else if ( _e.GetType().equals("UseCase") ) {
			log.debug("Element is a UseCase");
			UseCaseTransformer t = new UseCaseTransformer();
			t.transform(_e, this.umlPackage);
		}
		else if ( _e.GetType().equals("Activity") ) {
			log.debug("Element is a Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(_e, this.umlPackage);
		}else if ( _e.GetType().equals("Component") ) {
			log.debug("Element is a Component");
			ComponentTransformer t = new ComponentTransformer();
			t.transform(_e, this.umlPackage);
		}else if ( _e.GetType().equals("Class") ) {
			log.debug("Element is a Class");
			ClassTransformer t = new ClassTransformer();
			t.transform(_e, this.umlPackage);
		}else if ( _e.GetType().equals("Interface") ) {
			log.debug("Element is a Interface");
			InterfaceTransformer t = new InterfaceTransformer();
			t.transform(_e, this.umlPackage);
		}
	}
}
