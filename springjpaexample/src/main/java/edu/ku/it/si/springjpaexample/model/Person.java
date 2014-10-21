/**
 * 
 */
package edu.ku.it.si.springjpaexample.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Models a Person.
 * @author bphillips
 *
 */
@Entity
@Table(name="person")
@NamedQuery(name="person.findByEmplid", query="from Person where emplid = :emplid")
public final class Person implements Serializable {

	private static final long serialVersionUID = 3697535594187479699L;

	private Long emplid;
	

	private String firstName;
	

	private String lastName;
	
	private Gender gender ;
	


	

	@Id
	@GeneratedValue
	public Long getEmplid() {
		return emplid;
	}

	public void setEmplid(Long emplid) {
		this.emplid = emplid;
	}

	
	
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [emplid=" + emplid + ", firstName=" + firstName
				+ ", gender=" + gender + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emplid == null) ? 0 : emplid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (emplid == null) {
			if (other.emplid != null) {
				return false;
			}
		} else if (!emplid.equals(other.emplid)) {
			return false;
		}
		return true;
	}

	
	
	

}
