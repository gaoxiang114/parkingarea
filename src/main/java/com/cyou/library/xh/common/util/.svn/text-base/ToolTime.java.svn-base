package com.cyou.library.xh.common.util;

/**
 * @author gaoxiang_nad
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ToolTime {
	
	//得到当前年
	public static String getCurYear(){
		String year="1949";
		GregorianCalendar gregorianCalendar	= new GregorianCalendar();
		year = gregorianCalendar.get(GregorianCalendar.YEAR)+"";
		return year;
	}
	
	//得到当前月
	public static String getCurMonth(){
		String month="10";
	  	GregorianCalendar gregorianCalendar	= new GregorianCalendar();
	  	month = (gregorianCalendar.get(GregorianCalendar.MONTH)+1)+"";
	  	return month;
	}
	
	//得到当前日
	public static String getCurDay(){
		String day="01";
	  	GregorianCalendar gregorianCalendar	= new GregorianCalendar();
	  	day = gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH)+"";
	  	return day;
	}
	
	/**
	 * method 格式化时间
	 * @param date  需要格式化的时间
	 * @param timeFormat  格式化的规则，例如"yyyy-MM-dd"
	 * @return
	 */
	public static String getFormatTime(Date date,String timeFormat){
        try {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
			return sdf.format(date);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getParseTime(String datetime,String timeFormat){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
			return sdf.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date）,可以将“yyyy-MM-dd”字符串格式转化了Date型的“yyyy-MM-dd”
	 * @param dateString 需要转换为Date的字符串
	 * @return dataTime Date
	 * @throws ParseException 
	 */
	public final static java.sql.Date stringToDate(String dateString) throws ParseException{ 
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			dateFormat.setLenient(false);
			Date timeDate = dateFormat.parse(dateString);//util类型
			java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
			return dateTime;
		} catch (RuntimeException e){
			e.printStackTrace();
		}
		return null;
	}
}
