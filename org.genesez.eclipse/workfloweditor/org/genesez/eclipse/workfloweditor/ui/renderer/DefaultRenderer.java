package org.genesez.eclipse.workfloweditor.ui.renderer;

import java.lang.reflect.Field;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

@SuppressWarnings("restriction")
public class DefaultRenderer implements FieldRenderer {

	public DefaultRenderer() {
		super();
	}

	@Override
	public boolean renderElement(Composite parent, Field field, Parameter param, WorkflowComponent instance,
			IWorkbench workbench, IEclipseContext context) {
		Label fieldLabel = new Label(parent, SWT.NONE);
		fieldLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		fieldLabel.setText(field.getName() + ":");
		Text fieldValue = new Text(parent, SWT.BORDER);
		fieldValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Object value = null;
		try {
			value = field.get(instance);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (value != null) {
			fieldValue.setText(value.toString());
		}
		return true;
	}

}
