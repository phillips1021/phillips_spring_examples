package edu.ku.it.si.springmvcwebexample.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Configure the Servlet Container so that it will know
 * how to respond to requests for this web application.
 * @author bphillips
 *
 */
public class WebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	  protected String[] getServletMappings() {
	    return new String[] { "/" };
	  }
	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class<?>[] { RootConfig.class };
	  }
	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	    return new Class<?>[] { WebConfig.class };
	  }

}
