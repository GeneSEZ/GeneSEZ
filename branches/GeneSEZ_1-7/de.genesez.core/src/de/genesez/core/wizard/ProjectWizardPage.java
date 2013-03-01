package de.genesez.core.wizard;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.genesez.core.IPlatformWizard;
import de.genesez.core.PlatformWizardRegistry;

public class ProjectWizardPage extends WizardPage {

	// Contains the name of the project to create
	private Text projectText;

	private IPlatformWizard wizard = null;
	
	public ProjectWizardPage(ISelection selection) {
		super("wizardPage");
		this.setTitle("GeneSEZ Generator Project");
		this.setDescription("Creates a new generator project based on GeneSEZ Framework");
	}
	
	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;

		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(layout);

		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);

		this.projectText = new Text(container, SWT.BORDER | SWT.SINGLE);
		this.projectText.setText("de.genesez.myproject");
		this.projectText.setLayoutData(gd);
		this.projectText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				ProjectWizardPage.this.dialogChanged();
			}
		});

		// draw a separating line over the list of platforms 
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.LINE_SOLID );
		separator.setLayoutData( new GridData(GridData.FILL,GridData.FILL, true, false, 2, 1) );

		Label platform = new Label(container, SWT.NULL);
		platform.setLayoutData( new GridData(GridData.FILL,GridData.FILL, true, false, 2, 1) );
		platform.setText("Platform depencendies:");

		// the list of supported platforms
		for (final IPlatformWizard w : PlatformWizardRegistry.INSTANCE.getAll()) {
			final Button wbutton = new Button(container, SWT.RADIO);
			wbutton.setLayoutData( new GridData(GridData.FILL,GridData.FILL, true, false, 2, 1) );
			wbutton.setText( w.getName() );
			wbutton.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					// nothing to do here yet
				}
				public void widgetSelected(SelectionEvent e) {
					if ( wbutton.getSelection() ) {
						ProjectWizardPage.this.wizard = w;
						ProjectWizardPage.this.dialogChanged();
					}
				}
			});
		}
		
		this.setControl(container);
	}

	public String getProjectName() {
		return this.projectText.getText();
	}
	
	public IPlatformWizard getPlatformWizard() {
		return this.wizard;
	}
	
	private void dialogChanged() {

		if ( 0 == this.projectText.getText().length() ) {
			this.setErrorMessage("Project name must be specified");
			return;
		}
		if ( null == this.wizard ) {
			this.setErrorMessage("Platform must be selected");
			return;
		}
		setErrorMessage(null);
		setPageComplete(true);
	}
}
