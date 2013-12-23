package edu.ku.it.si.springwebservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Models a Person.
 * 
 * @author bphillips
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonAutoDetect
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    private String lastName;

    private String firstName;

	/**
	 * Get lastName.
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set lastName to value provided.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get firstName.
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set firstName to value provided.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName
				+ "]";
	}

}
