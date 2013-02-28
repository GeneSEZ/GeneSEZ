package de.genesez.core.wizard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.openarchitectureware.wizards.EclipseHelper;


public class PlatformProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	private PlatformProjectWizardPage page;

	private ISelection selection;

	private IConfigurationElement configElement;

	public PlatformProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		this.page = new PlatformProjectWizardPage(this.selection);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String name = this.page.getProjectName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					PlatformProjectWizard.this.doFinish(name, monitor);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		BasicNewProjectResourceWizard.updatePerspective(configElement);
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.configElement = config;
	}
	
	private void doFinish(String name, IProgressMonitor monitor) {
		monitor.beginTask("Creating GeneSEZ Platform Project " + name, 2);

		Set<String> reqbundles = new HashSet<String>();
		reqbundles.add("de.genesez.platforms.common;visibility:=reexport");

		List<String> srcfolders = new ArrayList<String>();
		srcfolders.add("src");
		
		List<IProject> projects = new ArrayList<IProject>();
		
		IProject p = EclipseHelper.createOAWProject(name, srcfolders, projects, reqbundles, null, monitor, getShell());
		
		if (p == null) {
			return;
		}
		
		EclipseHelper.createFile("build/build.xml", p, this.getContents("build/build.xml"), monitor);
		EclipseHelper.createFile("build/build.properties", p, this.getContents("build/build.properties"), monitor);
		
		monitor.worked(1);
	}
	
	private String getContents(String resource) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int read;

		try {
			InputStream inputStream = this.getClass()
				.getClassLoader()
				.getResourceAsStream( "skeleton/platform/" + resource );

			while (true) {
				read = inputStream.read(buffer);

				if (-1 == read) {
					break;
				}

				outputStream.write(buffer, 0, read);
			}

			outputStream.close();
			inputStream.close();
			return outputStream.toString("iso-8859-1");
		} catch (IOException e) {
			return "";
		}
	}

}
