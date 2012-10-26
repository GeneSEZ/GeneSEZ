package org.genesez.eclipse4.wizard.ui;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
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
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * Part to choose files for the application model and to decide whether they
 * should be copied or referenced.
 * 
 * Modify context elements:
 * <p>
 * {@link WizardConstants#APPLICATION_MODEL_LIST}
 * </p>
 * <p>
 * {@link WizardConstants#COPY_MODEL_FILES}
 * </p>
 * <p>
 * ({@link WizardConstants#APPLICATION_MODEL_ROOT})
 * </p>
 * 
 * @author Dominik Wetzel
 * 
 */
@SuppressWarnings("restriction")
public class ApplicationModelPart {

	private static final String BROWSE_FILES = "Choose folder for application model files";

	private Tree tree;
	private Button btnSelectAll;
	private Button btnDeselectAll;
	private Button btnRefresh;
	private Button btnCopyFilesTo;
	private Group grpExistingApplicationModel;
	private Text txtRootDirectory;
	private Button btnRootDirectory;
	private Listener modifyCheckedListener;

	private Image imgFolder = null;
	private Image imgFile = null;
	private Image imgError = null;

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

		grpExistingApplicationModel = new Group(parent, SWT.BORDER
				| SWT.SHADOW_ETCHED_IN);
		grpExistingApplicationModel.setText("Existing Application Model");
		grpExistingApplicationModel.setLayout(GridLayoutFactory
				.copyLayout(WizardConstants.L_GL_TXTBTN));

		txtRootDirectory = new Text(grpExistingApplicationModel, SWT.BORDER);
		txtRootDirectory.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		txtRootDirectory.setMessage(BROWSE_FILES);
		txtRootDirectory.setToolTipText(BROWSE_FILES);

		btnRootDirectory = new Button(grpExistingApplicationModel, SWT.NONE);
		btnRootDirectory.setText("Browse...");
		btnRootDirectory.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);

		tree = new Tree(grpExistingApplicationModel, SWT.BORDER | SWT.CHECK);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 3));

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
		context.modify(WizardConstants.COPY_MODEL_FILES,
				btnCopyFilesTo.getSelection());
		btnCopyFilesTo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 5, 1));
		btnCopyFilesTo.setText("Copy files to application project");
		btnCopyFilesTo.setSelection(true);
		addListener();
		btnCopyFilesTo.notifyListeners(SWT.Selection, new Event());

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
					if (containsNone && containsAll
							|| (containsAll && !containsNone && containsGrayed)) {
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

		txtRootDirectory.addTraverseListener(new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {
				if (SWT.TRAVERSE_RETURN == e.detail) {
					btnRefresh.notifyListeners(SWT.Selection, new Event());
					e.doit = false;
				}
			}
		});

		// Choose the root directory
		btnRootDirectory.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(btnRootDirectory
						.getShell());
				dialog.setFilterPath(workspace.getLocationURI().getPath());
				String dir = dialog.open();
				if (dir != null)
					txtRootDirectory.setText(dir.trim());
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
				String text = txtRootDirectory.getText();
				tree.clearAll(true);
				tree.removeAll();
				if (text == null || text.equals(""))
					return;
				IPath path = new Path(text);
				File rootFile = path.toFile();
				context.modify(WizardConstants.APPLICATION_MODEL_ROOT, path);
				applicationModel.clear();
				if (rootFile.exists() && rootFile.isDirectory()) {
					TreeItem item = new TreeItem(tree, SWT.NONE);
					item.setImage(imgFolder);
					prepareItem(item, rootFile);
					makeTree(rootFile, item);
					item.setExpanded(true);
				} else {
					context.modify(WizardConstants.APPLICATION_MODEL_LIST, null);
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
				context.modify(WizardConstants.COPY_MODEL_FILES,
						btnCopyFilesTo.getSelection());
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
						context.modify(WizardConstants.APPLICATION_MODEL_LIST,
								applicationModel);
					} else {
						applicationModel.remove(items.getData());
						context.modify(WizardConstants.APPLICATION_MODEL_LIST,
								applicationModel);
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
	 * Creates the representation of the file tree for the given directory
	 * (recursively)
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
