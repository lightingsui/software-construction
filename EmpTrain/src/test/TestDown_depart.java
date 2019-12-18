package test;

import com.train.service.Department;

public class TestDown_depart {
	public static void main(String[] args) {
		boolean result = new Department().existedDownDepart("001002");
		
		System.out.println(result);
	}
}
