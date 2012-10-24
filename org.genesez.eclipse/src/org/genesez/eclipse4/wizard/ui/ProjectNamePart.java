package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
@Creatable
public class ProjectNamePart {
	// Declare a field label, required for @Focus
	@Inject
	private IEclipseContext context;
	
	private Text text_disabled;

	@PostConstruct
	public void createControls(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(5, false));

		Label label = new Label(composite, SWT.LEFT);
		label.setText("Project Name:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,4,1));
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String name = text.getText().trim();
				String genName = name.concat(".generator");
				context.modify(WizardConstants.APP_PROJ_NAME, name);
				context.modify(WizardConstants.GEN_PROJ_NAME, genName);
				if(name.equals(""))
					text_disabled.setText("");
				else
					text_disabled.setText(genName);

			}
		});
		Label label_hidden = new Label(composite, SWT.LEFT);
		label_hidden.setText("Generator Project:");
		label_hidden.setEnabled(false);
		text_disabled = new Text(composite, SWT.SINGLE);
		text_disabled.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 4,1));
		text_disabled.setEnabled(false);
	}
	@PreDestroy
	public void dispose() {
	}
}
