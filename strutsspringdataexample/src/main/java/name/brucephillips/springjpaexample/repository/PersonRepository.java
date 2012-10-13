package name.brucephillips.springjpaexample.repository;

import name.brucephillips.springjpaexample.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Uses Spring Data JPA library to define a PersonRepistory
 * interface that Spring will use to create a Bean object
 * with CRUD methods for a Person.
 * @author brucephillips
 *
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * Get Person with the associated emplid.
	 * @param emplid - Employee ID
	 * @return Person object if provided emplid is 
	 * found in the data repository, otherwise return null
	 */
	Person findByEmplid(Long emplid);

}
