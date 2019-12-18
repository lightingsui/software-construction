package test;

import com.util.tool.ValidateUtil;

public class TestValidate {
	public static void main(String[] args) {
		String str = "2015-11-12";
		boolean result = ValidateUtil.validateTimeFormat(str);

		System.out.println(result);
	}
}
