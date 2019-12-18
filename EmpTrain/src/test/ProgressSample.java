package test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressSample {
	static class BarThread extends Thread {
		private static int DELAY = 500;
		JProgressBar progressBar;

		public BarThread(JProgressBar progressBar) {
			super();
			this.progressBar = progressBar;
		}

		@Override
		public void run() {
			int minimun = progressBar.getMinimum();
			int maximun = progressBar.getMaximum();

			Runnable runner = new Runnable() {

				@Override
				public void run() {
					int value = progressBar.getValue();
					progressBar.setValue(++value);
				}
			};

			for (int i = minimun; i < maximun; i++) {
				try {
					SwingUtilities.invokeAndWait(runner);
					// Out task for each step is to just sleep
					Thread.sleep(DELAY);
				} catch (Exception ex) {

				}
			}
		}
	}

	public ProgressSample() {
	}

	public static void main(String[] args) {
		// Initialize
		final JProgressBar progressBar = new JProgressBar(0, 100);
		final JButton btn = new JButton("Start");
		progressBar.setStringPainted(true);// 显示百分比字符
		progressBar.setIndeterminate(false);// 不确定的进度条
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btn.setEnabled(false);
				Thread stepper = new BarThread(progressBar);
				stepper.start();
			}
		}; 
		
		btn.addActionListener(actionListener);
		
		JFrame the_frame = new JFrame("Progress Bars");
		the_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = the_frame.getContentPane();
		
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.add(progressBar);		
		contentPane.add(btn);
		
		the_frame.setVisible(true);
	}
}
