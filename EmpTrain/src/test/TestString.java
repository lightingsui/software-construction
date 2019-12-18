package test;

public class TestString {
	public static void main(String[] args) {
//		String info = "男";
//		System.out.println("a:" + info);
//		info = "女";
//		System.out.println("b:" + info);
		String info = "发电一部-电气1班";
		String info2 = "运输部";
		
		System.out.println(info.split("-").length);
		System.out.println(info2.split("-").length);
	}
}
