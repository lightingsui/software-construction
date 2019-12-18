package com.train.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.dao.UserDAO;
import com.daofactory.DAOFactory;
import com.train.util.WindowUtil;
import com.train.vo.User;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {
	private JPanel contentPane;
	private JPasswordField password;
	private JPanel facePane;
	private JLabel L_face;
	private JPanel infoPane;
	private JPanel cookiesPane;
	private JCheckBox remPwd;
	private JCheckBox selfLogin;
	private JPanel helpPane;
	private JButton retrieve; // 找回密码
	private JButton resigter; // 注册账户
	private JButton btnLogin;
	private JLabel L_title;
	private JComboBox<Object> cbb_username;

	public static void main(String[] args) {
		new LoginForm().setVisible(true);
	}
	
	private LoginForm() {
		setTitle("LoginForm");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/face.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 299);

		init();
		setLocation(WindowUtil.setLocation(this.getWidth(), this.getHeight()));
	}

	public static void display() {
		new LoginForm().setVisible(true);
	}

	private void init() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		facePane = new JPanel();
		facePane.setBackground(Color.PINK);
		facePane.setBounds(43, 75, 98, 95);
		contentPane.add(facePane);
		facePane.setLayout(null);

		L_face = new JLabel("");
		L_face.setIcon(new ImageIcon("./images/yc.png"));
		L_face.setFont(new Font("Segoe Print", Font.BOLD, 16));
		L_face.setBounds(0, 0, 98, 95);
		facePane.add(L_face);

		infoPane = new JPanel();
		infoPane.setBackground(Color.PINK);
		infoPane.setBounds(151, 75, 232, 95);
		contentPane.add(infoPane);
		infoPane.setLayout(null);

		password = new JPasswordField();
		password.setEchoChar('●');
		password.setFont(new Font("华文行楷", Font.BOLD, 12));
		password.setBounds(10, 53, 212, 33);
		infoPane.add(password);
		
		String[] names = {"张亚超", "温时君", "乔磊"};
		cbb_username = new JComboBox<Object>();
		cbb_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_username.setModel(new DefaultComboBoxModel<Object>(names));
		cbb_username.setEditable(true);
		cbb_username.setBounds(10, 10, 212, 33);
		infoPane.add(cbb_username);
		
		cookiesPane = new JPanel();
		cookiesPane.setBackground(Color.PINK);
		cookiesPane.setBounds(151, 168, 232, 39);
		contentPane.add(cookiesPane);
		cookiesPane.setLayout(null);

		remPwd = new JCheckBox("记住密码");
		remPwd.setBackground(Color.PINK);
		remPwd.setFont(new Font("华文行楷", Font.BOLD, 16));
		remPwd.setBounds(6, 6, 103, 31);
		cookiesPane.add(remPwd);

		selfLogin = new JCheckBox("自动登录");
		selfLogin.setBackground(Color.PINK);
		selfLogin.setFont(new Font("华文行楷", Font.BOLD, 16));
		selfLogin.setBounds(121, 6, 103, 31);
		cookiesPane.add(selfLogin);

		helpPane = new JPanel();
		helpPane.setBackground(Color.PINK);
		helpPane.setBounds(393, 75, 100, 95);
		contentPane.add(helpPane);
		helpPane.setLayout(null);

		retrieve = new JButton("找回密码");
		retrieve.setForeground(Color.BLACK);
		retrieve.setFont(new Font("华文行楷", Font.BOLD, 14));
		retrieve.setBounds(0, 54, 100, 31);
		helpPane.add(retrieve);

		resigter = new JButton("注册账号");
		resigter.setForeground(Color.BLACK);
		resigter.setFont(new Font("华文行楷", Font.BOLD, 14));
		resigter.setBounds(0, 10, 100, 31);
		helpPane.add(resigter);

		btnLogin = new JButton("Sign me in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_login_action(e);
			}
		});
		btnLogin.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLogin.setBounds(161, 215, 209, 39);
		contentPane.add(btnLogin);

		L_title = new JLabel("电厂职工培训管理系统");
		L_title.setFont(new Font("华文行楷", Font.BOLD, 22));
		L_title.setBackground(Color.PINK);
		L_title.setBounds(151, 10, 232, 55);
		contentPane.add(L_title);
	}

	protected void do_login_action(ActionEvent e) {
		// validate();
		String user_name = (String) this.cbb_username.getSelectedItem();
		System.out.println(user_name);
		char[] pwds = this.password.getPassword();
		String pwd = new String(pwds);
		
		if("".equals(user_name) || "".equals(pwd)) {
			JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
		}
		
		boolean flag = check(user_name, pwd);

		if (flag) {
			LoginForm.this.setVisible(false);
			TrainMainFrame.display();
		}
	}

	public boolean check(String user_name, String pwd) {
		UserDAO dao = DAOFactory.getUserDAOInstance();
		try {
			User user = dao.findUser(user_name, pwd);

			if (user != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
