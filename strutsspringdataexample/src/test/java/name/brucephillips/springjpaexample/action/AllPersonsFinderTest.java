package name.brucephillips.springjpaexample.action;


import name.brucephillips.springjpaexample.action.AllPersonsFinder;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;
import com.opensymphony.xwork2.ActionProxy;


public class AllPersonsFinderTest extends StrutsSpringTestCase {
	
	@Override
	public String [] getContextLocations() {
		
		return new String [] {"applicationContextTest.xml"};
		
	}

	@Test
	public void testExecute() throws Exception {
		
		
		ActionProxy proxy = getActionProxy("allPersonsFinder");
		
		AllPersonsFinder action = (AllPersonsFinder) proxy.getAction() ;
		
		assertNotNull(action);
		
		String result = proxy.execute() ;
		
		assertEquals("Result of calling execute method is not success but it should be.", "success", result);
		
		
	}

}
