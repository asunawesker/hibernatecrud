
package org.uv.hibernatecrud;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

/**
 *
 * @author Irais AV
 */
public class DaoDepartment implements IDao<Department>{
    
    HibernateUtils session;

    public DaoDepartment() {
        session = HibernateUtils.getInstance(); 
    }        

    @Override
    public void save(Department department) {  
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.save(new Department(department.getName()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };    
        
        session.execute(t);          
    }

    @Override
    public List<Department> read() {
        List<Department> lstDepartment = new ArrayList<>();
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    Query query = (Query) session.createQuery("FROM Department");
                    for (Object department : query.list()) {
                        lstDepartment.add((Department) department);                        
                    }
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };    
        
        session.execute(t);   
        
        return lstDepartment;
    }
    
    @Override
    public List<Department> readById(Department department){
        List<Department> lstDepartment = new ArrayList<>();
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    Query query = session.createQuery("FROM Department WHERE id=:id");
                    query.setLong("id", department.getId());
                    for (Object department : query.list()) {
                        lstDepartment.add((Department) department);                        
                    }
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };    
        
        session.execute(t);     
        
        return lstDepartment;
    }

    @Override
    public void delete(Department department) {
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.delete(new Department(department.getId()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        }; 
        
        session.execute(t);              
    }

    @Override
    public void updated(Department department) {
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.update(new Department(department.getId(), department.getName()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };       
        
        session.execute(t);  
    }

}
