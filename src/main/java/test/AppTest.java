package main.java.test;

import java.util.List;

import main.java.app.config.HibernateConfig;
import main.java.app.service.impl.UserService;
import main.model.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserService.class })
public class AppTest extends TestCase
{
	private SessionFactory sessionFactory = null;
	
	public void setUp() {
		sessionFactory = HibernateConfig.configureSessionFactory();
	}
			
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
	@Autowired
	private UserService userService;

    public void testHibernatePut()
    {    	
    	userService.createUser(new User("Farkas", "Andras", false));
//        Session sess = null;
//        
//        try {
//	        sess = sessionFactory.openSession();
//	        sess.beginTransaction();
//	        
//	        User p1 = new User("Radu", "Popescu", false);
//	        User p2 = new User("Vasile", "Ionescu", true);
//	        
//	        sess.save(p1);
//	        sess.save(p2);
//	        
//	        sess.flush();
//	        sess.getTransaction().commit();	 
//	        
//	        List<User> persList = sess.createQuery("from User").list();
//	        assertTrue(persList.size() > 0);
//	        
//	        persList = sess.createQuery("from User where id=1").list();
//	        assertTrue(persList.size() == 1);	        
//        } catch (HibernateException he) {
//        	he.printStackTrace();
//        	
//        	sess.getTransaction().rollback();
//        } finally {
//        	sess.close();
//        }        
//        
//        assertTrue(true);
    }
    	    
//    public void testHibernateDelete()
//    {
//        Session sess = null;
//        
//        try {
//	        sess = sessionFactory.openSession();
//	        sess.beginTransaction();
//	        
//	        int deletedEntries = sess.createQuery("delete Person").executeUpdate();
//	        assertTrue(deletedEntries > 0);
//	        
//	        sess.flush();
//	        sess.getTransaction().commit();
//        } catch (HibernateException he) {
//        	he.printStackTrace();        
//        } finally {
//        	sess.close();
//        }
//        
//        assertTrue(true);
//    }
    
}
