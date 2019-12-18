package com.view.login;

import com.train.dto.UserDTO;
import com.train.service.User;
import com.util.tool.WindowUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Retrieve extends JFrame {
	private static Retrieve retrieve;
	private JPanel contentPane;
	private JPanel infoPane;
	private JButton btnRetrieve;
	private JLabel L_title;
	private JTextField tf_username;
	private JTextField tf_password;

	public static void main(String[] args) {
		Retrieve.display();
	}

	public Retrieve() {
		setTitle("Retrieve");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 299);

		init();
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
	}

	public JTextField getTf_username() {
		return tf_username;
	}

	public JTextField getTf_password() {
		return tf_password;
	}

	private void init() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		infoPane = new JPanel();
		infoPane.setBackground(Color.cyan);
		infoPane.setBounds(217, 75, 232, 109);
		contentPane.add(infoPane);
		infoPane.setLayout(null);

		tf_username = new JTextField();
		tf_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_username.setBounds(10, 10, 212, 33);
		infoPane.add(tf_username);
		tf_username.setColumns(10);

		tf_password = new JTextField();
		tf_password.setBackground(Color.WHITE);
		tf_password.setEditable(false);
		tf_password.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_password.setColumns(10);
		tf_password.setBounds(10, 66, 212, 33);
		infoPane.add(tf_password);

		btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_retrieve_action(e);
			}
		});
		btnRetrieve.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnRetrieve.setBounds(161, 215, 209, 39);
		contentPane.add(btnRetrieve);

		L_title = new JLabel("找回密码");
		L_title.setFont(new Font("华文行楷", Font.BOLD, 22));
		L_title.setBackground(Color.cyan);
		L_title.setBounds(201, 10, 107, 55);
		contentPane.add(L_title);

		JPanel namePane = new JPanel();
		namePane.setBackground(Color.LIGHT_GRAY);
		namePane.setBounds(53, 81, 133, 39);
		contentPane.add(namePane);
		namePane.setLayout(null);

		JLabel L_username = new JLabel("用户名");
		L_username.setFont(new Font("华文楷体", Font.BOLD, 20));
		L_username.setBounds(23, 0, 85, 39);
		namePane.add(L_username);

		JPanel pwdPane = new JPanel();
		pwdPane.setBackground(Color.LIGHT_GRAY);
		pwdPane.setBounds(53, 136, 133, 39);
		contentPane.add(pwdPane);
		pwdPane.setLayout(null);

		JLabel L_password = new JLabel("密    码");
		L_password.setFont(new Font("华文楷体", Font.BOLD, 20));
		L_password.setBounds(23, 0, 85, 39);
		pwdPane.add(L_password);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Retrieve.getInstance().dispose();
				Retrieve.setNullInstance();
				LoginForm.display();
			}
		});
		setResizable(false);
	}

	protected void do_retrieve_action(ActionEvent e) {
		String user_name = tf_username.getText();
		if (validateUser()) { // 用户名不为空
			User user = new User(user_name, null);
			UserDTO userDTO = user.findUserByName();
			if (userDTO != null) {
				tf_password.setText(userDTO.getPassword());
			} else {
				JOptionPane.showMessageDialog(null, "该用户不存在！");
			}
		} else { // 用户名为空的情况
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
		}

	}

	public boolean validateUser() {
		boolean result = false;

		if (!"".equals(tf_username.getText())) {
			result = true;
		}

		return result;
	}

	private static void setNullInstance() {
		retrieve = null;
	}
	
	public static Retrieve getInstance() {
		return retrieve;
	}

	public static void display() {
		retrieve = new Retrieve();
		retrieve.setVisible(true);
		retrieve.setResizable(false);
	}
}
