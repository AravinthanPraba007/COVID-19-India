package com.aravinthan.covid19.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateTimeHelperService {

	
	public static String changeDateFormatToReadableString(String date) {	
		Date givenDate =new Date();
		String resultDate="";
		try {
		 givenDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
		 resultDate=changeDateTimeToHumanReadable(givenDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultDate;
	}
	public static String changeDateTimeToHumanReadable(Date givenDate) throws ParseException {
		DateFormat localFormat = new SimpleDateFormat("EEE, dd MMMM yyyy' at 'hh:mm aa");
		return localFormat.format(givenDate);
	}
}
