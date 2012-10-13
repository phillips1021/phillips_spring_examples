package name.brucephillips.springcacheexample.dao;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import name.brucephillips.springcacheexample.model.Person;
	
/**
 * Implements methods to interact with a
 * Person data repository.
 * 
 * @author bphillips
 *
 */
@Repository("personDao")
public class PersonDaoStub implements PersonDao {
	
	private static final Logger LOGGER = Logger.getLogger(PersonDaoStub.class.getName());
	
	private static int executeCountForGetPerson = 0 ;

	@Cacheable("persons")
	public final Person getPerson(Long personId) {
		
		executeCountForGetPerson++;
		
		Person person = new Person();
		person.setPersonId(personId);
		person.setFirstName("Bruce");
		person.setLastName("Phillips");
		
		LOGGER.debug("Method getPerson has executed " + executeCountForGetPerson + " time(s).") ;
		
		return person;
		
	}
	
	
	public final int getPersonExecuteCount() {
		
		return executeCountForGetPerson;
		
	}

	
	@CacheEvict(value="persons", allEntries=true)
	public final void loadPeople() {
		
		LOGGER.debug("Method loadPeople has executed.");
		
	}
	
	

}
