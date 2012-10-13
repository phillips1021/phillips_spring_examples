package edu.ku.it.si.springjpaexample.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.opensymphony.xwork2.ActionProxy;

import edu.ku.it.si.springjpaexample.model.Person;



public class PersonUpdaterTest extends StrutsSpringTestCase {
	
	@Override
	public String getContextLocations() {
		
		return "applicationContextTest.xml";
		
	}
	

	public void testInput() throws Exception {
		
		request.setParameter("emplid", "2");
		
		ActionProxy proxy = getActionProxy("inputPersonUpdate");
		
		PersonUpdater action = (PersonUpdater) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling input method is not input but it should be.", "input", result);
		
		Person person = action.getPerson() ;
		
		assertEquals("Person's last name is not Cole but should be.", "Cole", person.getLast_name() );

	}
	
	
	public void testExecute() throws Exception {
		
		request.setParameter("person.emplid", "2");
		request.setParameter("person.first_name", "Kate");
		request.setParameter("person.last_name", "Cole");
		
		ActionProxy proxy = getActionProxy("executePersonUpdate");
		
		PersonUpdater action = (PersonUpdater) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		Person person = action.getPerson() ;
		
		assertEquals("Person's first name is not Kate but should be.", "Kate", person.getFirst_name() );

		
	}

}
