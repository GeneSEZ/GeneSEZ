package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Value;

public interface IFeatureRenderer {

	public boolean checkDefaultValue();

	public void setDefaultValue(Object value);

	public void setValue(Value value);

	public void removeValue();

	public void dispose();
}
