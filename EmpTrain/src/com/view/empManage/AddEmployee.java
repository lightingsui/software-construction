package com.view.empManage;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.train.dto.UserDTO;
import com.train.service.Department;
import com.train.service.Duty;
import com.train.service.Education;
import com.train.service.User;
import com.util.tool.DateChooser;
import com.util.tool.SelectUnitForm;
import com.util.tool.ValidateUtil;
import com.util.tool.WindowUtil;
import java.awt.Color;

@SuppressWarnings("serial")
public class AddEmployee extends JDialog {
	private static AddEmployee addEmployee;
	private JPanel contentPane;
	private JTextField tf_username;
	private JTextField tf_ID_Card;
	private JTextField tf_tel;
	private JTextField tf_birthday;
	private JTextField tf_unit;
	private ButtonGroup btnGroup;
	private JComboBox<String> cbb_duty;
	private JComboBox<String> cbb_education;
	private JRadioButton rb_sex_male;
	private JRadioButton rb_sex_female;
	private String sex = "男";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddEmployee() {
		setTitle("添加员工信息");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.cyan);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel L_username = new JLabel("姓       名");
		L_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_username.setBounds(46, 40, 74, 26);
		contentPane.add(L_username);

		tf_username = new JTextField();
		tf_username.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_username.setBounds(157, 41, 132, 26);
		contentPane.add(tf_username);
		tf_username.setColumns(10);

		JLabel L_birthday = new JLabel("出生日期");
		L_birthday.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_birthday.setBounds(46, 87, 74, 26);
		contentPane.add(L_birthday);

		JLabel L_unit = new JLabel("部       门");
		L_unit.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_unit.setBounds(46, 142, 74, 26);
		contentPane.add(L_unit);

		JLabel L_duty = new JLabel("职       务");
		L_duty.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_duty.setBounds(46, 198, 74, 26);
		contentPane.add(L_duty);

		JLabel L_sex = new JLabel("性       别");
		L_sex.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_sex.setBounds(342, 40, 74, 26);
		contentPane.add(L_sex);

		btnGroup = new ButtonGroup();
		rb_sex_male = new JRadioButton("男");
		rb_sex_male.setBackground(Color.cyan);
		rb_sex_male.setSelected(true);
		rb_sex_male.addItemListener(sexListener);
		rb_sex_male.setBounds(478, 41, 44, 23);
		contentPane.add(rb_sex_male);
		btnGroup.add(rb_sex_male);

		rb_sex_female = new JRadioButton("女");
		rb_sex_female.setBackground(Color.cyan);
		rb_sex_female.setBounds(536, 41, 44, 23);
		rb_sex_female.addItemListener(sexListener);
		contentPane.add(rb_sex_female);
		btnGroup.add(rb_sex_female);

		JLabel L_ID_Card = new JLabel("身份证号");
		L_ID_Card.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_ID_Card.setBounds(342, 87, 74, 26);
		contentPane.add(L_ID_Card);

		tf_ID_Card = new JTextField();
		tf_ID_Card.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_ID_Card.setColumns(10);
		tf_ID_Card.setBounds(449, 88, 159, 26);
		contentPane.add(tf_ID_Card);

		JLabel L_tel = new JLabel("联系电话");
		L_tel.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_tel.setBounds(342, 142, 74, 26);
		contentPane.add(L_tel);

		JLabel L_education = new JLabel("学       历");
		L_education.setFont(new Font("华文楷体", Font.BOLD, 16));
		L_education.setBounds(342, 198, 74, 26);
		contentPane.add(L_education);

		tf_tel = new JTextField();
		tf_tel.setFont(new Font("华文楷体", Font.BOLD, 14));
		tf_tel.setColumns(10);
		tf_tel.setBounds(449, 143, 159, 26);
		contentPane.add(tf_tel);

		cbb_duty = new JComboBox<String>();
		cbb_duty.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_duty.setModel(new DefaultComboBoxModel<String>(Duty.getDutyNames()));
		cbb_duty.setBounds(157, 199, 132, 26);
		contentPane.add(cbb_duty);

