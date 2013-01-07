package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.PlainString;
import org.eclipse.emf.mwe2.language.mwe2.PropertyReference;
import org.eclipse.emf.mwe2.language.mwe2.Reference;
import org.eclipse.emf.mwe2.language.mwe2.StringLiteral;
import org.eclipse.emf.mwe2.language.mwe2.StringPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.common.types.JvmFeature;

public class StringValueRenderer extends FeatureRenderer {

	private Text fieldValue;

	public StringValueRenderer(JvmFeature feature, Component component) {
		super(feature, component);
	}

	@Override
	protected void renderElement(Composite parent) {
		parent.setLayout(new GridLayout(3, false));
		Label fieldLabel = new Label(parent, SWT.NONE);
		fieldLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		fieldLabel.setText(feature.getSimpleName().substring(3) + ":");
		fieldValue = new Text(parent, SWT.BORDER);
		fieldValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		createDecoratedElement(parent);
		addListener();
	}

	private void addListener() {
		fieldValue.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (value == null || !fieldValue.getText().equals(getStringValue((StringLiteral) value))) {
					setValue(controller.setStringLiteral(assignment, fieldValue.getText()));
				}
			}
		});
	}

	private String getStringValue(StringLiteral value) {
		StringBuffer b = new StringBuffer();
		for (StringPart part : value.getParts()) {
			if (part instanceof PlainString) {
				b.append(((PlainString) part).getValue());
			} else if (part instanceof PropertyReference) {
				// TODO: Referenzen in Strings bearbeiten
				b.append(((PropertyReference) part).getReferable().getName());
			}
		}
		return b.toString().trim();
	}

	@Override
	public boolean checkDefaultValue() {
		if (value instanceof StringLiteral) {
			return getStringValue((StringLiteral) value).equals(fieldValue.getText().trim());
		} else {
			return false;
		}
	}

	@Override
	protected void changeValue() {
		if (value != null && value instanceof StringLiteral) {
			fieldValue.setText(getStringValue((StringLiteral) value));
		} else if (value instanceof Reference) {
		} else {
			fieldValue.setText((String) defaultValue);
		}
	}
}
