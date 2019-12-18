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
public class Register extends JFrame {
	private static Register register;
	private JPanel contentPane;
	private JPasswordField pf_password;
	private JPanel infoPane;
	private JButton btnRegister;
	private JLabel L_title;
	private JTextField tf_username;

	public static void main(String[] args) {
		Register.display();
	}

	private Register() {
		setTitle("Register");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 299);

		init();
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
	}

	public JPasswordField getPf_password() {
		return pf_password;
	}

	public JTextField getTf_username() {
		return tf_username;
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

		pf_password = new JPasswordField();
		pf_password.setEchoChar('●');
		pf_password.setFont(new Font("华文行楷", Font.BOLD, 12));
		pf_password.setBounds(10, 66, 212, 33);
		infoPane.add(pf_password);

		tf_username = new JTextField();
		tf_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_username.setBounds(10, 10, 212, 33);
		infoPane.add(tf_username);
		tf_username.setColumns(10);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_login_action(e);
			}
		});
		btnRegister.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnRegister.setBounds(161, 215, 209, 39);
		contentPane.add(btnRegister);

		L_title = new JLabel("注册账户");
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
				/* 销毁窗体对象 */
				Register.this.dispose();
				/* 窗体对象销毁完毕（并非真正意义上的销毁，只是把对象置空） */
				LoginForm.display();
			}
		});
		setResizable(false);
	}

	protected void do_login_action(ActionEvent e) {
		String user_name = tf_username.getText();
		String password = new String(pf_password.getPassword());
		if (validateUser()) { // 用户名/密码不为空

			UserDTO userDTO = new UserDTO(user_name, password);
			User user = new User(user_name, password);
			boolean existed = user.nameExisted(user_name);
			if (existed) {
				JOptionPane.showMessageDialog(null, "当前用户已存在！请重新注册账号！");
				clear();
			} else {
				boolean success = user.saveUser(userDTO);
				if (success) {
					JOptionPane.showMessageDialog(null, "注册成功！");
					Register.getInstance().dispose();
					new LoginForm();
				} else {
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			}
		} else { // 用户名或密码为空的情况
			JOptionPane.showMessageDialog(null, "用户名/密码不能为空！");
		}

	}

	private void clear() {
		tf_username.setText("");
		pf_password.setText("");
	}

	public boolean validateUser() {
		boolean[] result = { false, false };

		if (!"".equals(tf_username.getText())) {
			result[0] = true;
		}
		if (!"".equals(new String(pf_password.getPassword()))) {
			result[1] = true;
		}

		return result[0] && result[1];
	}

	public static Register getInstance() {
		return register;
	}

	public static void display() {
		register = new Register();
		register.setVisible(true);
		register.setResizable(false);
	}
}
