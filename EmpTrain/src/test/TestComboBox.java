package test;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TestComboBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestComboBox frame = new TestComboBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] majors = {"软件工程", "计算机", "日语", "机械"};
		JComboBox<Object> cbb_major = new JComboBox<Object>();
		cbb_major.setEditable(true);
		cbb_major.setModel(new DefaultComboBoxModel<Object>(majors));
		cbb_major.setBounds(164, 94, 137, 21);
		contentPane.add(cbb_major);
	}
}
