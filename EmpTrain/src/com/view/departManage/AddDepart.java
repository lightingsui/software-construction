package com.view.departManage;

import com.train.dto.DepartmentDTO;
import com.train.service.Department;
import com.util.tool.WindowUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class AddDepart extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField tf_up_unit;
	private JTextField tf_up_unit_id;
	private JTextField tf_unit_name;
	private JTextField tf_unit_id;
	private JTextField tf_header;
	private JTextArea ta_remark;
	private DepartmentDTO departDTO;
	private static AddDepart addDepart;

	public static void main(String[] args) {
		try {
			AddDepart dialog = new AddDepart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AddDepart() {
		setTitle("添加部门信息");
		setBounds(100, 100, 571, 412);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("保存");
				btnSave.setActionCommand("OK");
				btnSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						do_save_action(e);
					}
				});
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("取消");
				btnCancel.setActionCommand("Cancel");
				btnCancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						do_cancel_action(e);
					}
				});
				buttonPane.add(btnCancel);
			}
		}
		contentPanel.setLayout(null);

		JLabel L_up_unit = new JLabel("   上级部门");
		L_up_unit.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_up_unit_id = new JLabel("上级部门编号");
		L_up_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_unit_name = new JLabel("   部门名称");
		L_unit_name.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_unit_id = new JLabel("   部门编号");
		L_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_header = new JLabel("   部门简称");
		L_header.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_remark = new JLabel("      备注");
		L_remark.setFont(new Font("华文楷体", Font.BOLD, 14));

		final JPanel labelPane = new JPanel();
		labelPane.setBackground(Color.LIGHT_GRAY);
		labelPane.setBounds(76, 10, 90, 322);
		labelPane.setLayout(new GridLayout(6, 1));
		labelPane.add(L_up_unit);
		labelPane.add(L_up_unit_id);
		labelPane.add(L_unit_name);
		labelPane.add(L_unit_id);
		labelPane.add(L_header);
		labelPane.add(L_remark);
		contentPanel.add(labelPane);

		JPanel infoPane = new JPanel();
		infoPane.setBounds(196, 10, 288, 322);
		contentPanel.add(infoPane);
		infoPane.setLayout(null);

		tf_up_unit = new JTextField(10);
		tf_up_unit.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_up_unit.setBounds(0, 10, 288, 31);
		tf_up_unit.setEditable(false);
		infoPane.add(tf_up_unit);

		tf_up_unit_id = new JTextField(10);
		tf_up_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_up_unit_id.setBounds(0, 65, 288, 31);
		tf_up_unit_id.setEditable(false);
		infoPane.add(tf_up_unit_id);

		tf_unit_name = new JTextField(10);
		tf_unit_name.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_unit_name.setBounds(0, 118, 288, 31);
		infoPane.add(tf_unit_name);

		tf_unit_id = new JTextField(10);
		tf_unit_id.setEditable(false);
		tf_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_unit_id.setBounds(0, 176, 288, 31);
		infoPane.add(tf_unit_id);

		tf_header = new JTextField(10);
		tf_header.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_header.setBounds(0, 225, 288, 31);
		infoPane.add(tf_header);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 271, 288, 49);
		infoPane.add(scrollPane);

		ta_remark = new JTextArea();
		ta_remark.setLineWrap(true);
		ta_remark.setFont(new Font("华文楷体", Font.BOLD, 14));
		ta_remark.setBounds(0, 271, 288, 49);
		scrollPane.setViewportView(ta_remark);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				AddDepart.this.dispose();
				DepartManage.getInstance().setDepartDTO(null);
			}
		});
	}

	protected void do_cancel_action(ActionEvent e) {
		AddDepart.this.dispose();
		DepartManage.getInstance().setDepartDTO(null);
	}

	protected void do_save_action(ActionEvent e) {
		DepartmentDTO departDTO = null;
		Object[] params = new Object[5];
		params[0] = tf_up_unit_id.getText().trim();
		params[1] = tf_unit_name.getText().trim();
		params[2] = tf_unit_id.getText().trim();
		params[3] = tf_header.getText().trim();
		String remark = ta_remark.getText().trim();

		boolean[] result = validateDepart(params);
		if (result[0]) {
			if (result[1]) {
				departDTO = new DepartmentDTO((String) params[2],
						(String) params[0], (String) params[1],
						(String) params[3], remark);
				boolean success = new Department().saveDepart(departDTO);
				if (success) {
					JOptionPane.showMessageDialog(null, "保存成功!");
					clear();
				} else {
					JOptionPane.showMessageDialog(null, "保存失败!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "信息格式有误！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "请完善信息！");
		}
	}

	private void clear() {
		StringBuilder builder = new StringBuilder("00");
		String currentMaxId = tf_unit_id.getText().trim();
		String newMaxId = Integer.parseInt(currentMaxId) + 10 + "";
		builder.append(newMaxId);
		tf_unit_name.setText("");
		tf_unit_id.setText(builder.toString());
		tf_header.setText("");
		ta_remark.setText("");
	}

	private boolean[] validateDepart(Object[] params) {
		boolean[] result = { true, true };
		for (int i = 0; i < params.length; i++) {
			if (result[0] && "".equals(params[i])) {
				result[0] = false;
			}
			if (result[1] && "1".equals(params[i])) {
				result[1] = false;
			}
		}
		return result;
	}

	public void setDepartDTO(DepartmentDTO departDTO) {
		this.departDTO = departDTO;
		initData();
	}

	private void initData() {
		tf_up_unit.setText(departDTO.getUnit_name());
		tf_up_unit_id.setText(departDTO.getUnit_id());
		StringBuilder builder = new StringBuilder("00");

		try {
			// 获取当前部门下的最大部门编号
			String maxDepartId = new Department().getDepartMaxId(departDTO
					.getUnit_id());
			String newMaxId = Integer.parseInt(maxDepartId) + 10 + "";
			builder.append(newMaxId);
			tf_unit_id.setText(builder.toString());
		} catch (Exception ex) {
			// 当下级部门不存在时
			// 此处假设顶层根结点一定存在下级部门
			String newMaxId = Integer.parseInt(departDTO.getUnit_id()) + 10
					+ "";
			builder.append(newMaxId);
			tf_unit_id.setText(builder.toString());
		}
	}

	public static void display() {
		addDepart = new AddDepart();
		addDepart.setVisible(true);
		addDepart.setResizable(false);
	}

	public static AddDepart getInstance() {
		return addDepart;
	}
}
