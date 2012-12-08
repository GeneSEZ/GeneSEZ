package org.genesez.eclipse.workfloweditor.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public class UsedElementsPart {

	private static final String MODULE_LABEL = "Module name:";

	private ScrolledComposite scrolled;

	@Inject
	private IEclipseContext context;

	@Inject
	private Composite parent;

	@Inject
	private UIController controller;

	private Composite composite;

	private String moduleName;

	public UsedElementsPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		Label moduleLabel = new Label(parent, SWT.NONE);
		moduleLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		moduleLabel.setText(MODULE_LABEL);
		Text moduleText = new Text(parent, SWT.BORDER);
		moduleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		moduleName = controller.getModule().getCanonicalName();
		if (moduleName == null) {
			moduleText.setText("");
		} else {
			moduleText.setText(moduleName);
		}

		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		scrolled.setLayout(new FillLayout());
		BoxingComponent box = new BoxingComponent();
		IEclipseContext context = this.context.createChild();
		context.set(WorkfloweditorConstants.HEAD_COMPOSITE, scrolled);
		context.set(Composite.class, scrolled);
		ContextInjectionFactory.inject(box, context.createChild());
		composite = box.getComposite();
		scrolled.setContent(composite);
		addListeners();
	}

	private void addListeners() {
		scrolled.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle r = scrolled.getClientArea();
				scrolled.layout(true, true);
				scrolled.setMinSize(composite.computeSize(r.width, SWT.DEFAULT));
				parent.notifyListeners(SWT.Resize, new Event());
			}
		});
	}

	public Composite getComposite() {
		return scrolled;
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}

}
