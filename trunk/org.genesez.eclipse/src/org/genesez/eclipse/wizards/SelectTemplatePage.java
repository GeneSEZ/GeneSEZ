package org.genesez.eclipse.wizards;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.genesez.eclipse.generator.TemplateManager;
import org.genesez.eclipse.generator.TemplateManager.Template;


public class SelectTemplatePage extends WizardPage {
	
	private static final String ENTER_PROJECTNAME = "Enter a project name.";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one of does which get created by the template already exists.";
	private static final String SELECT_TEMPLATE = "Select a template for the project.";
	
	/** icon of the a language node in the tree */
	private Image languageIcon;
	/** icon of a template node in the tree */
	private Image templateIcon;
	
	/** the current name of the project set in the textbox */
	private String projectName;
	/** currently selected template in the tree view */
	private Template selectedTemplate;
	/** text field of the template description */
	private Text textDescription;
	/** text field of the project names preview */
	private Text textPreview;
	
	/** true if project name is valid */
	private boolean isProjectNameValid = false;
	
	/** true if selected template is valid */
	private boolean isTemplateValid = false;
	
	/** provides all current loaded templates */
	private TemplateManager templateManager = TemplateManager.getInstance();

	protected SelectTemplatePage(String pageName) {
		super(pageName);
		this.setTitle("GeneSEZ Project");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(), "/images/GeneSEZ.png"));
		this.setProjectName("");
		// load shared icons for the tree view
		ISharedImages eclipseImages = PlatformUI.getWorkbench().getSharedImages();
		languageIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FOLDER);
		templateIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FILE);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		createNameLine(composite)
			.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		createTemplateGroup(composite)
			.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		createProjectPreview(composite)
			.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));

		setControl(composite);
	}

	/**
	 * Label + Textbox for project name
	 * 
	 * @param parent
	 *            superior composite
	 */
	private Composite createNameLine(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label label = new Label(composite, SWT.LEFT);
		label.setText("Project Name:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, true));

		final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
		text.addModifyListener(new ModifyListener() { public void modifyText(ModifyEvent e) {
				setProjectName(text.getText().trim());
		}});

		return composite;
	}

	/**
	 * Group with template tree and template description
	 * 
	 * @param parent
	 *            superior composite
	 */
	private Composite createTemplateGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Template");
		group.setLayout(new GridLayout(2, false));

		Tree tree = new Tree(group, SWT.BORDER);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) { 
				setTemplate((Template)e.item.getData());
				}
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		String[] languages = templateManager.getLanguages();
		Map<String, List<Template>> templatesByLanguage = templateManager.getTemplatesByLanguage();
		
		for (int l = 0; l < languages.length; l++) {
			TreeItem langItem = new TreeItem(tree, 0);
			langItem.setText(languages[l]);
			langItem.setImage(languageIcon);
			List<Template> tempaltes = templatesByLanguage.get(languages[l]);
			for (int t=0;t<tempaltes.size();t++) {
				Template template = tempaltes.get(t);
				TreeItem templateItem = new TreeItem(langItem, 0);
				templateItem.setText(template.getName());
				templateItem.setImage(templateIcon);
				templateItem.setData(template);
			}
		}
		
		
		// description text field next to the tree
		Text description = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP);
		description.setEditable(false);
		GridData gd = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
		gd.widthHint = 150;
		description.setLayoutData(gd);
		textDescription = description;
		
		return group;
	}
	
	/**
	 * Create text area for the project names that will be generated
	 * @param parent superior composite
	 */
	private Composite createProjectPreview(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Label label = new Label(composite, SWT.LEFT);
		label.setText("The following projects will be created in your workspace by the selected template:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
		
		Text preview = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.WRAP);
		preview.setEditable(false);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.heightHint = 50;
		preview.setLayoutData(gd);
		textPreview = preview;
		return composite;
	}
	
	/**
	 * @param current project name
	 */
	private void setProjectName(String projectName) {
		this.projectName = projectName;
		isProjectNameValid = projectName.length() > 0;
		updateElements();
	}
	/** @param current project name */
	public String getProjectName() {
		return this.projectName;
	}
	/** @param current selected template */
	public Template getTemplate() {
		return this.selectedTemplate;
	}
	
	/**
	 * @param template current template
	 */
	private void setTemplate(Template template) {
		selectedTemplate = template;
		isTemplateValid = template != null;
		if(isTemplateValid) {
			textDescription.setText(template.getDescription());
		}
		else {
			textDescription.setText("");
			// reset project name
			setProjectName(projectName);
		}
		updateElements();
	}
	
	/**
	 * Update internals like message, wizard buttons or conflicts.
	 * Call after changing something in the wizard page.
	 */
	private void updateElements() {
		updateMessage();
		updateProjectNamePreview();
		checkIfComplete();
	}
	
	/**
	 * Updates the message in the wizard page header.
	 */
	private void updateMessage() {
		if(!isProjectNameValid) {
			this.setMessage(ENTER_PROJECTNAME, INFORMATION);
		}
		else if(!isTemplateValid) {
			this.setMessage(SELECT_TEMPLATE, INFORMATION);
		}
		else {
			this.setMessage(null);
		}
	}
	
	/**
	 * Refreshes the names of the projects preview and detect conflicts.
	 */
	private void updateProjectNamePreview() {
		if(textPreview == null) return;
		if(isTemplateValid && isProjectNameValid) {
			String[] projectNames = selectedTemplate.getReplacedProjectNames(projectName);
			String preview = "";
			// concat project names for preview text field
			// and check if one project already exists
			IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
			for(String name : projectNames) {
				if(workspace.exists(new Path(name))) {
					isProjectNameValid = false;
				}
				preview += name + "\n";
			}
			textPreview.setText(preview);
			// check if conflict appeared
			if(!isProjectNameValid) {
				this.setMessage(PROJECTNAME_EXSISTS, ERROR);
			}
		}
		else {
			textPreview.setText("");
		}
	}
	
	/**
	 * Determines if all user set values are correct and allows proceeding
	 * to next page if so.
	 */
	private void checkIfComplete() {
		this.setPageComplete(isProjectNameValid && isTemplateValid);
	}

}
