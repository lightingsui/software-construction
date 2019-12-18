package com.view.trainingPlan;

import com.train.dto.PlanItemDTO;
import com.train.dto.TrainingPlanDTO;
import com.train.service.PlanItem;
import com.train.service.TrainEmp;
import com.train.service.TrainingPlan;
import com.util.tool.CommonUtil;
import com.util.tool.WindowUtil;
import com.view.empArrange.TrainingPlanDisplay;
import com.view.home.TrainMainFrame;
import com.view.resultManage.TrainResultManage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.*;

@SuppressWarnings("serial")
public class TrainingPlanHome extends JFrame {
	private static TrainingPlanHome trainPlanHome;
	private JPanel contentPane;
	private JPanel selectPane;
	private JScrollPane scrollPane;
	private JTable resultTable;
	private DefaultTableModel model;
	private JComboBox<Object> cbb_year;
	private JComboBox<Object> cbb_major;
	private JComboBox<Object> cbb_type;
	private JComboBox<Object> cbb_finish;
	private JLabel L_current_time;
	private JButton btnScore;
	private JLabel L_train_plan_num;
	private int clickCount = -1;
	private String time;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingPlanHome.display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private TrainingPlanHome() {
		setBackground(Color.WHITE);
		setTitle("培训计划管理");
		setSize(WindowUtil.getAllScreen());
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		selectPane = new JPanel();
		selectPane.setBackground(Color.cyan);
		selectPane
				.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"),
						"\u67E5\u8BE2\u6761\u4EF6", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		selectPane.setBounds(35, 10, 1300, 103);
		contentPane.add(selectPane);
		selectPane.setLayout(null);

		String[] years = new String[] { "", "2012", "2013", "2014", "2015",
				"2016", "2017", "2018" };
		cbb_year = new JComboBox<Object>();
		cbb_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_year.setModel(new DefaultComboBoxModel<Object>(years));
		cbb_year.setBounds(318, 25, 161, 21);
		selectPane.add(cbb_year);

		JLabel L_year = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(172, 25, 122, 21);
		selectPane.add(L_year);

		JButton btnFind = new JButton("find");
		btnFind.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_find_action(e);
			}
		});
		btnFind.setBounds(1129, 46, 93, 23);
		selectPane.add(btnFind);

		JLabel L_major = new JLabel("\u57F9\u8BAD\u4E13\u4E1A");
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_major.setBounds(708, 25, 77, 21);
		selectPane.add(L_major);

		String[] majors = new String[] { "", "电气", "汽机", "锅炉", "化水", "燃运" };
		cbb_major = new JComboBox<Object>();
		cbb_major.setModel(new DefaultComboBoxModel<Object>(majors));
		cbb_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_major.setBounds(839, 25, 161, 21);
		selectPane.add(cbb_major);

		JLabel L_type = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B");
		L_type.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_type.setBounds(172, 60, 122, 21);
		selectPane.add(L_type);

		String[] types = new String[] { "", "新员工入厂培训", "中层管理人员培训", "班组长培训" };
		cbb_type = new JComboBox<Object>();
		cbb_type.setModel(new DefaultComboBoxModel<Object>(types));
		cbb_type.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_type.setBounds(318, 60, 161, 21);
		selectPane.add(cbb_type);

		JLabel L_finish = new JLabel("\u5B8C\u6210\u60C5\u51B5");
		L_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_finish.setBounds(708, 60, 77, 21);
		selectPane.add(L_finish);

		String[] finishes = new String[] { "", "未培训", "培训中", "已培训" };
		cbb_finish = new JComboBox<Object>();
		cbb_finish.setModel(new DefaultComboBoxModel<Object>(finishes));
		cbb_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_finish.setBounds(839, 60, 161, 21);
		selectPane.add(cbb_finish);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(35, 185, 1300, 424);
		contentPane.add(scrollPane);

		resultTable = new JTable();
		model = new DefaultTableModel();
		String[] tableHeaders = { "培训计划编号", "培训计划主题编号", "序号", "年度", "培训计划名称",
				"培训专业", "培训目的", "培训内容", "培训时间", "培训人数", "完成情况" };
		model.setColumnIdentifiers(tableHeaders);
		resultTable.setModel(model);

		setTableCellRenderer();

		resultTable.setAutoscrolls(true);
		resultTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_mouseClick_action(e);
			}
		});
		resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		resultTable.setRowHeight(30);
		resultTable.setFont(new Font("华文楷体", Font.BOLD, 16));
		scrollPane.setViewportView(resultTable);

		JButton btn_add = new JButton("create");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_add_action(e);
			}
		});
		btn_add.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_add.setBounds(893, 123, 93, 23);
		contentPane.add(btn_add);

		JButton btn_update = new JButton("update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_update_action(e);
			}
		});
		btn_update.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_update.setBounds(1030, 123, 93, 23);
		contentPane.add(btn_update);

		JButton btn_delete = new JButton("delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_delete_action(e);
			}
		});
		btn_delete.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_delete.setBounds(1163, 123, 93, 23);
		contentPane.add(btn_delete);

		JButton btn_next = new JButton("next");
		btn_next.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_next.setBounds(679, 648, 105, 23);
		contentPane.add(btn_next);

		JButton btn_end = new JButton("last");
		btn_end.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_end.setBounds(826, 648, 93, 23);
		contentPane.add(btn_end);

		JButton btn_first = new JButton("first");
		btn_first.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_first.setBounds(397, 648, 93, 23);
		contentPane.add(btn_first);

		JButton btn_previous = new JButton("previous");
		btn_previous.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_previous.setBounds(531, 648, 105, 23);
		contentPane.add(btn_previous);

		JButton btnreFresh = new JButton("refresh");
		btnreFresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_find_action(e);
			}
		});
		btnreFresh.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnreFresh.setBounds(758, 123, 93, 23);
		contentPane.add(btnreFresh);

		btnScore = new JButton("score");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_score_action(e);
			}
		});
		btnScore.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnScore.setBounds(620, 123, 93, 23);
		btnScore.setEnabled(false);
		contentPane.add(btnScore);

		JLabel lblNewLabel = new JLabel("Copyright@Sui");
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 16));
		lblNewLabel.setBounds(584, 681, 151, 33);
		contentPane.add(lblNewLabel);

		JLabel L_train_plan = new JLabel("培训计划：");
		L_train_plan.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_train_plan.setBounds(57, 128, 85, 33);
		contentPane.add(L_train_plan);

		L_train_plan_num = new JLabel("");
		L_train_plan_num.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_train_plan_num.setBounds(152, 128, 48, 33);
		contentPane.add(L_train_plan_num);

		JLabel L_train_plan_tip = new JLabel("条");
		L_train_plan_tip.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_train_plan_tip.setBounds(210, 128, 48, 33);
		contentPane.add(L_train_plan_tip);

		L_current_time = new JLabel("");
		L_current_time.setHorizontalAlignment(SwingConstants.CENTER);
		L_current_time.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_current_time.setBounds(317, 128, 244, 33);
		contentPane.add(L_current_time);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				time = dateFormatter.format(Calendar.getInstance().getTime());
				L_current_time.setText(time);
			}
		}, 0, 1000);

		setResizable(false);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					TrainingPlanHome.getInstance().dispose();
				} catch (Exception ex) {
					// 此处不作响应处理
				}
				TrainingPlanHome.setNullInstance();
				TrainMainFrame.display();
			}
		});
	}

	public JButton getBtnScore() {
		return btnScore;
	}

	protected void do_score_action(ActionEvent e) {
		try {
			if (clickCount >= 0) {
				String train_plan_id = (String) model.getValueAt(clickCount, 0);
				// String train_item_id = (String) model.getValueAt(clickCount,
				// 1);

				/* 获取培训计划信息 */
				String train_plan_name = (String) model.getValueAt(clickCount,
						3);
				String train_plan_year = (String) model.getValueAt(clickCount,
						4);
				String time = (String) model.getValueAt(clickCount, 8);
				String[] arry_time = time.split("/");
				TrainingPlanDTO planDTO = new TrainingPlanDTO(train_plan_name,
						train_plan_year, CommonUtil.getSqlDate(arry_time[0]),
						CommonUtil.getSqlDate(arry_time[1]));
				planDTO.setTrain_plan_id(train_plan_id);
				/* 获取培训计划主题信息 */
				PlanItemDTO itemDTO = new PlanItem().getPlanItem(train_plan_id);
				TrainResultManage.display();
				TrainResultManage.getInstance().setDTO(planDTO, itemDTO);
			} else {
				JOptionPane.showMessageDialog(null, "请先选中要查看成绩的记录!");
			}
		} catch (Exception ex) {
			// 此处异常不再进行相应处理
		}
	}

	private void do_display_action(ActionEvent e) {
		if (clickCount >= 0) {
			String train_plan_id = (String) model.getValueAt(clickCount, 0);
			// String train_item_id = (String) model.getValueAt(clickCount, 1);
			String finish = (String) model.getValueAt(clickCount, 10);

			/* 判断该培训计划是否为未培训状态 */
			if ("未培训".equals(finish)) { // 未培训状态才能够安排学员

				/* 获取培训计划信息 */
				String train_plan_name = (String) model.getValueAt(clickCount,
						3);
				String train_plan_year = (String) model.getValueAt(clickCount,
						4);
				String time = (String) model.getValueAt(clickCount, 8);
				String[] arry_time = time.split("/");
				TrainingPlanDTO planDTO = new TrainingPlanDTO(train_plan_name,
						train_plan_year, CommonUtil.getSqlDate(arry_time[0]),
						CommonUtil.getSqlDate(arry_time[1]));
				planDTO.setTrain_plan_id(train_plan_id);
				/* 获取培训计划主题信息 */
				PlanItemDTO itemDTO = new PlanItem().getPlanItem(train_plan_id);
				TrainingPlanDisplay.display();
				TrainingPlanDisplay.getInstance().setDTO(planDTO, itemDTO);
			} else if ("培训中".equals(finish)) {
				JOptionPane.showMessageDialog(null, "该培训计划正在培训中,\n不能安培学员！");
			} else if ("已培训".equals(finish)) {
				JOptionPane.showMessageDialog(null, "该培训计划已培训,\n不能安培学员！");
			}
		}
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	private void setTableCellRenderer() {
		/* 设置表格数据居中显示 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		resultTable.setDefaultRenderer(Object.class, renderer);
		/* 把'培训计划编号'和'培训计划主题编号'属性列隐藏掉 */
		TableColumn planIdColumn = resultTable.getColumnModel().getColumn(0);
		TableColumn planItemColumn = resultTable.getColumnModel().getColumn(1);

		planIdColumn.setMaxWidth(0);
		planIdColumn.setMinWidth(0);
		planIdColumn.setPreferredWidth(0);
		planIdColumn.setResizable(false);

		planItemColumn.setMaxWidth(0);
		planItemColumn.setMinWidth(0);
		planItemColumn.setPreferredWidth(0);
		planItemColumn.setResizable(false);
		/* '培训计划编号'和'培训计划主题编号'属性列隐藏操作完成 */

		TableColumn numColumn = resultTable.getColumnModel().getColumn(2);
		numColumn.setPreferredWidth(1);
		numColumn.setResizable(false);
		TableColumn yearColumn = resultTable.getColumnModel().getColumn(3);
		yearColumn.setPreferredWidth(2);
		TableColumn finishColumn = resultTable.getColumnModel().getColumn(9);
		finishColumn.setPreferredWidth(1);

		/* 设置表头不能移动 */
		resultTable.getTableHeader().setReorderingAllowed(false);
		// resultTable .getTableHeader().setResizingAllowed(false);

		/* 设置表格信息不能编辑 */
		// resultTable.setEnabled(false);
	}

	protected void do_mouseClick_action(MouseEvent e) {
		try {
			clickCount = resultTable.getSelectedRow();
			if (e.getClickCount() == 2) {
				do_display_action(null);
			}
			String finish = (String) model.getValueAt(clickCount, 10);
			if ("已培训".equals(finish)) {
				btnScore.setEnabled(true);
			} else {
				btnScore.setEnabled(false);
			}
		} catch (Exception ex) {

		}
	}

	protected void do_find_action(ActionEvent e) {
		Object[] params = new Object[3];
		params[0] = cbb_year.getSelectedItem();
		params[1] = cbb_type.getSelectedItem();
		params[2] = cbb_finish.getSelectedItem();
		String obj_major = (String) cbb_major.getSelectedItem();

		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		List<TrainingPlanDTO> allPlan = null;
		/* 获取全部培训计划信息 */
		allPlan = new TrainingPlan().getAllTrainingPlan(params);

		int k = 0;

		java.util.Iterator<TrainingPlanDTO> iter = allPlan.iterator();
		while (iter.hasNext()) {
			TrainingPlanDTO plan = (TrainingPlanDTO) iter.next();

			Vector<Object> v_item = new Vector<Object>();
			/* 通过一对一关系查询培训计划主题信息 */

			PlanItemDTO item = new PlanItem().getPlanItem(
					plan.getTrain_plan_id(), obj_major);

			if (item != null) {
				/* 设置隐藏的列信息 */
				v_item.add(item.getTrain_plan_id());
				v_item.add(item.getPlan_item_id());
				/* 列信息设置完毕 */
				v_item.add(new Integer(++k));
				v_item.add(plan.getTrain_plan_year());
				v_item.add(plan.getTrain_plan_name());
				v_item.add(item.getZy_name());
				v_item.add(item.getTrain_purpose());
				v_item.add(item.getTrain_content());
				String train_time = new String(plan.getStart_time() + "/"
						+ plan.getEnd_time());
				v_item.add(train_time);
				/* 统计培训人数 */
				Integer numOfPerson = new TrainEmp().countNumOfEmp(item
						.getPlan_item_id());
				if (numOfPerson == 0) {
					v_item.add(new String("未安排"));
				} else {
					v_item.add(numOfPerson);
				}
				/* 培训人数统计完毕 */
				v_item.add(plan.getIs_finish());
				results.add(v_item);
			}
		}
		if (this.model.getRowCount() != 0) {
			this.model.setRowCount(0);
		}
		for (Vector<Object> result : results) {
			this.model.addRow(result);
		}
		L_train_plan_num.setText(this.model.getRowCount() + "");
	}

	public boolean[] validatetPlan(Object... params) {
		boolean[] result = { true, true };

		for (int i = 0; i < params.length; i++) {
			if ("1".equals(params[i])) {
				result[0] = false;
			}
		}
		return result;
	}

	protected void do_delete_action(ActionEvent e) {
		if (clickCount >= 0) {
			int result = JOptionPane.showConfirmDialog(null, "确定删除？");

			if (result == JOptionPane.OK_OPTION) {
				boolean[] success = { true, true };
				String train_plan_id = (String) model.getValueAt(clickCount, 0);
				String plan_item_id = (String) model.getValueAt(clickCount, 1);

				success[0] = new PlanItem().deletePlanItem(plan_item_id);
				success[1] = new TrainingPlan()
						.deleteTrainingPlan(train_plan_id);
				// System.out.println(success[0] + "---" + success[1]);
				if (success[0] && success[1]) {
					this.model.removeRow(clickCount);
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
					return;
				}

				/* 重新加载编号 */
				for (int i = 0; i < model.getRowCount(); i++) {
					model.setValueAt(new Integer(i + 1), i, 2);
				}
				L_train_plan_num.setText(this.model.getRowCount() + "");
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "请先选中要删除的记录！");
		}
	}

	protected void do_update_action(ActionEvent e) {
		if (clickCount >= 0) {
			int count = model.getColumnCount();
			Object[] params = new Object[count];
			for (int i = 0; i < model.getColumnCount(); i++) {
				params[i] = this.model.getValueAt(clickCount, i);
			}

			/* 设置培训计划对象属性值 ,用于在修改信息窗体内的信息显示 */
			TrainingPlanDTO trainingPlanDTO = new TrainingPlanDTO();
			trainingPlanDTO.setTrain_plan_id((String) params[0]);
			trainingPlanDTO.setTrain_plan_year((String) params[3]);
			trainingPlanDTO.setTrain_plan_name((String) params[4]);
			trainingPlanDTO.setTrain_plan_type((String) params[4]);
			String time = (String) params[8];
			String[] _time = time.split("/");
			trainingPlanDTO.setStart_time(CommonUtil.getSqlDate(_time[0]));
			trainingPlanDTO.setEnd_time(CommonUtil.getSqlDate(_time[1]));
			trainingPlanDTO.setIs_finish((String) params[count - 1]);
			/* 培训计划对象属性值设置完毕 */

			/* 设置培训计划主题对象属性值,用于在修改信息窗体内的信息显示 */
			PlanItemDTO planItemDTO = new PlanItem()
					.getPlanItem(trainingPlanDTO.getTrain_plan_id());
			// planItemDTO.setPlan_item_id((String) params[1]);
			// planItemDTO.setZy_name((String) params[5]);
			// planItemDTO.setTrain_purpose((String) params[6]);
			// planItemDTO.setTrain_content((String) params[7]);
			/* 培训计划主题对象属性值设置完毕 */

			// TrainingPlanHome.getInstance().setVisible(false);
			UpdateTrainingPlan.display();
			UpdateTrainingPlan.getInstance().setPlanDTO(trainingPlanDTO,
					planItemDTO);
		} else {
			JOptionPane.showMessageDialog(null, "请先选中要修改的记录！");
		}
	}

	protected void do_add_action(ActionEvent e) {
		// TrainingPlanHome.getInstance().setVisible(false);
		// TrainingPlanHome.setNullInstance();
		AddTrainingPlan.display();
	}

	public void callFunction(String method) {
		try {
			if ("find".equals(method)) {
				do_find_action(null);
			}
		} catch (Exception ex) {

		}
	}

	public static void display() {
		if (trainPlanHome == null) {
			trainPlanHome = new TrainingPlanHome();
		}
		trainPlanHome.setVisible(true);
		trainPlanHome.setResizable(false);
	}

	private static void setNullInstance() {
		if (trainPlanHome != null) {
			trainPlanHome = null;
		}
	}

	public static TrainingPlanHome getInstance() {
		return trainPlanHome;
	}
}
