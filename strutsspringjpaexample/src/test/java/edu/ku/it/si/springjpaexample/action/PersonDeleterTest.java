package edu.ku.it.si.springjpaexample.action;

import org.apache.struts2.StrutsSpringTestCase;

import com.opensymphony.xwork2.ActionProxy;





public class PersonDeleterTest extends StrutsSpringTestCase {
	
	@Override
	public String getContextLocations() {
		
		return "applicationContextTest.xml";
		
	}
	

	
	
	
	public void testExecute() throws Exception {
		
		request.setParameter("emplid", "3");
			
		ActionProxy proxy = getActionProxy("personDelete");
		
		PersonDeleter action = (PersonDeleter) proxy.getAction();
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		
	}

}
