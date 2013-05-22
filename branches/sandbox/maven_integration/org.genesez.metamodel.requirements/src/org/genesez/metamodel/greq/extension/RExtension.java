package org.genesez.metamodel.greq.extension;

import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RSpecObject;

public interface RExtension<A extends RExtension.Annotation, T extends RExtension.Tag> {
	
	public interface Annotation {
		String getUri();
	}
	
	public interface Tag {
		String getName();
	}
	
	public void init(RModel model);
	public boolean hasAnnotation(RSpecObject object, A annotation);
	public boolean hasValue(RSpecObject object, A annotation, T tag, String value);
	public void assign(RSpecObject object, A annotation);
	public void assign(RSpecObject object, A annotation, T tag, String value);
}
