package name.brucephillips.springcacheexample.dao;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonDaoTest {
	
	@Autowired
	PersonDao personDao ;

	/**
	 * Calls the getPerson method 
	 * numerous times to confirm that the 
	 * @cacheable annotation on the method
	 * means the getPerson method actually
	 * only gets executed once.
	 */
	@Test
	public void testGetPerson() {
		
		/*
		 * Even though the getPerson method 
		 * is called 20 times in this loop
		 * it should only execute the first
		 * time.  After that the value returned
		 * is the cached Person object.
		 */
		for (int i = 1; i < 21; i++) {
			
			personDao.getPerson(123L);
			
		}
				
		assertEquals("Execute count for method getPerson is not 1 but should be.", 1, personDao.getPersonExecuteCount() );
		
		
		/*
		 * Load new/change Person records
		 * Cache should be emptied
		 */
		personDao.loadPeople() ;
		
		
		/*
		 * Call getPerson another 20 times
		 * but the method should only execute once.
		 */
		for (int i = 1; i < 21; i++) {
			
			personDao.getPerson(123L);
			
		}
		
		assertEquals("Execute count for method getPerson is not 2 but should be.", 2, personDao.getPersonExecuteCount() );
		
	}

}
