package org.genesez.eclipse.workfloweditor.ui;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.genesez.eclipse.workfloweditor.util.ExtensionPointReader;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

@SuppressWarnings("restriction")
public class AvailableElementsPart {

	private static final String AVAILABLE_WF_COMPONENTS = "Available Workflow Components";

	private Map<IExtension, List<WorkflowComponent>> extensionComponents = ExtensionPointReader.getAvailableWorkflowComponents();

	private ScrolledComposite scrolled;
	private Composite composite;
	private Group grpAvailableWorkflowcomponents;
	private Button currentSelection;
	private IExpansionListener expansionListener;
	private SelectionListener btnSelectionListener;

	@Inject
	private IEclipseContext context;

	public AvailableElementsPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout());
		parent.setBackgroundMode(SWT.INHERIT_FORCE);
		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		scrolled.setLayoutData(new GridData(SWT.FILL,SWT.FILL, true,true));
		composite = new Composite(scrolled, SWT.NONE);
		scrolled.setContent(composite);
		composite.setLayout(new GridLayout());
		scrolled.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		grpAvailableWorkflowcomponents = new Group(composite, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpAvailableWorkflowcomponents.setText(AVAILABLE_WF_COMPONENTS);
		grpAvailableWorkflowcomponents.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		grpAvailableWorkflowcomponents.setLayout(new GridLayout());
		grpAvailableWorkflowcomponents.setBackgroundMode(SWT.INHERIT_FORCE);

		addListener();

		for (IExtension extension : extensionComponents.keySet()) {
			ExpandableComposite expandableComposite = new ExpandableComposite(grpAvailableWorkflowcomponents,
					ExpandableComposite.NO_TITLE_FOCUS_BOX);
			expandableComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			expandableComposite.setLayout(new GridLayout());
			expandableComposite.setText(extension.getContributor().getName());

			Composite composite = new Composite(expandableComposite, SWT.NONE);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			composite.setLayout(new GridLayout());

			for (WorkflowComponent component : extensionComponents.get(extension)) {
				Button btn = new Button(composite, SWT.TOGGLE);
				btn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				btn.setData(component);
				btn.setText(component.getComponentName());
				btn.addSelectionListener(btnSelectionListener);
			}
			expandableComposite.setClient(composite);
			expandableComposite.setData(WorkfloweditorConstants.COMPOSITE_HEIGHT,
					composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			expandableComposite.setExpanded(true);
			expandableComposite.addExpansionListener(expansionListener);
		}
	}
	
	private void addListener(){
		scrolled.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				Rectangle r = scrolled.getClientArea();
				scrolled.setMinSize(grpAvailableWorkflowcomponents.computeSize(r.width, SWT.DEFAULT));
			}
		});
		
		// Listener to change group size on expansion state change.
		expansionListener = new IExpansionListener() {

			@Override
			public void expansionStateChanging(ExpansionEvent e) {
				ExpandableComposite ec = (ExpandableComposite) e.getSource();
				if (ec.isExpanded())
					grpAvailableWorkflowcomponents.setSize(
							grpAvailableWorkflowcomponents.getSize().x,
							grpAvailableWorkflowcomponents.getSize().y
									- (Integer) ec.getData(WorkfloweditorConstants.COMPOSITE_HEIGHT));
				else
					grpAvailableWorkflowcomponents.setSize(
							grpAvailableWorkflowcomponents.getSize().x,
							grpAvailableWorkflowcomponents.getSize().y
									+ (Integer) ec.getData(WorkfloweditorConstants.COMPOSITE_HEIGHT));
			}

			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				grpAvailableWorkflowcomponents.layout();
				scrolled.notifyListeners(SWT.Resize, new Event());
			}
		};
		
		// Checks whether a btn already selected and set SELECTED_WORKFLOWCOMPONENT in context.
		btnSelectionListener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.widget;
				if (btn.getSelection()) {
					if (context.get(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT) == null) {
						context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, e.widget.getData());
						currentSelection = btn;
					} else {
						btn.setSelection(false);
					}
				} else {
					context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, null);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
	}

	@Inject
	private void listenToSelectedWorkflowComponent(@Optional @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT) Object obj) {
		if (currentSelection != null && !currentSelection.isDisposed()) {
			if (obj != null) {
				currentSelection.setSelection(true);
			} else {
				currentSelection.setSelection(false);
				currentSelection = null;
			}
		}
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}
}
