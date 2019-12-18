package com.view.departManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import com.train.dto.DepartmentDTO;
import com.train.service.Department;
import com.util.tool.NodeValue;
import com.util.tool.WindowUtil;
import com.view.empManage.EmployeeManageHome;

import java.awt.Font;

@SuppressWarnings("serial")
public class DepartManage extends JInternalFrame {
	private static DepartManage departManage;
	private JSplitPane splitPane;
	private JTree departTree;
	private JPanel showPane;
	private DefaultTreeModel treeModel;
	private JScrollPane scrollPane;
	private JTable departTable;
	private DefaultTableModel tableModel;
	private DepartmentDTO departDTO;
	private int clickCount = -1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartManage frame = new DepartManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DepartManage() {
		setTitle("员工管理>>部门管理");
		setBounds(100, 100, 907, 497);
		getContentPane().setLayout(null);

		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 891, 468);
		getContentPane().add(splitPane);

		departTree = new JTree();
		departTree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				do_valueChanged_action(e);
			}
		});
		showTree();
		splitPane.setLeftComponent(departTree);

		showPane = new JPanel();
		showPane.setLayout(new BorderLayout());

		JToolBar toolBar = new JToolBar();
		JButton btnAdd = new JButton("添加");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_add_action(e);
			}
		});
		JButton btnUpdate = new JButton("修改");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_update_action(e);
			}
		});
		JButton btnDelete = new JButton("删除");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_delete_action(e);
			}
		});
		JButton btnRefresh = new JButton("刷新");
		btnRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_refresh_action(e);
			}
		});
		toolBar.add(btnAdd);
		toolBar.add(btnUpdate);
		toolBar.add(btnDelete);
		toolBar.add(btnRefresh);
		showPane.add(toolBar, BorderLayout.NORTH);

		scrollPane = new JScrollPane();
		departTable = new JTable();
		departTable.setFont(new Font("华文楷体", Font.BOLD, 14));
		tableModel = new DefaultTableModel();

		String[] tableHeaders = { "序号", "部门名称", "部门编号", "部门简称", "联系方式", "备注" };
		tableModel.setColumnIdentifiers(tableHeaders);
		loadData();
		departTable.setModel(tableModel);
		departTable.setRowHeight(30);
		departTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount = departTable.getSelectedRow();
			}
		});
		setTableCellRenderer();

		scrollPane.setViewportView(departTable);
		showPane.add(scrollPane, BorderLayout.CENTER);
		splitPane.setRightComponent(showPane);

		splitPane.setDividerSize(5);
		splitPane.setDividerLocation(120);

		/* 恢复工具栏'添加部门'按钮的使用 */
		EmployeeManageHome.getInstance().getBtn_addDepartment()
				.setEnabled(true);
	}

	private void setTableCellRenderer() {
		/* 设置表格数据居中显示 */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		departTable.setDefaultRenderer(Object.class, renderer);

		/* 设置编号属性列宽度 */
		TableColumn numColumn = departTable.getColumnModel().getColumn(0);
		numColumn.setPreferredWidth(1);

		/* 设置表格不能编辑 */
		// departTable.setEnabled(false);
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setDepartDTO(DepartmentDTO departDTO) {
		this.departDTO = departDTO;
	}

	protected void do_refresh_action(ActionEvent e) {
		loadData();
	}

	protected void do_delete_action(ActionEvent e) {
		if (clickCount >= 0) {
			int result = JOptionPane.showConfirmDialog(null, "确定删除该记录？");
			if (result == JOptionPane.OK_OPTION) {
				// 获取部门编号
				Object unit_id = tableModel.getValueAt(clickCount, 2);

				/* 判断是否存在下级部门 */
				boolean existed = new Department()
						.existedDownDepart((String) unit_id);
				if (existed) { // 存在下级部门
					JOptionPane.showMessageDialog(null, "该部门存在下级部门，不能删除！");
					return;
				} else {

					/* 如果不存在下级部门 ,执行删除操作 */
					boolean success = new Department()
							.deleteDepart((String) unit_id);
					if (success) {
						JOptionPane.showMessageDialog(null, "删除成功！");
						clickCount = -1;
					} else {
						// 删除失败时
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}
			} else {
				clickCount = -1;
			}
		} else {
			JOptionPane.showMessageDialog(null, "请先选择要删除的记录！");
		}
	}

	protected void do_update_action(ActionEvent e) {
		if (clickCount >= 0) {
			UpdateDepart.display();
			Object unit_id = tableModel.getValueAt(clickCount, 2);
			DepartmentDTO depart = new Department()
					.getDepartmentById((String) unit_id);
			UpdateDepart.getInstance().setDepartDTO(depart);

		} else {
			JOptionPane.showMessageDialog(null, "请先选择要修改的记录！");
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
		// System.out.println("/>"+departDTO);

		/* 获取当前部门下的全部信息 */
		List<DepartmentDTO> departs = new Department()
				.getAllDepartment(departDTO.getUnit_id());

		/* 如果表中有数据先全部清空 */
		if (this.tableModel.getRowCount() != 0) {
			this.tableModel.setRowCount(0);
		}

		int k = 0;
		Vector<Object> v_depart = null;
		for (DepartmentDTO depart : departs) {
			v_depart = new Vector<Object>();
			v_depart.add(new Integer(++k));
			v_depart.add(depart.getUnit_name());
			v_depart.add(depart.getUnit_id());
			v_depart.add(depart.getHeader());
			v_depart.add(depart.getTelephone());
			v_depart.add(depart.getRemark());
			tableModel.addRow(v_depart);
		}
	}

	protected void do_add_action(ActionEvent e) {
		if (departDTO != null) {
			AddDepart.display();
			AddDepart.getInstance().setDepartDTO(departDTO);
		} else {
			JOptionPane.showMessageDialog(null, "请先选择要添加部门的上级部门!");
		}
	}

	public void callFunctinon(String method) {
		try {
			if ("add".equals(method)) {
				do_add_action(null);
			}
		} catch (Exception ex) {

		}
	}

	private void loadData() {
		/* 重新加载部门树 */
		showTree();

		/* 如果表中有数据先全部清空 */
		if (this.tableModel.getRowCount() != 0) {
			this.tableModel.setRowCount(0);
		}

		List<DepartmentDTO> departs = null;
		departs = new Department().getAllDepartment();

		int k = 0;
		Vector<Object> v_depart = null;
		for (DepartmentDTO depart : departs) {
			v_depart = new Vector<Object>();
			v_depart.add(new Integer(++k));
			v_depart.add(depart.getUnit_name());
			v_depart.add(depart.getUnit_id());
			v_depart.add(depart.getHeader());
			v_depart.add(depart.getTelephone());
			v_depart.add(depart.getRemark());
			tableModel.addRow(v_depart);
		}
	}

	private void showTree() {
		Department department = new Department();
		DepartmentDTO departmentDTO = department.getDepartmentById("001");

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeValue(
				departmentDTO.getUnit_name(), departmentDTO));

		List<DepartmentDTO> allDepartment = department.getAllDepartment();
		allDepartment.remove(0);
		initDepartTree(allDepartment, "001", root);

		treeModel = new DefaultTreeModel(root);
		departTree.setModel(treeModel);
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
					// 不需要显示叶子部门
					initDepartTree(allUnit, depart.getUnit_id(), other);
					parent.add(other);
				}
			}
		} catch (Exception ex) {
			System.out.println();
		}
	}

	public static void display() {
		departManage = new DepartManage();
		departManage.setVisible(true);
		departManage.setResizable(false);
	}

	public static DepartManage getInstance() {
		return departManage;
	}
}
