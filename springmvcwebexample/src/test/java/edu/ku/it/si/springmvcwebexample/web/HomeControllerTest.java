package edu.ku.it.si.springmvcwebexample.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.ku.it.si.springmvcwebexample.model.Person;
import edu.ku.it.si.springmvcwebexample.service.PersonService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;


public class HomeControllerTest {

	
	@Test
	  public void testHomePage() throws Exception {
		
		Person p1 = new Person();
		p1.setFirstName("Bruce");
		p1.setLastName("Phillips");
		
		Person p2 = new Person();
		p2.setFirstName("Jane");
		p2.setLastName("Doe");
		
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(p1);
		people.add(p2);
		
		PersonService personService = mock(PersonService.class);
		
		when(personService.getPeople()).thenReturn(people);
		
	    HomeController controller = new HomeController();
	    controller.setPersonService(personService);
	    
	    MockMvc mockMvc =
	        MockMvcBuilders.standaloneSetup(controller).build();
	    
	    mockMvc.perform(get("/"))
	           .andExpect(view().name("home"))
	           .andExpect(model().attributeExists("people"));
	    
	}

}
