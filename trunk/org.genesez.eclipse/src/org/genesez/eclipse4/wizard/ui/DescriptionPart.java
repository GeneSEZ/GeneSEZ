package org.genesez.eclipse4.wizard.ui;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
@Creatable
public class DescriptionPart {

	public DescriptionPart() {
	}

	private Map<IWizardPage,String> currentDescriptions = new HashMap<IWizardPage, String>();
	private IWizardPage currentPage;
	private Text styledText;
	
	@Inject
	private IEclipseContext context;
	
	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new FormLayout());
		parent.setBackgroundMode(SWT.INHERIT_FORCE);
		
		Label lblDescription = new Label(parent, SWT.NONE);
		lblDescription.setFont(SWTResourceManager.getFont("Sans", 10, SWT.BOLD));
		FormData fd_lblDescription = new FormData();
		fd_lblDescription.right = new FormAttachment(100, -3);
		fd_lblDescription.top = new FormAttachment(0, 3);
		fd_lblDescription.left = new FormAttachment(0, 3);
		lblDescription.setLayoutData(fd_lblDescription);
		lblDescription.setText("Description:");
		
		styledText = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
		FormData fd_styledText = new FormData();
		fd_styledText.bottom = new FormAttachment(100, -3);
		fd_styledText.top = new FormAttachment(0, 23);
		fd_styledText.left = new FormAttachment(0,3);
		fd_styledText.right = new FormAttachment(100, -3);
		styledText.setLayoutData(fd_styledText);
		styledText.setDoubleClickEnabled(false);
		styledText.setEnabled(false);
	}
	
	@Inject
	private void setDescription(@Optional @Named(WizardConstants.DESCRIPTION) String description){
		if(description != null && styledText != null && !styledText.isDisposed()){
			styledText.setText(description);
		}
	}
	
	@Inject
	private void pageChanged(@Optional IWizardPage page){
		if(page != null){
			if(styledText != null && !styledText.isDisposed()){
				if(currentPage != null)
					currentDescriptions.put(currentPage, styledText.getText());
				if(currentDescriptions.containsKey(page))
					styledText.setText(currentDescriptions.get(page));
				else
					styledText.setText("");
				currentPage = page;
			}
		}
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
