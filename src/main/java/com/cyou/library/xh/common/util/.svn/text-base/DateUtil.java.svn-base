package com.cyou.library.xh.common.util;

/**
 * @author gaoxiang_nad
 */
import java.util.GregorianCalendar;

/*
 * 描述：将时间格式转换为政府文件格式
 * 输入参数：2009-09-15
 * 返回参数：二00九年九月十五日
 */
public class DateUtil {

	public static String changeDate(String dateStr) {
		StringBuffer dateSB = new StringBuffer();
		int year = 0;
		int month = 0;
		int date = 0;

		if (dateStr != null && !"".equals(dateStr) && dateStr.length() == 10) {
			// 年
			year = Integer.parseInt(dateStr.substring(0, 1));
			dateSB.append(dateToUppercase(year));
			year = Integer.parseInt(dateStr.substring(1, 2));
			dateSB.append(dateToUppercase(year));
			year = Integer.parseInt(dateStr.substring(2, 3));
			dateSB.append(dateToUppercase(year));
			year = Integer.parseInt(dateStr.substring(3, 4));
			dateSB.append(dateToUppercase(year));
			dateSB.append("年");
			// 月
			month = Integer.parseInt(dateStr.substring(5, 7));
			dateSB.append(dateToUppercase(month));
			dateSB.append("月");
			// 日
			date = Integer.parseInt(dateStr.substring(8, 10));
			dateSB.append(dateToUppercase(date));
			dateSB.append("日");
		}
		return dateSB.toString();
	}

	/*
	 * 描述：将数字转换为大写 输入参数：int 输出参数：大写
	 */
	public static String dateToUppercase(int date) {
		if (date == 0)
			return "〇";
		if (date == 1)
			return "一";
		if (date == 2)
			return "二";
		if (date == 3)
			return "三";
		if (date == 4)
			return "四";
		if (date == 5)
			return "五";
		if (date == 6)
			return "六";
		if (date == 7)
			return "七";
		if (date == 8)
			return "八";
		if (date == 9)
			return "九";
		if (date == 10)
			return "十";
		if (date == 20)
			return "二十";
		if (date == 30)
			return "三十";
		if (date > 10 && date < 20)
			return "十" + dateToUppercase(date - 10);
		if (date > 20 && date < 30)
			return "二十" + dateToUppercase(date - 20);
		if (date > 30 && date < 40)
			return "三十" + dateToUppercase(date - 30);
		return "";
	}

	// 得到当前年
	public static String getCurYear() {
		String year = "1949";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		year = gregorianCalendar.get(GregorianCalendar.YEAR) + "";
		return year;
	}

	// 得到当前月
	public static String getCurMonth() {
		String month = "10";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		month = (gregorianCalendar.get(GregorianCalendar.MONTH) + 1) + "";
		return month;
	}

	// 得到当前日
	public static String getCurDay() {
		String day = "01";
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH) + "";
		return day;
	}
}
