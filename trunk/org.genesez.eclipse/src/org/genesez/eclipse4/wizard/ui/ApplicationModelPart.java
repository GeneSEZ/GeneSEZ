package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

public class ApplicationModelPart {

	public ApplicationModelPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		
		Group grpExistingApplicationModel = new Group(parent, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpExistingApplicationModel.setText("Existing Application Model");
		grpExistingApplicationModel.setLayout(new GridLayout(3, false));
		
		DirectoryFieldEditor editor = new DirectoryFieldEditor("RootDirectory", "", grpExistingApplicationModel);
		editor.fillIntoGrid(grpExistingApplicationModel, 3);
		editor.getTextControl(grpExistingApplicationModel).setMessage("Select root directory");
		
		Composite scrolledComposite = new Composite(grpExistingApplicationModel, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledComposite.setLayout(new RowLayout(SWT.VERTICAL));
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 3));
		scrolledComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		
		Button btnMdzip = new Button(scrolledComposite, SWT.CHECK);
		btnMdzip.setText("MDZip");
		
		Button btnMdip = new Button(scrolledComposite, SWT.CHECK);
		btnMdip.setText("MDZip");
		
		Button btnSelectAll = new Button(grpExistingApplicationModel, SWT.NONE);
		btnSelectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSelectAll.setText("Select All");
		
		Button btnDeselectAll = new Button(grpExistingApplicationModel, SWT.NONE);
		btnDeselectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnDeselectAll.setText("Deselect All");
		
		Button btnRefresh = new Button(grpExistingApplicationModel, SWT.NONE);
		btnRefresh.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnRefresh.setText("Refresh");
		
		Button btnCopyFilesTo = new Button(grpExistingApplicationModel, SWT.CHECK);
		btnCopyFilesTo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		btnCopyFilesTo.setText("Copy files to application project");
	}

	@PreDestroy
	public void dispose() {
	}
}
