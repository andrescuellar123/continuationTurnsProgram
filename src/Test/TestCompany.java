package Test;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCompany {
	
	private Company e1;
	private Company e2;
	private Client c1;
	private Client c2;
	private Turn t1;
	
	public void setup1() throws AlreadyExcistException {
		int id = 1234;
		String typeId = "Cedula";
		String name = "Pepe";
		String lastName = "Perez";
		int telephone = 12345;
		String address = "calle 12";
		e1  = new Company();
		e1.addClient(id, typeId, name, lastName, telephone, address);
		c1 = new Client(id, typeId, name, lastName, telephone, address);
		Client nu= null;
		e1.addClient(0, "", "", "", 0, "");
		
	}
	
	
	public void setup2() throws AlreadyExcistException {
		int id = 1234;
		String typeId = "Cedula";
		String name = "Pepe";
		String lastName = "Perez";
		int telephone = 12345;
		String address = "calle 12";
		int id2 = 123;
		String typeId2 = "Cedula";
		String name2 = "Papa";
		String lastName2 = "Peter";
		int telephone2 = 123;
		String address2 = "calle 20";
		e1  = new Company();
		e1.addClient(id, typeId, name, lastName, telephone, address);
		e1.addClient(id2, typeId2, name2, lastName2, telephone2, address2);
		e2= new Company();
		
		
		
		
	}
	
	public void setup3() throws AlreadyExcistException {
		int id = 1234;
		String typeId = "Cedula";
		String name = "Pepe";
		String lastName = "Perez";
		int telephone = 12345;
		String address = "calle 12";
		e1  = new Company();
		e1.addClient(id, typeId, name, lastName, telephone, address);
		c1=new Client(id, typeId, name, lastName, telephone, address);
		c2=new Client(id, typeId, name, lastName, telephone, address);
		e2=new Company();
		int nu=1;
		char let= 'A';
		
		t1=new Turn(nu,let);
		c2.addTurn(t1);
	}
	
	@Test
	public void testAddClient() throws AlreadyExcistException {
		setup1();
		assertTrue(e1.getClients().get(0).getId()==c1.getId());//esta sive para cuando no existe y cuando no hay usuarios
		assertTrue(e1.getClients().get(1).getId()==0);
	}
	
	@Test
	public void testSearchClient() throws AlreadyExcistException,IndexOutOfBoundsException,NullPointerException {
		setup2();
		assertTrue(e1.searchClient( 1234).equals("the client is found : " + "Pepe"+" "+"Perez"+"with the phone number: "+12345)); 
		assertTrue(e1.searchClient(1111).equals("Not found"));
		assertTrue(e2.searchClient(3456).equals("None found"));
		assertTrue(e1.searchClient( 123).equals("the client is found : " + "Papa"+" "+"Peter"+"with the phone number: "+123));
		
		
	} 
	
	@Test
	public void testCreateATurn() throws AlreadyExcistException {
		setup3();
	
		assertTrue(e1.createTurn(c1).equals("the turn is: A00"));
		
		
		
	}
	

}
