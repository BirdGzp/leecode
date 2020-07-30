//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package math.other;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String FMT_DATE_YYYY = "yyyy";
    public static final String FMT_DATE_YYYYMMDD = "yyyy-MM-dd";
    public static final String FMT_DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT_DATE_YYYYMMDDTHHMMSS_SSSXXX = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String FMT_DATE_YYYYMMDD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FMT_DATE_HHMMSS = "HH:mm:ss";
    public static final String FMT_DATE_HHMM = "HH:mm";
    public static final String FMT_DATE_SPECIAL = "yyyyMMdd";
    public static final String FMT_DATE_MMDD = "MM-dd";
    public static final String FMT_DATE_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String FMT_DATE_MMDD_HHMM = "MM-dd HH:mm";
    public static final String FMT_DATE_MMMDDD = "MM月dd日";
    public static final String FMT_DATE_YYYYMMDDHHMM_NEW = "yyyyMMddHHmm";
    public static final String FMT_DATE_YYYY年M月D日 = "yyyy年M月d日";
    public static final String FMT_DATE_YYYY年MM月DD日 = "yyyy年MM月dd日";
    public static final String FMT_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FMT_DATE_YYYY年MM月DD日HH时MM分 = "yyyy年MM月dd日HH时mm分";
    public static final String FMT_DATE_YYYYMMDDHH = "yyyyMMddHH";
    public static final String FMT_DATE_YYYYMM = "yyyyMM";
    public static final String FMT_DATE_YYYYMMDDHH_MM_SS = "yyyyMMddHH:mm:ss";
    public static final String FMT_DATE_YYYYMMDD_POINT = "yyyy.MM.dd";
    public static final String FMT_DATE_MMDDHHmm = "M月d日HH:mm";
    public static final String FMT_DATE_YYYYMMDDHHMMSS_NEW = "yyyyMMddHHmmss";
    public static final String FMT_DATE_YYYYMMDDHHMMSS_SSS = "yyyyMMddHHmmssSSS";
    public static final int _5_MIN_MILLIS = 300000;
    public static final int _1_HOUR_MILLIS = 3600000;
    public static final int _24_HOUR_MILLIS = 86400000;
    public static final int _24_HOUR_MINUTES = 1440;

    public DateUtil() {
    }

    public static String formatDate(Date target, String format) {
        return target == null ? "" : (new SimpleDateFormat(format)).format(target);
    }

    public static String formatDate(Date target) {
        return formatDate(target, "yyyy-MM-dd");
    }

    public static String formatTimestamp(Timestamp time, String format) {
        return time == null ? "" : (new SimpleDateFormat(format)).format(time);
    }

    public static Date formatToDate(String date, String format) {
        try {

                SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
                return new Date(sorceFmt.parse(date).getTime());
        } catch (ParseException var3) {
            return null;
        }
    }

    public static Timestamp formatToTimestamp(String dateStr, String format) {

            try {
                SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
                return new Timestamp(sorceFmt.parse(dateStr).getTime());
            } catch (ParseException var3) {
                return null;
            }

    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d = new Date(System.currentTimeMillis());
        return sdf.format(d);
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date(System.currentTimeMillis());
        return sdf.format(d);
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date(System.currentTimeMillis());
        return sdf.format(d);
    }

    public static Timestamp getIntervalYear(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, years);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Date getIntervalDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static Timestamp getIntervalDayTimestamp(Timestamp timestamp, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(5, days);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getIntervalMonthTimestamp(Timestamp timestamp, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(2, months);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Date getIntervalHour(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(11, hours);
        return calendar.getTime();
    }

    public static Date getIntervalMinute(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minutes);
        return calendar.getTime();
    }

    public static Timestamp getIntervalMinuteTimestamp(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minutes);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getIntervalMinuteTimestamp(Timestamp timestamp, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(12, minutes);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getIntervalSecond(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(13, seconds);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getIntervalSecond(long timestamp, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.add(13, seconds);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getIntervalTimestamp(Date date, int days) {
        return new Timestamp(getIntervalDate(date, days).getTime());
    }

    public static boolean isToday(Date date) {
        return isSameDay(date, new Date());
    }

    public static boolean isThisMonth(Timestamp date) {
        Calendar source = Calendar.getInstance();
        source.setTimeInMillis(date.getTime());
        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(getCurrentTimestamp().getTime());
        return isSameMonth(source, today);
    }

    public static boolean isSameMonth(Calendar source, Calendar target) {
        if (source != null && target != null) {
            SimpleDateFormat sorceFmt = new SimpleDateFormat("yyyy-MM");
            String sourceDate = sorceFmt.format(source.getTime());
            String targetDate = sorceFmt.format(target.getTime());
            return true;
        } else {
            return false;
        }
    }

    public static Date getDateBeforeMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(new Date());
        calendar.add(2, -month);
        Date dayBeforeHalfYear = new Date(calendar.getTimeInMillis());
        return dayBeforeHalfYear;
    }

    public static Timestamp getBeginOfToday() {
        return getBeginOfThisDay(new Date());
    }

    public static Timestamp getEndOfToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 23:59:59";
        Date date = null;

        try {
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = form.parse(dateStr);
        } catch (ParseException var5) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static Timestamp getEndOfDay(Date now) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(now.getTime()) + " 23:59:59";
        Date date = null;

        try {
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = form.parse(dateStr);
        } catch (ParseException var5) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static Timestamp getBeginOfThisDay(Date time) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(time);
        Date date = null;

        try {
            date = form.parse(dateStr);
        } catch (ParseException var5) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static String getBeginOfNextDay(String date) {
        return getBeginOfNextDay(date, "yyyy-MM-dd");
    }

    public static String getBeginOfNextDay(String date, String format) {
        Timestamp time = formatToTimestamp(date, format);
        if (time == null) {
            return null;
        } else {
            Timestamp timestampAfter = getTimestampAfter(time, 1);
            return formatDate(timestampAfter, "yyyy-MM-dd HH:mm:ss");
        }
    }

    public static Timestamp getBeginOfThisMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(5, 1);
        String dateStr = form.format(cal.getTime()) + " 00:00:00";
        Date date = null;

        try {
            date = form.parse(dateStr);
        } catch (ParseException var5) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static Timestamp getTimestamp(String time) {
        return new Timestamp(Long.parseLong(time));
    }

    public static Timestamp getTimestampAfter(Date from, int days) {
        return getIntervalTimestamp(from, days);
    }

    public static Timestamp getTimestampAfterMonth(Date from, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        calendar.add(2, months);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Date getTimestampAfterHours(Timestamp from, int hours) {
        Date dayFrom = new Date(from.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayFrom);
        calendar.add(10, hours);
        return calendar.getTime();
    }

    public static long formatAndGetTimeLongValue(Date time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date formatTime = null;

        try {
            formatTime = sdf.parse(sdf.format(time.getTime()));
        } catch (ParseException var5) {
            formatTime = new Date();
        }

        return formatTime.getTime() / 1000L;
    }

    public static boolean checkTimeRange(Calendar source, Calendar target, int range, int Unit) {
        if (source != null && target != null && range != 0) {
            if (source.before(target)) {
                source.add(Unit, range);
                if (source.compareTo(target) >= 0) {
                    return true;
                }
            } else {
                source.add(Unit, range * -1);
                if (source.compareTo(target) <= 0) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean isSameDay(Date source, Date target) {
        if (source != null && target != null) {
            SimpleDateFormat sorceFmt = new SimpleDateFormat("yyyy-MM-dd");
            String sourceDate = sorceFmt.format(source);
            String targetDate = sorceFmt.format(target);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDateFormat(String dateStr, String dateFormat) {
        if (dateStr != null && !dateStr.equals("")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false);
                sdf.parse(dateStr);
                return true;
            } catch (ParseException var3) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Timestamp getTimestampByDiffMinute(long minute) {
        Calendar cal = Calendar.getInstance();
        long time = cal.getTimeInMillis() + minute * 60L * 1000L;
        return new Timestamp(time);
    }

    public static String getIntervalDate(Date date2Get, String format, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date2Get);
        c.add(6, days);
        String dateToGet = (new SimpleDateFormat(format)).format(c.getTime());
        return dateToGet;
    }

    public static String convertTime(Timestamp timestamp) {
        long begin_time_gap = getBeginOfToday().getTime() - timestamp.getTime();
        long time_gap = System.currentTimeMillis() - timestamp.getTime();
        SimpleDateFormat form;
        if (begin_time_gap > 86400000L) {
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return form.format(timestamp);
        } else if (begin_time_gap > 0L) {
            form = new SimpleDateFormat("HH:mm");
            return "昨天 " + form.format(timestamp);
        } else if (time_gap >= 3600000L) {
            form = new SimpleDateFormat("HH:mm");
            return "今天 " + form.format(timestamp);
        } else if (time_gap >= 60000L) {
            return time_gap / 60000L + "分钟前";
        } else {
            return time_gap > 1000L ? time_gap / 1000L + "秒前" : "";
        }
    }

    public static Date getDate(int year, int month, int day) {
        return getDate(year, month, day, 0, 0, 0);
    }

    public static Date getDate(int year, int month, int day, int hour, int minute, int second) {
        Date ts = null;
        Date dt = null;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, minute, second);
        dt = calendar.getTime();
        ts = new Date(dt.getTime());
        return ts;
    }

    public static String formatDateYYYYMMDDHH(Timestamp timestamp) {
        return timestamp == null ? null : (new SimpleDateFormat("yyyyMMddHH")).format(timestamp);
    }

    public static Date parseUtilDate(String strDate, String nFmtDate) {
        if (strDate != null && strDate.trim().length() != 0) {
            SimpleDateFormat fmtDate = null;
            byte var4 = -1;
            switch(nFmtDate.hashCode()) {
            case -2126457984:
                if (nFmtDate.equals("HH:mm:ss")) {
                    var4 = 5;
                }
                break;
            case -2041686048:
                if (nFmtDate.equals("yyyyMMddHH:mm:ss")) {
                    var4 = 6;
                }
                break;
            case -159776256:
                if (nFmtDate.equals("yyyy-MM-dd")) {
                    var4 = 1;
                }
                break;
            case 68697690:
                if (nFmtDate.equals("HH:mm")) {
                    var4 = 4;
                }
                break;
            case 1333195168:
                if (nFmtDate.equals("yyyy-MM-dd HH:mm:ss")) {
                    var4 = 2;
                }
                break;
            case 1349114208:
                if (nFmtDate.equals("yyyyMMddHHmmss")) {
                    var4 = 3;
                }
            }

            switch(var4) {
            case 1:
            default:
                fmtDate = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 2:
                fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case 3:
                fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            case 4:
                fmtDate = new SimpleDateFormat("HH:mm");
                break;
            case 5:
                fmtDate = new SimpleDateFormat("HH:mm:ss");
                break;
            case 6:
                fmtDate = new SimpleDateFormat("yyyyMMddHH:mm:ss");
            }

            try {
                return fmtDate.parse(strDate);
            } catch (ParseException var5) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static long getDaysBetween(Date begin, Date end) {
        Date beginOfStart = getBeginOfThisDay(begin);
        Date beginOfEnd = getBeginOfThisDay(end);
        long oneday = 86400000L;
        return (beginOfEnd.getTime() - beginOfStart.getTime()) / oneday;
    }

    public static Timestamp getDefaultOrIntervalMinTimestamp(Timestamp dealTime, String intervalTime, String defaultTime) {
        Timestamp time;

            time = getIntervalMinuteTimestamp(dealTime, Integer.parseInt(defaultTime));

            time = getIntervalMinuteTimestamp(dealTime, Integer.parseInt(intervalTime));


        return time;
    }

    public static Map<String, Timestamp> getStartTimeAndEndTimeForKScheduleTask(String dealTime, String startIntervalMin, String endIntervalMin, String defaultStartTime, String defaultEndTime) {
        Map<String, Timestamp> map = new HashMap();
        Timestamp dTime;

            dTime = formatToTimestamp(dealTime, "yyyyMMddHHmm");

        Timestamp sTime = getDefaultOrIntervalMinTimestamp(dTime, startIntervalMin, defaultStartTime);
        Timestamp eTime = getDefaultOrIntervalMinTimestamp(dTime, endIntervalMin, defaultEndTime);
        if (sTime.after(eTime)) {
            Timestamp temp = sTime;
            sTime = eTime;
            eTime = temp;
        }

        map.put("startTime", sTime);
        map.put("endTime", eTime);
        return map;
    }

    public static Timestamp getTimestampForMinute(long time) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = form.format(new Date(time)) + ":00";
        Date date = null;

        try {
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = form.parse(dateStr);
        } catch (ParseException var6) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static Timestamp getTodayTargetHour(int hour) {
        Calendar instance = Calendar.getInstance();
        instance.set(11, hour);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return new Timestamp(instance.getTime().getTime());
    }

    public static Timestamp getTargetHour(Timestamp timestamp, int hour) {
        Date dayFrom = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayFrom);
        calendar.set(11, hour);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static boolean isMonday(Timestamp timestamp) {
        if (timestamp == null) {
            return false;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timestamp.getTime());
            int day = calendar.get(7);
            return 2 == day;
        }
    }

    public static String formatDate(String src, String srcFormat, String targetFormat) {
        String result = "";
        Date date = formatToDate(src, srcFormat);
        result = formatDate(date, targetFormat);
        return result;
    }

    public static Timestamp getEarliestTime(List<Timestamp> list) {
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return (Timestamp)list.get(0);
            } else {
                Collections.sort(list, new Comparator<Timestamp>() {
                    public int compare(Timestamp o1, Timestamp o2) {
                        if (o1 == null) {
                            return -1;
                        } else if (o2 == null) {
                            return 1;
                        } else {
                            return o1.getTime() > o2.getTime() ? 1 : -1;
                        }
                    }
                });
                return (Timestamp)list.get(0);
            }
        } else {
            return null;
        }
    }
}
