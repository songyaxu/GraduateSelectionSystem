package com.seventh.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtil {
	public static SimpleDateFormat dateformatAll= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Timestamp currentTime(){
		return new Timestamp(System.currentTimeMillis()); 
	}
	public static String getTimeWithoutMilliSecond(Timestamp time){
		return dateformatAll.format(time);
	}
}
