/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ku.it.si.springwebservice.controller;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import com.jayway.jsonpath.InvalidPathException;
import edu.ku.it.si.springwebservice.model.Person;

/**
 *
 * @author bphillips
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext_Test.xml" })
public class PersonControllerTest {
    
    
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    
    @Test
    public void getPersonTest() throws Exception {
        
        mockMvc.perform(get("/person/username/bphillips").accept(MediaType.parseMediaType("application/json")))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json"))
          .andExpect(jsonPath("$.lastName", is("Phillips") ) );
        
 
    }
    
    
    @Test
    public void createPersonTest() throws Exception {
        

        
        mockMvc.perform(post("/person/username/create").contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"Tom\", \"lastName\":\"Jackson\",\"userName\":\"tjackson\"}".getBytes())).
                andExpect(status().isOk()).andExpect(jsonPath("$.lastName", is("Jackson") ) );
                
        
 
    }
    
    
    
    
}
