package org.genesez.metamodel.gcore.extension;

import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MModel;

public interface MExtension<S extends MExtension.Stereotype, T extends MExtension.Tag> {
	
	public interface Stereotype {
		String getName();
		String getXmiGuid();
	}
	
	public interface Tag {
		String getName();
		String getType();
	}
	
	public void init(MModel model);
	public boolean hasStereotype(MElement element, S stereotype);
	public boolean hasTaggedValue(MElement element, S stereotype, T tag, String value);
	public void assign(MElement element, S stereotype);
	public void assign(MElement element, S stereotype, T tag, String value);
}
