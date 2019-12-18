package com.view.trainingPlan;

import com.train.dto.PlanItemDTO;
import com.train.dto.TrainingPlanDTO;
import com.train.service.PlanItem;
import com.train.service.TrainingPlan;
import com.util.tool.CommonUtil;
import com.util.tool.DateChooser;
import com.util.tool.ValidateUtil;
import com.util.tool.WindowUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class AddTrainingPlan extends JFrame {
	private static AddTrainingPlan addTrainingPlan;
	private JPanel contentPane;
	private JTextField tf_startDate;
	private JTextField tf_endDate;
	private JTextField tf_classcount;
	private JButton btnLogin;
	private JComboBox<Object> cbMajor;
	private JComboBox<Object> cbb_finish;
	private JComboBox<Object> cbb_name;
	private JComboBox<Object> cbb_year;
	private JTextArea ta_purpose;
	private JTextArea ta_content;
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
		setBounds(100, 100, 836, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.cyan);
		setContentPane(contentPane);

		JLabel L_add = new JLabel("添加培训计划");
		L_add.setFont(new Font("华文楷体", Font.BOLD, 26));
		L_add.setBounds(334, 27, 182, 39);
		contentPane.add(L_add);

		JLabel L_name = new JLabel("       \u540D\u79F0");
		L_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_name.setBounds(452, 86, 115, 33);
		contentPane.add(L_name);

		JLabel L_year = new JLabel("       \u5E74\u5EA6");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(33, 86, 115, 33);
		contentPane.add(L_year);

		JLabel L_startDate = new JLabel("    \u5F00\u59CB\u65E5\u671F");
		L_startDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_startDate.setBounds(33, 141, 115, 33);
		contentPane.add(L_startDate);

		DateChooser dateChooser = DateChooser.getInstance();
		tf_startDate = new JTextField();
		tf_startDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_startDate.setColumns(10);
		tf_startDate.setBounds(182, 142, 173, 33);
		dateChooser.register(tf_startDate);
		contentPane.add(tf_startDate);

		JLabel L_endDate = new JLabel("    \u7ED3\u675F\u65E5\u671F");
		L_endDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_endDate.setBounds(452, 141, 115, 33);
		contentPane.add(L_endDate);

		DateChooser dateChooser2 = DateChooser.getInstance();
		tf_endDate = new JTextField();
		tf_endDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_endDate.setColumns(10);
		tf_endDate.setBounds(614, 142, 168, 33);
		dateChooser2.register(tf_endDate);
		contentPane.add(tf_endDate);

		btnLogin = new JButton("submit");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_submit_action(e);
			}
		});
		btnLogin.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLogin.setBounds(364, 437, 152, 33);
		contentPane.add(btnLogin);

		cbMajor = new JComboBox<Object>();
		String[] majors = { new String("电气"), new String("汽机"),
				new String("锅炉"), new String("化水"), new String("燃运") };
		cbMajor.setModel(new DefaultComboBoxModel<Object>(majors));
		cbMajor.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbMajor.setBounds(33, 296, 82, 27);
		contentPane.add(cbMajor);

		tf_classcount = new JTextField();
		tf_classcount.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(503, 296, 76, 33);
		contentPane.add(tf_classcount);

		tf_teacher = new JTextField();
		tf_teacher.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(601, 296, 76, 33);
		contentPane.add(tf_teacher);

		btn_back = new JButton("back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_back_action(e);
			}
		});
		btn_back.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btn_back.setBounds(585, 437, 152, 33);
		contentPane.add(btn_back);

		btn_reset = new JButton("reset");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btn_reset.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btn_reset.setBounds(141, 437, 152, 33);
		contentPane.add(btn_reset);

		JPanel tipPane = new JPanel();
		tipPane.setBackground(Color.LIGHT_GRAY);
		tipPane.setBounds(33, 205, 761, 44);
		contentPane.add(tipPane);
		tipPane.setLayout(null);

		JLabel L_major = new JLabel("     \u4E13\u4E1A");
		L_major.setBounds(10, 10, 92, 21);
		tipPane.add(L_major);
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_purpose = new JLabel("     \u57F9\u8BAD\u76EE\u7684");
		L_purpose.setBounds(131, 4, 115, 33);
		tipPane.add(L_purpose);
		L_purpose.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_content = new JLabel("     \u57F9\u8BAD\u5185\u5BB9");
		L_content.setBounds(306, 4, 115, 33);
		tipPane.add(L_content);
		L_content.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_classcount = new JLabel("     \u8BFE\u65F6");
		L_classcount.setBounds(468, 4, 82, 33);
		tipPane.add(L_classcount);
		L_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_teacher = new JLabel("    \u6388\u8BFE\u4EBA");
		L_teacher.setBounds(551, 4, 82, 33);
		tipPane.add(L_teacher);
		L_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_finish = new JLabel("完成情况");
		L_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_finish.setBounds(667, 4, 82, 33);
		tipPane.add(L_finish);

		String[] finish = { "未培训", "培训中", "已培训" };
		cbb_finish = new JComboBox<Object>();
		cbb_finish.setModel(new DefaultComboBoxModel<Object>(finish));
		cbb_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_finish.setBounds(700, 298, 82, 27);
		contentPane.add(cbb_finish);

		JScrollPane spcontent = new JScrollPane();
		spcontent
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spcontent.setBounds(334, 262, 146, 145);
		contentPane.add(spcontent);

		ta_content = new JTextArea();
		ta_content.setLineWrap(true);
		spcontent.setViewportView(ta_content);
		ta_content.setFont(new Font("华文楷体", Font.BOLD, 14));

		JScrollPane sp_purpose = new JScrollPane();
		sp_purpose
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp_purpose.setBounds(160, 262, 146, 145);
		contentPane.add(sp_purpose);

		ta_purpose = new JTextArea();
		ta_purpose.setLineWrap(true);
		sp_purpose.setViewportView(ta_purpose);
		ta_purpose.setFont(new Font("华文楷体", Font.BOLD, 14));

		String[] names = { "新员工入厂培训", "中层管理人员培训", "班组长培训" };
		cbb_name = new JComboBox<Object>();
		cbb_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_name.setModel(new DefaultComboBoxModel<Object>(names));
		cbb_name.setBounds(614, 86, 168, 33);
		contentPane.add(cbb_name);

		String[] years = { "2012", "2013", "2014", "2015", "2016", "2017",
				"2018" };
		cbb_year = new JComboBox<Object>();
		cbb_year.setModel(new DefaultComboBoxModel<Object>(years));
		cbb_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_year.setBounds(182, 87, 173, 33);
		contentPane.add(cbb_year);

		setResizable(false);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				AddTrainingPlan.getInstance().dispose();
				AddTrainingPlan.setNullInstance();
