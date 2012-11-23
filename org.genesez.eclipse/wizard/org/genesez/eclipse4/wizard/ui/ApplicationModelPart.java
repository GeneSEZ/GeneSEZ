/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse4.wizard.ui;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse4.wizard.util.FolderAndZipFolderSelectionDialog;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * Part to choose files for the application model and to decide whether they should be copied or referenced.
 * 
 * Modify context elements:
 * <p>
 * {@link WizardConstants#APPLICATION_MODEL_COLLECTION}
 * </p>
 * <p>
 * {@link WizardConstants#COPY_MODEL_FILES}
 * </p>
 * <p>
 * {@link WizardConstants#APPLICATION_MODEL_ROOT}
 * </p>
 * <p>
 * {@link WizardConstants#APPLICATION_MODEL_DESTINATION}
 * </p>
 * 
 * Listen to context elements:
 * <p>
 * {@link WizardConstants#CHOOSE_WORKFLOW}
 * </p>
 * <p>
 * {@link WizardConstants#APP_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#GEN_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#TEMPLATE}
 * </p>
 * <p>
 * {@link WizardConstants#CHOOSE_WIZARD}
 * </p>
 * <p>
 * {@link IWorkspaceRoot}
 * </p>
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class ApplicationModelPart {

	private static final String BROWSE_FILES = "Choose folder for application model files";
	private static final String BROWSE_PROJECTS = "Choose folder to store files.";

	private Tree tree;
	private Button btnSelectAll;
	private Button btnDeselectAll;
	private Button btnRefresh;
	private Button btnCopyFilesTo;
	private Group grpExistingApplicationModel;
	private Text txtRootDirectorySource;
	private Button btnRootDirectorySource;
	private Text txtRootDirectoryDestination;
	private Button btnRootDirectoryDestination;
	private Listener modifyCheckedListener;

	private Image imgFolder = null;
	private Image imgFile = null;
	private Image imgError = null;

	@Inject
	@Named(WizardConstants.TEMPLATE)
	private TemplateConfigXml template;

	@Inject
	@Named(WizardConstants.APP_PROJ_NAME)
	private String appName;

	@Inject
	@Named(WizardConstants.GEN_PROJ_NAME)
	private String genName;

	@Inject
	@Named(WizardConstants.CHOOSE_WIZARD)
	private Button wizardSelection;

	@Inject
	private IEclipseContext context;

	@Inject
	private IWorkspaceRoot workspace;

	private Set<File> applicationModel = new HashSet<File>();

	/**
	 * Standard constructor
	 */
	public ApplicationModelPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent, @Optional IWorkbench workbench) {
		if (workbench != null) {
			ISharedImages eclipseImages = workbench.getSharedImages();
			imgFile = eclipseImages.getImage(ISharedImages.IMG_OBJ_FILE);
			imgFolder = eclipseImages.getImage(ISharedImages.IMG_OBJ_FOLDER);
			imgError = eclipseImages.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		}

		grpExistingApplicationModel = new Group(parent, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpExistingApplicationModel.setText("Existing Application Model");
		grpExistingApplicationModel.setLayout(GridLayoutFactory.copyLayout(WizardConstants.L_GL_TXTBTN));

		txtRootDirectorySource = new Text(grpExistingApplicationModel, SWT.BORDER);
		txtRootDirectorySource.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		txtRootDirectorySource.setMessage(BROWSE_FILES);
		txtRootDirectorySource.setToolTipText(BROWSE_FILES);

		btnRootDirectorySource = new Button(grpExistingApplicationModel, SWT.NONE);
		btnRootDirectorySource.setText("Browse...");
		btnRootDirectorySource.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);

		tree = new Tree(grpExistingApplicationModel, SWT.BORDER | SWT.CHECK);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 3));

		btnSelectAll = new Button(grpExistingApplicationModel, SWT.NONE);
		btnSelectAll.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnSelectAll.setText("Select All");

		btnDeselectAll = new Button(grpExistingApplicationModel, SWT.NONE);
		btnDeselectAll.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnDeselectAll.setText("Deselect All");

		btnRefresh = new Button(grpExistingApplicationModel, SWT.NONE);
		btnRefresh.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnRefresh.setText("Refresh");

		btnCopyFilesTo = new Button(grpExistingApplicationModel, SWT.CHECK);
		btnCopyFilesTo.setSelection(false);
		context.modify(WizardConstants.COPY_MODEL_FILES, btnCopyFilesTo.getSelection());
		btnCopyFilesTo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		btnCopyFilesTo.setText("Copy files");
		btnCopyFilesTo.setToolTipText("If not checked files will be referenced, else they will be copied");
		btnCopyFilesTo.setSelection(true);

		txtRootDirectoryDestination = new Text(grpExistingApplicationModel, SWT.BORDER);
		txtRootDirectoryDestination.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		txtRootDirectoryDestination.setMessage(BROWSE_PROJECTS);
		txtRootDirectoryDestination.setToolTipText(BROWSE_PROJECTS);

		btnRootDirectoryDestination = new Button(grpExistingApplicationModel, SWT.NONE);
		btnRootDirectoryDestination.setText("Browse...");
		btnRootDirectoryDestination.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnRootDirectoryDestination.setEnabled(false);

		addListener();
		btnCopyFilesTo.notifyListeners(SWT.Selection, new Event());
		context.modify(WizardConstants.APPLICATION_MODEL_COLLECTION, applicationModel);
	}

	/**
	 * Adds the needed Listener
	 */
	private void addListener() {

		// creates a Listener which changes the look of an directory if not all
		// | all | none elements are selected
		modifyCheckedListener = new Listener() {

			@Override
			public void handleEvent(Event e) {
				TreeItem items = (TreeItem) e.item;
				if (((File) items.getData()).isDirectory()) {
					boolean containsNone = false;
					boolean containsAll = false;
					boolean containsGrayed = false;

					for (TreeItem item : items.getItems()) {
						if (item.getChecked())
							containsAll = true;
						else
							containsNone = true;
						if (item.getGrayed())
							containsGrayed = true;
					}
					if (containsNone && containsAll || (containsAll && !containsNone && containsGrayed)) {
						// not all elements selected
						items.setGrayed(true);
						items.setChecked(true);
					} else if (containsAll) {
						// all elements selected
						items.setGrayed(false);
						items.setChecked(true);
					} else {
						// no element selected
						items.setGrayed(false);
						items.setChecked(false);
					}
				}
				TreeItem parentItem = items.getParentItem();
				if (parentItem != null) {
					Event event = new Event();
					event.item = parentItem;
					parentItem.notifyListeners(SWT.Modify, event);
				}
			}
		};

		// Add listener to do refresh button if enter is clicked in the Source
		// Text.
		txtRootDirectorySource.addTraverseListener(new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {
				if (SWT.TRAVERSE_RETURN == e.detail) {
					btnRefresh.notifyListeners(SWT.Selection, new Event());
					e.doit = false;
				}
			}
		});

		// Choose the root source directory
		btnRootDirectorySource.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(btnRootDirectorySource.getShell());
				dialog.setFilterPath(workspace.getLocationURI().getPath());
				String dir = dialog.open();
				if (dir != null)
					txtRootDirectorySource.setText(dir.trim());
				btnRefresh.notifyListeners(SWT.Selection, new Event());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Just for convenience, does select all files
		btnSelectAll.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				for (TreeItem item : tree.getItems()) {
					item.setChecked(true);
					Event event = new Event();
					event.item = item;
					tree.notifyListeners(SWT.Selection, event);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Just for convenience, does deselect all files
		btnDeselectAll.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				for (TreeItem item : tree.getItems()) {
					item.setChecked(false);
					Event event = new Event();
					event.item = item;
					tree.notifyListeners(SWT.Selection, event);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// The refresh button does clear the tree and refills it.
		btnRefresh.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String text = txtRootDirectorySource.getText();
				tree.clearAll(true);
				tree.removeAll();
				if (text == null || text.equals(""))
					return;
				// IPath path = new Path(text);
				// File rootFile = path.toFile();
				File rootFile = new File(text);
				context.modify(WizardConstants.APPLICATION_MODEL_ROOT, rootFile);
				applicationModel.clear();
				if (rootFile.exists() && rootFile.isDirectory()) {
					TreeItem item = new TreeItem(tree, SWT.NONE);
					item.setImage(imgFolder);
					prepareItem(item, rootFile);
					makeTree(rootFile, item);
					item.setExpanded(true);
				} else {
					context.modify(WizardConstants.APPLICATION_MODEL_COLLECTION, null);
					TreeItem item = new TreeItem(tree, SWT.NONE);
					item.setImage(imgError);
					item.setText("An error occured while trying to read directory! Maybe its not existend.");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// sets the value of COPY_MODEL_FILES in the context
		btnCopyFilesTo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.COPY_MODEL_FILES, btnCopyFilesTo.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Choose the root destination directory
		txtRootDirectoryDestination.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.APPLICATION_MODEL_DESTINATION, txtRootDirectoryDestination.getText());
			}
		});

		// Open a FolderSelectionDialog
		btnRootDirectoryDestination.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FolderAndZipFolderSelectionDialog dialog = new FolderAndZipFolderSelectionDialog(btnRootDirectoryDestination
						.getShell(), "Choose a folder:", workspace, template, appName, genName);
				Object data = wizardSelection.getData();
				if (data.equals(WizardConstants.RADIO_1))
					dialog.setFlags(true, true, true);
				else if (data.equals(WizardConstants.RADIO_2))
					dialog.setFlags(true, true, false);
				else
					dialog.setFlags(true, false, true);
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null)
					txtRootDirectoryDestination.setText(((File) result[0]).toString());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Adds a SelectionListener which changes the status of the TreeItems
		// and changes the context
		tree.addSelectionListener(new SelectionListener() {

			private void setEvent(TreeItem item, boolean checked) {
				item.setChecked(checked);
				Event selection = new Event();
				selection.item = item;
				tree.notifyListeners(SWT.Selection, selection);
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem items = (TreeItem) e.item;
				if (items.getData() != null) {
					if (((File) items.getData()).isDirectory()) {
						items.setExpanded(true);
						if (items.getChecked())
							for (TreeItem item : items.getItems())
								setEvent(item, true);
						else
							for (TreeItem item : items.getItems())
								setEvent(item, false);
					} else if (items.getChecked()) {
						applicationModel.add((File) items.getData());
						context.modify(WizardConstants.APPLICATION_MODEL_COLLECTION, applicationModel);
					} else {
						applicationModel.remove(items.getData());
						context.modify(WizardConstants.APPLICATION_MODEL_COLLECTION, applicationModel);
					}
					TreeItem parentItem = items.getParentItem();
					if (parentItem != null) {
						Event event = new Event();
						event.item = parentItem;
						parentItem.notifyListeners(SWT.Modify, event);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	/**
	 * Listens to {@link WizardConstants#TEMPLATE}. If template not null destination button is enabled.
	 * 
	 * @param template
	 *            the template
	 */
	@Inject
	private void enableButton(@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template) {
		if (btnRootDirectoryDestination != null && !btnRootDirectoryDestination.isDisposed()) {
			if (template != null)
				btnRootDirectoryDestination.setEnabled(true);
			else
				btnRootDirectoryDestination.setEnabled(false);
		}
	}

	/**
	 * Sets the default text, listens to {@link WizardConstants#APP_PROJ_NAME}
	 * 
	 * @param name
	 *            the application project name.
	 */
	@Inject
	private void setRootDestination(@Optional @Named(WizardConstants.APP_PROJ_NAME) String name) {
		if (txtRootDirectoryDestination != null && !txtRootDirectoryDestination.isDisposed()) {
			if (name != null)
				txtRootDirectoryDestination.setText(name + File.separator + "model");
		}
	}

	/**
	 * Creates the representation of the file tree for the given directory (recursively)
	 * 
	 * @param directory
	 *            which will be used as the root of this tree part
	 * @param attachTo
	 *            the TreeItem, where the child items will be attached to.
	 */
	private void makeTree(File directory, TreeItem attachTo) {
		File[] files = directory.listFiles();
		for (File file : files) {
			TreeItem item = new TreeItem(attachTo, SWT.NONE);
			prepareItem(item, file);
			if (file.isDirectory()) {
				item.setImage(imgFolder);
				makeTree(file, item);
			} else {
				item.setImage(imgFile);
			}
		}
	}

	/**
	 * Prepares the TreeItem for further usage
	 * 
	 * @param item
	 *            the TreeItem which should be prepared
	 * @param file
	 */
	private void prepareItem(TreeItem item, File file) {
		item.setText(file.getName());
		item.setChecked(false);
		item.setData(file);
		item.addListener(SWT.Modify, modifyCheckedListener);
	}
}
