package de.genesez.tools.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.genesez.tools.generator.Project;

public class NewProjectWizard extends Wizard implements INewWizard {
	
	IWorkbench workbench;
	IStructuredSelection selection;
	SelectTemplatePage mainPage;

	public NewProjectWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
	}
	
	@Override
	public void addPages() {
		mainPage = new SelectTemplatePage("NewProjectPage");
		addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
		if(mainPage.isPageComplete()) {
			try {
				Project generator = new Project(mainPage.getProjectName(), mainPage.getTemplate());
				generator.create();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return false;
			}
			
			return true;
		}
		
		return false;
	}

}
