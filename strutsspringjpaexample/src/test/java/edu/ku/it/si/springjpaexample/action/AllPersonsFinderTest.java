package edu.ku.it.si.springjpaexample.action;

import java.util.List;



import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

import com.opensymphony.xwork2.ActionProxy;

import edu.ku.it.si.springjpaexample.model.Person;

public class AllPersonsFinderTest extends StrutsSpringTestCase {
	
	@Override
	public String getContextLocations() {
		
		return "applicationContextTest.xml";
		
	}

	@Test
	public void testExecute() throws Exception {
		
		
		ActionProxy proxy = getActionProxy("allPersonsFinder");
		
		AllPersonsFinder action = (AllPersonsFinder) proxy.getAction() ;
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		List<Person> persons = action.getPersons() ;
		
		assertEquals("The number of employees found is not 3 but should be.", 3, persons.size() );
		
		
		
		
	}

}
