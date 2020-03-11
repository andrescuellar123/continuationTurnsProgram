package model;

import java.util.*;

import javax.swing.JLabel;

public class DateAndClock implements Runnable {
	
	private String hora,min,sec,ampm;
	private Calendar calendario;
	Thread h1;
	
	public DateAndClock() {
		h1= new Thread(this);
		h1.start();
		
	}
	
	private JLabel lblrelj;

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while(ct==h1) {
			calcula();
			lblrelj.setText(hora+":" + min + " :" + sec + " " + ampm);
			System.out.println(hora+":" + min + " :" + sec + " " + ampm);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
		}
		
	}

	private void calcula() {
		Calendar calendario = new GregorianCalendar();
		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);
		ampm= calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
		if(ampm.equals("PM")) {
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hora = h>9?""+h:"0"+h;
		}else {
			hora=calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
			
		}
		min=calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		sec=calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
	}

}
