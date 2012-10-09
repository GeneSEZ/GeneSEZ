package org.genesez.eclipse4.wizard.ui.part;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("restriction")
@Creatable
public class PreviewProjectsPart {
	// Declare a field label, required for @Focus
	Text preview;

	@Inject
	public PreviewProjectsPart(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Label label = new Label(composite, SWT.LEFT);
		label.setText("The following projects will be created in your workspace by the selected template:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false,
				false));

		preview = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.WRAP);
		preview.setEditable(false);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.heightHint = 50;
		preview.setLayoutData(gd);
	}

	@Inject
	public void refreshPreview(@Optional @Named("projectname") String projName) {
		if (!preview.isDisposed()) {
			if (projName != null && !projName.trim().equals(""))
				preview.setText(projName + "\n" + projName + ".generator");
			else
				preview.setText("");
		}
	}

	@PreDestroy
	public void dispose() {
	}
}
