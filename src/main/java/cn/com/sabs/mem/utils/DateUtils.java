package cn.com.sabs.mem.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    /** 默认日期格式 */
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    /** 默认时间格式 */
    public static final String FORMAT_TIME = "HH:mm:ss";
    /** 默认日期时间格式 */
    public static final String FORMAT_DATETIME_YYYY_MM_DD = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATETIME_YYYYMMDD = "yyyyMMdd HH:mm:ss";
    public static DateFormat datefmt = new SimpleDateFormat(FORMAT_DATETIME_YYYY_MM_DD);
    public static DateFormat yyyyMMddFmt = new SimpleDateFormat(FORMAT_DATE);

    /**
     * 获取2个时间之间的差值
     * @param startDate
     * @param endDate
     * @param pattern
     * @return
     */
    public static int getBetweenDayNum(String startDate,String endDate,String pattern) {
        Date start = null;
        Date end = null;
        try {
            start = parseToDate(startDate,pattern);
            end = parseToDate(endDate, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long l = (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24);
        return (int) l;
    }



    /**
     * 获取某月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(2, 1);
        cal.set(5, 0);
        return cal.getTime();
    }

    public static String getThisWeekMonday(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format.format(calendar.getTime());
    }

    public static String getThisWeekSunday(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return format.format(calendar.getTime());
    }

    public static String getFirstDayOfMonth(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(calendar.getTime());
    }

    public static String getLastDayOfMonth(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(calendar.getTime());
    }

    public static String getFirstDayOfForMonth(Date date, String pattern){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(gcLast.getTime());
    }

    public static String getFirstDayOfForMonth(Date date, String pattern, int day){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        date = new Date(date.getTime() - 1000 * 60 * 60 * 24 * day);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(gcLast.getTime());
    }

    public static String getLastDayOfForMonth(Date date, String pattern){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        return format.format(calendar.getTime());
    }

    public static String getLastDayOfForMonth(Date date, String pattern, int day){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        date = new Date(date.getTime() - 1000 * 60 * 60 * 24 * day);
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        return format.format(calendar.getTime());
    }

    public static int getWeekOfYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfYear(String day ,  String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = format.parse(day);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getMonthOfYear(String day ,  String pattern) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = format.parse(day);
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    //毫秒转天、小时、分
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);

        String format;
        if(days == 0 && hours == 0 && minutes ==0 ) {
            format = "";
        }else if(days == 0 && hours == 0) {
            format = minutes + "分";
        }else if(days == 0 ) {
            format = hours + "小时 " + minutes + "分";
        }else {
            format = days + "天" + hours + "小时 " + minutes + "分";
        }
        return format;
    }

    //获取两个日期中的每一天日期(包含首尾) add by yankeyu
    public static List<String> getBetweenDays(String startDate, String endDate, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date start = null;
        Date end = null;
        try {
            start = dateFormat.parse(startDate);
            end = dateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(start);
        if (start.getTime() > end.getTime()) {
            return new ArrayList<>();
        }
        int days = (int) ((end.getTime() - start.getTime()) / (1000 * 3600 * 24));
        List<String> dates = new ArrayList<>();
        for(int i = 0 ; i <= days ; i ++) {
            dates.add(dateFormat.format(calendar.getTime()));
            if (days == 0) {
                break;
            }
            calendar.add(Calendar.DATE,1);
        }
        return dates;
    }


    public static String getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        if (hour < 10){ return "0" + hour + ":00";}
        return hour + ":00";
    }

    public static String getHour(Date date,boolean minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 10) {return "0" + hour;}
        return hour + "";
    }

    public static String getMinuteTarget(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateString = sdf.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String hourString;
        if (hour < 10){ hourString = "0" + hour;}
        else {hourString = hour + "";}
        int minute = calendar.get(Calendar.MINUTE);
        if (32 <= minute) {return dateString + hourString + "30";}
        else {return dateString + hourString + "00";}
    }

    public static boolean getZero(Date date) {
        Calendar zero = Calendar.getInstance();
        zero.set(zero.get(Calendar.YEAR), zero.get(Calendar.MONTH), zero.get(Calendar.DATE) + 1, 0, 0, 0);
        Calendar ten = Calendar.getInstance();
        ten.set(ten.get(Calendar.YEAR), ten.get(Calendar.MONTH), ten.get(Calendar.DATE) + 1, 0, 1, 0);
        if( date.getTime() >= zero.getTimeInMillis() && date.getTime() <= ten.getTimeInMillis()) {
            return true;
        }
        return  false;
    }


    public static boolean getTimeScope(Date date) {
        Calendar zero = Calendar.getInstance();
        zero.set(zero.get(Calendar.YEAR), zero.get(Calendar.MONTH), zero.get(Calendar.DATE), 13, 59, 52);
        Calendar ten = Calendar.getInstance();
        ten.set(ten.get(Calendar.YEAR), ten.get(Calendar.MONTH), ten.get(Calendar.DATE) , 13, 59, 59);
        if( date.getTime() >= zero.getTimeInMillis() && date.getTime() <= ten.getTimeInMillis()) {
            return true;
        }
        return  false;
    }

    public static boolean getTimeHour(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minute = calendar.get(Calendar.MINUTE);
        if( minute == 0 && minute == 30 ) {return true;}
        return false;
    }


    /**
     * 获取前 n 天日期
     *
     * @return
     */
    public static String getCurrentDate(int n) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(System.currentTimeMillis() - 24*60*60*1000*n);
    }
    /**
     * 日期相加指定年
     * @param date
     * @param addYears
     * @return
     */
    public static Date addYears(Date date , int addYears){
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.YEAR, addYears);
        return calender.getTime();
    }

    /**
     * 加指定月
     * @param date
     * @param addMonths
     * @return
     */
    public static Date addMonth(Date date , int addMonths){
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, addMonths);
        return calender.getTime();
    }

    /**
     * 加指定天数
     * @param date
     * @param addDays
     * @return
     */
    public static Date addDay(Date date , int addDays){
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.DAY_OF_YEAR, addDays);
        return calender.getTime();
    }

    public static Date StringToDate(String dateStr, String format){
        //String dateString = "2012-12-06 ";
        Date date = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateStr);
        }
        catch (ParseException e)
        {
//            logger.warn("日期转换为字符串错误，日期：" + date.toString() + "， 格式：" + format);
        }
        return date;
    }

    /**
     * 日期格式化
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date , String format){
        if(date == null) {
            return null;
        }
        String str_date = null;
        if(format != null){
            DateFormat formater = new SimpleDateFormat(format);
            str_date = formater.format(date);
        }else{
            str_date =datefmt.format(date);
        }
        return str_date;
    }

    public static Date parseToDate(String date , String format) throws ParseException{
        if(date == null){
            return null;
        }
        Date dDate = null;
        if(format != null){
            DateFormat formater = new SimpleDateFormat(format);
            dDate = formater.parse(date);
        }else{
            DateFormat formater = yyyyMMddFmt;
            dDate =formater.parse(date);
        }

        return dDate;
    }

    /**
     * 时间的比较
     * @param d1
     * @param d2
     * @return
     */
    public static int isLessDate(Date d1 , Date d2){
        if(d1 !=null && d2!= null){
//			return d1.getTime() == d2.getTime();
            if(d1.getTime() < d2.getTime()){
                return 1;
            }else if(d1.getTime() > d2.getTime()){
                return 2;
            }else{
                return 3;
            }
        }
        return 0;
    }
    /**
     * 返回当前月的天数
     * @return
     */
    public static int getCurDayOfMonth(){
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
        return day;
    }

    /**
     * 返回小时
     * @param date1
     * @param date2
     * @return
     */
    public static long getHoursDiffTime(Date date1, Date date2){
        long start = (date1!=null ? date1.getTime() : 0);
        long end = (date2!=null ? date2.getTime() : 0);
        long diff = (start - end);
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
        return hours;
    }
    /**
     *
     */
    public static long getDaysDiffDate(Date date1, Date date2){
        long start = (date1!=null ? date1.getTime() : 0);
        long end = (date2!=null ? date2.getTime() : 0);
        long diff = (start - end);
        long days = diff / (1000 * 60 * 60 * 24);
        return days;
    }

    /**
     * 由天转为月，任意日期转为对应月的第一天
     * @param date
     * @return
     */
    public static String dateTransferForMonth(Date date) {
        String yyyyMM = DateUtils.formatDate(date,"yyyy-MM");
        return yyyyMM+"-01";
    }

    /**
     *  日期转为当前月1号
     * @param date
     * @return
     */
    public static String transDate2MonthDay(String date){
        // yyyy-MM-dd   ->     yyyy-MM-
        String monthDate = date.substring(0,8);
        String transDate = monthDate.concat("01");
        return transDate;
    }

    /**
     *  日期转为当前年1月1号
     * @param date
     * @return
     */
    public static String transDate2YearDay(String date){
        // yyyy-MM-dd   ->     yyyy-
        String monthDate = date.substring(0,5);
        String transDate = monthDate.concat("01-01");
        return transDate;

    }

    public static void main(String[] args) throws ParseException {
        //System.out.println(getLastDayOfForMonth(new Date(),"yyyy-MM-dd"));
        //System.out.println(getMonthOfYear("2018-05-01","yyyy-MM-dd")+"月");
        //System.out.println(getBetweenDays("2018-05-10","2018-05-11","yyyy-MM-dd"));

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(getZero(sdf.parse("2018-10-11 00:09:50")));
        //System.out.println(getCurrentDate(0));
        //System.out.println(getTimeHour(new Date()));
        System.out.println(getCurrentDate(0));
    }
}
