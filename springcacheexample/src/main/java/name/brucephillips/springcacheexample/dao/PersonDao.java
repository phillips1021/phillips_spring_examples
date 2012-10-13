package name.brucephillips.springcacheexample.dao;

import name.brucephillips.springcacheexample.model.Person;

/**
 * Specifies behaviors required to interact
 * with a Person data repository.
 * @author bphillips
 *
 */
public interface PersonDao {
	
	/**
	 * Using the provided personId return
	 * the associated Person from the data
	 * repository.
	 * @param personId
	 * @return Person object having the associated personId or
	 * null if no associated Person is found with the provided
	 * personId
	 */
	Person getPerson(Long personId);
	
	/**
	 * Get the number of times method getPerson is 
	 * executed.  This is just for test purposes.
	 * @return number of times method getPerson was executed
	 * by any PersonDao object.
	 */
	int getPersonExecuteCount();
	
	/**
	 * Updates the Person data repository
	 * with new/changed Person records.
	 */
	void loadPeople();
	
	

}
