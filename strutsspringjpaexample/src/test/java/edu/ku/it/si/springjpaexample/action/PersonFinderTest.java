package edu.ku.it.si.springjpaexample.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.opensymphony.xwork2.ActionProxy;

import edu.ku.it.si.springjpaexample.action.PersonFinder;
import edu.ku.it.si.springjpaexample.model.Person;



public class PersonFinderTest extends StrutsSpringTestCase {
	
	@Override
	public String getContextLocations() {
		
		return "applicationContextTest.xml";
		
	}
	

	public void testExecute() throws Exception {
		
		request.setParameter("emplid", "1");
		
		ActionProxy proxy = getActionProxy("personFinder");
		
		PersonFinder action = (PersonFinder) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		Person person = action.getPerson() ;
		
		assertEquals("Person's first name is not Bruce but should be.", "Bruce", person.getFirst_name() );
		
		
		
	}

}
