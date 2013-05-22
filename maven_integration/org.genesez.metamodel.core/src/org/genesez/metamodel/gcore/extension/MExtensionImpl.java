package org.genesez.metamodel.gcore.extension;

import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.metamodel.gcore.GcoreFactory;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.metamodel.gcore.MStereotype;
import org.genesez.metamodel.gcore.MTag;
import org.genesez.metamodel.gcore.MTaggedValue;

public class MExtensionImpl<S extends MExtension.Stereotype, T extends MExtension.Tag> implements MExtension<S, T> {

	protected Map<S, MStereotype> stereotypes = new LinkedHashMap<S, MStereotype>();
	protected Map<T, MTag> tags = new LinkedHashMap<T, MTag>();
	private MModel current = null;
	
	public void init(MModel model) {
		if (current != model) {
			current = model;
			stereotypes.clear();
			tags.clear();
		}
	}
	
	public boolean hasStereotype(MElement element, S stereotype) {
		for (MStereotype s : element.getStereotype()) {
			if (s.getName().equals(stereotypes.get(stereotype).getName())) {
				return true;
			}			
		}
		return false;
	}
	
	public boolean hasTaggedValue(MElement element, S stereotype, T tag, String value) {
		if (hasStereotype(element, stereotype)) {
			for (MTaggedValue v : element.getTaggedValue()) {
				if (v.getTag().getName().equals(tag) && v.getTag().getStereotype().getName().equals(stereotype)) {
					if (v.equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void assign(MElement element, S stereotype) {
		if (!hasStereotype(element, stereotype)) {
			element.getStereotype().add(stereotypes.get(stereotype));
		}
	}
	
	public void assign(MElement element, S stereotype, T tag, String value) {
		// check stereotype
		assign(element, stereotype);
		// check tagged values
		if (!hasTaggedValue(element, stereotype, tag, value)) {
			MTaggedValue v = GcoreFactory.eINSTANCE.createMTaggedValue();
			element.getTaggedValue().add(v);
			v.setTag(tags.get(tag));
			v.setValue(value);
		}
	}
	
	
	protected MStereotype createStereotype(MModel model, S stereotype) {
		// check if already exists
		for (MStereotype s : model.getAnyStereotype()) {
			if (s.getName().equals(stereotype.getName())) {
				return s;
			}
		}
		// create
		MStereotype s = GcoreFactory.eINSTANCE.createMStereotype();
		model.getAnyStereotype().add(s);
		
		s.setName(stereotype.getName());
		s.setXmiGuid(stereotype.getName());
		
		return s;
	}
	
	protected MTag createTag(MStereotype stereotype, T tag) {
		// check if already exists
		for (MTag t : stereotype.getProperty()) {
			if (t.getName().equals(tag.getName())) {
				return t;
			}
		}
		// create
		MTag t = GcoreFactory.eINSTANCE.createMTag();
		stereotype.getProperty().add(t);
		t.setName(tag.getName());
		t.setType(tag.getType());
		return t;
	}
}
