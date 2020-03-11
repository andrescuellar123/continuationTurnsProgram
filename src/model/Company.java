package model;

import java.util.ArrayList;

public class Company {

	private ArrayList<Client>clients;
	
	private Turn ultimoDado;
	
	private Clock relj;
	/**
	 * @param clients
	 */
	public Company() {
		
		clients=new ArrayList<Client>();
		ultimoDado=new Turn(0,'A');
		
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

	public void addClient(int id, String typeId, String name, String lastName, int telephone, String address ) throws AlreadyExcistException{
		clients.add(new Client (id,typeId, name , lastName , telephone , address));
	}

	
	public String searchClient( int id1)throws IndexOutOfBoundsException, NullPointerException{
		boolean found = false;
		String msg = "None found";
		try {
			for (int i = 0; i < clients.size() || !found; i++) {
				if(clients.get(i).getId() == id1) {
				
					found = true;
					msg="the client is found : " + clients.get(i).getName() + " " + clients.get(i).getLastName() + "with the phone number: " + clients.get(i).getTelephone() ;
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
			char letter = ultimoDado.getLetter();
			int number = ultimoDado.getNumber();
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
				ultimoDado =new Turn(number,letter);
				c.addTurn(ultimoDado);
			}
			
		}
		else {
			 ultimoDado=new Turn(0, 'A');
			 
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
	
	
	
	public String theClock() {
		String msg= relj.toString();
		return msg;
		
	}
	
	
	
}
