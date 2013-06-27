package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

import de.genesez.adapter.ea.ElementRegistry;

public abstract class PropertyTransformer {

	private static final Log log = LogFactory.getLog(PropertySimpleTransformer.class);
	protected org.sparx.Attribute eaAttribute;
	protected Property property;
	
	Property transform(org.sparx.Attribute _a, StructuredClassifier _parent) {
		log.debug("Creating Attribute " + _a.GetName() + ", parent " + _parent.getName());
		
		this.eaAttribute = _a;
		
		Type type = this.findType();
		
		this.property = _parent.createOwnedAttribute(_a.GetName(), type);
		this.property.setIsDerived(this.eaAttribute.GetIsDerived());
		this.property.setIsReadOnly(this.eaAttribute.GetIsOrdered());
		this.property.setIsReadOnly(this.eaAttribute.GetIsConst());
		this.property.setIsStatic(this.eaAttribute.GetIsStatic());
		
		ElementRegistry.instance.addElement(this.eaAttribute, this.property);

		return this.property;
	}
	
	protected abstract Type findType();
}
