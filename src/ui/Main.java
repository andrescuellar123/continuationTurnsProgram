package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import model.*;

public class Main {
	private Company comp;
	private Scanner reader;
	
	public Main() throws IOException, ClassNotFoundException {
		reader = new Scanner(System.in);
		comp = new Company();
		menu();
		
	}
	public void menu() throws IOException, ClassNotFoundException {
		int opt = -1;
		while(opt != 20) {
			System.out.println("1.  create a Client");
			System.out.println("2.  search a Client");
			System.out.println("3.  give a Turn to a Employee");
			System.out.println("4.  give to the Employee the next Turn");
			System.out.println("5.  give client a turn");
			System.out.println("6.  create a type of turn for a Client");
			System.out.println("7.  show clients");
			System.out.println("8.  add client a fault");
			System.out.println("9.  Schedule and the clock");
			System.out.println("10.  the clients and the clock");
			System.out.println("11.  Exit");
			boolean cor = false;
			while(!cor) {
					
				opt = reader.nextInt();
				reader.nextLine();
				cor = true;
			
			}
			
		
			switch(opt) {
			case 1:
				TheClockAndDate tc= new TheClockAndDate(new GregorianCalendar());
				System.out.println(tc.theDateAndTime());
				
				Calendar c1 = GregorianCalendar.getInstance();

		        System.out.println("Fecha actual: "+c1.getTime().toLocaleString());
				
				System.out.println("what is the id");
				int a = Integer.parseInt(reader.nextLine());
				
				System.out.println("what is the type of id");
				String b = reader.nextLine();
				
				System.out.println("what is the name");
				String c = reader.nextLine();
				
				System.out.println("what is the lastname");
				String d = reader.nextLine();
				
				System.out.println("what is the phone");
				int e = Integer.parseInt(reader.nextLine());
				
				System.out.println("what is the address");
				String f = reader.nextLine();
				
				
				int g = 0;
				
				String h ="";
		
			
			
				try {
					comp.addClient(a,b,c,d,e,f,g,h);
				} catch (AlreadyExcistException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("what is the id of the client ");
				int fn =  Integer.parseInt(reader.nextLine());
				
				System.out.println(comp.searchClient(fn));
				break;
			case 3:
				System.out.println("The turn is");
				
				
				
				System.out.println(comp.giveATurn());
				break;
			case 4:
				System.out.println("number of the last turn");
				int j = Integer.parseInt(reader.nextLine());
				
				
				System.out.println("letter of the last turn");
				char k = reader.next().charAt(0);
				
					
				
				System.out.println(comp.advanceTurn(k,j));
				break;
			case 5 :
				System.out.println("Who is the client to give the turn");
				int id =Integer.parseInt(reader.nextLine());
				Client cl = comp.searchClientBinary(id);
				if(cl.getInasistencias()==2) {
					String[] arr1 = comp.suspended(cl).split(",");
					String [] arr2 = comp.getClock().split(",");
					for (int i = 0; i < arr2.length; i++) {
						if(Integer.parseInt((arr2[i]))>=Integer.parseInt(arr1[i])) {

							System.out.println(comp.suspended(cl));
							cl.setInasistencias(0);
					
						}
					}	
				}else {
				System.out.println(comp.getUltimoDado().toString());
				comp.addTurnToClient(id );
				System.out.println(cl.getClientTurn().toString());
				System.out.println(comp.searchClientBinary(id).toString());
				System.out.println(comp.getUltimoDado().toString());
				}
				break;
				
			case 6 :
				System.out.println("what is the client id?");
				int p = Integer.parseInt(reader.nextLine());
				Client c3 = comp.searchClientBinary(p);
				int tam= c3.getClientTurn().size();
				
			
				
				break;
			case 7 :
				
				System.out.println(comp.showClients());;
				break;
				
			case 8 :
				System.out.println("Who is the client to add the fault");
				int critery =reader.nextInt();
				Client cli = binarySearchClient(critery,comp.getClients());
				
				if(cli.getInasistencias()==0) {
					cli.setInasistencias(1);
					System.out.println("the client has comit a fault for first time");
				}
				else if(cli.getInasistencias()==1) {
					cli.setInasistencias(2);
					comp.suspended(cli);
					String sq =comp.suspended(cli).toString();
					cli.setSuspendido(sq);
					System.out.println("the client has been suspended"+ sq.toString());
				}
				
				
				break;
				

			case 9 :
				
				System.out.println(comp.getClock());
				break;
				
			case 10 :
				for (int i = 0; i < comp.getClients().size(); i++) {
					System.out.println(comp.getClients().get(i).getClientTurn().get(i).otherToString());
				}
	
				break;
				
			case 11:
				System.out.println("see you later");
			default:
				break;
			}
		}
	}

	
	public Client binarySearchClient(int critery, ArrayList<Client>theArray) {
		int max = theArray.size();
		int  min = 0;
		int mid=0;
		int pos=-1;
		while(pos == -1 && min <= max) {
			mid = (min + max)/2;
			if(critery == theArray.get(mid).getId()) {
				pos=mid;
			}
			else if(critery > theArray.get(mid).getId()){
				min =mid+1;
			}
			else{
				max=mid-1;
			}
		}
		return theArray.get(pos);
	}
	
	public String countTurnsOfClient(Client c) {
		String t1 = " ";
		for (int i = 0; i < c.getClientTurn().size()-1; i++) {
			t1+= c.getClientTurn().get(i).otherToString();
		}
		return t1;
	}
	
	
	
	public static void main(String[] args) {
		 try {
				Main m = new Main();
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
