package com.view.departManage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.train.dto.DepartmentDTO;
import com.train.service.Department;
import com.util.tool.CommonUtil;
import com.util.tool.DateChooser;
import com.util.tool.WindowUtil;

@SuppressWarnings("serial")
public class UpdateDepart extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField tf_up_unit;
	private JTextField tf_up_unit_id;
	private JTextField tf_unit_name;
	private JTextField tf_unit_id;
	private JTextField tf_address;
	private JTextField tf_telephone;
	private JTextField tf_contact_person;
	private JTextField tf_email;
	private JTextField tf_header;
	private JTextField tf_create_date;
	private JTextArea ta_remark;
	private DepartmentDTO departDTO;
	private static UpdateDepart updateDepart;

	public static void main(String[] args) {
		try {
			UpdateDepart dialog = new UpdateDepart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UpdateDepart() {
		setTitle("修改部门信息");
		setBounds(100, 100, 571, 537);
		setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(), this
				.getHeight())));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("修改");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_update_action(e);
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton btnCancel = new JButton("取消");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UpdateDepart.this.dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}

		JLabel L_up_unit = new JLabel("   上级部门");
		L_up_unit.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_up_unit_id = new JLabel("上级部门编号");
		L_up_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_unit_name = new JLabel("   部门名称");
		L_unit_name.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_unit_id = new JLabel("   部门编号");
		L_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_address = new JLabel("     地址");
		L_address.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_telephone = new JLabel("   联系方式");
		L_telephone.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_contact_person = new JLabel("    联系人");
		L_contact_person.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_email = new JLabel("   电子邮箱");
		L_email.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_header = new JLabel("   部门简称");
		L_header.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_create_date = new JLabel("   创建时间");
		L_create_date.setFont(new Font("华文楷体", Font.BOLD, 14));
		JLabel L_remark = new JLabel("      备注");
		L_remark.setFont(new Font("华文楷体", Font.BOLD, 14));

		final JPanel labelPane = new JPanel();
		labelPane.setBackground(Color.LIGHT_GRAY);
		labelPane.setBounds(76, 10, 90, 446);
		labelPane.setLayout(new GridLayout(11, 1));
		labelPane.add(L_up_unit);
		labelPane.add(L_up_unit_id);
		labelPane.add(L_unit_name);
		labelPane.add(L_unit_id);
		labelPane.add(L_address);
		labelPane.add(L_telephone);
		labelPane.add(L_contact_person);
		labelPane.add(L_email);
		labelPane.add(L_header);
		labelPane.add(L_create_date);
		labelPane.add(L_remark);
		contentPanel.add(labelPane);

		JPanel infoPane = new JPanel();
		infoPane.setBounds(196, 10, 288, 446);
		contentPanel.add(infoPane);
		infoPane.setLayout(null);

		tf_up_unit = new JTextField(10);
		tf_up_unit.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_up_unit.setBounds(0, 0, 288, 31);
		tf_up_unit.setEditable(false);
		infoPane.add(tf_up_unit);

		tf_up_unit_id = new JTextField(10);
		tf_up_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_up_unit_id.setBounds(0, 41, 288, 31);
		tf_up_unit_id.setEditable(false);
		infoPane.add(tf_up_unit_id);

		tf_unit_name = new JTextField(10);
		tf_unit_name.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_unit_name.setBounds(0, 82, 288, 31);
		infoPane.add(tf_unit_name);

		tf_unit_id = new JTextField(10);
		tf_unit_id.setEditable(false);
		tf_unit_id.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_unit_id.setBounds(0, 123, 288, 31);
		infoPane.add(tf_unit_id);

		tf_header = new JTextField(10);
		tf_header.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_header.setBounds(0, 330, 288, 31);
		infoPane.add(tf_header);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 408, 288, 38);
		infoPane.add(scrollPane);

		ta_remark = new JTextArea();
		scrollPane.setViewportView(ta_remark);
		ta_remark.setLineWrap(true);
		ta_remark.setFont(new Font("华文楷体", Font.BOLD, 14));

		tf_create_date = new JTextField(10);
		tf_create_date.setFont(new Font("华文楷体", Font.BOLD, 14));
		infoPane.add(tf_create_date);

		tf_address = new JTextField(10);
		tf_address.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_address.setBounds(0, 164, 288, 31);
		infoPane.add(tf_address);

		tf_telephone = new JTextField(10);
		tf_telephone.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_telephone.setBounds(0, 205, 288, 31);
		infoPane.add(tf_telephone);

		tf_contact_person = new JTextField(10);
		tf_contact_person.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_contact_person.setBounds(0, 248, 288, 31);
		infoPane.add(tf_contact_person);

		tf_email = new JTextField(10);
		tf_email.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_email.setBounds(0, 288, 288, 31);
		infoPane.add(tf_email);

		tf_create_date = new JTextField(10);
		tf_create_date.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_create_date.setBounds(0, 369, 288, 31);
		DateChooser dateChooser = DateChooser.getInstance();
		dateChooser.register(tf_create_date);
		infoPane.add(tf_create_date);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UpdateDepart.this.dispose();
				DepartManage.getInstance().setClickCount(-1);
			}
		});
	}

	protected void do_update_action(ActionEvent e) {
		String unit_id = tf_unit_id.getText().trim();
		String up_unit_id = tf_up_unit_id.getText().trim();
		Object[] params = new Object[8];
		params[0] = tf_unit_name.getText().trim();
		params[1] = tf_address.getText().trim();
		params[2] = tf_telephone.getText().trim();
		params[3] = tf_contact_person.getText().trim();
		params[4] = tf_email.getText().trim();
		params[5] = tf_header.getText().trim();
		params[6] = tf_create_date.getText().trim();
		String remark = (String) ta_remark.getText().trim();

		boolean[] result = validateDepart(params);
		if (result[0]) {
			if (result[1]) {
				DepartmentDTO depart = new DepartmentDTO(unit_id, up_unit_id,
						(String) params[0], (String) params[1],
						(String) params[2], (String) params[3],
						(String) params[4], (String) params[5],
						CommonUtil.getSqlDate(params[6]), remark);
				boolean success = new Department().updateDepart(depart);
				if (success) {
					JOptionPane.showMessageDialog(null, "修改成功！");
					DepartManage.getInstance().setClickCount(-1);
					UpdateDepart.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "修改失败！");
				}
			} else {
				JOptionPane.showMessageDialog(null, "信息格式有误！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "请完善信息！");
		}
		// 更新完成设置选中记录游标为-1
		DepartManage.getInstance().setClickCount(-1);
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
		loadData();
	}

	private void loadData() {
		try {
			String up_unit_name = new Department().getDepartmentById(
					departDTO.getUp_unit_id()).getUnit_name();
			tf_up_unit.setText(up_unit_name);
			tf_up_unit_id.setText(departDTO.getUp_unit_id());
		} catch (Exception ex) {
			tf_up_unit.setText("无上级部门");
			tf_up_unit_id.setText("无上级部门");
		}
		tf_unit_name.setText(departDTO.getUnit_name());
		tf_unit_id.setText(departDTO.getUnit_id());
		tf_address.setText(departDTO.getAddress());
		tf_telephone.setText(departDTO.getTelephone());
		tf_contact_person.setText(departDTO.getContact_person());
		tf_email.setText(departDTO.getEmail());
		tf_header.setText(departDTO.getHeader());
		tf_create_date.setText(departDTO.getCreate_date().toString());
		ta_remark.setText(departDTO.getRemark());
	}

	public static void display() {
		updateDepart = new UpdateDepart();
		updateDepart.setVisible(true);
		updateDepart.setResizable(false);
	}

	public static UpdateDepart getInstance() {
		return updateDepart;
	}
}
