package swing.simple;

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

		theFrame.setLayout(new FlowLayout());

//		theFrame.setLocation(0, 0);
//		theFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		// set global font default for JLabel
		UIDefaults uiDefaults = UIManager.getDefaults();
		uiDefaults.put("Label.font", ((Font) uiDefaults.get("Label.font"))
				.deriveFont(25f));

		// define a label and set some of its properties
		final JLabel label1 = new JLabel("Double-click me!", JLabel.RIGHT);
		label1.setForeground(Color.ORANGE);
		label1.setFont(new Font("Serif", Font.BOLD, 30));
		theFrame.add(label1);

		// usage of icons
		Icon icon1 = new ImageIcon(SimpleJFrameExample.class
				.getResource("/images/smiley.jpeg"));
		JButton button = new JButton();
		button.setIcon(icon1);
		theFrame.add(button);
		
		JButton button1 = new JButton("Just a Button");
		theFrame.add(button1);

		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1)
					System.exit(0);
			}
		});

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label1.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label1.setForeground(Color.ORANGE);
			}
		});

		// key bindings and actions
		Action paintItGreenAction = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label1.setForeground(Color.GREEN);
			}
		};

		Action paintItRedAction = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label1.setForeground(Color.RED);
			}
		};

		
		button.getInputMap().put(KeyStroke.getKeyStroke("F7"), "f7Pressed");
		button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK),
				"rAndCtrlPressed");
		button.getActionMap().put("f7Pressed", paintItGreenAction);
		button.getActionMap().put("rAndCtrlPressed", paintItRedAction);

		theFrame.pack();
		theFrame.setVisible(true);
	}
}
