package edu.ku.it.si.springmvcwebexample.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {

	
	@Test
	  public void testHomePage() throws Exception {
		
	    HomeController controller = new HomeController();
	    
	    MockMvc mockMvc =
	        MockMvcBuilders.standaloneSetup(controller).build();
	    
	    mockMvc.perform(get("/"))
	           .andExpect(view().name("home"));
	}

}