		JButton btnSave = new JButton("保存");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_save_action(e);
			}
		});
		btnSave.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnSave.setBounds(197, 271, 93, 23);
		contentPane.add(btnSave);

		JButton btnExit = new JButton("退出");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_exit_action(e);
			}
		});
		btnExit.setFont(new Font("华文楷体", Font.BOLD, 16));
		btnExit.setBounds(342, 271, 93, 23);
		contentPane.add(btnExit);

		cbb_education = new JComboBox<String>();
		cbb_education.setFont(new Font("华文楷体", Font.BOLD, 16));
		cbb_education.setModel(new DefaultComboBoxModel<String>(Education
				.getEducationNames()));
		cbb_education.setBounds(449, 202, 159, 26);
		contentPane.add(cbb_education);

		tf_birthday = new JTextField();
		tf_birthday.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_birthday.setColumns(10);
		tf_birthday.setBounds(157, 88, 132, 26);
		DateChooser dateChooser = DateChooser.getInstance();
		dateChooser.register(tf_birthday);
		contentPane.add(tf_birthday);

		tf_unit = new JTextField();
		tf_unit.setFont(new Font("华文楷体", Font.BOLD, 16));
		tf_unit.setColumns(10);
		tf_unit.setBounds(157, 143, 132, 26);
		tf_unit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectUnitForm selectUnitForm = new SelectUnitForm(tf_unit);
				selectUnitForm.setVisible(true);
			}
		});
		contentPane.add(tf_unit);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					AddEmployee.this.setVisible(false);
					AddEmployee.this.dispose();
					AddEmployee.setNullInstance();
//					EmpInfoManage.getInstance().do_find_action(null);
					EmpInfoManage.getInstance().setClickCount(-1);
				} catch (Exception ex) {

				}
			}
		});
		this.setLocation(WindowUtil.setLocation(new Dimension(this.getWidth(),
				this.getHeight())));
	}

	protected void do_exit_action(ActionEvent e) {
		AddEmployee.this.dispose();
	}

	ItemListener sexListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (rb_sex_female.isSelected()) {
				sex = "女";
			}
			if (rb_sex_male.isSelected()) {
				sex = "男";
			}
		}
	};

	protected void do_save_action(ActionEvent e) {
		Object[] params = new Object[8];
		params[0] = tf_username.getText().trim();
		params[1] = sex;
		params[2] = tf_birthday.getText().trim();
		params[3] = tf_ID_Card.getText().trim();
		params[4] = tf_unit.getText().trim();
		params[5] = tf_tel.getText().trim();
		params[6] = cbb_duty.getSelectedItem();
		params[7] = cbb_education.getSelectedItem();

		boolean[] result = validateEmployee(params);

		if (!result[2]) {
			if (result[0]) {
				if (result[1]) {
					UserDTO employeeDTO = new UserDTO();
					employeeDTO.setUser_name((String) params[0]);
					employeeDTO.setName((String) params[0]);
					employeeDTO.setSex((String) params[1]);
					employeeDTO.setBirthday((String) params[2]);
					employeeDTO.setCard_id((String) params[3]);
					String[] unit = params[4].toString().split("-");

					if (unit.length > 1) {
						employeeDTO.setUnit_id(new Department().getDepartId(
								unit[0], unit[1]));
					} else {
						employeeDTO.setUnit_id(new Department()
								.getUnit(unit[0]).getUnit_id());
					}
					employeeDTO.setTelephone((String) params[5]);
					employeeDTO.setDuty((String) params[6]);
					employeeDTO.setTecduty((String) params[7]);

					boolean success = new User().saveEmployee(employeeDTO);

					if (success) {
						JOptionPane.showMessageDialog(null, "信息保存成功！");
						AddEmployee.this.dispose();
						EmpInfoManage.getInstance().setClickCount(-1);
//						EmpInfoManage.getInstance().do_find_action(e);
					} else {
						JOptionPane.showMessageDialog(null, "信息保存失败！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "信息格式有误或未满18周岁！");
				}
			} else {
				JOptionPane.showMessageDialog(null, "请完善信息！");
			}
		} else {
			JOptionPane.showMessageDialog(null, "该用户已存在！");
		}
	}

	private boolean[] validateEmployee(Object... params) {
		boolean[] result = { true, true, true };

		result[2] = new User().nameExisted((String) params[0]);
		if (result[2]) {
			// 用户存在，直接返回
			return result;
		}
		// 用户名不存在时继续

		for (int i = 0; i < params.length; i++) {
			if (result[0] && "".equals(params[i])) {
				result[0] = false;
			}
			if (result[1] && "1".equals(params[i])) {
				result[1] = false;
			}
		}

		result[1] = ValidateUtil.validateID_Card((String) params[3]);
		result[1] = ValidateUtil.validateTel((String) params[5]);

		return result;
	}

	public static void display() {
		if (addEmployee == null) {
			addEmployee = new AddEmployee();
		}
		addEmployee.setVisible(true);
		addEmployee.setResizable(false);
	}

	public static void setNullInstance() {
		if (addEmployee != null) {
			addEmployee = null;
		}
	}

	public static AddEmployee getInstance() {
		return addEmployee;
	}
}
