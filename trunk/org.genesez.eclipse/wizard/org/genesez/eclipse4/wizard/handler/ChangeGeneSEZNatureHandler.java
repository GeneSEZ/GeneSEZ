/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse4.wizard.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * Handler to add/remove the GeneSEZ generator nature to projects
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class ChangeGeneSEZNatureHandler extends AbstractHandler {

	private static final String NATURE = WizardConstants.PLUGIN_ID + "."
			+ WizardConstants.NATURE_ID;
	
	/**
	 * Standard constructor
	 */
	public ChangeGeneSEZNatureHandler(){
	}

	/**
	 * Adds or removes the GeneSEZ generator nature from the chosen projects
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProject[] projects = getProjects();
		if (projects != null) {
			if (event.getParameter("org.genesez.eclipse.addNatureParameter") != null)
				for (IProject project : projects)
					addNature(project);
			else
				for (IProject project : projects)
					removeNature(project);
		}
		return null;
	}

	/**
	 * @return the selected projects
	 */
	private IProject[] getProjects() {
		try {
			IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			ISelection selection = window.getSelectionService().getSelection();

			@SuppressWarnings("rawtypes")
			Iterator it = ((IStructuredSelection) selection).iterator();
			List<Object> objects = new ArrayList<Object>();
			while (it.hasNext())
				objects.add(it.next());

			IProject[] projects = new IProject[objects.size()];
			for (int i = 0; i < projects.length; i++)
				projects[i] = (IProject) Platform.getAdapterManager()
						.getAdapter(objects.get(i), IProject.class);
			return projects;
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Unexpected Error occured.\nProject nature was not changed.",
							"Unexpected Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	/**
	 * adds the GeneSEZ generator nature to the project
	 * 
	 * @param project
	 *            the project
	 */
	public static void addNature(IProject project) {
		try {
			if (!project.hasNature(NATURE)) {
				IProjectDescription description = project.getDescription();
				String[] natures = description.getNatureIds();
				String[] newNatures = new String[natures.length + 1];
				System.arraycopy(natures, 0, newNatures, 0, natures.length);
				newNatures[natures.length] = NATURE;
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * removes the GeneSEZ generator nature from the project
	 * 
	 * @param project
	 *            the project
	 */
	public static void removeNature(IProject project) {
		try {
			if (project.hasNature(NATURE)) {
				IProjectDescription description = project.getDescription();
				String[] natures = description.getNatureIds();
				String[] newNatures = new String[natures.length - 1];
				int j = 0;
				for (int i = 0; i < natures.length; i++) {
					String nature = natures[i];
					if (!nature.equals(NATURE))
						newNatures[j++] = nature;
				}
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
			}
		} catch (CoreException e) {
		}
	}

}
