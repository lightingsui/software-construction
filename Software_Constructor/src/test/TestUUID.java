package test;

import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		String[] ids = new String[5];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = UUID.randomUUID().toString();
			System.out.println(i + " : " + ids[i].length());
		}

	}
}
