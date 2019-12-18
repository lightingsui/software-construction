package com.util.tool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;

import com.train.dto.DepartmentDTO;
import com.train.service.Department;

@SuppressWarnings("serial")
public class SelectUnitForm extends JDialog implements ActionListener,
		TreeSelectionListener {
	private final JPanel contentPanel = new JPanel();
	private JTree unitTree;
	private JTextField tf_selectedUnit;
	private String selectedUnit;

	public String getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(String selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public static void initDepartTree(List<DepartmentDTO> allUnit, String pid,
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

	public SelectUnitForm(JTextField tf_selectedUnit) {
		this.tf_selectedUnit = tf_selectedUnit;
		setModal(true);
		setTitle("部门信息");
		setBounds(100, 100, 212, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JTree departTree = new JTree();
		departTree.setBounds(10, 10, 300, 310);
		unitTree = departTree;
		departTree.addTreeSelectionListener(this);
		contentPanel.setLayout(null);
		departTree.setVisibleRowCount(40);

		/* 初始化部门树 */
		showTree();
		contentPanel.add(departTree);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				SelectUnitForm.this.dispose();
			}
		});
	}

	private void showTree() {
		Department department = new Department();
		DepartmentDTO departmentDTO = department.getDepartmentById("001");

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeValue(
				departmentDTO.getUnit_name(), departmentDTO));

		List<DepartmentDTO> allDepartment = department.getAllDepartment();
		allDepartment.remove(0);
		SelectUnitForm.initDepartTree(allDepartment, "001", root);

		DefaultTreeModel model = new DefaultTreeModel(root);
		unitTree.setModel(model);
		unitTree.getSelectionModel().setSelectionMode(
				DefaultTreeSelectionModel.SINGLE_TREE_SELECTION);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if ("OK".equals(btn.getActionCommand())) {
			tf_selectedUnit.setText(this.selectedUnit);
			this.setVisible(false);
		} else if ("Cancel".equals(btn.getActionCommand())) {
			this.dispose();
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) unitTree
				.getLastSelectedPathComponent();

		if (node == null) {
			return;
		}
		StringBuilder builder = new StringBuilder();
		if (node.getParent() != null
				&& !"太原市第二热电厂".equals(node.getParent().toString())) {
			builder.append(node.getParent().toString() + "-");
		}
		builder.append(((NodeValue) node.getUserObject()).getName());
		selectedUnit = builder.toString();
	}

}
