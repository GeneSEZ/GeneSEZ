/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.page;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The basic class for GeneSEZ Wizard pages.
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
@SuppressWarnings("restriction")
public abstract class GeneSEZProjectWizardPage extends WizardPage {

	/** The context which contains important values */
	protected IEclipseContext context;
	
	/** The host window which contains the context */
	private MWindow hostWin;
	
	/** The presentationEngine for Rendering*/
	@Inject
	private IPresentationEngine renderer;

	/**
	 * Creates the page.
	 * 
	 * @param pageName
	 *            the page name.
	 * @param hostWin
	 *            the host window, which contains the context.
	 */
	public GeneSEZProjectWizardPage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();

		setTitle("GeneSEZ Project Wizard");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),
				"/images/GeneSEZ.png"));

		ContextInjectionFactory.inject(this, context);
		initializeContext();
		this.setPageComplete(false);
	}
	
	/**
	 * initializes the context. This should contain all needed context elements
	 * from the Parts.
	 */
	protected abstract void initializeContext();
	
	/**
	 * Creates the model.
	 * @return the top MUIElement, will be mostly a {@link MPerspectiveStack},
	 */
	protected abstract MUIElement createModel();

	/**
	 * Creates the controls for the page.
	 */
	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout());
		setControl(comp);

		// Create the model
		MUIElement hostModel = createModel();
		renderModel(comp, hostModel);		
	}
	
	/**
	 * Modifies {@link IWizardPage} in the context if visible.
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		if(visible){
			context.modify(IWizardPage.class, this);
		}
		super.setVisible(visible);
	}
	
	/**
	 * renders the model
	 * 
	 * @param parent
	 *            the parent composite
	 * @param hostModel
	 *            the hostModel
	 */
	private void renderModel(Composite parent, final MUIElement hostModel) {
		hostWin.getSharedElements().add(hostModel);

		// Render it
		renderer.createGui(hostModel, parent, context);
		// Clean up the shared elements list once we're done
		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				hostWin.getSharedElements().remove(hostModel);
			}
		});
	}

}