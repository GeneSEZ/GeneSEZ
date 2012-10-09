package org.genesez.eclipse4.wizard.ui.part;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;

@SuppressWarnings("restriction")
@Creatable
public class TemplateSelectionPart {
	// Declare a field label, required for @Focus
	private static final int RELATIVE_SIZE = 40;

	private Tree tree;
	
	@Inject
	private IEclipseContext context;

	@PostConstruct
	public void createControls(Composite parent, MUIElement part, @Optional IWorkbench workbench) throws IOException, URISyntaxException{
		part.setContainerData(String.valueOf(RELATIVE_SIZE));
		Image languageIcon = null;
		Image templateIcon = null;
		Image exampleIcon = null;
		if(workbench != null){
			ISharedImages eclipseImages = workbench.getSharedImages();
			languageIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FOLDER);
			templateIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_FILE);
			exampleIcon = eclipseImages.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
		parent.setLayout(new GridLayout());
		
		tree = new Tree(parent, SWT.DOWN | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2);
		tree.setLayoutData(gData);
		
		List<TemplateConfigXml> xml_data = TemplateHelper.readTemplateInformation();
		for(TemplateConfigXml data : xml_data){
			if(!data.isExample()){
				TreeItem languageItem = getLanguageInTree(tree.getItems(), data.getLanguage());
				if(languageItem == null){
					languageItem = new TreeItem(tree,SWT.NONE);
					languageItem.setText(data.getLanguage());
					languageItem.setImage(languageIcon);
				}
				TreeItem item = new TreeItem(languageItem,SWT.NONE);
				item.setText(data.getName());
				item.setData(data);
				item.setImage(templateIcon);
			}
		}
		TreeItem examples = new TreeItem(tree,SWT.NONE);
		examples.setText("Examples");
		examples.setImage(languageIcon);
		for(TemplateConfigXml data : xml_data){
			if(data.isExample()){
				TreeItem languageItem = getLanguageInTree(examples.getItems(), data.getLanguage());
				if(languageItem == null){
					languageItem = new TreeItem(examples,SWT.NONE);
					languageItem.setText(data.getLanguage());
					languageItem.setImage(languageIcon);
				}
				TreeItem item = new TreeItem(languageItem,SWT.NONE);
				item.setText(data.getName());
				item.setData(data);
				item.setImage(exampleIcon);
			}
		}
		tree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem item = (TreeItem) e.item;
				TemplateConfigXml data = (TemplateConfigXml) item.getData();
				if(data == null)
					context.modify("template", null);
				else
					context.modify("template", data);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	private TreeItem getLanguageInTree(TreeItem[] items, String language){
		for(TreeItem item : items){
			if(item.getText().equals(language))
				return item;
		}
		return null;
	}
}
