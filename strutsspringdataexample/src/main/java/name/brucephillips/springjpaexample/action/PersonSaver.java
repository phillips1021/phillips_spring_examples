/**
 * 
 */
package name.brucephillips.springjpaexample.action;

import name.brucephillips.springjpaexample.model.Person;
import name.brucephillips.springjpaexample.service.PersonService;

import com.opensymphony.xwork2.ActionSupport;


/**
 * Acts as the controller for handling user
 * requests to save a Person object.
 * @author brucephillips
 *
 */
public class PersonSaver extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private  transient PersonService personService;
	
	private Person person ;

	
	
   /**
    * Save the state of the Person object.
    * 
    */
	public String execute() throws Exception {

		
		personService.save(person); 
		
		return SUCCESS;
	}
	
	public void validate() {
		
		
		if ( person.getFirst_name().length() == 0 ){	

			addFieldError( "person.first_name", "First name is required." );
			
		}
		
				
		if ( person.getLast_name().length() == 0 ){	

			addFieldError( "person.last_name", "Last name is required." );
			
		}
		
		
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	

}
