package ui;

import java.io.IOException;
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
		while(opt != 7) {
			System.out.println("1.  create a Client");
			System.out.println("2.  search a Client");
			System.out.println("3.  give a Turn to a Employee");
			System.out.println("4.  give to the Employee the next Turn");
			System.out.println("5.  give client a turn");
			System.out.println("6.  show clients");
			System.out.println("7.  the clock");
			
			System.out.println("8.  Exit");
			boolean cor = false;
			while(!cor) {
					
				opt = reader.nextInt();
				reader.nextLine();
				cor = true;
			
			}
			
		
			switch(opt) {
			case 1:
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
			
			
				try {
					comp.addClient(a,b,c,d,e,f);
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
				
				System.out.println("what is the id");
				int l = Integer.parseInt(reader.nextLine());
				
				System.out.println("what is the type of id");
				String m = reader.nextLine();
				
				System.out.println("what is the name");
				String n = reader.nextLine();
				
				System.out.println("what is the lastname");
				String o = reader.nextLine();
				
				System.out.println("what is the phone");
				int p= Integer.parseInt(reader.nextLine());
				
				System.out.println("what is the address");
				String q = reader.nextLine();
				
				Client c1= new Client(l,m,n,o,p,q);
				System.out.println(comp.createTurn(c1));
				break;
			case 6 :
				
				System.out.println(comp.showClients());;
				break;
				
			case 7 :
				
				System.out.println(comp.theClock());;
				break;
				
				
				
				
				
				
				
			case 8:
				System.out.println("see you later");
			default:
				break;
			}
		}
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
