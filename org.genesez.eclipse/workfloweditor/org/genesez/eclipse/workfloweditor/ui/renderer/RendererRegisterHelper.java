package org.genesez.eclipse.workfloweditor.ui.renderer;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.genesez.eclipse.workfloweditor.ui.renderer.collection.DefaultCollectionRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.collection.WorkflowCollectionRenderer;

public class RendererRegisterHelper {
	private static Set<FieldRenderer> availableRenderer = new LinkedHashSet<FieldRenderer>();
	private static FieldRenderer defaultRenderer;

	public static Collection<FieldRenderer> getRenderer() {
		return availableRenderer;
	}

	public static FieldRenderer getDefaultRenderer() {
		return defaultRenderer;
	}

	public static void setDefaultRenderer(FieldRenderer defRenderer) {
		if (defRenderer != null) {
			defaultRenderer = defRenderer;
		}
	}

	public static void addAvailableRenderer(FieldRenderer renderer) {
		availableRenderer.add(renderer);
	}

	static {
		addAvailableRenderer(new WorkflowCollectionRenderer());
		addAvailableRenderer(new DefaultCollectionRenderer());
		setDefaultRenderer(new DefaultRenderer());
	}
}
