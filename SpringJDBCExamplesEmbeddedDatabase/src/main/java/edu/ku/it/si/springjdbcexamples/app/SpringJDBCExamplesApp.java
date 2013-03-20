package edu.ku.it.si.springjdbcexamples.app;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ku.it.si.springjdbcexamples.model.Person;
import edu.ku.it.si.springjdbcexamples.service.PersonService;

public class SpringJDBCExamplesApp {

	//create Spring bean factory using the embedded Database repository configuration
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
   "applicationContext_DB.xml");
	
	PersonService personService ;
	
	private static final Logger logger = Logger.getLogger( SpringJDBCExamplesApp.class.getName() );

	/**
	 * @param args
	 */
	public static void main(String[] args) {

				
		SpringJDBCExamplesApp app = new SpringJDBCExamplesApp();
		
		app.run();
	
	}

	private void run() {
		
		
		personService = (PersonService) ctx.getBean("personService");
		
		//personService.doDBCleanUp();
		
		List<String> lastNames = personService.getLastNames() ;

		logger.info("Last names are " + lastNames );
		
		int numberOfPeople = personService.getNumberOfPeople();
		
		logger.info("Number of people is " + numberOfPeople);
		
		String lastName = "Phillips";
		
		String firstName = personService.getFirstName(lastName);
		
		logger.info("The first name of Phillips is " + firstName);
		
		Person person = personService.getPerson(lastName);
		
		logger.info("Everything about Phillips encapsulated in a Person object is " + person);
		
		List <Person> people = personService.getAllPersons() ;
		
		logger.info("Everything about everybody is " + people );
		
		personService.addPerson("Jeff", "Day");
		
		logger.info("Everything about everybody (check for Jeff Day) is " + personService.getAllPersons());
		
		person = personService.getPerson("Day");
		
		person.setPersonLastName("Mowen");
		
		personService.updatePerson(person);
		
		logger.info("Everything about everybody (check for that Jeff Day is now Jeff Mowen) is " + personService.getAllPersons());
		
		personService.deletePerson(person);
		
		logger.info("Everything about everybody (check for that Jeff Mowen is now GONE) is " + personService.getAllPersons());
		
		int countOfPeople = personService.countPeopleWithFirstName("Bruce");
		
		logger.info("Number of people with first name of Bruce is " + countOfPeople);
	
		/*create a Person object */
		Person personSkeleton = new Person();
		personSkeleton.setPersonLastName("Phillips");
		personSkeleton.setPersonFirstName("Bruce");
		
		/*use the personSkeleton object to get all Person objects
		 * with same last and first names
		 */
		people = personService.getPerson(personSkeleton);
		
		logger.info("All people with first name of Bruce and last name of Phillips are " + people);
		
		person = personService.getPerson(2);
		
		logger.info("Everything about person with personID of 2 is " + person);
		
		List<Map<String,Object>> peopleList = personService.getPeopleList() ;
		
		logger.info("All people in a List of Map objects " + peopleList);
		
		Person newPerson = new Person();
		newPerson.setPersonFirstName("Todd");
		newPerson.setPersonLastName("Kofford");
		
		personService.addPerson(newPerson);
		
		logger.info("Everything about everybody (check for Todd Kofford) is " + personService.getAllPersons());
		

		
		
	}



}
