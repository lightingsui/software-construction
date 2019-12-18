package com.view.systemManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.util.tool.WindowUtil;
import com.view.home.TrainMainFrame;

@SuppressWarnings("serial")
public class SystemManage extends JFrame {
	private static SystemManage systemManage = new SystemManage();
	private JPanel contentPane;
	private JPanel infoPane;
	private JButton btnOk;
	private JLabel L_title;
	private JComboBox<String> cbb_database;
	private JLabel L_selected_db;
	private JLabel L_current_db;

	public static void main(String[] args) {
		new SystemManage();
	}

	public SystemManage() {
		setTitle("Register");
		setBounds(100, 100, 519, 299);

		init();
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
	}

	private void init() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		infoPane = new JPanel();
		infoPane.setBackground(Color.cyan);
		infoPane.setBounds(217, 75, 232, 61);
		contentPane.add(infoPane);
		infoPane.setLayout(null);

		String[] database = { "train_emp", "emp_train" };

		cbb_database = new JComboBox<String>();
		cbb_database.setFont(new Font("Consolas", Font.BOLD, 18));
		cbb_database.setModel(new DefaultComboBoxModel<String>(database));
		cbb_database.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				L_selected_db.setText((String) cbb_database.getSelectedItem());
			}
		});
		cbb_database.setBounds(10, 10, 200, 41);
		infoPane.add(cbb_database);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_ok_action(e);
			}
		});
		btnOk.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnOk.setBounds(161, 215, 209, 39);
		contentPane.add(btnOk);

		L_title = new JLabel("数据库转接");
		L_title.setFont(new Font("华文行楷", Font.BOLD, 22));
		L_title.setBackground(Color.cyan);
		L_title.setBounds(195, 10, 139, 55);
		contentPane.add(L_title);

		JPanel namePane = new JPanel();
		namePane.setBackground(Color.LIGHT_GRAY);
		namePane.setBounds(53, 87, 133, 39);
		contentPane.add(namePane);
		namePane.setLayout(null);

		JLabel L_data_name = new JLabel("数据库");
		L_data_name.setFont(new Font("华文楷体", Font.BOLD, 20));
		L_data_name.setBounds(23, 0, 85, 39);
		namePane.add(L_data_name);

		L_selected_db = new JLabel("train_emp");
		L_selected_db.setHorizontalAlignment(SwingConstants.CENTER);
		L_selected_db.setFont(new Font("Consolas", Font.BOLD, 24));
		L_selected_db.setBounds(219, 164, 218, 41);
		contentPane.add(L_selected_db);

		L_current_db = new JLabel("当前数据库");
		L_current_db.setFont(new Font("华文楷体", Font.BOLD, 18));
		L_current_db.setBounds(63, 164, 100, 41);
		contentPane.add(L_current_db);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				/* 销毁窗体对象 */
				SystemManage.this.dispose();
				/* 窗体对象销毁完毕（并非真正意义上的销毁，只是把对象置空） */
				 TrainMainFrame.display();
			}
		});
		setResizable(false);
//		setVisible(true);
	}

	protected void do_ok_action(ActionEvent e) {
		SystemManage.this.setVisible(false);
	}
	
	public static void display() {
		systemManage.setVisible(true);
		systemManage.setResizable(false);
	}
}
