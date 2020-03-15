package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Company {

	private ArrayList<Client>clients;
	
	private Turn ultimoDado;
	private Turn ultimoComp;
	private GregorianCalendar g;
	
	private TheClockAndDate clock;
	/**
	 * @param clients
	 */
	public Company() {
		
		clients=new ArrayList<Client>();
		ultimoDado = new Turn(0,'A');
		clock=new TheClockAndDate(g);
		
	}
	
	


	/**
	 * @return the clients
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	


	public Turn getUltimoDado() {
		return ultimoDado;
	}
	public void setUltimoDado(Turn ultimoDado) {
		this.ultimoDado = ultimoDado;
	}

	public void addClient(int id, String typeId, String name, String lastName, int telephone, String address ,int inasistencias,
	 String suspendido) throws AlreadyExcistException{
		clients.add(new Client (id , typeId, name , lastName , telephone , address ,inasistencias,suspendido));
	}

	
	public String searchClient( int id1)throws IndexOutOfBoundsException, NullPointerException{
		boolean found = false;
		String msg = "None found";
		try {
			for (int i = 0; i < clients.size() || !found; i++) {
				if(clients.get(i).getId() == id1) {
				
					found = true;
					msg="the client is found : " + clients.get(i).getName() + " " + clients.get(i).getLastName() + "  with the phone number: " + clients.get(i).getTelephone() ;
					return msg;
				}
				
			
			}
			
		}
		catch(IndexOutOfBoundsException e) {
			
			for (int j = 0; j < clients.size(); j++) {
				if(clients.get(j).getId() != id1 ) {
					msg="Not found";
				}
			}
			
			
			
			
		}
		catch(NullPointerException e) {
			msg="None found";
		}
		return msg;
		}	
	
	public String giveATurn() {
		String msg = ultimoDado.getName();
		return msg;
		
	}
	public String advanceTurn(char let, int num) {
		ultimoDado=new Turn(num,let);
		return  ultimoDado.getNextTurn();
	}
	public String createTurn(Client c) {
		String msg="";
		if(ultimoDado != null) {
			char letter = ultimoComp.getLetter();
			int number = ultimoComp.getNumber();
			number++;
			if(number == 100) {
				number=0;
				if(letter=='Z') {
					letter='A';
					
				}
				else {
					letter++;
				}		
				//
				ultimoComp =new Turn(number,letter);
				c.addTurn(ultimoComp);
				setUltimoDado(ultimoComp);
				
			
			}
			
		}
		else {
			 ultimoDado=new Turn(0, 'A');
			 setUltimoDado(ultimoDado);
		}
		return msg=  ultimoDado.getName();
	}
	
	
	public String showClients() {
		String msg ="";
		for (int i = 0; i < clients.size(); i++) {
			msg= "the client: "+clients.get(i).getName() + "the id: "+clients.get(i).getId();
		}
		return msg;
	}
	
	public String suspended(Client c) {
		String msg="";

		if(c.getInasistencias() == 2){
			String [] msg2=clock.theDateAndTime().split(" ");
			int day2= Integer.parseInt(msg2[3])+2;
			msg2[3]=day2+"";
			msg=Arrays.toString(msg2);
			
			
		}
		return msg;
	}
	
	public String getClock() {
		String msg="";
		msg=clock.theDateAndTime();
		return msg;
	}

	
	public void addTurnToClient(int id) {
		Client c = searchClientBinary(id);
		Turn t = ultimoDado;
		if(ultimoDado!=null) {
		c.getClientTurn().add(t);
		String [] s = ultimoDado.getNextTurn().split(" ");
		char a = s[0].charAt(0);
		int num= Integer.parseInt(s[1]);
		ultimoDado.setLetter(a);
		ultimoDado.setNumber(num);
		}
	}
	
	public Client searchClientBinary(int id ) {
		int max = clients.size()-1;
		int  min = 0;
		int mid=0;
		int pos=-1;
		while(pos == -1 && min <= max) {
			mid = (min + max)/2;
			if(id == clients.get(mid).getId()) {
				pos=mid;
			}
			else if(id > clients.get(mid).getId()){
				min =mid+1;
			}
			else{
				max=mid-1;
			}
		}
		return clients.get(pos);
	}

	
}
