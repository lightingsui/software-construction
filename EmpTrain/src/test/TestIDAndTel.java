package test;

import com.util.tool.ValidateUtil;

public class TestIDAndTel {
	public static void main(String[] args) {
		String id = "411082991101063X";
		String tel = "18435155316";
		
		System.out.println(ValidateUtil.validateID_Card(id));
		System.out.println(ValidateUtil.validateTel(tel));
	}
}
