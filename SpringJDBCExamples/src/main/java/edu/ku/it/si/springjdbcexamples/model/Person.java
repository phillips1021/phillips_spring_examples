package edu.ku.it.si.springjdbcexamples.model;

/**
 * Models a Person
 * 
 * @author brucephillips
 *
 */
public class Person {
	
	private int personID ;
	
	private String personFirstName;
	
	private String personLastName;
	
	public Person() {
		
		personID = 0;
		personLastName = "none";
		personFirstName = "none";
			
	}

	/**
	 * @param personID
	 * @param personFirstName
	 * @param personLastName
	 */
	public Person(int personID, String personFirstName, String personLastName) {
		this.personID = personID;
		this.personFirstName = personFirstName;
		this.personLastName = personLastName;
	}

	/**
	 * @return the personID
	 */
	public int getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	/**
	 * @return the personFirstName
	 */
	public String getPersonFirstName() {
		return personFirstName;
	}

	/**
	 * @param personFirstName the personFirstName to set
	 */
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	/**
	 * @return the personLastName
	 */
	public String getPersonLastName() {
		return personLastName;
	}

	/**
	 * @param personLastName the personLastName to set
	 */
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	
	public String toString() {
		
		
		String temp = "Person ID: " + personID ;
		temp = temp + " Person Name: " + personFirstName + " " + personLastName ;
		
		return temp;
		
	}

}
