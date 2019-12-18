package com.train.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.TrainingPlanDAO;
import com.daofactory.DAOFactory;
import com.train.util.WindowUtil;
import com.train.vo.MajorPlan;
import com.train.vo.TrainingPlan;

@SuppressWarnings("serial")
public class AddTrainingPlan extends JFrame {
	private static AddTrainingPlan addTrainingPlan = new AddTrainingPlan();
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_year;
	private JTextField tf_startDate;
	private JTextField tf_endDate;
	private JTextField tf_classcount;
	private JButton btnLogin;
	private JComboBox<Object> cbMajor;
	private JTextArea ta_purpose;
	private JTextArea ta_content;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField tf_teacher;
	private JButton btn_back;
	private JButton btn_reset;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTrainingPlan frame = new AddTrainingPlan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private AddTrainingPlan() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.PINK);
		setContentPane(contentPane);

		JLabel L_add = new JLabel("添加培训计划");
		L_add.setFont(new Font("华文楷体", Font.BOLD, 26));
		L_add.setBounds(251, 23, 182, 39);
		contentPane.add(L_add);

		JLabel L_name = new JLabel("       \u540D\u79F0");
		L_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_name.setBounds(309, 86, 115, 33);
		contentPane.add(L_name);

		tf_name = new JTextField();
		tf_name.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_name.setColumns(10);
		tf_name.setBounds(434, 85, 152, 33);
		contentPane.add(tf_name);

		JLabel L_year = new JLabel("       \u5E74\u5EA6");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(10, 87, 115, 33);
		contentPane.add(L_year);

		tf_year = new JTextField();
		tf_year.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_year.setColumns(10);
		tf_year.setBounds(147, 86, 152, 33);
		contentPane.add(tf_year);

		JLabel L_startDate = new JLabel("    \u5F00\u59CB\u65E5\u671F");
		L_startDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_startDate.setBounds(10, 141, 115, 33);
		contentPane.add(L_startDate);

		tf_startDate = new JTextField();
		tf_startDate.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_startDate.setColumns(10);
		tf_startDate.setBounds(147, 140, 152, 33);
		contentPane.add(tf_startDate);

		JLabel L_endDate = new JLabel("    \u7ED3\u675F\u65E5\u671F");
		L_endDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_endDate.setBounds(309, 141, 115, 33);
		contentPane.add(L_endDate);

		tf_endDate = new JTextField();
		tf_endDate.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_endDate.setColumns(10);
		tf_endDate.setBounds(434, 140, 152, 33);
		contentPane.add(tf_endDate);

		btnLogin = new JButton("submit");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_submit_action(e);
			}
		});
		btnLogin.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLogin.setBounds(240, 399, 152, 33);
		contentPane.add(btnLogin);

		JLabel L_major = new JLabel("     \u4E13\u4E1A");
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_major.setBounds(23, 216, 115, 33);
		contentPane.add(L_major);

		JLabel L_purpose = new JLabel("     \u57F9\u8BAD\u76EE\u7684");
		L_purpose.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_purpose.setBounds(164, 216, 115, 33);
		contentPane.add(L_purpose);

		cbMajor = new JComboBox<Object>();
		String[] majors = { new String("电气"), new String("汽机"),
				new String("锅炉"), new String("化水"), new String("燃运") };
		cbMajor.setModel(new DefaultComboBoxModel<Object>(majors));
		cbMajor.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbMajor.setBounds(33, 259, 82, 27);
		contentPane.add(cbMajor);

		ta_purpose = new JTextArea();
		ta_purpose.setFont(new Font("华文楷体", Font.PLAIN, 14));
		ta_purpose.setBounds(154, 259, 146, 113);
		contentPane.add(ta_purpose);

		JLabel L_content = new JLabel("     \u57F9\u8BAD\u5185\u5BB9");
		L_content.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_content.setBounds(334, 216, 115, 33);
		contentPane.add(L_content);

		ta_content = new JTextArea();
		ta_content.setFont(new Font("华文楷体", Font.PLAIN, 14));
		ta_content.setBounds(325, 258, 146, 113);
		contentPane.add(ta_content);

		JLabel L_classcount = new JLabel("     \u8BFE\u65F6");
		L_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_classcount.setBounds(497, 216, 82, 33);
		contentPane.add(L_classcount);

		tf_classcount = new JTextField();
		tf_classcount.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(501, 258, 76, 33);
		contentPane.add(tf_classcount);

		JLabel L_teacher = new JLabel("    \u6388\u8BFE\u4EBA");
		L_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_teacher.setBounds(497, 299, 82, 33);
		contentPane.add(L_teacher);

		tf_teacher = new JTextField();
		tf_teacher.setFont(new Font("华文楷体", Font.PLAIN, 14));
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(503, 338, 76, 33);
		contentPane.add(tf_teacher);

		btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_back_action(e);
			}
		});
		btn_back.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btn_back.setBounds(427, 399, 152, 33);
		contentPane.add(btn_back);

		btn_reset = new JButton("reset");
		btn_reset.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btn_reset.setBounds(50, 399, 152, 33);
		contentPane.add(btn_reset);

		setResizable(false);
		setLocation(WindowUtil.setLocation(this.getWidth(), this.getHeight()));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				AddTrainingPlan.this.dispose();
				TrainingPlanHome.display();
				// System.exit(0);
			}
		});
	}

	protected void do_back_action(ActionEvent e) {
		AddTrainingPlan.this.setVisible(false);
		TrainingPlanHome.display();
	}

	protected void do_submit_action(ActionEvent e) {
		String name = tf_name.getText().trim();
		String year = tf_year.getText().trim();
		String startDate = tf_startDate.getText().trim();
		String endDate = tf_endDate.getText().trim();
		String major = (String) cbMajor.getSelectedItem();
		String purpose = ta_purpose.getText().trim();
		String content = ta_content.getText().trim();
		String class_count = tf_classcount.getText().trim();
		String teacher = tf_teacher.getText().trim();

		if (validateTrainPlan()) {
			MajorPlan majorInstance = new MajorPlan();
			majorInstance.setMajorName(major);
			majorInstance.setTrainingPurpose(purpose);
			majorInstance.setTrainingContent(content);
			majorInstance.setClassHours(class_count);
			majorInstance.setTeacher(teacher);

			TrainingPlan plan = new TrainingPlan();
			plan.setName(name);
			plan.setPlanYear(year);
			java.util.Date sdate_util = null;
			java.util.Date edate_util = null;
			try {
				sdate_util = sdf.parse(startDate);
				edate_util = sdf.parse(endDate);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			java.sql.Date sdate_sql = new java.sql.Date(sdate_util.getTime());
			java.sql.Date edate_sql = new java.sql.Date(edate_util.getTime());
			plan.setStartDate(sdate_sql);
			plan.setEndDate(edate_sql);
			plan.setMajorPlan(majorInstance);

			TrainingPlanDAO dao = DAOFactory.getPlanDaoInstance();
			try {
				int k = dao.add(plan);

				if (k != 0) {
					JOptionPane.showMessageDialog(null, "添加成功！");
					tf_name.setText("");
					tf_year.setText("");
					tf_startDate.setText("");
					tf_endDate.setText("");
					cbMajor.setSelectedItem("电气");
					ta_purpose.setText("");
					ta_content.setText("");
					tf_classcount.setText("");
					tf_teacher.setText("");
				}

				System.out.println(k);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "请完善信息！");
		}
	}

	private boolean validateTrainPlan() {
		String name = tf_name.getText().trim();
		String year = tf_year.getText().trim();
		String startDate = tf_startDate.getText().trim();
		String endDate = tf_endDate.getText().trim();
		String major = (String) cbMajor.getSelectedItem();
		String purpose = ta_purpose.getText().trim();
		String content = ta_content.getText().trim();
		String class_count = tf_classcount.getText().trim();
		String teacher = tf_teacher.getText().trim();

		if (!"".equals(name) && !"".equals(year) && !"".equals(startDate)
				&& !"".equals(endDate) && !"".equals(major)
				&& !"".equals(purpose) && !"".equals(content)
				&& !"".equals(class_count) && !"".equals(teacher)) {
			return true;
		}
		return false;
	}

	public static void display() {
		AddTrainingPlan.getInstance().setVisible(true);
	}

	public static AddTrainingPlan getInstance() {
		return addTrainingPlan;
	}
}
