package edu.ku.it.si.springjpaexample.web;

import edu.ku.it.si.springjpaexample.model.Person;
import edu.ku.it.si.springjpaexample.service.PersonService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
/**
 * Class that responds to http requests
 * to the web root of this application.
 * @author bphillips
 *
 */
public class HomeController {
	
	
	private PersonService personService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	  public String home(Model model) {
		
		List<Person> people = personService.findAllEmployees();
		
		model.addAttribute("people", people);
		
	    return "home";
	    
	  }

	/**
	 * @param personService the personService to set
	 */
	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	

}
