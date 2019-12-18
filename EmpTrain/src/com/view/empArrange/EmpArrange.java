package com.view.empArrange;

import java.awt.Component;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import com.train.dto.DepartmentDTO;
import com.train.dto.TrainEmpDTO;
import com.train.dto.UserDTO;
import com.train.service.Department;
import com.train.service.TrainEmp;
import com.train.service.User;
import com.util.tool.NodeValue;
import com.util.tool.WindowUtil;

@SuppressWarnings("serial")
public class EmpArrange extends JFrame {

	private JPanel contentPane;
	private JLabel L_departInfo;
	private JLabel L_arranged_num;
	private JTree departTree;
	private DefaultTreeModel departTreeModel;
	private JTable empTable;
	private DefaultTableModel empModel;
	private JTable arrangedEmpTable;
	private DefaultTableModel arrangedEmpModel;
	private static EmpArrange empArrange;
	private DepartmentDTO departDTO;
	private String selectedUnit;
	private JCheckBox ck;
	private int clickCount = -1;
	private int arr_clickCount = -1;
	private String train_plan_id;
	private String train_item_id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpArrange frame = new EmpArrange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmpArrange() {
		setTitle("学员安排");
		setSize(WindowUtil.getAllScreen());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		departTree = new JTree();
		departTree.setBounds(5, 5, 119, 485);
		departTree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				do_valueChanged_action(e);
			}
		});
		showTree();
		contentPane.setLayout(null);
		contentPane.add(departTree);

		final JPanel selectPane = new JPanel();
		selectPane.setBounds(124, 5, 1221, 485);
		selectPane.setLayout(null);

		final JPanel selectInfoPane = new JPanel();
		selectInfoPane.setBounds(0, 0, 1221, 44);
		JLabel L_tipInfo = new JLabel("部门:");
		L_tipInfo.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_tipInfo.setBounds(10, 10, 48, 26);
		L_departInfo = new JLabel("太原第二热电厂");
		L_departInfo.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_departInfo.setBounds(68, 10, 197, 26);
		selectInfoPane.setLayout(null);
		selectInfoPane.add(L_tipInfo);
		selectInfoPane.add(L_departInfo);
		selectPane.add(selectInfoPane);

		JButton btnSelect = new JButton("选择");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_select_action(e);
			}
		});
		btnSelect.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSelect.setBounds(1118, 10, 93, 26);
		selectInfoPane.add(btnSelect);

		JScrollPane sp_selectInfo = new JScrollPane();
		sp_selectInfo.setBounds(0, 44, 1221, 440);
		selectPane.add(sp_selectInfo);

		empTable = new JTable();
		empTable.setFont(new Font("华文楷体", Font.BOLD, 14));
		String[] headers = { "员工编号", "全选", "姓名", "性别", "身份证号", "职务", "入厂时间",
				"岗位" };
		empModel = new DefaultTableModel();
		empModel.setColumnIdentifiers(headers);
		empTable.setModel(empModel);
		empTable.setRowHeight(30);
		setEmp_numHide(empTable);
		empTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount = empTable.getSelectedRow();
			}
		});
		setTableDataCenter(empTable);
		sp_selectInfo.setViewportView(empTable);
		selectPane.add(sp_selectInfo);
		contentPane.add(selectPane);

		final JPanel selectedPane = new JPanel();
		selectedPane.setBounds(5, 490, 1340, 236);
		contentPane.add(selectedPane);
		selectedPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1340, 44);
		selectedPane.add(panel);

		JLabel L_arrangedEmpTip = new JLabel("已安排学员:");
		L_arrangedEmpTip.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_arrangedEmpTip.setBounds(10, 10, 98, 26);
		panel.add(L_arrangedEmpTip);

		JButton btnSave = new JButton("保存");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_save_action(e);
			}
		});
		btnSave.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSave.setBounds(1237, 10, 93, 26);
		panel.add(btnSave);

		L_arranged_num = new JLabel("0");
		L_arranged_num.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_arranged_num.setBounds(118, 10, 38, 26);
		panel.add(L_arranged_num);

		JLabel L_tip = new JLabel("人");
		L_tip.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_tip.setBounds(163, 10, 38, 26);
		panel.add(L_tip);

		JButton btnDelete = new JButton("删除");
		btnDelete.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnDelete.setBounds(1134, 10, 93, 26);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_delete_action(e);
			}
		});
		panel.add(btnDelete);

		JScrollPane sp_selectedInfo = new JScrollPane();
		sp_selectedInfo.setBounds(0, 44, 1340, 192);
		selectedPane.add(sp_selectedInfo);

		arrangedEmpTable = new JTable();
		arrangedEmpTable.setFont(new Font("华文楷体", Font.BOLD, 14));
		String[] arrangedHeaders = { "员工编号", "姓名", "部门", "职务", "入厂时间", "岗位" };
		arrangedEmpModel = new DefaultTableModel();
		arrangedEmpModel.setColumnIdentifiers(arrangedHeaders);
		arrangedEmpTable.setModel(arrangedEmpModel);
		arrangedEmpTable.setRowHeight(30);
		setEmp_numHide(arrangedEmpTable);
		arrangedEmpTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arr_clickCount = arrangedEmpTable.getSelectedRow();
			}
		});
		setTableDataCenter(arrangedEmpTable);
		sp_selectedInfo.setViewportView(arrangedEmpTable);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				EmpArrange.this.dispose();
			}
		});
	}

	private void setEmp_numHide(JTable table) {
		TableColumn tc_emp_id = table.getColumnModel().getColumn(0);
		tc_emp_id.setMaxWidth(0);
		tc_emp_id.setMinWidth(0);
		tc_emp_id.setPreferredWidth(0);
		tc_emp_id.setResizable(false);
	}

	private void initData() {
		List<TrainEmpDTO> allTrainEmp = new TrainEmp()
				.getTrainEmp(train_item_id);
		Vector<Object> v_emp = null;
		UserDTO employeeDTO = null;

		for (TrainEmpDTO te : allTrainEmp) {
			v_emp = new Vector<Object>();
			employeeDTO = new User().getEmployeeById(te.getEmp_id());
			v_emp.add(employeeDTO.getUser_id());
			v_emp.add(employeeDTO.getName());
			String unit_name = new Department()
					.getDepartCompleteName(employeeDTO.getUnit_id());
			v_emp.add(unit_name);
			v_emp.add(employeeDTO.getDuty());
			v_emp.add(employeeDTO.getLast_login_time());
			v_emp.add(employeeDTO.getDuty());
			arrangedEmpModel.addRow(v_emp);
		}
		L_arranged_num.setText(arrangedEmpModel.getRowCount() + "");
	}

	public void setId(String train_plan_id, String train_item_id) {
		this.train_plan_id = train_plan_id;
		this.train_item_id = train_item_id;
		initData();
	}

	protected void do_save_action(ActionEvent e) {
		StringBuilder num = new StringBuilder("");
		boolean result = true;
		int rowCount = arrangedEmpModel.getRowCount();
		int startCount = Integer.parseInt(L_arranged_num.getText().trim());

		for (int row = startCount; row < rowCount; row++) {
			String emp_id = (String) arrangedEmpModel.getValueAt(row, 0);
			TrainEmpDTO trainEmpDTO = new TrainEmpDTO(train_item_id,
					train_plan_id, emp_id);
			result = new TrainEmp().saveTrainEmp(trainEmpDTO);
			if (!result) {
				num.append(emp_id + ",");
			}
		}

		if (result) {
			JOptionPane.showMessageDialog(null, "保存成功！");
			L_arranged_num.setText(arrangedEmpModel.getRowCount() + "");
		} else {
			JOptionPane.showMessageDialog(null,
					"保存失败!未保存成功的\n员工编号为:" + num.toString());
		}
	}

	protected void do_delete_action(ActionEvent e) {
		if (arr_clickCount >= 0) {
			int option = JOptionPane.showConfirmDialog(null, "确定删除?");
			if (option == JOptionPane.OK_OPTION) {
				String emp_id = (String) arrangedEmpModel.getValueAt(
						arr_clickCount, 0);
				boolean success = new TrainEmp().deleteTrainEmp(train_item_id,
						emp_id);
				if (success) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					arrangedEmpModel.removeRow(arr_clickCount);
					L_arranged_num.setText(arrangedEmpModel.getRowCount() + "");
				} else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "请先选择要删除的记录!");
		}
	}

	protected void do_select_action(ActionEvent e) {
		try {
			if (empModel.getRowCount() != 0) {
				if (clickCount >= 0) {
					/* 循环判断是否已选择过该员工信息 */
					String emp_id = (String) empModel.getValueAt(clickCount, 0);
					for (int j = 0; j < arrangedEmpModel.getRowCount(); j++) {
						String arr_emp_id = (String) arrangedEmpModel
								.getValueAt(j, 0);
						if (emp_id.equals(arr_emp_id)) {
							JOptionPane.showMessageDialog(null,
									"该培训计划中已存在该员工信息,不可重复选择！");
							return;
						}
					}
					/* 否则，安排该员工进行培训 */
					Object[] params = new Object[8];
					for (int i = 0; i < empModel.getColumnCount(); i++) {
						params[i] = empModel.getValueAt(clickCount, i);
					}

					Vector<Object> v_emp = new Vector<Object>();
					v_emp.add(params[0]);
					v_emp.add(params[2]);
					v_emp.add(selectedUnit);
					v_emp.add(params[5]);
					v_emp.add(params[6]);
					v_emp.add(params[7]);
					arrangedEmpModel.addRow(v_emp);
				}
			}
		} catch (Exception ex) {
			// 此处不再进行相应处理
		}
	}

	private void setTableDataCenter(JTable table) {
		/* 设置表格数据居中显示 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
	}

	private void showTree() {
		Department department = new Department();
		DepartmentDTO departmentDTO = department.getDepartmentById("001");

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeValue(
				departmentDTO.getUnit_name(), departmentDTO));

		List<DepartmentDTO> allDepartment = department.getAllDepartment();
		allDepartment.remove(0);
		initDepartTree(allDepartment, "001", root);

		departTreeModel = new DefaultTreeModel(root);
		departTree.setModel(departTreeModel);
		departTree.getSelectionModel().setSelectionMode(
				DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);
	}

	private void initDepartTree(List<DepartmentDTO> allUnit, String pid,
			DefaultMutableTreeNode parent) {
		try {
			for (DepartmentDTO depart : allUnit) {
				if (depart.getUp_unit_id().equals(pid)) {
					DefaultMutableTreeNode other = new DefaultMutableTreeNode(
							new NodeValue(depart.getUnit_name(), depart));
					initDepartTree(allUnit, depart.getUnit_id(), other);
					parent.add(other);
				}
			}
		} catch (Exception ex) {
			System.out.println();
		}
	}

	protected void do_valueChanged_action(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) departTree
				.getLastSelectedPathComponent();

		if (node == null) {
			return;
		}
		// 获取部门信息，以供添加部门信息时使用
		departDTO = ((NodeValue) node.getUserObject()).getDepartDTO();
		L_departInfo.setText(departDTO.getUnit_name());

		StringBuilder builder = new StringBuilder();
		if (node.getParent() != null
				&& !"太原市第二热电厂".equals(node.getParent().toString())) {
			builder.append(node.getParent().toString() + "-");
		}
		builder.append(((NodeValue) node.getUserObject()).getName());
		selectedUnit = builder.toString();

		/* 为departTableModel装载数据 */
		findAndLoadEmpInfo();
	}

	private void findAndLoadEmpInfo() {
		if (empModel.getRowCount() != 0) {
			empModel.setRowCount(0);
		}
		List<UserDTO> allUnitEmp = new User().findUnitEmp(departDTO
				.getUnit_id());
		Vector<Object> v_emp = null;
		for (int i = 0; i < allUnitEmp.size(); i++) {
			v_emp = new Vector<Object>();
			UserDTO empDTO = allUnitEmp.get(i);
			v_emp.add(empDTO.getUser_id());
			v_emp.add(null);
			v_emp.add(empDTO.getName());
			v_emp.add(empDTO.getSex());
			v_emp.add(empDTO.getCard_id());
			v_emp.add(empDTO.getDuty());
			v_emp.add(empDTO.getLast_login_time());
			v_emp.add(empDTO.getDuty());
			empModel.addRow(v_emp);
			setCheckBox();
		}
	}

	private void setCheckBox() {
		// 开始向表格中添加复选框（注意：此示例较为简单，缺省很多判断，也没有动态代码支持）
		// 通过设置列渲染
		// 直接方式 使用TableColumn的setCellRenderer方法（推荐）
		// 此方法可以设置某一列的渲染（即使用某一个组件--即控件来显示单元格数据）
		empTable.getColumnModel().getColumn(1)
				.setCellRenderer(new TableCellRenderer() {
					/*
					 * (non-Javadoc) 此方法用于向方法调用者返回某一单元格的渲染器（即显示数据的组建--或控件）
					 * 可以为JCheckBox JComboBox JTextArea 等
					 * 
					 * @see javax.swing.table.TableCellRenderer#
					 * getTableCellRendererComponent(javax.swing.JTable,
					 * java.lang.Object, boolean, boolean, int, int)
					 */
					@Override
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// 创建用于返回的渲染组件
						ck = new JCheckBox();
						// 使具有焦点的行对应的复选框选中
						ck.setSelected(isSelected);
						// 设置单选box.setSelected(hasFocus);
						// 使复选框在单元格内居中显示
						ck.setHorizontalAlignment((int) 0.5f);
						return ck;
					}
				});
	}

	public static void display() {
		empArrange = new EmpArrange();
		empArrange.setVisible(true);
		empArrange.setResizable(false);
	}

	public static EmpArrange getInstance() {
		return empArrange;
	}
}
