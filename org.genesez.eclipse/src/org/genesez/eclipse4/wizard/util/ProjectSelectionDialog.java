package org.genesez.eclipse4.wizard.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class ProjectSelectionDialog extends AbstractFolderSelectionDialog {

	private static final String GENESEZ_NATURE_PROJECTS = "Show only projects with GeneSEZ generator nature.";
	
	private IWorkspaceRoot workspace;
	private boolean checkNature;
	private Button btnAllProjects;
	
	public ProjectSelectionDialog(Shell parentShell,String label, IWorkspaceRoot workspace, boolean checkNature) {
		super(parentShell, label);
		this.workspace = workspace;
		this.checkNature = checkNature;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);

		if(checkNature){
			btnAllProjects = new Button(area, SWT.CHECK | SWT.WRAP);
			btnAllProjects.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			btnAllProjects.setText(GENESEZ_NATURE_PROJECTS);
			btnAllProjects.setSelection(true);
			btnAllProjects.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(btnAllProjects.getSelection()){
						checkNature = true;
					}else{
						checkNature = false;
					}
					fillTree();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
		}
		return area;
	}

	@Override
	protected void fillTree() {
		tree.clearAll(true);
		tree.removeAll();
		Image projectImage = PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
		IProject[] allProjects = workspace.getProjects();
		for(IProject project : allProjects){
			if(checkNature){
				try {
					if(!project.hasNature(WizardConstants.PLUGIN_ID + "." + WizardConstants.NATURE_ID))
						continue;
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(project.getName());
			item.setImage(projectImage);
			item.setData(project);
		}
	}
}
