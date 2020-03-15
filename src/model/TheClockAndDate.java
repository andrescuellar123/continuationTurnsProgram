package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TheClockAndDate {
	
		
	private Calendar fecha ;

	public TheClockAndDate(GregorianCalendar fecha) {
		super();
			this.fecha = fecha.getInstance();
	}
	
	
	public String theDateAndTime() {
		String msg ="";
		
		int annio=fecha.get(Calendar.YEAR);
		int month = fecha.get(Calendar.MONTH);
		int day = fecha.get(Calendar.DAY_OF_MONTH);
        int hor = fecha.get(Calendar.HOUR_OF_DAY);
        int min = fecha.get(Calendar.MINUTE);
        int sec = fecha.get(Calendar.SECOND);
		
       return msg = annio + " " +(month+1) + " " +day + " " +hor + " " +min + " " +sec ;
	}



	
	
}
