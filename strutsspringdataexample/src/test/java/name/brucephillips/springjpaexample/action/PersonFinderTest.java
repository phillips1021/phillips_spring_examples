package name.brucephillips.springjpaexample.action;

import name.brucephillips.springjpaexample.action.PersonFinder;
import name.brucephillips.springjpaexample.model.Person;

import org.apache.struts2.StrutsSpringTestCase;

import com.opensymphony.xwork2.ActionProxy;




public class PersonFinderTest extends StrutsSpringTestCase {
	
	@Override
	public String [] getContextLocations() {
		
		return new String [] {"applicationContextTest.xml"};
		
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
