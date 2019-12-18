package com.util.tool;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 公用方法
 * 
 * @author Sui
 *
 */
public class CommonUtil {
	private static SimpleDateFormat sdf;

	public static String getId() {
		String id = UUID.randomUUID().toString();
		return id;
	}

	/* 获取当前日期 */
	public static java.sql.Date getCurrentDate() {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(new java.util.Date());
		return getSqlDate(currentDate);
	}

	/* 获取当前时间 */
	public static Timestamp getCurrenTime() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		return timestamp;
	}

	/* 时间格式转换 */
	public static java.sql.Date getSqlDate(Object params) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date sdate_util = null;
		java.sql.Date sdate_sql = null;

		try {
			sdate_util = sdf.parse((String) params);
		} catch (ParseException ex) {
			// ex.printStackTrace();
			return null;
		}
		sdate_sql = new java.sql.Date(sdate_util.getTime());

		return sdate_sql;
	}
}
