/**
 * 
 */
package name.brucephillips.springjpaexample.service;

import java.util.List;

import name.brucephillips.springjpaexample.model.Person;
import name.brucephillips.springjpaexample.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implements methods that enable interaction between 
 * a Controller and a PersonDao.
 * @author bphillips
 *
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {
		
	@Autowired
	 private PersonRepository personRepository;
	 
	/* (non-Javadoc)
	 * @see name.brucephillips.springjpaoracleexample.service.PersonService#findByEmplid(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public Person findByEmplid(Long emplid) {
		
		return personRepository.findByEmplid(emplid);
		
	}



	@Override
	@Transactional(readOnly=true)
	public List<Person> findAllEmployees() {
		
		return personRepository.findAll();
		
		
	}

	@Override
	@Transactional
	public void update(Person person) {
	
		personRepository.save(person);
		
	}

	@Override
	@Transactional
	public void delete(Person person) {
		
		personRepository.delete(person);

	}

	@Override
	@Transactional
	public void save(Person person) {
	
		personRepository.save(person);
		
		
	}
	
	

}
