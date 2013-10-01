package edu.ku.it.si.springwebserviceclient.app;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;


import edu.ku.it.si.springwebserviceclient.model.Person;

/**
 * Call REST web service to get a Person object.
 *
 */
public final class App {
	
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());


  
  private ApplicationContext ctx = new ClassPathXmlApplicationContext( "applicationContext.xml" );

    public static void main( String[] args )
    {
        
    	
    	App app = new App();
    	
    	app.run();
    	
    	
    	
    	
    }
	private void run() {
		
		/*
		 * For more information on Spring's RestTemplate class see: 
		 * http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/remoting.html#rest-client-access
		 * and http://docs.spring.io/spring/docs/3.2.x/javadoc-api/org/springframework/web/client/RestTemplate.html
		 */
		RestTemplate restTemplate = (RestTemplate) ctx.getBean("restTemplate");
		
		String url = "http://localhost:8080/springwebservice/person/username/{username}";
		
		/*
		 * url is the URL for the REST web service
		 * Person.class is what class to transform the response into
		 * bphillips is the value to provide for username in the web service call
		 */
		Person person = restTemplate.getForObject(url, Person.class, "bphillips");
		
		LOGGER.info("Person returned is " + person);
		
	}
	
	private App() {
		
	}
}
