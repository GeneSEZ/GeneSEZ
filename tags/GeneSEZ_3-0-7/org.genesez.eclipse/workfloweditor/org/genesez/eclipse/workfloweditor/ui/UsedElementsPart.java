/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.eclipse.workfloweditor.util.UIController;

/**
 * Part, that contains the used WorkflowComponents from the modell.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class UsedElementsPart {

	private static final String MODULE_LABEL = "Module name:";

	private ScrolledComposite scrolled;
	private Text moduleText;

	private Composite composite;

	@Inject
	private IEclipseContext context;

	@Inject
	private Composite parent;

	@Inject
	private UIController controller;

	/**
	 * Standard constructor
	 */
	public UsedElementsPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		context.set(UsedElementsPart.class, this);
		parent.setLayout(new GridLayout(2, false));
		Label moduleLabel = new Label(parent, SWT.NONE);
		moduleLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		moduleLabel.setText(MODULE_LABEL);
		moduleText = new Text(parent, SWT.BORDER);
		moduleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		String moduleName = controller.getModuleName();
		if (moduleName == null) {
			moduleText.setText("");
		} else {
			moduleText.setText(moduleName);
		}
		moduleText.setMessage(controller.getFileName());

		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		scrolled.setLayout(new FillLayout());
		composite = new Composite(scrolled, SWT.NONE);
		composite.setLayout(new GridLayout());
		scrolled.setContent(composite);
		controller.setHeadComposite(scrolled);
		addListeners();
		controller.readFeatures(controller.getRootComponent(), composite, context);
	}

	/**
	 * adds the listeners
	 */
	private void addListeners() {
		// allows scrolling if workflow is to long
		scrolled.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle r = scrolled.getClientArea();
				scrolled.layout(true, true);
				scrolled.setMinSize(composite.computeSize(r.width, SWT.DEFAULT));
				parent.notifyListeners(SWT.Resize, new Event());
			}
		});

		// modifies the Modulename
		moduleText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				controller.changeModuleName(moduleText.getText());
			}
		});
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}

}
