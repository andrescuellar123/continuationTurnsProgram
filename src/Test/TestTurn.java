package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class TestTurn {
	private Company c1;
	private Client c;
	
	private Turn t1;
	private Turn t2;
	private Turn t3;
	private Turn t4;
	
	public void  setup1() {
		
		c1=new Company();
		int id = 1234;
		String typeId = "Cedula";
		String name = "Pepe";
		String lastName = "Perez";
		int telephone = 12345;
		String address = "calle 12";
		c= new Client(id, typeId, name, lastName, telephone, address);
		
		int nu= 0;
		int n=1;
		char let= 'A';
		
		t1=new Turn(nu,let);
		t2=new Turn (n,let);
	}
	public void  setup2() {
		
		c1=new Company();
		int id = 1234;
		String typeId = "Cedula";
		String name = "Pepe";
		String lastName = "Perez";
		int telephone = 12345;
		String address = "calle 12";
		c= new Client(id, typeId, name, lastName, telephone, address);
		
		int nu= 0;
		int n=1;
		char let= 'A';
		
		t1=new Turn(nu,let);
		t2=new Turn (n,let);
		int n2 = 99;
		char let2='D';
		t3= new Turn(n2,let2);
		
		
		char let3='Z';
		t4= new Turn(n2,let3);
	}
	
	@Test
	public void testName() {
		setup1();
		assertTrue(t1.getName().equals("the turn is: A00" ));
		assertTrue(t1.getLetter()=='A');
		assertTrue(t1.getNumber()==00);
	}
	
	@Test
	public void testGetNext() {
		setup2();
		assertTrue(t1.getNextTurn().equals("the turn is: A01"));
		
		assertTrue(t3.getNextTurn().equals("the turn is: E00"));
		
		assertTrue(t4.getNextTurn().equals("the turn is: A00"));
		
		
	}

}
