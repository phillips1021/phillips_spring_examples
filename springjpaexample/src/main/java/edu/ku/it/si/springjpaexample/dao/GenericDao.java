/**
 * 
 */
package edu.ku.it.si.springjpaexample.dao;

/**
 * Specifies methods all Data Access Objects
 * must implement.
 * See:  http://insidecoding.wordpress.com/2011/09/07/the-generic-dao-pattern-in-java-with-spring-3-and-jpa-2-0/
 * @author bphillips
 *
 */
public interface GenericDao<T> {
	
	
	T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);

}
