package test;

public class TestObject {
	public static void main(String[] args) {
		Object[] params = new Object[3];
		String str1 = "张亚超";
		String str2 = "乔磊";
		String str3 = "温时君";
		params[0] = str1;
		params[1] = str2;
		params[2] = str3;
		boolean result = true;
		
		for(int i = 0; i < params.length; i++) {
			System.out.println(params[i]);
			if("".equals(params[i])) {
				result = false;
			}
		}
		System.out.println(result);
	}
}
