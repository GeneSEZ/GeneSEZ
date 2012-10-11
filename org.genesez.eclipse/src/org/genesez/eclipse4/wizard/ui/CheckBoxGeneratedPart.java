package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

@SuppressWarnings("restriction")
@Creatable
public class CheckBoxGeneratedPart {

	private Button button_gen;
	private StringButtonFieldEditor editor;
	private Composite gen;
	private boolean notDestroyed = true;

	@Inject
	public CheckBoxGeneratedPart(final Composite parent,
			final IEclipseContext context) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		button_gen = new Button(parent, SWT.CHECK);
		button_gen.setText("Use already existend generator project");
		gen = new Composite(parent, SWT.NONE);
		gen.setLayout(new GridLayout(3, false));
		button_gen.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify("checkbutton.gen.selection",
						button_gen.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		editor = new StringButtonFieldEditor("generated.project",
				"Select project:", gen) {

			SelectionDialog dialog = new ContainerSelectionDialog(
					parent.getShell(), null, false, "Choose Project");

			@Override
			protected String changePressed() {
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if (result == null) {
					return "";
				}
				return result[0].toString();
			}

			@Override
			public void dispose() {
				dialog.closeTray();
			}
		};
		editor.setEmptyStringAllowed(true);
		editor.setChangeButtonText("Browse...");
		editor.fillIntoGrid(gen, 3);
		editor.getTextControl(gen).addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				context.modify("generatorProject", editor.getStringValue());
			}
		});
	}

	@Inject
	public void changeState(
			@Optional @Named("checkbutton.gen.selection") boolean selection) {
		if (notDestroyed) {
			if (selection)
				editor.setEnabled(true, gen);
			else
				editor.setEnabled(false, gen);
		}
	}

	@PreDestroy
	public void preDestroy() {
		notDestroyed = false;
	}
}
