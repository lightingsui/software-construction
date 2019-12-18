package test;

import com.train.service.Department;

public class TestMaxDepartId {

	public TestMaxDepartId() {
	}
	
	public static void main(String[] args) {
		String maxId = new Department().getDepartMaxId("001001");
		System.out.println(maxId);
	}
}
