/**
 * 
 */
package edu.ku.it.si.springjpaexample.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * An abstract implementation of the methods specified
 * by the GenericDao interface - concrete DAO classes
 * will extend this abstract to avoid code duplication.
 * See: http://insidecoding.wordpress.com/2011/09/07/the-generic-dao-pattern-in-java-with-spring-3-and-jpa-2-0/
 * @author bphillips
 *
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	
    private EntityManager em;

 
	private Class<T> type;

    /**
     * Default constructor that gets the actual
     * parametrized type of the concrete class
     * and stores it in the Class<T> type 
     * instance field for use by the EntityManager.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
    	
        Type t = getClass().getGenericSuperclass();
        
        ParameterizedType pt = (ParameterizedType) t;
        
        type = (Class) pt.getActualTypeArguments()[0];
        
    }

	
    @Override
    public T create(final T t) {
    	
        this.em.persist(t);
        return t;
        
    }

    @Override
    public void delete(final Object id) {
    	
        this.em.remove(this.em.getReference(type, id));
        
    }

    @Override
    public T find(final Object id) {
    	
        return (T) this.em.find(type, id);
        
    }

    @Override
    public T update(final T t) {
    	
        return this.em.merge(t);   
        
    }
    
    public EntityManager getEm() {
		return em;
	}

    @PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
