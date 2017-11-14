package com.chenchen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class DateUtil {

	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat datetimeOtherFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	// 格式化日期与时间
	public static String formatDatetime(Date date) {
		return datetimeFormat.format(date);
	}

	// 格式化日期与时间
	public static String formatOtherDatetime(Date date) {
		return datetimeOtherFormat.format(date);
	}

	// 格式化日期
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

	// 格式化字符串日期与时间
	public static Date parseDatetime(String date) {
		try {
			return datetimeFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 格式化字符串日期
	public static Date parseDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 得到系统时间的前三个月
	 * @return String eg：2015-09-24 currentDate:2015-12-24
	 */
	public static String getBeforeMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的前6个月
		calendar.add(Calendar.MONTH,-3);
		date = calendar.getTime();
		String beforeDate = formatDate(date);
		return beforeDate;
	}

	/**
	 * 获取某年某月的第一天(本月的第一天)
	 * @Title:getFisrtDayOfMonth
	 * @Description:
	 * @param:@return
	 * @return:String eg：2015-12-01 currentDate:2015-12-24
	 * @throws
	 */
	public static Date getFisrtDayOfMonth(Date date) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		//获取某月最小天数
//		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
//		//设置日历中月份的最小天数
//		calendar.set(Calendar.DAY_OF_MONTH, firstDay);
//		//格式化日期
//		String firstDayOfMonth = formatDate(calendar.getTime());
//		return firstDayOfMonth;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取某月最小天数
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		//设置日历中月份的最小天数
		calendar.set(Calendar.DAY_OF_MONTH, firstDay);
		//格式化日期
		Date day_first=calendar.getTime();
		return day_first;

	}

	/**
	 * 得到系统时间的前一天
	 * @param date eg：2015-12-23 currentDate:2015-12-24
	 * @return
	 */
	public static Date getBeforeDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 获取上个月的第一天
	 * @Title:getFisrtDayOfMonth
	 * @Description:
	 * @param:@return
	 * @return:String eg：2015-11-01 00:00:00 currentDate:2015-12-24
	 * @throws
	 */
	public static String getFisrtDayOfPreMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();
		//上个月第一天
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = formatDate(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
		day_first = str.toString();
		return day_first;
	}

	/**
	 * 获取上个月的最后一天
	 * @Title:getFisrtDayOfMonth
	 * @Description:
	 * @param:@return
	 * @return:String eg：2015-11-30 23:59:59 currentDate:2015-12-24
	 * @throws
	 */
	public static String getLstDayOfPreMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);        //设置为该月第一天
		calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
		String day_last = formatDate(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
		day_last = endStr.toString();
		return day_last;
	}

	/**
	 * 得到系统时间的前两个月的字符串 
	 * @return eg：2015-10
	 */
	public static String getBeforeTwoMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//获取当前时间的前6个月
		calendar.add(Calendar.MONTH,-2);
		String beforeDate = formatDate(calendar.getTime());
		beforeDate = beforeDate.substring(0,7);
		return beforeDate;
	}

	/**
	 * 获得当前时间的本月最小时间
	 * @param  2017-12-12
	 * @return  2017-12-1
	 */
	public static Date getFisrtDayOfNow() {
		Calendar calendar=Calendar.getInstance();
		Date theDate=calendar.getTime();
		GregorianCalendar gcLast=(GregorianCalendar)Calendar.getInstance();
		gcLast.setTime(theDate);
		//设置为第一天
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		Date day_first=gcLast.getTime();

		return day_first;
	}

	/**
	 * 获取当天最大时间
	 * @param date
	 * @return
	 */
	public static Date getMaxTimeOfDay(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date max_time = calendar.getTime();
		return max_time;
	}

	/**
	 * 获取当天最小时间
	 * @param date
	 * @return
	 */
	public static Date getMinTimeOfDay(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date min_time = calendar.getTime();
		return min_time;
	}

	/**
	 * 获得当月最大时间
	 * @param date 2017-6-6
	 * @return 2017-6-31
	 */
	public static Date getLastDayOfDate(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date max_time_of_month = calendar.getTime();

		return max_time_of_month;
	}


	/**
	 * 获得当月最小时间
	 * @param date 2017-6-6
	 * @return 2017-6-31
	 */
	public static Date getFirstDayOfDate(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date min_time_of_month = calendar.getTime();

		return min_time_of_month;
	}



	public static Date getAfterMonth(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		Date after_month = calendar.getTime();
		return after_month;
	}



	public static void main(String[] args) {
		String date = "2016-12-22";
		Date date1 = parseDate(date);
		System.out.println(getBeforeMonth(date1));
	}
}
