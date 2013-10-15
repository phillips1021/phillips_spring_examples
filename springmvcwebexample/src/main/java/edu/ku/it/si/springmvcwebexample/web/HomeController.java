package edu.ku.it.si.springmvcwebexample.web;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	  public String home() {
		
	    return "home";
	    
	  }

}
