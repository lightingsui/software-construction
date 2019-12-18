package test.table;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableModelDemo {

	public static void main(String[] args) {
		final int WIDTH = 700;
		final int HEIGHT = 500;
		final int USER_SIZE = 10;

		final JFrame frame = new JFrame();
		frame.setTitle("基于面向对象的TableModel测试");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTable table = new JTable();
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < USER_SIZE; i++) {
			User u = new User();
			u.setId(i);
			u.setUsername("username" + i);
			u.setPassword("123");
			u.setAge(i + 20);
			u.setMarry(i % 2 == 0);
			users.add(u);
		}

		final TableModel tableModel = new MyTableModel<User>(users);
		table.setModel(tableModel);

		frame.add(new JScrollPane(table));

		Panel panel = new Panel();

		JButton btnAdd = new JButton("添加用户");
		JButton btnDelete = new JButton("删除用户（按照行来删除）");
		JButton btnDelete2 = new JButton("删除用户（按照对象来删除）");
		JButton btnUpdate = new JButton("更新用户");

		panel.add(btnAdd);
		panel.add(btnDelete);
		panel.add(btnDelete2);
		panel.add(btnUpdate);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog(frame, true);
				dialog.setSize(300, 300);

				JLabel L_id = new JLabel("用户编号：");
				final JTextField tf_id = new JTextField(25);

				JLabel L_name = new JLabel("用户姓名:");
				final JTextField tf_name = new JTextField(25);

				JLabel L_password = new JLabel("用户密码:");
				final JTextField tf_password = new JTextField(25);

				JLabel L_age = new JLabel("用户年龄：");
				final JTextField tf_age = new JTextField(25);

				final JRadioButton marry = new JRadioButton();
				marry.setText("已婚");
				marry.setSelected(true);

				final JRadioButton nomarry = new JRadioButton();
				nomarry.setText("未婚");

				final ButtonGroup group = new ButtonGroup();
				group.add(marry);
				group.add(nomarry);

				JButton btnConfirm = new JButton("确认添加");

				btnConfirm.addActionListener(new ActionListener() {

					@SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
					public void actionPerformed(ActionEvent e) {
						Integer id = Integer.parseInt(tf_id.getText());
						String username = tf_name.getText();
						String password = tf_password.getText();
						int age = Integer.parseInt(tf_age.getText());
						boolean marry = false;
						Enumeration<AbstractButton> en = group.getElements();
						while (en.hasMoreElements()) {
							AbstractButton ab = en.nextElement();
							if (ab.isSelected()) {
								marry = ab.getText().equals("已婚") ? true
										: false;
								break;
							}
						}
						User user = new User(id, username, password, age, marry);

						((MyTableModel) tableModel).addRow(user);
					}
				});

				dialog.setLayout(new FlowLayout());
				dialog.add(L_id);
				dialog.add(tf_id);
				dialog.add(L_name);
				dialog.add(tf_name);
				dialog.add(L_password);
				dialog.add(tf_password);
				dialog.add(L_age);
				dialog.add(tf_age);
				dialog.add(marry);
				dialog.add(nomarry);

				dialog.add(btnConfirm);
				dialog.setVisible(true);
			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				((MyTableModel) table.getModel()).deleteRow(rowIndex);
			}
		});

		btnDelete2.addActionListener(new ActionListener() {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();

				MyTableModel tableModel = ((MyTableModel) table.getModel());
				Integer id = (Integer) tableModel.getValueAt(rowIndex, 0);
				User u = new User();
				u.setId(id);
				tableModel.deleteRow(u);
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				final int rowIndex = table.getSelectedRow();

				final MyTableModel tableModel = ((MyTableModel) table
						.getModel());

				/*
				 * // 传统的方式是需要通过 for(int i = 0; i <
				 * tableModel.getColumnCount();i++) {
				 * tableModel.getValueAt(rowIndex, i); }
				 */
				// 现在我们采用基于OO的获取
				User user = (User) tableModel.getObjbyRowIndex(rowIndex);

				JDialog dialog = new JDialog(frame, true);
				dialog.setSize(300, 300);

				JLabel idLab = new JLabel("用户编号：");
				final JTextField idTF = new JTextField(String.valueOf(user
						.getId()), 25);

				JLabel nameLab = new JLabel("用户姓名：");
				final JTextField nameTF = new JTextField(user.getUsername(), 25);

				JLabel passwordLab = new JLabel("用户密码：");
				final JTextField passwordTF = new JTextField(
						user.getPassword(), 25);

				JLabel ageLab = new JLabel("用户年龄：");
				final JTextField ageTF = new JTextField(String.valueOf(user
						.getAge()), 25);

				final JRadioButton marry = new JRadioButton();
				marry.setText("已婚");

				final JRadioButton nomarry = new JRadioButton();
				nomarry.setText("未婚");

				if (user.getMarry()) {
					marry.setSelected(true);
				} else {
					nomarry.setSelected(true);
				}

				final ButtonGroup group = new ButtonGroup();
				group.add(marry);
				group.add(nomarry);

				JButton btnConfirm = new JButton("确认更新");

				btnConfirm.addActionListener(new ActionListener() {

					@SuppressWarnings("unchecked")
					@Override
					public void actionPerformed(ActionEvent e) {
						Integer id = Integer.parseInt(idTF.getText());
						String username = nameTF.getText();
						String password = passwordTF.getText();
						int age = Integer.parseInt(ageTF.getText());
						boolean marry = false;
						Enumeration<AbstractButton> en = group.getElements();
						while (en.hasMoreElements()) {
							AbstractButton ab = en.nextElement();
							if (ab.isSelected()) {
								marry = ab.getText().equals("已婚") ? true
										: false;
								break;
							}
						}
						User user = new User(id, username, password, age, marry);
						tableModel.update(rowIndex, user);
					}
				});

				dialog.setLayout(new FlowLayout());
				dialog.add(idLab);
				dialog.add(idTF);
				dialog.add(nameLab);
				dialog.add(nameTF);
				dialog.add(passwordLab);
				dialog.add(passwordTF);
				dialog.add(ageLab);
				dialog.add(ageTF);
				dialog.add(marry);
				dialog.add(nomarry);

				dialog.add(btnConfirm);

				dialog.setVisible(true);
			}
		});

		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	/**
	 * 请将你传入的对象以JavaBean的形式创建,自己定义的TableModel，可以直接放入对象
	 * 
	 * @author Administrator
	 * 
	 * @param <T>
	 */

	@SuppressWarnings("serial")
	static class MyTableModel<T> extends AbstractTableModel {
		private List<T> objs;
		private BeanInfo beanInfo;
		private Map<Integer, String> columnInfo = null;
		private Map<Integer, Integer> propertyInfo = null;
		private PropertyDescriptor[] pd = null;
		private int columnCount;
		@SuppressWarnings("unused")
		private Class<T> clazz;

		public MyTableModel() {
			try {
				columnInfo = new TreeMap<Integer, String>();
				propertyInfo = new HashMap<Integer, Integer>();
				Field[] fields = getClz().getDeclaredFields();
				beanInfo = Introspector.getBeanInfo(getClz());
				pd = beanInfo.getPropertyDescriptors();

				for (Field f : fields) {
					if (f.isAnnotationPresent(BeanColumn.class)) {
						// 这里没有直接写成columnCount = fields.length是因为可能某些字段不用来显示
						columnCount++;
						// 获取到Annotation
						BeanColumn bc = f.getAnnotation(BeanColumn.class);
						// 获取到该属性对应的列名称
						String columnName = bc.name();
						// 获取该名称在Table中的索引值
						int index = bc.index();
						// 通过TreeMap将列名称以及它的索引存储起来，用来显示表头信息
						columnInfo.put(index, columnName);
						/**
						 * 判断该属性在beanInfo中的索引，
						 * 最后显示是通过columnIndex--PropertyDescriptor数组中的索引，
						 * 然后获取到PropertyDescriptor来获取到具体的数据
						 */
						for (int i = 0; i < pd.length; i++) {
							String fieldName = null;
							if (f.getName().startsWith("is")) {
								fieldName = f
										.getName()
										.substring(
												f.getName().indexOf("is")
														+ "is".length())
										.toLowerCase();
							} else {
								fieldName = f.getName();
							}
							if (fieldName.equals(pd[i].getName())) {
								propertyInfo.put(index, i);
							}
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public MyTableModel(List<T> list) {
			this();
			this.objs = list;
		}

		/**
		 * 获取到泛型中的Class对象 这里还为解决，暂时先写死
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		private Class<T> getClz() {
			return (Class<T>) User.class;
		}

		/**
		 * 返回对象集合
		 * 
		 * @return
		 */
		public List<T> getObjs() {
			return objs;
		}

		/**
		 * 设置对象集合
		 * 
		 * @return objs
		 */

		public void setObjs(List<T> objs) {
			this.objs = objs;
		}

		/**
		 * 获取总的行数
		 * 
		 * @return
		 */
		@Override
		public int getRowCount() {
			if (objs != null) {
				return objs.size();
			} else {
				return 0;
			}
		}

		/**
		 * 获取总的列数
		 * 
		 * @return
		 */
		@Override
		public int getColumnCount() {
			return columnCount;
		}

		/**
		 * 返回单元格的数据做显示
		 * 
		 * @param rowIndex
		 * @param columnIndex
		 * @return
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			try {
				if (objs != null) {
					// 获取到行数据
					T t = objs.get(rowIndex);
					Integer propertyIndex = propertyInfo.get(columnIndex);
					return pd[propertyIndex].getReadMethod().invoke(t,
							new Object[] {});
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}

		/**
		 * 返回类的名称
		 */
		public String getColumnName(int column) {
			return columnInfo.get(column);
		}

		/**
		 * 返回TableCellRender渲染的类型
		 */
		public Class<?> getColumnClass(int columnIndex) {
			if (pd != null) {
				return pd[propertyInfo.get(columnIndex)].getPropertyType();
			}
			return Object.class;
		}

		/**
		 * DefaultTableModel底层也是这样完成的
		 */
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			try {
				T t = objs.get(rowIndex);
				int propIndex = propertyInfo.get(columnIndex);
				pd[propIndex].getWriteMethod().invoke(t,
						new Object[] { aValue });
				// 当数据更新完成之后，完成更新视图层
				fireTableCellUpdated(rowIndex, columnIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		/**
		 * 设置是否可以编辑
		 */
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
		}

		public void addRow(T t) {
			if (t == null) {
				throw new RuntimeException("添加失败");
			}
			objs.add(t);
			fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
		}

		/**
		 * 提供重载方法，让用户去调用
		 * 
		 * @param data
		 */
		public void addRow(List<Object> data) {

		}

		public void addRow(Object[] data) {

		}

		/**
		 * 根据对象来删除 此时需要重写对象的equals和hashCode方法，因为底层ArrayList判断对象是否
		 * 相等是通过equals方法来进行比较
		 */
		public void deleteRow(T t) {
			System.out.println("根据对象来删除/>" + (User) t);
			this.objs.remove(t);
			fireTableRowsDeleted(this.getColumnCount(), this.getColumnCount());
		}

		/**
		 * 根据行来删除
		 * 
		 * @param rowIndex
		 */
		public void deleteRow(int rowIndex) {
			System.out.println("按照行来删除/>" + (User) this.objs.get(rowIndex));
			this.objs.remove(rowIndex);
			fireTableRowsDeleted(this.getColumnCount(), this.getColumnCount());
		}

		public T getObjbyRowIndex(int rowIndex) {
			return objs.get(rowIndex);
		}

		/**
		 * 更新行数据
		 * 
		 * @param rowIndex
		 * @param t
		 */
		public void update(int rowIndex, T t) {
			this.objs.set(rowIndex, t);
			fireTableRowsUpdated(this.getColumnCount() - 1,
					this.getRowCount() - 1);
		}
	}
}
