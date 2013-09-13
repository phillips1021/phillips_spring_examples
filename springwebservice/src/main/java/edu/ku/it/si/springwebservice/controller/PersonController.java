package edu.ku.it.si.springwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ku.it.si.springwebservice.model.Person;
import edu.ku.it.si.springwebservice.service.PersonService;

/**
 * Controller class that handles requests for Person data.
 * 
 * @author bphillips
 * 
 */
@Controller
@RequestMapping("/controller")
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * Get the Person associated with the provide userName.
	 * 
	 * @param username
	 * @return JSON formatted Person object
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public Person getPerson(@PathVariable String username) {

		return personService.getPerson(username);

	}

}
