package edu.ku.it.si.springjpaexample.web;

import edu.ku.it.si.springjpaexample.model.Gender;
import edu.ku.it.si.springjpaexample.model.Person;
import edu.ku.it.si.springjpaexample.service.PersonService;
import edu.ku.it.si.springjpaexample.web.HomeController;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class HomeControllerTest {

	
	@Test
	  public void testHomePage() throws Exception {
		
		Person p1 = new Person();
		p1.setFirstName("Bruce");
		p1.setLastName("Phillips");
                p1.setGender(Gender.MALE);
                p1.setEmplid(1L);
		
		Person p2 = new Person();
		p2.setFirstName("Jane");
		p2.setLastName("Doe");
                p2.setGender(Gender.FEMALE);
                p2.setEmplid(2L);
		
		
		List<Person> people = new ArrayList<>();
		
		people.add(p1);
		people.add(p2);
		
		PersonService personService = mock(PersonService.class);
		
		when(personService.findAllEmployees()).thenReturn(people);
		
	    HomeController controller = new HomeController();
	    controller.setPersonService(personService);
	    
	    MockMvc mockMvc =
	        MockMvcBuilders.standaloneSetup(controller).build();
	    
	    mockMvc.perform(get("/"))
	           .andExpect(view().name("home"))
	           .andExpect(model().attributeExists("people"));
	    
	}

}
