package com.view.empArrange;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.train.dto.PlanItemDTO;
import com.train.dto.TrainingPlanDTO;
import com.util.tool.WindowUtil;
import com.view.trainingPlan.TrainingPlanHome;

@SuppressWarnings("serial")
public class TrainingPlanDisplay extends JFrame {
	private static TrainingPlanDisplay trainingPlanDisplay;
	private JPanel contentPane;
	private JTextField tf_year;
	private JTextField tf_name;
	private JTextField tf_time;
	private JTextField tf_major;
	private JTextArea ta_purpose;
	private JTextArea ta_content;
	private JTextField tf_classcount;
	private JTextField tf_teacher;
	private JTextField tf_operation;
	private TrainingPlanDTO planDTO;
	private PlanItemDTO itemDTO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingPlanDisplay frame = new TrainingPlanDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TrainingPlanDisplay() {
		setTitle("培训计划基本信息");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 391);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel yearPane = new JPanel();
		yearPane.setBackground(Color.LIGHT_GRAY);
		yearPane.setBounds(10, 22, 69, 46);
		contentPane.add(yearPane);
		yearPane.setLayout(null);

		JLabel L_year = new JLabel("  年度");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(5, 10, 54, 26);
		yearPane.add(L_year);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 68, 739, 46);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel L_major = new JLabel(" 专业");
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_major.setBounds(10, 10, 54, 26);
		panel.add(L_major);

		JLabel L_purpose = new JLabel("    培训目的");
		L_purpose.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_purpose.setBounds(90, 10, 117, 26);
		panel.add(L_purpose);

		JLabel L_content = new JLabel("    培训内容");
		L_content.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_content.setBounds(250, 10, 117, 26);
		panel.add(L_content);

		JLabel L_classcount = new JLabel(" 课时");
		L_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_classcount.setBounds(401, 10, 54, 26);
		panel.add(L_classcount);

		JLabel L_teacher = new JLabel(" 授课人");
		L_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_teacher.setBounds(475, 10, 62, 26);
		panel.add(L_teacher);

		JLabel label = new JLabel("    操作");
		label.setFont(new Font("华文楷体", Font.BOLD, 16));
		label.setBounds(603, 10, 69, 26);
		panel.add(label);

		tf_year = new JTextField();
		tf_year.setEditable(false);
		tf_year.setHorizontalAlignment(SwingConstants.CENTER);
		tf_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_year.setBounds(78, 22, 162, 46);
		contentPane.add(tf_year);
		tf_year.setColumns(10);

		JPanel namePane = new JPanel();
		namePane.setLayout(null);
		namePane.setBackground(Color.LIGHT_GRAY);
		namePane.setBounds(239, 22, 69, 46);
		contentPane.add(namePane);

		JLabel L_name = new JLabel("  名称");
		L_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_name.setBounds(5, 10, 54, 26);
		namePane.add(L_name);

		tf_name = new JTextField();
		tf_name.setEditable(false);
		tf_name.setHorizontalAlignment(SwingConstants.CENTER);
		tf_name.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_name.setColumns(10);
		tf_name.setBounds(308, 22, 162, 46);
		contentPane.add(tf_name);

		JPanel timePane = new JPanel();
		timePane.setLayout(null);
		timePane.setBackground(Color.LIGHT_GRAY);
		timePane.setBounds(469, 22, 90, 46);
		contentPane.add(timePane);

		JLabel L_time = new JLabel("    时间");
		L_time.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_time.setBounds(10, 10, 70, 26);
		timePane.add(L_time);

		tf_time = new JTextField();
		tf_time.setEditable(false);
		tf_time.setHorizontalAlignment(SwingConstants.CENTER);
		tf_time.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_time.setColumns(10);
		tf_time.setBounds(559, 22, 190, 46);
		contentPane.add(tf_time);

		tf_major = new JTextField();
		tf_major.setEditable(false);
		tf_major.setHorizontalAlignment(SwingConstants.CENTER);
		tf_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_major.setBounds(10, 114, 66, 211);
		contentPane.add(tf_major);
		tf_major.setColumns(10);

		JScrollPane sp_purpose = new JScrollPane();
		sp_purpose.setBounds(76, 114, 164, 211);
		contentPane.add(sp_purpose);

		ta_purpose = new JTextArea();
		ta_purpose.setTabSize(6);
		ta_purpose.setEditable(false);
		ta_purpose.setFont(new Font("华文楷体", Font.BOLD, 16));
		sp_purpose.setViewportView(ta_purpose);

		JScrollPane sp_content = new JScrollPane();
		sp_content.setBounds(240, 114, 164, 211);
		contentPane.add(sp_content);

		ta_content = new JTextArea();
		ta_content.setEditable(false);
		ta_content.setFont(new Font("华文楷体", Font.BOLD, 16));
		sp_content.setViewportView(ta_content);

		tf_classcount = new JTextField();
		tf_classcount.setEditable(false);
		tf_classcount.setHorizontalAlignment(SwingConstants.CENTER);
		tf_classcount.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_classcount.setColumns(10);
		tf_classcount.setBounds(404, 114, 66, 211);
		contentPane.add(tf_classcount);

		tf_teacher = new JTextField();
		tf_teacher.setEditable(false);
		tf_teacher.setHorizontalAlignment(SwingConstants.CENTER);
		tf_teacher.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_teacher.setColumns(10);
		tf_teacher.setBounds(470, 114, 89, 211);
		contentPane.add(tf_teacher);

		tf_operation = new JTextField();
		tf_operation.setText("安排学员");
		tf_operation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_operation_action(e);
			}
		});
		tf_operation.setEditable(false);
		tf_operation.setHorizontalAlignment(SwingConstants.CENTER);
		tf_operation.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_operation.setColumns(10);
		tf_operation.setBounds(559, 114, 190, 211);
		contentPane.add(tf_operation);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					TrainingPlanDisplay.this.dispose();
					TrainingPlanHome.getInstance().setClickCount(-1);
				} catch (Exception ex) {

				}
			}
		});
		setResizable(false);
	}

	public void setDTO(TrainingPlanDTO planDTO, PlanItemDTO itemDTO) {
		this.planDTO = planDTO;
		this.itemDTO = itemDTO;
		initData();
	}

	private void initData() {
		tf_year.setText(planDTO.getTrain_plan_year());
		tf_name.setText(planDTO.getTrain_plan_name());
		Date start_date = planDTO.getStart_time();
		Date end_date = planDTO.getEnd_time();
		String time = start_date + "/" + end_date;
		tf_time.setText(time);
		tf_major.setText(itemDTO.getZy_name());
		ta_purpose.setText(itemDTO.getTrain_purpose());
		ta_content.setText(itemDTO.getTrain_content());
		tf_classcount.setText(itemDTO.getClass_count());
		tf_teacher.setText(itemDTO.getTeacher());
	}

	protected void do_operation_action(MouseEvent e) {
		EmpArrange.display();
		EmpArrange.getInstance().setId(planDTO.getTrain_plan_id(),
				itemDTO.getPlan_item_id());
		TrainingPlanDisplay.this.dispose();
	}

	public static void display() {
		trainingPlanDisplay = new TrainingPlanDisplay();
		trainingPlanDisplay.setVisible(true);
		trainingPlanDisplay.setResizable(false);
	}

	public static TrainingPlanDisplay getInstance() {
		return trainingPlanDisplay;
	}
}
