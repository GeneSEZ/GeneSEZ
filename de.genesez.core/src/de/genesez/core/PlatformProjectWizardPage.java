package de.genesez.core;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PlatformProjectWizardPage extends WizardPage {

	private Text projectText;

	public PlatformProjectWizardPage(ISelection selection) {
		super("wizardPage");
		this.setTitle("GeneSEZ Platform");
		this.setDescription("Generates a new Platform Project for the GeneSEZ Framework");
	}
	
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");

		this.projectText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		this.projectText.setLayoutData(gd);
		this.projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		this.initialize();
		this.dialogChanged();
		this.setControl(container);
	}

	public String getProjectName() {
		return this.projectText.getText();
	}
	
	private void dialogChanged() {

		if ( 0 == this.projectText.getText().length() ) {
			this.setErrorMessage("Project name must be specified");
			return;
		}
		setErrorMessage(null);
		setPageComplete(true);
	}

	private void initialize() {
		this.projectText.setText("de.genesez.platforms.newplatform");
	}

}
