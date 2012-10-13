package edu.ku.it.si.springjpaexample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import edu.ku.it.si.springjpaexample.model.Person;

/**
 * Implements PersonDao behaviors using
 * JPA to interact with a data repository.
 * @author bphillips
 *
 */
@Repository("personDao")
public class PersonDaoJpa implements PersonDao {
	
	private static final Logger logger = Logger.getLogger(PersonDaoJpa.class.getName() );
	
	private EntityManager entityManager;
	
	

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}


	@Override
	public Person findbyEmplid(Long emplid) throws DataAccessException {
		
		Person person = null ;
		
		TypedQuery<Person> query =  entityManager.createNamedQuery("person.findByEmplid", Person.class);
		
		query.setParameter("emplid", emplid);
		
		try {
			
			person = query.getSingleResult() ;
			
			
		} catch (javax.persistence.NoResultException ex) {
			
			logger.warn("No Person was found with an emplid of " + emplid);
			
		}
		
		return person;
		
	}


	@Override
	public List<Person> findAllEmployees() {
		
		
		TypedQuery<Person> query = entityManager.createQuery("from " + Person.class.getName(), Person.class);
		
		List<Person> employees = query.getResultList();
		
		return employees;

	}


	@Override
	public void update(Person person) {
	
		entityManager.merge(person);
		
		
	}


	@Override
	public void delete(Person person) {
		
		
		//use merge to get the Person object into
		//this persistence context
		Person deletePerson = entityManager.merge(person);
		
		entityManager.remove(deletePerson);
		
			
	}


	@Override
	public void save(Person person) {
	
		entityManager.persist(person);
		
	}


	

}
