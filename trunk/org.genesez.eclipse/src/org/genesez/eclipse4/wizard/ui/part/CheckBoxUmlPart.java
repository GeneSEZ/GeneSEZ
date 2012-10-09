package org.genesez.eclipse4.wizard.ui.part;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class CheckBoxUmlPart {

	private Button button_uml;
	private FileFieldEditor ffe;
	private Composite uml;
	private boolean notDestroyed = true;

	@Inject
	public CheckBoxUmlPart(Composite parent, final IEclipseContext context) {
		button_uml = new Button(parent, SWT.CHECK);
		button_uml.setText("Use existend UML model");
		uml = new Composite(parent, SWT.NONE);
		uml.setLayout(new GridLayout(3, false));
		ffe = new FileFieldEditor("uml.file", "Model file: ", uml);
		button_uml.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify("checkbutton.uml.selection",
						button_uml.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		ffe.getTextControl(uml).addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				context.modify("umlModel", ffe.getStringValue());
			}
		});
	}

	@Inject
	private void changeState(
			@Optional @Named("checkbutton.uml.selection") boolean selection) {
		if (notDestroyed) {
			if (selection)
				ffe.setEnabled(true, uml);
			else
				ffe.setEnabled(false, uml);
		}
	}

	@PreDestroy
	public void preDestroy() {
		notDestroyed = false;
	}
}
