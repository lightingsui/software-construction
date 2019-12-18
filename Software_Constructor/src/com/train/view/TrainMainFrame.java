package com.train.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.train.util.WindowUtil;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class TrainMainFrame extends JFrame {
	private JPanel contentPane;
	private JPanel functionPane;
	private JPanel showPane;
	private CardLayout cl = new CardLayout();

	private TrainMainFrame() {
		setTitle("电厂职工培训管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		init();
	}

	private void init() {
		functionPane = new JPanel();
		functionPane.setBackground(Color.PINK);
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
		btnTrainPlanManage.setFont(new Font("华文宋体", Font.BOLD, 16));
		btnTrainPlanManage.setBounds(0, 0, 170, 43);
		functionPane.add(btnTrainPlanManage);

		JButton btnResultManage = new JButton("培训成绩管理");
		btnResultManage.setFont(new Font("华文宋体", Font.BOLD, 16));
		btnResultManage.setBounds(0, 43, 170, 43);
		functionPane.add(btnResultManage);

		JButton btnAttendanceManage = new JButton("考勤管理");
		btnAttendanceManage.setFont(new Font("华文宋体", Font.BOLD, 16));
		btnAttendanceManage.setBounds(0, 86, 170, 43);
		functionPane.add(btnAttendanceManage);

		JButton btnEmpManage = new JButton("学员管理");
		btnEmpManage.setFont(new Font("华文宋体", Font.BOLD, 16));
		btnEmpManage.setBounds(0, 129, 170, 43);
		functionPane.add(btnEmpManage);

		JButton btnSystemManage = new JButton("系统管理");
		btnSystemManage.setFont(new Font("华文宋体", Font.BOLD, 16));
		btnSystemManage.setBounds(0, 172, 170, 43);
		functionPane.add(btnSystemManage);

		JLabel L_image = new JLabel("");
		L_image.setIcon(new ImageIcon("./images/smile.jpg"));
		L_image.setBounds(0, 214, 170, 200);
		functionPane.add(L_image);

		JLabel L_currentUser = new JLabel("当前用户：");
		L_currentUser.setFont(new Font("华文宋体", Font.BOLD, 18));
		L_currentUser.setHorizontalAlignment(SwingConstants.CENTER);
		L_currentUser.setBounds(0, 414, 97, 61);
		functionPane.add(L_currentUser);
		
		JLabel L_currentUsername = new JLabel("张亚超");
		L_currentUsername.setHorizontalAlignment(SwingConstants.CENTER);
		L_currentUsername.setFont(new Font("华文宋体", Font.BOLD, 18));
		L_currentUsername.setBounds(90, 414, 80, 61);
		functionPane.add(L_currentUsername);

		showPane = new JPanel();
		showPane.setLayout(cl);
		Home home = new Home();
		showPane.add(home);
		showPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		showPane.setBounds(169, 0, 630, 474);
		contentPane.add(showPane);

		setResizable(false);
		setLocation(WindowUtil.setLocation(this.getWidth(), this.getHeight()));
	}

	protected void do_Manage_action(ActionEvent e) {
		String src = e.getActionCommand();
		switch (src) {
		case "培训计划管理":
			TrainMainFrame.this.setTitle("培训计划管理");
			TrainingPlanHome.display();
		}
	}

	public static void display() {
		new TrainMainFrame().setVisible(true);
	}

	public static void main(String[] args) {
		new TrainMainFrame().setVisible(true);
	}
}