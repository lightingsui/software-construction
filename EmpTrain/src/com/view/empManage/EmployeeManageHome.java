package com.view.empManage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.util.tool.WindowUtil;
import com.view.departManage.DepartManage;
import com.view.home.TrainMainFrame;

@SuppressWarnings("serial")
public class EmployeeManageHome extends JFrame {
	private static EmployeeManageHome employeeManageHome;
	private JPanel contentPane;
	private JButton btn_addDepartment;
	private JDesktopPane desktopPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManageHome.display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeManageHome() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 657);
		// setSize(WindowUtil.getAllScreen());
		init();

		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					EmployeeManageHome.this.dispose();
					new TrainMainFrame();
				} catch (Exception ex) {
					// 此处以免产生不必要的异常情况
				}
			}
		});
	}

	private void init() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu m_empManage = new JMenu("员工管理");
		menuBar.add(m_empManage);

		JMenuItem mi_empInfoManage = new JMenuItem("员工基本信息管理");
		mi_empInfoManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_empInfoManage_action(e);
			}
		});
		m_empManage.add(mi_empInfoManage);

		JMenuItem mi_deptManage = new JMenuItem("部门管理");
		mi_deptManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_depatManage_action(e);
			}
		});
		m_empManage.add(mi_deptManage);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btn_addEmployee = new JButton("添加员工");
		btn_addEmployee.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddEmployee.display();
			}
		});
		toolBar.add(btn_addEmployee);

		btn_addDepartment = new JButton("添加部门");
		btn_addDepartment.setEnabled(false);
		btn_addDepartment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DepartManage.getInstance().callFunctinon("add");
			}
		});
		toolBar.add(btn_addDepartment);

		desktopPane = new JDesktopPane();
		EmployeeHome home = new EmployeeHome();
		desktopPane.add(home);
		try {
			home.setMaximum(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}

		contentPane.add(desktopPane, BorderLayout.CENTER);

		final JPanel copyrightPane = new JPanel();
		contentPane.add(copyrightPane, BorderLayout.SOUTH);

		JLabel L_copyright = new JLabel("Copyright@Sui");
		L_copyright.setFont(new Font("华文楷体", Font.BOLD, 16));
		copyrightPane.add(L_copyright);
	}

	public JButton getBtn_addDepartment() {
		return btn_addDepartment;
	}

	protected void do_depatManage_action(ActionEvent e) {
		DepartManage.display();

		try {
			desktopPane.add(DepartManage.getInstance());
			DepartManage.getInstance().setMaximum(true);
		} catch (Exception ex) {

		}
	}

	private void do_empInfoManage_action(ActionEvent e) {
		EmpInfoManage.display();
		try {
			desktopPane.add(EmpInfoManage.getInstance());
			EmpInfoManage.getInstance().setMaximum(true);
		} catch (Exception ex) {

		}
	}

	public static void display() {
		employeeManageHome = new EmployeeManageHome();
		employeeManageHome.setVisible(true);
		employeeManageHome.setResizable(false);
	}

	public static EmployeeManageHome getInstance() {
		return employeeManageHome;
	}
}