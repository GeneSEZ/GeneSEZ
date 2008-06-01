package de.genesez.core;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class GeneratorProjectWizardPage extends WizardPage {

	public GeneratorProjectWizardPage(ISelection selection) {
		super("wizardPage");
		this.setTitle("GeneSEZ Generator Project");
		this.setDescription("Generates a new Generator Project based on GeneSEZ Framework");
	}
	
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

}
