package com.view.resultManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.train.dto.PlanItemDTO;
import com.train.dto.TrainResultDTO;
import com.train.dto.TrainingPlanDTO;
import com.train.dto.UserDTO;
import com.train.service.Department;
import com.train.service.TrainEmp;
import com.train.service.TrainResult;
import com.train.service.User;
import com.util.tool.WindowUtil;
import com.view.trainingPlan.TrainingPlanHome;

@SuppressWarnings("serial")
public class TrainResultManage extends JFrame {

	private JPanel contentPane;
	private JTextField tf_year;
	private JTextField tf_major;
	private JTextField tf_name;
	private JTextField tf_classcount;
	private JTextField tf_time;
	private JTextField tf_teacher;
	private JTable resultTable;
	private DefaultTableModel resultModel;
	private JLabel L_trainEmpNum;
	private static TrainResultManage trainResultManage;
	private int clickCount = -1;
	private TrainingPlanDTO planDTO;
	private PlanItemDTO itemDTO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainResultManage frame = new TrainResultManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TrainResultManage() {
		setTitle("培训成绩管理");
		setBounds(100, 100, 894, 479);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel baseInfoPane = new JPanel();
		baseInfoPane.setBounds(10, 10, 858, 91);
		contentPane.add(baseInfoPane);
		baseInfoPane.setLayout(null);

		JPanel infoPane1 = new JPanel();
		infoPane1.setBackground(Color.LIGHT_GRAY);
		infoPane1.setBounds(0, 0, 98, 91);
		baseInfoPane.add(infoPane1);
		infoPane1.setLayout(null);

		JLabel L_year = new JLabel("    年度");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(10, 5, 78, 35);
		infoPane1.add(L_year);

		JLabel L_major = new JLabel("    专业");
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_major.setBounds(10, 46, 78, 35);
		infoPane1.add(L_major);

		JPanel infoPane2 = new JPanel();
		infoPane2.setLayout(null);
		infoPane2.setBackground(Color.LIGHT_GRAY);
		infoPane2.setBounds(281, 0, 98, 91);
		baseInfoPane.add(infoPane2);

		JLabel L_name = new JLabel("    名称");
		L_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_name.setBounds(10, 5, 78, 35);
		infoPane2.add(L_name);

		JLabel L_classcount = new JLabel("    课时");
		L_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_classcount.setBounds(10, 46, 78, 35);
		infoPane2.add(L_classcount);

		tf_year = new JTextField();
		tf_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_year.setHorizontalAlignment(SwingConstants.CENTER);
		tf_year.setEditable(false);
		tf_year.setBounds(98, 0, 183, 45);
		baseInfoPane.add(tf_year);
		tf_year.setColumns(10);

		tf_major = new JTextField();
		tf_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_major.setHorizontalAlignment(SwingConstants.CENTER);
		tf_major.setEditable(false);
		tf_major.setColumns(10);
		tf_major.setBounds(98, 45, 183, 46);
		baseInfoPane.add(tf_major);

		tf_name = new JTextField();
		tf_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setEditable(false);
		tf_name.setColumns(10);
		tf_name.setBounds(379, 0, 183, 45);
		baseInfoPane.add(tf_name);

		tf_classcount = new JTextField();
		tf_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_classcount.setHorizontalAlignment(SwingConstants.CENTER);
		tf_classcount.setEditable(false);
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(379, 45, 183, 46);
		baseInfoPane.add(tf_classcount);

		JPanel infoPane3 = new JPanel();
		infoPane3.setLayout(null);
		infoPane3.setBackground(Color.LIGHT_GRAY);
		infoPane3.setBounds(562, 0, 98, 91);
		baseInfoPane.add(infoPane3);

		JLabel L_time = new JLabel("    时间");
		L_time.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_time.setBounds(10, 5, 78, 35);
		infoPane3.add(L_time);

		JLabel L_teacher = new JLabel("   授课人");
		L_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_teacher.setBounds(10, 46, 78, 35);
		infoPane3.add(L_teacher);

		tf_time = new JTextField();
		tf_time.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_time.setHorizontalAlignment(SwingConstants.CENTER);
		tf_time.setEditable(false);
		tf_time.setColumns(10);
		tf_time.setBounds(660, 0, 198, 45);
		baseInfoPane.add(tf_time);

		tf_teacher = new JTextField();
		tf_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_teacher.setHorizontalAlignment(SwingConstants.CENTER);
		tf_teacher.setEditable(false);
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(660, 45, 198, 46);
		baseInfoPane.add(tf_teacher);

		JPanel showPane = new JPanel();
		showPane.setBounds(10, 111, 858, 320);
		contentPane.add(showPane);
		showPane.setLayout(null);

		JPanel resultTipPane = new JPanel();
		resultTipPane.setBounds(0, 0, 858, 61);
		showPane.add(resultTipPane);
		resultTipPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("参加培训人数：");
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 105, 41);
		resultTipPane.add(lblNewLabel);

