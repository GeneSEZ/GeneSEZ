package org.genesez.eclipse4.wizard.handler;

import javax.inject.Named;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.e4.core.di.annotations.Execute;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class CreateProjectHandler {
	
	@Execute
	public boolean createProject(
			@Named(WizardConstants.TEMPLATE) TemplateConfigXml template,
			@Named(WizardConstants.APP_PROJ_NAME) String projectName,
			IWorkspaceRoot workspace) {
		if (template == null || projectName == null || workspace == null) {
			return false;
		}
		return TemplateHelper.createProject(template, projectName, workspace);
	}
}
