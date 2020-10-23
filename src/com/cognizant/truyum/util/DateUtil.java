package com.cognizant.truyum.util;

import java.util.Date;
import java.text.*;

public class DateUtil {
	public static  Date convertToDate (String date) {
		Date parseDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy");
		try {
			parseDate=formatter.parse(date);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
}
