package main.java.app.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConfig {
	private static SessionFactory sessionFactory = null;  
    
    public static SessionFactory configureSessionFactory() throws HibernateException {
    	if (null != sessionFactory)
    		return sessionFactory;
    	
        Configuration configuration = new Configuration(); 
        configuration.addResource("hibernate.cfg.xml").configure();  
         
        Properties properties = configuration.getProperties();
      
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        return sessionFactory;
    }

}
