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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UpdateTrainingPlan extends JFrame {
	private static UpdateTrainingPlan updateTrainingPlan;
	private TrainingPlanDTO planDTO;
	private PlanItemDTO itemDTO;
	private JPanel contentPane;
	private JTextField tf_startDate;
	private JTextField tf_endDate;
	private JTextField tf_classcount;
	private JTextField tf_teacher;
	private JButton btnUpdate;
	private JComboBox<Object> cbb_Major;
	private JComboBox<Object> cbb_year;
	private JComboBox<Object> cbb_name;
	private JComboBox<Object> cbb_finish;
	private JTextArea ta_purpose;
	private JTextArea ta_content;
	private String train_plan_id;

	public UpdateTrainingPlan() {
		setTitle("修改培训计划");
		setSize(889, 509);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UpdateTrainingPlan.getInstance().dispose();
				UpdateTrainingPlan.setNullInstance();
				// TrainingPlanHome.display();
				TrainingPlanHome.getInstance().do_find_action(null);
			}
		});
		init();
	}

	public void setPlanDTO(TrainingPlanDTO planDTO, PlanItemDTO itemDTO) {
		this.planDTO = planDTO;
		this.itemDTO = itemDTO;
		initData();
	}

	public void setTrain_plan_id(String train_plan_id) {
		this.train_plan_id = train_plan_id;
	}

	private void init() {
		JLabel L_update = new JLabel("\u4FEE\u6539\u57F9\u8BAD\u8BA1\u5212");
		L_update.setFont(new Font("华文楷体", Font.BOLD, 22));
		L_update.setBounds(384, 25, 152, 39);
		contentPane.add(L_update);

		JLabel L_name = new JLabel("       \u540D\u79F0");
		L_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_name.setBounds(504, 86, 115, 33);
		contentPane.add(L_name);

		JLabel L_year = new JLabel("       \u5E74\u5EA6");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(59, 86, 115, 33);
		contentPane.add(L_year);

		JLabel L_startDate = new JLabel("    \u5F00\u59CB\u65E5\u671F");
		L_startDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_startDate.setBounds(59, 141, 115, 33);
		contentPane.add(L_startDate);

		DateChooser dateChooser = DateChooser.getInstance();
		tf_startDate = new JTextField();
		tf_startDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_startDate.setColumns(10);
		tf_startDate.setBounds(200, 142, 176, 33);
		dateChooser.register(tf_startDate);
		contentPane.add(tf_startDate);

		JLabel L_endDate = new JLabel("    \u7ED3\u675F\u65E5\u671F");
		L_endDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_endDate.setBounds(504, 141, 115, 33);
		contentPane.add(L_endDate);

		DateChooser dateChooser2 = DateChooser.getInstance();
		tf_endDate = new JTextField();
		tf_endDate.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_endDate.setColumns(10);
		tf_endDate.setBounds(652, 142, 170, 33);
		dateChooser2.register(tf_endDate);
		contentPane.add(tf_endDate);

		btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_update_action(e);
			}
		});
		btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnUpdate.setBounds(532, 381, 186, 33);
		contentPane.add(btnUpdate);

		cbb_Major = new JComboBox<Object>();
		String[] majors = { new String("电气"), new String("汽机"),
				new String("锅炉"), new String("化水"), new String("燃运") };
		cbb_Major.setModel(new DefaultComboBoxModel<Object>(majors));
		cbb_Major.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_Major.setBounds(76, 299, 82, 27);
		contentPane.add(cbb_Major);

		tf_classcount = new JTextField();
		tf_classcount.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(532, 297, 76, 33);
		contentPane.add(tf_classcount);

		tf_teacher = new JTextField();
		tf_teacher.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(642, 297, 76, 33);
		contentPane.add(tf_teacher);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(45, 197, 777, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel L_major = new JLabel("     \u4E13\u4E1A");
		L_major.setBounds(24, 0, 115, 33);
		panel.add(L_major);
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_purpose = new JLabel("     \u57F9\u8BAD\u76EE\u7684");
		L_purpose.setBounds(149, 0, 115, 33);
		panel.add(L_purpose);
		L_purpose.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_content = new JLabel("     \u57F9\u8BAD\u5185\u5BB9");
		L_content.setBounds(319, 0, 115, 33);
		panel.add(L_content);
		L_content.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_classcount = new JLabel("     \u8BFE\u65F6");
		L_classcount.setBounds(473, 0, 82, 33);
		panel.add(L_classcount);
		L_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_teacher = new JLabel("    \u6388\u8BFE\u4EBA");
		L_teacher.setBounds(581, 0, 82, 33);
		panel.add(L_teacher);
		L_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));

		JLabel L_finish = new JLabel(" 完成情况");
		L_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_finish.setBounds(677, 0, 82, 33);
		panel.add(L_finish);

		JScrollPane sp_purpose = new JScrollPane();
		sp_purpose.setBounds(190, 268, 146, 146);
		contentPane.add(sp_purpose);

		ta_purpose = new JTextArea();
		ta_purpose.setFont(new Font("华文楷体", Font.BOLD, 14));
		sp_purpose.setViewportView(ta_purpose);

		JScrollPane sp_content = new JScrollPane();
		sp_content.setBounds(360, 268, 146, 146);
		contentPane.add(sp_content);

		ta_content = new JTextArea();
		ta_content.setFont(new Font("华文楷体", Font.BOLD, 14));
		sp_content.setViewportView(ta_content);

		String[] years = { "2012", "2013", "2014", "2015", "2016", "2017",
				"2018" };
		cbb_year = new JComboBox<Object>();
		cbb_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_year.setModel(new DefaultComboBoxModel<Object>(years));
