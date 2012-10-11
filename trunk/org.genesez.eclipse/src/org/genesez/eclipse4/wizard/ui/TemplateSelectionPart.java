package org.genesez.eclipse4.wizard.ui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
@Creatable
public class TemplateSelectionPart {

	private TabFolder tabFolder;
	
	@Inject
	private IEclipseContext context;

	@PostConstruct
	public void createControls(Composite parent, @Named(WizardConstants.IS_EXAMPLE) boolean example, @Optional IWorkbench workbench) throws IOException, URISyntaxException{
		Image templateIcon = null;
		if(workbench != null){
			ISharedImages eclipseImages = workbench.getSharedImages();
			templateIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FILE);
		}
		tabFolder = new TabFolder(parent, SWT.BORDER);
		
		// for selection of an item (with associated template)
		SelectionListener treeSelectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem item = (TreeItem) e.item;
				TemplateConfigXml data = (TemplateConfigXml) item.getData();
				context.modify(WizardConstants.DESCRIPTION, data.getDescription());
				context.modify(WizardConstants.TEMPLATE, data);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		
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
		
		// makes the tabView for the Template files
		List<TemplateConfigXml> xml_data = TemplateHelper.readTemplateInformation();
		for(TemplateConfigXml data : xml_data){
			if(data.isExample() == example){
				TabItem languageTab = getLanguageInTabs(tabFolder.getItems(), data.getLanguage());
				if(languageTab == null){
					languageTab = new TabItem(tabFolder,SWT.NONE);
					languageTab.setText(data.getLanguage());
					Tree tabTree = new Tree(tabFolder,SWT.NONE);
					tabTree.addSelectionListener(treeSelectionListener);
					languageTab.setControl(tabTree);
				}
				TreeItem item = new TreeItem((Tree) languageTab.getControl(),SWT.NONE);
				item.setText(data.getName());
				item.setData(data);
				item.setImage(templateIcon);
			}
		}
	}
	
	private TabItem getLanguageInTabs(TabItem[] items, String language){
		for(TabItem item : items){
			if(item.getText().equals(language))
				return item;
		}
		return null;
	}
}
