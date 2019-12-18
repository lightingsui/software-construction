package com.view.empManage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.train.dto.DepartmentDTO;
import com.train.dto.UserDTO;
import com.train.service.Department;
import com.train.service.User;
import com.util.tool.WindowUtil;

@SuppressWarnings("serial")
public class EmpInfoManage extends JInternalFrame {
	private static EmpInfoManage empInfoManage;
	private JComboBox<Object> cbb_unitName;
	private JTextField tf_empName;
	private JComboBox<Object> cbb_sex;
	private JButton btnFind;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnRefresh;
	private int clickCount = -1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpInfoManage frame = new EmpInfoManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmpInfoManage() {
		setTitle("员工管理>>员工基本信息管理");
		setBounds(100, 100, 907, 497);
		getContentPane().setLayout(null);

		init();
	}

	private void init() {
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 871, 82);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel L_unitName = new JLabel("班组");
		L_unitName.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_unitName.setBounds(25, 34, 49, 21);
		panel.add(L_unitName);

		String[] unit_class = { "", "发电一部", "发电一部-电气1班", "发电一部-汽机1班",
				"发电一部-锅炉1班", "发电二部", "发电二部-电气1班", "发电二部-汽机1班", "发电二部-锅炉1班",
				"检修车间", "锅炉车间", "燃料车间", "运输部" };
		cbb_unitName = new JComboBox<Object>();
		cbb_unitName.setModel(new DefaultComboBoxModel<Object>(unit_class));
		cbb_unitName.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_unitName.setBounds(91, 32, 161, 26);
		panel.add(cbb_unitName);

		JLabel L_empName = new JLabel("员工姓名");
		L_empName.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_empName.setBounds(291, 34, 74, 21);
		panel.add(L_empName);

		tf_empName = new JTextField();
		tf_empName.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_empName.setBounds(390, 32, 161, 26);
		panel.add(tf_empName);
		tf_empName.setColumns(10);

		JLabel L_sex = new JLabel("性别");
		L_sex.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_sex.setBounds(594, 34, 41, 21);
		panel.add(L_sex);

		String[] sex = { "", "男", "女" };
		cbb_sex = new JComboBox<Object>();
		cbb_sex.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_sex.setModel(new DefaultComboBoxModel<Object>(sex));
		cbb_sex.setBounds(659, 32, 61, 26);
		panel.add(cbb_sex);

		btnFind = new JButton("find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_find_action(e);
			}
		});
		btnFind.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnFind.setBounds(757, 32, 93, 26);
		panel.add(btnFind);

		JPanel operatePane = new JPanel();
		operatePane.setBounds(10, 81, 871, 44);
		getContentPane().add(operatePane);
		operatePane.setLayout(null);

		btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_delete_action(e);
			}
		});
		btnDelete.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnDelete.setBounds(757, 10, 93, 26);
		operatePane.add(btnDelete);

		btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_update_action(e);
			}
		});
		btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnUpdate.setBounds(632, 10, 93, 26);
		operatePane.add(btnUpdate);

		btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_create_action(e);
			}
		});
		btnCreate.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnCreate.setBounds(503, 10, 93, 26);
		operatePane.add(btnCreate);

		btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_find_action(e);
			}
		});
		btnRefresh.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnRefresh.setBounds(375, 10, 93, 26);
		operatePane.add(btnRefresh);

		JPanel resultPane = new JPanel();
		resultPane.setBounds(10, 123, 871, 335);
		getContentPane().add(resultPane);
		resultPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 5, 871, 330);
		resultPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("华文楷体", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_click_action(e);
			}
		});
		model = new DefaultTableModel();
		String[] headers = { "员工编号", "序号", "姓名", "性别", "出生日期", "部门", "岗位" };
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		setTabelCellRenderer();

		/* 屏蔽工具栏'添加部门'按钮的使用 */
		EmployeeManageHome.getInstance().getBtn_addDepartment()
				.setEnabled(false);
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	private void setTabelCellRenderer() {
		/* 设置表格数据居中显示 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);

		/* 把员工编号属性列隐藏掉 */
		TableColumn empId = table.getColumnModel().getColumn(0);
		empId.setMaxWidth(0);
		empId.setMinWidth(0);
		empId.setPreferredWidth(0);
		empId.setResizable(false);
		/* 设置编号属性列宽度 */
		TableColumn numColumn = table.getColumnModel().getColumn(1);
		numColumn.setPreferredWidth(1);

		/* 设置表格不可编辑 */
		// table.setEnabled(false);
	}

	protected void do_click_action(MouseEvent e) {
		clickCount = table.getSelectedRow();
	}

	protected void do_delete_action(ActionEvent e) {
		if (this.clickCount >= 0) {
			int result = JOptionPane.showConfirmDialog(null, "确定删除？");
			if (result == JOptionPane.OK_OPTION) {
				boolean success = new User().deleteEmployee((String) table
						.getValueAt(this.clickCount, 0));
				if (success) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					clickCount = -1;
					do_find_action(e);
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "请先选择要删除的记录!");
		}
	}

	protected void do_update_action(ActionEvent e) {
		try {
			if (this.clickCount >= 0) {
				String employee_id = (String) table.getValueAt(this.clickCount,
						0);
				UserDTO employee = new User().getEmployeeById(employee_id);

				/* 选中修改记录后，显示修改信息界面并初始化数据 */
				UpdateEmployee.display();
				UpdateEmployee.getInstance().setEmployeeDTO(employee);
			} else {
				JOptionPane.showMessageDialog(null, "请先选则要修改的记录！");
			}
		} catch (Exception ex) {

		}
	}

	protected void do_create_action(ActionEvent e) {
		AddEmployee.display();
	}

	protected void do_find_action(ActionEvent e) {
		String unit_name = (String) cbb_unitName.getSelectedItem();
		String empName = tf_empName.getText().trim();
		String sex = (String) cbb_sex.getSelectedItem();

		UserDTO user = new UserDTO();
		if (unit_name != null && !"".equals(unit_name)) {
			String[] unit = unit_name.split("-");
			if (unit.length > 1) {
				user.setUnit_id(new Department().getDepartId(unit[0], unit[1]));
			} else {
				user.setUnit_id(new Department().getUnit(unit_name)
						.getUnit_id());
			}
		}
		user.setUser_name(empName);
		user.setSex(sex);

		int k = 0;
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		/* 获取全部学员信息 */
		List<UserDTO> users = new User().getAllUser(user);
		Vector<Object> v_user = null;

		/* 处理表格显示数据 */
		if (!users.isEmpty()) {
			for (UserDTO u : users) {
				DepartmentDTO departDTO = new Department().getDepartmentById(u
						.getUnit_id());
				v_user = new Vector<Object>();
				v_user.add(u.getUser_id()); // 学员编号
				v_user.add(new Integer(++k)); // 序号
				v_user.add(u.getUser_name());
				v_user.add(u.getSex());
				v_user.add(u.getBirthday());
				if (departDTO != null) {
					v_user.add(departDTO.getUnit_name());
				} else {
					v_user.add(null);
				}
				v_user.add(u.getDuty());
				results.add(v_user);
			}
		}

		if (this.model.getRowCount() != 0) {
			this.model.setRowCount(0);
		}

		if (results.size() > 0) {
			for (Vector<Object> result : results) {
				this.model.addRow(result);
			}
		} else {
			JOptionPane.showMessageDialog(null, "查询无果！");
		}
	}

	public static void display() {
		empInfoManage = new EmpInfoManage();
		empInfoManage.setVisible(true);
	}

	public static EmpInfoManage getInstance() {
		return empInfoManage;
	}
}