package cn.qingjiu.yys.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	
	//取当前时间
    public static Timestamp nowTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }
    
    //String转Timestamp
    public static Timestamp strToTimestamp(String str, String formatStr) {
    	
    	formatStr = (formatStr == null) || (formatStr.trim().length() == 0) ?  "yyyy-MM-dd HH:mm:ss" : formatStr;
        SimpleDateFormat sf = new SimpleDateFormat(formatStr);
        try {
            Date date = sf.parse(str);
            Timestamp t1 = new Timestamp(date.getTime());
             return  t1;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    
    //Timestamp转String
  	public static String timestampToStr(Timestamp ts, String formatStr) {
  		
  		formatStr = (formatStr == null) || (formatStr.trim().length() == 0) ?  "yyyy-MM-dd HH:mm:ss" : formatStr;
  	    DateFormat sdf = new SimpleDateFormat(formatStr);  
  	  
  	    String tsStr = sdf.format(ts);  
  	    return tsStr; 
  	}
    
    //String转date
    public static Date strToDate(String thisDate, String formatStr) throws Exception {
		
		formatStr = (formatStr == null) || (formatStr.trim().length() == 0) ?  "yyyy-MM-dd HH:mm:ss" : formatStr;
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		try{
			return  new Timestamp(formatter.parse(thisDate).getTime());
		} catch (Exception e) {
			throw e;
		}
	}
	
    //date转String
	public static String dateToStr(Date thisDate, String formatStr) {

		formatStr = (formatStr == null) || (formatStr.trim().length() == 0) ?  "yyyy-MM-dd HH:mm:ss" : formatStr;
		SimpleDateFormat formater = new SimpleDateFormat(formatStr);
		return formater.format(thisDate);
	}
	
	//Timestamp时间差计算
	public static long dateDiff(String timeInterval, Timestamp t1, Timestamp t2) {
		Date date1 = new Date(t1.getTime());
		Date date2 = new Date(t2.getTime());
		return dateDiff(timeInterval, date1, date2);
	}

	//Date时间差计算
	public static long dateDiff(String timeInterval, Date date1, Date date2) {
		if (timeInterval.equals("year")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			int time = calendar.get(1);
			calendar.setTime(date2);
			return time - calendar.get(1);
		}
		if (timeInterval.equals("quarter")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			int time = calendar.get(1) * 4;
			calendar.setTime(date2);
			time -= calendar.get(1) * 4;
			calendar.setTime(date1);
			time += calendar.get(2) / 4;
			calendar.setTime(date2);
			return time - calendar.get(2) / 4;
		}
		if (timeInterval.equals("month")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			int time = calendar.get(1) * 12;
			calendar.setTime(date2);
			time -= calendar.get(1) * 12;
			calendar.setTime(date1);
			time += calendar.get(2);
			calendar.setTime(date2);
			return time - calendar.get(2);
		}
		if (timeInterval.equals("week")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			int time = calendar.get(1) * 52;
			calendar.setTime(date2);
			time -= calendar.get(1) * 52;
			calendar.setTime(date1);
			time += calendar.get(3);
			calendar.setTime(date2);
			return time - calendar.get(3);
		}
		if (timeInterval.equals("day")) {
			long time = date1.getTime() / 1000L / 60L / 60L / 24L;
			return time - date2.getTime() / 1000L / 60L / 60L / 24L;
		}
		if (timeInterval.equals("hour")) {
			long time = date1.getTime() / 1000L / 60L / 60L;
			return time - date2.getTime() / 1000L / 60L / 60L;
		}
		if (timeInterval.equals("minute")) {
			long time = date1.getTime() / 1000L / 60L;
			return time - date2.getTime() / 1000L / 60L;
		}
		if (timeInterval.equals("second")) {
			long time = date1.getTime() / 1000L;
			return time - date2.getTime() / 1000L;
		}
		return date1.getTime() - date2.getTime();
	}
	
	public static enum TimeInterval {
		year("year"), quarter("quarter"), month("month"), week("week"), day("day"), hour("hour"), minute("minute"), second("second");

		private final String value;

		private TimeInterval(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}

	/**
	 * @Description: 测试网络连通性
	 * @Param: []
	 * @return: boolean
	 * @Author: tjy
	 * @Date: 2019/10/16
	 */
	public static boolean isConnect(){
		boolean connect = false;
		Runtime runtime = Runtime.getRuntime();
		Process process;
		try {

			process = runtime.exec("ping " + "www.baidu.com");
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("返回值为:"+sb);
			is.close();
			isr.close();
			br.close();

			if (null != sb && !sb.toString().equals("")) {
				String logString = "";
				if (sb.toString().indexOf("TTL") > 0) {
					// 网络畅通
					connect = true;
				} else {
					// 网络不畅通
					connect = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connect;
	}

	//使用ip测试网络连通性
	public static boolean ping(String ipAddress)  {
		try {
			int  timeOut =  1000 ;  //超时时间
			boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);     // 当返回值是true时，说明host是可用的，false则不可。
			return status;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/** 
	* @Description: 对比两个字符串时间的差值(天、小时、分、秒)
	* @Param: [strTime1, strTime2] 
	* @return: void 
	* @Author: tjy
	* @Date: 2019/10/17 
	*/ 
	public static Map<String,Object> getTimeDifference(String strTime1, String strTime2) {
		//格式日期格式，在此我用的是"2018-01-24 19:49:50"这种格式
		//可以更改为自己使用的格式，例如：yyyy/MM/dd HH:mm:ss 。。。
		SimpleDateFormat df = new SimpleDateFormat("HHmmss");
		try{
			Date now = df.parse(strTime1);
			Date date=df.parse(strTime2);
			long l=now.getTime()-date.getTime(); //获取时间差
			System.out.println(l);
			long day=l/(24*60*60*1000);
			long hour=(l/(60*60*1000)-day*24);
			long min=((l/(60*1000))-day*24*60-hour*60);
			long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
			Map<String,Object> map = new HashMap<>();
			map.put("day",day);
			map.put("hour",hour);
			map.put("min",min);
			map.put("s",s);
			return map;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//判断是否是指定时间格式
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (Exception e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}
	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}


	/**
	 * 日期转星期
	 *
	 * @param datetime
	 * @return
	 */
	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
}
