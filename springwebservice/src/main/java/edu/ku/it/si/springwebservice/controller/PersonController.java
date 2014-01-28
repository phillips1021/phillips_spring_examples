package edu.ku.it.si.springwebservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ku.it.si.springwebservice.model.Person;
import edu.ku.it.si.springwebservice.service.PersonService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller class that handles requests for Person data.
 * For example to get a Person object using a username
 * value of bphillips use this
 * URL:  http://domainname:port/person/username/bphillips
 * 
 * @author bphillips
 * 
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger LOGGER = Logger.getLogger( PersonController.class.getName() );

	@Autowired
	private PersonService personService;

	/**
	 * Get the Person associated with the provide userName.
	 * 
	 * @param username
	 * @return JSON formatted Person object
	 */
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET,  produces = { "application/json" })
	@ResponseBody
	public Person getPerson(@PathVariable String username) {
		
		LOGGER.info("Get Person object for username: " + username);

		return personService.getPerson(username);

	}
        
        
        @RequestMapping(value = "/username/create", method = RequestMethod.POST,  produces = { "application/json" })
	@ResponseBody
        public Person createPerson(@RequestBody Person person) {

            LOGGER.info("Create Person object with this data: " + person);
            
            return personService.createPerson( person.getFirstName(), person.getLastName(), person.getUserName());
            
        }
}
