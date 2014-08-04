/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util;

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

/**
 * A Selection dialog thats used to select an item in a tree.
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 */
public abstract class AbstractFolderSelectionDialog extends SelectionDialog {
	
	/** the text set atop the tree */
	protected String labelText;
	/** the tree to select from*/
	protected Tree tree;

	/**
	 * Creates the selection dialog
	 * @param parentShell the parent shell
	 * @param labelText the label atop the tree
	 * @see SelectionDialog
	 */
	public AbstractFolderSelectionDialog(Shell parentShell, String labelText) {
		super(parentShell);
		this.labelText = labelText;
	}
	
	/**
	 * Adds a Label and the tree to the dialog field.
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
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
	
	/**
	 * Sets the result to null if the return code is Window.CANCEL 
	 * @see org.eclipse.jface.window.Window#setReturnCode(int)
	 */
	@Override
	protected void setReturnCode(int code) {
		if(code == Window.CANCEL)
			setResult(null);
		super.setReturnCode(code);
	}
	
	/**
	 * adds the selection listener for the tree,
	 * can be overwritten to set other listener
	 */
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
	
	/**
	 * Fills the tree with the implementation specific content
	 */
	abstract protected void fillTree();

}
