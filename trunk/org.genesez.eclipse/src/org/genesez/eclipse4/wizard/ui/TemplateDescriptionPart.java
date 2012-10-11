package org.genesez.eclipse4.wizard.ui;

import java.awt.Font;
import java.awt.Frame;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.CleanResizeListener;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;

@SuppressWarnings("restriction")
@Creatable
public class TemplateDescriptionPart {

	private static final int RELATIVE_SIZE = 60;
	private JLabel label;
	private Composite embedded;
	
	@Inject
	public TemplateDescriptionPart(Composite parent, @Optional MUIElement part){
		if(part != null){
			part.setContainerData(String.valueOf(RELATIVE_SIZE));
		}
		embedded = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND
				| SWT.WRAP);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		embedded.setLayoutData(gData);
		embedded.addControlListener(new CleanResizeListener());
				
		Frame awt_frame = SWT_AWT.new_Frame(embedded);
		JApplet frame = new JApplet();
		awt_frame.add(frame);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		frame.setContentPane(contentPane);
		JLabel headline = new JLabel("Description:");
		headline.setFont(headline.getFont().deriveFont(Font.BOLD));
		contentPane.add(headline);

		label = new JLabel("");
		contentPane.add(label);
	}

	@Inject
	public void setTemplateAndDescription(
			@Optional @Named("template") TemplateConfigXml data) {
		if (!embedded.isDisposed()) {
			if (data == null)
				label.setText("");
			else
				label.setText("<html><p>" + data.getDescription() + "</p></html>");
		}
	}

}