package com.view.home;

import com.util.tool.WindowUtil;
import com.view.empManage.EmployeeManageHome;
import com.view.login.LoginForm;
import com.view.systemManage.SystemManage;
import com.view.trainingPlan.TrainingPlanHome;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TrainMainFrame extends JFrame {
	private static TrainMainFrame mainFrame;
	private JPanel contentPane;
	private JPanel functionPane;
	private JPanel showPane;
	private JLabel L_currentUsername;
	private CardLayout cl = new CardLayout();

	public TrainMainFrame() {
		setTitle("电厂职工培训管理系统");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		init();
	}

	public JLabel getL_currentUsername() {
		return L_currentUsername;
	}

	private void init() {
		functionPane = new JPanel();
		functionPane.setBackground(Color.cyan);
		functionPane.setBorder(new LineBorder(Color.RED));
		functionPane.setBounds(0, 0, 170, 474);
		contentPane.add(functionPane);
		functionPane.setLayout(null);

		JButton btnTrainPlanManage = new JButton("培训计划管理");
		btnTrainPlanManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Manage_action(e);
			}
		});
		btnTrainPlanManage.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnTrainPlanManage.setBounds(0, 0, 170, 43);
		functionPane.add(btnTrainPlanManage);

		JButton btnResultManage = new JButton("培训成绩管理");
		btnResultManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TrainResultManage.display();
				TrainMainFrame.this.setVisible(false);
				TrainingPlanHome.display();
				TrainingPlanHome.getInstance().callFunction("find");
				JOptionPane.showMessageDialog(null,
						"请选择培训计划\n并点击按钮score\n进行查询!");
			}
		});
		btnResultManage.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnResultManage.setBounds(0, 43, 170, 43);
		functionPane.add(btnResultManage);

		JButton btnAttendanceManage = new JButton("考勤管理");
		btnAttendanceManage.setEnabled(false);
		btnAttendanceManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAttendanceManage.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnAttendanceManage.setBounds(0, 86, 170, 43);
		functionPane.add(btnAttendanceManage);

		JButton btnEmpManage = new JButton("员工管理");
		btnEmpManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Manage_action(e);
			}
		});
		btnEmpManage.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnEmpManage.setBounds(0, 129, 170, 43);
		functionPane.add(btnEmpManage);

		JButton btnSystemManage = new JButton("系统管理");
		btnSystemManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Manage_action(e);
			}
		});
		btnSystemManage.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSystemManage.setBounds(0, 172, 170, 43);
		functionPane.add(btnSystemManage);

		JLabel L_image = new JLabel("");
		L_image.setIcon(new ImageIcon("./images/smile.jpg"));
		L_image.setBounds(0, 214, 170, 200);
		functionPane.add(L_image);

		JLabel L_currentUser = new JLabel("当前用户：");
		L_currentUser.setFont(new Font("华文楷体", Font.BOLD, 18));
		L_currentUser.setHorizontalAlignment(SwingConstants.CENTER);
		L_currentUser.setBounds(0, 414, 97, 61);
		functionPane.add(L_currentUser);

		L_currentUsername = new JLabel("");
		L_currentUsername.setHorizontalAlignment(SwingConstants.CENTER);
		L_currentUsername.setFont(new Font("华文楷体", Font.BOLD, 18));
		L_currentUsername.setBounds(90, 414, 80, 61);
		functionPane.add(L_currentUsername);

		showPane = new JPanel();
		showPane.setLayout(cl);
		Home home = new Home();
		showPane.add(home);
		showPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		showPane.setBounds(169, 0, 630, 474);
		contentPane.add(showPane);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/* 销毁窗体对象 */
				TrainMainFrame.this.dispose();
				TrainMainFrame.setNullInstance();
				/* 窗体对象销毁完毕 */
				new LoginForm();
			}
		});
		setResizable(false);
		setVisible(true);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
	}

	protected void do_Manage_action(ActionEvent e) {
		String src = e.getActionCommand();

		switch (src) {
		case "培训计划管理": {// TrainMainFrame.this.setTitle("培训计划管理");
			TrainMainFrame.this.setVisible(false);
			TrainingPlanHome.display();
			break;
		}
		case "员工管理": {
			TrainMainFrame.this.setVisible(false);
			EmployeeManageHome.display();
			break;
		}
		case "系统管理": {
//			TrainMainFrame.this.setVisible(false);
			SystemManage.display();
		}
		default:
			break;
		}
	}

	private static void setNullInstance() {
		if (mainFrame != null) {
			mainFrame = null;
		}
	}

	public static void display() {
		if (mainFrame == null) {
			mainFrame = new TrainMainFrame();
		}
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}

	public static TrainMainFrame getInstance() {
		return mainFrame;
	}

	public static void main(String[] args) {
		new TrainMainFrame().setVisible(true);
	}
}