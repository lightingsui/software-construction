package com.view.login;

import com.train.dto.UserDTO;
import com.train.service.User;
import com.util.tool.WindowUtil;
import com.view.home.TrainMainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {
	private static LoginForm loginForm;
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
	private static JButton btnLogin;
	private JLabel L_title;
	private JComboBox<Object> cbb_username;
	private DefaultComboBoxModel<Object> usernameModel;
	private JProgressBar progressBar;
	private boolean[] cookie = { false, false };
	private UserDTO userDTO;
	private static boolean notify = false;

	public static void main(String[] args) {
		new LoginForm().setVisible(true);
	}

	public LoginForm() {
		setTitle("LoginForm");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/face.jpg"));
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 299);

		init();
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
	}

	public JPasswordField getPassword() {
		return password;
	}

	public JComboBox<Object> getCbb_username() {
		return cbb_username;
	}

	private void init() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		facePane = new JPanel();
		facePane.setBackground(Color.cyan);
		facePane.setBounds(43, 75, 98, 95);
		contentPane.add(facePane);
		facePane.setLayout(null);

		L_face = new JLabel("");
		L_face.setIcon(new ImageIcon("./images/yc.png"));
		L_face.setFont(new Font("Segoe Print", Font.BOLD, 16));
		L_face.setBounds(0, 0, 98, 95);
		facePane.add(L_face);

		infoPane = new JPanel();
		infoPane.setBackground(Color.cyan);
		infoPane.setBounds(151, 75, 232, 95);
		contentPane.add(infoPane);
		infoPane.setLayout(null);

		password = new JPasswordField();
		password.setEchoChar('●');
		password.setFont(new Font("华文行楷", Font.BOLD, 12));
		password.setBounds(10, 53, 212, 33);
		infoPane.add(password);

		// String[] names = { "张亚超", "温时君", "乔磊" };
		usernameModel = new DefaultComboBoxModel<Object>();
		loadDataModel();
		cbb_username = new JComboBox<Object>();
		cbb_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_username.setModel(usernameModel);
		// cbb_username.setModel(new DefaultComboBoxModel<Object>(names));
		cbb_username.setEditable(true);
		cbb_username.setBounds(10, 10, 212, 33);
		cbb_username.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.setText("");
				do_username_check_login(e);
			}
		});
		infoPane.add(cbb_username);

		cookiesPane = new JPanel();
		cookiesPane.setBackground(Color.cyan);
		cookiesPane.setBounds(151, 168, 232, 39);
		contentPane.add(cookiesPane);
		cookiesPane.setLayout(null);

		remPwd = new JCheckBox("记住密码");
		remPwd.setBackground(Color.cyan);
		remPwd.setFont(new Font("华文行楷", Font.BOLD, 16));
		remPwd.setBounds(6, 6, 103, 31);
		remPwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (remPwd.isSelected()) {
					cookie[0] = true;
				}
			}
		});
		cookiesPane.add(remPwd);

		selfLogin = new JCheckBox("自动登录");
		selfLogin.setBackground(Color.cyan);
		selfLogin.setFont(new Font("华文行楷", Font.BOLD, 16));
		selfLogin.setBounds(121, 6, 103, 31);
		selfLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selfLogin.isSelected()) {
					cookie[1] = true;
					cookie[0] = true;
					remPwd.setSelected(true);
				}
			}
		});
		cookiesPane.add(selfLogin);

		helpPane = new JPanel();
		helpPane.setBackground(Color.cyan);
		helpPane.setBounds(393, 75, 100, 95);
		contentPane.add(helpPane);
		helpPane.setLayout(null);

		retrieve = new JButton("找回密码");
		retrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_retrieve_action(e);
			}
		});
		retrieve.setForeground(Color.BLACK);
		retrieve.setFont(new Font("华文行楷", Font.BOLD, 14));
		retrieve.setBounds(0, 54, 100, 31);
		helpPane.add(retrieve);

		resigter = new JButton("注册账号");
		resigter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_register_action(e);
			}
		});
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
		L_title.setBackground(Color.cyan);
		L_title.setBounds(151, 10, 232, 55);
		contentPane.add(L_title);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setVisible(false);
		progressBar.setBounds(190, 55, 146, 14);
		contentPane.add(progressBar);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					LoginForm.this.dispose();
					System.exit(0);
				} catch (Exception ex) {
					// 此处不做处理
				}
			}
		});
		setResizable(false);
		setVisible(true);
	}

	protected void do_username_check_login(ActionEvent e) {
		try {
			// password.setText("");
			User user = new User((String) cbb_username.getSelectedItem(), null);
			userDTO = user.findUserByName();

			if (1 == userDTO.getRem_password()) {
				password.setText(userDTO.getPassword());
				remPwd.setSelected(true);
				if (1 == userDTO.getAuto_login()) {
					selfLogin.setSelected(true);
					runProgressBar();
				}
			}
		} catch (Exception ex) {

		}

	}

	private void runProgressBar() {
		progressBar.setVisible(true);
		progressBar.setStringPainted(true);// 显示百分比字符
		progressBar.setIndeterminate(false);// 不确定的进度条
		try {
			Thread stepper = new BarThread(progressBar);
			stepper.start();
		} catch (Exception ex) {

		}
	}

	static class BarThread extends Thread {
		private static int DELAY = 20;
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
					try {
						int value = progressBar.getValue();
						progressBar.setValue(value += 3);

						if (progressBar.getValue() == 100) {
							Thread.currentThread().interrupt();
							progressBar.setValue(0);
							notify = true;
						}
						if (notify) {
							notify = false;
							btnLogin.doClick();
						}
					} catch (Exception ex) {

					}
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

	private void loadDataModel() {
		List<String> allNames = new User().getAllNames();

		for (int i = 0; i < allNames.size(); i++) {
			usernameModel.addElement(allNames.get(i));
		}
	}

	protected void do_retrieve_action(ActionEvent e) {
		LoginForm.this.setVisible(false);
		Retrieve.display();
	}

	protected void do_register_action(ActionEvent e) {
		LoginForm.this.setVisible(false);
		Register.display();
	}

	protected void do_login_action(ActionEvent e) {
		if (validateUser()) { // 用户名/密码不为空
			String get_username = (String) this.cbb_username.getSelectedItem();
			String get_password = new String(this.password.getPassword());

			User user = new User(get_username, get_password);
			boolean success = user.findUser();

			if (success) { // 查找成功
				/* 先销毁窗体再进行显示系统主界面 */
				LoginForm.this.dispose();
				/* 窗体销毁完毕 */
				if (userDTO != null) {
					setCookie(); // 设置cookie值
				}
				notify = false;
				/* 设置'记住密码'和'自动登录在数据库中的属性值' */
				TrainMainFrame.display();
				TrainMainFrame.getInstance().getL_currentUsername()
						.setText(get_username);
			} else { // 查找失败
				JOptionPane.showMessageDialog(null, "用户名/密码错误！");
			}
		} else { // 用户名或密码为空的情况
//			JOptionPane.showMessageDialog(null, "用户名/密码不能为空！");
		}
	}

	private void setCookie() {
		if (cookie[1]) {
			userDTO.setAuto_login(1);
			userDTO.setRem_password(1);

		} else {
			if (cookie[0]) {
				userDTO.setRem_password(1);
			}
		}
		new User().updateCookie(userDTO);
	}

	public boolean validateUser() {
		boolean[] result = { false, false };

		if (!"".equals((String) cbb_username.getSelectedItem())) {
			result[0] = true;
		}

		// 不可以通过toString方法进行字符转换
		if (!"".equals(new String(password.getPassword()))) {
			result[1] = true;
		}

		return result[0] && result[1];
	}

	public static void display() {
		loginForm = new LoginForm();
		loginForm.setVisible(true);
		loginForm.setResizable(false);
	}
}
