package org.genesez.eclipse4.wizard.handler;

import javax.inject.Named;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.e4.core.di.annotations.Execute;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;

@SuppressWarnings("restriction")
public class CreateProjectHandler {
	
	@Execute
	public boolean createProject(
			@Named("template") TemplateConfigXml template,
			@Named("projectname") String projectName,
			@Named("workspace") IWorkspaceRoot workspace) {
		if (template == null || projectName == null || workspace == null) {
			return false;
		}
		return TemplateHelper.createProject(template, projectName, workspace);
	}
}
