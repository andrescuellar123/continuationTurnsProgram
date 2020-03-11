package model;

public class Clock {

	private int min;
	private int hours;
	private int sec;
	/**
	 * @param min
	 * @param hours
	 * @param sec
	 */
	public Clock() {
		super();
		this.min = 0;
		this.hours = 0;
		this.sec = 0;
	}
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	/**
	 * @return the sec
	 */
	public int getSec() {
		return sec;
	}
	/**
	 * @param sec the sec to set
	 */
	public void setSec(int sec) {
		this.sec = sec;
	}
	@Override
	public String toString() {
		return "Clock [min=" + min + ", hours=" + hours + ", sec=" + sec + "]";
	}



	public void theClock() throws InterruptedException {

		while(true) {
			
			if(hours < 10) {
				hours=0;
			}
			if(min < 10) {
				min=0;
			}
			if(sec < 10) {
				sec=0;
			}
			//aument
			sec++;
			
			//comp
			
			if(sec== 60) {
				sec=0;
				min++;
				if(min == 60) {
					min=0;
					min++;
					if(hours == 24) {
						hours=0;
					}
				}
			}
			
			Thread.sleep(1000);

		}
	}


}
