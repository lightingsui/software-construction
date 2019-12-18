package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class TestProgressBar extends JFrame {

	public TestProgressBar() {
		getContentPane().setLayout(null);

		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			JProgressBar pb = new JProgressBar();
			int value = 0;
			JDialog dialog = new JDialog();

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						while(true) {
							try {
								pb.setValue(value++);
								if(value == pb.getMaximum()) {
									dialog.setVisible(false);
								}
								sleep(50);
							} catch(Exception ex) {
								
							}
						}
					}
				}.start();
				dialog.setVisible(true);
			}
		});
		btnTest.setBounds(27, 26, 91, 21);
		getContentPane().add(btnTest);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(200, 120);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestProgressBar();
	}
}
