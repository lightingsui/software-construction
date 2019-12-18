package test;

public class TestFile {
	public static void main(String[] args) {
		String path = TestFile.class.getClassLoader()
				.getResource("./test/  aa.txt").getPath();
		// TestFile.class.getClassLoader().getResourceAsStream("./test/  aa.txt");
		System.out.println(path);
		/*
		 * 结果：/D:/lunatic/java/Git/Emp_trainSystem/EmpTrain/bin/test/%20%20aa.txt
		 */

		// String path2 = TestFile.class.getClassLoader()
		// .getResource("../images/face.jpg").getPath();
		// System.out.println(path2);
	}
}
