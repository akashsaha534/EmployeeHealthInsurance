package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BusinessDayCalculator {
	private final String DATE_FORMAT = "yyyy-MM-ss HH:mm:ss";
	private final int OFFICE_START_HOUR = 9;
	private final int OFFICE_CLOSE_HOUR = 18;
	private final int TOTAL_MINS_IN_BUSINESS_DAY = (OFFICE_CLOSE_HOUR - OFFICE_START_HOUR)*60;

	public double dateDifference(String start, String end){
	    Date startDate = validateStringToDate(start);
	    Date endDate = validateStringToDate(end);
	    System.out.println(startDate);
	    System.out.println(endDate);
	    Calendar startDay = convertDateToCalendar(startDate);
	    Calendar tempDay = (Calendar) startDay.clone();
	    Calendar endDay = convertDateToCalendar(endDate);

	    System.out.println(startDay.getTime());
	    System.out.println(endDay.getTime());
	    int workDays = -1;

	    int startDayDifference = 0;
	    int endDayDifference = 0;
	    int hours = 0;
	    int minsRemainder = 0;

	    if(!(startDay.get(Calendar.DAY_OF_YEAR) == endDay.get(Calendar.DAY_OF_YEAR)
	            && startDay.get(Calendar.YEAR) == endDay.get(Calendar.YEAR))){

	        do{
	            tempDay.add(Calendar.DAY_OF_MONTH, 1);
	            if(tempDay.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY 
	                    && tempDay.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
	                workDays++;
	            }
	        }while(tempDay.getTimeInMillis() <= endDay.getTimeInMillis());
	        
	        if(workDays > 0){
	            workDays = workDays - 1;
	        }
	    }

	    startDayDifference = hourDifferenceInMinutesOfStartDay(startDay);
	    endDayDifference = hourDifferenceInMinutesOfEndDay(endDay);

	    minsRemainder = (startDayDifference + endDayDifference) % TOTAL_MINS_IN_BUSINESS_DAY;
	    workDays = workDays + ((startDayDifference + endDayDifference) / TOTAL_MINS_IN_BUSINESS_DAY);

	    hours = minsRemainder/60;
	    minsRemainder = minsRemainder % 60;

	    System.out.println(workDays + "d "+ hours + "hrs " + minsRemainder + " mins");
	    return workDays*24+hours;
	}


	private int hourDifferenceInMinutesOfEndDay(Calendar endDay) {
	    long endTimestamp = endDay.getTimeInMillis();
	    System.out.println(endTimestamp);
	    endDay.set(Calendar.HOUR_OF_DAY, OFFICE_START_HOUR);
	    endDay.set(Calendar.MINUTE,0);
	    long endDayOfficeStartTimestamp = endDay.getTimeInMillis();
	    System.out.println(endDayOfficeStartTimestamp);
	    int difference = (int)((endTimestamp - endDayOfficeStartTimestamp) / 1000) / 60;
	    System.out.println(difference);
	    return difference;
	}


	private int hourDifferenceInMinutesOfStartDay(Calendar startDay) {
	    long starttimestamp = startDay.getTimeInMillis();
	    System.out.println(starttimestamp);
	    startDay.set(Calendar.HOUR_OF_DAY, OFFICE_CLOSE_HOUR);
	    startDay.set(Calendar.MINUTE,0);
	    long startDayOfficeCloseTimestamp = startDay.getTimeInMillis();
	    System.out.println(startDayOfficeCloseTimestamp);
	    int difference = (int)((startDayOfficeCloseTimestamp - starttimestamp) / 1000) / 60;
	    System.out.println(difference);
	    return difference;
	}

	public Calendar convertDateToCalendar(Date date){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);

	    if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
	            || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	        calendar = handleActivityOnAfterWorkHoursOrWeekendOrHolidays(calendar);
	    }

	    if(calendar.get(Calendar.HOUR_OF_DAY) >= OFFICE_CLOSE_HOUR 
	            && calendar.get(Calendar.MINUTE) > 0){
	        calendar = handleActivityOnAfterWorkHoursOrWeekendOrHolidays(calendar);
	    }

	    if(calendar.get(Calendar.HOUR_OF_DAY) < OFFICE_START_HOUR){
	        calendar.set(Calendar.HOUR_OF_DAY, OFFICE_START_HOUR);
	        calendar.set(Calendar.MINUTE,0);
	    }

	    return calendar;
	}

	private Calendar handleActivityOnAfterWorkHoursOrWeekendOrHolidays(Calendar calendar) {
	    do{
	        calendar.add(Calendar.DAY_OF_MONTH, 1);
	    }while(isHoliday(calendar));
	    calendar.set(Calendar.HOUR_OF_DAY, OFFICE_START_HOUR);
	    calendar.set(Calendar.MINUTE,0);
	    return calendar;
	}

	private boolean isHoliday(Calendar calendar) {
	    if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY 
	            || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	        return true;
	    }
	    return false;
	}

	public Date validateStringToDate(String input){
	    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	    Date date = null;
	    try{
	        date = dateFormat.parse(input);
	    }catch(ParseException exception){
	        System.out.println("invalid date format");
	        throw new RuntimeException("invalid date format");
	    }
	    return date;
	}

}