//		cbb_year.setEditable(true);
		cbb_year.setBounds(200, 87, 176, 33);
		contentPane.add(cbb_year);

		String[] names = { "新员工入厂培训", "中层管理人员培训", "班组长培训" };
		cbb_name = new JComboBox<Object>();
		cbb_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_name.setModel(new DefaultComboBoxModel<Object>(names));
		cbb_name.setBounds(652, 86, 170, 33);
		contentPane.add(cbb_name);

		String[] finish = { "未培训", "培训中", "已培训" };
		cbb_finish = new JComboBox<Object>();
		cbb_finish.setModel(new DefaultComboBoxModel<Object>(finish));
		cbb_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_finish.setBounds(740, 299, 82, 27);
		contentPane.add(cbb_finish);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UpdateTrainingPlan.this.dispose();
				TrainingPlanHome.getInstance().setClickCount(-1);
			}
		});
	}

	private void initData() {
		/* 设置train_plan_info属性 */
		this.setTrain_plan_id(planDTO.getTrain_plan_id());
		cbb_year.setSelectedItem(planDTO.getTrain_plan_year());
		cbb_name.setSelectedItem(planDTO.getTrain_plan_name());
		tf_startDate.setText(planDTO.getStart_time().toString());
		tf_endDate.setText(planDTO.getEnd_time().toString());
		cbb_finish.setSelectedItem(planDTO.getIs_finish());

		/* 设置train_plan_item属性 */
		cbb_Major.setSelectedItem(itemDTO.getZy_name());
		ta_purpose.setText(itemDTO.getTrain_purpose());
		ta_content.setText(itemDTO.getTrain_content());
		tf_classcount.setText(itemDTO.getClass_count());
		tf_teacher.setText(itemDTO.getTeacher());
	}

	protected void do_update_action(ActionEvent e) {
		Object[] params = new Object[10];
		params[0] = cbb_year.getSelectedItem();
		params[1] = cbb_name.getSelectedItem();
		params[2] = tf_startDate.getText().trim();
		params[3] = tf_endDate.getText().trim();
		params[4] = cbb_Major.getSelectedItem();
		params[5] = ta_purpose.getText().trim();
		params[6] = ta_content.getText().trim();
		params[7] = tf_classcount.getText().trim();
		params[8] = tf_teacher.getText().trim();
		params[9] = cbb_finish.getSelectedItem();

		boolean[] result = validateTrainPlan(params);

		if (result[0]) {
			if (result[1]) {
				/* 设置train_plan_info属性值 */
				TrainingPlanDTO planDTO = new TrainingPlanDTO();
				planDTO.setTrain_plan_year((String) params[0]);
				planDTO.setTrain_plan_name((String) params[1]);
				planDTO.setTrain_plan_type((String) params[1]);
				planDTO.setStart_time(CommonUtil.getSqlDate(params[2]));
				planDTO.setEnd_time(CommonUtil.getSqlDate(params[3]));
				planDTO.setIs_finish((String) params[9]);
				planDTO.setTrain_plan_id(train_plan_id);
				/* train_plan_info属性值设置完毕 */

				/* train_plan_item属性值设置完毕 */
				PlanItemDTO itemDTO = new PlanItemDTO();
				itemDTO.setTrain_plan_id(train_plan_id);
				itemDTO.setZy_dic_id(new PlanItem().getPlanItem(train_plan_id)
						.getZy_dic_id());
				itemDTO.setZy_name((String) params[4]);
				itemDTO.setTrain_purpose((String) params[5]);
				itemDTO.setTrain_content((String) params[6]);
				itemDTO.setClass_count((String) params[7]);
				itemDTO.setTeacher((String) params[8]);
				/* train_plan_item属性值设置完毕 */

				boolean[] success = { false, false };
				success[0] = new PlanItem().updatePlanItem(itemDTO);
				success[1] = new TrainingPlan().updateTrainingPlan(planDTO);
				if (success[0] && success[1]) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					UpdateTrainingPlan.getInstance().dispose();
					UpdateTrainingPlan.setNullInstance();
					// TrainingPlanHome.display();
					TrainingPlanHome.getInstance().setClickCount(-1);
					TrainingPlanHome.getInstance().do_find_action(null);

				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}

			} else {
				JOptionPane.showMessageDialog(null, "输入格式有误！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "请完善信息！");
		}
	}

	private boolean[] validateTrainPlan(Object... params) {
		boolean[] result = { true, true };

		for (int i = 0; i < params.length; i++) {
			if (result[0] && "".equals(params[i])) {
				result[0] = false;
			}
			if (result[1] && "1".equals(params[i])) {
				result[1] = false;
			}
		}

		if (!ValidateUtil.validateTimeFormat((String) params[2])
				|| !ValidateUtil.validateTimeFormat((String) params[3])) {
			result[1] = false;
		}
		return result;
	}

	private static void setNullInstance() {
		if (updateTrainingPlan != null) {
			updateTrainingPlan = null;
		}
	}

	public static void display() {
		if (updateTrainingPlan == null) {
			updateTrainingPlan = new UpdateTrainingPlan();
		}
		updateTrainingPlan.setVisible(true);
		updateTrainingPlan.setResizable(false);
	}

	public static UpdateTrainingPlan getInstance() {
		return updateTrainingPlan;
	}

	public static void main(String[] args) {
		UpdateTrainingPlan.display();
	}
}