		L_trainEmpNum = new JLabel("0");
		L_trainEmpNum.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_trainEmpNum.setBounds(150, 9, 26, 41);
		resultTipPane.add(L_trainEmpNum);

		JLabel label = new JLabel("人");
		label.setFont(new Font("华文楷体", Font.BOLD, 14));
		label.setBounds(178, 10, 26, 41);
		resultTipPane.add(label);

		JLabel L_resultTip = new JLabel("总成绩=出勤成绩 * 20 % + 考试成绩 * 80 %");
		L_resultTip.setForeground(Color.RED);
		L_resultTip.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_resultTip.setBounds(204, 10, 378, 41);
		resultTipPane.add(L_resultTip);

		JButton btnSet = new JButton("设置");
		btnSet.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSet.setBounds(553, 10, 93, 41);
		btnSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_set_action(e);
			}
		});
		resultTipPane.add(btnSet);

		JButton btnSave = new JButton("保存");
		btnSave.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSave.setBounds(654, 10, 93, 41);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_save_action(e);
			}
		});
		resultTipPane.add(btnSave);

		JButton btnCommit = new JButton("提交");
		btnCommit.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnCommit.setBounds(755, 10, 93, 41);
		resultTipPane.add(btnCommit);

		JLabel L_existedNum = new JLabel("0");
		L_existedNum.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_existedNum.setBounds(113, 9, 20, 41);
		resultTipPane.add(L_existedNum);

		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		label_1.setBounds(136, 10, 11, 41);
		resultTipPane.add(label_1);

		JScrollPane sp_result = new JScrollPane();
		sp_result.setBounds(0, 61, 858, 259);
		showPane.add(sp_result);

		resultTable = new JTable();
		resultTable.setFont(new Font("华文楷体", Font.BOLD, 14));
		String[] headers = { "员工编号", "序号", "姓名", "部门", "出勤次数", "出勤成绩", "考试成绩",
				"总成绩" };
		resultModel = new DefaultTableModel();
		resultModel.setColumnIdentifiers(headers);
		resultTable.setModel(resultModel);
		resultTable.setRowHeight(30);
		resultTable.setEnabled(false);
		resultTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount = resultTable.getSelectedRow();
			}
		});
		/* 给表格设置监听事件 */
		/* 表格监听事件设置完毕 */

		setTableCellRenderer();
		setTableDataCenter();

		sp_result.setViewportView(resultTable);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					TrainResultManage.this.dispose();
					TrainingPlanHome.getInstance().getBtnScore()
							.setEnabled(false);
				} catch (Exception ex) {
					// 此处不再针对异常进行相应处理
				}
			}
		});
	}

	protected void do_set_action(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null,
				"录入数据？(YES(录入)/NO(取消))", "", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			resultTable.setEnabled(true);
		} else if (result == JOptionPane.NO_OPTION) {
			resultTable.setEnabled(false);
		}
	}

	protected void do_save_action(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null,
				"保存还是修改数据？(YES(保存)/NO(取消))", "",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			do_savedata_action(e);
		} else if (result == JOptionPane.NO_OPTION) {
			do_update_action(e);
		}
	}

	private void do_update_action(ActionEvent e) {
		try {
			boolean success = true;
			if (clickCount >= 0) {
				String emp_id = (String) resultModel.getValueAt(clickCount, 0);
				float attendance_result = Float.parseFloat(resultModel
						.getValueAt(clickCount, 5).toString());
				float exam_result = Float.parseFloat(resultModel.getValueAt(
						clickCount, 6).toString());
				float total_result = Float.parseFloat(resultModel.getValueAt(
						clickCount, 7).toString());

				TrainResultDTO resultDTO = new TrainResultDTO(emp_id,
						exam_result, attendance_result, total_result);
				success = new TrainResult().updateResult(resultDTO);

				if (success) {
					JOptionPane.showMessageDialog(null, "保存成功!");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败!");
				}
				clickCount = -1;
			}
		} catch (Exception ex) {
			System.out.println("update null");
		}
	}

	private void do_savedata_action(ActionEvent e) {
		try {
			boolean success = true;
			if (clickCount >= 0) {
				String emp_id = (String) resultModel.getValueAt(clickCount, 0);
				float attendance_result = Float.parseFloat(resultModel
						.getValueAt(clickCount, 5).toString());
				float exam_result = Float.parseFloat(resultModel.getValueAt(
						clickCount, 6).toString());
				float total_result = Float.parseFloat(resultModel.getValueAt(
						clickCount, 7).toString());
		
				TrainResultDTO resultDTO = new TrainResultDTO(emp_id,
						exam_result, attendance_result, total_result);
				success = new TrainResult().saveResult(resultDTO);

				if (success) {
					JOptionPane.showMessageDialog(null, "保存成功!");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败!");
				}
				clickCount = -1;
			}
		} catch (Exception ex) {
			
		}
	}

	private void setTableCellRenderer() {
		/* 隐藏'员工编号'属性列 */
		TableColumn tc_emp_id_column = resultTable.getColumnModel()
				.getColumn(0);
		tc_emp_id_column.setMaxWidth(0);
		tc_emp_id_column.setMinWidth(0);
		tc_emp_id_column.setPreferredWidth(0);
		tc_emp_id_column.setResizable(false);
		/* 隐藏'员工编号'属性列完毕 */
	}

	private void setTableDataCenter() {
		/* 设置表格数据居中显示 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		resultTable.setDefaultRenderer(Object.class, renderer);
	}

	public void setDTO(TrainingPlanDTO planDTO, PlanItemDTO itemDTO) {
		this.planDTO = planDTO;
		this.itemDTO = itemDTO;
		loadAndShowData();
	}

	private void loadAndShowData() {
		tf_year.setText(planDTO.getTrain_plan_year());
		tf_name.setText(planDTO.getTrain_plan_name());
		String time = planDTO.getStart_time() + "/" + planDTO.getEnd_time();
		tf_time.setText(time);
		tf_major.setText(itemDTO.getZy_name());
		tf_classcount.setText(itemDTO.getClass_count());
		tf_teacher.setText(itemDTO.getTeacher());

		findAndShowData();
	}

	private void findAndShowData() {
		List<String> allEmp_id = new TrainEmp().getTrainEmpId(itemDTO
				.getPlan_item_id());
		/* 根据学员编号获取学员信息 */
		List<UserDTO> allEmp = new User().getEmpInfo(allEmp_id);
		/* 根据学员编号获取部门名 */
		List<String> allUnit_id = new User().getDepartIdByEmpId(allEmp_id);
		List<String> allDepartName = new Department().getDepartName(allUnit_id);
		/* 根据学员编号获取培训成绩 */
		List<TrainResultDTO> allResult = new TrainResult()
				.getTrainResult(allEmp_id);

		Vector<Object> v_result = null;
		int k = 0;
		for (int i = 0; i < allEmp_id.size(); i++) {
			UserDTO emp_dto = allEmp.get(i);
			TrainResultDTO result_dto = allResult.get(i);
			String departName = allDepartName.get(i);
			/* 构造表格向量 */
			v_result = new Vector<Object>();
			v_result.add(emp_dto.getUser_id());
			v_result.add(new Integer(++k));
			v_result.add(emp_dto.getName());
			/* 设置部门名 */
			if (departName.contains("太原市第二热电厂")) {
				String[] depart_name = departName.split("-");
				v_result.add(depart_name[1]);
			} else {
				v_result.add(departName);
			}
			/* 设置部门名完毕 */
			v_result.add(new Integer(10));
			try {
				v_result.add(result_dto.getAttendance_result());
				v_result.add(result_dto.getExam_result());
				v_result.add(result_dto.getTotal_result());
			} catch (Exception ex) {

			}
			resultModel.addRow(v_result);
		}
		L_trainEmpNum.setText(resultModel.getRowCount() + "");
	}

	public static void display() {
		trainResultManage = new TrainResultManage();
		trainResultManage.setVisible(true);
		trainResultManage.setResizable(false);
	}

	public static TrainResultManage getInstance() {
		return trainResultManage;
	}
}
