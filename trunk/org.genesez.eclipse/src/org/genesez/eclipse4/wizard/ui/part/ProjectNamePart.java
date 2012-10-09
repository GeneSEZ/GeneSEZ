package org.genesez.eclipse4.wizard.ui.part;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("restriction")
@Creatable
public class ProjectNamePart {
	// Declare a field label, required for @Focus
	@Inject
	private IEclipseContext context;
	
	@PostConstruct
	public void createControls(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label label = new Label(composite, SWT.LEFT);
		label.setText("Project Name:");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, true));

		final Text text = new Text(composite, SWT.SINGLE | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
		text.addModifyListener(new ModifyListener() { public void modifyText(ModifyEvent e) {
				context.modify("projectname", text.getText().trim());
		}});
		text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.character == SWT.SPACE)
					e.doit = false;
			}
		});
	}
	
	@PreDestroy
	public void dispose(){
	}
}
