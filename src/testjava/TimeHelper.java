package testjava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.log4j.Logger;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author 
 * @version 1.0
 */

public class TimeHelper
{
  private static Logger log = Logger.getLogger(TimeHelper.class);
  public static final int YEAR = 1;
  public static final int MONTH = 2;
  public static final int DAY = 3;
  public static final int HOUR = 4;
  public static final int MINUTE = 5;
  public static final int SECOND = 6;
  public static final int SERVER_TIME = 7;
  public static final int DB_TIME = 8;
  public static final int WEEK=9;
  
  public static String dateTimeToStr(Date date)
  {
    DateFormat df = DateFormat.getDateTimeInstance();
    return df.format(date);
  }
  
  /**
  * 字符串转换成日期
  * @param str
  * @return date
  */
  public static Date strToDate(String str,String formatStr) {
    
     SimpleDateFormat format = new SimpleDateFormat(formatStr);
     Date date = null;
     try {
      date = format.parse(str);
     } catch (ParseException e) {
      e.printStackTrace();
     }
     return date;
  }
  
  /**
   * yyyyMMddHHmmssSSS
   * @return
   */
  public static String dateTimeToStr()
  {
    //yyyyMMddHHmmssSSS
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(new Date(System.currentTimeMillis()));
  }
  /**
   * 返回指定日期指定输出格式的字符串
   * 
   * */
  public static String dateTimeToStr2(Date date,String format)
  {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(date);
  }
  
  /**
   * 获得时间差
   * @param startTime
   * @param endTime
   * @return
   */
  public static long getTimeDifference(Date startTime,Date endTime)
  {
    return startTime.getTime() - endTime.getTime();
  }

