package test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimestamp {
	public static void main(String[] args) {
		 Timestamp timestamp = new Timestamp(new Date().getTime());

		 System.out.println(timestamp);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = df.format(new Date());
//		Timestamp ts = Timestamp.valueOf(time);
//		System.out.println(ts);
	}
}
