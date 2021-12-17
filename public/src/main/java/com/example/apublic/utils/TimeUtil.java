package com.example.apublic.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 时间的转换
 */

public class TimeUtil {
    public static String formatYear(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy", Locale.CHINA);
        return format.format(date);
    }
    public static String formatDate(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }
    public static String formatDateMillis(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }
    public static String formatDate2(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDate10(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDate9(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }
    //格式化毫秒
    public static String formatMilliSecond(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }
    public static String formatDates3(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }


    public static String formatDate7(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return format.format(date);
    }
    public static String formatDateMills(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate6(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate3(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDate4(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate5(long timeStamp) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate(long timeStamp, String formatStr) {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat(formatStr, Locale.CHINA);
        return format.format(date);
    }

    public static String formatMilliSecondDate(long timeStamp, String formatStr) {
        Date date = new Date(timeStamp);
        SimpleDateFormat format = new SimpleDateFormat(formatStr, Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);
       // format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDate3(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return format.format(date);
    }

    public static String formatDate4(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDate5(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    /**
     * 将一个时间戳转换成提示性时间字符串，如刚刚，1秒前
     *
     * @param timeStamp
     * @return
     */
    public static String convertTimeToFormat(long timeStamp) {
        long curTime = System.currentTimeMillis() / (long) 1000;
        long time = curTime - timeStamp;

        if (time < 60 && time >= 0) {
            return "刚刚";
        } else if (time >= 60 && time < 3600) {
            return time / 60 + "分钟前";
        } else if (time >= 3600 && time < 3600 * 24) {
            return time / 3600 + "小时前";
        } else if (time >= 3600 * 24 && time < 3600 * 24 * 30) {
            return time / 3600 / 24 + "天前";
        } else if (time >= 3600 * 24 * 30 && time < 3600 * 24 * 30 * 12) {
            return time / 3600 / 24 / 30 + "个月前";
        } else if (time >= 3600 * 24 * 30 * 12) {
            return time / 3600 / 24 / 30 / 12 + "年前";
        } else {
            return "刚刚";
        }
    }


    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.CHINA);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }


    /*获取系统时间 格式为："yyyy/MM/dd "*/
    public static String getCurrentDate() {
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA);
        return sf.format(d);
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString(long time) {
        time = time * 1000;
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm", Locale.CHINA);
        return sf.format(d);
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString3(long time) {
        time = time * 1000;
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日 hh:mm", Locale.CHINA);
        return sf.format(d);
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString2(long time) {
        Date d = new Date(time * 1000);
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm", Locale.CHINA);
        //sf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sf.format(d);
    }

    public static String getDateToString2(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.CHINA);
        if(date == null) {
            return "";
        }
        //simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(date);
    }

    /*将字符串转为long时间,转换成时间戳需要除以1000*/
    public static long getStringToDate(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }


    /*将字符串转为long时间,转换成时间戳需要除以1000*/
    public static long getStringToDate4(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
    /*将字符串转为long时间,转换成时间戳需要除以1000*/
    public static long getStrToLong(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    /*将字符串转为long时间,转换成时间戳需要除以1000*/
    public static long getStringToLong(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static long getStringToDate2(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 得到剩余时间
     *
     * @param start_time
     * @return
     */
    public static String getDuring(long start_time) {
        Date date = new Date();
        long restTime = start_time - TimeUtil.dateToLong(date) / 1000;
        long timeStamp = restTime;//秒
        if (timeStamp < 60 && timeStamp >= 0) {//60秒之内
            return "1分钟后";
        } else if (timeStamp >= 60 && timeStamp < 3600) {//一个小时之内
            return "" + timeStamp / 60 + "分钟后";
        } else if (timeStamp >= 3600 && timeStamp < 3600 * 24) {//一天之内
            return timeStamp / 3600 + "小时后";
        } else if (timeStamp >= 3600 * 24 && timeStamp < 3600 * 24 * 30) {//一个月之内
            return timeStamp / 3600 / 24 + "天后";
        } else if (timeStamp >= 3600 * 24 * 30 && timeStamp < 3600 * 24 * 30 * 12) {//一年之内
            return timeStamp / 3600 / 24 / 30 + "个月后";
        } else if (timeStamp >= 3600 * 24 * 30 * 12) {//n年后
            return timeStamp / 3600 / 24 / 30 / 12 + "年后";
        } else {
            if (timeStamp < 0) {
                return "1分钟后";
            } else {
                return "很久很久以后";
            }
        }
    }
    public static String formatDateWithoutSecond(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        //format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return format.format(date);
    }

    public static String formatDateWithoutTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(date);
    }
    public static long getStringToDateWithoutSeconds(String time) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

    /** * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        if(date != null){
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if (w < 0){
            w = 0;
        }
        return weekOfDays[w];
    }
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        //添加或减去指定的时间给定日历领域，基于日历的规则。例如，从日历当前的时间减去5天，您就可以通过
        tempStart.add(Calendar.DAY_OF_YEAR, 0);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        tempEnd.add(Calendar.DAY_OF_YEAR, 1);
        while (tempStart.before(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0){
            w = 0;
        }
        return weekDays[w];
    }

    public static String formatDataTime(String time) {
        try {
            SimpleDateFormat startTimeFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat startTimeTo = new SimpleDateFormat("yyyy-MM-dd");
            Date startdate = startTimeFormat.parse(time);
            return startTimeTo.format(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatCDZInvoiceTime(String time) {
        try {
            SimpleDateFormat startTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat startTimeTo = new SimpleDateFormat("MM.dd HH:mm");
            Date startdate = startTimeFormat.parse(time);
            return startTimeTo.format(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatWYCInvoiceTime(String time) {
        try {
            SimpleDateFormat startTimeFormat = new SimpleDateFormat("MM月dd日 HH:mm");
            SimpleDateFormat startTimeTo = new SimpleDateFormat("MM.dd HH:mm");
            Date startdate = startTimeFormat.parse(time);
            return startTimeTo.format(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatCouponTime(String time) {
        try {
            SimpleDateFormat startTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat startTimeTo = new SimpleDateFormat("yyyy.MM.dd");
            Date startdate = startTimeFormat.parse(time);
            return startTimeTo.format(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String formatOrderTime(String time) {
        try {
            SimpleDateFormat startTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat startTimeTo = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            Date startdate = startTimeFormat.parse(time);
            return startTimeTo.format(startdate);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getHour(long time) {
        long hours = (time % (24 * 60 * 60)) / (60 * 60);
        String hoursStr = timeStrFormat(String.valueOf(hours));
        return hoursStr;
    }

    public static String getMinute(long time) {
        long minutes = ((time % (24 * 60 * 60)) % (60 * 60)) / 60;
        String minutesStr = timeStrFormat(String.valueOf(minutes));
        return minutesStr;
    }

    public static String getSecond(long time) {
        long second = ((time % (24 * 60 * 60)) % (60 * 60)) % 60;
        String secondStr = timeStrFormat(String.valueOf(second));
        return secondStr;
    }


    private static String timeStrFormat(String timeStr) {
        switch (timeStr.length()) {
            case 1:
                timeStr = "0" + timeStr;
                break;
        }
        return timeStr;
    }

    public static String dealTime(long time) {
        StringBuffer returnString = new StringBuffer();
        long day = time / (24 * 60 * 60);
        long hours = (time % (24 * 60 * 60)) / (60 * 60);
        long minutes = ((time % (24 * 60 * 60)) % (60 * 60)) / 60;
        long second = ((time % (24 * 60 * 60)) % (60 * 60)) % 60;
        String dayStr = String.valueOf(day);
        String hoursStr = timeStrFormat(String.valueOf(hours));
        String minutesStr = timeStrFormat(String.valueOf(minutes));
        String secondStr = timeStrFormat(String.valueOf(second));

        returnString.append(hoursStr).append(":").append(minutesStr).append(":").append(secondStr);
        return returnString.toString();
    }


}