  public static int getNowYear()
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    return cal.get(Calendar.YEAR);
  }
  
  
  /**
   * 取得当前服务器时间
   * 返回时间串格式：YYYY-MM-DD HH:MM:SS
   * @return String
   */
  public static String getServerCurrentDateTime()
  {
    Date now = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
    String result = df.format(now);
    return result;
  }

  /**
   * 判断2个时间是否相同
   * @param dateTime1 String
   * @param dateTime2 String
   * @return boolean
   */
  public boolean equals(String dateTime1, String dateTime2)
  {
    if (dateTime1 == null && dateTime2 == null)
    {
      return true;
    }
    if (dateTime1 == null || dateTime2 == null)
    {
      return false;
    }
    try
    {
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      Date date1 = df.parse(dateTime1);
      Date date2 = df.parse(dateTime2);
      Calendar calendar1 = new GregorianCalendar();
      Calendar calendar2 = new GregorianCalendar();
      calendar1.setTime(date1);
      calendar2.setTime(date2);
      if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH) && calendar1.get(Calendar.HOUR_OF_DAY) == calendar2.get(Calendar.HOUR_OF_DAY) && calendar1.get(Calendar.MINUTE) == calendar2.get(Calendar.MINUTE) && calendar1.get(Calendar.SECOND) == calendar2.get(Calendar.SECOND))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (ParseException ex)
    {
      log.error("时间格式错误。");
      return false;
    }
  }

  /**
   * 取得当前服务器日期
   * 返回日期串格式：YYYY-MM-DD
   * @return String
   */
  public String getServerCurrentDate()
  {
    Date now = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
    String result = df.format(now);
    return result;
  }

  

  /**
   * 判断一个时间是否为DateTime格式
   * 是：true
   * 否：false
   * @param time String
   * @return boolean
   */
  public boolean IsDateTime(String dateTime)
  {
    if (dateTime == null)
    {
      return false;
    }
    dateTime = dateTime.trim();
    if (dateTime.indexOf(" ") == -1)
    {
      try
      {
        //检查Date格式是否合法
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
        df.parse(dateTime);
        return false;
      }
      catch (ParseException ex)
      {
        log.error("时间转换异常。" + ex.toString());
        return false;
      }
    }
    else
    {
      try
      {
        //检查Date格式是否合法
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
        df.format(df.parse(dateTime));
        return true;
      }
      catch (ParseException ex)
      {
        log.error("时间转换异常。" + ex.toString());
        return false;
      }
    }
  }

  /**
   * 把长时间格式转化为短时间格式
   * 调用方式：DateTimeToDate("2004-12-10 10:11:50")
   * 返回结果：2004-12-10
   * @param longDate String
   * @return String
   */
  public String DateTimeToDate(String longDate)
  {
    if (longDate == null)
    {
      return null;
    }
    DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
    try
    {
      return df.format(df.parse(longDate));
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 得到一个时间段，以天分隔列表。
   * 调用方式：getEveryDaysList("2004-12-31 8:00:59","2005-01-01 23:00:00")
   * 返回结果：[[2004-12-31 8:00:59, 2004-12-31 23:59:59], [2005-1-1 00:00:00, 2005-01-01 23:00:00]]
   * @param beginTime String
   * @param endTime String
   * @return ArrayList
   */
  public ArrayList DateTimeSpaceToDaysList(String beginTime, String endTime)
  {
    TimeHelper timeHelper = new TimeHelper();
    Integer intervalDays = timeHelper.getIntervalDays(beginTime, endTime);
    String beginTime_temp = beginTime;
    ArrayList timeList = new ArrayList(); //时间段
    if (intervalDays != null)
    {
      //间隔时间大于一天
      if (intervalDays.intValue() != 0)
      {
        for (int i = 0; i <= intervalDays.intValue(); i++)
        {
          ArrayList list = new ArrayList();
          list.add(beginTime_temp);
          if (i == intervalDays.intValue())
          {
            list.add(endTime);
          }
          else
          {
            list.add(timeHelper.DateTimeToDate(beginTime_temp) + " 23:59:59");
          }
          timeList.add(list);
          beginTime_temp = timeHelper.addDays(beginTime_temp, 1, 0) + " 00:00:00"; //把开始时间加一天
        }
        return timeList;
      }
      else
      {
        ArrayList list = new ArrayList();
        list.add(beginTime);
        list.add(endTime);
        timeList.add(list);
        return timeList;
      }
    }
    else
    {
      return null;
    }
  }

  /**
   * 将原时间加参数分钟，返回时间。返回时间格式：0返回date，1返回datetime
   * @param beginTime String
   * @param dayAmount int
   * @param returnFormat int
   * @return String
   */
  public String addMinutes(String beginTime, int minuteAmount, int returnFormat)
  {
    try
    {
      if (beginTime == null)
      {
        return null;
      }
      DateFormat df;
      if (returnFormat == 0)
      {
        df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else if (returnFormat == 1)
      {
        df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else
      {
        return null;
      }
      Date _beginTime = df.parse(beginTime);
      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(_beginTime);
      gc_beginTime.add(GregorianCalendar.MINUTE, minuteAmount);
      String result = df.format(gc_beginTime.getTime());
      return result;
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }
  
  public static Date addDays(Date date,int dayAmount)
  {
    GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
    gc_beginTime.setTime(date);
    gc_beginTime.add(GregorianCalendar.DATE, dayAmount);
    return gc_beginTime.getTime();
  }

  /**
   * 将原时间加参数天，返回时间。返回时间格式：0返回date，1返回datetime
   * @param beginTime String
   * @param dayAmount int
   * @param returnFormat int
   * @return String
   */
  public String addDays(String beginTime, int dayAmount, int returnFormat)
  {
    try
    {
      if (beginTime == null)
      {
        return null;
      }
      DateFormat df;
      if (returnFormat == 0)
      {
        df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else if (returnFormat == 1)
      {
        df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else
      {
        return null;
      }
      Date _beginTime = df.parse(beginTime);
      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(_beginTime);
      gc_beginTime.add(GregorianCalendar.DATE, dayAmount);
      String result = df.format(gc_beginTime.getTime());
      return result;
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 将原时间加参数月，返回时间。返回时间格式：0返回date，1返回datetime
   * @param beginTime String
   * @param dayAmount int
   * @param returnFormat int
   * @return String
   */
  public String addMonths(String beginTime, int dayAmount, int returnFormat)
  {
    try
    {
      if (beginTime == null)
      {
        return null;
      }
      DateFormat df;
      if (returnFormat == 0)
      {
        df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else if (returnFormat == 1)
      {
        df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      }
      else
      {
        return null;
      }
      Date _beginTime = df.parse(beginTime);
      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(_beginTime);
      gc_beginTime.add(GregorianCalendar.MONTH, dayAmount);
      String result = df.format(gc_beginTime.getTime());
      return result;
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }
  
  public static Date addMonths(Date beginTime, int dayAmount, int returnFormat)
  {
    try
    {
      if (beginTime == null)
      {
        return null;
      }
      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(beginTime);
      gc_beginTime.add(GregorianCalendar.MONTH, dayAmount);
      return gc_beginTime.getTime();
    }
    catch (Exception ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }
  /**
   * 得到相隔的时间分钟数
   * @param beginTime String
   * @param endTime String
   * @return int
   */
  public Long getIntervalMinutes(String beginTime, String endTime)
  {
    try
    {
      if (beginTime == null || endTime == null)
      {
        return null;
      }
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      Date _beginTime = df.parse(beginTime);
      Date _endTime = df.parse(endTime);
      Calendar _beginCalendar = new GregorianCalendar();
      Calendar _endCalendar = new GregorianCalendar();
      _beginCalendar.setTime(_beginTime);
      _endCalendar.setTime(_endTime);

      long result = getMinutes(new GregorianCalendar(_beginCalendar.get(Calendar.YEAR), _beginCalendar.get(Calendar.MONTH), _beginCalendar.get(Calendar.DAY_OF_MONTH), _beginCalendar.get(Calendar.HOUR_OF_DAY), _beginCalendar.get(Calendar.MINUTE), _beginCalendar.get(Calendar.SECOND)), new GregorianCalendar(_endCalendar.get(Calendar.YEAR), _endCalendar.get(Calendar.MONTH), _endCalendar.get(Calendar.DAY_OF_MONTH), _endCalendar.get(Calendar.HOUR_OF_DAY), _endCalendar.get(Calendar.MINUTE), _endCalendar.get(Calendar.SECOND)));
      return new Long(result);
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 得到相隔的时间小时数
   * @param beginTime String
   * @param endTime String
   * @return int
   */
  public Integer getIntervalHours(String beginTime, String endTime)
  {
    try
    {
      if (beginTime == null || endTime == null)
      {
        return null;
      }
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      Date _beginTime = df.parse(beginTime);
      Date _endTime = df.parse(endTime);
      Calendar _beginCalendar = new GregorianCalendar();
      Calendar _endCalendar = new GregorianCalendar();
      _beginCalendar.setTime(_beginTime);
      _endCalendar.setTime(_endTime);

      int result = getHours(new GregorianCalendar(_beginCalendar.get(Calendar.YEAR), _beginCalendar.get(Calendar.MONTH), _beginCalendar.get(Calendar.DAY_OF_MONTH), _beginCalendar.get(Calendar.HOUR_OF_DAY), _beginCalendar.get(Calendar.MINUTE), _beginCalendar.get(Calendar.SECOND)), new GregorianCalendar(_endCalendar.get(Calendar.YEAR), _endCalendar.get(Calendar.MONTH), _endCalendar.get(Calendar.DAY_OF_MONTH), _endCalendar.get(Calendar.HOUR_OF_DAY), _endCalendar.get(Calendar.MINUTE), _endCalendar.get(Calendar.SECOND)));
      return new Integer(result);
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 得到相隔的时间天数
   * @param beginTime String
   * @param endTime String
   * @return int
   */
  public Integer getIntervalDays(String beginTime, String endTime)
  {
    try
    {
      if (beginTime == null || endTime == null)
      {
        return null;
      }
      DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      Date _beginTime = df.parse(beginTime);
      Date _endTime = df.parse(endTime);
      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      GregorianCalendar gc_endTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(_beginTime);
      gc_endTime.setTime(_endTime);
      int result = getDays(new GregorianCalendar(gc_beginTime.get(gc_beginTime.YEAR), gc_beginTime.get(gc_beginTime.MONTH), gc_beginTime.get(gc_beginTime.DAY_OF_MONTH), gc_beginTime.get(gc_beginTime.HOUR_OF_DAY), gc_beginTime.get(gc_beginTime.MINUTE), gc_beginTime.get(gc_beginTime.SECOND)), new GregorianCalendar(gc_endTime.get(gc_endTime.YEAR), gc_endTime.get(gc_endTime.MONTH), gc_endTime.get(gc_endTime.DAY_OF_MONTH), gc_endTime.get(gc_endTime.HOUR_OF_DAY), gc_endTime.get(gc_endTime.MINUTE), gc_endTime.get(gc_endTime.SECOND)));
      return new Integer(result);
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 得到相隔的时间月份
   * @param beginTime String
   * @param endTime String
   * @return int
   */
  public Integer getIntervalMonths(String beginTime, String endTime)
  {
    try
    {
      if (beginTime == null || endTime == null)
      {
        return null;
      }
      DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
      Date _beginTime = df.parse(beginTime);
      Date _endTime = df.parse(endTime);

      GregorianCalendar gc_beginTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      GregorianCalendar gc_endTime = new GregorianCalendar(Locale.SIMPLIFIED_CHINESE);
      gc_beginTime.setTime(_beginTime);
      gc_endTime.setTime(_endTime);
      int result;
      result = getMonths(new GregorianCalendar(gc_beginTime.get(gc_beginTime.YEAR), gc_beginTime.get(gc_beginTime.MONTH), gc_beginTime.get(gc_beginTime.DAY_OF_MONTH), gc_beginTime.get(gc_beginTime.HOUR_OF_DAY), gc_beginTime.get(gc_beginTime.MINUTE), gc_beginTime.get(gc_beginTime.SECOND)), new GregorianCalendar(gc_endTime.get(gc_endTime.YEAR), gc_endTime.get(gc_endTime.MONTH), gc_endTime.get(gc_endTime.DAY_OF_MONTH), gc_endTime.get(gc_endTime.HOUR_OF_DAY), gc_endTime.get(gc_endTime.MINUTE), gc_endTime.get(gc_endTime.SECOND)));
      return new Integer(result);
    }
    catch (ParseException ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return null;
    }
  }

  /**
   * 得到相隔的时间分钟
   * @param g1 GregorianCalendar
   * @param g2 GregorianCalendar
   * @return int
   */
  private long getMinutes(GregorianCalendar g1, GregorianCalendar g2)
  {
    long elapsed = 0;
    GregorianCalendar gc1, gc2;
    boolean isPlus = true;
    if (g2.after(g1))
    {
      gc2 = (GregorianCalendar) g2.clone();
      gc1 = (GregorianCalendar) g1.clone();
    }
    else
    {
      isPlus = false;
      gc2 = (GregorianCalendar) g1.clone();
      gc1 = (GregorianCalendar) g2.clone();
    }

    gc1.clear(Calendar.MILLISECOND);
    gc1.clear(Calendar.SECOND);

    gc2.clear(Calendar.MILLISECOND);
    gc2.clear(Calendar.SECOND);

    while (gc1.before(gc2))
    {
      gc1.add(Calendar.MINUTE, 1);
      elapsed++;
    }
    if (isPlus)
    {
      return elapsed;
    }
    else
    {
      return -elapsed;
    }
  }

  /**
   * 得到相隔的时间天数
   * @param g1 GregorianCalendar
   * @param g2 GregorianCalendar
   * @return int
   */
  public int getDays(GregorianCalendar g1, GregorianCalendar g2)
  {
    int elapsed = 0;
    GregorianCalendar gc1, gc2;
    boolean isPlus = true;
    if (g2.after(g1))
    {
      gc2 = (GregorianCalendar) g2.clone();
      gc1 = (GregorianCalendar) g1.clone();
    }
    else
    {
      isPlus = false;
      gc2 = (GregorianCalendar) g1.clone();
      gc1 = (GregorianCalendar) g2.clone();
    }

    gc1.clear(Calendar.MILLISECOND);
    gc1.clear(Calendar.SECOND);
    gc1.clear(Calendar.MINUTE);
    gc1.clear(Calendar.HOUR_OF_DAY);

    gc2.clear(Calendar.MILLISECOND);
    gc2.clear(Calendar.SECOND);
    gc2.clear(Calendar.MINUTE);
    gc2.clear(Calendar.HOUR_OF_DAY);

    while (gc1.before(gc2))
    {
      gc1.add(Calendar.DATE, 1);
      elapsed++;
    }
    if (isPlus)
    {
      return elapsed;
    }
    else
    {
      return -elapsed;
    }
  }

  /**
   * 得到相隔的时间小时数
   * @param g1 GregorianCalendar
   * @param g2 GregorianCalendar
   * @return int
   */
  private int getHours(GregorianCalendar g1, GregorianCalendar g2)
  {
    int elapsed = 0;
    GregorianCalendar gc1, gc2;
    boolean isPlus = true;
    if (g2.after(g1))
    {
      gc2 = (GregorianCalendar) g2.clone();
      gc1 = (GregorianCalendar) g1.clone();
    }
    else
    {
      isPlus = false;
      gc2 = (GregorianCalendar) g1.clone();
      gc1 = (GregorianCalendar) g2.clone();
    }

    gc1.clear(Calendar.MILLISECOND);
    gc1.clear(Calendar.SECOND);
    gc1.clear(Calendar.MINUTE);
//    gc1.clear(Calendar.HOUR_OF_DAY);

    gc2.clear(Calendar.MILLISECOND);
    gc2.clear(Calendar.SECOND);
    gc2.clear(Calendar.MINUTE);
//    gc2.clear(Calendar.HOUR_OF_DAY);

    while (gc1.before(gc2))
    {
      gc1.add(Calendar.HOUR_OF_DAY, 1);
      elapsed++;
    }
    if (isPlus)
    {
      return elapsed;
    }
    else
    {
      return -elapsed;
    }
  }

  /**
   * 得到相隔的时间月数
   * @param g1 GregorianCalendar
   * @param g2 GregorianCalendar
   * @return int
   */
  private int getMonths(GregorianCalendar g1, GregorianCalendar g2)
  {
    int elapsed = 0;
    GregorianCalendar gc1, gc2;
    boolean isPlus = true;
    if (g2.after(g1))
    {
      gc2 = (GregorianCalendar) g2.clone();
      gc1 = (GregorianCalendar) g1.clone();
    }
    else
    {
      isPlus = false;
      gc2 = (GregorianCalendar) g1.clone();
      gc1 = (GregorianCalendar) g2.clone();
    }

    gc1.clear(Calendar.MILLISECOND);
    gc1.clear(Calendar.SECOND);
    gc1.clear(Calendar.MINUTE);
    gc1.clear(Calendar.HOUR_OF_DAY);
    gc1.clear(Calendar.DATE);

    gc2.clear(Calendar.MILLISECOND);
    gc2.clear(Calendar.SECOND);
    gc2.clear(Calendar.MINUTE);
    gc2.clear(Calendar.HOUR_OF_DAY);
    gc2.clear(Calendar.DATE);
    while (gc1.before(gc2))
    {
      gc1.add(Calendar.MONTH, 1);
      elapsed++;
    }
    if (isPlus)
    {
      return elapsed;
    }
    else
    {
      return -elapsed;
    }
  }

  private boolean checkDate(String date)
  {
    String year = null;
    String month = null;
    String day = null;
    if (date == null)
    {
      return false;
    }
    date = date.trim();
    try
    {
      year = date.substring(0, date.indexOf("-"));
      month = date.substring(date.indexOf("-") + 1).substring(0, date.substring(date.indexOf("-") + 1).indexOf("-"));
      day = date.substring(date.lastIndexOf("-") + 1);
    }
    catch (Exception ex)
    {
      log.error("时间转换异常。" + ex.toString());
      return false;
    }
    if (checkYear(year) && checkMonth(month) && checkDay(day) && checkYearMonthDay(year, month, day))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * 检查年的格式
   * @param year String
   * @return boolean
   */
  private boolean checkYear(String year)
  {
    try
    {
      if (Integer.parseInt(year) > 1900 && Integer.parseInt(year) < 9999)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (NumberFormatException ex)
    {
      log.error("数字格式化异常。" + ex.toString());
      return false;
    }
  }

  /**
   * 检查月的格式
   * @param month String
   * @return boolean
   */
  private boolean checkMonth(String month)
  {
    try
    {
      if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (NumberFormatException ex)
    {
      log.error("数字格式化异常。" + ex.toString());
      return false;
    }
  }

  /**
   * 检查日的格式
   * @param day String
   * @return boolean
   */
  private boolean checkDay(String day)
  {
    try
    {
      if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    catch (NumberFormatException ex)
    {
      log.error("数字格式化异常。" + ex.toString());
      return false;
    }
  }

  /**
   * 检查闰年和每月的天数
   * @param year String
   * @param month String
   * @param day String
   * @return boolean
   */
  private boolean checkYearMonthDay(String year, String month, String day)
  {
    int _year = Integer.parseInt(year);
    int _month = Integer.parseInt(month);
    int _day = Integer.parseInt(day);
    //闰年
    if (((_year % 4 == 0) && (_year % 100 != 0)) || (_year % 400 == 0))
    {
      if (_month == 2 && _day > 29)
      {
        return false;
      }
    }
    if (_month == 1 && _day > 31)
    {
      return false;
    }
    if (_month == 2 && _day > 28)
    {
      return false;
    }
    if (_month == 3 && _day > 31)
    {
      return false;
    }
    if (_month == 4 && _day > 30)
    {
      return false;
    }
    if (_month == 5 && _day > 31)
    {
      return false;
    }
    if (_month == 6 && _day > 30)
    {
      return false;
    }
    if (_month == 7 && _day > 31)
    {
      return false;
    }
    if (_month == 8 && _day > 31)
    {
      return false;
    }
    if (_month == 9 && _day > 30)
    {
      return false;
    }
    if (_month == 10 && _day > 31)
    {
      return false;
    }
    if (_month == 21 && _day > 30)
    {
      return false;
    }
    if (_month == 12 && _day > 31)
    {
      return false;
    }
    return true;
  }

  /**
   * 比较时间大小
   * @return boolean
   */
  public static boolean compare_date(String date1, String date2,String format) 
	{           
      DateFormat df = new SimpleDateFormat(format);
      try {
             java.util.Date d1 = df.parse(date1);
             java.util.Date d2 = df.parse(date2);
             if (d1.getTime() > d2.getTime())
                {
                      return true;
                }
             else if (d1.getTime() < d2.getTime()) 
               {
                      return false;
               } 
             else 
             {
                      return false;
              }
      } catch (Exception exception) {
              exception.printStackTrace();
      }
      return false;

	  }

  /**
   * 得到时间片段，如得到"2005-1-20 14:12:23"的年为2005，月为1等
   * @return String
   */
  public int getDateTimeSegment(String dateTime, int returnDateType)
  {
    int str = -1;
    Calendar calendar = new GregorianCalendar();
    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.SIMPLIFIED_CHINESE);
    try
    {
      calendar.setTime(df.parse(dateTime));
    }
    catch (ParseException ex)
    {
      log.error("时间格式转换异常：" + ex.toString());
    }
    switch (returnDateType)
    {
      case YEAR:
        str = calendar.get(Calendar.YEAR);
        break;
      case MONTH:
        str = calendar.get(Calendar.MONTH) + 1;
        break;
      case DAY:
        str = calendar.get(Calendar.DAY_OF_MONTH);
        break;
      case HOUR:
        str = calendar.get(Calendar.HOUR_OF_DAY);
        break;
      case MINUTE:
        str = calendar.get(Calendar.MINUTE);
        break;
      case SECOND:
        str = calendar.get(Calendar.SECOND);
        break;
      case WEEK:
    	str=calendar.get(Calendar.DAY_OF_WEEK);
    	break;
      default:
        str = -1;
    }
    return str;
  }
  
  public static int getWeekofYear(){
	  Date date=strToDate("2014-01-06","yyyy-MM-dd");
	  Calendar cal=Calendar.getInstance(); 
	  cal.setTime(date);
	  return cal.get(Calendar.WEEK_OF_YEAR);
  }

  public static void main(String[] args)
  {
    //PropertyConfigurator.configure("config/log4j.properties");
    TimeHelper helper = new TimeHelper();

    String a = null;
    String b = "2005-01-01 08:04:05";
    System.out.println("aa"+helper.equals(a,b));

    System.out.println("fdas" + helper.addMonths("2005-2-1 2:7:24", 24, 1)); ;

    System.out.println("fdsafdas" + helper.getServerCurrentDateTime());
    Integer test1 = helper.getIntervalHours("2004-9-2 0:0:0", "2004-9-2 23:59:59");
    Long test2 = helper.getIntervalMinutes("2004-9-2 0:0:0", "2004-9-2 23:59:59");
    System.out.println("result:" + test1);
    System.out.println("result:" + test2);

    helper.getDateTimeSegment("2005-12-20 14:12:23", TimeHelper.YEAR);
    System.out.println("YEAR:" + helper.getDateTimeSegment("2005-1-20 14:12:23", TimeHelper.YEAR));
    System.out.println("MONTH:" + helper.getDateTimeSegment("2005-12-20 14:12:23", TimeHelper.MONTH));
    System.out.println("DAY:" + helper.getDateTimeSegment("2005-1-20 14:12:23", TimeHelper.DAY));
    System.out.println("HOUR:" + helper.getDateTimeSegment("2005-1-20 14:12:23", TimeHelper.HOUR));
    System.out.println("MINUTE:" + helper.getDateTimeSegment("2005-1-20 14:12:23", TimeHelper.MINUTE));
    System.out.println("SECOND:" + helper.getDateTimeSegment("2005-1-20 14:12:23", TimeHelper.SECOND));
    
    System.out.println(helper.addDays(new Date(),2).getTime()-(new Date()).getTime());
    
    System.out.println(getWeekofYear());
    System.out.println(helper.addDays(new Date(),2).getTime()-(new Date()).getTime());
   
    System.out.println(helper.dateTimeToStr2(new Date(), "HH:mm"));
    
    System.out.println(helper.compare_date(helper.dateTimeToStr2(new Date(), "HH:mm"),"11:00","HH:mm"));

  }
}
