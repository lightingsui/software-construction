package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// String date = "2015-11-30";
		//
		// try {
		// java.util.Date date_util = sdf.parse(date);
		// java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
		// System.out.println(date_sql);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();

		System.out.println(year + "-" + month + "-" + day);
		System.out.println(sdf.format(new Date()));
	}
}
