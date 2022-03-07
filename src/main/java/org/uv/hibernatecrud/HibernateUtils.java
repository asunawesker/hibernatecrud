
package org.uv.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Irais AV
 */
public class HibernateUtils {
    // HIBERNATE 5    
    private SessionFactory sessionFactory;
    public static HibernateUtils hibernateUtils;
    private Session session;

    private HibernateUtils() {}

    private synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static HibernateUtils getInstance(){
        if (hibernateUtils == null) 
            hibernateUtils = new HibernateUtils();                   
        return hibernateUtils;
    }
    
    private Session openSession(){
        session = getSessionFactory().openSession();
        return session;
    }
    
    private void closeSession(){
        session.close();
    }  
    
    public boolean execute(TransactionDb transaction) {
        boolean response = transaction.execute(openSession());
        closeSession();
        return response;
    }
}
