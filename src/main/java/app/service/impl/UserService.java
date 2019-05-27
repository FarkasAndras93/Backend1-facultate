package main.java.app.service.impl;

import java.util.List;

import main.java.app.config.HibernateConfig;
import main.model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 * User service class.
 */
@Service
public class UserService
{
	private SessionFactory sessionFactory = HibernateConfig.configureSessionFactory();

	/**
	 * Create user method
	 * @param user
	 */
    public void createUser(User user)
    {    	
        Session sess = null;
        
        try {
	        sess = sessionFactory.openSession();
	        sess.beginTransaction();
	        
	        sess.save(user);
	        
	        sess.flush();
	        sess.getTransaction().commit();	 
	        	        
        } catch (HibernateException he) {
        	he.printStackTrace();
        	
        	sess.getTransaction().rollback();
        } finally {
        	sess.close();
        }        

    }
    
    /**
     * Method to get all users from database.
     */
    public User login(String username, String password) {
    	
    	Session sess = null;
        
        try {
	        sess = sessionFactory.openSession();
	        sess.beginTransaction();
	        
	        List<User> userList = sess.createQuery("from User u where u.username='" + username + "' and u.password='" + password + "'").list();
	        	      
	        return userList.get(0);
        } catch (HibernateException he) {
        	he.printStackTrace();
        	
        	sess.getTransaction().rollback();
        } finally {
        	sess.close();
        } 
    	
        return null;
    }
    
    /**
     * Method to get all users from database.
     */
    public List<User> getAllUsers() {
    	
    	Session sess = null;
        
        try {
	        sess = sessionFactory.openSession();
	        sess.beginTransaction();
	        
	        List<User> userList = sess.createQuery("from User").list();
	        	      
	        return userList;
        } catch (HibernateException he) {
        	he.printStackTrace();
        	
        	sess.getTransaction().rollback();
        } finally {
        	sess.close();
        } 
    	
        return null;
    }
    
}
