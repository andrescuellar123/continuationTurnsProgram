package model;

public class AlreadyExcistException extends Exception{
	
	private int id;
	private String msg;
	public AlreadyExcistException(int n, String m){
		super("There is another Client with the same info" );
		msg=m;
		id = n;
		exist( n);
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	public void exist(int id1 ) {
		if(id1==this.getId()) {
			msg = "Same id";
		}
	}
	
}
