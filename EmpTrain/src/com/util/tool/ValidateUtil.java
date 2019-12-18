package com.util.tool;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	// 使用正则表达式校验日期格式
	public static boolean validateTimeFormat(String date) {
		Pattern pattern = Pattern.compile("[12](\\d){3}-[01](\\d)-[0123](\\d)");
		Matcher matcher = pattern.matcher(date);
		if (matcher.matches() && (!date.contains("-00"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validateID_Card(String ID_Card) {
		@SuppressWarnings("deprecation")
		int current_year = new Date().getYear();
		boolean[] result = { false, false };
		/* 验证身份证号 */
		/* 验证15位身份证号 */
		Pattern pattern = Pattern
				.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		Matcher matcher = pattern.matcher(ID_Card);
		result[0] = (matcher.matches()) ? true : false;

		/* 验证18位身份证号 */
		pattern = Pattern
				.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[0-9|X|x]$");
		matcher = pattern.matcher(ID_Card);
		result[1] = (matcher.matches()) ? true : false;

		/* 验证是否达到18周岁 */
		if (result[0]) {
			StringBuilder builder = new StringBuilder("19");
			builder.append(ID_Card.substring(6, 7));
			int birthday_year = Integer.parseInt(builder.toString());
			result[0] = ((current_year - birthday_year) > 18) ? true : false;
		}
		if (result[1]) {
			int birthday_year = Integer.parseInt(ID_Card.substring(6, 9));
			result[1] = ((current_year - birthday_year) > 18) ? true : false;
		}

		return result[0] || result[1];
	}

	public static boolean validateTel(String tel) {
		boolean result = true;
		/* 验证移动手机号 */
		Pattern pattern = Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(tel);
		result = (matcher.matches()) ? true : false;
		// result = tel.matches("1[3|4|5|8][0-9]\\d{8}");

		return result;
	}
}
