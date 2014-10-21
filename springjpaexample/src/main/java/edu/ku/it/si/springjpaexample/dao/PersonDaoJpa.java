package edu.ku.it.si.springjpaexample.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import edu.ku.it.si.springjpaexample.model.Gender;
import edu.ku.it.si.springjpaexample.model.Person;

/**
 * Implements PersonDao behaviors using
 * JPA to interact with a data repository.
 * @author bphillips
 *
 */
@Repository("personDao")
public class PersonDaoJpa extends GenericDaoImpl<Person> implements PersonDao {

	
	@Override
	public List<Person> findAllEmployees() {
		
		
		TypedQuery<Person> query = getEm().createQuery("from " + Person.class.getName(), Person.class);
		
		List<Person> employees = query.getResultList();
		
		return employees;

	}


	

	@Override
	public List<Person> findByGender(Gender gender) {
		
		 TypedQuery<Person> query = getEm().createQuery("select p FROM Person p where p.gender = :gender ", Person.class);
	        
	    query.setParameter( "gender", Gender.MALE );
	        
	     List<Person> maleEmployees = query.getResultList();
	     
	     return maleEmployees ;
	     
	}


	

}
