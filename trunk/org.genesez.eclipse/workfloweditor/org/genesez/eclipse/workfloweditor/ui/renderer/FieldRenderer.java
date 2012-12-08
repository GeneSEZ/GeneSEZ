package org.genesez.eclipse.workfloweditor.ui.renderer;

import java.lang.reflect.Field;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

@SuppressWarnings("restriction")
public interface FieldRenderer {

	public boolean renderElement(Composite parent, Field field, Parameter param, WorkflowComponent instance,
			IWorkbench workbench, IEclipseContext context);
}
