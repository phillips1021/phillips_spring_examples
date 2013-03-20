package edu.ku.it.si.springjdbcexamples.service;

import java.util.List;
import java.util.Map;

import edu.ku.it.si.springjdbcexamples.dao.PersonDao;
import edu.ku.it.si.springjdbcexamples.model.Person;

public  class PersonServiceImpl implements PersonService {
	
	PersonDao personDao ;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	
	@Override
	public List<String> getLastNames() {

		List<String> lastNames = personDao.getLastNames() ;
		
		return lastNames;
		
	}
	


	@Override
	public int getNumberOfPeople() {
		 
		return personDao.getNumberOfPeople();
	}

	@Override
	public String getFirstName(String lastName) {
		
		return personDao.getFirstName(lastName);
	}

	@Override
	public Person getPerson(String lastName) {

		Person person = personDao.getPerson(lastName);
		
		return person;
	}



	@Override
	public void addPerson(String firstName, String lastName) {

		personDao.addPerson(firstName, lastName);
		
	}

	@Override
	public void updatePerson(Person person) {

		personDao.updatePerson(person);
		
	}

	@Override
	public void deletePerson(Person person) {
		
		personDao.deletePerson(person);
		
	}

	@Override
	public void doDBCleanUp() {
		
		 personDao.doDBCleanUp();
		
	}

	@Override
	public int countPeopleWithFirstName(String firstName) {

		return personDao.countPeopleWithFirstName(firstName);
		
	}

	@Override
	public List<Person> getPerson(Person personSkeleton) {
		
		return personDao.getPerson(personSkeleton);
	}

	@Override
	public Person getPerson(int personId) {

		return personDao.getPerson(personId);
		
	}

	@Override
	public List<Map<String,Object>> getPeopleList() {

		return personDao.getPeopleList();
	}

	@Override
	public void addPerson(Person newPerson) {

		personDao.addPerson(newPerson);
		
	}

	@Override
	public List<Person> getAllPersons() {
		
		return personDao.getAllPersons() ;
	}
	
	

}
