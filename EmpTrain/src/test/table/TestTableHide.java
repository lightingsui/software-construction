package test.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.apache.commons.dbutils.DbUtils;

@SuppressWarnings("serial")
public class TestTableHide extends JFrame {
	private JPanel contentPane;
	private JTable resultTable;
	private int clickCount = -1;

	public TestTableHide() {
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		final JScrollPane scrollPane = new JScrollPane();

		resultTable = new JTable();
		resultTable.setModel(new MyTableModel());
		resultTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount = e.getClickCount();
			}
		});

		scrollPane.add(resultTable);

		contentPane.add(scrollPane, BorderLayout.CENTER);

		final JButton btnDelete = new JButton("删除信息");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do_delete_action(e);
			}
		});
		contentPane.add(btnDelete, BorderLayout.SOUTH);
		
		setContentPane(contentPane);
		setVisible(true);
	}

	protected void do_delete_action(ActionEvent e) {
		if (clickCount != -1) {
			Object param = resultTable.getModel().getValueAt(clickCount, 0);
			new UserUtils().deleteUser((Integer) param);
		}
	}

	class MyTableModel extends AbstractTableModel {
		String[] tableHeader = { "编号", "姓名", "密码" };
		Object[][] data = { { "1", "张亚超", "359099631" },
				{ "2", "乔磊", "361849544" }, { "3", "温时君", "359099631" },
				{ "4", "刘力瑄", "0215" } };

		@Override
		public int getRowCount() {
			return data.length;
		}

		@Override
		public int getColumnCount() {
			return tableHeader.length;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return tableHeader[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return User.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			if (aValue != null) {
				data[rowIndex][columnIndex] = ((User) aValue);
			}
		}

		@Override
		public void addTableModelListener(TableModelListener l) {

		}

		@Override
		public void removeTableModelListener(TableModelListener l) {

		}

	}

	private static void createAndShowGUI() {
		new TestTableHide();
	}
	
	public static void main(String[] args) {
		createAndShowGUI();
	}

}

class UserUtils {
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
	private Statement stmt;

	// private ResultSet rs;

	public UserUtils() {
		driver = "com.mysql.jdbc.driver";
		url = "jdbc:mysql://localhost:3306/user";
		user = "root";
		password = "3590";
	}

	public boolean deleteUser(int id) {
		boolean result = true;
		int k = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "DELETE FROM user WHERE id=" + id + ";";
			k = stmt.executeUpdate(sql);
			System.out.println(k);

			result = (k == 0) ? false : true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}