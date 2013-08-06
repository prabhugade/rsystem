package com.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	TimeZone tz=null;	
	public DateUtils()
	{
		tz=TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
	}
	public String convertdate(String date,String fromformat,String toformat)
	{
		String resultdate=null;
		Calendar calendar=Calendar.getInstance(tz);
		Date date1;
		try {
			date1 = new SimpleDateFormat(fromformat).parse(date);
			calendar.setTime(date1);
			resultdate=new SimpleDateFormat(toformat).format(calendar.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultdate;
	}
}
