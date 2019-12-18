package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDate {
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = "2015-11-30";
		
		try {
			java.util.Date date_util = sdf.parse(date);
			java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
			System.out.println(date_sql);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
