package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestButton extends JFrame {
	private JPanel contentPane;
	private JButton btn;
	
	public TestButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setSize(300, 200);
		setContentPane(contentPane);
		
		btn = new JButton("ÄãºÃ");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String src = e.getActionCommand();
				System.out.println(src);
				
			}
		});
		contentPane.add(btn);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestButton();
	}
}
