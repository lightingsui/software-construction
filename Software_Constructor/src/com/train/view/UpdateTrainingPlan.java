package com.train.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.dao.TrainingPlanDAO;
import com.daofactory.DAOFactory;
import com.train.vo.MajorPlan;
import com.train.vo.TrainingPlan;

@SuppressWarnings("serial")
public class UpdateTrainingPlan extends JPanel {
	private JTextField tf_name;
	private JTextField tf_year;
	private JTextField tf_startDate;
	private JTextField tf_endDate;
	private JTextField tf_classcount;
	private JTextField tf_teacher;
	private JButton btnUpdate;
	private JComboBox<Object> cbMajor;
	private JTextArea ta_purpose;
	private JTextArea ta_content;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JButton btnFind;
	private JButton btnDelete;

	public UpdateTrainingPlan() {
		setSize(630, 474);
		setBackground(Color.PINK);
		setLayout(null);

		init();
	}

	private void init() {
		JLabel L_add = new JLabel("\u4FEE\u6539\u57F9\u8BAD\u8BA1\u5212");
		L_add.setFont(new Font("�����п�", Font.BOLD, 22));
		L_add.setBounds(253, 24, 152, 39);
		this.add(L_add);

		JLabel L_name = new JLabel("       \u540D\u79F0");
		L_name.setFont(new Font("�����п�", Font.BOLD, 16));
		L_name.setBounds(309, 86, 115, 33);
		this.add(L_name);

		tf_name = new JTextField();
		tf_name.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_name.setColumns(10);
		tf_name.setBounds(434, 85, 152, 33);
		this.add(tf_name);

		JLabel L_year = new JLabel("       \u5E74\u5EA6");
		L_year.setFont(new Font("�����п�", Font.BOLD, 16));
		L_year.setBounds(10, 87, 115, 33);
		this.add(L_year);

		tf_year = new JTextField();
		tf_year.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_year.setColumns(10);
		tf_year.setBounds(147, 86, 152, 33);
		this.add(tf_year);

		JLabel L_startDate = new JLabel("    \u5F00\u59CB\u65E5\u671F");
		L_startDate.setFont(new Font("�����п�", Font.BOLD, 16));
		L_startDate.setBounds(10, 141, 115, 33);
		this.add(L_startDate);

		tf_startDate = new JTextField();
		tf_startDate.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_startDate.setColumns(10);
		tf_startDate.setBounds(147, 140, 152, 33);
		this.add(tf_startDate);

		JLabel L_endDate = new JLabel("    \u7ED3\u675F\u65E5\u671F");
		L_endDate.setFont(new Font("�����п�", Font.BOLD, 16));
		L_endDate.setBounds(309, 141, 115, 33);
		this.add(L_endDate);

		tf_endDate = new JTextField();
		tf_endDate.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_endDate.setColumns(10);
		tf_endDate.setBounds(434, 140, 152, 33);
		this.add(tf_endDate);

		btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_update_action(e);
			}
		});
		btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnUpdate.setBounds(147, 407, 152, 33);
		this.add(btnUpdate);

		JLabel L_major = new JLabel("     \u4E13\u4E1A");
		L_major.setFont(new Font("�����п�", Font.BOLD, 16));
		L_major.setBounds(23, 216, 115, 33);
		add(L_major);

		JLabel L_purpose = new JLabel("     \u57F9\u8BAD\u76EE\u7684");
		L_purpose.setFont(new Font("�����п�", Font.BOLD, 16));
		L_purpose.setBounds(164, 216, 115, 33);
		add(L_purpose);

		cbMajor = new JComboBox<Object>();
		String[] majors = { new String("����"), new String("����"),
				new String("��¯"), new String("��ˮ"), new String("ȼ��") };
		cbMajor.setModel(new DefaultComboBoxModel<Object>(majors));
		cbMajor.setFont(new Font("����", Font.PLAIN, 14));
		cbMajor.setBounds(33, 259, 82, 27);
		add(cbMajor);

		ta_purpose = new JTextArea();
		ta_purpose.setBounds(154, 259, 146, 113);
		add(ta_purpose);

		JLabel L_content = new JLabel("     \u57F9\u8BAD\u5185\u5BB9");
		L_content.setFont(new Font("�����п�", Font.BOLD, 16));
		L_content.setBounds(334, 216, 115, 33);
		add(L_content);

		ta_content = new JTextArea();
		ta_content.setBounds(325, 258, 146, 113);
		add(ta_content);

		JLabel L_classcount = new JLabel("     \u8BFE\u65F6");
		L_classcount.setFont(new Font("�����п�", Font.BOLD, 16));
		L_classcount.setBounds(497, 216, 82, 33);
		add(L_classcount);

		tf_classcount = new JTextField();
		tf_classcount.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(501, 256, 76, 33);
		add(tf_classcount);

		tf_teacher = new JTextField();
		tf_teacher.setFont(new Font("���ķ���", Font.PLAIN, 14));
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(501, 339, 76, 33);
		add(tf_teacher);

		JLabel L_teacher = new JLabel("    \u6388\u8BFE\u4EBA");
		L_teacher.setFont(new Font("�����п�", Font.BOLD, 16));
		L_teacher.setBounds(497, 299, 82, 33);
		add(L_teacher);

		btnFind = new JButton("find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_find_action(e);
			}
		});
		btnFind.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnFind.setBounds(434, 183, 152, 33);
		add(btnFind);
		
		btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnDelete.setBounds(325, 407, 152, 33);
		add(btnDelete);
	}

	protected void do_find_action(ActionEvent e) {

	}

	protected void do_update_action(ActionEvent e) {
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
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
					tf_name.setText("");
					tf_year.setText("");
					tf_startDate.setText("");
					tf_endDate.setText("");
					cbMajor.setSelectedItem("����");
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
			JOptionPane.showMessageDialog(null, "��������Ϣ��");
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
}
