package model;

public class TypeTurn {
	
	private static float PREFERENCIAL = 1.5f;
	private static float NORMAL = 3.25f;
	
	private String name;
	private float time;
	/**
	 * @param name
	 * @param time
	 */
	public TypeTurn(String name, float time) {
	
		this.name = name;
		this.time = time;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the time
	 */
	public float getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		if(time == 1) {
			this.time=PREFERENCIAL;
		}
		else if(time == 2) {
			this.time=NORMAL;
		}
	}
	
	
	
	
	
	
}
