package org.genesez.eclipse4.wizard.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * Part to choose a template in a TabView.
 * 
 * Modifies context element:
 * <p>
 * {@link WizardConstants#TEMPLATE}
 * </p>
 * <p>
 * {@link WizardConstants#DESCRIPTION}
 * </p>
 * 
 * Listens to context element:
 * <p>
 * {@link WizardConstants#IS_EXAMPLE}
 * </p>
 * 
 * @author Dominik Wetzel
 * 
 */
@SuppressWarnings("restriction")
public class TemplateSelectionPart {

	private static final String ERROR_MESSAGE = "Couldn't read the template files";

	private TabFolder tabFolder;
	private SelectionListener treeSelectionListener;
	private Image templateIcon = null;
	private Image errorIcon = null;

	@Inject
	private IEclipseContext context;

	/**
	 * Standard constructor
	 */
	public TemplateSelectionPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param example if true example projects are used {@link WizardConstants#IS_EXAMPLE}.
	 * @param workbench the workbench needed for images.
	 */
	@PostConstruct
	public void createControls(Composite parent,
			@Named(WizardConstants.IS_EXAMPLE) boolean example,
			@Optional IWorkbench workbench) {
		if (workbench != null) {
			ISharedImages eclipseImages = workbench.getSharedImages();
			templateIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FILE);
			errorIcon = eclipseImages
					.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		}
		tabFolder = new TabFolder(parent, SWT.BORDER);

		addListener();

		List<TemplateConfigXml> xml_data = null;
		// makes the tabView for the Template files
		try {
			xml_data = TemplateHelper.readTemplateInformation();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if (xml_data != null) {
			for (TemplateConfigXml data : xml_data) {
				if (data.isExample() == example) {
					TabItem languageTab = getLanguageInTabs(
							tabFolder.getItems(), data.getLanguage());
					if (languageTab == null) {
						languageTab = new TabItem(tabFolder, SWT.NONE);
						languageTab.setText(data.getLanguage());
						Tree tabTree = new Tree(tabFolder, SWT.NONE);
						tabTree.addSelectionListener(treeSelectionListener);
						languageTab.setControl(tabTree);
					}
					TreeItem item = new TreeItem(
							(Tree) languageTab.getControl(), SWT.NONE);
					item.setText(data.getName());
					item.setData(data);
					item.setImage(templateIcon);
				}
			}
		} else {
			TreeItem item = new TreeItem(new Tree(tabFolder, SWT.NONE),
					SWT.NONE);
			item.setText(ERROR_MESSAGE);
			item.setImage(errorIcon);
		}
	}

	/**
	 * Gets the TabItem for the given language.
	 * @param items tabItems to check.
	 * @param language the language to search.
	 * @return the corresponding tabItem or null if none found.
	 */
	private TabItem getLanguageInTabs(TabItem[] items, String language) {
		for (TabItem item : items) {
			if (item.getText().equals(language))
				return item;
		}
		return null;
	}

	/**
	 * Creates and adds the needed listeners.
	 */
	private void addListener() {
		// for selection of an item (with associated template)
		treeSelectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem item = (TreeItem) e.item;
				TemplateConfigXml data = (TemplateConfigXml) item.getData();
				context.modify(WizardConstants.DESCRIPTION,
						data.getDescription());
				context.modify(WizardConstants.TEMPLATE, data);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};

		// Adds the selection listener for the Tabfolder to modify context and
		// deselect selections
		tabFolder.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Tree tree = (Tree) ((TabItem) e.item).getControl();
				tree.deselectAll();
				context.modify(WizardConstants.DESCRIPTION, "");
				context.modify(WizardConstants.TEMPLATE, null);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
}
