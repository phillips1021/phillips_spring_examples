package edu.ku.it.si.springjdbcexamples.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


import edu.ku.it.si.springjdbcexamples.model.Person;

/**
 * Defines behaviors for getting Person information out of the relational
 * database
 * 
 * @author brucephillips
 * 
 */
public class PersonDaoImplDB extends SimpleJdbcDaoSupport implements PersonDao {
	
	


	@Override
	public void doDBCleanUp() {

		 this.getJdbcTemplate().update(
		        "delete from personTbl where personId > ?",
		        new Object[] {new Integer(0) });

	}

	

	@Override
	public List<Person> getPerson(Person personSkeleton) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(personSkeleton);

		List<Person> people = namedParameterJdbcTemplate.query(
			    "select personID, personFirstName, personLastName from personTbl " + 
			    " where personLastName = :personLastName and personFirstName = :personFirstName",
			    
			    namedParameters,
			    
				new PersonMapper() );
		
		return people;
		
	}

	

	@Override
	public void addPerson(Person newPerson) {

		SimpleJdbcInsert insertPerson = 
			new SimpleJdbcInsert(this.getDataSource())
		     .withTableName("personTbl").usingGeneratedKeyColumns("personID");


        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("personFirstName", newPerson.getPersonFirstName() );
        parameters.put("personLastName", newPerson.getPersonLastName() );
        insertPerson.execute(parameters);


	}

	@Override
	public List<Person> getAllPersons() {
		
		String sql = "select personId, personFirstName, personLastName from personTbl";

	    List <Person> people = this.getSimpleJdbcTemplate().query(sql, new PersonMapper());
	    
	    return people;
	
	}
	


	@Override
	public int saveAllPersonsMap(List<Person> people) {

        //using the provided collection
		//create an array of SqlParameterSource objects
		
		SqlParameterSource namedParametersArray []  = new MapSqlParameterSource[ people.size() ] ;
		
		int i = 0;
		
		for (Person person : people) {
			
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource() ;
			mapSqlParameterSource.addValue("personFirstName", person.getPersonFirstName());
			mapSqlParameterSource.addValue("personLastName", person.getPersonLastName() );
			
			namedParametersArray[i] = mapSqlParameterSource ;
			
			i++;

		}
		
		
		SimpleJdbcInsert insertPeople = 
			new SimpleJdbcInsert(this.getDataSource())
		     .withTableName("personTbl").usingGeneratedKeyColumns("personID");
		
		int [] recordsInserted = insertPeople.executeBatch(namedParametersArray);
		
		
		return recordsInserted.length ;
		

	}
	
	
	public int saveAllPersonsBean(List<Person> people) {
		
		//using the provided collection
		//create an array of SqlParameterSource objects
		
		SqlParameterSource namedParametersArray []  = new BeanPropertySqlParameterSource[ people.size() ] ;
		
		int i = 0;
		
		for (Person person : people ) {
			
			BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(person);
			
			namedParametersArray[i] = beanPropertySqlParameterSource;
			
			i++;
			
		}
		
		//specify which columns to insert since the personId column
		//value is auto generated by the database
		SimpleJdbcInsert insertPeople = 
			new SimpleJdbcInsert(this.getDataSource())
		     .withTableName("personTbl").usingColumns("personFirstName", "personLastName").usingGeneratedKeyColumns("personId");
		
		int [] recordsInserted = insertPeople.executeBatch(namedParametersArray);
		
		
		return recordsInserted.length ;
		
	}
	
	
	
	/**
	 * A static inner class to encapsulate the creation of a Person
	 * object for each row of the ResultSet
	 * @author brucephillips
	 *
	 */
	private static final class PersonMapper implements RowMapper<Person> {

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
       	 Person person = new Person();
	         person.setPersonFirstName(rs.getString("personFirstName"));
	         person.setPersonLastName(rs.getString("personLastName"));
	         person.setPersonID(rs.getInt("personId"));
	         return person;
       }
	}
	
	

}