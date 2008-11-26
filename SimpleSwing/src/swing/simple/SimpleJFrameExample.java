package swing.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

public class SimpleJFrameExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Simple Minds");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setSize(500, 400);
		theFrame.setVisible(true);

		// f.setLocation( 0, 0 );
		// f.setSize( Toolkit.getDefaultToolkit().getScreenSize() );

		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("Label.font", ((Font) uiDefaults.get("Label.font"))
				.deriveFont(25f));

		JLabel label1 = new JLabel("Double-click me!");
		label1.setForeground(Color.ORANGE);
		theFrame.add(label1);

		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1)
					System.exit(0);
			}
		});

	}
}
