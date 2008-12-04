package swing.simple;

import java.awt.event.*;
import javax.swing.*;

public class SwingWorkerDemo extends JFrame {
	JButton button = new JButton("Click me!");

	SwingWorkerDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(button);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClockPrecision().execute();
			}
		};

		button.addActionListener(al);

		pack();
	}

	class ClockPrecision extends SwingWorker<Long, Void> {
		@Override
		public Long doInBackground() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return ((System.nanoTime()) / 1000000);
		}

		@Override
		protected void done() {
			try {
				button.setText("" + get());
			} catch ( /* InterruptedException, ExecutionException */Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		new SwingWorkerDemo().setVisible(true);
	}
}