package com.game.www.wfcc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String getWeekOfDate(Date date) {      
	    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(date);      
	    }        

	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    

	}

	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateTimeFormat = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd");
		}
	};

	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat2 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy/MM/dd");
		}
	};
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat3 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy.MM.dd");
		}
	};
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat5 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy年MM月dd日");
		}
	};
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat4 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM.dd");
		}
	};
	/** 时间格式 */
	private final static ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	/** 时间格式 */
	private final static ThreadLocal<SimpleDateFormat> timeFormat2 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> timeFormat3 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> timeFormat4 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd HH:mm");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> timeFormat5 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy年MM月dd日 HH时");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> timeFormat6 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm:ss");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> timeFormat7 = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM.dd HH:mm");
		}
	};


	/**
	 * 获取当前时间:Date
	 */
	public static Date getDate(){
		return new Date();
	}

	/**
	 * 获取当前时间:Calendar
	 */
	public static Calendar getCal(){
		return Calendar.getInstance();
	}
	/**
	 * 获取指定时间:Calendar
	 */
	public static Calendar getCalByData(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;

	}

	/**
	 * 日期转换为字符串:yyyy-MM-dd
	 */
	public static String dateToStr(Date date){
		if(date != null)
			return dateFormat.get().format(date);
		return null;
	}
	public static String dateToStr3(Date date){
		if(date != null)
			return dateFormat3.get().format(date);
		return null;
	}
	public static String dateToStr4(Date date){
		if(date != null)
			return dateFormat4.get().format(date);
		return null;
	}
	public static String dateToStr5(Date date){
		if(date != null)
			return dateFormat5.get().format(date);
		return null;
	}
	public static String dateToStr2(Date date){
		if(date != null)
			return dateFormat2.get().format(date);
		return null;
	}
	public static String dateTimeToStr3(Date date){
		if(date != null)
			return timeFormat3.get().format(date);
		return null;
	}

	public static String dateTimeToStr4(Date date){
		if(date != null)
			return timeFormat4.get().format(date);
		return null;
	}
	public static String dateTimeToStr5(Date date){
		if(date != null)
			return timeFormat5.get().format(date);
		return null;
	}
	/**
	 * 日期转换为字符串:MM-dd
	 */
	public static String dateTimeToStr(Date date){
		if(date != null)
			return dateTimeFormat.get().format(date);
		return null;
	}
	/**
	 * 时间转换为字符串:yyyy-MM-dd HH:mm:ss
	 */
	public static String timeToStr(Date date){
		if(date != null)
			return timeFormat.get().format(date);
		return null;
	}
	public static String timeToStr6(Date date){
		if(date != null)
			return timeFormat6.get().format(date);
		return null;
	}
	/**
	 * 时间转换为字符串:HH:mm:ss
	 */
	public static String timeToStr2(Date date){
		if(date != null)
			return timeFormat2.get().format(date);
		return null;
	}
	public static String timeToStr3(Date date){
		if(date != null)
			return timeFormat3.get().format(date);
		return null;
	}
	public static String timeToStr7(Date date){
		if(date != null)
			return timeFormat7.get().format(date);
		return null;
	}
	public static String timeToStr4(Date date){
		if(date != null)
			return timeFormat4.get().format(date);
		return null;
	}
	/**
	 * 字符串转换为日期:yyyy-MM-dd
	 */
	public static Date strToDate(String str){
		Date date = null;
		try {
			date = dateFormat.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转换为时间:yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToTime(String str){
		Date date = null;
		try {
			date = timeFormat.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date strToTime5(String str){
		Date date = null;
		try {
			date = timeFormat5.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 友好的方式显示时间
	 */
	public static String friendlyFormat(String str){
		Date date = strToTime(str);
		if(date == null)
			return ":)";
		Calendar now = getCal();
		String time = new SimpleDateFormat("HH:mm").format(date);

		// 第一种情况，日期在同一天
		String curDate = dateFormat.get().format(now.getTime());
		String paramDate = dateFormat.get().format(date);
		if(curDate.equals(paramDate)){
			return "今天 " + time;
		}

		// 第二种情况，不在同一天
		int days = (int) ((getBegin(getDate()).getTime() - getBegin(date).getTime()) / 86400000 );
		if(days == 1 )
			return "昨天 "+time;
		if(days == -1 )
			return "明天 "+time;
		if(days <= 7)
			return getWeekOfDate(date) + " " + time;
		return dateTimeToStr4(date);
	}

	/**
	 * 友好的方式显示时间
	 */
	public static String friendlyFormat3(String str){
		Date date = strToTime(str);
		if(date == null)
			return ":)";
		Calendar now = getCal();
		String time = new SimpleDateFormat("HH:mm").format(date);

		// 第一种情况，日期在同一天
		String curDate = dateFormat.get().format(now.getTime());
		String paramDate = dateFormat.get().format(date);
		if(curDate.equals(paramDate)){
			return "今天";
		}

		// 第二种情况，不在同一天
		int days = (int) ((getBegin(getDate()).getTime() - getBegin(date).getTime()) / 86400000 );
		if(days == 1 )
			return "昨天 ";
		if(days == 2)
			return "前天 ";
		return dateToStr(date);
	}
	/**
	 * 友好的方式显示时间
	 */
	public static String friendlyFormat2(String str){
		Date date = strToTime(str);
		if(date == null)
			return ":)";
		Calendar now = getCal();
		String time = new SimpleDateFormat("HH:mm").format(date);

		// 第一种情况，日期在同一天
		String curDate = dateFormat.get().format(now.getTime());
		String paramDate = dateFormat.get().format(date);
		if(curDate.equals(paramDate)){
			return "今天";
		}

		// 第二种情况，不在同一天
		int days = (int) ((getBegin(getDate()).getTime() - getBegin(date).getTime()) / 86400000 );
		if(days == 1 )
			return "昨天 ";
		if(days == 2)
			return "前天 ";
		return null;
	}

	/**
	 * 返回日期的0点:2012-07-07 20:20:20 --> 2012-07-07 00:00:00
	 */
	public static Date getBegin(Date date){
		return strToTime(dateToStr(date)+" 00:00:00");
	}




	public static int getYear(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR);
		return year;
	}
	public static int getMonth(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int month = c.get(Calendar.MONTH);
		return month + 1;
	}
	public static int getDay(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int date = c.get(Calendar.DATE);
		return date;
	}
	public static int getHour(){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	public static int getHour(Date date){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	public static int getYear(Date date){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year;
	}
	public static int getMonth(Date date){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		return month + 1;
	}
	public static int getDay(Date date){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		return day;
	}


	/**
	 * create date:2010-5-22下午04:29:37
	 * 描述：将日期转换为指定格式字符串
	 * @param date  日期
	 * @return
	 */
	public static String getDateStr(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		String datestr = sdf.format(date);
		return datestr;
	}
	/**
	 * create date:2010-5-22下午03:40:44
	 * 描述：取出日期字符串中的年份字符串
	 * @param str 日期字符串
	 * @return
	 */
	public static String getYearStr(String str)
	{
		String yearStr = "";
		yearStr = str.substring(0,4);
		return yearStr;
	}

	/**
	 * create date:2010-5-22下午03:40:47
	 * 描述：取出日期字符串中的月份字符串
	 * @return
	 */
	public static String getMonthStr(String str)
	{
		String m;
		int startIndex = str.indexOf("年");
		int endIndex = str.indexOf("月");
		m = str.substring(startIndex+1,endIndex);
		return m;
	}

	/**
	 * create date:2010-5-22下午03:32:31
	 * 描述：将源字符串中的阿拉伯数字格式化为汉字
	 * @param sign 源字符串中的字符
	 * @return
	 */
	public static char formatDigit(char sign){
		if(sign == '0')
			sign = '0';
		if(sign == '1')
			sign = '一';
		if(sign == '2')
			sign = '二';
		if(sign == '3')
			sign = '三';
		if(sign == '4')
			sign = '四';
		if(sign == '5')
			sign = '五';
		if(sign == '6')
			sign = '六';
		if(sign == '7')
			sign = '七';
		if(sign == '8')
			sign = '八';
		if(sign == '9')
			sign = '九';
		return sign;
	}

	/**
	 * create date:2010-5-22下午03:31:51
	 * 描述： 获得月份字符串的长度
	 * @param str  待转换的源字符串
	 * @param pos1 第一个'-'的位置
	 * @param pos2 第二个'-'的位置
	 * @return
	 */
	public static int getMidLen(String str,int pos1,int pos2){
		return str.substring(pos1+1, pos2).length();
	}
	/**
	 * create date:2010-5-22下午03:32:17
	 * 描述：获得日期字符串的长度
	 * @param str  待转换的源字符串
	 * @param pos2 第二个'-'的位置
	 * @return
	 */
	public static int getLastLen(String str,int pos2){
		return str.substring(pos2+1).length();
	}

	/**
	 * create date:2010-5-22下午03:40:50
	 * 描述：取出日期字符串中的日字符串
	 * @param str 日期字符串
	 * @return
	 */
	public static String getDayStr(String str)
	{
		String dayStr = "";
		int startIndex = str.indexOf("月");
		int endIndex = str.indexOf("日");
		dayStr = str.substring(startIndex+1,endIndex);
		return dayStr;
	}


	public static String formatStrToM(String str){
		StringBuffer sb = new StringBuffer();
		int pos1 = str.indexOf("-");
		int pos2 = str.lastIndexOf("-");
		if(getMidLen(str,pos1,pos2) == 1){
			sb.append(formatDigit(str.charAt(5))+"月");
		}
		if(getMidLen(str,pos1,pos2) == 2){
			if(str.charAt(5) != '0' && str.charAt(6) != '0'){
				sb.append("十"+formatDigit(str.charAt(6))+"月");
			}
			else if(str.charAt(5) != '0' && str.charAt(6) == '0'){
				sb.append("十月");
			}
			else{
				sb.append(formatDigit(str.charAt(6))+"月");
			}
		}
		return sb.toString();
	}
	/**
	 * create date:2010-5-22下午03:32:46
	 * 描述：格式化日期
	 * @param str 源字符串中的字符
	 * @return
	 */
	public static String formatStr(String str){
		StringBuffer sb = new StringBuffer();
		int pos1 = str.indexOf("-");
		int pos2 = str.lastIndexOf("-");
		for(int i = 0; i < 4; i++){
			sb.append(formatDigit(str.charAt(i)));
		}
		sb.append('年');
		if(getMidLen(str,pos1,pos2) == 1){
			sb.append(formatDigit(str.charAt(5))+"月");
			if(str.charAt(7) != '0'){
				if(getLastLen(str, pos2) == 1){
					sb.append(formatDigit(str.charAt(7))+"日");
				}
				if(getLastLen(str, pos2) == 2){
					if(str.charAt(7) != '1' && str.charAt(8) != '0'){
						sb.append(formatDigit(str.charAt(7))+"十"+formatDigit(str.charAt(8))+"日");
					}
					else if(str.charAt(7) != '1' && str.charAt(8) == '0'){
						sb.append(formatDigit(str.charAt(7))+"十日");
					}
					else if(str.charAt(7) == '1' && str.charAt(8) != '0'){
						sb.append("十"+formatDigit(str.charAt(8))+"日");
					}
					else{
						sb.append("十日");
					}
				}
			}
			else{
				sb.append(formatDigit(str.charAt(8))+"日");
			}
		}
		if(getMidLen(str,pos1,pos2) == 2){
			if(str.charAt(5) != '0' && str.charAt(6) != '0'){
				sb.append("十"+formatDigit(str.charAt(6))+"月");
				if(getLastLen(str, pos2) == 1){
					sb.append(formatDigit(str.charAt(8))+"日");
				}
				if(getLastLen(str, pos2) == 2){
					if(str.charAt(8) != '0'){
						if(str.charAt(8) != '1' && str.charAt(9) != '0'){
							sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
						}
						else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
							sb.append(formatDigit(str.charAt(8))+"十日");
						}
						else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
							sb.append("十"+formatDigit(str.charAt(9))+"日");
						}
						else{
							sb.append("十日");
						}
					}
					else{
						sb.append(formatDigit(str.charAt(9))+"日");
					}
				}
			}
			else if(str.charAt(5) != '0' && str.charAt(6) == '0'){
				sb.append("十月");
				if(getLastLen(str, pos2) == 1){
					sb.append(formatDigit(str.charAt(8))+"日");
				}
				if(getLastLen(str, pos2) == 2){
					if(str.charAt(8) != '0'){
						if(str.charAt(8) != '1' && str.charAt(9) != '0'){
							sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
						}
						else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
							sb.append(formatDigit(str.charAt(8))+"十日");
						}
						else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
							sb.append("十"+formatDigit(str.charAt(9))+"日");
						}
						else{
							sb.append("十日");
						}
					}
					else{
						sb.append(formatDigit(str.charAt(9))+"日");
					}
				}
			}
			else{
				sb.append(formatDigit(str.charAt(6))+"月");
				if(getLastLen(str, pos2) == 1){
					sb.append(formatDigit(str.charAt(8))+"日");
				}
				if(getLastLen(str, pos2) == 2){
					if(str.charAt(8) != '0'){
						if(str.charAt(8) != '1' && str.charAt(9) != '0'){
							sb.append(formatDigit(str.charAt(8))+"十"+formatDigit(str.charAt(9))+"日");
						}
						else if(str.charAt(8) != '1' && str.charAt(9) == '0'){
							sb.append(formatDigit(str.charAt(8))+"十日");
						}
						else if(str.charAt(8) == '1' && str.charAt(9) != '0'){
							sb.append("十"+formatDigit(str.charAt(9))+"日");
						}
						else{
							sb.append("十日");
						}
					}
					else{
						sb.append(formatDigit(str.charAt(9))+"日");
					}
				}
			}
		}
		return sb.toString();
	}


	public static int getDayCountByM(int y , int m){
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR,y);
			cal.set(Calendar.MONTH, m - 1);
			int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
			return dateOfMonth;
		}catch (Exception e){
			return -1;
		}
	}

}
