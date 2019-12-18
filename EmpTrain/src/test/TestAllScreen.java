package test;

import com.util.tool.WindowUtil;

public class TestAllScreen {

	public static void main(String[] args) {
		System.out.println(WindowUtil.getAllScreen());
		System.out.println("width/>" + WindowUtil.getAllScreen().getWidth());
		System.out.println("height/>" + WindowUtil.getAllScreen().getHeight());
		// 1366.0
		// 768.0
	}
}
