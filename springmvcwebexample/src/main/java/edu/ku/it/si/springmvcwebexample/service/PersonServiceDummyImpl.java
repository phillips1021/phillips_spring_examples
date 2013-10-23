
package edu.ku.it.si.springmvcwebexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.ku.it.si.springmvcwebexample.model.Person;

/**
 * Provides hard-coded Person services.
 * @author bphillips
 *
 */
@Service
public class PersonServiceDummyImpl implements PersonService {

	@Override
	public List<Person> getPeople() {
		
		
		Person p1 = new Person();
		p1.setFirstName("Bruce");
		p1.setLastName("Phillips");
		
		Person p2 = new Person();
		p2.setFirstName("Jane");
		p2.setLastName("Doe");
		
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(p1);
		people.add(p2);
		
		return people;
		
		
		
	}

}
