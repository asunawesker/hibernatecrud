
package org.uv.hibernatecrud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Irais AV
 */
public class HibernateUtils {
    // HIBERNATE 5    
    // When a method is defined as synchronized then only one thread can be executing it at a time.
    public static SessionFactory factory;

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory;
    }     
    
}
