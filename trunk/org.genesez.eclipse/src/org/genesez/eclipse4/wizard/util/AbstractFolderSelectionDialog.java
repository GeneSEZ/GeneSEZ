package org.genesez.eclipse4.wizard.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.SelectionDialog;

public abstract class AbstractFolderSelectionDialog extends SelectionDialog {
	protected String labelText;
	protected Tree tree;

	public AbstractFolderSelectionDialog(Shell parentShell, String labelText) {
		super(parentShell);
		this.labelText = labelText;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
        // create composite 
        Composite area = (Composite) super.createDialogArea(parent);

		Label lblSelectProject = new Label(area, SWT.NONE);
		lblSelectProject.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false));
		lblSelectProject.setText(labelText);
		
		tree = new Tree(area, SWT.BORDER | SWT.SINGLE);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		addListener();
		fillTree();
		
        return area;
    }
	
	@Override
	protected void setReturnCode(int code) {
		if(code == Window.CANCEL)
			setResult(null);
		super.setReturnCode(code);
	}
	
	protected void addListener(){
		tree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<Object> newResult = new ArrayList<Object>();
				newResult.add(e.item.getData());
				setResult(newResult);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	abstract protected void fillTree();

}
