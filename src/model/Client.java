	package model;

import java.util.ArrayList;

public class Client {
	private ArrayList<Turn> clientTurn;
	private int id;
	private String typeId;
	private String name;
	private String lastName;
	private int telephone;
	private String address;
	/**
	 * @param id
	 * @param typeId
	 * @param name
	 * @param lastName
	 * @param telephone
	 * @param address
	 */
	public Client(int id, String typeId, String name, String lastName, int telephone, String address) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		clientTurn =new ArrayList<Turn>();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the telephone
	 */
	public int getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Turn> getClientTurn() {
		return clientTurn;
	}
	public void setClientTurn(ArrayList<Turn> clientTurn) {
		this.clientTurn = clientTurn;
	}
	public String clientTurns() {
		String msg= "";
		for (int i = 0; i < clientTurn.size(); i++) {
			 msg= clientTurn.get(i).getName();
		}
		
		
		return msg;
	}
	
	public void addTurn(Turn t) {
		clientTurn.add(t);
	}
	
	
}
