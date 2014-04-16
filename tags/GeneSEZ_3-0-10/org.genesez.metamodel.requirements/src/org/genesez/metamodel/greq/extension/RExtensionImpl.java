package org.genesez.metamodel.greq.extension;

import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.metamodel.greq.GreqFactory;
import org.genesez.metamodel.greq.RAnnotation;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RSpecObject;
import org.genesez.metamodel.greq.RTag;
import org.genesez.metamodel.greq.RValue;

public class RExtensionImpl<A extends RExtension.Annotation, T extends RExtension.Tag> implements RExtension<A, T> {
	
	protected Map<Annotation, RAnnotation> annotations = new LinkedHashMap<Annotation, RAnnotation>();
	protected Map<Tag, RTag> tags = new LinkedHashMap<Tag, RTag>();
	private RModel current = null;
	
	public void init(RModel model) {
		if (current != model) {
			current = model;
			annotations.clear();
			tags.clear();
		}
	}
	
	public boolean hasAnnotation(RSpecObject object, A annotation) {
		for (RAnnotation a : object.getAnnotation()) {
			if (a.getUri().equals(annotations.get(annotation).getUri())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasValue(RSpecObject object, A annotation, T tag, String value) {
		if (hasAnnotation(object, annotation)) {
			for (RValue v : object.getValue()) {
				if (v.getTag().getName().equals(tags.get(tag).getName()) && v.getTag().getAnnotation().getUri().equals(annotations.get(annotation).getUri())) {
					if (v.getValue().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void assign(RSpecObject object, A annotation) {
		if (!hasAnnotation(object, annotation)) {
			object.getAnnotation().add(annotations.get(annotation));
		}
	}
	
	public void assign(RSpecObject object, A annotation, T tag, String value) {
		// check annotation
		assign(object, annotation);
		// check value
		if (!hasValue(object, annotation, tag, value)) {
			RValue v = GreqFactory.eINSTANCE.createRValue();
			object.getValue().add(v);
			v.setTag(tags.get(tag));
			v.setValue(value);
		}
	}
	
	
	protected RAnnotation createAnnotation(RModel model, A annotation) {
		// check if already exists
		for (RAnnotation ext : model.getExtension()) {
			if (ext.getUri().equals(annotation.getUri())) {
				return ext;
			}
		}
		// create
		RAnnotation ext = GreqFactory.eINSTANCE.createRAnnotation();
		model.getExtension().add(ext);
		ext.setUri(annotation.getUri());
		return ext;
	}
	
	protected RTag createTag(RAnnotation annotation, T tag) {
		// check existence
		for (RTag t : annotation.getTag()) {
			if (t.getName().equals(tag.getName())) {
				return t;
			}
		}
		// create
		RTag t = GreqFactory.eINSTANCE.createRTag();
		annotation.getTag().add(t);
		t.setName(tag.getName());
		return t;
	}
}
