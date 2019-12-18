package com.train.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.train.util.WindowUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TrainingPlanHome extends JFrame {

	private JPanel contentPane;
	private JPanel selectPane;
	private JScrollPane scrollPane;
	private JTable resultTable;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingPlanHome frame = new TrainingPlanHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TrainingPlanHome() {
		setTitle("\u57F9\u8BAD\u8BA1\u5212\u7BA1\u7406");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		selectPane = new JPanel();
		selectPane.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u6761\u4EF6",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		selectPane.setBounds(10, 10, 679, 103);
		contentPane.add(selectPane);
		selectPane.setLayout(null);

		String[] years = new String[] { "2015", "2016", "2017" };
		JComboBox<Object> cbb_year = new JComboBox<Object>();
		cbb_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_year.setModel(new DefaultComboBoxModel<Object>(years));
		cbb_year.setBounds(142, 25, 161, 21);
		selectPane.add(cbb_year);

		JLabel L_year = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6");
		L_year.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_year.setBounds(10, 25, 122, 21);
		selectPane.add(L_year);

		JButton btnFind = new JButton("find");
		btnFind.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnFind.setBounds(576, 42, 93, 23);
		selectPane.add(btnFind);

		JLabel L_major = new JLabel("\u57F9\u8BAD\u4E13\u4E1A");
		L_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_major.setBounds(341, 27, 77, 21);
		selectPane.add(L_major);

		String[] majors = new String[] { "电气", "汽机", "锅炉", "化水", "燃运" };
		JComboBox<Object> cbb_major = new JComboBox<Object>();
		cbb_major.setModel(new DefaultComboBoxModel<Object>(majors));
		cbb_major.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_major.setBounds(452, 25, 99, 21);
		selectPane.add(cbb_major);

		JLabel L_type = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B");
		L_type.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_type.setBounds(10, 60, 122, 21);
		selectPane.add(L_type);

		String[] types = new String[] { "新员工入场培训", "中层管理人员培训", "班组长培训" };
		JComboBox<Object> cbb_type = new JComboBox<Object>();
		cbb_type.setModel(new DefaultComboBoxModel<Object>(types));
		cbb_type.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_type.setBounds(142, 60, 161, 21);
		selectPane.add(cbb_type);

		JLabel L_finish = new JLabel("\u5B8C\u6210\u60C5\u51B5");
		L_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_finish.setBounds(341, 60, 77, 21);
		selectPane.add(L_finish);

		String[] finishes = new String[] { "未培训", "培训中", "已培训" };
		JComboBox<Object> cbb_finish = new JComboBox<Object>();
		cbb_finish.setModel(new DefaultComboBoxModel<Object>(finishes));
		cbb_finish.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_finish.setBounds(452, 58, 99, 21);
		selectPane.add(cbb_finish);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(688, 505, -673, -333);
		contentPane.add(scrollPane);

		addResultTable();
		// resultTable.setModel(new DefaultTableModel(new Object[][] {}, new
		// String[]
		// {
		// "New column", "New column", "New column" }) {
		// @SuppressWarnings("rawtypes")
		// Class[] columnTypes = new Class[] { String.class, Object.class,
		// Object.class };
		//
		// @SuppressWarnings("unchecked")
		// public Class getColumnClass(int columnIndex) {
		// return columnTypes[columnIndex];
		// }
		// });
		scrollPane.setViewportView(resultTable);

		JButton btn_add = new JButton("create");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_add_action(e);
			}
		});
		btn_add.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_add.setBounds(343, 123, 93, 23);
		contentPane.add(btn_add);

		JButton btn_update = new JButton("update");
		btn_update.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_update.setBounds(464, 123, 93, 23);
		contentPane.add(btn_update);

		JButton btn_delete = new JButton("delete");
		btn_delete.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_delete.setBounds(588, 123, 93, 23);
		contentPane.add(btn_delete);

		JButton btn_next = new JButton("next");
		btn_next.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_next.setBounds(373, 526, 105, 23);
		contentPane.add(btn_next);

		JButton btn_end = new JButton("last");
		btn_end.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_end.setBounds(520, 526, 93, 23);
		contentPane.add(btn_end);

		JButton btn_first = new JButton("first");
		btn_first.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_first.setBounds(91, 526, 93, 23);
		contentPane.add(btn_first);

		JButton btn_previous = new JButton("previous");
		btn_previous.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btn_previous.setBounds(225, 526, 105, 23);
		contentPane.add(btn_previous);

		setResizable(false);
		setLocation(WindowUtil.setLocation(this.getWidth(), this.getHeight()));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TrainingPlanHome.this.dispose();
			}
		});
	}

	protected void do_add_action(ActionEvent e) {
		TrainingPlanHome.this.setVisible(false);
		AddTrainingPlan.display();
	}

	private void addResultTable() {
		String[] headers = { "序号", "年度", "培训计划名称", "培训类型", "培训专业", "培训时间",
				"培训人数", "完成情况" };
		// DefaultTableModel tableModel = new DefaultTableModel(data, headers);
		resultTable = new JTable();
		resultTable.setModel(new DefaultTableModel(new Object[][] {}, headers));
	}

	private void addData(Object[][] data) {

	}
	
	public static void display() {
		new TrainingPlanHome().setVisible(true);
	}
}
