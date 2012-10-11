package org.genesez.eclipse4.wizard.ui;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class RadioButtonUmlPart {

	private Button radio_referenz;
	private Button radio_copy;

	@Inject
	public RadioButtonUmlPart(Composite parent, final IEclipseContext context) {
		Composite composite = new Composite(parent, SWT.NONE);
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.marginLeft = 20;
		composite.setLayout(layout);

		radio_referenz = new Button(composite, SWT.RADIO);
		radio_referenz.setText("Reference");
		radio_copy = new Button(composite, SWT.RADIO);
		radio_copy.setText("Copy");
		radio_copy.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(radio_copy.getSelection()){
					context.getParent().modify("radiobutton.uml.text",radio_copy.getText());
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		radio_referenz.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(radio_referenz.getSelection()){
					context.getParent().modify("radiobutton.uml.text",radio_referenz.getText());
					context.getParent().declareModifiable("radiobutton.uml.text");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	@Inject
	public void changeState(
			@Optional @Named("checkbutton.uml.selection") boolean selection) {
		if (selection) {
			radio_referenz.setEnabled(true);
			radio_copy.setEnabled(true);
			return;
		} else {
			if (!radio_referenz.isDisposed() && !radio_copy.isDisposed()) {
				radio_referenz.setEnabled(false);
				radio_copy.setEnabled(false);
			}
		}
	}
}