//				TrainingPlanHome.display();
//				TrainingPlanHome.getInstance().do_find_action(null);
			}
		});
	}

	protected void do_back_action(ActionEvent e) {
		AddTrainingPlan.getInstance().dispose();
		AddTrainingPlan.setNullInstance();
//		TrainingPlanHome.display();
	}

	protected void do_submit_action(ActionEvent e) {
		Object[] params = new Object[10];
		params[0] = cbb_name.getSelectedItem();
		params[1] = cbb_year.getSelectedItem();
		params[2] = tf_startDate.getText().trim();
		params[3] = tf_endDate.getText().trim();
		params[4] = cbMajor.getSelectedItem();
		params[5] = ta_purpose.getText().trim();
		params[6] = ta_content.getText().trim();
		params[7] = tf_classcount.getText().trim();
		params[8] = tf_teacher.getText().trim();
		params[9] = cbb_finish.getSelectedItem();

		if (validateTrainPlan(params)) {
			/* 设置TrainingPlanDTO的值 */
			TrainingPlanDTO plan = new TrainingPlanDTO();
			plan.setTrain_plan_id(CommonUtil.getId());
			plan.setTrain_plan_name((String) params[0]);
			plan.setTrain_plan_year((String) params[1]);

			plan.setStart_time(CommonUtil.getSqlDate(params[2]));
			plan.setEnd_time(CommonUtil.getSqlDate(params[3]));
			plan.setIs_finish((String) params[9]);
			/* TrainingPlanDTO的值设置完毕 */

			/* 设置PlanItemDTO的值 */
			PlanItemDTO item = new PlanItemDTO();
			item.setTrain_plan_id(plan.getTrain_plan_id());
			item.setZy_name((String) params[4]);
			item.setTrain_purpose((String) params[5]);
			item.setTrain_content((String) params[6]);
			item.setClass_count((String) params[7]);
			item.setTeacher((String) params[8]);
			/* PlanItemDTO的值设置完毕 */

			boolean result = false;
			boolean[] success = { false, false };
			success[0] = new TrainingPlan().saveTrainingPlan(plan);
			if (success[0]) {
				success[1] = new PlanItem().savePlanItem(item);
				if (success[1]) {
					result = true;
				}
			}
			if (result) {
				JOptionPane.showMessageDialog(null, "数据保存成功！");
				clear();
			}

		} else {
			JOptionPane.showMessageDialog(null, "信息残缺或信息输入格式有误！");
		}
	}

	public boolean validateTrainPlan(Object... params) {
		boolean result = true;

		for (int i = 0; i < params.length; i++) {
			if ("".equals(params[i]) || "1".equals(params[i])) {
				result = false;
			}
		}
		result = ValidateUtil.validateTimeFormat((String) params[2]);
		result = ValidateUtil.validateTimeFormat((String) params[3]);
		return result;
	}

	/* 针对数据输入区进行复原 */
	private void clear() {
		cbb_name.setSelectedIndex(0);
		cbb_year.setSelectedItem(0);
		tf_startDate.setText("");
		tf_endDate.setText("");
		cbMajor.setSelectedIndex(0);
		ta_purpose.setText("");
		ta_content.setText("");
		tf_classcount.setText("");
		tf_teacher.setText("");
		cbb_finish.setSelectedIndex(0);
	}

	public static void display() {
		if (addTrainingPlan == null) {
			addTrainingPlan = new AddTrainingPlan();
		}
		addTrainingPlan.setVisible(true);
		addTrainingPlan.setResizable(false);
	}

	private static void setNullInstance() {
		if (addTrainingPlan != null) {
			addTrainingPlan = null;
		}
	}

	public static AddTrainingPlan getInstance() {
		return addTrainingPlan;
	}
}
