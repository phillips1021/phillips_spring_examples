/**
 * 
 */
package edu.ku.it.si.springjpaexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ku.it.si.springjpaexample.dao.PersonDao;
import edu.ku.it.si.springjpaexample.model.Person;

/**
 * Implements methods that enable interaction between 
 * a Controller and a PersonDao.
 * @author bphillips
 *
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
	
	 @Autowired
	 private PersonDao personDao;

	/* (non-Javadoc)
	 * @see edu.ku.it.si.springjpaoracleexample.service.PersonService#findbyEmplid(java.lang.String)
	 */
	@Override
	public Person findbyEmplid(Long emplid) {
		
		return personDao.findbyEmplid(emplid);
		
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public List<Person> findAllEmployees() {
		
		return personDao.findAllEmployees() ;
		
		
	}

	@Override
	@Transactional
	public void update(Person person) {
	
		personDao.update(person);
		
	}

	@Override
	@Transactional
	public void delete(Person person) {
		
		personDao.delete(person);

	}

	@Override
	@Transactional
	public void save(Person person) {
	
		personDao.save(person); //Person object's emplid instance field will now have a value
		
		
	}
	
	

}
