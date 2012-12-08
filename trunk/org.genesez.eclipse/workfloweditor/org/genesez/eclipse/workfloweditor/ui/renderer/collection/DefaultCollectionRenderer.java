package org.genesez.eclipse.workfloweditor.ui.renderer.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

public class DefaultCollectionRenderer extends AbstractCollectionRenderer {

	private static Map<Button, Group> groups = new HashMap<Button, Group>();

	private Group group;
	private Label filler;
	private Button btnAdd;
	private SelectionListener remSelectionListener;

	public DefaultCollectionRenderer() {
	}

	@Override
	protected boolean renderList(Field field, Parameter param, WorkflowComponent instance) {
		group = new Group(parent, SWT.BORDER);
		if (parent.getLayout() instanceof GridLayout) {
			group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, ((GridLayout) parent.getLayout()).numColumns, 1));
		}
		group.setText(field.getName());
		group.setLayout(new GridLayout(2, false));

		filler = new Label(group, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		btnAdd = new Button(group, SWT.NONE);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		if (addImage != null) {
			btnAdd.setImage(addImage);
		} else {
			btnAdd.setText(" + ");
		}
		groups.put(btnAdd, group);
		addListener();
		return true;
	}

	private void addListener() {
		remSelectionListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.widget;
				Text text = (Text) btn.getData();
				btn.dispose();
				text.dispose();
				headComposite.notifyListeners(SWT.Resize, new Event());
			}
		};

		btnAdd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Group group = groups.get(e.widget);
				Text text = new Text(group, SWT.BORDER);
				text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

				Button button = new Button(group, SWT.NONE);
				button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
				button.setData(text);
				if (remImage != null) {
					button.setImage(remImage);
				} else {
					button.setText(" - ");
				}
				button.addSelectionListener(remSelectionListener);
				headComposite.notifyListeners(SWT.Resize, new Event());
			}
		});
	}

}
