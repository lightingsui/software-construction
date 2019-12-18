package test;

import javax.swing.JOptionPane;

public class TestReturn {

	public TestReturn() {
	}

	public static void main(String[] args) {
		validateUser();
	}

	public static boolean validateUser() {
		boolean[] result = { false, false };
		char[] pwd = { 'a', 'b', 'c' };
		String username = "123";
		String password = new String(pwd);

		System.out.println("username:" + username);
		System.out.println("password:" + password);
		
		StringBuilder builder = new StringBuilder();
		if (!"".equals(username)) {
			builder.append("username");
			result[0] = true;
		}

		if (!"".equals(password)) {
			builder.append("、password");
			result[1] = true;
		}

		if (!(result[0] && result[1])) {
			JOptionPane.showMessageDialog(null, builder.toString() + "不能为空！");
		}

		System.out.println(builder.toString());
		System.out.println(result[0] && result[1]);
		return result[0] && result[1];
	}
}
