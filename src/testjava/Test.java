package testjava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public String getAdvertPlanTime(int flag, int i, int weekday) {

		String dateString = null;
		int days = 0;//当前日期的星期数与广告投放星期的相隔天数，如果指定广告在星期四投放，当前日期为星期二，则days=4-2=2
		Date date1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		//DAY_OF_WEEK 星期天是1，星期一是2，星期二是3……星期六是7，这里将日期减1对应星期一为1，星期二为2……星期天为0
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		//如果当前日期在星期weekday之前，则相差天数为weekday-week.如果今天为星期一，weekday为4，则相差4-1;
		if (week < weekday) {
			days = weekday - week;
		} else {//如果当前日期在星期weekday之后
			if (week == 0) {//如果是星期天
				days = weekday;
			} else {//如果不是星期天
				days = 7 - week + weekday;
			}
		}
		System.out.println("days>>>>>>>>>>>>>>>>>>"+days);
		System.out.println("Calendar.DATE>>>>>>>>>>>>>>>>>>"+cal.get(Calendar.DATE));
		cal.set(Calendar.DATE, (cal.get(Calendar.DATE) + days + 7 * i));
		System.out.println("Calendar.DATE>>>>>>>>>>>>>>>>>>"+cal.get(Calendar.DATE));

		int m = cal.get(Calendar.MONTH) + 1;
		System.out.println("m>>>>>>>>>>>>>>>>>>"+m);
		if (flag == 1) {// 濡傛灉鏄紑濮嬫椂闂�

			dateString = (((Integer) cal.get(Calendar.YEAR)).toString() + '-'
					+ addZero(m) + '-'
					+ addZero(cal.get(Calendar.DAY_OF_MONTH)) + " 00:00:01");

		} else if (flag == 2) {// 濡傛灉鏄粨鏉熸椂闂�
			dateString = (((Integer) cal.get(Calendar.YEAR)).toString() + '-'
					+ addZero(m) + '-'
					+ addZero(cal.get(Calendar.DAY_OF_MONTH)-1).toString() + " 23:59:59");
		}

		return dateString;
	}

	// 琛ラ浂
	public String addZero(int source) {
		if (source < 10) {
			return "0" + ((Integer) source).toString();
		} else {
			return ((Integer) source).toString();
		}
	}
	
	public String getAdvertPlanTime2(int flag, int i, int weekday) {

		String dateString = null;
		int days = 0;//当前日期的星期数与广告投放星期的相隔天数，如果指定广告在星期四投放，当前日期为星期二，则days=4-2=2
		Date date1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		//DAY_OF_WEEK 星期天是1，星期一是2，星期二是3……星期六是7，这里将日期减1对应星期一为1，星期二为2……星期天为0
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		//如果当前日期在星期weekday之前，则相差天数为weekday-week.如果今天为星期一，weekday为4，则相差4-1;
		if (week < weekday) {
			days = weekday - week;
		} else {//如果当前日期在星期weekday之后
			if (week == 0) {//如果是星期天
				days = weekday;
			} else {//如果不是星期天
				days = 7 - week + weekday;
			}
		}
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer(df1.format(new Date(date1.getTime() + days * 24 * 60 * 60 * 1000)));
		sb.append(" 00:00:01");
		//开始时间
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = null;
		try {
			date = df.parse(sb.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(flag ==1){
			dateString = df.format(new Date(date.getTime()));
		}else{
			dateString = df.format(new Date(date.getTime() + (7 * i) * 24 * 60 * 60 * 1000 -2000));
		}
		return dateString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * throw new IllegalArgumentException(
		 * "named capturing group is missing trailing '}'");
		 */
		// throw new NullPointerException("sdfsdfdf");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date tempDate = df.parse("2014-12-17 00:00:01");
		if (tempDate.before(TimeHelper.addDays(
				Calendar.getInstance().getTime(), -1))) {
			System.out.print(Calendar.getInstance().get(Calendar.YEAR));
		}
		
		Test test=new Test();
		System.out.println(">>>>>>>>>>>>>>>"+test.getAdvertPlanTime(2, 1, 4));
		System.out.println(">>>>>>>>>>>>>>>"+test.getAdvertPlanTime(1, 0, 4));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(">>>>>>>>>>>>>>>"+test.getAdvertPlanTime2(2, 1, 4));
		System.out.println(">>>>>>>>>>>>>>>"+test.getAdvertPlanTime2(1, 0, 4));
	}

}
