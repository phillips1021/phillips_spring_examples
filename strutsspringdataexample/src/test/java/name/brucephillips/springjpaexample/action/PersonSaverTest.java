package name.brucephillips.springjpaexample.action;

import name.brucephillips.springjpaexample.action.PersonSaver;
import name.brucephillips.springjpaexample.model.Person;

import org.apache.struts2.StrutsSpringTestCase;

import com.opensymphony.xwork2.ActionProxy;




public class PersonSaverTest extends StrutsSpringTestCase {
	
	@Override
	public String [] getContextLocations() {
		
		return new String [] {"applicationContextTest.xml"};
		
	}
	

	public void testInput() throws Exception {
		
		
		
		ActionProxy proxy = getActionProxy("inputPersonSave");
		
		PersonSaver action = (PersonSaver) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling input method is not input but it should be.", "input", result);
		
	
	}
	
	
	public void testExecute() throws Exception {
		
		
		request.setParameter("person.first_name", "George");
		request.setParameter("person.last_name", "Hosler");
		
		ActionProxy proxy = getActionProxy("executePersonSave");
		
		PersonSaver action = (PersonSaver) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		Person person = action.getPerson() ;
		
		assertEquals("Person's first name is not George but should be.", "George", person.getFirst_name() );
		
		

		
	}

}
