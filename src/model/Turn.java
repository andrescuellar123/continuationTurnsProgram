package model;

public class Turn {
	
	
	
	private int number;
	private char letter;
	private TypeTurn type;

	/**
	 * @param number
	 * @param letter
	 */
	public Turn(int number,char letter) {
		
		this.number = number;
		this.letter = letter;
	
	}
	
	
	
	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public char getLetter() {
		return letter;
	}

	


	public void setLetter(char letter) {
		this.letter = letter;
	}
	

	public TypeTurn getType() {
		return type;
	}



	public void setType(TypeTurn type) {
		this.type = type;
	}



	public String getName() {
		String msg ="";
		
		if(number<=9) {
			msg= letter +" "+ 0 + number;
			}
		else {
			msg=  letter + " " +number+"";
		}

		
		return  msg;
	}
	
	public String getNextTurn() {
		char letter2 = letter;
		int number2=number+1;
		String msg="";
		Turn t1 ;
		if(number2==100) {
			number2=0;
			if(letter2=='Z') {
				letter2='A';
			}
			else {
				letter2++;
			}
		}
		t1= new Turn(number2,letter2);
		t1.setLetter(letter2);
		t1.setNumber(number2);
		return t1.getName();
	}
	
	

	public TypeTurn addTypeTurn(String na , float time) {
		TypeTurn t= new TypeTurn(na,time);
		setType(t);
		return t;
	}



	@Override
	public String toString() {
		return "Turn [number=" + number + ", letter=" + letter + "]";
	}
	
	public String otherToString() {
		return "The Turn is:"+ getName() + " " + getType().getName() ;
	}

	


	


}
