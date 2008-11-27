package swing.simple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class SimpleJFrameExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Simple Example");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setSize(500, 400);

		LayoutManager manager = new FlowLayout();
		theFrame.setLayout(manager);

		Icon icon1 = new ImageIcon(SimpleJFrameExample.class
				.getResource("/images/smiley.jpeg"));
		JButton button = new JButton();
		button.setIcon(icon1);
		theFrame.add(button);

		// f.setLocation( 0, 0 );
		// f.setSize( Toolkit.getDefaultToolkit().getScreenSize() );

		// set global font default for JLabel
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("Label.font", ((Font) uiDefaults.get("Label.font"))
				.deriveFont(25f));

		JLabel label1 = new JLabel("Double-click me!", JLabel.RIGHT);
		// label1.setForeground(Color.ORANGE);
		// label1.setFont(new Font("Serif", Font.BOLD, 30));
		theFrame.add(label1);

		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1)
					System.exit(0);
			}
		});

		theFrame.pack();
		theFrame.setVisible(true);
	}
}
